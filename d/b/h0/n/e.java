package d.b.h0.n;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.pyramid.runtime.multiprocess.IPCServiceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.ubc.Flow;
import com.baidu.swan.ubc.IRemoteUBCService;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
@Autowired
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static volatile IRemoteUBCService f49949a;

    /* renamed from: b  reason: collision with root package name */
    public static Map<String, Integer> f49950b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public static Set<String> f49951c;

    static {
        HashSet hashSet = new HashSet();
        f49951c = hashSet;
        hashSet.add("606");
        f49951c.add("671");
        f49950b.put("606", -1);
        f49950b.put("671", -1);
    }

    public static String a(String str, String str2) {
        l g2;
        Integer valueOf;
        if (f49951c.contains(str) && (g2 = g()) != null && g2.p()) {
            synchronized (e.class) {
                Integer num = f49950b.get(str);
                if (num == null) {
                    num = -1;
                }
                String str3 = "ubc_counter" + str;
                if (num.intValue() == -1) {
                    num = Integer.valueOf(t.f().getInt(str3, 0));
                }
                try {
                    if (num.intValue() + 1 >= Integer.MAX_VALUE) {
                        valueOf = 0;
                    } else {
                        valueOf = Integer.valueOf(num.intValue() + 1);
                    }
                    JSONObject jSONObject = new JSONObject(str2);
                    jSONObject.put("counter", valueOf);
                    str2 = jSONObject.toString();
                    t.f().putInt("ubc_counter" + str, valueOf.intValue());
                    f49950b.put(str, valueOf);
                } catch (JSONException unused) {
                }
            }
            return str2;
        }
        return str2;
    }

    public static JSONObject b(String str, JSONObject jSONObject) {
        l g2;
        Integer valueOf;
        if (f49951c.contains(str) && (g2 = g()) != null && g2.p()) {
            synchronized (e.class) {
                Integer num = f49950b.get(str);
                if (num == null) {
                    num = -1;
                }
                String str2 = "ubc_counter" + str;
                if (num.intValue() == -1) {
                    num = Integer.valueOf(t.f().getInt(str2, 0));
                }
                try {
                    if (num.intValue() + 1 >= Integer.MAX_VALUE) {
                        valueOf = 0;
                    } else {
                        valueOf = Integer.valueOf(num.intValue() + 1);
                    }
                    jSONObject.put("counter", valueOf);
                    t.f().putInt("ubc_counter" + str, valueOf.intValue());
                    f49950b.put(str, valueOf);
                } catch (JSONException unused) {
                }
            }
            return jSONObject;
        }
        return jSONObject;
    }

    public static final Flow c(String str) {
        return d(str, "", 0);
    }

    public static Flow d(String str, String str2, int i) {
        return p.b().a(str, str2, i);
    }

    public static Context e() {
        return AppRuntime.getAppContext();
    }

    public static IRemoteUBCService f() throws RemoteException {
        if (f49949a == null) {
            synchronized (e.class) {
                if (f49949a == null) {
                    IBinder f2 = IPCServiceManager.f("open_log", true);
                    if (f2 == null) {
                        throw new RemoteException("Ceres get remote service empty !");
                    }
                    if (f2 != null) {
                        f49949a = IRemoteUBCService.Stub.asInterface(f2);
                    }
                }
            }
        }
        return f49949a;
    }

    @Inject
    public static final l g() {
        return d.b.h0.a.h1.b.a();
    }

    public static final void h(String str, String str2) {
        i(str, str2, 0);
    }

    public static void i(String str, String str2, int i) {
        if (d.b.c0.b.a.a.g()) {
            str2 = a(str, str2);
        }
        if (d.b.h0.o.d.a()) {
            p.b().e(str, str2, i);
        }
    }

    public static final void j(String str, Map<String, String> map) {
        k(str, map, 0);
    }

    public static final void k(String str, Map<String, String> map, int i) {
        if (d.b.h0.o.d.a()) {
            p.b().f(str, map, i);
        }
    }

    public static final void l(String str, JSONObject jSONObject) {
        m(str, jSONObject, 0);
    }

    public static void m(String str, JSONObject jSONObject, int i) {
        if (d.b.c0.b.a.a.g()) {
            b(str, jSONObject);
        }
        if (d.b.h0.o.d.a()) {
            p.b().g(str, jSONObject, i);
        }
    }

    public static final void onEvent(String str) {
        i(str, "", 0);
    }
}
