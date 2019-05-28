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
    private final com.google.gson.internal.b kfk;
    final boolean kgM;

    public f(com.google.gson.internal.b bVar, boolean z) {
        this.kfk = bVar;
        this.kgM = z;
    }

    @Override // com.google.gson.o
    public <T> n<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
        Type cJu = aVar.cJu();
        if (!Map.class.isAssignableFrom(aVar.cJt())) {
            return null;
        }
        Type[] b = C$Gson$Types.b(cJu, C$Gson$Types.g(cJu));
        return new a(dVar, b[0], a(dVar, b[0]), b[1], dVar.a(com.google.gson.b.a.l(b[1])), this.kfk.b(aVar));
    }

    private n<?> a(com.google.gson.d dVar, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? m.khp : dVar.a(com.google.gson.b.a.l(type));
    }

    /* loaded from: classes2.dex */
    private final class a<K, V> extends n<Map<K, V>> {
        private final com.google.gson.internal.d<? extends Map<K, V>> kgF;
        private final n<K> kgN;
        private final n<V> kgO;

        @Override // com.google.gson.n
        public /* bridge */ /* synthetic */ void a(com.google.gson.stream.a aVar, Object obj) throws IOException {
            a(aVar, (Map) ((Map) obj));
        }

        public a(com.google.gson.d dVar, Type type, n<K> nVar, Type type2, n<V> nVar2, com.google.gson.internal.d<? extends Map<K, V>> dVar2) {
            this.kgN = new l(dVar, nVar, type);
            this.kgO = new l(dVar, nVar2, type2);
            this.kgF = dVar2;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.google.gson.n<V> */
        /* JADX DEBUG: Multi-variable search result rejected for r0v14, resolved type: com.google.gson.n<V> */
        /* JADX WARN: Multi-variable type inference failed */
        public void a(com.google.gson.stream.a aVar, Map<K, V> map) throws IOException {
            int i = 0;
            if (map == null) {
                aVar.cJs();
            } else if (!f.this.kgM) {
                aVar.cJq();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    aVar.Ha(String.valueOf(entry.getKey()));
                    this.kgO.a(aVar, entry.getValue());
                }
                aVar.cJr();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                boolean z = false;
                for (Map.Entry<K, V> entry2 : map.entrySet()) {
                    com.google.gson.h be = this.kgN.be(entry2.getKey());
                    arrayList.add(be);
                    arrayList2.add(entry2.getValue());
                    z = (be.cIJ() || be.cIK()) | z;
                }
                if (z) {
                    aVar.cJo();
                    while (i < arrayList.size()) {
                        aVar.cJo();
                        com.google.gson.internal.f.b((com.google.gson.h) arrayList.get(i), aVar);
                        this.kgO.a(aVar, arrayList2.get(i));
                        aVar.cJp();
                        i++;
                    }
                    aVar.cJp();
                    return;
                }
                aVar.cJq();
                while (i < arrayList.size()) {
                    aVar.Ha(d((com.google.gson.h) arrayList.get(i)));
                    this.kgO.a(aVar, arrayList2.get(i));
                    i++;
                }
                aVar.cJr();
            }
        }

        private String d(com.google.gson.h hVar) {
            if (hVar.cIL()) {
                com.google.gson.k cIP = hVar.cIP();
                if (cIP.cIS()) {
                    return String.valueOf(cIP.cIH());
                }
                if (cIP.cIR()) {
                    return Boolean.toString(cIP.getAsBoolean());
                }
                if (cIP.cIT()) {
                    return cIP.cII();
                }
                throw new AssertionError();
            } else if (hVar.cIM()) {
                return "null";
            } else {
                throw new AssertionError();
            }
        }
    }
}
