package com.kwad.sdk.glide.load.engine;

import androidx.annotation.NonNull;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.a.d;
import com.kwad.sdk.glide.load.b.n;
import com.kwad.sdk.glide.load.engine.e;
import java.io.File;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class b implements d.a<Object>, e {

    /* renamed from: a  reason: collision with root package name */
    private final List<com.kwad.sdk.glide.load.c> f10179a;

    /* renamed from: b  reason: collision with root package name */
    private final f<?> f10180b;
    private final e.a c;
    private int d;
    private com.kwad.sdk.glide.load.c e;
    private List<com.kwad.sdk.glide.load.b.n<File, ?>> f;
    private int g;
    private volatile n.a<?> h;
    private File i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(f<?> fVar, e.a aVar) {
        this(fVar.o(), fVar, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(List<com.kwad.sdk.glide.load.c> list, f<?> fVar, e.a aVar) {
        this.d = -1;
        this.f10179a = list;
        this.f10180b = fVar;
        this.c = aVar;
    }

    private boolean c() {
        return this.g < this.f.size();
    }

    @Override // com.kwad.sdk.glide.load.a.d.a
    public void a(@NonNull Exception exc) {
        this.c.a(this.e, exc, this.h.c, DataSource.DATA_DISK_CACHE);
    }

    @Override // com.kwad.sdk.glide.load.a.d.a
    public void a(Object obj) {
        this.c.a(this.e, obj, this.h.c, DataSource.DATA_DISK_CACHE, this.e);
    }

    @Override // com.kwad.sdk.glide.load.engine.e
    public boolean a() {
        boolean z;
        boolean z2 = false;
        while (true) {
            if (this.f == null || !c()) {
                this.d++;
                if (this.d >= this.f10179a.size()) {
                    break;
                }
                com.kwad.sdk.glide.load.c cVar = this.f10179a.get(this.d);
                this.i = this.f10180b.b().a(new c(cVar, this.f10180b.f()));
                if (this.i != null) {
                    this.e = cVar;
                    this.f = this.f10180b.a(this.i);
                    this.g = 0;
                }
            } else {
                this.h = null;
                while (!z2 && c()) {
                    List<com.kwad.sdk.glide.load.b.n<File, ?>> list = this.f;
                    int i = this.g;
                    this.g = i + 1;
                    this.h = list.get(i).a(this.i, this.f10180b.g(), this.f10180b.h(), this.f10180b.e());
                    if (this.h == null || !this.f10180b.a(this.h.c.a())) {
                        z = z2;
                    } else {
                        z = true;
                        this.h.c.a(this.f10180b.d(), this);
                    }
                    z2 = z;
                }
            }
        }
        return z2;
    }

    @Override // com.kwad.sdk.glide.load.engine.e
    public void b() {
        n.a<?> aVar = this.h;
        if (aVar != null) {
            aVar.c.c();
        }
    }
}
