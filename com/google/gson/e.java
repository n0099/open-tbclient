package com.google.gson;

import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    final p f1613a;
    final v b;
    private final ThreadLocal c;
    private final Map d;
    private final List e;
    private final com.google.gson.internal.b f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private final boolean j;

    public e() {
        this(com.google.gson.internal.k.f1655a, FieldNamingPolicy.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, LongSerializationPolicy.DEFAULT, Collections.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(com.google.gson.internal.k kVar, d dVar, Map map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, LongSerializationPolicy longSerializationPolicy, List list) {
        this.c = new f(this);
        this.d = Collections.synchronizedMap(new HashMap());
        this.f1613a = new g(this);
        this.b = new h(this);
        this.f = new com.google.gson.internal.b(map);
        this.g = z;
        this.i = z3;
        this.h = z4;
        this.j = z5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.google.gson.internal.a.y.Q);
        arrayList.add(com.google.gson.internal.a.m.f1634a);
        arrayList.addAll(list);
        arrayList.add(com.google.gson.internal.a.y.x);
        arrayList.add(com.google.gson.internal.a.y.m);
        arrayList.add(com.google.gson.internal.a.y.g);
        arrayList.add(com.google.gson.internal.a.y.i);
        arrayList.add(com.google.gson.internal.a.y.k);
        arrayList.add(com.google.gson.internal.a.y.a(Long.TYPE, Long.class, a(longSerializationPolicy)));
        arrayList.add(com.google.gson.internal.a.y.a(Double.TYPE, Double.class, a(z6)));
        arrayList.add(com.google.gson.internal.a.y.a(Float.TYPE, Float.class, b(z6)));
        arrayList.add(com.google.gson.internal.a.y.r);
        arrayList.add(com.google.gson.internal.a.y.t);
        arrayList.add(com.google.gson.internal.a.y.z);
        arrayList.add(com.google.gson.internal.a.y.B);
        arrayList.add(com.google.gson.internal.a.y.a(BigDecimal.class, com.google.gson.internal.a.y.v));
        arrayList.add(com.google.gson.internal.a.y.a(BigInteger.class, com.google.gson.internal.a.y.w));
        arrayList.add(com.google.gson.internal.a.y.D);
        arrayList.add(com.google.gson.internal.a.y.F);
        arrayList.add(com.google.gson.internal.a.y.J);
        arrayList.add(com.google.gson.internal.a.y.O);
        arrayList.add(com.google.gson.internal.a.y.H);
        arrayList.add(com.google.gson.internal.a.y.d);
        arrayList.add(com.google.gson.internal.a.e.f1629a);
        arrayList.add(com.google.gson.internal.a.y.M);
        arrayList.add(com.google.gson.internal.a.v.f1640a);
        arrayList.add(com.google.gson.internal.a.t.f1639a);
        arrayList.add(com.google.gson.internal.a.y.K);
        arrayList.add(com.google.gson.internal.a.a.f1619a);
        arrayList.add(com.google.gson.internal.a.y.R);
        arrayList.add(com.google.gson.internal.a.y.b);
        arrayList.add(kVar);
        arrayList.add(new com.google.gson.internal.a.c(this.f));
        arrayList.add(new com.google.gson.internal.a.k(this.f, z2));
        arrayList.add(new com.google.gson.internal.a.p(this.f, dVar, kVar));
        this.e = Collections.unmodifiableList(arrayList);
    }

    private aa a(boolean z) {
        return z ? com.google.gson.internal.a.y.p : new i(this);
    }

    private aa b(boolean z) {
        return z ? com.google.gson.internal.a.y.o : new j(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException(d + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialDoubleValues() method.");
        }
    }

    private aa a(LongSerializationPolicy longSerializationPolicy) {
        return longSerializationPolicy == LongSerializationPolicy.DEFAULT ? com.google.gson.internal.a.y.n : new k(this);
    }

    public aa a(com.google.gson.b.a aVar) {
        aa aaVar = (aa) this.d.get(aVar);
        if (aaVar == null) {
            Map map = (Map) this.c.get();
            l lVar = (l) map.get(aVar);
            if (lVar != null) {
                return lVar;
            }
            l lVar2 = new l();
            map.put(aVar, lVar2);
            try {
                for (ab abVar : this.e) {
                    aa a2 = abVar.a(this, aVar);
                    if (a2 != null) {
                        lVar2.a(a2);
                        this.d.put(aVar, a2);
                        return a2;
                    }
                }
                throw new IllegalArgumentException("GSON cannot handle " + aVar);
            } finally {
                map.remove(aVar);
            }
        }
        return aaVar;
    }

    public aa a(ab abVar, com.google.gson.b.a aVar) {
        boolean z = false;
        for (ab abVar2 : this.e) {
            if (!z) {
                if (abVar2 == abVar) {
                    z = true;
                }
            } else {
                aa a2 = abVar2.a(this, aVar);
                if (a2 != null) {
                    return a2;
                }
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + aVar);
    }

    public aa a(Class cls) {
        return a(com.google.gson.b.a.b(cls));
    }

    public Object a(String str, Class cls) {
        return com.google.gson.internal.o.a(cls).cast(a(str, (Type) cls));
    }

    public Object a(String str, Type type) {
        if (str == null) {
            return null;
        }
        return a(new StringReader(str), type);
    }

    public Object a(Reader reader, Type type) {
        com.google.gson.stream.a aVar = new com.google.gson.stream.a(reader);
        Object a2 = a(aVar, type);
        a(a2, aVar);
        return a2;
    }

    private static void a(Object obj, com.google.gson.stream.a aVar) {
        if (obj != null) {
            try {
                if (aVar.f() != JsonToken.END_DOCUMENT) {
                    throw new JsonIOException("JSON document was not fully consumed.");
                }
            } catch (MalformedJsonException e) {
                throw new JsonSyntaxException(e);
            } catch (IOException e2) {
                throw new JsonIOException(e2);
            }
        }
    }

    public Object a(com.google.gson.stream.a aVar, Type type) {
        boolean z = true;
        boolean p = aVar.p();
        aVar.a(true);
        try {
            try {
                aVar.f();
                z = false;
                Object b = a(com.google.gson.b.a.a(type)).b(aVar);
                aVar.a(p);
                return b;
            } catch (EOFException e) {
                if (!z) {
                    throw new JsonSyntaxException(e);
                }
                aVar.a(p);
                return null;
            } catch (IOException e2) {
                throw new JsonSyntaxException(e2);
            } catch (IllegalStateException e3) {
                throw new JsonSyntaxException(e3);
            }
        } catch (Throwable th) {
            aVar.a(p);
            throw th;
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.g + "factories:" + this.e + ",instanceCreators:" + this.f + "}";
    }
}
