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
import com.kwad.sdk.utils.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class b<T extends c, R extends com.kwad.sdk.core.network.g> {

    /* renamed from: c  reason: collision with root package name */
    public static volatile Handler f39704c;

    /* renamed from: d  reason: collision with root package name */
    public static ExecutorService f39705d;

    /* renamed from: e  reason: collision with root package name */
    public Context f39707e;
    public volatile long a = AppConfig.TIMESTAMP_AVAILABLE_DURATION;

    /* renamed from: b  reason: collision with root package name */
    public h f39706b = new j();

    /* renamed from: f  reason: collision with root package name */
    public AtomicInteger f39708f = new AtomicInteger(0);

    /* renamed from: g  reason: collision with root package name */
    public AtomicInteger f39709g = new AtomicInteger(0);

    /* renamed from: h  reason: collision with root package name */
    public int f39710h = 5;

    /* loaded from: classes7.dex */
    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final h f39720b;

        /* renamed from: c  reason: collision with root package name */
        public final Context f39721c;

        public a(Context context, h hVar) {
            this.f39721c = context;
            this.f39720b = hVar;
        }

        private void a(@NonNull List<T> list, boolean z) {
            List a = y.a(list, 200);
            int size = a.size();
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            for (int i = 0; i < size; i++) {
                b.this.a((List) a.get(i), atomicBoolean, z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f39708f.get() > 0 || !com.ksad.download.c.b.a(this.f39721c)) {
                return;
            }
            List<T> b2 = this.f39720b.b();
            ArrayList arrayList = new ArrayList();
            if (b2 != null && !b2.isEmpty()) {
                Iterator<T> it = b2.iterator();
                while (it.hasNext()) {
                    T next = it.next();
                    if (next instanceof m) {
                        arrayList.add(next);
                        it.remove();
                    }
                }
            }
            if (b2 != null && b2.size() > 0) {
                a(b2, false);
            }
            if (arrayList.size() > 0) {
                a(arrayList, true);
            }
        }
    }

    public b() {
        if (f39705d == null) {
            f39705d = com.kwad.sdk.core.i.b.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(long j) {
        if (f39704c == null) {
            return;
        }
        f39704c.removeMessages(16843025);
        Message obtain = Message.obtain(f39704c, new a(this.f39707e, this.f39706b));
        obtain.what = 16843025;
        f39704c.sendMessageDelayed(obtain, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        int i = this.f39709g.get();
        if (i > 16) {
            i = 16;
        }
        return this.f39706b.a() >= ((long) (com.kwad.sdk.core.config.b.j() << i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        int andIncrement = this.f39709g.getAndIncrement();
        if (andIncrement <= this.f39710h) {
            if (andIncrement > 0) {
                this.a *= 2;
            }
            b(this.a);
        }
    }

    public abstract R a(List<T> list, boolean z);

    public void a() {
        b(0L);
    }

    public void a(long j) {
        this.a = j < 60 ? 60000L : j * 1000;
    }

    public synchronized void a(Context context) {
        this.f39707e = context;
        if (f39704c == null) {
            f39704c = com.kwad.sdk.core.i.a.b();
        }
    }

    public void a(final T t, final Boolean bool) {
        if (t != null) {
            new com.kwad.sdk.core.network.i<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.b.5
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
                    return (R) b.this.a(arrayList, bool.booleanValue());
                }

                @Override // com.kwad.sdk.core.network.i
                public boolean c() {
                    return false;
                }
            }.a(new com.kwad.sdk.core.network.j<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.b.6
                /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.kwad.sdk.core.report.b */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                public void a(@NonNull R r, int i, String str) {
                    b.this.a((g) new g<T>() { // from class: com.kwad.sdk.core.report.b.6.1
                        @Override // com.kwad.sdk.core.report.g
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

    public void a(@NonNull final g<T> gVar) {
        f39705d.execute(new Runnable() { // from class: com.kwad.sdk.core.report.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (b.f39704c != null && !b.f39704c.hasMessages(16843025)) {
                    b bVar = b.this;
                    bVar.b(bVar.a);
                }
                b.this.f39706b.a((h) gVar.a());
                if (b.this.c()) {
                    b.this.a();
                }
            }
        });
    }

    public void a(h hVar) {
        this.f39706b = hVar;
    }

    public void a(final List<T> list, final AtomicBoolean atomicBoolean, final boolean z) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f39708f.getAndIncrement();
        new com.kwad.sdk.core.network.i<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.b.2
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
                return (R) b.this.a(list, z);
            }

            @Override // com.kwad.sdk.core.network.i
            public boolean c() {
                return false;
            }
        }.a(new com.kwad.sdk.core.network.j<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.b.3
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull R r, int i, String str) {
                atomicBoolean.set(true);
                if (b.this.f39708f.decrementAndGet() == 0) {
                    b.this.d();
                }
            }

            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public /* bridge */ /* synthetic */ void a(@NonNull com.kwad.sdk.core.network.g gVar, @NonNull BaseResultData baseResultData) {
                a((AnonymousClass3) gVar, (BatchReportResult) baseResultData);
            }

            public void a(@NonNull R r, @NonNull BatchReportResult batchReportResult) {
                b.this.f39706b.a(list);
                if (b.this.f39708f.decrementAndGet() == 0 && atomicBoolean.get()) {
                    b.this.d();
                }
                b.this.a(batchReportResult.getInterval());
                b bVar = b.this;
                bVar.b(bVar.a);
            }
        });
    }

    public void b(@NonNull final g<T> gVar) {
        f39705d.execute(new Runnable() { // from class: com.kwad.sdk.core.report.b.4
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.kwad.sdk.core.report.b */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                Boolean bool;
                b bVar;
                c a2 = gVar.a();
                if (a2 instanceof m) {
                    b bVar2 = b.this;
                    bool = Boolean.TRUE;
                    bVar = bVar2;
                } else {
                    b bVar3 = b.this;
                    bool = Boolean.FALSE;
                    bVar = bVar3;
                }
                bVar.a((b) a2, bool);
            }
        });
    }
}
