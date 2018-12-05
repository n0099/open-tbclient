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
        Type caU = aVar.caU();
        if (!Map.class.isAssignableFrom(aVar.caT())) {
            return null;
        }
        Type[] b = C$Gson$Types.b(caU, C$Gson$Types.g(caU));
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
            JsonToken caH = aVar.caH();
            if (caH == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            Map<K, V> cav = this.iun.cav();
            if (caH == JsonToken.BEGIN_ARRAY) {
                aVar.beginArray();
                while (aVar.hasNext()) {
                    aVar.beginArray();
                    K b = this.iuC.b(aVar);
                    if (cav.put(b, this.iuD.b(aVar)) != null) {
                        throw new JsonSyntaxException("duplicate key: " + b);
                    }
                    aVar.endArray();
                }
                aVar.endArray();
                return cav;
            }
            aVar.beginObject();
            while (aVar.hasNext()) {
                com.google.gson.internal.d.itC.g(aVar);
                K b2 = this.iuC.b(aVar);
                if (cav.put(b2, this.iuD.b(aVar)) != null) {
                    throw new JsonSyntaxException("duplicate key: " + b2);
                }
            }
            aVar.endObject();
            return cav;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.google.gson.o<V> */
        /* JADX DEBUG: Multi-variable search result rejected for r0v14, resolved type: com.google.gson.o<V> */
        /* JADX WARN: Multi-variable type inference failed */
        public void a(com.google.gson.stream.b bVar, Map<K, V> map) throws IOException {
            int i = 0;
            if (map == null) {
                bVar.caS();
            } else if (!g.this.iuB) {
                bVar.caQ();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    bVar.zt(String.valueOf(entry.getKey()));
                    this.iuD.a(bVar, entry.getValue());
                }
                bVar.caR();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                boolean z = false;
                for (Map.Entry<K, V> entry2 : map.entrySet()) {
                    com.google.gson.i aQ = this.iuC.aQ(entry2.getKey());
                    arrayList.add(aQ);
                    arrayList2.add(entry2.getValue());
                    z = (aQ.cae() || aQ.caf()) | z;
                }
                if (z) {
                    bVar.caO();
                    while (i < arrayList.size()) {
                        bVar.caO();
                        com.google.gson.internal.g.b((com.google.gson.i) arrayList.get(i), bVar);
                        this.iuD.a(bVar, arrayList2.get(i));
                        bVar.caP();
                        i++;
                    }
                    bVar.caP();
                    return;
                }
                bVar.caQ();
                while (i < arrayList.size()) {
                    bVar.zt(d((com.google.gson.i) arrayList.get(i)));
                    this.iuD.a(bVar, arrayList2.get(i));
                    i++;
                }
                bVar.caR();
            }
        }

        private String d(com.google.gson.i iVar) {
            if (iVar.cag()) {
                com.google.gson.l cak = iVar.cak();
                if (cak.can()) {
                    return String.valueOf(cak.cac());
                }
                if (cak.cam()) {
                    return Boolean.toString(cak.getAsBoolean());
                }
                if (cak.cao()) {
                    return cak.cad();
                }
                throw new AssertionError();
            } else if (iVar.cah()) {
                return "null";
            } else {
                throw new AssertionError();
            }
        }
    }
}
