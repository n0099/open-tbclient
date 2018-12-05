package com.google.gson.internal.a;

import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import com.baidu.searchbox.ng.ai.apps.res.ui.BdDatePicker;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.o;
import com.google.gson.p;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
/* loaded from: classes2.dex */
public final class n {
    public static final o<Class> iva = new o<Class>() { // from class: com.google.gson.internal.a.n.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, Class cls) throws IOException {
            if (cls == null) {
                bVar.caS();
                return;
            }
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: n */
        public Class b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.caH() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }
    };
    public static final p ivb = a(Class.class, iva);
    public static final o<BitSet> ivc = new o<BitSet>() { // from class: com.google.gson.internal.a.n.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: u */
        public BitSet b(com.google.gson.stream.a aVar) throws IOException {
            boolean z;
            if (aVar.caH() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            BitSet bitSet = new BitSet();
            aVar.beginArray();
            JsonToken caH = aVar.caH();
            int i = 0;
            while (caH != JsonToken.END_ARRAY) {
                switch (AnonymousClass29.iuF[caH.ordinal()]) {
                    case 1:
                        if (aVar.nextInt() == 0) {
                            z = false;
                            break;
                        } else {
                            z = true;
                            break;
                        }
                    case 2:
                        z = aVar.nextBoolean();
                        break;
                    case 3:
                        String nextString = aVar.nextString();
                        try {
                            if (Integer.parseInt(nextString) == 0) {
                                z = false;
                                break;
                            } else {
                                z = true;
                                break;
                            }
                        } catch (NumberFormatException e) {
                            throw new JsonSyntaxException("Error: Expecting: bitset number value (1, 0), Found: " + nextString);
                        }
                    default:
                        throw new JsonSyntaxException("Invalid bitset value type: " + caH);
                }
                if (z) {
                    bitSet.set(i);
                }
                i++;
                caH = aVar.caH();
            }
            aVar.endArray();
            return bitSet;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, BitSet bitSet) throws IOException {
            if (bitSet == null) {
                bVar.caS();
                return;
            }
            bVar.caO();
            for (int i = 0; i < bitSet.length(); i++) {
                bVar.dx(bitSet.get(i) ? 1 : 0);
            }
            bVar.caP();
        }
    };
    public static final p ivd = a(BitSet.class, ivc);
    public static final o<Boolean> ive = new o<Boolean>() { // from class: com.google.gson.internal.a.n.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: F */
        public Boolean b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.caH() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            } else if (aVar.caH() == JsonToken.STRING) {
                return Boolean.valueOf(Boolean.parseBoolean(aVar.nextString()));
            } else {
                return Boolean.valueOf(aVar.nextBoolean());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, Boolean bool) throws IOException {
            bVar.k(bool);
        }
    };
    public static final o<Boolean> ivf = new o<Boolean>() { // from class: com.google.gson.internal.a.n.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: F */
        public Boolean b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.caH() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            return Boolean.valueOf(aVar.nextString());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, Boolean bool) throws IOException {
            bVar.zu(bool == null ? "null" : bool.toString());
        }
    };
    public static final p ivg = a(Boolean.TYPE, Boolean.class, ive);
    public static final o<Number> ivh = new o<Number>() { // from class: com.google.gson.internal.a.n.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: d */
        public Number b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.caH() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            try {
                return Byte.valueOf((byte) aVar.nextInt());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, Number number) throws IOException {
            bVar.b(number);
        }
    };
    public static final p ivi = a(Byte.TYPE, Byte.class, ivh);
    public static final o<Number> ivj = new o<Number>() { // from class: com.google.gson.internal.a.n.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: d */
        public Number b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.caH() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            try {
                return Short.valueOf((short) aVar.nextInt());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, Number number) throws IOException {
            bVar.b(number);
        }
    };
    public static final p ivk = a(Short.TYPE, Short.class, ivj);
    public static final o<Number> ivl = new o<Number>() { // from class: com.google.gson.internal.a.n.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: d */
        public Number b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.caH() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            try {
                return Integer.valueOf(aVar.nextInt());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, Number number) throws IOException {
            bVar.b(number);
        }
    };
    public static final p ivm = a(Integer.TYPE, Integer.class, ivl);
    public static final o<AtomicInteger> ivn = new o<AtomicInteger>() { // from class: com.google.gson.internal.a.n.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: G */
        public AtomicInteger b(com.google.gson.stream.a aVar) throws IOException {
            try {
                return new AtomicInteger(aVar.nextInt());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, AtomicInteger atomicInteger) throws IOException {
            bVar.dx(atomicInteger.get());
        }
    }.cap();
    public static final p ivo = a(AtomicInteger.class, ivn);
    public static final o<AtomicBoolean> ivp = new o<AtomicBoolean>() { // from class: com.google.gson.internal.a.n.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: H */
        public AtomicBoolean b(com.google.gson.stream.a aVar) throws IOException {
            return new AtomicBoolean(aVar.nextBoolean());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, AtomicBoolean atomicBoolean) throws IOException {
            bVar.pd(atomicBoolean.get());
        }
    }.cap();
    public static final p ivq = a(AtomicBoolean.class, ivp);
    public static final o<AtomicIntegerArray> ivr = new o<AtomicIntegerArray>() { // from class: com.google.gson.internal.a.n.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: o */
        public AtomicIntegerArray b(com.google.gson.stream.a aVar) throws IOException {
            ArrayList arrayList = new ArrayList();
            aVar.beginArray();
            while (aVar.hasNext()) {
                try {
                    arrayList.add(Integer.valueOf(aVar.nextInt()));
                } catch (NumberFormatException e) {
                    throw new JsonSyntaxException(e);
                }
            }
            aVar.endArray();
            int size = arrayList.size();
            AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
            for (int i = 0; i < size; i++) {
                atomicIntegerArray.set(i, ((Integer) arrayList.get(i)).intValue());
            }
            return atomicIntegerArray;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, AtomicIntegerArray atomicIntegerArray) throws IOException {
            bVar.caO();
            int length = atomicIntegerArray.length();
            for (int i = 0; i < length; i++) {
                bVar.dx(atomicIntegerArray.get(i));
            }
            bVar.caP();
        }
    }.cap();
    public static final p ivs = a(AtomicIntegerArray.class, ivr);
    public static final o<Number> ivt = new o<Number>() { // from class: com.google.gson.internal.a.n.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: d */
        public Number b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.caH() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            try {
                return Long.valueOf(aVar.nextLong());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, Number number) throws IOException {
            bVar.b(number);
        }
    };
    public static final o<Number> ivu = new o<Number>() { // from class: com.google.gson.internal.a.n.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: d */
        public Number b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.caH() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            return Float.valueOf((float) aVar.nextDouble());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, Number number) throws IOException {
            bVar.b(number);
        }
    };
    public static final o<Number> ivv = new o<Number>() { // from class: com.google.gson.internal.a.n.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: d */
        public Number b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.caH() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            return Double.valueOf(aVar.nextDouble());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, Number number) throws IOException {
            bVar.b(number);
        }
    };
    public static final o<Number> ivw = new o<Number>() { // from class: com.google.gson.internal.a.n.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: d */
        public Number b(com.google.gson.stream.a aVar) throws IOException {
            JsonToken caH = aVar.caH();
            switch (caH) {
                case NUMBER:
                    return new LazilyParsedNumber(aVar.nextString());
                case BOOLEAN:
                case STRING:
                default:
                    throw new JsonSyntaxException("Expecting number, got: " + caH);
                case NULL:
                    aVar.nextNull();
                    return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, Number number) throws IOException {
            bVar.b(number);
        }
    };
    public static final p ivx = a(Number.class, ivw);
    public static final o<Character> ivy = new o<Character>() { // from class: com.google.gson.internal.a.n.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: p */
        public Character b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.caH() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            String nextString = aVar.nextString();
            if (nextString.length() != 1) {
                throw new JsonSyntaxException("Expecting character, got: " + nextString);
            }
            return Character.valueOf(nextString.charAt(0));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, Character ch) throws IOException {
            bVar.zu(ch == null ? null : String.valueOf(ch));
        }
    };
    public static final p ivz = a(Character.TYPE, Character.class, ivy);
    public static final o<String> ivA = new o<String>() { // from class: com.google.gson.internal.a.n.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: q */
        public String b(com.google.gson.stream.a aVar) throws IOException {
            JsonToken caH = aVar.caH();
            if (caH == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            } else if (caH == JsonToken.BOOLEAN) {
                return Boolean.toString(aVar.nextBoolean());
            } else {
                return aVar.nextString();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, String str) throws IOException {
            bVar.zu(str);
        }
    };
    public static final o<BigDecimal> ivB = new o<BigDecimal>() { // from class: com.google.gson.internal.a.n.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: r */
        public BigDecimal b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.caH() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            try {
                return new BigDecimal(aVar.nextString());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, BigDecimal bigDecimal) throws IOException {
            bVar.b(bigDecimal);
        }
    };
    public static final o<BigInteger> ivC = new o<BigInteger>() { // from class: com.google.gson.internal.a.n.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: s */
        public BigInteger b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.caH() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            try {
                return new BigInteger(aVar.nextString());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, BigInteger bigInteger) throws IOException {
            bVar.b(bigInteger);
        }
    };
    public static final p ivD = a(String.class, ivA);
    public static final o<StringBuilder> ivE = new o<StringBuilder>() { // from class: com.google.gson.internal.a.n.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: t */
        public StringBuilder b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.caH() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            return new StringBuilder(aVar.nextString());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, StringBuilder sb) throws IOException {
            bVar.zu(sb == null ? null : sb.toString());
        }
    };
    public static final p ivF = a(StringBuilder.class, ivE);
    public static final o<StringBuffer> ivG = new o<StringBuffer>() { // from class: com.google.gson.internal.a.n.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: v */
        public StringBuffer b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.caH() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            return new StringBuffer(aVar.nextString());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, StringBuffer stringBuffer) throws IOException {
            bVar.zu(stringBuffer == null ? null : stringBuffer.toString());
        }
    };
    public static final p ivH = a(StringBuffer.class, ivG);
    public static final o<URL> ivI = new o<URL>() { // from class: com.google.gson.internal.a.n.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: w */
        public URL b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.caH() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            String nextString = aVar.nextString();
            if ("null".equals(nextString)) {
                return null;
            }
            return new URL(nextString);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, URL url) throws IOException {
            bVar.zu(url == null ? null : url.toExternalForm());
        }
    };
    public static final p ivJ = a(URL.class, ivI);
    public static final o<URI> ivK = new o<URI>() { // from class: com.google.gson.internal.a.n.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: x */
        public URI b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.caH() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            try {
                String nextString = aVar.nextString();
                if ("null".equals(nextString)) {
                    return null;
                }
                return new URI(nextString);
            } catch (URISyntaxException e) {
                throw new JsonIOException(e);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, URI uri) throws IOException {
            bVar.zu(uri == null ? null : uri.toASCIIString());
        }
    };
    public static final p ivL = a(URI.class, ivK);
    public static final o<InetAddress> ivM = new o<InetAddress>() { // from class: com.google.gson.internal.a.n.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: y */
        public InetAddress b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.caH() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            return InetAddress.getByName(aVar.nextString());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, InetAddress inetAddress) throws IOException {
            bVar.zu(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    };
    public static final p ivN = b(InetAddress.class, ivM);
    public static final o<UUID> ivO = new o<UUID>() { // from class: com.google.gson.internal.a.n.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: z */
        public UUID b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.caH() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            return UUID.fromString(aVar.nextString());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, UUID uuid) throws IOException {
            bVar.zu(uuid == null ? null : uuid.toString());
        }
    };
    public static final p ivP = a(UUID.class, ivO);
    public static final o<Currency> ivQ = new o<Currency>() { // from class: com.google.gson.internal.a.n.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: A */
        public Currency b(com.google.gson.stream.a aVar) throws IOException {
            return Currency.getInstance(aVar.nextString());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, Currency currency) throws IOException {
            bVar.zu(currency.getCurrencyCode());
        }
    }.cap();
    public static final p ivR = a(Currency.class, ivQ);
    public static final p ivS = new p() { // from class: com.google.gson.internal.a.n.19
        @Override // com.google.gson.p
        public <T> o<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
            if (aVar.caT() != Timestamp.class) {
                return null;
            }
            final o<T> t = dVar.t(Date.class);
            return (o<T>) new o<Timestamp>() { // from class: com.google.gson.internal.a.n.19.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.gson.o
                /* renamed from: B */
                public Timestamp b(com.google.gson.stream.a aVar2) throws IOException {
                    Date date = (Date) t.b(aVar2);
                    if (date != null) {
                        return new Timestamp(date.getTime());
                    }
                    return null;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.gson.o
                public void a(com.google.gson.stream.b bVar, Timestamp timestamp) throws IOException {
                    t.a(bVar, timestamp);
                }
            };
        }
    };
    public static final o<Calendar> ivT = new o<Calendar>() { // from class: com.google.gson.internal.a.n.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: C */
        public Calendar b(com.google.gson.stream.a aVar) throws IOException {
            int i = 0;
            if (aVar.caH() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            aVar.beginObject();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (aVar.caH() != JsonToken.END_OBJECT) {
                String nextName = aVar.nextName();
                int nextInt = aVar.nextInt();
                if (BdDatePicker.WHEEL_VIEW_YEAR_TYPE.equals(nextName)) {
                    i6 = nextInt;
                } else if (BdDatePicker.WHEEL_VIEW_MONTH_TYPE.equals(nextName)) {
                    i5 = nextInt;
                } else if ("dayOfMonth".equals(nextName)) {
                    i4 = nextInt;
                } else if ("hourOfDay".equals(nextName)) {
                    i3 = nextInt;
                } else if ("minute".equals(nextName)) {
                    i2 = nextInt;
                } else if ("second".equals(nextName)) {
                    i = nextInt;
                }
            }
            aVar.endObject();
            return new GregorianCalendar(i6, i5, i4, i3, i2, i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, Calendar calendar) throws IOException {
            if (calendar == null) {
                bVar.caS();
                return;
            }
            bVar.caQ();
            bVar.zt(BdDatePicker.WHEEL_VIEW_YEAR_TYPE);
            bVar.dx(calendar.get(1));
            bVar.zt(BdDatePicker.WHEEL_VIEW_MONTH_TYPE);
            bVar.dx(calendar.get(2));
            bVar.zt("dayOfMonth");
            bVar.dx(calendar.get(5));
            bVar.zt("hourOfDay");
            bVar.dx(calendar.get(11));
            bVar.zt("minute");
            bVar.dx(calendar.get(12));
            bVar.zt("second");
            bVar.dx(calendar.get(13));
            bVar.caR();
        }
    };
    public static final p ivU = b(Calendar.class, GregorianCalendar.class, ivT);
    public static final o<Locale> ivV = new o<Locale>() { // from class: com.google.gson.internal.a.n.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: D */
        public Locale b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.caH() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(aVar.nextString(), BaseRequestAction.SPLITE);
            String nextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String nextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String nextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            if (nextToken2 == null && nextToken3 == null) {
                return new Locale(nextToken);
            }
            if (nextToken3 == null) {
                return new Locale(nextToken, nextToken2);
            }
            return new Locale(nextToken, nextToken2, nextToken3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, Locale locale) throws IOException {
            bVar.zu(locale == null ? null : locale.toString());
        }
    };
    public static final p ivW = a(Locale.class, ivV);
    public static final o<com.google.gson.i> ivX = new o<com.google.gson.i>() { // from class: com.google.gson.internal.a.n.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: E */
        public com.google.gson.i b(com.google.gson.stream.a aVar) throws IOException {
            switch (AnonymousClass29.iuF[aVar.caH().ordinal()]) {
                case 1:
                    return new com.google.gson.l(new LazilyParsedNumber(aVar.nextString()));
                case 2:
                    return new com.google.gson.l(Boolean.valueOf(aVar.nextBoolean()));
                case 3:
                    return new com.google.gson.l(aVar.nextString());
                case 4:
                    aVar.nextNull();
                    return com.google.gson.j.itd;
                case 5:
                    com.google.gson.f fVar = new com.google.gson.f();
                    aVar.beginArray();
                    while (aVar.hasNext()) {
                        fVar.b(b(aVar));
                    }
                    aVar.endArray();
                    return fVar;
                case 6:
                    com.google.gson.k kVar = new com.google.gson.k();
                    aVar.beginObject();
                    while (aVar.hasNext()) {
                        kVar.a(aVar.nextName(), b(aVar));
                    }
                    aVar.endObject();
                    return kVar;
                default:
                    throw new IllegalArgumentException();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, com.google.gson.i iVar) throws IOException {
            if (iVar == null || iVar.cah()) {
                bVar.caS();
            } else if (iVar.cag()) {
                com.google.gson.l cak = iVar.cak();
                if (cak.can()) {
                    bVar.b(cak.cac());
                } else if (cak.cam()) {
                    bVar.pd(cak.getAsBoolean());
                } else {
                    bVar.zu(cak.cad());
                }
            } else if (iVar.cae()) {
                bVar.caO();
                Iterator<com.google.gson.i> it = iVar.caj().iterator();
                while (it.hasNext()) {
                    a(bVar, it.next());
                }
                bVar.caP();
            } else if (iVar.caf()) {
                bVar.caQ();
                for (Map.Entry<String, com.google.gson.i> entry : iVar.cai().entrySet()) {
                    bVar.zt(entry.getKey());
                    a(bVar, entry.getValue());
                }
                bVar.caR();
            } else {
                throw new IllegalArgumentException("Couldn't write " + iVar.getClass());
            }
        }
    };
    public static final p ivY = b(com.google.gson.i.class, ivX);
    public static final p ivZ = new p() { // from class: com.google.gson.internal.a.n.24
        @Override // com.google.gson.p
        public <T> o<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
            Class caT = aVar.caT();
            if (!Enum.class.isAssignableFrom(caT) || caT == Enum.class) {
                return null;
            }
            if (!caT.isEnum()) {
                caT = (Class<? super Object>) caT.getSuperclass();
            }
            return new a(caT);
        }
    };

    /* loaded from: classes2.dex */
    private static final class a<T extends Enum<T>> extends o<T> {
        private final Map<String, T> iwk = new HashMap();
        private final Map<T, String> iwl = new HashMap();

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.gson.internal.a.n$a<T extends java.lang.Enum<T>> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.gson.o
        public /* bridge */ /* synthetic */ void a(com.google.gson.stream.b bVar, Object obj) throws IOException {
            a(bVar, (com.google.gson.stream.b) ((Enum) obj));
        }

        public a(Class<T> cls) {
            T[] enumConstants;
            try {
                for (T t : cls.getEnumConstants()) {
                    String name = t.name();
                    com.google.gson.a.c cVar = (com.google.gson.a.c) cls.getField(name).getAnnotation(com.google.gson.a.c.class);
                    if (cVar != null) {
                        name = cVar.value();
                        String[] cat = cVar.cat();
                        for (String str : cat) {
                            this.iwk.put(str, t);
                        }
                    }
                    String str2 = name;
                    this.iwk.put(str2, t);
                    this.iwl.put(t, str2);
                }
            } catch (NoSuchFieldException e) {
                throw new AssertionError(e);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: I */
        public T b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.caH() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            return this.iwk.get(aVar.nextString());
        }

        public void a(com.google.gson.stream.b bVar, T t) throws IOException {
            bVar.zu(t == null ? null : this.iwl.get(t));
        }
    }

    public static <TT> p a(final Class<TT> cls, final o<TT> oVar) {
        return new p() { // from class: com.google.gson.internal.a.n.25
            @Override // com.google.gson.p
            public <T> o<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
                if (aVar.caT() == cls) {
                    return oVar;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + ",adapter=" + oVar + "]";
            }
        };
    }

    public static <TT> p a(final Class<TT> cls, final Class<TT> cls2, final o<? super TT> oVar) {
        return new p() { // from class: com.google.gson.internal.a.n.26
            @Override // com.google.gson.p
            public <T> o<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
                Class<? super T> caT = aVar.caT();
                if (caT == cls || caT == cls2) {
                    return oVar;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls2.getName() + "+" + cls.getName() + ",adapter=" + oVar + "]";
            }
        };
    }

    public static <TT> p b(final Class<TT> cls, final Class<? extends TT> cls2, final o<? super TT> oVar) {
        return new p() { // from class: com.google.gson.internal.a.n.27
            @Override // com.google.gson.p
            public <T> o<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
                Class<? super T> caT = aVar.caT();
                if (caT == cls || caT == cls2) {
                    return oVar;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + "+" + cls2.getName() + ",adapter=" + oVar + "]";
            }
        };
    }

    public static <T1> p b(final Class<T1> cls, final o<T1> oVar) {
        return new p() { // from class: com.google.gson.internal.a.n.28
            @Override // com.google.gson.p
            public <T2> o<T2> a(com.google.gson.d dVar, com.google.gson.b.a<T2> aVar) {
                final Class<? super T2> caT = aVar.caT();
                if (cls.isAssignableFrom(caT)) {
                    return (o<T2>) new o<T1>() { // from class: com.google.gson.internal.a.n.28.1
                        @Override // com.google.gson.o
                        public void a(com.google.gson.stream.b bVar, T1 t1) throws IOException {
                            oVar.a(bVar, t1);
                        }

                        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Class */
                        /* JADX WARN: Multi-variable type inference failed */
                        /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, T1] */
                        @Override // com.google.gson.o
                        public T1 b(com.google.gson.stream.a aVar2) throws IOException {
                            ?? b = oVar.b(aVar2);
                            if (b != 0 && !caT.isInstance(b)) {
                                throw new JsonSyntaxException("Expected a " + caT.getName() + " but was " + b.getClass().getName());
                            }
                            return b;
                        }
                    };
                }
                return null;
            }

            public String toString() {
                return "Factory[typeHierarchy=" + cls.getName() + ",adapter=" + oVar + "]";
            }
        };
    }
}
