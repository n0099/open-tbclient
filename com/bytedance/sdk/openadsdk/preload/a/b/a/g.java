package com.bytedance.sdk.openadsdk.preload.a.b.a;

import com.baidu.android.common.others.lang.StringUtil;
import com.bytedance.sdk.openadsdk.preload.a.q;
import com.bytedance.sdk.openadsdk.preload.a.t;
import com.bytedance.sdk.openadsdk.preload.a.v;
import com.bytedance.sdk.openadsdk.preload.a.w;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes5.dex */
public final class g implements w {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f29618a;

    /* renamed from: b  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.a.b.c f29619b;

    /* loaded from: classes5.dex */
    public final class a<K, V> extends v<Map<K, V>> {

        /* renamed from: b  reason: collision with root package name */
        public final v<K> f29621b;

        /* renamed from: c  reason: collision with root package name */
        public final v<V> f29622c;

        /* renamed from: d  reason: collision with root package name */
        public final com.bytedance.sdk.openadsdk.preload.a.b.i<? extends Map<K, V>> f29623d;

        public a(com.bytedance.sdk.openadsdk.preload.a.f fVar, Type type, v<K> vVar, Type type2, v<V> vVar2, com.bytedance.sdk.openadsdk.preload.a.b.i<? extends Map<K, V>> iVar) {
            this.f29621b = new m(fVar, vVar, type);
            this.f29622c = new m(fVar, vVar2, type2);
            this.f29623d = iVar;
        }

        @Override // com.bytedance.sdk.openadsdk.preload.a.v
        public /* bridge */ /* synthetic */ void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, Object obj) throws IOException {
            a(cVar, (Map) ((Map) obj));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.preload.a.v
        /* renamed from: a */
        public Map<K, V> b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
            com.bytedance.sdk.openadsdk.preload.a.d.b f2 = aVar.f();
            if (f2 == com.bytedance.sdk.openadsdk.preload.a.d.b.NULL) {
                aVar.j();
                return null;
            }
            Map<K, V> a2 = this.f29623d.a();
            if (f2 == com.bytedance.sdk.openadsdk.preload.a.d.b.BEGIN_ARRAY) {
                aVar.a();
                while (aVar.e()) {
                    aVar.a();
                    K b2 = this.f29621b.b(aVar);
                    if (a2.put(b2, this.f29622c.b(aVar)) == null) {
                        aVar.b();
                    } else {
                        throw new t("duplicate key: " + b2);
                    }
                }
                aVar.b();
            } else {
                aVar.c();
                while (aVar.e()) {
                    com.bytedance.sdk.openadsdk.preload.a.b.f.f29739a.a(aVar);
                    K b3 = this.f29621b.b(aVar);
                    if (a2.put(b3, this.f29622c.b(aVar)) != null) {
                        throw new t("duplicate key: " + b3);
                    }
                }
                aVar.d();
            }
            return a2;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v5, resolved type: com.bytedance.sdk.openadsdk.preload.a.v<V> */
        /* JADX DEBUG: Multi-variable search result rejected for r3v8, resolved type: com.bytedance.sdk.openadsdk.preload.a.v<V> */
        /* JADX WARN: Multi-variable type inference failed */
        public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, Map<K, V> map) throws IOException {
            if (map == null) {
                cVar.f();
            } else if (!g.this.f29618a) {
                cVar.d();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    cVar.a(String.valueOf(entry.getKey()));
                    this.f29622c.a(cVar, entry.getValue());
                }
                cVar.e();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                int i = 0;
                boolean z = false;
                for (Map.Entry<K, V> entry2 : map.entrySet()) {
                    com.bytedance.sdk.openadsdk.preload.a.l a2 = this.f29621b.a(entry2.getKey());
                    arrayList.add(a2);
                    arrayList2.add(entry2.getValue());
                    z |= a2.g() || a2.h();
                }
                if (z) {
                    cVar.b();
                    int size = arrayList.size();
                    while (i < size) {
                        cVar.b();
                        com.bytedance.sdk.openadsdk.preload.a.b.l.a((com.bytedance.sdk.openadsdk.preload.a.l) arrayList.get(i), cVar);
                        this.f29622c.a(cVar, arrayList2.get(i));
                        cVar.c();
                        i++;
                    }
                    cVar.c();
                    return;
                }
                cVar.d();
                int size2 = arrayList.size();
                while (i < size2) {
                    cVar.a(a((com.bytedance.sdk.openadsdk.preload.a.l) arrayList.get(i)));
                    this.f29622c.a(cVar, arrayList2.get(i));
                    i++;
                }
                cVar.e();
            }
        }

        private String a(com.bytedance.sdk.openadsdk.preload.a.l lVar) {
            if (lVar.i()) {
                q m = lVar.m();
                if (m.o()) {
                    return String.valueOf(m.a());
                }
                if (m.n()) {
                    return Boolean.toString(m.f());
                }
                if (m.p()) {
                    return m.b();
                }
                throw new AssertionError();
            } else if (lVar.j()) {
                return StringUtil.NULL_STRING;
            } else {
                throw new AssertionError();
            }
        }
    }

    public g(com.bytedance.sdk.openadsdk.preload.a.b.c cVar, boolean z) {
        this.f29619b = cVar;
        this.f29618a = z;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.w
    public <T> v<T> a(com.bytedance.sdk.openadsdk.preload.a.f fVar, com.bytedance.sdk.openadsdk.preload.a.c.a<T> aVar) {
        Type b2 = aVar.b();
        if (Map.class.isAssignableFrom(aVar.a())) {
            Type[] b3 = com.bytedance.sdk.openadsdk.preload.a.b.b.b(b2, com.bytedance.sdk.openadsdk.preload.a.b.b.e(b2));
            return new a(fVar, b3[0], a(fVar, b3[0]), b3[1], fVar.a((com.bytedance.sdk.openadsdk.preload.a.c.a) com.bytedance.sdk.openadsdk.preload.a.c.a.a(b3[1])), this.f29619b.a(aVar));
        }
        return null;
    }

    private v<?> a(com.bytedance.sdk.openadsdk.preload.a.f fVar, Type type) {
        if (type != Boolean.TYPE && type != Boolean.class) {
            return fVar.a((com.bytedance.sdk.openadsdk.preload.a.c.a) com.bytedance.sdk.openadsdk.preload.a.c.a.a(type));
        }
        return n.f29667f;
    }
}
