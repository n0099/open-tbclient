package com;

import android.text.TextUtils;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.common.http.JsonHttpResponseHandler;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.cloudsdk.social.share.ShareContent;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
class h extends JsonHttpResponseHandler {
    final /* synthetic */ ShareContent a;
    final /* synthetic */ IBaiduListener b;
    final /* synthetic */ ao c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ao aoVar, ShareContent shareContent, IBaiduListener iBaiduListener) {
        this.c = aoVar;
        this.a = shareContent;
        this.b = iBaiduListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
    public void onFailure(Throwable th, String str) {
        this.c.a(this.a, this.b);
    }

    @Override // com.baidu.cloudsdk.common.http.JsonHttpResponseHandler
    protected void onSuccess(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString(SocialConstants.PARAM_URL);
            if (!TextUtils.isEmpty(string)) {
                this.a.setLinkUrl(string);
            }
        } catch (JSONException e) {
        }
        this.c.a(this.a, this.b);
    }
}
