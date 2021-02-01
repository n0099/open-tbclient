package com.kwad.sdk.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.a.d;
import com.kwad.sdk.glide.load.b.n;
import com.kwad.sdk.glide.load.engine.e;
import java.util.Collections;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class w implements d.a<Object>, e, e.a {

    /* renamed from: a  reason: collision with root package name */
    private final f<?> f10255a;

    /* renamed from: b  reason: collision with root package name */
    private final e.a f10256b;
    private int c;
    private b d;
    private Object e;
    private volatile n.a<?> f;
    private c g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(f<?> fVar, e.a aVar) {
        this.f10255a = fVar;
        this.f10256b = aVar;
    }

    private void b(Object obj) {
        long a2 = com.kwad.sdk.glide.g.f.a();
        try {
            com.kwad.sdk.glide.load.a<X> a3 = this.f10255a.a((f<?>) obj);
            d dVar = new d(a3, obj, this.f10255a.e());
            this.g = new c(this.f.f10102a, this.f10255a.f());
            this.f10255a.b().a(this.g, dVar);
            if (Log.isLoggable("SourceGenerator", 2)) {
                Log.v("SourceGenerator", "Finished encoding source to cache, key: " + this.g + ", data: " + obj + ", encoder: " + a3 + ", duration: " + com.kwad.sdk.glide.g.f.a(a2));
            }
            this.f.c.b();
            this.d = new b(Collections.singletonList(this.f.f10102a), this.f10255a, this);
        } catch (Throwable th) {
            this.f.c.b();
            throw th;
        }
    }

    private boolean d() {
        return this.c < this.f10255a.n().size();
    }

    @Override // com.kwad.sdk.glide.load.engine.e.a
    public void a(com.kwad.sdk.glide.load.c cVar, Exception exc, com.kwad.sdk.glide.load.a.d<?> dVar, DataSource dataSource) {
        this.f10256b.a(cVar, exc, dVar, this.f.c.d());
    }

    @Override // com.kwad.sdk.glide.load.engine.e.a
    public void a(com.kwad.sdk.glide.load.c cVar, Object obj, com.kwad.sdk.glide.load.a.d<?> dVar, DataSource dataSource, com.kwad.sdk.glide.load.c cVar2) {
        this.f10256b.a(cVar, obj, dVar, this.f.c.d(), cVar);
    }

    @Override // com.kwad.sdk.glide.load.a.d.a
    public void a(@NonNull Exception exc) {
        this.f10256b.a(this.g, exc, this.f.c, this.f.c.d());
    }

    @Override // com.kwad.sdk.glide.load.a.d.a
    public void a(Object obj) {
        h c = this.f10255a.c();
        if (obj == null || !c.a(this.f.c.d())) {
            this.f10256b.a(this.f.f10102a, obj, this.f.c, this.f.c.d(), this.g);
            return;
        }
        this.e = obj;
        this.f10256b.c();
    }

    @Override // com.kwad.sdk.glide.load.engine.e
    public boolean a() {
        if (this.e != null) {
            Object obj = this.e;
            this.e = null;
            b(obj);
        }
        if (this.d == null || !this.d.a()) {
            this.d = null;
            this.f = null;
            boolean z = false;
            while (!z && d()) {
                List<n.a<?>> n = this.f10255a.n();
                int i = this.c;
                this.c = i + 1;
                this.f = n.get(i);
                if (this.f != null && (this.f10255a.c().a(this.f.c.d()) || this.f10255a.a(this.f.c.a()))) {
                    this.f.c.a(this.f10255a.d(), this);
                    z = true;
                }
            }
            return z;
        }
        return true;
    }

    @Override // com.kwad.sdk.glide.load.engine.e
    public void b() {
        n.a<?> aVar = this.f;
        if (aVar != null) {
            aVar.c.c();
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.e.a
    public void c() {
        throw new UnsupportedOperationException();
    }
}
