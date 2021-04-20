package com.kwai.sodler.lib;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class k implements com.kwai.sodler.lib.a.e {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwai.sodler.lib.a.d f37478a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwai.sodler.lib.a.g f37479b;

    /* renamed from: c  reason: collision with root package name */
    public final com.kwai.sodler.lib.a.c f37480c;

    /* renamed from: d  reason: collision with root package name */
    public final com.kwai.sodler.lib.a.b f37481d;

    /* renamed from: e  reason: collision with root package name */
    public final com.kwai.sodler.lib.ext.c f37482e;

    /* renamed from: f  reason: collision with root package name */
    public final com.kwai.sodler.lib.ext.a f37483f;

    /* loaded from: classes6.dex */
    public static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        public final com.kwai.sodler.lib.a.e f37484a;

        /* renamed from: com.kwai.sodler.lib.k$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static class C0465a extends a {
            public C0465a(com.kwai.sodler.lib.a.e eVar) {
                super(eVar);
            }

            @Override // com.kwai.sodler.lib.k.a
            public void a(com.kwai.sodler.lib.a.f fVar) {
                this.f37484a.f().a(fVar);
            }
        }

        /* loaded from: classes6.dex */
        public static class b extends a {
            public b(com.kwai.sodler.lib.a.e eVar) {
                super(eVar);
            }

            @Override // com.kwai.sodler.lib.k.a
            public void a(com.kwai.sodler.lib.a.f fVar) {
                this.f37484a.c().a(fVar);
            }
        }

        /* loaded from: classes6.dex */
        public static class c extends a {
            public c(com.kwai.sodler.lib.a.e eVar) {
                super(eVar);
            }

            @Override // com.kwai.sodler.lib.k.a
            public void a(com.kwai.sodler.lib.a.f fVar) {
                this.f37484a.d().a(fVar);
            }
        }

        public a(com.kwai.sodler.lib.a.e eVar) {
            this.f37484a = eVar;
        }

        public static a a(com.kwai.sodler.lib.a.e eVar, int i) {
            return i != 1 ? i != 256 ? new b(eVar) : new C0465a(eVar) : new c(eVar);
        }

        public abstract void a(com.kwai.sodler.lib.a.f fVar);
    }

    public k(com.kwai.sodler.lib.a.d dVar, com.kwai.sodler.lib.a.g gVar, com.kwai.sodler.lib.a.c cVar, com.kwai.sodler.lib.a.b bVar, com.kwai.sodler.lib.ext.c cVar2, com.kwai.sodler.lib.ext.a aVar) {
        this.f37478a = dVar;
        this.f37479b = gVar;
        this.f37480c = cVar;
        this.f37482e = cVar2;
        this.f37483f = aVar;
        this.f37481d = bVar;
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
        return this.f37482e;
    }

    @Override // com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.a.d c() {
        return this.f37478a;
    }

    @Override // com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.a.g d() {
        return this.f37479b;
    }

    @Override // com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.a.c e() {
        return this.f37480c;
    }

    @Override // com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.a.b f() {
        return this.f37481d;
    }

    @Override // com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.ext.a g() {
        return this.f37483f;
    }
}
