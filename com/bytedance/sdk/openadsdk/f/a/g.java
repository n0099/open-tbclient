package com.bytedance.sdk.openadsdk.f.a;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.f.a.d;
import com.bytedance.sdk.openadsdk.f.a.s;
import com.bytedance.sdk.openadsdk.f.a.u;
import com.bytedance.sdk.openadsdk.f.a.v;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
/* loaded from: classes4.dex */
class g implements v.a {

    /* renamed from: a  reason: collision with root package name */
    private final h f7118a;

    /* renamed from: b  reason: collision with root package name */
    private final t f7119b;
    private final Map<String, b> c = new HashMap();
    private final Map<String, d.b> d = new HashMap();
    private final List<p> e = new ArrayList();
    private final Set<d> f = new HashSet();
    private final m g;
    private final boolean h;
    private final boolean i;
    private final com.bytedance.sdk.openadsdk.f.a.a j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(@NonNull j jVar, @NonNull com.bytedance.sdk.openadsdk.f.a.a aVar, @Nullable u uVar) {
        this.j = aVar;
        this.f7118a = jVar.d;
        this.f7119b = new t(uVar, jVar.l, jVar.m);
        this.f7119b.a(this);
        this.f7119b.a(jVar.p);
        this.g = jVar.i;
        this.h = jVar.h;
        this.i = jVar.o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    @MainThread
    public a a(@NonNull p pVar, @NonNull f fVar) throws Exception {
        b bVar = this.c.get(pVar.d);
        if (bVar != null) {
            try {
                w b2 = b(fVar.f7117b, bVar);
                fVar.d = b2;
                if (b2 == null) {
                    if (this.g != null) {
                        this.g.a(fVar.f7117b, pVar.d, 1);
                    }
                    i.a("Permission denied, call: " + pVar);
                    throw new r(-1);
                } else if (bVar instanceof e) {
                    i.a("Processing stateless call: " + pVar);
                    return a(pVar, (e) bVar, fVar);
                } else if (bVar instanceof c) {
                    i.a("Processing raw call: " + pVar);
                    return a(pVar, (c) bVar, b2);
                }
            } catch (u.a e) {
                i.a("No remote permission config fetched, call pending: " + pVar, e);
                this.e.add(pVar);
                return new a(false, x.a());
            }
        }
        d.b bVar2 = this.d.get(pVar.d);
        if (bVar2 != null) {
            d a2 = bVar2.a();
            a2.a(pVar.d);
            w b3 = b(fVar.f7117b, a2);
            fVar.d = b3;
            if (b3 == null) {
                i.a("Permission denied, call: " + pVar);
                a2.d();
                throw new r(-1);
            }
            i.a("Processing stateful call: " + pVar);
            return a(pVar, a2, fVar);
        }
        if (this.g != null) {
            this.g.a(fVar.f7117b, pVar.d, 2);
        }
        i.b("Received call: " + pVar + ", but not registered.");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, @NonNull e<?, ?> eVar) {
        eVar.a(str);
        this.c.put(str, eVar);
        i.a("JsBridge stateless method registered: " + str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, @NonNull d.b bVar) {
        this.d.put(str, bVar);
        i.a("JsBridge stateful method registered: " + str);
    }

    @NonNull
    @MainThread
    private a a(@NonNull p pVar, @NonNull e eVar, @NonNull f fVar) throws Exception {
        return new a(true, x.a(this.f7118a.a((h) eVar.a(a(pVar.e, (b) eVar), fVar))));
    }

    @NonNull
    @MainThread
    private a a(@NonNull final p pVar, @NonNull final d dVar, @NonNull f fVar) throws Exception {
        this.f.add(dVar);
        dVar.a(a(pVar.e, dVar), fVar, new d.a() { // from class: com.bytedance.sdk.openadsdk.f.a.g.1
            @Override // com.bytedance.sdk.openadsdk.f.a.d.a
            public void a(@Nullable Object obj) {
                if (g.this.j != null) {
                    g.this.j.b(x.a(g.this.f7118a.a((h) obj)), pVar);
                    g.this.f.remove(dVar);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.f.a.d.a
            public void a(@Nullable Throwable th) {
                if (g.this.j != null) {
                    g.this.j.b(x.a(th), pVar);
                    g.this.f.remove(dVar);
                }
            }
        });
        return new a(false, x.a());
    }

    @NonNull
    @MainThread
    private a a(final p pVar, c cVar, w wVar) throws Exception {
        cVar.a(pVar, new s(pVar.d, wVar, new s.a() { // from class: com.bytedance.sdk.openadsdk.f.a.g.2
        }));
        return new a(false, x.a());
    }

    private Object a(String str, b bVar) throws JSONException {
        return this.f7118a.a(str, a(bVar)[0]);
    }

    private w b(String str, b bVar) {
        return this.i ? w.PRIVATE : this.f7119b.a(this.h, str, bVar);
    }

    @NonNull
    private static Type[] a(Object obj) {
        Type genericSuperclass = obj.getClass().getGenericSuperclass();
        if (genericSuperclass == null) {
            throw new IllegalStateException("Method is not parameterized?!");
        }
        return ((ParameterizedType) genericSuperclass).getActualTypeArguments();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f7124a;

        /* renamed from: b  reason: collision with root package name */
        String f7125b;

        private a(boolean z, @NonNull String str) {
            this.f7124a = z;
            this.f7125b = str;
        }
    }
}
