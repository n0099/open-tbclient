package d.b.g0.a.e0.p;

import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44577a = d.b.g0.a.k.f45443a;

    public static void a(Message message) {
        if (message != null) {
            Object obj = message.obj;
            if (obj instanceof Bundle) {
                Bundle bundle = (Bundle) obj;
                String string = bundle.getString("eventType");
                HashMap hashMap = new HashMap();
                hashMap.put("eventType", string);
                JSONObject jSONObject = new JSONObject();
                if (TextUtils.equals(string, "checkForUpdate")) {
                    try {
                        jSONObject.put("hasUpdate", bundle.getBoolean("hasUpdate"));
                    } catch (JSONException e2) {
                        if (f44577a) {
                            e2.printStackTrace();
                        }
                    }
                }
                hashMap.put("data", jSONObject.toString());
                d.b.g0.a.k0.b.b bVar = new d.b.g0.a.k0.b.b("updateStatusChange", hashMap);
                SwanAppActivity activity = d.b.g0.a.z0.f.V().getActivity();
                if (activity != null && activity.getFrameType() == 1) {
                    d.b.g0.g.h0.a.a().d(string, bundle.getBoolean("hasUpdate"));
                } else {
                    d.b.g0.a.z0.f.V().N(bVar);
                }
            }
        }
    }

    public static void b(String str, boolean z) {
        d.b.g0.a.c0.c.h("SwanAppPkgUpdateManager", "send checkForUpdate msg, hasUpdate=" + z);
        Bundle bundle = new Bundle();
        bundle.putBoolean("hasUpdate", z);
        d("checkForUpdate", str, bundle);
    }

    public static void c(String str) {
        d.b.g0.a.c0.c.h("SwanAppPkgUpdateManager", "send update failed msg");
        d("updateFailed", str, null);
    }

    public static void d(String str, String str2, Bundle bundle) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString("eventType", str);
            d.b.g0.a.n1.c.a e2 = d.b.g0.a.n1.c.a.e();
            d.b.g0.a.n1.c.c cVar = new d.b.g0.a.n1.c.c(107, bundle);
            cVar.c(str2);
            e2.h(cVar);
            return;
        }
        d.b.g0.a.c0.c.h("SwanAppPkgUpdateManager", "appId is empty or eventType is empty");
    }

    public static void e(String str) {
        if (f44577a) {
            Log.d("SwanAppPkgUpdateManager", "send update ready msg");
        }
        d("updateReady", str, null);
    }

    public static void f(String str, String str2, boolean z) {
        char c2;
        int hashCode = str.hashCode();
        if (hashCode == -1330233754) {
            if (str.equals("updateFailed")) {
                c2 = 1;
            }
            c2 = 65535;
        } else if (hashCode != -1317168438) {
            if (hashCode == -585906598 && str.equals("updateReady")) {
                c2 = 0;
            }
            c2 = 65535;
        } else {
            if (str.equals("checkForUpdate")) {
                c2 = 2;
            }
            c2 = 65535;
        }
        if (c2 == 0) {
            e(str2);
        } else if (c2 == 1) {
            c(str2);
        } else if (c2 != 2) {
        } else {
            b(str2, z);
        }
    }
}
