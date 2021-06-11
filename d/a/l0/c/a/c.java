package d.a.l0.c.a;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.pyramid.annotation.Service;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.wallet.lightapp.base.LightappConstants;
import d.a.l0.a.k;
import d.a.l0.n.i.a;
import okhttp3.Callback;
import org.json.JSONObject;
@Service
/* loaded from: classes3.dex */
public class c implements d.a.l0.a.p.d.d {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f50127a = k.f46875a;

    @Override // d.a.l0.a.p.d.d
    public void d(byte[] bArr) {
        d.b().c(bArr);
    }

    @Override // d.a.l0.a.p.d.d
    public <T> void e(String str, String str2, ResponseCallback<T> responseCallback) {
        new d.a.l0.c.a.k.b().q(str, str2, responseCallback);
    }

    @Override // d.a.l0.a.p.d.d
    public void f(String str, String str2, a.c cVar) {
        new d.a.l0.c.a.k.a().k(str, str2, cVar);
    }

    @Override // d.a.l0.a.p.d.d
    public boolean g(String str) {
        return d.b().e(str);
    }

    @Override // d.a.l0.a.p.d.d
    public boolean h() {
        return d.b().d();
    }

    @Override // d.a.l0.a.p.d.d
    public boolean i(@NonNull d.a.l0.a.a2.e eVar, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, Callback callback, d.a.l0.a.v2.e1.b<String> bVar) {
        JSONObject optJSONObject = jSONObject.optJSONObject("ext");
        if (optJSONObject == null || !optJSONObject.optBoolean("enableBdtls", false)) {
            return false;
        }
        String optString = optJSONObject.optString(LightappConstants.ACCESS_WALLET_SERVICE_PARAM_SERVICE);
        if (TextUtils.isEmpty(optString)) {
            if (f50127a) {
                Log.d("BdtlsImpl", "onFailure: serviceId is invalid");
            }
            if (bVar != null) {
                bVar.onCallback("serviceId is invalid");
                return true;
            }
            return true;
        }
        d.a.l0.a.j2.k.y(str, eVar.N().G(), null);
        new d.a.l0.c.a.k.d(eVar, jSONObject, str2, callback).o(optString);
        return true;
    }
}
