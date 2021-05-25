package d.a.l0.a.y.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.JsFunction;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.binding.model.JSTypeMismatchException;
import d.a.l0.a.k;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f45766c = k.f43199a;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, Object> f45767a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, Integer> f45768b;

    /* renamed from: d.a.l0.a.y.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0906a {
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

        public static b d(Object obj) {
            if (obj instanceof b) {
                return (b) obj;
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

        public static a g(Object obj) {
            if (obj instanceof a) {
                return (a) obj;
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

        public static JSTypeMismatchException j(a aVar, String str, int i2) {
            int intValue = aVar.j().containsKey(str) ? ((Integer) aVar.j().get(str)).intValue() : 12;
            return new JSTypeMismatchException(str, intValue, i2, String.format("The \"%s\" argument must be %s. Received type %s", str, JsObject.typeToString(i2), JsObject.typeToString(intValue)));
        }
    }

    public static a G(JsObject jsObject) {
        if (jsObject == null) {
            if (f45766c) {
                Log.e("JSObjectMap", "parseFromJSObject object is null.");
                return null;
            }
            return null;
        }
        a aVar = new a();
        boolean z = false;
        for (int i2 = 0; i2 < jsObject.length(); i2++) {
            int propertyType = jsObject.getPropertyType(i2);
            String propertyName = jsObject.getPropertyName(i2);
            aVar.j().put(propertyName, Integer.valueOf(propertyType));
            switch (propertyType) {
                case 1:
                    aVar.f().put(propertyName, Boolean.valueOf(jsObject.toBoolean(i2)));
                    break;
                case 2:
                    aVar.f().put(propertyName, Integer.valueOf(jsObject.toInteger(i2)));
                    break;
                case 3:
                    aVar.f().put(propertyName, Long.valueOf(jsObject.toLong(i2)));
                    break;
                case 5:
                    aVar.f().put(propertyName, Double.valueOf(jsObject.toDouble(i2)));
                    break;
                case 6:
                    aVar.f().put(propertyName, new b(i2, jsObject));
                    z = true;
                    break;
                case 7:
                    aVar.f().put(propertyName, jsObject.toString(i2));
                    break;
                case 8:
                    aVar.f().put(propertyName, jsObject.toJsFunction(i2));
                    break;
                case 9:
                    aVar.f().put(propertyName, G(jsObject.toJsObject(i2)));
                    break;
                case 10:
                    aVar.f().put(propertyName, jsObject.toJsArrayBuffer(i2));
                    break;
            }
        }
        if (!z) {
            jsObject.release();
        }
        return aVar;
    }

    public JsObject[] A(String str) {
        return B(str, null);
    }

    public JsObject[] B(String str, JsObject[] jsObjectArr) {
        b d2 = C0906a.d(f().get(str));
        return d2 != null ? d2.f45770b.toObjectArray(d2.f45769a) : jsObjectArr;
    }

    public String C(String str) {
        return D(str, "");
    }

    public String D(String str, String str2) {
        String i2 = C0906a.i(f().get(str));
        return i2 != null ? i2 : str2;
    }

    public String[] E(String str) {
        return F(str, null);
    }

    public String[] F(String str, String[] strArr) {
        b d2 = C0906a.d(f().get(str));
        return d2 != null ? d2.f45770b.toStringArray(d2.f45769a) : strArr;
    }

    public void H(String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        f().put(str, obj);
    }

    public String I(String str) {
        return String.valueOf(f().get(str));
    }

    public boolean b(String str) {
        return j().containsKey(str);
    }

    public double c(String str) throws JSTypeMismatchException {
        Double b2 = C0906a.b(f().get(str));
        if (b2 != null) {
            return b2.doubleValue();
        }
        throw C0906a.j(this, str, 5);
    }

    public int d(String str) throws JSTypeMismatchException {
        Integer c2 = C0906a.c(f().get(str));
        if (c2 != null) {
            return c2.intValue();
        }
        throw C0906a.j(this, str, 2);
    }

    public JsObject[] e(String str) throws JSTypeMismatchException {
        b d2 = C0906a.d(f().get(str));
        if (d2 != null) {
            return d2.f45770b.toObjectArray(d2.f45769a);
        }
        throw C0906a.j(this, str, 6);
    }

    public final Map<String, Object> f() {
        if (this.f45767a == null) {
            this.f45767a = new TreeMap();
        }
        return this.f45767a;
    }

    public String g(String str) throws JSTypeMismatchException {
        String i2 = C0906a.i(f().get(str));
        if (i2 != null) {
            return i2;
        }
        throw C0906a.j(this, str, 7);
    }

    public String[] h(String str) throws JSTypeMismatchException {
        b d2 = C0906a.d(f().get(str));
        if (d2 != null) {
            return d2.f45770b.toStringArray(d2.f45769a);
        }
        throw C0906a.j(this, str, 6);
    }

    public int i(String str) {
        Integer num = j().get(str);
        if (num == null) {
            num = 12;
        }
        return num.intValue();
    }

    public final Map<String, Integer> j() {
        if (this.f45768b == null) {
            this.f45768b = new TreeMap();
        }
        return this.f45768b;
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
        Boolean a2 = C0906a.a(f().get(str));
        return a2 != null ? a2.booleanValue() : z;
    }

    public double o(String str, double d2) {
        Double b2 = C0906a.b(f().get(str));
        return b2 != null ? b2.doubleValue() : d2;
    }

    public double[] p(String str) {
        return q(str, null);
    }

    public double[] q(String str, double[] dArr) {
        b d2 = C0906a.d(f().get(str));
        return d2 != null ? d2.f45770b.toDoubleArray(d2.f45769a) : dArr;
    }

    public int r(String str) {
        return s(str, 0);
    }

    public int s(String str, int i2) {
        Integer c2 = C0906a.c(f().get(str));
        return c2 != null ? c2.intValue() : i2;
    }

    public JsArrayBuffer t(String str) {
        return u(str, null);
    }

    public String toString() {
        return f().toString();
    }

    public JsArrayBuffer u(String str, JsArrayBuffer jsArrayBuffer) {
        JsArrayBuffer e2 = C0906a.e(f().get(str));
        return e2 != null ? e2 : jsArrayBuffer;
    }

    public JsFunction v(String str) {
        return w(str, null);
    }

    public JsFunction w(String str, JsFunction jsFunction) {
        JsFunction f2 = C0906a.f(f().get(str));
        return f2 != null ? f2 : jsFunction;
    }

    public a x(String str) {
        return y(str, null);
    }

    public a y(String str, a aVar) {
        a g2 = C0906a.g(f().get(str));
        return g2 != null ? g2 : aVar;
    }

    public long z(String str, long j) {
        Long h2 = C0906a.h(f().get(str));
        return h2 != null ? h2.longValue() : j;
    }
}
