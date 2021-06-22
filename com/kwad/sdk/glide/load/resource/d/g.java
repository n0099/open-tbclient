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
/* loaded from: classes7.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.glide.g f36519a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.glide.b.a f36520b;

    /* renamed from: c  reason: collision with root package name */
    public final Handler f36521c;

    /* renamed from: d  reason: collision with root package name */
    public final List<b> f36522d;

    /* renamed from: e  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.e f36523e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f36524f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f36525g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f36526h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.glide.f<Bitmap> f36527i;
    public a j;
    public boolean k;
    public a l;
    public Bitmap m;
    public com.kwad.sdk.glide.load.h<Bitmap> n;
    public a o;
    @Nullable
    public d p;

    @VisibleForTesting
    /* loaded from: classes7.dex */
    public static class a extends com.kwad.sdk.glide.request.a.h<Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        public final int f36528a;

        /* renamed from: b  reason: collision with root package name */
        public final Handler f36529b;

        /* renamed from: c  reason: collision with root package name */
        public final long f36530c;

        /* renamed from: d  reason: collision with root package name */
        public Bitmap f36531d;

        public a(Handler handler, int i2, long j) {
            this.f36529b = handler;
            this.f36528a = i2;
            this.f36530c = j;
        }

        public Bitmap a() {
            return this.f36531d;
        }

        public void a(@NonNull Bitmap bitmap, @Nullable com.kwad.sdk.glide.request.b.b<? super Bitmap> bVar) {
            this.f36531d = bitmap;
            this.f36529b.sendMessageAtTime(this.f36529b.obtainMessage(1, this), this.f36530c);
        }

        @Override // com.kwad.sdk.glide.request.a.j
        public /* bridge */ /* synthetic */ void a(@NonNull Object obj, @Nullable com.kwad.sdk.glide.request.b.b bVar) {
            a((Bitmap) obj, (com.kwad.sdk.glide.request.b.b<? super Bitmap>) bVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void f();
    }

    /* loaded from: classes7.dex */
    public class c implements Handler.Callback {
        public c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                g.this.a((a) message.obj);
                return true;
            } else if (i2 == 2) {
                g.this.f36519a.a((a) message.obj);
                return false;
            } else {
                return false;
            }
        }
    }

    @VisibleForTesting
    /* loaded from: classes7.dex */
    public interface d {
        void a();
    }

    public g(com.kwad.sdk.glide.c cVar, com.kwad.sdk.glide.b.a aVar, int i2, int i3, com.kwad.sdk.glide.load.h<Bitmap> hVar, Bitmap bitmap) {
        this(cVar.a(), com.kwad.sdk.glide.c.b(cVar.c()), aVar, null, a(com.kwad.sdk.glide.c.b(cVar.c()), i2, i3), hVar, bitmap);
    }

    public g(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, com.kwad.sdk.glide.g gVar, com.kwad.sdk.glide.b.a aVar, Handler handler, com.kwad.sdk.glide.f<Bitmap> fVar, com.kwad.sdk.glide.load.h<Bitmap> hVar, Bitmap bitmap) {
        this.f36522d = new ArrayList();
        this.f36519a = gVar;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new c()) : handler;
        this.f36523e = eVar;
        this.f36521c = handler;
        this.f36527i = fVar;
        this.f36520b = aVar;
        a(hVar, bitmap);
    }

    public static com.kwad.sdk.glide.f<Bitmap> a(com.kwad.sdk.glide.g gVar, int i2, int i3) {
        return gVar.f().a((com.kwad.sdk.glide.request.a<?>) com.kwad.sdk.glide.request.f.b(com.kwad.sdk.glide.load.engine.h.f36323b).a(true).b(true).b(i2, i3));
    }

    private int j() {
        return k.a(i().getWidth(), i().getHeight(), i().getConfig());
    }

    private void k() {
        if (this.f36524f) {
            return;
        }
        this.f36524f = true;
        this.k = false;
        m();
    }

    private void l() {
        this.f36524f = false;
    }

    private void m() {
        if (!this.f36524f || this.f36525g) {
            return;
        }
        if (this.f36526h) {
            com.kwad.sdk.glide.g.j.a(this.o == null, "Pending target must be null when starting from the first frame");
            this.f36520b.f();
            this.f36526h = false;
        }
        a aVar = this.o;
        if (aVar != null) {
            this.o = null;
            a(aVar);
            return;
        }
        this.f36525g = true;
        long uptimeMillis = SystemClock.uptimeMillis() + this.f36520b.c();
        this.f36520b.b();
        this.l = new a(this.f36521c, this.f36520b.e(), uptimeMillis);
        this.f36527i.a((com.kwad.sdk.glide.request.a<?>) com.kwad.sdk.glide.request.f.b(o())).a(this.f36520b).a((com.kwad.sdk.glide.f<Bitmap>) this.l);
    }

    private void n() {
        Bitmap bitmap = this.m;
        if (bitmap != null) {
            this.f36523e.a(bitmap);
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
        this.f36527i = this.f36527i.a((com.kwad.sdk.glide.request.a<?>) new com.kwad.sdk.glide.request.f().a(hVar));
    }

    @VisibleForTesting
    public void a(a aVar) {
        d dVar = this.p;
        if (dVar != null) {
            dVar.a();
        }
        this.f36525g = false;
        if (this.k) {
            this.f36521c.obtainMessage(2, aVar).sendToTarget();
        } else if (!this.f36524f) {
            this.o = aVar;
        } else {
            if (aVar.a() != null) {
                n();
                a aVar2 = this.j;
                this.j = aVar;
                for (int size = this.f36522d.size() - 1; size >= 0; size--) {
                    this.f36522d.get(size).f();
                }
                if (aVar2 != null) {
                    this.f36521c.obtainMessage(2, aVar2).sendToTarget();
                }
            }
            m();
        }
    }

    public void a(b bVar) {
        if (this.k) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        }
        if (this.f36522d.contains(bVar)) {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        boolean isEmpty = this.f36522d.isEmpty();
        this.f36522d.add(bVar);
        if (isEmpty) {
            k();
        }
    }

    public int b() {
        return i().getWidth();
    }

    public void b(b bVar) {
        this.f36522d.remove(bVar);
        if (this.f36522d.isEmpty()) {
            l();
        }
    }

    public int c() {
        return i().getHeight();
    }

    public int d() {
        return this.f36520b.g() + j();
    }

    public int e() {
        a aVar = this.j;
        if (aVar != null) {
            return aVar.f36528a;
        }
        return -1;
    }

    public ByteBuffer f() {
        return this.f36520b.a().asReadOnlyBuffer();
    }

    public int g() {
        return this.f36520b.d();
    }

    public void h() {
        this.f36522d.clear();
        n();
        l();
        a aVar = this.j;
        if (aVar != null) {
            this.f36519a.a(aVar);
            this.j = null;
        }
        a aVar2 = this.l;
        if (aVar2 != null) {
            this.f36519a.a(aVar2);
            this.l = null;
        }
        a aVar3 = this.o;
        if (aVar3 != null) {
            this.f36519a.a(aVar3);
            this.o = null;
        }
        this.f36520b.i();
        this.k = true;
    }

    public Bitmap i() {
        a aVar = this.j;
        return aVar != null ? aVar.a() : this.m;
    }
}
