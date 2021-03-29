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
    public final List<com.kwad.sdk.glide.load.c> f35451a;

    /* renamed from: b  reason: collision with root package name */
    public final f<?> f35452b;

    /* renamed from: c  reason: collision with root package name */
    public final e.a f35453c;

    /* renamed from: d  reason: collision with root package name */
    public int f35454d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.glide.load.c f35455e;

    /* renamed from: f  reason: collision with root package name */
    public List<com.kwad.sdk.glide.load.b.n<File, ?>> f35456f;

    /* renamed from: g  reason: collision with root package name */
    public int f35457g;

    /* renamed from: h  reason: collision with root package name */
    public volatile n.a<?> f35458h;
    public File i;

    public b(f<?> fVar, e.a aVar) {
        this(fVar.o(), fVar, aVar);
    }

    public b(List<com.kwad.sdk.glide.load.c> list, f<?> fVar, e.a aVar) {
        this.f35454d = -1;
        this.f35451a = list;
        this.f35452b = fVar;
        this.f35453c = aVar;
    }

    private boolean c() {
        return this.f35457g < this.f35456f.size();
    }

    @Override // com.kwad.sdk.glide.load.a.d.a
    public void a(@NonNull Exception exc) {
        this.f35453c.a(this.f35455e, exc, this.f35458h.f35336c, DataSource.DATA_DISK_CACHE);
    }

    @Override // com.kwad.sdk.glide.load.a.d.a
    public void a(Object obj) {
        this.f35453c.a(this.f35455e, obj, this.f35458h.f35336c, DataSource.DATA_DISK_CACHE, this.f35455e);
    }

    @Override // com.kwad.sdk.glide.load.engine.e
    public boolean a() {
        while (true) {
            boolean z = false;
            if (this.f35456f != null && c()) {
                this.f35458h = null;
                while (!z && c()) {
                    List<com.kwad.sdk.glide.load.b.n<File, ?>> list = this.f35456f;
                    int i = this.f35457g;
                    this.f35457g = i + 1;
                    this.f35458h = list.get(i).a(this.i, this.f35452b.g(), this.f35452b.h(), this.f35452b.e());
                    if (this.f35458h != null && this.f35452b.a(this.f35458h.f35336c.a())) {
                        this.f35458h.f35336c.a(this.f35452b.d(), this);
                        z = true;
                    }
                }
                return z;
            }
            int i2 = this.f35454d + 1;
            this.f35454d = i2;
            if (i2 >= this.f35451a.size()) {
                return false;
            }
            com.kwad.sdk.glide.load.c cVar = this.f35451a.get(this.f35454d);
            File a2 = this.f35452b.b().a(new c(cVar, this.f35452b.f()));
            this.i = a2;
            if (a2 != null) {
                this.f35455e = cVar;
                this.f35456f = this.f35452b.a(a2);
                this.f35457g = 0;
            }
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.e
    public void b() {
        n.a<?> aVar = this.f35458h;
        if (aVar != null) {
            aVar.f35336c.c();
        }
    }
}
