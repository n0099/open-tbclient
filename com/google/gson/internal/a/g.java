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
    private final com.google.gson.internal.b jNe;
    final boolean jOP;

    public g(com.google.gson.internal.b bVar, boolean z) {
        this.jNe = bVar;
        this.jOP = z;
    }

    @Override // com.google.gson.p
    public <T> o<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
        Type cBK = aVar.cBK();
        if (!Map.class.isAssignableFrom(aVar.cBJ())) {
            return null;
        }
        Type[] b = C$Gson$Types.b(cBK, C$Gson$Types.g(cBK));
        return new a(dVar, b[0], a(dVar, b[0]), b[1], dVar.a(com.google.gson.b.a.l(b[1])), this.jNe.b(aVar));
    }

    private o<?> a(com.google.gson.d dVar, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? n.jPt : dVar.a(com.google.gson.b.a.l(type));
    }

    /* loaded from: classes2.dex */
    private final class a<K, V> extends o<Map<K, V>> {
        private final com.google.gson.internal.e<? extends Map<K, V>> jOB;
        private final o<K> jOQ;
        private final o<V> jOR;

        @Override // com.google.gson.o
        public /* bridge */ /* synthetic */ void a(com.google.gson.stream.b bVar, Object obj) throws IOException {
            a(bVar, (Map) ((Map) obj));
        }

        public a(com.google.gson.d dVar, Type type, o<K> oVar, Type type2, o<V> oVar2, com.google.gson.internal.e<? extends Map<K, V>> eVar) {
            this.jOQ = new m(dVar, oVar, type);
            this.jOR = new m(dVar, oVar2, type2);
            this.jOB = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: k */
        public Map<K, V> b(com.google.gson.stream.a aVar) throws IOException {
            JsonToken cBx = aVar.cBx();
            if (cBx == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            Map<K, V> cBl = this.jOB.cBl();
            if (cBx == JsonToken.BEGIN_ARRAY) {
                aVar.beginArray();
                while (aVar.hasNext()) {
                    aVar.beginArray();
                    K b = this.jOQ.b(aVar);
                    if (cBl.put(b, this.jOR.b(aVar)) != null) {
                        throw new JsonSyntaxException("duplicate key: " + b);
                    }
                    aVar.endArray();
                }
                aVar.endArray();
                return cBl;
            }
            aVar.beginObject();
            while (aVar.hasNext()) {
                com.google.gson.internal.d.jNQ.g(aVar);
                K b2 = this.jOQ.b(aVar);
                if (cBl.put(b2, this.jOR.b(aVar)) != null) {
                    throw new JsonSyntaxException("duplicate key: " + b2);
                }
            }
            aVar.endObject();
            return cBl;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.google.gson.o<V> */
        /* JADX DEBUG: Multi-variable search result rejected for r0v14, resolved type: com.google.gson.o<V> */
        /* JADX WARN: Multi-variable type inference failed */
        public void a(com.google.gson.stream.b bVar, Map<K, V> map) throws IOException {
            int i = 0;
            if (map == null) {
                bVar.cBI();
            } else if (!g.this.jOP) {
                bVar.cBG();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    bVar.FQ(String.valueOf(entry.getKey()));
                    this.jOR.a(bVar, entry.getValue());
                }
                bVar.cBH();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                boolean z = false;
                for (Map.Entry<K, V> entry2 : map.entrySet()) {
                    com.google.gson.i bg = this.jOQ.bg(entry2.getKey());
                    arrayList.add(bg);
                    arrayList2.add(entry2.getValue());
                    z = (bg.cAU() || bg.cAV()) | z;
                }
                if (z) {
                    bVar.cBE();
                    while (i < arrayList.size()) {
                        bVar.cBE();
                        com.google.gson.internal.g.b((com.google.gson.i) arrayList.get(i), bVar);
                        this.jOR.a(bVar, arrayList2.get(i));
                        bVar.cBF();
                        i++;
                    }
                    bVar.cBF();
                    return;
                }
                bVar.cBG();
                while (i < arrayList.size()) {
                    bVar.FQ(d((com.google.gson.i) arrayList.get(i)));
                    this.jOR.a(bVar, arrayList2.get(i));
                    i++;
                }
                bVar.cBH();
            }
        }

        private String d(com.google.gson.i iVar) {
            if (iVar.cAW()) {
                com.google.gson.l cBa = iVar.cBa();
                if (cBa.cBd()) {
                    return String.valueOf(cBa.cAS());
                }
                if (cBa.cBc()) {
                    return Boolean.toString(cBa.getAsBoolean());
                }
                if (cBa.cBe()) {
                    return cBa.cAT();
                }
                throw new AssertionError();
            } else if (iVar.cAX()) {
                return "null";
            } else {
                throw new AssertionError();
            }
        }
    }
}
