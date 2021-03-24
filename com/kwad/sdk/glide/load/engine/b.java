package com.kwad.sdk.glide.load.engine;

import androidx.annotation.NonNull;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.a.d;
import com.kwad.sdk.glide.load.b.n;
import com.kwad.sdk.glide.load.engine.e;
import java.io.File;
import java.util.List;
/* loaded from: classes6.dex */
public class b implements d.a<Object>, e {

    /* renamed from: a  reason: collision with root package name */
    public final List<com.kwad.sdk.glide.load.c> f35450a;

    /* renamed from: b  reason: collision with root package name */
    public final f<?> f35451b;

    /* renamed from: c  reason: collision with root package name */
    public final e.a f35452c;

    /* renamed from: d  reason: collision with root package name */
    public int f35453d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.glide.load.c f35454e;

    /* renamed from: f  reason: collision with root package name */
    public List<com.kwad.sdk.glide.load.b.n<File, ?>> f35455f;

    /* renamed from: g  reason: collision with root package name */
    public int f35456g;

    /* renamed from: h  reason: collision with root package name */
    public volatile n.a<?> f35457h;
    public File i;

    public b(f<?> fVar, e.a aVar) {
        this(fVar.o(), fVar, aVar);
    }

    public b(List<com.kwad.sdk.glide.load.c> list, f<?> fVar, e.a aVar) {
        this.f35453d = -1;
        this.f35450a = list;
        this.f35451b = fVar;
        this.f35452c = aVar;
    }

    private boolean c() {
        return this.f35456g < this.f35455f.size();
    }

    @Override // com.kwad.sdk.glide.load.a.d.a
    public void a(@NonNull Exception exc) {
        this.f35452c.a(this.f35454e, exc, this.f35457h.f35335c, DataSource.DATA_DISK_CACHE);
    }

    @Override // com.kwad.sdk.glide.load.a.d.a
    public void a(Object obj) {
        this.f35452c.a(this.f35454e, obj, this.f35457h.f35335c, DataSource.DATA_DISK_CACHE, this.f35454e);
    }

    @Override // com.kwad.sdk.glide.load.engine.e
    public boolean a() {
        while (true) {
            boolean z = false;
            if (this.f35455f != null && c()) {
                this.f35457h = null;
                while (!z && c()) {
                    List<com.kwad.sdk.glide.load.b.n<File, ?>> list = this.f35455f;
                    int i = this.f35456g;
                    this.f35456g = i + 1;
                    this.f35457h = list.get(i).a(this.i, this.f35451b.g(), this.f35451b.h(), this.f35451b.e());
                    if (this.f35457h != null && this.f35451b.a(this.f35457h.f35335c.a())) {
                        this.f35457h.f35335c.a(this.f35451b.d(), this);
                        z = true;
                    }
                }
                return z;
            }
            int i2 = this.f35453d + 1;
            this.f35453d = i2;
            if (i2 >= this.f35450a.size()) {
                return false;
            }
            com.kwad.sdk.glide.load.c cVar = this.f35450a.get(this.f35453d);
            File a2 = this.f35451b.b().a(new c(cVar, this.f35451b.f()));
            this.i = a2;
            if (a2 != null) {
                this.f35454e = cVar;
                this.f35455f = this.f35451b.a(a2);
                this.f35456g = 0;
            }
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.e
    public void b() {
        n.a<?> aVar = this.f35457h;
        if (aVar != null) {
            aVar.f35335c.c();
        }
    }
}
