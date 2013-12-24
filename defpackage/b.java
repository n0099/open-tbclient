package defpackage;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import com.baidu.cloudsdk.BaiduAPIResponseHandler;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.common.http.AsyncHttpClient;
import com.baidu.cloudsdk.common.http.RequestParams;
import com.baidu.cloudsdk.common.util.Utils;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.cloudsdk.social.oauth.SocialOAuthActivity;
import com.baidu.cloudsdk.social.oauth.SocialOAuthStatisticsManager;
/* renamed from: b  reason: default package */
/* loaded from: classes.dex */
abstract class b extends cb {
    private AsyncHttpClient e;

    public b(SocialOAuthActivity socialOAuthActivity, String str, String str2, IBaiduListener iBaiduListener) {
        super(socialOAuthActivity, str, str2, iBaiduListener);
        this.e = new AsyncHttpClient();
    }

    @Override // defpackage.cb
    public void a() {
        this.e.cancelRequests(this.a, true);
        super.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, String str2, String str3) {
        RequestParams requestParams = new RequestParams();
        requestParams.put(SocialConstants.PARAM_GRANT_TYPE, "media_token");
        requestParams.put("media_token", str);
        requestParams.put(SocialConstants.PARAM_MEDIA_UID, str2);
        requestParams.put(SocialConstants.PARAM_MEDIA_TYPE, str3);
        requestParams.put(SocialConstants.PARAM_CLIENT_ID, this.b);
        requestParams.put(SocialConstants.PARAM_CLIENT_TYPE, SocialConstants.ANDROID_CLIENT_TYPE);
        SocialOAuthStatisticsManager.getInstance(this.a).setCommonParams(requestParams);
        this.e.post(this.a, "https://openapi.baidu.com/social/oauth/2.0/token", requestParams, new BaiduAPIResponseHandler("https://openapi.baidu.com/social/oauth/2.0/token", this.d));
    }

    protected boolean a(Intent intent, String str) {
        PackageManager packageManager = this.a.getPackageManager();
        ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
        if (resolveActivity == null) {
            return false;
        }
        try {
            Signature[] signatureArr = packageManager.getPackageInfo(resolveActivity.activityInfo.packageName, 64).signatures;
            for (Signature signature : signatureArr) {
                if (str.equals(Utils.md5(signature.toCharsString()))) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b() {
        Intent c = c();
        if (a(c, d())) {
            try {
                this.a.startActivityForResult(c, e());
                this.a.a();
                return true;
            } catch (ActivityNotFoundException e) {
                return false;
            }
        }
        return false;
    }

    protected abstract Intent c();

    protected abstract String d();

    protected abstract int e();
}
