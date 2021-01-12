package com.kwai.video.ksvodplayerkit.d;

import android.content.Context;
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
/* loaded from: classes4.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    private Context f11066b;
    private HodorDebugInfoView c;
    private AtomicBoolean d = new AtomicBoolean(false);
    private final Object e = new Object();

    /* renamed from: a  reason: collision with root package name */
    private d f11065a = i.a().t();
    private Map<String, g> f = new LinkedHashMap(200);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends AwesomeCacheCallback {

        /* renamed from: b  reason: collision with root package name */
        private com.kwai.video.ksvodplayerkit.d.b f11068b;

        a(com.kwai.video.ksvodplayerkit.d.b bVar) {
            this.f11068b = bVar;
        }

        @Override // com.kwai.video.cache.AwesomeCacheCallback
        public void onDownloadFinish(AcCallBackInfo acCallBackInfo) {
            if (this.f11068b == null) {
                return;
            }
            switch (acCallBackInfo.stopReason) {
                case 1:
                case 2:
                    com.kwai.video.ksvodplayerkit.a.b.b("KSVodPrefetcher", this.f11068b.g + ", stopReason:" + AcCallBackInfo.stopReasonToString(acCallBackInfo.stopReason) + ", taskState:" + acCallBackInfo.getTaskStateString());
                    c.this.a(acCallBackInfo, this.f11068b);
                    return;
                default:
                    if (acCallBackInfo.stopReason == 3) {
                        if (!com.kwai.video.ksvodplayerkit.c.a.a(c.this.f11066b)) {
                            com.kwai.video.ksvodplayerkit.a.b.b("KSVodPrefetcher", this.f11068b.g + ", stopReason:" + AcCallBackInfo.stopReasonToString(acCallBackInfo.stopReason) + ", taskState:" + acCallBackInfo.getTaskStateString());
                            c.this.a(acCallBackInfo, this.f11068b);
                            return;
                        }
                        if (c.this.a(this.f11068b.a(), this.f11068b) >= 0) {
                            com.kwai.video.ksvodplayerkit.a.b.e("KSVodPrefetcher", "onDownloadFinish stop_reason:" + acCallBackInfo.stopReason + ", switch next url success!");
                            return;
                        }
                        com.kwai.video.ksvodplayerkit.a.b.b("KSVodPrefetcher", this.f11068b.g + ", stopReason:" + AcCallBackInfo.stopReasonToString(acCallBackInfo.stopReason) + ", taskState:" + acCallBackInfo.getTaskStateString());
                        c.this.a(acCallBackInfo, this.f11068b);
                        com.kwai.video.ksvodplayerkit.a.b.e("KSVodPrefetcher", "onDownloadFinish stop_reason:" + acCallBackInfo.stopReason + ", switch next url failed!");
                        return;
                    }
                    return;
            }
        }

        @Override // com.kwai.video.cache.AwesomeCacheCallback
        public void onSessionProgress(AcCallBackInfo acCallBackInfo) {
            if (acCallBackInfo == null || this.f11068b == null) {
                return;
            }
            com.kwai.video.ksvodplayerkit.a.b.b("KSVodPrefetcher", this.f11068b.g + ", stopReason:" + AcCallBackInfo.stopReasonToString(acCallBackInfo.stopReason) + ", taskState:" + acCallBackInfo.getTaskStateString());
        }
    }

    /* loaded from: classes4.dex */
    private static class b {

        /* renamed from: a  reason: collision with root package name */
        private static c f11069a = new c();
    }

    protected c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(AbstractHodorPreloadTask abstractHodorPreloadTask, com.kwai.video.ksvodplayerkit.d.b bVar) {
        if (c() <= 0 && d() <= 0) {
            com.kwai.video.ksvodplayerkit.a.b.b("KSVodPrefetcher", "Invalid preload size, not submit task");
            return -1;
        } else if (abstractHodorPreloadTask != null) {
            if (abstractHodorPreloadTask instanceof VodAdaptivePreloadPriorityTask) {
                if (d() <= 0) {
                    com.kwai.video.ksvodplayerkit.a.b.b("KSVodPrefetcher", "Invalid preloadMs:" + d() + ", not submit task ");
                    return -1;
                }
                ((VodAdaptivePreloadPriorityTask) abstractHodorPreloadTask).setPreloadDurationMs(d());
            } else if (abstractHodorPreloadTask instanceof MediaPreloadPriorityTask) {
                if (c() <= 0) {
                    com.kwai.video.ksvodplayerkit.a.b.b("KSVodPrefetcher", "Invalid preloadBytes:" + c() + ", not submit task ");
                    return -1;
                }
                ((MediaPreloadPriorityTask) abstractHodorPreloadTask).setPreloadBytes(c());
            }
            com.kwai.video.ksvodplayerkit.a.b.b("KSVodPrefetcher", "submit task：" + bVar.g + ", priority：" + bVar.c());
            abstractHodorPreloadTask.setAwesomeCacheCallback(new a(bVar));
            abstractHodorPreloadTask.setPriority(bVar.c());
            abstractHodorPreloadTask.setMaxSpeedKbps(this.f11065a.j);
            abstractHodorPreloadTask.setOnlyPreloadUnderSpeedKbps(this.f11065a.c);
            abstractHodorPreloadTask.setBizType("KSVodPrefetcher");
            abstractHodorPreloadTask.setGroupName("KSDownloaderKit");
            abstractHodorPreloadTask.submit();
            return 0;
        } else {
            return -1;
        }
    }

    public static c a() {
        return b.f11069a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AcCallBackInfo acCallBackInfo, com.kwai.video.ksvodplayerkit.d.b bVar) {
        if (acCallBackInfo == null || acCallBackInfo.cdnStatJson == null || bVar == null) {
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
        } catch (JSONException e) {
            e.printStackTrace();
        }
        com.kwai.video.ksvodplayerkit.a.c.b(jSONObject.toString());
    }

    private void b(Context context) {
    }

    private void b(AcCallBackInfo acCallBackInfo, com.kwai.video.ksvodplayerkit.d.b bVar) {
        int i = 0;
        if (acCallBackInfo == null || bVar == null || bVar.e() == null) {
            return;
        }
        g gVar = new g(acCallBackInfo.stopReason == 1, acCallBackInfo.currentUri, acCallBackInfo.contentLength, acCallBackInfo.downloadBytes);
        synchronized (this.e) {
            if (this.f.size() >= 200) {
                Iterator<Map.Entry<String, g>> it = this.f.entrySet().iterator();
                while (it.hasNext()) {
                    it.next();
                    it.remove();
                    i++;
                    if (i >= 20) {
                        break;
                    }
                }
            }
            this.f.put(bVar.e(), gVar);
        }
    }

    private long c() {
        return com.kwai.video.ksvodplayerkit.c.a.d(this.f11066b) == 1 ? this.f11065a.d : this.f11065a.e;
    }

    private long d() {
        return com.kwai.video.ksvodplayerkit.c.a.d(this.f11066b) == 1 ? this.f11065a.f : this.f11065a.g;
    }

    public int a(com.kwai.video.ksvodplayerkit.d.b bVar) {
        if (bVar instanceof com.kwai.video.ksvodplayerkit.d.a) {
            ((com.kwai.video.ksvodplayerkit.d.a) bVar).a(this.f11066b);
        }
        if (this.c != null && i.a().m()) {
            this.c.setVisibility(0);
            this.c.startTimer();
        }
        return a(bVar.b(), bVar);
    }

    public g a(String str) {
        g gVar = new g();
        if (str != null) {
            synchronized (this.e) {
                if (this.f.containsKey(str)) {
                    gVar = this.f.get(str);
                }
            }
        }
        return gVar;
    }

    public void a(Context context) {
        if (this.d.get()) {
            return;
        }
        this.f11066b = context;
        HodorConfig.setPreloadV3VodBufferLowRatio(this.f11065a.h);
        HodorConfig.setPreloadV3VodCacheKbThresholdWhenPrepare(this.f11065a.k);
        HodorConfig.setPreloadV3VodPausePreloadMaxCountDueToBufferLow(this.f11065a.i);
        b(this.f11066b);
        this.d.set(true);
    }

    public void b() {
        com.kwai.video.ksvodplayerkit.a.b.b("KSVodPrefetcher", "remove all task");
        Hodor.instance().cancelAllTasksOfGroupName("KSDownloaderKit");
        if (this.c != null) {
            this.c.stopTimer();
        }
    }
}
