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
    public static final n<Class> khk = new n<Class>() { // from class: com.google.gson.internal.a.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Class cls) throws IOException {
            if (cls == null) {
                aVar.cJs();
                return;
            }
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }
    };
    public static final o khl = a(Class.class, khk);
    public static final n<BitSet> khm = new n<BitSet>() { // from class: com.google.gson.internal.a.m.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, BitSet bitSet) throws IOException {
            if (bitSet == null) {
                aVar.cJs();
                return;
            }
            aVar.cJo();
            for (int i = 0; i < bitSet.length(); i++) {
                aVar.eF(bitSet.get(i) ? 1 : 0);
            }
            aVar.cJp();
        }
    };
    public static final o khn = a(BitSet.class, khm);
    public static final n<Boolean> kho = new n<Boolean>() { // from class: com.google.gson.internal.a.m.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Boolean bool) throws IOException {
            aVar.m(bool);
        }
    };
    public static final n<Boolean> khp = new n<Boolean>() { // from class: com.google.gson.internal.a.m.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Boolean bool) throws IOException {
            aVar.Hb(bool == null ? "null" : bool.toString());
        }
    };
    public static final o khq = a(Boolean.TYPE, Boolean.class, kho);
    public static final n<Number> khr = new n<Number>() { // from class: com.google.gson.internal.a.m.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final o khs = a(Byte.TYPE, Byte.class, khr);
    public static final n<Number> kht = new n<Number>() { // from class: com.google.gson.internal.a.m.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final o khu = a(Short.TYPE, Short.class, kht);
    public static final n<Number> khv = new n<Number>() { // from class: com.google.gson.internal.a.m.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final o khw = a(Integer.TYPE, Integer.class, khv);
    public static final n<AtomicInteger> khx = new n<AtomicInteger>() { // from class: com.google.gson.internal.a.m.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, AtomicInteger atomicInteger) throws IOException {
            aVar.eF(atomicInteger.get());
        }
    }.cIU();
    public static final o khy = a(AtomicInteger.class, khx);
    public static final n<AtomicBoolean> khz = new n<AtomicBoolean>() { // from class: com.google.gson.internal.a.m.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, AtomicBoolean atomicBoolean) throws IOException {
            aVar.sq(atomicBoolean.get());
        }
    }.cIU();
    public static final o khA = a(AtomicBoolean.class, khz);
    public static final n<AtomicIntegerArray> khB = new n<AtomicIntegerArray>() { // from class: com.google.gson.internal.a.m.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, AtomicIntegerArray atomicIntegerArray) throws IOException {
            aVar.cJo();
            int length = atomicIntegerArray.length();
            for (int i = 0; i < length; i++) {
                aVar.eF(atomicIntegerArray.get(i));
            }
            aVar.cJp();
        }
    }.cIU();
    public static final o khC = a(AtomicIntegerArray.class, khB);
    public static final n<Number> khD = new n<Number>() { // from class: com.google.gson.internal.a.m.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final n<Number> khE = new n<Number>() { // from class: com.google.gson.internal.a.m.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final n<Number> khF = new n<Number>() { // from class: com.google.gson.internal.a.m.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final n<Number> khG = new n<Number>() { // from class: com.google.gson.internal.a.m.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final o khH = a(Number.class, khG);
    public static final n<Character> khI = new n<Character>() { // from class: com.google.gson.internal.a.m.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Character ch) throws IOException {
            aVar.Hb(ch == null ? null : String.valueOf(ch));
        }
    };
    public static final o khJ = a(Character.TYPE, Character.class, khI);
    public static final n<String> khK = new n<String>() { // from class: com.google.gson.internal.a.m.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, String str) throws IOException {
            aVar.Hb(str);
        }
    };
    public static final n<BigDecimal> khL = new n<BigDecimal>() { // from class: com.google.gson.internal.a.m.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, BigDecimal bigDecimal) throws IOException {
            aVar.a(bigDecimal);
        }
    };
    public static final n<BigInteger> khM = new n<BigInteger>() { // from class: com.google.gson.internal.a.m.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, BigInteger bigInteger) throws IOException {
            aVar.a(bigInteger);
        }
    };
    public static final o khN = a(String.class, khK);
    public static final n<StringBuilder> khO = new n<StringBuilder>() { // from class: com.google.gson.internal.a.m.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, StringBuilder sb) throws IOException {
            aVar.Hb(sb == null ? null : sb.toString());
        }
    };
    public static final o khP = a(StringBuilder.class, khO);
    public static final n<StringBuffer> khQ = new n<StringBuffer>() { // from class: com.google.gson.internal.a.m.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, StringBuffer stringBuffer) throws IOException {
            aVar.Hb(stringBuffer == null ? null : stringBuffer.toString());
        }
    };
    public static final o khR = a(StringBuffer.class, khQ);
    public static final n<URL> khS = new n<URL>() { // from class: com.google.gson.internal.a.m.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, URL url) throws IOException {
            aVar.Hb(url == null ? null : url.toExternalForm());
        }
    };
    public static final o khT = a(URL.class, khS);
    public static final n<URI> khU = new n<URI>() { // from class: com.google.gson.internal.a.m.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, URI uri) throws IOException {
            aVar.Hb(uri == null ? null : uri.toASCIIString());
        }
    };
    public static final o khV = a(URI.class, khU);
    public static final n<InetAddress> khW = new n<InetAddress>() { // from class: com.google.gson.internal.a.m.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, InetAddress inetAddress) throws IOException {
            aVar.Hb(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    };
    public static final o khX = b(InetAddress.class, khW);
    public static final n<UUID> khY = new n<UUID>() { // from class: com.google.gson.internal.a.m.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, UUID uuid) throws IOException {
            aVar.Hb(uuid == null ? null : uuid.toString());
        }
    };
    public static final o khZ = a(UUID.class, khY);
    public static final n<Currency> kia = new n<Currency>() { // from class: com.google.gson.internal.a.m.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Currency currency) throws IOException {
            aVar.Hb(currency.getCurrencyCode());
        }
    }.cIU();
    public static final o kib = a(Currency.class, kia);
    public static final o kic = new o() { // from class: com.google.gson.internal.a.m.19
        @Override // com.google.gson.o
        public <T> n<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
            if (aVar.cJt() != Timestamp.class) {
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
    public static final n<Calendar> kie = new n<Calendar>() { // from class: com.google.gson.internal.a.m.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Calendar calendar) throws IOException {
            if (calendar == null) {
                aVar.cJs();
                return;
            }
            aVar.cJq();
            aVar.Ha("year");
            aVar.eF(calendar.get(1));
            aVar.Ha("month");
            aVar.eF(calendar.get(2));
            aVar.Ha("dayOfMonth");
            aVar.eF(calendar.get(5));
            aVar.Ha("hourOfDay");
            aVar.eF(calendar.get(11));
            aVar.Ha("minute");
            aVar.eF(calendar.get(12));
            aVar.Ha("second");
            aVar.eF(calendar.get(13));
            aVar.cJr();
        }
    };
    public static final o kif = b(Calendar.class, GregorianCalendar.class, kie);
    public static final n<Locale> kig = new n<Locale>() { // from class: com.google.gson.internal.a.m.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, Locale locale) throws IOException {
            aVar.Hb(locale == null ? null : locale.toString());
        }
    };
    public static final o kih = a(Locale.class, kig);
    public static final n<com.google.gson.h> kii = new n<com.google.gson.h>() { // from class: com.google.gson.internal.a.m.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, com.google.gson.h hVar) throws IOException {
            if (hVar == null || hVar.cIM()) {
                aVar.cJs();
            } else if (hVar.cIL()) {
                com.google.gson.k cIP = hVar.cIP();
                if (cIP.cIS()) {
                    aVar.a(cIP.cIH());
                } else if (cIP.cIR()) {
                    aVar.sq(cIP.getAsBoolean());
                } else {
                    aVar.Hb(cIP.cII());
                }
            } else if (hVar.cIJ()) {
                aVar.cJo();
                Iterator<com.google.gson.h> it = hVar.cIO().iterator();
                while (it.hasNext()) {
                    a(aVar, it.next());
                }
                aVar.cJp();
            } else if (hVar.cIK()) {
                aVar.cJq();
                for (Map.Entry<String, com.google.gson.h> entry : hVar.cIN().entrySet()) {
                    aVar.Ha(entry.getKey());
                    a(aVar, entry.getValue());
                }
                aVar.cJr();
            } else {
                throw new IllegalArgumentException("Couldn't write " + hVar.getClass());
            }
        }
    };
    public static final o kij = b(com.google.gson.h.class, kii);
    public static final o kik = new o() { // from class: com.google.gson.internal.a.m.24
        @Override // com.google.gson.o
        public <T> n<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
            Class cJt = aVar.cJt();
            if (!Enum.class.isAssignableFrom(cJt) || cJt == Enum.class) {
                return null;
            }
            if (!cJt.isEnum()) {
                cJt = (Class<? super Object>) cJt.getSuperclass();
            }
            return new a(cJt);
        }
    };

    /* loaded from: classes2.dex */
    private static final class a<T extends Enum<T>> extends n<T> {
        private final Map<String, T> kiv = new HashMap();
        private final Map<T, String> kiw = new HashMap();

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
                        String[] cIY = cVar.cIY();
                        for (String str : cIY) {
                            this.kiv.put(str, t);
                        }
                    }
                    String str2 = name;
                    this.kiv.put(str2, t);
                    this.kiw.put(t, str2);
                }
            } catch (NoSuchFieldException e) {
                throw new AssertionError(e);
            }
        }

        public void a(com.google.gson.stream.a aVar, T t) throws IOException {
            aVar.Hb(t == null ? null : this.kiw.get(t));
        }
    }

    public static <TT> o a(final Class<TT> cls, final n<TT> nVar) {
        return new o() { // from class: com.google.gson.internal.a.m.25
            @Override // com.google.gson.o
            public <T> n<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
                if (aVar.cJt() == cls) {
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
                Class<? super T> cJt = aVar.cJt();
                if (cJt == cls || cJt == cls2) {
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
                Class<? super T> cJt = aVar.cJt();
                if (cJt == cls || cJt == cls2) {
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
                final Class<? super T2> cJt = aVar.cJt();
                if (cls.isAssignableFrom(cJt)) {
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
