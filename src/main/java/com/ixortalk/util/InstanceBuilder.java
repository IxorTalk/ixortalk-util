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
package com.ixortalk.util;

public abstract class InstanceBuilder<T> {

    private T instance;
    private boolean hasBeenBuilt;

    public InstanceBuilder() {
        instance = createInstance();
    }

    protected abstract T createInstance();

    protected final T instance() {
        return instance;
    }

    public T build() {
        if (hasBeenBuilt) {
            throw new IllegalStateException("Builders can build only once");
        }
        hasBeenBuilt = true;
        return instance;
    }
}
