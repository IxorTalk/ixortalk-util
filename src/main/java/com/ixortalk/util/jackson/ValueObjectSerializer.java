/**
 *
 *  2016 (c) IxorTalk CVBA
 *  All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of IxorTalk CVBA
 *
 * The intellectual and technical concepts contained
 * herein are proprietary to IxorTalk CVBA
 * and may be covered by U.S. and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 *
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from IxorTalk CVBA.
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.
 */
package com.ixortalk.util.jackson;

import java.io.IOException;
import java.util.function.Function;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class ValueObjectSerializer<T> extends StdSerializer<T> {

    private final Function<T, String> valueExtractor;

    public ValueObjectSerializer(Class<T> vc, Function<T, String> valueExtractor) {
        super(vc);
        this.valueExtractor = valueExtractor;
    }

    @Override
    public void serialize(T value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeString(valueExtractor.apply(value));
    }

}
