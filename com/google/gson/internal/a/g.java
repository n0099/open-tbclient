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
    private final com.google.gson.internal.b jNm;
    final boolean jOX;

    public g(com.google.gson.internal.b bVar, boolean z) {
        this.jNm = bVar;
        this.jOX = z;
    }

    @Override // com.google.gson.p
    public <T> o<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
        Type cBH = aVar.cBH();
        if (!Map.class.isAssignableFrom(aVar.cBG())) {
            return null;
        }
        Type[] b = C$Gson$Types.b(cBH, C$Gson$Types.g(cBH));
        return new a(dVar, b[0], a(dVar, b[0]), b[1], dVar.a(com.google.gson.b.a.l(b[1])), this.jNm.b(aVar));
    }

    private o<?> a(com.google.gson.d dVar, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? n.jPB : dVar.a(com.google.gson.b.a.l(type));
    }

    /* loaded from: classes2.dex */
    private final class a<K, V> extends o<Map<K, V>> {
        private final com.google.gson.internal.e<? extends Map<K, V>> jOJ;
        private final o<K> jOY;
        private final o<V> jOZ;

        @Override // com.google.gson.o
        public /* bridge */ /* synthetic */ void a(com.google.gson.stream.b bVar, Object obj) throws IOException {
            a(bVar, (Map) ((Map) obj));
        }

        public a(com.google.gson.d dVar, Type type, o<K> oVar, Type type2, o<V> oVar2, com.google.gson.internal.e<? extends Map<K, V>> eVar) {
            this.jOY = new m(dVar, oVar, type);
            this.jOZ = new m(dVar, oVar2, type2);
            this.jOJ = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: k */
        public Map<K, V> b(com.google.gson.stream.a aVar) throws IOException {
            JsonToken cBu = aVar.cBu();
            if (cBu == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            Map<K, V> cBi = this.jOJ.cBi();
            if (cBu == JsonToken.BEGIN_ARRAY) {
                aVar.beginArray();
                while (aVar.hasNext()) {
                    aVar.beginArray();
                    K b = this.jOY.b(aVar);
                    if (cBi.put(b, this.jOZ.b(aVar)) != null) {
                        throw new JsonSyntaxException("duplicate key: " + b);
                    }
                    aVar.endArray();
                }
                aVar.endArray();
                return cBi;
            }
            aVar.beginObject();
            while (aVar.hasNext()) {
                com.google.gson.internal.d.jNY.g(aVar);
                K b2 = this.jOY.b(aVar);
                if (cBi.put(b2, this.jOZ.b(aVar)) != null) {
                    throw new JsonSyntaxException("duplicate key: " + b2);
                }
            }
            aVar.endObject();
            return cBi;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.google.gson.o<V> */
        /* JADX DEBUG: Multi-variable search result rejected for r0v14, resolved type: com.google.gson.o<V> */
        /* JADX WARN: Multi-variable type inference failed */
        public void a(com.google.gson.stream.b bVar, Map<K, V> map) throws IOException {
            int i = 0;
            if (map == null) {
                bVar.cBF();
            } else if (!g.this.jOX) {
                bVar.cBD();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    bVar.FS(String.valueOf(entry.getKey()));
                    this.jOZ.a(bVar, entry.getValue());
                }
                bVar.cBE();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                boolean z = false;
                for (Map.Entry<K, V> entry2 : map.entrySet()) {
                    com.google.gson.i bg = this.jOY.bg(entry2.getKey());
                    arrayList.add(bg);
                    arrayList2.add(entry2.getValue());
                    z = (bg.cAR() || bg.cAS()) | z;
                }
                if (z) {
                    bVar.cBB();
                    while (i < arrayList.size()) {
                        bVar.cBB();
                        com.google.gson.internal.g.b((com.google.gson.i) arrayList.get(i), bVar);
                        this.jOZ.a(bVar, arrayList2.get(i));
                        bVar.cBC();
                        i++;
                    }
                    bVar.cBC();
                    return;
                }
                bVar.cBD();
                while (i < arrayList.size()) {
                    bVar.FS(d((com.google.gson.i) arrayList.get(i)));
                    this.jOZ.a(bVar, arrayList2.get(i));
                    i++;
                }
                bVar.cBE();
            }
        }

        private String d(com.google.gson.i iVar) {
            if (iVar.cAT()) {
                com.google.gson.l cAX = iVar.cAX();
                if (cAX.cBa()) {
                    return String.valueOf(cAX.cAP());
                }
                if (cAX.cAZ()) {
                    return Boolean.toString(cAX.getAsBoolean());
                }
                if (cAX.cBb()) {
                    return cAX.cAQ();
                }
                throw new AssertionError();
            } else if (iVar.cAU()) {
                return "null";
            } else {
                throw new AssertionError();
            }
        }
    }
}
