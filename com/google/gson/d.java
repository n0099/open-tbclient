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
    private static final com.google.gson.b.a<?> kfk = new com.google.gson.b.a<Object>() { // from class: com.google.gson.d.1
    };
    private final List<o> gXH;
    private final ThreadLocal<Map<com.google.gson.b.a<?>, a<?>>> kfl;
    private final Map<com.google.gson.b.a<?>, n<?>> kfm;
    private final com.google.gson.internal.b kfn;
    private final com.google.gson.internal.c kfo;
    private final c kfp;
    private final boolean kfq;
    private final boolean kfr;
    private final boolean kfs;
    private final boolean kft;
    private final boolean kfu;
    private final com.google.gson.internal.a.d kfv;

    public d() {
        this(com.google.gson.internal.c.kfN, FieldNamingPolicy.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, false, LongSerializationPolicy.DEFAULT, Collections.emptyList());
    }

    d(com.google.gson.internal.c cVar, c cVar2, Map<Type, e<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, LongSerializationPolicy longSerializationPolicy, List<o> list) {
        this.kfl = new ThreadLocal<>();
        this.kfm = new ConcurrentHashMap();
        this.kfn = new com.google.gson.internal.b(map);
        this.kfo = cVar;
        this.kfp = cVar2;
        this.kfq = z;
        this.kfs = z3;
        this.kfr = z4;
        this.kft = z5;
        this.kfu = z6;
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.google.gson.internal.a.m.kim);
        arrayList.add(com.google.gson.internal.a.g.kgE);
        arrayList.add(cVar);
        arrayList.addAll(list);
        arrayList.add(com.google.gson.internal.a.m.khQ);
        arrayList.add(com.google.gson.internal.a.m.khz);
        arrayList.add(com.google.gson.internal.a.m.kht);
        arrayList.add(com.google.gson.internal.a.m.khv);
        arrayList.add(com.google.gson.internal.a.m.khx);
        n<Number> a2 = a(longSerializationPolicy);
        arrayList.add(com.google.gson.internal.a.m.a(Long.TYPE, Long.class, a2));
        arrayList.add(com.google.gson.internal.a.m.a(Double.TYPE, Double.class, sp(z7)));
        arrayList.add(com.google.gson.internal.a.m.a(Float.TYPE, Float.class, sq(z7)));
        arrayList.add(com.google.gson.internal.a.m.khK);
        arrayList.add(com.google.gson.internal.a.m.khB);
        arrayList.add(com.google.gson.internal.a.m.khD);
        arrayList.add(com.google.gson.internal.a.m.a(AtomicLong.class, a(a2)));
        arrayList.add(com.google.gson.internal.a.m.a(AtomicLongArray.class, b(a2)));
        arrayList.add(com.google.gson.internal.a.m.khF);
        arrayList.add(com.google.gson.internal.a.m.khM);
        arrayList.add(com.google.gson.internal.a.m.khS);
        arrayList.add(com.google.gson.internal.a.m.khU);
        arrayList.add(com.google.gson.internal.a.m.a(BigDecimal.class, com.google.gson.internal.a.m.khO));
        arrayList.add(com.google.gson.internal.a.m.a(BigInteger.class, com.google.gson.internal.a.m.khP));
        arrayList.add(com.google.gson.internal.a.m.khW);
        arrayList.add(com.google.gson.internal.a.m.khY);
        arrayList.add(com.google.gson.internal.a.m.kic);
        arrayList.add(com.google.gson.internal.a.m.kif);
        arrayList.add(com.google.gson.internal.a.m.kik);
        arrayList.add(com.google.gson.internal.a.m.kia);
        arrayList.add(com.google.gson.internal.a.m.khq);
        arrayList.add(com.google.gson.internal.a.c.kgE);
        arrayList.add(com.google.gson.internal.a.m.kii);
        arrayList.add(com.google.gson.internal.a.j.kgE);
        arrayList.add(com.google.gson.internal.a.i.kgE);
        arrayList.add(com.google.gson.internal.a.m.kig);
        arrayList.add(com.google.gson.internal.a.a.kgE);
        arrayList.add(com.google.gson.internal.a.m.kho);
        arrayList.add(new com.google.gson.internal.a.b(this.kfn));
        arrayList.add(new com.google.gson.internal.a.f(this.kfn, z2));
        this.kfv = new com.google.gson.internal.a.d(this.kfn);
        arrayList.add(this.kfv);
        arrayList.add(com.google.gson.internal.a.m.kin);
        arrayList.add(new com.google.gson.internal.a.h(this.kfn, cVar2, cVar, this.kfv));
        this.gXH = Collections.unmodifiableList(arrayList);
    }

    private n<Number> sp(boolean z) {
        return z ? com.google.gson.internal.a.m.khI : new n<Number>() { // from class: com.google.gson.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.n
            public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
                if (number == null) {
                    aVar.cJr();
                    return;
                }
                d.q(number.doubleValue());
                aVar.a(number);
            }
        };
    }

    private n<Number> sq(boolean z) {
        return z ? com.google.gson.internal.a.m.khH : new n<Number>() { // from class: com.google.gson.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.n
            public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
                if (number == null) {
                    aVar.cJr();
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
        return longSerializationPolicy == LongSerializationPolicy.DEFAULT ? com.google.gson.internal.a.m.khG : new n<Number>() { // from class: com.google.gson.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.n
            public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
                if (number == null) {
                    aVar.cJr();
                } else {
                    aVar.Hd(number.toString());
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
        }.cIT();
    }

    private static n<AtomicLongArray> b(final n<Number> nVar) {
        return new n<AtomicLongArray>() { // from class: com.google.gson.d.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.n
            public void a(com.google.gson.stream.a aVar, AtomicLongArray atomicLongArray) throws IOException {
                aVar.cJn();
                int length = atomicLongArray.length();
                for (int i = 0; i < length; i++) {
                    n.this.a(aVar, Long.valueOf(atomicLongArray.get(i)));
                }
                aVar.cJo();
            }
        }.cIT();
    }

    public <T> n<T> a(com.google.gson.b.a<T> aVar) {
        HashMap hashMap;
        n<T> nVar = (n<T>) this.kfm.get(aVar == null ? kfk : aVar);
        if (nVar == null) {
            Map<com.google.gson.b.a<?>, a<?>> map = this.kfl.get();
            boolean z = false;
            if (map == null) {
                HashMap hashMap2 = new HashMap();
                this.kfl.set(hashMap2);
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
                    for (o oVar : this.gXH) {
                        nVar = oVar.a(this, aVar);
                        if (nVar != null) {
                            aVar2.c(nVar);
                            this.kfm.put(aVar, nVar);
                            hashMap.remove(aVar);
                            if (z) {
                                this.kfl.remove();
                            }
                        }
                    }
                    throw new IllegalArgumentException("GSON cannot handle " + aVar);
                } catch (Throwable th) {
                    hashMap.remove(aVar);
                    if (z) {
                        this.kfl.remove();
                    }
                    throw th;
                }
            }
        }
        return nVar;
    }

    public <T> n<T> a(o oVar, com.google.gson.b.a<T> aVar) {
        if (!this.gXH.contains(oVar)) {
            oVar = this.kfv;
        }
        boolean z = false;
        for (o oVar2 : this.gXH) {
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
        return obj == null ? a(i.kfA) : b(obj, obj.getClass());
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
        boolean cJu = aVar.cJu();
        aVar.ss(this.kfr);
        boolean cJv = aVar.cJv();
        aVar.st(this.kfq);
        try {
            try {
                a2.a(aVar, obj);
            } catch (IOException e) {
                throw new JsonIOException(e);
            }
        } finally {
            aVar.setLenient(isLenient);
            aVar.ss(cJu);
            aVar.st(cJv);
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
        if (this.kfs) {
            writer.write(")]}'\n");
        }
        com.google.gson.stream.a aVar = new com.google.gson.stream.a(writer);
        if (this.kft) {
            aVar.setIndent("  ");
        }
        aVar.st(this.kfq);
        return aVar;
    }

    public void a(h hVar, com.google.gson.stream.a aVar) throws JsonIOException {
        boolean isLenient = aVar.isLenient();
        aVar.setLenient(true);
        boolean cJu = aVar.cJu();
        aVar.ss(this.kfr);
        boolean cJv = aVar.cJv();
        aVar.st(this.kfq);
        try {
            try {
                com.google.gson.internal.f.b(hVar, aVar);
            } catch (IOException e) {
                throw new JsonIOException(e);
            }
        } finally {
            aVar.setLenient(isLenient);
            aVar.ss(cJu);
            aVar.st(cJv);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a<T> extends n<T> {
        private n<T> kfy;

        a() {
        }

        public void c(n<T> nVar) {
            if (this.kfy != null) {
                throw new AssertionError();
            }
            this.kfy = nVar;
        }

        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, T t) throws IOException {
            if (this.kfy == null) {
                throw new IllegalStateException();
            }
            this.kfy.a(aVar, t);
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.kfq + "factories:" + this.gXH + ",instanceCreators:" + this.kfn + "}";
    }
}
