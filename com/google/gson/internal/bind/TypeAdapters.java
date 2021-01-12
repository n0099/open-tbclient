package com.google.gson.internal.bind;

import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.a.c;
import com.google.gson.internal.LazilyParsedNumber;
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
/* loaded from: classes4.dex */
public final class TypeAdapters {
    public static final TypeAdapter<Class> pJy = new TypeAdapter<Class>() { // from class: com.google.gson.internal.bind.TypeAdapters.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, Class cls) throws IOException {
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: f */
        public Class read(com.google.gson.stream.a aVar) throws IOException {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }
    }.nullSafe();
    public static final TypeAdapterFactory pJz = a(Class.class, pJy);
    public static final TypeAdapter<BitSet> pJA = new TypeAdapter<BitSet>() { // from class: com.google.gson.internal.bind.TypeAdapters.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: m */
        public BitSet read(com.google.gson.stream.a aVar) throws IOException {
            boolean z;
            BitSet bitSet = new BitSet();
            aVar.eyV();
            JsonToken eyX = aVar.eyX();
            int i = 0;
            while (eyX != JsonToken.END_ARRAY) {
                switch (AnonymousClass36.pJc[eyX.ordinal()]) {
                    case 1:
                        if (aVar.ezg() == 0) {
                            z = false;
                            break;
                        } else {
                            z = true;
                            break;
                        }
                    case 2:
                        z = aVar.ezc();
                        break;
                    case 3:
                        String ezb = aVar.ezb();
                        try {
                            if (Integer.parseInt(ezb) == 0) {
                                z = false;
                                break;
                            } else {
                                z = true;
                                break;
                            }
                        } catch (NumberFormatException e) {
                            throw new JsonSyntaxException("Error: Expecting: bitset number value (1, 0), Found: " + ezb);
                        }
                    default:
                        throw new JsonSyntaxException("Invalid bitset value type: " + eyX);
                }
                if (z) {
                    bitSet.set(i);
                }
                i++;
                eyX = aVar.eyX();
            }
            aVar.endArray();
            return bitSet;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, BitSet bitSet) throws IOException {
            bVar.ezm();
            int length = bitSet.length();
            for (int i = 0; i < length; i++) {
                bVar.iQ(bitSet.get(i) ? 1 : 0);
            }
            bVar.ezn();
        }
    }.nullSafe();
    public static final TypeAdapterFactory pJB = a(BitSet.class, pJA);
    public static final TypeAdapter<Boolean> pJC = new TypeAdapter<Boolean>() { // from class: com.google.gson.internal.bind.TypeAdapters.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: x */
        public Boolean read(com.google.gson.stream.a aVar) throws IOException {
            JsonToken eyX = aVar.eyX();
            if (eyX == JsonToken.NULL) {
                aVar.ezd();
                return null;
            } else if (eyX == JsonToken.STRING) {
                return Boolean.valueOf(Boolean.parseBoolean(aVar.ezb()));
            } else {
                return Boolean.valueOf(aVar.ezc());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, Boolean bool) throws IOException {
            bVar.w(bool);
        }
    };
    public static final TypeAdapter<Boolean> pJD = new TypeAdapter<Boolean>() { // from class: com.google.gson.internal.bind.TypeAdapters.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: x */
        public Boolean read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.eyX() == JsonToken.NULL) {
                aVar.ezd();
                return null;
            }
            return Boolean.valueOf(aVar.ezb());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, Boolean bool) throws IOException {
            bVar.YJ(bool == null ? "null" : bool.toString());
        }
    };
    public static final TypeAdapterFactory pJE = a(Boolean.TYPE, Boolean.class, pJC);
    public static final TypeAdapter<Number> pJF = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.5
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.eyX() == JsonToken.NULL) {
                aVar.ezd();
                return null;
            }
            try {
                return Byte.valueOf((byte) aVar.ezg());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.b bVar, Number number) throws IOException {
            bVar.b(number);
        }
    };
    public static final TypeAdapterFactory pJG = a(Byte.TYPE, Byte.class, pJF);
    public static final TypeAdapter<Number> pJH = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.6
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.eyX() == JsonToken.NULL) {
                aVar.ezd();
                return null;
            }
            try {
                return Short.valueOf((short) aVar.ezg());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.b bVar, Number number) throws IOException {
            bVar.b(number);
        }
    };
    public static final TypeAdapterFactory pJI = a(Short.TYPE, Short.class, pJH);
    public static final TypeAdapter<Number> pJJ = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.7
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.eyX() == JsonToken.NULL) {
                aVar.ezd();
                return null;
            }
            try {
                return Integer.valueOf(aVar.ezg());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.b bVar, Number number) throws IOException {
            bVar.b(number);
        }
    };
    public static final TypeAdapterFactory pJK = a(Integer.TYPE, Integer.class, pJJ);
    public static final TypeAdapter<AtomicInteger> pJL = new TypeAdapter<AtomicInteger>() { // from class: com.google.gson.internal.bind.TypeAdapters.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: y */
        public AtomicInteger read(com.google.gson.stream.a aVar) throws IOException {
            try {
                return new AtomicInteger(aVar.ezg());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, AtomicInteger atomicInteger) throws IOException {
            bVar.iQ(atomicInteger.get());
        }
    }.nullSafe();
    public static final TypeAdapterFactory pJM = a(AtomicInteger.class, pJL);
    public static final TypeAdapter<AtomicBoolean> pJN = new TypeAdapter<AtomicBoolean>() { // from class: com.google.gson.internal.bind.TypeAdapters.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: z */
        public AtomicBoolean read(com.google.gson.stream.a aVar) throws IOException {
            return new AtomicBoolean(aVar.ezc());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, AtomicBoolean atomicBoolean) throws IOException {
            bVar.Bg(atomicBoolean.get());
        }
    }.nullSafe();
    public static final TypeAdapterFactory pJO = a(AtomicBoolean.class, pJN);
    public static final TypeAdapter<AtomicIntegerArray> pJP = new TypeAdapter<AtomicIntegerArray>() { // from class: com.google.gson.internal.bind.TypeAdapters.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: g */
        public AtomicIntegerArray read(com.google.gson.stream.a aVar) throws IOException {
            ArrayList arrayList = new ArrayList();
            aVar.eyV();
            while (aVar.hasNext()) {
                try {
                    arrayList.add(Integer.valueOf(aVar.ezg()));
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
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, AtomicIntegerArray atomicIntegerArray) throws IOException {
            bVar.ezm();
            int length = atomicIntegerArray.length();
            for (int i = 0; i < length; i++) {
                bVar.iQ(atomicIntegerArray.get(i));
            }
            bVar.ezn();
        }
    }.nullSafe();
    public static final TypeAdapterFactory pJQ = a(AtomicIntegerArray.class, pJP);
    public static final TypeAdapter<Number> pJR = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.11
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.eyX() == JsonToken.NULL) {
                aVar.ezd();
                return null;
            }
            try {
                return Long.valueOf(aVar.ezf());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.b bVar, Number number) throws IOException {
            bVar.b(number);
        }
    };
    public static final TypeAdapter<Number> pJS = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.12
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.eyX() == JsonToken.NULL) {
                aVar.ezd();
                return null;
            }
            return Float.valueOf((float) aVar.eze());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.b bVar, Number number) throws IOException {
            bVar.b(number);
        }
    };
    public static final TypeAdapter<Number> pJT = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.13
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.eyX() == JsonToken.NULL) {
                aVar.ezd();
                return null;
            }
            return Double.valueOf(aVar.eze());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.b bVar, Number number) throws IOException {
            bVar.b(number);
        }
    };
    public static final TypeAdapter<Number> pJU = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.14
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            JsonToken eyX = aVar.eyX();
            switch (AnonymousClass36.pJc[eyX.ordinal()]) {
                case 1:
                case 3:
                    return new LazilyParsedNumber(aVar.ezb());
                case 2:
                default:
                    throw new JsonSyntaxException("Expecting number, got: " + eyX);
                case 4:
                    aVar.ezd();
                    return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.b bVar, Number number) throws IOException {
            bVar.b(number);
        }
    };
    public static final TypeAdapterFactory pJV = a(Number.class, pJU);
    public static final TypeAdapter<Character> pJW = new TypeAdapter<Character>() { // from class: com.google.gson.internal.bind.TypeAdapters.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: h */
        public Character read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.eyX() == JsonToken.NULL) {
                aVar.ezd();
                return null;
            }
            String ezb = aVar.ezb();
            if (ezb.length() != 1) {
                throw new JsonSyntaxException("Expecting character, got: " + ezb);
            }
            return Character.valueOf(ezb.charAt(0));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, Character ch) throws IOException {
            bVar.YJ(ch == null ? null : String.valueOf(ch));
        }
    };
    public static final TypeAdapterFactory pJX = a(Character.TYPE, Character.class, pJW);
    public static final TypeAdapter<String> pJY = new TypeAdapter<String>() { // from class: com.google.gson.internal.bind.TypeAdapters.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: i */
        public String read(com.google.gson.stream.a aVar) throws IOException {
            JsonToken eyX = aVar.eyX();
            if (eyX == JsonToken.NULL) {
                aVar.ezd();
                return null;
            } else if (eyX == JsonToken.BOOLEAN) {
                return Boolean.toString(aVar.ezc());
            } else {
                return aVar.ezb();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, String str) throws IOException {
            bVar.YJ(str);
        }
    };
    public static final TypeAdapter<BigDecimal> pJZ = new TypeAdapter<BigDecimal>() { // from class: com.google.gson.internal.bind.TypeAdapters.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: j */
        public BigDecimal read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.eyX() == JsonToken.NULL) {
                aVar.ezd();
                return null;
            }
            try {
                return new BigDecimal(aVar.ezb());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, BigDecimal bigDecimal) throws IOException {
            bVar.b(bigDecimal);
        }
    };
    public static final TypeAdapter<BigInteger> pKa = new TypeAdapter<BigInteger>() { // from class: com.google.gson.internal.bind.TypeAdapters.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: k */
        public BigInteger read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.eyX() == JsonToken.NULL) {
                aVar.ezd();
                return null;
            }
            try {
                return new BigInteger(aVar.ezb());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, BigInteger bigInteger) throws IOException {
            bVar.b(bigInteger);
        }
    };
    public static final TypeAdapterFactory pKb = a(String.class, pJY);
    public static final TypeAdapter<StringBuilder> pKc = new TypeAdapter<StringBuilder>() { // from class: com.google.gson.internal.bind.TypeAdapters.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: l */
        public StringBuilder read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.eyX() == JsonToken.NULL) {
                aVar.ezd();
                return null;
            }
            return new StringBuilder(aVar.ezb());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, StringBuilder sb) throws IOException {
            bVar.YJ(sb == null ? null : sb.toString());
        }
    };
    public static final TypeAdapterFactory pKd = a(StringBuilder.class, pKc);
    public static final TypeAdapter<StringBuffer> pKe = new TypeAdapter<StringBuffer>() { // from class: com.google.gson.internal.bind.TypeAdapters.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: n */
        public StringBuffer read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.eyX() == JsonToken.NULL) {
                aVar.ezd();
                return null;
            }
            return new StringBuffer(aVar.ezb());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, StringBuffer stringBuffer) throws IOException {
            bVar.YJ(stringBuffer == null ? null : stringBuffer.toString());
        }
    };
    public static final TypeAdapterFactory pKf = a(StringBuffer.class, pKe);
    public static final TypeAdapter<URL> pKg = new TypeAdapter<URL>() { // from class: com.google.gson.internal.bind.TypeAdapters.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: o */
        public URL read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.eyX() == JsonToken.NULL) {
                aVar.ezd();
                return null;
            }
            String ezb = aVar.ezb();
            if ("null".equals(ezb)) {
                return null;
            }
            return new URL(ezb);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, URL url) throws IOException {
            bVar.YJ(url == null ? null : url.toExternalForm());
        }
    };
    public static final TypeAdapterFactory pKh = a(URL.class, pKg);
    public static final TypeAdapter<URI> pKi = new TypeAdapter<URI>() { // from class: com.google.gson.internal.bind.TypeAdapters.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: p */
        public URI read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.eyX() == JsonToken.NULL) {
                aVar.ezd();
                return null;
            }
            try {
                String ezb = aVar.ezb();
                if ("null".equals(ezb)) {
                    return null;
                }
                return new URI(ezb);
            } catch (URISyntaxException e) {
                throw new JsonIOException(e);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, URI uri) throws IOException {
            bVar.YJ(uri == null ? null : uri.toASCIIString());
        }
    };
    public static final TypeAdapterFactory pKj = a(URI.class, pKi);
    public static final TypeAdapter<InetAddress> pKk = new TypeAdapter<InetAddress>() { // from class: com.google.gson.internal.bind.TypeAdapters.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: q */
        public InetAddress read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.eyX() == JsonToken.NULL) {
                aVar.ezd();
                return null;
            }
            return InetAddress.getByName(aVar.ezb());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, InetAddress inetAddress) throws IOException {
            bVar.YJ(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    };
    public static final TypeAdapterFactory pKl = b(InetAddress.class, pKk);
    public static final TypeAdapter<UUID> pKm = new TypeAdapter<UUID>() { // from class: com.google.gson.internal.bind.TypeAdapters.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: r */
        public UUID read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.eyX() == JsonToken.NULL) {
                aVar.ezd();
                return null;
            }
            return UUID.fromString(aVar.ezb());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, UUID uuid) throws IOException {
            bVar.YJ(uuid == null ? null : uuid.toString());
        }
    };
    public static final TypeAdapterFactory pKn = a(UUID.class, pKm);
    public static final TypeAdapter<Currency> pKo = new TypeAdapter<Currency>() { // from class: com.google.gson.internal.bind.TypeAdapters.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: s */
        public Currency read(com.google.gson.stream.a aVar) throws IOException {
            return Currency.getInstance(aVar.ezb());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, Currency currency) throws IOException {
            bVar.YJ(currency.getCurrencyCode());
        }
    }.nullSafe();
    public static final TypeAdapterFactory pKp = a(Currency.class, pKo);
    public static final TypeAdapterFactory pKq = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.26
        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            if (aVar.ezu() != Timestamp.class) {
                return null;
            }
            final TypeAdapter<T> adapter = gson.getAdapter(Date.class);
            return (TypeAdapter<T>) new TypeAdapter<Timestamp>() { // from class: com.google.gson.internal.bind.TypeAdapters.26.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.gson.TypeAdapter
                /* renamed from: t */
                public Timestamp read(com.google.gson.stream.a aVar2) throws IOException {
                    Date date = (Date) adapter.read(aVar2);
                    if (date != null) {
                        return new Timestamp(date.getTime());
                    }
                    return null;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.gson.TypeAdapter
                /* renamed from: a */
                public void write(com.google.gson.stream.b bVar, Timestamp timestamp) throws IOException {
                    adapter.write(bVar, timestamp);
                }
            };
        }
    };
    public static final TypeAdapter<Calendar> pKr = new TypeAdapter<Calendar>() { // from class: com.google.gson.internal.bind.TypeAdapters.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: u */
        public Calendar read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.eyX() == JsonToken.NULL) {
                aVar.ezd();
                return null;
            }
            aVar.eyW();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (aVar.eyX() != JsonToken.END_OBJECT) {
                String eza = aVar.eza();
                int ezg = aVar.ezg();
                if ("year".equals(eza)) {
                    i6 = ezg;
                } else if ("month".equals(eza)) {
                    i5 = ezg;
                } else if ("dayOfMonth".equals(eza)) {
                    i4 = ezg;
                } else if ("hourOfDay".equals(eza)) {
                    i3 = ezg;
                } else if ("minute".equals(eza)) {
                    i2 = ezg;
                } else if ("second".equals(eza)) {
                    i = ezg;
                }
            }
            aVar.endObject();
            return new GregorianCalendar(i6, i5, i4, i3, i2, i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, Calendar calendar) throws IOException {
            if (calendar == null) {
                bVar.ezq();
                return;
            }
            bVar.ezo();
            bVar.YI("year");
            bVar.iQ(calendar.get(1));
            bVar.YI("month");
            bVar.iQ(calendar.get(2));
            bVar.YI("dayOfMonth");
            bVar.iQ(calendar.get(5));
            bVar.YI("hourOfDay");
            bVar.iQ(calendar.get(11));
            bVar.YI("minute");
            bVar.iQ(calendar.get(12));
            bVar.YI("second");
            bVar.iQ(calendar.get(13));
            bVar.ezp();
        }
    };
    public static final TypeAdapterFactory pKs = b(Calendar.class, GregorianCalendar.class, pKr);
    public static final TypeAdapter<Locale> pKt = new TypeAdapter<Locale>() { // from class: com.google.gson.internal.bind.TypeAdapters.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: v */
        public Locale read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.eyX() == JsonToken.NULL) {
                aVar.ezd();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(aVar.ezb(), PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
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
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, Locale locale) throws IOException {
            bVar.YJ(locale == null ? null : locale.toString());
        }
    };
    public static final TypeAdapterFactory pKu = a(Locale.class, pKt);
    public static final TypeAdapter<JsonElement> pKv = new TypeAdapter<JsonElement>() { // from class: com.google.gson.internal.bind.TypeAdapters.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: w */
        public JsonElement read(com.google.gson.stream.a aVar) throws IOException {
            switch (AnonymousClass36.pJc[aVar.eyX().ordinal()]) {
                case 1:
                    return new JsonPrimitive((Number) new LazilyParsedNumber(aVar.ezb()));
                case 2:
                    return new JsonPrimitive(Boolean.valueOf(aVar.ezc()));
                case 3:
                    return new JsonPrimitive(aVar.ezb());
                case 4:
                    aVar.ezd();
                    return JsonNull.INSTANCE;
                case 5:
                    JsonArray jsonArray = new JsonArray();
                    aVar.eyV();
                    while (aVar.hasNext()) {
                        jsonArray.add(read(aVar));
                    }
                    aVar.endArray();
                    return jsonArray;
                case 6:
                    JsonObject jsonObject = new JsonObject();
                    aVar.eyW();
                    while (aVar.hasNext()) {
                        jsonObject.add(aVar.eza(), read(aVar));
                    }
                    aVar.endObject();
                    return jsonObject;
                default:
                    throw new IllegalArgumentException();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, JsonElement jsonElement) throws IOException {
            if (jsonElement == null || jsonElement.isJsonNull()) {
                bVar.ezq();
            } else if (jsonElement.isJsonPrimitive()) {
                JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
                if (asJsonPrimitive.isNumber()) {
                    bVar.b(asJsonPrimitive.getAsNumber());
                } else if (asJsonPrimitive.isBoolean()) {
                    bVar.Bg(asJsonPrimitive.getAsBoolean());
                } else {
                    bVar.YJ(asJsonPrimitive.getAsString());
                }
            } else if (jsonElement.isJsonArray()) {
                bVar.ezm();
                Iterator<JsonElement> it = jsonElement.getAsJsonArray().iterator();
                while (it.hasNext()) {
                    write(bVar, it.next());
                }
                bVar.ezn();
            } else if (jsonElement.isJsonObject()) {
                bVar.ezo();
                for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
                    bVar.YI(entry.getKey());
                    write(bVar, entry.getValue());
                }
                bVar.ezp();
            } else {
                throw new IllegalArgumentException("Couldn't write " + jsonElement.getClass());
            }
        }
    };
    public static final TypeAdapterFactory pKw = b(JsonElement.class, pKv);
    public static final TypeAdapterFactory pKx = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.30
        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            Class ezu = aVar.ezu();
            if (!Enum.class.isAssignableFrom(ezu) || ezu == Enum.class) {
                return null;
            }
            if (!ezu.isEnum()) {
                ezu = (Class<? super Object>) ezu.getSuperclass();
            }
            return new EnumTypeAdapter(ezu);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.gson.internal.bind.TypeAdapters$36  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass36 {
        static final /* synthetic */ int[] pJc = new int[JsonToken.values().length];

        static {
            try {
                pJc[JsonToken.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                pJc[JsonToken.BOOLEAN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                pJc[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                pJc[JsonToken.NULL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                pJc[JsonToken.BEGIN_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                pJc[JsonToken.BEGIN_OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                pJc[JsonToken.END_DOCUMENT.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                pJc[JsonToken.NAME.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                pJc[JsonToken.END_OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                pJc[JsonToken.END_ARRAY.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
        }
    }

    /* loaded from: classes4.dex */
    private static final class EnumTypeAdapter<T extends Enum<T>> extends TypeAdapter<T> {
        private final Map<String, T> pKI = new HashMap();
        private final Map<T, String> pKJ = new HashMap();

        public EnumTypeAdapter(Class<T> cls) {
            T[] enumConstants;
            try {
                for (T t : cls.getEnumConstants()) {
                    String name = t.name();
                    c cVar = (c) cls.getField(name).getAnnotation(c.class);
                    if (cVar != null) {
                        name = cVar.value();
                        String[] eyC = cVar.eyC();
                        for (String str : eyC) {
                            this.pKI.put(str, t);
                        }
                    }
                    String str2 = name;
                    this.pKI.put(str2, t);
                    this.pKJ.put(t, str2);
                }
            } catch (NoSuchFieldException e) {
                throw new AssertionError(e);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: A */
        public T read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.eyX() == JsonToken.NULL) {
                aVar.ezd();
                return null;
            }
            return this.pKI.get(aVar.ezb());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, T t) throws IOException {
            bVar.YJ(t == null ? null : this.pKJ.get(t));
        }
    }

    public static <TT> TypeAdapterFactory a(final com.google.gson.b.a<TT> aVar, final TypeAdapter<TT> typeAdapter) {
        return new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.31
            @Override // com.google.gson.TypeAdapterFactory
            public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar2) {
                if (aVar2.equals(com.google.gson.b.a.this)) {
                    return typeAdapter;
                }
                return null;
            }
        };
    }

    public static <TT> TypeAdapterFactory a(final Class<TT> cls, final TypeAdapter<TT> typeAdapter) {
        return new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.32
            @Override // com.google.gson.TypeAdapterFactory
            public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
                if (aVar.ezu() == cls) {
                    return typeAdapter;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    public static <TT> TypeAdapterFactory a(final Class<TT> cls, final Class<TT> cls2, final TypeAdapter<? super TT> typeAdapter) {
        return new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.33
            @Override // com.google.gson.TypeAdapterFactory
            public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
                Class<? super T> ezu = aVar.ezu();
                if (ezu == cls || ezu == cls2) {
                    return typeAdapter;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls2.getName() + "+" + cls.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    public static <TT> TypeAdapterFactory b(final Class<TT> cls, final Class<? extends TT> cls2, final TypeAdapter<? super TT> typeAdapter) {
        return new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.34
            @Override // com.google.gson.TypeAdapterFactory
            public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
                Class<? super T> ezu = aVar.ezu();
                if (ezu == cls || ezu == cls2) {
                    return typeAdapter;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + "+" + cls2.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    public static <T1> TypeAdapterFactory b(final Class<T1> cls, final TypeAdapter<T1> typeAdapter) {
        return new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.35
            @Override // com.google.gson.TypeAdapterFactory
            public <T2> TypeAdapter<T2> create(Gson gson, com.google.gson.b.a<T2> aVar) {
                final Class<? super T2> ezu = aVar.ezu();
                if (cls.isAssignableFrom(ezu)) {
                    return (TypeAdapter<T2>) new TypeAdapter<T1>() { // from class: com.google.gson.internal.bind.TypeAdapters.35.1
                        @Override // com.google.gson.TypeAdapter
                        public void write(com.google.gson.stream.b bVar, T1 t1) throws IOException {
                            typeAdapter.write(bVar, t1);
                        }

                        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Class */
                        /* JADX WARN: Multi-variable type inference failed */
                        /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, T1] */
                        @Override // com.google.gson.TypeAdapter
                        public T1 read(com.google.gson.stream.a aVar2) throws IOException {
                            ?? read = typeAdapter.read(aVar2);
                            if (read != 0 && !ezu.isInstance(read)) {
                                throw new JsonSyntaxException("Expected a " + ezu.getName() + " but was " + read.getClass().getName());
                            }
                            return read;
                        }
                    };
                }
                return null;
            }

            public String toString() {
                return "Factory[typeHierarchy=" + cls.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }
}
