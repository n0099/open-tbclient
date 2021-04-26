package org.webrtc;

import com.baidu.android.common.others.lang.StringUtil;
import java.util.Map;
import kotlin.text.Typography;
/* loaded from: classes7.dex */
public class RTCStats {
    public final String id;
    public final Map<String, Object> members;
    public final long timestampUs;
    public final String type;

    public RTCStats(long j, String str, String str2, Map<String, Object> map) {
        this.timestampUs = j;
        this.type = str;
        this.id = str2;
        this.members = map;
    }

    public static void appendValue(StringBuilder sb, Object obj) {
        if (!(obj instanceof Object[])) {
            if (!(obj instanceof String)) {
                sb.append(obj);
                return;
            }
            sb.append(Typography.quote);
            sb.append(obj);
            sb.append(Typography.quote);
            return;
        }
        Object[] objArr = (Object[]) obj;
        sb.append('[');
        for (int i2 = 0; i2 < objArr.length; i2++) {
            if (i2 != 0) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            appendValue(sb, objArr[i2]);
        }
        sb.append(']');
    }

    @CalledByNative
    public static RTCStats create(long j, String str, String str2, Map map) {
        return new RTCStats(j, str, str2, map);
    }

    public String getId() {
        return this.id;
    }

    public Map<String, Object> getMembers() {
        return this.members;
    }

    public double getTimestampUs() {
        return this.timestampUs;
    }

    public String getType() {
        return this.type;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{ timestampUs: ");
        sb.append(this.timestampUs);
        sb.append(", type: ");
        sb.append(this.type);
        sb.append(", id: ");
        sb.append(this.id);
        for (Map.Entry<String, Object> entry : this.members.entrySet()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(entry.getKey());
            sb.append(": ");
            appendValue(sb, entry.getValue());
        }
        sb.append(" }");
        return sb.toString();
    }
}
