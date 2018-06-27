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
    private final List<n> eLA;
    private final ThreadLocal<Map<com.google.gson.b.a<?>, a<?>>> hMA;
    private final Map<com.google.gson.b.a<?>, m<?>> hMB;
    private final com.google.gson.internal.b hMC;
    private final boolean hMD;
    private final boolean hME;
    private final boolean hMF;
    private final boolean hMG;
    final g hMH;
    final l hMI;

    public d() {
        this(com.google.gson.internal.c.hMY, FieldNamingPolicy.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, LongSerializationPolicy.DEFAULT, Collections.emptyList());
    }

    d(com.google.gson.internal.c cVar, c cVar2, Map<Type, e<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, LongSerializationPolicy longSerializationPolicy, List<n> list) {
        this.hMA = new ThreadLocal<>();
        this.hMB = Collections.synchronizedMap(new HashMap());
        this.hMH = new g() { // from class: com.google.gson.d.1
        };
        this.hMI = new l() { // from class: com.google.gson.d.2
        };
        this.hMC = new com.google.gson.internal.b(map);
        this.hMD = z;
        this.hMF = z3;
        this.hME = z4;
        this.hMG = z5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.google.gson.internal.a.k.hOZ);
        arrayList.add(com.google.gson.internal.a.f.hNE);
        arrayList.add(cVar);
        arrayList.addAll(list);
        arrayList.add(com.google.gson.internal.a.k.hOG);
        arrayList.add(com.google.gson.internal.a.k.hOv);
        arrayList.add(com.google.gson.internal.a.k.hOp);
        arrayList.add(com.google.gson.internal.a.k.hOr);
        arrayList.add(com.google.gson.internal.a.k.hOt);
        arrayList.add(com.google.gson.internal.a.k.a(Long.TYPE, Long.class, a(longSerializationPolicy)));
        arrayList.add(com.google.gson.internal.a.k.a(Double.TYPE, Double.class, oj(z6)));
        arrayList.add(com.google.gson.internal.a.k.a(Float.TYPE, Float.class, ok(z6)));
        arrayList.add(com.google.gson.internal.a.k.hOA);
        arrayList.add(com.google.gson.internal.a.k.hOC);
        arrayList.add(com.google.gson.internal.a.k.hOI);
        arrayList.add(com.google.gson.internal.a.k.hOK);
        arrayList.add(com.google.gson.internal.a.k.a(BigDecimal.class, com.google.gson.internal.a.k.hOE));
        arrayList.add(com.google.gson.internal.a.k.a(BigInteger.class, com.google.gson.internal.a.k.hOF));
        arrayList.add(com.google.gson.internal.a.k.hOM);
        arrayList.add(com.google.gson.internal.a.k.hOO);
        arrayList.add(com.google.gson.internal.a.k.hOS);
        arrayList.add(com.google.gson.internal.a.k.hOX);
        arrayList.add(com.google.gson.internal.a.k.hOQ);
        arrayList.add(com.google.gson.internal.a.k.hOm);
        arrayList.add(com.google.gson.internal.a.c.hNE);
        arrayList.add(com.google.gson.internal.a.k.hOV);
        arrayList.add(com.google.gson.internal.a.i.hNE);
        arrayList.add(com.google.gson.internal.a.h.hNE);
        arrayList.add(com.google.gson.internal.a.k.hOT);
        arrayList.add(com.google.gson.internal.a.a.hNE);
        arrayList.add(com.google.gson.internal.a.k.hPa);
        arrayList.add(com.google.gson.internal.a.k.hOk);
        arrayList.add(new com.google.gson.internal.a.b(this.hMC));
        arrayList.add(new com.google.gson.internal.a.e(this.hMC, z2));
        arrayList.add(new com.google.gson.internal.a.g(this.hMC, cVar2, cVar));
        this.eLA = Collections.unmodifiableList(arrayList);
    }

    private m<Number> oj(boolean z) {
        return z ? com.google.gson.internal.a.k.hOy : new m<Number>() { // from class: com.google.gson.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.m
            public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
                if (number == null) {
                    aVar.bOF();
                    return;
                }
                d.this.r(number.doubleValue());
                aVar.a(number);
            }
        };
    }

    private m<Number> ok(boolean z) {
        return z ? com.google.gson.internal.a.k.hOx : new m<Number>() { // from class: com.google.gson.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.m
            public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
                if (number == null) {
                    aVar.bOF();
                    return;
                }
                d.this.r(number.floatValue());
                aVar.a(number);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException(d + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private m<Number> a(LongSerializationPolicy longSerializationPolicy) {
        return longSerializationPolicy == LongSerializationPolicy.DEFAULT ? com.google.gson.internal.a.k.hOw : new m<Number>() { // from class: com.google.gson.d.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.m
            public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
                if (number == null) {
                    aVar.bOF();
                } else {
                    aVar.xy(number.toString());
                }
            }
        };
    }

    public <T> m<T> a(com.google.gson.b.a<T> aVar) {
        HashMap hashMap;
        m<T> mVar = (m<T>) this.hMB.get(aVar);
        if (mVar == null) {
            Map<com.google.gson.b.a<?>, a<?>> map = this.hMA.get();
            boolean z = false;
            if (map == null) {
                HashMap hashMap2 = new HashMap();
                this.hMA.set(hashMap2);
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
                    for (n nVar : this.eLA) {
                        mVar = nVar.a(this, aVar);
                        if (mVar != null) {
                            aVar2.a(mVar);
                            this.hMB.put(aVar, mVar);
                            hashMap.remove(aVar);
                            if (z) {
                                this.hMA.remove();
                            }
                        }
                    }
                    throw new IllegalArgumentException("GSON cannot handle " + aVar);
                } catch (Throwable th) {
                    hashMap.remove(aVar);
                    if (z) {
                        this.hMA.remove();
                    }
                    throw th;
                }
            }
        }
        return mVar;
    }

    public <T> m<T> a(n nVar, com.google.gson.b.a<T> aVar) {
        boolean z = false;
        for (n nVar2 : this.eLA) {
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
        return obj == null ? a(i.hMM) : b(obj, obj.getClass());
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
        boolean bOJ = aVar.bOJ();
        aVar.om(this.hME);
        boolean bOK = aVar.bOK();
        aVar.on(this.hMD);
        try {
            try {
                a2.a(aVar, obj);
            } catch (IOException e) {
                throw new JsonIOException(e);
            }
        } finally {
            aVar.setLenient(isLenient);
            aVar.om(bOJ);
            aVar.on(bOK);
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
        if (this.hMF) {
            writer.write(")]}'\n");
        }
        com.google.gson.stream.a aVar = new com.google.gson.stream.a(writer);
        if (this.hMG) {
            aVar.setIndent("  ");
        }
        aVar.on(this.hMD);
        return aVar;
    }

    public void a(h hVar, com.google.gson.stream.a aVar) throws JsonIOException {
        boolean isLenient = aVar.isLenient();
        aVar.setLenient(true);
        boolean bOJ = aVar.bOJ();
        aVar.om(this.hME);
        boolean bOK = aVar.bOK();
        aVar.on(this.hMD);
        try {
            try {
                com.google.gson.internal.f.b(hVar, aVar);
            } catch (IOException e) {
                throw new JsonIOException(e);
            }
        } finally {
            aVar.setLenient(isLenient);
            aVar.om(bOJ);
            aVar.on(bOK);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a<T> extends m<T> {
        private m<T> hMK;

        a() {
        }

        public void a(m<T> mVar) {
            if (this.hMK != null) {
                throw new AssertionError();
            }
            this.hMK = mVar;
        }

        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, T t) throws IOException {
            if (this.hMK == null) {
                throw new IllegalStateException();
            }
            this.hMK.a(aVar, t);
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.hMD + "factories:" + this.eLA + ",instanceCreators:" + this.hMC + "}";
    }
}
