package org.webrtc;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes8.dex */
public class MediaConstraints {
    public final List<KeyValuePair> mandatory = new ArrayList();
    public final List<KeyValuePair> optional = new ArrayList();

    /* loaded from: classes8.dex */
    public static class KeyValuePair {
        public final String key;
        public final String value;

        public KeyValuePair(String str, String str2) {
            this.key = str;
            this.value = str2;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || KeyValuePair.class != obj.getClass()) {
                return false;
            }
            KeyValuePair keyValuePair = (KeyValuePair) obj;
            return this.key.equals(keyValuePair.key) && this.value.equals(keyValuePair.value);
        }

        @CalledByNative("KeyValuePair")
        public String getKey() {
            return this.key;
        }

        @CalledByNative("KeyValuePair")
        public String getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.key.hashCode() + this.value.hashCode();
        }

        public String toString() {
            return this.key + ": " + this.value;
        }
    }

    public static String stringifyKeyValuePairList(List<KeyValuePair> list) {
        StringBuilder sb = new StringBuilder(PreferencesUtil.LEFT_MOUNT);
        for (KeyValuePair keyValuePair : list) {
            if (sb.length() > 1) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append(keyValuePair.toString());
        }
        sb.append(PreferencesUtil.RIGHT_MOUNT);
        return sb.toString();
    }

    @CalledByNative
    public List<KeyValuePair> getMandatory() {
        return this.mandatory;
    }

    @CalledByNative
    public List<KeyValuePair> getOptional() {
        return this.optional;
    }

    public String toString() {
        return "mandatory: " + stringifyKeyValuePairList(this.mandatory) + ", optional: " + stringifyKeyValuePairList(this.optional);
    }
}
