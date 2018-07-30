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
    private final com.google.gson.internal.b hFz;
    private final boolean hGP;

    public e(com.google.gson.internal.b bVar, boolean z) {
        this.hFz = bVar;
        this.hGP = z;
    }

    @Override // com.google.gson.n
    public <T> m<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
        Type bKB = aVar.bKB();
        if (!Map.class.isAssignableFrom(aVar.bKA())) {
            return null;
        }
        Type[] b = C$Gson$Types.b(bKB, C$Gson$Types.f(bKB));
        return new a(dVar, b[0], a(dVar, b[0]), b[1], dVar.a(com.google.gson.b.a.l(b[1])), this.hFz.b(aVar));
    }

    private m<?> a(com.google.gson.d dVar, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? k.hHm : dVar.a(com.google.gson.b.a.l(type));
    }

    /* loaded from: classes2.dex */
    private final class a<K, V> extends m<Map<K, V>> {
        private final com.google.gson.internal.d<? extends Map<K, V>> hGG;
        private final m<K> hGQ;
        private final m<V> hGR;

        @Override // com.google.gson.m
        public /* bridge */ /* synthetic */ void a(com.google.gson.stream.a aVar, Object obj) throws IOException {
            a(aVar, (Map) ((Map) obj));
        }

        public a(com.google.gson.d dVar, Type type, m<K> mVar, Type type2, m<V> mVar2, com.google.gson.internal.d<? extends Map<K, V>> dVar2) {
            this.hGQ = new j(dVar, mVar, type);
            this.hGR = new j(dVar, mVar2, type2);
            this.hGG = dVar2;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.google.gson.m<V> */
        /* JADX DEBUG: Multi-variable search result rejected for r0v14, resolved type: com.google.gson.m<V> */
        /* JADX WARN: Multi-variable type inference failed */
        public void a(com.google.gson.stream.a aVar, Map<K, V> map) throws IOException {
            int i = 0;
            if (map != null) {
                if (!e.this.hGP) {
                    aVar.bKw();
                    for (Map.Entry<K, V> entry : map.entrySet()) {
                        aVar.wD(String.valueOf(entry.getKey()));
                        this.hGR.a(aVar, entry.getValue());
                    }
                    aVar.bKx();
                    return;
                }
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                boolean z = false;
                for (Map.Entry<K, V> entry2 : map.entrySet()) {
                    com.google.gson.h ai = this.hGQ.ai(entry2.getKey());
                    arrayList.add(ai);
                    arrayList2.add(entry2.getValue());
                    z = (ai.bJX() || ai.bJY()) | z;
                }
                if (z) {
                    aVar.bKu();
                    while (i < arrayList.size()) {
                        aVar.bKu();
                        com.google.gson.internal.f.b((com.google.gson.h) arrayList.get(i), aVar);
                        this.hGR.a(aVar, arrayList2.get(i));
                        aVar.bKv();
                        i++;
                    }
                    aVar.bKv();
                    return;
                }
                aVar.bKw();
                while (i < arrayList.size()) {
                    aVar.wD(d((com.google.gson.h) arrayList.get(i)));
                    this.hGR.a(aVar, arrayList2.get(i));
                    i++;
                }
                aVar.bKx();
                return;
            }
            aVar.bKy();
        }

        private String d(com.google.gson.h hVar) {
            if (hVar.bJZ()) {
                com.google.gson.k bKd = hVar.bKd();
                if (bKd.bKg()) {
                    return String.valueOf(bKd.bJV());
                }
                if (bKd.bKf()) {
                    return Boolean.toString(bKd.getAsBoolean());
                }
                if (bKd.bKh()) {
                    return bKd.bJW();
                }
                throw new AssertionError();
            } else if (hVar.bKa()) {
                return "null";
            } else {
                throw new AssertionError();
            }
        }
    }
}
