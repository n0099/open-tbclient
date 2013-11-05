package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.cloudsdk.BaiduException;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.core.SocialConfig;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.cloudsdk.social.oauth.SocialOAuthActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: bu  reason: default package */
/* loaded from: classes.dex */
public class bu extends b {
    private String e;
    private String f;
    private ServiceConnection g;

    public bu(SocialOAuthActivity socialOAuthActivity, String str, IBaiduListener iBaiduListener) {
        super(socialOAuthActivity, str, MediaType.SINAWEIBO.toString(), iBaiduListener);
        this.g = new bv(this);
    }

    private boolean h() {
        Context applicationContext = this.f395a.getApplicationContext();
        Intent intent = new Intent("com.sina.weibo.remotessoservice");
        if (applicationContext.getPackageManager().resolveService(intent, 0) != null) {
            return applicationContext.getApplicationContext().bindService(intent, this.g, 1);
        }
        return false;
    }

    @Override // defpackage.cb
    public void a(int i, int i2, Intent intent) {
        if (i == e()) {
            String stringExtra = intent != null ? intent.getStringExtra("error") : null;
            if (i2 != -1 || intent == null) {
                if (i2 != 0) {
                    this.d.onError(new BaiduException("sina weibo sso returns unknown error"));
                    return;
                } else if (intent == null) {
                    this.d.onCancel();
                    return;
                } else {
                    this.d.onError(new BaiduException(stringExtra + ", error_code: " + String.valueOf(intent.getIntExtra(SocialConstants.PARAM_ERROR_CODE, -1)) + ", request for " + intent.getStringExtra("failing_url") + " failed"));
                    return;
                }
            }
            if (TextUtils.isEmpty(stringExtra)) {
                stringExtra = intent.getStringExtra("error_type");
            }
            if (stringExtra == null) {
                Bundle extras = intent.getExtras();
                a(extras.getString("access_token"), extras.getString("uid"), MediaType.SINAWEIBO.toString());
            } else if (stringExtra.equals(SocialConstants.ERROR_ACCESS_DENIED) || stringExtra.equals("OAuthAccessDeniedException")) {
                this.d.onCancel();
            } else {
                this.d.onError(new BaiduException(intent.getStringExtra("error_description")));
            }
        }
    }

    @Override // defpackage.b
    protected Intent c() {
        String clientId = SocialConfig.getInstance(this.f395a).getClientId(MediaType.SINAWEIBO);
        Intent intent = new Intent();
        intent.setClassName(this.e, this.f);
        intent.putExtra("appKey", clientId);
        intent.putExtra("redirectUri", "https://openapi.baidu.com/social/oauth/2.0/receiver");
        intent.putExtra(SocialConstants.PARAM_SCOPE, "email,direct_messages_write,direct_messages_read,friendships_groups_read,friendships_groups_write,statuses_to_me_read");
        return intent;
    }

    @Override // defpackage.b
    protected String d() {
        return "a23452bf0194000bdd87c6e0365a900b";
    }

    @Override // defpackage.b
    protected int e() {
        return 32973;
    }

    @Override // defpackage.cb
    public void f() {
        if (!SocialConfig.getInstance(this.f395a).getSsoMediaTypes().contains(MediaType.SINAWEIBO)) {
            g();
        } else if (h()) {
        } else {
            g();
        }
    }
}
