package tv.chushou.basis.http.listener;

import android.support.annotation.Keep;
import android.support.annotation.Nullable;
import org.json.JSONObject;
import tv.chushou.basis.d.a.c.a;
import tv.chushou.basis.d.b;
import tv.chushou.basis.http.Http;
import tv.chushou.basis.http.HttpExecutor;
@Keep
/* loaded from: classes5.dex */
public abstract class JsonCallbackWrapper implements a<Http.Resp> {
    public abstract void callFailure(int i, @Nullable String str, @Nullable String str2);

    public abstract void callStart();

    public abstract void callSuccess(String str, JSONObject jSONObject);

    @Override // tv.chushou.basis.d.a.c.a
    public final void onFailure(int i, @Nullable String str, @Nullable Throwable th) {
        callFailure(i, str, "");
    }

    @Override // tv.chushou.basis.d.a.c.a
    public final void onStart() {
        callStart();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // tv.chushou.basis.d.a.c.a
    public final void onSuccess(Http.Resp resp) {
        if (resp == null || resp.respJson == null) {
            callFailure(-1, "", resp != null ? resp.respString : "");
            return;
        }
        int optInt = resp.respJson.optInt("code", -1);
        if (optInt == 0) {
            callSuccess(resp.respString, resp.respJson);
            return;
        }
        if (optInt == 401) {
            b.dRl().d(HttpExecutor.TAG, "401, url=" + resp.baseUrl + resp.path);
        }
        String optString = resp.respJson.optString("message");
        tv.chushou.basis.d.a.b.b bVar = (tv.chushou.basis.d.a.b.b) b.dRm().S(tv.chushou.basis.d.a.b.b.class);
        if (bVar != null) {
            bVar.Jh(optInt);
        }
        callFailure(optInt, optString, resp.respString);
    }
}
