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
    private static final com.google.gson.b.a<?> ilB = new com.google.gson.b.a<Object>() { // from class: com.google.gson.d.1
    };
    private final List<p> ffM;
    private final ThreadLocal<Map<com.google.gson.b.a<?>, a<?>>> ilC;
    private final Map<com.google.gson.b.a<?>, o<?>> ilD;
    private final com.google.gson.internal.b ilE;
    private final com.google.gson.internal.c ilF;
    private final c ilG;
    private final boolean ilH;
    private final boolean ilI;
    private final boolean ilJ;
    private final boolean ilK;
    private final boolean ilL;
    private final com.google.gson.internal.a.d ilM;

    public d() {
        this(com.google.gson.internal.c.ime, FieldNamingPolicy.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, false, LongSerializationPolicy.DEFAULT, Collections.emptyList());
    }

    d(com.google.gson.internal.c cVar, c cVar2, Map<Type, e<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, LongSerializationPolicy longSerializationPolicy, List<p> list) {
        this.ilC = new ThreadLocal<>();
        this.ilD = new ConcurrentHashMap();
        this.ilE = new com.google.gson.internal.b(map);
        this.ilF = cVar;
        this.ilG = cVar2;
        this.ilH = z;
        this.ilJ = z3;
        this.ilI = z4;
        this.ilK = z5;
        this.ilL = z6;
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.google.gson.internal.a.n.ioO);
        arrayList.add(com.google.gson.internal.a.h.imY);
        arrayList.add(cVar);
        arrayList.addAll(list);
        arrayList.add(com.google.gson.internal.a.n.iot);
        arrayList.add(com.google.gson.internal.a.n.ioc);
        arrayList.add(com.google.gson.internal.a.n.inW);
        arrayList.add(com.google.gson.internal.a.n.inY);
        arrayList.add(com.google.gson.internal.a.n.ioa);
        o<Number> a2 = a(longSerializationPolicy);
        arrayList.add(com.google.gson.internal.a.n.a(Long.TYPE, Long.class, a2));
        arrayList.add(com.google.gson.internal.a.n.a(Double.TYPE, Double.class, oZ(z7)));
        arrayList.add(com.google.gson.internal.a.n.a(Float.TYPE, Float.class, pa(z7)));
        arrayList.add(com.google.gson.internal.a.n.ion);
        arrayList.add(com.google.gson.internal.a.n.ioe);
        arrayList.add(com.google.gson.internal.a.n.iog);
        arrayList.add(com.google.gson.internal.a.n.a(AtomicLong.class, a(a2)));
        arrayList.add(com.google.gson.internal.a.n.a(AtomicLongArray.class, b(a2)));
        arrayList.add(com.google.gson.internal.a.n.ioi);
        arrayList.add(com.google.gson.internal.a.n.iop);
        arrayList.add(com.google.gson.internal.a.n.iov);
        arrayList.add(com.google.gson.internal.a.n.iox);
        arrayList.add(com.google.gson.internal.a.n.a(BigDecimal.class, com.google.gson.internal.a.n.ior));
        arrayList.add(com.google.gson.internal.a.n.a(BigInteger.class, com.google.gson.internal.a.n.ios));
        arrayList.add(com.google.gson.internal.a.n.ioz);
        arrayList.add(com.google.gson.internal.a.n.ioB);
        arrayList.add(com.google.gson.internal.a.n.ioF);
        arrayList.add(com.google.gson.internal.a.n.ioH);
        arrayList.add(com.google.gson.internal.a.n.ioM);
        arrayList.add(com.google.gson.internal.a.n.ioD);
        arrayList.add(com.google.gson.internal.a.n.inT);
        arrayList.add(com.google.gson.internal.a.c.imY);
        arrayList.add(com.google.gson.internal.a.n.ioK);
        arrayList.add(com.google.gson.internal.a.k.imY);
        arrayList.add(com.google.gson.internal.a.j.imY);
        arrayList.add(com.google.gson.internal.a.n.ioI);
        arrayList.add(com.google.gson.internal.a.a.imY);
        arrayList.add(com.google.gson.internal.a.n.inR);
        arrayList.add(new com.google.gson.internal.a.b(this.ilE));
        arrayList.add(new com.google.gson.internal.a.g(this.ilE, z2));
        this.ilM = new com.google.gson.internal.a.d(this.ilE);
        arrayList.add(this.ilM);
        arrayList.add(com.google.gson.internal.a.n.ioP);
        arrayList.add(new com.google.gson.internal.a.i(this.ilE, cVar2, cVar, this.ilM));
        this.ffM = Collections.unmodifiableList(arrayList);
    }

    private o<Number> oZ(boolean z) {
        return z ? com.google.gson.internal.a.n.iol : new o<Number>() { // from class: com.google.gson.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.o
            /* renamed from: a */
            public Double b(com.google.gson.stream.a aVar) throws IOException {
                if (aVar.bYB() == JsonToken.NULL) {
                    aVar.nextNull();
                    return null;
                }
                return Double.valueOf(aVar.nextDouble());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.o
            public void a(com.google.gson.stream.b bVar, Number number) throws IOException {
                if (number == null) {
                    bVar.bYM();
                    return;
                }
                d.p(number.doubleValue());
                bVar.b(number);
            }
        };
    }

    private o<Number> pa(boolean z) {
        return z ? com.google.gson.internal.a.n.iok : new o<Number>() { // from class: com.google.gson.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.o
            /* renamed from: c */
            public Float b(com.google.gson.stream.a aVar) throws IOException {
                if (aVar.bYB() == JsonToken.NULL) {
                    aVar.nextNull();
                    return null;
                }
                return Float.valueOf((float) aVar.nextDouble());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.o
            public void a(com.google.gson.stream.b bVar, Number number) throws IOException {
                if (number == null) {
                    bVar.bYM();
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
        return longSerializationPolicy == LongSerializationPolicy.DEFAULT ? com.google.gson.internal.a.n.ioj : new o<Number>() { // from class: com.google.gson.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.o
            /* renamed from: d */
            public Number b(com.google.gson.stream.a aVar) throws IOException {
                if (aVar.bYB() == JsonToken.NULL) {
                    aVar.nextNull();
                    return null;
                }
                return Long.valueOf(aVar.nextLong());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.o
            public void a(com.google.gson.stream.b bVar, Number number) throws IOException {
                if (number == null) {
                    bVar.bYM();
                } else {
                    bVar.yR(number.toString());
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
        }.bYj();
    }

    private static o<AtomicLongArray> b(final o<Number> oVar) {
        return new o<AtomicLongArray>() { // from class: com.google.gson.d.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.o
            public void a(com.google.gson.stream.b bVar, AtomicLongArray atomicLongArray) throws IOException {
                bVar.bYI();
                int length = atomicLongArray.length();
                for (int i = 0; i < length; i++) {
                    o.this.a(bVar, Long.valueOf(atomicLongArray.get(i)));
                }
                bVar.bYJ();
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
        }.bYj();
    }

    public <T> o<T> a(com.google.gson.b.a<T> aVar) {
        HashMap hashMap;
        o<T> oVar = (o<T>) this.ilD.get(aVar == null ? ilB : aVar);
        if (oVar == null) {
            Map<com.google.gson.b.a<?>, a<?>> map = this.ilC.get();
            boolean z = false;
            if (map == null) {
                HashMap hashMap2 = new HashMap();
                this.ilC.set(hashMap2);
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
                    for (p pVar : this.ffM) {
                        oVar = pVar.a(this, aVar);
                        if (oVar != null) {
                            aVar2.c(oVar);
                            this.ilD.put(aVar, oVar);
                            hashMap.remove(aVar);
                            if (z) {
                                this.ilC.remove();
                            }
                        }
                    }
                    throw new IllegalArgumentException("GSON cannot handle " + aVar);
                } catch (Throwable th) {
                    hashMap.remove(aVar);
                    if (z) {
                        this.ilC.remove();
                    }
                    throw th;
                }
            }
        }
        return oVar;
    }

    public <T> o<T> a(p pVar, com.google.gson.b.a<T> aVar) {
        if (!this.ffM.contains(pVar)) {
            pVar = this.ilM;
        }
        boolean z = false;
        for (p pVar2 : this.ffM) {
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
        return obj == null ? a(j.ilR) : b(obj, obj.getClass());
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
        boolean bYY = bVar.bYY();
        bVar.pd(this.ilI);
        boolean bYZ = bVar.bYZ();
        bVar.pe(this.ilH);
        try {
            try {
                a2.a(bVar, obj);
            } catch (IOException e) {
                throw new JsonIOException(e);
            }
        } finally {
            bVar.setLenient(isLenient);
            bVar.pd(bYY);
            bVar.pe(bYZ);
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
        if (this.ilJ) {
            writer.write(")]}'\n");
        }
        com.google.gson.stream.b bVar = new com.google.gson.stream.b(writer);
        if (this.ilK) {
            bVar.setIndent("  ");
        }
        bVar.pe(this.ilH);
        return bVar;
    }

    public com.google.gson.stream.a c(Reader reader) {
        com.google.gson.stream.a aVar = new com.google.gson.stream.a(reader);
        aVar.setLenient(this.ilL);
        return aVar;
    }

    public void a(i iVar, com.google.gson.stream.b bVar) throws JsonIOException {
        boolean isLenient = bVar.isLenient();
        bVar.setLenient(true);
        boolean bYY = bVar.bYY();
        bVar.pd(this.ilI);
        boolean bYZ = bVar.bYZ();
        bVar.pe(this.ilH);
        try {
            try {
                com.google.gson.internal.g.b(iVar, bVar);
            } catch (IOException e) {
                throw new JsonIOException(e);
            }
        } finally {
            bVar.setLenient(isLenient);
            bVar.pd(bYY);
            bVar.pe(bYZ);
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
                if (aVar.bYB() != JsonToken.END_DOCUMENT) {
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
                aVar.bYB();
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
        private o<T> ilP;

        a() {
        }

        public void c(o<T> oVar) {
            if (this.ilP != null) {
                throw new AssertionError();
            }
            this.ilP = oVar;
        }

        @Override // com.google.gson.o
        public T b(com.google.gson.stream.a aVar) throws IOException {
            if (this.ilP == null) {
                throw new IllegalStateException();
            }
            return this.ilP.b(aVar);
        }

        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, T t) throws IOException {
            if (this.ilP == null) {
                throw new IllegalStateException();
            }
            this.ilP.a(bVar, t);
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.ilH + "factories:" + this.ffM + ",instanceCreators:" + this.ilE + "}";
    }
}
