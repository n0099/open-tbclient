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
    private static final com.google.gson.b.a<?> jNb = new com.google.gson.b.a<Object>() { // from class: com.google.gson.d.1
    };
    private final List<p> gGv;
    private final ThreadLocal<Map<com.google.gson.b.a<?>, a<?>>> jNc;
    private final Map<com.google.gson.b.a<?>, o<?>> jNd;
    private final com.google.gson.internal.b jNe;
    private final com.google.gson.internal.c jNf;
    private final c jNg;
    private final boolean jNh;
    private final boolean jNi;
    private final boolean jNj;
    private final boolean jNk;
    private final boolean jNl;
    private final com.google.gson.internal.a.d jNm;

    public d() {
        this(com.google.gson.internal.c.jNE, FieldNamingPolicy.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, false, LongSerializationPolicy.DEFAULT, Collections.emptyList());
    }

    d(com.google.gson.internal.c cVar, c cVar2, Map<Type, e<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, LongSerializationPolicy longSerializationPolicy, List<p> list) {
        this.jNc = new ThreadLocal<>();
        this.jNd = new ConcurrentHashMap();
        this.jNe = new com.google.gson.internal.b(map);
        this.jNf = cVar;
        this.jNg = cVar2;
        this.jNh = z;
        this.jNj = z3;
        this.jNi = z4;
        this.jNk = z5;
        this.jNl = z6;
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.google.gson.internal.a.n.jQm);
        arrayList.add(com.google.gson.internal.a.h.jOx);
        arrayList.add(cVar);
        arrayList.addAll(list);
        arrayList.add(com.google.gson.internal.a.n.jPR);
        arrayList.add(com.google.gson.internal.a.n.jPA);
        arrayList.add(com.google.gson.internal.a.n.jPu);
        arrayList.add(com.google.gson.internal.a.n.jPw);
        arrayList.add(com.google.gson.internal.a.n.jPy);
        o<Number> a2 = a(longSerializationPolicy);
        arrayList.add(com.google.gson.internal.a.n.a(Long.TYPE, Long.class, a2));
        arrayList.add(com.google.gson.internal.a.n.a(Double.TYPE, Double.class, rz(z7)));
        arrayList.add(com.google.gson.internal.a.n.a(Float.TYPE, Float.class, rA(z7)));
        arrayList.add(com.google.gson.internal.a.n.jPL);
        arrayList.add(com.google.gson.internal.a.n.jPC);
        arrayList.add(com.google.gson.internal.a.n.jPE);
        arrayList.add(com.google.gson.internal.a.n.a(AtomicLong.class, a(a2)));
        arrayList.add(com.google.gson.internal.a.n.a(AtomicLongArray.class, b(a2)));
        arrayList.add(com.google.gson.internal.a.n.jPG);
        arrayList.add(com.google.gson.internal.a.n.jPN);
        arrayList.add(com.google.gson.internal.a.n.jPT);
        arrayList.add(com.google.gson.internal.a.n.jPV);
        arrayList.add(com.google.gson.internal.a.n.a(BigDecimal.class, com.google.gson.internal.a.n.jPP));
        arrayList.add(com.google.gson.internal.a.n.a(BigInteger.class, com.google.gson.internal.a.n.jPQ));
        arrayList.add(com.google.gson.internal.a.n.jPX);
        arrayList.add(com.google.gson.internal.a.n.jPZ);
        arrayList.add(com.google.gson.internal.a.n.jQd);
        arrayList.add(com.google.gson.internal.a.n.jQf);
        arrayList.add(com.google.gson.internal.a.n.jQk);
        arrayList.add(com.google.gson.internal.a.n.jQb);
        arrayList.add(com.google.gson.internal.a.n.jPr);
        arrayList.add(com.google.gson.internal.a.c.jOx);
        arrayList.add(com.google.gson.internal.a.n.jQi);
        arrayList.add(com.google.gson.internal.a.k.jOx);
        arrayList.add(com.google.gson.internal.a.j.jOx);
        arrayList.add(com.google.gson.internal.a.n.jQg);
        arrayList.add(com.google.gson.internal.a.a.jOx);
        arrayList.add(com.google.gson.internal.a.n.jPp);
        arrayList.add(new com.google.gson.internal.a.b(this.jNe));
        arrayList.add(new com.google.gson.internal.a.g(this.jNe, z2));
        this.jNm = new com.google.gson.internal.a.d(this.jNe);
        arrayList.add(this.jNm);
        arrayList.add(com.google.gson.internal.a.n.jQn);
        arrayList.add(new com.google.gson.internal.a.i(this.jNe, cVar2, cVar, this.jNm));
        this.gGv = Collections.unmodifiableList(arrayList);
    }

    private o<Number> rz(boolean z) {
        return z ? com.google.gson.internal.a.n.jPJ : new o<Number>() { // from class: com.google.gson.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.o
            /* renamed from: a */
            public Double b(com.google.gson.stream.a aVar) throws IOException {
                if (aVar.cBx() == JsonToken.NULL) {
                    aVar.nextNull();
                    return null;
                }
                return Double.valueOf(aVar.nextDouble());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.o
            public void a(com.google.gson.stream.b bVar, Number number) throws IOException {
                if (number == null) {
                    bVar.cBI();
                    return;
                }
                d.q(number.doubleValue());
                bVar.b(number);
            }
        };
    }

    private o<Number> rA(boolean z) {
        return z ? com.google.gson.internal.a.n.jPI : new o<Number>() { // from class: com.google.gson.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.o
            /* renamed from: c */
            public Float b(com.google.gson.stream.a aVar) throws IOException {
                if (aVar.cBx() == JsonToken.NULL) {
                    aVar.nextNull();
                    return null;
                }
                return Float.valueOf((float) aVar.nextDouble());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.o
            public void a(com.google.gson.stream.b bVar, Number number) throws IOException {
                if (number == null) {
                    bVar.cBI();
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
        return longSerializationPolicy == LongSerializationPolicy.DEFAULT ? com.google.gson.internal.a.n.jPH : new o<Number>() { // from class: com.google.gson.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.o
            /* renamed from: d */
            public Number b(com.google.gson.stream.a aVar) throws IOException {
                if (aVar.cBx() == JsonToken.NULL) {
                    aVar.nextNull();
                    return null;
                }
                return Long.valueOf(aVar.nextLong());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.o
            public void a(com.google.gson.stream.b bVar, Number number) throws IOException {
                if (number == null) {
                    bVar.cBI();
                } else {
                    bVar.FR(number.toString());
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
        }.cBf();
    }

    private static o<AtomicLongArray> b(final o<Number> oVar) {
        return new o<AtomicLongArray>() { // from class: com.google.gson.d.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.o
            public void a(com.google.gson.stream.b bVar, AtomicLongArray atomicLongArray) throws IOException {
                bVar.cBE();
                int length = atomicLongArray.length();
                for (int i = 0; i < length; i++) {
                    o.this.a(bVar, Long.valueOf(atomicLongArray.get(i)));
                }
                bVar.cBF();
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
        }.cBf();
    }

    public <T> o<T> a(com.google.gson.b.a<T> aVar) {
        HashMap hashMap;
        o<T> oVar = (o<T>) this.jNd.get(aVar == null ? jNb : aVar);
        if (oVar == null) {
            Map<com.google.gson.b.a<?>, a<?>> map = this.jNc.get();
            boolean z = false;
            if (map == null) {
                HashMap hashMap2 = new HashMap();
                this.jNc.set(hashMap2);
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
                    for (p pVar : this.gGv) {
                        oVar = pVar.a(this, aVar);
                        if (oVar != null) {
                            aVar2.c(oVar);
                            this.jNd.put(aVar, oVar);
                            hashMap.remove(aVar);
                            if (z) {
                                this.jNc.remove();
                            }
                        }
                    }
                    throw new IllegalArgumentException("GSON cannot handle " + aVar);
                } catch (Throwable th) {
                    hashMap.remove(aVar);
                    if (z) {
                        this.jNc.remove();
                    }
                    throw th;
                }
            }
        }
        return oVar;
    }

    public <T> o<T> a(p pVar, com.google.gson.b.a<T> aVar) {
        if (!this.gGv.contains(pVar)) {
            pVar = this.jNm;
        }
        boolean z = false;
        for (p pVar2 : this.gGv) {
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
        return obj == null ? a(j.jNr) : b(obj, obj.getClass());
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
        boolean cBU = bVar.cBU();
        bVar.rD(this.jNi);
        boolean cBV = bVar.cBV();
        bVar.rE(this.jNh);
        try {
            try {
                a2.a(bVar, obj);
            } catch (IOException e) {
                throw new JsonIOException(e);
            }
        } finally {
            bVar.setLenient(isLenient);
            bVar.rD(cBU);
            bVar.rE(cBV);
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
        if (this.jNj) {
            writer.write(")]}'\n");
        }
        com.google.gson.stream.b bVar = new com.google.gson.stream.b(writer);
        if (this.jNk) {
            bVar.setIndent("  ");
        }
        bVar.rE(this.jNh);
        return bVar;
    }

    public com.google.gson.stream.a c(Reader reader) {
        com.google.gson.stream.a aVar = new com.google.gson.stream.a(reader);
        aVar.setLenient(this.jNl);
        return aVar;
    }

    public void a(i iVar, com.google.gson.stream.b bVar) throws JsonIOException {
        boolean isLenient = bVar.isLenient();
        bVar.setLenient(true);
        boolean cBU = bVar.cBU();
        bVar.rD(this.jNi);
        boolean cBV = bVar.cBV();
        bVar.rE(this.jNh);
        try {
            try {
                com.google.gson.internal.g.b(iVar, bVar);
            } catch (IOException e) {
                throw new JsonIOException(e);
            }
        } finally {
            bVar.setLenient(isLenient);
            bVar.rD(cBU);
            bVar.rE(cBV);
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
                if (aVar.cBx() != JsonToken.END_DOCUMENT) {
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
                aVar.cBx();
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
        private o<T> jNp;

        a() {
        }

        public void c(o<T> oVar) {
            if (this.jNp != null) {
                throw new AssertionError();
            }
            this.jNp = oVar;
        }

        @Override // com.google.gson.o
        public T b(com.google.gson.stream.a aVar) throws IOException {
            if (this.jNp == null) {
                throw new IllegalStateException();
            }
            return this.jNp.b(aVar);
        }

        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, T t) throws IOException {
            if (this.jNp == null) {
                throw new IllegalStateException();
            }
            this.jNp.a(bVar, t);
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.jNh + "factories:" + this.gGv + ",instanceCreators:" + this.jNe + "}";
    }
}
