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
    private final com.google.gson.internal.b knz;
    final boolean kpb;

    public f(com.google.gson.internal.b bVar, boolean z) {
        this.knz = bVar;
        this.kpb = z;
    }

    @Override // com.google.gson.o
    public <T> n<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
        Type cMU = aVar.cMU();
        if (!Map.class.isAssignableFrom(aVar.cMT())) {
            return null;
        }
        Type[] b = C$Gson$Types.b(cMU, C$Gson$Types.g(cMU));
        return new a(dVar, b[0], a(dVar, b[0]), b[1], dVar.a(com.google.gson.b.a.l(b[1])), this.knz.b(aVar));
    }

    private n<?> a(com.google.gson.d dVar, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? m.kpE : dVar.a(com.google.gson.b.a.l(type));
    }

    /* loaded from: classes2.dex */
    private final class a<K, V> extends n<Map<K, V>> {
        private final com.google.gson.internal.d<? extends Map<K, V>> koU;
        private final n<K> kpc;
        private final n<V> kpd;

        @Override // com.google.gson.n
        public /* bridge */ /* synthetic */ void a(com.google.gson.stream.a aVar, Object obj) throws IOException {
            a(aVar, (Map) ((Map) obj));
        }

        public a(com.google.gson.d dVar, Type type, n<K> nVar, Type type2, n<V> nVar2, com.google.gson.internal.d<? extends Map<K, V>> dVar2) {
            this.kpc = new l(dVar, nVar, type);
            this.kpd = new l(dVar, nVar2, type2);
            this.koU = dVar2;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.google.gson.n<V> */
        /* JADX DEBUG: Multi-variable search result rejected for r0v14, resolved type: com.google.gson.n<V> */
        /* JADX WARN: Multi-variable type inference failed */
        public void a(com.google.gson.stream.a aVar, Map<K, V> map) throws IOException {
            int i = 0;
            if (map == null) {
                aVar.cMS();
            } else if (!f.this.kpb) {
                aVar.cMQ();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    aVar.HX(String.valueOf(entry.getKey()));
                    this.kpd.a(aVar, entry.getValue());
                }
                aVar.cMR();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                boolean z = false;
                for (Map.Entry<K, V> entry2 : map.entrySet()) {
                    com.google.gson.h be = this.kpc.be(entry2.getKey());
                    arrayList.add(be);
                    arrayList2.add(entry2.getValue());
                    z = (be.cMj() || be.cMk()) | z;
                }
                if (z) {
                    aVar.cMO();
                    while (i < arrayList.size()) {
                        aVar.cMO();
                        com.google.gson.internal.f.b((com.google.gson.h) arrayList.get(i), aVar);
                        this.kpd.a(aVar, arrayList2.get(i));
                        aVar.cMP();
                        i++;
                    }
                    aVar.cMP();
                    return;
                }
                aVar.cMQ();
                while (i < arrayList.size()) {
                    aVar.HX(d((com.google.gson.h) arrayList.get(i)));
                    this.kpd.a(aVar, arrayList2.get(i));
                    i++;
                }
                aVar.cMR();
            }
        }

        private String d(com.google.gson.h hVar) {
            if (hVar.cMl()) {
                com.google.gson.k cMp = hVar.cMp();
                if (cMp.cMs()) {
                    return String.valueOf(cMp.cMg());
                }
                if (cMp.cMr()) {
                    return Boolean.toString(cMp.cMi());
                }
                if (cMp.cMt()) {
                    return cMp.cMh();
                }
                throw new AssertionError();
            } else if (hVar.cMm()) {
                return "null";
            } else {
                throw new AssertionError();
            }
        }
    }
}
