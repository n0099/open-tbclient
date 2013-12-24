package defpackage;

import com.baidu.cloudsdk.BaiduException;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.social.core.SessionManager;
import com.baidu.cloudsdk.social.oauth.SocialOAuthActivity;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: u  reason: default package */
/* loaded from: classes.dex */
public class u implements IBaiduListener {
    final /* synthetic */ SocialOAuthActivity a;

    public u(SocialOAuthActivity socialOAuthActivity) {
        this.a = socialOAuthActivity;
    }

    @Override // com.baidu.cloudsdk.IBaiduListener
    public void onCancel() {
        IBaiduListener iBaiduListener;
        IBaiduListener iBaiduListener2;
        this.a.finish();
        iBaiduListener = SocialOAuthActivity.a;
        if (iBaiduListener != null) {
            iBaiduListener2 = SocialOAuthActivity.a;
            iBaiduListener2.onCancel();
        }
    }

    @Override // com.baidu.cloudsdk.IBaiduListener
    public void onComplete() {
        IBaiduListener iBaiduListener;
        IBaiduListener iBaiduListener2;
        this.a.finish();
        iBaiduListener = SocialOAuthActivity.a;
        if (iBaiduListener != null) {
            iBaiduListener2 = SocialOAuthActivity.a;
            iBaiduListener2.onComplete();
        }
    }

    @Override // com.baidu.cloudsdk.IBaiduListener
    public void onComplete(JSONArray jSONArray) {
        IBaiduListener iBaiduListener;
        IBaiduListener iBaiduListener2;
        this.a.finish();
        iBaiduListener = SocialOAuthActivity.a;
        if (iBaiduListener != null) {
            iBaiduListener2 = SocialOAuthActivity.a;
            iBaiduListener2.onComplete(jSONArray);
        }
    }

    @Override // com.baidu.cloudsdk.IBaiduListener
    public void onComplete(JSONObject jSONObject) {
        IBaiduListener iBaiduListener;
        IBaiduListener iBaiduListener2;
        if (!SessionManager.getInstance(this.a).save(jSONObject)) {
            onError(new BaiduException("failed to save social session, it may be an error content"));
            return;
        }
        this.a.finish();
        iBaiduListener = SocialOAuthActivity.a;
        if (iBaiduListener != null) {
            iBaiduListener2 = SocialOAuthActivity.a;
            iBaiduListener2.onComplete();
        }
    }

    @Override // com.baidu.cloudsdk.IBaiduListener
    public void onError(BaiduException baiduException) {
        IBaiduListener iBaiduListener;
        IBaiduListener iBaiduListener2;
        this.a.finish();
        iBaiduListener = SocialOAuthActivity.a;
        if (iBaiduListener != null) {
            iBaiduListener2 = SocialOAuthActivity.a;
            iBaiduListener2.onError(baiduException);
        }
    }
}
