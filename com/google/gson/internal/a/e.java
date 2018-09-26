package com.google.gson.internal.a;

import com.google.gson.internal.C$Gson$Types;
import com.google.gson.m;
import com.google.gson.n;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes2.dex */
public final class e implements n {
    private final com.google.gson.internal.b hNA;
    private final boolean hOQ;

    public e(com.google.gson.internal.b bVar, boolean z) {
        this.hNA = bVar;
        this.hOQ = z;
    }

    @Override // com.google.gson.n
    public <T> m<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
        Type bNj = aVar.bNj();
        if (!Map.class.isAssignableFrom(aVar.bNi())) {
            return null;
        }
        Type[] b = C$Gson$Types.b(bNj, C$Gson$Types.f(bNj));
        return new a(dVar, b[0], a(dVar, b[0]), b[1], dVar.a(com.google.gson.b.a.l(b[1])), this.hNA.b(aVar));
    }

    private m<?> a(com.google.gson.d dVar, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? k.hPn : dVar.a(com.google.gson.b.a.l(type));
    }

    /* loaded from: classes2.dex */
    private final class a<K, V> extends m<Map<K, V>> {
        private final com.google.gson.internal.d<? extends Map<K, V>> hOH;
        private final m<K> hOR;
        private final m<V> hOS;

        @Override // com.google.gson.m
        public /* bridge */ /* synthetic */ void a(com.google.gson.stream.a aVar, Object obj) throws IOException {
            a(aVar, (Map) ((Map) obj));
        }

        public a(com.google.gson.d dVar, Type type, m<K> mVar, Type type2, m<V> mVar2, com.google.gson.internal.d<? extends Map<K, V>> dVar2) {
            this.hOR = new j(dVar, mVar, type);
            this.hOS = new j(dVar, mVar2, type2);
            this.hOH = dVar2;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.google.gson.m<V> */
        /* JADX DEBUG: Multi-variable search result rejected for r0v14, resolved type: com.google.gson.m<V> */
        /* JADX WARN: Multi-variable type inference failed */
        public void a(com.google.gson.stream.a aVar, Map<K, V> map) throws IOException {
            int i = 0;
            if (map != null) {
                if (!e.this.hOQ) {
                    aVar.bNe();
                    for (Map.Entry<K, V> entry : map.entrySet()) {
                        aVar.xp(String.valueOf(entry.getKey()));
                        this.hOS.a(aVar, entry.getValue());
                    }
                    aVar.bNf();
                    return;
                }
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                boolean z = false;
                for (Map.Entry<K, V> entry2 : map.entrySet()) {
                    com.google.gson.h al = this.hOR.al(entry2.getKey());
                    arrayList.add(al);
                    arrayList2.add(entry2.getValue());
                    z = (al.bMF() || al.bMG()) | z;
                }
                if (z) {
                    aVar.bNc();
                    while (i < arrayList.size()) {
                        aVar.bNc();
                        com.google.gson.internal.f.b((com.google.gson.h) arrayList.get(i), aVar);
                        this.hOS.a(aVar, arrayList2.get(i));
                        aVar.bNd();
                        i++;
                    }
                    aVar.bNd();
                    return;
                }
                aVar.bNe();
                while (i < arrayList.size()) {
                    aVar.xp(d((com.google.gson.h) arrayList.get(i)));
                    this.hOS.a(aVar, arrayList2.get(i));
                    i++;
                }
                aVar.bNf();
                return;
            }
            aVar.bNg();
        }

        private String d(com.google.gson.h hVar) {
            if (hVar.bMH()) {
                com.google.gson.k bML = hVar.bML();
                if (bML.bMO()) {
                    return String.valueOf(bML.bMD());
                }
                if (bML.bMN()) {
                    return Boolean.toString(bML.getAsBoolean());
                }
                if (bML.bMP()) {
                    return bML.bME();
                }
                throw new AssertionError();
            } else if (hVar.bMI()) {
                return "null";
            } else {
                throw new AssertionError();
            }
        }
    }
}
