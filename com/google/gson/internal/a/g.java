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
    private final com.google.gson.internal.b ilE;
    final boolean inq;

    public g(com.google.gson.internal.b bVar, boolean z) {
        this.ilE = bVar;
        this.inq = z;
    }

    @Override // com.google.gson.p
    public <T> o<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
        Type bYO = aVar.bYO();
        if (!Map.class.isAssignableFrom(aVar.bYN())) {
            return null;
        }
        Type[] b = C$Gson$Types.b(bYO, C$Gson$Types.g(bYO));
        return new a(dVar, b[0], a(dVar, b[0]), b[1], dVar.a(com.google.gson.b.a.l(b[1])), this.ilE.b(aVar));
    }

    private o<?> a(com.google.gson.d dVar, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? n.inV : dVar.a(com.google.gson.b.a.l(type));
    }

    /* loaded from: classes2.dex */
    private final class a<K, V> extends o<Map<K, V>> {
        private final com.google.gson.internal.e<? extends Map<K, V>> inc;
        private final o<K> inr;

        /* renamed from: int  reason: not valid java name */
        private final o<V> f0int;

        @Override // com.google.gson.o
        public /* bridge */ /* synthetic */ void a(com.google.gson.stream.b bVar, Object obj) throws IOException {
            a(bVar, (Map) ((Map) obj));
        }

        public a(com.google.gson.d dVar, Type type, o<K> oVar, Type type2, o<V> oVar2, com.google.gson.internal.e<? extends Map<K, V>> eVar) {
            this.inr = new m(dVar, oVar, type);
            this.f0int = new m(dVar, oVar2, type2);
            this.inc = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: k */
        public Map<K, V> b(com.google.gson.stream.a aVar) throws IOException {
            JsonToken bYB = aVar.bYB();
            if (bYB == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            Map<K, V> bYp = this.inc.bYp();
            if (bYB == JsonToken.BEGIN_ARRAY) {
                aVar.beginArray();
                while (aVar.hasNext()) {
                    aVar.beginArray();
                    K b = this.inr.b(aVar);
                    if (bYp.put(b, this.f0int.b(aVar)) != null) {
                        throw new JsonSyntaxException("duplicate key: " + b);
                    }
                    aVar.endArray();
                }
                aVar.endArray();
                return bYp;
            }
            aVar.beginObject();
            while (aVar.hasNext()) {
                com.google.gson.internal.d.imr.g(aVar);
                K b2 = this.inr.b(aVar);
                if (bYp.put(b2, this.f0int.b(aVar)) != null) {
                    throw new JsonSyntaxException("duplicate key: " + b2);
                }
            }
            aVar.endObject();
            return bYp;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.google.gson.o<V> */
        /* JADX DEBUG: Multi-variable search result rejected for r0v14, resolved type: com.google.gson.o<V> */
        /* JADX WARN: Multi-variable type inference failed */
        public void a(com.google.gson.stream.b bVar, Map<K, V> map) throws IOException {
            int i = 0;
            if (map == null) {
                bVar.bYM();
            } else if (!g.this.inq) {
                bVar.bYK();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    bVar.yQ(String.valueOf(entry.getKey()));
                    this.f0int.a(bVar, entry.getValue());
                }
                bVar.bYL();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                boolean z = false;
                for (Map.Entry<K, V> entry2 : map.entrySet()) {
                    com.google.gson.i aP = this.inr.aP(entry2.getKey());
                    arrayList.add(aP);
                    arrayList2.add(entry2.getValue());
                    z = (aP.bXY() || aP.bXZ()) | z;
                }
                if (z) {
                    bVar.bYI();
                    while (i < arrayList.size()) {
                        bVar.bYI();
                        com.google.gson.internal.g.b((com.google.gson.i) arrayList.get(i), bVar);
                        this.f0int.a(bVar, arrayList2.get(i));
                        bVar.bYJ();
                        i++;
                    }
                    bVar.bYJ();
                    return;
                }
                bVar.bYK();
                while (i < arrayList.size()) {
                    bVar.yQ(d((com.google.gson.i) arrayList.get(i)));
                    this.f0int.a(bVar, arrayList2.get(i));
                    i++;
                }
                bVar.bYL();
            }
        }

        private String d(com.google.gson.i iVar) {
            if (iVar.bYa()) {
                com.google.gson.l bYe = iVar.bYe();
                if (bYe.bYh()) {
                    return String.valueOf(bYe.bXW());
                }
                if (bYe.bYg()) {
                    return Boolean.toString(bYe.getAsBoolean());
                }
                if (bYe.bYi()) {
                    return bYe.bXX();
                }
                throw new AssertionError();
            } else if (iVar.bYb()) {
                return "null";
            } else {
                throw new AssertionError();
            }
        }
    }
}
