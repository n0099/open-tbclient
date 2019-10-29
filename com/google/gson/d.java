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
    private static final com.google.gson.b.a<?> kof = new com.google.gson.b.a<Object>() { // from class: com.google.gson.d.1
    };
    private final List<o> heJ;
    private final ThreadLocal<Map<com.google.gson.b.a<?>, a<?>>> kog;
    private final Map<com.google.gson.b.a<?>, n<?>> koh;
    private final com.google.gson.internal.b koi;
    private final com.google.gson.internal.c koj;
    private final c kok;
    private final boolean kol;
    private final boolean kom;
    private final boolean kon;
    private final boolean koo;
    private final boolean kop;
    private final com.google.gson.internal.a.d koq;

    public d() {
        this(com.google.gson.internal.c.koI, FieldNamingPolicy.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, false, LongSerializationPolicy.DEFAULT, Collections.emptyList());
    }

    d(com.google.gson.internal.c cVar, c cVar2, Map<Type, e<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, LongSerializationPolicy longSerializationPolicy, List<o> list) {
        this.kog = new ThreadLocal<>();
        this.koh = new ConcurrentHashMap();
        this.koi = new com.google.gson.internal.b(map);
        this.koj = cVar;
        this.kok = cVar2;
        this.kol = z;
        this.kon = z3;
        this.kom = z4;
        this.koo = z5;
        this.kop = z6;
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.google.gson.internal.a.m.krg);
        arrayList.add(com.google.gson.internal.a.g.kpz);
        arrayList.add(cVar);
        arrayList.addAll(list);
        arrayList.add(com.google.gson.internal.a.m.kqL);
        arrayList.add(com.google.gson.internal.a.m.kqu);
        arrayList.add(com.google.gson.internal.a.m.kqo);
        arrayList.add(com.google.gson.internal.a.m.kqq);
        arrayList.add(com.google.gson.internal.a.m.kqs);
        n<Number> a2 = a(longSerializationPolicy);
        arrayList.add(com.google.gson.internal.a.m.a(Long.TYPE, Long.class, a2));
        arrayList.add(com.google.gson.internal.a.m.a(Double.TYPE, Double.class, sn(z7)));
        arrayList.add(com.google.gson.internal.a.m.a(Float.TYPE, Float.class, so(z7)));
        arrayList.add(com.google.gson.internal.a.m.kqF);
        arrayList.add(com.google.gson.internal.a.m.kqw);
        arrayList.add(com.google.gson.internal.a.m.kqy);
        arrayList.add(com.google.gson.internal.a.m.a(AtomicLong.class, a(a2)));
        arrayList.add(com.google.gson.internal.a.m.a(AtomicLongArray.class, b(a2)));
        arrayList.add(com.google.gson.internal.a.m.kqA);
        arrayList.add(com.google.gson.internal.a.m.kqH);
        arrayList.add(com.google.gson.internal.a.m.kqN);
        arrayList.add(com.google.gson.internal.a.m.kqP);
        arrayList.add(com.google.gson.internal.a.m.a(BigDecimal.class, com.google.gson.internal.a.m.kqJ));
        arrayList.add(com.google.gson.internal.a.m.a(BigInteger.class, com.google.gson.internal.a.m.kqK));
        arrayList.add(com.google.gson.internal.a.m.kqR);
        arrayList.add(com.google.gson.internal.a.m.kqT);
        arrayList.add(com.google.gson.internal.a.m.kqX);
        arrayList.add(com.google.gson.internal.a.m.kqZ);
        arrayList.add(com.google.gson.internal.a.m.kre);
        arrayList.add(com.google.gson.internal.a.m.kqV);
        arrayList.add(com.google.gson.internal.a.m.kql);
        arrayList.add(com.google.gson.internal.a.c.kpz);
        arrayList.add(com.google.gson.internal.a.m.krc);
        arrayList.add(com.google.gson.internal.a.j.kpz);
        arrayList.add(com.google.gson.internal.a.i.kpz);
        arrayList.add(com.google.gson.internal.a.m.kra);
        arrayList.add(com.google.gson.internal.a.a.kpz);
        arrayList.add(com.google.gson.internal.a.m.kqj);
        arrayList.add(new com.google.gson.internal.a.b(this.koi));
        arrayList.add(new com.google.gson.internal.a.f(this.koi, z2));
        this.koq = new com.google.gson.internal.a.d(this.koi);
        arrayList.add(this.koq);
        arrayList.add(com.google.gson.internal.a.m.krh);
        arrayList.add(new com.google.gson.internal.a.h(this.koi, cVar2, cVar, this.koq));
        this.heJ = Collections.unmodifiableList(arrayList);
    }

    private n<Number> sn(boolean z) {
        return z ? com.google.gson.internal.a.m.kqD : new n<Number>() { // from class: com.google.gson.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.n
            public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
                if (number == null) {
                    aVar.cKD();
                    return;
                }
                d.q(number.doubleValue());
                aVar.a(number);
            }
        };
    }

    private n<Number> so(boolean z) {
        return z ? com.google.gson.internal.a.m.kqC : new n<Number>() { // from class: com.google.gson.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.n
            public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
                if (number == null) {
                    aVar.cKD();
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
        return longSerializationPolicy == LongSerializationPolicy.DEFAULT ? com.google.gson.internal.a.m.kqB : new n<Number>() { // from class: com.google.gson.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.n
            public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
                if (number == null) {
                    aVar.cKD();
                } else {
                    aVar.GP(number.toString());
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
        }.cKf();
    }

    private static n<AtomicLongArray> b(final n<Number> nVar) {
        return new n<AtomicLongArray>() { // from class: com.google.gson.d.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.n
            public void a(com.google.gson.stream.a aVar, AtomicLongArray atomicLongArray) throws IOException {
                aVar.cKz();
                int length = atomicLongArray.length();
                for (int i = 0; i < length; i++) {
                    n.this.a(aVar, Long.valueOf(atomicLongArray.get(i)));
                }
                aVar.cKA();
            }
        }.cKf();
    }

    public <T> n<T> a(com.google.gson.b.a<T> aVar) {
        HashMap hashMap;
        n<T> nVar = (n<T>) this.koh.get(aVar == null ? kof : aVar);
        if (nVar == null) {
            Map<com.google.gson.b.a<?>, a<?>> map = this.kog.get();
            boolean z = false;
            if (map == null) {
                HashMap hashMap2 = new HashMap();
                this.kog.set(hashMap2);
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
                    for (o oVar : this.heJ) {
                        nVar = oVar.a(this, aVar);
                        if (nVar != null) {
                            aVar2.c(nVar);
                            this.koh.put(aVar, nVar);
                            hashMap.remove(aVar);
                            if (z) {
                                this.kog.remove();
                            }
                        }
                    }
                    throw new IllegalArgumentException("GSON cannot handle " + aVar);
                } catch (Throwable th) {
                    hashMap.remove(aVar);
                    if (z) {
                        this.kog.remove();
                    }
                    throw th;
                }
            }
        }
        return nVar;
    }

    public <T> n<T> a(o oVar, com.google.gson.b.a<T> aVar) {
        if (!this.heJ.contains(oVar)) {
            oVar = this.koq;
        }
        boolean z = false;
        for (o oVar2 : this.heJ) {
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

    public <T> n<T> u(Class<T> cls) {
        return a(com.google.gson.b.a.C(cls));
    }

    public String toJson(Object obj) {
        return obj == null ? a(i.kov) : b(obj, obj.getClass());
    }

    public String b(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        a(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public void a(Object obj, Type type, Appendable appendable) throws JsonIOException {
        try {
            a(obj, type, a(com.google.gson.internal.f.a(appendable)));
        } catch (IOException e) {
            throw new JsonIOException(e);
        }
    }

    public void a(Object obj, Type type, com.google.gson.stream.a aVar) throws JsonIOException {
        n a2 = a(com.google.gson.b.a.l(type));
        boolean cKG = aVar.cKG();
        aVar.sq(true);
        boolean cKH = aVar.cKH();
        aVar.sr(this.kom);
        boolean cKI = aVar.cKI();
        aVar.ss(this.kol);
        try {
            try {
                a2.a(aVar, obj);
            } catch (IOException e) {
                throw new JsonIOException(e);
            }
        } finally {
            aVar.sq(cKG);
            aVar.sr(cKH);
            aVar.ss(cKI);
        }
    }

    public String a(h hVar) {
        StringWriter stringWriter = new StringWriter();
        a(hVar, stringWriter);
        return stringWriter.toString();
    }

    public void a(h hVar, Appendable appendable) throws JsonIOException {
        try {
            a(hVar, a(com.google.gson.internal.f.a(appendable)));
        } catch (IOException e) {
            throw new JsonIOException(e);
        }
    }

    public com.google.gson.stream.a a(Writer writer) throws IOException {
        if (this.kon) {
            writer.write(")]}'\n");
        }
        com.google.gson.stream.a aVar = new com.google.gson.stream.a(writer);
        if (this.koo) {
            aVar.GQ("  ");
        }
        aVar.ss(this.kol);
        return aVar;
    }

    public void a(h hVar, com.google.gson.stream.a aVar) throws JsonIOException {
        boolean cKG = aVar.cKG();
        aVar.sq(true);
        boolean cKH = aVar.cKH();
        aVar.sr(this.kom);
        boolean cKI = aVar.cKI();
        aVar.ss(this.kol);
        try {
            try {
                com.google.gson.internal.f.b(hVar, aVar);
            } catch (IOException e) {
                throw new JsonIOException(e);
            }
        } finally {
            aVar.sq(cKG);
            aVar.sr(cKH);
            aVar.ss(cKI);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a<T> extends n<T> {
        private n<T> kot;

        a() {
        }

        public void c(n<T> nVar) {
            if (this.kot != null) {
                throw new AssertionError();
            }
            this.kot = nVar;
        }

        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, T t) throws IOException {
            if (this.kot == null) {
                throw new IllegalStateException();
            }
            this.kot.a(aVar, t);
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.kol + "factories:" + this.heJ + ",instanceCreators:" + this.koi + "}";
    }
}
