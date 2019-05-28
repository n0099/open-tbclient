package com.google.gson;

import java.io.IOException;
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
    private static final com.google.gson.b.a<?> kfh = new com.google.gson.b.a<Object>() { // from class: com.google.gson.d.1
    };
    private final List<o> gXG;
    private final ThreadLocal<Map<com.google.gson.b.a<?>, a<?>>> kfi;
    private final Map<com.google.gson.b.a<?>, n<?>> kfj;
    private final com.google.gson.internal.b kfk;
    private final com.google.gson.internal.c kfl;
    private final c kfm;
    private final boolean kfn;
    private final boolean kfo;
    private final boolean kfp;
    private final boolean kfq;
    private final boolean kfr;
    private final com.google.gson.internal.a.d kfs;

    public d() {
        this(com.google.gson.internal.c.kfK, FieldNamingPolicy.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, false, LongSerializationPolicy.DEFAULT, Collections.emptyList());
    }

    d(com.google.gson.internal.c cVar, c cVar2, Map<Type, e<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, LongSerializationPolicy longSerializationPolicy, List<o> list) {
        this.kfi = new ThreadLocal<>();
        this.kfj = new ConcurrentHashMap();
        this.kfk = new com.google.gson.internal.b(map);
        this.kfl = cVar;
        this.kfm = cVar2;
        this.kfn = z;
        this.kfp = z3;
        this.kfo = z4;
        this.kfq = z5;
        this.kfr = z6;
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.google.gson.internal.a.m.kij);
        arrayList.add(com.google.gson.internal.a.g.kgB);
        arrayList.add(cVar);
        arrayList.addAll(list);
        arrayList.add(com.google.gson.internal.a.m.khN);
        arrayList.add(com.google.gson.internal.a.m.khw);
        arrayList.add(com.google.gson.internal.a.m.khq);
        arrayList.add(com.google.gson.internal.a.m.khs);
        arrayList.add(com.google.gson.internal.a.m.khu);
        n<Number> a2 = a(longSerializationPolicy);
        arrayList.add(com.google.gson.internal.a.m.a(Long.TYPE, Long.class, a2));
        arrayList.add(com.google.gson.internal.a.m.a(Double.TYPE, Double.class, so(z7)));
        arrayList.add(com.google.gson.internal.a.m.a(Float.TYPE, Float.class, sp(z7)));
        arrayList.add(com.google.gson.internal.a.m.khH);
        arrayList.add(com.google.gson.internal.a.m.khy);
        arrayList.add(com.google.gson.internal.a.m.khA);
        arrayList.add(com.google.gson.internal.a.m.a(AtomicLong.class, a(a2)));
        arrayList.add(com.google.gson.internal.a.m.a(AtomicLongArray.class, b(a2)));
        arrayList.add(com.google.gson.internal.a.m.khC);
        arrayList.add(com.google.gson.internal.a.m.khJ);
        arrayList.add(com.google.gson.internal.a.m.khP);
        arrayList.add(com.google.gson.internal.a.m.khR);
        arrayList.add(com.google.gson.internal.a.m.a(BigDecimal.class, com.google.gson.internal.a.m.khL));
        arrayList.add(com.google.gson.internal.a.m.a(BigInteger.class, com.google.gson.internal.a.m.khM));
        arrayList.add(com.google.gson.internal.a.m.khT);
        arrayList.add(com.google.gson.internal.a.m.khV);
        arrayList.add(com.google.gson.internal.a.m.khZ);
        arrayList.add(com.google.gson.internal.a.m.kib);
        arrayList.add(com.google.gson.internal.a.m.kih);
        arrayList.add(com.google.gson.internal.a.m.khX);
        arrayList.add(com.google.gson.internal.a.m.khn);
        arrayList.add(com.google.gson.internal.a.c.kgB);
        arrayList.add(com.google.gson.internal.a.m.kif);
        arrayList.add(com.google.gson.internal.a.j.kgB);
        arrayList.add(com.google.gson.internal.a.i.kgB);
        arrayList.add(com.google.gson.internal.a.m.kic);
        arrayList.add(com.google.gson.internal.a.a.kgB);
        arrayList.add(com.google.gson.internal.a.m.khl);
        arrayList.add(new com.google.gson.internal.a.b(this.kfk));
        arrayList.add(new com.google.gson.internal.a.f(this.kfk, z2));
        this.kfs = new com.google.gson.internal.a.d(this.kfk);
        arrayList.add(this.kfs);
        arrayList.add(com.google.gson.internal.a.m.kik);
        arrayList.add(new com.google.gson.internal.a.h(this.kfk, cVar2, cVar, this.kfs));
        this.gXG = Collections.unmodifiableList(arrayList);
    }

    private n<Number> so(boolean z) {
        return z ? com.google.gson.internal.a.m.khF : new n<Number>() { // from class: com.google.gson.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.n
            public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
                if (number == null) {
                    aVar.cJs();
                    return;
                }
                d.q(number.doubleValue());
                aVar.a(number);
            }
        };
    }

    private n<Number> sp(boolean z) {
        return z ? com.google.gson.internal.a.m.khE : new n<Number>() { // from class: com.google.gson.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.n
            public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
                if (number == null) {
                    aVar.cJs();
                    return;
                }
                d.q(number.floatValue());
                aVar.a(number);
            }
        };
    }

    static void q(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException(d + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private static n<Number> a(LongSerializationPolicy longSerializationPolicy) {
        return longSerializationPolicy == LongSerializationPolicy.DEFAULT ? com.google.gson.internal.a.m.khD : new n<Number>() { // from class: com.google.gson.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.n
            public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
                if (number == null) {
                    aVar.cJs();
                } else {
                    aVar.Hb(number.toString());
                }
            }
        };
    }

    private static n<AtomicLong> a(final n<Number> nVar) {
        return new n<AtomicLong>() { // from class: com.google.gson.d.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.n
            public void a(com.google.gson.stream.a aVar, AtomicLong atomicLong) throws IOException {
                n.this.a(aVar, Long.valueOf(atomicLong.get()));
            }
        }.cIU();
    }

    private static n<AtomicLongArray> b(final n<Number> nVar) {
        return new n<AtomicLongArray>() { // from class: com.google.gson.d.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.n
            public void a(com.google.gson.stream.a aVar, AtomicLongArray atomicLongArray) throws IOException {
                aVar.cJo();
                int length = atomicLongArray.length();
                for (int i = 0; i < length; i++) {
                    n.this.a(aVar, Long.valueOf(atomicLongArray.get(i)));
                }
                aVar.cJp();
            }
        }.cIU();
    }

    public <T> n<T> a(com.google.gson.b.a<T> aVar) {
        HashMap hashMap;
        n<T> nVar = (n<T>) this.kfj.get(aVar == null ? kfh : aVar);
        if (nVar == null) {
            Map<com.google.gson.b.a<?>, a<?>> map = this.kfi.get();
            boolean z = false;
            if (map == null) {
                HashMap hashMap2 = new HashMap();
                this.kfi.set(hashMap2);
                hashMap = hashMap2;
                z = true;
            } else {
                hashMap = map;
            }
            nVar = hashMap.get(aVar);
            if (nVar == null) {
                try {
                    a<?> aVar2 = new a<>();
                    hashMap.put(aVar, aVar2);
                    for (o oVar : this.gXG) {
                        nVar = oVar.a(this, aVar);
                        if (nVar != null) {
                            aVar2.c(nVar);
                            this.kfj.put(aVar, nVar);
                            hashMap.remove(aVar);
                            if (z) {
                                this.kfi.remove();
                            }
                        }
                    }
                    throw new IllegalArgumentException("GSON cannot handle " + aVar);
                } catch (Throwable th) {
                    hashMap.remove(aVar);
                    if (z) {
                        this.kfi.remove();
                    }
                    throw th;
                }
            }
        }
        return nVar;
    }

    public <T> n<T> a(o oVar, com.google.gson.b.a<T> aVar) {
        if (!this.gXG.contains(oVar)) {
            oVar = this.kfs;
        }
        boolean z = false;
        for (o oVar2 : this.gXG) {
            if (!z) {
                if (oVar2 == oVar) {
                    z = true;
                }
            } else {
                n<T> a2 = oVar2.a(this, aVar);
                if (a2 != null) {
                    return a2;
                }
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + aVar);
    }

    public <T> n<T> v(Class<T> cls) {
        return a(com.google.gson.b.a.C(cls));
    }

    public String toJson(Object obj) {
        return obj == null ? a(i.kfx) : b(obj, obj.getClass());
    }

    public String b(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        a(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public void a(Object obj, Type type, Appendable appendable) throws JsonIOException {
        try {
            a(obj, type, b(com.google.gson.internal.f.a(appendable)));
        } catch (IOException e) {
            throw new JsonIOException(e);
        }
    }

    public void a(Object obj, Type type, com.google.gson.stream.a aVar) throws JsonIOException {
        n a2 = a(com.google.gson.b.a.l(type));
        boolean isLenient = aVar.isLenient();
        aVar.setLenient(true);
        boolean cJv = aVar.cJv();
        aVar.sr(this.kfo);
        boolean cJw = aVar.cJw();
        aVar.ss(this.kfn);
        try {
            try {
                a2.a(aVar, obj);
            } catch (IOException e) {
                throw new JsonIOException(e);
            }
        } finally {
            aVar.setLenient(isLenient);
            aVar.sr(cJv);
            aVar.ss(cJw);
        }
    }

    public String a(h hVar) {
        StringWriter stringWriter = new StringWriter();
        a(hVar, stringWriter);
        return stringWriter.toString();
    }

    public void a(h hVar, Appendable appendable) throws JsonIOException {
        try {
            a(hVar, b(com.google.gson.internal.f.a(appendable)));
        } catch (IOException e) {
            throw new JsonIOException(e);
        }
    }

    public com.google.gson.stream.a b(Writer writer) throws IOException {
        if (this.kfp) {
            writer.write(")]}'\n");
        }
        com.google.gson.stream.a aVar = new com.google.gson.stream.a(writer);
        if (this.kfq) {
            aVar.setIndent("  ");
        }
        aVar.ss(this.kfn);
        return aVar;
    }

    public void a(h hVar, com.google.gson.stream.a aVar) throws JsonIOException {
        boolean isLenient = aVar.isLenient();
        aVar.setLenient(true);
        boolean cJv = aVar.cJv();
        aVar.sr(this.kfo);
        boolean cJw = aVar.cJw();
        aVar.ss(this.kfn);
        try {
            try {
                com.google.gson.internal.f.b(hVar, aVar);
            } catch (IOException e) {
                throw new JsonIOException(e);
            }
        } finally {
            aVar.setLenient(isLenient);
            aVar.sr(cJv);
            aVar.ss(cJw);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a<T> extends n<T> {
        private n<T> kfv;

        a() {
        }

        public void c(n<T> nVar) {
            if (this.kfv != null) {
                throw new AssertionError();
            }
            this.kfv = nVar;
        }

        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, T t) throws IOException {
            if (this.kfv == null) {
                throw new IllegalStateException();
            }
            this.kfv.a(aVar, t);
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.kfn + "factories:" + this.gXG + ",instanceCreators:" + this.kfk + "}";
    }
}
