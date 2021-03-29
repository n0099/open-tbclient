package com.kwad.sdk.glide.load.engine;

import androidx.annotation.NonNull;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.a.d;
import com.kwad.sdk.glide.load.b.n;
import com.kwad.sdk.glide.load.engine.e;
import java.io.File;
import java.util.List;
/* loaded from: classes6.dex */
public class t implements d.a<Object>, e {

    /* renamed from: a  reason: collision with root package name */
    public final e.a f35605a;

    /* renamed from: b  reason: collision with root package name */
    public final f<?> f35606b;

    /* renamed from: c  reason: collision with root package name */
    public int f35607c;

    /* renamed from: d  reason: collision with root package name */
    public int f35608d = -1;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.glide.load.c f35609e;

    /* renamed from: f  reason: collision with root package name */
    public List<com.kwad.sdk.glide.load.b.n<File, ?>> f35610f;

    /* renamed from: g  reason: collision with root package name */
    public int f35611g;

    /* renamed from: h  reason: collision with root package name */
    public volatile n.a<?> f35612h;
    public File i;
    public u j;

    public t(f<?> fVar, e.a aVar) {
        this.f35606b = fVar;
        this.f35605a = aVar;
    }

    private boolean c() {
        return this.f35611g < this.f35610f.size();
    }

    @Override // com.kwad.sdk.glide.load.a.d.a
    public void a(@NonNull Exception exc) {
        this.f35605a.a(this.j, exc, this.f35612h.f35336c, DataSource.RESOURCE_DISK_CACHE);
    }

    @Override // com.kwad.sdk.glide.load.a.d.a
    public void a(Object obj) {
        this.f35605a.a(this.f35609e, obj, this.f35612h.f35336c, DataSource.RESOURCE_DISK_CACHE, this.j);
    }

    @Override // com.kwad.sdk.glide.load.engine.e
    public boolean a() {
        List<com.kwad.sdk.glide.load.c> o = this.f35606b.o();
        boolean z = false;
        if (o.isEmpty()) {
            return false;
        }
        List<Class<?>> l = this.f35606b.l();
        if (l.isEmpty()) {
            if (File.class.equals(this.f35606b.j())) {
                return false;
            }
            throw new IllegalStateException("Failed to find any load path from " + this.f35606b.k() + " to " + this.f35606b.j());
        }
        while (true) {
            if (this.f35610f != null && c()) {
                this.f35612h = null;
                while (!z && c()) {
                    List<com.kwad.sdk.glide.load.b.n<File, ?>> list = this.f35610f;
                    int i = this.f35611g;
                    this.f35611g = i + 1;
                    this.f35612h = list.get(i).a(this.i, this.f35606b.g(), this.f35606b.h(), this.f35606b.e());
                    if (this.f35612h != null && this.f35606b.a(this.f35612h.f35336c.a())) {
                        this.f35612h.f35336c.a(this.f35606b.d(), this);
                        z = true;
                    }
                }
                return z;
            }
            int i2 = this.f35608d + 1;
            this.f35608d = i2;
            if (i2 >= l.size()) {
                int i3 = this.f35607c + 1;
                this.f35607c = i3;
                if (i3 >= o.size()) {
                    return false;
                }
                this.f35608d = 0;
            }
            com.kwad.sdk.glide.load.c cVar = o.get(this.f35607c);
            Class<?> cls = l.get(this.f35608d);
            this.j = new u(this.f35606b.i(), cVar, this.f35606b.f(), this.f35606b.g(), this.f35606b.h(), this.f35606b.c(cls), cls, this.f35606b.e());
            File a2 = this.f35606b.b().a(this.j);
            this.i = a2;
            if (a2 != null) {
                this.f35609e = cVar;
                this.f35610f = this.f35606b.a(a2);
                this.f35611g = 0;
            }
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.e
    public void b() {
        n.a<?> aVar = this.f35612h;
        if (aVar != null) {
            aVar.f35336c.c();
        }
    }
}
