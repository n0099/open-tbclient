package d.a.i0.a.n0.h;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import d.a.i0.a.k;
import d.a.i0.n.h.g;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f43423a = k.f43025a;

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, Integer> f43424b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public static final Object f43425c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public static boolean f43426d = c.a();

    public static void a() {
        if (f43426d) {
            if (f43423a) {
                Log.d("ExcludeRecorder", "remove all exclude appIds");
            }
            synchronized (f43425c) {
                f43424b.clear();
            }
        }
    }

    @NonNull
    public static Set<String> b() {
        String[] strArr;
        if (!f43426d) {
            return Collections.emptySet();
        }
        synchronized (f43425c) {
            strArr = (String[]) f43424b.keySet().toArray(new String[0]);
        }
        return d.a.i0.a.v2.z0.a.a(strArr);
    }

    public static boolean c(String str) {
        boolean containsKey;
        if (f43426d && !TextUtils.isEmpty(str)) {
            synchronized (f43425c) {
                containsKey = f43424b.containsKey(str);
            }
            if (f43423a) {
                Log.d("ExcludeRecorder", "appId - " + str + " needExclude - " + containsKey);
            }
            return containsKey;
        }
        return false;
    }

    public static void d(String str) {
        if (f43426d) {
            if (f43423a) {
                Log.d("ExcludeRecorder", "record one appId for exclude - " + str);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            synchronized (f43425c) {
                Integer num = f43424b.get(str);
                if (num == null) {
                    f43424b.put(str, 1);
                } else {
                    f43424b.put(str, Integer.valueOf(num.intValue() + 1));
                }
            }
        }
    }

    public static void e(d.a.i0.n.o.f fVar) {
        if (f43426d && fVar != null) {
            for (d.a.i0.n.h.e eVar : fVar.h()) {
                if (eVar instanceof d.a.i0.n.h.f) {
                    d(eVar.f47836g);
                } else if (eVar instanceof g) {
                    d(((g) eVar).o);
                }
            }
        }
    }

    public static void f(String str) {
        if (f43426d) {
            if (f43423a) {
                Log.d("ExcludeRecorder", "remove one appId for exclude - " + str);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            synchronized (f43425c) {
                Integer num = f43424b.get(str);
                if (num != null) {
                    int intValue = num.intValue() - 1;
                    if (intValue <= 0) {
                        f43424b.remove(str);
                    } else {
                        f43424b.put(str, Integer.valueOf(intValue));
                    }
                }
            }
        }
    }
}
