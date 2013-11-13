package defpackage;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.cloudsdk.common.http.JsonHttpResponseHandler;
import com.baidu.cloudsdk.common.http.RequestParams;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: s  reason: default package */
/* loaded from: classes.dex */
public class s extends JsonHttpResponseHandler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RequestParams f2986a;
    final /* synthetic */ m b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(m mVar, RequestParams requestParams) {
        this.b = mVar;
        this.f2986a = requestParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
    public void onFailure(Throwable th, String str) {
        String str2;
        str2 = m.f2881a;
        Log.e(str2, "get city|street failed, url: http://loc.map.baidu.com/wloc?" + this.f2986a.getQueryString() + ", errmsg: " + th.getMessage());
        this.b.d();
    }

    @Override // com.baidu.cloudsdk.common.http.JsonHttpResponseHandler
    protected void onSuccess(JSONObject jSONObject) {
        JSONObject optJSONObject;
        String str;
        if (jSONObject.optJSONObject("addr") != null) {
            String str2 = optJSONObject.optString("city") + optJSONObject.optString("street");
            if (!TextUtils.isEmpty(str2)) {
                this.b.a(str2);
                return;
            }
        }
        str = m.f2881a;
        Log.e(str, "get city|street failed, url: http://loc.map.baidu.com/wloc?" + this.f2986a.getQueryString());
        this.b.d();
    }
}
