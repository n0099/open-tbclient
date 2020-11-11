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
/* loaded from: classes17.dex */
public final class TypeAdapters {
    public static final TypeAdapter<Class> peE = new TypeAdapter<Class>() { // from class: com.google.gson.internal.bind.TypeAdapters.1
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
    public static final TypeAdapterFactory peF = a(Class.class, peE);
    public static final TypeAdapter<BitSet> peG = new TypeAdapter<BitSet>() { // from class: com.google.gson.internal.bind.TypeAdapters.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: m */
        public BitSet read(com.google.gson.stream.a aVar) throws IOException {
            boolean z;
            BitSet bitSet = new BitSet();
            aVar.esU();
            JsonToken esW = aVar.esW();
            int i = 0;
            while (esW != JsonToken.END_ARRAY) {
                switch (AnonymousClass36.pei[esW.ordinal()]) {
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
                        String eta = aVar.eta();
                        try {
                            if (Integer.parseInt(eta) == 0) {
                                z = false;
                                break;
                            } else {
                                z = true;
                                break;
                            }
                        } catch (NumberFormatException e) {
                            throw new JsonSyntaxException("Error: Expecting: bitset number value (1, 0), Found: " + eta);
                        }
                    default:
                        throw new JsonSyntaxException("Invalid bitset value type: " + esW);
                }
                if (z) {
                    bitSet.set(i);
                }
                i++;
                esW = aVar.esW();
            }
            aVar.endArray();
            return bitSet;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, BitSet bitSet) throws IOException {
            bVar.eth();
            int length = bitSet.length();
            for (int i = 0; i < length; i++) {
                bVar.hT(bitSet.get(i) ? 1 : 0);
            }
            bVar.eti();
        }
    }.nullSafe();
    public static final TypeAdapterFactory peH = a(BitSet.class, peG);
    public static final TypeAdapter<Boolean> peI = new TypeAdapter<Boolean>() { // from class: com.google.gson.internal.bind.TypeAdapters.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: x */
        public Boolean read(com.google.gson.stream.a aVar) throws IOException {
            JsonToken esW = aVar.esW();
            if (esW == JsonToken.NULL) {
                aVar.etb();
                return null;
            } else if (esW == JsonToken.STRING) {
                return Boolean.valueOf(Boolean.parseBoolean(aVar.eta()));
            } else {
                return Boolean.valueOf(aVar.nextBoolean());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, Boolean bool) throws IOException {
            bVar.v(bool);
        }
    };
    public static final TypeAdapter<Boolean> peJ = new TypeAdapter<Boolean>() { // from class: com.google.gson.internal.bind.TypeAdapters.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: x */
        public Boolean read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.esW() == JsonToken.NULL) {
                aVar.etb();
                return null;
            }
            return Boolean.valueOf(aVar.eta());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, Boolean bool) throws IOException {
            bVar.YA(bool == null ? "null" : bool.toString());
        }
    };
    public static final TypeAdapterFactory peK = a(Boolean.TYPE, Boolean.class, peI);
    public static final TypeAdapter<Number> peL = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.5
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.esW() == JsonToken.NULL) {
                aVar.etb();
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
    public static final TypeAdapterFactory peM = a(Byte.TYPE, Byte.class, peL);
    public static final TypeAdapter<Number> peN = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.6
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.esW() == JsonToken.NULL) {
                aVar.etb();
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
    public static final TypeAdapterFactory peO = a(Short.TYPE, Short.class, peN);
    public static final TypeAdapter<Number> peP = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.7
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.esW() == JsonToken.NULL) {
                aVar.etb();
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
    public static final TypeAdapterFactory peQ = a(Integer.TYPE, Integer.class, peP);
    public static final TypeAdapter<AtomicInteger> peR = new TypeAdapter<AtomicInteger>() { // from class: com.google.gson.internal.bind.TypeAdapters.8
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
            bVar.hT(atomicInteger.get());
        }
    }.nullSafe();
    public static final TypeAdapterFactory peS = a(AtomicInteger.class, peR);
    public static final TypeAdapter<AtomicBoolean> peT = new TypeAdapter<AtomicBoolean>() { // from class: com.google.gson.internal.bind.TypeAdapters.9
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
            bVar.Ay(atomicBoolean.get());
        }
    }.nullSafe();
    public static final TypeAdapterFactory peU = a(AtomicBoolean.class, peT);
    public static final TypeAdapter<AtomicIntegerArray> peV = new TypeAdapter<AtomicIntegerArray>() { // from class: com.google.gson.internal.bind.TypeAdapters.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: g */
        public AtomicIntegerArray read(com.google.gson.stream.a aVar) throws IOException {
            ArrayList arrayList = new ArrayList();
            aVar.esU();
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
            bVar.eth();
            int length = atomicIntegerArray.length();
            for (int i = 0; i < length; i++) {
                bVar.hT(atomicIntegerArray.get(i));
            }
            bVar.eti();
        }
    }.nullSafe();
    public static final TypeAdapterFactory peW = a(AtomicIntegerArray.class, peV);
    public static final TypeAdapter<Number> peX = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.11
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.esW() == JsonToken.NULL) {
                aVar.etb();
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
    public static final TypeAdapter<Number> peY = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.12
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.esW() == JsonToken.NULL) {
                aVar.etb();
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
    public static final TypeAdapter<Number> peZ = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.13
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.esW() == JsonToken.NULL) {
                aVar.etb();
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
    public static final TypeAdapter<Number> pfa = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.14
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            JsonToken esW = aVar.esW();
            switch (AnonymousClass36.pei[esW.ordinal()]) {
                case 1:
                case 3:
                    return new LazilyParsedNumber(aVar.eta());
                case 2:
                default:
                    throw new JsonSyntaxException("Expecting number, got: " + esW);
                case 4:
                    aVar.etb();
                    return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.b bVar, Number number) throws IOException {
            bVar.a(number);
        }
    };
    public static final TypeAdapterFactory pfb = a(Number.class, pfa);
    public static final TypeAdapter<Character> pfc = new TypeAdapter<Character>() { // from class: com.google.gson.internal.bind.TypeAdapters.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: h */
        public Character read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.esW() == JsonToken.NULL) {
                aVar.etb();
                return null;
            }
            String eta = aVar.eta();
            if (eta.length() != 1) {
                throw new JsonSyntaxException("Expecting character, got: " + eta);
            }
            return Character.valueOf(eta.charAt(0));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, Character ch) throws IOException {
            bVar.YA(ch == null ? null : String.valueOf(ch));
        }
    };
    public static final TypeAdapterFactory pfd = a(Character.TYPE, Character.class, pfc);
    public static final TypeAdapter<String> pfe = new TypeAdapter<String>() { // from class: com.google.gson.internal.bind.TypeAdapters.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: i */
        public String read(com.google.gson.stream.a aVar) throws IOException {
            JsonToken esW = aVar.esW();
            if (esW == JsonToken.NULL) {
                aVar.etb();
                return null;
            } else if (esW == JsonToken.BOOLEAN) {
                return Boolean.toString(aVar.nextBoolean());
            } else {
                return aVar.eta();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, String str) throws IOException {
            bVar.YA(str);
        }
    };
    public static final TypeAdapter<BigDecimal> pff = new TypeAdapter<BigDecimal>() { // from class: com.google.gson.internal.bind.TypeAdapters.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: j */
        public BigDecimal read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.esW() == JsonToken.NULL) {
                aVar.etb();
                return null;
            }
            try {
                return new BigDecimal(aVar.eta());
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
    public static final TypeAdapter<BigInteger> pfg = new TypeAdapter<BigInteger>() { // from class: com.google.gson.internal.bind.TypeAdapters.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: k */
        public BigInteger read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.esW() == JsonToken.NULL) {
                aVar.etb();
                return null;
            }
            try {
                return new BigInteger(aVar.eta());
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
    public static final TypeAdapterFactory pfh = a(String.class, pfe);
    public static final TypeAdapter<StringBuilder> pfi = new TypeAdapter<StringBuilder>() { // from class: com.google.gson.internal.bind.TypeAdapters.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: l */
        public StringBuilder read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.esW() == JsonToken.NULL) {
                aVar.etb();
                return null;
            }
            return new StringBuilder(aVar.eta());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, StringBuilder sb) throws IOException {
            bVar.YA(sb == null ? null : sb.toString());
        }
    };
    public static final TypeAdapterFactory pfj = a(StringBuilder.class, pfi);
    public static final TypeAdapter<StringBuffer> pfk = new TypeAdapter<StringBuffer>() { // from class: com.google.gson.internal.bind.TypeAdapters.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: n */
        public StringBuffer read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.esW() == JsonToken.NULL) {
                aVar.etb();
                return null;
            }
            return new StringBuffer(aVar.eta());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, StringBuffer stringBuffer) throws IOException {
            bVar.YA(stringBuffer == null ? null : stringBuffer.toString());
        }
    };
    public static final TypeAdapterFactory pfl = a(StringBuffer.class, pfk);
    public static final TypeAdapter<URL> pfm = new TypeAdapter<URL>() { // from class: com.google.gson.internal.bind.TypeAdapters.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: o */
        public URL read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.esW() == JsonToken.NULL) {
                aVar.etb();
                return null;
            }
            String eta = aVar.eta();
            if ("null".equals(eta)) {
                return null;
            }
            return new URL(eta);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, URL url) throws IOException {
            bVar.YA(url == null ? null : url.toExternalForm());
        }
    };
    public static final TypeAdapterFactory pfn = a(URL.class, pfm);
    public static final TypeAdapter<URI> pfo = new TypeAdapter<URI>() { // from class: com.google.gson.internal.bind.TypeAdapters.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: p */
        public URI read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.esW() == JsonToken.NULL) {
                aVar.etb();
                return null;
            }
            try {
                String eta = aVar.eta();
                if ("null".equals(eta)) {
                    return null;
                }
                return new URI(eta);
            } catch (URISyntaxException e) {
                throw new JsonIOException(e);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, URI uri) throws IOException {
            bVar.YA(uri == null ? null : uri.toASCIIString());
        }
    };
    public static final TypeAdapterFactory pfp = a(URI.class, pfo);
    public static final TypeAdapter<InetAddress> pfq = new TypeAdapter<InetAddress>() { // from class: com.google.gson.internal.bind.TypeAdapters.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: q */
        public InetAddress read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.esW() == JsonToken.NULL) {
                aVar.etb();
                return null;
            }
            return InetAddress.getByName(aVar.eta());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, InetAddress inetAddress) throws IOException {
            bVar.YA(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    };
    public static final TypeAdapterFactory pfr = b(InetAddress.class, pfq);
    public static final TypeAdapter<UUID> pfs = new TypeAdapter<UUID>() { // from class: com.google.gson.internal.bind.TypeAdapters.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: r */
        public UUID read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.esW() == JsonToken.NULL) {
                aVar.etb();
                return null;
            }
            return UUID.fromString(aVar.eta());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, UUID uuid) throws IOException {
            bVar.YA(uuid == null ? null : uuid.toString());
        }
    };
    public static final TypeAdapterFactory pft = a(UUID.class, pfs);
    public static final TypeAdapter<Currency> pfu = new TypeAdapter<Currency>() { // from class: com.google.gson.internal.bind.TypeAdapters.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: s */
        public Currency read(com.google.gson.stream.a aVar) throws IOException {
            return Currency.getInstance(aVar.eta());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, Currency currency) throws IOException {
            bVar.YA(currency.getCurrencyCode());
        }
    }.nullSafe();
    public static final TypeAdapterFactory pfv = a(Currency.class, pfu);
    public static final TypeAdapterFactory pfw = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.26
        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            if (aVar.etp() != Timestamp.class) {
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
    public static final TypeAdapter<Calendar> pfx = new TypeAdapter<Calendar>() { // from class: com.google.gson.internal.bind.TypeAdapters.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: u */
        public Calendar read(com.google.gson.stream.a aVar) throws IOException {
            int i = 0;
            if (aVar.esW() == JsonToken.NULL) {
                aVar.etb();
                return null;
            }
            aVar.esV();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (aVar.esW() != JsonToken.END_OBJECT) {
                String esZ = aVar.esZ();
                int nextInt = aVar.nextInt();
                if ("year".equals(esZ)) {
                    i6 = nextInt;
                } else if ("month".equals(esZ)) {
                    i5 = nextInt;
                } else if ("dayOfMonth".equals(esZ)) {
                    i4 = nextInt;
                } else if ("hourOfDay".equals(esZ)) {
                    i3 = nextInt;
                } else if ("minute".equals(esZ)) {
                    i2 = nextInt;
                } else if ("second".equals(esZ)) {
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
                bVar.etl();
                return;
            }
            bVar.etj();
            bVar.Yz("year");
            bVar.hT(calendar.get(1));
            bVar.Yz("month");
            bVar.hT(calendar.get(2));
            bVar.Yz("dayOfMonth");
            bVar.hT(calendar.get(5));
            bVar.Yz("hourOfDay");
            bVar.hT(calendar.get(11));
            bVar.Yz("minute");
            bVar.hT(calendar.get(12));
            bVar.Yz("second");
            bVar.hT(calendar.get(13));
            bVar.etk();
        }
    };
    public static final TypeAdapterFactory pfy = b(Calendar.class, GregorianCalendar.class, pfx);
    public static final TypeAdapter<Locale> pfz = new TypeAdapter<Locale>() { // from class: com.google.gson.internal.bind.TypeAdapters.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: v */
        public Locale read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.esW() == JsonToken.NULL) {
                aVar.etb();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(aVar.eta(), PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
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
            bVar.YA(locale == null ? null : locale.toString());
        }
    };
    public static final TypeAdapterFactory pfA = a(Locale.class, pfz);
    public static final TypeAdapter<JsonElement> pfB = new TypeAdapter<JsonElement>() { // from class: com.google.gson.internal.bind.TypeAdapters.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: w */
        public JsonElement read(com.google.gson.stream.a aVar) throws IOException {
            switch (AnonymousClass36.pei[aVar.esW().ordinal()]) {
                case 1:
                    return new JsonPrimitive((Number) new LazilyParsedNumber(aVar.eta()));
                case 2:
                    return new JsonPrimitive(Boolean.valueOf(aVar.nextBoolean()));
                case 3:
                    return new JsonPrimitive(aVar.eta());
                case 4:
                    aVar.etb();
                    return JsonNull.INSTANCE;
                case 5:
                    JsonArray jsonArray = new JsonArray();
                    aVar.esU();
                    while (aVar.hasNext()) {
                        jsonArray.add(read(aVar));
                    }
                    aVar.endArray();
                    return jsonArray;
                case 6:
                    JsonObject jsonObject = new JsonObject();
                    aVar.esV();
                    while (aVar.hasNext()) {
                        jsonObject.add(aVar.esZ(), read(aVar));
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
                bVar.etl();
            } else if (jsonElement.isJsonPrimitive()) {
                JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
                if (asJsonPrimitive.isNumber()) {
                    bVar.a(asJsonPrimitive.getAsNumber());
                } else if (asJsonPrimitive.isBoolean()) {
                    bVar.Ay(asJsonPrimitive.getAsBoolean());
                } else {
                    bVar.YA(asJsonPrimitive.getAsString());
                }
            } else if (jsonElement.isJsonArray()) {
                bVar.eth();
                Iterator<JsonElement> it = jsonElement.getAsJsonArray().iterator();
                while (it.hasNext()) {
                    write(bVar, it.next());
                }
                bVar.eti();
            } else if (jsonElement.isJsonObject()) {
                bVar.etj();
                for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
                    bVar.Yz(entry.getKey());
                    write(bVar, entry.getValue());
                }
                bVar.etk();
            } else {
                throw new IllegalArgumentException("Couldn't write " + jsonElement.getClass());
            }
        }
    };
    public static final TypeAdapterFactory pfC = b(JsonElement.class, pfB);
    public static final TypeAdapterFactory pfD = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.30
        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            Class etp = aVar.etp();
            if (!Enum.class.isAssignableFrom(etp) || etp == Enum.class) {
                return null;
            }
            if (!etp.isEnum()) {
                etp = (Class<? super Object>) etp.getSuperclass();
            }
            return new EnumTypeAdapter(etp);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.gson.internal.bind.TypeAdapters$36  reason: invalid class name */
    /* loaded from: classes17.dex */
    public static /* synthetic */ class AnonymousClass36 {
        static final /* synthetic */ int[] pei = new int[JsonToken.values().length];

        static {
            try {
                pei[JsonToken.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                pei[JsonToken.BOOLEAN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                pei[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                pei[JsonToken.NULL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                pei[JsonToken.BEGIN_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                pei[JsonToken.BEGIN_OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                pei[JsonToken.END_DOCUMENT.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                pei[JsonToken.NAME.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                pei[JsonToken.END_OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                pei[JsonToken.END_ARRAY.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
        }
    }

    /* loaded from: classes17.dex */
    private static final class EnumTypeAdapter<T extends Enum<T>> extends TypeAdapter<T> {
        private final Map<String, T> pfO = new HashMap();
        private final Map<T, String> pfP = new HashMap();

        public EnumTypeAdapter(Class<T> cls) {
            T[] enumConstants;
            try {
                for (T t : cls.getEnumConstants()) {
                    String name = t.name();
                    c cVar = (c) cls.getField(name).getAnnotation(c.class);
                    if (cVar != null) {
                        name = cVar.value();
                        String[] esC = cVar.esC();
                        for (String str : esC) {
                            this.pfO.put(str, t);
                        }
                    }
                    String str2 = name;
                    this.pfO.put(str2, t);
                    this.pfP.put(t, str2);
                }
            } catch (NoSuchFieldException e) {
                throw new AssertionError(e);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: A */
        public T read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.esW() == JsonToken.NULL) {
                aVar.etb();
                return null;
            }
            return this.pfO.get(aVar.eta());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, T t) throws IOException {
            bVar.YA(t == null ? null : this.pfP.get(t));
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
                if (aVar.etp() == cls) {
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
                Class<? super T> etp = aVar.etp();
                if (etp == cls || etp == cls2) {
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
                Class<? super T> etp = aVar.etp();
                if (etp == cls || etp == cls2) {
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
                final Class<? super T2> etp = aVar.etp();
                if (cls.isAssignableFrom(etp)) {
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
                            if (read != 0 && !etp.isInstance(read)) {
                                throw new JsonSyntaxException("Expected a " + etp.getName() + " but was " + read.getClass().getName());
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
