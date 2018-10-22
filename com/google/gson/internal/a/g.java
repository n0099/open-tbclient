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
    private final com.google.gson.internal.b ijU;
    final boolean ilF;

    public g(com.google.gson.internal.b bVar, boolean z) {
        this.ijU = bVar;
        this.ilF = z;
    }

    @Override // com.google.gson.p
    public <T> o<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
        Type bZr = aVar.bZr();
        if (!Map.class.isAssignableFrom(aVar.bZq())) {
            return null;
        }
        Type[] b = C$Gson$Types.b(bZr, C$Gson$Types.g(bZr));
        return new a(dVar, b[0], a(dVar, b[0]), b[1], dVar.a(com.google.gson.b.a.l(b[1])), this.ijU.b(aVar));
    }

    private o<?> a(com.google.gson.d dVar, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? n.imk : dVar.a(com.google.gson.b.a.l(type));
    }

    /* loaded from: classes2.dex */
    private final class a<K, V> extends o<Map<K, V>> {
        private final o<K> ilG;
        private final o<V> ilH;
        private final com.google.gson.internal.e<? extends Map<K, V>> ilr;

        @Override // com.google.gson.o
        public /* bridge */ /* synthetic */ void a(com.google.gson.stream.b bVar, Object obj) throws IOException {
            a(bVar, (Map) ((Map) obj));
        }

        public a(com.google.gson.d dVar, Type type, o<K> oVar, Type type2, o<V> oVar2, com.google.gson.internal.e<? extends Map<K, V>> eVar) {
            this.ilG = new m(dVar, oVar, type);
            this.ilH = new m(dVar, oVar2, type2);
            this.ilr = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: k */
        public Map<K, V> b(com.google.gson.stream.a aVar) throws IOException {
            JsonToken bZe = aVar.bZe();
            if (bZe == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            Map<K, V> bYS = this.ilr.bYS();
            if (bZe == JsonToken.BEGIN_ARRAY) {
                aVar.beginArray();
                while (aVar.hasNext()) {
                    aVar.beginArray();
                    K b = this.ilG.b(aVar);
                    if (bYS.put(b, this.ilH.b(aVar)) != null) {
                        throw new JsonSyntaxException("duplicate key: " + b);
                    }
                    aVar.endArray();
                }
                aVar.endArray();
                return bYS;
            }
            aVar.beginObject();
            while (aVar.hasNext()) {
                com.google.gson.internal.d.ikG.g(aVar);
                K b2 = this.ilG.b(aVar);
                if (bYS.put(b2, this.ilH.b(aVar)) != null) {
                    throw new JsonSyntaxException("duplicate key: " + b2);
                }
            }
            aVar.endObject();
            return bYS;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.google.gson.o<V> */
        /* JADX DEBUG: Multi-variable search result rejected for r0v14, resolved type: com.google.gson.o<V> */
        /* JADX WARN: Multi-variable type inference failed */
        public void a(com.google.gson.stream.b bVar, Map<K, V> map) throws IOException {
            int i = 0;
            if (map == null) {
                bVar.bZp();
            } else if (!g.this.ilF) {
                bVar.bZn();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    bVar.yL(String.valueOf(entry.getKey()));
                    this.ilH.a(bVar, entry.getValue());
                }
                bVar.bZo();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                boolean z = false;
                for (Map.Entry<K, V> entry2 : map.entrySet()) {
                    com.google.gson.i aQ = this.ilG.aQ(entry2.getKey());
                    arrayList.add(aQ);
                    arrayList2.add(entry2.getValue());
                    z = (aQ.bYB() || aQ.bYC()) | z;
                }
                if (z) {
                    bVar.bZl();
                    while (i < arrayList.size()) {
                        bVar.bZl();
                        com.google.gson.internal.g.b((com.google.gson.i) arrayList.get(i), bVar);
                        this.ilH.a(bVar, arrayList2.get(i));
                        bVar.bZm();
                        i++;
                    }
                    bVar.bZm();
                    return;
                }
                bVar.bZn();
                while (i < arrayList.size()) {
                    bVar.yL(d((com.google.gson.i) arrayList.get(i)));
                    this.ilH.a(bVar, arrayList2.get(i));
                    i++;
                }
                bVar.bZo();
            }
        }

        private String d(com.google.gson.i iVar) {
            if (iVar.bYD()) {
                com.google.gson.l bYH = iVar.bYH();
                if (bYH.bYK()) {
                    return String.valueOf(bYH.bYz());
                }
                if (bYH.bYJ()) {
                    return Boolean.toString(bYH.getAsBoolean());
                }
                if (bYH.bYL()) {
                    return bYH.bYA();
                }
                throw new AssertionError();
            } else if (iVar.bYE()) {
                return "null";
            } else {
                throw new AssertionError();
            }
        }
    }
}
