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
    private final com.google.gson.internal.b ixh;
    final boolean iyS;

    public g(com.google.gson.internal.b bVar, boolean z) {
        this.ixh = bVar;
        this.iyS = z;
    }

    @Override // com.google.gson.p
    public <T> o<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
        Type ccs = aVar.ccs();
        if (!Map.class.isAssignableFrom(aVar.ccr())) {
            return null;
        }
        Type[] b = C$Gson$Types.b(ccs, C$Gson$Types.g(ccs));
        return new a(dVar, b[0], a(dVar, b[0]), b[1], dVar.a(com.google.gson.b.a.l(b[1])), this.ixh.b(aVar));
    }

    private o<?> a(com.google.gson.d dVar, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? n.izw : dVar.a(com.google.gson.b.a.l(type));
    }

    /* loaded from: classes2.dex */
    private final class a<K, V> extends o<Map<K, V>> {
        private final com.google.gson.internal.e<? extends Map<K, V>> iyE;
        private final o<K> iyT;
        private final o<V> iyU;

        @Override // com.google.gson.o
        public /* bridge */ /* synthetic */ void a(com.google.gson.stream.b bVar, Object obj) throws IOException {
            a(bVar, (Map) ((Map) obj));
        }

        public a(com.google.gson.d dVar, Type type, o<K> oVar, Type type2, o<V> oVar2, com.google.gson.internal.e<? extends Map<K, V>> eVar) {
            this.iyT = new m(dVar, oVar, type);
            this.iyU = new m(dVar, oVar2, type2);
            this.iyE = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: k */
        public Map<K, V> b(com.google.gson.stream.a aVar) throws IOException {
            JsonToken ccf = aVar.ccf();
            if (ccf == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            Map<K, V> cbT = this.iyE.cbT();
            if (ccf == JsonToken.BEGIN_ARRAY) {
                aVar.beginArray();
                while (aVar.hasNext()) {
                    aVar.beginArray();
                    K b = this.iyT.b(aVar);
                    if (cbT.put(b, this.iyU.b(aVar)) != null) {
                        throw new JsonSyntaxException("duplicate key: " + b);
                    }
                    aVar.endArray();
                }
                aVar.endArray();
                return cbT;
            }
            aVar.beginObject();
            while (aVar.hasNext()) {
                com.google.gson.internal.d.ixT.g(aVar);
                K b2 = this.iyT.b(aVar);
                if (cbT.put(b2, this.iyU.b(aVar)) != null) {
                    throw new JsonSyntaxException("duplicate key: " + b2);
                }
            }
            aVar.endObject();
            return cbT;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.google.gson.o<V> */
        /* JADX DEBUG: Multi-variable search result rejected for r0v14, resolved type: com.google.gson.o<V> */
        /* JADX WARN: Multi-variable type inference failed */
        public void a(com.google.gson.stream.b bVar, Map<K, V> map) throws IOException {
            int i = 0;
            if (map == null) {
                bVar.ccq();
            } else if (!g.this.iyS) {
                bVar.cco();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    bVar.zM(String.valueOf(entry.getKey()));
                    this.iyU.a(bVar, entry.getValue());
                }
                bVar.ccp();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                boolean z = false;
                for (Map.Entry<K, V> entry2 : map.entrySet()) {
                    com.google.gson.i aQ = this.iyT.aQ(entry2.getKey());
                    arrayList.add(aQ);
                    arrayList2.add(entry2.getValue());
                    z = (aQ.cbC() || aQ.cbD()) | z;
                }
                if (z) {
                    bVar.ccm();
                    while (i < arrayList.size()) {
                        bVar.ccm();
                        com.google.gson.internal.g.b((com.google.gson.i) arrayList.get(i), bVar);
                        this.iyU.a(bVar, arrayList2.get(i));
                        bVar.ccn();
                        i++;
                    }
                    bVar.ccn();
                    return;
                }
                bVar.cco();
                while (i < arrayList.size()) {
                    bVar.zM(d((com.google.gson.i) arrayList.get(i)));
                    this.iyU.a(bVar, arrayList2.get(i));
                    i++;
                }
                bVar.ccp();
            }
        }

        private String d(com.google.gson.i iVar) {
            if (iVar.cbE()) {
                com.google.gson.l cbI = iVar.cbI();
                if (cbI.cbL()) {
                    return String.valueOf(cbI.cbA());
                }
                if (cbI.cbK()) {
                    return Boolean.toString(cbI.getAsBoolean());
                }
                if (cbI.cbM()) {
                    return cbI.cbB();
                }
                throw new AssertionError();
            } else if (iVar.cbF()) {
                return "null";
            } else {
                throw new AssertionError();
            }
        }
    }
}
