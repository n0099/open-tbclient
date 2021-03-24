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
    public final com.kwad.sdk.glide.g f35725a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.glide.b.a f35726b;

    /* renamed from: c  reason: collision with root package name */
    public final Handler f35727c;

    /* renamed from: d  reason: collision with root package name */
    public final List<b> f35728d;

    /* renamed from: e  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.e f35729e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f35730f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f35731g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f35732h;
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
        public final int f35733a;

        /* renamed from: b  reason: collision with root package name */
        public final Handler f35734b;

        /* renamed from: c  reason: collision with root package name */
        public final long f35735c;

        /* renamed from: d  reason: collision with root package name */
        public Bitmap f35736d;

        public a(Handler handler, int i, long j) {
            this.f35734b = handler;
            this.f35733a = i;
            this.f35735c = j;
        }

        public Bitmap a() {
            return this.f35736d;
        }

        public void a(@NonNull Bitmap bitmap, @Nullable com.kwad.sdk.glide.request.b.b<? super Bitmap> bVar) {
            this.f35736d = bitmap;
            this.f35734b.sendMessageAtTime(this.f35734b.obtainMessage(1, this), this.f35735c);
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
                g.this.f35725a.a((a) message.obj);
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
        this.f35728d = new ArrayList();
        this.f35725a = gVar;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new c()) : handler;
        this.f35729e = eVar;
        this.f35727c = handler;
        this.i = fVar;
        this.f35726b = aVar;
        a(hVar, bitmap);
    }

    public static com.kwad.sdk.glide.f<Bitmap> a(com.kwad.sdk.glide.g gVar, int i, int i2) {
        return gVar.f().a((com.kwad.sdk.glide.request.a<?>) com.kwad.sdk.glide.request.f.b(com.kwad.sdk.glide.load.engine.h.f35536b).a(true).b(true).b(i, i2));
    }

    private int j() {
        return k.a(i().getWidth(), i().getHeight(), i().getConfig());
    }

    private void k() {
        if (this.f35730f) {
            return;
        }
        this.f35730f = true;
        this.k = false;
        m();
    }

    private void l() {
        this.f35730f = false;
    }

    private void m() {
        if (!this.f35730f || this.f35731g) {
            return;
        }
        if (this.f35732h) {
            com.kwad.sdk.glide.g.j.a(this.o == null, "Pending target must be null when starting from the first frame");
            this.f35726b.f();
            this.f35732h = false;
        }
        a aVar = this.o;
        if (aVar != null) {
            this.o = null;
            a(aVar);
            return;
        }
        this.f35731g = true;
        long uptimeMillis = SystemClock.uptimeMillis() + this.f35726b.c();
        this.f35726b.b();
        this.l = new a(this.f35727c, this.f35726b.e(), uptimeMillis);
        this.i.a((com.kwad.sdk.glide.request.a<?>) com.kwad.sdk.glide.request.f.b(o())).a(this.f35726b).a((com.kwad.sdk.glide.f<Bitmap>) this.l);
    }

    private void n() {
        Bitmap bitmap = this.m;
        if (bitmap != null) {
            this.f35729e.a(bitmap);
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
        this.f35731g = false;
        if (this.k) {
            this.f35727c.obtainMessage(2, aVar).sendToTarget();
        } else if (!this.f35730f) {
            this.o = aVar;
        } else {
            if (aVar.a() != null) {
                n();
                a aVar2 = this.j;
                this.j = aVar;
                for (int size = this.f35728d.size() - 1; size >= 0; size--) {
                    this.f35728d.get(size).f();
                }
                if (aVar2 != null) {
                    this.f35727c.obtainMessage(2, aVar2).sendToTarget();
                }
            }
            m();
        }
    }

    public void a(b bVar) {
        if (this.k) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        }
        if (this.f35728d.contains(bVar)) {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        boolean isEmpty = this.f35728d.isEmpty();
        this.f35728d.add(bVar);
        if (isEmpty) {
            k();
        }
    }

    public int b() {
        return i().getWidth();
    }

    public void b(b bVar) {
        this.f35728d.remove(bVar);
        if (this.f35728d.isEmpty()) {
            l();
        }
    }

    public int c() {
        return i().getHeight();
    }

    public int d() {
        return this.f35726b.g() + j();
    }

    public int e() {
        a aVar = this.j;
        if (aVar != null) {
            return aVar.f35733a;
        }
        return -1;
    }

    public ByteBuffer f() {
        return this.f35726b.a().asReadOnlyBuffer();
    }

    public int g() {
        return this.f35726b.d();
    }

    public void h() {
        this.f35728d.clear();
        n();
        l();
        a aVar = this.j;
        if (aVar != null) {
            this.f35725a.a(aVar);
            this.j = null;
        }
        a aVar2 = this.l;
        if (aVar2 != null) {
            this.f35725a.a(aVar2);
            this.l = null;
        }
        a aVar3 = this.o;
        if (aVar3 != null) {
            this.f35725a.a(aVar3);
            this.o = null;
        }
        this.f35726b.i();
        this.k = true;
    }

    public Bitmap i() {
        a aVar = this.j;
        return aVar != null ? aVar.a() : this.m;
    }
}
