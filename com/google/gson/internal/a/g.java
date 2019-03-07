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
    private final com.google.gson.internal.b jMT;
    final boolean jOE;

    public g(com.google.gson.internal.b bVar, boolean z) {
        this.jMT = bVar;
        this.jOE = z;
    }

    @Override // com.google.gson.p
    public <T> o<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
        Type cBx = aVar.cBx();
        if (!Map.class.isAssignableFrom(aVar.cBw())) {
            return null;
        }
        Type[] b = C$Gson$Types.b(cBx, C$Gson$Types.g(cBx));
        return new a(dVar, b[0], a(dVar, b[0]), b[1], dVar.a(com.google.gson.b.a.l(b[1])), this.jMT.b(aVar));
    }

    private o<?> a(com.google.gson.d dVar, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? n.jPi : dVar.a(com.google.gson.b.a.l(type));
    }

    /* loaded from: classes2.dex */
    private final class a<K, V> extends o<Map<K, V>> {
        private final o<K> jOF;
        private final o<V> jOG;
        private final com.google.gson.internal.e<? extends Map<K, V>> jOq;

        @Override // com.google.gson.o
        public /* bridge */ /* synthetic */ void a(com.google.gson.stream.b bVar, Object obj) throws IOException {
            a(bVar, (Map) ((Map) obj));
        }

        public a(com.google.gson.d dVar, Type type, o<K> oVar, Type type2, o<V> oVar2, com.google.gson.internal.e<? extends Map<K, V>> eVar) {
            this.jOF = new m(dVar, oVar, type);
            this.jOG = new m(dVar, oVar2, type2);
            this.jOq = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: k */
        public Map<K, V> b(com.google.gson.stream.a aVar) throws IOException {
            JsonToken cBk = aVar.cBk();
            if (cBk == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            Map<K, V> cAY = this.jOq.cAY();
            if (cBk == JsonToken.BEGIN_ARRAY) {
                aVar.beginArray();
                while (aVar.hasNext()) {
                    aVar.beginArray();
                    K b = this.jOF.b(aVar);
                    if (cAY.put(b, this.jOG.b(aVar)) != null) {
                        throw new JsonSyntaxException("duplicate key: " + b);
                    }
                    aVar.endArray();
                }
                aVar.endArray();
                return cAY;
            }
            aVar.beginObject();
            while (aVar.hasNext()) {
                com.google.gson.internal.d.jNF.g(aVar);
                K b2 = this.jOF.b(aVar);
                if (cAY.put(b2, this.jOG.b(aVar)) != null) {
                    throw new JsonSyntaxException("duplicate key: " + b2);
                }
            }
            aVar.endObject();
            return cAY;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.google.gson.o<V> */
        /* JADX DEBUG: Multi-variable search result rejected for r0v14, resolved type: com.google.gson.o<V> */
        /* JADX WARN: Multi-variable type inference failed */
        public void a(com.google.gson.stream.b bVar, Map<K, V> map) throws IOException {
            int i = 0;
            if (map == null) {
                bVar.cBv();
            } else if (!g.this.jOE) {
                bVar.cBt();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    bVar.FP(String.valueOf(entry.getKey()));
                    this.jOG.a(bVar, entry.getValue());
                }
                bVar.cBu();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                boolean z = false;
                for (Map.Entry<K, V> entry2 : map.entrySet()) {
                    com.google.gson.i bf = this.jOF.bf(entry2.getKey());
                    arrayList.add(bf);
                    arrayList2.add(entry2.getValue());
                    z = (bf.cAH() || bf.cAI()) | z;
                }
                if (z) {
                    bVar.cBr();
                    while (i < arrayList.size()) {
                        bVar.cBr();
                        com.google.gson.internal.g.b((com.google.gson.i) arrayList.get(i), bVar);
                        this.jOG.a(bVar, arrayList2.get(i));
                        bVar.cBs();
                        i++;
                    }
                    bVar.cBs();
                    return;
                }
                bVar.cBt();
                while (i < arrayList.size()) {
                    bVar.FP(d((com.google.gson.i) arrayList.get(i)));
                    this.jOG.a(bVar, arrayList2.get(i));
                    i++;
                }
                bVar.cBu();
            }
        }

        private String d(com.google.gson.i iVar) {
            if (iVar.cAJ()) {
                com.google.gson.l cAN = iVar.cAN();
                if (cAN.cAQ()) {
                    return String.valueOf(cAN.cAF());
                }
                if (cAN.cAP()) {
                    return Boolean.toString(cAN.getAsBoolean());
                }
                if (cAN.cAR()) {
                    return cAN.cAG();
                }
                throw new AssertionError();
            } else if (iVar.cAK()) {
                return "null";
            } else {
                throw new AssertionError();
            }
        }
    }
}
