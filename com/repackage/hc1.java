package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.devicescore.DeviceScoreCollectFetcher;
import com.baidu.searchbox.devicescore.DeviceScoreConfigFetcher;
import com.baidu.searchbox.devicescore.DeviceScoreFetcher;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.YYPluginManageServiceFetcher;
import com.baidu.searchbox.logsystem.exceptionhandler.impl.ExceptionHandlerServiceFetcher;
import com.baidu.searchbox.performance.speed.SpeedRuntimeProvider;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.searchbox.updateprocessor.UpdateCloudControlProcessor;
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
/* loaded from: classes6.dex */
public class hc1 {
    public static /* synthetic */ Interceptable $ic;
    public static final ConcurrentHashMap<ServiceReference, gc1<?>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755653157, "Lcom/repackage/hc1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755653157, "Lcom/repackage/hc1;");
                return;
            }
        }
        a = new ConcurrentHashMap<>();
        d();
    }

    public hc1() {
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
            gc1<?> gc1Var = a.get(serviceReference);
            if (gc1Var != null) {
                return (T) gc1Var.getService();
            }
            return null;
        }
        return (T) invokeL.objValue;
    }

    public static <T> void b(ServiceReference serviceReference, gc1<T> gc1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, serviceReference, gc1Var) == null) {
            a.put(serviceReference, gc1Var);
        }
    }

    public static <T> void c(String str, String str2, Class<? extends gc1<T>> cls) {
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
            c("Frs", "FrsService", yd6.class);
            c("HotTopic", "HotTopicRequest", vg5.class);
            c("device_score", "DEVICE_SCORE", DeviceScoreFetcher.class);
            c("device_score", "DEVICE_SCORE_COLLECT", DeviceScoreCollectFetcher.class);
            c("device_score", "DEVICE_SCORE_CONFIG", DeviceScoreConfigFetcher.class);
            c("live", "ab", xg7.class);
            c("live", DI.ACCOUNT, mg7.class);
            c("live", DI.APP_INFO_NAME, og7.class);
            c("live", DI.EXT.EXT_LIVE_JUMP_PAGE, dh7.class);
            c("live", DI.EXT.EXT_LIVE_LOG, kh7.class);
            c("live", DI.FOLLOW_STATUS, bh7.class);
            c("live", DI.LIGHTBROWSER_VIEW, tg7.class);
            c("live", DI.LIVE_CUSTOM_SETTINGS, gi7.class);
            c("live", DI.LIVE_EVENT_DISPATCHER, zg7.class);
            c("live", DI.LIVE_LIKE, fh7.class);
            c("live", DI.LIVE_LOCATION, ih7.class);
            c("live", DI.LIVE_REAL_AUTH, qg7.class);
            c("live", DI.LIVE_SHOW_VIDEO_PLAYER, sh7.class);
            c("live", "net", mh7.class);
            c("live", DI.PAY_CHANNEL, vg7.class);
            c("live", DI.LIVE_PLAYER, zh7.class);
            c("live", DI.ROUTER_NAME, ei7.class);
            c("live", "share", ki7.class);
            c("live", DI.TB.SHARE_CHANNEL, ii7.class);
            c("live", DI.THIRD_PART_ACCOUNT, mi7.class);
            c("live", DI.YY.THIRD_PART_ALI_RECHARGE, ni7.class);
            c("live", DI.YY.THIRD_PART_WX_RECHARGE, pi7.class);
            c("live", "toast", ri7.class);
            c("live", DI.YYPAY.YY_PAY, ph7.class);
            c("live", DI.YY.YY_PLUGIN, YYPluginManageServiceFetcher.class);
            c("logsystem", "exceptionhandler", ExceptionHandlerServiceFetcher.class);
            c("nad.core", "adRequester", ry0.class);
            c("nad.core", "browserDownload", pj0.class);
            c("nad.core", "cmd", el5.class);
            c("nad.core", UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME, fl5.class);
            c("nad.core", "crius", yi0.class);
            c("nad.core", "deviceInfoInner", og0.class);
            c("nad.core", "eventbus", zk0.class);
            c("nad.core", "exp", ol0.class);
            c("nad.core", "ipdx", rg0.class);
            c("nad.core", "loadImage", bg0.class);
            c("nad.core", "loadVideo", ou0.class);
            c("nad.core", "maxUI", hl5.class);
            c("nad.core", "navBarTool", il5.class);
            c("nad.core", "splash.config", jl5.class);
            c("nad.core", "splash.host", kl5.class);
            c("speed", "runtime", SpeedRuntimeProvider.class);
            c("tbadkcore", "INetExperiment", NetExperimentFetcher.class);
            c("tbadkcore", "ISoProcess", e65.class);
            c(UBCCloudControlProcessor.UBC_KEY, UBC.TAG, d59.class);
            c("voyager", StatConstants.VALUE_TYPE_UPLOAD, de9.class);
            c("yaLog", "yaLogConfig", af9.class);
        }
    }
}
