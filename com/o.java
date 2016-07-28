package com;

import android.text.TextUtils;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.common.http.JsonHttpResponseHandler;
import com.baidu.cloudsdk.social.share.ShareContent;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
class o extends JsonHttpResponseHandler {
    final /* synthetic */ ShareContent a;
    final /* synthetic */ IBaiduListener b;
    final /* synthetic */ n cT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, ShareContent shareContent, IBaiduListener iBaiduListener) {
        this.cT = nVar;
        this.a = shareContent;
        this.b = iBaiduListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
    public void onFailure(Throwable th, String str) {
        this.cT.a(this.a, this.b);
    }

    @Override // com.baidu.cloudsdk.common.http.JsonHttpResponseHandler
    protected void onSuccess(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("url");
            if (!TextUtils.isEmpty(string)) {
                this.a.setLinkUrl(string + "#weixin.qq.com");
            }
        } catch (JSONException e) {
        }
        this.cT.a(this.a, this.b);
    }
}
