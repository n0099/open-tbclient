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
    private static final com.google.gson.b.a<?> kfg = new com.google.gson.b.a<Object>() { // from class: com.google.gson.d.1
    };
    private final List<o> gXD;
    private final ThreadLocal<Map<com.google.gson.b.a<?>, a<?>>> kfh;
    private final Map<com.google.gson.b.a<?>, n<?>> kfi;
    private final com.google.gson.internal.b kfj;
    private final com.google.gson.internal.c kfk;
    private final c kfl;
    private final boolean kfm;
    private final boolean kfn;
    private final boolean kfo;
    private final boolean kfp;
    private final boolean kfq;
    private final com.google.gson.internal.a.d kfr;

    public d() {
        this(com.google.gson.internal.c.kfJ, FieldNamingPolicy.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, false, LongSerializationPolicy.DEFAULT, Collections.emptyList());
    }

    d(com.google.gson.internal.c cVar, c cVar2, Map<Type, e<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, LongSerializationPolicy longSerializationPolicy, List<o> list) {
        this.kfh = new ThreadLocal<>();
        this.kfi = new ConcurrentHashMap();
        this.kfj = new com.google.gson.internal.b(map);
        this.kfk = cVar;
        this.kfl = cVar2;
        this.kfm = z;
        this.kfo = z3;
        this.kfn = z4;
        this.kfp = z5;
        this.kfq = z6;
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.google.gson.internal.a.m.kii);
        arrayList.add(com.google.gson.internal.a.g.kgA);
        arrayList.add(cVar);
        arrayList.addAll(list);
        arrayList.add(com.google.gson.internal.a.m.khM);
        arrayList.add(com.google.gson.internal.a.m.khv);
        arrayList.add(com.google.gson.internal.a.m.khp);
        arrayList.add(com.google.gson.internal.a.m.khr);
        arrayList.add(com.google.gson.internal.a.m.kht);
        n<Number> a2 = a(longSerializationPolicy);
        arrayList.add(com.google.gson.internal.a.m.a(Long.TYPE, Long.class, a2));
        arrayList.add(com.google.gson.internal.a.m.a(Double.TYPE, Double.class, so(z7)));
        arrayList.add(com.google.gson.internal.a.m.a(Float.TYPE, Float.class, sp(z7)));
        arrayList.add(com.google.gson.internal.a.m.khG);
        arrayList.add(com.google.gson.internal.a.m.khx);
        arrayList.add(com.google.gson.internal.a.m.khz);
        arrayList.add(com.google.gson.internal.a.m.a(AtomicLong.class, a(a2)));
        arrayList.add(com.google.gson.internal.a.m.a(AtomicLongArray.class, b(a2)));
        arrayList.add(com.google.gson.internal.a.m.khB);
        arrayList.add(com.google.gson.internal.a.m.khI);
        arrayList.add(com.google.gson.internal.a.m.khO);
        arrayList.add(com.google.gson.internal.a.m.khQ);
        arrayList.add(com.google.gson.internal.a.m.a(BigDecimal.class, com.google.gson.internal.a.m.khK));
        arrayList.add(com.google.gson.internal.a.m.a(BigInteger.class, com.google.gson.internal.a.m.khL));
        arrayList.add(com.google.gson.internal.a.m.khS);
        arrayList.add(com.google.gson.internal.a.m.khU);
        arrayList.add(com.google.gson.internal.a.m.khY);
        arrayList.add(com.google.gson.internal.a.m.kia);
        arrayList.add(com.google.gson.internal.a.m.kig);
        arrayList.add(com.google.gson.internal.a.m.khW);
        arrayList.add(com.google.gson.internal.a.m.khm);
        arrayList.add(com.google.gson.internal.a.c.kgA);
        arrayList.add(com.google.gson.internal.a.m.kie);
        arrayList.add(com.google.gson.internal.a.j.kgA);
        arrayList.add(com.google.gson.internal.a.i.kgA);
        arrayList.add(com.google.gson.internal.a.m.kib);
        arrayList.add(com.google.gson.internal.a.a.kgA);
        arrayList.add(com.google.gson.internal.a.m.khk);
        arrayList.add(new com.google.gson.internal.a.b(this.kfj));
        arrayList.add(new com.google.gson.internal.a.f(this.kfj, z2));
        this.kfr = new com.google.gson.internal.a.d(this.kfj);
        arrayList.add(this.kfr);
        arrayList.add(com.google.gson.internal.a.m.kij);
        arrayList.add(new com.google.gson.internal.a.h(this.kfj, cVar2, cVar, this.kfr));
        this.gXD = Collections.unmodifiableList(arrayList);
    }

    private n<Number> so(boolean z) {
        return z ? com.google.gson.internal.a.m.khE : new n<Number>() { // from class: com.google.gson.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.n
            public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
                if (number == null) {
                    aVar.cJq();
                    return;
                }
                d.q(number.doubleValue());
                aVar.a(number);
            }
        };
    }

    private n<Number> sp(boolean z) {
        return z ? com.google.gson.internal.a.m.khD : new n<Number>() { // from class: com.google.gson.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.n
            public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
                if (number == null) {
                    aVar.cJq();
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
        return longSerializationPolicy == LongSerializationPolicy.DEFAULT ? com.google.gson.internal.a.m.khC : new n<Number>() { // from class: com.google.gson.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.n
            public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
                if (number == null) {
                    aVar.cJq();
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
        }.cIS();
    }

    private static n<AtomicLongArray> b(final n<Number> nVar) {
        return new n<AtomicLongArray>() { // from class: com.google.gson.d.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.n
            public void a(com.google.gson.stream.a aVar, AtomicLongArray atomicLongArray) throws IOException {
                aVar.cJm();
                int length = atomicLongArray.length();
                for (int i = 0; i < length; i++) {
                    n.this.a(aVar, Long.valueOf(atomicLongArray.get(i)));
                }
                aVar.cJn();
            }
        }.cIS();
    }

    public <T> n<T> a(com.google.gson.b.a<T> aVar) {
        HashMap hashMap;
        n<T> nVar = (n<T>) this.kfi.get(aVar == null ? kfg : aVar);
        if (nVar == null) {
            Map<com.google.gson.b.a<?>, a<?>> map = this.kfh.get();
            boolean z = false;
            if (map == null) {
                HashMap hashMap2 = new HashMap();
                this.kfh.set(hashMap2);
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
                    for (o oVar : this.gXD) {
                        nVar = oVar.a(this, aVar);
                        if (nVar != null) {
                            aVar2.c(nVar);
                            this.kfi.put(aVar, nVar);
                            hashMap.remove(aVar);
                            if (z) {
                                this.kfh.remove();
                            }
                        }
                    }
                    throw new IllegalArgumentException("GSON cannot handle " + aVar);
                } catch (Throwable th) {
                    hashMap.remove(aVar);
                    if (z) {
                        this.kfh.remove();
                    }
                    throw th;
                }
            }
        }
        return nVar;
    }

    public <T> n<T> a(o oVar, com.google.gson.b.a<T> aVar) {
        if (!this.gXD.contains(oVar)) {
            oVar = this.kfr;
        }
        boolean z = false;
        for (o oVar2 : this.gXD) {
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
        return obj == null ? a(i.kfw) : b(obj, obj.getClass());
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
        boolean cJt = aVar.cJt();
        aVar.sr(this.kfn);
        boolean cJu = aVar.cJu();
        aVar.ss(this.kfm);
        try {
            try {
                a2.a(aVar, obj);
            } catch (IOException e) {
                throw new JsonIOException(e);
            }
        } finally {
            aVar.setLenient(isLenient);
            aVar.sr(cJt);
            aVar.ss(cJu);
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
        if (this.kfo) {
            writer.write(")]}'\n");
        }
        com.google.gson.stream.a aVar = new com.google.gson.stream.a(writer);
        if (this.kfp) {
            aVar.setIndent("  ");
        }
        aVar.ss(this.kfm);
        return aVar;
    }

    public void a(h hVar, com.google.gson.stream.a aVar) throws JsonIOException {
        boolean isLenient = aVar.isLenient();
        aVar.setLenient(true);
        boolean cJt = aVar.cJt();
        aVar.sr(this.kfn);
        boolean cJu = aVar.cJu();
        aVar.ss(this.kfm);
        try {
            try {
                com.google.gson.internal.f.b(hVar, aVar);
            } catch (IOException e) {
                throw new JsonIOException(e);
            }
        } finally {
            aVar.setLenient(isLenient);
            aVar.sr(cJt);
            aVar.ss(cJu);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a<T> extends n<T> {
        private n<T> kfu;

        a() {
        }

        public void c(n<T> nVar) {
            if (this.kfu != null) {
                throw new AssertionError();
            }
            this.kfu = nVar;
        }

        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, T t) throws IOException {
            if (this.kfu == null) {
                throw new IllegalStateException();
            }
            this.kfu.a(aVar, t);
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.kfm + "factories:" + this.gXD + ",instanceCreators:" + this.kfj + "}";
    }
}
