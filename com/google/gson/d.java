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
    private static final com.google.gson.b.a<?> ixf = new com.google.gson.b.a<Object>() { // from class: com.google.gson.d.1
    };
    private final List<p> fqr;
    private final ThreadLocal<Map<com.google.gson.b.a<?>, a<?>>> ixg;
    private final Map<com.google.gson.b.a<?>, o<?>> ixh;
    private final com.google.gson.internal.b ixi;
    private final com.google.gson.internal.c ixj;
    private final c ixk;
    private final boolean ixl;
    private final boolean ixm;
    private final boolean ixn;
    private final boolean ixo;
    private final boolean ixp;
    private final com.google.gson.internal.a.d ixq;

    public d() {
        this(com.google.gson.internal.c.ixI, FieldNamingPolicy.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, false, LongSerializationPolicy.DEFAULT, Collections.emptyList());
    }

    d(com.google.gson.internal.c cVar, c cVar2, Map<Type, e<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, LongSerializationPolicy longSerializationPolicy, List<p> list) {
        this.ixg = new ThreadLocal<>();
        this.ixh = new ConcurrentHashMap();
        this.ixi = new com.google.gson.internal.b(map);
        this.ixj = cVar;
        this.ixk = cVar2;
        this.ixl = z;
        this.ixn = z3;
        this.ixm = z4;
        this.ixo = z5;
        this.ixp = z6;
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.google.gson.internal.a.n.iAq);
        arrayList.add(com.google.gson.internal.a.h.iyB);
        arrayList.add(cVar);
        arrayList.addAll(list);
        arrayList.add(com.google.gson.internal.a.n.izV);
        arrayList.add(com.google.gson.internal.a.n.izE);
        arrayList.add(com.google.gson.internal.a.n.izy);
        arrayList.add(com.google.gson.internal.a.n.izA);
        arrayList.add(com.google.gson.internal.a.n.izC);
        o<Number> a2 = a(longSerializationPolicy);
        arrayList.add(com.google.gson.internal.a.n.a(Long.TYPE, Long.class, a2));
        arrayList.add(com.google.gson.internal.a.n.a(Double.TYPE, Double.class, pf(z7)));
        arrayList.add(com.google.gson.internal.a.n.a(Float.TYPE, Float.class, pg(z7)));
        arrayList.add(com.google.gson.internal.a.n.izP);
        arrayList.add(com.google.gson.internal.a.n.izG);
        arrayList.add(com.google.gson.internal.a.n.izI);
        arrayList.add(com.google.gson.internal.a.n.a(AtomicLong.class, a(a2)));
        arrayList.add(com.google.gson.internal.a.n.a(AtomicLongArray.class, b(a2)));
        arrayList.add(com.google.gson.internal.a.n.izK);
        arrayList.add(com.google.gson.internal.a.n.izR);
        arrayList.add(com.google.gson.internal.a.n.izX);
        arrayList.add(com.google.gson.internal.a.n.izZ);
        arrayList.add(com.google.gson.internal.a.n.a(BigDecimal.class, com.google.gson.internal.a.n.izT));
        arrayList.add(com.google.gson.internal.a.n.a(BigInteger.class, com.google.gson.internal.a.n.izU));
        arrayList.add(com.google.gson.internal.a.n.iAb);
        arrayList.add(com.google.gson.internal.a.n.iAd);
        arrayList.add(com.google.gson.internal.a.n.iAh);
        arrayList.add(com.google.gson.internal.a.n.iAj);
        arrayList.add(com.google.gson.internal.a.n.iAo);
        arrayList.add(com.google.gson.internal.a.n.iAf);
        arrayList.add(com.google.gson.internal.a.n.izv);
        arrayList.add(com.google.gson.internal.a.c.iyB);
        arrayList.add(com.google.gson.internal.a.n.iAm);
        arrayList.add(com.google.gson.internal.a.k.iyB);
        arrayList.add(com.google.gson.internal.a.j.iyB);
        arrayList.add(com.google.gson.internal.a.n.iAk);
        arrayList.add(com.google.gson.internal.a.a.iyB);
        arrayList.add(com.google.gson.internal.a.n.izt);
        arrayList.add(new com.google.gson.internal.a.b(this.ixi));
        arrayList.add(new com.google.gson.internal.a.g(this.ixi, z2));
        this.ixq = new com.google.gson.internal.a.d(this.ixi);
        arrayList.add(this.ixq);
        arrayList.add(com.google.gson.internal.a.n.iAr);
        arrayList.add(new com.google.gson.internal.a.i(this.ixi, cVar2, cVar, this.ixq));
        this.fqr = Collections.unmodifiableList(arrayList);
    }

    private o<Number> pf(boolean z) {
        return z ? com.google.gson.internal.a.n.izN : new o<Number>() { // from class: com.google.gson.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.o
            /* renamed from: a */
            public Double b(com.google.gson.stream.a aVar) throws IOException {
                if (aVar.ccf() == JsonToken.NULL) {
                    aVar.nextNull();
                    return null;
                }
                return Double.valueOf(aVar.nextDouble());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.o
            public void a(com.google.gson.stream.b bVar, Number number) throws IOException {
                if (number == null) {
                    bVar.ccq();
                    return;
                }
                d.p(number.doubleValue());
                bVar.b(number);
            }
        };
    }

    private o<Number> pg(boolean z) {
        return z ? com.google.gson.internal.a.n.izM : new o<Number>() { // from class: com.google.gson.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.o
            /* renamed from: c */
            public Float b(com.google.gson.stream.a aVar) throws IOException {
                if (aVar.ccf() == JsonToken.NULL) {
                    aVar.nextNull();
                    return null;
                }
                return Float.valueOf((float) aVar.nextDouble());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.o
            public void a(com.google.gson.stream.b bVar, Number number) throws IOException {
                if (number == null) {
                    bVar.ccq();
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
        return longSerializationPolicy == LongSerializationPolicy.DEFAULT ? com.google.gson.internal.a.n.izL : new o<Number>() { // from class: com.google.gson.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.o
            /* renamed from: d */
            public Number b(com.google.gson.stream.a aVar) throws IOException {
                if (aVar.ccf() == JsonToken.NULL) {
                    aVar.nextNull();
                    return null;
                }
                return Long.valueOf(aVar.nextLong());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.o
            public void a(com.google.gson.stream.b bVar, Number number) throws IOException {
                if (number == null) {
                    bVar.ccq();
                } else {
                    bVar.zN(number.toString());
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
        }.cbN();
    }

    private static o<AtomicLongArray> b(final o<Number> oVar) {
        return new o<AtomicLongArray>() { // from class: com.google.gson.d.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.o
            public void a(com.google.gson.stream.b bVar, AtomicLongArray atomicLongArray) throws IOException {
                bVar.ccm();
                int length = atomicLongArray.length();
                for (int i = 0; i < length; i++) {
                    o.this.a(bVar, Long.valueOf(atomicLongArray.get(i)));
                }
                bVar.ccn();
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
        }.cbN();
    }

    public <T> o<T> a(com.google.gson.b.a<T> aVar) {
        HashMap hashMap;
        o<T> oVar = (o<T>) this.ixh.get(aVar == null ? ixf : aVar);
        if (oVar == null) {
            Map<com.google.gson.b.a<?>, a<?>> map = this.ixg.get();
            boolean z = false;
            if (map == null) {
                HashMap hashMap2 = new HashMap();
                this.ixg.set(hashMap2);
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
                    for (p pVar : this.fqr) {
                        oVar = pVar.a(this, aVar);
                        if (oVar != null) {
                            aVar2.c(oVar);
                            this.ixh.put(aVar, oVar);
                            hashMap.remove(aVar);
                            if (z) {
                                this.ixg.remove();
                            }
                        }
                    }
                    throw new IllegalArgumentException("GSON cannot handle " + aVar);
                } catch (Throwable th) {
                    hashMap.remove(aVar);
                    if (z) {
                        this.ixg.remove();
                    }
                    throw th;
                }
            }
        }
        return oVar;
    }

    public <T> o<T> a(p pVar, com.google.gson.b.a<T> aVar) {
        if (!this.fqr.contains(pVar)) {
            pVar = this.ixq;
        }
        boolean z = false;
        for (p pVar2 : this.fqr) {
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
        return a(com.google.gson.b.a.C(cls));
    }

    public String toJson(Object obj) {
        return obj == null ? a(j.ixv) : b(obj, obj.getClass());
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
        boolean ccC = bVar.ccC();
        bVar.pj(this.ixm);
        boolean ccD = bVar.ccD();
        bVar.pk(this.ixl);
        try {
            try {
                a2.a(bVar, obj);
            } catch (IOException e) {
                throw new JsonIOException(e);
            }
        } finally {
            bVar.setLenient(isLenient);
            bVar.pj(ccC);
            bVar.pk(ccD);
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
        if (this.ixn) {
            writer.write(")]}'\n");
        }
        com.google.gson.stream.b bVar = new com.google.gson.stream.b(writer);
        if (this.ixo) {
            bVar.setIndent("  ");
        }
        bVar.pk(this.ixl);
        return bVar;
    }

    public com.google.gson.stream.a c(Reader reader) {
        com.google.gson.stream.a aVar = new com.google.gson.stream.a(reader);
        aVar.setLenient(this.ixp);
        return aVar;
    }

    public void a(i iVar, com.google.gson.stream.b bVar) throws JsonIOException {
        boolean isLenient = bVar.isLenient();
        bVar.setLenient(true);
        boolean ccC = bVar.ccC();
        bVar.pj(this.ixm);
        boolean ccD = bVar.ccD();
        bVar.pk(this.ixl);
        try {
            try {
                com.google.gson.internal.g.b(iVar, bVar);
            } catch (IOException e) {
                throw new JsonIOException(e);
            }
        } finally {
            bVar.setLenient(isLenient);
            bVar.pj(ccC);
            bVar.pk(ccD);
        }
    }

    public <T> T fromJson(String str, Class<T> cls) throws JsonSyntaxException {
        return (T) com.google.gson.internal.f.y(cls).cast(d(str, cls));
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
                if (aVar.ccf() != JsonToken.END_DOCUMENT) {
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
                aVar.ccf();
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
        private o<T> ixt;

        a() {
        }

        public void c(o<T> oVar) {
            if (this.ixt != null) {
                throw new AssertionError();
            }
            this.ixt = oVar;
        }

        @Override // com.google.gson.o
        public T b(com.google.gson.stream.a aVar) throws IOException {
            if (this.ixt == null) {
                throw new IllegalStateException();
            }
            return this.ixt.b(aVar);
        }

        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, T t) throws IOException {
            if (this.ixt == null) {
                throw new IllegalStateException();
            }
            this.ixt.a(bVar, t);
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.ixl + "factories:" + this.fqr + ",instanceCreators:" + this.ixi + "}";
    }
}
