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
    public static final n<Class> krW = new n<Class>() { // from class: com.google.gson.internal.a.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Class cls) throws IOException {
            if (cls == null) {
                aVar.cNG();
                return;
            }
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }
    };
    public static final o krX = a(Class.class, krW);
    public static final n<BitSet> krY = new n<BitSet>() { // from class: com.google.gson.internal.a.m.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, BitSet bitSet) throws IOException {
            if (bitSet == null) {
                aVar.cNG();
                return;
            }
            aVar.cNC();
            for (int i = 0; i < bitSet.length(); i++) {
                aVar.eQ(bitSet.get(i) ? 1 : 0);
            }
            aVar.cND();
        }
    };
    public static final o krZ = a(BitSet.class, krY);
    public static final n<Boolean> ksa = new n<Boolean>() { // from class: com.google.gson.internal.a.m.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Boolean bool) throws IOException {
            aVar.m(bool);
        }
    };
    public static final n<Boolean> ksb = new n<Boolean>() { // from class: com.google.gson.internal.a.m.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Boolean bool) throws IOException {
            aVar.Iy(bool == null ? "null" : bool.toString());
        }
    };
    public static final o ksc = a(Boolean.TYPE, Boolean.class, ksa);
    public static final n<Number> ksd = new n<Number>() { // from class: com.google.gson.internal.a.m.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final o kse = a(Byte.TYPE, Byte.class, ksd);
    public static final n<Number> ksf = new n<Number>() { // from class: com.google.gson.internal.a.m.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final o ksg = a(Short.TYPE, Short.class, ksf);
    public static final n<Number> ksh = new n<Number>() { // from class: com.google.gson.internal.a.m.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final o ksi = a(Integer.TYPE, Integer.class, ksh);
    public static final n<AtomicInteger> ksj = new n<AtomicInteger>() { // from class: com.google.gson.internal.a.m.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, AtomicInteger atomicInteger) throws IOException {
            aVar.eQ(atomicInteger.get());
        }
    }.cNi();
    public static final o ksk = a(AtomicInteger.class, ksj);
    public static final n<AtomicBoolean> ksl = new n<AtomicBoolean>() { // from class: com.google.gson.internal.a.m.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, AtomicBoolean atomicBoolean) throws IOException {
            aVar.sK(atomicBoolean.get());
        }
    }.cNi();
    public static final o ksm = a(AtomicBoolean.class, ksl);
    public static final n<AtomicIntegerArray> ksn = new n<AtomicIntegerArray>() { // from class: com.google.gson.internal.a.m.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, AtomicIntegerArray atomicIntegerArray) throws IOException {
            aVar.cNC();
            int length = atomicIntegerArray.length();
            for (int i = 0; i < length; i++) {
                aVar.eQ(atomicIntegerArray.get(i));
            }
            aVar.cND();
        }
    }.cNi();
    public static final o kso = a(AtomicIntegerArray.class, ksn);
    public static final n<Number> ksp = new n<Number>() { // from class: com.google.gson.internal.a.m.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final n<Number> ksq = new n<Number>() { // from class: com.google.gson.internal.a.m.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final n<Number> ksr = new n<Number>() { // from class: com.google.gson.internal.a.m.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final n<Number> kss = new n<Number>() { // from class: com.google.gson.internal.a.m.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final o kst = a(Number.class, kss);
    public static final n<Character> ksu = new n<Character>() { // from class: com.google.gson.internal.a.m.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Character ch) throws IOException {
            aVar.Iy(ch == null ? null : String.valueOf(ch));
        }
    };
    public static final o ksv = a(Character.TYPE, Character.class, ksu);
    public static final n<String> ksw = new n<String>() { // from class: com.google.gson.internal.a.m.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, String str) throws IOException {
            aVar.Iy(str);
        }
    };
    public static final n<BigDecimal> ksx = new n<BigDecimal>() { // from class: com.google.gson.internal.a.m.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, BigDecimal bigDecimal) throws IOException {
            aVar.a(bigDecimal);
        }
    };
    public static final n<BigInteger> ksy = new n<BigInteger>() { // from class: com.google.gson.internal.a.m.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, BigInteger bigInteger) throws IOException {
            aVar.a(bigInteger);
        }
    };
    public static final o ksz = a(String.class, ksw);
    public static final n<StringBuilder> ksA = new n<StringBuilder>() { // from class: com.google.gson.internal.a.m.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, StringBuilder sb) throws IOException {
            aVar.Iy(sb == null ? null : sb.toString());
        }
    };
    public static final o ksB = a(StringBuilder.class, ksA);
    public static final n<StringBuffer> ksC = new n<StringBuffer>() { // from class: com.google.gson.internal.a.m.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, StringBuffer stringBuffer) throws IOException {
            aVar.Iy(stringBuffer == null ? null : stringBuffer.toString());
        }
    };
    public static final o ksD = a(StringBuffer.class, ksC);
    public static final n<URL> ksE = new n<URL>() { // from class: com.google.gson.internal.a.m.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, URL url) throws IOException {
            aVar.Iy(url == null ? null : url.toExternalForm());
        }
    };
    public static final o ksF = a(URL.class, ksE);
    public static final n<URI> ksG = new n<URI>() { // from class: com.google.gson.internal.a.m.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, URI uri) throws IOException {
            aVar.Iy(uri == null ? null : uri.toASCIIString());
        }
    };
    public static final o ksH = a(URI.class, ksG);
    public static final n<InetAddress> ksI = new n<InetAddress>() { // from class: com.google.gson.internal.a.m.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, InetAddress inetAddress) throws IOException {
            aVar.Iy(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    };
    public static final o ksJ = b(InetAddress.class, ksI);
    public static final n<UUID> ksK = new n<UUID>() { // from class: com.google.gson.internal.a.m.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, UUID uuid) throws IOException {
            aVar.Iy(uuid == null ? null : uuid.toString());
        }
    };
    public static final o ksL = a(UUID.class, ksK);
    public static final n<Currency> ksM = new n<Currency>() { // from class: com.google.gson.internal.a.m.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Currency currency) throws IOException {
            aVar.Iy(currency.getCurrencyCode());
        }
    }.cNi();
    public static final o ksN = a(Currency.class, ksM);
    public static final o ksO = new o() { // from class: com.google.gson.internal.a.m.19
        @Override // com.google.gson.o
        public <T> n<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
            if (aVar.cNH() != Timestamp.class) {
                return null;
            }
            final n<T> x = dVar.x(Date.class);
            return (n<T>) new n<Timestamp>() { // from class: com.google.gson.internal.a.m.19.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.gson.n
                public void a(com.google.gson.stream.a aVar2, Timestamp timestamp) throws IOException {
                    x.a(aVar2, timestamp);
                }
            };
        }
    };
    public static final n<Calendar> ksP = new n<Calendar>() { // from class: com.google.gson.internal.a.m.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Calendar calendar) throws IOException {
            if (calendar == null) {
                aVar.cNG();
                return;
            }
            aVar.cNE();
            aVar.Ix("year");
            aVar.eQ(calendar.get(1));
            aVar.Ix("month");
            aVar.eQ(calendar.get(2));
            aVar.Ix("dayOfMonth");
            aVar.eQ(calendar.get(5));
            aVar.Ix("hourOfDay");
            aVar.eQ(calendar.get(11));
            aVar.Ix("minute");
            aVar.eQ(calendar.get(12));
            aVar.Ix("second");
            aVar.eQ(calendar.get(13));
            aVar.cNF();
        }
    };
    public static final o ksQ = b(Calendar.class, GregorianCalendar.class, ksP);
    public static final n<Locale> ksR = new n<Locale>() { // from class: com.google.gson.internal.a.m.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Locale locale) throws IOException {
            aVar.Iy(locale == null ? null : locale.toString());
        }
    };
    public static final o ksS = a(Locale.class, ksR);
    public static final n<com.google.gson.h> ksT = new n<com.google.gson.h>() { // from class: com.google.gson.internal.a.m.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, com.google.gson.h hVar) throws IOException {
            if (hVar == null || hVar.cNa()) {
                aVar.cNG();
            } else if (hVar.cMZ()) {
                com.google.gson.k cNd = hVar.cNd();
                if (cNd.cNg()) {
                    aVar.a(cNd.cMU());
                } else if (cNd.cNf()) {
                    aVar.sK(cNd.cMW());
                } else {
                    aVar.Iy(cNd.cMV());
                }
            } else if (hVar.cMX()) {
                aVar.cNC();
                Iterator<com.google.gson.h> it = hVar.cNc().iterator();
                while (it.hasNext()) {
                    a(aVar, it.next());
                }
                aVar.cND();
            } else if (hVar.cMY()) {
                aVar.cNE();
                for (Map.Entry<String, com.google.gson.h> entry : hVar.cNb().entrySet()) {
                    aVar.Ix(entry.getKey());
                    a(aVar, entry.getValue());
                }
                aVar.cNF();
            } else {
                throw new IllegalArgumentException("Couldn't write " + hVar.getClass());
            }
        }
    };
    public static final o ksU = b(com.google.gson.h.class, ksT);
    public static final o ksV = new o() { // from class: com.google.gson.internal.a.m.24
        @Override // com.google.gson.o
        public <T> n<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
            Class cNH = aVar.cNH();
            if (!Enum.class.isAssignableFrom(cNH) || cNH == Enum.class) {
                return null;
            }
            if (!cNH.isEnum()) {
                cNH = (Class<? super Object>) cNH.getSuperclass();
            }
            return new a(cNH);
        }
    };

    /* loaded from: classes2.dex */
    private static final class a<T extends Enum<T>> extends n<T> {
        private final Map<String, T> ktg = new HashMap();
        private final Map<T, String> kth = new HashMap();

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
                        String[] cNm = cVar.cNm();
                        for (String str : cNm) {
                            this.ktg.put(str, t);
                        }
                    }
                    String str2 = name;
                    this.ktg.put(str2, t);
                    this.kth.put(t, str2);
                }
            } catch (NoSuchFieldException e) {
                throw new AssertionError(e);
            }
        }

        public void a(com.google.gson.stream.a aVar, T t) throws IOException {
            aVar.Iy(t == null ? null : this.kth.get(t));
        }
    }

    public static <TT> o a(final Class<TT> cls, final n<TT> nVar) {
        return new o() { // from class: com.google.gson.internal.a.m.25
            @Override // com.google.gson.o
            public <T> n<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
                if (aVar.cNH() == cls) {
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
                Class<? super T> cNH = aVar.cNH();
                if (cNH == cls || cNH == cls2) {
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
                Class<? super T> cNH = aVar.cNH();
                if (cNH == cls || cNH == cls2) {
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
                final Class<? super T2> cNH = aVar.cNH();
                if (cls.isAssignableFrom(cNH)) {
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
