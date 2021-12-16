package com.xiaomi.clientreport.manager;

import android.content.Context;
import android.os.Process;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.processor.IEventProcessor;
import com.xiaomi.clientreport.processor.IPerfProcessor;
/* loaded from: classes4.dex */
public class ClientReportClient {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ClientReportClient() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            init(context, Config.defaultConfig(context), new com.xiaomi.clientreport.processor.a(context), new com.xiaomi.clientreport.processor.b(context));
        }
    }

    public static void init(Context context, Config config) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, config) == null) {
            init(context, config, new com.xiaomi.clientreport.processor.a(context), new com.xiaomi.clientreport.processor.b(context));
        }
    }

    public static void init(Context context, Config config, IEventProcessor iEventProcessor, IPerfProcessor iPerfProcessor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65539, null, context, config, iEventProcessor, iPerfProcessor) == null) {
            com.xiaomi.channel.commonutils.logger.b.c("init in process " + com.xiaomi.push.g.a(context) + " pid :" + Process.myPid() + " threadId: " + Thread.currentThread().getId());
            a.a(context).a(config, iEventProcessor, iPerfProcessor);
            if (com.xiaomi.push.g.m391a(context)) {
                com.xiaomi.channel.commonutils.logger.b.c("init in process\u3000start scheduleJob");
                a.a(context).m128a();
            }
        }
    }

    public static void reportEvent(Context context, EventClientReport eventClientReport) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, eventClientReport) == null) || eventClientReport == null) {
            return;
        }
        a.a(context).a(eventClientReport);
    }

    public static void reportPerf(Context context, PerfClientReport perfClientReport) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65541, null, context, perfClientReport) == null) || perfClientReport == null) {
            return;
        }
        a.a(context).a(perfClientReport);
    }

    public static void updateConfig(Context context, Config config) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65542, null, context, config) == null) || config == null) {
            return;
        }
        a.a(context).a(config.isEventUploadSwitchOpen(), config.isPerfUploadSwitchOpen(), config.getEventUploadFrequency(), config.getPerfUploadFrequency());
    }
}
