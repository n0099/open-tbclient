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
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.BuildConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.auth.c;
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
/* loaded from: classes6.dex */
public class Tencent {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int REQUEST_LOGIN = 10001;

    /* renamed from: b  reason: collision with root package name */
    public static Tencent f39045b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final c f39046a;

    public Tencent(String str, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f39046a = c.a(str, context);
    }

    public static boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
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
        return invokeLL.booleanValue;
    }

    public static synchronized Tencent createInstance(String str, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, context)) == null) {
            synchronized (Tencent.class) {
                e.a(context.getApplicationContext());
                f.c("openSDK_LOG.Tencent", "createInstance()  -- start, appId = " + str);
                if (f39045b == null) {
                    f39045b = new Tencent(str, context);
                } else if (!str.equals(f39045b.getAppId())) {
                    f39045b.logout(context);
                    f39045b = new Tencent(str, context);
                }
                if (a(context, str)) {
                    com.tencent.open.utils.f.a(context, str);
                    f.c("openSDK_LOG.Tencent", "createInstance()  -- end");
                    return f39045b;
                }
                return null;
            }
        }
        return (Tencent) invokeLL.objValue;
    }

    public static void handleResultData(Intent intent, IUiListener iUiListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, intent, iUiListener) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("handleResultData() data = null ? ");
            sb.append(intent == null);
            sb.append(", listener = null ? ");
            sb.append(iUiListener == null);
            f.c("openSDK_LOG.Tencent", sb.toString());
            UIListenerManager.getInstance().handleDataToListener(intent, iUiListener);
        }
    }

    public static boolean onActivityResultData(int i2, int i3, Intent intent, IUiListener iUiListener) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), intent, iUiListener})) == null) {
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
        return invokeCommon.booleanValue;
    }

    public int ask(Activity activity, Bundle bundle, IUiListener iUiListener) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, activity, bundle, iUiListener)) == null) {
            f.c("openSDK_LOG.Tencent", "ask()");
            new SocialApi(this.f39046a.b()).ask(activity, bundle, iUiListener);
            return 0;
        }
        return invokeLLL.intValue;
    }

    public void bindQQGroup(Activity activity, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, bundle) == null) {
            new SocialOperation(getQQToken()).bindQQGroup(activity, bundle);
        }
    }

    public void checkLogin(IUiListener iUiListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iUiListener) == null) {
            f.c("openSDK_LOG.Tencent", "checkLogin()");
            this.f39046a.a(iUiListener);
        }
    }

    public boolean checkSessionValid(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            JSONObject loadSession = this.f39046a.b().loadSession(str);
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
        return invokeL.booleanValue;
    }

    public String getAccessToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f39046a.b().getAccessToken() : (String) invokeV.objValue;
    }

    public String getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f39046a.b().getAppId() : (String) invokeV.objValue;
    }

    public long getExpiresIn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f39046a.b().getExpireTimeInSecond() : invokeV.longValue;
    }

    public String getOpenId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f39046a.b().getOpenId() : (String) invokeV.objValue;
    }

    public QQToken getQQToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f39046a.b() : (QQToken) invokeV.objValue;
    }

    public int gift(Activity activity, Bundle bundle, IUiListener iUiListener) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, activity, bundle, iUiListener)) == null) {
            f.c("openSDK_LOG.Tencent", "gift()");
            new SocialApi(this.f39046a.b()).gift(activity, bundle, iUiListener);
            return 0;
        }
        return invokeLLL.intValue;
    }

    @Deprecated
    public void handleLoginData(Intent intent, IUiListener iUiListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, intent, iUiListener) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("handleLoginData() data = null ? ");
            sb.append(intent == null);
            sb.append(", listener = null ? ");
            sb.append(iUiListener == null);
            f.c("openSDK_LOG.Tencent", sb.toString());
            UIListenerManager.getInstance().handleDataToListener(intent, iUiListener);
        }
    }

    public void initSessionCache(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, jSONObject) == null) {
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
    }

    public int invite(Activity activity, Bundle bundle, IUiListener iUiListener) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048588, this, activity, bundle, iUiListener)) == null) {
            f.c("openSDK_LOG.Tencent", "invite()");
            new SocialApi(this.f39046a.b()).invite(activity, bundle, iUiListener);
            return 0;
        }
        return invokeLLL.intValue;
    }

    public boolean isQQInstalled(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, context)) == null) {
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
        return invokeL.booleanValue;
    }

    public boolean isReady() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? isSessionValid() && getOpenId() != null : invokeV.booleanValue;
    }

    public boolean isSessionValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f39046a.c() : invokeV.booleanValue;
    }

    public boolean isSupportSSOLogin(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, activity)) == null) ? (j.d(activity) && h.a(activity, com.tencent.connect.common.Constants.PACKAGE_QQ_PAD) != null) || h.c(activity, BuildConfig.VERSION_NAME) >= 0 || h.d(activity, "1.1") >= 0 : invokeL.booleanValue;
    }

    public boolean joinQQGroup(Activity activity, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, activity, str)) == null) {
            f.c("openSDK_LOG.Tencent", "joinQQGroup()");
            Intent intent = new Intent();
            String openId = this.f39046a.b().getOpenId();
            String appId = this.f39046a.b().getAppId();
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
                d.a().a(this.f39046a.b().getOpenId(), this.f39046a.b().getAppId(), com.tencent.connect.common.Constants.VIA_JOIN_GROUP, "13", "18", "0");
                return true;
            } catch (Exception unused) {
                d.a().a(this.f39046a.b().getOpenId(), this.f39046a.b().getAppId(), com.tencent.connect.common.Constants.VIA_JOIN_GROUP, "13", "18", "1");
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public JSONObject loadSession(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) ? this.f39046a.b().loadSession(str) : (JSONObject) invokeL.objValue;
    }

    public int login(Activity activity, String str, IUiListener iUiListener) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048595, this, activity, str, iUiListener)) == null) {
            f.c("openSDK_LOG.Tencent", "login() with activity, scope is " + str);
            return this.f39046a.a(activity, str, iUiListener);
        }
        return invokeLLL.intValue;
    }

    public int loginServerSide(Activity activity, String str, IUiListener iUiListener) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048597, this, activity, str, iUiListener)) == null) {
            f.c("openSDK_LOG.Tencent", "loginServerSide() with activity, scope = " + str + ",server_side");
            c cVar = this.f39046a;
            return cVar.a(activity, str + ",server_side", iUiListener);
        }
        return invokeLLL.intValue;
    }

    public int loginWithOEM(Activity activity, String str, IUiListener iUiListener, String str2, String str3, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{activity, str, iUiListener, str2, str3, str4})) == null) {
            f.c("openSDK_LOG.Tencent", "loginWithOEM() with activity, scope = " + str);
            return this.f39046a.a(activity, str, iUiListener, str2, str3, str4);
        }
        return invokeCommon.intValue;
    }

    public void logout(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, context) == null) {
            f.c("openSDK_LOG.Tencent", "logout()");
            this.f39046a.b().setAccessToken(null, "0");
            this.f39046a.b().setOpenId(null);
        }
    }

    public void makeFriend(Activity activity, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, activity, bundle) == null) {
            new SocialOperation(getQQToken()).makeFriend(activity, bundle);
        }
    }

    public boolean onActivityResult(int i2, int i3, Intent intent) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048602, this, i2, i3, intent)) == null) {
            f.c("openSDK_LOG.Tencent", "onActivityResult() deprecated, will do nothing");
            return false;
        }
        return invokeIIL.booleanValue;
    }

    public void publishToQzone(Activity activity, Bundle bundle, IUiListener iUiListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048603, this, activity, bundle, iUiListener) == null) {
            f.c("openSDK_LOG.Tencent", "publishToQzone()");
            new QzonePublish(activity, this.f39046a.b()).publishToQzone(activity, bundle, iUiListener);
        }
    }

    public int reAuth(Activity activity, String str, IUiListener iUiListener) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048604, this, activity, str, iUiListener)) == null) {
            f.c("openSDK_LOG.Tencent", "reAuth() with activity, scope = " + str);
            return this.f39046a.b(activity, str, iUiListener);
        }
        return invokeLLL.intValue;
    }

    public void releaseResource() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
        }
    }

    public void reportDAU() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            this.f39046a.a();
        }
    }

    public JSONObject request(String str, Bundle bundle, String str2) throws IOException, JSONException, HttpUtils.NetworkUnavailableException, HttpUtils.HttpStatusException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048607, this, str, bundle, str2)) == null) {
            f.c("openSDK_LOG.Tencent", "request()");
            return HttpUtils.request(this.f39046a.b(), e.a(), str, bundle, str2);
        }
        return (JSONObject) invokeLLL.objValue;
    }

    public void requestAsync(String str, Bundle bundle, String str2, IRequestListener iRequestListener, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048608, this, str, bundle, str2, iRequestListener, obj) == null) {
            f.c("openSDK_LOG.Tencent", "requestAsync()");
            HttpUtils.requestAsync(this.f39046a.b(), e.a(), str, bundle, str2, iRequestListener);
        }
    }

    public void saveSession(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, jSONObject) == null) {
            this.f39046a.b().saveSession(jSONObject);
        }
    }

    public void setAccessToken(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048610, this, str, str2) == null) {
            f.a("openSDK_LOG.Tencent", "setAccessToken(), expiresIn = " + str2 + "");
            this.f39046a.a(str, str2);
        }
    }

    public void setOpenId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            f.a("openSDK_LOG.Tencent", "setOpenId() --start");
            this.f39046a.a(e.a(), str);
            f.a("openSDK_LOG.Tencent", "setOpenId() --end");
        }
    }

    public void shareToQQ(Activity activity, Bundle bundle, IUiListener iUiListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048612, this, activity, bundle, iUiListener) == null) {
            f.c("openSDK_LOG.Tencent", "shareToQQ()");
            new QQShare(activity, this.f39046a.b()).shareToQQ(activity, bundle, iUiListener);
        }
    }

    public void shareToQzone(Activity activity, Bundle bundle, IUiListener iUiListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048613, this, activity, bundle, iUiListener) == null) {
            f.c("openSDK_LOG.Tencent", "shareToQzone()");
            new QzoneShare(activity, this.f39046a.b()).shareToQzone(activity, bundle, iUiListener);
        }
    }

    public int story(Activity activity, Bundle bundle, IUiListener iUiListener) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048614, this, activity, bundle, iUiListener)) == null) {
            f.c("openSDK_LOG.Tencent", "story()");
            new SocialApi(this.f39046a.b()).story(activity, bundle, iUiListener);
            return 0;
        }
        return invokeLLL.intValue;
    }

    public int login(Fragment fragment, String str, IUiListener iUiListener) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048596, this, fragment, str, iUiListener)) == null) {
            f.c("openSDK_LOG.Tencent", "login() with fragment, scope is " + str);
            return this.f39046a.a(fragment, str, iUiListener, "");
        }
        return invokeLLL.intValue;
    }

    public int loginServerSide(Fragment fragment, String str, IUiListener iUiListener) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048598, this, fragment, str, iUiListener)) == null) {
            f.c("openSDK_LOG.Tencent", "loginServerSide() with fragment, scope = " + str + ",server_side");
            c cVar = this.f39046a;
            return cVar.a(fragment, str + ",server_side", iUiListener, "");
        }
        return invokeLLL.intValue;
    }
}
