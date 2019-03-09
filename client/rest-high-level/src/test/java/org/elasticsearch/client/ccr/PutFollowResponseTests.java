/*
 * Licensed to Elasticsearch under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.client.ccr;

import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.test.ESTestCase;

import java.io.IOException;

import static org.elasticsearch.test.AbstractXContentTestCase.xContentTester;

public class PutFollowResponseTests extends ESTestCase {

    public void testFromXContent() throws IOException {
        xContentTester(this::createParser,
            this::createTestInstance,
            PutFollowResponseTests::toXContent,
            PutFollowResponse::fromXContent)
            .supportsUnknownFields(true)
            .test();
    }

    private PutFollowResponse createTestInstance() {
        return new PutFollowResponse(randomBoolean(), randomBoolean(), randomBoolean());
    }

    public static void toXContent(PutFollowResponse response, XContentBuilder builder) throws IOException {
        builder.startObject();
        {
            builder.field(PutFollowResponse.FOLLOW_INDEX_CREATED.getPreferredName(), response.isFollowIndexCreated());
            builder.field(PutFollowResponse.FOLLOW_INDEX_SHARDS_ACKED.getPreferredName(), response.isFollowIndexShardsAcked());
            builder.field(PutFollowResponse.INDEX_FOLLOWING_STARTED.getPreferredName(), response.isIndexFollowingStarted());
        }
        builder.endObject();
    }
}
