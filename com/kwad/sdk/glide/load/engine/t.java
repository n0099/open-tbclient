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
    public final e.a f36394a;

    /* renamed from: b  reason: collision with root package name */
    public final f<?> f36395b;

    /* renamed from: c  reason: collision with root package name */
    public int f36396c;

    /* renamed from: d  reason: collision with root package name */
    public int f36397d = -1;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.glide.load.c f36398e;

    /* renamed from: f  reason: collision with root package name */
    public List<com.kwad.sdk.glide.load.b.n<File, ?>> f36399f;

    /* renamed from: g  reason: collision with root package name */
    public int f36400g;

    /* renamed from: h  reason: collision with root package name */
    public volatile n.a<?> f36401h;

    /* renamed from: i  reason: collision with root package name */
    public File f36402i;
    public u j;

    public t(f<?> fVar, e.a aVar) {
        this.f36395b = fVar;
        this.f36394a = aVar;
    }

    private boolean c() {
        return this.f36400g < this.f36399f.size();
    }

    @Override // com.kwad.sdk.glide.load.a.d.a
    public void a(@NonNull Exception exc) {
        this.f36394a.a(this.j, exc, this.f36401h.f36117c, DataSource.RESOURCE_DISK_CACHE);
    }

    @Override // com.kwad.sdk.glide.load.a.d.a
    public void a(Object obj) {
        this.f36394a.a(this.f36398e, obj, this.f36401h.f36117c, DataSource.RESOURCE_DISK_CACHE, this.j);
    }

    @Override // com.kwad.sdk.glide.load.engine.e
    public boolean a() {
        List<com.kwad.sdk.glide.load.c> o = this.f36395b.o();
        boolean z = false;
        if (o.isEmpty()) {
            return false;
        }
        List<Class<?>> l = this.f36395b.l();
        if (l.isEmpty()) {
            if (File.class.equals(this.f36395b.j())) {
                return false;
            }
            throw new IllegalStateException("Failed to find any load path from " + this.f36395b.k() + " to " + this.f36395b.j());
        }
        while (true) {
            if (this.f36399f != null && c()) {
                this.f36401h = null;
                while (!z && c()) {
                    List<com.kwad.sdk.glide.load.b.n<File, ?>> list = this.f36399f;
                    int i2 = this.f36400g;
                    this.f36400g = i2 + 1;
                    this.f36401h = list.get(i2).a(this.f36402i, this.f36395b.g(), this.f36395b.h(), this.f36395b.e());
                    if (this.f36401h != null && this.f36395b.a(this.f36401h.f36117c.a())) {
                        this.f36401h.f36117c.a(this.f36395b.d(), this);
                        z = true;
                    }
                }
                return z;
            }
            int i3 = this.f36397d + 1;
            this.f36397d = i3;
            if (i3 >= l.size()) {
                int i4 = this.f36396c + 1;
                this.f36396c = i4;
                if (i4 >= o.size()) {
                    return false;
                }
                this.f36397d = 0;
            }
            com.kwad.sdk.glide.load.c cVar = o.get(this.f36396c);
            Class<?> cls = l.get(this.f36397d);
            this.j = new u(this.f36395b.i(), cVar, this.f36395b.f(), this.f36395b.g(), this.f36395b.h(), this.f36395b.c(cls), cls, this.f36395b.e());
            File a2 = this.f36395b.b().a(this.j);
            this.f36402i = a2;
            if (a2 != null) {
                this.f36398e = cVar;
                this.f36399f = this.f36395b.a(a2);
                this.f36400g = 0;
            }
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.e
    public void b() {
        n.a<?> aVar = this.f36401h;
        if (aVar != null) {
            aVar.f36117c.c();
        }
    }
}
