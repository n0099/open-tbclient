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
    private final com.google.gson.internal.b kfn;
    final boolean kgP;

    public f(com.google.gson.internal.b bVar, boolean z) {
        this.kfn = bVar;
        this.kgP = z;
    }

    @Override // com.google.gson.o
    public <T> n<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
        Type cJt = aVar.cJt();
        if (!Map.class.isAssignableFrom(aVar.cJs())) {
            return null;
        }
        Type[] b = C$Gson$Types.b(cJt, C$Gson$Types.g(cJt));
        return new a(dVar, b[0], a(dVar, b[0]), b[1], dVar.a(com.google.gson.b.a.l(b[1])), this.kfn.b(aVar));
    }

    private n<?> a(com.google.gson.d dVar, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? m.khs : dVar.a(com.google.gson.b.a.l(type));
    }

    /* loaded from: classes2.dex */
    private final class a<K, V> extends n<Map<K, V>> {
        private final com.google.gson.internal.d<? extends Map<K, V>> kgI;
        private final n<K> kgQ;
        private final n<V> kgR;

        @Override // com.google.gson.n
        public /* bridge */ /* synthetic */ void a(com.google.gson.stream.a aVar, Object obj) throws IOException {
            a(aVar, (Map) ((Map) obj));
        }

        public a(com.google.gson.d dVar, Type type, n<K> nVar, Type type2, n<V> nVar2, com.google.gson.internal.d<? extends Map<K, V>> dVar2) {
            this.kgQ = new l(dVar, nVar, type);
            this.kgR = new l(dVar, nVar2, type2);
            this.kgI = dVar2;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.google.gson.n<V> */
        /* JADX DEBUG: Multi-variable search result rejected for r0v14, resolved type: com.google.gson.n<V> */
        /* JADX WARN: Multi-variable type inference failed */
        public void a(com.google.gson.stream.a aVar, Map<K, V> map) throws IOException {
            int i = 0;
            if (map == null) {
                aVar.cJr();
            } else if (!f.this.kgP) {
                aVar.cJp();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    aVar.Hc(String.valueOf(entry.getKey()));
                    this.kgR.a(aVar, entry.getValue());
                }
                aVar.cJq();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                boolean z = false;
                for (Map.Entry<K, V> entry2 : map.entrySet()) {
                    com.google.gson.h be = this.kgQ.be(entry2.getKey());
                    arrayList.add(be);
                    arrayList2.add(entry2.getValue());
                    z = (be.cII() || be.cIJ()) | z;
                }
                if (z) {
                    aVar.cJn();
                    while (i < arrayList.size()) {
                        aVar.cJn();
                        com.google.gson.internal.f.b((com.google.gson.h) arrayList.get(i), aVar);
                        this.kgR.a(aVar, arrayList2.get(i));
                        aVar.cJo();
                        i++;
                    }
                    aVar.cJo();
                    return;
                }
                aVar.cJp();
                while (i < arrayList.size()) {
                    aVar.Hc(d((com.google.gson.h) arrayList.get(i)));
                    this.kgR.a(aVar, arrayList2.get(i));
                    i++;
                }
                aVar.cJq();
            }
        }

        private String d(com.google.gson.h hVar) {
            if (hVar.cIK()) {
                com.google.gson.k cIO = hVar.cIO();
                if (cIO.cIR()) {
                    return String.valueOf(cIO.cIG());
                }
                if (cIO.cIQ()) {
                    return Boolean.toString(cIO.getAsBoolean());
                }
                if (cIO.cIS()) {
                    return cIO.cIH();
                }
                throw new AssertionError();
            } else if (hVar.cIL()) {
                return "null";
            } else {
                throw new AssertionError();
            }
        }
    }
}
