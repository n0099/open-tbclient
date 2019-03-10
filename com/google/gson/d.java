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
    private static final com.google.gson.b.a<?> jNj = new com.google.gson.b.a<Object>() { // from class: com.google.gson.d.1
    };
    private final List<p> gGw;
    private final ThreadLocal<Map<com.google.gson.b.a<?>, a<?>>> jNk;
    private final Map<com.google.gson.b.a<?>, o<?>> jNl;
    private final com.google.gson.internal.b jNm;
    private final com.google.gson.internal.c jNn;
    private final c jNo;
    private final boolean jNp;
    private final boolean jNq;
    private final boolean jNr;
    private final boolean jNs;
    private final boolean jNt;
    private final com.google.gson.internal.a.d jNu;

    public d() {
        this(com.google.gson.internal.c.jNM, FieldNamingPolicy.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, false, LongSerializationPolicy.DEFAULT, Collections.emptyList());
    }

    d(com.google.gson.internal.c cVar, c cVar2, Map<Type, e<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, LongSerializationPolicy longSerializationPolicy, List<p> list) {
        this.jNk = new ThreadLocal<>();
        this.jNl = new ConcurrentHashMap();
        this.jNm = new com.google.gson.internal.b(map);
        this.jNn = cVar;
        this.jNo = cVar2;
        this.jNp = z;
        this.jNr = z3;
        this.jNq = z4;
        this.jNs = z5;
        this.jNt = z6;
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.google.gson.internal.a.n.jQu);
        arrayList.add(com.google.gson.internal.a.h.jOF);
        arrayList.add(cVar);
        arrayList.addAll(list);
        arrayList.add(com.google.gson.internal.a.n.jPZ);
        arrayList.add(com.google.gson.internal.a.n.jPI);
        arrayList.add(com.google.gson.internal.a.n.jPC);
        arrayList.add(com.google.gson.internal.a.n.jPE);
        arrayList.add(com.google.gson.internal.a.n.jPG);
        o<Number> a2 = a(longSerializationPolicy);
        arrayList.add(com.google.gson.internal.a.n.a(Long.TYPE, Long.class, a2));
        arrayList.add(com.google.gson.internal.a.n.a(Double.TYPE, Double.class, rz(z7)));
        arrayList.add(com.google.gson.internal.a.n.a(Float.TYPE, Float.class, rA(z7)));
        arrayList.add(com.google.gson.internal.a.n.jPT);
        arrayList.add(com.google.gson.internal.a.n.jPK);
        arrayList.add(com.google.gson.internal.a.n.jPM);
        arrayList.add(com.google.gson.internal.a.n.a(AtomicLong.class, a(a2)));
        arrayList.add(com.google.gson.internal.a.n.a(AtomicLongArray.class, b(a2)));
        arrayList.add(com.google.gson.internal.a.n.jPO);
        arrayList.add(com.google.gson.internal.a.n.jPV);
        arrayList.add(com.google.gson.internal.a.n.jQb);
        arrayList.add(com.google.gson.internal.a.n.jQd);
        arrayList.add(com.google.gson.internal.a.n.a(BigDecimal.class, com.google.gson.internal.a.n.jPX));
        arrayList.add(com.google.gson.internal.a.n.a(BigInteger.class, com.google.gson.internal.a.n.jPY));
        arrayList.add(com.google.gson.internal.a.n.jQf);
        arrayList.add(com.google.gson.internal.a.n.jQh);
        arrayList.add(com.google.gson.internal.a.n.jQl);
        arrayList.add(com.google.gson.internal.a.n.jQn);
        arrayList.add(com.google.gson.internal.a.n.jQs);
        arrayList.add(com.google.gson.internal.a.n.jQj);
        arrayList.add(com.google.gson.internal.a.n.jPz);
        arrayList.add(com.google.gson.internal.a.c.jOF);
        arrayList.add(com.google.gson.internal.a.n.jQq);
        arrayList.add(com.google.gson.internal.a.k.jOF);
        arrayList.add(com.google.gson.internal.a.j.jOF);
        arrayList.add(com.google.gson.internal.a.n.jQo);
        arrayList.add(com.google.gson.internal.a.a.jOF);
        arrayList.add(com.google.gson.internal.a.n.jPx);
        arrayList.add(new com.google.gson.internal.a.b(this.jNm));
        arrayList.add(new com.google.gson.internal.a.g(this.jNm, z2));
        this.jNu = new com.google.gson.internal.a.d(this.jNm);
        arrayList.add(this.jNu);
        arrayList.add(com.google.gson.internal.a.n.jQv);
        arrayList.add(new com.google.gson.internal.a.i(this.jNm, cVar2, cVar, this.jNu));
        this.gGw = Collections.unmodifiableList(arrayList);
    }

    private o<Number> rz(boolean z) {
        return z ? com.google.gson.internal.a.n.jPR : new o<Number>() { // from class: com.google.gson.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.o
            /* renamed from: a */
            public Double b(com.google.gson.stream.a aVar) throws IOException {
                if (aVar.cBu() == JsonToken.NULL) {
                    aVar.nextNull();
                    return null;
                }
                return Double.valueOf(aVar.nextDouble());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.o
            public void a(com.google.gson.stream.b bVar, Number number) throws IOException {
                if (number == null) {
                    bVar.cBF();
                    return;
                }
                d.q(number.doubleValue());
                bVar.b(number);
            }
        };
    }

    private o<Number> rA(boolean z) {
        return z ? com.google.gson.internal.a.n.jPQ : new o<Number>() { // from class: com.google.gson.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.o
            /* renamed from: c */
            public Float b(com.google.gson.stream.a aVar) throws IOException {
                if (aVar.cBu() == JsonToken.NULL) {
                    aVar.nextNull();
                    return null;
                }
                return Float.valueOf((float) aVar.nextDouble());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.o
            public void a(com.google.gson.stream.b bVar, Number number) throws IOException {
                if (number == null) {
                    bVar.cBF();
                    return;
                }
                d.q(number.floatValue());
                bVar.b(number);
            }
        };
    }

    static void q(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException(d + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private static o<Number> a(LongSerializationPolicy longSerializationPolicy) {
        return longSerializationPolicy == LongSerializationPolicy.DEFAULT ? com.google.gson.internal.a.n.jPP : new o<Number>() { // from class: com.google.gson.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.o
            /* renamed from: d */
            public Number b(com.google.gson.stream.a aVar) throws IOException {
                if (aVar.cBu() == JsonToken.NULL) {
                    aVar.nextNull();
                    return null;
                }
                return Long.valueOf(aVar.nextLong());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.o
            public void a(com.google.gson.stream.b bVar, Number number) throws IOException {
                if (number == null) {
                    bVar.cBF();
                } else {
                    bVar.FT(number.toString());
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
        }.cBc();
    }

    private static o<AtomicLongArray> b(final o<Number> oVar) {
        return new o<AtomicLongArray>() { // from class: com.google.gson.d.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.o
            public void a(com.google.gson.stream.b bVar, AtomicLongArray atomicLongArray) throws IOException {
                bVar.cBB();
                int length = atomicLongArray.length();
                for (int i = 0; i < length; i++) {
                    o.this.a(bVar, Long.valueOf(atomicLongArray.get(i)));
                }
                bVar.cBC();
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
        }.cBc();
    }

    public <T> o<T> a(com.google.gson.b.a<T> aVar) {
        HashMap hashMap;
        o<T> oVar = (o<T>) this.jNl.get(aVar == null ? jNj : aVar);
        if (oVar == null) {
            Map<com.google.gson.b.a<?>, a<?>> map = this.jNk.get();
            boolean z = false;
            if (map == null) {
                HashMap hashMap2 = new HashMap();
                this.jNk.set(hashMap2);
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
                    for (p pVar : this.gGw) {
                        oVar = pVar.a(this, aVar);
                        if (oVar != null) {
                            aVar2.c(oVar);
                            this.jNl.put(aVar, oVar);
                            hashMap.remove(aVar);
                            if (z) {
                                this.jNk.remove();
                            }
                        }
                    }
                    throw new IllegalArgumentException("GSON cannot handle " + aVar);
                } catch (Throwable th) {
                    hashMap.remove(aVar);
                    if (z) {
                        this.jNk.remove();
                    }
                    throw th;
                }
            }
        }
        return oVar;
    }

    public <T> o<T> a(p pVar, com.google.gson.b.a<T> aVar) {
        if (!this.gGw.contains(pVar)) {
            pVar = this.jNu;
        }
        boolean z = false;
        for (p pVar2 : this.gGw) {
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

    public <T> o<T> w(Class<T> cls) {
        return a(com.google.gson.b.a.F(cls));
    }

    public String toJson(Object obj) {
        return obj == null ? a(j.jNz) : b(obj, obj.getClass());
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
        boolean cBR = bVar.cBR();
        bVar.rD(this.jNq);
        boolean cBS = bVar.cBS();
        bVar.rE(this.jNp);
        try {
            try {
                a2.a(bVar, obj);
            } catch (IOException e) {
                throw new JsonIOException(e);
            }
        } finally {
            bVar.setLenient(isLenient);
            bVar.rD(cBR);
            bVar.rE(cBS);
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
        if (this.jNr) {
            writer.write(")]}'\n");
        }
        com.google.gson.stream.b bVar = new com.google.gson.stream.b(writer);
        if (this.jNs) {
            bVar.setIndent("  ");
        }
        bVar.rE(this.jNp);
        return bVar;
    }

    public com.google.gson.stream.a c(Reader reader) {
        com.google.gson.stream.a aVar = new com.google.gson.stream.a(reader);
        aVar.setLenient(this.jNt);
        return aVar;
    }

    public void a(i iVar, com.google.gson.stream.b bVar) throws JsonIOException {
        boolean isLenient = bVar.isLenient();
        bVar.setLenient(true);
        boolean cBR = bVar.cBR();
        bVar.rD(this.jNq);
        boolean cBS = bVar.cBS();
        bVar.rE(this.jNp);
        try {
            try {
                com.google.gson.internal.g.b(iVar, bVar);
            } catch (IOException e) {
                throw new JsonIOException(e);
            }
        } finally {
            bVar.setLenient(isLenient);
            bVar.rD(cBR);
            bVar.rE(cBS);
        }
    }

    public <T> T fromJson(String str, Class<T> cls) throws JsonSyntaxException {
        return (T) com.google.gson.internal.f.B(cls).cast(d(str, cls));
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
                if (aVar.cBu() != JsonToken.END_DOCUMENT) {
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
                aVar.cBu();
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
        private o<T> jNx;

        a() {
        }

        public void c(o<T> oVar) {
            if (this.jNx != null) {
                throw new AssertionError();
            }
            this.jNx = oVar;
        }

        @Override // com.google.gson.o
        public T b(com.google.gson.stream.a aVar) throws IOException {
            if (this.jNx == null) {
                throw new IllegalStateException();
            }
            return this.jNx.b(aVar);
        }

        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, T t) throws IOException {
            if (this.jNx == null) {
                throw new IllegalStateException();
            }
            this.jNx.a(bVar, t);
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.jNp + "factories:" + this.gGw + ",instanceCreators:" + this.jNm + "}";
    }
}
