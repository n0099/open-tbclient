package com.google.gson.internal.a;

import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.o;
import com.google.gson.p;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes2.dex */
public final class g implements p {
    private final com.google.gson.internal.b isQ;
    final boolean iuB;

    public g(com.google.gson.internal.b bVar, boolean z) {
        this.isQ = bVar;
        this.iuB = z;
    }

    @Override // com.google.gson.p
    public <T> o<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
        Type caT = aVar.caT();
        if (!Map.class.isAssignableFrom(aVar.caS())) {
            return null;
        }
        Type[] b = C$Gson$Types.b(caT, C$Gson$Types.g(caT));
        return new a(dVar, b[0], a(dVar, b[0]), b[1], dVar.a(com.google.gson.b.a.l(b[1])), this.isQ.b(aVar));
    }

    private o<?> a(com.google.gson.d dVar, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? n.ivf : dVar.a(com.google.gson.b.a.l(type));
    }

    /* loaded from: classes2.dex */
    private final class a<K, V> extends o<Map<K, V>> {
        private final o<K> iuC;
        private final o<V> iuD;
        private final com.google.gson.internal.e<? extends Map<K, V>> iun;

        @Override // com.google.gson.o
        public /* bridge */ /* synthetic */ void a(com.google.gson.stream.b bVar, Object obj) throws IOException {
            a(bVar, (Map) ((Map) obj));
        }

        public a(com.google.gson.d dVar, Type type, o<K> oVar, Type type2, o<V> oVar2, com.google.gson.internal.e<? extends Map<K, V>> eVar) {
            this.iuC = new m(dVar, oVar, type);
            this.iuD = new m(dVar, oVar2, type2);
            this.iun = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: k */
        public Map<K, V> b(com.google.gson.stream.a aVar) throws IOException {
            JsonToken caG = aVar.caG();
            if (caG == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            Map<K, V> cau = this.iun.cau();
            if (caG == JsonToken.BEGIN_ARRAY) {
                aVar.beginArray();
                while (aVar.hasNext()) {
                    aVar.beginArray();
                    K b = this.iuC.b(aVar);
                    if (cau.put(b, this.iuD.b(aVar)) != null) {
                        throw new JsonSyntaxException("duplicate key: " + b);
                    }
                    aVar.endArray();
                }
                aVar.endArray();
                return cau;
            }
            aVar.beginObject();
            while (aVar.hasNext()) {
                com.google.gson.internal.d.itC.g(aVar);
                K b2 = this.iuC.b(aVar);
                if (cau.put(b2, this.iuD.b(aVar)) != null) {
                    throw new JsonSyntaxException("duplicate key: " + b2);
                }
            }
            aVar.endObject();
            return cau;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.google.gson.o<V> */
        /* JADX DEBUG: Multi-variable search result rejected for r0v14, resolved type: com.google.gson.o<V> */
        /* JADX WARN: Multi-variable type inference failed */
        public void a(com.google.gson.stream.b bVar, Map<K, V> map) throws IOException {
            int i = 0;
            if (map == null) {
                bVar.caR();
            } else if (!g.this.iuB) {
                bVar.caP();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    bVar.zt(String.valueOf(entry.getKey()));
                    this.iuD.a(bVar, entry.getValue());
                }
                bVar.caQ();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                boolean z = false;
                for (Map.Entry<K, V> entry2 : map.entrySet()) {
                    com.google.gson.i aQ = this.iuC.aQ(entry2.getKey());
                    arrayList.add(aQ);
                    arrayList2.add(entry2.getValue());
                    z = (aQ.cad() || aQ.cae()) | z;
                }
                if (z) {
                    bVar.caN();
                    while (i < arrayList.size()) {
                        bVar.caN();
                        com.google.gson.internal.g.b((com.google.gson.i) arrayList.get(i), bVar);
                        this.iuD.a(bVar, arrayList2.get(i));
                        bVar.caO();
                        i++;
                    }
                    bVar.caO();
                    return;
                }
                bVar.caP();
                while (i < arrayList.size()) {
                    bVar.zt(d((com.google.gson.i) arrayList.get(i)));
                    this.iuD.a(bVar, arrayList2.get(i));
                    i++;
                }
                bVar.caQ();
            }
        }

        private String d(com.google.gson.i iVar) {
            if (iVar.caf()) {
                com.google.gson.l caj = iVar.caj();
                if (caj.cam()) {
                    return String.valueOf(caj.cab());
                }
                if (caj.cal()) {
                    return Boolean.toString(caj.getAsBoolean());
                }
                if (caj.can()) {
                    return caj.cac();
                }
                throw new AssertionError();
            } else if (iVar.cag()) {
                return "null";
            } else {
                throw new AssertionError();
            }
        }
    }
}
