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
    public final e.a f35604a;

    /* renamed from: b  reason: collision with root package name */
    public final f<?> f35605b;

    /* renamed from: c  reason: collision with root package name */
    public int f35606c;

    /* renamed from: d  reason: collision with root package name */
    public int f35607d = -1;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.glide.load.c f35608e;

    /* renamed from: f  reason: collision with root package name */
    public List<com.kwad.sdk.glide.load.b.n<File, ?>> f35609f;

    /* renamed from: g  reason: collision with root package name */
    public int f35610g;

    /* renamed from: h  reason: collision with root package name */
    public volatile n.a<?> f35611h;
    public File i;
    public u j;

    public t(f<?> fVar, e.a aVar) {
        this.f35605b = fVar;
        this.f35604a = aVar;
    }

    private boolean c() {
        return this.f35610g < this.f35609f.size();
    }

    @Override // com.kwad.sdk.glide.load.a.d.a
    public void a(@NonNull Exception exc) {
        this.f35604a.a(this.j, exc, this.f35611h.f35335c, DataSource.RESOURCE_DISK_CACHE);
    }

    @Override // com.kwad.sdk.glide.load.a.d.a
    public void a(Object obj) {
        this.f35604a.a(this.f35608e, obj, this.f35611h.f35335c, DataSource.RESOURCE_DISK_CACHE, this.j);
    }

    @Override // com.kwad.sdk.glide.load.engine.e
    public boolean a() {
        List<com.kwad.sdk.glide.load.c> o = this.f35605b.o();
        boolean z = false;
        if (o.isEmpty()) {
            return false;
        }
        List<Class<?>> l = this.f35605b.l();
        if (l.isEmpty()) {
            if (File.class.equals(this.f35605b.j())) {
                return false;
            }
            throw new IllegalStateException("Failed to find any load path from " + this.f35605b.k() + " to " + this.f35605b.j());
        }
        while (true) {
            if (this.f35609f != null && c()) {
                this.f35611h = null;
                while (!z && c()) {
                    List<com.kwad.sdk.glide.load.b.n<File, ?>> list = this.f35609f;
                    int i = this.f35610g;
                    this.f35610g = i + 1;
                    this.f35611h = list.get(i).a(this.i, this.f35605b.g(), this.f35605b.h(), this.f35605b.e());
                    if (this.f35611h != null && this.f35605b.a(this.f35611h.f35335c.a())) {
                        this.f35611h.f35335c.a(this.f35605b.d(), this);
                        z = true;
                    }
                }
                return z;
            }
            int i2 = this.f35607d + 1;
            this.f35607d = i2;
            if (i2 >= l.size()) {
                int i3 = this.f35606c + 1;
                this.f35606c = i3;
                if (i3 >= o.size()) {
                    return false;
                }
                this.f35607d = 0;
            }
            com.kwad.sdk.glide.load.c cVar = o.get(this.f35606c);
            Class<?> cls = l.get(this.f35607d);
            this.j = new u(this.f35605b.i(), cVar, this.f35605b.f(), this.f35605b.g(), this.f35605b.h(), this.f35605b.c(cls), cls, this.f35605b.e());
            File a2 = this.f35605b.b().a(this.j);
            this.i = a2;
            if (a2 != null) {
                this.f35608e = cVar;
                this.f35609f = this.f35605b.a(a2);
                this.f35610g = 0;
            }
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.e
    public void b() {
        n.a<?> aVar = this.f35611h;
        if (aVar != null) {
            aVar.f35335c.c();
        }
    }
}
