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
    public static final m<Class> hPi = new m<Class>() { // from class: com.google.gson.internal.a.k.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, Class cls) throws IOException {
            if (cls == null) {
                aVar.bNg();
                return;
            }
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }
    };
    public static final n hPj = a(Class.class, hPi);
    public static final m<BitSet> hPk = new m<BitSet>() { // from class: com.google.gson.internal.a.k.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, BitSet bitSet) throws IOException {
            if (bitSet == null) {
                aVar.bNg();
                return;
            }
            aVar.bNc();
            for (int i = 0; i < bitSet.length(); i++) {
                aVar.di(bitSet.get(i) ? 1 : 0);
            }
            aVar.bNd();
        }
    };
    public static final n hPl = a(BitSet.class, hPk);
    public static final m<Boolean> hPm = new m<Boolean>() { // from class: com.google.gson.internal.a.k.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, Boolean bool) throws IOException {
            if (bool == null) {
                aVar.bNg();
            } else {
                aVar.oi(bool.booleanValue());
            }
        }
    };
    public static final m<Boolean> hPn = new m<Boolean>() { // from class: com.google.gson.internal.a.k.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, Boolean bool) throws IOException {
            aVar.xq(bool == null ? "null" : bool.toString());
        }
    };
    public static final n hPo = a(Boolean.TYPE, Boolean.class, hPm);
    public static final m<Number> hPp = new m<Number>() { // from class: com.google.gson.internal.a.k.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.b(number);
        }
    };
    public static final n hPq = a(Byte.TYPE, Byte.class, hPp);
    public static final m<Number> hPr = new m<Number>() { // from class: com.google.gson.internal.a.k.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.b(number);
        }
    };
    public static final n hPs = a(Short.TYPE, Short.class, hPr);
    public static final m<Number> hPt = new m<Number>() { // from class: com.google.gson.internal.a.k.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.b(number);
        }
    };
    public static final n hPu = a(Integer.TYPE, Integer.class, hPt);
    public static final m<Number> hPv = new m<Number>() { // from class: com.google.gson.internal.a.k.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.b(number);
        }
    };
    public static final m<Number> hPw = new m<Number>() { // from class: com.google.gson.internal.a.k.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.b(number);
        }
    };
    public static final m<Number> hPx = new m<Number>() { // from class: com.google.gson.internal.a.k.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.b(number);
        }
    };
    public static final m<Number> hPy = new m<Number>() { // from class: com.google.gson.internal.a.k.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.b(number);
        }
    };
    public static final n hPz = a(Number.class, hPy);
    public static final m<Character> hPA = new m<Character>() { // from class: com.google.gson.internal.a.k.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, Character ch) throws IOException {
            aVar.xq(ch == null ? null : String.valueOf(ch));
        }
    };
    public static final n hPB = a(Character.TYPE, Character.class, hPA);
    public static final m<String> hPC = new m<String>() { // from class: com.google.gson.internal.a.k.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, String str) throws IOException {
            aVar.xq(str);
        }
    };
    public static final m<BigDecimal> hPD = new m<BigDecimal>() { // from class: com.google.gson.internal.a.k.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, BigDecimal bigDecimal) throws IOException {
            aVar.b(bigDecimal);
        }
    };
    public static final m<BigInteger> hPE = new m<BigInteger>() { // from class: com.google.gson.internal.a.k.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, BigInteger bigInteger) throws IOException {
            aVar.b(bigInteger);
        }
    };
    public static final n hPF = a(String.class, hPC);
    public static final m<StringBuilder> hPG = new m<StringBuilder>() { // from class: com.google.gson.internal.a.k.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, StringBuilder sb) throws IOException {
            aVar.xq(sb == null ? null : sb.toString());
        }
    };
    public static final n hPH = a(StringBuilder.class, hPG);
    public static final m<StringBuffer> hPI = new m<StringBuffer>() { // from class: com.google.gson.internal.a.k.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, StringBuffer stringBuffer) throws IOException {
            aVar.xq(stringBuffer == null ? null : stringBuffer.toString());
        }
    };
    public static final n hPJ = a(StringBuffer.class, hPI);
    public static final m<URL> hPK = new m<URL>() { // from class: com.google.gson.internal.a.k.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, URL url) throws IOException {
            aVar.xq(url == null ? null : url.toExternalForm());
        }
    };
    public static final n hPL = a(URL.class, hPK);
    public static final m<URI> hPM = new m<URI>() { // from class: com.google.gson.internal.a.k.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, URI uri) throws IOException {
            aVar.xq(uri == null ? null : uri.toASCIIString());
        }
    };
    public static final n hPN = a(URI.class, hPM);
    public static final m<InetAddress> hPO = new m<InetAddress>() { // from class: com.google.gson.internal.a.k.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, InetAddress inetAddress) throws IOException {
            aVar.xq(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    };
    public static final n hPP = b(InetAddress.class, hPO);
    public static final m<UUID> hPQ = new m<UUID>() { // from class: com.google.gson.internal.a.k.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, UUID uuid) throws IOException {
            aVar.xq(uuid == null ? null : uuid.toString());
        }
    };
    public static final n hPR = a(UUID.class, hPQ);
    public static final n hPS = new n() { // from class: com.google.gson.internal.a.k.15
        @Override // com.google.gson.n
        public <T> m<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
            if (aVar.bNi() != Timestamp.class) {
                return null;
            }
            final m<T> r = dVar.r(Date.class);
            return (m<T>) new m<Timestamp>() { // from class: com.google.gson.internal.a.k.15.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.gson.m
                public void a(com.google.gson.stream.a aVar2, Timestamp timestamp) throws IOException {
                    r.a(aVar2, timestamp);
                }
            };
        }
    };
    public static final m<Calendar> hPT = new m<Calendar>() { // from class: com.google.gson.internal.a.k.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, Calendar calendar) throws IOException {
            if (calendar == null) {
                aVar.bNg();
                return;
            }
            aVar.bNe();
            aVar.xp("year");
            aVar.di(calendar.get(1));
            aVar.xp("month");
            aVar.di(calendar.get(2));
            aVar.xp("dayOfMonth");
            aVar.di(calendar.get(5));
            aVar.xp("hourOfDay");
            aVar.di(calendar.get(11));
            aVar.xp("minute");
            aVar.di(calendar.get(12));
            aVar.xp("second");
            aVar.di(calendar.get(13));
            aVar.bNf();
        }
    };
    public static final n hPU = b(Calendar.class, GregorianCalendar.class, hPT);
    public static final m<Locale> hPV = new m<Locale>() { // from class: com.google.gson.internal.a.k.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, Locale locale) throws IOException {
            aVar.xq(locale == null ? null : locale.toString());
        }
    };
    public static final n hPW = a(Locale.class, hPV);
    public static final m<com.google.gson.h> hPX = new m<com.google.gson.h>() { // from class: com.google.gson.internal.a.k.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, com.google.gson.h hVar) throws IOException {
            if (hVar == null || hVar.bMI()) {
                aVar.bNg();
            } else if (hVar.bMH()) {
                com.google.gson.k bML = hVar.bML();
                if (bML.bMO()) {
                    aVar.b(bML.bMD());
                } else if (bML.bMN()) {
                    aVar.oi(bML.getAsBoolean());
                } else {
                    aVar.xq(bML.bME());
                }
            } else if (hVar.bMF()) {
                aVar.bNc();
                Iterator<com.google.gson.h> it = hVar.bMK().iterator();
                while (it.hasNext()) {
                    a(aVar, it.next());
                }
                aVar.bNd();
            } else if (hVar.bMG()) {
                aVar.bNe();
                for (Map.Entry<String, com.google.gson.h> entry : hVar.bMJ().entrySet()) {
                    aVar.xp(entry.getKey());
                    a(aVar, entry.getValue());
                }
                aVar.bNf();
            } else {
                throw new IllegalArgumentException("Couldn't write " + hVar.getClass());
            }
        }
    };
    public static final n hPY = b(com.google.gson.h.class, hPX);
    public static final n hPZ = bNh();

    /* loaded from: classes2.dex */
    private static final class a<T extends Enum<T>> extends m<T> {
        private final Map<String, T> hQj = new HashMap();
        private final Map<T, String> hQk = new HashMap();

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
                    this.hQj.put(value, t);
                    this.hQk.put(t, value);
                }
            } catch (NoSuchFieldException e) {
                throw new AssertionError();
            }
        }

        public void a(com.google.gson.stream.a aVar, T t) throws IOException {
            aVar.xq(t == null ? null : this.hQk.get(t));
        }
    }

    public static n bNh() {
        return new n() { // from class: com.google.gson.internal.a.k.19
            @Override // com.google.gson.n
            public <T> m<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
                Class bNi = aVar.bNi();
                if (!Enum.class.isAssignableFrom(bNi) || bNi == Enum.class) {
                    return null;
                }
                if (!bNi.isEnum()) {
                    bNi = (Class<? super Object>) bNi.getSuperclass();
                }
                return new a(bNi);
            }
        };
    }

    public static <TT> n a(final Class<TT> cls, final m<TT> mVar) {
        return new n() { // from class: com.google.gson.internal.a.k.20
            @Override // com.google.gson.n
            public <T> m<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
                if (aVar.bNi() == cls) {
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
                Class<? super T> bNi = aVar.bNi();
                if (bNi == cls || bNi == cls2) {
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
                Class<? super T> bNi = aVar.bNi();
                if (bNi == cls || bNi == cls2) {
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
                if (cls.isAssignableFrom(aVar.bNi())) {
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
