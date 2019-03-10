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
    public static final o<Class> jPw = new o<Class>() { // from class: com.google.gson.internal.a.n.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, Class cls) throws IOException {
            if (cls == null) {
                bVar.cBF();
                return;
            }
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: n */
        public Class b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cBu() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }
    };
    public static final p jPx = a(Class.class, jPw);
    public static final o<BitSet> jPy = new o<BitSet>() { // from class: com.google.gson.internal.a.n.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: u */
        public BitSet b(com.google.gson.stream.a aVar) throws IOException {
            boolean z;
            if (aVar.cBu() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            BitSet bitSet = new BitSet();
            aVar.beginArray();
            JsonToken cBu = aVar.cBu();
            int i = 0;
            while (cBu != JsonToken.END_ARRAY) {
                switch (AnonymousClass29.jPb[cBu.ordinal()]) {
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
                        throw new JsonSyntaxException("Invalid bitset value type: " + cBu);
                }
                if (z) {
                    bitSet.set(i);
                }
                i++;
                cBu = aVar.cBu();
            }
            aVar.endArray();
            return bitSet;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, BitSet bitSet) throws IOException {
            if (bitSet == null) {
                bVar.cBF();
                return;
            }
            bVar.cBB();
            for (int i = 0; i < bitSet.length(); i++) {
                bVar.eh(bitSet.get(i) ? 1 : 0);
            }
            bVar.cBC();
        }
    };
    public static final p jPz = a(BitSet.class, jPy);
    public static final o<Boolean> jPA = new o<Boolean>() { // from class: com.google.gson.internal.a.n.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: F */
        public Boolean b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cBu() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            } else if (aVar.cBu() == JsonToken.STRING) {
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
    public static final o<Boolean> jPB = new o<Boolean>() { // from class: com.google.gson.internal.a.n.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: F */
        public Boolean b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cBu() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            return Boolean.valueOf(aVar.nextString());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, Boolean bool) throws IOException {
            bVar.FT(bool == null ? "null" : bool.toString());
        }
    };
    public static final p jPC = a(Boolean.TYPE, Boolean.class, jPA);
    public static final o<Number> jPD = new o<Number>() { // from class: com.google.gson.internal.a.n.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: d */
        public Number b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cBu() == JsonToken.NULL) {
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
    public static final p jPE = a(Byte.TYPE, Byte.class, jPD);
    public static final o<Number> jPF = new o<Number>() { // from class: com.google.gson.internal.a.n.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: d */
        public Number b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cBu() == JsonToken.NULL) {
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
    public static final p jPG = a(Short.TYPE, Short.class, jPF);
    public static final o<Number> jPH = new o<Number>() { // from class: com.google.gson.internal.a.n.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: d */
        public Number b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cBu() == JsonToken.NULL) {
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
    public static final p jPI = a(Integer.TYPE, Integer.class, jPH);
    public static final o<AtomicInteger> jPJ = new o<AtomicInteger>() { // from class: com.google.gson.internal.a.n.34
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
    }.cBc();
    public static final p jPK = a(AtomicInteger.class, jPJ);
    public static final o<AtomicBoolean> jPL = new o<AtomicBoolean>() { // from class: com.google.gson.internal.a.n.35
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
    }.cBc();
    public static final p jPM = a(AtomicBoolean.class, jPL);
    public static final o<AtomicIntegerArray> jPN = new o<AtomicIntegerArray>() { // from class: com.google.gson.internal.a.n.2
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
            bVar.cBB();
            int length = atomicIntegerArray.length();
            for (int i = 0; i < length; i++) {
                bVar.eh(atomicIntegerArray.get(i));
            }
            bVar.cBC();
        }
    }.cBc();
    public static final p jPO = a(AtomicIntegerArray.class, jPN);
    public static final o<Number> jPP = new o<Number>() { // from class: com.google.gson.internal.a.n.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: d */
        public Number b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cBu() == JsonToken.NULL) {
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
    public static final o<Number> jPQ = new o<Number>() { // from class: com.google.gson.internal.a.n.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: d */
        public Number b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cBu() == JsonToken.NULL) {
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
    public static final o<Number> jPR = new o<Number>() { // from class: com.google.gson.internal.a.n.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: d */
        public Number b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cBu() == JsonToken.NULL) {
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
    public static final o<Number> jPS = new o<Number>() { // from class: com.google.gson.internal.a.n.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: d */
        public Number b(com.google.gson.stream.a aVar) throws IOException {
            JsonToken cBu = aVar.cBu();
            switch (cBu) {
                case NUMBER:
                    return new LazilyParsedNumber(aVar.nextString());
                case BOOLEAN:
                case STRING:
                default:
                    throw new JsonSyntaxException("Expecting number, got: " + cBu);
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
    public static final p jPT = a(Number.class, jPS);
    public static final o<Character> jPU = new o<Character>() { // from class: com.google.gson.internal.a.n.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: p */
        public Character b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cBu() == JsonToken.NULL) {
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
            bVar.FT(ch == null ? null : String.valueOf(ch));
        }
    };
    public static final p jPV = a(Character.TYPE, Character.class, jPU);
    public static final o<String> jPW = new o<String>() { // from class: com.google.gson.internal.a.n.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: q */
        public String b(com.google.gson.stream.a aVar) throws IOException {
            JsonToken cBu = aVar.cBu();
            if (cBu == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            } else if (cBu == JsonToken.BOOLEAN) {
                return Boolean.toString(aVar.nextBoolean());
            } else {
                return aVar.nextString();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, String str) throws IOException {
            bVar.FT(str);
        }
    };
    public static final o<BigDecimal> jPX = new o<BigDecimal>() { // from class: com.google.gson.internal.a.n.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: r */
        public BigDecimal b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cBu() == JsonToken.NULL) {
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
    public static final o<BigInteger> jPY = new o<BigInteger>() { // from class: com.google.gson.internal.a.n.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: s */
        public BigInteger b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cBu() == JsonToken.NULL) {
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
    public static final p jPZ = a(String.class, jPW);
    public static final o<StringBuilder> jQa = new o<StringBuilder>() { // from class: com.google.gson.internal.a.n.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: t */
        public StringBuilder b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cBu() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            return new StringBuilder(aVar.nextString());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, StringBuilder sb) throws IOException {
            bVar.FT(sb == null ? null : sb.toString());
        }
    };
    public static final p jQb = a(StringBuilder.class, jQa);
    public static final o<StringBuffer> jQc = new o<StringBuffer>() { // from class: com.google.gson.internal.a.n.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: v */
        public StringBuffer b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cBu() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            return new StringBuffer(aVar.nextString());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, StringBuffer stringBuffer) throws IOException {
            bVar.FT(stringBuffer == null ? null : stringBuffer.toString());
        }
    };
    public static final p jQd = a(StringBuffer.class, jQc);
    public static final o<URL> jQe = new o<URL>() { // from class: com.google.gson.internal.a.n.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: w */
        public URL b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cBu() == JsonToken.NULL) {
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
            bVar.FT(url == null ? null : url.toExternalForm());
        }
    };
    public static final p jQf = a(URL.class, jQe);
    public static final o<URI> jQg = new o<URI>() { // from class: com.google.gson.internal.a.n.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: x */
        public URI b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cBu() == JsonToken.NULL) {
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
            bVar.FT(uri == null ? null : uri.toASCIIString());
        }
    };
    public static final p jQh = a(URI.class, jQg);
    public static final o<InetAddress> jQi = new o<InetAddress>() { // from class: com.google.gson.internal.a.n.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: y */
        public InetAddress b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cBu() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            return InetAddress.getByName(aVar.nextString());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, InetAddress inetAddress) throws IOException {
            bVar.FT(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    };
    public static final p jQj = b(InetAddress.class, jQi);
    public static final o<UUID> jQk = new o<UUID>() { // from class: com.google.gson.internal.a.n.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: z */
        public UUID b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cBu() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            return UUID.fromString(aVar.nextString());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, UUID uuid) throws IOException {
            bVar.FT(uuid == null ? null : uuid.toString());
        }
    };
    public static final p jQl = a(UUID.class, jQk);
    public static final o<Currency> jQm = new o<Currency>() { // from class: com.google.gson.internal.a.n.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: A */
        public Currency b(com.google.gson.stream.a aVar) throws IOException {
            return Currency.getInstance(aVar.nextString());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, Currency currency) throws IOException {
            bVar.FT(currency.getCurrencyCode());
        }
    }.cBc();
    public static final p jQn = a(Currency.class, jQm);
    public static final p jQo = new p() { // from class: com.google.gson.internal.a.n.19
        @Override // com.google.gson.p
        public <T> o<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
            if (aVar.cBG() != Timestamp.class) {
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
    public static final o<Calendar> jQp = new o<Calendar>() { // from class: com.google.gson.internal.a.n.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: C */
        public Calendar b(com.google.gson.stream.a aVar) throws IOException {
            int i = 0;
            if (aVar.cBu() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            aVar.beginObject();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (aVar.cBu() != JsonToken.END_OBJECT) {
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
                bVar.cBF();
                return;
            }
            bVar.cBD();
            bVar.FS("year");
            bVar.eh(calendar.get(1));
            bVar.FS("month");
            bVar.eh(calendar.get(2));
            bVar.FS("dayOfMonth");
            bVar.eh(calendar.get(5));
            bVar.FS("hourOfDay");
            bVar.eh(calendar.get(11));
            bVar.FS("minute");
            bVar.eh(calendar.get(12));
            bVar.FS("second");
            bVar.eh(calendar.get(13));
            bVar.cBE();
        }
    };
    public static final p jQq = b(Calendar.class, GregorianCalendar.class, jQp);
    public static final o<Locale> jQr = new o<Locale>() { // from class: com.google.gson.internal.a.n.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: D */
        public Locale b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cBu() == JsonToken.NULL) {
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
            bVar.FT(locale == null ? null : locale.toString());
        }
    };
    public static final p jQs = a(Locale.class, jQr);
    public static final o<com.google.gson.i> jQt = new o<com.google.gson.i>() { // from class: com.google.gson.internal.a.n.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: E */
        public com.google.gson.i b(com.google.gson.stream.a aVar) throws IOException {
            switch (AnonymousClass29.jPb[aVar.cBu().ordinal()]) {
                case 1:
                    return new com.google.gson.l(new LazilyParsedNumber(aVar.nextString()));
                case 2:
                    return new com.google.gson.l(Boolean.valueOf(aVar.nextBoolean()));
                case 3:
                    return new com.google.gson.l(aVar.nextString());
                case 4:
                    aVar.nextNull();
                    return com.google.gson.j.jNz;
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
            if (iVar == null || iVar.cAU()) {
                bVar.cBF();
            } else if (iVar.cAT()) {
                com.google.gson.l cAX = iVar.cAX();
                if (cAX.cBa()) {
                    bVar.b(cAX.cAP());
                } else if (cAX.cAZ()) {
                    bVar.rB(cAX.getAsBoolean());
                } else {
                    bVar.FT(cAX.cAQ());
                }
            } else if (iVar.cAR()) {
                bVar.cBB();
                Iterator<com.google.gson.i> it = iVar.cAW().iterator();
                while (it.hasNext()) {
                    a(bVar, it.next());
                }
                bVar.cBC();
            } else if (iVar.cAS()) {
                bVar.cBD();
                for (Map.Entry<String, com.google.gson.i> entry : iVar.cAV().entrySet()) {
                    bVar.FS(entry.getKey());
                    a(bVar, entry.getValue());
                }
                bVar.cBE();
            } else {
                throw new IllegalArgumentException("Couldn't write " + iVar.getClass());
            }
        }
    };
    public static final p jQu = b(com.google.gson.i.class, jQt);
    public static final p jQv = new p() { // from class: com.google.gson.internal.a.n.24
        @Override // com.google.gson.p
        public <T> o<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
            Class cBG = aVar.cBG();
            if (!Enum.class.isAssignableFrom(cBG) || cBG == Enum.class) {
                return null;
            }
            if (!cBG.isEnum()) {
                cBG = (Class<? super Object>) cBG.getSuperclass();
            }
            return new a(cBG);
        }
    };

    /* loaded from: classes2.dex */
    private static final class a<T extends Enum<T>> extends o<T> {
        private final Map<String, T> jQG = new HashMap();
        private final Map<T, String> jQH = new HashMap();

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
                        String[] cBg = cVar.cBg();
                        for (String str : cBg) {
                            this.jQG.put(str, t);
                        }
                    }
                    String str2 = name;
                    this.jQG.put(str2, t);
                    this.jQH.put(t, str2);
                }
            } catch (NoSuchFieldException e) {
                throw new AssertionError(e);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: I */
        public T b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cBu() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            return this.jQG.get(aVar.nextString());
        }

        public void a(com.google.gson.stream.b bVar, T t) throws IOException {
            bVar.FT(t == null ? null : this.jQH.get(t));
        }
    }

    public static <TT> p a(final Class<TT> cls, final o<TT> oVar) {
        return new p() { // from class: com.google.gson.internal.a.n.25
            @Override // com.google.gson.p
            public <T> o<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
                if (aVar.cBG() == cls) {
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
                Class<? super T> cBG = aVar.cBG();
                if (cBG == cls || cBG == cls2) {
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
                Class<? super T> cBG = aVar.cBG();
                if (cBG == cls || cBG == cls2) {
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
                final Class<? super T2> cBG = aVar.cBG();
                if (cls.isAssignableFrom(cBG)) {
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
                            if (b != 0 && !cBG.isInstance(b)) {
                                throw new JsonSyntaxException("Expected a " + cBG.getName() + " but was " + b.getClass().getName());
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
