package d.a.l0.a.n0.h;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import d.a.l0.a.k;
import d.a.l0.n.h.g;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47273a = k.f46875a;

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, Integer> f47274b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public static final Object f47275c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public static boolean f47276d = c.a();

    public static void a() {
        if (f47276d) {
            if (f47273a) {
                Log.d("ExcludeRecorder", "remove all exclude appIds");
            }
            synchronized (f47275c) {
                f47274b.clear();
            }
        }
    }

    @NonNull
    public static Set<String> b() {
        String[] strArr;
        if (!f47276d) {
            return Collections.emptySet();
        }
        synchronized (f47275c) {
            strArr = (String[]) f47274b.keySet().toArray(new String[0]);
        }
        return d.a.l0.a.v2.z0.a.a(strArr);
    }

    public static boolean c(String str) {
        boolean containsKey;
        if (f47276d && !TextUtils.isEmpty(str)) {
            synchronized (f47275c) {
                containsKey = f47274b.containsKey(str);
            }
            if (f47273a) {
                Log.d("ExcludeRecorder", "appId - " + str + " needExclude - " + containsKey);
            }
            return containsKey;
        }
        return false;
    }

    public static void d(String str) {
        if (f47276d) {
            if (f47273a) {
                Log.d("ExcludeRecorder", "record one appId for exclude - " + str);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            synchronized (f47275c) {
                Integer num = f47274b.get(str);
                if (num == null) {
                    f47274b.put(str, 1);
                } else {
                    f47274b.put(str, Integer.valueOf(num.intValue() + 1));
                }
            }
        }
    }

    public static void e(d.a.l0.n.o.f fVar) {
        if (f47276d && fVar != null) {
            for (d.a.l0.n.h.e eVar : fVar.h()) {
                if (eVar instanceof d.a.l0.n.h.f) {
                    d(eVar.f51686g);
                } else if (eVar instanceof g) {
                    d(((g) eVar).o);
                }
            }
        }
    }

    public static void f(String str) {
        if (f47276d) {
            if (f47273a) {
                Log.d("ExcludeRecorder", "remove one appId for exclude - " + str);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            synchronized (f47275c) {
                Integer num = f47274b.get(str);
                if (num != null) {
                    int intValue = num.intValue() - 1;
                    if (intValue <= 0) {
                        f47274b.remove(str);
                    } else {
                        f47274b.put(str, Integer.valueOf(intValue));
                    }
                }
            }
        }
    }
}
