package com.kwai.sodler.lib;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class k implements com.kwai.sodler.lib.a.e {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwai.sodler.lib.a.d f35299a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwai.sodler.lib.a.g f35300b;

    /* renamed from: c  reason: collision with root package name */
    public final com.kwai.sodler.lib.a.c f35301c;

    /* renamed from: d  reason: collision with root package name */
    public final com.kwai.sodler.lib.a.b f35302d;

    /* renamed from: e  reason: collision with root package name */
    public final com.kwai.sodler.lib.ext.c f35303e;

    /* renamed from: f  reason: collision with root package name */
    public final com.kwai.sodler.lib.ext.a f35304f;

    /* loaded from: classes6.dex */
    public static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        public final com.kwai.sodler.lib.a.e f35305a;

        /* renamed from: com.kwai.sodler.lib.k$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static class C0413a extends a {
            public C0413a(com.kwai.sodler.lib.a.e eVar) {
                super(eVar);
            }

            @Override // com.kwai.sodler.lib.k.a
            public void a(com.kwai.sodler.lib.a.f fVar) {
                this.f35305a.f().a(fVar);
            }
        }

        /* loaded from: classes6.dex */
        public static class b extends a {
            public b(com.kwai.sodler.lib.a.e eVar) {
                super(eVar);
            }

            @Override // com.kwai.sodler.lib.k.a
            public void a(com.kwai.sodler.lib.a.f fVar) {
                this.f35305a.c().a(fVar);
            }
        }

        /* loaded from: classes6.dex */
        public static class c extends a {
            public c(com.kwai.sodler.lib.a.e eVar) {
                super(eVar);
            }

            @Override // com.kwai.sodler.lib.k.a
            public void a(com.kwai.sodler.lib.a.f fVar) {
                this.f35305a.d().a(fVar);
            }
        }

        public a(com.kwai.sodler.lib.a.e eVar) {
            this.f35305a = eVar;
        }

        public static a a(com.kwai.sodler.lib.a.e eVar, int i2) {
            return i2 != 1 ? i2 != 256 ? new b(eVar) : new C0413a(eVar) : new c(eVar);
        }

        public abstract void a(com.kwai.sodler.lib.a.f fVar);
    }

    public k(com.kwai.sodler.lib.a.d dVar, com.kwai.sodler.lib.a.g gVar, com.kwai.sodler.lib.a.c cVar, com.kwai.sodler.lib.a.b bVar, com.kwai.sodler.lib.ext.c cVar2, com.kwai.sodler.lib.ext.a aVar) {
        this.f35299a = dVar;
        this.f35300b = gVar;
        this.f35301c = cVar;
        this.f35303e = cVar2;
        this.f35304f = aVar;
        this.f35302d = bVar;
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
        return this.f35303e;
    }

    @Override // com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.a.d c() {
        return this.f35299a;
    }

    @Override // com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.a.g d() {
        return this.f35300b;
    }

    @Override // com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.a.c e() {
        return this.f35301c;
    }

    @Override // com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.a.b f() {
        return this.f35302d;
    }

    @Override // com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.ext.a g() {
        return this.f35304f;
    }
}
