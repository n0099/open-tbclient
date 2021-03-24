package com.kwai.sodler.lib;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class k implements com.kwai.sodler.lib.a.e {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwai.sodler.lib.a.d f37188a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwai.sodler.lib.a.g f37189b;

    /* renamed from: c  reason: collision with root package name */
    public final com.kwai.sodler.lib.a.c f37190c;

    /* renamed from: d  reason: collision with root package name */
    public final com.kwai.sodler.lib.a.b f37191d;

    /* renamed from: e  reason: collision with root package name */
    public final com.kwai.sodler.lib.ext.c f37192e;

    /* renamed from: f  reason: collision with root package name */
    public final com.kwai.sodler.lib.ext.a f37193f;

    /* loaded from: classes6.dex */
    public static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        public final com.kwai.sodler.lib.a.e f37194a;

        /* renamed from: com.kwai.sodler.lib.k$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static class C0450a extends a {
            public C0450a(com.kwai.sodler.lib.a.e eVar) {
                super(eVar);
            }

            @Override // com.kwai.sodler.lib.k.a
            public void a(com.kwai.sodler.lib.a.f fVar) {
                this.f37194a.f().a(fVar);
            }
        }

        /* loaded from: classes6.dex */
        public static class b extends a {
            public b(com.kwai.sodler.lib.a.e eVar) {
                super(eVar);
            }

            @Override // com.kwai.sodler.lib.k.a
            public void a(com.kwai.sodler.lib.a.f fVar) {
                this.f37194a.c().a(fVar);
            }
        }

        /* loaded from: classes6.dex */
        public static class c extends a {
            public c(com.kwai.sodler.lib.a.e eVar) {
                super(eVar);
            }

            @Override // com.kwai.sodler.lib.k.a
            public void a(com.kwai.sodler.lib.a.f fVar) {
                this.f37194a.d().a(fVar);
            }
        }

        public a(com.kwai.sodler.lib.a.e eVar) {
            this.f37194a = eVar;
        }

        public static a a(com.kwai.sodler.lib.a.e eVar, int i) {
            return i != 1 ? i != 256 ? new b(eVar) : new C0450a(eVar) : new c(eVar);
        }

        public abstract void a(com.kwai.sodler.lib.a.f fVar);
    }

    public k(com.kwai.sodler.lib.a.d dVar, com.kwai.sodler.lib.a.g gVar, com.kwai.sodler.lib.a.c cVar, com.kwai.sodler.lib.a.b bVar, com.kwai.sodler.lib.ext.c cVar2, com.kwai.sodler.lib.ext.a aVar) {
        this.f37188a = dVar;
        this.f37189b = gVar;
        this.f37190c = cVar;
        this.f37192e = cVar2;
        this.f37193f = aVar;
        this.f37191d = bVar;
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
        return this.f37192e;
    }

    @Override // com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.a.d c() {
        return this.f37188a;
    }

    @Override // com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.a.g d() {
        return this.f37189b;
    }

    @Override // com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.a.c e() {
        return this.f37190c;
    }

    @Override // com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.a.b f() {
        return this.f37191d;
    }

    @Override // com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.ext.a g() {
        return this.f37193f;
    }
}
