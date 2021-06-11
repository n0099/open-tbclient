package com.kwad.sdk.glide.load.engine;

import androidx.annotation.NonNull;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.a.d;
import com.kwad.sdk.glide.load.b.n;
import com.kwad.sdk.glide.load.engine.e;
import java.io.File;
import java.util.List;
/* loaded from: classes7.dex */
public class t implements d.a<Object>, e {

    /* renamed from: a  reason: collision with root package name */
    public final e.a f36296a;

    /* renamed from: b  reason: collision with root package name */
    public final f<?> f36297b;

    /* renamed from: c  reason: collision with root package name */
    public int f36298c;

    /* renamed from: d  reason: collision with root package name */
    public int f36299d = -1;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.glide.load.c f36300e;

    /* renamed from: f  reason: collision with root package name */
    public List<com.kwad.sdk.glide.load.b.n<File, ?>> f36301f;

    /* renamed from: g  reason: collision with root package name */
    public int f36302g;

    /* renamed from: h  reason: collision with root package name */
    public volatile n.a<?> f36303h;

    /* renamed from: i  reason: collision with root package name */
    public File f36304i;
    public u j;

    public t(f<?> fVar, e.a aVar) {
        this.f36297b = fVar;
        this.f36296a = aVar;
    }

    private boolean c() {
        return this.f36302g < this.f36301f.size();
    }

    @Override // com.kwad.sdk.glide.load.a.d.a
    public void a(@NonNull Exception exc) {
        this.f36296a.a(this.j, exc, this.f36303h.f36019c, DataSource.RESOURCE_DISK_CACHE);
    }

    @Override // com.kwad.sdk.glide.load.a.d.a
    public void a(Object obj) {
        this.f36296a.a(this.f36300e, obj, this.f36303h.f36019c, DataSource.RESOURCE_DISK_CACHE, this.j);
    }

    @Override // com.kwad.sdk.glide.load.engine.e
    public boolean a() {
        List<com.kwad.sdk.glide.load.c> o = this.f36297b.o();
        boolean z = false;
        if (o.isEmpty()) {
            return false;
        }
        List<Class<?>> l = this.f36297b.l();
        if (l.isEmpty()) {
            if (File.class.equals(this.f36297b.j())) {
                return false;
            }
            throw new IllegalStateException("Failed to find any load path from " + this.f36297b.k() + " to " + this.f36297b.j());
        }
        while (true) {
            if (this.f36301f != null && c()) {
                this.f36303h = null;
                while (!z && c()) {
                    List<com.kwad.sdk.glide.load.b.n<File, ?>> list = this.f36301f;
                    int i2 = this.f36302g;
                    this.f36302g = i2 + 1;
                    this.f36303h = list.get(i2).a(this.f36304i, this.f36297b.g(), this.f36297b.h(), this.f36297b.e());
                    if (this.f36303h != null && this.f36297b.a(this.f36303h.f36019c.a())) {
                        this.f36303h.f36019c.a(this.f36297b.d(), this);
                        z = true;
                    }
                }
                return z;
            }
            int i3 = this.f36299d + 1;
            this.f36299d = i3;
            if (i3 >= l.size()) {
                int i4 = this.f36298c + 1;
                this.f36298c = i4;
                if (i4 >= o.size()) {
                    return false;
                }
                this.f36299d = 0;
            }
            com.kwad.sdk.glide.load.c cVar = o.get(this.f36298c);
            Class<?> cls = l.get(this.f36299d);
            this.j = new u(this.f36297b.i(), cVar, this.f36297b.f(), this.f36297b.g(), this.f36297b.h(), this.f36297b.c(cls), cls, this.f36297b.e());
            File a2 = this.f36297b.b().a(this.j);
            this.f36304i = a2;
            if (a2 != null) {
                this.f36300e = cVar;
                this.f36301f = this.f36297b.a(a2);
                this.f36302g = 0;
            }
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.e
    public void b() {
        n.a<?> aVar = this.f36303h;
        if (aVar != null) {
            aVar.f36019c.c();
        }
    }
}
