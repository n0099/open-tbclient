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
/* loaded from: classes6.dex */
public class g implements v.a {

    /* renamed from: a  reason: collision with root package name */
    public final h f29302a;

    /* renamed from: b  reason: collision with root package name */
    public final t f29303b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, b> f29304c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, d.b> f29305d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public final List<p> f29306e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public final Set<d> f29307f = new HashSet();

    /* renamed from: g  reason: collision with root package name */
    public final m f29308g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f29309h;
    public final boolean i;
    public final com.bytedance.sdk.openadsdk.f.a.a j;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f29315a;

        /* renamed from: b  reason: collision with root package name */
        public String f29316b;

        public a(boolean z, @NonNull String str) {
            this.f29315a = z;
            this.f29316b = str;
        }
    }

    public g(@NonNull j jVar, @NonNull com.bytedance.sdk.openadsdk.f.a.a aVar, @Nullable u uVar) {
        this.j = aVar;
        this.f29302a = jVar.f29322d;
        t tVar = new t(uVar, jVar.l, jVar.m);
        this.f29303b = tVar;
        tVar.a(this);
        this.f29303b.a(jVar.p);
        this.f29308g = jVar.i;
        this.f29309h = jVar.f29326h;
        this.i = jVar.o;
    }

    private w b(String str, b bVar) {
        if (this.i) {
            return w.PRIVATE;
        }
        return this.f29303b.a(this.f29309h, str, bVar);
    }

    @Nullable
    @MainThread
    public a a(@NonNull p pVar, @NonNull f fVar) throws Exception {
        b bVar = this.f29304c.get(pVar.f29330d);
        if (bVar != null) {
            try {
                w b2 = b(fVar.f29299b, bVar);
                fVar.f29301d = b2;
                if (b2 == null) {
                    if (this.f29308g != null) {
                        this.f29308g.a(fVar.f29299b, pVar.f29330d, 1);
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
                this.f29306e.add(pVar);
                return new a(false, x.a());
            }
        }
        d.b bVar2 = this.f29305d.get(pVar.f29330d);
        if (bVar2 != null) {
            d a2 = bVar2.a();
            a2.a(pVar.f29330d);
            w b3 = b(fVar.f29299b, a2);
            fVar.f29301d = b3;
            if (b3 != null) {
                i.a("Processing stateful call: " + pVar);
                return a(pVar, a2, fVar);
            }
            i.a("Permission denied, call: " + pVar);
            a2.d();
            throw new r(-1);
        }
        m mVar = this.f29308g;
        if (mVar != null) {
            mVar.a(fVar.f29299b, pVar.f29330d, 2);
        }
        i.b("Received call: " + pVar + ", but not registered.");
        return null;
    }

    public void a(String str, @NonNull e<?, ?> eVar) {
        eVar.a(str);
        this.f29304c.put(str, eVar);
        i.a("JsBridge stateless method registered: " + str);
    }

    public void a(String str, @NonNull d.b bVar) {
        this.f29305d.put(str, bVar);
        i.a("JsBridge stateful method registered: " + str);
    }

    @NonNull
    @MainThread
    private a a(@NonNull p pVar, @NonNull e eVar, @NonNull f fVar) throws Exception {
        return new a(true, x.a(this.f29302a.a((h) eVar.a(a(pVar.f29331e, (b) eVar), fVar))));
    }

    @NonNull
    @MainThread
    private a a(@NonNull final p pVar, @NonNull final d dVar, @NonNull f fVar) throws Exception {
        this.f29307f.add(dVar);
        dVar.a(a(pVar.f29331e, dVar), fVar, new d.a() { // from class: com.bytedance.sdk.openadsdk.f.a.g.1
            @Override // com.bytedance.sdk.openadsdk.f.a.d.a
            public void a(@Nullable Object obj) {
                if (g.this.j == null) {
                    return;
                }
                g.this.j.b(x.a(g.this.f29302a.a((h) obj)), pVar);
                g.this.f29307f.remove(dVar);
            }

            @Override // com.bytedance.sdk.openadsdk.f.a.d.a
            public void a(@Nullable Throwable th) {
                if (g.this.j == null) {
                    return;
                }
                g.this.j.b(x.a(th), pVar);
                g.this.f29307f.remove(dVar);
            }
        });
        return new a(false, x.a());
    }

    @NonNull
    @MainThread
    private a a(final p pVar, c cVar, w wVar) throws Exception {
        cVar.a(pVar, new s(pVar.f29330d, wVar, new s.a() { // from class: com.bytedance.sdk.openadsdk.f.a.g.2
        }));
        return new a(false, x.a());
    }

    private Object a(String str, b bVar) throws JSONException {
        return this.f29302a.a(str, a(bVar)[0]);
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
