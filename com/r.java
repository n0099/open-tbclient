package com;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.cloudsdk.BaiduException;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.core.SocialConfig;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.cloudsdk.social.core.util.MobileQQ;
import com.baidu.cloudsdk.social.oauth.SocialOAuthActivity;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends x {
    public r(SocialOAuthActivity socialOAuthActivity, String str, IBaiduListener iBaiduListener) {
        super(socialOAuthActivity, str, MediaType.QZONE.toString(), iBaiduListener);
    }

    @Override // com.v
    public void a() {
        if (!SocialConfig.getInstance(this.a).getSsoMediaTypes().contains(MediaType.QZONE)) {
            f();
        } else if (g()) {
        } else {
            f();
        }
    }

    @Override // com.v
    public void a(int i, int i2, Intent intent) {
        if (i == d()) {
            if (i2 != -1 || intent == null) {
                if (i2 == 0) {
                    this.d.onCancel();
                } else {
                    this.d.onError(new BaiduException("qq sso returns unknown error"));
                }
            } else if (intent.getIntExtra(MobileQQ.KEY_ERROR_CODE, 0) != 0) {
                String stringExtra = intent.getStringExtra(MobileQQ.KEY_ERROR_MSG);
                this.d.onError(new BaiduException(stringExtra + ", " + intent.getStringExtra(MobileQQ.KEY_ERROR_DETAIL)));
            } else {
                String stringExtra2 = intent.getStringExtra(MobileQQ.KEY_RESPONSE);
                if (TextUtils.isEmpty(stringExtra2)) {
                    this.d.onError(new BaiduException("no response from qq sso"));
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(stringExtra2);
                    a(jSONObject.getString("access_token"), jSONObject.getString("openid"), MediaType.QZONE.toString());
                } catch (JSONException e) {
                    this.d.onError(new BaiduException(e));
                }
            }
        }
    }

    @Override // com.x
    protected Intent b() {
        String clientId = SocialConfig.getInstance(this.a).getClientId(MediaType.QZONE);
        Bundle bundle = new Bundle();
        bundle.putString("need_pay", SocialConstants.TRUE);
        bundle.putString(MobileQQ.PARAM_PF, MobileQQ.DEFAULT_PF);
        bundle.putString(SocialConstants.PARAM_CLIENT_ID, clientId);
        bundle.putString(SocialConstants.PARAM_SCOPE, "get_user_info,get_simple_userinfo,get_user_profile,get_app_friends,add_share,add_topic,list_album,upload_pic,add_album,set_user_face,get_vip_info,get_vip_rich_info,get_intimate_friends_weibo,match_nick_tips_weibo");
        Intent intent = new Intent();
        intent.setClassName(MobileQQ.PACKAGE_NAME, MobileQQ.SSO_ACTIVITY_NAME);
        intent.putExtra(MobileQQ.KEY_REQUEST_CODE, d());
        intent.putExtra(MobileQQ.KEY_ACTION, "action_login");
        intent.putExtra(MobileQQ.KEY_PARAMS, bundle);
        return intent;
    }

    @Override // com.x
    protected String c() {
        return MobileQQ.SIGNATURE_HASH;
    }

    @Override // com.x
    protected int d() {
        return 5657;
    }
}
