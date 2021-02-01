package com.kwad.sdk.core.report;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.annotation.NonNull;
import com.kwad.sdk.collector.AppStatusRules;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.report.d;
import com.kwad.sdk.core.response.model.BatchReportResult;
import com.kwad.sdk.utils.r;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class c<T extends d, R extends com.kwad.sdk.core.network.g> {
    private static ExecutorService e = null;
    private Context f;

    /* renamed from: a  reason: collision with root package name */
    private volatile long f9399a = 120000;

    /* renamed from: b  reason: collision with root package name */
    private i f9400b = new j();
    private HandlerThread c = null;
    private Handler d = null;
    private AtomicInteger g = new AtomicInteger(0);
    private AtomicInteger h = new AtomicInteger(0);
    private int i = 5;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final i f9415b;
        private final Context c;

        public a(Context context, i iVar) {
            this.c = context;
            this.f9415b = iVar;
        }

        private void a(@NonNull List<T> list) {
            List a2 = r.a(list, 200);
            int size = a2.size();
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            for (int i = 0; i < size; i++) {
                c.this.a((List) a2.get(i), atomicBoolean);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            List<T> b2;
            if (c.this.g.get() > 0 || !com.ksad.download.d.b.a(this.c) || (b2 = this.f9415b.b()) == null || b2.isEmpty()) {
                return;
            }
            a(b2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c() {
        if (e == null) {
            e = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j) {
        if (this.d == null) {
            return;
        }
        this.d.removeMessages(16843025);
        Message obtain = Message.obtain(this.d, new a(this.f, this.f9400b));
        obtain.what = 16843025;
        this.d.sendMessageDelayed(obtain, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        int i = this.h.get();
        return this.f9400b.a() >= ((long) (com.kwad.sdk.core.config.c.v() << (i <= 16 ? i : 16)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        int andIncrement = this.h.getAndIncrement();
        if (andIncrement <= this.i) {
            if (andIncrement > 0) {
                this.f9399a *= 2;
            }
            b(this.f9399a);
        }
    }

    protected abstract R a(List<T> list);

    public void a() {
        b(0L);
    }

    protected void a(long j) {
        if (j < 60) {
            this.f9399a = AppStatusRules.DEFAULT_GRANULARITY;
        } else {
            this.f9399a = 1000 * j;
        }
    }

    public void a(Context context) {
        this.f = context;
        this.c = new HandlerThread(b());
        this.c.start();
        this.d = new Handler(this.c.getLooper());
    }

    protected void a(final T t) {
        if (t != null) {
            new com.kwad.sdk.core.network.i<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.c.5
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.kwad.sdk.core.network.i
                @NonNull
                /* renamed from: a */
                public BatchReportResult b(String str) {
                    JSONObject jSONObject = new JSONObject(str);
                    BatchReportResult batchReportResult = new BatchReportResult();
                    batchReportResult.parseJson(jSONObject);
                    return batchReportResult;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.kwad.sdk.core.network.a
                @NonNull
                public R b() {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(t);
                    return (R) c.this.a(arrayList);
                }
            }.a(new com.kwad.sdk.core.network.j<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.c.6
                /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.kwad.sdk.core.report.c */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                public void a(@NonNull R r, int i, String str) {
                    c.this.a((h) new h<T>() { // from class: com.kwad.sdk.core.report.c.6.1
                        @Override // com.kwad.sdk.core.report.h
                        @NonNull
                        public T a() {
                            return (T) t;
                        }
                    });
                }

                @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                public /* bridge */ /* synthetic */ void a(@NonNull com.kwad.sdk.core.network.g gVar, @NonNull BaseResultData baseResultData) {
                    a((AnonymousClass6) gVar, (BatchReportResult) baseResultData);
                }

                public void a(@NonNull R r, @NonNull BatchReportResult batchReportResult) {
                    com.kwad.sdk.core.d.a.a("BaseBatchReporter", "立即上报 onSuccess action= " + t + " result " + batchReportResult.getResult());
                }
            });
        }
    }

    public void a(@NonNull final h<T> hVar) {
        e.execute(new Runnable() { // from class: com.kwad.sdk.core.report.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (!c.this.d.hasMessages(16843025)) {
                    c.this.b(c.this.f9399a);
                }
                c.this.f9400b.a((i) hVar.a());
                if (c.this.c()) {
                    c.this.a();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(i iVar) {
        this.f9400b = iVar;
    }

    protected void a(final List<T> list, final AtomicBoolean atomicBoolean) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.g.getAndIncrement();
        new com.kwad.sdk.core.network.i<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.c.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.kwad.sdk.core.network.i
            @NonNull
            /* renamed from: a */
            public BatchReportResult b(String str) {
                JSONObject jSONObject = new JSONObject(str);
                BatchReportResult batchReportResult = new BatchReportResult();
                batchReportResult.parseJson(jSONObject);
                return batchReportResult;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            public R b() {
                return (R) c.this.a(list);
            }
        }.a(new com.kwad.sdk.core.network.j<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.c.3
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull R r, int i, String str) {
                atomicBoolean.set(true);
                if (c.this.g.decrementAndGet() == 0) {
                    c.this.d();
                }
            }

            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public /* bridge */ /* synthetic */ void a(@NonNull com.kwad.sdk.core.network.g gVar, @NonNull BaseResultData baseResultData) {
                a((AnonymousClass3) gVar, (BatchReportResult) baseResultData);
            }

            public void a(@NonNull R r, @NonNull BatchReportResult batchReportResult) {
                c.this.f9400b.a(list);
                if (c.this.g.decrementAndGet() == 0 && atomicBoolean.get()) {
                    c.this.d();
                }
                c.this.a(batchReportResult.getInterval());
                c.this.b(c.this.f9399a);
            }
        });
    }

    protected abstract String b();

    public void b(@NonNull final h<T> hVar) {
        e.execute(new Runnable() { // from class: com.kwad.sdk.core.report.c.4
            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.kwad.sdk.core.report.c */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                c.this.a((c) hVar.a());
            }
        });
    }
}
