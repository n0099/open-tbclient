package d.a.i0.r;

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
        public static final p f48279a = new p();
    }

    public static p b() {
        return b.f48279a;
    }

    public Flow a(String str, String str2, int i2) {
        if (d.a.c0.b.a.a.g()) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return n.f().a(str, str2, i2);
        }
        return d(str, r.b(str2), i2);
    }

    public final IRemoteUBCService c() throws RemoteException {
        return e.g();
    }

    public final Flow d(String str, String str2, int i2) {
        Flow flow;
        try {
            flow = c().ubcBeginFlow(str, str2, i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            flow = null;
        }
        return flow == null ? new Flow() : flow;
    }

    public void e(String str, String str2, int i2) {
        if (d.a.c0.b.a.a.g()) {
            if (e.h() == null && TextUtils.isEmpty(str)) {
                return;
            }
            n.f().j(str, str2, i2);
            return;
        }
        try {
            c().ubcOnEvent(str, r.b(str2), i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    public final void f(String str, Map<String, String> map, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        } catch (JSONException unused) {
        }
        e(str, jSONObject.toString(), i2);
    }

    public void g(String str, JSONObject jSONObject, int i2) {
        if (d.a.c0.b.a.a.g()) {
            if (e.h() == null && TextUtils.isEmpty(str)) {
                return;
            }
            n.f().k(str, jSONObject, i2);
            return;
        }
        try {
            c().ubcOnEvent(str, r.c(jSONObject), i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    public void h() {
        n.f().q();
    }

    public void i() {
        n.f().l();
    }

    public final void onEvent(String str) {
        e(str, "", 0);
    }

    public p() {
    }
}
