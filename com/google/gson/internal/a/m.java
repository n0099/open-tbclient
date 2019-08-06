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
    public static final n<Class> kpz = new n<Class>() { // from class: com.google.gson.internal.a.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Class cls) throws IOException {
            if (cls == null) {
                aVar.cMS();
                return;
            }
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }
    };
    public static final o kpA = a(Class.class, kpz);
    public static final n<BitSet> kpB = new n<BitSet>() { // from class: com.google.gson.internal.a.m.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, BitSet bitSet) throws IOException {
            if (bitSet == null) {
                aVar.cMS();
                return;
            }
            aVar.cMO();
            for (int i = 0; i < bitSet.length(); i++) {
                aVar.eN(bitSet.get(i) ? 1 : 0);
            }
            aVar.cMP();
        }
    };
    public static final o kpC = a(BitSet.class, kpB);
    public static final n<Boolean> kpD = new n<Boolean>() { // from class: com.google.gson.internal.a.m.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Boolean bool) throws IOException {
            aVar.m(bool);
        }
    };
    public static final n<Boolean> kpE = new n<Boolean>() { // from class: com.google.gson.internal.a.m.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Boolean bool) throws IOException {
            aVar.HY(bool == null ? "null" : bool.toString());
        }
    };
    public static final o kpF = a(Boolean.TYPE, Boolean.class, kpD);
    public static final n<Number> kpG = new n<Number>() { // from class: com.google.gson.internal.a.m.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final o kpH = a(Byte.TYPE, Byte.class, kpG);
    public static final n<Number> kpI = new n<Number>() { // from class: com.google.gson.internal.a.m.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final o kpJ = a(Short.TYPE, Short.class, kpI);
    public static final n<Number> kpK = new n<Number>() { // from class: com.google.gson.internal.a.m.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final o kpL = a(Integer.TYPE, Integer.class, kpK);
    public static final n<AtomicInteger> kpM = new n<AtomicInteger>() { // from class: com.google.gson.internal.a.m.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, AtomicInteger atomicInteger) throws IOException {
            aVar.eN(atomicInteger.get());
        }
    }.cMu();
    public static final o kpN = a(AtomicInteger.class, kpM);
    public static final n<AtomicBoolean> kpO = new n<AtomicBoolean>() { // from class: com.google.gson.internal.a.m.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, AtomicBoolean atomicBoolean) throws IOException {
            aVar.sH(atomicBoolean.get());
        }
    }.cMu();
    public static final o kpP = a(AtomicBoolean.class, kpO);
    public static final n<AtomicIntegerArray> kpQ = new n<AtomicIntegerArray>() { // from class: com.google.gson.internal.a.m.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, AtomicIntegerArray atomicIntegerArray) throws IOException {
            aVar.cMO();
            int length = atomicIntegerArray.length();
            for (int i = 0; i < length; i++) {
                aVar.eN(atomicIntegerArray.get(i));
            }
            aVar.cMP();
        }
    }.cMu();
    public static final o kpR = a(AtomicIntegerArray.class, kpQ);
    public static final n<Number> kpS = new n<Number>() { // from class: com.google.gson.internal.a.m.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final n<Number> kpT = new n<Number>() { // from class: com.google.gson.internal.a.m.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final n<Number> kpU = new n<Number>() { // from class: com.google.gson.internal.a.m.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final n<Number> kpV = new n<Number>() { // from class: com.google.gson.internal.a.m.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final o kpW = a(Number.class, kpV);
    public static final n<Character> kpX = new n<Character>() { // from class: com.google.gson.internal.a.m.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Character ch) throws IOException {
            aVar.HY(ch == null ? null : String.valueOf(ch));
        }
    };
    public static final o kpY = a(Character.TYPE, Character.class, kpX);
    public static final n<String> kpZ = new n<String>() { // from class: com.google.gson.internal.a.m.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, String str) throws IOException {
            aVar.HY(str);
        }
    };
    public static final n<BigDecimal> kqa = new n<BigDecimal>() { // from class: com.google.gson.internal.a.m.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, BigDecimal bigDecimal) throws IOException {
            aVar.a(bigDecimal);
        }
    };
    public static final n<BigInteger> kqb = new n<BigInteger>() { // from class: com.google.gson.internal.a.m.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, BigInteger bigInteger) throws IOException {
            aVar.a(bigInteger);
        }
    };
    public static final o kqc = a(String.class, kpZ);
    public static final n<StringBuilder> kqd = new n<StringBuilder>() { // from class: com.google.gson.internal.a.m.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, StringBuilder sb) throws IOException {
            aVar.HY(sb == null ? null : sb.toString());
        }
    };
    public static final o kqe = a(StringBuilder.class, kqd);
    public static final n<StringBuffer> kqf = new n<StringBuffer>() { // from class: com.google.gson.internal.a.m.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, StringBuffer stringBuffer) throws IOException {
            aVar.HY(stringBuffer == null ? null : stringBuffer.toString());
        }
    };
    public static final o kqg = a(StringBuffer.class, kqf);
    public static final n<URL> kqh = new n<URL>() { // from class: com.google.gson.internal.a.m.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, URL url) throws IOException {
            aVar.HY(url == null ? null : url.toExternalForm());
        }
    };
    public static final o kqi = a(URL.class, kqh);
    public static final n<URI> kqj = new n<URI>() { // from class: com.google.gson.internal.a.m.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, URI uri) throws IOException {
            aVar.HY(uri == null ? null : uri.toASCIIString());
        }
    };
    public static final o kqk = a(URI.class, kqj);
    public static final n<InetAddress> kql = new n<InetAddress>() { // from class: com.google.gson.internal.a.m.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, InetAddress inetAddress) throws IOException {
            aVar.HY(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    };
    public static final o kqm = b(InetAddress.class, kql);
    public static final n<UUID> kqn = new n<UUID>() { // from class: com.google.gson.internal.a.m.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, UUID uuid) throws IOException {
            aVar.HY(uuid == null ? null : uuid.toString());
        }
    };
    public static final o kqo = a(UUID.class, kqn);
    public static final n<Currency> kqp = new n<Currency>() { // from class: com.google.gson.internal.a.m.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Currency currency) throws IOException {
            aVar.HY(currency.getCurrencyCode());
        }
    }.cMu();
    public static final o kqq = a(Currency.class, kqp);
    public static final o kqr = new o() { // from class: com.google.gson.internal.a.m.19
        @Override // com.google.gson.o
        public <T> n<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
            if (aVar.cMT() != Timestamp.class) {
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
    public static final n<Calendar> kqs = new n<Calendar>() { // from class: com.google.gson.internal.a.m.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Calendar calendar) throws IOException {
            if (calendar == null) {
                aVar.cMS();
                return;
            }
            aVar.cMQ();
            aVar.HX("year");
            aVar.eN(calendar.get(1));
            aVar.HX("month");
            aVar.eN(calendar.get(2));
            aVar.HX("dayOfMonth");
            aVar.eN(calendar.get(5));
            aVar.HX("hourOfDay");
            aVar.eN(calendar.get(11));
            aVar.HX("minute");
            aVar.eN(calendar.get(12));
            aVar.HX("second");
            aVar.eN(calendar.get(13));
            aVar.cMR();
        }
    };
    public static final o kqt = b(Calendar.class, GregorianCalendar.class, kqs);
    public static final n<Locale> kqu = new n<Locale>() { // from class: com.google.gson.internal.a.m.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Locale locale) throws IOException {
            aVar.HY(locale == null ? null : locale.toString());
        }
    };
    public static final o kqv = a(Locale.class, kqu);
    public static final n<com.google.gson.h> kqw = new n<com.google.gson.h>() { // from class: com.google.gson.internal.a.m.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, com.google.gson.h hVar) throws IOException {
            if (hVar == null || hVar.cMm()) {
                aVar.cMS();
            } else if (hVar.cMl()) {
                com.google.gson.k cMp = hVar.cMp();
                if (cMp.cMs()) {
                    aVar.a(cMp.cMg());
                } else if (cMp.cMr()) {
                    aVar.sH(cMp.cMi());
                } else {
                    aVar.HY(cMp.cMh());
                }
            } else if (hVar.cMj()) {
                aVar.cMO();
                Iterator<com.google.gson.h> it = hVar.cMo().iterator();
                while (it.hasNext()) {
                    a(aVar, it.next());
                }
                aVar.cMP();
            } else if (hVar.cMk()) {
                aVar.cMQ();
                for (Map.Entry<String, com.google.gson.h> entry : hVar.cMn().entrySet()) {
                    aVar.HX(entry.getKey());
                    a(aVar, entry.getValue());
                }
                aVar.cMR();
            } else {
                throw new IllegalArgumentException("Couldn't write " + hVar.getClass());
            }
        }
    };
    public static final o kqx = b(com.google.gson.h.class, kqw);
    public static final o kqy = new o() { // from class: com.google.gson.internal.a.m.24
        @Override // com.google.gson.o
        public <T> n<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
            Class cMT = aVar.cMT();
            if (!Enum.class.isAssignableFrom(cMT) || cMT == Enum.class) {
                return null;
            }
            if (!cMT.isEnum()) {
                cMT = (Class<? super Object>) cMT.getSuperclass();
            }
            return new a(cMT);
        }
    };

    /* loaded from: classes2.dex */
    private static final class a<T extends Enum<T>> extends n<T> {
        private final Map<String, T> kqJ = new HashMap();
        private final Map<T, String> kqK = new HashMap();

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
                        String[] cMy = cVar.cMy();
                        for (String str : cMy) {
                            this.kqJ.put(str, t);
                        }
                    }
                    String str2 = name;
                    this.kqJ.put(str2, t);
                    this.kqK.put(t, str2);
                }
            } catch (NoSuchFieldException e) {
                throw new AssertionError(e);
            }
        }

        public void a(com.google.gson.stream.a aVar, T t) throws IOException {
            aVar.HY(t == null ? null : this.kqK.get(t));
        }
    }

    public static <TT> o a(final Class<TT> cls, final n<TT> nVar) {
        return new o() { // from class: com.google.gson.internal.a.m.25
            @Override // com.google.gson.o
            public <T> n<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
                if (aVar.cMT() == cls) {
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
                Class<? super T> cMT = aVar.cMT();
                if (cMT == cls || cMT == cls2) {
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
                Class<? super T> cMT = aVar.cMT();
                if (cMT == cls || cMT == cls2) {
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
                final Class<? super T2> cMT = aVar.cMT();
                if (cls.isAssignableFrom(cMT)) {
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
