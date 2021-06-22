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
/* loaded from: classes7.dex */
public abstract class c<T extends d, R extends com.kwad.sdk.core.network.g> {

    /* renamed from: e  reason: collision with root package name */
    public static ExecutorService f34746e;

    /* renamed from: f  reason: collision with root package name */
    public Context f34751f;

    /* renamed from: a  reason: collision with root package name */
    public volatile long f34747a = AppConfig.TIMESTAMP_AVAILABLE_DURATION;

    /* renamed from: b  reason: collision with root package name */
    public i f34748b = new j();

    /* renamed from: c  reason: collision with root package name */
    public HandlerThread f34749c = null;

    /* renamed from: d  reason: collision with root package name */
    public Handler f34750d = null;

    /* renamed from: g  reason: collision with root package name */
    public AtomicInteger f34752g = new AtomicInteger(0);

    /* renamed from: h  reason: collision with root package name */
    public AtomicInteger f34753h = new AtomicInteger(0);

    /* renamed from: i  reason: collision with root package name */
    public int f34754i = 5;

    /* loaded from: classes7.dex */
    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final i f34770b;

        /* renamed from: c  reason: collision with root package name */
        public final Context f34771c;

        public a(Context context, i iVar) {
            this.f34771c = context;
            this.f34770b = iVar;
        }

        private void a(@NonNull List<T> list) {
            List a2 = r.a(list, 200);
            int size = a2.size();
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            for (int i2 = 0; i2 < size; i2++) {
                c.this.a((List) a2.get(i2), atomicBoolean);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            List<T> b2;
            if (c.this.f34752g.get() > 0 || !com.ksad.download.d.b.a(this.f34771c) || (b2 = this.f34770b.b()) == null || b2.isEmpty()) {
                return;
            }
            a(b2);
        }
    }

    public c() {
        if (f34746e == null) {
            f34746e = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j) {
        Handler handler = this.f34750d;
        if (handler == null) {
            return;
        }
        handler.removeMessages(16843025);
        Message obtain = Message.obtain(this.f34750d, new a(this.f34751f, this.f34748b));
        obtain.what = 16843025;
        this.f34750d.sendMessageDelayed(obtain, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        int i2 = this.f34753h.get();
        if (i2 > 16) {
            i2 = 16;
        }
        return this.f34748b.a() >= ((long) (com.kwad.sdk.core.config.c.v() << i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        int andIncrement = this.f34753h.getAndIncrement();
        if (andIncrement <= this.f34754i) {
            if (andIncrement > 0) {
                this.f34747a *= 2;
            }
            b(this.f34747a);
        }
    }

    public abstract R a(List<T> list);

    public void a() {
        b(0L);
    }

    public void a(long j) {
        this.f34747a = j < 60 ? 60000L : j * 1000;
    }

    public void a(Context context) {
        this.f34751f = context;
        HandlerThread handlerThread = new HandlerThread(b());
        this.f34749c = handlerThread;
        handlerThread.start();
        this.f34750d = new Handler(this.f34749c.getLooper());
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
        f34746e.execute(new Runnable() { // from class: com.kwad.sdk.core.report.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (!c.this.f34750d.hasMessages(16843025)) {
                    c cVar = c.this;
                    cVar.b(cVar.f34747a);
                }
                c.this.f34748b.a((i) hVar.a());
                if (c.this.c()) {
                    c.this.a();
                }
            }
        });
    }

    public void a(i iVar) {
        this.f34748b = iVar;
    }

    public void a(final List<T> list, final AtomicBoolean atomicBoolean) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f34752g.getAndIncrement();
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
                if (c.this.f34752g.decrementAndGet() == 0) {
                    c.this.d();
                }
            }

            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public /* bridge */ /* synthetic */ void a(@NonNull com.kwad.sdk.core.network.g gVar, @NonNull BaseResultData baseResultData) {
                a((AnonymousClass3) gVar, (BatchReportResult) baseResultData);
            }

            public void a(@NonNull R r, @NonNull BatchReportResult batchReportResult) {
                c.this.f34748b.a(list);
                if (c.this.f34752g.decrementAndGet() == 0 && atomicBoolean.get()) {
                    c.this.d();
                }
                c.this.a(batchReportResult.getInterval());
                c cVar = c.this;
                cVar.b(cVar.f34747a);
            }
        });
    }

    public abstract String b();

    public void b(@NonNull final h<T> hVar) {
        f34746e.execute(new Runnable() { // from class: com.kwad.sdk.core.report.c.4
            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.kwad.sdk.core.report.c */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                c.this.a((c) hVar.a());
            }
        });
    }
}
