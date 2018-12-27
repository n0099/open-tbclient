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
    public static final o<Class> iyk = new o<Class>() { // from class: com.google.gson.internal.a.n.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, Class cls) throws IOException {
            if (cls == null) {
                bVar.cbI();
                return;
            }
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: n */
        public Class b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cbx() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }
    };
    public static final p iyl = a(Class.class, iyk);
    public static final o<BitSet> iym = new o<BitSet>() { // from class: com.google.gson.internal.a.n.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: u */
        public BitSet b(com.google.gson.stream.a aVar) throws IOException {
            boolean z;
            if (aVar.cbx() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            BitSet bitSet = new BitSet();
            aVar.beginArray();
            JsonToken cbx = aVar.cbx();
            int i = 0;
            while (cbx != JsonToken.END_ARRAY) {
                switch (AnonymousClass29.ixP[cbx.ordinal()]) {
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
                        throw new JsonSyntaxException("Invalid bitset value type: " + cbx);
                }
                if (z) {
                    bitSet.set(i);
                }
                i++;
                cbx = aVar.cbx();
            }
            aVar.endArray();
            return bitSet;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, BitSet bitSet) throws IOException {
            if (bitSet == null) {
                bVar.cbI();
                return;
            }
            bVar.cbE();
            for (int i = 0; i < bitSet.length(); i++) {
                bVar.dC(bitSet.get(i) ? 1 : 0);
            }
            bVar.cbF();
        }
    };
    public static final p iyn = a(BitSet.class, iym);
    public static final o<Boolean> iyo = new o<Boolean>() { // from class: com.google.gson.internal.a.n.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: F */
        public Boolean b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cbx() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            } else if (aVar.cbx() == JsonToken.STRING) {
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
    public static final o<Boolean> iyp = new o<Boolean>() { // from class: com.google.gson.internal.a.n.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: F */
        public Boolean b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cbx() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            return Boolean.valueOf(aVar.nextString());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, Boolean bool) throws IOException {
            bVar.zx(bool == null ? "null" : bool.toString());
        }
    };
    public static final p iyq = a(Boolean.TYPE, Boolean.class, iyo);
    public static final o<Number> iyr = new o<Number>() { // from class: com.google.gson.internal.a.n.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: d */
        public Number b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cbx() == JsonToken.NULL) {
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
    public static final p iys = a(Byte.TYPE, Byte.class, iyr);
    public static final o<Number> iyt = new o<Number>() { // from class: com.google.gson.internal.a.n.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: d */
        public Number b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cbx() == JsonToken.NULL) {
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
    public static final p iyu = a(Short.TYPE, Short.class, iyt);
    public static final o<Number> iyv = new o<Number>() { // from class: com.google.gson.internal.a.n.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: d */
        public Number b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cbx() == JsonToken.NULL) {
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
    public static final p iyw = a(Integer.TYPE, Integer.class, iyv);
    public static final o<AtomicInteger> iyx = new o<AtomicInteger>() { // from class: com.google.gson.internal.a.n.34
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
            bVar.dC(atomicInteger.get());
        }
    }.cbf();
    public static final p iyy = a(AtomicInteger.class, iyx);
    public static final o<AtomicBoolean> iyz = new o<AtomicBoolean>() { // from class: com.google.gson.internal.a.n.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: H */
        public AtomicBoolean b(com.google.gson.stream.a aVar) throws IOException {
            return new AtomicBoolean(aVar.nextBoolean());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, AtomicBoolean atomicBoolean) throws IOException {
            bVar.pg(atomicBoolean.get());
        }
    }.cbf();
    public static final p iyA = a(AtomicBoolean.class, iyz);
    public static final o<AtomicIntegerArray> iyB = new o<AtomicIntegerArray>() { // from class: com.google.gson.internal.a.n.2
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
            bVar.cbE();
            int length = atomicIntegerArray.length();
            for (int i = 0; i < length; i++) {
                bVar.dC(atomicIntegerArray.get(i));
            }
            bVar.cbF();
        }
    }.cbf();
    public static final p iyC = a(AtomicIntegerArray.class, iyB);
    public static final o<Number> iyD = new o<Number>() { // from class: com.google.gson.internal.a.n.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: d */
        public Number b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cbx() == JsonToken.NULL) {
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
    public static final o<Number> iyE = new o<Number>() { // from class: com.google.gson.internal.a.n.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: d */
        public Number b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cbx() == JsonToken.NULL) {
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
    public static final o<Number> iyF = new o<Number>() { // from class: com.google.gson.internal.a.n.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: d */
        public Number b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cbx() == JsonToken.NULL) {
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
    public static final o<Number> iyG = new o<Number>() { // from class: com.google.gson.internal.a.n.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: d */
        public Number b(com.google.gson.stream.a aVar) throws IOException {
            JsonToken cbx = aVar.cbx();
            switch (cbx) {
                case NUMBER:
                    return new LazilyParsedNumber(aVar.nextString());
                case BOOLEAN:
                case STRING:
                default:
                    throw new JsonSyntaxException("Expecting number, got: " + cbx);
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
    public static final p iyH = a(Number.class, iyG);
    public static final o<Character> iyI = new o<Character>() { // from class: com.google.gson.internal.a.n.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: p */
        public Character b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cbx() == JsonToken.NULL) {
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
            bVar.zx(ch == null ? null : String.valueOf(ch));
        }
    };
    public static final p iyJ = a(Character.TYPE, Character.class, iyI);
    public static final o<String> iyK = new o<String>() { // from class: com.google.gson.internal.a.n.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: q */
        public String b(com.google.gson.stream.a aVar) throws IOException {
            JsonToken cbx = aVar.cbx();
            if (cbx == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            } else if (cbx == JsonToken.BOOLEAN) {
                return Boolean.toString(aVar.nextBoolean());
            } else {
                return aVar.nextString();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, String str) throws IOException {
            bVar.zx(str);
        }
    };
    public static final o<BigDecimal> iyL = new o<BigDecimal>() { // from class: com.google.gson.internal.a.n.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: r */
        public BigDecimal b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cbx() == JsonToken.NULL) {
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
    public static final o<BigInteger> iyM = new o<BigInteger>() { // from class: com.google.gson.internal.a.n.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: s */
        public BigInteger b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cbx() == JsonToken.NULL) {
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
    public static final p iyN = a(String.class, iyK);
    public static final o<StringBuilder> iyO = new o<StringBuilder>() { // from class: com.google.gson.internal.a.n.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: t */
        public StringBuilder b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cbx() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            return new StringBuilder(aVar.nextString());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, StringBuilder sb) throws IOException {
            bVar.zx(sb == null ? null : sb.toString());
        }
    };
    public static final p iyP = a(StringBuilder.class, iyO);
    public static final o<StringBuffer> iyQ = new o<StringBuffer>() { // from class: com.google.gson.internal.a.n.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: v */
        public StringBuffer b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cbx() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            return new StringBuffer(aVar.nextString());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, StringBuffer stringBuffer) throws IOException {
            bVar.zx(stringBuffer == null ? null : stringBuffer.toString());
        }
    };
    public static final p iyR = a(StringBuffer.class, iyQ);
    public static final o<URL> iyS = new o<URL>() { // from class: com.google.gson.internal.a.n.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: w */
        public URL b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cbx() == JsonToken.NULL) {
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
            bVar.zx(url == null ? null : url.toExternalForm());
        }
    };
    public static final p iyT = a(URL.class, iyS);
    public static final o<URI> iyU = new o<URI>() { // from class: com.google.gson.internal.a.n.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: x */
        public URI b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cbx() == JsonToken.NULL) {
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
            bVar.zx(uri == null ? null : uri.toASCIIString());
        }
    };
    public static final p iyV = a(URI.class, iyU);
    public static final o<InetAddress> iyW = new o<InetAddress>() { // from class: com.google.gson.internal.a.n.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: y */
        public InetAddress b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cbx() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            return InetAddress.getByName(aVar.nextString());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, InetAddress inetAddress) throws IOException {
            bVar.zx(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    };
    public static final p iyX = b(InetAddress.class, iyW);
    public static final o<UUID> iyY = new o<UUID>() { // from class: com.google.gson.internal.a.n.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: z */
        public UUID b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cbx() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            return UUID.fromString(aVar.nextString());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, UUID uuid) throws IOException {
            bVar.zx(uuid == null ? null : uuid.toString());
        }
    };
    public static final p iyZ = a(UUID.class, iyY);
    public static final o<Currency> iza = new o<Currency>() { // from class: com.google.gson.internal.a.n.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: A */
        public Currency b(com.google.gson.stream.a aVar) throws IOException {
            return Currency.getInstance(aVar.nextString());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, Currency currency) throws IOException {
            bVar.zx(currency.getCurrencyCode());
        }
    }.cbf();
    public static final p izb = a(Currency.class, iza);
    public static final p izc = new p() { // from class: com.google.gson.internal.a.n.19
        @Override // com.google.gson.p
        public <T> o<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
            if (aVar.cbJ() != Timestamp.class) {
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
    public static final o<Calendar> izd = new o<Calendar>() { // from class: com.google.gson.internal.a.n.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: C */
        public Calendar b(com.google.gson.stream.a aVar) throws IOException {
            int i = 0;
            if (aVar.cbx() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            aVar.beginObject();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (aVar.cbx() != JsonToken.END_OBJECT) {
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
                bVar.cbI();
                return;
            }
            bVar.cbG();
            bVar.zw(BdDatePicker.WHEEL_VIEW_YEAR_TYPE);
            bVar.dC(calendar.get(1));
            bVar.zw(BdDatePicker.WHEEL_VIEW_MONTH_TYPE);
            bVar.dC(calendar.get(2));
            bVar.zw("dayOfMonth");
            bVar.dC(calendar.get(5));
            bVar.zw("hourOfDay");
            bVar.dC(calendar.get(11));
            bVar.zw("minute");
            bVar.dC(calendar.get(12));
            bVar.zw("second");
            bVar.dC(calendar.get(13));
            bVar.cbH();
        }
    };
    public static final p ize = b(Calendar.class, GregorianCalendar.class, izd);
    public static final o<Locale> izf = new o<Locale>() { // from class: com.google.gson.internal.a.n.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: D */
        public Locale b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cbx() == JsonToken.NULL) {
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
            bVar.zx(locale == null ? null : locale.toString());
        }
    };
    public static final p izg = a(Locale.class, izf);
    public static final o<com.google.gson.i> izh = new o<com.google.gson.i>() { // from class: com.google.gson.internal.a.n.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: E */
        public com.google.gson.i b(com.google.gson.stream.a aVar) throws IOException {
            switch (AnonymousClass29.ixP[aVar.cbx().ordinal()]) {
                case 1:
                    return new com.google.gson.l(new LazilyParsedNumber(aVar.nextString()));
                case 2:
                    return new com.google.gson.l(Boolean.valueOf(aVar.nextBoolean()));
                case 3:
                    return new com.google.gson.l(aVar.nextString());
                case 4:
                    aVar.nextNull();
                    return com.google.gson.j.iwn;
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
            if (iVar == null || iVar.caX()) {
                bVar.cbI();
            } else if (iVar.caW()) {
                com.google.gson.l cba = iVar.cba();
                if (cba.cbd()) {
                    bVar.b(cba.caS());
                } else if (cba.cbc()) {
                    bVar.pg(cba.getAsBoolean());
                } else {
                    bVar.zx(cba.caT());
                }
            } else if (iVar.caU()) {
                bVar.cbE();
                Iterator<com.google.gson.i> it = iVar.caZ().iterator();
                while (it.hasNext()) {
                    a(bVar, it.next());
                }
                bVar.cbF();
            } else if (iVar.caV()) {
                bVar.cbG();
                for (Map.Entry<String, com.google.gson.i> entry : iVar.caY().entrySet()) {
                    bVar.zw(entry.getKey());
                    a(bVar, entry.getValue());
                }
                bVar.cbH();
            } else {
                throw new IllegalArgumentException("Couldn't write " + iVar.getClass());
            }
        }
    };
    public static final p izi = b(com.google.gson.i.class, izh);
    public static final p izj = new p() { // from class: com.google.gson.internal.a.n.24
        @Override // com.google.gson.p
        public <T> o<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
            Class cbJ = aVar.cbJ();
            if (!Enum.class.isAssignableFrom(cbJ) || cbJ == Enum.class) {
                return null;
            }
            if (!cbJ.isEnum()) {
                cbJ = (Class<? super Object>) cbJ.getSuperclass();
            }
            return new a(cbJ);
        }
    };

    /* loaded from: classes2.dex */
    private static final class a<T extends Enum<T>> extends o<T> {
        private final Map<String, T> izu = new HashMap();
        private final Map<T, String> izv = new HashMap();

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
                        String[] cbj = cVar.cbj();
                        for (String str : cbj) {
                            this.izu.put(str, t);
                        }
                    }
                    String str2 = name;
                    this.izu.put(str2, t);
                    this.izv.put(t, str2);
                }
            } catch (NoSuchFieldException e) {
                throw new AssertionError(e);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: I */
        public T b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cbx() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            return this.izu.get(aVar.nextString());
        }

        public void a(com.google.gson.stream.b bVar, T t) throws IOException {
            bVar.zx(t == null ? null : this.izv.get(t));
        }
    }

    public static <TT> p a(final Class<TT> cls, final o<TT> oVar) {
        return new p() { // from class: com.google.gson.internal.a.n.25
            @Override // com.google.gson.p
            public <T> o<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
                if (aVar.cbJ() == cls) {
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
                Class<? super T> cbJ = aVar.cbJ();
                if (cbJ == cls || cbJ == cls2) {
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
                Class<? super T> cbJ = aVar.cbJ();
                if (cbJ == cls || cbJ == cls2) {
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
                final Class<? super T2> cbJ = aVar.cbJ();
                if (cls.isAssignableFrom(cbJ)) {
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
                            if (b != 0 && !cbJ.isInstance(b)) {
                                throw new JsonSyntaxException("Expected a " + cbJ.getName() + " but was " + b.getClass().getName());
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
