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
/* loaded from: classes6.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.glide.g f36110a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.glide.b.a f36111b;

    /* renamed from: c  reason: collision with root package name */
    public final Handler f36112c;

    /* renamed from: d  reason: collision with root package name */
    public final List<b> f36113d;

    /* renamed from: e  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.e f36114e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f36115f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f36116g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f36117h;
    public com.kwad.sdk.glide.f<Bitmap> i;
    public a j;
    public boolean k;
    public a l;
    public Bitmap m;
    public com.kwad.sdk.glide.load.h<Bitmap> n;
    public a o;
    @Nullable
    public d p;

    @VisibleForTesting
    /* loaded from: classes6.dex */
    public static class a extends com.kwad.sdk.glide.request.a.h<Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        public final int f36118a;

        /* renamed from: b  reason: collision with root package name */
        public final Handler f36119b;

        /* renamed from: c  reason: collision with root package name */
        public final long f36120c;

        /* renamed from: d  reason: collision with root package name */
        public Bitmap f36121d;

        public a(Handler handler, int i, long j) {
            this.f36119b = handler;
            this.f36118a = i;
            this.f36120c = j;
        }

        public Bitmap a() {
            return this.f36121d;
        }

        public void a(@NonNull Bitmap bitmap, @Nullable com.kwad.sdk.glide.request.b.b<? super Bitmap> bVar) {
            this.f36121d = bitmap;
            this.f36119b.sendMessageAtTime(this.f36119b.obtainMessage(1, this), this.f36120c);
        }

        @Override // com.kwad.sdk.glide.request.a.j
        public /* bridge */ /* synthetic */ void a(@NonNull Object obj, @Nullable com.kwad.sdk.glide.request.b.b bVar) {
            a((Bitmap) obj, (com.kwad.sdk.glide.request.b.b<? super Bitmap>) bVar);
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void f();
    }

    /* loaded from: classes6.dex */
    public class c implements Handler.Callback {
        public c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                g.this.a((a) message.obj);
                return true;
            } else if (i == 2) {
                g.this.f36110a.a((a) message.obj);
                return false;
            } else {
                return false;
            }
        }
    }

    @VisibleForTesting
    /* loaded from: classes6.dex */
    public interface d {
        void a();
    }

    public g(com.kwad.sdk.glide.c cVar, com.kwad.sdk.glide.b.a aVar, int i, int i2, com.kwad.sdk.glide.load.h<Bitmap> hVar, Bitmap bitmap) {
        this(cVar.a(), com.kwad.sdk.glide.c.b(cVar.c()), aVar, null, a(com.kwad.sdk.glide.c.b(cVar.c()), i, i2), hVar, bitmap);
    }

    public g(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, com.kwad.sdk.glide.g gVar, com.kwad.sdk.glide.b.a aVar, Handler handler, com.kwad.sdk.glide.f<Bitmap> fVar, com.kwad.sdk.glide.load.h<Bitmap> hVar, Bitmap bitmap) {
        this.f36113d = new ArrayList();
        this.f36110a = gVar;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new c()) : handler;
        this.f36114e = eVar;
        this.f36112c = handler;
        this.i = fVar;
        this.f36111b = aVar;
        a(hVar, bitmap);
    }

    public static com.kwad.sdk.glide.f<Bitmap> a(com.kwad.sdk.glide.g gVar, int i, int i2) {
        return gVar.f().a((com.kwad.sdk.glide.request.a<?>) com.kwad.sdk.glide.request.f.b(com.kwad.sdk.glide.load.engine.h.f35921b).a(true).b(true).b(i, i2));
    }

    private int j() {
        return k.a(i().getWidth(), i().getHeight(), i().getConfig());
    }

    private void k() {
        if (this.f36115f) {
            return;
        }
        this.f36115f = true;
        this.k = false;
        m();
    }

    private void l() {
        this.f36115f = false;
    }

    private void m() {
        if (!this.f36115f || this.f36116g) {
            return;
        }
        if (this.f36117h) {
            com.kwad.sdk.glide.g.j.a(this.o == null, "Pending target must be null when starting from the first frame");
            this.f36111b.f();
            this.f36117h = false;
        }
        a aVar = this.o;
        if (aVar != null) {
            this.o = null;
            a(aVar);
            return;
        }
        this.f36116g = true;
        long uptimeMillis = SystemClock.uptimeMillis() + this.f36111b.c();
        this.f36111b.b();
        this.l = new a(this.f36112c, this.f36111b.e(), uptimeMillis);
        this.i.a((com.kwad.sdk.glide.request.a<?>) com.kwad.sdk.glide.request.f.b(o())).a(this.f36111b).a((com.kwad.sdk.glide.f<Bitmap>) this.l);
    }

    private void n() {
        Bitmap bitmap = this.m;
        if (bitmap != null) {
            this.f36114e.a(bitmap);
            this.m = null;
        }
    }

    public static com.kwad.sdk.glide.load.c o() {
        return new com.kwad.sdk.glide.f.b(Double.valueOf(Math.random()));
    }

    public Bitmap a() {
        return this.m;
    }

    public void a(com.kwad.sdk.glide.load.h<Bitmap> hVar, Bitmap bitmap) {
        this.n = (com.kwad.sdk.glide.load.h) com.kwad.sdk.glide.g.j.a(hVar);
        this.m = (Bitmap) com.kwad.sdk.glide.g.j.a(bitmap);
        this.i = this.i.a((com.kwad.sdk.glide.request.a<?>) new com.kwad.sdk.glide.request.f().a(hVar));
    }

    @VisibleForTesting
    public void a(a aVar) {
        d dVar = this.p;
        if (dVar != null) {
            dVar.a();
        }
        this.f36116g = false;
        if (this.k) {
            this.f36112c.obtainMessage(2, aVar).sendToTarget();
        } else if (!this.f36115f) {
            this.o = aVar;
        } else {
            if (aVar.a() != null) {
                n();
                a aVar2 = this.j;
                this.j = aVar;
                for (int size = this.f36113d.size() - 1; size >= 0; size--) {
                    this.f36113d.get(size).f();
                }
                if (aVar2 != null) {
                    this.f36112c.obtainMessage(2, aVar2).sendToTarget();
                }
            }
            m();
        }
    }

    public void a(b bVar) {
        if (this.k) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        }
        if (this.f36113d.contains(bVar)) {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        boolean isEmpty = this.f36113d.isEmpty();
        this.f36113d.add(bVar);
        if (isEmpty) {
            k();
        }
    }

    public int b() {
        return i().getWidth();
    }

    public void b(b bVar) {
        this.f36113d.remove(bVar);
        if (this.f36113d.isEmpty()) {
            l();
        }
    }

    public int c() {
        return i().getHeight();
    }

    public int d() {
        return this.f36111b.g() + j();
    }

    public int e() {
        a aVar = this.j;
        if (aVar != null) {
            return aVar.f36118a;
        }
        return -1;
    }

    public ByteBuffer f() {
        return this.f36111b.a().asReadOnlyBuffer();
    }

    public int g() {
        return this.f36111b.d();
    }

    public void h() {
        this.f36113d.clear();
        n();
        l();
        a aVar = this.j;
        if (aVar != null) {
            this.f36110a.a(aVar);
            this.j = null;
        }
        a aVar2 = this.l;
        if (aVar2 != null) {
            this.f36110a.a(aVar2);
            this.l = null;
        }
        a aVar3 = this.o;
        if (aVar3 != null) {
            this.f36110a.a(aVar3);
            this.o = null;
        }
        this.f36111b.i();
        this.k = true;
    }

    public Bitmap i() {
        a aVar = this.j;
        return aVar != null ? aVar.a() : this.m;
    }
}
