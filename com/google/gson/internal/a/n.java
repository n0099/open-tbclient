package com.google.gson.internal.a;

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
    public static final o<Class> jPd = new o<Class>() { // from class: com.google.gson.internal.a.n.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, Class cls) throws IOException {
            if (cls == null) {
                bVar.cBv();
                return;
            }
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: n */
        public Class b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cBk() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }
    };
    public static final p jPe = a(Class.class, jPd);
    public static final o<BitSet> jPf = new o<BitSet>() { // from class: com.google.gson.internal.a.n.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: u */
        public BitSet b(com.google.gson.stream.a aVar) throws IOException {
            boolean z;
            if (aVar.cBk() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            BitSet bitSet = new BitSet();
            aVar.beginArray();
            JsonToken cBk = aVar.cBk();
            int i = 0;
            while (cBk != JsonToken.END_ARRAY) {
                switch (AnonymousClass29.jOI[cBk.ordinal()]) {
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
                        throw new JsonSyntaxException("Invalid bitset value type: " + cBk);
                }
                if (z) {
                    bitSet.set(i);
                }
                i++;
                cBk = aVar.cBk();
            }
            aVar.endArray();
            return bitSet;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, BitSet bitSet) throws IOException {
            if (bitSet == null) {
                bVar.cBv();
                return;
            }
            bVar.cBr();
            for (int i = 0; i < bitSet.length(); i++) {
                bVar.eh(bitSet.get(i) ? 1 : 0);
            }
            bVar.cBs();
        }
    };
    public static final p jPg = a(BitSet.class, jPf);
    public static final o<Boolean> jPh = new o<Boolean>() { // from class: com.google.gson.internal.a.n.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: F */
        public Boolean b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cBk() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            } else if (aVar.cBk() == JsonToken.STRING) {
                return Boolean.valueOf(Boolean.parseBoolean(aVar.nextString()));
            } else {
                return Boolean.valueOf(aVar.nextBoolean());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, Boolean bool) throws IOException {
            bVar.m(bool);
        }
    };
    public static final o<Boolean> jPi = new o<Boolean>() { // from class: com.google.gson.internal.a.n.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: F */
        public Boolean b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cBk() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            return Boolean.valueOf(aVar.nextString());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, Boolean bool) throws IOException {
            bVar.FQ(bool == null ? "null" : bool.toString());
        }
    };
    public static final p jPj = a(Boolean.TYPE, Boolean.class, jPh);
    public static final o<Number> jPk = new o<Number>() { // from class: com.google.gson.internal.a.n.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: d */
        public Number b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cBk() == JsonToken.NULL) {
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
    public static final p jPl = a(Byte.TYPE, Byte.class, jPk);
    public static final o<Number> jPm = new o<Number>() { // from class: com.google.gson.internal.a.n.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: d */
        public Number b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cBk() == JsonToken.NULL) {
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
    public static final p jPn = a(Short.TYPE, Short.class, jPm);
    public static final o<Number> jPo = new o<Number>() { // from class: com.google.gson.internal.a.n.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: d */
        public Number b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cBk() == JsonToken.NULL) {
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
    public static final p jPp = a(Integer.TYPE, Integer.class, jPo);
    public static final o<AtomicInteger> jPq = new o<AtomicInteger>() { // from class: com.google.gson.internal.a.n.34
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
            bVar.eh(atomicInteger.get());
        }
    }.cAS();
    public static final p jPr = a(AtomicInteger.class, jPq);
    public static final o<AtomicBoolean> jPs = new o<AtomicBoolean>() { // from class: com.google.gson.internal.a.n.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: H */
        public AtomicBoolean b(com.google.gson.stream.a aVar) throws IOException {
            return new AtomicBoolean(aVar.nextBoolean());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, AtomicBoolean atomicBoolean) throws IOException {
            bVar.rB(atomicBoolean.get());
        }
    }.cAS();
    public static final p jPt = a(AtomicBoolean.class, jPs);
    public static final o<AtomicIntegerArray> jPu = new o<AtomicIntegerArray>() { // from class: com.google.gson.internal.a.n.2
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
            bVar.cBr();
            int length = atomicIntegerArray.length();
            for (int i = 0; i < length; i++) {
                bVar.eh(atomicIntegerArray.get(i));
            }
            bVar.cBs();
        }
    }.cAS();
    public static final p jPv = a(AtomicIntegerArray.class, jPu);
    public static final o<Number> jPw = new o<Number>() { // from class: com.google.gson.internal.a.n.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: d */
        public Number b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cBk() == JsonToken.NULL) {
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
    public static final o<Number> jPx = new o<Number>() { // from class: com.google.gson.internal.a.n.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: d */
        public Number b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cBk() == JsonToken.NULL) {
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
    public static final o<Number> jPy = new o<Number>() { // from class: com.google.gson.internal.a.n.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: d */
        public Number b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cBk() == JsonToken.NULL) {
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
    public static final o<Number> jPz = new o<Number>() { // from class: com.google.gson.internal.a.n.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: d */
        public Number b(com.google.gson.stream.a aVar) throws IOException {
            JsonToken cBk = aVar.cBk();
            switch (cBk) {
                case NUMBER:
                    return new LazilyParsedNumber(aVar.nextString());
                case BOOLEAN:
                case STRING:
                default:
                    throw new JsonSyntaxException("Expecting number, got: " + cBk);
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
    public static final p jPA = a(Number.class, jPz);
    public static final o<Character> jPB = new o<Character>() { // from class: com.google.gson.internal.a.n.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: p */
        public Character b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cBk() == JsonToken.NULL) {
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
            bVar.FQ(ch == null ? null : String.valueOf(ch));
        }
    };
    public static final p jPC = a(Character.TYPE, Character.class, jPB);
    public static final o<String> jPD = new o<String>() { // from class: com.google.gson.internal.a.n.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: q */
        public String b(com.google.gson.stream.a aVar) throws IOException {
            JsonToken cBk = aVar.cBk();
            if (cBk == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            } else if (cBk == JsonToken.BOOLEAN) {
                return Boolean.toString(aVar.nextBoolean());
            } else {
                return aVar.nextString();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, String str) throws IOException {
            bVar.FQ(str);
        }
    };
    public static final o<BigDecimal> jPE = new o<BigDecimal>() { // from class: com.google.gson.internal.a.n.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: r */
        public BigDecimal b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cBk() == JsonToken.NULL) {
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
    public static final o<BigInteger> jPF = new o<BigInteger>() { // from class: com.google.gson.internal.a.n.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: s */
        public BigInteger b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cBk() == JsonToken.NULL) {
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
    public static final p jPG = a(String.class, jPD);
    public static final o<StringBuilder> jPH = new o<StringBuilder>() { // from class: com.google.gson.internal.a.n.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: t */
        public StringBuilder b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cBk() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            return new StringBuilder(aVar.nextString());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, StringBuilder sb) throws IOException {
            bVar.FQ(sb == null ? null : sb.toString());
        }
    };
    public static final p jPI = a(StringBuilder.class, jPH);
    public static final o<StringBuffer> jPJ = new o<StringBuffer>() { // from class: com.google.gson.internal.a.n.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: v */
        public StringBuffer b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cBk() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            return new StringBuffer(aVar.nextString());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, StringBuffer stringBuffer) throws IOException {
            bVar.FQ(stringBuffer == null ? null : stringBuffer.toString());
        }
    };
    public static final p jPK = a(StringBuffer.class, jPJ);
    public static final o<URL> jPL = new o<URL>() { // from class: com.google.gson.internal.a.n.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: w */
        public URL b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cBk() == JsonToken.NULL) {
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
            bVar.FQ(url == null ? null : url.toExternalForm());
        }
    };
    public static final p jPM = a(URL.class, jPL);
    public static final o<URI> jPN = new o<URI>() { // from class: com.google.gson.internal.a.n.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: x */
        public URI b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cBk() == JsonToken.NULL) {
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
            bVar.FQ(uri == null ? null : uri.toASCIIString());
        }
    };
    public static final p jPO = a(URI.class, jPN);
    public static final o<InetAddress> jPP = new o<InetAddress>() { // from class: com.google.gson.internal.a.n.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: y */
        public InetAddress b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cBk() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            return InetAddress.getByName(aVar.nextString());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, InetAddress inetAddress) throws IOException {
            bVar.FQ(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    };
    public static final p jPQ = b(InetAddress.class, jPP);
    public static final o<UUID> jPR = new o<UUID>() { // from class: com.google.gson.internal.a.n.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: z */
        public UUID b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cBk() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            return UUID.fromString(aVar.nextString());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, UUID uuid) throws IOException {
            bVar.FQ(uuid == null ? null : uuid.toString());
        }
    };
    public static final p jPS = a(UUID.class, jPR);
    public static final o<Currency> jPT = new o<Currency>() { // from class: com.google.gson.internal.a.n.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: A */
        public Currency b(com.google.gson.stream.a aVar) throws IOException {
            return Currency.getInstance(aVar.nextString());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, Currency currency) throws IOException {
            bVar.FQ(currency.getCurrencyCode());
        }
    }.cAS();
    public static final p jPU = a(Currency.class, jPT);
    public static final p jPV = new p() { // from class: com.google.gson.internal.a.n.19
        @Override // com.google.gson.p
        public <T> o<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
            if (aVar.cBw() != Timestamp.class) {
                return null;
            }
            final o<T> w = dVar.w(Date.class);
            return (o<T>) new o<Timestamp>() { // from class: com.google.gson.internal.a.n.19.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.gson.o
                /* renamed from: B */
                public Timestamp b(com.google.gson.stream.a aVar2) throws IOException {
                    Date date = (Date) w.b(aVar2);
                    if (date != null) {
                        return new Timestamp(date.getTime());
                    }
                    return null;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.gson.o
                public void a(com.google.gson.stream.b bVar, Timestamp timestamp) throws IOException {
                    w.a(bVar, timestamp);
                }
            };
        }
    };
    public static final o<Calendar> jPW = new o<Calendar>() { // from class: com.google.gson.internal.a.n.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: C */
        public Calendar b(com.google.gson.stream.a aVar) throws IOException {
            int i = 0;
            if (aVar.cBk() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            aVar.beginObject();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (aVar.cBk() != JsonToken.END_OBJECT) {
                String nextName = aVar.nextName();
                int nextInt = aVar.nextInt();
                if ("year".equals(nextName)) {
                    i6 = nextInt;
                } else if ("month".equals(nextName)) {
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
                bVar.cBv();
                return;
            }
            bVar.cBt();
            bVar.FP("year");
            bVar.eh(calendar.get(1));
            bVar.FP("month");
            bVar.eh(calendar.get(2));
            bVar.FP("dayOfMonth");
            bVar.eh(calendar.get(5));
            bVar.FP("hourOfDay");
            bVar.eh(calendar.get(11));
            bVar.FP("minute");
            bVar.eh(calendar.get(12));
            bVar.FP("second");
            bVar.eh(calendar.get(13));
            bVar.cBu();
        }
    };
    public static final p jPX = b(Calendar.class, GregorianCalendar.class, jPW);
    public static final o<Locale> jPY = new o<Locale>() { // from class: com.google.gson.internal.a.n.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: D */
        public Locale b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cBk() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(aVar.nextString(), "_");
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
            bVar.FQ(locale == null ? null : locale.toString());
        }
    };
    public static final p jPZ = a(Locale.class, jPY);
    public static final o<com.google.gson.i> jQa = new o<com.google.gson.i>() { // from class: com.google.gson.internal.a.n.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: E */
        public com.google.gson.i b(com.google.gson.stream.a aVar) throws IOException {
            switch (AnonymousClass29.jOI[aVar.cBk().ordinal()]) {
                case 1:
                    return new com.google.gson.l(new LazilyParsedNumber(aVar.nextString()));
                case 2:
                    return new com.google.gson.l(Boolean.valueOf(aVar.nextBoolean()));
                case 3:
                    return new com.google.gson.l(aVar.nextString());
                case 4:
                    aVar.nextNull();
                    return com.google.gson.j.jNg;
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
            if (iVar == null || iVar.cAK()) {
                bVar.cBv();
            } else if (iVar.cAJ()) {
                com.google.gson.l cAN = iVar.cAN();
                if (cAN.cAQ()) {
                    bVar.b(cAN.cAF());
                } else if (cAN.cAP()) {
                    bVar.rB(cAN.getAsBoolean());
                } else {
                    bVar.FQ(cAN.cAG());
                }
            } else if (iVar.cAH()) {
                bVar.cBr();
                Iterator<com.google.gson.i> it = iVar.cAM().iterator();
                while (it.hasNext()) {
                    a(bVar, it.next());
                }
                bVar.cBs();
            } else if (iVar.cAI()) {
                bVar.cBt();
                for (Map.Entry<String, com.google.gson.i> entry : iVar.cAL().entrySet()) {
                    bVar.FP(entry.getKey());
                    a(bVar, entry.getValue());
                }
                bVar.cBu();
            } else {
                throw new IllegalArgumentException("Couldn't write " + iVar.getClass());
            }
        }
    };
    public static final p jQb = b(com.google.gson.i.class, jQa);
    public static final p jQc = new p() { // from class: com.google.gson.internal.a.n.24
        @Override // com.google.gson.p
        public <T> o<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
            Class cBw = aVar.cBw();
            if (!Enum.class.isAssignableFrom(cBw) || cBw == Enum.class) {
                return null;
            }
            if (!cBw.isEnum()) {
                cBw = (Class<? super Object>) cBw.getSuperclass();
            }
            return new a(cBw);
        }
    };

    /* loaded from: classes2.dex */
    private static final class a<T extends Enum<T>> extends o<T> {
        private final Map<String, T> jQn = new HashMap();
        private final Map<T, String> jQo = new HashMap();

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
                        String[] cAW = cVar.cAW();
                        for (String str : cAW) {
                            this.jQn.put(str, t);
                        }
                    }
                    String str2 = name;
                    this.jQn.put(str2, t);
                    this.jQo.put(t, str2);
                }
            } catch (NoSuchFieldException e) {
                throw new AssertionError(e);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: I */
        public T b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cBk() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            return this.jQn.get(aVar.nextString());
        }

        public void a(com.google.gson.stream.b bVar, T t) throws IOException {
            bVar.FQ(t == null ? null : this.jQo.get(t));
        }
    }

    public static <TT> p a(final Class<TT> cls, final o<TT> oVar) {
        return new p() { // from class: com.google.gson.internal.a.n.25
            @Override // com.google.gson.p
            public <T> o<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
                if (aVar.cBw() == cls) {
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
                Class<? super T> cBw = aVar.cBw();
                if (cBw == cls || cBw == cls2) {
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
                Class<? super T> cBw = aVar.cBw();
                if (cBw == cls || cBw == cls2) {
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
                final Class<? super T2> cBw = aVar.cBw();
                if (cls.isAssignableFrom(cBw)) {
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
                            if (b != 0 && !cBw.isInstance(b)) {
                                throw new JsonSyntaxException("Expected a " + cBw.getName() + " but was " + b.getClass().getName());
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
