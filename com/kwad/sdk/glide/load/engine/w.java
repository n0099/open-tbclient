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
/* loaded from: classes7.dex */
public class w implements d.a<Object>, e, e.a {

    /* renamed from: a  reason: collision with root package name */
    public final f<?> f36315a;

    /* renamed from: b  reason: collision with root package name */
    public final e.a f36316b;

    /* renamed from: c  reason: collision with root package name */
    public int f36317c;

    /* renamed from: d  reason: collision with root package name */
    public b f36318d;

    /* renamed from: e  reason: collision with root package name */
    public Object f36319e;

    /* renamed from: f  reason: collision with root package name */
    public volatile n.a<?> f36320f;

    /* renamed from: g  reason: collision with root package name */
    public c f36321g;

    public w(f<?> fVar, e.a aVar) {
        this.f36315a = fVar;
        this.f36316b = aVar;
    }

    private void b(Object obj) {
        long a2 = com.kwad.sdk.glide.g.f.a();
        try {
            com.kwad.sdk.glide.load.a<X> a3 = this.f36315a.a((f<?>) obj);
            d dVar = new d(a3, obj, this.f36315a.e());
            this.f36321g = new c(this.f36320f.f36017a, this.f36315a.f());
            this.f36315a.b().a(this.f36321g, dVar);
            if (Log.isLoggable(SourceGenerator.TAG, 2)) {
                Log.v(SourceGenerator.TAG, "Finished encoding source to cache, key: " + this.f36321g + ", data: " + obj + ", encoder: " + a3 + ", duration: " + com.kwad.sdk.glide.g.f.a(a2));
            }
            this.f36320f.f36019c.b();
            this.f36318d = new b(Collections.singletonList(this.f36320f.f36017a), this.f36315a, this);
        } catch (Throwable th) {
            this.f36320f.f36019c.b();
            throw th;
        }
    }

    private boolean d() {
        return this.f36317c < this.f36315a.n().size();
    }

    @Override // com.kwad.sdk.glide.load.engine.e.a
    public void a(com.kwad.sdk.glide.load.c cVar, Exception exc, com.kwad.sdk.glide.load.a.d<?> dVar, DataSource dataSource) {
        this.f36316b.a(cVar, exc, dVar, this.f36320f.f36019c.d());
    }

    @Override // com.kwad.sdk.glide.load.engine.e.a
    public void a(com.kwad.sdk.glide.load.c cVar, Object obj, com.kwad.sdk.glide.load.a.d<?> dVar, DataSource dataSource, com.kwad.sdk.glide.load.c cVar2) {
        this.f36316b.a(cVar, obj, dVar, this.f36320f.f36019c.d(), cVar);
    }

    @Override // com.kwad.sdk.glide.load.a.d.a
    public void a(@NonNull Exception exc) {
        this.f36316b.a(this.f36321g, exc, this.f36320f.f36019c, this.f36320f.f36019c.d());
    }

    @Override // com.kwad.sdk.glide.load.a.d.a
    public void a(Object obj) {
        h c2 = this.f36315a.c();
        if (obj == null || !c2.a(this.f36320f.f36019c.d())) {
            this.f36316b.a(this.f36320f.f36017a, obj, this.f36320f.f36019c, this.f36320f.f36019c.d(), this.f36321g);
            return;
        }
        this.f36319e = obj;
        this.f36316b.c();
    }

    @Override // com.kwad.sdk.glide.load.engine.e
    public boolean a() {
        Object obj = this.f36319e;
        if (obj != null) {
            this.f36319e = null;
            b(obj);
        }
        b bVar = this.f36318d;
        if (bVar == null || !bVar.a()) {
            this.f36318d = null;
            this.f36320f = null;
            boolean z = false;
            while (!z && d()) {
                List<n.a<?>> n = this.f36315a.n();
                int i2 = this.f36317c;
                this.f36317c = i2 + 1;
                this.f36320f = n.get(i2);
                if (this.f36320f != null && (this.f36315a.c().a(this.f36320f.f36019c.d()) || this.f36315a.a(this.f36320f.f36019c.a()))) {
                    this.f36320f.f36019c.a(this.f36315a.d(), this);
                    z = true;
                }
            }
            return z;
        }
        return true;
    }

    @Override // com.kwad.sdk.glide.load.engine.e
    public void b() {
        n.a<?> aVar = this.f36320f;
        if (aVar != null) {
            aVar.f36019c.c();
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.e.a
    public void c() {
        throw new UnsupportedOperationException();
    }
}
