package d.a.h0.g.e.d;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.JsFunction;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
import d.a.h0.a.k;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f46291c = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, Object> f46292a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, Integer> f46293b;

    /* loaded from: classes3.dex */
    public static class a {
        public static Boolean a(Object obj) {
            if (obj instanceof Boolean) {
                return (Boolean) obj;
            }
            return null;
        }

        public static Double b(Object obj) {
            if (obj instanceof Double) {
                return (Double) obj;
            }
            if (obj instanceof Number) {
                return Double.valueOf(((Number) obj).doubleValue());
            }
            return null;
        }

        public static Integer c(Object obj) {
            if (obj instanceof Integer) {
                return (Integer) obj;
            }
            if (obj instanceof Number) {
                return Integer.valueOf(((Number) obj).intValue());
            }
            return null;
        }

        public static d d(Object obj) {
            if (obj instanceof d) {
                return (d) obj;
            }
            return null;
        }

        public static JsArrayBuffer e(Object obj) {
            if (obj instanceof JsArrayBuffer) {
                return (JsArrayBuffer) obj;
            }
            return null;
        }

        public static JsFunction f(Object obj) {
            if (obj instanceof JsFunction) {
                return (JsFunction) obj;
            }
            return null;
        }

        public static c g(Object obj) {
            if (obj instanceof c) {
                return (c) obj;
            }
            return null;
        }

        public static Long h(Object obj) {
            if (obj instanceof Long) {
                return (Long) obj;
            }
            if (obj instanceof Number) {
                return Long.valueOf(((Number) obj).longValue());
            }
            return null;
        }

        public static String i(Object obj) {
            if (obj instanceof String) {
                return (String) obj;
            }
            return null;
        }

        public static JSTypeMismatchException j(c cVar, String str, int i2) {
            int intValue = cVar.j().containsKey(str) ? ((Integer) cVar.j().get(str)).intValue() : 12;
            return new JSTypeMismatchException(str, intValue, i2, String.format("The \"%s\" argument must be %s. Received type %s", str, JsObject.typeToString(i2), JsObject.typeToString(intValue)));
        }
    }

    public static c F(JsObject jsObject) {
        if (jsObject == null) {
            if (f46291c) {
                Log.e("JSObjectMap", "parseFromJSObject object is null.");
                return null;
            }
            return null;
        }
        c cVar = new c();
        boolean z = false;
        for (int i2 = 0; i2 < jsObject.length(); i2++) {
            int propertyType = jsObject.getPropertyType(i2);
            String propertyName = jsObject.getPropertyName(i2);
            cVar.j().put(propertyName, Integer.valueOf(propertyType));
            switch (propertyType) {
                case 1:
                    cVar.f().put(propertyName, Boolean.valueOf(jsObject.toBoolean(i2)));
                    break;
                case 2:
                    cVar.f().put(propertyName, Integer.valueOf(jsObject.toInteger(i2)));
                    break;
                case 3:
                    cVar.f().put(propertyName, Long.valueOf(jsObject.toLong(i2)));
                    break;
                case 5:
                    cVar.f().put(propertyName, Double.valueOf(jsObject.toDouble(i2)));
                    break;
                case 6:
                    cVar.f().put(propertyName, new d(i2, jsObject));
                    z = true;
                    break;
                case 7:
                    cVar.f().put(propertyName, jsObject.toString(i2));
                    break;
                case 8:
                    cVar.f().put(propertyName, jsObject.toJsFunction(i2));
                    break;
                case 9:
                    cVar.f().put(propertyName, F(jsObject.toJsObject(i2)));
                    break;
                case 10:
                    cVar.f().put(propertyName, jsObject.toJsArrayBuffer(i2));
                    break;
            }
        }
        if (!z) {
            jsObject.release();
        }
        return cVar;
    }

    public JsObject[] A(String str, JsObject[] jsObjectArr) {
        d d2 = a.d(f().get(str));
        return d2 != null ? d2.f46295b.toObjectArray(d2.f46294a) : jsObjectArr;
    }

    public String B(String str) {
        return C(str, "");
    }

    public String C(String str, String str2) {
        String i2 = a.i(f().get(str));
        return i2 != null ? i2 : str2;
    }

    public String[] D(String str) {
        return E(str, null);
    }

    public String[] E(String str, String[] strArr) {
        d d2 = a.d(f().get(str));
        return d2 != null ? d2.f46295b.toStringArray(d2.f46294a) : strArr;
    }

    public void G(String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        f().put(str, obj);
    }

    public String H(String str) {
        return String.valueOf(f().get(str));
    }

    public boolean b(String str) {
        return j().containsKey(str);
    }

    public double c(String str) throws JSTypeMismatchException {
        Double b2 = a.b(f().get(str));
        if (b2 != null) {
            return b2.doubleValue();
        }
        throw a.j(this, str, 5);
    }

    public int d(String str) throws JSTypeMismatchException {
        Integer c2 = a.c(f().get(str));
        if (c2 != null) {
            return c2.intValue();
        }
        throw a.j(this, str, 2);
    }

    public JsObject[] e(String str) throws JSTypeMismatchException {
        d d2 = a.d(f().get(str));
        if (d2 != null) {
            return d2.f46295b.toObjectArray(d2.f46294a);
        }
        throw a.j(this, str, 6);
    }

    public final Map<String, Object> f() {
        if (this.f46292a == null) {
            this.f46292a = new TreeMap();
        }
        return this.f46292a;
    }

    public String g(String str) throws JSTypeMismatchException {
        String i2 = a.i(f().get(str));
        if (i2 != null) {
            return i2;
        }
        throw a.j(this, str, 7);
    }

    public String[] h(String str) throws JSTypeMismatchException {
        d d2 = a.d(f().get(str));
        if (d2 != null) {
            return d2.f46295b.toStringArray(d2.f46294a);
        }
        throw a.j(this, str, 6);
    }

    public int i(String str) {
        Integer num = j().get(str);
        if (num == null) {
            num = 12;
        }
        return num.intValue();
    }

    public final Map<String, Integer> j() {
        if (this.f46293b == null) {
            this.f46293b = new TreeMap();
        }
        return this.f46293b;
    }

    public Set<String> k() {
        return f().keySet();
    }

    public int l() {
        return f().size();
    }

    public boolean m(String str) {
        return n(str, false);
    }

    public boolean n(String str, boolean z) {
        Boolean a2 = a.a(f().get(str));
        return a2 != null ? a2.booleanValue() : z;
    }

    public double o(String str, double d2) {
        Double b2 = a.b(f().get(str));
        return b2 != null ? b2.doubleValue() : d2;
    }

    public double[] p(String str) {
        return q(str, null);
    }

    public double[] q(String str, double[] dArr) {
        d d2 = a.d(f().get(str));
        return d2 != null ? d2.f46295b.toDoubleArray(d2.f46294a) : dArr;
    }

    public int r(String str) {
        return s(str, 0);
    }

    public int s(String str, int i2) {
        Integer c2 = a.c(f().get(str));
        return c2 != null ? c2.intValue() : i2;
    }

    public JsArrayBuffer t(String str, JsArrayBuffer jsArrayBuffer) {
        JsArrayBuffer e2 = a.e(f().get(str));
        return e2 != null ? e2 : jsArrayBuffer;
    }

    public String toString() {
        return f().toString();
    }

    public JsFunction u(String str) {
        return v(str, null);
    }

    public JsFunction v(String str, JsFunction jsFunction) {
        JsFunction f2 = a.f(f().get(str));
        return f2 != null ? f2 : jsFunction;
    }

    public c w(String str) {
        return x(str, null);
    }

    public c x(String str, c cVar) {
        c g2 = a.g(f().get(str));
        return g2 != null ? g2 : cVar;
    }

    public long y(String str, long j) {
        Long h2 = a.h(f().get(str));
        return h2 != null ? h2.longValue() : j;
    }

    public JsObject[] z(String str) {
        return A(str, null);
    }
}
