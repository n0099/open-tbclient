package com.yy.hiidostatis.defs.handler;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.api.MetricsWorker;
import com.yy.hiidostatis.defs.controller.HttpSendController;
import com.yy.hiidostatis.inner.AbstractConfig;
import com.yy.hiidostatis.inner.util.SharedTimerTask;
import com.yy.hiidostatis.inner.util.ThreadPool;
import com.yy.hiidostatis.inner.util.http.MetricsHttpEncryptUtil;
import com.yy.hiidostatis.inner.util.log.L;
import com.yy.hiidostatis.pref.HdStatisConfig;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes8.dex */
public class MetricsHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String appkey;
    public long defaultMetricsExpire;
    public Context mContext;
    public HttpSendController metricsSend;
    public Map<String, MetricsWorker> metricsWorkerMap;
    public Map<String, TimeWorker> timers;
    public String ver;

    /* loaded from: classes8.dex */
    public class TimeWorker {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long interval;
        public final /* synthetic */ MetricsHandler this$0;
        public volatile SharedTimerTask timerTask;
        public MetricsWorker worker;

        public TimeWorker(MetricsHandler metricsHandler, MetricsWorker metricsWorker, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {metricsHandler, metricsWorker, Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = metricsHandler;
            this.worker = metricsWorker;
            this.interval = j2;
        }

        public synchronized void beginTimer() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this) {
                    if (this.timerTask != null) {
                        return;
                    }
                    this.timerTask = new SharedTimerTask(this) { // from class: com.yy.hiidostatis.defs.handler.MetricsHandler.TimeWorker.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ TimeWorker this$1;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$1 = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.this$1.worker.sendNow();
                            }
                        }
                    };
                    ThreadPool.getPool().getTimer().schedule(this.timerTask, this.interval * 1000, 1000 * this.interval);
                }
            }
        }

        public synchronized void stopTimer() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                synchronized (this) {
                    if (this.timerTask == null) {
                        return;
                    }
                    this.timerTask.cancel();
                    this.timerTask = null;
                }
            }
        }
    }

    public MetricsHandler(Context context, String str, String str2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.metricsWorkerMap = new ConcurrentHashMap();
        this.timers = new ConcurrentHashMap();
        this.mContext = context;
        this.appkey = str;
        this.ver = str2;
        this.defaultMetricsExpire = j2;
    }

    private MetricsWorker addMetricsWorker(String str, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{str, Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            MetricsWorker createMetricsWorker = createMetricsWorker(j2, j3);
            if (createMetricsWorker != null) {
                this.metricsWorkerMap.put(str, createMetricsWorker);
                TimeWorker timeWorker = new TimeWorker(this, createMetricsWorker, j3);
                timeWorker.beginTimer();
                this.timers.put(str, timeWorker);
            } else {
                L.debug(this, "Create %s MetricsWorker error", str);
            }
            return createMetricsWorker;
        }
        return (MetricsWorker) invokeCommon.objValue;
    }

    private MetricsWorker createMetricsWorker(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) ? createMetricsWorker(j2, j3, this.appkey, this.ver) : (MetricsWorker) invokeCommon.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MetricsWorker getMetricsWorkerByName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, str)) == null) {
            if (str == null || str.isEmpty()) {
                return null;
            }
            return this.metricsWorkerMap.get(str);
        }
        return (MetricsWorker) invokeL.objValue;
    }

    public boolean containMetric(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? this.metricsWorkerMap.containsKey(str) : invokeL.booleanValue;
    }

    public String getVer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.ver : (String) invokeV.objValue;
    }

    public void onBackground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ThreadPool.getPool().executeQueue(new Runnable(this) { // from class: com.yy.hiidostatis.defs.handler.MetricsHandler.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MetricsHandler this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        for (Map.Entry entry : this.this$0.metricsWorkerMap.entrySet()) {
                            ((MetricsWorker) entry.getValue()).sendNow();
                        }
                    }
                }
            });
        }
    }

    public void onExit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ThreadPool.getPool().executeQueue(new Runnable(this) { // from class: com.yy.hiidostatis.defs.handler.MetricsHandler.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MetricsHandler this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        for (Map.Entry entry : this.this$0.timers.entrySet()) {
                            ((TimeWorker) entry.getValue()).stopTimer();
                        }
                        for (Map.Entry entry2 : this.this$0.metricsWorkerMap.entrySet()) {
                            ((MetricsWorker) entry2.getValue()).sendNow();
                        }
                    }
                }
            });
        }
    }

    public void onForeground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ThreadPool.getPool().executeQueue(new Runnable(this) { // from class: com.yy.hiidostatis.defs.handler.MetricsHandler.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MetricsHandler this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        for (Map.Entry entry : this.this$0.timers.entrySet()) {
                            ((TimeWorker) entry.getValue()).beginTimer();
                        }
                    }
                }
            });
        }
    }

    public void reportCount(String str, int i2, String str2, String str3, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, Integer.valueOf(i2), str2, str3, Long.valueOf(j2)}) == null) {
            ThreadPool.getPool().executeQueue(new Runnable(this, str, i2, str2, str3, j2) { // from class: com.yy.hiidostatis.defs.handler.MetricsHandler.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MetricsHandler this$0;
                public final /* synthetic */ long val$count;
                public final /* synthetic */ String val$countName;
                public final /* synthetic */ String val$metricsName;
                public final /* synthetic */ int val$scode;
                public final /* synthetic */ String val$uri;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, Integer.valueOf(i2), str2, str3, Long.valueOf(j2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$metricsName = str;
                    this.val$scode = i2;
                    this.val$uri = str2;
                    this.val$countName = str3;
                    this.val$count = j2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        MetricsWorker metricsWorkerByName = this.this$0.getMetricsWorkerByName(this.val$metricsName);
                        if (metricsWorkerByName != null) {
                            metricsWorkerByName.reportCount(this.val$scode, this.val$uri, this.val$countName, this.val$count);
                        } else {
                            L.debug(this, "NOT Init %s MetricsWork", this.val$metricsName);
                        }
                    }
                }
            });
        }
    }

    public void reportReturnCode(String str, int i2, String str2, long j2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, Integer.valueOf(i2), str2, Long.valueOf(j2), str3}) == null) {
            reportReturnCode(str, i2, str2, j2, str3, null);
        }
    }

    public void reportSrcData(String str, int i2, String str2, String str3, long j2, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{str, Integer.valueOf(i2), str2, str3, Long.valueOf(j2), map}) == null) {
            ThreadPool.getPool().executeQueue(new Runnable(this, str, i2, str2, str3, j2, map) { // from class: com.yy.hiidostatis.defs.handler.MetricsHandler.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MetricsHandler this$0;
                public final /* synthetic */ Map val$extra;
                public final /* synthetic */ String val$metricsName;
                public final /* synthetic */ int val$scode;
                public final /* synthetic */ String val$topic;
                public final /* synthetic */ String val$uri;
                public final /* synthetic */ long val$val;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, Integer.valueOf(i2), str2, str3, Long.valueOf(j2), map};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$metricsName = str;
                    this.val$scode = i2;
                    this.val$uri = str2;
                    this.val$topic = str3;
                    this.val$val = j2;
                    this.val$extra = map;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        MetricsWorker metricsWorkerByName = this.this$0.getMetricsWorkerByName(this.val$metricsName);
                        if (metricsWorkerByName != null) {
                            metricsWorkerByName.reportSrcData(this.val$scode, this.val$uri, this.val$topic, this.val$val, this.val$extra);
                        } else {
                            L.debug(this, "NOT Init %s MetricsWork", this.val$metricsName);
                        }
                    }
                }
            });
        }
    }

    public void setVer(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.ver = str;
        }
    }

    private MetricsWorker createMetricsWorker(long j2, long j3, String str, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str, str2})) == null) {
            try {
                AbstractConfig config = HdStatisConfig.getConfig(str);
                File file = new File(this.mContext.getCacheDir().getAbsolutePath() + "/hiido_metrics");
                file.mkdirs();
                if (this.metricsSend == null) {
                    this.metricsSend = new HttpSendController(new MetricsHttpEncryptUtil(), file, 20, 2);
                }
                return new MetricsWorker(this.mContext, 10, this.metricsSend, j2, str, str2, config.getSdkVer());
            } catch (Throwable unused) {
                return null;
            }
        }
        return (MetricsWorker) invokeCommon.objValue;
    }

    public void reportCount(String str, int i2, String str2, String str3, long j2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{str, Integer.valueOf(i2), str2, str3, Long.valueOf(j2), Integer.valueOf(i3)}) == null) {
            ThreadPool.getPool().executeQueue(new Runnable(this, str, i2, str2, str3, j2, i3) { // from class: com.yy.hiidostatis.defs.handler.MetricsHandler.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MetricsHandler this$0;
                public final /* synthetic */ long val$count;
                public final /* synthetic */ String val$countName;
                public final /* synthetic */ String val$metricsName;
                public final /* synthetic */ int val$scode;
                public final /* synthetic */ int val$times;
                public final /* synthetic */ String val$uri;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, Integer.valueOf(i2), str2, str3, Long.valueOf(j2), Integer.valueOf(i3)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$metricsName = str;
                    this.val$scode = i2;
                    this.val$uri = str2;
                    this.val$countName = str3;
                    this.val$count = j2;
                    this.val$times = i3;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        MetricsWorker metricsWorkerByName = this.this$0.getMetricsWorkerByName(this.val$metricsName);
                        if (metricsWorkerByName != null) {
                            metricsWorkerByName.reportCount(this.val$scode, this.val$uri, this.val$countName, this.val$count, this.val$times);
                        } else {
                            L.debug(this, "NOT Init %s MetricsWork", this.val$metricsName);
                        }
                    }
                }
            });
        }
    }

    public void reportReturnCode(String str, int i2, String str2, long j2, String str3, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{str, Integer.valueOf(i2), str2, Long.valueOf(j2), str3, map}) == null) {
            ThreadPool.getPool().executeQueue(new Runnable(this, str, i2, str2, j2, str3, map) { // from class: com.yy.hiidostatis.defs.handler.MetricsHandler.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MetricsHandler this$0;
                public final /* synthetic */ String val$code;
                public final /* synthetic */ String val$metricsName;
                public final /* synthetic */ Map val$moreinfo;
                public final /* synthetic */ int val$scode;
                public final /* synthetic */ long val$timeConsumption;
                public final /* synthetic */ String val$uri;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, Integer.valueOf(i2), str2, Long.valueOf(j2), str3, map};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$metricsName = str;
                    this.val$scode = i2;
                    this.val$uri = str2;
                    this.val$timeConsumption = j2;
                    this.val$code = str3;
                    this.val$moreinfo = map;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        MetricsWorker metricsWorkerByName = this.this$0.getMetricsWorkerByName(this.val$metricsName);
                        if (metricsWorkerByName != null) {
                            metricsWorkerByName.reportReturnCode(this.val$scode, this.val$uri, this.val$timeConsumption, this.val$code, this.val$moreinfo);
                        } else {
                            L.debug(this, "NOT Init %s MetricsWork", this.val$metricsName);
                        }
                    }
                }
            });
        }
    }

    public MetricsWorker addMetricsWorker(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048576, this, str, j2)) == null) {
            if (this.metricsWorkerMap.containsKey(str)) {
                return null;
            }
            return addMetricsWorker(str, this.defaultMetricsExpire, j2);
        }
        return (MetricsWorker) invokeLJ.objValue;
    }
}
