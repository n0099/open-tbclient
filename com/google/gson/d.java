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
    private static final com.google.gson.b.a<?> kno = new com.google.gson.b.a<Object>() { // from class: com.google.gson.d.1
    };
    private final List<o> hdS;
    private final ThreadLocal<Map<com.google.gson.b.a<?>, a<?>>> knp;
    private final Map<com.google.gson.b.a<?>, n<?>> knq;
    private final com.google.gson.internal.b knr;
    private final com.google.gson.internal.c kns;
    private final c knt;
    private final boolean knu;
    private final boolean knv;
    private final boolean knw;
    private final boolean knx;
    private final boolean kny;
    private final com.google.gson.internal.a.d knz;

    public d() {
        this(com.google.gson.internal.c.knR, FieldNamingPolicy.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, false, LongSerializationPolicy.DEFAULT, Collections.emptyList());
    }

    d(com.google.gson.internal.c cVar, c cVar2, Map<Type, e<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, LongSerializationPolicy longSerializationPolicy, List<o> list) {
        this.knp = new ThreadLocal<>();
        this.knq = new ConcurrentHashMap();
        this.knr = new com.google.gson.internal.b(map);
        this.kns = cVar;
        this.knt = cVar2;
        this.knu = z;
        this.knw = z3;
        this.knv = z4;
        this.knx = z5;
        this.kny = z6;
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.google.gson.internal.a.m.kqp);
        arrayList.add(com.google.gson.internal.a.g.koI);
        arrayList.add(cVar);
        arrayList.addAll(list);
        arrayList.add(com.google.gson.internal.a.m.kpU);
        arrayList.add(com.google.gson.internal.a.m.kpD);
        arrayList.add(com.google.gson.internal.a.m.kpx);
        arrayList.add(com.google.gson.internal.a.m.kpz);
        arrayList.add(com.google.gson.internal.a.m.kpB);
        n<Number> a2 = a(longSerializationPolicy);
        arrayList.add(com.google.gson.internal.a.m.a(Long.TYPE, Long.class, a2));
        arrayList.add(com.google.gson.internal.a.m.a(Double.TYPE, Double.class, sn(z7)));
        arrayList.add(com.google.gson.internal.a.m.a(Float.TYPE, Float.class, so(z7)));
        arrayList.add(com.google.gson.internal.a.m.kpO);
        arrayList.add(com.google.gson.internal.a.m.kpF);
        arrayList.add(com.google.gson.internal.a.m.kpH);
        arrayList.add(com.google.gson.internal.a.m.a(AtomicLong.class, a(a2)));
        arrayList.add(com.google.gson.internal.a.m.a(AtomicLongArray.class, b(a2)));
        arrayList.add(com.google.gson.internal.a.m.kpJ);
        arrayList.add(com.google.gson.internal.a.m.kpQ);
        arrayList.add(com.google.gson.internal.a.m.kpW);
        arrayList.add(com.google.gson.internal.a.m.kpY);
        arrayList.add(com.google.gson.internal.a.m.a(BigDecimal.class, com.google.gson.internal.a.m.kpS));
        arrayList.add(com.google.gson.internal.a.m.a(BigInteger.class, com.google.gson.internal.a.m.kpT));
        arrayList.add(com.google.gson.internal.a.m.kqa);
        arrayList.add(com.google.gson.internal.a.m.kqc);
        arrayList.add(com.google.gson.internal.a.m.kqg);
        arrayList.add(com.google.gson.internal.a.m.kqi);
        arrayList.add(com.google.gson.internal.a.m.kqn);
        arrayList.add(com.google.gson.internal.a.m.kqe);
        arrayList.add(com.google.gson.internal.a.m.kpu);
        arrayList.add(com.google.gson.internal.a.c.koI);
        arrayList.add(com.google.gson.internal.a.m.kql);
        arrayList.add(com.google.gson.internal.a.j.koI);
        arrayList.add(com.google.gson.internal.a.i.koI);
        arrayList.add(com.google.gson.internal.a.m.kqj);
        arrayList.add(com.google.gson.internal.a.a.koI);
        arrayList.add(com.google.gson.internal.a.m.kps);
        arrayList.add(new com.google.gson.internal.a.b(this.knr));
        arrayList.add(new com.google.gson.internal.a.f(this.knr, z2));
        this.knz = new com.google.gson.internal.a.d(this.knr);
        arrayList.add(this.knz);
        arrayList.add(com.google.gson.internal.a.m.kqq);
        arrayList.add(new com.google.gson.internal.a.h(this.knr, cVar2, cVar, this.knz));
        this.hdS = Collections.unmodifiableList(arrayList);
    }

    private n<Number> sn(boolean z) {
        return z ? com.google.gson.internal.a.m.kpM : new n<Number>() { // from class: com.google.gson.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.n
            public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
                if (number == null) {
                    aVar.cKB();
                    return;
                }
                d.q(number.doubleValue());
                aVar.a(number);
            }
        };
    }

    private n<Number> so(boolean z) {
        return z ? com.google.gson.internal.a.m.kpL : new n<Number>() { // from class: com.google.gson.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.n
            public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
                if (number == null) {
                    aVar.cKB();
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
        return longSerializationPolicy == LongSerializationPolicy.DEFAULT ? com.google.gson.internal.a.m.kpK : new n<Number>() { // from class: com.google.gson.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.n
            public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
                if (number == null) {
                    aVar.cKB();
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
        }.cKd();
    }

    private static n<AtomicLongArray> b(final n<Number> nVar) {
        return new n<AtomicLongArray>() { // from class: com.google.gson.d.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.n
            public void a(com.google.gson.stream.a aVar, AtomicLongArray atomicLongArray) throws IOException {
                aVar.cKx();
                int length = atomicLongArray.length();
                for (int i = 0; i < length; i++) {
                    n.this.a(aVar, Long.valueOf(atomicLongArray.get(i)));
                }
                aVar.cKy();
            }
        }.cKd();
    }

    public <T> n<T> a(com.google.gson.b.a<T> aVar) {
        HashMap hashMap;
        n<T> nVar = (n<T>) this.knq.get(aVar == null ? kno : aVar);
        if (nVar == null) {
            Map<com.google.gson.b.a<?>, a<?>> map = this.knp.get();
            boolean z = false;
            if (map == null) {
                HashMap hashMap2 = new HashMap();
                this.knp.set(hashMap2);
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
                            this.knq.put(aVar, nVar);
                            hashMap.remove(aVar);
                            if (z) {
                                this.knp.remove();
                            }
                        }
                    }
                    throw new IllegalArgumentException("GSON cannot handle " + aVar);
                } catch (Throwable th) {
                    hashMap.remove(aVar);
                    if (z) {
                        this.knp.remove();
                    }
                    throw th;
                }
            }
        }
        return nVar;
    }

    public <T> n<T> a(o oVar, com.google.gson.b.a<T> aVar) {
        if (!this.hdS.contains(oVar)) {
            oVar = this.knz;
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

    public <T> n<T> u(Class<T> cls) {
        return a(com.google.gson.b.a.C(cls));
    }

    public String toJson(Object obj) {
        return obj == null ? a(i.knE) : b(obj, obj.getClass());
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
        boolean cKE = aVar.cKE();
        aVar.sq(true);
        boolean cKF = aVar.cKF();
        aVar.sr(this.knv);
        boolean cKG = aVar.cKG();
        aVar.ss(this.knu);
        try {
            try {
                a2.a(aVar, obj);
            } catch (IOException e) {
                throw new JsonIOException(e);
            }
        } finally {
            aVar.sq(cKE);
            aVar.sr(cKF);
            aVar.ss(cKG);
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
        if (this.knw) {
            writer.write(")]}'\n");
        }
        com.google.gson.stream.a aVar = new com.google.gson.stream.a(writer);
        if (this.knx) {
            aVar.GQ("  ");
        }
        aVar.ss(this.knu);
        return aVar;
    }

    public void a(h hVar, com.google.gson.stream.a aVar) throws JsonIOException {
        boolean cKE = aVar.cKE();
        aVar.sq(true);
        boolean cKF = aVar.cKF();
        aVar.sr(this.knv);
        boolean cKG = aVar.cKG();
        aVar.ss(this.knu);
        try {
            try {
                com.google.gson.internal.f.b(hVar, aVar);
            } catch (IOException e) {
                throw new JsonIOException(e);
            }
        } finally {
            aVar.sq(cKE);
            aVar.sr(cKF);
            aVar.ss(cKG);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a<T> extends n<T> {
        private n<T> knC;

        a() {
        }

        public void c(n<T> nVar) {
            if (this.knC != null) {
                throw new AssertionError();
            }
            this.knC = nVar;
        }

        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, T t) throws IOException {
            if (this.knC == null) {
                throw new IllegalStateException();
            }
            this.knC.a(aVar, t);
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.knu + "factories:" + this.hdS + ",instanceCreators:" + this.knr + "}";
    }
}
