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
    private static final com.google.gson.b.a<?> kmq = new com.google.gson.b.a<Object>() { // from class: com.google.gson.d.1
    };
    private final List<o> hdS;
    private final boolean kmA;
    private final com.google.gson.internal.a.d kmB;
    private final ThreadLocal<Map<com.google.gson.b.a<?>, a<?>>> kmr;
    private final Map<com.google.gson.b.a<?>, n<?>> kms;
    private final com.google.gson.internal.b kmt;
    private final com.google.gson.internal.c kmu;
    private final c kmv;
    private final boolean kmw;
    private final boolean kmx;
    private final boolean kmy;
    private final boolean kmz;

    public d() {
        this(com.google.gson.internal.c.kmT, FieldNamingPolicy.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, false, LongSerializationPolicy.DEFAULT, Collections.emptyList());
    }

    d(com.google.gson.internal.c cVar, c cVar2, Map<Type, e<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, LongSerializationPolicy longSerializationPolicy, List<o> list) {
        this.kmr = new ThreadLocal<>();
        this.kms = new ConcurrentHashMap();
        this.kmt = new com.google.gson.internal.b(map);
        this.kmu = cVar;
        this.kmv = cVar2;
        this.kmw = z;
        this.kmy = z3;
        this.kmx = z4;
        this.kmz = z5;
        this.kmA = z6;
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.google.gson.internal.a.m.kpr);
        arrayList.add(com.google.gson.internal.a.g.knK);
        arrayList.add(cVar);
        arrayList.addAll(list);
        arrayList.add(com.google.gson.internal.a.m.koW);
        arrayList.add(com.google.gson.internal.a.m.koF);
        arrayList.add(com.google.gson.internal.a.m.koz);
        arrayList.add(com.google.gson.internal.a.m.koB);
        arrayList.add(com.google.gson.internal.a.m.koD);
        n<Number> a2 = a(longSerializationPolicy);
        arrayList.add(com.google.gson.internal.a.m.a(Long.TYPE, Long.class, a2));
        arrayList.add(com.google.gson.internal.a.m.a(Double.TYPE, Double.class, sE(z7)));
        arrayList.add(com.google.gson.internal.a.m.a(Float.TYPE, Float.class, sF(z7)));
        arrayList.add(com.google.gson.internal.a.m.koQ);
        arrayList.add(com.google.gson.internal.a.m.koH);
        arrayList.add(com.google.gson.internal.a.m.koJ);
        arrayList.add(com.google.gson.internal.a.m.a(AtomicLong.class, a(a2)));
        arrayList.add(com.google.gson.internal.a.m.a(AtomicLongArray.class, b(a2)));
        arrayList.add(com.google.gson.internal.a.m.koL);
        arrayList.add(com.google.gson.internal.a.m.koS);
        arrayList.add(com.google.gson.internal.a.m.koY);
        arrayList.add(com.google.gson.internal.a.m.kpa);
        arrayList.add(com.google.gson.internal.a.m.a(BigDecimal.class, com.google.gson.internal.a.m.koU));
        arrayList.add(com.google.gson.internal.a.m.a(BigInteger.class, com.google.gson.internal.a.m.koV));
        arrayList.add(com.google.gson.internal.a.m.kpc);
        arrayList.add(com.google.gson.internal.a.m.kpe);
        arrayList.add(com.google.gson.internal.a.m.kpi);
        arrayList.add(com.google.gson.internal.a.m.kpk);
        arrayList.add(com.google.gson.internal.a.m.kpp);
        arrayList.add(com.google.gson.internal.a.m.kpg);
        arrayList.add(com.google.gson.internal.a.m.kow);
        arrayList.add(com.google.gson.internal.a.c.knK);
        arrayList.add(com.google.gson.internal.a.m.kpn);
        arrayList.add(com.google.gson.internal.a.j.knK);
        arrayList.add(com.google.gson.internal.a.i.knK);
        arrayList.add(com.google.gson.internal.a.m.kpl);
        arrayList.add(com.google.gson.internal.a.a.knK);
        arrayList.add(com.google.gson.internal.a.m.kou);
        arrayList.add(new com.google.gson.internal.a.b(this.kmt));
        arrayList.add(new com.google.gson.internal.a.f(this.kmt, z2));
        this.kmB = new com.google.gson.internal.a.d(this.kmt);
        arrayList.add(this.kmB);
        arrayList.add(com.google.gson.internal.a.m.kps);
        arrayList.add(new com.google.gson.internal.a.h(this.kmt, cVar2, cVar, this.kmB));
        this.hdS = Collections.unmodifiableList(arrayList);
    }

    private n<Number> sE(boolean z) {
        return z ? com.google.gson.internal.a.m.koO : new n<Number>() { // from class: com.google.gson.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.n
            public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
                if (number == null) {
                    aVar.cMx();
                    return;
                }
                d.q(number.doubleValue());
                aVar.a(number);
            }
        };
    }

    private n<Number> sF(boolean z) {
        return z ? com.google.gson.internal.a.m.koN : new n<Number>() { // from class: com.google.gson.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.n
            public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
                if (number == null) {
                    aVar.cMx();
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
        return longSerializationPolicy == LongSerializationPolicy.DEFAULT ? com.google.gson.internal.a.m.koM : new n<Number>() { // from class: com.google.gson.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.n
            public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
                if (number == null) {
                    aVar.cMx();
                } else {
                    aVar.HX(number.toString());
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
        }.cLZ();
    }

    private static n<AtomicLongArray> b(final n<Number> nVar) {
        return new n<AtomicLongArray>() { // from class: com.google.gson.d.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.n
            public void a(com.google.gson.stream.a aVar, AtomicLongArray atomicLongArray) throws IOException {
                aVar.cMt();
                int length = atomicLongArray.length();
                for (int i = 0; i < length; i++) {
                    n.this.a(aVar, Long.valueOf(atomicLongArray.get(i)));
                }
                aVar.cMu();
            }
        }.cLZ();
    }

    public <T> n<T> a(com.google.gson.b.a<T> aVar) {
        HashMap hashMap;
        n<T> nVar = (n<T>) this.kms.get(aVar == null ? kmq : aVar);
        if (nVar == null) {
            Map<com.google.gson.b.a<?>, a<?>> map = this.kmr.get();
            boolean z = false;
            if (map == null) {
                HashMap hashMap2 = new HashMap();
                this.kmr.set(hashMap2);
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
                    for (o oVar : this.hdS) {
                        nVar = oVar.a(this, aVar);
                        if (nVar != null) {
                            aVar2.c(nVar);
                            this.kms.put(aVar, nVar);
                            hashMap.remove(aVar);
                            if (z) {
                                this.kmr.remove();
                            }
                        }
                    }
                    throw new IllegalArgumentException("GSON cannot handle " + aVar);
                } catch (Throwable th) {
                    hashMap.remove(aVar);
                    if (z) {
                        this.kmr.remove();
                    }
                    throw th;
                }
            }
        }
        return nVar;
    }

    public <T> n<T> a(o oVar, com.google.gson.b.a<T> aVar) {
        if (!this.hdS.contains(oVar)) {
            oVar = this.kmB;
        }
        boolean z = false;
        for (o oVar2 : this.hdS) {
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

    public <T> n<T> x(Class<T> cls) {
        return a(com.google.gson.b.a.E(cls));
    }

    public String toJson(Object obj) {
        return obj == null ? a(i.kmG) : b(obj, obj.getClass());
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
        boolean cMA = aVar.cMA();
        aVar.sH(true);
        boolean cMB = aVar.cMB();
        aVar.sI(this.kmx);
        boolean cMC = aVar.cMC();
        aVar.sJ(this.kmw);
        try {
            try {
                a2.a(aVar, obj);
            } catch (IOException e) {
                throw new JsonIOException(e);
            }
        } finally {
            aVar.sH(cMA);
            aVar.sI(cMB);
            aVar.sJ(cMC);
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
        if (this.kmy) {
            writer.write(")]}'\n");
        }
        com.google.gson.stream.a aVar = new com.google.gson.stream.a(writer);
        if (this.kmz) {
            aVar.HY("  ");
        }
        aVar.sJ(this.kmw);
        return aVar;
    }

    public void a(h hVar, com.google.gson.stream.a aVar) throws JsonIOException {
        boolean cMA = aVar.cMA();
        aVar.sH(true);
        boolean cMB = aVar.cMB();
        aVar.sI(this.kmx);
        boolean cMC = aVar.cMC();
        aVar.sJ(this.kmw);
        try {
            try {
                com.google.gson.internal.f.b(hVar, aVar);
            } catch (IOException e) {
                throw new JsonIOException(e);
            }
        } finally {
            aVar.sH(cMA);
            aVar.sI(cMB);
            aVar.sJ(cMC);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a<T> extends n<T> {
        private n<T> kmE;

        a() {
        }

        public void c(n<T> nVar) {
            if (this.kmE != null) {
                throw new AssertionError();
            }
            this.kmE = nVar;
        }

        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, T t) throws IOException {
            if (this.kmE == null) {
                throw new IllegalStateException();
            }
            this.kmE.a(aVar, t);
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.kmw + "factories:" + this.hdS + ",instanceCreators:" + this.kmt + "}";
    }
}
