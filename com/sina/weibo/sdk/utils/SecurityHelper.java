package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.ApiUtils;
import com.sina.weibo.sdk.auth.WbAppInfo;
import com.sina.weibo.sdk.constant.WBConstants;
/* loaded from: classes10.dex */
public class SecurityHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public SecurityHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean checkResponseAppLegal(Context context, WbAppInfo wbAppInfo, Intent intent) {
        InterceptResult invokeLLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, context, wbAppInfo, intent)) == null) {
            if ((wbAppInfo != null && wbAppInfo.getSupportVersion() <= 10352) || wbAppInfo == null) {
                return true;
            }
            if (intent != null) {
                str = intent.getStringExtra(WBConstants.Base.APP_PKG);
            } else {
                str = null;
            }
            if (str != null && intent.getStringExtra(WBConstants.TRAN) != null && ApiUtils.validateWeiboSign(context, str)) {
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static boolean containSign(Signature[] signatureArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, signatureArr, str)) == null) {
            if (signatureArr != null && str != null) {
                for (Signature signature : signatureArr) {
                    if (str.equals(MD5.hexdigest(signature.toByteArray()))) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean validateAppSignatureForIntent(Context context, Intent intent) {
        InterceptResult invokeLL;
        ResolveInfo resolveActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, intent)) == null) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (resolveActivity = packageManager.resolveActivity(intent, 0)) == null) {
                return false;
            }
            try {
                return containSign(packageManager.getPackageInfo(resolveActivity.activityInfo.packageName, 64).signatures, WBConstants.WEIBO_SIGN);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                return false;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeLL.booleanValue;
    }
}
