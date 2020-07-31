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
/* loaded from: classes10.dex */
public final class n {
    public static final TypeAdapter<Class> nku = new TypeAdapter<Class>() { // from class: com.google.gson.internal.a.n.1
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
    public static final TypeAdapterFactory nkv = a(Class.class, nku);
    public static final TypeAdapter<BitSet> nkw = new TypeAdapter<BitSet>() { // from class: com.google.gson.internal.a.n.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: m */
        public BitSet read(com.google.gson.stream.a aVar) throws IOException {
            boolean z;
            BitSet bitSet = new BitSet();
            aVar.dLl();
            JsonToken dLn = aVar.dLn();
            int i = 0;
            while (dLn != JsonToken.END_ARRAY) {
                switch (AnonymousClass30.njY[dLn.ordinal()]) {
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
                        String dLr = aVar.dLr();
                        try {
                            if (Integer.parseInt(dLr) == 0) {
                                z = false;
                                break;
                            } else {
                                z = true;
                                break;
                            }
                        } catch (NumberFormatException e) {
                            throw new JsonSyntaxException("Error: Expecting: bitset number value (1, 0), Found: " + dLr);
                        }
                    default:
                        throw new JsonSyntaxException("Invalid bitset value type: " + dLn);
                }
                if (z) {
                    bitSet.set(i);
                }
                i++;
                dLn = aVar.dLn();
            }
            aVar.endArray();
            return bitSet;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, BitSet bitSet) throws IOException {
            bVar.dLy();
            int length = bitSet.length();
            for (int i = 0; i < length; i++) {
                bVar.gm(bitSet.get(i) ? 1 : 0);
            }
            bVar.dLz();
        }
    }.nullSafe();
    public static final TypeAdapterFactory nkx = a(BitSet.class, nkw);
    public static final TypeAdapter<Boolean> nky = new TypeAdapter<Boolean>() { // from class: com.google.gson.internal.a.n.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: x */
        public Boolean read(com.google.gson.stream.a aVar) throws IOException {
            JsonToken dLn = aVar.dLn();
            if (dLn == JsonToken.NULL) {
                aVar.dLs();
                return null;
            } else if (dLn == JsonToken.STRING) {
                return Boolean.valueOf(Boolean.parseBoolean(aVar.dLr()));
            } else {
                return Boolean.valueOf(aVar.nextBoolean());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, Boolean bool) throws IOException {
            bVar.r(bool);
        }
    };
    public static final TypeAdapter<Boolean> nkz = new TypeAdapter<Boolean>() { // from class: com.google.gson.internal.a.n.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: x */
        public Boolean read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.dLn() == JsonToken.NULL) {
                aVar.dLs();
                return null;
            }
            return Boolean.valueOf(aVar.dLr());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, Boolean bool) throws IOException {
            bVar.RP(bool == null ? "null" : bool.toString());
        }
    };
    public static final TypeAdapterFactory nkA = a(Boolean.TYPE, Boolean.class, nky);
    public static final TypeAdapter<Number> nkB = new TypeAdapter<Number>() { // from class: com.google.gson.internal.a.n.32
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.dLn() == JsonToken.NULL) {
                aVar.dLs();
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
    public static final TypeAdapterFactory nkC = a(Byte.TYPE, Byte.class, nkB);
    public static final TypeAdapter<Number> nkD = new TypeAdapter<Number>() { // from class: com.google.gson.internal.a.n.33
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.dLn() == JsonToken.NULL) {
                aVar.dLs();
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
    public static final TypeAdapterFactory nkE = a(Short.TYPE, Short.class, nkD);
    public static final TypeAdapter<Number> nkF = new TypeAdapter<Number>() { // from class: com.google.gson.internal.a.n.34
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.dLn() == JsonToken.NULL) {
                aVar.dLs();
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
    public static final TypeAdapterFactory nkG = a(Integer.TYPE, Integer.class, nkF);
    public static final TypeAdapter<AtomicInteger> nkH = new TypeAdapter<AtomicInteger>() { // from class: com.google.gson.internal.a.n.35
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
            bVar.gm(atomicInteger.get());
        }
    }.nullSafe();
    public static final TypeAdapterFactory nkI = a(AtomicInteger.class, nkH);
    public static final TypeAdapter<AtomicBoolean> nkJ = new TypeAdapter<AtomicBoolean>() { // from class: com.google.gson.internal.a.n.36
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
            bVar.xw(atomicBoolean.get());
        }
    }.nullSafe();
    public static final TypeAdapterFactory nkK = a(AtomicBoolean.class, nkJ);
    public static final TypeAdapter<AtomicIntegerArray> nkL = new TypeAdapter<AtomicIntegerArray>() { // from class: com.google.gson.internal.a.n.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: g */
        public AtomicIntegerArray read(com.google.gson.stream.a aVar) throws IOException {
            ArrayList arrayList = new ArrayList();
            aVar.dLl();
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
            bVar.dLy();
            int length = atomicIntegerArray.length();
            for (int i = 0; i < length; i++) {
                bVar.gm(atomicIntegerArray.get(i));
            }
            bVar.dLz();
        }
    }.nullSafe();
    public static final TypeAdapterFactory nkM = a(AtomicIntegerArray.class, nkL);
    public static final TypeAdapter<Number> nkN = new TypeAdapter<Number>() { // from class: com.google.gson.internal.a.n.3
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.dLn() == JsonToken.NULL) {
                aVar.dLs();
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
    public static final TypeAdapter<Number> nkO = new TypeAdapter<Number>() { // from class: com.google.gson.internal.a.n.4
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.dLn() == JsonToken.NULL) {
                aVar.dLs();
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
    public static final TypeAdapter<Number> nkP = new TypeAdapter<Number>() { // from class: com.google.gson.internal.a.n.5
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.dLn() == JsonToken.NULL) {
                aVar.dLs();
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
    public static final TypeAdapter<Number> nkQ = new TypeAdapter<Number>() { // from class: com.google.gson.internal.a.n.6
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            JsonToken dLn = aVar.dLn();
            switch (dLn) {
                case NUMBER:
                case STRING:
                    return new LazilyParsedNumber(aVar.dLr());
                case BOOLEAN:
                default:
                    throw new JsonSyntaxException("Expecting number, got: " + dLn);
                case NULL:
                    aVar.dLs();
                    return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.b bVar, Number number) throws IOException {
            bVar.a(number);
        }
    };
    public static final TypeAdapterFactory nkR = a(Number.class, nkQ);
    public static final TypeAdapter<Character> nkS = new TypeAdapter<Character>() { // from class: com.google.gson.internal.a.n.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: h */
        public Character read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.dLn() == JsonToken.NULL) {
                aVar.dLs();
                return null;
            }
            String dLr = aVar.dLr();
            if (dLr.length() != 1) {
                throw new JsonSyntaxException("Expecting character, got: " + dLr);
            }
            return Character.valueOf(dLr.charAt(0));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, Character ch) throws IOException {
            bVar.RP(ch == null ? null : String.valueOf(ch));
        }
    };
    public static final TypeAdapterFactory nkT = a(Character.TYPE, Character.class, nkS);
    public static final TypeAdapter<String> nkU = new TypeAdapter<String>() { // from class: com.google.gson.internal.a.n.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: i */
        public String read(com.google.gson.stream.a aVar) throws IOException {
            JsonToken dLn = aVar.dLn();
            if (dLn == JsonToken.NULL) {
                aVar.dLs();
                return null;
            } else if (dLn == JsonToken.BOOLEAN) {
                return Boolean.toString(aVar.nextBoolean());
            } else {
                return aVar.dLr();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, String str) throws IOException {
            bVar.RP(str);
        }
    };
    public static final TypeAdapter<BigDecimal> nkV = new TypeAdapter<BigDecimal>() { // from class: com.google.gson.internal.a.n.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: j */
        public BigDecimal read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.dLn() == JsonToken.NULL) {
                aVar.dLs();
                return null;
            }
            try {
                return new BigDecimal(aVar.dLr());
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
    public static final TypeAdapter<BigInteger> nkW = new TypeAdapter<BigInteger>() { // from class: com.google.gson.internal.a.n.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: k */
        public BigInteger read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.dLn() == JsonToken.NULL) {
                aVar.dLs();
                return null;
            }
            try {
                return new BigInteger(aVar.dLr());
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
    public static final TypeAdapterFactory nkX = a(String.class, nkU);
    public static final TypeAdapter<StringBuilder> nkY = new TypeAdapter<StringBuilder>() { // from class: com.google.gson.internal.a.n.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: l */
        public StringBuilder read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.dLn() == JsonToken.NULL) {
                aVar.dLs();
                return null;
            }
            return new StringBuilder(aVar.dLr());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, StringBuilder sb) throws IOException {
            bVar.RP(sb == null ? null : sb.toString());
        }
    };
    public static final TypeAdapterFactory nkZ = a(StringBuilder.class, nkY);
    public static final TypeAdapter<StringBuffer> nla = new TypeAdapter<StringBuffer>() { // from class: com.google.gson.internal.a.n.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: n */
        public StringBuffer read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.dLn() == JsonToken.NULL) {
                aVar.dLs();
                return null;
            }
            return new StringBuffer(aVar.dLr());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, StringBuffer stringBuffer) throws IOException {
            bVar.RP(stringBuffer == null ? null : stringBuffer.toString());
        }
    };
    public static final TypeAdapterFactory nlb = a(StringBuffer.class, nla);
    public static final TypeAdapter<URL> nlc = new TypeAdapter<URL>() { // from class: com.google.gson.internal.a.n.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: o */
        public URL read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.dLn() == JsonToken.NULL) {
                aVar.dLs();
                return null;
            }
            String dLr = aVar.dLr();
            if ("null".equals(dLr)) {
                return null;
            }
            return new URL(dLr);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, URL url) throws IOException {
            bVar.RP(url == null ? null : url.toExternalForm());
        }
    };
    public static final TypeAdapterFactory nld = a(URL.class, nlc);
    public static final TypeAdapter<URI> nle = new TypeAdapter<URI>() { // from class: com.google.gson.internal.a.n.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: p */
        public URI read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.dLn() == JsonToken.NULL) {
                aVar.dLs();
                return null;
            }
            try {
                String dLr = aVar.dLr();
                if ("null".equals(dLr)) {
                    return null;
                }
                return new URI(dLr);
            } catch (URISyntaxException e) {
                throw new JsonIOException(e);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, URI uri) throws IOException {
            bVar.RP(uri == null ? null : uri.toASCIIString());
        }
    };
    public static final TypeAdapterFactory nlf = a(URI.class, nle);
    public static final TypeAdapter<InetAddress> nlg = new TypeAdapter<InetAddress>() { // from class: com.google.gson.internal.a.n.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: q */
        public InetAddress read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.dLn() == JsonToken.NULL) {
                aVar.dLs();
                return null;
            }
            return InetAddress.getByName(aVar.dLr());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, InetAddress inetAddress) throws IOException {
            bVar.RP(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    };
    public static final TypeAdapterFactory nlh = b(InetAddress.class, nlg);
    public static final TypeAdapter<UUID> nli = new TypeAdapter<UUID>() { // from class: com.google.gson.internal.a.n.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: r */
        public UUID read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.dLn() == JsonToken.NULL) {
                aVar.dLs();
                return null;
            }
            return UUID.fromString(aVar.dLr());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, UUID uuid) throws IOException {
            bVar.RP(uuid == null ? null : uuid.toString());
        }
    };
    public static final TypeAdapterFactory nlj = a(UUID.class, nli);
    public static final TypeAdapter<Currency> nlk = new TypeAdapter<Currency>() { // from class: com.google.gson.internal.a.n.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: s */
        public Currency read(com.google.gson.stream.a aVar) throws IOException {
            return Currency.getInstance(aVar.dLr());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, Currency currency) throws IOException {
            bVar.RP(currency.getCurrencyCode());
        }
    }.nullSafe();
    public static final TypeAdapterFactory nll = a(Currency.class, nlk);
    public static final TypeAdapterFactory nlm = new TypeAdapterFactory() { // from class: com.google.gson.internal.a.n.19
        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            if (aVar.dLG() != Timestamp.class) {
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
    public static final TypeAdapter<Calendar> nln = new TypeAdapter<Calendar>() { // from class: com.google.gson.internal.a.n.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: u */
        public Calendar read(com.google.gson.stream.a aVar) throws IOException {
            int i = 0;
            if (aVar.dLn() == JsonToken.NULL) {
                aVar.dLs();
                return null;
            }
            aVar.dLm();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (aVar.dLn() != JsonToken.END_OBJECT) {
                String dLq = aVar.dLq();
                int nextInt = aVar.nextInt();
                if ("year".equals(dLq)) {
                    i6 = nextInt;
                } else if ("month".equals(dLq)) {
                    i5 = nextInt;
                } else if ("dayOfMonth".equals(dLq)) {
                    i4 = nextInt;
                } else if ("hourOfDay".equals(dLq)) {
                    i3 = nextInt;
                } else if ("minute".equals(dLq)) {
                    i2 = nextInt;
                } else if ("second".equals(dLq)) {
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
                bVar.dLC();
                return;
            }
            bVar.dLA();
            bVar.RO("year");
            bVar.gm(calendar.get(1));
            bVar.RO("month");
            bVar.gm(calendar.get(2));
            bVar.RO("dayOfMonth");
            bVar.gm(calendar.get(5));
            bVar.RO("hourOfDay");
            bVar.gm(calendar.get(11));
            bVar.RO("minute");
            bVar.gm(calendar.get(12));
            bVar.RO("second");
            bVar.gm(calendar.get(13));
            bVar.dLB();
        }
    };
    public static final TypeAdapterFactory nlo = b(Calendar.class, GregorianCalendar.class, nln);
    public static final TypeAdapter<Locale> nlp = new TypeAdapter<Locale>() { // from class: com.google.gson.internal.a.n.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: v */
        public Locale read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.dLn() == JsonToken.NULL) {
                aVar.dLs();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(aVar.dLr(), PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
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
            bVar.RP(locale == null ? null : locale.toString());
        }
    };
    public static final TypeAdapterFactory nlq = a(Locale.class, nlp);
    public static final TypeAdapter<JsonElement> nlr = new TypeAdapter<JsonElement>() { // from class: com.google.gson.internal.a.n.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: w */
        public JsonElement read(com.google.gson.stream.a aVar) throws IOException {
            switch (AnonymousClass30.njY[aVar.dLn().ordinal()]) {
                case 1:
                    return new JsonPrimitive((Number) new LazilyParsedNumber(aVar.dLr()));
                case 2:
                    return new JsonPrimitive(Boolean.valueOf(aVar.nextBoolean()));
                case 3:
                    return new JsonPrimitive(aVar.dLr());
                case 4:
                    aVar.dLs();
                    return JsonNull.INSTANCE;
                case 5:
                    JsonArray jsonArray = new JsonArray();
                    aVar.dLl();
                    while (aVar.hasNext()) {
                        jsonArray.add(read(aVar));
                    }
                    aVar.endArray();
                    return jsonArray;
                case 6:
                    JsonObject jsonObject = new JsonObject();
                    aVar.dLm();
                    while (aVar.hasNext()) {
                        jsonObject.add(aVar.dLq(), read(aVar));
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
                bVar.dLC();
            } else if (jsonElement.isJsonPrimitive()) {
                JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
                if (asJsonPrimitive.isNumber()) {
                    bVar.a(asJsonPrimitive.getAsNumber());
                } else if (asJsonPrimitive.isBoolean()) {
                    bVar.xw(asJsonPrimitive.getAsBoolean());
                } else {
                    bVar.RP(asJsonPrimitive.getAsString());
                }
            } else if (jsonElement.isJsonArray()) {
                bVar.dLy();
                Iterator<JsonElement> it = jsonElement.getAsJsonArray().iterator();
                while (it.hasNext()) {
                    write(bVar, it.next());
                }
                bVar.dLz();
            } else if (jsonElement.isJsonObject()) {
                bVar.dLA();
                for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
                    bVar.RO(entry.getKey());
                    write(bVar, entry.getValue());
                }
                bVar.dLB();
            } else {
                throw new IllegalArgumentException("Couldn't write " + jsonElement.getClass());
            }
        }
    };
    public static final TypeAdapterFactory nls = b(JsonElement.class, nlr);
    public static final TypeAdapterFactory nlt = new TypeAdapterFactory() { // from class: com.google.gson.internal.a.n.24
        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            Class dLG = aVar.dLG();
            if (!Enum.class.isAssignableFrom(dLG) || dLG == Enum.class) {
                return null;
            }
            if (!dLG.isEnum()) {
                dLG = (Class<? super Object>) dLG.getSuperclass();
            }
            return new a(dLG);
        }
    };

    /* loaded from: classes10.dex */
    private static final class a<T extends Enum<T>> extends TypeAdapter<T> {
        private final Map<String, T> nlE = new HashMap();
        private final Map<T, String> nlF = new HashMap();

        public a(Class<T> cls) {
            T[] enumConstants;
            try {
                for (T t : cls.getEnumConstants()) {
                    String name = t.name();
                    com.google.gson.a.c cVar = (com.google.gson.a.c) cls.getField(name).getAnnotation(com.google.gson.a.c.class);
                    if (cVar != null) {
                        name = cVar.value();
                        String[] dKT = cVar.dKT();
                        for (String str : dKT) {
                            this.nlE.put(str, t);
                        }
                    }
                    String str2 = name;
                    this.nlE.put(str2, t);
                    this.nlF.put(t, str2);
                }
            } catch (NoSuchFieldException e) {
                throw new AssertionError(e);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: A */
        public T read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.dLn() == JsonToken.NULL) {
                aVar.dLs();
                return null;
            }
            return this.nlE.get(aVar.dLr());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, T t) throws IOException {
            bVar.RP(t == null ? null : this.nlF.get(t));
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
                if (aVar.dLG() == cls) {
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
                Class<? super T> dLG = aVar.dLG();
                if (dLG == cls || dLG == cls2) {
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
                Class<? super T> dLG = aVar.dLG();
                if (dLG == cls || dLG == cls2) {
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
                final Class<? super T2> dLG = aVar.dLG();
                if (cls.isAssignableFrom(dLG)) {
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
                            if (read != 0 && !dLG.isInstance(read)) {
                                throw new JsonSyntaxException("Expected a " + dLG.getName() + " but was " + read.getClass().getName());
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
