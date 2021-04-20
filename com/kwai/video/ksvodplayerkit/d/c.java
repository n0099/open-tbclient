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
/* loaded from: classes6.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public Context f37585b;

    /* renamed from: c  reason: collision with root package name */
    public HodorDebugInfoView f37586c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicBoolean f37587d = new AtomicBoolean(false);

    /* renamed from: e  reason: collision with root package name */
    public final Object f37588e = new Object();

    /* renamed from: a  reason: collision with root package name */
    public d f37584a = i.a().t();

    /* renamed from: f  reason: collision with root package name */
    public Map<String, g> f37589f = new LinkedHashMap(200);

    /* loaded from: classes6.dex */
    public class a extends AwesomeCacheCallback {

        /* renamed from: b  reason: collision with root package name */
        public com.kwai.video.ksvodplayerkit.d.b f37591b;

        public a(com.kwai.video.ksvodplayerkit.d.b bVar) {
            this.f37591b = bVar;
        }

        @Override // com.kwai.video.cache.AwesomeCacheCallback
        public void onDownloadFinish(AcCallBackInfo acCallBackInfo) {
            if (this.f37591b == null) {
                return;
            }
            int i = acCallBackInfo.stopReason;
            if (i == 1 || i == 2) {
                com.kwai.video.ksvodplayerkit.a.b.b("KSVodPrefetcher", this.f37591b.f37583g + ", stopReason:" + AcCallBackInfo.stopReasonToString(acCallBackInfo.stopReason) + ", taskState:" + acCallBackInfo.getTaskStateString());
                c.this.a(acCallBackInfo, this.f37591b);
            } else if (i == 3) {
                if (!com.kwai.video.ksvodplayerkit.c.a.a(c.this.f37585b)) {
                    com.kwai.video.ksvodplayerkit.a.b.b("KSVodPrefetcher", this.f37591b.f37583g + ", stopReason:" + AcCallBackInfo.stopReasonToString(acCallBackInfo.stopReason) + ", taskState:" + acCallBackInfo.getTaskStateString());
                    c.this.a(acCallBackInfo, this.f37591b);
                    return;
                }
                if (c.this.a(this.f37591b.a(), this.f37591b) >= 0) {
                    com.kwai.video.ksvodplayerkit.a.b.e("KSVodPrefetcher", "onDownloadFinish stop_reason:" + acCallBackInfo.stopReason + ", switch next url success!");
                    return;
                }
                com.kwai.video.ksvodplayerkit.a.b.b("KSVodPrefetcher", this.f37591b.f37583g + ", stopReason:" + AcCallBackInfo.stopReasonToString(acCallBackInfo.stopReason) + ", taskState:" + acCallBackInfo.getTaskStateString());
                c.this.a(acCallBackInfo, this.f37591b);
                StringBuilder sb = new StringBuilder();
                sb.append("onDownloadFinish stop_reason:");
                sb.append(acCallBackInfo.stopReason);
                sb.append(", switch next url failed!");
                com.kwai.video.ksvodplayerkit.a.b.e("KSVodPrefetcher", sb.toString());
            }
        }

        @Override // com.kwai.video.cache.AwesomeCacheCallback
        public void onSessionProgress(AcCallBackInfo acCallBackInfo) {
            if (acCallBackInfo == null || this.f37591b == null) {
                return;
            }
            com.kwai.video.ksvodplayerkit.a.b.b("KSVodPrefetcher", this.f37591b.f37583g + ", stopReason:" + AcCallBackInfo.stopReasonToString(acCallBackInfo.stopReason) + ", taskState:" + acCallBackInfo.getTaskStateString());
        }
    }

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static c f37592a = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(AbstractHodorPreloadTask abstractHodorPreloadTask, com.kwai.video.ksvodplayerkit.d.b bVar) {
        StringBuilder sb;
        long c2;
        String sb2;
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
                com.kwai.video.ksvodplayerkit.a.b.b("KSVodPrefetcher", "submit task：" + bVar.f37583g + ", priority：" + bVar.c());
                abstractHodorPreloadTask.setAwesomeCacheCallback(new a(bVar));
                abstractHodorPreloadTask.setPriority(bVar.c());
                abstractHodorPreloadTask.setMaxSpeedKbps(this.f37584a.j);
                abstractHodorPreloadTask.setOnlyPreloadUnderSpeedKbps(this.f37584a.f37595c);
                abstractHodorPreloadTask.setBizType("KSVodPrefetcher");
                abstractHodorPreloadTask.setGroupName("KSDownloaderKit");
                abstractHodorPreloadTask.submit();
                return 0;
            } else if (d() > 0) {
                ((VodAdaptivePreloadPriorityTask) abstractHodorPreloadTask).setPreloadDurationMs(d());
                com.kwai.video.ksvodplayerkit.a.b.b("KSVodPrefetcher", "submit task：" + bVar.f37583g + ", priority：" + bVar.c());
                abstractHodorPreloadTask.setAwesomeCacheCallback(new a(bVar));
                abstractHodorPreloadTask.setPriority(bVar.c());
                abstractHodorPreloadTask.setMaxSpeedKbps(this.f37584a.j);
                abstractHodorPreloadTask.setOnlyPreloadUnderSpeedKbps(this.f37584a.f37595c);
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

    public static c a() {
        return b.f37592a;
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
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.kwai.video.ksvodplayerkit.a.c.b(jSONObject.toString());
    }

    private void b(Context context) {
    }

    private void b(AcCallBackInfo acCallBackInfo, com.kwai.video.ksvodplayerkit.d.b bVar) {
        if (acCallBackInfo == null || bVar == null || bVar.e() == null) {
            return;
        }
        int i = 0;
        g gVar = new g(acCallBackInfo.stopReason == 1, acCallBackInfo.currentUri, acCallBackInfo.contentLength, acCallBackInfo.downloadBytes);
        synchronized (this.f37588e) {
            if (this.f37589f.size() >= 200) {
                Iterator<Map.Entry<String, g>> it = this.f37589f.entrySet().iterator();
                while (it.hasNext()) {
                    it.next();
                    it.remove();
                    i++;
                    if (i >= 20) {
                        break;
                    }
                }
            }
            this.f37589f.put(bVar.e(), gVar);
        }
    }

    private long c() {
        return com.kwai.video.ksvodplayerkit.c.a.d(this.f37585b) == 1 ? this.f37584a.f37596d : this.f37584a.f37597e;
    }

    private long d() {
        return com.kwai.video.ksvodplayerkit.c.a.d(this.f37585b) == 1 ? this.f37584a.f37598f : this.f37584a.f37599g;
    }

    public int a(com.kwai.video.ksvodplayerkit.d.b bVar) {
        if (bVar instanceof com.kwai.video.ksvodplayerkit.d.a) {
            ((com.kwai.video.ksvodplayerkit.d.a) bVar).a(this.f37585b);
        }
        if (this.f37586c != null && i.a().m()) {
            this.f37586c.setVisibility(0);
            this.f37586c.startTimer();
        }
        return a(bVar.b(), bVar);
    }

    public g a(String str) {
        g gVar = new g();
        if (str != null) {
            synchronized (this.f37588e) {
                if (this.f37589f.containsKey(str)) {
                    gVar = this.f37589f.get(str);
                }
            }
        }
        return gVar;
    }

    public void a(Context context) {
        if (this.f37587d.get()) {
            return;
        }
        this.f37585b = context;
        HodorConfig.setPreloadV3VodBufferLowRatio(this.f37584a.f37600h);
        HodorConfig.setPreloadV3VodCacheKbThresholdWhenPrepare(this.f37584a.k);
        HodorConfig.setPreloadV3VodPausePreloadMaxCountDueToBufferLow(this.f37584a.i);
        b(this.f37585b);
        this.f37587d.set(true);
    }

    public void b() {
        com.kwai.video.ksvodplayerkit.a.b.b("KSVodPrefetcher", "remove all task");
        Hodor.instance().cancelAllTasksOfGroupName("KSDownloaderKit");
        HodorDebugInfoView hodorDebugInfoView = this.f37586c;
        if (hodorDebugInfoView != null) {
            hodorDebugInfoView.stopTimer();
        }
    }
}
