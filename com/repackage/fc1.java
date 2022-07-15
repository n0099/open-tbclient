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
/* loaded from: classes6.dex */
public class fc1 {
    public static /* synthetic */ Interceptable $ic;
    public static final ConcurrentHashMap<ServiceReference, ec1<?>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755712739, "Lcom/repackage/fc1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755712739, "Lcom/repackage/fc1;");
                return;
            }
        }
        a = new ConcurrentHashMap<>();
        d();
    }

    public fc1() {
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
            ec1<?> ec1Var = a.get(serviceReference);
            if (ec1Var != null) {
                return (T) ec1Var.getService();
            }
            return null;
        }
        return (T) invokeL.objValue;
    }

    public static <T> void b(ServiceReference serviceReference, ec1<T> ec1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, serviceReference, ec1Var) == null) {
            a.put(serviceReference, ec1Var);
        }
    }

    public static <T> void c(String str, String str2, Class<? extends ec1<T>> cls) {
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
            c("Frs", "FrsService", qd6.class);
            c("HotTopic", "HotTopicRequest", ii5.class);
            c("device_score", "DEVICE_SCORE", DeviceScoreFetcher.class);
            c("device_score", "DEVICE_SCORE_COLLECT", DeviceScoreCollectFetcher.class);
            c("device_score", "DEVICE_SCORE_CONFIG", DeviceScoreConfigFetcher.class);
            c("live", "ab", og7.class);
            c("live", DI.ACCOUNT, dg7.class);
            c("live", DI.APP_INFO_NAME, fg7.class);
            c("live", DI.EXT.EXT_LIVE_JUMP_PAGE, ug7.class);
            c("live", DI.EXT.EXT_LIVE_LOG, bh7.class);
            c("live", DI.FOLLOW_STATUS, sg7.class);
            c("live", DI.LIGHTBROWSER_VIEW, kg7.class);
            c("live", DI.LIVE_CUSTOM_SETTINGS, xh7.class);
            c("live", DI.LIVE_EVENT_DISPATCHER, qg7.class);
            c("live", DI.LIVE_LIKE, wg7.class);
            c("live", DI.LIVE_LOCATION, zg7.class);
            c("live", DI.LIVE_REAL_AUTH, hg7.class);
            c("live", DI.LIVE_SHOW_VIDEO_PLAYER, jh7.class);
            c("live", "net", dh7.class);
            c("live", DI.PAY_CHANNEL, mg7.class);
            c("live", DI.LIVE_PLAYER, qh7.class);
            c("live", DI.ROUTER_NAME, vh7.class);
            c("live", "share", bi7.class);
            c("live", DI.TB.SHARE_CHANNEL, zh7.class);
            c("live", DI.THIRD_PART_ACCOUNT, di7.class);
            c("live", DI.YY.THIRD_PART_ALI_RECHARGE, ei7.class);
            c("live", DI.YY.THIRD_PART_WX_RECHARGE, gi7.class);
            c("live", DI.TOAST_NAME, ii7.class);
            c("live", DI.YYPAY.YY_PAY, gh7.class);
            c("live", DI.YY.YY_PLUGIN, YYPluginManageServiceFetcher.class);
            c("logsystem", "exceptionhandler", ExceptionHandlerServiceFetcher.class);
            c("nad.core", "adRequester", vx0.class);
            c("nad.core", "browserDownload", qi0.class);
            c("nad.core", "cmd", yl5.class);
            c("nad.core", UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME, zl5.class);
            c("nad.core", "crius", bi0.class);
            c("nad.core", "deviceInfoInner", of0.class);
            c("nad.core", "eventbus", dk0.class);
            c("nad.core", "exp", sk0.class);
            c("nad.core", "ipdx", rf0.class);
            c("nad.core", "loadImage", af0.class);
            c("nad.core", "loadVideo", st0.class);
            c("nad.core", "maxUI", bm5.class);
            c("nad.core", "navBarTool", dm5.class);
            c("nad.core", "splash.config", em5.class);
            c("nad.core", "splash.host", fm5.class);
            c("nad.core", "thirdService", cm5.class);
            c("speed", "runtime", SpeedRuntimeProvider.class);
            c("tbBaseEmotion", "EmotionService", j46.class);
            c("tbadkcore", "IHttpsExperiment", HttpsExperimentFetcher.class);
            c("tbadkcore", "INetExperiment", NetExperimentFetcher.class);
            c("tbadkcore", "ISoProcess", i75.class);
            c(UBCCloudControlProcessor.UBC_KEY, UBC.TAG, i29.class);
            c("voyager", StatConstants.VALUE_TYPE_UPLOAD, za9.class);
            c("yaLog", "yaLogConfig", wb9.class);
        }
    }
}
