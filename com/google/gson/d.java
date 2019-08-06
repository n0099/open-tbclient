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
    private static final com.google.gson.b.a<?> knw = new com.google.gson.b.a<Object>() { // from class: com.google.gson.d.1
    };
    private final List<o> heK;
    private final com.google.gson.internal.c knA;
    private final c knB;
    private final boolean knC;
    private final boolean knD;
    private final boolean knE;
    private final boolean knF;
    private final boolean knG;
    private final com.google.gson.internal.a.d knH;
    private final ThreadLocal<Map<com.google.gson.b.a<?>, a<?>>> knx;
    private final Map<com.google.gson.b.a<?>, n<?>> kny;
    private final com.google.gson.internal.b knz;

    public d() {
        this(com.google.gson.internal.c.knZ, FieldNamingPolicy.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, false, LongSerializationPolicy.DEFAULT, Collections.emptyList());
    }

    d(com.google.gson.internal.c cVar, c cVar2, Map<Type, e<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, LongSerializationPolicy longSerializationPolicy, List<o> list) {
        this.knx = new ThreadLocal<>();
        this.kny = new ConcurrentHashMap();
        this.knz = new com.google.gson.internal.b(map);
        this.knA = cVar;
        this.knB = cVar2;
        this.knC = z;
        this.knE = z3;
        this.knD = z4;
        this.knF = z5;
        this.knG = z6;
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.google.gson.internal.a.m.kqx);
        arrayList.add(com.google.gson.internal.a.g.koQ);
        arrayList.add(cVar);
        arrayList.addAll(list);
        arrayList.add(com.google.gson.internal.a.m.kqc);
        arrayList.add(com.google.gson.internal.a.m.kpL);
        arrayList.add(com.google.gson.internal.a.m.kpF);
        arrayList.add(com.google.gson.internal.a.m.kpH);
        arrayList.add(com.google.gson.internal.a.m.kpJ);
        n<Number> a2 = a(longSerializationPolicy);
        arrayList.add(com.google.gson.internal.a.m.a(Long.TYPE, Long.class, a2));
        arrayList.add(com.google.gson.internal.a.m.a(Double.TYPE, Double.class, sF(z7)));
        arrayList.add(com.google.gson.internal.a.m.a(Float.TYPE, Float.class, sG(z7)));
        arrayList.add(com.google.gson.internal.a.m.kpW);
        arrayList.add(com.google.gson.internal.a.m.kpN);
        arrayList.add(com.google.gson.internal.a.m.kpP);
        arrayList.add(com.google.gson.internal.a.m.a(AtomicLong.class, a(a2)));
        arrayList.add(com.google.gson.internal.a.m.a(AtomicLongArray.class, b(a2)));
        arrayList.add(com.google.gson.internal.a.m.kpR);
        arrayList.add(com.google.gson.internal.a.m.kpY);
        arrayList.add(com.google.gson.internal.a.m.kqe);
        arrayList.add(com.google.gson.internal.a.m.kqg);
        arrayList.add(com.google.gson.internal.a.m.a(BigDecimal.class, com.google.gson.internal.a.m.kqa));
        arrayList.add(com.google.gson.internal.a.m.a(BigInteger.class, com.google.gson.internal.a.m.kqb));
        arrayList.add(com.google.gson.internal.a.m.kqi);
        arrayList.add(com.google.gson.internal.a.m.kqk);
        arrayList.add(com.google.gson.internal.a.m.kqo);
        arrayList.add(com.google.gson.internal.a.m.kqq);
        arrayList.add(com.google.gson.internal.a.m.kqv);
        arrayList.add(com.google.gson.internal.a.m.kqm);
        arrayList.add(com.google.gson.internal.a.m.kpC);
        arrayList.add(com.google.gson.internal.a.c.koQ);
        arrayList.add(com.google.gson.internal.a.m.kqt);
        arrayList.add(com.google.gson.internal.a.j.koQ);
        arrayList.add(com.google.gson.internal.a.i.koQ);
        arrayList.add(com.google.gson.internal.a.m.kqr);
        arrayList.add(com.google.gson.internal.a.a.koQ);
        arrayList.add(com.google.gson.internal.a.m.kpA);
        arrayList.add(new com.google.gson.internal.a.b(this.knz));
        arrayList.add(new com.google.gson.internal.a.f(this.knz, z2));
        this.knH = new com.google.gson.internal.a.d(this.knz);
        arrayList.add(this.knH);
        arrayList.add(com.google.gson.internal.a.m.kqy);
        arrayList.add(new com.google.gson.internal.a.h(this.knz, cVar2, cVar, this.knH));
        this.heK = Collections.unmodifiableList(arrayList);
    }

    private n<Number> sF(boolean z) {
        return z ? com.google.gson.internal.a.m.kpU : new n<Number>() { // from class: com.google.gson.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.n
            public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
                if (number == null) {
                    aVar.cMS();
                    return;
                }
                d.q(number.doubleValue());
                aVar.a(number);
            }
        };
    }

    private n<Number> sG(boolean z) {
        return z ? com.google.gson.internal.a.m.kpT : new n<Number>() { // from class: com.google.gson.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.n
            public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
                if (number == null) {
                    aVar.cMS();
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
        return longSerializationPolicy == LongSerializationPolicy.DEFAULT ? com.google.gson.internal.a.m.kpS : new n<Number>() { // from class: com.google.gson.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.n
            public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
                if (number == null) {
                    aVar.cMS();
                } else {
                    aVar.HY(number.toString());
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
        }.cMu();
    }

    private static n<AtomicLongArray> b(final n<Number> nVar) {
        return new n<AtomicLongArray>() { // from class: com.google.gson.d.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.n
            public void a(com.google.gson.stream.a aVar, AtomicLongArray atomicLongArray) throws IOException {
                aVar.cMO();
                int length = atomicLongArray.length();
                for (int i = 0; i < length; i++) {
                    n.this.a(aVar, Long.valueOf(atomicLongArray.get(i)));
                }
                aVar.cMP();
            }
        }.cMu();
    }

    public <T> n<T> a(com.google.gson.b.a<T> aVar) {
        HashMap hashMap;
        n<T> nVar = (n<T>) this.kny.get(aVar == null ? knw : aVar);
        if (nVar == null) {
            Map<com.google.gson.b.a<?>, a<?>> map = this.knx.get();
            boolean z = false;
            if (map == null) {
                HashMap hashMap2 = new HashMap();
                this.knx.set(hashMap2);
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
                    for (o oVar : this.heK) {
                        nVar = oVar.a(this, aVar);
                        if (nVar != null) {
                            aVar2.c(nVar);
                            this.kny.put(aVar, nVar);
                            hashMap.remove(aVar);
                            if (z) {
                                this.knx.remove();
                            }
                        }
                    }
                    throw new IllegalArgumentException("GSON cannot handle " + aVar);
                } catch (Throwable th) {
                    hashMap.remove(aVar);
                    if (z) {
                        this.knx.remove();
                    }
                    throw th;
                }
            }
        }
        return nVar;
    }

    public <T> n<T> a(o oVar, com.google.gson.b.a<T> aVar) {
        if (!this.heK.contains(oVar)) {
            oVar = this.knH;
        }
        boolean z = false;
        for (o oVar2 : this.heK) {
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
        return obj == null ? a(i.knM) : b(obj, obj.getClass());
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
        boolean cMV = aVar.cMV();
        aVar.sI(true);
        boolean cMW = aVar.cMW();
        aVar.sJ(this.knD);
        boolean cMX = aVar.cMX();
        aVar.sK(this.knC);
        try {
            try {
                a2.a(aVar, obj);
            } catch (IOException e) {
                throw new JsonIOException(e);
            }
        } finally {
            aVar.sI(cMV);
            aVar.sJ(cMW);
            aVar.sK(cMX);
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
        if (this.knE) {
            writer.write(")]}'\n");
        }
        com.google.gson.stream.a aVar = new com.google.gson.stream.a(writer);
        if (this.knF) {
            aVar.HZ("  ");
        }
        aVar.sK(this.knC);
        return aVar;
    }

    public void a(h hVar, com.google.gson.stream.a aVar) throws JsonIOException {
        boolean cMV = aVar.cMV();
        aVar.sI(true);
        boolean cMW = aVar.cMW();
        aVar.sJ(this.knD);
        boolean cMX = aVar.cMX();
        aVar.sK(this.knC);
        try {
            try {
                com.google.gson.internal.f.b(hVar, aVar);
            } catch (IOException e) {
                throw new JsonIOException(e);
            }
        } finally {
            aVar.sI(cMV);
            aVar.sJ(cMW);
            aVar.sK(cMX);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a<T> extends n<T> {
        private n<T> knK;

        a() {
        }

        public void c(n<T> nVar) {
            if (this.knK != null) {
                throw new AssertionError();
            }
            this.knK = nVar;
        }

        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, T t) throws IOException {
            if (this.knK == null) {
                throw new IllegalStateException();
            }
            this.knK.a(aVar, t);
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.knC + "factories:" + this.heK + ",instanceCreators:" + this.knz + "}";
    }
}
