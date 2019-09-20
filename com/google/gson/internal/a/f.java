package com.google.gson.internal.a;

import com.google.gson.internal.C$Gson$Types;
import com.google.gson.n;
import com.google.gson.o;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes2.dex */
public final class f implements o {
    private final com.google.gson.internal.b kpW;
    final boolean kry;

    public f(com.google.gson.internal.b bVar, boolean z) {
        this.kpW = bVar;
        this.kry = z;
    }

    @Override // com.google.gson.o
    public <T> n<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
        Type cNI = aVar.cNI();
        if (!Map.class.isAssignableFrom(aVar.cNH())) {
            return null;
        }
        Type[] b = C$Gson$Types.b(cNI, C$Gson$Types.g(cNI));
        return new a(dVar, b[0], a(dVar, b[0]), b[1], dVar.a(com.google.gson.b.a.l(b[1])), this.kpW.b(aVar));
    }

    private n<?> a(com.google.gson.d dVar, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? m.ksb : dVar.a(com.google.gson.b.a.l(type));
    }

    /* loaded from: classes2.dex */
    private final class a<K, V> extends n<Map<K, V>> {
        private final n<V> krA;
        private final com.google.gson.internal.d<? extends Map<K, V>> krr;
        private final n<K> krz;

        @Override // com.google.gson.n
        public /* bridge */ /* synthetic */ void a(com.google.gson.stream.a aVar, Object obj) throws IOException {
            a(aVar, (Map) ((Map) obj));
        }

        public a(com.google.gson.d dVar, Type type, n<K> nVar, Type type2, n<V> nVar2, com.google.gson.internal.d<? extends Map<K, V>> dVar2) {
            this.krz = new l(dVar, nVar, type);
            this.krA = new l(dVar, nVar2, type2);
            this.krr = dVar2;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.google.gson.n<V> */
        /* JADX DEBUG: Multi-variable search result rejected for r0v14, resolved type: com.google.gson.n<V> */
        /* JADX WARN: Multi-variable type inference failed */
        public void a(com.google.gson.stream.a aVar, Map<K, V> map) throws IOException {
            int i = 0;
            if (map == null) {
                aVar.cNG();
            } else if (!f.this.kry) {
                aVar.cNE();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    aVar.Ix(String.valueOf(entry.getKey()));
                    this.krA.a(aVar, entry.getValue());
                }
                aVar.cNF();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                boolean z = false;
                for (Map.Entry<K, V> entry2 : map.entrySet()) {
                    com.google.gson.h be = this.krz.be(entry2.getKey());
                    arrayList.add(be);
                    arrayList2.add(entry2.getValue());
                    z = (be.cMX() || be.cMY()) | z;
                }
                if (z) {
                    aVar.cNC();
                    while (i < arrayList.size()) {
                        aVar.cNC();
                        com.google.gson.internal.f.b((com.google.gson.h) arrayList.get(i), aVar);
                        this.krA.a(aVar, arrayList2.get(i));
                        aVar.cND();
                        i++;
                    }
                    aVar.cND();
                    return;
                }
                aVar.cNE();
                while (i < arrayList.size()) {
                    aVar.Ix(d((com.google.gson.h) arrayList.get(i)));
                    this.krA.a(aVar, arrayList2.get(i));
                    i++;
                }
                aVar.cNF();
            }
        }

        private String d(com.google.gson.h hVar) {
            if (hVar.cMZ()) {
                com.google.gson.k cNd = hVar.cNd();
                if (cNd.cNg()) {
                    return String.valueOf(cNd.cMU());
                }
                if (cNd.cNf()) {
                    return Boolean.toString(cNd.cMW());
                }
                if (cNd.cNh()) {
                    return cNd.cMV();
                }
                throw new AssertionError();
            } else if (hVar.cNa()) {
                return "null";
            } else {
                throw new AssertionError();
            }
        }
    }
}
