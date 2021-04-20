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
    public final e.a f35894a;

    /* renamed from: b  reason: collision with root package name */
    public final f<?> f35895b;

    /* renamed from: c  reason: collision with root package name */
    public int f35896c;

    /* renamed from: d  reason: collision with root package name */
    public int f35897d = -1;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.glide.load.c f35898e;

    /* renamed from: f  reason: collision with root package name */
    public List<com.kwad.sdk.glide.load.b.n<File, ?>> f35899f;

    /* renamed from: g  reason: collision with root package name */
    public int f35900g;

    /* renamed from: h  reason: collision with root package name */
    public volatile n.a<?> f35901h;
    public File i;
    public u j;

    public t(f<?> fVar, e.a aVar) {
        this.f35895b = fVar;
        this.f35894a = aVar;
    }

    private boolean c() {
        return this.f35900g < this.f35899f.size();
    }

    @Override // com.kwad.sdk.glide.load.a.d.a
    public void a(@NonNull Exception exc) {
        this.f35894a.a(this.j, exc, this.f35901h.f35625c, DataSource.RESOURCE_DISK_CACHE);
    }

    @Override // com.kwad.sdk.glide.load.a.d.a
    public void a(Object obj) {
        this.f35894a.a(this.f35898e, obj, this.f35901h.f35625c, DataSource.RESOURCE_DISK_CACHE, this.j);
    }

    @Override // com.kwad.sdk.glide.load.engine.e
    public boolean a() {
        List<com.kwad.sdk.glide.load.c> o = this.f35895b.o();
        boolean z = false;
        if (o.isEmpty()) {
            return false;
        }
        List<Class<?>> l = this.f35895b.l();
        if (l.isEmpty()) {
            if (File.class.equals(this.f35895b.j())) {
                return false;
            }
            throw new IllegalStateException("Failed to find any load path from " + this.f35895b.k() + " to " + this.f35895b.j());
        }
        while (true) {
            if (this.f35899f != null && c()) {
                this.f35901h = null;
                while (!z && c()) {
                    List<com.kwad.sdk.glide.load.b.n<File, ?>> list = this.f35899f;
                    int i = this.f35900g;
                    this.f35900g = i + 1;
                    this.f35901h = list.get(i).a(this.i, this.f35895b.g(), this.f35895b.h(), this.f35895b.e());
                    if (this.f35901h != null && this.f35895b.a(this.f35901h.f35625c.a())) {
                        this.f35901h.f35625c.a(this.f35895b.d(), this);
                        z = true;
                    }
                }
                return z;
            }
            int i2 = this.f35897d + 1;
            this.f35897d = i2;
            if (i2 >= l.size()) {
                int i3 = this.f35896c + 1;
                this.f35896c = i3;
                if (i3 >= o.size()) {
                    return false;
                }
                this.f35897d = 0;
            }
            com.kwad.sdk.glide.load.c cVar = o.get(this.f35896c);
            Class<?> cls = l.get(this.f35897d);
            this.j = new u(this.f35895b.i(), cVar, this.f35895b.f(), this.f35895b.g(), this.f35895b.h(), this.f35895b.c(cls), cls, this.f35895b.e());
            File a2 = this.f35895b.b().a(this.j);
            this.i = a2;
            if (a2 != null) {
                this.f35898e = cVar;
                this.f35899f = this.f35895b.a(a2);
                this.f35900g = 0;
            }
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.e
    public void b() {
        n.a<?> aVar = this.f35901h;
        if (aVar != null) {
            aVar.f35625c.c();
        }
    }
}
