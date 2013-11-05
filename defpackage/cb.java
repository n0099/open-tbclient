package defpackage;

import android.content.Intent;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.common.http.RequestParams;
import com.baidu.cloudsdk.common.util.Utils;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.cloudsdk.social.oauth.SocialOAuthActivity;
import com.baidu.cloudsdk.social.oauth.SocialOAuthStatisticsManager;
import java.util.Random;
/* renamed from: cb  reason: default package */
/* loaded from: classes.dex */
public class cb {

    /* renamed from: a  reason: collision with root package name */
    protected SocialOAuthActivity f395a;
    protected String b;
    protected String c;
    protected IBaiduListener d;

    public cb(SocialOAuthActivity socialOAuthActivity, String str, String str2, IBaiduListener iBaiduListener) {
        this.f395a = socialOAuthActivity;
        this.b = str;
        this.c = str2;
        this.d = iBaiduListener;
    }

    private String b() {
        return Utils.md5(String.valueOf(new Random(System.currentTimeMillis()).nextInt()));
    }

    public void a() {
    }

    public void a(int i, int i2, Intent intent) {
    }

    public void f() {
        g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g() {
        RequestParams requestParams = new RequestParams();
        requestParams.put(SocialConstants.PARAM_CLIENT_ID, this.b);
        requestParams.put(SocialConstants.PARAM_CLIENT_TYPE, SocialConstants.ANDROID_CLIENT_TYPE);
        requestParams.put(SocialConstants.PARAM_MEDIA_TYPE, this.c);
        requestParams.put(SocialConstants.PARAM_REDIRECT_URI, SocialConstants.OOB_REDIRECT_URI);
        requestParams.put(SocialConstants.PARAM_RESPONSE_TYPE, SocialConstants.TOKEN_RESPONSE_TYPE);
        requestParams.put(SocialConstants.PARAM_DISPLAY, SocialConstants.MOBILE_DISPLAY);
        requestParams.put(SocialConstants.PARAM_SECURE, SocialConstants.TRUE);
        String b = b();
        requestParams.put(SocialConstants.PARAM_STATE, b);
        SocialOAuthStatisticsManager.getInstance(this.f395a).setCommonParams(requestParams);
        new bw(this.f395a, "https://openapi.baidu.com/social/oauth/2.0/authorize?" + requestParams.getQueryString(), b, this.d).show();
    }
}
