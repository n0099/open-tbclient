package com.kwad.sdk.core.report;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import com.baidu.searchbox.config.AppConfig;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.report.c;
import com.kwad.sdk.core.response.model.BatchReportResult;
import com.kwad.sdk.service.ServiceProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public abstract class b<T extends c, R extends com.kwad.sdk.core.network.g> {
    public static ExecutorService ZI;
    public static volatile Handler mHandler;
    public T ZL;
    public Context mContext;
    public volatile long ZG = AppConfig.TIMESTAMP_AVAILABLE_DURATION;
    public j ZH = new l();
    public AtomicInteger ZJ = new AtomicInteger(0);
    public AtomicInteger mRetryCount = new AtomicInteger(0);
    public int ZK = 5;

    public b() {
        if (ZI == null) {
            ZI = com.kwad.sdk.core.threads.b.vl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void E(long j) {
        if (mHandler == null) {
            return;
        }
        mHandler.removeMessages(16843025);
        Message obtain = Message.obtain(mHandler, a(this.mContext, this.ZH, this.ZJ));
        obtain.what = 16843025;
        mHandler.sendMessageDelayed(obtain, j);
    }

    private void c(@NonNull final i<T> iVar) {
        new com.kwad.sdk.core.network.m<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.b.4
            @NonNull
            public static BatchReportResult cq(String str) {
                JSONObject jSONObject = new JSONObject(str);
                BatchReportResult batchReportResult = new BatchReportResult();
                batchReportResult.parseJson(jSONObject);
                return batchReportResult;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.kwad.sdk.core.report.b */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            public final R createRequest() {
                c us = iVar.us();
                b.this.ZL = us;
                return (R) b.this.a((b) us);
            }

            @Override // com.kwad.sdk.core.network.m
            public final boolean enableMonitorReport() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.a
            public final ExecutorService getExecutor() {
                return b.ZI;
            }

            /* JADX DEBUG: Return type fixed from 'com.kwad.sdk.core.network.BaseResultData' to match base method */
            @Override // com.kwad.sdk.core.network.m
            @NonNull
            public final /* synthetic */ BatchReportResult parseData(String str) {
                return cq(str);
            }
        }.request(new com.kwad.sdk.core.network.n<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.b.5
            private void a(@NonNull BatchReportResult batchReportResult) {
                com.kwad.sdk.core.e.b.d("BaseBatchReporter", "立即上报 onSuccess action= " + b.this.ZL + " result " + batchReportResult.getResult());
            }

            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.kwad.sdk.core.report.b */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.kwad.sdk.core.network.n, com.kwad.sdk.core.network.h
            public final void onError(@NonNull R r, int i, String str) {
                b.this.a((i) new i<T>() { // from class: com.kwad.sdk.core.report.b.5.1
                    @Override // com.kwad.sdk.core.report.i
                    @NonNull
                    public final T us() {
                        return (T) b.this.ZL;
                    }
                });
            }

            @Override // com.kwad.sdk.core.network.n, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.g gVar, @NonNull BaseResultData baseResultData) {
                a((BatchReportResult) baseResultData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean un() {
        int i = this.mRetryCount.get();
        if (i > 16) {
            i = 16;
        }
        r rVar = (r) ServiceProvider.get(r.class);
        return this.ZH.size() >= (rVar != null ? (long) (rVar.lr() << i) : 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void up() {
        int andIncrement = this.mRetryCount.getAndIncrement();
        if (andIncrement <= this.ZK) {
            if (andIncrement > 0) {
                this.ZG *= 2;
            }
            E(this.ZG);
        }
    }

    public final void D(long j) {
        this.ZG = j < 60 ? 60000L : j * 1000;
    }

    public R a(T t) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(t);
        return o(arrayList);
    }

    public Runnable a(Context context, j<T> jVar, AtomicInteger atomicInteger) {
        return new v(context, jVar, this, atomicInteger);
    }

    public final void a(@NonNull final i<T> iVar) {
        ZI.execute(new Runnable() { // from class: com.kwad.sdk.core.report.b.1
            @Override // java.lang.Runnable
            public final void run() {
                if (b.mHandler != null && !b.mHandler.hasMessages(16843025)) {
                    b bVar = b.this;
                    bVar.E(bVar.ZG);
                }
                c us = iVar.us();
                if (us != null) {
                    b.this.ZH.d(us);
                }
                if (b.this.un()) {
                    b.this.uo();
                }
            }
        });
    }

    public final void a(j jVar) {
        this.ZH = jVar;
    }

    public final void a(final List<T> list, final AtomicBoolean atomicBoolean) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.ZJ.getAndIncrement();
        new com.kwad.sdk.core.network.m<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.b.2
            @NonNull
            public static BatchReportResult cq(String str) {
                JSONObject jSONObject = new JSONObject(str);
                BatchReportResult batchReportResult = new BatchReportResult();
                batchReportResult.parseJson(jSONObject);
                return batchReportResult;
            }

            @Override // com.kwad.sdk.core.network.a
            @NonNull
            public final R createRequest() {
                return (R) b.this.o(list);
            }

            @Override // com.kwad.sdk.core.network.m
            public final boolean enableMonitorReport() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.a
            public final ExecutorService getExecutor() {
                return b.ZI;
            }

            /* JADX DEBUG: Return type fixed from 'com.kwad.sdk.core.network.BaseResultData' to match base method */
            @Override // com.kwad.sdk.core.network.m
            @NonNull
            public final /* synthetic */ BatchReportResult parseData(String str) {
                return cq(str);
            }
        }.request(new com.kwad.sdk.core.network.n<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.b.3
            private void a(@NonNull BatchReportResult batchReportResult) {
                b.this.ZH.q(list);
                if (b.this.ZJ.decrementAndGet() == 0 && atomicBoolean.get()) {
                    b.this.up();
                }
                b.this.D(batchReportResult.getInterval());
                b bVar = b.this;
                bVar.E(bVar.ZG);
            }

            @Override // com.kwad.sdk.core.network.n, com.kwad.sdk.core.network.h
            public final void onError(@NonNull R r, int i, String str) {
                atomicBoolean.set(true);
                if (b.this.ZJ.decrementAndGet() == 0) {
                    b.this.up();
                }
            }

            @Override // com.kwad.sdk.core.network.n, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.g gVar, @NonNull BaseResultData baseResultData) {
                a((BatchReportResult) baseResultData);
            }
        });
    }

    public final void b(@NonNull i<T> iVar) {
        c(iVar);
    }

    public synchronized void e(Context context, int i) {
        this.mContext = context;
        if (mHandler == null) {
            mHandler = com.kwad.sdk.core.threads.a.vg();
        }
    }

    public abstract R o(List<T> list);

    public final void uo() {
        E(0L);
    }
}
