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
    public static final n<Class> kqi = new n<Class>() { // from class: com.google.gson.internal.a.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Class cls) throws IOException {
            if (cls == null) {
                aVar.cKD();
                return;
            }
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }
    };
    public static final o kqj = a(Class.class, kqi);
    public static final n<BitSet> kqk = new n<BitSet>() { // from class: com.google.gson.internal.a.m.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, BitSet bitSet) throws IOException {
            if (bitSet == null) {
                aVar.cKD();
                return;
            }
            aVar.cKz();
            for (int i = 0; i < bitSet.length(); i++) {
                aVar.ek(bitSet.get(i) ? 1 : 0);
            }
            aVar.cKA();
        }
    };
    public static final o kql = a(BitSet.class, kqk);
    public static final n<Boolean> kqm = new n<Boolean>() { // from class: com.google.gson.internal.a.m.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Boolean bool) throws IOException {
            aVar.l(bool);
        }
    };
    public static final n<Boolean> kqn = new n<Boolean>() { // from class: com.google.gson.internal.a.m.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Boolean bool) throws IOException {
            aVar.GP(bool == null ? "null" : bool.toString());
        }
    };
    public static final o kqo = a(Boolean.TYPE, Boolean.class, kqm);
    public static final n<Number> kqp = new n<Number>() { // from class: com.google.gson.internal.a.m.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final o kqq = a(Byte.TYPE, Byte.class, kqp);
    public static final n<Number> kqr = new n<Number>() { // from class: com.google.gson.internal.a.m.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final o kqs = a(Short.TYPE, Short.class, kqr);
    public static final n<Number> kqt = new n<Number>() { // from class: com.google.gson.internal.a.m.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final o kqu = a(Integer.TYPE, Integer.class, kqt);
    public static final n<AtomicInteger> kqv = new n<AtomicInteger>() { // from class: com.google.gson.internal.a.m.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, AtomicInteger atomicInteger) throws IOException {
            aVar.ek(atomicInteger.get());
        }
    }.cKf();
    public static final o kqw = a(AtomicInteger.class, kqv);
    public static final n<AtomicBoolean> kqx = new n<AtomicBoolean>() { // from class: com.google.gson.internal.a.m.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, AtomicBoolean atomicBoolean) throws IOException {
            aVar.sp(atomicBoolean.get());
        }
    }.cKf();
    public static final o kqy = a(AtomicBoolean.class, kqx);
    public static final n<AtomicIntegerArray> kqz = new n<AtomicIntegerArray>() { // from class: com.google.gson.internal.a.m.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, AtomicIntegerArray atomicIntegerArray) throws IOException {
            aVar.cKz();
            int length = atomicIntegerArray.length();
            for (int i = 0; i < length; i++) {
                aVar.ek(atomicIntegerArray.get(i));
            }
            aVar.cKA();
        }
    }.cKf();
    public static final o kqA = a(AtomicIntegerArray.class, kqz);
    public static final n<Number> kqB = new n<Number>() { // from class: com.google.gson.internal.a.m.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final n<Number> kqC = new n<Number>() { // from class: com.google.gson.internal.a.m.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final n<Number> kqD = new n<Number>() { // from class: com.google.gson.internal.a.m.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final n<Number> kqE = new n<Number>() { // from class: com.google.gson.internal.a.m.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final o kqF = a(Number.class, kqE);
    public static final n<Character> kqG = new n<Character>() { // from class: com.google.gson.internal.a.m.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Character ch) throws IOException {
            aVar.GP(ch == null ? null : String.valueOf(ch));
        }
    };
    public static final o kqH = a(Character.TYPE, Character.class, kqG);
    public static final n<String> kqI = new n<String>() { // from class: com.google.gson.internal.a.m.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, String str) throws IOException {
            aVar.GP(str);
        }
    };
    public static final n<BigDecimal> kqJ = new n<BigDecimal>() { // from class: com.google.gson.internal.a.m.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, BigDecimal bigDecimal) throws IOException {
            aVar.a(bigDecimal);
        }
    };
    public static final n<BigInteger> kqK = new n<BigInteger>() { // from class: com.google.gson.internal.a.m.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, BigInteger bigInteger) throws IOException {
            aVar.a(bigInteger);
        }
    };
    public static final o kqL = a(String.class, kqI);
    public static final n<StringBuilder> kqM = new n<StringBuilder>() { // from class: com.google.gson.internal.a.m.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, StringBuilder sb) throws IOException {
            aVar.GP(sb == null ? null : sb.toString());
        }
    };
    public static final o kqN = a(StringBuilder.class, kqM);
    public static final n<StringBuffer> kqO = new n<StringBuffer>() { // from class: com.google.gson.internal.a.m.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, StringBuffer stringBuffer) throws IOException {
            aVar.GP(stringBuffer == null ? null : stringBuffer.toString());
        }
    };
    public static final o kqP = a(StringBuffer.class, kqO);
    public static final n<URL> kqQ = new n<URL>() { // from class: com.google.gson.internal.a.m.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, URL url) throws IOException {
            aVar.GP(url == null ? null : url.toExternalForm());
        }
    };
    public static final o kqR = a(URL.class, kqQ);
    public static final n<URI> kqS = new n<URI>() { // from class: com.google.gson.internal.a.m.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, URI uri) throws IOException {
            aVar.GP(uri == null ? null : uri.toASCIIString());
        }
    };
    public static final o kqT = a(URI.class, kqS);
    public static final n<InetAddress> kqU = new n<InetAddress>() { // from class: com.google.gson.internal.a.m.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, InetAddress inetAddress) throws IOException {
            aVar.GP(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    };
    public static final o kqV = b(InetAddress.class, kqU);
    public static final n<UUID> kqW = new n<UUID>() { // from class: com.google.gson.internal.a.m.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, UUID uuid) throws IOException {
            aVar.GP(uuid == null ? null : uuid.toString());
        }
    };
    public static final o kqX = a(UUID.class, kqW);
    public static final n<Currency> kqY = new n<Currency>() { // from class: com.google.gson.internal.a.m.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Currency currency) throws IOException {
            aVar.GP(currency.getCurrencyCode());
        }
    }.cKf();
    public static final o kqZ = a(Currency.class, kqY);
    public static final o kra = new o() { // from class: com.google.gson.internal.a.m.19
        @Override // com.google.gson.o
        public <T> n<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
            if (aVar.cKE() != Timestamp.class) {
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
    public static final n<Calendar> krb = new n<Calendar>() { // from class: com.google.gson.internal.a.m.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Calendar calendar) throws IOException {
            if (calendar == null) {
                aVar.cKD();
                return;
            }
            aVar.cKB();
            aVar.GO("year");
            aVar.ek(calendar.get(1));
            aVar.GO("month");
            aVar.ek(calendar.get(2));
            aVar.GO("dayOfMonth");
            aVar.ek(calendar.get(5));
            aVar.GO("hourOfDay");
            aVar.ek(calendar.get(11));
            aVar.GO("minute");
            aVar.ek(calendar.get(12));
            aVar.GO("second");
            aVar.ek(calendar.get(13));
            aVar.cKC();
        }
    };
    public static final o krc = b(Calendar.class, GregorianCalendar.class, krb);
    public static final n<Locale> krd = new n<Locale>() { // from class: com.google.gson.internal.a.m.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Locale locale) throws IOException {
            aVar.GP(locale == null ? null : locale.toString());
        }
    };
    public static final o kre = a(Locale.class, krd);
    public static final n<com.google.gson.h> krf = new n<com.google.gson.h>() { // from class: com.google.gson.internal.a.m.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, com.google.gson.h hVar) throws IOException {
            if (hVar == null || hVar.cJX()) {
                aVar.cKD();
            } else if (hVar.cJW()) {
                com.google.gson.k cKa = hVar.cKa();
                if (cKa.cKd()) {
                    aVar.a(cKa.cJR());
                } else if (cKa.cKc()) {
                    aVar.sp(cKa.cJT());
                } else {
                    aVar.GP(cKa.cJS());
                }
            } else if (hVar.cJU()) {
                aVar.cKz();
                Iterator<com.google.gson.h> it = hVar.cJZ().iterator();
                while (it.hasNext()) {
                    a(aVar, it.next());
                }
                aVar.cKA();
            } else if (hVar.cJV()) {
                aVar.cKB();
                for (Map.Entry<String, com.google.gson.h> entry : hVar.cJY().entrySet()) {
                    aVar.GO(entry.getKey());
                    a(aVar, entry.getValue());
                }
                aVar.cKC();
            } else {
                throw new IllegalArgumentException("Couldn't write " + hVar.getClass());
            }
        }
    };
    public static final o krg = b(com.google.gson.h.class, krf);
    public static final o krh = new o() { // from class: com.google.gson.internal.a.m.24
        @Override // com.google.gson.o
        public <T> n<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
            Class cKE = aVar.cKE();
            if (!Enum.class.isAssignableFrom(cKE) || cKE == Enum.class) {
                return null;
            }
            if (!cKE.isEnum()) {
                cKE = (Class<? super Object>) cKE.getSuperclass();
            }
            return new a(cKE);
        }
    };

    /* loaded from: classes2.dex */
    private static final class a<T extends Enum<T>> extends n<T> {
        private final Map<String, T> krs = new HashMap();
        private final Map<T, String> krt = new HashMap();

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
                        String[] cKj = cVar.cKj();
                        for (String str : cKj) {
                            this.krs.put(str, t);
                        }
                    }
                    String str2 = name;
                    this.krs.put(str2, t);
                    this.krt.put(t, str2);
                }
            } catch (NoSuchFieldException e) {
                throw new AssertionError(e);
            }
        }

        public void a(com.google.gson.stream.a aVar, T t) throws IOException {
            aVar.GP(t == null ? null : this.krt.get(t));
        }
    }

    public static <TT> o a(final Class<TT> cls, final n<TT> nVar) {
        return new o() { // from class: com.google.gson.internal.a.m.25
            @Override // com.google.gson.o
            public <T> n<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
                if (aVar.cKE() == cls) {
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
                Class<? super T> cKE = aVar.cKE();
                if (cKE == cls || cKE == cls2) {
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
                Class<? super T> cKE = aVar.cKE();
                if (cKE == cls || cKE == cls2) {
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
                final Class<? super T2> cKE = aVar.cKE();
                if (cls.isAssignableFrom(cKE)) {
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
