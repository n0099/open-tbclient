package com.bytedance.sdk.openadsdk.preload.a;

import com.bumptech.glide.load.engine.GlideException;
import com.google.gson.Gson;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
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
/* loaded from: classes6.dex */
public final class f {
    public static final com.bytedance.sdk.openadsdk.preload.a.c.a<?> r = com.bytedance.sdk.openadsdk.preload.a.c.a.b(Object.class);

    /* renamed from: a  reason: collision with root package name */
    public final List<w> f30078a;

    /* renamed from: b  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.a.b.d f30079b;

    /* renamed from: c  reason: collision with root package name */
    public final e f30080c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<Type, h<?>> f30081d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f30082e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f30083f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f30084g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f30085h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f30086i;
    public final boolean j;
    public final boolean k;
    public final String l;
    public final int m;
    public final int n;
    public final u o;
    public final List<w> p;
    public final List<w> q;
    public final ThreadLocal<Map<com.bytedance.sdk.openadsdk.preload.a.c.a<?>, a<?>>> s;
    public final Map<com.bytedance.sdk.openadsdk.preload.a.c.a<?>, v<?>> t;
    public final com.bytedance.sdk.openadsdk.preload.a.b.c u;
    public final com.bytedance.sdk.openadsdk.preload.a.b.a.d v;

    public f() {
        this(com.bytedance.sdk.openadsdk.preload.a.b.d.f29991a, d.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, false, u.DEFAULT, null, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
    }

    private v<Number> a(boolean z) {
        if (z) {
            return com.bytedance.sdk.openadsdk.preload.a.b.a.n.v;
        }
        return new v<Number>() { // from class: com.bytedance.sdk.openadsdk.preload.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            /* renamed from: a */
            public Double b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bytedance.sdk.openadsdk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                return Double.valueOf(aVar.k());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, Number number) throws IOException {
                if (number == null) {
                    cVar.f();
                    return;
                }
                f.a(number.doubleValue());
                cVar.a(number);
            }
        };
    }

    private v<Number> b(boolean z) {
        if (z) {
            return com.bytedance.sdk.openadsdk.preload.a.b.a.n.u;
        }
        return new v<Number>() { // from class: com.bytedance.sdk.openadsdk.preload.a.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            /* renamed from: a */
            public Float b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bytedance.sdk.openadsdk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                return Float.valueOf((float) aVar.k());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, Number number) throws IOException {
                if (number == null) {
                    cVar.f();
                    return;
                }
                f.a(number.floatValue());
                cVar.a(number);
            }
        };
    }

    public String toString() {
        return "{serializeNulls:" + this.f30082e + ",factories:" + this.f30078a + ",instanceCreators:" + this.u + "}";
    }

    /* loaded from: classes6.dex */
    public static class a<T> extends v<T> {

        /* renamed from: a  reason: collision with root package name */
        public v<T> f30091a;

        public void a(v<T> vVar) {
            if (this.f30091a == null) {
                this.f30091a = vVar;
                return;
            }
            throw new AssertionError();
        }

        @Override // com.bytedance.sdk.openadsdk.preload.a.v
        public T b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
            v<T> vVar = this.f30091a;
            if (vVar != null) {
                return vVar.b(aVar);
            }
            throw new IllegalStateException();
        }

        @Override // com.bytedance.sdk.openadsdk.preload.a.v
        public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, T t) throws IOException {
            v<T> vVar = this.f30091a;
            if (vVar != null) {
                vVar.a(cVar, t);
                return;
            }
            throw new IllegalStateException();
        }
    }

    public static void a(double d2) {
        if (Double.isNaN(d2) || Double.isInfinite(d2)) {
            throw new IllegalArgumentException(d2 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    public static v<AtomicLongArray> b(final v<Number> vVar) {
        return new v<AtomicLongArray>() { // from class: com.bytedance.sdk.openadsdk.preload.a.f.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, AtomicLongArray atomicLongArray) throws IOException {
                cVar.b();
                int length = atomicLongArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    v.this.a(cVar, Long.valueOf(atomicLongArray.get(i2)));
                }
                cVar.c();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            /* renamed from: a */
            public AtomicLongArray b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                ArrayList arrayList = new ArrayList();
                aVar.a();
                while (aVar.e()) {
                    arrayList.add(Long.valueOf(((Number) v.this.b(aVar)).longValue()));
                }
                aVar.b();
                int size = arrayList.size();
                AtomicLongArray atomicLongArray = new AtomicLongArray(size);
                for (int i2 = 0; i2 < size; i2++) {
                    atomicLongArray.set(i2, ((Long) arrayList.get(i2)).longValue());
                }
                return atomicLongArray;
            }
        }.a();
    }

    public static v<Number> a(u uVar) {
        if (uVar == u.DEFAULT) {
            return com.bytedance.sdk.openadsdk.preload.a.b.a.n.t;
        }
        return new v<Number>() { // from class: com.bytedance.sdk.openadsdk.preload.a.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            /* renamed from: a */
            public Number b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bytedance.sdk.openadsdk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                return Long.valueOf(aVar.l());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, Number number) throws IOException {
                if (number == null) {
                    cVar.f();
                } else {
                    cVar.b(number.toString());
                }
            }
        };
    }

    public f(com.bytedance.sdk.openadsdk.preload.a.b.d dVar, e eVar, Map<Type, h<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, u uVar, String str, int i2, int i3, List<w> list, List<w> list2, List<w> list3) {
        this.s = new ThreadLocal<>();
        this.t = new ConcurrentHashMap();
        this.f30079b = dVar;
        this.f30080c = eVar;
        this.f30081d = map;
        this.u = new com.bytedance.sdk.openadsdk.preload.a.b.c(map);
        this.f30082e = z;
        this.f30083f = z2;
        this.f30084g = z3;
        this.f30085h = z4;
        this.f30086i = z5;
        this.j = z6;
        this.k = z7;
        this.o = uVar;
        this.l = str;
        this.m = i2;
        this.n = i3;
        this.p = list;
        this.q = list2;
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.Y);
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.h.f29888a);
        arrayList.add(dVar);
        arrayList.addAll(list3);
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.D);
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.m);
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.f29933g);
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.f29935i);
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.k);
        v<Number> a2 = a(uVar);
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.a(Long.TYPE, Long.class, a2));
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.a(Double.TYPE, Double.class, a(z7)));
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.a(Float.TYPE, Float.class, b(z7)));
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.x);
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.o);
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.q);
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.a(AtomicLong.class, a(a2)));
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.a(AtomicLongArray.class, b(a2)));
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.s);
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.z);
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.F);
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.H);
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.a(BigDecimal.class, com.bytedance.sdk.openadsdk.preload.a.b.a.n.B));
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.a(BigInteger.class, com.bytedance.sdk.openadsdk.preload.a.b.a.n.C));
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.J);
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.L);
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.P);
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.R);
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.W);
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.N);
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.f29930d);
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.c.f29868a);
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.U);
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.k.f29909a);
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.j.f29907a);
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.S);
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.a.f29861a);
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.f29928b);
        arrayList.add(new com.bytedance.sdk.openadsdk.preload.a.b.a.b(this.u));
        arrayList.add(new com.bytedance.sdk.openadsdk.preload.a.b.a.g(this.u, z2));
        com.bytedance.sdk.openadsdk.preload.a.b.a.d dVar2 = new com.bytedance.sdk.openadsdk.preload.a.b.a.d(this.u);
        this.v = dVar2;
        arrayList.add(dVar2);
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.Z);
        arrayList.add(new com.bytedance.sdk.openadsdk.preload.a.b.a.i(this.u, eVar, dVar, this.v));
        this.f30078a = Collections.unmodifiableList(arrayList);
    }

    public static v<AtomicLong> a(final v<Number> vVar) {
        return new v<AtomicLong>() { // from class: com.bytedance.sdk.openadsdk.preload.a.f.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, AtomicLong atomicLong) throws IOException {
                v.this.a(cVar, Long.valueOf(atomicLong.get()));
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            /* renamed from: a */
            public AtomicLong b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                return new AtomicLong(((Number) v.this.b(aVar)).longValue());
            }
        }.a();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v5, resolved type: java.util.Map<com.bytedance.sdk.openadsdk.preload.a.c.a<?>, com.bytedance.sdk.openadsdk.preload.a.v<?>> */
    /* JADX DEBUG: Type inference failed for r4v4. Raw type applied. Possible types: com.bytedance.sdk.openadsdk.preload.a.v<T>, com.bytedance.sdk.openadsdk.preload.a.v<?> */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> v<T> a(com.bytedance.sdk.openadsdk.preload.a.c.a<T> aVar) {
        v<T> vVar = (v<T>) this.t.get(aVar == null ? r : aVar);
        if (vVar != null) {
            return vVar;
        }
        Map<com.bytedance.sdk.openadsdk.preload.a.c.a<?>, a<?>> map = this.s.get();
        boolean z = false;
        if (map == null) {
            map = new HashMap<>();
            this.s.set(map);
            z = true;
        }
        a<?> aVar2 = map.get(aVar);
        if (aVar2 != null) {
            return aVar2;
        }
        try {
            a<?> aVar3 = new a<>();
            map.put(aVar, aVar3);
            for (w wVar : this.f30078a) {
                v vVar2 = (v<T>) wVar.a(this, aVar);
                if (vVar2 != null) {
                    aVar3.a((v<?>) vVar2);
                    this.t.put(aVar, vVar2);
                    return vVar2;
                }
            }
            throw new IllegalArgumentException("GSON (pangle-v3200) cannot handle " + aVar);
        } finally {
            map.remove(aVar);
            if (z) {
                this.s.remove();
            }
        }
    }

    public <T> v<T> a(w wVar, com.bytedance.sdk.openadsdk.preload.a.c.a<T> aVar) {
        if (!this.f30078a.contains(wVar)) {
            wVar = this.v;
        }
        boolean z = false;
        for (w wVar2 : this.f30078a) {
            if (z) {
                v<T> a2 = wVar2.a(this, aVar);
                if (a2 != null) {
                    return a2;
                }
            } else if (wVar2 == wVar) {
                z = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + aVar);
    }

    public <T> v<T> a(Class<T> cls) {
        return a((com.bytedance.sdk.openadsdk.preload.a.c.a) com.bytedance.sdk.openadsdk.preload.a.c.a.b(cls));
    }

    public String a(Object obj) {
        if (obj == null) {
            return a((l) n.f30102a);
        }
        return a(obj, obj.getClass());
    }

    public String a(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        a(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public void a(Object obj, Type type, Appendable appendable) throws m {
        try {
            a(obj, type, a(com.bytedance.sdk.openadsdk.preload.a.b.l.a(appendable)));
        } catch (IOException e2) {
            throw new m(e2);
        }
    }

    public void a(Object obj, Type type, com.bytedance.sdk.openadsdk.preload.a.d.c cVar) throws m {
        v a2 = a((com.bytedance.sdk.openadsdk.preload.a.c.a) com.bytedance.sdk.openadsdk.preload.a.c.a.a(type));
        boolean g2 = cVar.g();
        cVar.b(true);
        boolean h2 = cVar.h();
        cVar.c(this.f30085h);
        boolean i2 = cVar.i();
        cVar.d(this.f30082e);
        try {
            try {
                a2.a(cVar, obj);
            } catch (IOException e2) {
                throw new m(e2);
            } catch (AssertionError e3) {
                AssertionError assertionError = new AssertionError("AssertionError (GSON pangle-v3200): " + e3.getMessage());
                assertionError.initCause(e3);
                throw assertionError;
            }
        } finally {
            cVar.b(g2);
            cVar.c(h2);
            cVar.d(i2);
        }
    }

    public String a(l lVar) {
        StringWriter stringWriter = new StringWriter();
        a(lVar, stringWriter);
        return stringWriter.toString();
    }

    public void a(l lVar, Appendable appendable) throws m {
        try {
            a(lVar, a(com.bytedance.sdk.openadsdk.preload.a.b.l.a(appendable)));
        } catch (IOException e2) {
            throw new m(e2);
        }
    }

    public com.bytedance.sdk.openadsdk.preload.a.d.c a(Writer writer) throws IOException {
        if (this.f30084g) {
            writer.write(Gson.JSON_NON_EXECUTABLE_PREFIX);
        }
        com.bytedance.sdk.openadsdk.preload.a.d.c cVar = new com.bytedance.sdk.openadsdk.preload.a.d.c(writer);
        if (this.f30086i) {
            cVar.c(GlideException.IndentedAppendable.INDENT);
        }
        cVar.d(this.f30082e);
        return cVar;
    }

    public com.bytedance.sdk.openadsdk.preload.a.d.a a(Reader reader) {
        com.bytedance.sdk.openadsdk.preload.a.d.a aVar = new com.bytedance.sdk.openadsdk.preload.a.d.a(reader);
        aVar.a(this.j);
        return aVar;
    }

    public void a(l lVar, com.bytedance.sdk.openadsdk.preload.a.d.c cVar) throws m {
        boolean g2 = cVar.g();
        cVar.b(true);
        boolean h2 = cVar.h();
        cVar.c(this.f30085h);
        boolean i2 = cVar.i();
        cVar.d(this.f30082e);
        try {
            try {
                com.bytedance.sdk.openadsdk.preload.a.b.l.a(lVar, cVar);
            } catch (IOException e2) {
                throw new m(e2);
            } catch (AssertionError e3) {
                AssertionError assertionError = new AssertionError("AssertionError (GSON pangle-v3200): " + e3.getMessage());
                assertionError.initCause(e3);
                throw assertionError;
            }
        } finally {
            cVar.b(g2);
            cVar.c(h2);
            cVar.d(i2);
        }
    }

    public <T> T a(String str, Type type) throws t {
        if (str == null) {
            return null;
        }
        return (T) a((Reader) new StringReader(str), type);
    }

    public <T> T a(Reader reader, Type type) throws m, t {
        com.bytedance.sdk.openadsdk.preload.a.d.a a2 = a(reader);
        T t = (T) a(a2, type);
        a(t, a2);
        return t;
    }

    public static void a(Object obj, com.bytedance.sdk.openadsdk.preload.a.d.a aVar) {
        if (obj != null) {
            try {
                if (aVar.f() == com.bytedance.sdk.openadsdk.preload.a.d.b.END_DOCUMENT) {
                    return;
                }
                throw new m("JSON document was not fully consumed.");
            } catch (com.bytedance.sdk.openadsdk.preload.a.d.d e2) {
                throw new t(e2);
            } catch (IOException e3) {
                throw new m(e3);
            }
        }
    }

    public <T> T a(com.bytedance.sdk.openadsdk.preload.a.d.a aVar, Type type) throws m, t {
        boolean q = aVar.q();
        boolean z = true;
        aVar.a(true);
        try {
            try {
                try {
                    aVar.f();
                    z = false;
                    T b2 = a((com.bytedance.sdk.openadsdk.preload.a.c.a) com.bytedance.sdk.openadsdk.preload.a.c.a.a(type)).b(aVar);
                    aVar.a(q);
                    return b2;
                } catch (AssertionError e2) {
                    AssertionError assertionError = new AssertionError("AssertionError (GSON pangle-v3200): " + e2.getMessage());
                    assertionError.initCause(e2);
                    throw assertionError;
                } catch (IllegalStateException e3) {
                    throw new t(e3);
                }
            } catch (EOFException e4) {
                if (z) {
                    aVar.a(q);
                    return null;
                }
                throw new t(e4);
            } catch (IOException e5) {
                throw new t(e5);
            }
        } catch (Throwable th) {
            aVar.a(q);
            throw th;
        }
    }
}
