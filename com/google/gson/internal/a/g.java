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
    private final com.google.gson.internal.b iwa;
    final boolean ixL;

    public g(com.google.gson.internal.b bVar, boolean z) {
        this.iwa = bVar;
        this.ixL = z;
    }

    @Override // com.google.gson.p
    public <T> o<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
        Type cbK = aVar.cbK();
        if (!Map.class.isAssignableFrom(aVar.cbJ())) {
            return null;
        }
        Type[] b = C$Gson$Types.b(cbK, C$Gson$Types.g(cbK));
        return new a(dVar, b[0], a(dVar, b[0]), b[1], dVar.a(com.google.gson.b.a.l(b[1])), this.iwa.b(aVar));
    }

    private o<?> a(com.google.gson.d dVar, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? n.iyp : dVar.a(com.google.gson.b.a.l(type));
    }

    /* loaded from: classes2.dex */
    private final class a<K, V> extends o<Map<K, V>> {
        private final o<K> ixM;
        private final o<V> ixN;
        private final com.google.gson.internal.e<? extends Map<K, V>> ixx;

        @Override // com.google.gson.o
        public /* bridge */ /* synthetic */ void a(com.google.gson.stream.b bVar, Object obj) throws IOException {
            a(bVar, (Map) ((Map) obj));
        }

        public a(com.google.gson.d dVar, Type type, o<K> oVar, Type type2, o<V> oVar2, com.google.gson.internal.e<? extends Map<K, V>> eVar) {
            this.ixM = new m(dVar, oVar, type);
            this.ixN = new m(dVar, oVar2, type2);
            this.ixx = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: k */
        public Map<K, V> b(com.google.gson.stream.a aVar) throws IOException {
            JsonToken cbx = aVar.cbx();
            if (cbx == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            Map<K, V> cbl = this.ixx.cbl();
            if (cbx == JsonToken.BEGIN_ARRAY) {
                aVar.beginArray();
                while (aVar.hasNext()) {
                    aVar.beginArray();
                    K b = this.ixM.b(aVar);
                    if (cbl.put(b, this.ixN.b(aVar)) != null) {
                        throw new JsonSyntaxException("duplicate key: " + b);
                    }
                    aVar.endArray();
                }
                aVar.endArray();
                return cbl;
            }
            aVar.beginObject();
            while (aVar.hasNext()) {
                com.google.gson.internal.d.iwM.g(aVar);
                K b2 = this.ixM.b(aVar);
                if (cbl.put(b2, this.ixN.b(aVar)) != null) {
                    throw new JsonSyntaxException("duplicate key: " + b2);
                }
            }
            aVar.endObject();
            return cbl;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.google.gson.o<V> */
        /* JADX DEBUG: Multi-variable search result rejected for r0v14, resolved type: com.google.gson.o<V> */
        /* JADX WARN: Multi-variable type inference failed */
        public void a(com.google.gson.stream.b bVar, Map<K, V> map) throws IOException {
            int i = 0;
            if (map == null) {
                bVar.cbI();
            } else if (!g.this.ixL) {
                bVar.cbG();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    bVar.zw(String.valueOf(entry.getKey()));
                    this.ixN.a(bVar, entry.getValue());
                }
                bVar.cbH();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                boolean z = false;
                for (Map.Entry<K, V> entry2 : map.entrySet()) {
                    com.google.gson.i aQ = this.ixM.aQ(entry2.getKey());
                    arrayList.add(aQ);
                    arrayList2.add(entry2.getValue());
                    z = (aQ.caU() || aQ.caV()) | z;
                }
                if (z) {
                    bVar.cbE();
                    while (i < arrayList.size()) {
                        bVar.cbE();
                        com.google.gson.internal.g.b((com.google.gson.i) arrayList.get(i), bVar);
                        this.ixN.a(bVar, arrayList2.get(i));
                        bVar.cbF();
                        i++;
                    }
                    bVar.cbF();
                    return;
                }
                bVar.cbG();
                while (i < arrayList.size()) {
                    bVar.zw(d((com.google.gson.i) arrayList.get(i)));
                    this.ixN.a(bVar, arrayList2.get(i));
                    i++;
                }
                bVar.cbH();
            }
        }

        private String d(com.google.gson.i iVar) {
            if (iVar.caW()) {
                com.google.gson.l cba = iVar.cba();
                if (cba.cbd()) {
                    return String.valueOf(cba.caS());
                }
                if (cba.cbc()) {
                    return Boolean.toString(cba.getAsBoolean());
                }
                if (cba.cbe()) {
                    return cba.caT();
                }
                throw new AssertionError();
            } else if (iVar.caX()) {
                return "null";
            } else {
                throw new AssertionError();
            }
        }
    }
}
