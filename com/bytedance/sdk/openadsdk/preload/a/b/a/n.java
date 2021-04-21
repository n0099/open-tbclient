package com.bytedance.sdk.openadsdk.preload.a.b.a;

import com.baidu.android.common.others.lang.StringUtil;
import com.bytedance.sdk.openadsdk.preload.a.o;
import com.bytedance.sdk.openadsdk.preload.a.q;
import com.bytedance.sdk.openadsdk.preload.a.t;
import com.bytedance.sdk.openadsdk.preload.a.v;
import com.bytedance.sdk.openadsdk.preload.a.w;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
/* loaded from: classes5.dex */
public final class n {
    public static final v<String> A;
    public static final v<BigDecimal> B;
    public static final v<BigInteger> C;
    public static final w D;
    public static final v<StringBuilder> E;
    public static final w F;
    public static final v<StringBuffer> G;
    public static final w H;
    public static final v<URL> I;
    public static final w J;
    public static final v<URI> K;
    public static final w L;
    public static final v<InetAddress> M;
    public static final w N;
    public static final v<UUID> O;
    public static final w P;
    public static final v<Currency> Q;
    public static final w R;
    public static final w S;
    public static final v<Calendar> T;
    public static final w U;
    public static final v<Locale> V;
    public static final w W;
    public static final v<com.bytedance.sdk.openadsdk.preload.a.l> X;
    public static final w Y;
    public static final w Z;

    /* renamed from: a  reason: collision with root package name */
    public static final v<Class> f29662a;

    /* renamed from: b  reason: collision with root package name */
    public static final w f29663b;

    /* renamed from: c  reason: collision with root package name */
    public static final v<BitSet> f29664c;

    /* renamed from: d  reason: collision with root package name */
    public static final w f29665d;

    /* renamed from: e  reason: collision with root package name */
    public static final v<Boolean> f29666e;

    /* renamed from: f  reason: collision with root package name */
    public static final v<Boolean> f29667f;

    /* renamed from: g  reason: collision with root package name */
    public static final w f29668g;

    /* renamed from: h  reason: collision with root package name */
    public static final v<Number> f29669h;
    public static final w i;
    public static final v<Number> j;
    public static final w k;
    public static final v<Number> l;
    public static final w m;
    public static final v<AtomicInteger> n;
    public static final w o;
    public static final v<AtomicBoolean> p;
    public static final w q;
    public static final v<AtomicIntegerArray> r;
    public static final w s;
    public static final v<Number> t;
    public static final v<Number> u;
    public static final v<Number> v;
    public static final v<Number> w;
    public static final w x;
    public static final v<Character> y;
    public static final w z;

    /* renamed from: com.bytedance.sdk.openadsdk.preload.a.b.a.n$30  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass30 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f29686a;

        static {
            int[] iArr = new int[com.bytedance.sdk.openadsdk.preload.a.d.b.values().length];
            f29686a = iArr;
            try {
                iArr[com.bytedance.sdk.openadsdk.preload.a.d.b.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f29686a[com.bytedance.sdk.openadsdk.preload.a.d.b.BOOLEAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f29686a[com.bytedance.sdk.openadsdk.preload.a.d.b.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f29686a[com.bytedance.sdk.openadsdk.preload.a.d.b.NULL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f29686a[com.bytedance.sdk.openadsdk.preload.a.d.b.BEGIN_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f29686a[com.bytedance.sdk.openadsdk.preload.a.d.b.BEGIN_OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f29686a[com.bytedance.sdk.openadsdk.preload.a.d.b.END_DOCUMENT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f29686a[com.bytedance.sdk.openadsdk.preload.a.d.b.NAME.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f29686a[com.bytedance.sdk.openadsdk.preload.a.d.b.END_OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f29686a[com.bytedance.sdk.openadsdk.preload.a.d.b.END_ARRAY.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class a<T extends Enum<T>> extends v<T> {

        /* renamed from: a  reason: collision with root package name */
        public final Map<String, T> f29687a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        public final Map<T, String> f29688b = new HashMap();

        public a(Class<T> cls) {
            T[] enumConstants;
            try {
                for (T t : cls.getEnumConstants()) {
                    String name = t.name();
                    com.bytedance.sdk.openadsdk.preload.a.a.c cVar = (com.bytedance.sdk.openadsdk.preload.a.a.c) cls.getField(name).getAnnotation(com.bytedance.sdk.openadsdk.preload.a.a.c.class);
                    if (cVar != null) {
                        name = cVar.a();
                        for (String str : cVar.b()) {
                            this.f29687a.put(str, t);
                        }
                    }
                    this.f29687a.put(name, t);
                    this.f29688b.put(t, name);
                }
            } catch (NoSuchFieldException e2) {
                throw new AssertionError(e2);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.bytedance.sdk.openadsdk.preload.a.b.a.n$a<T extends java.lang.Enum<T>> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.bytedance.sdk.openadsdk.preload.a.v
        public /* bridge */ /* synthetic */ void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, Object obj) throws IOException {
            a(cVar, (com.bytedance.sdk.openadsdk.preload.a.d.c) ((Enum) obj));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.preload.a.v
        /* renamed from: a */
        public T b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
            if (aVar.f() == com.bytedance.sdk.openadsdk.preload.a.d.b.NULL) {
                aVar.j();
                return null;
            }
            return this.f29687a.get(aVar.h());
        }

        public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, T t) throws IOException {
            cVar.b(t == null ? null : this.f29688b.get(t));
        }
    }

    static {
        v<Class> a2 = new v<Class>() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.a.n.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, Class cls) throws IOException {
                throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            /* renamed from: a */
            public Class b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
            }
        }.a();
        f29662a = a2;
        f29663b = a(Class.class, a2);
        v<BitSet> a3 = new v<BitSet>() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.a.n.12
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
                if (java.lang.Integer.parseInt(r1) != 0) goto L15;
             */
            /* JADX WARN: Code restructure failed: missing block: B:15:0x002e, code lost:
                r5 = false;
             */
            /* JADX WARN: Code restructure failed: missing block: B:22:0x0067, code lost:
                if (r8.m() != 0) goto L15;
             */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public BitSet b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                BitSet bitSet = new BitSet();
                aVar.a();
                com.bytedance.sdk.openadsdk.preload.a.d.b f2 = aVar.f();
                int i2 = 0;
                while (f2 != com.bytedance.sdk.openadsdk.preload.a.d.b.END_ARRAY) {
                    int i3 = AnonymousClass30.f29686a[f2.ordinal()];
                    boolean z2 = true;
                    if (i3 != 1) {
                        if (i3 == 2) {
                            z2 = aVar.i();
                        } else if (i3 == 3) {
                            String h2 = aVar.h();
                            try {
                            } catch (NumberFormatException unused) {
                                throw new t("Error: Expecting: bitset number value (1, 0), Found: " + h2);
                            }
                        } else {
                            throw new t("Invalid bitset value type: " + f2);
                        }
                        if (z2) {
                            bitSet.set(i2);
                        }
                        i2++;
                        f2 = aVar.f();
                    }
                }
                aVar.b();
                return bitSet;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, BitSet bitSet) throws IOException {
                cVar.b();
                int length = bitSet.length();
                for (int i2 = 0; i2 < length; i2++) {
                    cVar.a(bitSet.get(i2) ? 1L : 0L);
                }
                cVar.c();
            }
        }.a();
        f29664c = a3;
        f29665d = a(BitSet.class, a3);
        f29666e = new v<Boolean>() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.a.n.23
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            /* renamed from: a */
            public Boolean b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                com.bytedance.sdk.openadsdk.preload.a.d.b f2 = aVar.f();
                if (f2 == com.bytedance.sdk.openadsdk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                } else if (f2 == com.bytedance.sdk.openadsdk.preload.a.d.b.STRING) {
                    return Boolean.valueOf(Boolean.parseBoolean(aVar.h()));
                } else {
                    return Boolean.valueOf(aVar.i());
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, Boolean bool) throws IOException {
                cVar.a(bool);
            }
        };
        f29667f = new v<Boolean>() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.a.n.31
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            /* renamed from: a */
            public Boolean b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bytedance.sdk.openadsdk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                return Boolean.valueOf(aVar.h());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, Boolean bool) throws IOException {
                cVar.b(bool == null ? StringUtil.NULL_STRING : bool.toString());
            }
        };
        f29668g = a(Boolean.TYPE, Boolean.class, f29666e);
        f29669h = new v<Number>() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.a.n.32
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            /* renamed from: a */
            public Number b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bytedance.sdk.openadsdk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                try {
                    return Byte.valueOf((byte) aVar.m());
                } catch (NumberFormatException e2) {
                    throw new t(e2);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, Number number) throws IOException {
                cVar.a(number);
            }
        };
        i = a(Byte.TYPE, Byte.class, f29669h);
        j = new v<Number>() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.a.n.33
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            /* renamed from: a */
            public Number b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bytedance.sdk.openadsdk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                try {
                    return Short.valueOf((short) aVar.m());
                } catch (NumberFormatException e2) {
                    throw new t(e2);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, Number number) throws IOException {
                cVar.a(number);
            }
        };
        k = a(Short.TYPE, Short.class, j);
        l = new v<Number>() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.a.n.34
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            /* renamed from: a */
            public Number b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bytedance.sdk.openadsdk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                try {
                    return Integer.valueOf(aVar.m());
                } catch (NumberFormatException e2) {
                    throw new t(e2);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, Number number) throws IOException {
                cVar.a(number);
            }
        };
        m = a(Integer.TYPE, Integer.class, l);
        v<AtomicInteger> a4 = new v<AtomicInteger>() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.a.n.35
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            /* renamed from: a */
            public AtomicInteger b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                try {
                    return new AtomicInteger(aVar.m());
                } catch (NumberFormatException e2) {
                    throw new t(e2);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, AtomicInteger atomicInteger) throws IOException {
                cVar.a(atomicInteger.get());
            }
        }.a();
        n = a4;
        o = a(AtomicInteger.class, a4);
        v<AtomicBoolean> a5 = new v<AtomicBoolean>() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.a.n.36
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            /* renamed from: a */
            public AtomicBoolean b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                return new AtomicBoolean(aVar.i());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, AtomicBoolean atomicBoolean) throws IOException {
                cVar.a(atomicBoolean.get());
            }
        }.a();
        p = a5;
        q = a(AtomicBoolean.class, a5);
        v<AtomicIntegerArray> a6 = new v<AtomicIntegerArray>() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.a.n.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            /* renamed from: a */
            public AtomicIntegerArray b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                ArrayList arrayList = new ArrayList();
                aVar.a();
                while (aVar.e()) {
                    try {
                        arrayList.add(Integer.valueOf(aVar.m()));
                    } catch (NumberFormatException e2) {
                        throw new t(e2);
                    }
                }
                aVar.b();
                int size = arrayList.size();
                AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
                for (int i2 = 0; i2 < size; i2++) {
                    atomicIntegerArray.set(i2, ((Integer) arrayList.get(i2)).intValue());
                }
                return atomicIntegerArray;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, AtomicIntegerArray atomicIntegerArray) throws IOException {
                cVar.b();
                int length = atomicIntegerArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    cVar.a(atomicIntegerArray.get(i2));
                }
                cVar.c();
            }
        }.a();
        r = a6;
        s = a(AtomicIntegerArray.class, a6);
        t = new v<Number>() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.a.n.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            /* renamed from: a */
            public Number b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bytedance.sdk.openadsdk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                try {
                    return Long.valueOf(aVar.l());
                } catch (NumberFormatException e2) {
                    throw new t(e2);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, Number number) throws IOException {
                cVar.a(number);
            }
        };
        u = new v<Number>() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.a.n.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            /* renamed from: a */
            public Number b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bytedance.sdk.openadsdk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                return Float.valueOf((float) aVar.k());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, Number number) throws IOException {
                cVar.a(number);
            }
        };
        v = new v<Number>() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.a.n.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            /* renamed from: a */
            public Number b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bytedance.sdk.openadsdk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                return Double.valueOf(aVar.k());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, Number number) throws IOException {
                cVar.a(number);
            }
        };
        v<Number> vVar = new v<Number>() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.a.n.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            /* renamed from: a */
            public Number b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                com.bytedance.sdk.openadsdk.preload.a.d.b f2 = aVar.f();
                int i2 = AnonymousClass30.f29686a[f2.ordinal()];
                if (i2 == 1 || i2 == 3) {
                    return new com.bytedance.sdk.openadsdk.preload.a.b.g(aVar.h());
                }
                if (i2 == 4) {
                    aVar.j();
                    return null;
                }
                throw new t("Expecting number, got: " + f2);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, Number number) throws IOException {
                cVar.a(number);
            }
        };
        w = vVar;
        x = a(Number.class, vVar);
        y = new v<Character>() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.a.n.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            /* renamed from: a */
            public Character b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bytedance.sdk.openadsdk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                String h2 = aVar.h();
                if (h2.length() == 1) {
                    return Character.valueOf(h2.charAt(0));
                }
                throw new t("Expecting character, got: " + h2);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, Character ch) throws IOException {
                cVar.b(ch == null ? null : String.valueOf(ch));
            }
        };
        z = a(Character.TYPE, Character.class, y);
        A = new v<String>() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.a.n.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            /* renamed from: a */
            public String b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                com.bytedance.sdk.openadsdk.preload.a.d.b f2 = aVar.f();
                if (f2 == com.bytedance.sdk.openadsdk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                } else if (f2 == com.bytedance.sdk.openadsdk.preload.a.d.b.BOOLEAN) {
                    return Boolean.toString(aVar.i());
                } else {
                    return aVar.h();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, String str) throws IOException {
                cVar.b(str);
            }
        };
        B = new v<BigDecimal>() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.a.n.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            /* renamed from: a */
            public BigDecimal b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bytedance.sdk.openadsdk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                try {
                    return new BigDecimal(aVar.h());
                } catch (NumberFormatException e2) {
                    throw new t(e2);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, BigDecimal bigDecimal) throws IOException {
                cVar.a(bigDecimal);
            }
        };
        C = new v<BigInteger>() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.a.n.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            /* renamed from: a */
            public BigInteger b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bytedance.sdk.openadsdk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                try {
                    return new BigInteger(aVar.h());
                } catch (NumberFormatException e2) {
                    throw new t(e2);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, BigInteger bigInteger) throws IOException {
                cVar.a(bigInteger);
            }
        };
        D = a(String.class, A);
        v<StringBuilder> vVar2 = new v<StringBuilder>() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.a.n.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            /* renamed from: a */
            public StringBuilder b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bytedance.sdk.openadsdk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                return new StringBuilder(aVar.h());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, StringBuilder sb) throws IOException {
                cVar.b(sb == null ? null : sb.toString());
            }
        };
        E = vVar2;
        F = a(StringBuilder.class, vVar2);
        v<StringBuffer> vVar3 = new v<StringBuffer>() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.a.n.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            /* renamed from: a */
            public StringBuffer b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bytedance.sdk.openadsdk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                return new StringBuffer(aVar.h());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, StringBuffer stringBuffer) throws IOException {
                cVar.b(stringBuffer == null ? null : stringBuffer.toString());
            }
        };
        G = vVar3;
        H = a(StringBuffer.class, vVar3);
        v<URL> vVar4 = new v<URL>() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.a.n.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            /* renamed from: a */
            public URL b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bytedance.sdk.openadsdk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                String h2 = aVar.h();
                if (StringUtil.NULL_STRING.equals(h2)) {
                    return null;
                }
                return new URL(h2);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, URL url) throws IOException {
                cVar.b(url == null ? null : url.toExternalForm());
            }
        };
        I = vVar4;
        J = a(URL.class, vVar4);
        v<URI> vVar5 = new v<URI>() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.a.n.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            /* renamed from: a */
            public URI b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bytedance.sdk.openadsdk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                try {
                    String h2 = aVar.h();
                    if (StringUtil.NULL_STRING.equals(h2)) {
                        return null;
                    }
                    return new URI(h2);
                } catch (URISyntaxException e2) {
                    throw new com.bytedance.sdk.openadsdk.preload.a.m(e2);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, URI uri) throws IOException {
                cVar.b(uri == null ? null : uri.toASCIIString());
            }
        };
        K = vVar5;
        L = a(URI.class, vVar5);
        v<InetAddress> vVar6 = new v<InetAddress>() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.a.n.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            /* renamed from: a */
            public InetAddress b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bytedance.sdk.openadsdk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                return InetAddress.getByName(aVar.h());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, InetAddress inetAddress) throws IOException {
                cVar.b(inetAddress == null ? null : inetAddress.getHostAddress());
            }
        };
        M = vVar6;
        N = b(InetAddress.class, vVar6);
        v<UUID> vVar7 = new v<UUID>() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.a.n.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            /* renamed from: a */
            public UUID b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bytedance.sdk.openadsdk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                return UUID.fromString(aVar.h());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, UUID uuid) throws IOException {
                cVar.b(uuid == null ? null : uuid.toString());
            }
        };
        O = vVar7;
        P = a(UUID.class, vVar7);
        v<Currency> a7 = new v<Currency>() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.a.n.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            /* renamed from: a */
            public Currency b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                return Currency.getInstance(aVar.h());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, Currency currency) throws IOException {
                cVar.b(currency.getCurrencyCode());
            }
        }.a();
        Q = a7;
        R = a(Currency.class, a7);
        S = new w() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.a.n.19
            @Override // com.bytedance.sdk.openadsdk.preload.a.w
            public <T> v<T> a(com.bytedance.sdk.openadsdk.preload.a.f fVar, com.bytedance.sdk.openadsdk.preload.a.c.a<T> aVar) {
                if (aVar.a() != Timestamp.class) {
                    return null;
                }
                final v<T> a8 = fVar.a((Class) Date.class);
                return (v<T>) new v<Timestamp>() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.a.n.19.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.preload.a.v
                    /* renamed from: a */
                    public Timestamp b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar2) throws IOException {
                        Date date = (Date) a8.b(aVar2);
                        if (date != null) {
                            return new Timestamp(date.getTime());
                        }
                        return null;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.preload.a.v
                    public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, Timestamp timestamp) throws IOException {
                        a8.a(cVar, timestamp);
                    }
                };
            }
        };
        v<Calendar> vVar8 = new v<Calendar>() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.a.n.20
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            /* renamed from: a */
            public Calendar b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bytedance.sdk.openadsdk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                aVar.c();
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (aVar.f() != com.bytedance.sdk.openadsdk.preload.a.d.b.END_OBJECT) {
                    String g2 = aVar.g();
                    int m2 = aVar.m();
                    if ("year".equals(g2)) {
                        i2 = m2;
                    } else if ("month".equals(g2)) {
                        i3 = m2;
                    } else if ("dayOfMonth".equals(g2)) {
                        i4 = m2;
                    } else if ("hourOfDay".equals(g2)) {
                        i5 = m2;
                    } else if ("minute".equals(g2)) {
                        i6 = m2;
                    } else if ("second".equals(g2)) {
                        i7 = m2;
                    }
                }
                aVar.d();
                return new GregorianCalendar(i2, i3, i4, i5, i6, i7);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, Calendar calendar) throws IOException {
                if (calendar == null) {
                    cVar.f();
                    return;
                }
                cVar.d();
                cVar.a("year");
                cVar.a(calendar.get(1));
                cVar.a("month");
                cVar.a(calendar.get(2));
                cVar.a("dayOfMonth");
                cVar.a(calendar.get(5));
                cVar.a("hourOfDay");
                cVar.a(calendar.get(11));
                cVar.a("minute");
                cVar.a(calendar.get(12));
                cVar.a("second");
                cVar.a(calendar.get(13));
                cVar.e();
            }
        };
        T = vVar8;
        U = b(Calendar.class, GregorianCalendar.class, vVar8);
        v<Locale> vVar9 = new v<Locale>() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.a.n.21
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            /* renamed from: a */
            public Locale b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bytedance.sdk.openadsdk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                StringTokenizer stringTokenizer = new StringTokenizer(aVar.h(), "_");
                String nextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                String nextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                String nextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                if (nextToken2 == null && nextToken3 == null) {
                    return new Locale(nextToken);
                }
                if (nextToken3 == null) {
                    return new Locale(nextToken, nextToken2);
                }
                return new Locale(nextToken, nextToken2, nextToken3);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, Locale locale) throws IOException {
                cVar.b(locale == null ? null : locale.toString());
            }
        };
        V = vVar9;
        W = a(Locale.class, vVar9);
        v<com.bytedance.sdk.openadsdk.preload.a.l> vVar10 = new v<com.bytedance.sdk.openadsdk.preload.a.l>() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.a.n.22
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            /* renamed from: a */
            public com.bytedance.sdk.openadsdk.preload.a.l b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                switch (AnonymousClass30.f29686a[aVar.f().ordinal()]) {
                    case 1:
                        return new q(new com.bytedance.sdk.openadsdk.preload.a.b.g(aVar.h()));
                    case 2:
                        return new q(Boolean.valueOf(aVar.i()));
                    case 3:
                        return new q(aVar.h());
                    case 4:
                        aVar.j();
                        return com.bytedance.sdk.openadsdk.preload.a.n.f29830a;
                    case 5:
                        com.bytedance.sdk.openadsdk.preload.a.i iVar = new com.bytedance.sdk.openadsdk.preload.a.i();
                        aVar.a();
                        while (aVar.e()) {
                            iVar.a(b(aVar));
                        }
                        aVar.b();
                        return iVar;
                    case 6:
                        o oVar = new o();
                        aVar.c();
                        while (aVar.e()) {
                            oVar.a(aVar.g(), b(aVar));
                        }
                        aVar.d();
                        return oVar;
                    default:
                        throw new IllegalArgumentException();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, com.bytedance.sdk.openadsdk.preload.a.l lVar) throws IOException {
                if (lVar != null && !lVar.j()) {
                    if (lVar.i()) {
                        q m2 = lVar.m();
                        if (m2.o()) {
                            cVar.a(m2.a());
                            return;
                        } else if (m2.n()) {
                            cVar.a(m2.f());
                            return;
                        } else {
                            cVar.b(m2.b());
                            return;
                        }
                    } else if (lVar.g()) {
                        cVar.b();
                        Iterator<com.bytedance.sdk.openadsdk.preload.a.l> it = lVar.l().iterator();
                        while (it.hasNext()) {
                            a(cVar, it.next());
                        }
                        cVar.c();
                        return;
                    } else if (lVar.h()) {
                        cVar.d();
                        for (Map.Entry<String, com.bytedance.sdk.openadsdk.preload.a.l> entry : lVar.k().n()) {
                            cVar.a(entry.getKey());
                            a(cVar, entry.getValue());
                        }
                        cVar.e();
                        return;
                    } else {
                        throw new IllegalArgumentException("Couldn't write " + lVar.getClass());
                    }
                }
                cVar.f();
            }
        };
        X = vVar10;
        Y = b(com.bytedance.sdk.openadsdk.preload.a.l.class, vVar10);
        Z = new w() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.a.n.24
            @Override // com.bytedance.sdk.openadsdk.preload.a.w
            public <T> v<T> a(com.bytedance.sdk.openadsdk.preload.a.f fVar, com.bytedance.sdk.openadsdk.preload.a.c.a<T> aVar) {
                Class a8 = aVar.a();
                if (!Enum.class.isAssignableFrom(a8) || a8 == Enum.class) {
                    return null;
                }
                if (!a8.isEnum()) {
                    a8 = (Class<? super Object>) a8.getSuperclass();
                }
                return new a(a8);
            }
        };
    }

    public static <TT> w a(final com.bytedance.sdk.openadsdk.preload.a.c.a<TT> aVar, final v<TT> vVar) {
        return new w() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.a.n.25
            @Override // com.bytedance.sdk.openadsdk.preload.a.w
            public <T> v<T> a(com.bytedance.sdk.openadsdk.preload.a.f fVar, com.bytedance.sdk.openadsdk.preload.a.c.a<T> aVar2) {
                if (aVar2.equals(com.bytedance.sdk.openadsdk.preload.a.c.a.this)) {
                    return vVar;
                }
                return null;
            }
        };
    }

    public static <TT> w b(final Class<TT> cls, final Class<? extends TT> cls2, final v<? super TT> vVar) {
        return new w() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.a.n.28
            @Override // com.bytedance.sdk.openadsdk.preload.a.w
            public <T> v<T> a(com.bytedance.sdk.openadsdk.preload.a.f fVar, com.bytedance.sdk.openadsdk.preload.a.c.a<T> aVar) {
                Class<? super T> a2 = aVar.a();
                if (a2 == cls || a2 == cls2) {
                    return vVar;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + "+" + cls2.getName() + ",adapter=" + vVar + "]";
            }
        };
    }

    public static <TT> w a(final Class<TT> cls, final v<TT> vVar) {
        return new w() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.a.n.26
            @Override // com.bytedance.sdk.openadsdk.preload.a.w
            public <T> v<T> a(com.bytedance.sdk.openadsdk.preload.a.f fVar, com.bytedance.sdk.openadsdk.preload.a.c.a<T> aVar) {
                if (aVar.a() == cls) {
                    return vVar;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + ",adapter=" + vVar + "]";
            }
        };
    }

    public static <T1> w b(final Class<T1> cls, final v<T1> vVar) {
        return new w() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.a.n.29
            @Override // com.bytedance.sdk.openadsdk.preload.a.w
            public <T2> v<T2> a(com.bytedance.sdk.openadsdk.preload.a.f fVar, com.bytedance.sdk.openadsdk.preload.a.c.a<T2> aVar) {
                final Class<? super T2> a2 = aVar.a();
                if (cls.isAssignableFrom(a2)) {
                    return (v<T2>) new v<T1>() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.a.n.29.1
                        @Override // com.bytedance.sdk.openadsdk.preload.a.v
                        public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, T1 t1) throws IOException {
                            vVar.a(cVar, t1);
                        }

                        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: java.lang.Class */
                        /* JADX WARN: Multi-variable type inference failed */
                        /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object, T1] */
                        @Override // com.bytedance.sdk.openadsdk.preload.a.v
                        public T1 b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar2) throws IOException {
                            ?? b2 = vVar.b(aVar2);
                            if (b2 == 0 || a2.isInstance(b2)) {
                                return b2;
                            }
                            throw new t("Expected a " + a2.getName() + " but was " + b2.getClass().getName());
                        }
                    };
                }
                return null;
            }

            public String toString() {
                return "Factory[typeHierarchy=" + cls.getName() + ",adapter=" + vVar + "]";
            }
        };
    }

    public static <TT> w a(final Class<TT> cls, final Class<TT> cls2, final v<? super TT> vVar) {
        return new w() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.a.n.27
            @Override // com.bytedance.sdk.openadsdk.preload.a.w
            public <T> v<T> a(com.bytedance.sdk.openadsdk.preload.a.f fVar, com.bytedance.sdk.openadsdk.preload.a.c.a<T> aVar) {
                Class<? super T> a2 = aVar.a();
                if (a2 == cls || a2 == cls2) {
                    return vVar;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls2.getName() + "+" + cls.getName() + ",adapter=" + vVar + "]";
            }
        };
    }
}
