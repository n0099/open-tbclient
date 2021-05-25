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
    public final h f29060a;

    /* renamed from: b  reason: collision with root package name */
    public final t f29061b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, b> f29062c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, d.b> f29063d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public final List<p> f29064e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public final Set<d> f29065f = new HashSet();

    /* renamed from: g  reason: collision with root package name */
    public final m f29066g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f29067h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f29068i;
    public final com.bytedance.sdk.openadsdk.f.a.a j;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f29074a;

        /* renamed from: b  reason: collision with root package name */
        public String f29075b;

        public a(boolean z, @NonNull String str) {
            this.f29074a = z;
            this.f29075b = str;
        }
    }

    public g(@NonNull j jVar, @NonNull com.bytedance.sdk.openadsdk.f.a.a aVar, @Nullable u uVar) {
        this.j = aVar;
        this.f29060a = jVar.f29081d;
        t tVar = new t(uVar, jVar.l, jVar.m);
        this.f29061b = tVar;
        tVar.a(this);
        this.f29061b.a(jVar.p);
        this.f29066g = jVar.f29086i;
        this.f29067h = jVar.f29085h;
        this.f29068i = jVar.o;
    }

    private w b(String str, b bVar) {
        if (this.f29068i) {
            return w.PRIVATE;
        }
        return this.f29061b.a(this.f29067h, str, bVar);
    }

    @Nullable
    @MainThread
    public a a(@NonNull p pVar, @NonNull f fVar) throws Exception {
        b bVar = this.f29062c.get(pVar.f29090d);
        if (bVar != null) {
            try {
                w b2 = b(fVar.f29057b, bVar);
                fVar.f29059d = b2;
                if (b2 == null) {
                    if (this.f29066g != null) {
                        this.f29066g.a(fVar.f29057b, pVar.f29090d, 1);
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
                this.f29064e.add(pVar);
                return new a(false, x.a());
            }
        }
        d.b bVar2 = this.f29063d.get(pVar.f29090d);
        if (bVar2 != null) {
            d a2 = bVar2.a();
            a2.a(pVar.f29090d);
            w b3 = b(fVar.f29057b, a2);
            fVar.f29059d = b3;
            if (b3 != null) {
                i.a("Processing stateful call: " + pVar);
                return a(pVar, a2, fVar);
            }
            i.a("Permission denied, call: " + pVar);
            a2.d();
            throw new r(-1);
        }
        m mVar = this.f29066g;
        if (mVar != null) {
            mVar.a(fVar.f29057b, pVar.f29090d, 2);
        }
        i.b("Received call: " + pVar + ", but not registered.");
        return null;
    }

    public void a(String str, @NonNull e<?, ?> eVar) {
        eVar.a(str);
        this.f29062c.put(str, eVar);
        i.a("JsBridge stateless method registered: " + str);
    }

    public void a(String str, @NonNull d.b bVar) {
        this.f29063d.put(str, bVar);
        i.a("JsBridge stateful method registered: " + str);
    }

    @NonNull
    @MainThread
    private a a(@NonNull p pVar, @NonNull e eVar, @NonNull f fVar) throws Exception {
        return new a(true, x.a(this.f29060a.a((h) eVar.a(a(pVar.f29091e, (b) eVar), fVar))));
    }

    @NonNull
    @MainThread
    private a a(@NonNull final p pVar, @NonNull final d dVar, @NonNull f fVar) throws Exception {
        this.f29065f.add(dVar);
        dVar.a(a(pVar.f29091e, dVar), fVar, new d.a() { // from class: com.bytedance.sdk.openadsdk.f.a.g.1
            @Override // com.bytedance.sdk.openadsdk.f.a.d.a
            public void a(@Nullable Object obj) {
                if (g.this.j == null) {
                    return;
                }
                g.this.j.b(x.a(g.this.f29060a.a((h) obj)), pVar);
                g.this.f29065f.remove(dVar);
            }

            @Override // com.bytedance.sdk.openadsdk.f.a.d.a
            public void a(@Nullable Throwable th) {
                if (g.this.j == null) {
                    return;
                }
                g.this.j.b(x.a(th), pVar);
                g.this.f29065f.remove(dVar);
            }
        });
        return new a(false, x.a());
    }

    @NonNull
    @MainThread
    private a a(final p pVar, c cVar, w wVar) throws Exception {
        cVar.a(pVar, new s(pVar.f29090d, wVar, new s.a() { // from class: com.bytedance.sdk.openadsdk.f.a.g.2
        }));
        return new a(false, x.a());
    }

    private Object a(String str, b bVar) throws JSONException {
        return this.f29060a.a(str, a(bVar)[0]);
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
