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
    private final com.google.gson.internal.b koi;
    final boolean kpK;

    public f(com.google.gson.internal.b bVar, boolean z) {
        this.koi = bVar;
        this.kpK = z;
    }

    @Override // com.google.gson.o
    public <T> n<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
        Type cKF = aVar.cKF();
        if (!Map.class.isAssignableFrom(aVar.cKE())) {
            return null;
        }
        Type[] b = C$Gson$Types.b(cKF, C$Gson$Types.g(cKF));
        return new a(dVar, b[0], a(dVar, b[0]), b[1], dVar.a(com.google.gson.b.a.l(b[1])), this.koi.b(aVar));
    }

    private n<?> a(com.google.gson.d dVar, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? m.kqn : dVar.a(com.google.gson.b.a.l(type));
    }

    /* loaded from: classes2.dex */
    private final class a<K, V> extends n<Map<K, V>> {
        private final com.google.gson.internal.d<? extends Map<K, V>> kpD;
        private final n<K> kpL;
        private final n<V> kpM;

        @Override // com.google.gson.n
        public /* bridge */ /* synthetic */ void a(com.google.gson.stream.a aVar, Object obj) throws IOException {
            a(aVar, (Map) ((Map) obj));
        }

        public a(com.google.gson.d dVar, Type type, n<K> nVar, Type type2, n<V> nVar2, com.google.gson.internal.d<? extends Map<K, V>> dVar2) {
            this.kpL = new l(dVar, nVar, type);
            this.kpM = new l(dVar, nVar2, type2);
            this.kpD = dVar2;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.google.gson.n<V> */
        /* JADX DEBUG: Multi-variable search result rejected for r0v14, resolved type: com.google.gson.n<V> */
        /* JADX WARN: Multi-variable type inference failed */
        public void a(com.google.gson.stream.a aVar, Map<K, V> map) throws IOException {
            int i = 0;
            if (map == null) {
                aVar.cKD();
            } else if (!f.this.kpK) {
                aVar.cKB();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    aVar.GO(String.valueOf(entry.getKey()));
                    this.kpM.a(aVar, entry.getValue());
                }
                aVar.cKC();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                boolean z = false;
                for (Map.Entry<K, V> entry2 : map.entrySet()) {
                    com.google.gson.h aZ = this.kpL.aZ(entry2.getKey());
                    arrayList.add(aZ);
                    arrayList2.add(entry2.getValue());
                    z = (aZ.cJU() || aZ.cJV()) | z;
                }
                if (z) {
                    aVar.cKz();
                    while (i < arrayList.size()) {
                        aVar.cKz();
                        com.google.gson.internal.f.b((com.google.gson.h) arrayList.get(i), aVar);
                        this.kpM.a(aVar, arrayList2.get(i));
                        aVar.cKA();
                        i++;
                    }
                    aVar.cKA();
                    return;
                }
                aVar.cKB();
                while (i < arrayList.size()) {
                    aVar.GO(d((com.google.gson.h) arrayList.get(i)));
                    this.kpM.a(aVar, arrayList2.get(i));
                    i++;
                }
                aVar.cKC();
            }
        }

        private String d(com.google.gson.h hVar) {
            if (hVar.cJW()) {
                com.google.gson.k cKa = hVar.cKa();
                if (cKa.cKd()) {
                    return String.valueOf(cKa.cJR());
                }
                if (cKa.cKc()) {
                    return Boolean.toString(cKa.cJT());
                }
                if (cKa.cKe()) {
                    return cKa.cJS();
                }
                throw new AssertionError();
            } else if (hVar.cJX()) {
                return "null";
            } else {
                throw new AssertionError();
            }
        }
    }
}
