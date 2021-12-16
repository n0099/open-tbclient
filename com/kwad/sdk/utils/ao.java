package com.kwad.sdk.utils;

import android.location.Location;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsCustomController;
import com.kwad.sdk.api.SdkConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class ao {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a() {
        KsCustomController ksCustomController;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            try {
                SdkConfig sdkConfig = KsAdSDKImpl.get().getSdkConfig();
                if (sdkConfig == null || (ksCustomController = sdkConfig.ksCustomController) == null) {
                    return false;
                }
                return !ksCustomController.canReadLocation();
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static Location b() {
        KsCustomController ksCustomController;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                SdkConfig sdkConfig = KsAdSDKImpl.get().getSdkConfig();
                if (sdkConfig == null || (ksCustomController = sdkConfig.ksCustomController) == null) {
                    return null;
                }
                return ksCustomController.getLocation();
            } catch (Throwable unused) {
                return null;
            }
        }
        return (Location) invokeV.objValue;
    }

    public static boolean c() {
        KsCustomController ksCustomController;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                SdkConfig sdkConfig = KsAdSDKImpl.get().getSdkConfig();
                if (sdkConfig == null || (ksCustomController = sdkConfig.ksCustomController) == null) {
                    return false;
                }
                return !ksCustomController.canUsePhoneState();
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static String d() {
        KsCustomController ksCustomController;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            try {
                SdkConfig sdkConfig = KsAdSDKImpl.get().getSdkConfig();
                return (sdkConfig == null || (ksCustomController = sdkConfig.ksCustomController) == null) ? "" : ksCustomController.getImei();
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static String[] e() {
        KsCustomController ksCustomController;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            try {
                SdkConfig sdkConfig = KsAdSDKImpl.get().getSdkConfig();
                if (sdkConfig != null && (ksCustomController = sdkConfig.ksCustomController) != null) {
                    return ksCustomController.getImeis();
                }
            } catch (Throwable unused) {
            }
            return new String[]{"", ""};
        }
        return (String[]) invokeV.objValue;
    }

    public static String f() {
        KsCustomController ksCustomController;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            try {
                SdkConfig sdkConfig = KsAdSDKImpl.get().getSdkConfig();
                return (sdkConfig == null || (ksCustomController = sdkConfig.ksCustomController) == null) ? "" : ksCustomController.getAndroidId();
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static boolean g() {
        KsCustomController ksCustomController;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            try {
                SdkConfig sdkConfig = KsAdSDKImpl.get().getSdkConfig();
                if (sdkConfig == null || (ksCustomController = sdkConfig.ksCustomController) == null) {
                    return false;
                }
                return !ksCustomController.canUseMacAddress();
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static String h() {
        KsCustomController ksCustomController;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            try {
                SdkConfig sdkConfig = KsAdSDKImpl.get().getSdkConfig();
                return (sdkConfig == null || (ksCustomController = sdkConfig.ksCustomController) == null) ? "" : ksCustomController.getMacAddress();
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static boolean i() {
        KsCustomController ksCustomController;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            try {
                SdkConfig sdkConfig = KsAdSDKImpl.get().getSdkConfig();
                if (sdkConfig == null || (ksCustomController = sdkConfig.ksCustomController) == null) {
                    return false;
                }
                return !ksCustomController.canUseOaid();
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static String j() {
        KsCustomController ksCustomController;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            try {
                SdkConfig sdkConfig = KsAdSDKImpl.get().getSdkConfig();
                return (sdkConfig == null || (ksCustomController = sdkConfig.ksCustomController) == null) ? "" : ksCustomController.getOaid();
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static boolean k() {
        KsCustomController ksCustomController;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            try {
                SdkConfig sdkConfig = KsAdSDKImpl.get().getSdkConfig();
                if (sdkConfig == null || (ksCustomController = sdkConfig.ksCustomController) == null) {
                    return false;
                }
                return !ksCustomController.canUseNetworkState();
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean l() {
        KsCustomController ksCustomController;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            try {
                SdkConfig sdkConfig = KsAdSDKImpl.get().getSdkConfig();
                if (sdkConfig == null || (ksCustomController = sdkConfig.ksCustomController) == null) {
                    return false;
                }
                return !ksCustomController.canUseStoragePermission();
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean m() {
        KsCustomController ksCustomController;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            try {
                SdkConfig sdkConfig = KsAdSDKImpl.get().getSdkConfig();
                if (sdkConfig == null || (ksCustomController = sdkConfig.ksCustomController) == null) {
                    return false;
                }
                return !ksCustomController.canReadInstalledPackages();
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static List<String> n() {
        KsCustomController ksCustomController;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            try {
                SdkConfig sdkConfig = KsAdSDKImpl.get().getSdkConfig();
                if (sdkConfig != null && (ksCustomController = sdkConfig.ksCustomController) != null) {
                    return ksCustomController.getInstalledPackages();
                }
            } catch (Throwable unused) {
            }
            return new ArrayList();
        }
        return (List) invokeV.objValue;
    }
}
