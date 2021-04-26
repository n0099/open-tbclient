package org.webrtc;

import com.baidu.android.common.others.lang.StringUtil;
/* loaded from: classes7.dex */
public class StatsReport {
    public final String id;
    public final double timestamp;
    public final String type;
    public final Value[] values;

    /* loaded from: classes7.dex */
    public static class Value {
        public final String name;
        public final String value;

        @CalledByNative("Value")
        public Value(String str, String str2) {
            this.name = str;
            this.value = str2;
        }

        public String toString() {
            return "[" + this.name + ": " + this.value + "]";
        }
    }

    @CalledByNative
    public StatsReport(String str, String str2, double d2, Value[] valueArr) {
        this.id = str;
        this.type = str2;
        this.timestamp = d2;
        this.values = valueArr;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(this.id);
        sb.append(", type: ");
        sb.append(this.type);
        sb.append(", timestamp: ");
        sb.append(this.timestamp);
        sb.append(", values: ");
        int i2 = 0;
        while (true) {
            Value[] valueArr = this.values;
            if (i2 >= valueArr.length) {
                return sb.toString();
            }
            sb.append(valueArr[i2].toString());
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            i2++;
        }
    }
}
