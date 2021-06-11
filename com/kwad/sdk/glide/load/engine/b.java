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
    public final List<com.kwad.sdk.glide.load.c> f36136a;

    /* renamed from: b  reason: collision with root package name */
    public final f<?> f36137b;

    /* renamed from: c  reason: collision with root package name */
    public final e.a f36138c;

    /* renamed from: d  reason: collision with root package name */
    public int f36139d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.glide.load.c f36140e;

    /* renamed from: f  reason: collision with root package name */
    public List<com.kwad.sdk.glide.load.b.n<File, ?>> f36141f;

    /* renamed from: g  reason: collision with root package name */
    public int f36142g;

    /* renamed from: h  reason: collision with root package name */
    public volatile n.a<?> f36143h;

    /* renamed from: i  reason: collision with root package name */
    public File f36144i;

    public b(f<?> fVar, e.a aVar) {
        this(fVar.o(), fVar, aVar);
    }

    public b(List<com.kwad.sdk.glide.load.c> list, f<?> fVar, e.a aVar) {
        this.f36139d = -1;
        this.f36136a = list;
        this.f36137b = fVar;
        this.f36138c = aVar;
    }

    private boolean c() {
        return this.f36142g < this.f36141f.size();
    }

    @Override // com.kwad.sdk.glide.load.a.d.a
    public void a(@NonNull Exception exc) {
        this.f36138c.a(this.f36140e, exc, this.f36143h.f36019c, DataSource.DATA_DISK_CACHE);
    }

    @Override // com.kwad.sdk.glide.load.a.d.a
    public void a(Object obj) {
        this.f36138c.a(this.f36140e, obj, this.f36143h.f36019c, DataSource.DATA_DISK_CACHE, this.f36140e);
    }

    @Override // com.kwad.sdk.glide.load.engine.e
    public boolean a() {
        while (true) {
            boolean z = false;
            if (this.f36141f != null && c()) {
                this.f36143h = null;
                while (!z && c()) {
                    List<com.kwad.sdk.glide.load.b.n<File, ?>> list = this.f36141f;
                    int i2 = this.f36142g;
                    this.f36142g = i2 + 1;
                    this.f36143h = list.get(i2).a(this.f36144i, this.f36137b.g(), this.f36137b.h(), this.f36137b.e());
                    if (this.f36143h != null && this.f36137b.a(this.f36143h.f36019c.a())) {
                        this.f36143h.f36019c.a(this.f36137b.d(), this);
                        z = true;
                    }
                }
                return z;
            }
            int i3 = this.f36139d + 1;
            this.f36139d = i3;
            if (i3 >= this.f36136a.size()) {
                return false;
            }
            com.kwad.sdk.glide.load.c cVar = this.f36136a.get(this.f36139d);
            File a2 = this.f36137b.b().a(new c(cVar, this.f36137b.f()));
            this.f36144i = a2;
            if (a2 != null) {
                this.f36140e = cVar;
                this.f36141f = this.f36137b.a(a2);
                this.f36142g = 0;
            }
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.e
    public void b() {
        n.a<?> aVar = this.f36143h;
        if (aVar != null) {
            aVar.f36019c.c();
        }
    }
}
