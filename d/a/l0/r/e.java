package d.a.l0.r;

import android.annotation.SuppressLint;
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
    public static volatile IRemoteUBCService f52053a;

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, Integer> f52054b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public static final Set<String> f52055c;

    static {
        HashSet hashSet = new HashSet();
        f52055c = hashSet;
        hashSet.add("606");
        f52055c.add("671");
        f52054b.put("606", -1);
        f52054b.put("671", -1);
    }

    public static int a(String str, String str2) {
        int intValue;
        Integer num = f52054b.get(str);
        if (num == null) {
            num = -1;
        }
        if (num.intValue() == -1) {
            intValue = t.g().getInt(str2, 0);
        } else {
            intValue = num.intValue();
        }
        int i2 = intValue + 1;
        if (i2 >= Integer.MAX_VALUE || i2 < 0) {
            return 0;
        }
        return i2;
    }

    public static String b(String str, String str2) {
        l h2;
        if (f52055c.contains(str) && (h2 = h()) != null && h2.q()) {
            synchronized (e.class) {
                String str3 = "ubc_counter" + str;
                int a2 = a(str, str3);
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    jSONObject.put("counter", a2);
                    str2 = jSONObject.toString();
                    t.g().putInt(str3, a2);
                    f52054b.put(str, Integer.valueOf(a2));
                } catch (JSONException unused) {
                }
            }
            return str2;
        }
        return str2;
    }

    public static JSONObject c(String str, JSONObject jSONObject) {
        l h2;
        if (f52055c.contains(str) && (h2 = h()) != null && h2.q()) {
            synchronized (e.class) {
                String str2 = "ubc_counter" + str;
                int a2 = a(str, str2);
                try {
                    jSONObject.put("counter", a2);
                    t.g().putInt(str2, a2);
                    f52054b.put(str, Integer.valueOf(a2));
                } catch (JSONException unused) {
                }
            }
            return jSONObject;
        }
        return jSONObject;
    }

    public static Flow d(String str) {
        return e(str, "", 0);
    }

    public static Flow e(String str, String str2, int i2) {
        return p.b().a(str, str2, i2);
    }

    public static Context f() {
        return AppRuntime.getAppContext();
    }

    @SuppressLint({"BDThrowableCheck"})
    public static IRemoteUBCService g() throws RemoteException {
        if (f52053a == null) {
            synchronized (e.class) {
                if (f52053a == null) {
                    IBinder f2 = IPCServiceManager.f("open_log", true);
                    if (f2 == null) {
                        throw new RemoteException("Ceres get remote service empty !");
                    }
                    if (f2 != null) {
                        f52053a = IRemoteUBCService.Stub.asInterface(f2);
                    }
                }
            }
        }
        return f52053a;
    }

    @Inject
    public static l h() {
        return d.a.l0.a.o1.b.a();
    }

    public static void i(String str, String str2) {
        j(str, str2, 0);
    }

    public static void j(String str, String str2, int i2) {
        if (d.a.e0.b.a.a.g()) {
            str2 = b(str, str2);
        }
        if (d.a.l0.s.d.a()) {
            p.b().e(str, str2, i2);
        }
    }

    public static void k(String str, Map<String, String> map) {
        l(str, map, 0);
    }

    public static void l(String str, Map<String, String> map, int i2) {
        if (d.a.l0.s.d.a()) {
            p.b().f(str, map, i2);
        }
    }

    public static void m(String str, JSONObject jSONObject) {
        n(str, jSONObject, 0);
    }

    public static void n(String str, JSONObject jSONObject, int i2) {
        if (d.a.e0.b.a.a.g()) {
            c(str, jSONObject);
        }
        if (d.a.l0.s.d.a()) {
            p.b().g(str, jSONObject, i2);
        }
    }

    public static void onEvent(String str) {
        j(str, "", 0);
    }
}
