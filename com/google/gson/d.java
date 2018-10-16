package com.google.gson;

import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
/* loaded from: classes2.dex */
public final class d {
    private static final com.google.gson.b.a<?> ijQ = new com.google.gson.b.a<Object>() { // from class: com.google.gson.d.1
    };
    private final List<p> fes;
    private final ThreadLocal<Map<com.google.gson.b.a<?>, a<?>>> ijR;
    private final Map<com.google.gson.b.a<?>, o<?>> ijS;
    private final com.google.gson.internal.b ijT;
    private final com.google.gson.internal.c ijU;
    private final c ijV;
    private final boolean ijW;
    private final boolean ijX;
    private final boolean ijY;
    private final boolean ijZ;
    private final boolean ika;
    private final com.google.gson.internal.a.d ikb;

    public d() {
        this(com.google.gson.internal.c.ikt, FieldNamingPolicy.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, false, LongSerializationPolicy.DEFAULT, Collections.emptyList());
    }

    d(com.google.gson.internal.c cVar, c cVar2, Map<Type, e<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, LongSerializationPolicy longSerializationPolicy, List<p> list) {
        this.ijR = new ThreadLocal<>();
        this.ijS = new ConcurrentHashMap();
        this.ijT = new com.google.gson.internal.b(map);
        this.ijU = cVar;
        this.ijV = cVar2;
        this.ijW = z;
        this.ijY = z3;
        this.ijX = z4;
        this.ijZ = z5;
        this.ika = z6;
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.google.gson.internal.a.n.inc);
        arrayList.add(com.google.gson.internal.a.h.ilm);
        arrayList.add(cVar);
        arrayList.addAll(list);
        arrayList.add(com.google.gson.internal.a.n.imH);
        arrayList.add(com.google.gson.internal.a.n.imq);
        arrayList.add(com.google.gson.internal.a.n.imk);
        arrayList.add(com.google.gson.internal.a.n.imm);
        arrayList.add(com.google.gson.internal.a.n.imo);
        o<Number> a2 = a(longSerializationPolicy);
        arrayList.add(com.google.gson.internal.a.n.a(Long.TYPE, Long.class, a2));
        arrayList.add(com.google.gson.internal.a.n.a(Double.TYPE, Double.class, oM(z7)));
        arrayList.add(com.google.gson.internal.a.n.a(Float.TYPE, Float.class, oN(z7)));
        arrayList.add(com.google.gson.internal.a.n.imB);
        arrayList.add(com.google.gson.internal.a.n.ims);
        arrayList.add(com.google.gson.internal.a.n.imu);
        arrayList.add(com.google.gson.internal.a.n.a(AtomicLong.class, a(a2)));
        arrayList.add(com.google.gson.internal.a.n.a(AtomicLongArray.class, b(a2)));
        arrayList.add(com.google.gson.internal.a.n.imw);
        arrayList.add(com.google.gson.internal.a.n.imD);
        arrayList.add(com.google.gson.internal.a.n.imJ);
        arrayList.add(com.google.gson.internal.a.n.imL);
        arrayList.add(com.google.gson.internal.a.n.a(BigDecimal.class, com.google.gson.internal.a.n.imF));
        arrayList.add(com.google.gson.internal.a.n.a(BigInteger.class, com.google.gson.internal.a.n.imG));
        arrayList.add(com.google.gson.internal.a.n.imN);
        arrayList.add(com.google.gson.internal.a.n.imP);
        arrayList.add(com.google.gson.internal.a.n.imT);
        arrayList.add(com.google.gson.internal.a.n.imV);
        arrayList.add(com.google.gson.internal.a.n.ina);
        arrayList.add(com.google.gson.internal.a.n.imR);
        arrayList.add(com.google.gson.internal.a.n.imh);
        arrayList.add(com.google.gson.internal.a.c.ilm);
        arrayList.add(com.google.gson.internal.a.n.imY);
        arrayList.add(com.google.gson.internal.a.k.ilm);
        arrayList.add(com.google.gson.internal.a.j.ilm);
        arrayList.add(com.google.gson.internal.a.n.imW);
        arrayList.add(com.google.gson.internal.a.a.ilm);
        arrayList.add(com.google.gson.internal.a.n.ime);
        arrayList.add(new com.google.gson.internal.a.b(this.ijT));
        arrayList.add(new com.google.gson.internal.a.g(this.ijT, z2));
        this.ikb = new com.google.gson.internal.a.d(this.ijT);
        arrayList.add(this.ikb);
        arrayList.add(com.google.gson.internal.a.n.ind);
        arrayList.add(new com.google.gson.internal.a.i(this.ijT, cVar2, cVar, this.ikb));
        this.fes = Collections.unmodifiableList(arrayList);
    }

    private o<Number> oM(boolean z) {
        return z ? com.google.gson.internal.a.n.imz : new o<Number>() { // from class: com.google.gson.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.o
            /* renamed from: a */
            public Double b(com.google.gson.stream.a aVar) throws IOException {
                if (aVar.bZe() == JsonToken.NULL) {
                    aVar.nextNull();
                    return null;
                }
                return Double.valueOf(aVar.nextDouble());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.o
            public void a(com.google.gson.stream.b bVar, Number number) throws IOException {
                if (number == null) {
                    bVar.bZp();
                    return;
                }
                d.p(number.doubleValue());
                bVar.b(number);
            }
        };
    }

    private o<Number> oN(boolean z) {
        return z ? com.google.gson.internal.a.n.imy : new o<Number>() { // from class: com.google.gson.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.o
            /* renamed from: c */
            public Float b(com.google.gson.stream.a aVar) throws IOException {
                if (aVar.bZe() == JsonToken.NULL) {
                    aVar.nextNull();
                    return null;
                }
                return Float.valueOf((float) aVar.nextDouble());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.o
            public void a(com.google.gson.stream.b bVar, Number number) throws IOException {
                if (number == null) {
                    bVar.bZp();
                    return;
                }
                d.p(number.floatValue());
                bVar.b(number);
            }
        };
    }

    static void p(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException(d + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private static o<Number> a(LongSerializationPolicy longSerializationPolicy) {
        return longSerializationPolicy == LongSerializationPolicy.DEFAULT ? com.google.gson.internal.a.n.imx : new o<Number>() { // from class: com.google.gson.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.o
            /* renamed from: d */
            public Number b(com.google.gson.stream.a aVar) throws IOException {
                if (aVar.bZe() == JsonToken.NULL) {
                    aVar.nextNull();
                    return null;
                }
                return Long.valueOf(aVar.nextLong());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.o
            public void a(com.google.gson.stream.b bVar, Number number) throws IOException {
                if (number == null) {
                    bVar.bZp();
                } else {
                    bVar.yM(number.toString());
                }
            }
        };
    }

    private static o<AtomicLong> a(final o<Number> oVar) {
        return new o<AtomicLong>() { // from class: com.google.gson.d.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.o
            public void a(com.google.gson.stream.b bVar, AtomicLong atomicLong) throws IOException {
                o.this.a(bVar, Long.valueOf(atomicLong.get()));
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.o
            /* renamed from: e */
            public AtomicLong b(com.google.gson.stream.a aVar) throws IOException {
                return new AtomicLong(((Number) o.this.b(aVar)).longValue());
            }
        }.bYM();
    }

    private static o<AtomicLongArray> b(final o<Number> oVar) {
        return new o<AtomicLongArray>() { // from class: com.google.gson.d.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.o
            public void a(com.google.gson.stream.b bVar, AtomicLongArray atomicLongArray) throws IOException {
                bVar.bZl();
                int length = atomicLongArray.length();
                for (int i = 0; i < length; i++) {
                    o.this.a(bVar, Long.valueOf(atomicLongArray.get(i)));
                }
                bVar.bZm();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.o
            /* renamed from: f */
            public AtomicLongArray b(com.google.gson.stream.a aVar) throws IOException {
                ArrayList arrayList = new ArrayList();
                aVar.beginArray();
                while (aVar.hasNext()) {
                    arrayList.add(Long.valueOf(((Number) o.this.b(aVar)).longValue()));
                }
                aVar.endArray();
                int size = arrayList.size();
                AtomicLongArray atomicLongArray = new AtomicLongArray(size);
                for (int i = 0; i < size; i++) {
                    atomicLongArray.set(i, ((Long) arrayList.get(i)).longValue());
                }
                return atomicLongArray;
            }
        }.bYM();
    }

    public <T> o<T> a(com.google.gson.b.a<T> aVar) {
        HashMap hashMap;
        o<T> oVar = (o<T>) this.ijS.get(aVar == null ? ijQ : aVar);
        if (oVar == null) {
            Map<com.google.gson.b.a<?>, a<?>> map = this.ijR.get();
            boolean z = false;
            if (map == null) {
                HashMap hashMap2 = new HashMap();
                this.ijR.set(hashMap2);
                hashMap = hashMap2;
                z = true;
            } else {
                hashMap = map;
            }
            oVar = hashMap.get(aVar);
            if (oVar == null) {
                try {
                    a<?> aVar2 = new a<>();
                    hashMap.put(aVar, aVar2);
                    for (p pVar : this.fes) {
                        oVar = pVar.a(this, aVar);
                        if (oVar != null) {
                            aVar2.c(oVar);
                            this.ijS.put(aVar, oVar);
                            hashMap.remove(aVar);
                            if (z) {
                                this.ijR.remove();
                            }
                        }
                    }
                    throw new IllegalArgumentException("GSON cannot handle " + aVar);
                } catch (Throwable th) {
                    hashMap.remove(aVar);
                    if (z) {
                        this.ijR.remove();
                    }
                    throw th;
                }
            }
        }
        return oVar;
    }

    public <T> o<T> a(p pVar, com.google.gson.b.a<T> aVar) {
        if (!this.fes.contains(pVar)) {
            pVar = this.ikb;
        }
        boolean z = false;
        for (p pVar2 : this.fes) {
            if (!z) {
                if (pVar2 == pVar) {
                    z = true;
                }
            } else {
                o<T> a2 = pVar2.a(this, aVar);
                if (a2 != null) {
                    return a2;
                }
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + aVar);
    }

    public <T> o<T> t(Class<T> cls) {
        return a(com.google.gson.b.a.B(cls));
    }

    public String toJson(Object obj) {
        return obj == null ? a(j.ikg) : b(obj, obj.getClass());
    }

    public String b(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        a(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public void a(Object obj, Type type, Appendable appendable) throws JsonIOException {
        try {
            a(obj, type, c(com.google.gson.internal.g.a(appendable)));
        } catch (IOException e) {
            throw new JsonIOException(e);
        }
    }

    public void a(Object obj, Type type, com.google.gson.stream.b bVar) throws JsonIOException {
        o a2 = a(com.google.gson.b.a.l(type));
        boolean isLenient = bVar.isLenient();
        bVar.setLenient(true);
        boolean bZB = bVar.bZB();
        bVar.oQ(this.ijX);
        boolean bZC = bVar.bZC();
        bVar.oR(this.ijW);
        try {
            try {
                a2.a(bVar, obj);
            } catch (IOException e) {
                throw new JsonIOException(e);
            }
        } finally {
            bVar.setLenient(isLenient);
            bVar.oQ(bZB);
            bVar.oR(bZC);
        }
    }

    public String a(i iVar) {
        StringWriter stringWriter = new StringWriter();
        a(iVar, stringWriter);
        return stringWriter.toString();
    }

    public void a(i iVar, Appendable appendable) throws JsonIOException {
        try {
            a(iVar, c(com.google.gson.internal.g.a(appendable)));
        } catch (IOException e) {
            throw new JsonIOException(e);
        }
    }

    public com.google.gson.stream.b c(Writer writer) throws IOException {
        if (this.ijY) {
            writer.write(")]}'\n");
        }
        com.google.gson.stream.b bVar = new com.google.gson.stream.b(writer);
        if (this.ijZ) {
            bVar.setIndent("  ");
        }
        bVar.oR(this.ijW);
        return bVar;
    }

    public com.google.gson.stream.a c(Reader reader) {
        com.google.gson.stream.a aVar = new com.google.gson.stream.a(reader);
        aVar.setLenient(this.ika);
        return aVar;
    }

    public void a(i iVar, com.google.gson.stream.b bVar) throws JsonIOException {
        boolean isLenient = bVar.isLenient();
        bVar.setLenient(true);
        boolean bZB = bVar.bZB();
        bVar.oQ(this.ijX);
        boolean bZC = bVar.bZC();
        bVar.oR(this.ijW);
        try {
            try {
                com.google.gson.internal.g.b(iVar, bVar);
            } catch (IOException e) {
                throw new JsonIOException(e);
            }
        } finally {
            bVar.setLenient(isLenient);
            bVar.oQ(bZB);
            bVar.oR(bZC);
        }
    }

    public <T> T d(String str, Type type) throws JsonSyntaxException {
        if (str == null) {
            return null;
        }
        return (T) a(new StringReader(str), type);
    }

    public <T> T a(Reader reader, Type type) throws JsonIOException, JsonSyntaxException {
        com.google.gson.stream.a c = c(reader);
        T t = (T) a(c, type);
        a(t, c);
        return t;
    }

    private static void a(Object obj, com.google.gson.stream.a aVar) {
        if (obj != null) {
            try {
                if (aVar.bZe() != JsonToken.END_DOCUMENT) {
                    throw new JsonIOException("JSON document was not fully consumed.");
                }
            } catch (MalformedJsonException e) {
                throw new JsonSyntaxException(e);
            } catch (IOException e2) {
                throw new JsonIOException(e2);
            }
        }
    }

    public <T> T a(com.google.gson.stream.a aVar, Type type) throws JsonIOException, JsonSyntaxException {
        boolean z = true;
        boolean isLenient = aVar.isLenient();
        aVar.setLenient(true);
        try {
            try {
                aVar.bZe();
                z = false;
                T b = a(com.google.gson.b.a.l(type)).b(aVar);
                aVar.setLenient(isLenient);
                return b;
            } catch (EOFException e) {
                if (!z) {
                    throw new JsonSyntaxException(e);
                }
                aVar.setLenient(isLenient);
                return null;
            } catch (IOException e2) {
                throw new JsonSyntaxException(e2);
            } catch (IllegalStateException e3) {
                throw new JsonSyntaxException(e3);
            }
        } catch (Throwable th) {
            aVar.setLenient(isLenient);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a<T> extends o<T> {
        private o<T> ike;

        a() {
        }

        public void c(o<T> oVar) {
            if (this.ike != null) {
                throw new AssertionError();
            }
            this.ike = oVar;
        }

        @Override // com.google.gson.o
        public T b(com.google.gson.stream.a aVar) throws IOException {
            if (this.ike == null) {
                throw new IllegalStateException();
            }
            return this.ike.b(aVar);
        }

        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, T t) throws IOException {
            if (this.ike == null) {
                throw new IllegalStateException();
            }
            this.ike.a(bVar, t);
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.ijW + "factories:" + this.fes + ",instanceCreators:" + this.ijT + "}";
    }
}
