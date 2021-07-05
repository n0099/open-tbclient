package com.kwai.video.ksvodplayerkit.d;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.video.cache.AcCallBackInfo;
import com.kwai.video.cache.AwesomeCacheCallback;
import com.kwai.video.hodor.AbstractHodorPreloadTask;
import com.kwai.video.hodor.Hodor;
import com.kwai.video.hodor.HodorConfig;
import com.kwai.video.hodor.MediaPreloadPriorityTask;
import com.kwai.video.hodor.VodAdaptivePreloadPriorityTask;
import com.kwai.video.hodor_debug_tools.debuginfo.HodorDebugInfoView;
import com.kwai.video.ksvodplayerkit.i;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d f39931a;

    /* renamed from: b  reason: collision with root package name */
    public Context f39932b;

    /* renamed from: c  reason: collision with root package name */
    public HodorDebugInfoView f39933c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicBoolean f39934d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f39935e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, g> f39936f;

    /* loaded from: classes7.dex */
    public class a extends AwesomeCacheCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f39937a;

        /* renamed from: b  reason: collision with root package name */
        public com.kwai.video.ksvodplayerkit.d.b f39938b;

        public a(c cVar, com.kwai.video.ksvodplayerkit.d.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39937a = cVar;
            this.f39938b = bVar;
        }

        @Override // com.kwai.video.cache.AwesomeCacheCallback
        public void onDownloadFinish(AcCallBackInfo acCallBackInfo) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, acCallBackInfo) == null) || this.f39938b == null) {
                return;
            }
            int i2 = acCallBackInfo.stopReason;
            if (i2 == 1 || i2 == 2) {
                com.kwai.video.ksvodplayerkit.a.b.b("KSVodPrefetcher", this.f39938b.f39930g + ", stopReason:" + AcCallBackInfo.stopReasonToString(acCallBackInfo.stopReason) + ", taskState:" + acCallBackInfo.getTaskStateString());
                this.f39937a.a(acCallBackInfo, this.f39938b);
            } else if (i2 == 3) {
                if (!com.kwai.video.ksvodplayerkit.c.a.a(this.f39937a.f39932b)) {
                    com.kwai.video.ksvodplayerkit.a.b.b("KSVodPrefetcher", this.f39938b.f39930g + ", stopReason:" + AcCallBackInfo.stopReasonToString(acCallBackInfo.stopReason) + ", taskState:" + acCallBackInfo.getTaskStateString());
                    this.f39937a.a(acCallBackInfo, this.f39938b);
                    return;
                }
                if (this.f39937a.a(this.f39938b.a(), this.f39938b) >= 0) {
                    com.kwai.video.ksvodplayerkit.a.b.e("KSVodPrefetcher", "onDownloadFinish stop_reason:" + acCallBackInfo.stopReason + ", switch next url success!");
                    return;
                }
                com.kwai.video.ksvodplayerkit.a.b.b("KSVodPrefetcher", this.f39938b.f39930g + ", stopReason:" + AcCallBackInfo.stopReasonToString(acCallBackInfo.stopReason) + ", taskState:" + acCallBackInfo.getTaskStateString());
                this.f39937a.a(acCallBackInfo, this.f39938b);
                StringBuilder sb = new StringBuilder();
                sb.append("onDownloadFinish stop_reason:");
                sb.append(acCallBackInfo.stopReason);
                sb.append(", switch next url failed!");
                com.kwai.video.ksvodplayerkit.a.b.e("KSVodPrefetcher", sb.toString());
            }
        }

        @Override // com.kwai.video.cache.AwesomeCacheCallback
        public void onSessionProgress(AcCallBackInfo acCallBackInfo) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, acCallBackInfo) == null) || acCallBackInfo == null || this.f39938b == null) {
                return;
            }
            com.kwai.video.ksvodplayerkit.a.b.b("KSVodPrefetcher", this.f39938b.f39930g + ", stopReason:" + AcCallBackInfo.stopReasonToString(acCallBackInfo.stopReason) + ", taskState:" + acCallBackInfo.getTaskStateString());
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static c f39939a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(686233517, "Lcom/kwai/video/ksvodplayerkit/d/c$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(686233517, "Lcom/kwai/video/ksvodplayerkit/d/c$b;");
                    return;
                }
            }
            f39939a = new c();
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f39934d = new AtomicBoolean(false);
        this.f39935e = new Object();
        this.f39931a = i.a().t();
        this.f39936f = new LinkedHashMap(200);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(AbstractHodorPreloadTask abstractHodorPreloadTask, com.kwai.video.ksvodplayerkit.d.b bVar) {
        InterceptResult invokeLL;
        StringBuilder sb;
        long c2;
        String sb2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, abstractHodorPreloadTask, bVar)) == null) {
            if (c() <= 0 && d() <= 0) {
                sb2 = "Invalid preload size, not submit task";
            } else if (abstractHodorPreloadTask == null) {
                return -1;
            } else {
                if (!(abstractHodorPreloadTask instanceof VodAdaptivePreloadPriorityTask)) {
                    if (abstractHodorPreloadTask instanceof MediaPreloadPriorityTask) {
                        if (c() <= 0) {
                            sb = new StringBuilder();
                            sb.append("Invalid preloadBytes:");
                            c2 = c();
                            sb.append(c2);
                            sb.append(", not submit task ");
                            sb2 = sb.toString();
                        } else {
                            ((MediaPreloadPriorityTask) abstractHodorPreloadTask).setPreloadBytes(c());
                        }
                    }
                    com.kwai.video.ksvodplayerkit.a.b.b("KSVodPrefetcher", "submit task：" + bVar.f39930g + ", priority：" + bVar.c());
                    abstractHodorPreloadTask.setAwesomeCacheCallback(new a(this, bVar));
                    abstractHodorPreloadTask.setPriority(bVar.c());
                    abstractHodorPreloadTask.setMaxSpeedKbps(this.f39931a.j);
                    abstractHodorPreloadTask.setOnlyPreloadUnderSpeedKbps(this.f39931a.f39942c);
                    abstractHodorPreloadTask.setBizType("KSVodPrefetcher");
                    abstractHodorPreloadTask.setGroupName("KSDownloaderKit");
                    abstractHodorPreloadTask.submit();
                    return 0;
                } else if (d() > 0) {
                    ((VodAdaptivePreloadPriorityTask) abstractHodorPreloadTask).setPreloadDurationMs(d());
                    com.kwai.video.ksvodplayerkit.a.b.b("KSVodPrefetcher", "submit task：" + bVar.f39930g + ", priority：" + bVar.c());
                    abstractHodorPreloadTask.setAwesomeCacheCallback(new a(this, bVar));
                    abstractHodorPreloadTask.setPriority(bVar.c());
                    abstractHodorPreloadTask.setMaxSpeedKbps(this.f39931a.j);
                    abstractHodorPreloadTask.setOnlyPreloadUnderSpeedKbps(this.f39931a.f39942c);
                    abstractHodorPreloadTask.setBizType("KSVodPrefetcher");
                    abstractHodorPreloadTask.setGroupName("KSDownloaderKit");
                    abstractHodorPreloadTask.submit();
                    return 0;
                } else {
                    sb = new StringBuilder();
                    sb.append("Invalid preloadMs:");
                    c2 = d();
                    sb.append(c2);
                    sb.append(", not submit task ");
                    sb2 = sb.toString();
                }
            }
            com.kwai.video.ksvodplayerkit.a.b.b("KSVodPrefetcher", sb2);
            return -1;
        }
        return invokeLL.intValue;
    }

    public static c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) ? b.f39939a : (c) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AcCallBackInfo acCallBackInfo, com.kwai.video.ksvodplayerkit.d.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, acCallBackInfo, bVar) == null) || acCallBackInfo == null || acCallBackInfo.cdnStatJson == null || bVar == null) {
            return;
        }
        b(acCallBackInfo, bVar);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("qos", acCallBackInfo.cdnStatJson);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("rank", bVar.d());
            jSONObject2.put("video_id", bVar.e());
            jSONObject2.put("resource_type", "prefetch_video");
            jSONObject.put("stats", jSONObject2.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.kwai.video.ksvodplayerkit.a.c.b(jSONObject.toString());
    }

    private void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, context) == null) {
        }
    }

    private void b(AcCallBackInfo acCallBackInfo, com.kwai.video.ksvodplayerkit.d.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65544, this, acCallBackInfo, bVar) == null) || acCallBackInfo == null || bVar == null || bVar.e() == null) {
            return;
        }
        int i2 = 0;
        g gVar = new g(acCallBackInfo.stopReason == 1, acCallBackInfo.currentUri, acCallBackInfo.contentLength, acCallBackInfo.downloadBytes);
        synchronized (this.f39935e) {
            if (this.f39936f.size() >= 200) {
                Iterator<Map.Entry<String, g>> it = this.f39936f.entrySet().iterator();
                while (it.hasNext()) {
                    it.next();
                    it.remove();
                    i2++;
                    if (i2 >= 20) {
                        break;
                    }
                }
            }
            this.f39936f.put(bVar.e(), gVar);
        }
    }

    private long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) ? com.kwai.video.ksvodplayerkit.c.a.d(this.f39932b) == 1 ? this.f39931a.f39943d : this.f39931a.f39944e : invokeV.longValue;
    }

    private long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            return com.kwai.video.ksvodplayerkit.c.a.d(this.f39932b) == 1 ? this.f39931a.f39945f : this.f39931a.f39946g;
        }
        return invokeV.longValue;
    }

    public int a(com.kwai.video.ksvodplayerkit.d.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
            if (bVar instanceof com.kwai.video.ksvodplayerkit.d.a) {
                ((com.kwai.video.ksvodplayerkit.d.a) bVar).a(this.f39932b);
            }
            if (this.f39933c != null && i.a().m()) {
                this.f39933c.setVisibility(0);
                this.f39933c.startTimer();
            }
            return a(bVar.b(), bVar);
        }
        return invokeL.intValue;
    }

    public g a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            g gVar = new g();
            if (str != null) {
                synchronized (this.f39935e) {
                    if (this.f39936f.containsKey(str)) {
                        gVar = this.f39936f.get(str);
                    }
                }
            }
            return gVar;
        }
        return (g) invokeL.objValue;
    }

    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) || this.f39934d.get()) {
            return;
        }
        this.f39932b = context;
        HodorConfig.setPreloadV3VodBufferLowRatio(this.f39931a.f39947h);
        HodorConfig.setPreloadV3VodCacheKbThresholdWhenPrepare(this.f39931a.k);
        HodorConfig.setPreloadV3VodPausePreloadMaxCountDueToBufferLow(this.f39931a.f39948i);
        b(this.f39932b);
        this.f39934d.set(true);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            com.kwai.video.ksvodplayerkit.a.b.b("KSVodPrefetcher", "remove all task");
            Hodor.instance().cancelAllTasksOfGroupName("KSDownloaderKit");
            HodorDebugInfoView hodorDebugInfoView = this.f39933c;
            if (hodorDebugInfoView != null) {
                hodorDebugInfoView.stopTimer();
            }
        }
    }
}
