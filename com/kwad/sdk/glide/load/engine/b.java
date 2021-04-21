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
    public final List<com.kwad.sdk.glide.load.c> f35835a;

    /* renamed from: b  reason: collision with root package name */
    public final f<?> f35836b;

    /* renamed from: c  reason: collision with root package name */
    public final e.a f35837c;

    /* renamed from: d  reason: collision with root package name */
    public int f35838d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.glide.load.c f35839e;

    /* renamed from: f  reason: collision with root package name */
    public List<com.kwad.sdk.glide.load.b.n<File, ?>> f35840f;

    /* renamed from: g  reason: collision with root package name */
    public int f35841g;

    /* renamed from: h  reason: collision with root package name */
    public volatile n.a<?> f35842h;
    public File i;

    public b(f<?> fVar, e.a aVar) {
        this(fVar.o(), fVar, aVar);
    }

    public b(List<com.kwad.sdk.glide.load.c> list, f<?> fVar, e.a aVar) {
        this.f35838d = -1;
        this.f35835a = list;
        this.f35836b = fVar;
        this.f35837c = aVar;
    }

    private boolean c() {
        return this.f35841g < this.f35840f.size();
    }

    @Override // com.kwad.sdk.glide.load.a.d.a
    public void a(@NonNull Exception exc) {
        this.f35837c.a(this.f35839e, exc, this.f35842h.f35720c, DataSource.DATA_DISK_CACHE);
    }

    @Override // com.kwad.sdk.glide.load.a.d.a
    public void a(Object obj) {
        this.f35837c.a(this.f35839e, obj, this.f35842h.f35720c, DataSource.DATA_DISK_CACHE, this.f35839e);
    }

    @Override // com.kwad.sdk.glide.load.engine.e
    public boolean a() {
        while (true) {
            boolean z = false;
            if (this.f35840f != null && c()) {
                this.f35842h = null;
                while (!z && c()) {
                    List<com.kwad.sdk.glide.load.b.n<File, ?>> list = this.f35840f;
                    int i = this.f35841g;
                    this.f35841g = i + 1;
                    this.f35842h = list.get(i).a(this.i, this.f35836b.g(), this.f35836b.h(), this.f35836b.e());
                    if (this.f35842h != null && this.f35836b.a(this.f35842h.f35720c.a())) {
                        this.f35842h.f35720c.a(this.f35836b.d(), this);
                        z = true;
                    }
                }
                return z;
            }
            int i2 = this.f35838d + 1;
            this.f35838d = i2;
            if (i2 >= this.f35835a.size()) {
                return false;
            }
            com.kwad.sdk.glide.load.c cVar = this.f35835a.get(this.f35838d);
            File a2 = this.f35836b.b().a(new c(cVar, this.f35836b.f()));
            this.i = a2;
            if (a2 != null) {
                this.f35839e = cVar;
                this.f35840f = this.f35836b.a(a2);
                this.f35841g = 0;
            }
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.e
    public void b() {
        n.a<?> aVar = this.f35842h;
        if (aVar != null) {
            aVar.f35720c.c();
        }
    }
}
