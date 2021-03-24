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
    public final f<?> f35621a;

    /* renamed from: b  reason: collision with root package name */
    public final e.a f35622b;

    /* renamed from: c  reason: collision with root package name */
    public int f35623c;

    /* renamed from: d  reason: collision with root package name */
    public b f35624d;

    /* renamed from: e  reason: collision with root package name */
    public Object f35625e;

    /* renamed from: f  reason: collision with root package name */
    public volatile n.a<?> f35626f;

    /* renamed from: g  reason: collision with root package name */
    public c f35627g;

    public w(f<?> fVar, e.a aVar) {
        this.f35621a = fVar;
        this.f35622b = aVar;
    }

    private void b(Object obj) {
        long a2 = com.kwad.sdk.glide.g.f.a();
        try {
            com.kwad.sdk.glide.load.a<X> a3 = this.f35621a.a((f<?>) obj);
            d dVar = new d(a3, obj, this.f35621a.e());
            this.f35627g = new c(this.f35626f.f35333a, this.f35621a.f());
            this.f35621a.b().a(this.f35627g, dVar);
            if (Log.isLoggable(SourceGenerator.TAG, 2)) {
                Log.v(SourceGenerator.TAG, "Finished encoding source to cache, key: " + this.f35627g + ", data: " + obj + ", encoder: " + a3 + ", duration: " + com.kwad.sdk.glide.g.f.a(a2));
            }
            this.f35626f.f35335c.b();
            this.f35624d = new b(Collections.singletonList(this.f35626f.f35333a), this.f35621a, this);
        } catch (Throwable th) {
            this.f35626f.f35335c.b();
            throw th;
        }
    }

    private boolean d() {
        return this.f35623c < this.f35621a.n().size();
    }

    @Override // com.kwad.sdk.glide.load.engine.e.a
    public void a(com.kwad.sdk.glide.load.c cVar, Exception exc, com.kwad.sdk.glide.load.a.d<?> dVar, DataSource dataSource) {
        this.f35622b.a(cVar, exc, dVar, this.f35626f.f35335c.d());
    }

    @Override // com.kwad.sdk.glide.load.engine.e.a
    public void a(com.kwad.sdk.glide.load.c cVar, Object obj, com.kwad.sdk.glide.load.a.d<?> dVar, DataSource dataSource, com.kwad.sdk.glide.load.c cVar2) {
        this.f35622b.a(cVar, obj, dVar, this.f35626f.f35335c.d(), cVar);
    }

    @Override // com.kwad.sdk.glide.load.a.d.a
    public void a(@NonNull Exception exc) {
        this.f35622b.a(this.f35627g, exc, this.f35626f.f35335c, this.f35626f.f35335c.d());
    }

    @Override // com.kwad.sdk.glide.load.a.d.a
    public void a(Object obj) {
        h c2 = this.f35621a.c();
        if (obj == null || !c2.a(this.f35626f.f35335c.d())) {
            this.f35622b.a(this.f35626f.f35333a, obj, this.f35626f.f35335c, this.f35626f.f35335c.d(), this.f35627g);
            return;
        }
        this.f35625e = obj;
        this.f35622b.c();
    }

    @Override // com.kwad.sdk.glide.load.engine.e
    public boolean a() {
        Object obj = this.f35625e;
        if (obj != null) {
            this.f35625e = null;
            b(obj);
        }
        b bVar = this.f35624d;
        if (bVar == null || !bVar.a()) {
            this.f35624d = null;
            this.f35626f = null;
            boolean z = false;
            while (!z && d()) {
                List<n.a<?>> n = this.f35621a.n();
                int i = this.f35623c;
                this.f35623c = i + 1;
                this.f35626f = n.get(i);
                if (this.f35626f != null && (this.f35621a.c().a(this.f35626f.f35335c.d()) || this.f35621a.a(this.f35626f.f35335c.a()))) {
                    this.f35626f.f35335c.a(this.f35621a.d(), this);
                    z = true;
                }
            }
            return z;
        }
        return true;
    }

    @Override // com.kwad.sdk.glide.load.engine.e
    public void b() {
        n.a<?> aVar = this.f35626f;
        if (aVar != null) {
            aVar.f35335c.c();
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.e.a
    public void c() {
        throw new UnsupportedOperationException();
    }
}
