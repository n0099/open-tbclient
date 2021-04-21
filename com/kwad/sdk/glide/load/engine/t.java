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
    public final e.a f35989a;

    /* renamed from: b  reason: collision with root package name */
    public final f<?> f35990b;

    /* renamed from: c  reason: collision with root package name */
    public int f35991c;

    /* renamed from: d  reason: collision with root package name */
    public int f35992d = -1;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.glide.load.c f35993e;

    /* renamed from: f  reason: collision with root package name */
    public List<com.kwad.sdk.glide.load.b.n<File, ?>> f35994f;

    /* renamed from: g  reason: collision with root package name */
    public int f35995g;

    /* renamed from: h  reason: collision with root package name */
    public volatile n.a<?> f35996h;
    public File i;
    public u j;

    public t(f<?> fVar, e.a aVar) {
        this.f35990b = fVar;
        this.f35989a = aVar;
    }

    private boolean c() {
        return this.f35995g < this.f35994f.size();
    }

    @Override // com.kwad.sdk.glide.load.a.d.a
    public void a(@NonNull Exception exc) {
        this.f35989a.a(this.j, exc, this.f35996h.f35720c, DataSource.RESOURCE_DISK_CACHE);
    }

    @Override // com.kwad.sdk.glide.load.a.d.a
    public void a(Object obj) {
        this.f35989a.a(this.f35993e, obj, this.f35996h.f35720c, DataSource.RESOURCE_DISK_CACHE, this.j);
    }

    @Override // com.kwad.sdk.glide.load.engine.e
    public boolean a() {
        List<com.kwad.sdk.glide.load.c> o = this.f35990b.o();
        boolean z = false;
        if (o.isEmpty()) {
            return false;
        }
        List<Class<?>> l = this.f35990b.l();
        if (l.isEmpty()) {
            if (File.class.equals(this.f35990b.j())) {
                return false;
            }
            throw new IllegalStateException("Failed to find any load path from " + this.f35990b.k() + " to " + this.f35990b.j());
        }
        while (true) {
            if (this.f35994f != null && c()) {
                this.f35996h = null;
                while (!z && c()) {
                    List<com.kwad.sdk.glide.load.b.n<File, ?>> list = this.f35994f;
                    int i = this.f35995g;
                    this.f35995g = i + 1;
                    this.f35996h = list.get(i).a(this.i, this.f35990b.g(), this.f35990b.h(), this.f35990b.e());
                    if (this.f35996h != null && this.f35990b.a(this.f35996h.f35720c.a())) {
                        this.f35996h.f35720c.a(this.f35990b.d(), this);
                        z = true;
                    }
                }
                return z;
            }
            int i2 = this.f35992d + 1;
            this.f35992d = i2;
            if (i2 >= l.size()) {
                int i3 = this.f35991c + 1;
                this.f35991c = i3;
                if (i3 >= o.size()) {
                    return false;
                }
                this.f35992d = 0;
            }
            com.kwad.sdk.glide.load.c cVar = o.get(this.f35991c);
            Class<?> cls = l.get(this.f35992d);
            this.j = new u(this.f35990b.i(), cVar, this.f35990b.f(), this.f35990b.g(), this.f35990b.h(), this.f35990b.c(cls), cls, this.f35990b.e());
            File a2 = this.f35990b.b().a(this.j);
            this.i = a2;
            if (a2 != null) {
                this.f35993e = cVar;
                this.f35994f = this.f35990b.a(a2);
                this.f35995g = 0;
            }
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.e
    public void b() {
        n.a<?> aVar = this.f35996h;
        if (aVar != null) {
            aVar.f35720c.c();
        }
    }
}
