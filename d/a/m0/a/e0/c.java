package d.a.m0.a.e0;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.m0.a.h0.u.g;
import d.a.m0.a.k;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45134a = k.f46983a;

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, d.a.m0.a.p.e.a> f45135b = new HashMap(2);

    public static d.a.m0.a.p.e.a a() {
        if (f45134a) {
            Log.d("ConsoleCache", "create new sConsole");
        }
        d.k(true);
        return g.N().X().a(AppRuntime.getAppContext());
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0029 A[Catch: all -> 0x006b, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0009, B:9:0x0014, B:11:0x001b, B:13:0x0029, B:15:0x0039, B:16:0x004f, B:18:0x0053), top: B:24:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0053 A[Catch: all -> 0x006b, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0009, B:9:0x0014, B:11:0x001b, B:13:0x0029, B:15:0x0039, B:16:0x004f, B:18:0x0053), top: B:24:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized d.a.m0.a.p.e.a b() {
        String str;
        d.a.m0.a.p.e.a aVar;
        synchronized (c.class) {
            d.a.m0.a.a2.e Q = d.a.m0.a.a2.e.Q();
            if (Q != null && !TextUtils.isEmpty(Q.getAppId())) {
                str = Q.getAppId();
                String a2 = d.a.m0.a.v.a.a(str);
                aVar = f45135b.get(a2);
                if (aVar == null) {
                    e();
                    aVar = a();
                    f45135b.put(a2, aVar);
                    if (f45134a) {
                        Log.d("ConsoleCache", "can not find sconsole for appId - " + str);
                    }
                }
                if (f45134a) {
                    Log.d("ConsoleCache", "get sconsole for appId - " + str);
                }
            }
            str = "_no_id_";
            String a22 = d.a.m0.a.v.a.a(str);
            aVar = f45135b.get(a22);
            if (aVar == null) {
            }
            if (f45134a) {
            }
        }
        return aVar;
    }

    public static boolean c() {
        d.a.m0.a.a2.e Q = d.a.m0.a.a2.e.Q();
        if (Q != null && !TextUtils.isEmpty(Q.f44533f)) {
            return b.b(d.a.m0.a.v.a.a(Q.f44533f));
        }
        if (f45134a) {
            Log.w("ConsoleCache", "swanApp is null or appId is empty");
            return false;
        }
        return false;
    }

    public static void d() {
        if (c()) {
            b();
        }
    }

    public static synchronized void e() {
        synchronized (c.class) {
            if (f45135b.size() > 0) {
                for (String str : f45135b.keySet()) {
                    d.a.m0.a.p.e.a aVar = f45135b.get(str);
                    if (aVar != null) {
                        aVar.E();
                    }
                }
                f45135b.clear();
            }
        }
    }
}
