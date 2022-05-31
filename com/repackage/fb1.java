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
/* loaded from: classes5.dex */
public class fb1 {
    public static /* synthetic */ Interceptable $ic;
    public static final ConcurrentHashMap<ServiceReference, eb1<?>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755713700, "Lcom/repackage/fb1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755713700, "Lcom/repackage/fb1;");
                return;
            }
        }
        a = new ConcurrentHashMap<>();
        d();
    }

    public fb1() {
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
            eb1<?> eb1Var = a.get(serviceReference);
            if (eb1Var != null) {
                return (T) eb1Var.getService();
            }
            return null;
        }
        return (T) invokeL.objValue;
    }

    public static <T> void b(ServiceReference serviceReference, eb1<T> eb1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, serviceReference, eb1Var) == null) {
            a.put(serviceReference, eb1Var);
        }
    }

    public static <T> void c(String str, String str2, Class<? extends eb1<T>> cls) {
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
            c("Frs", "FrsService", tb6.class);
            c("HotTopic", "HotTopicRequest", ig5.class);
            c("device_score", "DEVICE_SCORE", DeviceScoreFetcher.class);
            c("device_score", "DEVICE_SCORE_COLLECT", DeviceScoreCollectFetcher.class);
            c("device_score", "DEVICE_SCORE_CONFIG", DeviceScoreConfigFetcher.class);
            c("live", "ab", le7.class);
            c("live", DI.ACCOUNT, ae7.class);
            c("live", DI.APP_INFO_NAME, ce7.class);
            c("live", DI.EXT.EXT_LIVE_JUMP_PAGE, re7.class);
            c("live", DI.EXT.EXT_LIVE_LOG, ye7.class);
            c("live", DI.FOLLOW_STATUS, pe7.class);
            c("live", DI.LIGHTBROWSER_VIEW, he7.class);
            c("live", DI.LIVE_CUSTOM_SETTINGS, uf7.class);
            c("live", DI.LIVE_EVENT_DISPATCHER, ne7.class);
            c("live", DI.LIVE_LIKE, te7.class);
            c("live", DI.LIVE_LOCATION, we7.class);
            c("live", DI.LIVE_REAL_AUTH, ee7.class);
            c("live", DI.LIVE_SHOW_VIDEO_PLAYER, gf7.class);
            c("live", "net", af7.class);
            c("live", DI.PAY_CHANNEL, je7.class);
            c("live", DI.LIVE_PLAYER, nf7.class);
            c("live", DI.ROUTER_NAME, sf7.class);
            c("live", "share", yf7.class);
            c("live", DI.TB.SHARE_CHANNEL, wf7.class);
            c("live", DI.THIRD_PART_ACCOUNT, ag7.class);
            c("live", DI.YY.THIRD_PART_ALI_RECHARGE, bg7.class);
            c("live", DI.YY.THIRD_PART_WX_RECHARGE, dg7.class);
            c("live", "toast", fg7.class);
            c("live", DI.YYPAY.YY_PAY, df7.class);
            c("live", DI.YY.YY_PLUGIN, YYPluginManageServiceFetcher.class);
            c("logsystem", "exceptionhandler", ExceptionHandlerServiceFetcher.class);
            c("nad.core", "adRequester", ex0.class);
            c("nad.core", "browserDownload", ci0.class);
            c("nad.core", "cmd", yj5.class);
            c("nad.core", UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME, zj5.class);
            c("nad.core", "crius", oh0.class);
            c("nad.core", "deviceInfoInner", ef0.class);
            c("nad.core", "eventbus", mj0.class);
            c("nad.core", "exp", bk0.class);
            c("nad.core", "ipdx", hf0.class);
            c("nad.core", "loadImage", re0.class);
            c("nad.core", "loadVideo", bt0.class);
            c("nad.core", "maxUI", bk5.class);
            c("nad.core", "navBarTool", dk5.class);
            c("nad.core", "splash.config", ek5.class);
            c("nad.core", "splash.host", fk5.class);
            c("nad.core", "thirdService", ck5.class);
            c("speed", "runtime", SpeedRuntimeProvider.class);
            c("tbBaseEmotion", "EmotionService", l26.class);
            c("tbadkcore", "IHttpsExperiment", HttpsExperimentFetcher.class);
            c("tbadkcore", "INetExperiment", NetExperimentFetcher.class);
            c("tbadkcore", "ISoProcess", r55.class);
            c(UBCCloudControlProcessor.UBC_KEY, UBC.TAG, b19.class);
            c("voyager", StatConstants.VALUE_TYPE_UPLOAD, s99.class);
            c("yaLog", "yaLogConfig", pa9.class);
        }
    }
}
