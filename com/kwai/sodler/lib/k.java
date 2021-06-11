package com.kwai.sodler.lib;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class k implements com.kwai.sodler.lib.a.e {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwai.sodler.lib.a.d f37957a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwai.sodler.lib.a.g f37958b;

    /* renamed from: c  reason: collision with root package name */
    public final com.kwai.sodler.lib.a.c f37959c;

    /* renamed from: d  reason: collision with root package name */
    public final com.kwai.sodler.lib.a.b f37960d;

    /* renamed from: e  reason: collision with root package name */
    public final com.kwai.sodler.lib.ext.c f37961e;

    /* renamed from: f  reason: collision with root package name */
    public final com.kwai.sodler.lib.ext.a f37962f;

    /* loaded from: classes7.dex */
    public static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        public final com.kwai.sodler.lib.a.e f37963a;

        /* renamed from: com.kwai.sodler.lib.k$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static class C0451a extends a {
            public C0451a(com.kwai.sodler.lib.a.e eVar) {
                super(eVar);
            }

            @Override // com.kwai.sodler.lib.k.a
            public void a(com.kwai.sodler.lib.a.f fVar) {
                this.f37963a.f().a(fVar);
            }
        }

        /* loaded from: classes7.dex */
        public static class b extends a {
            public b(com.kwai.sodler.lib.a.e eVar) {
                super(eVar);
            }

            @Override // com.kwai.sodler.lib.k.a
            public void a(com.kwai.sodler.lib.a.f fVar) {
                this.f37963a.c().a(fVar);
            }
        }

        /* loaded from: classes7.dex */
        public static class c extends a {
            public c(com.kwai.sodler.lib.a.e eVar) {
                super(eVar);
            }

            @Override // com.kwai.sodler.lib.k.a
            public void a(com.kwai.sodler.lib.a.f fVar) {
                this.f37963a.d().a(fVar);
            }
        }

        public a(com.kwai.sodler.lib.a.e eVar) {
            this.f37963a = eVar;
        }

        public static a a(com.kwai.sodler.lib.a.e eVar, int i2) {
            return i2 != 1 ? i2 != 256 ? new b(eVar) : new C0451a(eVar) : new c(eVar);
        }

        public abstract void a(com.kwai.sodler.lib.a.f fVar);
    }

    public k(com.kwai.sodler.lib.a.d dVar, com.kwai.sodler.lib.a.g gVar, com.kwai.sodler.lib.a.c cVar, com.kwai.sodler.lib.a.b bVar, com.kwai.sodler.lib.ext.c cVar2, com.kwai.sodler.lib.ext.a aVar) {
        this.f37957a = dVar;
        this.f37958b = gVar;
        this.f37959c = cVar;
        this.f37961e = cVar2;
        this.f37962f = aVar;
        this.f37960d = bVar;
    }

    public com.kwai.sodler.lib.a.f a(@NonNull com.kwai.sodler.lib.a.f fVar, @NonNull a aVar) {
        if (fVar.b() == null) {
            fVar.a(this);
        }
        com.kwai.sodler.lib.a.c("Sodler.manager", "request id = " + fVar.i() + ", state log = " + fVar.d());
        aVar.a(fVar);
        return fVar;
    }

    public Map a(Map map) {
        return (map == null || map == Collections.EMPTY_MAP) ? new HashMap() : map;
    }

    @Override // com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.ext.c b() {
        return this.f37961e;
    }

    @Override // com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.a.d c() {
        return this.f37957a;
    }

    @Override // com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.a.g d() {
        return this.f37958b;
    }

    @Override // com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.a.c e() {
        return this.f37959c;
    }

    @Override // com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.a.b f() {
        return this.f37960d;
    }

    @Override // com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.ext.a g() {
        return this.f37962f;
    }
}
