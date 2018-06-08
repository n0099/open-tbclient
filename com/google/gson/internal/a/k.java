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
    public static final m<Class> hKd = new m<Class>() { // from class: com.google.gson.internal.a.k.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, Class cls) throws IOException {
            if (cls == null) {
                aVar.bOd();
                return;
            }
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }
    };
    public static final n hKe = a(Class.class, hKd);
    public static final m<BitSet> hKf = new m<BitSet>() { // from class: com.google.gson.internal.a.k.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, BitSet bitSet) throws IOException {
            if (bitSet == null) {
                aVar.bOd();
                return;
            }
            aVar.bNZ();
            for (int i = 0; i < bitSet.length(); i++) {
                aVar.dE(bitSet.get(i) ? 1 : 0);
            }
            aVar.bOa();
        }
    };
    public static final n hKg = a(BitSet.class, hKf);
    public static final m<Boolean> hKh = new m<Boolean>() { // from class: com.google.gson.internal.a.k.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, Boolean bool) throws IOException {
            if (bool == null) {
                aVar.bOd();
            } else {
                aVar.oe(bool.booleanValue());
            }
        }
    };
    public static final m<Boolean> hKi = new m<Boolean>() { // from class: com.google.gson.internal.a.k.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, Boolean bool) throws IOException {
            aVar.xA(bool == null ? "null" : bool.toString());
        }
    };
    public static final n hKj = a(Boolean.TYPE, Boolean.class, hKh);
    public static final m<Number> hKk = new m<Number>() { // from class: com.google.gson.internal.a.k.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final n hKl = a(Byte.TYPE, Byte.class, hKk);
    public static final m<Number> hKm = new m<Number>() { // from class: com.google.gson.internal.a.k.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final n hKn = a(Short.TYPE, Short.class, hKm);
    public static final m<Number> hKo = new m<Number>() { // from class: com.google.gson.internal.a.k.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final n hKp = a(Integer.TYPE, Integer.class, hKo);
    public static final m<Number> hKq = new m<Number>() { // from class: com.google.gson.internal.a.k.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final m<Number> hKr = new m<Number>() { // from class: com.google.gson.internal.a.k.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final m<Number> hKs = new m<Number>() { // from class: com.google.gson.internal.a.k.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final m<Number> hKt = new m<Number>() { // from class: com.google.gson.internal.a.k.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final n hKu = a(Number.class, hKt);
    public static final m<Character> hKv = new m<Character>() { // from class: com.google.gson.internal.a.k.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, Character ch) throws IOException {
            aVar.xA(ch == null ? null : String.valueOf(ch));
        }
    };
    public static final n hKw = a(Character.TYPE, Character.class, hKv);
    public static final m<String> hKx = new m<String>() { // from class: com.google.gson.internal.a.k.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, String str) throws IOException {
            aVar.xA(str);
        }
    };
    public static final m<BigDecimal> hKy = new m<BigDecimal>() { // from class: com.google.gson.internal.a.k.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, BigDecimal bigDecimal) throws IOException {
            aVar.a(bigDecimal);
        }
    };
    public static final m<BigInteger> hKz = new m<BigInteger>() { // from class: com.google.gson.internal.a.k.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, BigInteger bigInteger) throws IOException {
            aVar.a(bigInteger);
        }
    };
    public static final n hKA = a(String.class, hKx);
    public static final m<StringBuilder> hKB = new m<StringBuilder>() { // from class: com.google.gson.internal.a.k.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, StringBuilder sb) throws IOException {
            aVar.xA(sb == null ? null : sb.toString());
        }
    };
    public static final n hKC = a(StringBuilder.class, hKB);
    public static final m<StringBuffer> hKD = new m<StringBuffer>() { // from class: com.google.gson.internal.a.k.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, StringBuffer stringBuffer) throws IOException {
            aVar.xA(stringBuffer == null ? null : stringBuffer.toString());
        }
    };
    public static final n hKE = a(StringBuffer.class, hKD);
    public static final m<URL> hKF = new m<URL>() { // from class: com.google.gson.internal.a.k.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, URL url) throws IOException {
            aVar.xA(url == null ? null : url.toExternalForm());
        }
    };
    public static final n hKG = a(URL.class, hKF);
    public static final m<URI> hKH = new m<URI>() { // from class: com.google.gson.internal.a.k.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, URI uri) throws IOException {
            aVar.xA(uri == null ? null : uri.toASCIIString());
        }
    };
    public static final n hKI = a(URI.class, hKH);
    public static final m<InetAddress> hKJ = new m<InetAddress>() { // from class: com.google.gson.internal.a.k.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, InetAddress inetAddress) throws IOException {
            aVar.xA(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    };
    public static final n hKK = b(InetAddress.class, hKJ);
    public static final m<UUID> hKL = new m<UUID>() { // from class: com.google.gson.internal.a.k.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, UUID uuid) throws IOException {
            aVar.xA(uuid == null ? null : uuid.toString());
        }
    };
    public static final n hKM = a(UUID.class, hKL);
    public static final n hKN = new n() { // from class: com.google.gson.internal.a.k.15
        @Override // com.google.gson.n
        public <T> m<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
            if (aVar.bOf() != Timestamp.class) {
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
    public static final m<Calendar> hKO = new m<Calendar>() { // from class: com.google.gson.internal.a.k.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, Calendar calendar) throws IOException {
            if (calendar == null) {
                aVar.bOd();
                return;
            }
            aVar.bOb();
            aVar.xz("year");
            aVar.dE(calendar.get(1));
            aVar.xz("month");
            aVar.dE(calendar.get(2));
            aVar.xz("dayOfMonth");
            aVar.dE(calendar.get(5));
            aVar.xz("hourOfDay");
            aVar.dE(calendar.get(11));
            aVar.xz("minute");
            aVar.dE(calendar.get(12));
            aVar.xz("second");
            aVar.dE(calendar.get(13));
            aVar.bOc();
        }
    };
    public static final n hKP = b(Calendar.class, GregorianCalendar.class, hKO);
    public static final m<Locale> hKQ = new m<Locale>() { // from class: com.google.gson.internal.a.k.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, Locale locale) throws IOException {
            aVar.xA(locale == null ? null : locale.toString());
        }
    };
    public static final n hKR = a(Locale.class, hKQ);
    public static final m<com.google.gson.h> hKS = new m<com.google.gson.h>() { // from class: com.google.gson.internal.a.k.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, com.google.gson.h hVar) throws IOException {
            if (hVar == null || hVar.bNF()) {
                aVar.bOd();
            } else if (hVar.bNE()) {
                com.google.gson.k bNI = hVar.bNI();
                if (bNI.bNL()) {
                    aVar.a(bNI.bNA());
                } else if (bNI.bNK()) {
                    aVar.oe(bNI.getAsBoolean());
                } else {
                    aVar.xA(bNI.bNB());
                }
            } else if (hVar.bNC()) {
                aVar.bNZ();
                Iterator<com.google.gson.h> it = hVar.bNH().iterator();
                while (it.hasNext()) {
                    a(aVar, it.next());
                }
                aVar.bOa();
            } else if (hVar.bND()) {
                aVar.bOb();
                for (Map.Entry<String, com.google.gson.h> entry : hVar.bNG().entrySet()) {
                    aVar.xz(entry.getKey());
                    a(aVar, entry.getValue());
                }
                aVar.bOc();
            } else {
                throw new IllegalArgumentException("Couldn't write " + hVar.getClass());
            }
        }
    };
    public static final n hKT = b(com.google.gson.h.class, hKS);
    public static final n hKU = bOe();

    /* loaded from: classes2.dex */
    private static final class a<T extends Enum<T>> extends m<T> {
        private final Map<String, T> hLe = new HashMap();
        private final Map<T, String> hLf = new HashMap();

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
                    this.hLe.put(value, t);
                    this.hLf.put(t, value);
                }
            } catch (NoSuchFieldException e) {
                throw new AssertionError();
            }
        }

        public void a(com.google.gson.stream.a aVar, T t) throws IOException {
            aVar.xA(t == null ? null : this.hLf.get(t));
        }
    }

    public static n bOe() {
        return new n() { // from class: com.google.gson.internal.a.k.19
            @Override // com.google.gson.n
            public <T> m<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
                Class bOf = aVar.bOf();
                if (!Enum.class.isAssignableFrom(bOf) || bOf == Enum.class) {
                    return null;
                }
                if (!bOf.isEnum()) {
                    bOf = (Class<? super Object>) bOf.getSuperclass();
                }
                return new a(bOf);
            }
        };
    }

    public static <TT> n a(final Class<TT> cls, final m<TT> mVar) {
        return new n() { // from class: com.google.gson.internal.a.k.20
            @Override // com.google.gson.n
            public <T> m<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
                if (aVar.bOf() == cls) {
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
                Class<? super T> bOf = aVar.bOf();
                if (bOf == cls || bOf == cls2) {
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
                Class<? super T> bOf = aVar.bOf();
                if (bOf == cls || bOf == cls2) {
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
                if (cls.isAssignableFrom(aVar.bOf())) {
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
