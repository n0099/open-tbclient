package com.bytedance.sdk.openadsdk.preload.a.b.a;

import com.bytedance.sdk.openadsdk.preload.a.q;
import com.bytedance.sdk.openadsdk.preload.a.t;
import com.bytedance.sdk.openadsdk.preload.a.v;
import com.bytedance.sdk.openadsdk.preload.a.w;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes6.dex */
public final class g implements w {

    /* renamed from: a  reason: collision with root package name */
    final boolean f4961a;
    private final com.bytedance.sdk.openadsdk.preload.a.b.c b;

    public g(com.bytedance.sdk.openadsdk.preload.a.b.c cVar, boolean z) {
        this.b = cVar;
        this.f4961a = z;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.w
    public <T> v<T> a(com.bytedance.sdk.openadsdk.preload.a.f fVar, com.bytedance.sdk.openadsdk.preload.a.c.a<T> aVar) {
        Type b = aVar.b();
        if (!Map.class.isAssignableFrom(aVar.a())) {
            return null;
        }
        Type[] b2 = com.bytedance.sdk.openadsdk.preload.a.b.b.b(b, com.bytedance.sdk.openadsdk.preload.a.b.b.e(b));
        return new a(fVar, b2[0], a(fVar, b2[0]), b2[1], fVar.a((com.bytedance.sdk.openadsdk.preload.a.c.a) com.bytedance.sdk.openadsdk.preload.a.c.a.a(b2[1])), this.b.a(aVar));
    }

    private v<?> a(com.bytedance.sdk.openadsdk.preload.a.f fVar, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? n.f : fVar.a((com.bytedance.sdk.openadsdk.preload.a.c.a) com.bytedance.sdk.openadsdk.preload.a.c.a.a(type));
    }

    /* loaded from: classes6.dex */
    private final class a<K, V> extends v<Map<K, V>> {
        private final v<K> b;
        private final v<V> c;
        private final com.bytedance.sdk.openadsdk.preload.a.b.i<? extends Map<K, V>> d;

        @Override // com.bytedance.sdk.openadsdk.preload.a.v
        public /* bridge */ /* synthetic */ void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, Object obj) throws IOException {
            a(cVar, (Map) ((Map) obj));
        }

        public a(com.bytedance.sdk.openadsdk.preload.a.f fVar, Type type, v<K> vVar, Type type2, v<V> vVar2, com.bytedance.sdk.openadsdk.preload.a.b.i<? extends Map<K, V>> iVar) {
            this.b = new m(fVar, vVar, type);
            this.c = new m(fVar, vVar2, type2);
            this.d = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.preload.a.v
        /* renamed from: a */
        public Map<K, V> b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
            com.bytedance.sdk.openadsdk.preload.a.d.b f = aVar.f();
            if (f == com.bytedance.sdk.openadsdk.preload.a.d.b.NULL) {
                aVar.j();
                return null;
            }
            Map<K, V> a2 = this.d.a();
            if (f == com.bytedance.sdk.openadsdk.preload.a.d.b.BEGIN_ARRAY) {
                aVar.a();
                while (aVar.e()) {
                    aVar.a();
                    K b = this.b.b(aVar);
                    if (a2.put(b, this.c.b(aVar)) != null) {
                        throw new t("duplicate key: " + b);
                    }
                    aVar.b();
                }
                aVar.b();
                return a2;
            }
            aVar.c();
            while (aVar.e()) {
                com.bytedance.sdk.openadsdk.preload.a.b.f.f5008a.a(aVar);
                K b2 = this.b.b(aVar);
                if (a2.put(b2, this.c.b(aVar)) != null) {
                    throw new t("duplicate key: " + b2);
                }
            }
            aVar.d();
            return a2;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: com.bytedance.sdk.openadsdk.preload.a.v<V> */
        /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: com.bytedance.sdk.openadsdk.preload.a.v<V> */
        /* JADX WARN: Multi-variable type inference failed */
        public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, Map<K, V> map) throws IOException {
            int i = 0;
            if (map == null) {
                cVar.f();
            } else if (!g.this.f4961a) {
                cVar.d();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    cVar.a(String.valueOf(entry.getKey()));
                    this.c.a(cVar, entry.getValue());
                }
                cVar.e();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                boolean z = false;
                for (Map.Entry<K, V> entry2 : map.entrySet()) {
                    com.bytedance.sdk.openadsdk.preload.a.l a2 = this.b.a(entry2.getKey());
                    arrayList.add(a2);
                    arrayList2.add(entry2.getValue());
                    z = (a2.g() || a2.h()) | z;
                }
                if (z) {
                    cVar.b();
                    int size = arrayList.size();
                    while (i < size) {
                        cVar.b();
                        com.bytedance.sdk.openadsdk.preload.a.b.l.a((com.bytedance.sdk.openadsdk.preload.a.l) arrayList.get(i), cVar);
                        this.c.a(cVar, arrayList2.get(i));
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
                    this.c.a(cVar, arrayList2.get(i));
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
                return "null";
            } else {
                throw new AssertionError();
            }
        }
    }
}
