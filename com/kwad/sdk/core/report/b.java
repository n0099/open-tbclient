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
/* loaded from: classes5.dex */
public abstract class b<T extends c, R extends com.kwad.sdk.core.network.g> {
    public static volatile Handler c;
    public static ExecutorService d;
    public Context e;
    public T i;
    public volatile long a = AppConfig.TIMESTAMP_AVAILABLE_DURATION;
    public j b = new l();
    public AtomicInteger f = new AtomicInteger(0);
    public AtomicInteger g = new AtomicInteger(0);
    public int h = 5;

    public b() {
        if (d == null) {
            d = com.kwad.sdk.core.threads.b.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(long j) {
        if (c == null) {
            return;
        }
        c.removeMessages(16843025);
        Message obtain = Message.obtain(c, a(this.e, this.b, this.f));
        obtain.what = 16843025;
        c.sendMessageDelayed(obtain, j);
    }

    private void c(@NonNull final i<T> iVar) {
        new com.kwad.sdk.core.network.l<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.b.4
            @NonNull
            public static BatchReportResult a(String str) {
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
                c a = iVar.a();
                b.this.i = a;
                return (R) b.this.a((b) a);
            }

            @Override // com.kwad.sdk.core.network.l
            public final boolean enableMonitorReport() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.a
            public final ExecutorService getExecutor() {
                return b.d;
            }

            /* JADX DEBUG: Return type fixed from 'com.kwad.sdk.core.network.BaseResultData' to match base method */
            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ BatchReportResult parseData(String str) {
                return a(str);
            }
        }.request(new com.kwad.sdk.core.network.m<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.b.5
            private void a(@NonNull BatchReportResult batchReportResult) {
                com.kwad.sdk.core.d.b.a("BaseBatchReporter", "立即上报 onSuccess action= " + b.this.i + " result " + batchReportResult.getResult());
            }

            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.kwad.sdk.core.report.b */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.kwad.sdk.core.network.m, com.kwad.sdk.core.network.h
            public final void onError(@NonNull R r, int i, String str) {
                b.this.a((i) new i<T>() { // from class: com.kwad.sdk.core.report.b.5.1
                    @Override // com.kwad.sdk.core.report.i
                    @NonNull
                    public final T a() {
                        return (T) b.this.i;
                    }
                });
            }

            @Override // com.kwad.sdk.core.network.m, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.g gVar, @NonNull BaseResultData baseResultData) {
                a((BatchReportResult) baseResultData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        int i = this.g.get();
        if (i > 16) {
            i = 16;
        }
        r rVar = (r) ServiceProvider.a(r.class);
        return this.b.a() >= (rVar != null ? (long) (rVar.a() << i) : 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        int andIncrement = this.g.getAndIncrement();
        if (andIncrement <= this.h) {
            if (andIncrement > 0) {
                this.a *= 2;
            }
            b(this.a);
        }
    }

    public R a(T t) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(t);
        return a(arrayList);
    }

    public abstract R a(List<T> list);

    public Runnable a(Context context, j<T> jVar, AtomicInteger atomicInteger) {
        return new v(context, jVar, this, atomicInteger);
    }

    public final void a() {
        b(0L);
    }

    public final void a(long j) {
        this.a = j < 60 ? 60000L : j * 1000;
    }

    public synchronized void a(Context context, int i) {
        this.e = context;
        if (c == null) {
            c = com.kwad.sdk.core.threads.a.b();
        }
    }

    public final void a(@NonNull final i<T> iVar) {
        d.execute(new Runnable() { // from class: com.kwad.sdk.core.report.b.1
            @Override // java.lang.Runnable
            public final void run() {
                if (b.c != null && !b.c.hasMessages(16843025)) {
                    b bVar = b.this;
                    bVar.b(bVar.a);
                }
                c a = iVar.a();
                if (a != null) {
                    b.this.b.a((j) a);
                }
                if (b.this.d()) {
                    b.this.a();
                }
            }
        });
    }

    public final void a(j jVar) {
        this.b = jVar;
    }

    public final void a(final List<T> list, final AtomicBoolean atomicBoolean) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f.getAndIncrement();
        new com.kwad.sdk.core.network.l<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.b.2
            @NonNull
            public static BatchReportResult a(String str) {
                JSONObject jSONObject = new JSONObject(str);
                BatchReportResult batchReportResult = new BatchReportResult();
                batchReportResult.parseJson(jSONObject);
                return batchReportResult;
            }

            @Override // com.kwad.sdk.core.network.a
            @NonNull
            public final R createRequest() {
                return (R) b.this.a(list);
            }

            @Override // com.kwad.sdk.core.network.l
            public final boolean enableMonitorReport() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.a
            public final ExecutorService getExecutor() {
                return b.d;
            }

            /* JADX DEBUG: Return type fixed from 'com.kwad.sdk.core.network.BaseResultData' to match base method */
            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ BatchReportResult parseData(String str) {
                return a(str);
            }
        }.request(new com.kwad.sdk.core.network.m<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.b.3
            private void a(@NonNull BatchReportResult batchReportResult) {
                b.this.b.a(list);
                if (b.this.f.decrementAndGet() == 0 && atomicBoolean.get()) {
                    b.this.e();
                }
                b.this.a(batchReportResult.getInterval());
                b bVar = b.this;
                bVar.b(bVar.a);
            }

            @Override // com.kwad.sdk.core.network.m, com.kwad.sdk.core.network.h
            public final void onError(@NonNull R r, int i, String str) {
                atomicBoolean.set(true);
                if (b.this.f.decrementAndGet() == 0) {
                    b.this.e();
                }
            }

            @Override // com.kwad.sdk.core.network.m, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.g gVar, @NonNull BaseResultData baseResultData) {
                a((BatchReportResult) baseResultData);
            }
        });
    }

    public final void b(@NonNull i<T> iVar) {
        c(iVar);
    }
}
