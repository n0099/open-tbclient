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
    private final com.google.gson.internal.b kfj;
    final boolean kgL;

    public f(com.google.gson.internal.b bVar, boolean z) {
        this.kfj = bVar;
        this.kgL = z;
    }

    @Override // com.google.gson.o
    public <T> n<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
        Type cJs = aVar.cJs();
        if (!Map.class.isAssignableFrom(aVar.cJr())) {
            return null;
        }
        Type[] b = C$Gson$Types.b(cJs, C$Gson$Types.g(cJs));
        return new a(dVar, b[0], a(dVar, b[0]), b[1], dVar.a(com.google.gson.b.a.l(b[1])), this.kfj.b(aVar));
    }

    private n<?> a(com.google.gson.d dVar, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? m.kho : dVar.a(com.google.gson.b.a.l(type));
    }

    /* loaded from: classes2.dex */
    private final class a<K, V> extends n<Map<K, V>> {
        private final com.google.gson.internal.d<? extends Map<K, V>> kgE;
        private final n<K> kgM;
        private final n<V> kgN;

        @Override // com.google.gson.n
        public /* bridge */ /* synthetic */ void a(com.google.gson.stream.a aVar, Object obj) throws IOException {
            a(aVar, (Map) ((Map) obj));
        }

        public a(com.google.gson.d dVar, Type type, n<K> nVar, Type type2, n<V> nVar2, com.google.gson.internal.d<? extends Map<K, V>> dVar2) {
            this.kgM = new l(dVar, nVar, type);
            this.kgN = new l(dVar, nVar2, type2);
            this.kgE = dVar2;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.google.gson.n<V> */
        /* JADX DEBUG: Multi-variable search result rejected for r0v14, resolved type: com.google.gson.n<V> */
        /* JADX WARN: Multi-variable type inference failed */
        public void a(com.google.gson.stream.a aVar, Map<K, V> map) throws IOException {
            int i = 0;
            if (map == null) {
                aVar.cJq();
            } else if (!f.this.kgL) {
                aVar.cJo();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    aVar.Ha(String.valueOf(entry.getKey()));
                    this.kgN.a(aVar, entry.getValue());
                }
                aVar.cJp();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                boolean z = false;
                for (Map.Entry<K, V> entry2 : map.entrySet()) {
                    com.google.gson.h be = this.kgM.be(entry2.getKey());
                    arrayList.add(be);
                    arrayList2.add(entry2.getValue());
                    z = (be.cIH() || be.cII()) | z;
                }
                if (z) {
                    aVar.cJm();
                    while (i < arrayList.size()) {
                        aVar.cJm();
                        com.google.gson.internal.f.b((com.google.gson.h) arrayList.get(i), aVar);
                        this.kgN.a(aVar, arrayList2.get(i));
                        aVar.cJn();
                        i++;
                    }
                    aVar.cJn();
                    return;
                }
                aVar.cJo();
                while (i < arrayList.size()) {
                    aVar.Ha(d((com.google.gson.h) arrayList.get(i)));
                    this.kgN.a(aVar, arrayList2.get(i));
                    i++;
                }
                aVar.cJp();
            }
        }

        private String d(com.google.gson.h hVar) {
            if (hVar.cIJ()) {
                com.google.gson.k cIN = hVar.cIN();
                if (cIN.cIQ()) {
                    return String.valueOf(cIN.cIF());
                }
                if (cIN.cIP()) {
                    return Boolean.toString(cIN.getAsBoolean());
                }
                if (cIN.cIR()) {
                    return cIN.cIG();
                }
                throw new AssertionError();
            } else if (hVar.cIK()) {
                return "null";
            } else {
                throw new AssertionError();
            }
        }
    }
}
