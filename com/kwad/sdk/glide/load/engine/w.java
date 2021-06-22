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
    public final f<?> f36413a;

    /* renamed from: b  reason: collision with root package name */
    public final e.a f36414b;

    /* renamed from: c  reason: collision with root package name */
    public int f36415c;

    /* renamed from: d  reason: collision with root package name */
    public b f36416d;

    /* renamed from: e  reason: collision with root package name */
    public Object f36417e;

    /* renamed from: f  reason: collision with root package name */
    public volatile n.a<?> f36418f;

    /* renamed from: g  reason: collision with root package name */
    public c f36419g;

    public w(f<?> fVar, e.a aVar) {
        this.f36413a = fVar;
        this.f36414b = aVar;
    }

    private void b(Object obj) {
        long a2 = com.kwad.sdk.glide.g.f.a();
        try {
            com.kwad.sdk.glide.load.a<X> a3 = this.f36413a.a((f<?>) obj);
            d dVar = new d(a3, obj, this.f36413a.e());
            this.f36419g = new c(this.f36418f.f36115a, this.f36413a.f());
            this.f36413a.b().a(this.f36419g, dVar);
            if (Log.isLoggable(SourceGenerator.TAG, 2)) {
                Log.v(SourceGenerator.TAG, "Finished encoding source to cache, key: " + this.f36419g + ", data: " + obj + ", encoder: " + a3 + ", duration: " + com.kwad.sdk.glide.g.f.a(a2));
            }
            this.f36418f.f36117c.b();
            this.f36416d = new b(Collections.singletonList(this.f36418f.f36115a), this.f36413a, this);
        } catch (Throwable th) {
            this.f36418f.f36117c.b();
            throw th;
        }
    }

    private boolean d() {
        return this.f36415c < this.f36413a.n().size();
    }

    @Override // com.kwad.sdk.glide.load.engine.e.a
    public void a(com.kwad.sdk.glide.load.c cVar, Exception exc, com.kwad.sdk.glide.load.a.d<?> dVar, DataSource dataSource) {
        this.f36414b.a(cVar, exc, dVar, this.f36418f.f36117c.d());
    }

    @Override // com.kwad.sdk.glide.load.engine.e.a
    public void a(com.kwad.sdk.glide.load.c cVar, Object obj, com.kwad.sdk.glide.load.a.d<?> dVar, DataSource dataSource, com.kwad.sdk.glide.load.c cVar2) {
        this.f36414b.a(cVar, obj, dVar, this.f36418f.f36117c.d(), cVar);
    }

    @Override // com.kwad.sdk.glide.load.a.d.a
    public void a(@NonNull Exception exc) {
        this.f36414b.a(this.f36419g, exc, this.f36418f.f36117c, this.f36418f.f36117c.d());
    }

    @Override // com.kwad.sdk.glide.load.a.d.a
    public void a(Object obj) {
        h c2 = this.f36413a.c();
        if (obj == null || !c2.a(this.f36418f.f36117c.d())) {
            this.f36414b.a(this.f36418f.f36115a, obj, this.f36418f.f36117c, this.f36418f.f36117c.d(), this.f36419g);
            return;
        }
        this.f36417e = obj;
        this.f36414b.c();
    }

    @Override // com.kwad.sdk.glide.load.engine.e
    public boolean a() {
        Object obj = this.f36417e;
        if (obj != null) {
            this.f36417e = null;
            b(obj);
        }
        b bVar = this.f36416d;
        if (bVar == null || !bVar.a()) {
            this.f36416d = null;
            this.f36418f = null;
            boolean z = false;
            while (!z && d()) {
                List<n.a<?>> n = this.f36413a.n();
                int i2 = this.f36415c;
                this.f36415c = i2 + 1;
                this.f36418f = n.get(i2);
                if (this.f36418f != null && (this.f36413a.c().a(this.f36418f.f36117c.d()) || this.f36413a.a(this.f36418f.f36117c.a()))) {
                    this.f36418f.f36117c.a(this.f36413a.d(), this);
                    z = true;
                }
            }
            return z;
        }
        return true;
    }

    @Override // com.kwad.sdk.glide.load.engine.e
    public void b() {
        n.a<?> aVar = this.f36418f;
        if (aVar != null) {
            aVar.f36117c.c();
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.e.a
    public void c() {
        throw new UnsupportedOperationException();
    }
}
