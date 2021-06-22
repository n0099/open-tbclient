package com.kwad.sdk.glide.load.engine;

import androidx.annotation.NonNull;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.a.d;
import com.kwad.sdk.glide.load.b.n;
import com.kwad.sdk.glide.load.engine.e;
import java.io.File;
import java.util.List;
/* loaded from: classes7.dex */
public class b implements d.a<Object>, e {

    /* renamed from: a  reason: collision with root package name */
    public final List<com.kwad.sdk.glide.load.c> f36234a;

    /* renamed from: b  reason: collision with root package name */
    public final f<?> f36235b;

    /* renamed from: c  reason: collision with root package name */
    public final e.a f36236c;

    /* renamed from: d  reason: collision with root package name */
    public int f36237d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.glide.load.c f36238e;

    /* renamed from: f  reason: collision with root package name */
    public List<com.kwad.sdk.glide.load.b.n<File, ?>> f36239f;

    /* renamed from: g  reason: collision with root package name */
    public int f36240g;

    /* renamed from: h  reason: collision with root package name */
    public volatile n.a<?> f36241h;

    /* renamed from: i  reason: collision with root package name */
    public File f36242i;

    public b(f<?> fVar, e.a aVar) {
        this(fVar.o(), fVar, aVar);
    }

    public b(List<com.kwad.sdk.glide.load.c> list, f<?> fVar, e.a aVar) {
        this.f36237d = -1;
        this.f36234a = list;
        this.f36235b = fVar;
        this.f36236c = aVar;
    }

    private boolean c() {
        return this.f36240g < this.f36239f.size();
    }

    @Override // com.kwad.sdk.glide.load.a.d.a
    public void a(@NonNull Exception exc) {
        this.f36236c.a(this.f36238e, exc, this.f36241h.f36117c, DataSource.DATA_DISK_CACHE);
    }

    @Override // com.kwad.sdk.glide.load.a.d.a
    public void a(Object obj) {
        this.f36236c.a(this.f36238e, obj, this.f36241h.f36117c, DataSource.DATA_DISK_CACHE, this.f36238e);
    }

    @Override // com.kwad.sdk.glide.load.engine.e
    public boolean a() {
        while (true) {
            boolean z = false;
            if (this.f36239f != null && c()) {
                this.f36241h = null;
                while (!z && c()) {
                    List<com.kwad.sdk.glide.load.b.n<File, ?>> list = this.f36239f;
                    int i2 = this.f36240g;
                    this.f36240g = i2 + 1;
                    this.f36241h = list.get(i2).a(this.f36242i, this.f36235b.g(), this.f36235b.h(), this.f36235b.e());
                    if (this.f36241h != null && this.f36235b.a(this.f36241h.f36117c.a())) {
                        this.f36241h.f36117c.a(this.f36235b.d(), this);
                        z = true;
                    }
                }
                return z;
            }
            int i3 = this.f36237d + 1;
            this.f36237d = i3;
            if (i3 >= this.f36234a.size()) {
                return false;
            }
            com.kwad.sdk.glide.load.c cVar = this.f36234a.get(this.f36237d);
            File a2 = this.f36235b.b().a(new c(cVar, this.f36235b.f()));
            this.f36242i = a2;
            if (a2 != null) {
                this.f36238e = cVar;
                this.f36239f = this.f36235b.a(a2);
                this.f36240g = 0;
            }
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.e
    public void b() {
        n.a<?> aVar = this.f36241h;
        if (aVar != null) {
            aVar.f36117c.c();
        }
    }
}
