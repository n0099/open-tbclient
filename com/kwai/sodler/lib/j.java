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
/* loaded from: classes6.dex */
public final class j extends k {

    /* renamed from: a  reason: collision with root package name */
    public static volatile j f37561a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f37562b;

    /* renamed from: c  reason: collision with root package name */
    public k f37563c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwai.sodler.lib.ext.a f37564d;

    /* renamed from: e  reason: collision with root package name */
    public ExecutorService f37565e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, b> f37566f;

    /* renamed from: g  reason: collision with root package name */
    public a f37567g;

    /* loaded from: classes6.dex */
    public interface a {
        void a(String str, String str2);
    }

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final com.kwai.sodler.lib.a.f f37571a;

        /* renamed from: b  reason: collision with root package name */
        public final Future<com.kwai.sodler.lib.a.f> f37572b;

        public b(com.kwai.sodler.lib.a.f fVar, Future<com.kwai.sodler.lib.a.f> future) {
            this.f37571a = fVar;
            this.f37572b = future;
        }

        public void a() {
            this.f37571a.e();
            this.f37572b.cancel(true);
        }
    }

    public j() {
        super(null, null, null, null, null, null);
        this.f37562b = false;
    }

    public static j a() {
        if (f37561a == null) {
            synchronized (j.class) {
                if (f37561a == null) {
                    f37561a = new j();
                }
            }
        }
        return f37561a;
    }

    public static ExecutorService i() {
        return new ThreadPoolExecutor(1, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue());
    }

    private void j() {
        if (!this.f37562b) {
            throw new RuntimeException("Sodler has not yet been init.");
        }
    }

    @Override // com.kwai.sodler.lib.k
    public com.kwai.sodler.lib.a.f a(@NonNull com.kwai.sodler.lib.a.f fVar, @NonNull k.a aVar) {
        if (this.f37562b) {
            com.kwai.sodler.lib.a.e b2 = fVar.b();
            k kVar = this.f37563c;
            if (b2 == null) {
                b2 = kVar;
            }
            return kVar.a(fVar.a(b2), aVar);
        }
        throw new RuntimeException("Sodler has not yet been init.");
    }

    public b a(@NonNull com.kwai.sodler.lib.a.f fVar, int i) {
        return b(fVar, k.a.a(this, i));
    }

    public synchronized void a(Context context, @NonNull com.kwai.sodler.lib.ext.c cVar) {
        if (!this.f37562b) {
            d dVar = new d(context);
            e eVar = new e(context);
            c cVar2 = new c(context, cVar);
            com.kwai.sodler.lib.b bVar = new com.kwai.sodler.lib.b();
            this.f37564d = new com.kwai.sodler.lib.ext.a();
            this.f37565e = i();
            this.f37563c = new k(dVar, eVar, cVar2, bVar, cVar, new com.kwai.sodler.lib.ext.a());
            this.f37562b = true;
            j();
        }
    }

    @Override // com.kwai.sodler.lib.k, com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.ext.c b() {
        if (this.f37562b) {
            return this.f37563c.b();
        }
        throw new RuntimeException("Sodler has not yet been init.");
    }

    public b b(@NonNull final com.kwai.sodler.lib.a.f fVar, @NonNull final k.a aVar) {
        if (this.f37562b) {
            Map<String, b> a2 = a(this.f37566f);
            this.f37566f = a2;
            b bVar = a2.get(fVar.i());
            if (bVar != null) {
                bVar.a();
            }
            fVar.a(this);
            b bVar2 = new b(fVar, this.f37565e.submit(new Callable<com.kwai.sodler.lib.a.f>() { // from class: com.kwai.sodler.lib.j.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public com.kwai.sodler.lib.a.f call() {
                    return j.this.a(fVar, aVar);
                }
            }));
            if (fVar.i() != null) {
                this.f37566f.put(fVar.i(), bVar2);
            }
            return bVar2;
        }
        throw new RuntimeException("Sodler has not yet been init.");
    }

    @Override // com.kwai.sodler.lib.k, com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.a.d c() {
        if (this.f37562b) {
            return this.f37563c.c();
        }
        throw new RuntimeException("Sodler has not yet been init.");
    }

    @Override // com.kwai.sodler.lib.k, com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.a.g d() {
        if (this.f37562b) {
            return this.f37563c.d();
        }
        throw new RuntimeException("Sodler has not yet been init.");
    }

    @Override // com.kwai.sodler.lib.k, com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.a.c e() {
        if (this.f37562b) {
            return this.f37563c.e();
        }
        throw new RuntimeException("Sodler has not yet been init.");
    }

    @Override // com.kwai.sodler.lib.k, com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.a.b f() {
        if (this.f37562b) {
            return this.f37563c.f();
        }
        throw new RuntimeException("Sodler has not yet been init.");
    }

    @Override // com.kwai.sodler.lib.k, com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.ext.a g() {
        if (this.f37562b) {
            return this.f37564d;
        }
        throw new RuntimeException("Sodler has not yet been init.");
    }

    public a h() {
        return this.f37567g;
    }
}
