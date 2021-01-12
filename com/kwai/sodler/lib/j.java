package com.kwai.sodler.lib;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.ActivityChooserView;
import com.kwai.sodler.lib.k;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public final class j extends k {

    /* renamed from: a  reason: collision with root package name */
    private static volatile j f11016a;

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f11017b;
    private k c;
    private com.kwai.sodler.lib.ext.a d;
    private ExecutorService e;
    private Map<String, b> f;
    private a g;

    /* loaded from: classes4.dex */
    public interface a {
        void a(String str, String str2);
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final com.kwai.sodler.lib.a.f f11020a;

        /* renamed from: b  reason: collision with root package name */
        private final Future<com.kwai.sodler.lib.a.f> f11021b;

        public b(com.kwai.sodler.lib.a.f fVar, Future<com.kwai.sodler.lib.a.f> future) {
            this.f11020a = fVar;
            this.f11021b = future;
        }

        public void a() {
            this.f11020a.e();
            this.f11021b.cancel(true);
        }
    }

    private j() {
        super(null, null, null, null, null, null);
        this.f11017b = false;
    }

    public static j a() {
        if (f11016a == null) {
            synchronized (j.class) {
                if (f11016a == null) {
                    f11016a = new j();
                }
            }
        }
        return f11016a;
    }

    private static ExecutorService i() {
        return new ThreadPoolExecutor(1, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 60L, TimeUnit.SECONDS, new SynchronousQueue());
    }

    private void j() {
        if (!this.f11017b) {
            throw new RuntimeException("Sodler has not yet been init.");
        }
    }

    @Override // com.kwai.sodler.lib.k
    public com.kwai.sodler.lib.a.f a(@NonNull com.kwai.sodler.lib.a.f fVar, @NonNull k.a aVar) {
        if (this.f11017b) {
            com.kwai.sodler.lib.a.e b2 = fVar.b();
            k kVar = this.c;
            if (b2 == null) {
                b2 = this.c;
            }
            return kVar.a(fVar.a(b2), aVar);
        }
        throw new RuntimeException("Sodler has not yet been init.");
    }

    public b a(@NonNull com.kwai.sodler.lib.a.f fVar, int i) {
        return b(fVar, k.a.a(this, i));
    }

    public synchronized void a(Context context, @NonNull com.kwai.sodler.lib.ext.c cVar) {
        if (!this.f11017b) {
            d dVar = new d(context);
            e eVar = new e(context);
            c cVar2 = new c(context, cVar);
            com.kwai.sodler.lib.b bVar = new com.kwai.sodler.lib.b();
            this.d = new com.kwai.sodler.lib.ext.a();
            this.e = i();
            this.c = new k(dVar, eVar, cVar2, bVar, cVar, new com.kwai.sodler.lib.ext.a());
            this.f11017b = true;
            j();
        }
    }

    @Override // com.kwai.sodler.lib.k, com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.ext.c b() {
        if (this.f11017b) {
            return this.c.b();
        }
        throw new RuntimeException("Sodler has not yet been init.");
    }

    public b b(@NonNull final com.kwai.sodler.lib.a.f fVar, @NonNull final k.a aVar) {
        if (this.f11017b) {
            this.f = a(this.f);
            b bVar = this.f.get(fVar.i());
            if (bVar != null) {
                bVar.a();
            }
            fVar.a(this);
            b bVar2 = new b(fVar, this.e.submit(new Callable<com.kwai.sodler.lib.a.f>() { // from class: com.kwai.sodler.lib.j.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public com.kwai.sodler.lib.a.f call() {
                    return j.this.a(fVar, aVar);
                }
            }));
            if (fVar.i() != null) {
                this.f.put(fVar.i(), bVar2);
            }
            return bVar2;
        }
        throw new RuntimeException("Sodler has not yet been init.");
    }

    @Override // com.kwai.sodler.lib.k, com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.a.d c() {
        if (this.f11017b) {
            return this.c.c();
        }
        throw new RuntimeException("Sodler has not yet been init.");
    }

    @Override // com.kwai.sodler.lib.k, com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.a.g d() {
        if (this.f11017b) {
            return this.c.d();
        }
        throw new RuntimeException("Sodler has not yet been init.");
    }

    @Override // com.kwai.sodler.lib.k, com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.a.c e() {
        if (this.f11017b) {
            return this.c.e();
        }
        throw new RuntimeException("Sodler has not yet been init.");
    }

    @Override // com.kwai.sodler.lib.k, com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.a.b f() {
        if (this.f11017b) {
            return this.c.f();
        }
        throw new RuntimeException("Sodler has not yet been init.");
    }

    @Override // com.kwai.sodler.lib.k, com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.ext.a g() {
        if (this.f11017b) {
            return this.d;
        }
        throw new RuntimeException("Sodler has not yet been init.");
    }

    public a h() {
        return this.g;
    }
}
