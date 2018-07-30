package com.google.gson.internal.a;

import com.google.gson.m;
import com.google.gson.n;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.sql.Timestamp;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
/* loaded from: classes2.dex */
public final class k {
    public static final m<Class> hHh = new m<Class>() { // from class: com.google.gson.internal.a.k.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, Class cls) throws IOException {
            if (cls == null) {
                aVar.bKy();
                return;
            }
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }
    };
    public static final n hHi = a(Class.class, hHh);
    public static final m<BitSet> hHj = new m<BitSet>() { // from class: com.google.gson.internal.a.k.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, BitSet bitSet) throws IOException {
            if (bitSet == null) {
                aVar.bKy();
                return;
            }
            aVar.bKu();
            for (int i = 0; i < bitSet.length(); i++) {
                aVar.dh(bitSet.get(i) ? 1 : 0);
            }
            aVar.bKv();
        }
    };
    public static final n hHk = a(BitSet.class, hHj);
    public static final m<Boolean> hHl = new m<Boolean>() { // from class: com.google.gson.internal.a.k.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, Boolean bool) throws IOException {
            if (bool == null) {
                aVar.bKy();
            } else {
                aVar.nL(bool.booleanValue());
            }
        }
    };
    public static final m<Boolean> hHm = new m<Boolean>() { // from class: com.google.gson.internal.a.k.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, Boolean bool) throws IOException {
            aVar.wE(bool == null ? "null" : bool.toString());
        }
    };
    public static final n hHn = a(Boolean.TYPE, Boolean.class, hHl);
    public static final m<Number> hHo = new m<Number>() { // from class: com.google.gson.internal.a.k.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final n hHp = a(Byte.TYPE, Byte.class, hHo);
    public static final m<Number> hHq = new m<Number>() { // from class: com.google.gson.internal.a.k.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final n hHr = a(Short.TYPE, Short.class, hHq);
    public static final m<Number> hHs = new m<Number>() { // from class: com.google.gson.internal.a.k.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final n hHt = a(Integer.TYPE, Integer.class, hHs);
    public static final m<Number> hHu = new m<Number>() { // from class: com.google.gson.internal.a.k.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final m<Number> hHv = new m<Number>() { // from class: com.google.gson.internal.a.k.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final m<Number> hHw = new m<Number>() { // from class: com.google.gson.internal.a.k.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final m<Number> hHx = new m<Number>() { // from class: com.google.gson.internal.a.k.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final n hHy = a(Number.class, hHx);
    public static final m<Character> hHz = new m<Character>() { // from class: com.google.gson.internal.a.k.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, Character ch) throws IOException {
            aVar.wE(ch == null ? null : String.valueOf(ch));
        }
    };
    public static final n hHA = a(Character.TYPE, Character.class, hHz);
    public static final m<String> hHB = new m<String>() { // from class: com.google.gson.internal.a.k.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, String str) throws IOException {
            aVar.wE(str);
        }
    };
    public static final m<BigDecimal> hHC = new m<BigDecimal>() { // from class: com.google.gson.internal.a.k.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, BigDecimal bigDecimal) throws IOException {
            aVar.a(bigDecimal);
        }
    };
    public static final m<BigInteger> hHD = new m<BigInteger>() { // from class: com.google.gson.internal.a.k.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, BigInteger bigInteger) throws IOException {
            aVar.a(bigInteger);
        }
    };
    public static final n hHE = a(String.class, hHB);
    public static final m<StringBuilder> hHF = new m<StringBuilder>() { // from class: com.google.gson.internal.a.k.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, StringBuilder sb) throws IOException {
            aVar.wE(sb == null ? null : sb.toString());
        }
    };
    public static final n hHG = a(StringBuilder.class, hHF);
    public static final m<StringBuffer> hHH = new m<StringBuffer>() { // from class: com.google.gson.internal.a.k.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, StringBuffer stringBuffer) throws IOException {
            aVar.wE(stringBuffer == null ? null : stringBuffer.toString());
        }
    };
    public static final n hHI = a(StringBuffer.class, hHH);
    public static final m<URL> hHJ = new m<URL>() { // from class: com.google.gson.internal.a.k.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, URL url) throws IOException {
            aVar.wE(url == null ? null : url.toExternalForm());
        }
    };
    public static final n hHK = a(URL.class, hHJ);
    public static final m<URI> hHL = new m<URI>() { // from class: com.google.gson.internal.a.k.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, URI uri) throws IOException {
            aVar.wE(uri == null ? null : uri.toASCIIString());
        }
    };
    public static final n hHM = a(URI.class, hHL);
    public static final m<InetAddress> hHN = new m<InetAddress>() { // from class: com.google.gson.internal.a.k.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, InetAddress inetAddress) throws IOException {
            aVar.wE(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    };
    public static final n hHO = b(InetAddress.class, hHN);
    public static final m<UUID> hHP = new m<UUID>() { // from class: com.google.gson.internal.a.k.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, UUID uuid) throws IOException {
            aVar.wE(uuid == null ? null : uuid.toString());
        }
    };
    public static final n hHQ = a(UUID.class, hHP);
    public static final n hHR = new n() { // from class: com.google.gson.internal.a.k.15
        @Override // com.google.gson.n
        public <T> m<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
            if (aVar.bKA() != Timestamp.class) {
                return null;
            }
            final m<T> o = dVar.o(Date.class);
            return (m<T>) new m<Timestamp>() { // from class: com.google.gson.internal.a.k.15.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.gson.m
                public void a(com.google.gson.stream.a aVar2, Timestamp timestamp) throws IOException {
                    o.a(aVar2, timestamp);
                }
            };
        }
    };
    public static final m<Calendar> hHS = new m<Calendar>() { // from class: com.google.gson.internal.a.k.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, Calendar calendar) throws IOException {
            if (calendar == null) {
                aVar.bKy();
                return;
            }
            aVar.bKw();
            aVar.wD("year");
            aVar.dh(calendar.get(1));
            aVar.wD("month");
            aVar.dh(calendar.get(2));
            aVar.wD("dayOfMonth");
            aVar.dh(calendar.get(5));
            aVar.wD("hourOfDay");
            aVar.dh(calendar.get(11));
            aVar.wD("minute");
            aVar.dh(calendar.get(12));
            aVar.wD("second");
            aVar.dh(calendar.get(13));
            aVar.bKx();
        }
    };
    public static final n hHT = b(Calendar.class, GregorianCalendar.class, hHS);
    public static final m<Locale> hHU = new m<Locale>() { // from class: com.google.gson.internal.a.k.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, Locale locale) throws IOException {
            aVar.wE(locale == null ? null : locale.toString());
        }
    };
    public static final n hHV = a(Locale.class, hHU);
    public static final m<com.google.gson.h> hHW = new m<com.google.gson.h>() { // from class: com.google.gson.internal.a.k.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, com.google.gson.h hVar) throws IOException {
            if (hVar == null || hVar.bKa()) {
                aVar.bKy();
            } else if (hVar.bJZ()) {
                com.google.gson.k bKd = hVar.bKd();
                if (bKd.bKg()) {
                    aVar.a(bKd.bJV());
                } else if (bKd.bKf()) {
                    aVar.nL(bKd.getAsBoolean());
                } else {
                    aVar.wE(bKd.bJW());
                }
            } else if (hVar.bJX()) {
                aVar.bKu();
                Iterator<com.google.gson.h> it = hVar.bKc().iterator();
                while (it.hasNext()) {
                    a(aVar, it.next());
                }
                aVar.bKv();
            } else if (hVar.bJY()) {
                aVar.bKw();
                for (Map.Entry<String, com.google.gson.h> entry : hVar.bKb().entrySet()) {
                    aVar.wD(entry.getKey());
                    a(aVar, entry.getValue());
                }
                aVar.bKx();
            } else {
                throw new IllegalArgumentException("Couldn't write " + hVar.getClass());
            }
        }
    };
    public static final n hHX = b(com.google.gson.h.class, hHW);
    public static final n hHY = bKz();

    /* loaded from: classes2.dex */
    private static final class a<T extends Enum<T>> extends m<T> {
        private final Map<String, T> hIi = new HashMap();
        private final Map<T, String> hIj = new HashMap();

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.gson.internal.a.k$a<T extends java.lang.Enum<T>> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.gson.m
        public /* bridge */ /* synthetic */ void a(com.google.gson.stream.a aVar, Object obj) throws IOException {
            a(aVar, (com.google.gson.stream.a) ((Enum) obj));
        }

        public a(Class<T> cls) {
            T[] enumConstants;
            try {
                for (T t : cls.getEnumConstants()) {
                    String name = t.name();
                    com.google.gson.a.b bVar = (com.google.gson.a.b) cls.getField(name).getAnnotation(com.google.gson.a.b.class);
                    String value = bVar != null ? bVar.value() : name;
                    this.hIi.put(value, t);
                    this.hIj.put(t, value);
                }
            } catch (NoSuchFieldException e) {
                throw new AssertionError();
            }
        }

        public void a(com.google.gson.stream.a aVar, T t) throws IOException {
            aVar.wE(t == null ? null : this.hIj.get(t));
        }
    }

    public static n bKz() {
        return new n() { // from class: com.google.gson.internal.a.k.19
            @Override // com.google.gson.n
            public <T> m<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
                Class bKA = aVar.bKA();
                if (!Enum.class.isAssignableFrom(bKA) || bKA == Enum.class) {
                    return null;
                }
                if (!bKA.isEnum()) {
                    bKA = (Class<? super Object>) bKA.getSuperclass();
                }
                return new a(bKA);
            }
        };
    }

    public static <TT> n a(final Class<TT> cls, final m<TT> mVar) {
        return new n() { // from class: com.google.gson.internal.a.k.20
            @Override // com.google.gson.n
            public <T> m<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
                if (aVar.bKA() == cls) {
                    return mVar;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + ",adapter=" + mVar + "]";
            }
        };
    }

    public static <TT> n a(final Class<TT> cls, final Class<TT> cls2, final m<? super TT> mVar) {
        return new n() { // from class: com.google.gson.internal.a.k.21
            @Override // com.google.gson.n
            public <T> m<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
                Class<? super T> bKA = aVar.bKA();
                if (bKA == cls || bKA == cls2) {
                    return mVar;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls2.getName() + "+" + cls.getName() + ",adapter=" + mVar + "]";
            }
        };
    }

    public static <TT> n b(final Class<TT> cls, final Class<? extends TT> cls2, final m<? super TT> mVar) {
        return new n() { // from class: com.google.gson.internal.a.k.23
            @Override // com.google.gson.n
            public <T> m<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
                Class<? super T> bKA = aVar.bKA();
                if (bKA == cls || bKA == cls2) {
                    return mVar;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + "+" + cls2.getName() + ",adapter=" + mVar + "]";
            }
        };
    }

    public static <TT> n b(final Class<TT> cls, final m<TT> mVar) {
        return new n() { // from class: com.google.gson.internal.a.k.24
            @Override // com.google.gson.n
            public <T> m<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
                if (cls.isAssignableFrom(aVar.bKA())) {
                    return mVar;
                }
                return null;
            }

            public String toString() {
                return "Factory[typeHierarchy=" + cls.getName() + ",adapter=" + mVar + "]";
            }
        };
    }
}
