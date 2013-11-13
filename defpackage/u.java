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

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SocialOAuthActivity f2988a;

    public u(SocialOAuthActivity socialOAuthActivity) {
        this.f2988a = socialOAuthActivity;
    }

    @Override // com.baidu.cloudsdk.IBaiduListener
    public void onCancel() {
        IBaiduListener iBaiduListener;
        IBaiduListener iBaiduListener2;
        this.f2988a.finish();
        iBaiduListener = SocialOAuthActivity.f853a;
        if (iBaiduListener != null) {
            iBaiduListener2 = SocialOAuthActivity.f853a;
            iBaiduListener2.onCancel();
        }
    }

    @Override // com.baidu.cloudsdk.IBaiduListener
    public void onComplete() {
        IBaiduListener iBaiduListener;
        IBaiduListener iBaiduListener2;
        this.f2988a.finish();
        iBaiduListener = SocialOAuthActivity.f853a;
        if (iBaiduListener != null) {
            iBaiduListener2 = SocialOAuthActivity.f853a;
            iBaiduListener2.onComplete();
        }
    }

    @Override // com.baidu.cloudsdk.IBaiduListener
    public void onComplete(JSONArray jSONArray) {
        IBaiduListener iBaiduListener;
        IBaiduListener iBaiduListener2;
        this.f2988a.finish();
        iBaiduListener = SocialOAuthActivity.f853a;
        if (iBaiduListener != null) {
            iBaiduListener2 = SocialOAuthActivity.f853a;
            iBaiduListener2.onComplete(jSONArray);
        }
    }

    @Override // com.baidu.cloudsdk.IBaiduListener
    public void onComplete(JSONObject jSONObject) {
        IBaiduListener iBaiduListener;
        IBaiduListener iBaiduListener2;
        if (!SessionManager.getInstance(this.f2988a).save(jSONObject)) {
            onError(new BaiduException("failed to save social session, it may be an error content"));
            return;
        }
        this.f2988a.finish();
        iBaiduListener = SocialOAuthActivity.f853a;
        if (iBaiduListener != null) {
            iBaiduListener2 = SocialOAuthActivity.f853a;
            iBaiduListener2.onComplete();
        }
    }

    @Override // com.baidu.cloudsdk.IBaiduListener
    public void onError(BaiduException baiduException) {
        IBaiduListener iBaiduListener;
        IBaiduListener iBaiduListener2;
        this.f2988a.finish();
        iBaiduListener = SocialOAuthActivity.f853a;
        if (iBaiduListener != null) {
            iBaiduListener2 = SocialOAuthActivity.f853a;
            iBaiduListener2.onError(baiduException);
        }
    }
}
