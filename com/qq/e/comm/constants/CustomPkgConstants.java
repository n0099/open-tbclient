package com.qq.e.comm.constants;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.ads.ADActivity;
import com.qq.e.ads.LandscapeADActivity;
import com.qq.e.ads.PortraitADActivity;
import com.qq.e.ads.RewardvideoLandscapeADActivity;
import com.qq.e.ads.RewardvideoPortraitADActivity;
import com.qq.e.comm.DownloadService;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.util.StringUtil;
/* loaded from: classes3.dex */
public class CustomPkgConstants {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f59049b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f59050c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f59051d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f59052e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f59053f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1837064515, "Lcom/qq/e/comm/constants/CustomPkgConstants;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1837064515, "Lcom/qq/e/comm/constants/CustomPkgConstants;");
                return;
            }
        }
        a = DownloadService.class.getName();
        f59049b = ADActivity.class.getName();
        f59050c = PortraitADActivity.class.getName();
        f59051d = RewardvideoPortraitADActivity.class.getName();
        f59052e = LandscapeADActivity.class.getName();
        f59053f = RewardvideoLandscapeADActivity.class.getName();
    }

    public CustomPkgConstants() {
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

    public static String getADActivityName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String customADActivityClassName = GlobalSetting.getCustomADActivityClassName();
            return !StringUtil.isEmpty(customADActivityClassName) ? customADActivityClassName : f59049b;
        }
        return (String) invokeV.objValue;
    }

    public static String getAssetPluginDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? "gdt_plugin" : (String) invokeV.objValue;
    }

    public static String getAssetPluginName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? "gdtadv2.jar" : (String) invokeV.objValue;
    }

    public static String getAssetPluginXorKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? "" : (String) invokeV.objValue;
    }

    public static String getDownLoadServiceName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? a : (String) invokeV.objValue;
    }

    public static String getLandscapeADActivityName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            String customLandscapeActivityClassName = GlobalSetting.getCustomLandscapeActivityClassName();
            return !StringUtil.isEmpty(customLandscapeActivityClassName) ? customLandscapeActivityClassName : f59052e;
        }
        return (String) invokeV.objValue;
    }

    public static String getPortraitADActivityName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            String customPortraitActivityClassName = GlobalSetting.getCustomPortraitActivityClassName();
            return !StringUtil.isEmpty(customPortraitActivityClassName) ? customPortraitActivityClassName : f59050c;
        }
        return (String) invokeV.objValue;
    }

    public static String getRewardvideoLandscapeADActivityName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            String customRewardvideoLandscapeActivityClassName = GlobalSetting.getCustomRewardvideoLandscapeActivityClassName();
            return !StringUtil.isEmpty(customRewardvideoLandscapeActivityClassName) ? customRewardvideoLandscapeActivityClassName : f59053f;
        }
        return (String) invokeV.objValue;
    }

    public static String getRewardvideoPortraitADActivityName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            String customRewardvideoPortraitActivityClassName = GlobalSetting.getCustomRewardvideoPortraitActivityClassName();
            return !StringUtil.isEmpty(customRewardvideoPortraitActivityClassName) ? customRewardvideoPortraitActivityClassName : f59051d;
        }
        return (String) invokeV.objValue;
    }
}
