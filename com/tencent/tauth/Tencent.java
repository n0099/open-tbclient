package com.tencent.tauth;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import androidx.fragment.app.Fragment;
import com.baidu.pass.main.facesdk.BuildConfig;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.auth.c;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.connect.share.QQShare;
import com.tencent.connect.share.QzonePublish;
import com.tencent.connect.share.QzoneShare;
import com.tencent.open.SocialApi;
import com.tencent.open.SocialOperation;
import com.tencent.open.a.f;
import com.tencent.open.b.d;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.e;
import com.tencent.open.utils.h;
import com.tencent.open.utils.j;
import java.io.IOException;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class Tencent {
    public static final int REQUEST_LOGIN = 10001;

    /* renamed from: b  reason: collision with root package name */
    public static Tencent f40288b;

    /* renamed from: a  reason: collision with root package name */
    public final c f40289a;

    public Tencent(String str, Context context) {
        this.f40289a = c.a(str, context);
    }

    public static boolean a(Context context, String str) {
        try {
            context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.tauth.AuthActivity"), 0);
            try {
                context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.connect.common.AssistActivity"), 0);
                return true;
            } catch (PackageManager.NameNotFoundException unused) {
                f.e("openSDK_LOG.Tencent", "AndroidManifest.xml 没有检测到com.tencent.connect.common.AssistActivity\n" + ("没有在AndroidManifest.xml中检测到com.tencent.connect.common.AssistActivity,请加上com.tencent.connect.common.AssistActivity,详细信息请查看官网文档.\n配置示例如下: \n<activity\n     android:name=\"com.tencent.connect.common.AssistActivity\"\n     android:screenOrientation=\"behind\"\n     android:theme=\"@android:style/Theme.Translucent.NoTitleBar\"\n     android:configChanges=\"orientation|keyboardHidden\">\n</activity>"));
                return false;
            }
        } catch (PackageManager.NameNotFoundException unused2) {
            f.e("openSDK_LOG.Tencent", "AndroidManifest.xml 没有检测到com.tencent.tauth.AuthActivity" + (("没有在AndroidManifest.xml中检测到com.tencent.tauth.AuthActivity,请加上com.tencent.tauth.AuthActivity,并配置<data android:scheme=\"tencent" + str + "\" />,详细信息请查看官网文档.") + "\n配置示例如下: \n<activity\n     android:name=\"com.tencent.tauth.AuthActivity\"\n     android:noHistory=\"true\"\n     android:launchMode=\"singleTask\">\n<intent-filter>\n    <action android:name=\"android.intent.action.VIEW\" />\n    <category android:name=\"android.intent.category.DEFAULT\" />\n    <category android:name=\"android.intent.category.BROWSABLE\" />\n    <data android:scheme=\"tencent" + str + "\" />\n</intent-filter>\n</activity>"));
            return false;
        }
    }

    public static synchronized Tencent createInstance(String str, Context context) {
        synchronized (Tencent.class) {
            e.a(context.getApplicationContext());
            f.c("openSDK_LOG.Tencent", "createInstance()  -- start, appId = " + str);
            if (f40288b == null) {
                f40288b = new Tencent(str, context);
            } else if (!str.equals(f40288b.getAppId())) {
                f40288b.logout(context);
                f40288b = new Tencent(str, context);
            }
            if (a(context, str)) {
                com.tencent.open.utils.f.a(context, str);
                f.c("openSDK_LOG.Tencent", "createInstance()  -- end");
                return f40288b;
            }
            return null;
        }
    }

    public static void handleResultData(Intent intent, IUiListener iUiListener) {
        StringBuilder sb = new StringBuilder();
        sb.append("handleResultData() data = null ? ");
        sb.append(intent == null);
        sb.append(", listener = null ? ");
        sb.append(iUiListener == null);
        f.c("openSDK_LOG.Tencent", sb.toString());
        UIListenerManager.getInstance().handleDataToListener(intent, iUiListener);
    }

    public static boolean onActivityResultData(int i2, int i3, Intent intent, IUiListener iUiListener) {
        StringBuilder sb = new StringBuilder();
        sb.append("onActivityResultData() reqcode = ");
        sb.append(i2);
        sb.append(", resultcode = ");
        sb.append(i3);
        sb.append(", data = null ? ");
        sb.append(intent == null);
        sb.append(", listener = null ? ");
        sb.append(iUiListener == null);
        f.c("openSDK_LOG.Tencent", sb.toString());
        return UIListenerManager.getInstance().onActivityResult(i2, i3, intent, iUiListener);
    }

    public int ask(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c("openSDK_LOG.Tencent", "ask()");
        new SocialApi(this.f40289a.b()).ask(activity, bundle, iUiListener);
        return 0;
    }

    public void bindQQGroup(Activity activity, Bundle bundle) {
        new SocialOperation(getQQToken()).bindQQGroup(activity, bundle);
    }

    public void checkLogin(IUiListener iUiListener) {
        f.c("openSDK_LOG.Tencent", "checkLogin()");
        this.f40289a.a(iUiListener);
    }

    public boolean checkSessionValid(String str) {
        JSONObject loadSession = this.f40289a.b().loadSession(str);
        if (loadSession != null && loadSession.length() != 0) {
            try {
                String string = loadSession.getString("access_token");
                String string2 = loadSession.getString("expires_in");
                String string3 = loadSession.getString("openid");
                String string4 = loadSession.getString("expires_time");
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3) && !TextUtils.isEmpty(string4)) {
                    if (System.currentTimeMillis() < Long.parseLong(string4)) {
                        return true;
                    }
                }
            } catch (Exception e2) {
                f.c("QQToken", "checkSessionValid " + e2.toString());
            }
        }
        return false;
    }

    public String getAccessToken() {
        return this.f40289a.b().getAccessToken();
    }

    public String getAppId() {
        return this.f40289a.b().getAppId();
    }

    public long getExpiresIn() {
        return this.f40289a.b().getExpireTimeInSecond();
    }

    public String getOpenId() {
        return this.f40289a.b().getOpenId();
    }

    public QQToken getQQToken() {
        return this.f40289a.b();
    }

    public int gift(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c("openSDK_LOG.Tencent", "gift()");
        new SocialApi(this.f40289a.b()).gift(activity, bundle, iUiListener);
        return 0;
    }

    @Deprecated
    public void handleLoginData(Intent intent, IUiListener iUiListener) {
        StringBuilder sb = new StringBuilder();
        sb.append("handleLoginData() data = null ? ");
        sb.append(intent == null);
        sb.append(", listener = null ? ");
        sb.append(iUiListener == null);
        f.c("openSDK_LOG.Tencent", sb.toString());
        UIListenerManager.getInstance().handleDataToListener(intent, iUiListener);
    }

    public void initSessionCache(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("access_token");
            String string2 = jSONObject.getString("expires_in");
            String string3 = jSONObject.getString("openid");
            if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || TextUtils.isEmpty(string3)) {
                return;
            }
            setAccessToken(string, string2);
            setOpenId(string3);
        } catch (Exception e2) {
            f.c("QQToken", "initSessionCache " + e2.toString());
        }
    }

    public int invite(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c("openSDK_LOG.Tencent", "invite()");
        new SocialApi(this.f40289a.b()).invite(activity, bundle, iUiListener);
        return 0;
    }

    public boolean isQQInstalled(Context context) {
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
        if (installedPackages != null) {
            for (int i2 = 0; i2 < installedPackages.size(); i2++) {
                if (installedPackages.get(i2).packageName.equals("com.tencent.mobileqq")) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isReady() {
        return isSessionValid() && getOpenId() != null;
    }

    public boolean isSessionValid() {
        return this.f40289a.c();
    }

    public boolean isSupportSSOLogin(Activity activity) {
        return (j.d(activity) && h.a(activity, Constants.PACKAGE_QQ_PAD) != null) || h.c(activity, BuildConfig.VERSION_NAME) >= 0 || h.d(activity, "1.1") >= 0;
    }

    public boolean joinQQGroup(Activity activity, String str) {
        f.c("openSDK_LOG.Tencent", "joinQQGroup()");
        Intent intent = new Intent();
        String openId = this.f40289a.b().getOpenId();
        String appId = this.f40289a.b().getAppId();
        StringBuffer stringBuffer = new StringBuffer("mqqopensdkapi://bizAgent/qm/qr?url=http%3A%2F%2Fqm.qq.com%2Fcgi-bin%2Fqm%2Fqr%3Ffrom%3Dapp%26p%3Dandroid%26k%3D" + str);
        if (!TextUtils.isEmpty(openId)) {
            stringBuffer.append("&openid=" + Base64.encodeToString(j.i(openId), 2));
        }
        if (!TextUtils.isEmpty(appId)) {
            stringBuffer.append("&appid=" + appId);
        }
        intent.setData(Uri.parse(stringBuffer.toString()));
        try {
            activity.startActivity(intent);
            d.a().a(this.f40289a.b().getOpenId(), this.f40289a.b().getAppId(), Constants.VIA_JOIN_GROUP, "13", "18", "0");
            return true;
        } catch (Exception unused) {
            d.a().a(this.f40289a.b().getOpenId(), this.f40289a.b().getAppId(), Constants.VIA_JOIN_GROUP, "13", "18", "1");
            return false;
        }
    }

    public JSONObject loadSession(String str) {
        return this.f40289a.b().loadSession(str);
    }

    public int login(Activity activity, String str, IUiListener iUiListener) {
        f.c("openSDK_LOG.Tencent", "login() with activity, scope is " + str);
        return this.f40289a.a(activity, str, iUiListener);
    }

    public int loginServerSide(Activity activity, String str, IUiListener iUiListener) {
        f.c("openSDK_LOG.Tencent", "loginServerSide() with activity, scope = " + str + ",server_side");
        c cVar = this.f40289a;
        return cVar.a(activity, str + ",server_side", iUiListener);
    }

    public int loginWithOEM(Activity activity, String str, IUiListener iUiListener, String str2, String str3, String str4) {
        f.c("openSDK_LOG.Tencent", "loginWithOEM() with activity, scope = " + str);
        return this.f40289a.a(activity, str, iUiListener, str2, str3, str4);
    }

    public void logout(Context context) {
        f.c("openSDK_LOG.Tencent", "logout()");
        this.f40289a.b().setAccessToken(null, "0");
        this.f40289a.b().setOpenId(null);
    }

    public void makeFriend(Activity activity, Bundle bundle) {
        new SocialOperation(getQQToken()).makeFriend(activity, bundle);
    }

    public boolean onActivityResult(int i2, int i3, Intent intent) {
        f.c("openSDK_LOG.Tencent", "onActivityResult() deprecated, will do nothing");
        return false;
    }

    public void publishToQzone(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c("openSDK_LOG.Tencent", "publishToQzone()");
        new QzonePublish(activity, this.f40289a.b()).publishToQzone(activity, bundle, iUiListener);
    }

    public int reAuth(Activity activity, String str, IUiListener iUiListener) {
        f.c("openSDK_LOG.Tencent", "reAuth() with activity, scope = " + str);
        return this.f40289a.b(activity, str, iUiListener);
    }

    public void releaseResource() {
    }

    public void reportDAU() {
        this.f40289a.a();
    }

    public JSONObject request(String str, Bundle bundle, String str2) throws IOException, JSONException, HttpUtils.NetworkUnavailableException, HttpUtils.HttpStatusException {
        f.c("openSDK_LOG.Tencent", "request()");
        return HttpUtils.request(this.f40289a.b(), e.a(), str, bundle, str2);
    }

    public void requestAsync(String str, Bundle bundle, String str2, IRequestListener iRequestListener, Object obj) {
        f.c("openSDK_LOG.Tencent", "requestAsync()");
        HttpUtils.requestAsync(this.f40289a.b(), e.a(), str, bundle, str2, iRequestListener);
    }

    public void saveSession(JSONObject jSONObject) {
        this.f40289a.b().saveSession(jSONObject);
    }

    public void setAccessToken(String str, String str2) {
        f.a("openSDK_LOG.Tencent", "setAccessToken(), expiresIn = " + str2 + "");
        this.f40289a.a(str, str2);
    }

    public void setOpenId(String str) {
        f.a("openSDK_LOG.Tencent", "setOpenId() --start");
        this.f40289a.a(e.a(), str);
        f.a("openSDK_LOG.Tencent", "setOpenId() --end");
    }

    public void shareToQQ(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c("openSDK_LOG.Tencent", "shareToQQ()");
        new QQShare(activity, this.f40289a.b()).shareToQQ(activity, bundle, iUiListener);
    }

    public void shareToQzone(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c("openSDK_LOG.Tencent", "shareToQzone()");
        new QzoneShare(activity, this.f40289a.b()).shareToQzone(activity, bundle, iUiListener);
    }

    public int story(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c("openSDK_LOG.Tencent", "story()");
        new SocialApi(this.f40289a.b()).story(activity, bundle, iUiListener);
        return 0;
    }

    public int login(Fragment fragment, String str, IUiListener iUiListener) {
        f.c("openSDK_LOG.Tencent", "login() with fragment, scope is " + str);
        return this.f40289a.a(fragment, str, iUiListener, "");
    }

    public int loginServerSide(Fragment fragment, String str, IUiListener iUiListener) {
        f.c("openSDK_LOG.Tencent", "loginServerSide() with fragment, scope = " + str + ",server_side");
        c cVar = this.f40289a;
        return cVar.a(fragment, str + ",server_side", iUiListener, "");
    }
}
