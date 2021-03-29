package d.b.g0.n;

import android.os.RemoteException;
import android.text.TextUtils;
import com.baidu.swan.ubc.Flow;
import com.baidu.swan.ubc.IRemoteUBCService;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class p {

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final p f49300a = new p();
    }

    public static p b() {
        return b.f49300a;
    }

    public Flow a(String str, String str2, int i) {
        if (d.b.d0.b.a.a.g()) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return n.k().g(str, str2, i);
        }
        return d(str, r.b(str2), i);
    }

    public final IRemoteUBCService c() throws RemoteException {
        return e.f();
    }

    public final Flow d(String str, String str2, int i) {
        Flow flow;
        try {
            flow = c().ubcBeginFlow(str, str2, i);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            flow = null;
        }
        return flow == null ? new Flow() : flow;
    }

    public void e(String str, String str2, int i) {
        if (d.b.d0.b.a.a.g()) {
            if (e.g() == null && TextUtils.isEmpty(str)) {
                return;
            }
            n.k().n(str, str2, i);
            return;
        }
        try {
            c().ubcOnEvent(str, r.b(str2), i);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    public final void f(String str, Map<String, String> map, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        } catch (JSONException unused) {
        }
        e(str, jSONObject.toString(), i);
    }

    public void g(String str, JSONObject jSONObject, int i) {
        if (d.b.d0.b.a.a.g()) {
            if (e.g() == null && TextUtils.isEmpty(str)) {
                return;
            }
            n.k().o(str, jSONObject, i);
            return;
        }
        try {
            c().ubcOnEvent(str, r.c(jSONObject), i);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    public void h() {
        n.k().u();
    }

    public void i() {
        n.k().p();
    }

    public final void onEvent(String str) {
        e(str, "", 0);
    }

    public p() {
    }
}
