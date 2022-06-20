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
public class qb1 {
    public static /* synthetic */ Interceptable $ic;
    public static final ConcurrentHashMap<ServiceReference, pb1<?>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755385999, "Lcom/repackage/qb1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755385999, "Lcom/repackage/qb1;");
                return;
            }
        }
        a = new ConcurrentHashMap<>();
        d();
    }

    public qb1() {
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
            pb1<?> pb1Var = a.get(serviceReference);
            if (pb1Var != null) {
                return (T) pb1Var.getService();
            }
            return null;
        }
        return (T) invokeL.objValue;
    }

    public static <T> void b(ServiceReference serviceReference, pb1<T> pb1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, serviceReference, pb1Var) == null) {
            a.put(serviceReference, pb1Var);
        }
    }

    public static <T> void c(String str, String str2, Class<? extends pb1<T>> cls) {
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
            c("Frs", "FrsService", tc6.class);
            c("HotTopic", "HotTopicRequest", fh5.class);
            c("device_score", "DEVICE_SCORE", DeviceScoreFetcher.class);
            c("device_score", "DEVICE_SCORE_COLLECT", DeviceScoreCollectFetcher.class);
            c("device_score", "DEVICE_SCORE_CONFIG", DeviceScoreConfigFetcher.class);
            c("live", "ab", wf7.class);
            c("live", DI.ACCOUNT, lf7.class);
            c("live", DI.APP_INFO_NAME, nf7.class);
            c("live", DI.EXT.EXT_LIVE_JUMP_PAGE, cg7.class);
            c("live", DI.EXT.EXT_LIVE_LOG, jg7.class);
            c("live", DI.FOLLOW_STATUS, ag7.class);
            c("live", DI.LIGHTBROWSER_VIEW, sf7.class);
            c("live", DI.LIVE_CUSTOM_SETTINGS, fh7.class);
            c("live", DI.LIVE_EVENT_DISPATCHER, yf7.class);
            c("live", DI.LIVE_LIKE, eg7.class);
            c("live", DI.LIVE_LOCATION, hg7.class);
            c("live", DI.LIVE_REAL_AUTH, pf7.class);
            c("live", DI.LIVE_SHOW_VIDEO_PLAYER, rg7.class);
            c("live", "net", lg7.class);
            c("live", DI.PAY_CHANNEL, uf7.class);
            c("live", DI.LIVE_PLAYER, yg7.class);
            c("live", DI.ROUTER_NAME, dh7.class);
            c("live", "share", jh7.class);
            c("live", DI.TB.SHARE_CHANNEL, hh7.class);
            c("live", DI.THIRD_PART_ACCOUNT, lh7.class);
            c("live", DI.YY.THIRD_PART_ALI_RECHARGE, mh7.class);
            c("live", DI.YY.THIRD_PART_WX_RECHARGE, oh7.class);
            c("live", "toast", qh7.class);
            c("live", DI.YYPAY.YY_PAY, og7.class);
            c("live", DI.YY.YY_PLUGIN, YYPluginManageServiceFetcher.class);
            c("logsystem", "exceptionhandler", ExceptionHandlerServiceFetcher.class);
            c("nad.core", "adRequester", ix0.class);
            c("nad.core", "browserDownload", gi0.class);
            c("nad.core", "cmd", vk5.class);
            c("nad.core", UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME, wk5.class);
            c("nad.core", "crius", sh0.class);
            c("nad.core", "deviceInfoInner", if0.class);
            c("nad.core", "eventbus", qj0.class);
            c("nad.core", "exp", fk0.class);
            c("nad.core", "ipdx", lf0.class);
            c("nad.core", "loadImage", ve0.class);
            c("nad.core", "loadVideo", ft0.class);
            c("nad.core", "maxUI", yk5.class);
            c("nad.core", "navBarTool", al5.class);
            c("nad.core", "splash.config", bl5.class);
            c("nad.core", "splash.host", cl5.class);
            c("nad.core", "thirdService", zk5.class);
            c("speed", "runtime", SpeedRuntimeProvider.class);
            c("tbBaseEmotion", "EmotionService", l36.class);
            c("tbadkcore", "IHttpsExperiment", HttpsExperimentFetcher.class);
            c("tbadkcore", "INetExperiment", NetExperimentFetcher.class);
            c("tbadkcore", "ISoProcess", g65.class);
            c(UBCCloudControlProcessor.UBC_KEY, UBC.TAG, j19.class);
            c("voyager", StatConstants.VALUE_TYPE_UPLOAD, aa9.class);
            c("yaLog", "yaLogConfig", xa9.class);
        }
    }
}
