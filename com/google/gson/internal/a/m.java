package com.google.gson.internal.a;

import com.google.gson.n;
import com.google.gson.o;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.sql.Timestamp;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
/* loaded from: classes2.dex */
public final class m {
    public static final n<Class> kpr = new n<Class>() { // from class: com.google.gson.internal.a.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Class cls) throws IOException {
            if (cls == null) {
                aVar.cKB();
                return;
            }
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }
    };
    public static final o kps = a(Class.class, kpr);
    public static final n<BitSet> kpt = new n<BitSet>() { // from class: com.google.gson.internal.a.m.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, BitSet bitSet) throws IOException {
            if (bitSet == null) {
                aVar.cKB();
                return;
            }
            aVar.cKx();
            for (int i = 0; i < bitSet.length(); i++) {
                aVar.ej(bitSet.get(i) ? 1 : 0);
            }
            aVar.cKy();
        }
    };
    public static final o kpu = a(BitSet.class, kpt);
    public static final n<Boolean> kpv = new n<Boolean>() { // from class: com.google.gson.internal.a.m.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Boolean bool) throws IOException {
            aVar.l(bool);
        }
    };
    public static final n<Boolean> kpw = new n<Boolean>() { // from class: com.google.gson.internal.a.m.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Boolean bool) throws IOException {
            aVar.GP(bool == null ? "null" : bool.toString());
        }
    };
    public static final o kpx = a(Boolean.TYPE, Boolean.class, kpv);
    public static final n<Number> kpy = new n<Number>() { // from class: com.google.gson.internal.a.m.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final o kpz = a(Byte.TYPE, Byte.class, kpy);
    public static final n<Number> kpA = new n<Number>() { // from class: com.google.gson.internal.a.m.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final o kpB = a(Short.TYPE, Short.class, kpA);
    public static final n<Number> kpC = new n<Number>() { // from class: com.google.gson.internal.a.m.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final o kpD = a(Integer.TYPE, Integer.class, kpC);
    public static final n<AtomicInteger> kpE = new n<AtomicInteger>() { // from class: com.google.gson.internal.a.m.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, AtomicInteger atomicInteger) throws IOException {
            aVar.ej(atomicInteger.get());
        }
    }.cKd();
    public static final o kpF = a(AtomicInteger.class, kpE);
    public static final n<AtomicBoolean> kpG = new n<AtomicBoolean>() { // from class: com.google.gson.internal.a.m.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, AtomicBoolean atomicBoolean) throws IOException {
            aVar.sp(atomicBoolean.get());
        }
    }.cKd();
    public static final o kpH = a(AtomicBoolean.class, kpG);
    public static final n<AtomicIntegerArray> kpI = new n<AtomicIntegerArray>() { // from class: com.google.gson.internal.a.m.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, AtomicIntegerArray atomicIntegerArray) throws IOException {
            aVar.cKx();
            int length = atomicIntegerArray.length();
            for (int i = 0; i < length; i++) {
                aVar.ej(atomicIntegerArray.get(i));
            }
            aVar.cKy();
        }
    }.cKd();
    public static final o kpJ = a(AtomicIntegerArray.class, kpI);
    public static final n<Number> kpK = new n<Number>() { // from class: com.google.gson.internal.a.m.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final n<Number> kpL = new n<Number>() { // from class: com.google.gson.internal.a.m.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final n<Number> kpM = new n<Number>() { // from class: com.google.gson.internal.a.m.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final n<Number> kpN = new n<Number>() { // from class: com.google.gson.internal.a.m.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final o kpO = a(Number.class, kpN);
    public static final n<Character> kpP = new n<Character>() { // from class: com.google.gson.internal.a.m.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Character ch) throws IOException {
            aVar.GP(ch == null ? null : String.valueOf(ch));
        }
    };
    public static final o kpQ = a(Character.TYPE, Character.class, kpP);
    public static final n<String> kpR = new n<String>() { // from class: com.google.gson.internal.a.m.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, String str) throws IOException {
            aVar.GP(str);
        }
    };
    public static final n<BigDecimal> kpS = new n<BigDecimal>() { // from class: com.google.gson.internal.a.m.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, BigDecimal bigDecimal) throws IOException {
            aVar.a(bigDecimal);
        }
    };
    public static final n<BigInteger> kpT = new n<BigInteger>() { // from class: com.google.gson.internal.a.m.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, BigInteger bigInteger) throws IOException {
            aVar.a(bigInteger);
        }
    };
    public static final o kpU = a(String.class, kpR);
    public static final n<StringBuilder> kpV = new n<StringBuilder>() { // from class: com.google.gson.internal.a.m.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, StringBuilder sb) throws IOException {
            aVar.GP(sb == null ? null : sb.toString());
        }
    };
    public static final o kpW = a(StringBuilder.class, kpV);
    public static final n<StringBuffer> kpX = new n<StringBuffer>() { // from class: com.google.gson.internal.a.m.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, StringBuffer stringBuffer) throws IOException {
            aVar.GP(stringBuffer == null ? null : stringBuffer.toString());
        }
    };
    public static final o kpY = a(StringBuffer.class, kpX);
    public static final n<URL> kpZ = new n<URL>() { // from class: com.google.gson.internal.a.m.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, URL url) throws IOException {
            aVar.GP(url == null ? null : url.toExternalForm());
        }
    };
    public static final o kqa = a(URL.class, kpZ);
    public static final n<URI> kqb = new n<URI>() { // from class: com.google.gson.internal.a.m.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, URI uri) throws IOException {
            aVar.GP(uri == null ? null : uri.toASCIIString());
        }
    };
    public static final o kqc = a(URI.class, kqb);
    public static final n<InetAddress> kqd = new n<InetAddress>() { // from class: com.google.gson.internal.a.m.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, InetAddress inetAddress) throws IOException {
            aVar.GP(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    };
    public static final o kqe = b(InetAddress.class, kqd);
    public static final n<UUID> kqf = new n<UUID>() { // from class: com.google.gson.internal.a.m.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, UUID uuid) throws IOException {
            aVar.GP(uuid == null ? null : uuid.toString());
        }
    };
    public static final o kqg = a(UUID.class, kqf);
    public static final n<Currency> kqh = new n<Currency>() { // from class: com.google.gson.internal.a.m.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Currency currency) throws IOException {
            aVar.GP(currency.getCurrencyCode());
        }
    }.cKd();
    public static final o kqi = a(Currency.class, kqh);
    public static final o kqj = new o() { // from class: com.google.gson.internal.a.m.19
        @Override // com.google.gson.o
        public <T> n<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
            if (aVar.cKC() != Timestamp.class) {
                return null;
            }
            final n<T> u = dVar.u(Date.class);
            return (n<T>) new n<Timestamp>() { // from class: com.google.gson.internal.a.m.19.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.gson.n
                public void a(com.google.gson.stream.a aVar2, Timestamp timestamp) throws IOException {
                    u.a(aVar2, timestamp);
                }
            };
        }
    };
    public static final n<Calendar> kqk = new n<Calendar>() { // from class: com.google.gson.internal.a.m.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Calendar calendar) throws IOException {
            if (calendar == null) {
                aVar.cKB();
                return;
            }
            aVar.cKz();
            aVar.GO("year");
            aVar.ej(calendar.get(1));
            aVar.GO("month");
            aVar.ej(calendar.get(2));
            aVar.GO("dayOfMonth");
            aVar.ej(calendar.get(5));
            aVar.GO("hourOfDay");
            aVar.ej(calendar.get(11));
            aVar.GO("minute");
            aVar.ej(calendar.get(12));
            aVar.GO("second");
            aVar.ej(calendar.get(13));
            aVar.cKA();
        }
    };
    public static final o kql = b(Calendar.class, GregorianCalendar.class, kqk);
    public static final n<Locale> kqm = new n<Locale>() { // from class: com.google.gson.internal.a.m.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Locale locale) throws IOException {
            aVar.GP(locale == null ? null : locale.toString());
        }
    };
    public static final o kqn = a(Locale.class, kqm);
    public static final n<com.google.gson.h> kqo = new n<com.google.gson.h>() { // from class: com.google.gson.internal.a.m.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, com.google.gson.h hVar) throws IOException {
            if (hVar == null || hVar.cJV()) {
                aVar.cKB();
            } else if (hVar.cJU()) {
                com.google.gson.k cJY = hVar.cJY();
                if (cJY.cKb()) {
                    aVar.a(cJY.cJP());
                } else if (cJY.cKa()) {
                    aVar.sp(cJY.cJR());
                } else {
                    aVar.GP(cJY.cJQ());
                }
            } else if (hVar.cJS()) {
                aVar.cKx();
                Iterator<com.google.gson.h> it = hVar.cJX().iterator();
                while (it.hasNext()) {
                    a(aVar, it.next());
                }
                aVar.cKy();
            } else if (hVar.cJT()) {
                aVar.cKz();
                for (Map.Entry<String, com.google.gson.h> entry : hVar.cJW().entrySet()) {
                    aVar.GO(entry.getKey());
                    a(aVar, entry.getValue());
                }
                aVar.cKA();
            } else {
                throw new IllegalArgumentException("Couldn't write " + hVar.getClass());
            }
        }
    };
    public static final o kqp = b(com.google.gson.h.class, kqo);
    public static final o kqq = new o() { // from class: com.google.gson.internal.a.m.24
        @Override // com.google.gson.o
        public <T> n<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
            Class cKC = aVar.cKC();
            if (!Enum.class.isAssignableFrom(cKC) || cKC == Enum.class) {
                return null;
            }
            if (!cKC.isEnum()) {
                cKC = (Class<? super Object>) cKC.getSuperclass();
            }
            return new a(cKC);
        }
    };

    /* loaded from: classes2.dex */
    private static final class a<T extends Enum<T>> extends n<T> {
        private final Map<String, T> kqB = new HashMap();
        private final Map<T, String> kqC = new HashMap();

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.gson.internal.a.m$a<T extends java.lang.Enum<T>> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.gson.n
        public /* bridge */ /* synthetic */ void a(com.google.gson.stream.a aVar, Object obj) throws IOException {
            a(aVar, (com.google.gson.stream.a) ((Enum) obj));
        }

        public a(Class<T> cls) {
            T[] enumConstants;
            try {
                for (T t : cls.getEnumConstants()) {
                    String name = t.name();
                    com.google.gson.a.c cVar = (com.google.gson.a.c) cls.getField(name).getAnnotation(com.google.gson.a.c.class);
                    if (cVar != null) {
                        name = cVar.value();
                        String[] cKh = cVar.cKh();
                        for (String str : cKh) {
                            this.kqB.put(str, t);
                        }
                    }
                    String str2 = name;
                    this.kqB.put(str2, t);
                    this.kqC.put(t, str2);
                }
            } catch (NoSuchFieldException e) {
                throw new AssertionError(e);
            }
        }

        public void a(com.google.gson.stream.a aVar, T t) throws IOException {
            aVar.GP(t == null ? null : this.kqC.get(t));
        }
    }

    public static <TT> o a(final Class<TT> cls, final n<TT> nVar) {
        return new o() { // from class: com.google.gson.internal.a.m.25
            @Override // com.google.gson.o
            public <T> n<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
                if (aVar.cKC() == cls) {
                    return nVar;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + ",adapter=" + nVar + "]";
            }
        };
    }

    public static <TT> o a(final Class<TT> cls, final Class<TT> cls2, final n<? super TT> nVar) {
        return new o() { // from class: com.google.gson.internal.a.m.26
            @Override // com.google.gson.o
            public <T> n<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
                Class<? super T> cKC = aVar.cKC();
                if (cKC == cls || cKC == cls2) {
                    return nVar;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls2.getName() + "+" + cls.getName() + ",adapter=" + nVar + "]";
            }
        };
    }

    public static <TT> o b(final Class<TT> cls, final Class<? extends TT> cls2, final n<? super TT> nVar) {
        return new o() { // from class: com.google.gson.internal.a.m.27
            @Override // com.google.gson.o
            public <T> n<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
                Class<? super T> cKC = aVar.cKC();
                if (cKC == cls || cKC == cls2) {
                    return nVar;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + "+" + cls2.getName() + ",adapter=" + nVar + "]";
            }
        };
    }

    public static <T1> o b(final Class<T1> cls, final n<T1> nVar) {
        return new o() { // from class: com.google.gson.internal.a.m.28
            @Override // com.google.gson.o
            public <T2> n<T2> a(com.google.gson.d dVar, com.google.gson.b.a<T2> aVar) {
                final Class<? super T2> cKC = aVar.cKC();
                if (cls.isAssignableFrom(cKC)) {
                    return (n<T2>) new n<T1>() { // from class: com.google.gson.internal.a.m.28.1
                        @Override // com.google.gson.n
                        public void a(com.google.gson.stream.a aVar2, T1 t1) throws IOException {
                            nVar.a(aVar2, t1);
                        }
                    };
                }
                return null;
            }

            public String toString() {
                return "Factory[typeHierarchy=" + cls.getName() + ",adapter=" + nVar + "]";
            }
        };
    }
}
