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
    public final f<?> f36006a;

    /* renamed from: b  reason: collision with root package name */
    public final e.a f36007b;

    /* renamed from: c  reason: collision with root package name */
    public int f36008c;

    /* renamed from: d  reason: collision with root package name */
    public b f36009d;

    /* renamed from: e  reason: collision with root package name */
    public Object f36010e;

    /* renamed from: f  reason: collision with root package name */
    public volatile n.a<?> f36011f;

    /* renamed from: g  reason: collision with root package name */
    public c f36012g;

    public w(f<?> fVar, e.a aVar) {
        this.f36006a = fVar;
        this.f36007b = aVar;
    }

    private void b(Object obj) {
        long a2 = com.kwad.sdk.glide.g.f.a();
        try {
            com.kwad.sdk.glide.load.a<X> a3 = this.f36006a.a((f<?>) obj);
            d dVar = new d(a3, obj, this.f36006a.e());
            this.f36012g = new c(this.f36011f.f35718a, this.f36006a.f());
            this.f36006a.b().a(this.f36012g, dVar);
            if (Log.isLoggable(SourceGenerator.TAG, 2)) {
                Log.v(SourceGenerator.TAG, "Finished encoding source to cache, key: " + this.f36012g + ", data: " + obj + ", encoder: " + a3 + ", duration: " + com.kwad.sdk.glide.g.f.a(a2));
            }
            this.f36011f.f35720c.b();
            this.f36009d = new b(Collections.singletonList(this.f36011f.f35718a), this.f36006a, this);
        } catch (Throwable th) {
            this.f36011f.f35720c.b();
            throw th;
        }
    }

    private boolean d() {
        return this.f36008c < this.f36006a.n().size();
    }

    @Override // com.kwad.sdk.glide.load.engine.e.a
    public void a(com.kwad.sdk.glide.load.c cVar, Exception exc, com.kwad.sdk.glide.load.a.d<?> dVar, DataSource dataSource) {
        this.f36007b.a(cVar, exc, dVar, this.f36011f.f35720c.d());
    }

    @Override // com.kwad.sdk.glide.load.engine.e.a
    public void a(com.kwad.sdk.glide.load.c cVar, Object obj, com.kwad.sdk.glide.load.a.d<?> dVar, DataSource dataSource, com.kwad.sdk.glide.load.c cVar2) {
        this.f36007b.a(cVar, obj, dVar, this.f36011f.f35720c.d(), cVar);
    }

    @Override // com.kwad.sdk.glide.load.a.d.a
    public void a(@NonNull Exception exc) {
        this.f36007b.a(this.f36012g, exc, this.f36011f.f35720c, this.f36011f.f35720c.d());
    }

    @Override // com.kwad.sdk.glide.load.a.d.a
    public void a(Object obj) {
        h c2 = this.f36006a.c();
        if (obj == null || !c2.a(this.f36011f.f35720c.d())) {
            this.f36007b.a(this.f36011f.f35718a, obj, this.f36011f.f35720c, this.f36011f.f35720c.d(), this.f36012g);
            return;
        }
        this.f36010e = obj;
        this.f36007b.c();
    }

    @Override // com.kwad.sdk.glide.load.engine.e
    public boolean a() {
        Object obj = this.f36010e;
        if (obj != null) {
            this.f36010e = null;
            b(obj);
        }
        b bVar = this.f36009d;
        if (bVar == null || !bVar.a()) {
            this.f36009d = null;
            this.f36011f = null;
            boolean z = false;
            while (!z && d()) {
                List<n.a<?>> n = this.f36006a.n();
                int i = this.f36008c;
                this.f36008c = i + 1;
                this.f36011f = n.get(i);
                if (this.f36011f != null && (this.f36006a.c().a(this.f36011f.f35720c.d()) || this.f36006a.a(this.f36011f.f35720c.a()))) {
                    this.f36011f.f35720c.a(this.f36006a.d(), this);
                    z = true;
                }
            }
            return z;
        }
        return true;
    }

    @Override // com.kwad.sdk.glide.load.engine.e
    public void b() {
        n.a<?> aVar = this.f36011f;
        if (aVar != null) {
            aVar.f35720c.c();
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.e.a
    public void c() {
        throw new UnsupportedOperationException();
    }
}
