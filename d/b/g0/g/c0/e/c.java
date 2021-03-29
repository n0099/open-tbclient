package d.b.g0.g.c0.e;

import com.baidu.swan.gamecenter.appmanager.install.InstallAntiBlockingActivity;
import com.baidu.wallet.router.RouterCallback;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends d {

    /* renamed from: b  reason: collision with root package name */
    public String f48025b;

    /* renamed from: c  reason: collision with root package name */
    public int f48026c;

    @Override // d.b.g0.g.c0.e.d
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(InstallAntiBlockingActivity.PARAM_PACKAGE_NAME, this.f48025b);
            jSONObject.put(RouterCallback.KEY_ERROR_CODE, this.f48026c);
            jSONObject.put("errMsg", this.f48027a);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
