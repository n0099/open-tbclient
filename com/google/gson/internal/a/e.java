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
    private final com.google.gson.internal.b hMC;
    private final boolean hNR;

    public e(com.google.gson.internal.b bVar, boolean z) {
        this.hMC = bVar;
        this.hNR = z;
    }

    @Override // com.google.gson.n
    public <T> m<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
        Type bOI = aVar.bOI();
        if (!Map.class.isAssignableFrom(aVar.bOH())) {
            return null;
        }
        Type[] b = C$Gson$Types.b(bOI, C$Gson$Types.f(bOI));
        return new a(dVar, b[0], a(dVar, b[0]), b[1], dVar.a(com.google.gson.b.a.l(b[1])), this.hMC.b(aVar));
    }

    private m<?> a(com.google.gson.d dVar, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? k.hOo : dVar.a(com.google.gson.b.a.l(type));
    }

    /* loaded from: classes2.dex */
    private final class a<K, V> extends m<Map<K, V>> {
        private final com.google.gson.internal.d<? extends Map<K, V>> hNI;
        private final m<K> hNS;
        private final m<V> hNT;

        @Override // com.google.gson.m
        public /* bridge */ /* synthetic */ void a(com.google.gson.stream.a aVar, Object obj) throws IOException {
            a(aVar, (Map) ((Map) obj));
        }

        public a(com.google.gson.d dVar, Type type, m<K> mVar, Type type2, m<V> mVar2, com.google.gson.internal.d<? extends Map<K, V>> dVar2) {
            this.hNS = new j(dVar, mVar, type);
            this.hNT = new j(dVar, mVar2, type2);
            this.hNI = dVar2;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.google.gson.m<V> */
        /* JADX DEBUG: Multi-variable search result rejected for r0v14, resolved type: com.google.gson.m<V> */
        /* JADX WARN: Multi-variable type inference failed */
        public void a(com.google.gson.stream.a aVar, Map<K, V> map) throws IOException {
            int i = 0;
            if (map != null) {
                if (!e.this.hNR) {
                    aVar.bOD();
                    for (Map.Entry<K, V> entry : map.entrySet()) {
                        aVar.xx(String.valueOf(entry.getKey()));
                        this.hNT.a(aVar, entry.getValue());
                    }
                    aVar.bOE();
                    return;
                }
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                boolean z = false;
                for (Map.Entry<K, V> entry2 : map.entrySet()) {
                    com.google.gson.h aj = this.hNS.aj(entry2.getKey());
                    arrayList.add(aj);
                    arrayList2.add(entry2.getValue());
                    z = (aj.bOe() || aj.bOf()) | z;
                }
                if (z) {
                    aVar.bOB();
                    while (i < arrayList.size()) {
                        aVar.bOB();
                        com.google.gson.internal.f.b((com.google.gson.h) arrayList.get(i), aVar);
                        this.hNT.a(aVar, arrayList2.get(i));
                        aVar.bOC();
                        i++;
                    }
                    aVar.bOC();
                    return;
                }
                aVar.bOD();
                while (i < arrayList.size()) {
                    aVar.xx(d((com.google.gson.h) arrayList.get(i)));
                    this.hNT.a(aVar, arrayList2.get(i));
                    i++;
                }
                aVar.bOE();
                return;
            }
            aVar.bOF();
        }

        private String d(com.google.gson.h hVar) {
            if (hVar.bOg()) {
                com.google.gson.k bOk = hVar.bOk();
                if (bOk.bOn()) {
                    return String.valueOf(bOk.bOc());
                }
                if (bOk.bOm()) {
                    return Boolean.toString(bOk.getAsBoolean());
                }
                if (bOk.bOo()) {
                    return bOk.bOd();
                }
                throw new AssertionError();
            } else if (hVar.bOh()) {
                return "null";
            } else {
                throw new AssertionError();
            }
        }
    }
}
