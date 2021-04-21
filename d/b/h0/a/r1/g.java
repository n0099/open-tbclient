package d.b.h0.a.r1;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class g extends f {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f46464b = d.b.h0.a.k.f45772a;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, Object> f46465a;

    public g(e eVar) {
        super(eVar);
        this.f46465a = new HashMap();
    }

    public void a() {
        this.f46465a.clear();
    }

    public boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f46465a.containsKey(str);
    }

    public Boolean c(String str, Boolean bool) {
        try {
            return (Boolean) f(str, bool);
        } catch (ClassCastException e2) {
            if (f46464b) {
                e2.printStackTrace();
            }
            return bool;
        }
    }

    public Integer d(String str, Integer num) {
        try {
            return (Integer) f(str, num);
        } catch (ClassCastException e2) {
            if (f46464b) {
                e2.printStackTrace();
            }
            return num;
        }
    }

    public String e(String str, String str2) {
        try {
            return (String) f(str, str2);
        } catch (ClassCastException e2) {
            if (f46464b) {
                e2.printStackTrace();
            }
            return str2;
        }
    }

    public final <V> V f(String str, V v) {
        if (b(str)) {
            if (this.f46465a.get(str) == null) {
                return null;
            }
            try {
                return (V) this.f46465a.get(str);
            } catch (Exception e2) {
                if (f46464b) {
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
        this.f46465a.put(str, v);
    }
}
