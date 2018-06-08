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
    private final List<n> eHJ;
    private final boolean hIA;
    final g hIB;
    final l hIC;
    private final ThreadLocal<Map<com.google.gson.b.a<?>, a<?>>> hIu;
    private final Map<com.google.gson.b.a<?>, m<?>> hIv;
    private final com.google.gson.internal.b hIw;
    private final boolean hIx;
    private final boolean hIy;
    private final boolean hIz;

    public d() {
        this(com.google.gson.internal.c.hIS, FieldNamingPolicy.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, LongSerializationPolicy.DEFAULT, Collections.emptyList());
    }

    d(com.google.gson.internal.c cVar, c cVar2, Map<Type, e<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, LongSerializationPolicy longSerializationPolicy, List<n> list) {
        this.hIu = new ThreadLocal<>();
        this.hIv = Collections.synchronizedMap(new HashMap());
        this.hIB = new g() { // from class: com.google.gson.d.1
        };
        this.hIC = new l() { // from class: com.google.gson.d.2
        };
        this.hIw = new com.google.gson.internal.b(map);
        this.hIx = z;
        this.hIz = z3;
        this.hIy = z4;
        this.hIA = z5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.google.gson.internal.a.k.hKT);
        arrayList.add(com.google.gson.internal.a.f.hJy);
        arrayList.add(cVar);
        arrayList.addAll(list);
        arrayList.add(com.google.gson.internal.a.k.hKA);
        arrayList.add(com.google.gson.internal.a.k.hKp);
        arrayList.add(com.google.gson.internal.a.k.hKj);
        arrayList.add(com.google.gson.internal.a.k.hKl);
        arrayList.add(com.google.gson.internal.a.k.hKn);
        arrayList.add(com.google.gson.internal.a.k.a(Long.TYPE, Long.class, a(longSerializationPolicy)));
        arrayList.add(com.google.gson.internal.a.k.a(Double.TYPE, Double.class, oc(z6)));
        arrayList.add(com.google.gson.internal.a.k.a(Float.TYPE, Float.class, od(z6)));
        arrayList.add(com.google.gson.internal.a.k.hKu);
        arrayList.add(com.google.gson.internal.a.k.hKw);
        arrayList.add(com.google.gson.internal.a.k.hKC);
        arrayList.add(com.google.gson.internal.a.k.hKE);
        arrayList.add(com.google.gson.internal.a.k.a(BigDecimal.class, com.google.gson.internal.a.k.hKy));
        arrayList.add(com.google.gson.internal.a.k.a(BigInteger.class, com.google.gson.internal.a.k.hKz));
        arrayList.add(com.google.gson.internal.a.k.hKG);
        arrayList.add(com.google.gson.internal.a.k.hKI);
        arrayList.add(com.google.gson.internal.a.k.hKM);
        arrayList.add(com.google.gson.internal.a.k.hKR);
        arrayList.add(com.google.gson.internal.a.k.hKK);
        arrayList.add(com.google.gson.internal.a.k.hKg);
        arrayList.add(com.google.gson.internal.a.c.hJy);
        arrayList.add(com.google.gson.internal.a.k.hKP);
        arrayList.add(com.google.gson.internal.a.i.hJy);
        arrayList.add(com.google.gson.internal.a.h.hJy);
        arrayList.add(com.google.gson.internal.a.k.hKN);
        arrayList.add(com.google.gson.internal.a.a.hJy);
        arrayList.add(com.google.gson.internal.a.k.hKU);
        arrayList.add(com.google.gson.internal.a.k.hKe);
        arrayList.add(new com.google.gson.internal.a.b(this.hIw));
        arrayList.add(new com.google.gson.internal.a.e(this.hIw, z2));
        arrayList.add(new com.google.gson.internal.a.g(this.hIw, cVar2, cVar));
        this.eHJ = Collections.unmodifiableList(arrayList);
    }

    private m<Number> oc(boolean z) {
        return z ? com.google.gson.internal.a.k.hKs : new m<Number>() { // from class: com.google.gson.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.m
            public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
                if (number == null) {
                    aVar.bOd();
                    return;
                }
                d.this.s(number.doubleValue());
                aVar.a(number);
            }
        };
    }

    private m<Number> od(boolean z) {
        return z ? com.google.gson.internal.a.k.hKr : new m<Number>() { // from class: com.google.gson.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.m
            public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
                if (number == null) {
                    aVar.bOd();
                    return;
                }
                d.this.s(number.floatValue());
                aVar.a(number);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException(d + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private m<Number> a(LongSerializationPolicy longSerializationPolicy) {
        return longSerializationPolicy == LongSerializationPolicy.DEFAULT ? com.google.gson.internal.a.k.hKq : new m<Number>() { // from class: com.google.gson.d.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.m
            public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
                if (number == null) {
                    aVar.bOd();
                } else {
                    aVar.xA(number.toString());
                }
            }
        };
    }

    public <T> m<T> a(com.google.gson.b.a<T> aVar) {
        HashMap hashMap;
        m<T> mVar = (m<T>) this.hIv.get(aVar);
        if (mVar == null) {
            Map<com.google.gson.b.a<?>, a<?>> map = this.hIu.get();
            boolean z = false;
            if (map == null) {
                HashMap hashMap2 = new HashMap();
                this.hIu.set(hashMap2);
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
                    for (n nVar : this.eHJ) {
                        mVar = nVar.a(this, aVar);
                        if (mVar != null) {
                            aVar2.a(mVar);
                            this.hIv.put(aVar, mVar);
                            hashMap.remove(aVar);
                            if (z) {
                                this.hIu.remove();
                            }
                        }
                    }
                    throw new IllegalArgumentException("GSON cannot handle " + aVar);
                } catch (Throwable th) {
                    hashMap.remove(aVar);
                    if (z) {
                        this.hIu.remove();
                    }
                    throw th;
                }
            }
        }
        return mVar;
    }

    public <T> m<T> a(n nVar, com.google.gson.b.a<T> aVar) {
        boolean z = false;
        for (n nVar2 : this.eHJ) {
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
        return obj == null ? a(i.hIG) : b(obj, obj.getClass());
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
        boolean bOh = aVar.bOh();
        aVar.of(this.hIy);
        boolean bOi = aVar.bOi();
        aVar.og(this.hIx);
        try {
            try {
                a2.a(aVar, obj);
            } catch (IOException e) {
                throw new JsonIOException(e);
            }
        } finally {
            aVar.setLenient(isLenient);
            aVar.of(bOh);
            aVar.og(bOi);
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
        if (this.hIz) {
            writer.write(")]}'\n");
        }
        com.google.gson.stream.a aVar = new com.google.gson.stream.a(writer);
        if (this.hIA) {
            aVar.setIndent("  ");
        }
        aVar.og(this.hIx);
        return aVar;
    }

    public void a(h hVar, com.google.gson.stream.a aVar) throws JsonIOException {
        boolean isLenient = aVar.isLenient();
        aVar.setLenient(true);
        boolean bOh = aVar.bOh();
        aVar.of(this.hIy);
        boolean bOi = aVar.bOi();
        aVar.og(this.hIx);
        try {
            try {
                com.google.gson.internal.f.b(hVar, aVar);
            } catch (IOException e) {
                throw new JsonIOException(e);
            }
        } finally {
            aVar.setLenient(isLenient);
            aVar.of(bOh);
            aVar.og(bOi);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a<T> extends m<T> {
        private m<T> hIE;

        a() {
        }

        public void a(m<T> mVar) {
            if (this.hIE != null) {
                throw new AssertionError();
            }
            this.hIE = mVar;
        }

        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, T t) throws IOException {
            if (this.hIE == null) {
                throw new IllegalStateException();
            }
            this.hIE.a(aVar, t);
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.hIx + "factories:" + this.eHJ + ",instanceCreators:" + this.hIw + "}";
    }
}
