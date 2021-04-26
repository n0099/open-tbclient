package org.json.alipay;

import com.baidu.android.common.others.lang.StringUtil;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.text.Typography;
/* loaded from: classes7.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f68319a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    public Map f68320b;

    /* loaded from: classes7.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public final Object clone() {
            return this;
        }

        public final boolean equals(Object obj) {
            return obj == null || obj == this;
        }

        public final String toString() {
            return StringUtil.NULL_STRING;
        }
    }

    public b() {
        this.f68320b = new HashMap();
    }

    public b(String str) {
        this(new c(str));
    }

    public b(Map map) {
        this.f68320b = map == null ? new HashMap() : map;
    }

    public b(c cVar) {
        this();
        if (cVar.c() != '{') {
            throw cVar.a("A JSONObject text must begin with '{'");
        }
        while (true) {
            char c2 = cVar.c();
            if (c2 == 0) {
                throw cVar.a("A JSONObject text must end with '}'");
            }
            if (c2 == '}') {
                return;
            }
            cVar.a();
            String obj = cVar.d().toString();
            char c3 = cVar.c();
            if (c3 == '=') {
                if (cVar.b() != '>') {
                    cVar.a();
                }
            } else if (c3 != ':') {
                throw cVar.a("Expected a ':' after a key");
            }
            Object d2 = cVar.d();
            if (obj == null) {
                throw new JSONException("Null key.");
            }
            if (d2 != null) {
                b(d2);
                this.f68320b.put(obj, d2);
            } else {
                this.f68320b.remove(obj);
            }
            char c4 = cVar.c();
            if (c4 != ',' && c4 != ';') {
                if (c4 != '}') {
                    throw cVar.a("Expected a ',' or '}'");
                }
                return;
            } else if (cVar.c() == '}') {
                return;
            } else {
                cVar.a();
            }
        }
    }

    public static String a(Object obj) {
        if (obj == null || obj.equals(null)) {
            return StringUtil.NULL_STRING;
        }
        if (!(obj instanceof Number)) {
            return ((obj instanceof Boolean) || (obj instanceof b) || (obj instanceof org.json.alipay.a)) ? obj.toString() : obj instanceof Map ? new b((Map) obj).toString() : obj instanceof Collection ? new org.json.alipay.a((Collection) obj).toString() : obj.getClass().isArray() ? new org.json.alipay.a(obj).toString() : c(obj.toString());
        }
        Number number = (Number) obj;
        if (number != null) {
            b(number);
            String obj2 = number.toString();
            if (obj2.indexOf(46) <= 0 || obj2.indexOf(101) >= 0 || obj2.indexOf(69) >= 0) {
                return obj2;
            }
            while (obj2.endsWith("0")) {
                obj2 = obj2.substring(0, obj2.length() - 1);
            }
            return obj2.endsWith(".") ? obj2.substring(0, obj2.length() - 1) : obj2;
        }
        throw new JSONException("Null pointer");
    }

    public static void b(Object obj) {
        if (obj != null) {
            if (obj instanceof Double) {
                Double d2 = (Double) obj;
                if (d2.isInfinite() || d2.isNaN()) {
                    throw new JSONException("JSON does not allow non-finite numbers.");
                }
            } else if (obj instanceof Float) {
                Float f2 = (Float) obj;
                if (f2.isInfinite() || f2.isNaN()) {
                    throw new JSONException("JSON does not allow non-finite numbers.");
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0084, code lost:
        if (r4 == '<') goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String c(String str) {
        String str2;
        if (str == null || str.length() == 0) {
            return "\"\"";
        }
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer(length + 4);
        stringBuffer.append(Typography.quote);
        int i2 = 0;
        char c2 = 0;
        while (i2 < length) {
            char charAt = str.charAt(i2);
            if (charAt == '\f') {
                str2 = "\\f";
            } else if (charAt != '\r') {
                if (charAt != '\"') {
                    if (charAt != '/') {
                        if (charAt != '\\') {
                            switch (charAt) {
                                case '\b':
                                    str2 = "\\b";
                                    break;
                                case '\t':
                                    str2 = "\\t";
                                    break;
                                case '\n':
                                    str2 = "\\n";
                                    break;
                                default:
                                    if (charAt < ' ' || ((charAt >= 128 && charAt < 160) || (charAt >= 8192 && charAt < 8448))) {
                                        String str3 = "000" + Integer.toHexString(charAt);
                                        str2 = "\\u" + str3.substring(str3.length() - 4);
                                        break;
                                    }
                                    stringBuffer.append(charAt);
                                    i2++;
                                    c2 = charAt;
                                    break;
                            }
                        }
                    }
                }
                stringBuffer.append('\\');
                stringBuffer.append(charAt);
                i2++;
                c2 = charAt;
            } else {
                str2 = "\\r";
            }
            stringBuffer.append(str2);
            i2++;
            c2 = charAt;
        }
        stringBuffer.append(Typography.quote);
        return stringBuffer.toString();
    }

    public final Object a(String str) {
        Object obj = str == null ? null : this.f68320b.get(str);
        if (obj != null) {
            return obj;
        }
        throw new JSONException("JSONObject[" + c(str) + "] not found.");
    }

    public final Iterator a() {
        return this.f68320b.keySet().iterator();
    }

    public final boolean b(String str) {
        return this.f68320b.containsKey(str);
    }

    public String toString() {
        try {
            Iterator a2 = a();
            StringBuffer stringBuffer = new StringBuffer(StringUtil.ARRAY_START);
            while (a2.hasNext()) {
                if (stringBuffer.length() > 1) {
                    stringBuffer.append(',');
                }
                Object next = a2.next();
                stringBuffer.append(c(next.toString()));
                stringBuffer.append(':');
                stringBuffer.append(a(this.f68320b.get(next)));
            }
            stringBuffer.append('}');
            return stringBuffer.toString();
        } catch (Exception unused) {
            return null;
        }
    }
}
