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
/* loaded from: classes5.dex */
public final class TypeAdapters {
    public static final TypeAdapter<Class> pUe = new TypeAdapter<Class>() { // from class: com.google.gson.internal.bind.TypeAdapters.1
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
    public static final TypeAdapterFactory pUf = a(Class.class, pUe);
    public static final TypeAdapter<BitSet> pUg = new TypeAdapter<BitSet>() { // from class: com.google.gson.internal.bind.TypeAdapters.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: m */
        public BitSet read(com.google.gson.stream.a aVar) throws IOException {
            boolean z;
            BitSet bitSet = new BitSet();
            aVar.eBv();
            JsonToken eBx = aVar.eBx();
            int i = 0;
            while (eBx != JsonToken.END_ARRAY) {
                switch (AnonymousClass36.pTI[eBx.ordinal()]) {
                    case 1:
                        if (aVar.eBG() == 0) {
                            z = false;
                            break;
                        } else {
                            z = true;
                            break;
                        }
                    case 2:
                        z = aVar.eBC();
                        break;
                    case 3:
                        String eBB = aVar.eBB();
                        try {
                            if (Integer.parseInt(eBB) == 0) {
                                z = false;
                                break;
                            } else {
                                z = true;
                                break;
                            }
                        } catch (NumberFormatException e) {
                            throw new JsonSyntaxException("Error: Expecting: bitset number value (1, 0), Found: " + eBB);
                        }
                    default:
                        throw new JsonSyntaxException("Invalid bitset value type: " + eBx);
                }
                if (z) {
                    bitSet.set(i);
                }
                i++;
                eBx = aVar.eBx();
            }
            aVar.endArray();
            return bitSet;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, BitSet bitSet) throws IOException {
            bVar.eBM();
            int length = bitSet.length();
            for (int i = 0; i < length; i++) {
                bVar.iT(bitSet.get(i) ? 1 : 0);
            }
            bVar.eBN();
        }
    }.nullSafe();
    public static final TypeAdapterFactory pUh = a(BitSet.class, pUg);
    public static final TypeAdapter<Boolean> pUi = new TypeAdapter<Boolean>() { // from class: com.google.gson.internal.bind.TypeAdapters.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: x */
        public Boolean read(com.google.gson.stream.a aVar) throws IOException {
            JsonToken eBx = aVar.eBx();
            if (eBx == JsonToken.NULL) {
                aVar.eBD();
                return null;
            } else if (eBx == JsonToken.STRING) {
                return Boolean.valueOf(Boolean.parseBoolean(aVar.eBB()));
            } else {
                return Boolean.valueOf(aVar.eBC());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, Boolean bool) throws IOException {
            bVar.v(bool);
        }
    };
    public static final TypeAdapter<Boolean> pUj = new TypeAdapter<Boolean>() { // from class: com.google.gson.internal.bind.TypeAdapters.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: x */
        public Boolean read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.eBx() == JsonToken.NULL) {
                aVar.eBD();
                return null;
            }
            return Boolean.valueOf(aVar.eBB());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, Boolean bool) throws IOException {
            bVar.ZX(bool == null ? "null" : bool.toString());
        }
    };
    public static final TypeAdapterFactory pUk = a(Boolean.TYPE, Boolean.class, pUi);
    public static final TypeAdapter<Number> pUl = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.5
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.eBx() == JsonToken.NULL) {
                aVar.eBD();
                return null;
            }
            try {
                return Byte.valueOf((byte) aVar.eBG());
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
    public static final TypeAdapterFactory pUm = a(Byte.TYPE, Byte.class, pUl);
    public static final TypeAdapter<Number> pUn = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.6
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.eBx() == JsonToken.NULL) {
                aVar.eBD();
                return null;
            }
            try {
                return Short.valueOf((short) aVar.eBG());
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
    public static final TypeAdapterFactory pUo = a(Short.TYPE, Short.class, pUn);
    public static final TypeAdapter<Number> pUp = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.7
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.eBx() == JsonToken.NULL) {
                aVar.eBD();
                return null;
            }
            try {
                return Integer.valueOf(aVar.eBG());
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
    public static final TypeAdapterFactory pUq = a(Integer.TYPE, Integer.class, pUp);
    public static final TypeAdapter<AtomicInteger> pUr = new TypeAdapter<AtomicInteger>() { // from class: com.google.gson.internal.bind.TypeAdapters.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: y */
        public AtomicInteger read(com.google.gson.stream.a aVar) throws IOException {
            try {
                return new AtomicInteger(aVar.eBG());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, AtomicInteger atomicInteger) throws IOException {
            bVar.iT(atomicInteger.get());
        }
    }.nullSafe();
    public static final TypeAdapterFactory pUs = a(AtomicInteger.class, pUr);
    public static final TypeAdapter<AtomicBoolean> pUt = new TypeAdapter<AtomicBoolean>() { // from class: com.google.gson.internal.bind.TypeAdapters.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: z */
        public AtomicBoolean read(com.google.gson.stream.a aVar) throws IOException {
            return new AtomicBoolean(aVar.eBC());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, AtomicBoolean atomicBoolean) throws IOException {
            bVar.Bz(atomicBoolean.get());
        }
    }.nullSafe();
    public static final TypeAdapterFactory pUu = a(AtomicBoolean.class, pUt);
    public static final TypeAdapter<AtomicIntegerArray> pUv = new TypeAdapter<AtomicIntegerArray>() { // from class: com.google.gson.internal.bind.TypeAdapters.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: g */
        public AtomicIntegerArray read(com.google.gson.stream.a aVar) throws IOException {
            ArrayList arrayList = new ArrayList();
            aVar.eBv();
            while (aVar.hasNext()) {
                try {
                    arrayList.add(Integer.valueOf(aVar.eBG()));
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
            bVar.eBM();
            int length = atomicIntegerArray.length();
            for (int i = 0; i < length; i++) {
                bVar.iT(atomicIntegerArray.get(i));
            }
            bVar.eBN();
        }
    }.nullSafe();
    public static final TypeAdapterFactory pUw = a(AtomicIntegerArray.class, pUv);
    public static final TypeAdapter<Number> pUx = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.11
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.eBx() == JsonToken.NULL) {
                aVar.eBD();
                return null;
            }
            try {
                return Long.valueOf(aVar.eBF());
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
    public static final TypeAdapter<Number> pUy = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.12
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.eBx() == JsonToken.NULL) {
                aVar.eBD();
                return null;
            }
            return Float.valueOf((float) aVar.eBE());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.b bVar, Number number) throws IOException {
            bVar.b(number);
        }
    };
    public static final TypeAdapter<Number> pUz = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.13
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.eBx() == JsonToken.NULL) {
                aVar.eBD();
                return null;
            }
            return Double.valueOf(aVar.eBE());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.b bVar, Number number) throws IOException {
            bVar.b(number);
        }
    };
    public static final TypeAdapter<Number> pUA = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.14
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            JsonToken eBx = aVar.eBx();
            switch (AnonymousClass36.pTI[eBx.ordinal()]) {
                case 1:
                case 3:
                    return new LazilyParsedNumber(aVar.eBB());
                case 2:
                default:
                    throw new JsonSyntaxException("Expecting number, got: " + eBx);
                case 4:
                    aVar.eBD();
                    return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.b bVar, Number number) throws IOException {
            bVar.b(number);
        }
    };
    public static final TypeAdapterFactory pUB = a(Number.class, pUA);
    public static final TypeAdapter<Character> pUC = new TypeAdapter<Character>() { // from class: com.google.gson.internal.bind.TypeAdapters.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: h */
        public Character read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.eBx() == JsonToken.NULL) {
                aVar.eBD();
                return null;
            }
            String eBB = aVar.eBB();
            if (eBB.length() != 1) {
                throw new JsonSyntaxException("Expecting character, got: " + eBB);
            }
            return Character.valueOf(eBB.charAt(0));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, Character ch) throws IOException {
            bVar.ZX(ch == null ? null : String.valueOf(ch));
        }
    };
    public static final TypeAdapterFactory pUD = a(Character.TYPE, Character.class, pUC);
    public static final TypeAdapter<String> pUE = new TypeAdapter<String>() { // from class: com.google.gson.internal.bind.TypeAdapters.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: i */
        public String read(com.google.gson.stream.a aVar) throws IOException {
            JsonToken eBx = aVar.eBx();
            if (eBx == JsonToken.NULL) {
                aVar.eBD();
                return null;
            } else if (eBx == JsonToken.BOOLEAN) {
                return Boolean.toString(aVar.eBC());
            } else {
                return aVar.eBB();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, String str) throws IOException {
            bVar.ZX(str);
        }
    };
    public static final TypeAdapter<BigDecimal> pUF = new TypeAdapter<BigDecimal>() { // from class: com.google.gson.internal.bind.TypeAdapters.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: j */
        public BigDecimal read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.eBx() == JsonToken.NULL) {
                aVar.eBD();
                return null;
            }
            try {
                return new BigDecimal(aVar.eBB());
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
    public static final TypeAdapter<BigInteger> pUG = new TypeAdapter<BigInteger>() { // from class: com.google.gson.internal.bind.TypeAdapters.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: k */
        public BigInteger read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.eBx() == JsonToken.NULL) {
                aVar.eBD();
                return null;
            }
            try {
                return new BigInteger(aVar.eBB());
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
    public static final TypeAdapterFactory pUH = a(String.class, pUE);
    public static final TypeAdapter<StringBuilder> pUI = new TypeAdapter<StringBuilder>() { // from class: com.google.gson.internal.bind.TypeAdapters.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: l */
        public StringBuilder read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.eBx() == JsonToken.NULL) {
                aVar.eBD();
                return null;
            }
            return new StringBuilder(aVar.eBB());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, StringBuilder sb) throws IOException {
            bVar.ZX(sb == null ? null : sb.toString());
        }
    };
    public static final TypeAdapterFactory pUJ = a(StringBuilder.class, pUI);
    public static final TypeAdapter<StringBuffer> pUK = new TypeAdapter<StringBuffer>() { // from class: com.google.gson.internal.bind.TypeAdapters.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: n */
        public StringBuffer read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.eBx() == JsonToken.NULL) {
                aVar.eBD();
                return null;
            }
            return new StringBuffer(aVar.eBB());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, StringBuffer stringBuffer) throws IOException {
            bVar.ZX(stringBuffer == null ? null : stringBuffer.toString());
        }
    };
    public static final TypeAdapterFactory pUL = a(StringBuffer.class, pUK);
    public static final TypeAdapter<URL> pUM = new TypeAdapter<URL>() { // from class: com.google.gson.internal.bind.TypeAdapters.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: o */
        public URL read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.eBx() == JsonToken.NULL) {
                aVar.eBD();
                return null;
            }
            String eBB = aVar.eBB();
            if ("null".equals(eBB)) {
                return null;
            }
            return new URL(eBB);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, URL url) throws IOException {
            bVar.ZX(url == null ? null : url.toExternalForm());
        }
    };
    public static final TypeAdapterFactory pUN = a(URL.class, pUM);
    public static final TypeAdapter<URI> pUO = new TypeAdapter<URI>() { // from class: com.google.gson.internal.bind.TypeAdapters.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: p */
        public URI read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.eBx() == JsonToken.NULL) {
                aVar.eBD();
                return null;
            }
            try {
                String eBB = aVar.eBB();
                if ("null".equals(eBB)) {
                    return null;
                }
                return new URI(eBB);
            } catch (URISyntaxException e) {
                throw new JsonIOException(e);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, URI uri) throws IOException {
            bVar.ZX(uri == null ? null : uri.toASCIIString());
        }
    };
    public static final TypeAdapterFactory pUP = a(URI.class, pUO);
    public static final TypeAdapter<InetAddress> pUQ = new TypeAdapter<InetAddress>() { // from class: com.google.gson.internal.bind.TypeAdapters.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: q */
        public InetAddress read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.eBx() == JsonToken.NULL) {
                aVar.eBD();
                return null;
            }
            return InetAddress.getByName(aVar.eBB());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, InetAddress inetAddress) throws IOException {
            bVar.ZX(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    };
    public static final TypeAdapterFactory pUR = b(InetAddress.class, pUQ);
    public static final TypeAdapter<UUID> pUS = new TypeAdapter<UUID>() { // from class: com.google.gson.internal.bind.TypeAdapters.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: r */
        public UUID read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.eBx() == JsonToken.NULL) {
                aVar.eBD();
                return null;
            }
            return UUID.fromString(aVar.eBB());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, UUID uuid) throws IOException {
            bVar.ZX(uuid == null ? null : uuid.toString());
        }
    };
    public static final TypeAdapterFactory pUT = a(UUID.class, pUS);
    public static final TypeAdapter<Currency> pUU = new TypeAdapter<Currency>() { // from class: com.google.gson.internal.bind.TypeAdapters.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: s */
        public Currency read(com.google.gson.stream.a aVar) throws IOException {
            return Currency.getInstance(aVar.eBB());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, Currency currency) throws IOException {
            bVar.ZX(currency.getCurrencyCode());
        }
    }.nullSafe();
    public static final TypeAdapterFactory pUV = a(Currency.class, pUU);
    public static final TypeAdapterFactory pUW = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.26
        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            if (aVar.eBU() != Timestamp.class) {
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
    public static final TypeAdapter<Calendar> pUX = new TypeAdapter<Calendar>() { // from class: com.google.gson.internal.bind.TypeAdapters.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: u */
        public Calendar read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.eBx() == JsonToken.NULL) {
                aVar.eBD();
                return null;
            }
            aVar.eBw();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (aVar.eBx() != JsonToken.END_OBJECT) {
                String eBA = aVar.eBA();
                int eBG = aVar.eBG();
                if ("year".equals(eBA)) {
                    i6 = eBG;
                } else if ("month".equals(eBA)) {
                    i5 = eBG;
                } else if ("dayOfMonth".equals(eBA)) {
                    i4 = eBG;
                } else if ("hourOfDay".equals(eBA)) {
                    i3 = eBG;
                } else if ("minute".equals(eBA)) {
                    i2 = eBG;
                } else if ("second".equals(eBA)) {
                    i = eBG;
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
                bVar.eBQ();
                return;
            }
            bVar.eBO();
            bVar.ZW("year");
            bVar.iT(calendar.get(1));
            bVar.ZW("month");
            bVar.iT(calendar.get(2));
            bVar.ZW("dayOfMonth");
            bVar.iT(calendar.get(5));
            bVar.ZW("hourOfDay");
            bVar.iT(calendar.get(11));
            bVar.ZW("minute");
            bVar.iT(calendar.get(12));
            bVar.ZW("second");
            bVar.iT(calendar.get(13));
            bVar.eBP();
        }
    };
    public static final TypeAdapterFactory pUY = b(Calendar.class, GregorianCalendar.class, pUX);
    public static final TypeAdapter<Locale> pUZ = new TypeAdapter<Locale>() { // from class: com.google.gson.internal.bind.TypeAdapters.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: v */
        public Locale read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.eBx() == JsonToken.NULL) {
                aVar.eBD();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(aVar.eBB(), PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
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
            bVar.ZX(locale == null ? null : locale.toString());
        }
    };
    public static final TypeAdapterFactory pVa = a(Locale.class, pUZ);
    public static final TypeAdapter<JsonElement> pVb = new TypeAdapter<JsonElement>() { // from class: com.google.gson.internal.bind.TypeAdapters.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: w */
        public JsonElement read(com.google.gson.stream.a aVar) throws IOException {
            switch (AnonymousClass36.pTI[aVar.eBx().ordinal()]) {
                case 1:
                    return new JsonPrimitive((Number) new LazilyParsedNumber(aVar.eBB()));
                case 2:
                    return new JsonPrimitive(Boolean.valueOf(aVar.eBC()));
                case 3:
                    return new JsonPrimitive(aVar.eBB());
                case 4:
                    aVar.eBD();
                    return JsonNull.INSTANCE;
                case 5:
                    JsonArray jsonArray = new JsonArray();
                    aVar.eBv();
                    while (aVar.hasNext()) {
                        jsonArray.add(read(aVar));
                    }
                    aVar.endArray();
                    return jsonArray;
                case 6:
                    JsonObject jsonObject = new JsonObject();
                    aVar.eBw();
                    while (aVar.hasNext()) {
                        jsonObject.add(aVar.eBA(), read(aVar));
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
                bVar.eBQ();
            } else if (jsonElement.isJsonPrimitive()) {
                JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
                if (asJsonPrimitive.isNumber()) {
                    bVar.b(asJsonPrimitive.getAsNumber());
                } else if (asJsonPrimitive.isBoolean()) {
                    bVar.Bz(asJsonPrimitive.getAsBoolean());
                } else {
                    bVar.ZX(asJsonPrimitive.getAsString());
                }
            } else if (jsonElement.isJsonArray()) {
                bVar.eBM();
                Iterator<JsonElement> it = jsonElement.getAsJsonArray().iterator();
                while (it.hasNext()) {
                    write(bVar, it.next());
                }
                bVar.eBN();
            } else if (jsonElement.isJsonObject()) {
                bVar.eBO();
                for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
                    bVar.ZW(entry.getKey());
                    write(bVar, entry.getValue());
                }
                bVar.eBP();
            } else {
                throw new IllegalArgumentException("Couldn't write " + jsonElement.getClass());
            }
        }
    };
    public static final TypeAdapterFactory pVc = b(JsonElement.class, pVb);
    public static final TypeAdapterFactory pVd = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.30
        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            Class eBU = aVar.eBU();
            if (!Enum.class.isAssignableFrom(eBU) || eBU == Enum.class) {
                return null;
            }
            if (!eBU.isEnum()) {
                eBU = (Class<? super Object>) eBU.getSuperclass();
            }
            return new EnumTypeAdapter(eBU);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.gson.internal.bind.TypeAdapters$36  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass36 {
        static final /* synthetic */ int[] pTI = new int[JsonToken.values().length];

        static {
            try {
                pTI[JsonToken.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                pTI[JsonToken.BOOLEAN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                pTI[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                pTI[JsonToken.NULL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                pTI[JsonToken.BEGIN_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                pTI[JsonToken.BEGIN_OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                pTI[JsonToken.END_DOCUMENT.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                pTI[JsonToken.NAME.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                pTI[JsonToken.END_OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                pTI[JsonToken.END_ARRAY.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
        }
    }

    /* loaded from: classes5.dex */
    private static final class EnumTypeAdapter<T extends Enum<T>> extends TypeAdapter<T> {
        private final Map<String, T> pVo = new HashMap();
        private final Map<T, String> pVp = new HashMap();

        public EnumTypeAdapter(Class<T> cls) {
            T[] enumConstants;
            try {
                for (T t : cls.getEnumConstants()) {
                    String name = t.name();
                    c cVar = (c) cls.getField(name).getAnnotation(c.class);
                    if (cVar != null) {
                        name = cVar.value();
                        String[] eBc = cVar.eBc();
                        for (String str : eBc) {
                            this.pVo.put(str, t);
                        }
                    }
                    String str2 = name;
                    this.pVo.put(str2, t);
                    this.pVp.put(t, str2);
                }
            } catch (NoSuchFieldException e) {
                throw new AssertionError(e);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: A */
        public T read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.eBx() == JsonToken.NULL) {
                aVar.eBD();
                return null;
            }
            return this.pVo.get(aVar.eBB());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, T t) throws IOException {
            bVar.ZX(t == null ? null : this.pVp.get(t));
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
                if (aVar.eBU() == cls) {
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
                Class<? super T> eBU = aVar.eBU();
                if (eBU == cls || eBU == cls2) {
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
                Class<? super T> eBU = aVar.eBU();
                if (eBU == cls || eBU == cls2) {
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
                final Class<? super T2> eBU = aVar.eBU();
                if (cls.isAssignableFrom(eBU)) {
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
                            if (read != 0 && !eBU.isInstance(read)) {
                                throw new JsonSyntaxException("Expected a " + eBU.getName() + " but was " + read.getClass().getName());
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
