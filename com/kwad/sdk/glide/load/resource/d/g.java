package com.kwad.sdk.glide.load.resource.d;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.kwad.sdk.glide.g.k;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    final com.kwad.sdk.glide.g f6809a;
    private final com.kwad.sdk.glide.b.a b;
    private final Handler c;
    private final List<b> d;
    private final com.kwad.sdk.glide.load.engine.bitmap_recycle.e e;
    private boolean f;
    private boolean g;
    private boolean h;
    private com.kwad.sdk.glide.f<Bitmap> i;
    private a j;
    private boolean k;
    private a l;
    private Bitmap m;
    private com.kwad.sdk.glide.load.h<Bitmap> n;
    private a o;
    @Nullable
    private d p;

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes3.dex */
    public static class a extends com.kwad.sdk.glide.request.a.h<Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        final int f6810a;
        private final Handler b;
        private final long c;
        private Bitmap d;

        a(Handler handler, int i, long j) {
            this.b = handler;
            this.f6810a = i;
            this.c = j;
        }

        Bitmap a() {
            return this.d;
        }

        public void a(@NonNull Bitmap bitmap, @Nullable com.kwad.sdk.glide.request.b.b<? super Bitmap> bVar) {
            this.d = bitmap;
            this.b.sendMessageAtTime(this.b.obtainMessage(1, this), this.c);
        }

        @Override // com.kwad.sdk.glide.request.a.j
        public /* bridge */ /* synthetic */ void a(@NonNull Object obj, @Nullable com.kwad.sdk.glide.request.b.b bVar) {
            a((Bitmap) obj, (com.kwad.sdk.glide.request.b.b<? super Bitmap>) bVar);
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void f();
    }

    /* loaded from: classes3.dex */
    private class c implements Handler.Callback {
        c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                g.this.a((a) message.obj);
                return true;
            }
            if (message.what == 2) {
                g.this.f6809a.a((a) message.obj);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes3.dex */
    public interface d {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(com.kwad.sdk.glide.c cVar, com.kwad.sdk.glide.b.a aVar, int i, int i2, com.kwad.sdk.glide.load.h<Bitmap> hVar, Bitmap bitmap) {
        this(cVar.a(), com.kwad.sdk.glide.c.b(cVar.c()), aVar, null, a(com.kwad.sdk.glide.c.b(cVar.c()), i, i2), hVar, bitmap);
    }

    g(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, com.kwad.sdk.glide.g gVar, com.kwad.sdk.glide.b.a aVar, Handler handler, com.kwad.sdk.glide.f<Bitmap> fVar, com.kwad.sdk.glide.load.h<Bitmap> hVar, Bitmap bitmap) {
        this.d = new ArrayList();
        this.f6809a = gVar;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new c()) : handler;
        this.e = eVar;
        this.c = handler;
        this.i = fVar;
        this.b = aVar;
        a(hVar, bitmap);
    }

    private static com.kwad.sdk.glide.f<Bitmap> a(com.kwad.sdk.glide.g gVar, int i, int i2) {
        return gVar.f().a((com.kwad.sdk.glide.request.a<?>) com.kwad.sdk.glide.request.f.b(com.kwad.sdk.glide.load.engine.h.b).a(true).b(true).b(i, i2));
    }

    private int j() {
        return k.a(i().getWidth(), i().getHeight(), i().getConfig());
    }

    private void k() {
        if (this.f) {
            return;
        }
        this.f = true;
        this.k = false;
        m();
    }

    private void l() {
        this.f = false;
    }

    private void m() {
        if (!this.f || this.g) {
            return;
        }
        if (this.h) {
            com.kwad.sdk.glide.g.j.a(this.o == null, "Pending target must be null when starting from the first frame");
            this.b.f();
            this.h = false;
        }
        if (this.o != null) {
            a aVar = this.o;
            this.o = null;
            a(aVar);
            return;
        }
        this.g = true;
        long c2 = this.b.c() + SystemClock.uptimeMillis();
        this.b.b();
        this.l = new a(this.c, this.b.e(), c2);
        this.i.a((com.kwad.sdk.glide.request.a<?>) com.kwad.sdk.glide.request.f.b(o())).a(this.b).a((com.kwad.sdk.glide.f<Bitmap>) this.l);
    }

    private void n() {
        if (this.m != null) {
            this.e.a(this.m);
            this.m = null;
        }
    }

    private static com.kwad.sdk.glide.load.c o() {
        return new com.kwad.sdk.glide.f.b(Double.valueOf(Math.random()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bitmap a() {
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.kwad.sdk.glide.load.h<Bitmap> hVar, Bitmap bitmap) {
        this.n = (com.kwad.sdk.glide.load.h) com.kwad.sdk.glide.g.j.a(hVar);
        this.m = (Bitmap) com.kwad.sdk.glide.g.j.a(bitmap);
        this.i = this.i.a((com.kwad.sdk.glide.request.a<?>) new com.kwad.sdk.glide.request.f().a(hVar));
    }

    @VisibleForTesting
    void a(a aVar) {
        if (this.p != null) {
            this.p.a();
        }
        this.g = false;
        if (this.k) {
            this.c.obtainMessage(2, aVar).sendToTarget();
        } else if (!this.f) {
            this.o = aVar;
        } else {
            if (aVar.a() != null) {
                n();
                a aVar2 = this.j;
                this.j = aVar;
                for (int size = this.d.size() - 1; size >= 0; size--) {
                    this.d.get(size).f();
                }
                if (aVar2 != null) {
                    this.c.obtainMessage(2, aVar2).sendToTarget();
                }
            }
            m();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        if (this.k) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        }
        if (this.d.contains(bVar)) {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        boolean isEmpty = this.d.isEmpty();
        this.d.add(bVar);
        if (isEmpty) {
            k();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return i().getWidth();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(b bVar) {
        this.d.remove(bVar);
        if (this.d.isEmpty()) {
            l();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return i().getHeight();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.b.g() + j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        if (this.j != null) {
            return this.j.f6810a;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteBuffer f() {
        return this.b.a().asReadOnlyBuffer();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.b.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        this.d.clear();
        n();
        l();
        if (this.j != null) {
            this.f6809a.a(this.j);
            this.j = null;
        }
        if (this.l != null) {
            this.f6809a.a(this.l);
            this.l = null;
        }
        if (this.o != null) {
            this.f6809a.a(this.o);
            this.o = null;
        }
        this.b.i();
        this.k = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bitmap i() {
        return this.j != null ? this.j.a() : this.m;
    }
}
