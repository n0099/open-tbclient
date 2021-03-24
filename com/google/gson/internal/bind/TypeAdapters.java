package com.google.gson.internal.bind;

import com.baidu.android.common.others.lang.StringUtil;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.stream.JsonToken;
import d.g.c.a.c;
import d.g.c.d.b;
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
/* loaded from: classes6.dex */
public final class TypeAdapters {
    public static final TypeAdapter<String> A;
    public static final TypeAdapter<BigDecimal> B;
    public static final TypeAdapter<BigInteger> C;
    public static final TypeAdapterFactory D;
    public static final TypeAdapter<StringBuilder> E;
    public static final TypeAdapterFactory F;
    public static final TypeAdapter<StringBuffer> G;
    public static final TypeAdapterFactory H;
    public static final TypeAdapter<URL> I;
    public static final TypeAdapterFactory J;
    public static final TypeAdapter<URI> K;
    public static final TypeAdapterFactory L;
    public static final TypeAdapter<InetAddress> M;
    public static final TypeAdapterFactory N;
    public static final TypeAdapter<UUID> O;
    public static final TypeAdapterFactory P;
    public static final TypeAdapter<Currency> Q;
    public static final TypeAdapterFactory R;
    public static final TypeAdapterFactory S;
    public static final TypeAdapter<Calendar> T;
    public static final TypeAdapterFactory U;
    public static final TypeAdapter<Locale> V;
    public static final TypeAdapterFactory W;
    public static final TypeAdapter<JsonElement> X;
    public static final TypeAdapterFactory Y;
    public static final TypeAdapterFactory Z;

    /* renamed from: a  reason: collision with root package name */
    public static final TypeAdapter<Class> f30992a;

    /* renamed from: b  reason: collision with root package name */
    public static final TypeAdapterFactory f30993b;

    /* renamed from: c  reason: collision with root package name */
    public static final TypeAdapter<BitSet> f30994c;

    /* renamed from: d  reason: collision with root package name */
    public static final TypeAdapterFactory f30995d;

    /* renamed from: e  reason: collision with root package name */
    public static final TypeAdapter<Boolean> f30996e;

    /* renamed from: f  reason: collision with root package name */
    public static final TypeAdapter<Boolean> f30997f;

    /* renamed from: g  reason: collision with root package name */
    public static final TypeAdapterFactory f30998g;

    /* renamed from: h  reason: collision with root package name */
    public static final TypeAdapter<Number> f30999h;
    public static final TypeAdapterFactory i;
    public static final TypeAdapter<Number> j;
    public static final TypeAdapterFactory k;
    public static final TypeAdapter<Number> l;
    public static final TypeAdapterFactory m;
    public static final TypeAdapter<AtomicInteger> n;
    public static final TypeAdapterFactory o;
    public static final TypeAdapter<AtomicBoolean> p;
    public static final TypeAdapterFactory q;
    public static final TypeAdapter<AtomicIntegerArray> r;
    public static final TypeAdapterFactory s;
    public static final TypeAdapter<Number> t;
    public static final TypeAdapter<Number> u;
    public static final TypeAdapter<Number> v;
    public static final TypeAdapter<Number> w;
    public static final TypeAdapterFactory x;
    public static final TypeAdapter<Character> y;
    public static final TypeAdapterFactory z;

    /* loaded from: classes6.dex */
    public static final class EnumTypeAdapter<T extends Enum<T>> extends TypeAdapter<T> {

        /* renamed from: a  reason: collision with root package name */
        public final Map<String, T> f31015a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        public final Map<T, String> f31016b = new HashMap();

        public EnumTypeAdapter(Class<T> cls) {
            T[] enumConstants;
            try {
                for (T t : cls.getEnumConstants()) {
                    String name = t.name();
                    c cVar = (c) cls.getField(name).getAnnotation(c.class);
                    if (cVar != null) {
                        name = cVar.value();
                        for (String str : cVar.alternate()) {
                            this.f31015a.put(str, t);
                        }
                    }
                    this.f31015a.put(name, t);
                    this.f31016b.put(t, name);
                }
            } catch (NoSuchFieldException e2) {
                throw new AssertionError(e2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public T read(d.g.c.d.a aVar) throws IOException {
            if (aVar.M() == JsonToken.NULL) {
                aVar.I();
                return null;
            }
            return this.f31015a.get(aVar.K());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: b */
        public void write(b bVar, T t) throws IOException {
            bVar.O(t == null ? null : this.f31016b.get(t));
        }
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f31017a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            f31017a = iArr;
            try {
                iArr[JsonToken.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31017a[JsonToken.BOOLEAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f31017a[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f31017a[JsonToken.NULL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f31017a[JsonToken.BEGIN_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f31017a[JsonToken.BEGIN_OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f31017a[JsonToken.END_DOCUMENT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f31017a[JsonToken.NAME.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f31017a[JsonToken.END_OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f31017a[JsonToken.END_ARRAY.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    static {
        TypeAdapter<Class> nullSafe = new TypeAdapter<Class>() { // from class: com.google.gson.internal.bind.TypeAdapters.1
            public Class a(d.g.c.d.a aVar) throws IOException {
                throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
            }

            public void b(b bVar, Class cls) throws IOException {
                throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
            }

            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.google.gson.TypeAdapter
            public /* bridge */ /* synthetic */ Class read(d.g.c.d.a aVar) throws IOException {
                a(aVar);
                throw null;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [d.g.c.d.b, java.lang.Object] */
            @Override // com.google.gson.TypeAdapter
            public /* bridge */ /* synthetic */ void write(b bVar, Class cls) throws IOException {
                b(bVar, cls);
                throw null;
            }
        }.nullSafe();
        f30992a = nullSafe;
        f30993b = b(Class.class, nullSafe);
        TypeAdapter<BitSet> nullSafe2 = new TypeAdapter<BitSet>() { // from class: com.google.gson.internal.bind.TypeAdapters.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
                if (java.lang.Integer.parseInt(r1) != 0) goto L15;
             */
            /* JADX WARN: Code restructure failed: missing block: B:15:0x002e, code lost:
                r5 = false;
             */
            /* JADX WARN: Code restructure failed: missing block: B:22:0x0067, code lost:
                if (r8.E() != 0) goto L15;
             */
            @Override // com.google.gson.TypeAdapter
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public BitSet read(d.g.c.d.a aVar) throws IOException {
                BitSet bitSet = new BitSet();
                aVar.n();
                JsonToken M2 = aVar.M();
                int i2 = 0;
                while (M2 != JsonToken.END_ARRAY) {
                    int i3 = a.f31017a[M2.ordinal()];
                    boolean z2 = true;
                    if (i3 != 1) {
                        if (i3 == 2) {
                            z2 = aVar.C();
                        } else if (i3 == 3) {
                            String K2 = aVar.K();
                            try {
                            } catch (NumberFormatException unused) {
                                throw new JsonSyntaxException("Error: Expecting: bitset number value (1, 0), Found: " + K2);
                            }
                        } else {
                            throw new JsonSyntaxException("Invalid bitset value type: " + M2);
                        }
                        if (z2) {
                            bitSet.set(i2);
                        }
                        i2++;
                        M2 = aVar.M();
                    }
                }
                aVar.t();
                return bitSet;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            /* renamed from: b */
            public void write(b bVar, BitSet bitSet) throws IOException {
                bVar.q();
                int length = bitSet.length();
                for (int i2 = 0; i2 < length; i2++) {
                    bVar.L(bitSet.get(i2) ? 1L : 0L);
                }
                bVar.t();
            }
        }.nullSafe();
        f30994c = nullSafe2;
        f30995d = b(BitSet.class, nullSafe2);
        f30996e = new TypeAdapter<Boolean>() { // from class: com.google.gson.internal.bind.TypeAdapters.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            /* renamed from: a */
            public Boolean read(d.g.c.d.a aVar) throws IOException {
                JsonToken M2 = aVar.M();
                if (M2 == JsonToken.NULL) {
                    aVar.I();
                    return null;
                } else if (M2 == JsonToken.STRING) {
                    return Boolean.valueOf(Boolean.parseBoolean(aVar.K()));
                } else {
                    return Boolean.valueOf(aVar.C());
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            /* renamed from: b */
            public void write(b bVar, Boolean bool) throws IOException {
                bVar.M(bool);
            }
        };
        f30997f = new TypeAdapter<Boolean>() { // from class: com.google.gson.internal.bind.TypeAdapters.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            /* renamed from: a */
            public Boolean read(d.g.c.d.a aVar) throws IOException {
                if (aVar.M() == JsonToken.NULL) {
                    aVar.I();
                    return null;
                }
                return Boolean.valueOf(aVar.K());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            /* renamed from: b */
            public void write(b bVar, Boolean bool) throws IOException {
                bVar.O(bool == null ? StringUtil.NULL_STRING : bool.toString());
            }
        };
        f30998g = c(Boolean.TYPE, Boolean.class, f30996e);
        f30999h = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.5
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.gson.TypeAdapter
            public Number read(d.g.c.d.a aVar) throws IOException {
                if (aVar.M() == JsonToken.NULL) {
                    aVar.I();
                    return null;
                }
                try {
                    return Byte.valueOf((byte) aVar.E());
                } catch (NumberFormatException e2) {
                    throw new JsonSyntaxException(e2);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            public void write(b bVar, Number number) throws IOException {
                bVar.N(number);
            }
        };
        i = c(Byte.TYPE, Byte.class, f30999h);
        j = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.gson.TypeAdapter
            public Number read(d.g.c.d.a aVar) throws IOException {
                if (aVar.M() == JsonToken.NULL) {
                    aVar.I();
                    return null;
                }
                try {
                    return Short.valueOf((short) aVar.E());
                } catch (NumberFormatException e2) {
                    throw new JsonSyntaxException(e2);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            public void write(b bVar, Number number) throws IOException {
                bVar.N(number);
            }
        };
        k = c(Short.TYPE, Short.class, j);
        l = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.7
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.gson.TypeAdapter
            public Number read(d.g.c.d.a aVar) throws IOException {
                if (aVar.M() == JsonToken.NULL) {
                    aVar.I();
                    return null;
                }
                try {
                    return Integer.valueOf(aVar.E());
                } catch (NumberFormatException e2) {
                    throw new JsonSyntaxException(e2);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            public void write(b bVar, Number number) throws IOException {
                bVar.N(number);
            }
        };
        m = c(Integer.TYPE, Integer.class, l);
        TypeAdapter<AtomicInteger> nullSafe3 = new TypeAdapter<AtomicInteger>() { // from class: com.google.gson.internal.bind.TypeAdapters.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            /* renamed from: a */
            public AtomicInteger read(d.g.c.d.a aVar) throws IOException {
                try {
                    return new AtomicInteger(aVar.E());
                } catch (NumberFormatException e2) {
                    throw new JsonSyntaxException(e2);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            /* renamed from: b */
            public void write(b bVar, AtomicInteger atomicInteger) throws IOException {
                bVar.L(atomicInteger.get());
            }
        }.nullSafe();
        n = nullSafe3;
        o = b(AtomicInteger.class, nullSafe3);
        TypeAdapter<AtomicBoolean> nullSafe4 = new TypeAdapter<AtomicBoolean>() { // from class: com.google.gson.internal.bind.TypeAdapters.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            /* renamed from: a */
            public AtomicBoolean read(d.g.c.d.a aVar) throws IOException {
                return new AtomicBoolean(aVar.C());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            /* renamed from: b */
            public void write(b bVar, AtomicBoolean atomicBoolean) throws IOException {
                bVar.P(atomicBoolean.get());
            }
        }.nullSafe();
        p = nullSafe4;
        q = b(AtomicBoolean.class, nullSafe4);
        TypeAdapter<AtomicIntegerArray> nullSafe5 = new TypeAdapter<AtomicIntegerArray>() { // from class: com.google.gson.internal.bind.TypeAdapters.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            /* renamed from: a */
            public AtomicIntegerArray read(d.g.c.d.a aVar) throws IOException {
                ArrayList arrayList = new ArrayList();
                aVar.n();
                while (aVar.y()) {
                    try {
                        arrayList.add(Integer.valueOf(aVar.E()));
                    } catch (NumberFormatException e2) {
                        throw new JsonSyntaxException(e2);
                    }
                }
                aVar.t();
                int size = arrayList.size();
                AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
                for (int i2 = 0; i2 < size; i2++) {
                    atomicIntegerArray.set(i2, ((Integer) arrayList.get(i2)).intValue());
                }
                return atomicIntegerArray;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            /* renamed from: b */
            public void write(b bVar, AtomicIntegerArray atomicIntegerArray) throws IOException {
                bVar.q();
                int length = atomicIntegerArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    bVar.L(atomicIntegerArray.get(i2));
                }
                bVar.t();
            }
        }.nullSafe();
        r = nullSafe5;
        s = b(AtomicIntegerArray.class, nullSafe5);
        t = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.11
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.gson.TypeAdapter
            public Number read(d.g.c.d.a aVar) throws IOException {
                if (aVar.M() == JsonToken.NULL) {
                    aVar.I();
                    return null;
                }
                try {
                    return Long.valueOf(aVar.F());
                } catch (NumberFormatException e2) {
                    throw new JsonSyntaxException(e2);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            public void write(b bVar, Number number) throws IOException {
                bVar.N(number);
            }
        };
        u = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.12
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.gson.TypeAdapter
            public Number read(d.g.c.d.a aVar) throws IOException {
                if (aVar.M() == JsonToken.NULL) {
                    aVar.I();
                    return null;
                }
                return Float.valueOf((float) aVar.D());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            public void write(b bVar, Number number) throws IOException {
                bVar.N(number);
            }
        };
        v = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.13
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.gson.TypeAdapter
            public Number read(d.g.c.d.a aVar) throws IOException {
                if (aVar.M() == JsonToken.NULL) {
                    aVar.I();
                    return null;
                }
                return Double.valueOf(aVar.D());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            public void write(b bVar, Number number) throws IOException {
                bVar.N(number);
            }
        };
        TypeAdapter<Number> typeAdapter = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.14
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.gson.TypeAdapter
            public Number read(d.g.c.d.a aVar) throws IOException {
                JsonToken M2 = aVar.M();
                int i2 = a.f31017a[M2.ordinal()];
                if (i2 == 1 || i2 == 3) {
                    return new LazilyParsedNumber(aVar.K());
                }
                if (i2 == 4) {
                    aVar.I();
                    return null;
                }
                throw new JsonSyntaxException("Expecting number, got: " + M2);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            public void write(b bVar, Number number) throws IOException {
                bVar.N(number);
            }
        };
        w = typeAdapter;
        x = b(Number.class, typeAdapter);
        y = new TypeAdapter<Character>() { // from class: com.google.gson.internal.bind.TypeAdapters.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            /* renamed from: a */
            public Character read(d.g.c.d.a aVar) throws IOException {
                if (aVar.M() == JsonToken.NULL) {
                    aVar.I();
                    return null;
                }
                String K2 = aVar.K();
                if (K2.length() == 1) {
                    return Character.valueOf(K2.charAt(0));
                }
                throw new JsonSyntaxException("Expecting character, got: " + K2);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            /* renamed from: b */
            public void write(b bVar, Character ch) throws IOException {
                bVar.O(ch == null ? null : String.valueOf(ch));
            }
        };
        z = c(Character.TYPE, Character.class, y);
        A = new TypeAdapter<String>() { // from class: com.google.gson.internal.bind.TypeAdapters.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            /* renamed from: a */
            public String read(d.g.c.d.a aVar) throws IOException {
                JsonToken M2 = aVar.M();
                if (M2 == JsonToken.NULL) {
                    aVar.I();
                    return null;
                } else if (M2 == JsonToken.BOOLEAN) {
                    return Boolean.toString(aVar.C());
                } else {
                    return aVar.K();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            /* renamed from: b */
            public void write(b bVar, String str) throws IOException {
                bVar.O(str);
            }
        };
        B = new TypeAdapter<BigDecimal>() { // from class: com.google.gson.internal.bind.TypeAdapters.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            /* renamed from: a */
            public BigDecimal read(d.g.c.d.a aVar) throws IOException {
                if (aVar.M() == JsonToken.NULL) {
                    aVar.I();
                    return null;
                }
                try {
                    return new BigDecimal(aVar.K());
                } catch (NumberFormatException e2) {
                    throw new JsonSyntaxException(e2);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            /* renamed from: b */
            public void write(b bVar, BigDecimal bigDecimal) throws IOException {
                bVar.N(bigDecimal);
            }
        };
        C = new TypeAdapter<BigInteger>() { // from class: com.google.gson.internal.bind.TypeAdapters.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            /* renamed from: a */
            public BigInteger read(d.g.c.d.a aVar) throws IOException {
                if (aVar.M() == JsonToken.NULL) {
                    aVar.I();
                    return null;
                }
                try {
                    return new BigInteger(aVar.K());
                } catch (NumberFormatException e2) {
                    throw new JsonSyntaxException(e2);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            /* renamed from: b */
            public void write(b bVar, BigInteger bigInteger) throws IOException {
                bVar.N(bigInteger);
            }
        };
        D = b(String.class, A);
        TypeAdapter<StringBuilder> typeAdapter2 = new TypeAdapter<StringBuilder>() { // from class: com.google.gson.internal.bind.TypeAdapters.19
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            /* renamed from: a */
            public StringBuilder read(d.g.c.d.a aVar) throws IOException {
                if (aVar.M() == JsonToken.NULL) {
                    aVar.I();
                    return null;
                }
                return new StringBuilder(aVar.K());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            /* renamed from: b */
            public void write(b bVar, StringBuilder sb) throws IOException {
                bVar.O(sb == null ? null : sb.toString());
            }
        };
        E = typeAdapter2;
        F = b(StringBuilder.class, typeAdapter2);
        TypeAdapter<StringBuffer> typeAdapter3 = new TypeAdapter<StringBuffer>() { // from class: com.google.gson.internal.bind.TypeAdapters.20
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            /* renamed from: a */
            public StringBuffer read(d.g.c.d.a aVar) throws IOException {
                if (aVar.M() == JsonToken.NULL) {
                    aVar.I();
                    return null;
                }
                return new StringBuffer(aVar.K());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            /* renamed from: b */
            public void write(b bVar, StringBuffer stringBuffer) throws IOException {
                bVar.O(stringBuffer == null ? null : stringBuffer.toString());
            }
        };
        G = typeAdapter3;
        H = b(StringBuffer.class, typeAdapter3);
        TypeAdapter<URL> typeAdapter4 = new TypeAdapter<URL>() { // from class: com.google.gson.internal.bind.TypeAdapters.21
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            /* renamed from: a */
            public URL read(d.g.c.d.a aVar) throws IOException {
                if (aVar.M() == JsonToken.NULL) {
                    aVar.I();
                    return null;
                }
                String K2 = aVar.K();
                if (StringUtil.NULL_STRING.equals(K2)) {
                    return null;
                }
                return new URL(K2);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            /* renamed from: b */
            public void write(b bVar, URL url) throws IOException {
                bVar.O(url == null ? null : url.toExternalForm());
            }
        };
        I = typeAdapter4;
        J = b(URL.class, typeAdapter4);
        TypeAdapter<URI> typeAdapter5 = new TypeAdapter<URI>() { // from class: com.google.gson.internal.bind.TypeAdapters.22
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            /* renamed from: a */
            public URI read(d.g.c.d.a aVar) throws IOException {
                if (aVar.M() == JsonToken.NULL) {
                    aVar.I();
                    return null;
                }
                try {
                    String K2 = aVar.K();
                    if (StringUtil.NULL_STRING.equals(K2)) {
                        return null;
                    }
                    return new URI(K2);
                } catch (URISyntaxException e2) {
                    throw new JsonIOException(e2);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            /* renamed from: b */
            public void write(b bVar, URI uri) throws IOException {
                bVar.O(uri == null ? null : uri.toASCIIString());
            }
        };
        K = typeAdapter5;
        L = b(URI.class, typeAdapter5);
        TypeAdapter<InetAddress> typeAdapter6 = new TypeAdapter<InetAddress>() { // from class: com.google.gson.internal.bind.TypeAdapters.23
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            /* renamed from: a */
            public InetAddress read(d.g.c.d.a aVar) throws IOException {
                if (aVar.M() == JsonToken.NULL) {
                    aVar.I();
                    return null;
                }
                return InetAddress.getByName(aVar.K());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            /* renamed from: b */
            public void write(b bVar, InetAddress inetAddress) throws IOException {
                bVar.O(inetAddress == null ? null : inetAddress.getHostAddress());
            }
        };
        M = typeAdapter6;
        N = e(InetAddress.class, typeAdapter6);
        TypeAdapter<UUID> typeAdapter7 = new TypeAdapter<UUID>() { // from class: com.google.gson.internal.bind.TypeAdapters.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            /* renamed from: a */
            public UUID read(d.g.c.d.a aVar) throws IOException {
                if (aVar.M() == JsonToken.NULL) {
                    aVar.I();
                    return null;
                }
                return UUID.fromString(aVar.K());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            /* renamed from: b */
            public void write(b bVar, UUID uuid) throws IOException {
                bVar.O(uuid == null ? null : uuid.toString());
            }
        };
        O = typeAdapter7;
        P = b(UUID.class, typeAdapter7);
        TypeAdapter<Currency> nullSafe6 = new TypeAdapter<Currency>() { // from class: com.google.gson.internal.bind.TypeAdapters.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            /* renamed from: a */
            public Currency read(d.g.c.d.a aVar) throws IOException {
                return Currency.getInstance(aVar.K());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            /* renamed from: b */
            public void write(b bVar, Currency currency) throws IOException {
                bVar.O(currency.getCurrencyCode());
            }
        }.nullSafe();
        Q = nullSafe6;
        R = b(Currency.class, nullSafe6);
        S = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.26
            @Override // com.google.gson.TypeAdapterFactory
            public <T> TypeAdapter<T> create(Gson gson, d.g.c.c.a<T> aVar) {
                if (aVar.c() != Timestamp.class) {
                    return null;
                }
                final TypeAdapter<T> adapter = gson.getAdapter(Date.class);
                return (TypeAdapter<T>) new TypeAdapter<Timestamp>(this) { // from class: com.google.gson.internal.bind.TypeAdapters.26.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.google.gson.TypeAdapter
                    /* renamed from: a */
                    public Timestamp read(d.g.c.d.a aVar2) throws IOException {
                        Date date = (Date) adapter.read(aVar2);
                        if (date != null) {
                            return new Timestamp(date.getTime());
                        }
                        return null;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.google.gson.TypeAdapter
                    /* renamed from: b */
                    public void write(b bVar, Timestamp timestamp) throws IOException {
                        adapter.write(bVar, timestamp);
                    }
                };
            }
        };
        TypeAdapter<Calendar> typeAdapter8 = new TypeAdapter<Calendar>() { // from class: com.google.gson.internal.bind.TypeAdapters.27
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            /* renamed from: a */
            public Calendar read(d.g.c.d.a aVar) throws IOException {
                if (aVar.M() == JsonToken.NULL) {
                    aVar.I();
                    return null;
                }
                aVar.o();
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (aVar.M() != JsonToken.END_OBJECT) {
                    String G2 = aVar.G();
                    int E2 = aVar.E();
                    if ("year".equals(G2)) {
                        i2 = E2;
                    } else if ("month".equals(G2)) {
                        i3 = E2;
                    } else if ("dayOfMonth".equals(G2)) {
                        i4 = E2;
                    } else if ("hourOfDay".equals(G2)) {
                        i5 = E2;
                    } else if ("minute".equals(G2)) {
                        i6 = E2;
                    } else if ("second".equals(G2)) {
                        i7 = E2;
                    }
                }
                aVar.v();
                return new GregorianCalendar(i2, i3, i4, i5, i6, i7);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            /* renamed from: b */
            public void write(b bVar, Calendar calendar) throws IOException {
                if (calendar == null) {
                    bVar.B();
                    return;
                }
                bVar.r();
                bVar.z("year");
                bVar.L(calendar.get(1));
                bVar.z("month");
                bVar.L(calendar.get(2));
                bVar.z("dayOfMonth");
                bVar.L(calendar.get(5));
                bVar.z("hourOfDay");
                bVar.L(calendar.get(11));
                bVar.z("minute");
                bVar.L(calendar.get(12));
                bVar.z("second");
                bVar.L(calendar.get(13));
                bVar.v();
            }
        };
        T = typeAdapter8;
        U = d(Calendar.class, GregorianCalendar.class, typeAdapter8);
        TypeAdapter<Locale> typeAdapter9 = new TypeAdapter<Locale>() { // from class: com.google.gson.internal.bind.TypeAdapters.28
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            /* renamed from: a */
            public Locale read(d.g.c.d.a aVar) throws IOException {
                if (aVar.M() == JsonToken.NULL) {
                    aVar.I();
                    return null;
                }
                StringTokenizer stringTokenizer = new StringTokenizer(aVar.K(), "_");
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
            @Override // com.google.gson.TypeAdapter
            /* renamed from: b */
            public void write(b bVar, Locale locale) throws IOException {
                bVar.O(locale == null ? null : locale.toString());
            }
        };
        V = typeAdapter9;
        W = b(Locale.class, typeAdapter9);
        TypeAdapter<JsonElement> typeAdapter10 = new TypeAdapter<JsonElement>() { // from class: com.google.gson.internal.bind.TypeAdapters.29
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            /* renamed from: a */
            public JsonElement read(d.g.c.d.a aVar) throws IOException {
                switch (a.f31017a[aVar.M().ordinal()]) {
                    case 1:
                        return new JsonPrimitive((Number) new LazilyParsedNumber(aVar.K()));
                    case 2:
                        return new JsonPrimitive(Boolean.valueOf(aVar.C()));
                    case 3:
                        return new JsonPrimitive(aVar.K());
                    case 4:
                        aVar.I();
                        return JsonNull.INSTANCE;
                    case 5:
                        JsonArray jsonArray = new JsonArray();
                        aVar.n();
                        while (aVar.y()) {
                            jsonArray.add(read(aVar));
                        }
                        aVar.t();
                        return jsonArray;
                    case 6:
                        JsonObject jsonObject = new JsonObject();
                        aVar.o();
                        while (aVar.y()) {
                            jsonObject.add(aVar.G(), read(aVar));
                        }
                        aVar.v();
                        return jsonObject;
                    default:
                        throw new IllegalArgumentException();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            /* renamed from: b */
            public void write(b bVar, JsonElement jsonElement) throws IOException {
                if (jsonElement != null && !jsonElement.isJsonNull()) {
                    if (jsonElement.isJsonPrimitive()) {
                        JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
                        if (asJsonPrimitive.isNumber()) {
                            bVar.N(asJsonPrimitive.getAsNumber());
                            return;
                        } else if (asJsonPrimitive.isBoolean()) {
                            bVar.P(asJsonPrimitive.getAsBoolean());
                            return;
                        } else {
                            bVar.O(asJsonPrimitive.getAsString());
                            return;
                        }
                    } else if (jsonElement.isJsonArray()) {
                        bVar.q();
                        Iterator<JsonElement> it = jsonElement.getAsJsonArray().iterator();
                        while (it.hasNext()) {
                            write(bVar, it.next());
                        }
                        bVar.t();
                        return;
                    } else if (jsonElement.isJsonObject()) {
                        bVar.r();
                        for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
                            bVar.z(entry.getKey());
                            write(bVar, entry.getValue());
                        }
                        bVar.v();
                        return;
                    } else {
                        throw new IllegalArgumentException("Couldn't write " + jsonElement.getClass());
                    }
                }
                bVar.B();
            }
        };
        X = typeAdapter10;
        Y = e(JsonElement.class, typeAdapter10);
        Z = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.30
            @Override // com.google.gson.TypeAdapterFactory
            public <T> TypeAdapter<T> create(Gson gson, d.g.c.c.a<T> aVar) {
                Class c2 = aVar.c();
                if (!Enum.class.isAssignableFrom(c2) || c2 == Enum.class) {
                    return null;
                }
                if (!c2.isEnum()) {
                    c2 = (Class<? super Object>) c2.getSuperclass();
                }
                return new EnumTypeAdapter(c2);
            }
        };
    }

    public static <TT> TypeAdapterFactory a(final d.g.c.c.a<TT> aVar, final TypeAdapter<TT> typeAdapter) {
        return new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.31
            @Override // com.google.gson.TypeAdapterFactory
            public <T> TypeAdapter<T> create(Gson gson, d.g.c.c.a<T> aVar2) {
                if (aVar2.equals(d.g.c.c.a.this)) {
                    return typeAdapter;
                }
                return null;
            }
        };
    }

    public static <TT> TypeAdapterFactory b(final Class<TT> cls, final TypeAdapter<TT> typeAdapter) {
        return new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.32
            @Override // com.google.gson.TypeAdapterFactory
            public <T> TypeAdapter<T> create(Gson gson, d.g.c.c.a<T> aVar) {
                if (aVar.c() == cls) {
                    return typeAdapter;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    public static <TT> TypeAdapterFactory c(final Class<TT> cls, final Class<TT> cls2, final TypeAdapter<? super TT> typeAdapter) {
        return new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.33
            @Override // com.google.gson.TypeAdapterFactory
            public <T> TypeAdapter<T> create(Gson gson, d.g.c.c.a<T> aVar) {
                Class<? super T> c2 = aVar.c();
                if (c2 == cls || c2 == cls2) {
                    return typeAdapter;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls2.getName() + "+" + cls.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    public static <TT> TypeAdapterFactory d(final Class<TT> cls, final Class<? extends TT> cls2, final TypeAdapter<? super TT> typeAdapter) {
        return new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.34
            @Override // com.google.gson.TypeAdapterFactory
            public <T> TypeAdapter<T> create(Gson gson, d.g.c.c.a<T> aVar) {
                Class<? super T> c2 = aVar.c();
                if (c2 == cls || c2 == cls2) {
                    return typeAdapter;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + "+" + cls2.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    public static <T1> TypeAdapterFactory e(final Class<T1> cls, final TypeAdapter<T1> typeAdapter) {
        return new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.35
            @Override // com.google.gson.TypeAdapterFactory
            public <T2> TypeAdapter<T2> create(Gson gson, d.g.c.c.a<T2> aVar) {
                final Class<? super T2> c2 = aVar.c();
                if (cls.isAssignableFrom(c2)) {
                    return (TypeAdapter<T2>) new TypeAdapter<T1>() { // from class: com.google.gson.internal.bind.TypeAdapters.35.1
                        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: java.lang.Class */
                        /* JADX WARN: Multi-variable type inference failed */
                        /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object, T1] */
                        @Override // com.google.gson.TypeAdapter
                        public T1 read(d.g.c.d.a aVar2) throws IOException {
                            ?? read = typeAdapter.read(aVar2);
                            if (read == 0 || c2.isInstance(read)) {
                                return read;
                            }
                            throw new JsonSyntaxException("Expected a " + c2.getName() + " but was " + read.getClass().getName());
                        }

                        @Override // com.google.gson.TypeAdapter
                        public void write(b bVar, T1 t1) throws IOException {
                            typeAdapter.write(bVar, t1);
                        }
                    };
                }
                return null;
            }

            public String toString() {
                return "Factory[typeHierarchy=" + cls.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }
}
