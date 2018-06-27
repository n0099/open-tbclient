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
    public static final m<Class> hOj = new m<Class>() { // from class: com.google.gson.internal.a.k.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, Class cls) throws IOException {
            if (cls == null) {
                aVar.bOF();
                return;
            }
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }
    };
    public static final n hOk = a(Class.class, hOj);
    public static final m<BitSet> hOl = new m<BitSet>() { // from class: com.google.gson.internal.a.k.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, BitSet bitSet) throws IOException {
            if (bitSet == null) {
                aVar.bOF();
                return;
            }
            aVar.bOB();
            for (int i = 0; i < bitSet.length(); i++) {
                aVar.dC(bitSet.get(i) ? 1 : 0);
            }
            aVar.bOC();
        }
    };
    public static final n hOm = a(BitSet.class, hOl);
    public static final m<Boolean> hOn = new m<Boolean>() { // from class: com.google.gson.internal.a.k.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, Boolean bool) throws IOException {
            if (bool == null) {
                aVar.bOF();
            } else {
                aVar.ol(bool.booleanValue());
            }
        }
    };
    public static final m<Boolean> hOo = new m<Boolean>() { // from class: com.google.gson.internal.a.k.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, Boolean bool) throws IOException {
            aVar.xy(bool == null ? "null" : bool.toString());
        }
    };
    public static final n hOp = a(Boolean.TYPE, Boolean.class, hOn);
    public static final m<Number> hOq = new m<Number>() { // from class: com.google.gson.internal.a.k.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final n hOr = a(Byte.TYPE, Byte.class, hOq);
    public static final m<Number> hOs = new m<Number>() { // from class: com.google.gson.internal.a.k.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final n hOt = a(Short.TYPE, Short.class, hOs);
    public static final m<Number> hOu = new m<Number>() { // from class: com.google.gson.internal.a.k.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final n hOv = a(Integer.TYPE, Integer.class, hOu);
    public static final m<Number> hOw = new m<Number>() { // from class: com.google.gson.internal.a.k.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final m<Number> hOx = new m<Number>() { // from class: com.google.gson.internal.a.k.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final m<Number> hOy = new m<Number>() { // from class: com.google.gson.internal.a.k.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final m<Number> hOz = new m<Number>() { // from class: com.google.gson.internal.a.k.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, Number number) throws IOException {
            aVar.a(number);
        }
    };
    public static final n hOA = a(Number.class, hOz);
    public static final m<Character> hOB = new m<Character>() { // from class: com.google.gson.internal.a.k.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, Character ch) throws IOException {
            aVar.xy(ch == null ? null : String.valueOf(ch));
        }
    };
    public static final n hOC = a(Character.TYPE, Character.class, hOB);
    public static final m<String> hOD = new m<String>() { // from class: com.google.gson.internal.a.k.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, String str) throws IOException {
            aVar.xy(str);
        }
    };
    public static final m<BigDecimal> hOE = new m<BigDecimal>() { // from class: com.google.gson.internal.a.k.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, BigDecimal bigDecimal) throws IOException {
            aVar.a(bigDecimal);
        }
    };
    public static final m<BigInteger> hOF = new m<BigInteger>() { // from class: com.google.gson.internal.a.k.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, BigInteger bigInteger) throws IOException {
            aVar.a(bigInteger);
        }
    };
    public static final n hOG = a(String.class, hOD);
    public static final m<StringBuilder> hOH = new m<StringBuilder>() { // from class: com.google.gson.internal.a.k.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, StringBuilder sb) throws IOException {
            aVar.xy(sb == null ? null : sb.toString());
        }
    };
    public static final n hOI = a(StringBuilder.class, hOH);
    public static final m<StringBuffer> hOJ = new m<StringBuffer>() { // from class: com.google.gson.internal.a.k.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, StringBuffer stringBuffer) throws IOException {
            aVar.xy(stringBuffer == null ? null : stringBuffer.toString());
        }
    };
    public static final n hOK = a(StringBuffer.class, hOJ);
    public static final m<URL> hOL = new m<URL>() { // from class: com.google.gson.internal.a.k.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, URL url) throws IOException {
            aVar.xy(url == null ? null : url.toExternalForm());
        }
    };
    public static final n hOM = a(URL.class, hOL);
    public static final m<URI> hON = new m<URI>() { // from class: com.google.gson.internal.a.k.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, URI uri) throws IOException {
            aVar.xy(uri == null ? null : uri.toASCIIString());
        }
    };
    public static final n hOO = a(URI.class, hON);
    public static final m<InetAddress> hOP = new m<InetAddress>() { // from class: com.google.gson.internal.a.k.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, InetAddress inetAddress) throws IOException {
            aVar.xy(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    };
    public static final n hOQ = b(InetAddress.class, hOP);
    public static final m<UUID> hOR = new m<UUID>() { // from class: com.google.gson.internal.a.k.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, UUID uuid) throws IOException {
            aVar.xy(uuid == null ? null : uuid.toString());
        }
    };
    public static final n hOS = a(UUID.class, hOR);
    public static final n hOT = new n() { // from class: com.google.gson.internal.a.k.15
        @Override // com.google.gson.n
        public <T> m<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
            if (aVar.bOH() != Timestamp.class) {
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
    public static final m<Calendar> hOU = new m<Calendar>() { // from class: com.google.gson.internal.a.k.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, Calendar calendar) throws IOException {
            if (calendar == null) {
                aVar.bOF();
                return;
            }
            aVar.bOD();
            aVar.xx("year");
            aVar.dC(calendar.get(1));
            aVar.xx("month");
            aVar.dC(calendar.get(2));
            aVar.xx("dayOfMonth");
            aVar.dC(calendar.get(5));
            aVar.xx("hourOfDay");
            aVar.dC(calendar.get(11));
            aVar.xx("minute");
            aVar.dC(calendar.get(12));
            aVar.xx("second");
            aVar.dC(calendar.get(13));
            aVar.bOE();
        }
    };
    public static final n hOV = b(Calendar.class, GregorianCalendar.class, hOU);
    public static final m<Locale> hOW = new m<Locale>() { // from class: com.google.gson.internal.a.k.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, Locale locale) throws IOException {
            aVar.xy(locale == null ? null : locale.toString());
        }
    };
    public static final n hOX = a(Locale.class, hOW);
    public static final m<com.google.gson.h> hOY = new m<com.google.gson.h>() { // from class: com.google.gson.internal.a.k.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, com.google.gson.h hVar) throws IOException {
            if (hVar == null || hVar.bOh()) {
                aVar.bOF();
            } else if (hVar.bOg()) {
                com.google.gson.k bOk = hVar.bOk();
                if (bOk.bOn()) {
                    aVar.a(bOk.bOc());
                } else if (bOk.bOm()) {
                    aVar.ol(bOk.getAsBoolean());
                } else {
                    aVar.xy(bOk.bOd());
                }
            } else if (hVar.bOe()) {
                aVar.bOB();
                Iterator<com.google.gson.h> it = hVar.bOj().iterator();
                while (it.hasNext()) {
                    a(aVar, it.next());
                }
                aVar.bOC();
            } else if (hVar.bOf()) {
                aVar.bOD();
                for (Map.Entry<String, com.google.gson.h> entry : hVar.bOi().entrySet()) {
                    aVar.xx(entry.getKey());
                    a(aVar, entry.getValue());
                }
                aVar.bOE();
            } else {
                throw new IllegalArgumentException("Couldn't write " + hVar.getClass());
            }
        }
    };
    public static final n hOZ = b(com.google.gson.h.class, hOY);
    public static final n hPa = bOG();

    /* loaded from: classes2.dex */
    private static final class a<T extends Enum<T>> extends m<T> {
        private final Map<String, T> hPk = new HashMap();
        private final Map<T, String> hPl = new HashMap();

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
                    this.hPk.put(value, t);
                    this.hPl.put(t, value);
                }
            } catch (NoSuchFieldException e) {
                throw new AssertionError();
            }
        }

        public void a(com.google.gson.stream.a aVar, T t) throws IOException {
            aVar.xy(t == null ? null : this.hPl.get(t));
        }
    }

    public static n bOG() {
        return new n() { // from class: com.google.gson.internal.a.k.19
            @Override // com.google.gson.n
            public <T> m<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
                Class bOH = aVar.bOH();
                if (!Enum.class.isAssignableFrom(bOH) || bOH == Enum.class) {
                    return null;
                }
                if (!bOH.isEnum()) {
                    bOH = (Class<? super Object>) bOH.getSuperclass();
                }
                return new a(bOH);
            }
        };
    }

    public static <TT> n a(final Class<TT> cls, final m<TT> mVar) {
        return new n() { // from class: com.google.gson.internal.a.k.20
            @Override // com.google.gson.n
            public <T> m<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
                if (aVar.bOH() == cls) {
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
                Class<? super T> bOH = aVar.bOH();
                if (bOH == cls || bOH == cls2) {
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
                Class<? super T> bOH = aVar.bOH();
                if (bOH == cls || bOH == cls2) {
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
                if (cls.isAssignableFrom(aVar.bOH())) {
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
