package defpackage;

import android.text.TextUtils;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.common.http.JsonHttpResponseHandler;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.cloudsdk.social.share.ShareContent;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: k  reason: default package */
/* loaded from: classes.dex */
class k extends JsonHttpResponseHandler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ShareContent f3045a;
    final /* synthetic */ IBaiduListener b;
    final /* synthetic */ aq c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(aq aqVar, ShareContent shareContent, IBaiduListener iBaiduListener) {
        this.c = aqVar;
        this.f3045a = shareContent;
        this.b = iBaiduListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
    public void onFailure(Throwable th, String str) {
        this.c.a(this.f3045a, this.b);
    }

    @Override // com.baidu.cloudsdk.common.http.JsonHttpResponseHandler
    protected void onSuccess(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString(SocialConstants.PARAM_URL);
            if (!TextUtils.isEmpty(string)) {
                this.f3045a.setLinkUrl(string);
            }
        } catch (JSONException e) {
        }
        this.c.a(this.f3045a, this.b);
    }
}
