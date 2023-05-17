package com.huawei.hms.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.text.TextUtils;
import android.util.AndroidException;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.support.log.HMSLog;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
/* loaded from: classes9.dex */
public class PackageManagerHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final PackageManager a;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class PackageStates {
        public static /* synthetic */ Interceptable $ic;
        public static final PackageStates DISABLED;
        public static final PackageStates ENABLED;
        public static final PackageStates NOT_INSTALLED;
        public static final PackageStates SPOOF;
        public static final /* synthetic */ PackageStates[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-245899371, "Lcom/huawei/hms/utils/PackageManagerHelper$PackageStates;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-245899371, "Lcom/huawei/hms/utils/PackageManagerHelper$PackageStates;");
                    return;
                }
            }
            ENABLED = new PackageStates("ENABLED", 0);
            DISABLED = new PackageStates("DISABLED", 1);
            NOT_INSTALLED = new PackageStates("NOT_INSTALLED", 2);
            PackageStates packageStates = new PackageStates("SPOOF", 3);
            SPOOF = packageStates;
            a = new PackageStates[]{ENABLED, DISABLED, NOT_INSTALLED, packageStates};
        }

        public PackageStates(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static PackageStates valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (PackageStates) Enum.valueOf(PackageStates.class, str);
            }
            return (PackageStates) invokeL.objValue;
        }

        public static PackageStates[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (PackageStates[]) a.clone();
            }
            return (PackageStates[]) invokeV.objValue;
        }
    }

    public PackageManagerHelper(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context.getPackageManager();
    }

    public String getApplicationName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            try {
                return this.a.getApplicationLabel(this.a.getApplicationInfo(str, 128)).toString();
            } catch (AndroidException unused) {
                HMSLog.e("PackageManagerHelper", "Failed to get application name for " + str);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public int getPackageVersionCode(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            try {
                PackageInfo packageInfo = this.a.getPackageInfo(str, 16);
                if (packageInfo == null) {
                    return 0;
                }
                return packageInfo.versionCode;
            } catch (AndroidException e) {
                HMSLog.e("PackageManagerHelper", "get PackageVersionCode failed " + e);
                return 0;
            } catch (RuntimeException e2) {
                HMSLog.e("PackageManagerHelper", "get PackageVersionCode failed", e2);
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public final byte[] a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                PackageInfo packageInfo = this.a.getPackageInfo(str, 64);
                if (packageInfo != null && packageInfo.signatures != null && packageInfo.signatures.length > 0) {
                    return packageInfo.signatures[0].toByteArray();
                }
            } catch (AndroidException e) {
                HMSLog.e("PackageManagerHelper", "Failed to get application signature certificate fingerprint." + e.getMessage());
            } catch (RuntimeException e2) {
                HMSLog.e("PackageManagerHelper", "Failed to get application signature certificate fingerprint.", e2);
            }
            HMSLog.e("PackageManagerHelper", "Failed to get application signature certificate fingerprint.");
            return new byte[0];
        }
        return (byte[]) invokeL.objValue;
    }

    public long getPackageFirstInstallTime(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            try {
                PackageInfo packageInfo = this.a.getPackageInfo(str, 128);
                if (packageInfo == null) {
                    return 0L;
                }
                return packageInfo.firstInstallTime;
            } catch (AndroidException | RuntimeException unused) {
                return 0L;
            }
        }
        return invokeL.longValue;
    }

    public String getPackageSignature(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            byte[] a = a(str);
            if (a != null && a.length != 0) {
                return HEX.encodeHexString(SHA256.digest(a), true);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public PackageStates getPackageStates(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return PackageStates.NOT_INSTALLED;
            }
            try {
                if (this.a.getApplicationInfo(str, 128).enabled) {
                    return PackageStates.ENABLED;
                }
                return PackageStates.DISABLED;
            } catch (AndroidException unused) {
                return PackageStates.NOT_INSTALLED;
            }
        }
        return (PackageStates) invokeL.objValue;
    }

    public String getPackageVersionName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            try {
                PackageInfo packageInfo = this.a.getPackageInfo(str, 16);
                if (packageInfo == null || packageInfo.versionName == null) {
                    return "";
                }
                return packageInfo.versionName;
            } catch (AndroidException unused) {
                return "";
            } catch (RuntimeException e) {
                HMSLog.e("PackageManagerHelper", "get getPackageVersionName failed", e);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public boolean isPackageFreshInstall(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            try {
                PackageInfo packageInfo = this.a.getPackageInfo(str, 128);
                if (packageInfo == null) {
                    return false;
                }
                if (packageInfo.firstInstallTime != packageInfo.lastUpdateTime) {
                    return false;
                }
                return true;
            } catch (AndroidException | RuntimeException unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean hasProvider(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, str2)) == null) {
            try {
                PackageInfo packageInfo = this.a.getPackageInfo(str, 8);
                if (packageInfo != null && packageInfo.providers != null) {
                    for (ProviderInfo providerInfo : packageInfo.providers) {
                        if (str2.equals(providerInfo.authority)) {
                            return true;
                        }
                    }
                }
            } catch (AndroidException | RuntimeException unused) {
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean verifyPackageArchive(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, str, str2, str3)) == null) {
            PackageInfo packageArchiveInfo = this.a.getPackageArchiveInfo(str, 64);
            if (packageArchiveInfo == null || packageArchiveInfo.signatures.length <= 0 || !str2.equals(packageArchiveInfo.packageName)) {
                return false;
            }
            InputStream inputStream = null;
            try {
                try {
                    inputStream = IOUtils.toInputStream(packageArchiveInfo.signatures[0].toByteArray());
                    return str3.equalsIgnoreCase(HEX.encodeHexString(SHA256.digest(CertificateFactory.getInstance("X.509").generateCertificate(inputStream).getEncoded()), true));
                } finally {
                    IOUtils.closeQuietly((InputStream) null);
                }
            } catch (IOException | CertificateException e) {
                HMSLog.e("PackageManagerHelper", "Failed to get application signature certificate fingerprint." + e.getMessage());
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }
}
