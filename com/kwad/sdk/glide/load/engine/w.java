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
    public final f<?> f35622a;

    /* renamed from: b  reason: collision with root package name */
    public final e.a f35623b;

    /* renamed from: c  reason: collision with root package name */
    public int f35624c;

    /* renamed from: d  reason: collision with root package name */
    public b f35625d;

    /* renamed from: e  reason: collision with root package name */
    public Object f35626e;

    /* renamed from: f  reason: collision with root package name */
    public volatile n.a<?> f35627f;

    /* renamed from: g  reason: collision with root package name */
    public c f35628g;

    public w(f<?> fVar, e.a aVar) {
        this.f35622a = fVar;
        this.f35623b = aVar;
    }

    private void b(Object obj) {
        long a2 = com.kwad.sdk.glide.g.f.a();
        try {
            com.kwad.sdk.glide.load.a<X> a3 = this.f35622a.a((f<?>) obj);
            d dVar = new d(a3, obj, this.f35622a.e());
            this.f35628g = new c(this.f35627f.f35334a, this.f35622a.f());
            this.f35622a.b().a(this.f35628g, dVar);
            if (Log.isLoggable(SourceGenerator.TAG, 2)) {
                Log.v(SourceGenerator.TAG, "Finished encoding source to cache, key: " + this.f35628g + ", data: " + obj + ", encoder: " + a3 + ", duration: " + com.kwad.sdk.glide.g.f.a(a2));
            }
            this.f35627f.f35336c.b();
            this.f35625d = new b(Collections.singletonList(this.f35627f.f35334a), this.f35622a, this);
        } catch (Throwable th) {
            this.f35627f.f35336c.b();
            throw th;
        }
    }

    private boolean d() {
        return this.f35624c < this.f35622a.n().size();
    }

    @Override // com.kwad.sdk.glide.load.engine.e.a
    public void a(com.kwad.sdk.glide.load.c cVar, Exception exc, com.kwad.sdk.glide.load.a.d<?> dVar, DataSource dataSource) {
        this.f35623b.a(cVar, exc, dVar, this.f35627f.f35336c.d());
    }

    @Override // com.kwad.sdk.glide.load.engine.e.a
    public void a(com.kwad.sdk.glide.load.c cVar, Object obj, com.kwad.sdk.glide.load.a.d<?> dVar, DataSource dataSource, com.kwad.sdk.glide.load.c cVar2) {
        this.f35623b.a(cVar, obj, dVar, this.f35627f.f35336c.d(), cVar);
    }

    @Override // com.kwad.sdk.glide.load.a.d.a
    public void a(@NonNull Exception exc) {
        this.f35623b.a(this.f35628g, exc, this.f35627f.f35336c, this.f35627f.f35336c.d());
    }

    @Override // com.kwad.sdk.glide.load.a.d.a
    public void a(Object obj) {
        h c2 = this.f35622a.c();
        if (obj == null || !c2.a(this.f35627f.f35336c.d())) {
            this.f35623b.a(this.f35627f.f35334a, obj, this.f35627f.f35336c, this.f35627f.f35336c.d(), this.f35628g);
            return;
        }
        this.f35626e = obj;
        this.f35623b.c();
    }

    @Override // com.kwad.sdk.glide.load.engine.e
    public boolean a() {
        Object obj = this.f35626e;
        if (obj != null) {
            this.f35626e = null;
            b(obj);
        }
        b bVar = this.f35625d;
        if (bVar == null || !bVar.a()) {
            this.f35625d = null;
            this.f35627f = null;
            boolean z = false;
            while (!z && d()) {
                List<n.a<?>> n = this.f35622a.n();
                int i = this.f35624c;
                this.f35624c = i + 1;
                this.f35627f = n.get(i);
                if (this.f35627f != null && (this.f35622a.c().a(this.f35627f.f35336c.d()) || this.f35622a.a(this.f35627f.f35336c.a()))) {
                    this.f35627f.f35336c.a(this.f35622a.d(), this);
                    z = true;
                }
            }
            return z;
        }
        return true;
    }

    @Override // com.kwad.sdk.glide.load.engine.e
    public void b() {
        n.a<?> aVar = this.f35627f;
        if (aVar != null) {
            aVar.f35336c.c();
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.e.a
    public void c() {
        throw new UnsupportedOperationException();
    }
}
