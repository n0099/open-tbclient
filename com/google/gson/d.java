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
    private final List<n> eWL;
    private final com.google.gson.internal.b hNA;
    private final boolean hNB;
    private final boolean hNC;
    private final boolean hND;
    private final boolean hNE;
    final g hNF;
    final l hNG;
    private final ThreadLocal<Map<com.google.gson.b.a<?>, a<?>>> hNy;
    private final Map<com.google.gson.b.a<?>, m<?>> hNz;

    public d() {
        this(com.google.gson.internal.c.hNW, FieldNamingPolicy.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, LongSerializationPolicy.DEFAULT, Collections.emptyList());
    }

    d(com.google.gson.internal.c cVar, c cVar2, Map<Type, e<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, LongSerializationPolicy longSerializationPolicy, List<n> list) {
        this.hNy = new ThreadLocal<>();
        this.hNz = Collections.synchronizedMap(new HashMap());
        this.hNF = new g() { // from class: com.google.gson.d.1
        };
        this.hNG = new l() { // from class: com.google.gson.d.2
        };
        this.hNA = new com.google.gson.internal.b(map);
        this.hNB = z;
        this.hND = z3;
        this.hNC = z4;
        this.hNE = z5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.google.gson.internal.a.k.hPY);
        arrayList.add(com.google.gson.internal.a.f.hOD);
        arrayList.add(cVar);
        arrayList.addAll(list);
        arrayList.add(com.google.gson.internal.a.k.hPF);
        arrayList.add(com.google.gson.internal.a.k.hPu);
        arrayList.add(com.google.gson.internal.a.k.hPo);
        arrayList.add(com.google.gson.internal.a.k.hPq);
        arrayList.add(com.google.gson.internal.a.k.hPs);
        arrayList.add(com.google.gson.internal.a.k.a(Long.TYPE, Long.class, a(longSerializationPolicy)));
        arrayList.add(com.google.gson.internal.a.k.a(Double.TYPE, Double.class, og(z6)));
        arrayList.add(com.google.gson.internal.a.k.a(Float.TYPE, Float.class, oh(z6)));
        arrayList.add(com.google.gson.internal.a.k.hPz);
        arrayList.add(com.google.gson.internal.a.k.hPB);
        arrayList.add(com.google.gson.internal.a.k.hPH);
        arrayList.add(com.google.gson.internal.a.k.hPJ);
        arrayList.add(com.google.gson.internal.a.k.a(BigDecimal.class, com.google.gson.internal.a.k.hPD));
        arrayList.add(com.google.gson.internal.a.k.a(BigInteger.class, com.google.gson.internal.a.k.hPE));
        arrayList.add(com.google.gson.internal.a.k.hPL);
        arrayList.add(com.google.gson.internal.a.k.hPN);
        arrayList.add(com.google.gson.internal.a.k.hPR);
        arrayList.add(com.google.gson.internal.a.k.hPW);
        arrayList.add(com.google.gson.internal.a.k.hPP);
        arrayList.add(com.google.gson.internal.a.k.hPl);
        arrayList.add(com.google.gson.internal.a.c.hOD);
        arrayList.add(com.google.gson.internal.a.k.hPU);
        arrayList.add(com.google.gson.internal.a.i.hOD);
        arrayList.add(com.google.gson.internal.a.h.hOD);
        arrayList.add(com.google.gson.internal.a.k.hPS);
        arrayList.add(com.google.gson.internal.a.a.hOD);
        arrayList.add(com.google.gson.internal.a.k.hPZ);
        arrayList.add(com.google.gson.internal.a.k.hPj);
        arrayList.add(new com.google.gson.internal.a.b(this.hNA));
        arrayList.add(new com.google.gson.internal.a.e(this.hNA, z2));
        arrayList.add(new com.google.gson.internal.a.g(this.hNA, cVar2, cVar));
        this.eWL = Collections.unmodifiableList(arrayList);
    }

    private m<Number> og(boolean z) {
        return z ? com.google.gson.internal.a.k.hPx : new m<Number>() { // from class: com.google.gson.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.m
            public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
                if (number == null) {
                    aVar.bNg();
                    return;
                }
                d.this.p(number.doubleValue());
                aVar.b(number);
            }
        };
    }

    private m<Number> oh(boolean z) {
        return z ? com.google.gson.internal.a.k.hPw : new m<Number>() { // from class: com.google.gson.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.m
            public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
                if (number == null) {
                    aVar.bNg();
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
        return longSerializationPolicy == LongSerializationPolicy.DEFAULT ? com.google.gson.internal.a.k.hPv : new m<Number>() { // from class: com.google.gson.d.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.m
            public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
                if (number == null) {
                    aVar.bNg();
                } else {
                    aVar.xq(number.toString());
                }
            }
        };
    }

    public <T> m<T> a(com.google.gson.b.a<T> aVar) {
        HashMap hashMap;
        m<T> mVar = (m<T>) this.hNz.get(aVar);
        if (mVar == null) {
            Map<com.google.gson.b.a<?>, a<?>> map = this.hNy.get();
            boolean z = false;
            if (map == null) {
                HashMap hashMap2 = new HashMap();
                this.hNy.set(hashMap2);
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
                    for (n nVar : this.eWL) {
                        mVar = nVar.a(this, aVar);
                        if (mVar != null) {
                            aVar2.a(mVar);
                            this.hNz.put(aVar, mVar);
                            hashMap.remove(aVar);
                            if (z) {
                                this.hNy.remove();
                            }
                        }
                    }
                    throw new IllegalArgumentException("GSON cannot handle " + aVar);
                } catch (Throwable th) {
                    hashMap.remove(aVar);
                    if (z) {
                        this.hNy.remove();
                    }
                    throw th;
                }
            }
        }
        return mVar;
    }

    public <T> m<T> a(n nVar, com.google.gson.b.a<T> aVar) {
        boolean z = false;
        for (n nVar2 : this.eWL) {
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

    public <T> m<T> r(Class<T> cls) {
        return a(com.google.gson.b.a.x(cls));
    }

    public String toJson(Object obj) {
        return obj == null ? a(i.hNK) : b(obj, obj.getClass());
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
        boolean bNk = aVar.bNk();
        aVar.oj(this.hNC);
        boolean bNl = aVar.bNl();
        aVar.ok(this.hNB);
        try {
            try {
                a2.a(aVar, obj);
            } catch (IOException e) {
                throw new JsonIOException(e);
            }
        } finally {
            aVar.setLenient(isLenient);
            aVar.oj(bNk);
            aVar.ok(bNl);
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
        if (this.hND) {
            writer.write(")]}'\n");
        }
        com.google.gson.stream.a aVar = new com.google.gson.stream.a(writer);
        if (this.hNE) {
            aVar.setIndent("  ");
        }
        aVar.ok(this.hNB);
        return aVar;
    }

    public void a(h hVar, com.google.gson.stream.a aVar) throws JsonIOException {
        boolean isLenient = aVar.isLenient();
        aVar.setLenient(true);
        boolean bNk = aVar.bNk();
        aVar.oj(this.hNC);
        boolean bNl = aVar.bNl();
        aVar.ok(this.hNB);
        try {
            try {
                com.google.gson.internal.f.b(hVar, aVar);
            } catch (IOException e) {
                throw new JsonIOException(e);
            }
        } finally {
            aVar.setLenient(isLenient);
            aVar.oj(bNk);
            aVar.ok(bNl);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a<T> extends m<T> {
        private m<T> hNI;

        a() {
        }

        public void a(m<T> mVar) {
            if (this.hNI != null) {
                throw new AssertionError();
            }
            this.hNI = mVar;
        }

        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, T t) throws IOException {
            if (this.hNI == null) {
                throw new IllegalStateException();
            }
            this.hNI.a(aVar, t);
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.hNB + "factories:" + this.eWL + ",instanceCreators:" + this.hNA + "}";
    }
}
