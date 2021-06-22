package d.a.m0.a.n0.h;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import d.a.m0.a.k;
import d.a.m0.n.h.g;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47381a = k.f46983a;

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, Integer> f47382b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public static final Object f47383c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public static boolean f47384d = c.a();

    public static void a() {
        if (f47384d) {
            if (f47381a) {
                Log.d("ExcludeRecorder", "remove all exclude appIds");
            }
            synchronized (f47383c) {
                f47382b.clear();
            }
        }
    }

    @NonNull
    public static Set<String> b() {
        String[] strArr;
        if (!f47384d) {
            return Collections.emptySet();
        }
        synchronized (f47383c) {
            strArr = (String[]) f47382b.keySet().toArray(new String[0]);
        }
        return d.a.m0.a.v2.z0.a.a(strArr);
    }

    public static boolean c(String str) {
        boolean containsKey;
        if (f47384d && !TextUtils.isEmpty(str)) {
            synchronized (f47383c) {
                containsKey = f47382b.containsKey(str);
            }
            if (f47381a) {
                Log.d("ExcludeRecorder", "appId - " + str + " needExclude - " + containsKey);
            }
            return containsKey;
        }
        return false;
    }

    public static void d(String str) {
        if (f47384d) {
            if (f47381a) {
                Log.d("ExcludeRecorder", "record one appId for exclude - " + str);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            synchronized (f47383c) {
                Integer num = f47382b.get(str);
                if (num == null) {
                    f47382b.put(str, 1);
                } else {
                    f47382b.put(str, Integer.valueOf(num.intValue() + 1));
                }
            }
        }
    }

    public static void e(d.a.m0.n.o.f fVar) {
        if (f47384d && fVar != null) {
            for (d.a.m0.n.h.e eVar : fVar.h()) {
                if (eVar instanceof d.a.m0.n.h.f) {
                    d(eVar.f51794g);
                } else if (eVar instanceof g) {
                    d(((g) eVar).o);
                }
            }
        }
    }

    public static void f(String str) {
        if (f47384d) {
            if (f47381a) {
                Log.d("ExcludeRecorder", "remove one appId for exclude - " + str);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            synchronized (f47383c) {
                Integer num = f47382b.get(str);
                if (num != null) {
                    int intValue = num.intValue() - 1;
                    if (intValue <= 0) {
                        f47382b.remove(str);
                    } else {
                        f47382b.put(str, Integer.valueOf(intValue));
                    }
                }
            }
        }
    }
}
