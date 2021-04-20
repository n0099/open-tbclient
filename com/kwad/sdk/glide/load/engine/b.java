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
    public final List<com.kwad.sdk.glide.load.c> f35740a;

    /* renamed from: b  reason: collision with root package name */
    public final f<?> f35741b;

    /* renamed from: c  reason: collision with root package name */
    public final e.a f35742c;

    /* renamed from: d  reason: collision with root package name */
    public int f35743d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.glide.load.c f35744e;

    /* renamed from: f  reason: collision with root package name */
    public List<com.kwad.sdk.glide.load.b.n<File, ?>> f35745f;

    /* renamed from: g  reason: collision with root package name */
    public int f35746g;

    /* renamed from: h  reason: collision with root package name */
    public volatile n.a<?> f35747h;
    public File i;

    public b(f<?> fVar, e.a aVar) {
        this(fVar.o(), fVar, aVar);
    }

    public b(List<com.kwad.sdk.glide.load.c> list, f<?> fVar, e.a aVar) {
        this.f35743d = -1;
        this.f35740a = list;
        this.f35741b = fVar;
        this.f35742c = aVar;
    }

    private boolean c() {
        return this.f35746g < this.f35745f.size();
    }

    @Override // com.kwad.sdk.glide.load.a.d.a
    public void a(@NonNull Exception exc) {
        this.f35742c.a(this.f35744e, exc, this.f35747h.f35625c, DataSource.DATA_DISK_CACHE);
    }

    @Override // com.kwad.sdk.glide.load.a.d.a
    public void a(Object obj) {
        this.f35742c.a(this.f35744e, obj, this.f35747h.f35625c, DataSource.DATA_DISK_CACHE, this.f35744e);
    }

    @Override // com.kwad.sdk.glide.load.engine.e
    public boolean a() {
        while (true) {
            boolean z = false;
            if (this.f35745f != null && c()) {
                this.f35747h = null;
                while (!z && c()) {
                    List<com.kwad.sdk.glide.load.b.n<File, ?>> list = this.f35745f;
                    int i = this.f35746g;
                    this.f35746g = i + 1;
                    this.f35747h = list.get(i).a(this.i, this.f35741b.g(), this.f35741b.h(), this.f35741b.e());
                    if (this.f35747h != null && this.f35741b.a(this.f35747h.f35625c.a())) {
                        this.f35747h.f35625c.a(this.f35741b.d(), this);
                        z = true;
                    }
                }
                return z;
            }
            int i2 = this.f35743d + 1;
            this.f35743d = i2;
            if (i2 >= this.f35740a.size()) {
                return false;
            }
            com.kwad.sdk.glide.load.c cVar = this.f35740a.get(this.f35743d);
            File a2 = this.f35741b.b().a(new c(cVar, this.f35741b.f()));
            this.i = a2;
            if (a2 != null) {
                this.f35744e = cVar;
                this.f35745f = this.f35741b.a(a2);
                this.f35746g = 0;
            }
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.e
    public void b() {
        n.a<?> aVar = this.f35747h;
        if (aVar != null) {
            aVar.f35625c.c();
        }
    }
}
