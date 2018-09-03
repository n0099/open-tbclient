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
    private final com.google.gson.internal.b hFg;
    private final boolean hGw;

    public e(com.google.gson.internal.b bVar, boolean z) {
        this.hFg = bVar;
        this.hGw = z;
    }

    @Override // com.google.gson.n
    public <T> m<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
        Type bKs = aVar.bKs();
        if (!Map.class.isAssignableFrom(aVar.bKr())) {
            return null;
        }
        Type[] b = C$Gson$Types.b(bKs, C$Gson$Types.f(bKs));
        return new a(dVar, b[0], a(dVar, b[0]), b[1], dVar.a(com.google.gson.b.a.l(b[1])), this.hFg.b(aVar));
    }

    private m<?> a(com.google.gson.d dVar, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? k.hGT : dVar.a(com.google.gson.b.a.l(type));
    }

    /* loaded from: classes2.dex */
    private final class a<K, V> extends m<Map<K, V>> {
        private final com.google.gson.internal.d<? extends Map<K, V>> hGn;
        private final m<K> hGx;
        private final m<V> hGy;

        @Override // com.google.gson.m
        public /* bridge */ /* synthetic */ void a(com.google.gson.stream.a aVar, Object obj) throws IOException {
            a(aVar, (Map) ((Map) obj));
        }

        public a(com.google.gson.d dVar, Type type, m<K> mVar, Type type2, m<V> mVar2, com.google.gson.internal.d<? extends Map<K, V>> dVar2) {
            this.hGx = new j(dVar, mVar, type);
            this.hGy = new j(dVar, mVar2, type2);
            this.hGn = dVar2;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.google.gson.m<V> */
        /* JADX DEBUG: Multi-variable search result rejected for r0v14, resolved type: com.google.gson.m<V> */
        /* JADX WARN: Multi-variable type inference failed */
        public void a(com.google.gson.stream.a aVar, Map<K, V> map) throws IOException {
            int i = 0;
            if (map != null) {
                if (!e.this.hGw) {
                    aVar.bKn();
                    for (Map.Entry<K, V> entry : map.entrySet()) {
                        aVar.wE(String.valueOf(entry.getKey()));
                        this.hGy.a(aVar, entry.getValue());
                    }
                    aVar.bKo();
                    return;
                }
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                boolean z = false;
                for (Map.Entry<K, V> entry2 : map.entrySet()) {
                    com.google.gson.h ai = this.hGx.ai(entry2.getKey());
                    arrayList.add(ai);
                    arrayList2.add(entry2.getValue());
                    z = (ai.bJO() || ai.bJP()) | z;
                }
                if (z) {
                    aVar.bKl();
                    while (i < arrayList.size()) {
                        aVar.bKl();
                        com.google.gson.internal.f.b((com.google.gson.h) arrayList.get(i), aVar);
                        this.hGy.a(aVar, arrayList2.get(i));
                        aVar.bKm();
                        i++;
                    }
                    aVar.bKm();
                    return;
                }
                aVar.bKn();
                while (i < arrayList.size()) {
                    aVar.wE(d((com.google.gson.h) arrayList.get(i)));
                    this.hGy.a(aVar, arrayList2.get(i));
                    i++;
                }
                aVar.bKo();
                return;
            }
            aVar.bKp();
        }

        private String d(com.google.gson.h hVar) {
            if (hVar.bJQ()) {
                com.google.gson.k bJU = hVar.bJU();
                if (bJU.bJX()) {
                    return String.valueOf(bJU.bJM());
                }
                if (bJU.bJW()) {
                    return Boolean.toString(bJU.getAsBoolean());
                }
                if (bJU.bJY()) {
                    return bJU.bJN();
                }
                throw new AssertionError();
            } else if (hVar.bJR()) {
                return "null";
            } else {
                throw new AssertionError();
            }
        }
    }
}
