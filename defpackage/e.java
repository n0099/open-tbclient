package defpackage;

import android.text.TextUtils;
import com.baidu.cloudsdk.common.http.JsonHttpResponseHandler;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.cloudsdk.social.share.ShareContent;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: e  reason: default package */
/* loaded from: classes.dex */
public class e extends JsonHttpResponseHandler {
    final /* synthetic */ ShareContent a;
    final /* synthetic */ ai b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ai aiVar, ShareContent shareContent) {
        this.b = aiVar;
        this.a = shareContent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
    public void onFailure(Throwable th, String str) {
        this.b.a(this.a);
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
        this.b.a(this.a);
    }
}
