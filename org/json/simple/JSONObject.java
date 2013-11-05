package org.json.simple;

import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class JSONObject extends HashMap implements Map, a, b {
    private static final long serialVersionUID = -503443796854799292L;

    public JSONObject() {
    }

    public JSONObject(Map map) {
        super(map);
    }

    public static void writeJSONString(Map map, Writer writer) {
        boolean z;
        if (map == null) {
            writer.write("null");
            return;
        }
        boolean z2 = true;
        writer.write(SocialAPIErrorCodes.ERROR_INVALID_BDUSS);
        for (Map.Entry entry : map.entrySet()) {
            if (z2) {
                z = false;
            } else {
                writer.write(44);
                z = z2;
            }
            writer.write(34);
            writer.write(escape(String.valueOf(entry.getKey())));
            writer.write(34);
            writer.write(58);
            c.a(entry.getValue(), writer);
            z2 = z;
        }
        writer.write(SocialAPIErrorCodes.ERROR_INVALID_UPLOAD_FILE);
    }

    @Override // org.json.simple.b
    public void writeJSONString(Writer writer) {
        writeJSONString(this, writer);
    }

    public static String toJSONString(Map map) {
        boolean z;
        if (map == null) {
            return "null";
        }
        StringBuffer stringBuffer = new StringBuffer();
        boolean z2 = true;
        stringBuffer.append('{');
        for (Map.Entry entry : map.entrySet()) {
            if (z2) {
                z = false;
            } else {
                stringBuffer.append(',');
                z = z2;
            }
            a(String.valueOf(entry.getKey()), entry.getValue(), stringBuffer);
            z2 = z;
        }
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    @Override // org.json.simple.a
    public String toJSONString() {
        return toJSONString(this);
    }

    private static String a(String str, Object obj, StringBuffer stringBuffer) {
        stringBuffer.append('\"');
        if (str == null) {
            stringBuffer.append("null");
        } else {
            c.a(str, stringBuffer);
        }
        stringBuffer.append('\"').append(':');
        stringBuffer.append(c.a(obj));
        return stringBuffer.toString();
    }

    @Override // java.util.AbstractMap
    public String toString() {
        return toJSONString();
    }

    public static String toString(String str, Object obj) {
        StringBuffer stringBuffer = new StringBuffer();
        a(str, obj, stringBuffer);
        return stringBuffer.toString();
    }

    public static String escape(String str) {
        return c.a(str);
    }
}
