package org.json.simple;

import java.io.Writer;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public static void a(Object obj, Writer writer) {
        if (obj == null) {
            writer.write("null");
        } else if (obj instanceof String) {
            writer.write(34);
            writer.write(a((String) obj));
            writer.write(34);
        } else if (obj instanceof Double) {
            if (((Double) obj).isInfinite() || ((Double) obj).isNaN()) {
                writer.write("null");
            } else {
                writer.write(obj.toString());
            }
        } else if (obj instanceof Float) {
            if (((Float) obj).isInfinite() || ((Float) obj).isNaN()) {
                writer.write("null");
            } else {
                writer.write(obj.toString());
            }
        } else if (obj instanceof Number) {
            writer.write(obj.toString());
        } else if (obj instanceof Boolean) {
            writer.write(obj.toString());
        } else if (obj instanceof b) {
            ((b) obj).writeJSONString(writer);
        } else if (obj instanceof a) {
            writer.write(((a) obj).toJSONString());
        } else if (obj instanceof Map) {
            JSONObject.writeJSONString((Map) obj, writer);
        } else if (obj instanceof List) {
            JSONArray.writeJSONString((List) obj, writer);
        } else {
            writer.write(obj.toString());
        }
    }

    public static String a(Object obj) {
        if (obj == null) {
            return "null";
        }
        if (obj instanceof String) {
            return new StringBuffer().append("\"").append(a((String) obj)).append("\"").toString();
        }
        if (obj instanceof Double) {
            if (((Double) obj).isInfinite() || ((Double) obj).isNaN()) {
                return "null";
            }
            return obj.toString();
        } else if (obj instanceof Float) {
            if (((Float) obj).isInfinite() || ((Float) obj).isNaN()) {
                return "null";
            }
            return obj.toString();
        } else if (obj instanceof Number) {
            return obj.toString();
        } else {
            if (obj instanceof Boolean) {
                return obj.toString();
            }
            if (obj instanceof a) {
                return ((a) obj).toJSONString();
            }
            if (obj instanceof Map) {
                return JSONObject.toJSONString((Map) obj);
            }
            if (obj instanceof List) {
                return JSONArray.toJSONString((List) obj);
            }
            return obj.toString();
        }
    }

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        a(str, stringBuffer);
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str, StringBuffer stringBuffer) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            switch (charAt) {
                case '\b':
                    stringBuffer.append("\\b");
                    break;
                case '\t':
                    stringBuffer.append("\\t");
                    break;
                case '\n':
                    stringBuffer.append("\\n");
                    break;
                case '\f':
                    stringBuffer.append("\\f");
                    break;
                case '\r':
                    stringBuffer.append("\\r");
                    break;
                case '\"':
                    stringBuffer.append("\\\"");
                    break;
                case '/':
                    stringBuffer.append("\\/");
                    break;
                case '\\':
                    stringBuffer.append("\\\\");
                    break;
                default:
                    if ((charAt >= 0 && charAt <= 31) || ((charAt >= 127 && charAt <= 159) || (charAt >= 8192 && charAt <= 8447))) {
                        String hexString = Integer.toHexString(charAt);
                        stringBuffer.append("\\u");
                        for (int i2 = 0; i2 < 4 - hexString.length(); i2++) {
                            stringBuffer.append('0');
                        }
                        stringBuffer.append(hexString.toUpperCase());
                        break;
                    } else {
                        stringBuffer.append(charAt);
                        break;
                    }
            }
        }
    }
}
