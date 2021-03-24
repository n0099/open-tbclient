package d.b.g0.a.r1;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class g extends f {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f45742b = d.b.g0.a.k.f45050a;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, Object> f45743a;

    public g(e eVar) {
        super(eVar);
        this.f45743a = new HashMap();
    }

    public void a() {
        this.f45743a.clear();
    }

    public boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f45743a.containsKey(str);
    }

    public Boolean c(String str, Boolean bool) {
        try {
            return (Boolean) f(str, bool);
        } catch (ClassCastException e2) {
            if (f45742b) {
                e2.printStackTrace();
            }
            return bool;
        }
    }

    public Integer d(String str, Integer num) {
        try {
            return (Integer) f(str, num);
        } catch (ClassCastException e2) {
            if (f45742b) {
                e2.printStackTrace();
            }
            return num;
        }
    }

    public String e(String str, String str2) {
        try {
            return (String) f(str, str2);
        } catch (ClassCastException e2) {
            if (f45742b) {
                e2.printStackTrace();
            }
            return str2;
        }
    }

    public final <V> V f(String str, V v) {
        if (b(str)) {
            if (this.f45743a.get(str) == null) {
                return null;
            }
            try {
                return (V) this.f45743a.get(str);
            } catch (Exception e2) {
                if (f45742b) {
                    e2.printStackTrace();
                    return v;
                }
                return v;
            }
        }
        return v;
    }

    public void g() {
        a();
    }

    public void h(String str, Boolean bool) {
        k(str, bool);
    }

    public void i(String str, Integer num) {
        k(str, num);
    }

    public void j(String str, String str2) {
        k(str, str2);
    }

    public final <V> void k(String str, V v) {
        this.f45743a.put(str, v);
    }
}
