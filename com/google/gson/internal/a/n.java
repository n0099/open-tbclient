package com.google.gson.internal.a;

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
/* loaded from: classes7.dex */
public final class n {
    public static final TypeAdapter<Class> nbH = new TypeAdapter<Class>() { // from class: com.google.gson.internal.a.n.1
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
    public static final TypeAdapterFactory nbI = a(Class.class, nbH);
    public static final TypeAdapter<BitSet> nbJ = new TypeAdapter<BitSet>() { // from class: com.google.gson.internal.a.n.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: m */
        public BitSet read(com.google.gson.stream.a aVar) throws IOException {
            boolean z;
            BitSet bitSet = new BitSet();
            aVar.dHM();
            JsonToken dHO = aVar.dHO();
            int i = 0;
            while (dHO != JsonToken.END_ARRAY) {
                switch (AnonymousClass30.nbl[dHO.ordinal()]) {
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
                        String dHS = aVar.dHS();
                        try {
                            if (Integer.parseInt(dHS) == 0) {
                                z = false;
                                break;
                            } else {
                                z = true;
                                break;
                            }
                        } catch (NumberFormatException e) {
                            throw new JsonSyntaxException("Error: Expecting: bitset number value (1, 0), Found: " + dHS);
                        }
                    default:
                        throw new JsonSyntaxException("Invalid bitset value type: " + dHO);
                }
                if (z) {
                    bitSet.set(i);
                }
                i++;
                dHO = aVar.dHO();
            }
            aVar.endArray();
            return bitSet;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, BitSet bitSet) throws IOException {
            bVar.dHZ();
            int length = bitSet.length();
            for (int i = 0; i < length; i++) {
                bVar.fZ(bitSet.get(i) ? 1 : 0);
            }
            bVar.dIa();
        }
    }.nullSafe();
    public static final TypeAdapterFactory nbK = a(BitSet.class, nbJ);
    public static final TypeAdapter<Boolean> nbL = new TypeAdapter<Boolean>() { // from class: com.google.gson.internal.a.n.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: x */
        public Boolean read(com.google.gson.stream.a aVar) throws IOException {
            JsonToken dHO = aVar.dHO();
            if (dHO == JsonToken.NULL) {
                aVar.dHT();
                return null;
            } else if (dHO == JsonToken.STRING) {
                return Boolean.valueOf(Boolean.parseBoolean(aVar.dHS()));
            } else {
                return Boolean.valueOf(aVar.nextBoolean());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, Boolean bool) throws IOException {
            bVar.p(bool);
        }
    };
    public static final TypeAdapter<Boolean> nbM = new TypeAdapter<Boolean>() { // from class: com.google.gson.internal.a.n.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: x */
        public Boolean read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.dHO() == JsonToken.NULL) {
                aVar.dHT();
                return null;
            }
            return Boolean.valueOf(aVar.dHS());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, Boolean bool) throws IOException {
            bVar.Rc(bool == null ? "null" : bool.toString());
        }
    };
    public static final TypeAdapterFactory nbN = a(Boolean.TYPE, Boolean.class, nbL);
    public static final TypeAdapter<Number> nbO = new TypeAdapter<Number>() { // from class: com.google.gson.internal.a.n.32
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.dHO() == JsonToken.NULL) {
                aVar.dHT();
                return null;
            }
            try {
                return Byte.valueOf((byte) aVar.nextInt());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.b bVar, Number number) throws IOException {
            bVar.a(number);
        }
    };
    public static final TypeAdapterFactory nbP = a(Byte.TYPE, Byte.class, nbO);
    public static final TypeAdapter<Number> nbQ = new TypeAdapter<Number>() { // from class: com.google.gson.internal.a.n.33
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.dHO() == JsonToken.NULL) {
                aVar.dHT();
                return null;
            }
            try {
                return Short.valueOf((short) aVar.nextInt());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.b bVar, Number number) throws IOException {
            bVar.a(number);
        }
    };
    public static final TypeAdapterFactory nbR = a(Short.TYPE, Short.class, nbQ);
    public static final TypeAdapter<Number> nbS = new TypeAdapter<Number>() { // from class: com.google.gson.internal.a.n.34
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.dHO() == JsonToken.NULL) {
                aVar.dHT();
                return null;
            }
            try {
                return Integer.valueOf(aVar.nextInt());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.b bVar, Number number) throws IOException {
            bVar.a(number);
        }
    };
    public static final TypeAdapterFactory nbT = a(Integer.TYPE, Integer.class, nbS);
    public static final TypeAdapter<AtomicInteger> nbU = new TypeAdapter<AtomicInteger>() { // from class: com.google.gson.internal.a.n.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: y */
        public AtomicInteger read(com.google.gson.stream.a aVar) throws IOException {
            try {
                return new AtomicInteger(aVar.nextInt());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, AtomicInteger atomicInteger) throws IOException {
            bVar.fZ(atomicInteger.get());
        }
    }.nullSafe();
    public static final TypeAdapterFactory nbV = a(AtomicInteger.class, nbU);
    public static final TypeAdapter<AtomicBoolean> nbW = new TypeAdapter<AtomicBoolean>() { // from class: com.google.gson.internal.a.n.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: z */
        public AtomicBoolean read(com.google.gson.stream.a aVar) throws IOException {
            return new AtomicBoolean(aVar.nextBoolean());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, AtomicBoolean atomicBoolean) throws IOException {
            bVar.wR(atomicBoolean.get());
        }
    }.nullSafe();
    public static final TypeAdapterFactory nbX = a(AtomicBoolean.class, nbW);
    public static final TypeAdapter<AtomicIntegerArray> nbY = new TypeAdapter<AtomicIntegerArray>() { // from class: com.google.gson.internal.a.n.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: g */
        public AtomicIntegerArray read(com.google.gson.stream.a aVar) throws IOException {
            ArrayList arrayList = new ArrayList();
            aVar.dHM();
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
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, AtomicIntegerArray atomicIntegerArray) throws IOException {
            bVar.dHZ();
            int length = atomicIntegerArray.length();
            for (int i = 0; i < length; i++) {
                bVar.fZ(atomicIntegerArray.get(i));
            }
            bVar.dIa();
        }
    }.nullSafe();
    public static final TypeAdapterFactory nbZ = a(AtomicIntegerArray.class, nbY);
    public static final TypeAdapter<Number> nca = new TypeAdapter<Number>() { // from class: com.google.gson.internal.a.n.3
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.dHO() == JsonToken.NULL) {
                aVar.dHT();
                return null;
            }
            try {
                return Long.valueOf(aVar.nextLong());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.b bVar, Number number) throws IOException {
            bVar.a(number);
        }
    };
    public static final TypeAdapter<Number> ncb = new TypeAdapter<Number>() { // from class: com.google.gson.internal.a.n.4
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.dHO() == JsonToken.NULL) {
                aVar.dHT();
                return null;
            }
            return Float.valueOf((float) aVar.nextDouble());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.b bVar, Number number) throws IOException {
            bVar.a(number);
        }
    };
    public static final TypeAdapter<Number> ncc = new TypeAdapter<Number>() { // from class: com.google.gson.internal.a.n.5
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.dHO() == JsonToken.NULL) {
                aVar.dHT();
                return null;
            }
            return Double.valueOf(aVar.nextDouble());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.b bVar, Number number) throws IOException {
            bVar.a(number);
        }
    };
    public static final TypeAdapter<Number> ncd = new TypeAdapter<Number>() { // from class: com.google.gson.internal.a.n.6
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            JsonToken dHO = aVar.dHO();
            switch (dHO) {
                case NUMBER:
                case STRING:
                    return new LazilyParsedNumber(aVar.dHS());
                case BOOLEAN:
                default:
                    throw new JsonSyntaxException("Expecting number, got: " + dHO);
                case NULL:
                    aVar.dHT();
                    return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.b bVar, Number number) throws IOException {
            bVar.a(number);
        }
    };
    public static final TypeAdapterFactory nce = a(Number.class, ncd);
    public static final TypeAdapter<Character> ncf = new TypeAdapter<Character>() { // from class: com.google.gson.internal.a.n.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: h */
        public Character read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.dHO() == JsonToken.NULL) {
                aVar.dHT();
                return null;
            }
            String dHS = aVar.dHS();
            if (dHS.length() != 1) {
                throw new JsonSyntaxException("Expecting character, got: " + dHS);
            }
            return Character.valueOf(dHS.charAt(0));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, Character ch) throws IOException {
            bVar.Rc(ch == null ? null : String.valueOf(ch));
        }
    };
    public static final TypeAdapterFactory ncg = a(Character.TYPE, Character.class, ncf);
    public static final TypeAdapter<String> nch = new TypeAdapter<String>() { // from class: com.google.gson.internal.a.n.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: i */
        public String read(com.google.gson.stream.a aVar) throws IOException {
            JsonToken dHO = aVar.dHO();
            if (dHO == JsonToken.NULL) {
                aVar.dHT();
                return null;
            } else if (dHO == JsonToken.BOOLEAN) {
                return Boolean.toString(aVar.nextBoolean());
            } else {
                return aVar.dHS();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, String str) throws IOException {
            bVar.Rc(str);
        }
    };
    public static final TypeAdapter<BigDecimal> nci = new TypeAdapter<BigDecimal>() { // from class: com.google.gson.internal.a.n.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: j */
        public BigDecimal read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.dHO() == JsonToken.NULL) {
                aVar.dHT();
                return null;
            }
            try {
                return new BigDecimal(aVar.dHS());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, BigDecimal bigDecimal) throws IOException {
            bVar.a(bigDecimal);
        }
    };
    public static final TypeAdapter<BigInteger> ncj = new TypeAdapter<BigInteger>() { // from class: com.google.gson.internal.a.n.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: k */
        public BigInteger read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.dHO() == JsonToken.NULL) {
                aVar.dHT();
                return null;
            }
            try {
                return new BigInteger(aVar.dHS());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, BigInteger bigInteger) throws IOException {
            bVar.a(bigInteger);
        }
    };
    public static final TypeAdapterFactory nck = a(String.class, nch);
    public static final TypeAdapter<StringBuilder> ncl = new TypeAdapter<StringBuilder>() { // from class: com.google.gson.internal.a.n.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: l */
        public StringBuilder read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.dHO() == JsonToken.NULL) {
                aVar.dHT();
                return null;
            }
            return new StringBuilder(aVar.dHS());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, StringBuilder sb) throws IOException {
            bVar.Rc(sb == null ? null : sb.toString());
        }
    };
    public static final TypeAdapterFactory ncm = a(StringBuilder.class, ncl);
    public static final TypeAdapter<StringBuffer> ncn = new TypeAdapter<StringBuffer>() { // from class: com.google.gson.internal.a.n.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: n */
        public StringBuffer read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.dHO() == JsonToken.NULL) {
                aVar.dHT();
                return null;
            }
            return new StringBuffer(aVar.dHS());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, StringBuffer stringBuffer) throws IOException {
            bVar.Rc(stringBuffer == null ? null : stringBuffer.toString());
        }
    };
    public static final TypeAdapterFactory nco = a(StringBuffer.class, ncn);
    public static final TypeAdapter<URL> ncp = new TypeAdapter<URL>() { // from class: com.google.gson.internal.a.n.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: o */
        public URL read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.dHO() == JsonToken.NULL) {
                aVar.dHT();
                return null;
            }
            String dHS = aVar.dHS();
            if ("null".equals(dHS)) {
                return null;
            }
            return new URL(dHS);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, URL url) throws IOException {
            bVar.Rc(url == null ? null : url.toExternalForm());
        }
    };
    public static final TypeAdapterFactory ncq = a(URL.class, ncp);
    public static final TypeAdapter<URI> ncr = new TypeAdapter<URI>() { // from class: com.google.gson.internal.a.n.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: p */
        public URI read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.dHO() == JsonToken.NULL) {
                aVar.dHT();
                return null;
            }
            try {
                String dHS = aVar.dHS();
                if ("null".equals(dHS)) {
                    return null;
                }
                return new URI(dHS);
            } catch (URISyntaxException e) {
                throw new JsonIOException(e);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, URI uri) throws IOException {
            bVar.Rc(uri == null ? null : uri.toASCIIString());
        }
    };
    public static final TypeAdapterFactory ncs = a(URI.class, ncr);
    public static final TypeAdapter<InetAddress> nct = new TypeAdapter<InetAddress>() { // from class: com.google.gson.internal.a.n.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: q */
        public InetAddress read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.dHO() == JsonToken.NULL) {
                aVar.dHT();
                return null;
            }
            return InetAddress.getByName(aVar.dHS());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, InetAddress inetAddress) throws IOException {
            bVar.Rc(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    };
    public static final TypeAdapterFactory ncu = b(InetAddress.class, nct);
    public static final TypeAdapter<UUID> ncv = new TypeAdapter<UUID>() { // from class: com.google.gson.internal.a.n.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: r */
        public UUID read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.dHO() == JsonToken.NULL) {
                aVar.dHT();
                return null;
            }
            return UUID.fromString(aVar.dHS());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, UUID uuid) throws IOException {
            bVar.Rc(uuid == null ? null : uuid.toString());
        }
    };
    public static final TypeAdapterFactory ncw = a(UUID.class, ncv);
    public static final TypeAdapter<Currency> ncx = new TypeAdapter<Currency>() { // from class: com.google.gson.internal.a.n.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: s */
        public Currency read(com.google.gson.stream.a aVar) throws IOException {
            return Currency.getInstance(aVar.dHS());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, Currency currency) throws IOException {
            bVar.Rc(currency.getCurrencyCode());
        }
    }.nullSafe();
    public static final TypeAdapterFactory ncy = a(Currency.class, ncx);
    public static final TypeAdapterFactory ncz = new TypeAdapterFactory() { // from class: com.google.gson.internal.a.n.19
        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            if (aVar.dIh() != Timestamp.class) {
                return null;
            }
            final TypeAdapter<T> adapter = gson.getAdapter(Date.class);
            return (TypeAdapter<T>) new TypeAdapter<Timestamp>() { // from class: com.google.gson.internal.a.n.19.1
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
    public static final TypeAdapter<Calendar> ncA = new TypeAdapter<Calendar>() { // from class: com.google.gson.internal.a.n.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: u */
        public Calendar read(com.google.gson.stream.a aVar) throws IOException {
            int i = 0;
            if (aVar.dHO() == JsonToken.NULL) {
                aVar.dHT();
                return null;
            }
            aVar.dHN();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (aVar.dHO() != JsonToken.END_OBJECT) {
                String dHR = aVar.dHR();
                int nextInt = aVar.nextInt();
                if ("year".equals(dHR)) {
                    i6 = nextInt;
                } else if ("month".equals(dHR)) {
                    i5 = nextInt;
                } else if ("dayOfMonth".equals(dHR)) {
                    i4 = nextInt;
                } else if ("hourOfDay".equals(dHR)) {
                    i3 = nextInt;
                } else if ("minute".equals(dHR)) {
                    i2 = nextInt;
                } else if ("second".equals(dHR)) {
                    i = nextInt;
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
                bVar.dId();
                return;
            }
            bVar.dIb();
            bVar.Rb("year");
            bVar.fZ(calendar.get(1));
            bVar.Rb("month");
            bVar.fZ(calendar.get(2));
            bVar.Rb("dayOfMonth");
            bVar.fZ(calendar.get(5));
            bVar.Rb("hourOfDay");
            bVar.fZ(calendar.get(11));
            bVar.Rb("minute");
            bVar.fZ(calendar.get(12));
            bVar.Rb("second");
            bVar.fZ(calendar.get(13));
            bVar.dIc();
        }
    };
    public static final TypeAdapterFactory ncB = b(Calendar.class, GregorianCalendar.class, ncA);
    public static final TypeAdapter<Locale> ncC = new TypeAdapter<Locale>() { // from class: com.google.gson.internal.a.n.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: v */
        public Locale read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.dHO() == JsonToken.NULL) {
                aVar.dHT();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(aVar.dHS(), PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
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
            bVar.Rc(locale == null ? null : locale.toString());
        }
    };
    public static final TypeAdapterFactory ncD = a(Locale.class, ncC);
    public static final TypeAdapter<JsonElement> ncE = new TypeAdapter<JsonElement>() { // from class: com.google.gson.internal.a.n.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: w */
        public JsonElement read(com.google.gson.stream.a aVar) throws IOException {
            switch (AnonymousClass30.nbl[aVar.dHO().ordinal()]) {
                case 1:
                    return new JsonPrimitive((Number) new LazilyParsedNumber(aVar.dHS()));
                case 2:
                    return new JsonPrimitive(Boolean.valueOf(aVar.nextBoolean()));
                case 3:
                    return new JsonPrimitive(aVar.dHS());
                case 4:
                    aVar.dHT();
                    return JsonNull.INSTANCE;
                case 5:
                    JsonArray jsonArray = new JsonArray();
                    aVar.dHM();
                    while (aVar.hasNext()) {
                        jsonArray.add(read(aVar));
                    }
                    aVar.endArray();
                    return jsonArray;
                case 6:
                    JsonObject jsonObject = new JsonObject();
                    aVar.dHN();
                    while (aVar.hasNext()) {
                        jsonObject.add(aVar.dHR(), read(aVar));
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
                bVar.dId();
            } else if (jsonElement.isJsonPrimitive()) {
                JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
                if (asJsonPrimitive.isNumber()) {
                    bVar.a(asJsonPrimitive.getAsNumber());
                } else if (asJsonPrimitive.isBoolean()) {
                    bVar.wR(asJsonPrimitive.getAsBoolean());
                } else {
                    bVar.Rc(asJsonPrimitive.getAsString());
                }
            } else if (jsonElement.isJsonArray()) {
                bVar.dHZ();
                Iterator<JsonElement> it = jsonElement.getAsJsonArray().iterator();
                while (it.hasNext()) {
                    write(bVar, it.next());
                }
                bVar.dIa();
            } else if (jsonElement.isJsonObject()) {
                bVar.dIb();
                for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
                    bVar.Rb(entry.getKey());
                    write(bVar, entry.getValue());
                }
                bVar.dIc();
            } else {
                throw new IllegalArgumentException("Couldn't write " + jsonElement.getClass());
            }
        }
    };
    public static final TypeAdapterFactory ncF = b(JsonElement.class, ncE);
    public static final TypeAdapterFactory ncG = new TypeAdapterFactory() { // from class: com.google.gson.internal.a.n.24
        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            Class dIh = aVar.dIh();
            if (!Enum.class.isAssignableFrom(dIh) || dIh == Enum.class) {
                return null;
            }
            if (!dIh.isEnum()) {
                dIh = (Class<? super Object>) dIh.getSuperclass();
            }
            return new a(dIh);
        }
    };

    /* loaded from: classes7.dex */
    private static final class a<T extends Enum<T>> extends TypeAdapter<T> {
        private final Map<String, T> ncR = new HashMap();
        private final Map<T, String> ncS = new HashMap();

        public a(Class<T> cls) {
            T[] enumConstants;
            try {
                for (T t : cls.getEnumConstants()) {
                    String name = t.name();
                    com.google.gson.a.c cVar = (com.google.gson.a.c) cls.getField(name).getAnnotation(com.google.gson.a.c.class);
                    if (cVar != null) {
                        name = cVar.value();
                        String[] dHu = cVar.dHu();
                        for (String str : dHu) {
                            this.ncR.put(str, t);
                        }
                    }
                    String str2 = name;
                    this.ncR.put(str2, t);
                    this.ncS.put(t, str2);
                }
            } catch (NoSuchFieldException e) {
                throw new AssertionError(e);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: A */
        public T read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.dHO() == JsonToken.NULL) {
                aVar.dHT();
                return null;
            }
            return this.ncR.get(aVar.dHS());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, T t) throws IOException {
            bVar.Rc(t == null ? null : this.ncS.get(t));
        }
    }

    public static <TT> TypeAdapterFactory a(final com.google.gson.b.a<TT> aVar, final TypeAdapter<TT> typeAdapter) {
        return new TypeAdapterFactory() { // from class: com.google.gson.internal.a.n.25
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
        return new TypeAdapterFactory() { // from class: com.google.gson.internal.a.n.26
            @Override // com.google.gson.TypeAdapterFactory
            public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
                if (aVar.dIh() == cls) {
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
        return new TypeAdapterFactory() { // from class: com.google.gson.internal.a.n.27
            @Override // com.google.gson.TypeAdapterFactory
            public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
                Class<? super T> dIh = aVar.dIh();
                if (dIh == cls || dIh == cls2) {
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
        return new TypeAdapterFactory() { // from class: com.google.gson.internal.a.n.28
            @Override // com.google.gson.TypeAdapterFactory
            public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
                Class<? super T> dIh = aVar.dIh();
                if (dIh == cls || dIh == cls2) {
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
        return new TypeAdapterFactory() { // from class: com.google.gson.internal.a.n.29
            @Override // com.google.gson.TypeAdapterFactory
            public <T2> TypeAdapter<T2> create(Gson gson, com.google.gson.b.a<T2> aVar) {
                final Class<? super T2> dIh = aVar.dIh();
                if (cls.isAssignableFrom(dIh)) {
                    return (TypeAdapter<T2>) new TypeAdapter<T1>() { // from class: com.google.gson.internal.a.n.29.1
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
                            if (read != 0 && !dIh.isInstance(read)) {
                                throw new JsonSyntaxException("Expected a " + dIh.getName() + " but was " + read.getClass().getName());
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
