package com.kwad.sdk.core.report;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.annotation.NonNull;
import com.baidu.searchbox.config.AppConfig;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.report.d;
import com.kwad.sdk.core.response.model.BatchReportResult;
import com.kwad.sdk.utils.p;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class c<T extends d, R extends com.kwad.sdk.core.network.g> {

    /* renamed from: e  reason: collision with root package name */
    public static ExecutorService f33383e;

    /* renamed from: f  reason: collision with root package name */
    public Context f33388f;

    /* renamed from: a  reason: collision with root package name */
    public volatile long f33384a = AppConfig.TIMESTAMP_AVAILABLE_DURATION;

    /* renamed from: b  reason: collision with root package name */
    public i f33385b = new j();

    /* renamed from: c  reason: collision with root package name */
    public HandlerThread f33386c = null;

    /* renamed from: d  reason: collision with root package name */
    public Handler f33387d = null;

    /* renamed from: g  reason: collision with root package name */
    public AtomicInteger f33389g = new AtomicInteger(0);

    /* renamed from: h  reason: collision with root package name */
    public AtomicInteger f33390h = new AtomicInteger(0);

    /* renamed from: i  reason: collision with root package name */
    public int f33391i = 5;

    /* loaded from: classes6.dex */
    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final i f33407b;

        /* renamed from: c  reason: collision with root package name */
        public final Context f33408c;

        public a(Context context, i iVar) {
            this.f33408c = context;
            this.f33407b = iVar;
        }

        private void a(@NonNull List<T> list) {
            List a2 = p.a(list, 200);
            int size = a2.size();
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            for (int i2 = 0; i2 < size; i2++) {
                c.this.a((List) a2.get(i2), atomicBoolean);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            List<T> b2;
            if (c.this.f33389g.get() > 0 || !com.ksad.download.d.b.a(this.f33408c) || (b2 = this.f33407b.b()) == null || b2.isEmpty()) {
                return;
            }
            a(b2);
        }
    }

    public c() {
        if (f33383e == null) {
            f33383e = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j) {
        Handler handler = this.f33387d;
        if (handler == null) {
            return;
        }
        handler.removeMessages(16843025);
        Message obtain = Message.obtain(this.f33387d, new a(this.f33388f, this.f33385b));
        obtain.what = 16843025;
        this.f33387d.sendMessageDelayed(obtain, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        int i2 = this.f33390h.get();
        if (i2 > 16) {
            i2 = 16;
        }
        return this.f33385b.a() >= ((long) (com.kwad.sdk.core.config.c.i() << i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        int andIncrement = this.f33390h.getAndIncrement();
        if (andIncrement <= this.f33391i) {
            if (andIncrement > 0) {
                this.f33384a *= 2;
            }
            b(this.f33384a);
        }
    }

    public abstract R a(List<T> list);

    public void a() {
        b(0L);
    }

    public void a(long j) {
        this.f33384a = j < 60 ? 60000L : j * 1000;
    }

    public void a(Context context) {
        this.f33388f = context;
        HandlerThread handlerThread = new HandlerThread(b());
        this.f33386c = handlerThread;
        handlerThread.start();
        this.f33387d = new Handler(this.f33386c.getLooper());
    }

    public void a(final T t) {
        if (t != null) {
            new com.kwad.sdk.core.network.i<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.c.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.i
                @NonNull
                /* renamed from: a */
                public BatchReportResult b(String str) {
                    JSONObject jSONObject = new JSONObject(str);
                    BatchReportResult batchReportResult = new BatchReportResult();
                    batchReportResult.parseJson(jSONObject);
                    return batchReportResult;
                }

                @Override // com.kwad.sdk.core.network.a
                @NonNull
                public R b() {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(t);
                    return (R) c.this.a(arrayList);
                }
            }.a(new com.kwad.sdk.core.network.j<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.c.6
                /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.kwad.sdk.core.report.c */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                public void a(@NonNull R r, int i2, String str) {
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
        f33383e.execute(new Runnable() { // from class: com.kwad.sdk.core.report.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.f33387d != null && !c.this.f33387d.hasMessages(16843025)) {
                    c cVar = c.this;
                    cVar.b(cVar.f33384a);
                }
                c.this.f33385b.a((i) hVar.a());
                if (c.this.c()) {
                    c.this.a();
                }
            }
        });
    }

    public void a(i iVar) {
        this.f33385b = iVar;
    }

    public void a(final List<T> list, final AtomicBoolean atomicBoolean) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f33389g.getAndIncrement();
        new com.kwad.sdk.core.network.i<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.i
            @NonNull
            /* renamed from: a */
            public BatchReportResult b(String str) {
                JSONObject jSONObject = new JSONObject(str);
                BatchReportResult batchReportResult = new BatchReportResult();
                batchReportResult.parseJson(jSONObject);
                return batchReportResult;
            }

            @Override // com.kwad.sdk.core.network.a
            @NonNull
            public R b() {
                return (R) c.this.a(list);
            }
        }.a(new com.kwad.sdk.core.network.j<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.c.3
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull R r, int i2, String str) {
                atomicBoolean.set(true);
                if (c.this.f33389g.decrementAndGet() == 0) {
                    c.this.d();
                }
            }

            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public /* bridge */ /* synthetic */ void a(@NonNull com.kwad.sdk.core.network.g gVar, @NonNull BaseResultData baseResultData) {
                a((AnonymousClass3) gVar, (BatchReportResult) baseResultData);
            }

            public void a(@NonNull R r, @NonNull BatchReportResult batchReportResult) {
                c.this.f33385b.a(list);
                if (c.this.f33389g.decrementAndGet() == 0 && atomicBoolean.get()) {
                    c.this.d();
                }
                c.this.a(batchReportResult.getInterval());
                c cVar = c.this;
                cVar.b(cVar.f33384a);
            }
        });
    }

    public abstract String b();

    public void b(@NonNull final h<T> hVar) {
        f33383e.execute(new Runnable() { // from class: com.kwad.sdk.core.report.c.4
            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.kwad.sdk.core.report.c */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                c.this.a((c) hVar.a());
            }
        });
    }
}
