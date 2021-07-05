package com.tencent.connect.auth;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.common.BaseApi;
import com.tencent.open.a.f;
import com.tencent.open.utils.e;
import com.tencent.tauth.IUiListener;
import java.io.File;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AuthAgent f41768a;

    /* renamed from: b  reason: collision with root package name */
    public QQToken f41769b;

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
        f.c("openSDK_LOG.QQAuth", "new QQAuth() --start");
        this.f41769b = new QQToken(str);
        this.f41768a = new AuthAgent(this.f41769b);
        com.tencent.connect.a.a.c(context, this.f41769b);
        f.c("openSDK_LOG.QQAuth", "new QQAuth() --end");
    }

    public static c a(String str, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, context)) == null) {
            e.a(context.getApplicationContext());
            f.c("openSDK_LOG.QQAuth", "QQAuth -- createInstance() --start");
            try {
                PackageManager packageManager = context.getPackageManager();
                packageManager.getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.tauth.AuthActivity"), 0);
                packageManager.getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.connect.common.AssistActivity"), 0);
                c cVar = new c(str, context);
                f.c("openSDK_LOG.QQAuth", "QQAuth -- createInstance()  --end");
                return cVar;
            } catch (PackageManager.NameNotFoundException e2) {
                f.b("openSDK_LOG.QQAuth", "createInstance() error --end", e2);
                Toast.makeText(context.getApplicationContext(), "请参照文档在Androidmanifest.xml加上AuthActivity和AssitActivity的定义 ", 1).show();
                return null;
            }
        }
        return (c) invokeLL.objValue;
    }

    public int b(Activity activity, String str, IUiListener iUiListener) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity, str, iUiListener)) == null) {
            f.c("openSDK_LOG.QQAuth", "reAuth()");
            return this.f41768a.doLogin(activity, str, iUiListener, true, null);
        }
        return invokeLLL.intValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("isSessionValid(), result = ");
            sb.append(this.f41769b.isSessionValid() ? "true" : "false");
            sb.append("");
            f.a("openSDK_LOG.QQAuth", sb.toString());
            return this.f41769b.isSessionValid();
        }
        return invokeV.booleanValue;
    }

    public QQToken b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f41769b : (QQToken) invokeV.objValue;
    }

    public int a(Activity activity, String str, IUiListener iUiListener) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, activity, str, iUiListener)) == null) {
            f.c("openSDK_LOG.QQAuth", "login()");
            return a(activity, str, iUiListener, "");
        }
        return invokeLLL.intValue;
    }

    public int a(Activity activity, String str, IUiListener iUiListener, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, str, iUiListener, str2)) == null) {
            f.c("openSDK_LOG.QQAuth", "-->login activity: " + activity);
            return a(activity, null, str, iUiListener, str2);
        }
        return invokeLLLL.intValue;
    }

    public int a(Fragment fragment, String str, IUiListener iUiListener, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, fragment, str, iUiListener, str2)) == null) {
            FragmentActivity activity = fragment.getActivity();
            f.c("openSDK_LOG.QQAuth", "-->login activity: " + activity);
            return a(activity, fragment, str, iUiListener, str2);
        }
        return invokeLLLL.intValue;
    }

    private int a(Activity activity, Fragment fragment, String str, IUiListener iUiListener, String str2) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65537, this, activity, fragment, str, iUiListener, str2)) == null) {
            String packageName = activity.getApplicationContext().getPackageName();
            String str3 = null;
            try {
                Iterator<ApplicationInfo> it = activity.getPackageManager().getInstalledApplications(128).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ApplicationInfo next = it.next();
                    if (packageName.equals(next.packageName)) {
                        str3 = next.sourceDir;
                        break;
                    }
                }
                if (str3 != null) {
                    String a2 = com.tencent.open.utils.a.a(new File(str3));
                    if (!TextUtils.isEmpty(a2)) {
                        f.a("openSDK_LOG.QQAuth", "-->login channelId: " + a2);
                        return a(activity, str, iUiListener, a2, a2, "");
                    }
                }
            } catch (Throwable th) {
                f.b("openSDK_LOG.QQAuth", "-->login get channel id exception.", th);
                th.printStackTrace();
            }
            f.b("openSDK_LOG.QQAuth", "-->login channelId is null ");
            BaseApi.isOEM = false;
            return this.f41768a.doLogin(activity, str, iUiListener, false, fragment);
        }
        return invokeLLLLL.intValue;
    }

    @Deprecated
    public int a(Activity activity, String str, IUiListener iUiListener, String str2, String str3, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{activity, str, iUiListener, str2, str3, str4})) == null) {
            f.c("openSDK_LOG.QQAuth", "loginWithOEM");
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
            return this.f41768a.doLogin(activity, str, iUiListener);
        }
        return invokeCommon.intValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f41768a.a((IUiListener) null);
        }
    }

    public void a(IUiListener iUiListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, iUiListener) == null) {
            this.f41768a.b(iUiListener);
        }
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
            f.a("openSDK_LOG.QQAuth", "setAccessToken(), validTimeInSecond = " + str2 + "");
            this.f41769b.setAccessToken(str, str2);
        }
    }

    public void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, context, str) == null) {
            f.a("openSDK_LOG.QQAuth", "setOpenId() --start");
            this.f41769b.setOpenId(str);
            com.tencent.connect.a.a.d(context, this.f41769b);
            f.a("openSDK_LOG.QQAuth", "setOpenId() --end");
        }
    }
}
