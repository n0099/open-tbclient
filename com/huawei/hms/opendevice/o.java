package com.huawei.hms.opendevice;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.nva;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.entity.DeleteTokenReq;
import com.huawei.hms.aaid.entity.TokenReq;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.push.HmsMessaging;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;
import java.util.UUID;
/* loaded from: classes8.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static DeleteTokenReq a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, str)) == null) {
            return a(context, null, null, str, null);
        }
        return (DeleteTokenReq) invokeLL.objValue;
    }

    public static TokenReq b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, context, str)) == null) {
            return b(context, null, null, str, null);
        }
        return (TokenReq) invokeLL.objValue;
    }

    public static DeleteTokenReq a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, context, str, str2)) == null) {
            return a(context, str, null, null, str2);
        }
        return (DeleteTokenReq) invokeLLL.objValue;
    }

    public static TokenReq b(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, context, str, str2)) == null) {
            return b(context, str, null, null, str2);
        }
        return (TokenReq) invokeLLL.objValue;
    }

    public static DeleteTokenReq a(Context context, String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65538, null, context, str, str2, str3, str4)) == null) {
            DeleteTokenReq deleteTokenReq = new DeleteTokenReq();
            deleteTokenReq.setAppId(str);
            deleteTokenReq.setScope(str4);
            deleteTokenReq.setProjectId(str2);
            deleteTokenReq.setPkgName(context.getPackageName());
            deleteTokenReq.setSubjectId(str3);
            if (TextUtils.isEmpty(str)) {
                deleteTokenReq.setAppId(Util.getAppId(context));
            }
            if (TextUtils.isEmpty(str4)) {
                deleteTokenReq.setScope(HmsMessaging.DEFAULT_TOKEN_SCOPE);
            }
            if (TextUtils.isEmpty(str2)) {
                deleteTokenReq.setProjectId(d(context));
            }
            return deleteTokenReq;
        }
        return (DeleteTokenReq) invokeLLLLL.objValue;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            PushPreferences pushPreferences = new PushPreferences(context, "aaid");
            if (pushPreferences.containsKey("aaid")) {
                return pushPreferences.getString("aaid");
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static DeleteTokenReq b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            return a(context, null, null, null, null);
        }
        return (DeleteTokenReq) invokeL.objValue;
    }

    public static String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            return nva.c(context).a("client/project_id");
        }
        return (String) invokeL.objValue;
    }

    public static TokenReq b(Context context, String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65543, null, context, str, str2, str3, str4)) == null) {
            TokenReq tokenReq = new TokenReq();
            tokenReq.setPackageName(context.getPackageName());
            tokenReq.setAppId(str);
            tokenReq.setScope(str4);
            tokenReq.setProjectId(str2);
            tokenReq.setSubjectId(str3);
            tokenReq.setMultiSender(false);
            if (TextUtils.isEmpty(str)) {
                tokenReq.setAppId(Util.getAppId(context));
            }
            if (TextUtils.isEmpty(str2)) {
                tokenReq.setProjectId(d(context));
            }
            if (TextUtils.isEmpty(str4)) {
                tokenReq.setScope(HmsMessaging.DEFAULT_TOKEN_SCOPE);
            }
            i a = i.a(context);
            if (!a.getBoolean("hasRequestAgreement")) {
                tokenReq.setFirstTime(true);
                a.saveBoolean("hasRequestAgreement", true);
            } else {
                tokenReq.setFirstTime(false);
            }
            return tokenReq;
        }
        return (TokenReq) invokeLLLLL.objValue;
    }

    public static synchronized String c(Context context) {
        InterceptResult invokeL;
        String uuid;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            synchronized (o.class) {
                PushPreferences pushPreferences = new PushPreferences(context, "aaid");
                if (pushPreferences.containsKey("aaid")) {
                    uuid = pushPreferences.getString("aaid");
                } else {
                    uuid = UUID.randomUUID().toString();
                    pushPreferences.saveString("aaid", uuid);
                    pushPreferences.saveLong("creationTime", Long.valueOf(System.currentTimeMillis()));
                }
            }
            return uuid;
        }
        return (String) invokeL.objValue;
    }

    public static boolean e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (applicationInfo != null && applicationInfo.metaData != null) {
                    if (!TextUtils.isEmpty(applicationInfo.metaData.getString("com.huawei.hms.client.service.name:base"))) {
                        return true;
                    }
                }
                return false;
            } catch (PackageManager.NameNotFoundException unused) {
                HMSLog.e(HmsInstanceId.TAG, "isIntegratedBaseSdk failed.");
                return true;
            }
        }
        return invokeL.booleanValue;
    }
}
