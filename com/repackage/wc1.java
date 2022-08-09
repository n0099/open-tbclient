package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.devicescore.DeviceScoreCollectFetcher;
import com.baidu.searchbox.devicescore.DeviceScoreConfigFetcher;
import com.baidu.searchbox.devicescore.DeviceScoreFetcher;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceFetcher;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.MultiPluginManagerServiceFetcher;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.YYPluginManageServiceFetcher;
import com.baidu.searchbox.live.service.Media2YYServiceFetcher;
import com.baidu.searchbox.live.service.PluginInvokeServiceFetcher;
import com.baidu.searchbox.live.service.YY2MediaServiceFetcher;
import com.baidu.searchbox.live.service.YYPluginProgressInvokeServiceFetcher;
import com.baidu.searchbox.logsystem.exceptionhandler.impl.ExceptionHandlerServiceFetcher;
import com.baidu.searchbox.performance.speed.SpeedRuntimeProvider;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.tbadk.abtest.helper.HttpsExperimentFetcher;
import com.baidu.tbadk.abtest.helper.NetExperimentFetcher;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBC;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class wc1 {
    public static /* synthetic */ Interceptable $ic;
    public static final ConcurrentHashMap<ServiceReference, vc1<?>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755206292, "Lcom/repackage/wc1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755206292, "Lcom/repackage/wc1;");
                return;
            }
        }
        a = new ConcurrentHashMap<>();
        d();
    }

    public wc1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static <T> T a(ServiceReference serviceReference) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, serviceReference)) == null) {
            vc1<?> vc1Var = a.get(serviceReference);
            if (vc1Var != null) {
                return (T) vc1Var.getService();
            }
            return null;
        }
        return (T) invokeL.objValue;
    }

    public static <T> void b(ServiceReference serviceReference, vc1<T> vc1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, serviceReference, vc1Var) == null) {
            a.put(serviceReference, vc1Var);
        }
    }

    public static <T> void c(String str, String str2, Class<? extends vc1<T>> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, cls) == null) {
            try {
                b(new ServiceReference(str, str2), cls.newInstance());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            c("Frs", "FrsService", if6.class);
            c("HotTopic", "HotTopicRequest", wj5.class);
            c("device_score", "DEVICE_SCORE", DeviceScoreFetcher.class);
            c("device_score", "DEVICE_SCORE_COLLECT", DeviceScoreCollectFetcher.class);
            c("device_score", "DEVICE_SCORE_CONFIG", DeviceScoreConfigFetcher.class);
            c("live", "ab", ji7.class);
            c("live", DI.ACCOUNT, yh7.class);
            c("live", DI.APP_INFO_NAME, ai7.class);
            c("live", DI.EXT.EXT_LIVE_JUMP_PAGE, pi7.class);
            c("live", DI.EXT.EXT_LIVE_LOG, wi7.class);
            c("live", DI.FOLLOW_STATUS, ni7.class);
            c("live", DI.LIGHTBROWSER_VIEW, fi7.class);
            c("live", DI.LIVE_CUSTOM_SETTINGS, sj7.class);
            c("live", DI.LIVE_EVENT_DISPATCHER, li7.class);
            c("live", DI.LIVE_LIKE, ri7.class);
            c("live", DI.LIVE_LOCATION, ui7.class);
            c("live", DI.LIVE_REAL_AUTH, ci7.class);
            c("live", DI.LIVE_SHOW_VIDEO_PLAYER, ej7.class);
            c("live", DI.MINI_SHELL.MEDIA_2_YY, Media2YYServiceFetcher.class);
            c("live", "multi_plugin", MultiPluginManagerServiceFetcher.class);
            c("live", "net", yi7.class);
            c("live", DI.PAY_CHANNEL, hi7.class);
            c("live", DI.LIVE_PLAYER, lj7.class);
            c("live", DI.MINI_SHELL.PLUGIN_MANAGER, PluginInvokeServiceFetcher.class);
            c("live", DI.LIVE_PRE_START_PLAYER, LivePreStartPlayServiceFetcher.class);
            c("live", DI.ROUTER_NAME, qj7.class);
            c("live", "share", wj7.class);
            c("live", DI.TB.SHARE_CHANNEL, uj7.class);
            c("live", DI.THIRD_PART_ACCOUNT, yj7.class);
            c("live", DI.YY.THIRD_PART_ALI_RECHARGE, zj7.class);
            c("live", DI.YY.THIRD_PART_WX_RECHARGE, bk7.class);
            c("live", DI.TOAST_NAME, dk7.class);
            c("live", DI.MINI_SHELL.YY_2_MEDIA, YY2MediaServiceFetcher.class);
            c("live", DI.YY.YY_MULTI_PLUGIN_PROGRESS, YYPluginProgressInvokeServiceFetcher.class);
            c("live", DI.YYPAY.YY_PAY, bj7.class);
            c("live", DI.YY.YY_PLUGIN, YYPluginManageServiceFetcher.class);
            c("logsystem", "exceptionhandler", ExceptionHandlerServiceFetcher.class);
            c("nad.core", "adRequester", ux0.class);
            c("nad.core", "browserDownload", mi0.class);
            c("nad.core", "cmd", qn5.class);
            c("nad.core", "config", rn5.class);
            c("nad.core", "crius", xh0.class);
            c("nad.core", "deviceInfoInner", kf0.class);
            c("nad.core", "eventbus", ak0.class);
            c("nad.core", "exp", pk0.class);
            c("nad.core", "ipdx", nf0.class);
            c("nad.core", "loadImage", we0.class);
            c("nad.core", "loadVideo", rt0.class);
            c("nad.core", "maxUI", tn5.class);
            c("nad.core", "navBarTool", vn5.class);
            c("nad.core", "splash.config", wn5.class);
            c("nad.core", "splash.host", xn5.class);
            c("nad.core", "thirdService", un5.class);
            c("speed", "runtime", SpeedRuntimeProvider.class);
            c("tbBaseEmotion", "EmotionService", b66.class);
            c("tbadkcore", "IHttpsExperiment", HttpsExperimentFetcher.class);
            c("tbadkcore", "INetExperiment", NetExperimentFetcher.class);
            c("tbadkcore", "ISoProcess", h85.class);
            c(UBCCloudControlProcessor.UBC_KEY, UBC.TAG, d59.class);
            c("voyager", StatConstants.VALUE_TYPE_UPLOAD, ud9.class);
            c("yaLog", "yaLogConfig", re9.class);
        }
    }
}
