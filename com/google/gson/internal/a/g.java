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
    private final com.google.gson.internal.b jMz;
    final boolean jOj;

    public g(com.google.gson.internal.b bVar, boolean z) {
        this.jMz = bVar;
        this.jOj = z;
    }

    @Override // com.google.gson.p
    public <T> o<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
        Type cBD = aVar.cBD();
        if (!Map.class.isAssignableFrom(aVar.cBC())) {
            return null;
        }
        Type[] b = C$Gson$Types.b(cBD, C$Gson$Types.g(cBD));
        return new a(dVar, b[0], a(dVar, b[0]), b[1], dVar.a(com.google.gson.b.a.l(b[1])), this.jMz.b(aVar));
    }

    private o<?> a(com.google.gson.d dVar, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? n.jON : dVar.a(com.google.gson.b.a.l(type));
    }

    /* loaded from: classes2.dex */
    private final class a<K, V> extends o<Map<K, V>> {
        private final com.google.gson.internal.e<? extends Map<K, V>> jNW;
        private final o<K> jOk;
        private final o<V> jOl;

        @Override // com.google.gson.o
        public /* bridge */ /* synthetic */ void a(com.google.gson.stream.b bVar, Object obj) throws IOException {
            a(bVar, (Map) ((Map) obj));
        }

        public a(com.google.gson.d dVar, Type type, o<K> oVar, Type type2, o<V> oVar2, com.google.gson.internal.e<? extends Map<K, V>> eVar) {
            this.jOk = new m(dVar, oVar, type);
            this.jOl = new m(dVar, oVar2, type2);
            this.jNW = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: k */
        public Map<K, V> b(com.google.gson.stream.a aVar) throws IOException {
            JsonToken cBq = aVar.cBq();
            if (cBq == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            Map<K, V> cBe = this.jNW.cBe();
            if (cBq == JsonToken.BEGIN_ARRAY) {
                aVar.beginArray();
                while (aVar.hasNext()) {
                    aVar.beginArray();
                    K b = this.jOk.b(aVar);
                    if (cBe.put(b, this.jOl.b(aVar)) != null) {
                        throw new JsonSyntaxException("duplicate key: " + b);
                    }
                    aVar.endArray();
                }
                aVar.endArray();
                return cBe;
            }
            aVar.beginObject();
            while (aVar.hasNext()) {
                com.google.gson.internal.d.jNl.g(aVar);
                K b2 = this.jOk.b(aVar);
                if (cBe.put(b2, this.jOl.b(aVar)) != null) {
                    throw new JsonSyntaxException("duplicate key: " + b2);
                }
            }
            aVar.endObject();
            return cBe;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.google.gson.o<V> */
        /* JADX DEBUG: Multi-variable search result rejected for r0v14, resolved type: com.google.gson.o<V> */
        /* JADX WARN: Multi-variable type inference failed */
        public void a(com.google.gson.stream.b bVar, Map<K, V> map) throws IOException {
            int i = 0;
            if (map == null) {
                bVar.cBB();
            } else if (!g.this.jOj) {
                bVar.cBz();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    bVar.FG(String.valueOf(entry.getKey()));
                    this.jOl.a(bVar, entry.getValue());
                }
                bVar.cBA();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                boolean z = false;
                for (Map.Entry<K, V> entry2 : map.entrySet()) {
                    com.google.gson.i bc = this.jOk.bc(entry2.getKey());
                    arrayList.add(bc);
                    arrayList2.add(entry2.getValue());
                    z = (bc.cAN() || bc.cAO()) | z;
                }
                if (z) {
                    bVar.cBx();
                    while (i < arrayList.size()) {
                        bVar.cBx();
                        com.google.gson.internal.g.b((com.google.gson.i) arrayList.get(i), bVar);
                        this.jOl.a(bVar, arrayList2.get(i));
                        bVar.cBy();
                        i++;
                    }
                    bVar.cBy();
                    return;
                }
                bVar.cBz();
                while (i < arrayList.size()) {
                    bVar.FG(d((com.google.gson.i) arrayList.get(i)));
                    this.jOl.a(bVar, arrayList2.get(i));
                    i++;
                }
                bVar.cBA();
            }
        }

        private String d(com.google.gson.i iVar) {
            if (iVar.cAP()) {
                com.google.gson.l cAT = iVar.cAT();
                if (cAT.cAW()) {
                    return String.valueOf(cAT.cAL());
                }
                if (cAT.cAV()) {
                    return Boolean.toString(cAT.getAsBoolean());
                }
                if (cAT.cAX()) {
                    return cAT.cAM();
                }
                throw new AssertionError();
            } else if (iVar.cAQ()) {
                return "null";
            } else {
                throw new AssertionError();
            }
        }
    }
}
