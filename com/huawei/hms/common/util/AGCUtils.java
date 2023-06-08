package com.huawei.hms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.tieba.t9b;
import com.baidu.tieba.v9b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.IOUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes9.dex */
public class AGCUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public AGCUtils() {
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

    public static String a(Context context) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                HMSLog.e("AGCUtils", "In getMetaDataAppId, Failed to get 'PackageManager' instance.");
                return "";
            }
            try {
                ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 128).applicationInfo;
                if (applicationInfo != null && applicationInfo.metaData != null && (obj = applicationInfo.metaData.get(Constants.HUAWEI_HMS_CLIENT_APPID)) != null) {
                    String valueOf = String.valueOf(obj);
                    if (valueOf.startsWith(AccountConstants.PROFESSION_APPROVE_URL_APPID)) {
                        return valueOf.substring(6);
                    }
                    return valueOf;
                }
                HMSLog.e("AGCUtils", "In getMetaDataAppId, Failed to read meta data for the AppID.");
                return "";
            } catch (PackageManager.NameNotFoundException unused) {
                HMSLog.e("AGCUtils", "In getMetaDataAppId, Failed to read meta data for the AppID.");
                return "";
            } catch (RuntimeException e) {
                HMSLog.e("AGCUtils", "In getMetaDataAppId, Failed to read meta data for the AppID.", e);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                HMSLog.e("AGCUtils", "In getMetaDataCpId, Failed to get 'PackageManager' instance.");
                return "";
            }
            try {
                ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 128).applicationInfo;
                if (applicationInfo != null && applicationInfo.metaData != null && (obj = applicationInfo.metaData.get("com.huawei.hms.client.cpid")) != null) {
                    String valueOf = String.valueOf(obj);
                    if (valueOf.startsWith("cpid=")) {
                        return valueOf.substring(5);
                    }
                    return valueOf;
                }
                HMSLog.i("AGCUtils", "In getMetaDataCpId, Failed to read meta data for the CpId.");
                return "";
            } catch (PackageManager.NameNotFoundException unused) {
                HMSLog.e("AGCUtils", "In getMetaDataCpId, Failed to read meta data for the CpId.");
                return "";
            } catch (RuntimeException e) {
                HMSLog.e("AGCUtils", "In getMetaDataCpId, Failed to read meta data for the CpId.", e);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String getCpId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            if (c(context)) {
                return a(context, "client/cp_id");
            }
            String str = null;
            try {
                t9b b = t9b.b();
                if (b.getContext() != context) {
                    b = t9b.a(new v9b().a(context));
                }
                str = b.c().a("client/cp_id");
            } catch (NullPointerException unused) {
                HMSLog.e("AGCUtils", "Get cpid with AGConnectServicesConfig failed");
            }
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            String b2 = b(context);
            if (!TextUtils.isEmpty(b2)) {
                return b2;
            }
            return a(context, "client/cp_id");
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x006d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context, String str) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            InputStream inputStream = null;
            try {
                try {
                    v9b v9bVar = new v9b();
                    inputStream = context.getResources().getAssets().open("agconnect-services.json");
                    v9bVar.b(inputStream);
                    str2 = v9bVar.a(context).a(str);
                } catch (IOException e) {
                    HMSLog.e("AGCUtils", "Get " + str + " failed: " + e);
                    str2 = "";
                    IOUtils.closeQuietly(inputStream);
                    if (!TextUtils.isEmpty(str2)) {
                    }
                } catch (NullPointerException e2) {
                    HMSLog.e("AGCUtils", "Get " + str + " with AGConnectServicesConfig failed: " + e2);
                    str2 = "";
                    IOUtils.closeQuietly(inputStream);
                    if (!TextUtils.isEmpty(str2)) {
                    }
                }
                IOUtils.closeQuietly(inputStream);
                if (!TextUtils.isEmpty(str2)) {
                    return str2;
                }
                HMSLog.e("AGCUtils", "The " + str + " is null.");
                return "";
            } catch (Throwable th) {
                IOUtils.closeQuietly(inputStream);
                throw th;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static boolean c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            return context.getPackageName().equals(HMSPackageManager.getInstance(context).getHMSPackageNameForMultiService());
        }
        return invokeL.booleanValue;
    }

    public static String getAppId(Context context) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            if (c(context)) {
                str = a(context, "client/app_id");
                if (!TextUtils.isEmpty(str)) {
                    return str;
                }
            } else {
                str = null;
            }
            try {
                t9b b = t9b.b();
                if (b.getContext() != context) {
                    b = t9b.a(new v9b().a(context));
                }
                str = b.c().a("client/app_id");
            } catch (NullPointerException unused) {
                HMSLog.e("AGCUtils", "Get appId with AGConnectServicesConfig failed");
            }
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            String a = a(context);
            if (!TextUtils.isEmpty(a)) {
                return a;
            }
            return a(context, "client/app_id");
        }
        return (String) invokeL.objValue;
    }
}
