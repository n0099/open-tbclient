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
    private final com.google.gson.internal.b knr;
    final boolean koT;

    public f(com.google.gson.internal.b bVar, boolean z) {
        this.knr = bVar;
        this.koT = z;
    }

    @Override // com.google.gson.o
    public <T> n<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
        Type cKD = aVar.cKD();
        if (!Map.class.isAssignableFrom(aVar.cKC())) {
            return null;
        }
        Type[] b = C$Gson$Types.b(cKD, C$Gson$Types.g(cKD));
        return new a(dVar, b[0], a(dVar, b[0]), b[1], dVar.a(com.google.gson.b.a.l(b[1])), this.knr.b(aVar));
    }

    private n<?> a(com.google.gson.d dVar, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? m.kpw : dVar.a(com.google.gson.b.a.l(type));
    }

    /* loaded from: classes2.dex */
    private final class a<K, V> extends n<Map<K, V>> {
        private final com.google.gson.internal.d<? extends Map<K, V>> koM;
        private final n<K> koU;
        private final n<V> koV;

        @Override // com.google.gson.n
        public /* bridge */ /* synthetic */ void a(com.google.gson.stream.a aVar, Object obj) throws IOException {
            a(aVar, (Map) ((Map) obj));
        }

        public a(com.google.gson.d dVar, Type type, n<K> nVar, Type type2, n<V> nVar2, com.google.gson.internal.d<? extends Map<K, V>> dVar2) {
            this.koU = new l(dVar, nVar, type);
            this.koV = new l(dVar, nVar2, type2);
            this.koM = dVar2;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.google.gson.n<V> */
        /* JADX DEBUG: Multi-variable search result rejected for r0v14, resolved type: com.google.gson.n<V> */
        /* JADX WARN: Multi-variable type inference failed */
        public void a(com.google.gson.stream.a aVar, Map<K, V> map) throws IOException {
            int i = 0;
            if (map == null) {
                aVar.cKB();
            } else if (!f.this.koT) {
                aVar.cKz();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    aVar.GO(String.valueOf(entry.getKey()));
                    this.koV.a(aVar, entry.getValue());
                }
                aVar.cKA();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                boolean z = false;
                for (Map.Entry<K, V> entry2 : map.entrySet()) {
                    com.google.gson.h aZ = this.koU.aZ(entry2.getKey());
                    arrayList.add(aZ);
                    arrayList2.add(entry2.getValue());
                    z = (aZ.cJS() || aZ.cJT()) | z;
                }
                if (z) {
                    aVar.cKx();
                    while (i < arrayList.size()) {
                        aVar.cKx();
                        com.google.gson.internal.f.b((com.google.gson.h) arrayList.get(i), aVar);
                        this.koV.a(aVar, arrayList2.get(i));
                        aVar.cKy();
                        i++;
                    }
                    aVar.cKy();
                    return;
                }
                aVar.cKz();
                while (i < arrayList.size()) {
                    aVar.GO(d((com.google.gson.h) arrayList.get(i)));
                    this.koV.a(aVar, arrayList2.get(i));
                    i++;
                }
                aVar.cKA();
            }
        }

        private String d(com.google.gson.h hVar) {
            if (hVar.cJU()) {
                com.google.gson.k cJY = hVar.cJY();
                if (cJY.cKb()) {
                    return String.valueOf(cJY.cJP());
                }
                if (cJY.cKa()) {
                    return Boolean.toString(cJY.cJR());
                }
                if (cJY.cKc()) {
                    return cJY.cJQ();
                }
                throw new AssertionError();
            } else if (hVar.cJV()) {
                return "null";
            } else {
                throw new AssertionError();
            }
        }
    }
}
