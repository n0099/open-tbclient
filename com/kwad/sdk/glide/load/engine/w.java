package com.kwad.sdk.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.SourceGenerator;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.a.d;
import com.kwad.sdk.glide.load.b.n;
import com.kwad.sdk.glide.load.engine.e;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public class w implements d.a<Object>, e, e.a {

    /* renamed from: a  reason: collision with root package name */
    public final f<?> f35911a;

    /* renamed from: b  reason: collision with root package name */
    public final e.a f35912b;

    /* renamed from: c  reason: collision with root package name */
    public int f35913c;

    /* renamed from: d  reason: collision with root package name */
    public b f35914d;

    /* renamed from: e  reason: collision with root package name */
    public Object f35915e;

    /* renamed from: f  reason: collision with root package name */
    public volatile n.a<?> f35916f;

    /* renamed from: g  reason: collision with root package name */
    public c f35917g;

    public w(f<?> fVar, e.a aVar) {
        this.f35911a = fVar;
        this.f35912b = aVar;
    }

    private void b(Object obj) {
        long a2 = com.kwad.sdk.glide.g.f.a();
        try {
            com.kwad.sdk.glide.load.a<X> a3 = this.f35911a.a((f<?>) obj);
            d dVar = new d(a3, obj, this.f35911a.e());
            this.f35917g = new c(this.f35916f.f35623a, this.f35911a.f());
            this.f35911a.b().a(this.f35917g, dVar);
            if (Log.isLoggable(SourceGenerator.TAG, 2)) {
                Log.v(SourceGenerator.TAG, "Finished encoding source to cache, key: " + this.f35917g + ", data: " + obj + ", encoder: " + a3 + ", duration: " + com.kwad.sdk.glide.g.f.a(a2));
            }
            this.f35916f.f35625c.b();
            this.f35914d = new b(Collections.singletonList(this.f35916f.f35623a), this.f35911a, this);
        } catch (Throwable th) {
            this.f35916f.f35625c.b();
            throw th;
        }
    }

    private boolean d() {
        return this.f35913c < this.f35911a.n().size();
    }

    @Override // com.kwad.sdk.glide.load.engine.e.a
    public void a(com.kwad.sdk.glide.load.c cVar, Exception exc, com.kwad.sdk.glide.load.a.d<?> dVar, DataSource dataSource) {
        this.f35912b.a(cVar, exc, dVar, this.f35916f.f35625c.d());
    }

    @Override // com.kwad.sdk.glide.load.engine.e.a
    public void a(com.kwad.sdk.glide.load.c cVar, Object obj, com.kwad.sdk.glide.load.a.d<?> dVar, DataSource dataSource, com.kwad.sdk.glide.load.c cVar2) {
        this.f35912b.a(cVar, obj, dVar, this.f35916f.f35625c.d(), cVar);
    }

    @Override // com.kwad.sdk.glide.load.a.d.a
    public void a(@NonNull Exception exc) {
        this.f35912b.a(this.f35917g, exc, this.f35916f.f35625c, this.f35916f.f35625c.d());
    }

    @Override // com.kwad.sdk.glide.load.a.d.a
    public void a(Object obj) {
        h c2 = this.f35911a.c();
        if (obj == null || !c2.a(this.f35916f.f35625c.d())) {
            this.f35912b.a(this.f35916f.f35623a, obj, this.f35916f.f35625c, this.f35916f.f35625c.d(), this.f35917g);
            return;
        }
        this.f35915e = obj;
        this.f35912b.c();
    }

    @Override // com.kwad.sdk.glide.load.engine.e
    public boolean a() {
        Object obj = this.f35915e;
        if (obj != null) {
            this.f35915e = null;
            b(obj);
        }
        b bVar = this.f35914d;
        if (bVar == null || !bVar.a()) {
            this.f35914d = null;
            this.f35916f = null;
            boolean z = false;
            while (!z && d()) {
                List<n.a<?>> n = this.f35911a.n();
                int i = this.f35913c;
                this.f35913c = i + 1;
                this.f35916f = n.get(i);
                if (this.f35916f != null && (this.f35911a.c().a(this.f35916f.f35625c.d()) || this.f35911a.a(this.f35916f.f35625c.a()))) {
                    this.f35916f.f35625c.a(this.f35911a.d(), this);
                    z = true;
                }
            }
            return z;
        }
        return true;
    }

    @Override // com.kwad.sdk.glide.load.engine.e
    public void b() {
        n.a<?> aVar = this.f35916f;
        if (aVar != null) {
            aVar.f35625c.c();
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.e.a
    public void c() {
        throw new UnsupportedOperationException();
    }
}
