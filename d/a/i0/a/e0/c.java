package d.a.i0.a.e0;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.i0.a.h0.u.g;
import d.a.i0.a.k;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f41176a = k.f43025a;

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, d.a.i0.a.p.e.a> f41177b = new HashMap(2);

    public static d.a.i0.a.p.e.a a() {
        if (f41176a) {
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
    public static synchronized d.a.i0.a.p.e.a b() {
        String str;
        d.a.i0.a.p.e.a aVar;
        synchronized (c.class) {
            d.a.i0.a.a2.e Q = d.a.i0.a.a2.e.Q();
            if (Q != null && !TextUtils.isEmpty(Q.getAppId())) {
                str = Q.getAppId();
                String a2 = d.a.i0.a.v.a.a(str);
                aVar = f41177b.get(a2);
                if (aVar == null) {
                    e();
                    aVar = a();
                    f41177b.put(a2, aVar);
                    if (f41176a) {
                        Log.d("ConsoleCache", "can not find sconsole for appId - " + str);
                    }
                }
                if (f41176a) {
                    Log.d("ConsoleCache", "get sconsole for appId - " + str);
                }
            }
            str = "_no_id_";
            String a22 = d.a.i0.a.v.a.a(str);
            aVar = f41177b.get(a22);
            if (aVar == null) {
            }
            if (f41176a) {
            }
        }
        return aVar;
    }

    public static boolean c() {
        d.a.i0.a.a2.e Q = d.a.i0.a.a2.e.Q();
        if (Q != null && !TextUtils.isEmpty(Q.f40575f)) {
            return b.b(d.a.i0.a.v.a.a(Q.f40575f));
        }
        if (f41176a) {
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
            if (f41177b.size() > 0) {
                for (String str : f41177b.keySet()) {
                    d.a.i0.a.p.e.a aVar = f41177b.get(str);
                    if (aVar != null) {
                        aVar.E();
                    }
                }
                f41177b.clear();
            }
        }
    }
}
