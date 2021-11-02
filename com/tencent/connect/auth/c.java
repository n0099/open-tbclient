package com.tencent.connect.auth;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.f;
import com.tencent.open.utils.i;
import com.tencent.open.utils.l;
import com.tencent.tauth.IUiListener;
import java.io.File;
import java.util.Map;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AuthAgent f69872a;

    /* renamed from: b  reason: collision with root package name */
    public QQToken f69873b;

    public c(String str, Context context) {
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
        SLog.i("openSDK_LOG.QQAuth", "new QQAuth() --start");
        this.f69873b = new QQToken(str);
        this.f69872a = new AuthAgent(this.f69873b);
        com.tencent.connect.a.a.c(context, this.f69873b);
        a(context, Constants.SDK_VERSION);
        SLog.i("openSDK_LOG.QQAuth", "new QQAuth() --end");
    }

    public static void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, str) == null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("BuglySdkInfos", 0).edit();
            edit.putString("bcb3903995", str);
            edit.apply();
        }
    }

    public int b(Activity activity, String str, IUiListener iUiListener) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, activity, str, iUiListener)) == null) {
            SLog.i("openSDK_LOG.QQAuth", "reAuth()");
            return this.f69872a.a(activity, str, iUiListener, true, null, false);
        }
        return invokeLLL.intValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("isSessionValid(), result = ");
            sb.append(this.f69873b.isSessionValid() ? "true" : "false");
            SLog.i("openSDK_LOG.QQAuth", sb.toString());
            return this.f69873b.isSessionValid();
        }
        return invokeV.booleanValue;
    }

    public QQToken b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f69873b : (QQToken) invokeV.objValue;
    }

    public void b(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, context, str) == null) {
            SLog.i("openSDK_LOG.QQAuth", "setOpenId() --start");
            this.f69873b.setOpenId(str);
            com.tencent.connect.a.a.d(context, this.f69873b);
            SLog.i("openSDK_LOG.QQAuth", "setOpenId() --end");
        }
    }

    public static c a(String str, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, context)) == null) {
            f.a(context.getApplicationContext());
            SLog.i("openSDK_LOG.QQAuth", "QQAuth -- createInstance() --start");
            c cVar = new c(str, context);
            SLog.i("openSDK_LOG.QQAuth", "QQAuth -- createInstance()  --end");
            return cVar;
        }
        return (c) invokeLL.objValue;
    }

    public int a(Activity activity, String str, IUiListener iUiListener) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, str, iUiListener)) == null) {
            SLog.i("openSDK_LOG.QQAuth", "login()");
            return a(activity, str, iUiListener, "");
        }
        return invokeLLL.intValue;
    }

    public int a(Activity activity, String str, IUiListener iUiListener, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{activity, str, iUiListener, Boolean.valueOf(z)})) == null) {
            SLog.i("openSDK_LOG.QQAuth", "login()");
            return a(activity, null, str, iUiListener, "", z);
        }
        return invokeCommon.intValue;
    }

    public int a(Activity activity, IUiListener iUiListener, Map<String, Object> map) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, activity, iUiListener, map)) == null) {
            SLog.i("openSDK_LOG.QQAuth", "login--params");
            return a(activity, (Fragment) null, l.a(map, Constants.KEY_SCOPE, "all"), iUiListener, "", l.a(map, Constants.KEY_QRCODE, false), map);
        }
        return invokeLLL.intValue;
    }

    public int a(Activity activity, String str, IUiListener iUiListener, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, activity, str, iUiListener, str2)) == null) {
            SLog.i("openSDK_LOG.QQAuth", "-->login activity: " + activity);
            return a(activity, (Fragment) null, str, iUiListener, str2);
        }
        return invokeLLLL.intValue;
    }

    public int a(Fragment fragment, String str, IUiListener iUiListener, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, fragment, str, iUiListener, str2)) == null) {
            FragmentActivity activity = fragment.getActivity();
            SLog.i("openSDK_LOG.QQAuth", "-->login activity: " + activity);
            return a(activity, fragment, str, iUiListener, str2);
        }
        return invokeLLLL.intValue;
    }

    public int a(Fragment fragment, String str, IUiListener iUiListener, String str2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{fragment, str, iUiListener, str2, Boolean.valueOf(z)})) == null) {
            FragmentActivity activity = fragment.getActivity();
            SLog.i("openSDK_LOG.QQAuth", "-->login activity: " + activity);
            return a(activity, fragment, str, iUiListener, str2, z);
        }
        return invokeCommon.intValue;
    }

    private int a(Activity activity, Fragment fragment, String str, IUiListener iUiListener, String str2) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65537, this, activity, fragment, str, iUiListener, str2)) == null) ? a(activity, fragment, str, iUiListener, str2, false) : invokeLLLLL.intValue;
    }

    private int a(Activity activity, Fragment fragment, String str, IUiListener iUiListener, String str2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{activity, fragment, str, iUiListener, str2, Boolean.valueOf(z)})) == null) ? a(activity, fragment, str, iUiListener, str2, z, (Map<String, Object>) null) : invokeCommon.intValue;
    }

    private int a(Activity activity, Fragment fragment, String str, IUiListener iUiListener, String str2, boolean z, Map<String, Object> map) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{activity, fragment, str, iUiListener, str2, Boolean.valueOf(z), map})) == null) {
            try {
                String a2 = i.a(activity);
                if (a2 != null) {
                    String a3 = com.tencent.open.utils.b.a(new File(a2));
                    if (!TextUtils.isEmpty(a3)) {
                        SLog.v("openSDK_LOG.QQAuth", "-->login channelId: " + a3);
                        return a(activity, str, iUiListener, z, a3, a3, "");
                    }
                }
            } catch (Throwable th) {
                SLog.e("openSDK_LOG.QQAuth", "-->login get channel id exception.", th);
            }
            SLog.d("openSDK_LOG.QQAuth", "-->login channelId is null ");
            BaseApi.isOEM = false;
            return this.f69872a.doLogin(activity, str, iUiListener, false, fragment, z, map);
        }
        return invokeCommon.intValue;
    }

    @Deprecated
    public int a(Activity activity, String str, IUiListener iUiListener, boolean z, String str2, String str3, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{activity, str, iUiListener, Boolean.valueOf(z), str2, str3, str4})) == null) {
            SLog.i("openSDK_LOG.QQAuth", "loginWithOEM");
            BaseApi.isOEM = true;
            if (str2.equals("")) {
                str2 = StringUtil.NULL_STRING;
            }
            if (str3.equals("")) {
                str3 = StringUtil.NULL_STRING;
            }
            if (str4.equals("")) {
                str4 = StringUtil.NULL_STRING;
            }
            BaseApi.installChannel = str3;
            BaseApi.registerChannel = str2;
            BaseApi.businessId = str4;
            return this.f69872a.a(activity, str, iUiListener, false, null, z);
        }
        return invokeCommon.intValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f69872a.a((IUiListener) null);
        }
    }

    public void a(IUiListener iUiListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iUiListener) == null) {
            this.f69872a.b(iUiListener);
        }
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) {
            SLog.i("openSDK_LOG.QQAuth", "setAccessToken(), validTimeInSecond = " + str2 + "");
            this.f69873b.setAccessToken(str, str2);
        }
    }
}
