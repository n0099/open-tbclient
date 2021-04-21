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
/* loaded from: classes5.dex */
public class g implements v.a {

    /* renamed from: a  reason: collision with root package name */
    public final h f28996a;

    /* renamed from: b  reason: collision with root package name */
    public final t f28997b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, b> f28998c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, d.b> f28999d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public final List<p> f29000e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public final Set<d> f29001f = new HashSet();

    /* renamed from: g  reason: collision with root package name */
    public final m f29002g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f29003h;
    public final boolean i;
    public final com.bytedance.sdk.openadsdk.f.a.a j;

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f29009a;

        /* renamed from: b  reason: collision with root package name */
        public String f29010b;

        public a(boolean z, @NonNull String str) {
            this.f29009a = z;
            this.f29010b = str;
        }
    }

    public g(@NonNull j jVar, @NonNull com.bytedance.sdk.openadsdk.f.a.a aVar, @Nullable u uVar) {
        this.j = aVar;
        this.f28996a = jVar.f29016d;
        t tVar = new t(uVar, jVar.l, jVar.m);
        this.f28997b = tVar;
        tVar.a(this);
        this.f28997b.a(jVar.p);
        this.f29002g = jVar.i;
        this.f29003h = jVar.f29020h;
        this.i = jVar.o;
    }

    private w b(String str, b bVar) {
        if (this.i) {
            return w.PRIVATE;
        }
        return this.f28997b.a(this.f29003h, str, bVar);
    }

    @Nullable
    @MainThread
    public a a(@NonNull p pVar, @NonNull f fVar) throws Exception {
        b bVar = this.f28998c.get(pVar.f29024d);
        if (bVar != null) {
            try {
                w b2 = b(fVar.f28993b, bVar);
                fVar.f28995d = b2;
                if (b2 == null) {
                    if (this.f29002g != null) {
                        this.f29002g.a(fVar.f28993b, pVar.f29024d, 1);
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
            } catch (u.a e2) {
                i.a("No remote permission config fetched, call pending: " + pVar, e2);
                this.f29000e.add(pVar);
                return new a(false, x.a());
            }
        }
        d.b bVar2 = this.f28999d.get(pVar.f29024d);
        if (bVar2 != null) {
            d a2 = bVar2.a();
            a2.a(pVar.f29024d);
            w b3 = b(fVar.f28993b, a2);
            fVar.f28995d = b3;
            if (b3 != null) {
                i.a("Processing stateful call: " + pVar);
                return a(pVar, a2, fVar);
            }
            i.a("Permission denied, call: " + pVar);
            a2.d();
            throw new r(-1);
        }
        m mVar = this.f29002g;
        if (mVar != null) {
            mVar.a(fVar.f28993b, pVar.f29024d, 2);
        }
        i.b("Received call: " + pVar + ", but not registered.");
        return null;
    }

    public void a(String str, @NonNull e<?, ?> eVar) {
        eVar.a(str);
        this.f28998c.put(str, eVar);
        i.a("JsBridge stateless method registered: " + str);
    }

    public void a(String str, @NonNull d.b bVar) {
        this.f28999d.put(str, bVar);
        i.a("JsBridge stateful method registered: " + str);
    }

    @NonNull
    @MainThread
    private a a(@NonNull p pVar, @NonNull e eVar, @NonNull f fVar) throws Exception {
        return new a(true, x.a(this.f28996a.a((h) eVar.a(a(pVar.f29025e, (b) eVar), fVar))));
    }

    @NonNull
    @MainThread
    private a a(@NonNull final p pVar, @NonNull final d dVar, @NonNull f fVar) throws Exception {
        this.f29001f.add(dVar);
        dVar.a(a(pVar.f29025e, dVar), fVar, new d.a() { // from class: com.bytedance.sdk.openadsdk.f.a.g.1
            @Override // com.bytedance.sdk.openadsdk.f.a.d.a
            public void a(@Nullable Object obj) {
                if (g.this.j == null) {
                    return;
                }
                g.this.j.b(x.a(g.this.f28996a.a((h) obj)), pVar);
                g.this.f29001f.remove(dVar);
            }

            @Override // com.bytedance.sdk.openadsdk.f.a.d.a
            public void a(@Nullable Throwable th) {
                if (g.this.j == null) {
                    return;
                }
                g.this.j.b(x.a(th), pVar);
                g.this.f29001f.remove(dVar);
            }
        });
        return new a(false, x.a());
    }

    @NonNull
    @MainThread
    private a a(final p pVar, c cVar, w wVar) throws Exception {
        cVar.a(pVar, new s(pVar.f29024d, wVar, new s.a() { // from class: com.bytedance.sdk.openadsdk.f.a.g.2
        }));
        return new a(false, x.a());
    }

    private Object a(String str, b bVar) throws JSONException {
        return this.f28996a.a(str, a(bVar)[0]);
    }

    @NonNull
    public static Type[] a(Object obj) {
        Type genericSuperclass = obj.getClass().getGenericSuperclass();
        if (genericSuperclass != null) {
            return ((ParameterizedType) genericSuperclass).getActualTypeArguments();
        }
        throw new IllegalStateException("Method is not parameterized?!");
    }
}
