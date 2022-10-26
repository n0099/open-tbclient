package com.tencent.tauth;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import com.baidu.pass.main.facesdk.BuildConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.auth.c;
import com.tencent.connect.avatar.QQAvatar;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.connect.emotion.QQEmotion;
import com.tencent.connect.share.QQShare;
import com.tencent.connect.share.QzonePublish;
import com.tencent.connect.share.QzoneShare;
import com.tencent.open.im.IM;
import com.tencent.open.log.SLog;
import com.tencent.open.log.Tracer;
import com.tencent.open.miniapp.MiniApp;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.f;
import com.tencent.open.utils.g;
import com.tencent.open.utils.i;
import com.tencent.open.utils.l;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class Tencent {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int REQUEST_LOGIN = 10001;
    public static Tencent c;
    public transient /* synthetic */ FieldHolder $fh;
    public final c a;
    public String b;

    public void releaseResource() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
        }
    }

    public Tencent(String str, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = c.a(str, context);
    }

    public static void handleResultData(Intent intent, IUiListener iUiListener) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, intent, iUiListener) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("handleResultData() data = null ? ");
            boolean z2 = true;
            if (intent == null) {
                z = true;
            } else {
                z = false;
            }
            sb.append(z);
            sb.append(", listener = null ? ");
            if (iUiListener != null) {
                z2 = false;
            }
            sb.append(z2);
            SLog.i("openSDK_LOG.Tencent", sb.toString());
            UIListenerManager.getInstance().handleDataToListener(intent, iUiListener);
        }
    }

    @Deprecated
    public void handleLoginData(Intent intent, IUiListener iUiListener) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, intent, iUiListener) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("handleLoginData() data = null ? ");
            boolean z2 = true;
            if (intent == null) {
                z = true;
            } else {
                z = false;
            }
            sb.append(z);
            sb.append(", listener = null ? ");
            if (iUiListener != null) {
                z2 = false;
            }
            sb.append(z2);
            SLog.i("openSDK_LOG.Tencent", sb.toString());
            UIListenerManager.getInstance().handleDataToListener(intent, iUiListener);
        }
    }

    public static boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            try {
                context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.tauth.AuthActivity"), 128);
                try {
                    context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.connect.common.AssistActivity"), 128);
                    return true;
                } catch (PackageManager.NameNotFoundException unused) {
                    SLog.e("openSDK_LOG.Tencent", "AndroidManifest.xml 没有检测到com.tencent.connect.common.AssistActivity\n" + ("没有在AndroidManifest.xml中检测到com.tencent.connect.common.AssistActivity,请加上com.tencent.connect.common.AssistActivity,详细信息请查看官网文档.\n配置示例如下: \n<activity\n     android:name=\"com.tencent.connect.common.AssistActivity\"\n     android:screenOrientation=\"behind\"\n     android:theme=\"@android:style/Theme.Translucent.NoTitleBar\"\n     android:configChanges=\"orientation|keyboardHidden\">\n</activity>"));
                    return false;
                }
            } catch (PackageManager.NameNotFoundException unused2) {
                SLog.e("openSDK_LOG.Tencent", "AndroidManifest.xml 没有检测到com.tencent.tauth.AuthActivity" + (("没有在AndroidManifest.xml中检测到com.tencent.tauth.AuthActivity,请加上com.tencent.tauth.AuthActivity,并配置<data android:scheme=\"tencent" + str + "\" />,详细信息请查看官网文档.") + "\n配置示例如下: \n<activity\n     android:name=\"com.tencent.tauth.AuthActivity\"\n     android:noHistory=\"true\"\n     android:launchMode=\"singleTask\">\n<intent-filter>\n    <action android:name=\"android.intent.action.VIEW\" />\n    <category android:name=\"android.intent.category.DEFAULT\" />\n    <category android:name=\"android.intent.category.BROWSABLE\" />\n    <data android:scheme=\"tencent" + str + "\" />\n</intent-filter>\n</activity>"));
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
                f.a(context.getApplicationContext());
                SLog.i("openSDK_LOG.Tencent", "createInstance()  -- start, appId = " + str);
                if (TextUtils.isEmpty(str)) {
                    SLog.e("openSDK_LOG.Tencent", "appId should not be empty!");
                    return null;
                }
                if (c == null) {
                    c = new Tencent(str, context);
                } else if (!str.equals(c.getAppId())) {
                    c.logout(context);
                    c = new Tencent(str, context);
                }
                if (!a(context, str)) {
                    return null;
                }
                g.a(context, str);
                SLog.i("openSDK_LOG.Tencent", "createInstance()  -- end");
                return c;
            }
        }
        return (Tencent) invokeLL.objValue;
    }

    public static synchronized Tencent createInstance(String str, Context context, String str2) {
        InterceptResult invokeLLL;
        Tencent createInstance;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, str, context, str2)) == null) {
            synchronized (Tencent.class) {
                createInstance = createInstance(str, context);
                SLog.i("openSDK_LOG.Tencent", "createInstance()  -- start, appId = " + str + ", authorities=" + str2);
                if (createInstance != null) {
                    createInstance.b = str2;
                } else {
                    SLog.i("openSDK_LOG.Tencent", "null == tencent set mAuthorities fail");
                }
            }
            return createInstance;
        }
        return (Tencent) invokeLLL.objValue;
    }

    public static synchronized String getAuthorities(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            synchronized (Tencent.class) {
                if (TextUtils.isEmpty(str)) {
                    SLog.i("openSDK_LOG.Tencent", "TextUtils.isEmpty(appId)");
                    return null;
                } else if (c == null) {
                    SLog.i("openSDK_LOG.Tencent", "sInstance == null");
                    return null;
                } else {
                    if (str.equals(c.getAppId())) {
                        str2 = c.b;
                    } else {
                        str2 = "";
                    }
                    return str2;
                }
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean isSupportShareToQQ(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            SLog.i("openSDK_LOG.Tencent", "isSupportShareToQQ()");
            boolean z = true;
            if (l.c(context) && i.a(context, Constants.PACKAGE_QQ_PAD) != null) {
                return true;
            }
            if (i.c(context, BuildConfig.VERSION_NAME) < 0 && i.a(context, Constants.PACKAGE_TIM) == null && i.a(context, Constants.PACKAGE_QQ_SPEED) == null) {
                z = false;
            }
            SLog.i("openSDK_LOG.Tencent", "isSupportShareToQQ() support=" + z);
            return z;
        }
        return invokeL.booleanValue;
    }

    public void initSessionCache(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jSONObject) == null) {
            try {
                String string = jSONObject.getString("access_token");
                String string2 = jSONObject.getString("expires_in");
                String string3 = jSONObject.getString("openid");
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3)) {
                    setAccessToken(string, string2);
                    setOpenId(string3);
                }
                SLog.i("openSDK_LOG.Tencent", "initSessionCache()");
            } catch (Exception e) {
                SLog.i("QQToken", "initSessionCache " + e.toString());
            }
        }
    }

    public boolean isSupportSSOLogin(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, activity)) == null) {
            SLog.i("openSDK_LOG.Tencent", "isSupportSSOLogin()");
            boolean z = true;
            if (l.c(activity) && i.a((Context) activity, Constants.PACKAGE_QQ_PAD) != null) {
                return true;
            }
            if (i.c(activity, BuildConfig.VERSION_NAME) < 0 && i.d(activity, "1.1") < 0 && i.e(activity, "4.0.0") < 0) {
                z = false;
            }
            SLog.i("openSDK_LOG.Tencent", "isSupportSSOLogin() support=" + z);
            return z;
        }
        return invokeL.booleanValue;
    }

    public static boolean isSupportPushToQZone(Context context) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            if (i.c(context, "5.9.5") < 0 && i.a(context, Constants.PACKAGE_QQ_SPEED) == null) {
                z = false;
            } else {
                z = true;
            }
            SLog.i("openSDK_LOG.Tencent", "isSupportPushToQZone() support=" + z);
            return z;
        }
        return invokeL.booleanValue;
    }

    public JSONObject loadSession(String str) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            JSONObject loadSession = this.a.b().loadSession(str);
            StringBuilder sb = new StringBuilder();
            sb.append("loadSession() appid ");
            sb.append(str);
            sb.append(", length=");
            if (loadSession != null) {
                i = loadSession.length();
            } else {
                i = 0;
            }
            sb.append(i);
            SLog.i("openSDK_LOG.Tencent", sb.toString());
            return loadSession;
        }
        return (JSONObject) invokeL.objValue;
    }

    public void logout(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, context) == null) {
            SLog.i("openSDK_LOG.Tencent", "logout()");
            this.a.b().setAccessToken(null, "0");
            this.a.b().setOpenId(null);
            this.a.b().removeSession(this.a.b().getAppId());
        }
    }

    public void saveSession(JSONObject jSONObject) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, jSONObject) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("saveSession() length=");
            if (jSONObject != null) {
                i = jSONObject.length();
            } else {
                i = 0;
            }
            sb.append(i);
            SLog.i("openSDK_LOG.Tencent", sb.toString());
            this.a.b().saveSession(jSONObject);
        }
    }

    public static boolean onActivityResultData(int i, int i2, Intent intent, IUiListener iUiListener) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), intent, iUiListener})) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("onActivityResultData() reqcode = ");
            sb.append(i);
            sb.append(", resultcode = ");
            sb.append(i2);
            sb.append(", data = null ? ");
            boolean z2 = true;
            if (intent == null) {
                z = true;
            } else {
                z = false;
            }
            sb.append(z);
            sb.append(", listener = null ? ");
            if (iUiListener != null) {
                z2 = false;
            }
            sb.append(z2);
            SLog.i("openSDK_LOG.Tencent", sb.toString());
            return UIListenerManager.getInstance().onActivityResult(i, i2, intent, iUiListener);
        }
        return invokeCommon.booleanValue;
    }

    public static Map parseMiniParameters(Intent intent) {
        InterceptResult invokeL;
        String stringExtra;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, intent)) == null) {
            HashMap hashMap = new HashMap();
            if (intent == null) {
                SLog.e("openSDK_LOG.Tencent", "parseMiniParameters null == intent");
                return hashMap;
            }
            try {
                stringExtra = intent.getStringExtra("appParameter");
            } catch (Exception e) {
                SLog.e("openSDK_LOG.Tencent", "parseMiniParameters Exception", e);
            }
            if (!TextUtils.isEmpty(stringExtra)) {
                SLog.d("openSDK_LOG.Tencent", "parseMiniParameters appParameter=" + stringExtra);
                JSONObject jSONObject = new JSONObject(stringExtra);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.getString(next));
                }
                return hashMap;
            }
            Uri data = intent.getData();
            if (data == null) {
                SLog.d("openSDK_LOG.Tencent", "parseMiniParameters uri==null");
                return hashMap;
            }
            String uri = data.toString();
            if (TextUtils.isEmpty(uri)) {
                SLog.d("openSDK_LOG.Tencent", "parseMiniParameters uriStr isEmpty");
                return hashMap;
            }
            String substring = uri.substring(uri.lastIndexOf(63) + 1);
            if (TextUtils.isEmpty(substring)) {
                SLog.d("openSDK_LOG.Tencent", "parseMiniParameters uriParam is empty");
                return hashMap;
            }
            SLog.d("openSDK_LOG.Tencent", "parseMiniParameters uriParam=" + substring);
            for (String str : substring.split("&")) {
                String[] split = str.split("=");
                if (split.length == 2) {
                    hashMap.put(split[0], split[1]);
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static void setCustomLogger(Tracer tracer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, tracer) == null) {
            SLog.i("openSDK_LOG.Tencent", "setCustomLogger");
            SLog.getInstance().setCustomLogger(tracer);
        }
    }

    public void checkLogin(IUiListener iUiListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iUiListener) == null) {
            SLog.i("openSDK_LOG.Tencent", "checkLogin()");
            this.a.a(iUiListener);
        }
    }

    public boolean isQQInstalled(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context)) == null) {
            boolean b = i.b(context);
            SLog.i("openSDK_LOG.Tencent", "isQQInstalled() installed=" + b);
            return b;
        }
        return invokeL.booleanValue;
    }

    public void setOpenId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            SLog.i("openSDK_LOG.Tencent", "setOpenId() --start");
            this.a.b(f.a(), str);
            SLog.i("openSDK_LOG.Tencent", "setOpenId() --end");
        }
    }

    public String getAccessToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String accessToken = this.a.b().getAccessToken();
            SLog.i("openSDK_LOG.Tencent", "getAccessToken() accessToken = " + accessToken);
            return accessToken;
        }
        return (String) invokeV.objValue;
    }

    public String getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String appId = this.a.b().getAppId();
            SLog.i("openSDK_LOG.Tencent", "getAppId() appid =" + appId);
            return appId;
        }
        return (String) invokeV.objValue;
    }

    public String getOpenId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            String openId = this.a.b().getOpenId();
            SLog.i("openSDK_LOG.Tencent", "getOpenId() openid= " + openId);
            return openId;
        }
        return (String) invokeV.objValue;
    }

    public boolean isReady() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (isSessionValid() && getOpenId() != null) {
                z = true;
            } else {
                z = false;
            }
            SLog.i("openSDK_LOG.Tencent", "isReady() --ready=" + z);
            return z;
        }
        return invokeV.booleanValue;
    }

    public long getExpiresIn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            long expireTimeInSecond = this.a.b().getExpireTimeInSecond();
            SLog.i("openSDK_LOG.Tencent", "getExpiresIn() expiresin= " + expireTimeInSecond);
            return expireTimeInSecond;
        }
        return invokeV.longValue;
    }

    public QQToken getQQToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            SLog.i("openSDK_LOG.Tencent", "getQQToken()");
            return this.a.b();
        }
        return (QQToken) invokeV.objValue;
    }

    public boolean isSessionValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            boolean c2 = this.a.c();
            SLog.i("openSDK_LOG.Tencent", "isSessionValid() isvalid =" + c2);
            return c2;
        }
        return invokeV.booleanValue;
    }

    public void reportDAU() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            SLog.i("openSDK_LOG.Tencent", "reportDAU() ");
            this.a.a();
        }
    }

    public int login(Activity activity, IUiListener iUiListener, Map map) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, activity, iUiListener, map)) == null) {
            SLog.i("openSDK_LOG.Tencent", "login activity with params");
            return this.a.a(activity, iUiListener, map);
        }
        return invokeLLL.intValue;
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048598, this, i, i2, intent)) == null) {
            SLog.i("openSDK_LOG.Tencent", "onActivityResult() deprecated, will do nothing");
            return false;
        }
        return invokeIIL.booleanValue;
    }

    public void publishToQzone(Activity activity, Bundle bundle, IUiListener iUiListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048599, this, activity, bundle, iUiListener) == null) {
            SLog.i("openSDK_LOG.Tencent", "publishToQzone()");
            new QzonePublish(activity, this.a.b()).publishToQzone(activity, bundle, iUiListener);
        }
    }

    public int reAuth(Activity activity, String str, IUiListener iUiListener) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048600, this, activity, str, iUiListener)) == null) {
            SLog.i("openSDK_LOG.Tencent", "reAuth() with activity, scope = " + str);
            return this.a.b(activity, str, iUiListener);
        }
        return invokeLLL.intValue;
    }

    public JSONObject request(String str, Bundle bundle, String str2) throws IOException, JSONException, HttpUtils.NetworkUnavailableException, HttpUtils.HttpStatusException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048603, this, str, bundle, str2)) == null) {
            SLog.i("openSDK_LOG.Tencent", "request()");
            return HttpUtils.request(this.a.b(), f.a(), str, bundle, str2);
        }
        return (JSONObject) invokeLLL.objValue;
    }

    public void setAvatarByQQ(Activity activity, Uri uri, IUiListener iUiListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048609, this, activity, uri, iUiListener) == null) {
            SLog.i("openSDK_LOG.Tencent", "setAvatarByQQ()");
            new QQAvatar(this.a.b()).setAvatarByQQ(activity, uri, iUiListener);
        }
    }

    public void setDynamicAvatar(Activity activity, Uri uri, IUiListener iUiListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048610, this, activity, uri, iUiListener) == null) {
            SLog.i("openSDK_LOG.Tencent", "setDynamicAvatar()");
            new QQAvatar(this.a.b()).setDynamicAvatar(activity, uri, iUiListener);
        }
    }

    public void setEmotions(Activity activity, ArrayList arrayList, IUiListener iUiListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048611, this, activity, arrayList, iUiListener) == null) {
            SLog.i("openSDK_LOG.Tencent", "saveQQEmotions()");
            new QQEmotion(this.a.b()).setEmotions(activity, arrayList, iUiListener);
        }
    }

    public void shareToQQ(Activity activity, Bundle bundle, IUiListener iUiListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048613, this, activity, bundle, iUiListener) == null) {
            SLog.i("openSDK_LOG.Tencent", "shareToQQ()");
            if (TextUtils.isEmpty(this.b)) {
                iUiListener.onWarning(-19);
            }
            new QQShare(activity, this.a.b()).shareToQQ(activity, bundle, iUiListener);
        }
    }

    public void shareToQzone(Activity activity, Bundle bundle, IUiListener iUiListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048614, this, activity, bundle, iUiListener) == null) {
            SLog.i("openSDK_LOG.Tencent", "shareToQzone()");
            new QzoneShare(activity, this.a.b()).shareToQzone(activity, bundle, iUiListener);
        }
    }

    public int startIMAio(Activity activity, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048615, this, activity, str, str2)) == null) {
            SLog.i("openSDK_LOG.Tencent", "startIMAio()");
            return startIMConversation(activity, IM.CHAT_TYPE_AIO, str, str2);
        }
        return invokeLLL.intValue;
    }

    public int startIMAudio(Activity activity, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048616, this, activity, str, str2)) == null) {
            SLog.i("openSDK_LOG.Tencent", "startIMAudio()");
            return startIMConversation(activity, IM.CHAT_TYPE_AUDIO_CHAT, str, str2);
        }
        return invokeLLL.intValue;
    }

    public int startIMVideo(Activity activity, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048618, this, activity, str, str2)) == null) {
            SLog.i("openSDK_LOG.Tencent", "startIMVideo()");
            return startIMConversation(activity, IM.CHAT_TYPE_VIDEO_CHAT, str, str2);
        }
        return invokeLLL.intValue;
    }

    public int login(Activity activity, String str, IUiListener iUiListener) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, activity, str, iUiListener)) == null) {
            SLog.i("openSDK_LOG.Tencent", "login() with activity, scope is " + str);
            return this.a.a(activity, str, iUiListener);
        }
        return invokeLLL.intValue;
    }

    public int login(Activity activity, String str, IUiListener iUiListener, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{activity, str, iUiListener, Boolean.valueOf(z)})) == null) {
            SLog.i("openSDK_LOG.Tencent", "login() with activity, scope is " + str);
            return this.a.a(activity, str, iUiListener, z);
        }
        return invokeCommon.intValue;
    }

    public int login(Fragment fragment, String str, IUiListener iUiListener) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048592, this, fragment, str, iUiListener)) == null) {
            SLog.i("openSDK_LOG.Tencent", "login() with fragment, scope is " + str);
            return this.a.a(fragment, str, iUiListener, "");
        }
        return invokeLLL.intValue;
    }

    public int login(Fragment fragment, String str, IUiListener iUiListener, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{fragment, str, iUiListener, Boolean.valueOf(z)})) == null) {
            SLog.i("openSDK_LOG.Tencent", "login() with fragment, scope is " + str);
            return this.a.a(fragment, str, iUiListener, "", z);
        }
        return invokeCommon.intValue;
    }

    public int loginServerSide(Activity activity, String str, IUiListener iUiListener) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, activity, str, iUiListener)) == null) {
            SLog.i("openSDK_LOG.Tencent", "loginServerSide() with activity, scope = " + str + ",server_side");
            c cVar = this.a;
            return cVar.a(activity, str + ",server_side", iUiListener);
        }
        return invokeLLL.intValue;
    }

    public void setAvatar(Activity activity, Bundle bundle, IUiListener iUiListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048607, this, activity, bundle, iUiListener) == null) {
            SLog.i("openSDK_LOG.Tencent", "setAvatar()");
            String string = bundle.getString("picture");
            new QQAvatar(this.a.b()).setAvatar(activity, Uri.parse(string), iUiListener, bundle.getInt("exitAnim"));
        }
    }

    public int loginServerSide(Fragment fragment, String str, IUiListener iUiListener) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048595, this, fragment, str, iUiListener)) == null) {
            SLog.i("openSDK_LOG.Tencent", "loginServerSide() with fragment, scope = " + str + ",server_side");
            c cVar = this.a;
            return cVar.a(fragment, str + ",server_side", iUiListener, "");
        }
        return invokeLLL.intValue;
    }

    public int loginWithOEM(Activity activity, String str, IUiListener iUiListener, boolean z, String str2, String str3, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{activity, str, iUiListener, Boolean.valueOf(z), str2, str3, str4})) == null) {
            SLog.i("openSDK_LOG.Tencent", "loginWithOEM() with activity, scope = " + str);
            return this.a.a(activity, str, iUiListener, z, str2, str3, str4);
        }
        return invokeCommon.intValue;
    }

    public void requestAsync(String str, Bundle bundle, String str2, IRequestListener iRequestListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048604, this, str, bundle, str2, iRequestListener) == null) {
            SLog.i("openSDK_LOG.Tencent", "requestAsync()");
            HttpUtils.requestAsync(this.a.b(), f.a(), str, bundle, str2, iRequestListener);
        }
    }

    public int startIMConversation(Activity activity, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048617, this, activity, str, str2, str3)) == null) {
            return new IM(getQQToken()).startIMConversation(activity, str, str2, str3);
        }
        return invokeLLLL.intValue;
    }

    public int startMiniApp(Activity activity, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048619, this, activity, str, str2, str3)) == null) {
            SLog.i("openSDK_LOG.Tencent", "startMiniApp()");
            return new MiniApp(getQQToken()).startMiniApp(activity, MiniApp.MINIAPP_TYPE_NORMAL, str, "21", str2, str3);
        }
        return invokeLLLL.intValue;
    }

    public void setAccessToken(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048606, this, str, str2) == null) {
            SLog.i("openSDK_LOG.Tencent", "setAccessToken(), expiresIn = " + str2 + "");
            this.a.a(str, str2);
        }
    }

    public void setAvatar(Activity activity, Bundle bundle, IUiListener iUiListener, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{activity, bundle, iUiListener, Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            SLog.i("openSDK_LOG.Tencent", "setAvatar()");
            bundle.putInt("exitAnim", i2);
            activity.overridePendingTransition(i, 0);
            setAvatar(activity, bundle, iUiListener);
        }
    }
}
