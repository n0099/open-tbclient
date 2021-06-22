package com.kwai.sodler.lib;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwai.sodler.lib.k;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class j extends k {

    /* renamed from: a  reason: collision with root package name */
    public static volatile j f38043a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f38044b;

    /* renamed from: c  reason: collision with root package name */
    public k f38045c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwai.sodler.lib.ext.a f38046d;

    /* renamed from: e  reason: collision with root package name */
    public ExecutorService f38047e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, b> f38048f;

    /* renamed from: g  reason: collision with root package name */
    public a f38049g;

    /* loaded from: classes7.dex */
    public interface a {
        void a(String str, String str2);
    }

    /* loaded from: classes7.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final com.kwai.sodler.lib.a.f f38053a;

        /* renamed from: b  reason: collision with root package name */
        public final Future<com.kwai.sodler.lib.a.f> f38054b;

        public b(com.kwai.sodler.lib.a.f fVar, Future<com.kwai.sodler.lib.a.f> future) {
            this.f38053a = fVar;
            this.f38054b = future;
        }

        public void a() {
            this.f38053a.e();
            this.f38054b.cancel(true);
        }
    }

    public j() {
        super(null, null, null, null, null, null);
        this.f38044b = false;
    }

    public static j a() {
        if (f38043a == null) {
            synchronized (j.class) {
                if (f38043a == null) {
                    f38043a = new j();
                }
            }
        }
        return f38043a;
    }

    public static ExecutorService i() {
        return new ThreadPoolExecutor(1, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue());
    }

    private void j() {
        if (!this.f38044b) {
            throw new RuntimeException("Sodler has not yet been init.");
        }
    }

    @Override // com.kwai.sodler.lib.k
    public com.kwai.sodler.lib.a.f a(@NonNull com.kwai.sodler.lib.a.f fVar, @NonNull k.a aVar) {
        if (this.f38044b) {
            com.kwai.sodler.lib.a.e b2 = fVar.b();
            k kVar = this.f38045c;
            if (b2 == null) {
                b2 = kVar;
            }
            return kVar.a(fVar.a(b2), aVar);
        }
        throw new RuntimeException("Sodler has not yet been init.");
    }

    public b a(@NonNull com.kwai.sodler.lib.a.f fVar, int i2) {
        return b(fVar, k.a.a(this, i2));
    }

    public synchronized void a(Context context, @NonNull com.kwai.sodler.lib.ext.c cVar) {
        if (!this.f38044b) {
            d dVar = new d(context);
            e eVar = new e(context);
            c cVar2 = new c(context, cVar);
            com.kwai.sodler.lib.b bVar = new com.kwai.sodler.lib.b();
            this.f38046d = new com.kwai.sodler.lib.ext.a();
            this.f38047e = i();
            this.f38045c = new k(dVar, eVar, cVar2, bVar, cVar, new com.kwai.sodler.lib.ext.a());
            this.f38044b = true;
            j();
        }
    }

    @Override // com.kwai.sodler.lib.k, com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.ext.c b() {
        if (this.f38044b) {
            return this.f38045c.b();
        }
        throw new RuntimeException("Sodler has not yet been init.");
    }

    public b b(@NonNull final com.kwai.sodler.lib.a.f fVar, @NonNull final k.a aVar) {
        if (this.f38044b) {
            Map<String, b> a2 = a(this.f38048f);
            this.f38048f = a2;
            b bVar = a2.get(fVar.i());
            if (bVar != null) {
                bVar.a();
            }
            fVar.a(this);
            b bVar2 = new b(fVar, this.f38047e.submit(new Callable<com.kwai.sodler.lib.a.f>() { // from class: com.kwai.sodler.lib.j.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public com.kwai.sodler.lib.a.f call() {
                    return j.this.a(fVar, aVar);
                }
            }));
            if (fVar.i() != null) {
                this.f38048f.put(fVar.i(), bVar2);
            }
            return bVar2;
        }
        throw new RuntimeException("Sodler has not yet been init.");
    }

    @Override // com.kwai.sodler.lib.k, com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.a.d c() {
        if (this.f38044b) {
            return this.f38045c.c();
        }
        throw new RuntimeException("Sodler has not yet been init.");
    }

    @Override // com.kwai.sodler.lib.k, com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.a.g d() {
        if (this.f38044b) {
            return this.f38045c.d();
        }
        throw new RuntimeException("Sodler has not yet been init.");
    }

    @Override // com.kwai.sodler.lib.k, com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.a.c e() {
        if (this.f38044b) {
            return this.f38045c.e();
        }
        throw new RuntimeException("Sodler has not yet been init.");
    }

    @Override // com.kwai.sodler.lib.k, com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.a.b f() {
        if (this.f38044b) {
            return this.f38045c.f();
        }
        throw new RuntimeException("Sodler has not yet been init.");
    }

    @Override // com.kwai.sodler.lib.k, com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.ext.a g() {
        if (this.f38044b) {
            return this.f38046d;
        }
        throw new RuntimeException("Sodler has not yet been init.");
    }

    public a h() {
        return this.f38049g;
    }
}
