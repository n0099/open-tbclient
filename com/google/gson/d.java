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
    private final List<n> ePv;
    private final boolean hFA;
    private final boolean hFB;
    private final boolean hFC;
    private final boolean hFD;
    final g hFE;
    final l hFF;
    private final ThreadLocal<Map<com.google.gson.b.a<?>, a<?>>> hFx;
    private final Map<com.google.gson.b.a<?>, m<?>> hFy;
    private final com.google.gson.internal.b hFz;

    public d() {
        this(com.google.gson.internal.c.hFV, FieldNamingPolicy.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, LongSerializationPolicy.DEFAULT, Collections.emptyList());
    }

    d(com.google.gson.internal.c cVar, c cVar2, Map<Type, e<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, LongSerializationPolicy longSerializationPolicy, List<n> list) {
        this.hFx = new ThreadLocal<>();
        this.hFy = Collections.synchronizedMap(new HashMap());
        this.hFE = new g() { // from class: com.google.gson.d.1
        };
        this.hFF = new l() { // from class: com.google.gson.d.2
        };
        this.hFz = new com.google.gson.internal.b(map);
        this.hFA = z;
        this.hFC = z3;
        this.hFB = z4;
        this.hFD = z5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.google.gson.internal.a.k.hHX);
        arrayList.add(com.google.gson.internal.a.f.hGC);
        arrayList.add(cVar);
        arrayList.addAll(list);
        arrayList.add(com.google.gson.internal.a.k.hHE);
        arrayList.add(com.google.gson.internal.a.k.hHt);
        arrayList.add(com.google.gson.internal.a.k.hHn);
        arrayList.add(com.google.gson.internal.a.k.hHp);
        arrayList.add(com.google.gson.internal.a.k.hHr);
        arrayList.add(com.google.gson.internal.a.k.a(Long.TYPE, Long.class, a(longSerializationPolicy)));
        arrayList.add(com.google.gson.internal.a.k.a(Double.TYPE, Double.class, nJ(z6)));
        arrayList.add(com.google.gson.internal.a.k.a(Float.TYPE, Float.class, nK(z6)));
        arrayList.add(com.google.gson.internal.a.k.hHy);
        arrayList.add(com.google.gson.internal.a.k.hHA);
        arrayList.add(com.google.gson.internal.a.k.hHG);
        arrayList.add(com.google.gson.internal.a.k.hHI);
        arrayList.add(com.google.gson.internal.a.k.a(BigDecimal.class, com.google.gson.internal.a.k.hHC));
        arrayList.add(com.google.gson.internal.a.k.a(BigInteger.class, com.google.gson.internal.a.k.hHD));
        arrayList.add(com.google.gson.internal.a.k.hHK);
        arrayList.add(com.google.gson.internal.a.k.hHM);
        arrayList.add(com.google.gson.internal.a.k.hHQ);
        arrayList.add(com.google.gson.internal.a.k.hHV);
        arrayList.add(com.google.gson.internal.a.k.hHO);
        arrayList.add(com.google.gson.internal.a.k.hHk);
        arrayList.add(com.google.gson.internal.a.c.hGC);
        arrayList.add(com.google.gson.internal.a.k.hHT);
        arrayList.add(com.google.gson.internal.a.i.hGC);
        arrayList.add(com.google.gson.internal.a.h.hGC);
        arrayList.add(com.google.gson.internal.a.k.hHR);
        arrayList.add(com.google.gson.internal.a.a.hGC);
        arrayList.add(com.google.gson.internal.a.k.hHY);
        arrayList.add(com.google.gson.internal.a.k.hHi);
        arrayList.add(new com.google.gson.internal.a.b(this.hFz));
        arrayList.add(new com.google.gson.internal.a.e(this.hFz, z2));
        arrayList.add(new com.google.gson.internal.a.g(this.hFz, cVar2, cVar));
        this.ePv = Collections.unmodifiableList(arrayList);
    }

    private m<Number> nJ(boolean z) {
        return z ? com.google.gson.internal.a.k.hHw : new m<Number>() { // from class: com.google.gson.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.m
            public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
                if (number == null) {
                    aVar.bKy();
                    return;
                }
                d.this.q(number.doubleValue());
                aVar.a(number);
            }
        };
    }

    private m<Number> nK(boolean z) {
        return z ? com.google.gson.internal.a.k.hHv : new m<Number>() { // from class: com.google.gson.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.m
            public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
                if (number == null) {
                    aVar.bKy();
                    return;
                }
                d.this.q(number.floatValue());
                aVar.a(number);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException(d + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private m<Number> a(LongSerializationPolicy longSerializationPolicy) {
        return longSerializationPolicy == LongSerializationPolicy.DEFAULT ? com.google.gson.internal.a.k.hHu : new m<Number>() { // from class: com.google.gson.d.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.m
            public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
                if (number == null) {
                    aVar.bKy();
                } else {
                    aVar.wE(number.toString());
                }
            }
        };
    }

    public <T> m<T> a(com.google.gson.b.a<T> aVar) {
        HashMap hashMap;
        m<T> mVar = (m<T>) this.hFy.get(aVar);
        if (mVar == null) {
            Map<com.google.gson.b.a<?>, a<?>> map = this.hFx.get();
            boolean z = false;
            if (map == null) {
                HashMap hashMap2 = new HashMap();
                this.hFx.set(hashMap2);
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
                    for (n nVar : this.ePv) {
                        mVar = nVar.a(this, aVar);
                        if (mVar != null) {
                            aVar2.a(mVar);
                            this.hFy.put(aVar, mVar);
                            hashMap.remove(aVar);
                            if (z) {
                                this.hFx.remove();
                            }
                        }
                    }
                    throw new IllegalArgumentException("GSON cannot handle " + aVar);
                } catch (Throwable th) {
                    hashMap.remove(aVar);
                    if (z) {
                        this.hFx.remove();
                    }
                    throw th;
                }
            }
        }
        return mVar;
    }

    public <T> m<T> a(n nVar, com.google.gson.b.a<T> aVar) {
        boolean z = false;
        for (n nVar2 : this.ePv) {
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
        return obj == null ? a(i.hFJ) : b(obj, obj.getClass());
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
        boolean bKC = aVar.bKC();
        aVar.nM(this.hFB);
        boolean bKD = aVar.bKD();
        aVar.nN(this.hFA);
        try {
            try {
                a2.a(aVar, obj);
            } catch (IOException e) {
                throw new JsonIOException(e);
            }
        } finally {
            aVar.setLenient(isLenient);
            aVar.nM(bKC);
            aVar.nN(bKD);
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
        if (this.hFC) {
            writer.write(")]}'\n");
        }
        com.google.gson.stream.a aVar = new com.google.gson.stream.a(writer);
        if (this.hFD) {
            aVar.setIndent("  ");
        }
        aVar.nN(this.hFA);
        return aVar;
    }

    public void a(h hVar, com.google.gson.stream.a aVar) throws JsonIOException {
        boolean isLenient = aVar.isLenient();
        aVar.setLenient(true);
        boolean bKC = aVar.bKC();
        aVar.nM(this.hFB);
        boolean bKD = aVar.bKD();
        aVar.nN(this.hFA);
        try {
            try {
                com.google.gson.internal.f.b(hVar, aVar);
            } catch (IOException e) {
                throw new JsonIOException(e);
            }
        } finally {
            aVar.setLenient(isLenient);
            aVar.nM(bKC);
            aVar.nN(bKD);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a<T> extends m<T> {
        private m<T> hFH;

        a() {
        }

        public void a(m<T> mVar) {
            if (this.hFH != null) {
                throw new AssertionError();
            }
            this.hFH = mVar;
        }

        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, T t) throws IOException {
            if (this.hFH == null) {
                throw new IllegalStateException();
            }
            this.hFH.a(aVar, t);
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.hFA + "factories:" + this.ePv + ",instanceCreators:" + this.hFz + "}";
    }
}
