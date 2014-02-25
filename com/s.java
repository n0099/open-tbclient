package com;

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
import com.baidu.sapi2.SapiAccountManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends x {
    private String f;
    private String g;
    private ServiceConnection h;

    public s(SocialOAuthActivity socialOAuthActivity, String str, IBaiduListener iBaiduListener) {
        super(socialOAuthActivity, str, MediaType.SINAWEIBO.toString(), iBaiduListener);
        this.h = new t(this);
    }

    private boolean h() {
        Context applicationContext = this.a.getApplicationContext();
        Intent intent = new Intent("com.sina.weibo.remotessoservice");
        if (applicationContext.getPackageManager().resolveService(intent, 0) != null) {
            return applicationContext.getApplicationContext().bindService(intent, this.h, 1);
        }
        return false;
    }

    @Override // com.v
    public void a() {
        if (!SocialConfig.getInstance(this.a).getSsoMediaTypes().contains(MediaType.SINAWEIBO)) {
            f();
        } else if (h()) {
        } else {
            f();
        }
    }

    @Override // com.v
    public void a(int i, int i2, Intent intent) {
        if (i == d()) {
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
                a(extras.getString("access_token"), extras.getString(SapiAccountManager.SESSION_UID), MediaType.SINAWEIBO.toString());
            } else if (stringExtra.equals(SocialConstants.ERROR_ACCESS_DENIED) || stringExtra.equals("OAuthAccessDeniedException")) {
                this.d.onCancel();
            } else {
                this.d.onError(new BaiduException(intent.getStringExtra("error_description")));
            }
        }
    }

    @Override // com.x
    protected Intent b() {
        String clientId = SocialConfig.getInstance(this.a).getClientId(MediaType.SINAWEIBO);
        Intent intent = new Intent();
        intent.setClassName(this.f, this.g);
        intent.putExtra("appKey", clientId);
        intent.putExtra("redirectUri", "https://openapi.baidu.com/social/oauth/2.0/receiver");
        intent.putExtra(SocialConstants.PARAM_SCOPE, "email,direct_messages_write,direct_messages_read,friendships_groups_read,friendships_groups_write,statuses_to_me_read");
        return intent;
    }

    @Override // com.x
    protected String c() {
        return "a23452bf0194000bdd87c6e0365a900b";
    }

    @Override // com.x
    protected int d() {
        return 32973;
    }
}
