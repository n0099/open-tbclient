package com.yy.mobile.framework.revenuesdk.baseapi.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.util.n;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.common.Constants;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\u0006\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\u0006\u0010\u0005J\u0019\u0010\u0007\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\u0007\u0010\u0005J\u0019\u0010\b\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\b\u0010\u0005J\u0019\u0010\t\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\t\u0010\u0005J!\u0010\f\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/baseapi/utils/PackageInstallUtil;", "Landroid/content/Context;", "context", "", "isInstallAlipay", "(Landroid/content/Context;)Z", "isInstallQQ", "isInstallQQLite", "isInstallQZone", "isInstallWechat", "", "packageName", "isInstalled", "(Landroid/content/Context;Ljava/lang/String;)Z", "<init>", "()V", "paybaseapi_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes6.dex */
public final class PackageInstallUtil {
    public static /* synthetic */ Interceptable $ic;
    public static final PackageInstallUtil INSTANCE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1018361688, "Lcom/yy/mobile/framework/revenuesdk/baseapi/utils/PackageInstallUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1018361688, "Lcom/yy/mobile/framework/revenuesdk/baseapi/utils/PackageInstallUtil;");
                return;
            }
        }
        INSTANCE = new PackageInstallUtil();
    }

    public PackageInstallUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @JvmStatic
    public static final boolean isInstallAlipay(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? isInstalled(context, n.f1995a) : invokeL.booleanValue;
    }

    @JvmStatic
    public static final boolean isInstallQQ(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? isInstalled(context, "com.tencent.mobileqq") : invokeL.booleanValue;
    }

    @JvmStatic
    public static final boolean isInstallQQLite(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) ? isInstalled(context, "com.tencent.qqlite") : invokeL.booleanValue;
    }

    @JvmStatic
    public static final boolean isInstallQZone(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) ? isInstalled(context, Constants.PACKAGE_QZONE) : invokeL.booleanValue;
    }

    @JvmStatic
    public static final boolean isInstallWechat(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) ? isInstalled(context, "com.tencent.mm") : invokeL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0039 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean isInstalled(Context context, String str) {
        InterceptResult invokeLL;
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65543, null, context, str)) != null) {
            return invokeLL.booleanValue;
        }
        if (context != null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    packageInfo = packageManager.getPackageInfo(str, 256);
                    return packageInfo == null;
                }
            } catch (Exception e2) {
                RLog.error("PackageInstallUtil", "pkg: " + str + ", get packageInfo is null, e=" + e2, new Object[0]);
                return false;
            }
        }
        packageInfo = null;
        if (packageInfo == null) {
        }
    }
}
