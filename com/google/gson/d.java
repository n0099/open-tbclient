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
    private static final com.google.gson.b.a<?> kpT = new com.google.gson.b.a<Object>() { // from class: com.google.gson.d.1
    };
    private final List<o> hgE;
    private final ThreadLocal<Map<com.google.gson.b.a<?>, a<?>>> kpU;
    private final Map<com.google.gson.b.a<?>, n<?>> kpV;
    private final com.google.gson.internal.b kpW;
    private final com.google.gson.internal.c kpX;
    private final c kpY;
    private final boolean kpZ;
    private final boolean kqa;
    private final boolean kqb;
    private final boolean kqc;
    private final boolean kqd;
    private final com.google.gson.internal.a.d kqe;

    public d() {
        this(com.google.gson.internal.c.kqw, FieldNamingPolicy.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, false, LongSerializationPolicy.DEFAULT, Collections.emptyList());
    }

    d(com.google.gson.internal.c cVar, c cVar2, Map<Type, e<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, LongSerializationPolicy longSerializationPolicy, List<o> list) {
        this.kpU = new ThreadLocal<>();
        this.kpV = new ConcurrentHashMap();
        this.kpW = new com.google.gson.internal.b(map);
        this.kpX = cVar;
        this.kpY = cVar2;
        this.kpZ = z;
        this.kqb = z3;
        this.kqa = z4;
        this.kqc = z5;
        this.kqd = z6;
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.google.gson.internal.a.m.ksU);
        arrayList.add(com.google.gson.internal.a.g.krn);
        arrayList.add(cVar);
        arrayList.addAll(list);
        arrayList.add(com.google.gson.internal.a.m.ksz);
        arrayList.add(com.google.gson.internal.a.m.ksi);
        arrayList.add(com.google.gson.internal.a.m.ksc);
        arrayList.add(com.google.gson.internal.a.m.kse);
        arrayList.add(com.google.gson.internal.a.m.ksg);
        n<Number> a2 = a(longSerializationPolicy);
        arrayList.add(com.google.gson.internal.a.m.a(Long.TYPE, Long.class, a2));
        arrayList.add(com.google.gson.internal.a.m.a(Double.TYPE, Double.class, sI(z7)));
        arrayList.add(com.google.gson.internal.a.m.a(Float.TYPE, Float.class, sJ(z7)));
        arrayList.add(com.google.gson.internal.a.m.kst);
        arrayList.add(com.google.gson.internal.a.m.ksk);
        arrayList.add(com.google.gson.internal.a.m.ksm);
        arrayList.add(com.google.gson.internal.a.m.a(AtomicLong.class, a(a2)));
        arrayList.add(com.google.gson.internal.a.m.a(AtomicLongArray.class, b(a2)));
        arrayList.add(com.google.gson.internal.a.m.kso);
        arrayList.add(com.google.gson.internal.a.m.ksv);
        arrayList.add(com.google.gson.internal.a.m.ksB);
        arrayList.add(com.google.gson.internal.a.m.ksD);
        arrayList.add(com.google.gson.internal.a.m.a(BigDecimal.class, com.google.gson.internal.a.m.ksx));
        arrayList.add(com.google.gson.internal.a.m.a(BigInteger.class, com.google.gson.internal.a.m.ksy));
        arrayList.add(com.google.gson.internal.a.m.ksF);
        arrayList.add(com.google.gson.internal.a.m.ksH);
        arrayList.add(com.google.gson.internal.a.m.ksL);
        arrayList.add(com.google.gson.internal.a.m.ksN);
        arrayList.add(com.google.gson.internal.a.m.ksS);
        arrayList.add(com.google.gson.internal.a.m.ksJ);
        arrayList.add(com.google.gson.internal.a.m.krZ);
        arrayList.add(com.google.gson.internal.a.c.krn);
        arrayList.add(com.google.gson.internal.a.m.ksQ);
        arrayList.add(com.google.gson.internal.a.j.krn);
        arrayList.add(com.google.gson.internal.a.i.krn);
        arrayList.add(com.google.gson.internal.a.m.ksO);
        arrayList.add(com.google.gson.internal.a.a.krn);
        arrayList.add(com.google.gson.internal.a.m.krX);
        arrayList.add(new com.google.gson.internal.a.b(this.kpW));
        arrayList.add(new com.google.gson.internal.a.f(this.kpW, z2));
        this.kqe = new com.google.gson.internal.a.d(this.kpW);
        arrayList.add(this.kqe);
        arrayList.add(com.google.gson.internal.a.m.ksV);
        arrayList.add(new com.google.gson.internal.a.h(this.kpW, cVar2, cVar, this.kqe));
        this.hgE = Collections.unmodifiableList(arrayList);
    }

    private n<Number> sI(boolean z) {
        return z ? com.google.gson.internal.a.m.ksr : new n<Number>() { // from class: com.google.gson.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.n
            public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
                if (number == null) {
                    aVar.cNG();
                    return;
                }
                d.q(number.doubleValue());
                aVar.a(number);
            }
        };
    }

    private n<Number> sJ(boolean z) {
        return z ? com.google.gson.internal.a.m.ksq : new n<Number>() { // from class: com.google.gson.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.n
            public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
                if (number == null) {
                    aVar.cNG();
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
        return longSerializationPolicy == LongSerializationPolicy.DEFAULT ? com.google.gson.internal.a.m.ksp : new n<Number>() { // from class: com.google.gson.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.n
            public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
                if (number == null) {
                    aVar.cNG();
                } else {
                    aVar.Iy(number.toString());
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
        }.cNi();
    }

    private static n<AtomicLongArray> b(final n<Number> nVar) {
        return new n<AtomicLongArray>() { // from class: com.google.gson.d.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.n
            public void a(com.google.gson.stream.a aVar, AtomicLongArray atomicLongArray) throws IOException {
                aVar.cNC();
                int length = atomicLongArray.length();
                for (int i = 0; i < length; i++) {
                    n.this.a(aVar, Long.valueOf(atomicLongArray.get(i)));
                }
                aVar.cND();
            }
        }.cNi();
    }

    public <T> n<T> a(com.google.gson.b.a<T> aVar) {
        HashMap hashMap;
        n<T> nVar = (n<T>) this.kpV.get(aVar == null ? kpT : aVar);
        if (nVar == null) {
            Map<com.google.gson.b.a<?>, a<?>> map = this.kpU.get();
            boolean z = false;
            if (map == null) {
                HashMap hashMap2 = new HashMap();
                this.kpU.set(hashMap2);
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
                    for (o oVar : this.hgE) {
                        nVar = oVar.a(this, aVar);
                        if (nVar != null) {
                            aVar2.c(nVar);
                            this.kpV.put(aVar, nVar);
                            hashMap.remove(aVar);
                            if (z) {
                                this.kpU.remove();
                            }
                        }
                    }
                    throw new IllegalArgumentException("GSON cannot handle " + aVar);
                } catch (Throwable th) {
                    hashMap.remove(aVar);
                    if (z) {
                        this.kpU.remove();
                    }
                    throw th;
                }
            }
        }
        return nVar;
    }

    public <T> n<T> a(o oVar, com.google.gson.b.a<T> aVar) {
        if (!this.hgE.contains(oVar)) {
            oVar = this.kqe;
        }
        boolean z = false;
        for (o oVar2 : this.hgE) {
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
        return obj == null ? a(i.kqj) : b(obj, obj.getClass());
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
        boolean cNJ = aVar.cNJ();
        aVar.sL(true);
        boolean cNK = aVar.cNK();
        aVar.sM(this.kqa);
        boolean cNL = aVar.cNL();
        aVar.sN(this.kpZ);
        try {
            try {
                a2.a(aVar, obj);
            } catch (IOException e) {
                throw new JsonIOException(e);
            }
        } finally {
            aVar.sL(cNJ);
            aVar.sM(cNK);
            aVar.sN(cNL);
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
        if (this.kqb) {
            writer.write(")]}'\n");
        }
        com.google.gson.stream.a aVar = new com.google.gson.stream.a(writer);
        if (this.kqc) {
            aVar.Iz("  ");
        }
        aVar.sN(this.kpZ);
        return aVar;
    }

    public void a(h hVar, com.google.gson.stream.a aVar) throws JsonIOException {
        boolean cNJ = aVar.cNJ();
        aVar.sL(true);
        boolean cNK = aVar.cNK();
        aVar.sM(this.kqa);
        boolean cNL = aVar.cNL();
        aVar.sN(this.kpZ);
        try {
            try {
                com.google.gson.internal.f.b(hVar, aVar);
            } catch (IOException e) {
                throw new JsonIOException(e);
            }
        } finally {
            aVar.sL(cNJ);
            aVar.sM(cNK);
            aVar.sN(cNL);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a<T> extends n<T> {
        private n<T> kqh;

        a() {
        }

        public void c(n<T> nVar) {
            if (this.kqh != null) {
                throw new AssertionError();
            }
            this.kqh = nVar;
        }

        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, T t) throws IOException {
            if (this.kqh == null) {
                throw new IllegalStateException();
            }
            this.kqh.a(aVar, t);
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.kpZ + "factories:" + this.hgE + ",instanceCreators:" + this.kpW + "}";
    }
}
