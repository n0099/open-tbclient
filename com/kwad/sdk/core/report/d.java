package com.kwad.sdk.core.report;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import com.baidu.searchbox.config.AppConfig;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.report.g;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.core.response.model.BatchReportResult;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public abstract class d<T extends g, R extends com.kwad.sdk.core.network.f> {
    public static ExecutorService avm;
    public static volatile Handler fS;
    public T avp;
    public Context mContext;
    public volatile long SS = AppConfig.TIMESTAMP_AVAILABLE_DURATION;
    public o avl = new p();
    public AtomicInteger avn = new AtomicInteger(0);
    public AtomicInteger mRetryCount = new AtomicInteger(0);
    public int avo = 5;

    public abstract R u(List<T> list);

    public d() {
        if (avm == null) {
            avm = GlobalThreadPools.Ew();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dq() {
        int andIncrement = this.mRetryCount.getAndIncrement();
        if (andIncrement <= this.avo) {
            if (andIncrement > 0) {
                this.SS *= 2;
            }
            ah(this.SS);
        }
    }

    public final boolean Do() {
        long j;
        int i = this.mRetryCount.get();
        if (i > 16) {
            i = 16;
        }
        v vVar = (v) ServiceProvider.get(v.class);
        if (vVar != null) {
            j = vVar.ye() << i;
        } else {
            j = 20;
        }
        if (this.avl.size() >= j) {
            return true;
        }
        return false;
    }

    public final void Dp() {
        ah(0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ah(long j) {
        if (fS == null) {
            return;
        }
        fS.removeMessages(16843025);
        Message obtain = Message.obtain(fS, a(this.mContext, this.avl, this.avn));
        obtain.what = 16843025;
        fS.sendMessageDelayed(obtain, j);
    }

    public final void ag(long j) {
        if (j < 60) {
            this.SS = 60000L;
        } else {
            this.SS = j * 1000;
        }
    }

    public synchronized void i(Context context, int i) {
        this.mContext = context;
        if (fS == null) {
            fS = com.kwad.sdk.core.threads.a.Eq();
        }
    }

    private void c(@NonNull final n<T> nVar) {
        new com.kwad.sdk.core.network.l<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.d.4
            @Override // com.kwad.sdk.core.network.l
            public final boolean enableMonitorReport() {
                return false;
            }

            @NonNull
            public static BatchReportResult dN(String str) {
                JSONObject jSONObject = new JSONObject(str);
                BatchReportResult batchReportResult = new BatchReportResult();
                batchReportResult.parseJson(jSONObject);
                return batchReportResult;
            }

            /* JADX DEBUG: Return type fixed from 'com.kwad.sdk.core.response.model.BaseResultData' to match base method */
            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ BatchReportResult parseData(String str) {
                return dN(str);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.kwad.sdk.core.report.d */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            public final R createRequest() {
                g Dt = nVar.Dt();
                d.this.avp = Dt;
                return (R) d.this.a((d) Dt);
            }

            @Override // com.kwad.sdk.core.network.a
            public final ExecutorService getExecutor() {
                return d.avm;
            }
        }.request(new com.kwad.sdk.core.network.o<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.d.5
            private void a(@NonNull BatchReportResult batchReportResult) {
                com.kwad.sdk.core.e.c.d("BaseBatchReporter", "立即上报 onSuccess action= " + d.this.avp + " result " + batchReportResult.getResult());
            }

            /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: com.kwad.sdk.core.report.d */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final void onError(@NonNull R r, int i, String str) {
                com.kwad.sdk.core.e.c.e("BaseBatchReporter", "立即上报 onError errorCode:" + i + " errorMsg:" + str + "\naction=" + d.this.avp);
                d.this.a((n) new n<T>() { // from class: com.kwad.sdk.core.report.d.5.1
                    @Override // com.kwad.sdk.core.report.n
                    @NonNull
                    public final T Dt() {
                        return (T) d.this.avp;
                    }
                });
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.f fVar, @NonNull BaseResultData baseResultData) {
                a((BatchReportResult) baseResultData);
            }
        });
    }

    public R a(T t) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(t);
        return u(arrayList);
    }

    public final void b(@NonNull n<T> nVar) {
        try {
            c(nVar);
        } catch (Throwable th) {
            ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(th);
        }
    }

    public Runnable a(Context context, o<T> oVar, AtomicInteger atomicInteger) {
        return new z(context, oVar, this, atomicInteger);
    }

    public final void a(@NonNull final n<T> nVar) {
        avm.execute(new Runnable() { // from class: com.kwad.sdk.core.report.d.1
            @Override // java.lang.Runnable
            public final void run() {
                if (d.fS != null && !d.fS.hasMessages(16843025)) {
                    d dVar = d.this;
                    dVar.ah(dVar.SS);
                }
                g Dt = nVar.Dt();
                if (Dt != null) {
                    d.this.avl.j(Dt);
                }
                if (d.this.Do()) {
                    d.this.Dp();
                }
            }
        });
    }

    public final void a(o oVar) {
        this.avl = oVar;
    }

    public final void a(final List<T> list, final AtomicBoolean atomicBoolean) {
        if (list != null && list.size() > 0) {
            this.avn.getAndIncrement();
            new com.kwad.sdk.core.network.l<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.d.2
                @Override // com.kwad.sdk.core.network.l
                public final boolean enableMonitorReport() {
                    return false;
                }

                @NonNull
                public static BatchReportResult dN(String str) {
                    JSONObject jSONObject = new JSONObject(str);
                    BatchReportResult batchReportResult = new BatchReportResult();
                    batchReportResult.parseJson(jSONObject);
                    return batchReportResult;
                }

                /* JADX DEBUG: Return type fixed from 'com.kwad.sdk.core.response.model.BaseResultData' to match base method */
                @Override // com.kwad.sdk.core.network.l
                @NonNull
                public final /* synthetic */ BatchReportResult parseData(String str) {
                    return dN(str);
                }

                @Override // com.kwad.sdk.core.network.a
                @NonNull
                public final R createRequest() {
                    return (R) d.this.u(list);
                }

                @Override // com.kwad.sdk.core.network.a
                public final ExecutorService getExecutor() {
                    return d.avm;
                }
            }.request(new com.kwad.sdk.core.network.o<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.d.3
                @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                public final void onError(@NonNull R r, int i, String str) {
                    atomicBoolean.set(true);
                    if (d.this.avn.decrementAndGet() != 0) {
                        return;
                    }
                    d.this.Dq();
                }

                private void a(@NonNull BatchReportResult batchReportResult) {
                    d.this.avl.v(list);
                    if (d.this.avn.decrementAndGet() == 0 && atomicBoolean.get()) {
                        d.this.Dq();
                    }
                    d.this.ag(batchReportResult.getInterval());
                    d dVar = d.this;
                    dVar.ah(dVar.SS);
                }

                @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.f fVar, @NonNull BaseResultData baseResultData) {
                    a((BatchReportResult) baseResultData);
                }
            });
        }
    }
}
