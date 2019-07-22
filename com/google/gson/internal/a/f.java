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
    private final com.google.gson.internal.b kmt;
    final boolean knV;

    public f(com.google.gson.internal.b bVar, boolean z) {
        this.kmt = bVar;
        this.knV = z;
    }

    @Override // com.google.gson.o
    public <T> n<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
        Type cMz = aVar.cMz();
        if (!Map.class.isAssignableFrom(aVar.cMy())) {
            return null;
        }
        Type[] b = C$Gson$Types.b(cMz, C$Gson$Types.g(cMz));
        return new a(dVar, b[0], a(dVar, b[0]), b[1], dVar.a(com.google.gson.b.a.l(b[1])), this.kmt.b(aVar));
    }

    private n<?> a(com.google.gson.d dVar, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? m.koy : dVar.a(com.google.gson.b.a.l(type));
    }

    /* loaded from: classes2.dex */
    private final class a<K, V> extends n<Map<K, V>> {
        private final com.google.gson.internal.d<? extends Map<K, V>> knO;
        private final n<K> knW;
        private final n<V> knX;

        @Override // com.google.gson.n
        public /* bridge */ /* synthetic */ void a(com.google.gson.stream.a aVar, Object obj) throws IOException {
            a(aVar, (Map) ((Map) obj));
        }

        public a(com.google.gson.d dVar, Type type, n<K> nVar, Type type2, n<V> nVar2, com.google.gson.internal.d<? extends Map<K, V>> dVar2) {
            this.knW = new l(dVar, nVar, type);
            this.knX = new l(dVar, nVar2, type2);
            this.knO = dVar2;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.google.gson.n<V> */
        /* JADX DEBUG: Multi-variable search result rejected for r0v14, resolved type: com.google.gson.n<V> */
        /* JADX WARN: Multi-variable type inference failed */
        public void a(com.google.gson.stream.a aVar, Map<K, V> map) throws IOException {
            int i = 0;
            if (map == null) {
                aVar.cMx();
            } else if (!f.this.knV) {
                aVar.cMv();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    aVar.HW(String.valueOf(entry.getKey()));
                    this.knX.a(aVar, entry.getValue());
                }
                aVar.cMw();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                boolean z = false;
                for (Map.Entry<K, V> entry2 : map.entrySet()) {
                    com.google.gson.h be = this.knW.be(entry2.getKey());
                    arrayList.add(be);
                    arrayList2.add(entry2.getValue());
                    z = (be.cLO() || be.cLP()) | z;
                }
                if (z) {
                    aVar.cMt();
                    while (i < arrayList.size()) {
                        aVar.cMt();
                        com.google.gson.internal.f.b((com.google.gson.h) arrayList.get(i), aVar);
                        this.knX.a(aVar, arrayList2.get(i));
                        aVar.cMu();
                        i++;
                    }
                    aVar.cMu();
                    return;
                }
                aVar.cMv();
                while (i < arrayList.size()) {
                    aVar.HW(d((com.google.gson.h) arrayList.get(i)));
                    this.knX.a(aVar, arrayList2.get(i));
                    i++;
                }
                aVar.cMw();
            }
        }

        private String d(com.google.gson.h hVar) {
            if (hVar.cLQ()) {
                com.google.gson.k cLU = hVar.cLU();
                if (cLU.cLX()) {
                    return String.valueOf(cLU.cLL());
                }
                if (cLU.cLW()) {
                    return Boolean.toString(cLU.cLN());
                }
                if (cLU.cLY()) {
                    return cLU.cLM();
                }
                throw new AssertionError();
            } else if (hVar.cLR()) {
                return "null";
            } else {
                throw new AssertionError();
            }
        }
    }
}
