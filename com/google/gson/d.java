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
/* loaded from: classes2.dex */
public final class d {
    private final List<n> ePq;
    private final ThreadLocal<Map<com.google.gson.b.a<?>, a<?>>> hFe;
    private final Map<com.google.gson.b.a<?>, m<?>> hFf;
    private final com.google.gson.internal.b hFg;
    private final boolean hFh;
    private final boolean hFi;
    private final boolean hFj;
    private final boolean hFk;
    final g hFl;
    final l hFm;

    public d() {
        this(com.google.gson.internal.c.hFC, FieldNamingPolicy.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, LongSerializationPolicy.DEFAULT, Collections.emptyList());
    }

    d(com.google.gson.internal.c cVar, c cVar2, Map<Type, e<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, LongSerializationPolicy longSerializationPolicy, List<n> list) {
        this.hFe = new ThreadLocal<>();
        this.hFf = Collections.synchronizedMap(new HashMap());
        this.hFl = new g() { // from class: com.google.gson.d.1
        };
        this.hFm = new l() { // from class: com.google.gson.d.2
        };
        this.hFg = new com.google.gson.internal.b(map);
        this.hFh = z;
        this.hFj = z3;
        this.hFi = z4;
        this.hFk = z5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.google.gson.internal.a.k.hHE);
        arrayList.add(com.google.gson.internal.a.f.hGj);
        arrayList.add(cVar);
        arrayList.addAll(list);
        arrayList.add(com.google.gson.internal.a.k.hHl);
        arrayList.add(com.google.gson.internal.a.k.hHa);
        arrayList.add(com.google.gson.internal.a.k.hGU);
        arrayList.add(com.google.gson.internal.a.k.hGW);
        arrayList.add(com.google.gson.internal.a.k.hGY);
        arrayList.add(com.google.gson.internal.a.k.a(Long.TYPE, Long.class, a(longSerializationPolicy)));
        arrayList.add(com.google.gson.internal.a.k.a(Double.TYPE, Double.class, nJ(z6)));
        arrayList.add(com.google.gson.internal.a.k.a(Float.TYPE, Float.class, nK(z6)));
        arrayList.add(com.google.gson.internal.a.k.hHf);
        arrayList.add(com.google.gson.internal.a.k.hHh);
        arrayList.add(com.google.gson.internal.a.k.hHn);
        arrayList.add(com.google.gson.internal.a.k.hHp);
        arrayList.add(com.google.gson.internal.a.k.a(BigDecimal.class, com.google.gson.internal.a.k.hHj));
        arrayList.add(com.google.gson.internal.a.k.a(BigInteger.class, com.google.gson.internal.a.k.hHk));
        arrayList.add(com.google.gson.internal.a.k.hHr);
        arrayList.add(com.google.gson.internal.a.k.hHt);
        arrayList.add(com.google.gson.internal.a.k.hHx);
        arrayList.add(com.google.gson.internal.a.k.hHC);
        arrayList.add(com.google.gson.internal.a.k.hHv);
        arrayList.add(com.google.gson.internal.a.k.hGR);
        arrayList.add(com.google.gson.internal.a.c.hGj);
        arrayList.add(com.google.gson.internal.a.k.hHA);
        arrayList.add(com.google.gson.internal.a.i.hGj);
        arrayList.add(com.google.gson.internal.a.h.hGj);
        arrayList.add(com.google.gson.internal.a.k.hHy);
        arrayList.add(com.google.gson.internal.a.a.hGj);
        arrayList.add(com.google.gson.internal.a.k.hHF);
        arrayList.add(com.google.gson.internal.a.k.hGP);
        arrayList.add(new com.google.gson.internal.a.b(this.hFg));
        arrayList.add(new com.google.gson.internal.a.e(this.hFg, z2));
        arrayList.add(new com.google.gson.internal.a.g(this.hFg, cVar2, cVar));
        this.ePq = Collections.unmodifiableList(arrayList);
    }

    private m<Number> nJ(boolean z) {
        return z ? com.google.gson.internal.a.k.hHd : new m<Number>() { // from class: com.google.gson.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.m
            public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
                if (number == null) {
                    aVar.bKp();
                    return;
                }
                d.this.p(number.doubleValue());
                aVar.b(number);
            }
        };
    }

    private m<Number> nK(boolean z) {
        return z ? com.google.gson.internal.a.k.hHc : new m<Number>() { // from class: com.google.gson.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.m
            public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
                if (number == null) {
                    aVar.bKp();
                    return;
                }
                d.this.p(number.floatValue());
                aVar.b(number);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException(d + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private m<Number> a(LongSerializationPolicy longSerializationPolicy) {
        return longSerializationPolicy == LongSerializationPolicy.DEFAULT ? com.google.gson.internal.a.k.hHb : new m<Number>() { // from class: com.google.gson.d.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.m
            public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
                if (number == null) {
                    aVar.bKp();
                } else {
                    aVar.wF(number.toString());
                }
            }
        };
    }

    public <T> m<T> a(com.google.gson.b.a<T> aVar) {
        HashMap hashMap;
        m<T> mVar = (m<T>) this.hFf.get(aVar);
        if (mVar == null) {
            Map<com.google.gson.b.a<?>, a<?>> map = this.hFe.get();
            boolean z = false;
            if (map == null) {
                HashMap hashMap2 = new HashMap();
                this.hFe.set(hashMap2);
                hashMap = hashMap2;
                z = true;
            } else {
                hashMap = map;
            }
            mVar = hashMap.get(aVar);
            if (mVar == null) {
                try {
                    a<?> aVar2 = new a<>();
                    hashMap.put(aVar, aVar2);
                    for (n nVar : this.ePq) {
                        mVar = nVar.a(this, aVar);
                        if (mVar != null) {
                            aVar2.a(mVar);
                            this.hFf.put(aVar, mVar);
                            hashMap.remove(aVar);
                            if (z) {
                                this.hFe.remove();
                            }
                        }
                    }
                    throw new IllegalArgumentException("GSON cannot handle " + aVar);
                } catch (Throwable th) {
                    hashMap.remove(aVar);
                    if (z) {
                        this.hFe.remove();
                    }
                    throw th;
                }
            }
        }
        return mVar;
    }

    public <T> m<T> a(n nVar, com.google.gson.b.a<T> aVar) {
        boolean z = false;
        for (n nVar2 : this.ePq) {
            if (!z) {
                if (nVar2 == nVar) {
                    z = true;
                }
            } else {
                m<T> a2 = nVar2.a(this, aVar);
                if (a2 != null) {
                    return a2;
                }
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + aVar);
    }

    public <T> m<T> o(Class<T> cls) {
        return a(com.google.gson.b.a.u(cls));
    }

    public String toJson(Object obj) {
        return obj == null ? a(i.hFq) : b(obj, obj.getClass());
    }

    public String b(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        a(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public void a(Object obj, Type type, Appendable appendable) throws JsonIOException {
        try {
            a(obj, type, c(com.google.gson.internal.f.a(appendable)));
        } catch (IOException e) {
            throw new JsonIOException(e);
        }
    }

    public void a(Object obj, Type type, com.google.gson.stream.a aVar) throws JsonIOException {
        m a2 = a(com.google.gson.b.a.l(type));
        boolean isLenient = aVar.isLenient();
        aVar.setLenient(true);
        boolean bKt = aVar.bKt();
        aVar.nM(this.hFi);
        boolean bKu = aVar.bKu();
        aVar.nN(this.hFh);
        try {
            try {
                a2.a(aVar, obj);
            } catch (IOException e) {
                throw new JsonIOException(e);
            }
        } finally {
            aVar.setLenient(isLenient);
            aVar.nM(bKt);
            aVar.nN(bKu);
        }
    }

    public String a(h hVar) {
        StringWriter stringWriter = new StringWriter();
        a(hVar, stringWriter);
        return stringWriter.toString();
    }

    public void a(h hVar, Appendable appendable) throws JsonIOException {
        try {
            a(hVar, c(com.google.gson.internal.f.a(appendable)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private com.google.gson.stream.a c(Writer writer) throws IOException {
        if (this.hFj) {
            writer.write(")]}'\n");
        }
        com.google.gson.stream.a aVar = new com.google.gson.stream.a(writer);
        if (this.hFk) {
            aVar.setIndent("  ");
        }
        aVar.nN(this.hFh);
        return aVar;
    }

    public void a(h hVar, com.google.gson.stream.a aVar) throws JsonIOException {
        boolean isLenient = aVar.isLenient();
        aVar.setLenient(true);
        boolean bKt = aVar.bKt();
        aVar.nM(this.hFi);
        boolean bKu = aVar.bKu();
        aVar.nN(this.hFh);
        try {
            try {
                com.google.gson.internal.f.b(hVar, aVar);
            } catch (IOException e) {
                throw new JsonIOException(e);
            }
        } finally {
            aVar.setLenient(isLenient);
            aVar.nM(bKt);
            aVar.nN(bKu);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a<T> extends m<T> {
        private m<T> hFo;

        a() {
        }

        public void a(m<T> mVar) {
            if (this.hFo != null) {
                throw new AssertionError();
            }
            this.hFo = mVar;
        }

        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, T t) throws IOException {
            if (this.hFo == null) {
                throw new IllegalStateException();
            }
            this.hFo.a(aVar, t);
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.hFh + "factories:" + this.ePq + ",instanceCreators:" + this.hFg + "}";
    }
}
