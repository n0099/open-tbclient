package com;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.cloudsdk.common.http.JsonHttpResponseHandler;
import com.baidu.cloudsdk.common.http.RequestParams;
import com.baidu.cloudsdk.social.share.uiwithlayout.LocationPreview;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class s extends JsonHttpResponseHandler {
    final /* synthetic */ RequestParams dC;
    final /* synthetic */ LocationPreview dD;

    public s(LocationPreview locationPreview, RequestParams requestParams) {
        this.dD = locationPreview;
        this.dC = requestParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
    public void onFailure(Throwable th, String str) {
        String str2;
        str2 = LocationPreview.a;
        Log.e(str2, "get city|street failed, url: http://api.map.baidu.com/geocoder/v2/?" + this.dC.getQueryString() + ", errmsg: " + th.getMessage());
        this.dD.b();
    }

    @Override // com.baidu.cloudsdk.common.http.JsonHttpResponseHandler
    protected void onSuccess(JSONObject jSONObject) {
        String str;
        JSONObject optJSONObject = jSONObject.optJSONObject("result");
        if (optJSONObject != null) {
            String optString = optJSONObject.optString("formatted_address");
            if (!TextUtils.isEmpty(optString)) {
                this.dD.a(optString);
                return;
            }
        }
        str = LocationPreview.a;
        Log.e(str, "get city|street failed, url: http://api.map.baidu.com/geocoder/v2/?" + this.dC.getQueryString());
        this.dD.b();
    }
}
