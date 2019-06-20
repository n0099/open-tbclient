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
    public static final n<Class> khn = new n<Class>() { // from class: com.google.gson.internal.a.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Class cls) throws IOException {
            if (cls == null) {
                aVar.cJr();
                return;
            }
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }
    };
    public static final o kho = a(Class.class, khn);
    public static final n<BitSet> khp = new n<BitSet>() { // from class: com.google.gson.internal.a.m.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, BitSet bitSet) throws IOException {
            if (bitSet == null) {
                aVar.cJr();
                return;
            }
            aVar.cJn();
            for (int i = 0; i < bitSet.length(); i++) {
                aVar.eF(bitSet.get(i) ? 1 : 0);
            }
            aVar.cJo();
        }
    };
    public static final o khq = a(BitSet.class, khp);
    public static final n<Boolean> khr = new n<Boolean>() { // from class: com.google.gson.internal.a.m.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Boolean bool) throws IOException {
            aVar.m(bool);
        }
    };
    public static final n<Boolean> khs = new n<Boolean>() { // from class: com.google.gson.internal.a.m.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Boolean bool) throws IOException {
            aVar.Hd(bool == null ? "null" : bool.toString());
        }
    };
    public static final o kht = a(Boolean.TYPE, Boolean.class, khr);
    public static final n<Number> khu = new n<Number>() { // from class: com.google.gson.internal.a.m.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final o khv = a(Byte.TYPE, Byte.class, khu);
    public static final n<Number> khw = new n<Number>() { // from class: com.google.gson.internal.a.m.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final o khx = a(Short.TYPE, Short.class, khw);
    public static final n<Number> khy = new n<Number>() { // from class: com.google.gson.internal.a.m.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final o khz = a(Integer.TYPE, Integer.class, khy);
    public static final n<AtomicInteger> khA = new n<AtomicInteger>() { // from class: com.google.gson.internal.a.m.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, AtomicInteger atomicInteger) throws IOException {
            aVar.eF(atomicInteger.get());
        }
    }.cIT();
    public static final o khB = a(AtomicInteger.class, khA);
    public static final n<AtomicBoolean> khC = new n<AtomicBoolean>() { // from class: com.google.gson.internal.a.m.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, AtomicBoolean atomicBoolean) throws IOException {
            aVar.sr(atomicBoolean.get());
        }
    }.cIT();
    public static final o khD = a(AtomicBoolean.class, khC);
    public static final n<AtomicIntegerArray> khE = new n<AtomicIntegerArray>() { // from class: com.google.gson.internal.a.m.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, AtomicIntegerArray atomicIntegerArray) throws IOException {
            aVar.cJn();
            int length = atomicIntegerArray.length();
            for (int i = 0; i < length; i++) {
                aVar.eF(atomicIntegerArray.get(i));
            }
            aVar.cJo();
        }
    }.cIT();
    public static final o khF = a(AtomicIntegerArray.class, khE);
    public static final n<Number> khG = new n<Number>() { // from class: com.google.gson.internal.a.m.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final n<Number> khH = new n<Number>() { // from class: com.google.gson.internal.a.m.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final n<Number> khI = new n<Number>() { // from class: com.google.gson.internal.a.m.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final n<Number> khJ = new n<Number>() { // from class: com.google.gson.internal.a.m.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final o khK = a(Number.class, khJ);
    public static final n<Character> khL = new n<Character>() { // from class: com.google.gson.internal.a.m.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Character ch) throws IOException {
            aVar.Hd(ch == null ? null : String.valueOf(ch));
        }
    };
    public static final o khM = a(Character.TYPE, Character.class, khL);
    public static final n<String> khN = new n<String>() { // from class: com.google.gson.internal.a.m.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, String str) throws IOException {
            aVar.Hd(str);
        }
    };
    public static final n<BigDecimal> khO = new n<BigDecimal>() { // from class: com.google.gson.internal.a.m.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, BigDecimal bigDecimal) throws IOException {
            aVar.a(bigDecimal);
        }
    };
    public static final n<BigInteger> khP = new n<BigInteger>() { // from class: com.google.gson.internal.a.m.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, BigInteger bigInteger) throws IOException {
            aVar.a(bigInteger);
        }
    };
    public static final o khQ = a(String.class, khN);
    public static final n<StringBuilder> khR = new n<StringBuilder>() { // from class: com.google.gson.internal.a.m.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, StringBuilder sb) throws IOException {
            aVar.Hd(sb == null ? null : sb.toString());
        }
    };
    public static final o khS = a(StringBuilder.class, khR);
    public static final n<StringBuffer> khT = new n<StringBuffer>() { // from class: com.google.gson.internal.a.m.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, StringBuffer stringBuffer) throws IOException {
            aVar.Hd(stringBuffer == null ? null : stringBuffer.toString());
        }
    };
    public static final o khU = a(StringBuffer.class, khT);
    public static final n<URL> khV = new n<URL>() { // from class: com.google.gson.internal.a.m.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, URL url) throws IOException {
            aVar.Hd(url == null ? null : url.toExternalForm());
        }
    };
    public static final o khW = a(URL.class, khV);
    public static final n<URI> khX = new n<URI>() { // from class: com.google.gson.internal.a.m.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, URI uri) throws IOException {
            aVar.Hd(uri == null ? null : uri.toASCIIString());
        }
    };
    public static final o khY = a(URI.class, khX);
    public static final n<InetAddress> khZ = new n<InetAddress>() { // from class: com.google.gson.internal.a.m.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, InetAddress inetAddress) throws IOException {
            aVar.Hd(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    };
    public static final o kia = b(InetAddress.class, khZ);
    public static final n<UUID> kib = new n<UUID>() { // from class: com.google.gson.internal.a.m.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, UUID uuid) throws IOException {
            aVar.Hd(uuid == null ? null : uuid.toString());
        }
    };
    public static final o kic = a(UUID.class, kib);
    public static final n<Currency> kie = new n<Currency>() { // from class: com.google.gson.internal.a.m.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Currency currency) throws IOException {
            aVar.Hd(currency.getCurrencyCode());
        }
    }.cIT();
    public static final o kif = a(Currency.class, kie);
    public static final o kig = new o() { // from class: com.google.gson.internal.a.m.19
        @Override // com.google.gson.o
        public <T> n<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
            if (aVar.cJs() != Timestamp.class) {
                return null;
            }
            final n<T> v = dVar.v(Date.class);
            return (n<T>) new n<Timestamp>() { // from class: com.google.gson.internal.a.m.19.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.gson.n
                public void a(com.google.gson.stream.a aVar2, Timestamp timestamp) throws IOException {
                    v.a(aVar2, timestamp);
                }
            };
        }
    };
    public static final n<Calendar> kih = new n<Calendar>() { // from class: com.google.gson.internal.a.m.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Calendar calendar) throws IOException {
            if (calendar == null) {
                aVar.cJr();
                return;
            }
            aVar.cJp();
            aVar.Hc("year");
            aVar.eF(calendar.get(1));
            aVar.Hc("month");
            aVar.eF(calendar.get(2));
            aVar.Hc("dayOfMonth");
            aVar.eF(calendar.get(5));
            aVar.Hc("hourOfDay");
            aVar.eF(calendar.get(11));
            aVar.Hc("minute");
            aVar.eF(calendar.get(12));
            aVar.Hc("second");
            aVar.eF(calendar.get(13));
            aVar.cJq();
        }
    };
    public static final o kii = b(Calendar.class, GregorianCalendar.class, kih);
    public static final n<Locale> kij = new n<Locale>() { // from class: com.google.gson.internal.a.m.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Locale locale) throws IOException {
            aVar.Hd(locale == null ? null : locale.toString());
        }
    };
    public static final o kik = a(Locale.class, kij);
    public static final n<com.google.gson.h> kil = new n<com.google.gson.h>() { // from class: com.google.gson.internal.a.m.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, com.google.gson.h hVar) throws IOException {
            if (hVar == null || hVar.cIL()) {
                aVar.cJr();
            } else if (hVar.cIK()) {
                com.google.gson.k cIO = hVar.cIO();
                if (cIO.cIR()) {
                    aVar.a(cIO.cIG());
                } else if (cIO.cIQ()) {
                    aVar.sr(cIO.getAsBoolean());
                } else {
                    aVar.Hd(cIO.cIH());
                }
            } else if (hVar.cII()) {
                aVar.cJn();
                Iterator<com.google.gson.h> it = hVar.cIN().iterator();
                while (it.hasNext()) {
                    a(aVar, it.next());
                }
                aVar.cJo();
            } else if (hVar.cIJ()) {
                aVar.cJp();
                for (Map.Entry<String, com.google.gson.h> entry : hVar.cIM().entrySet()) {
                    aVar.Hc(entry.getKey());
                    a(aVar, entry.getValue());
                }
                aVar.cJq();
            } else {
                throw new IllegalArgumentException("Couldn't write " + hVar.getClass());
            }
        }
    };
    public static final o kim = b(com.google.gson.h.class, kil);
    public static final o kin = new o() { // from class: com.google.gson.internal.a.m.24
        @Override // com.google.gson.o
        public <T> n<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
            Class cJs = aVar.cJs();
            if (!Enum.class.isAssignableFrom(cJs) || cJs == Enum.class) {
                return null;
            }
            if (!cJs.isEnum()) {
                cJs = (Class<? super Object>) cJs.getSuperclass();
            }
            return new a(cJs);
        }
    };

    /* loaded from: classes2.dex */
    private static final class a<T extends Enum<T>> extends n<T> {
        private final Map<String, T> kiy = new HashMap();
        private final Map<T, String> kiz = new HashMap();

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
                        String[] cIX = cVar.cIX();
                        for (String str : cIX) {
                            this.kiy.put(str, t);
                        }
                    }
                    String str2 = name;
                    this.kiy.put(str2, t);
                    this.kiz.put(t, str2);
                }
            } catch (NoSuchFieldException e) {
                throw new AssertionError(e);
            }
        }

        public void a(com.google.gson.stream.a aVar, T t) throws IOException {
            aVar.Hd(t == null ? null : this.kiz.get(t));
        }
    }

    public static <TT> o a(final Class<TT> cls, final n<TT> nVar) {
        return new o() { // from class: com.google.gson.internal.a.m.25
            @Override // com.google.gson.o
            public <T> n<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
                if (aVar.cJs() == cls) {
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
                Class<? super T> cJs = aVar.cJs();
                if (cJs == cls || cJs == cls2) {
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
                Class<? super T> cJs = aVar.cJs();
                if (cJs == cls || cJs == cls2) {
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
                final Class<? super T2> cJs = aVar.cJs();
                if (cls.isAssignableFrom(cJs)) {
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
