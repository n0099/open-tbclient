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
/* loaded from: classes3.dex */
public final class n {
    public static final TypeAdapter<Class> nEn = new TypeAdapter<Class>() { // from class: com.google.gson.internal.a.n.1
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
    public static final TypeAdapterFactory nEo = a(Class.class, nEn);
    public static final TypeAdapter<BitSet> nEp = new TypeAdapter<BitSet>() { // from class: com.google.gson.internal.a.n.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: m */
        public BitSet read(com.google.gson.stream.a aVar) throws IOException {
            boolean z;
            BitSet bitSet = new BitSet();
            aVar.dXn();
            JsonToken dXp = aVar.dXp();
            int i = 0;
            while (dXp != JsonToken.END_ARRAY) {
                switch (AnonymousClass30.nDR[dXp.ordinal()]) {
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
                        String dXt = aVar.dXt();
                        try {
                            if (Integer.parseInt(dXt) == 0) {
                                z = false;
                                break;
                            } else {
                                z = true;
                                break;
                            }
                        } catch (NumberFormatException e) {
                            throw new JsonSyntaxException("Error: Expecting: bitset number value (1, 0), Found: " + dXt);
                        }
                    default:
                        throw new JsonSyntaxException("Invalid bitset value type: " + dXp);
                }
                if (z) {
                    bitSet.set(i);
                }
                i++;
                dXp = aVar.dXp();
            }
            aVar.endArray();
            return bitSet;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, BitSet bitSet) throws IOException {
            bVar.dXA();
            int length = bitSet.length();
            for (int i = 0; i < length; i++) {
                bVar.gz(bitSet.get(i) ? 1 : 0);
            }
            bVar.dXB();
        }
    }.nullSafe();
    public static final TypeAdapterFactory nEq = a(BitSet.class, nEp);
    public static final TypeAdapter<Boolean> nEr = new TypeAdapter<Boolean>() { // from class: com.google.gson.internal.a.n.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: x */
        public Boolean read(com.google.gson.stream.a aVar) throws IOException {
            JsonToken dXp = aVar.dXp();
            if (dXp == JsonToken.NULL) {
                aVar.dXu();
                return null;
            } else if (dXp == JsonToken.STRING) {
                return Boolean.valueOf(Boolean.parseBoolean(aVar.dXt()));
            } else {
                return Boolean.valueOf(aVar.nextBoolean());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, Boolean bool) throws IOException {
            bVar.t(bool);
        }
    };
    public static final TypeAdapter<Boolean> nEs = new TypeAdapter<Boolean>() { // from class: com.google.gson.internal.a.n.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: x */
        public Boolean read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.dXp() == JsonToken.NULL) {
                aVar.dXu();
                return null;
            }
            return Boolean.valueOf(aVar.dXt());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, Boolean bool) throws IOException {
            bVar.UT(bool == null ? "null" : bool.toString());
        }
    };
    public static final TypeAdapterFactory nEt = a(Boolean.TYPE, Boolean.class, nEr);
    public static final TypeAdapter<Number> nEu = new TypeAdapter<Number>() { // from class: com.google.gson.internal.a.n.32
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.dXp() == JsonToken.NULL) {
                aVar.dXu();
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
    public static final TypeAdapterFactory nEv = a(Byte.TYPE, Byte.class, nEu);
    public static final TypeAdapter<Number> nEw = new TypeAdapter<Number>() { // from class: com.google.gson.internal.a.n.33
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.dXp() == JsonToken.NULL) {
                aVar.dXu();
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
    public static final TypeAdapterFactory nEx = a(Short.TYPE, Short.class, nEw);
    public static final TypeAdapter<Number> nEy = new TypeAdapter<Number>() { // from class: com.google.gson.internal.a.n.34
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.dXp() == JsonToken.NULL) {
                aVar.dXu();
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
    public static final TypeAdapterFactory nEz = a(Integer.TYPE, Integer.class, nEy);
    public static final TypeAdapter<AtomicInteger> nEA = new TypeAdapter<AtomicInteger>() { // from class: com.google.gson.internal.a.n.35
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
            bVar.gz(atomicInteger.get());
        }
    }.nullSafe();
    public static final TypeAdapterFactory nEB = a(AtomicInteger.class, nEA);
    public static final TypeAdapter<AtomicBoolean> nEC = new TypeAdapter<AtomicBoolean>() { // from class: com.google.gson.internal.a.n.36
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
            bVar.yn(atomicBoolean.get());
        }
    }.nullSafe();
    public static final TypeAdapterFactory nED = a(AtomicBoolean.class, nEC);
    public static final TypeAdapter<AtomicIntegerArray> nEE = new TypeAdapter<AtomicIntegerArray>() { // from class: com.google.gson.internal.a.n.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: g */
        public AtomicIntegerArray read(com.google.gson.stream.a aVar) throws IOException {
            ArrayList arrayList = new ArrayList();
            aVar.dXn();
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
            bVar.dXA();
            int length = atomicIntegerArray.length();
            for (int i = 0; i < length; i++) {
                bVar.gz(atomicIntegerArray.get(i));
            }
            bVar.dXB();
        }
    }.nullSafe();
    public static final TypeAdapterFactory nEF = a(AtomicIntegerArray.class, nEE);
    public static final TypeAdapter<Number> nEG = new TypeAdapter<Number>() { // from class: com.google.gson.internal.a.n.3
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.dXp() == JsonToken.NULL) {
                aVar.dXu();
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
    public static final TypeAdapter<Number> nEH = new TypeAdapter<Number>() { // from class: com.google.gson.internal.a.n.4
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.dXp() == JsonToken.NULL) {
                aVar.dXu();
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
    public static final TypeAdapter<Number> nEI = new TypeAdapter<Number>() { // from class: com.google.gson.internal.a.n.5
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.dXp() == JsonToken.NULL) {
                aVar.dXu();
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
    public static final TypeAdapter<Number> nEJ = new TypeAdapter<Number>() { // from class: com.google.gson.internal.a.n.6
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            JsonToken dXp = aVar.dXp();
            switch (dXp) {
                case NUMBER:
                case STRING:
                    return new LazilyParsedNumber(aVar.dXt());
                case BOOLEAN:
                default:
                    throw new JsonSyntaxException("Expecting number, got: " + dXp);
                case NULL:
                    aVar.dXu();
                    return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.b bVar, Number number) throws IOException {
            bVar.a(number);
        }
    };
    public static final TypeAdapterFactory nEK = a(Number.class, nEJ);
    public static final TypeAdapter<Character> nEL = new TypeAdapter<Character>() { // from class: com.google.gson.internal.a.n.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: h */
        public Character read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.dXp() == JsonToken.NULL) {
                aVar.dXu();
                return null;
            }
            String dXt = aVar.dXt();
            if (dXt.length() != 1) {
                throw new JsonSyntaxException("Expecting character, got: " + dXt);
            }
            return Character.valueOf(dXt.charAt(0));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, Character ch) throws IOException {
            bVar.UT(ch == null ? null : String.valueOf(ch));
        }
    };
    public static final TypeAdapterFactory nEM = a(Character.TYPE, Character.class, nEL);
    public static final TypeAdapter<String> nEN = new TypeAdapter<String>() { // from class: com.google.gson.internal.a.n.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: i */
        public String read(com.google.gson.stream.a aVar) throws IOException {
            JsonToken dXp = aVar.dXp();
            if (dXp == JsonToken.NULL) {
                aVar.dXu();
                return null;
            } else if (dXp == JsonToken.BOOLEAN) {
                return Boolean.toString(aVar.nextBoolean());
            } else {
                return aVar.dXt();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, String str) throws IOException {
            bVar.UT(str);
        }
    };
    public static final TypeAdapter<BigDecimal> nEO = new TypeAdapter<BigDecimal>() { // from class: com.google.gson.internal.a.n.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: j */
        public BigDecimal read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.dXp() == JsonToken.NULL) {
                aVar.dXu();
                return null;
            }
            try {
                return new BigDecimal(aVar.dXt());
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
    public static final TypeAdapter<BigInteger> nEP = new TypeAdapter<BigInteger>() { // from class: com.google.gson.internal.a.n.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: k */
        public BigInteger read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.dXp() == JsonToken.NULL) {
                aVar.dXu();
                return null;
            }
            try {
                return new BigInteger(aVar.dXt());
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
    public static final TypeAdapterFactory nEQ = a(String.class, nEN);
    public static final TypeAdapter<StringBuilder> nER = new TypeAdapter<StringBuilder>() { // from class: com.google.gson.internal.a.n.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: l */
        public StringBuilder read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.dXp() == JsonToken.NULL) {
                aVar.dXu();
                return null;
            }
            return new StringBuilder(aVar.dXt());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, StringBuilder sb) throws IOException {
            bVar.UT(sb == null ? null : sb.toString());
        }
    };
    public static final TypeAdapterFactory nES = a(StringBuilder.class, nER);
    public static final TypeAdapter<StringBuffer> nET = new TypeAdapter<StringBuffer>() { // from class: com.google.gson.internal.a.n.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: n */
        public StringBuffer read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.dXp() == JsonToken.NULL) {
                aVar.dXu();
                return null;
            }
            return new StringBuffer(aVar.dXt());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, StringBuffer stringBuffer) throws IOException {
            bVar.UT(stringBuffer == null ? null : stringBuffer.toString());
        }
    };
    public static final TypeAdapterFactory nEU = a(StringBuffer.class, nET);
    public static final TypeAdapter<URL> nEV = new TypeAdapter<URL>() { // from class: com.google.gson.internal.a.n.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: o */
        public URL read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.dXp() == JsonToken.NULL) {
                aVar.dXu();
                return null;
            }
            String dXt = aVar.dXt();
            if ("null".equals(dXt)) {
                return null;
            }
            return new URL(dXt);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, URL url) throws IOException {
            bVar.UT(url == null ? null : url.toExternalForm());
        }
    };
    public static final TypeAdapterFactory nEW = a(URL.class, nEV);
    public static final TypeAdapter<URI> nEX = new TypeAdapter<URI>() { // from class: com.google.gson.internal.a.n.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: p */
        public URI read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.dXp() == JsonToken.NULL) {
                aVar.dXu();
                return null;
            }
            try {
                String dXt = aVar.dXt();
                if ("null".equals(dXt)) {
                    return null;
                }
                return new URI(dXt);
            } catch (URISyntaxException e) {
                throw new JsonIOException(e);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, URI uri) throws IOException {
            bVar.UT(uri == null ? null : uri.toASCIIString());
        }
    };
    public static final TypeAdapterFactory nEY = a(URI.class, nEX);
    public static final TypeAdapter<InetAddress> nEZ = new TypeAdapter<InetAddress>() { // from class: com.google.gson.internal.a.n.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: q */
        public InetAddress read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.dXp() == JsonToken.NULL) {
                aVar.dXu();
                return null;
            }
            return InetAddress.getByName(aVar.dXt());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, InetAddress inetAddress) throws IOException {
            bVar.UT(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    };
    public static final TypeAdapterFactory nFa = b(InetAddress.class, nEZ);
    public static final TypeAdapter<UUID> nFb = new TypeAdapter<UUID>() { // from class: com.google.gson.internal.a.n.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: r */
        public UUID read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.dXp() == JsonToken.NULL) {
                aVar.dXu();
                return null;
            }
            return UUID.fromString(aVar.dXt());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, UUID uuid) throws IOException {
            bVar.UT(uuid == null ? null : uuid.toString());
        }
    };
    public static final TypeAdapterFactory nFc = a(UUID.class, nFb);
    public static final TypeAdapter<Currency> nFd = new TypeAdapter<Currency>() { // from class: com.google.gson.internal.a.n.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: s */
        public Currency read(com.google.gson.stream.a aVar) throws IOException {
            return Currency.getInstance(aVar.dXt());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, Currency currency) throws IOException {
            bVar.UT(currency.getCurrencyCode());
        }
    }.nullSafe();
    public static final TypeAdapterFactory nFe = a(Currency.class, nFd);
    public static final TypeAdapterFactory nFf = new TypeAdapterFactory() { // from class: com.google.gson.internal.a.n.19
        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            if (aVar.dXI() != Timestamp.class) {
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
    public static final TypeAdapter<Calendar> nFg = new TypeAdapter<Calendar>() { // from class: com.google.gson.internal.a.n.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: u */
        public Calendar read(com.google.gson.stream.a aVar) throws IOException {
            int i = 0;
            if (aVar.dXp() == JsonToken.NULL) {
                aVar.dXu();
                return null;
            }
            aVar.dXo();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (aVar.dXp() != JsonToken.END_OBJECT) {
                String dXs = aVar.dXs();
                int nextInt = aVar.nextInt();
                if ("year".equals(dXs)) {
                    i6 = nextInt;
                } else if ("month".equals(dXs)) {
                    i5 = nextInt;
                } else if ("dayOfMonth".equals(dXs)) {
                    i4 = nextInt;
                } else if ("hourOfDay".equals(dXs)) {
                    i3 = nextInt;
                } else if ("minute".equals(dXs)) {
                    i2 = nextInt;
                } else if ("second".equals(dXs)) {
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
                bVar.dXE();
                return;
            }
            bVar.dXC();
            bVar.US("year");
            bVar.gz(calendar.get(1));
            bVar.US("month");
            bVar.gz(calendar.get(2));
            bVar.US("dayOfMonth");
            bVar.gz(calendar.get(5));
            bVar.US("hourOfDay");
            bVar.gz(calendar.get(11));
            bVar.US("minute");
            bVar.gz(calendar.get(12));
            bVar.US("second");
            bVar.gz(calendar.get(13));
            bVar.dXD();
        }
    };
    public static final TypeAdapterFactory nFh = b(Calendar.class, GregorianCalendar.class, nFg);
    public static final TypeAdapter<Locale> nFi = new TypeAdapter<Locale>() { // from class: com.google.gson.internal.a.n.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: v */
        public Locale read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.dXp() == JsonToken.NULL) {
                aVar.dXu();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(aVar.dXt(), PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
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
            bVar.UT(locale == null ? null : locale.toString());
        }
    };
    public static final TypeAdapterFactory nFj = a(Locale.class, nFi);
    public static final TypeAdapter<JsonElement> nFk = new TypeAdapter<JsonElement>() { // from class: com.google.gson.internal.a.n.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: w */
        public JsonElement read(com.google.gson.stream.a aVar) throws IOException {
            switch (AnonymousClass30.nDR[aVar.dXp().ordinal()]) {
                case 1:
                    return new JsonPrimitive((Number) new LazilyParsedNumber(aVar.dXt()));
                case 2:
                    return new JsonPrimitive(Boolean.valueOf(aVar.nextBoolean()));
                case 3:
                    return new JsonPrimitive(aVar.dXt());
                case 4:
                    aVar.dXu();
                    return JsonNull.INSTANCE;
                case 5:
                    JsonArray jsonArray = new JsonArray();
                    aVar.dXn();
                    while (aVar.hasNext()) {
                        jsonArray.add(read(aVar));
                    }
                    aVar.endArray();
                    return jsonArray;
                case 6:
                    JsonObject jsonObject = new JsonObject();
                    aVar.dXo();
                    while (aVar.hasNext()) {
                        jsonObject.add(aVar.dXs(), read(aVar));
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
                bVar.dXE();
            } else if (jsonElement.isJsonPrimitive()) {
                JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
                if (asJsonPrimitive.isNumber()) {
                    bVar.a(asJsonPrimitive.getAsNumber());
                } else if (asJsonPrimitive.isBoolean()) {
                    bVar.yn(asJsonPrimitive.getAsBoolean());
                } else {
                    bVar.UT(asJsonPrimitive.getAsString());
                }
            } else if (jsonElement.isJsonArray()) {
                bVar.dXA();
                Iterator<JsonElement> it = jsonElement.getAsJsonArray().iterator();
                while (it.hasNext()) {
                    write(bVar, it.next());
                }
                bVar.dXB();
            } else if (jsonElement.isJsonObject()) {
                bVar.dXC();
                for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
                    bVar.US(entry.getKey());
                    write(bVar, entry.getValue());
                }
                bVar.dXD();
            } else {
                throw new IllegalArgumentException("Couldn't write " + jsonElement.getClass());
            }
        }
    };
    public static final TypeAdapterFactory nFl = b(JsonElement.class, nFk);
    public static final TypeAdapterFactory nFm = new TypeAdapterFactory() { // from class: com.google.gson.internal.a.n.24
        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            Class dXI = aVar.dXI();
            if (!Enum.class.isAssignableFrom(dXI) || dXI == Enum.class) {
                return null;
            }
            if (!dXI.isEnum()) {
                dXI = (Class<? super Object>) dXI.getSuperclass();
            }
            return new a(dXI);
        }
    };

    /* loaded from: classes3.dex */
    private static final class a<T extends Enum<T>> extends TypeAdapter<T> {
        private final Map<String, T> nFx = new HashMap();
        private final Map<T, String> nFy = new HashMap();

        public a(Class<T> cls) {
            T[] enumConstants;
            try {
                for (T t : cls.getEnumConstants()) {
                    String name = t.name();
                    com.google.gson.a.c cVar = (com.google.gson.a.c) cls.getField(name).getAnnotation(com.google.gson.a.c.class);
                    if (cVar != null) {
                        name = cVar.value();
                        String[] dWV = cVar.dWV();
                        for (String str : dWV) {
                            this.nFx.put(str, t);
                        }
                    }
                    String str2 = name;
                    this.nFx.put(str2, t);
                    this.nFy.put(t, str2);
                }
            } catch (NoSuchFieldException e) {
                throw new AssertionError(e);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: A */
        public T read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.dXp() == JsonToken.NULL) {
                aVar.dXu();
                return null;
            }
            return this.nFx.get(aVar.dXt());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, T t) throws IOException {
            bVar.UT(t == null ? null : this.nFy.get(t));
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
                if (aVar.dXI() == cls) {
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
                Class<? super T> dXI = aVar.dXI();
                if (dXI == cls || dXI == cls2) {
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
                Class<? super T> dXI = aVar.dXI();
                if (dXI == cls || dXI == cls2) {
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
                final Class<? super T2> dXI = aVar.dXI();
                if (cls.isAssignableFrom(dXI)) {
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
                            if (read != 0 && !dXI.isInstance(read)) {
                                throw new JsonSyntaxException("Expected a " + dXI.getName() + " but was " + read.getClass().getName());
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
