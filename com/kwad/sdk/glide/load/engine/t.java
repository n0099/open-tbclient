package com.kwad.sdk.glide.load.engine;

import androidx.annotation.NonNull;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.a.d;
import com.kwad.sdk.glide.load.b.n;
import com.kwad.sdk.glide.load.engine.e;
import java.io.File;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class t implements d.a<Object>, e {

    /* renamed from: a  reason: collision with root package name */
    private final e.a f10548a;

    /* renamed from: b  reason: collision with root package name */
    private final f<?> f10549b;
    private int c;
    private int d = -1;
    private com.kwad.sdk.glide.load.c e;
    private List<com.kwad.sdk.glide.load.b.n<File, ?>> f;
    private int g;
    private volatile n.a<?> h;
    private File i;
    private u j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(f<?> fVar, e.a aVar) {
        this.f10549b = fVar;
        this.f10548a = aVar;
    }

    private boolean c() {
        return this.g < this.f.size();
    }

    @Override // com.kwad.sdk.glide.load.a.d.a
    public void a(@NonNull Exception exc) {
        this.f10548a.a(this.j, exc, this.h.c, DataSource.RESOURCE_DISK_CACHE);
    }

    @Override // com.kwad.sdk.glide.load.a.d.a
    public void a(Object obj) {
        this.f10548a.a(this.e, obj, this.h.c, DataSource.RESOURCE_DISK_CACHE, this.j);
    }

    @Override // com.kwad.sdk.glide.load.engine.e
    public boolean a() {
        boolean z;
        List<com.kwad.sdk.glide.load.c> o = this.f10549b.o();
        if (o.isEmpty()) {
            return false;
        }
        List<Class<?>> l = this.f10549b.l();
        if (l.isEmpty()) {
            if (File.class.equals(this.f10549b.j())) {
                return false;
            }
            throw new IllegalStateException("Failed to find any load path from " + this.f10549b.k() + " to " + this.f10549b.j());
        }
        while (true) {
            if (this.f != null && c()) {
                this.h = null;
                boolean z2 = false;
                while (!z2 && c()) {
                    List<com.kwad.sdk.glide.load.b.n<File, ?>> list = this.f;
                    int i = this.g;
                    this.g = i + 1;
                    this.h = list.get(i).a(this.i, this.f10549b.g(), this.f10549b.h(), this.f10549b.e());
                    if (this.h == null || !this.f10549b.a(this.h.c.a())) {
                        z = z2;
                    } else {
                        z = true;
                        this.h.c.a(this.f10549b.d(), this);
                    }
                    z2 = z;
                }
                return z2;
            }
            this.d++;
            if (this.d >= l.size()) {
                this.c++;
                if (this.c >= o.size()) {
                    return false;
                }
                this.d = 0;
            }
            com.kwad.sdk.glide.load.c cVar = o.get(this.c);
            Class<?> cls = l.get(this.d);
            this.j = new u(this.f10549b.i(), cVar, this.f10549b.f(), this.f10549b.g(), this.f10549b.h(), this.f10549b.c(cls), cls, this.f10549b.e());
            this.i = this.f10549b.b().a(this.j);
            if (this.i != null) {
                this.e = cVar;
                this.f = this.f10549b.a(this.i);
                this.g = 0;
            }
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.e
    public void b() {
        n.a<?> aVar = this.h;
        if (aVar != null) {
            aVar.c.c();
        }
    }
}
