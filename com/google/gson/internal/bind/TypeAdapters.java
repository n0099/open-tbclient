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
    public static final TypeAdapter<Class> pvs = new TypeAdapter<Class>() { // from class: com.google.gson.internal.bind.TypeAdapters.1
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
    public static final TypeAdapterFactory pvt = a(Class.class, pvs);
    public static final TypeAdapter<BitSet> pvu = new TypeAdapter<BitSet>() { // from class: com.google.gson.internal.bind.TypeAdapters.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: m */
        public BitSet read(com.google.gson.stream.a aVar) throws IOException {
            boolean z;
            BitSet bitSet = new BitSet();
            aVar.eyx();
            JsonToken eyz = aVar.eyz();
            int i = 0;
            while (eyz != JsonToken.END_ARRAY) {
                switch (AnonymousClass36.puW[eyz.ordinal()]) {
                    case 1:
                        if (aVar.eyI() == 0) {
                            z = false;
                            break;
                        } else {
                            z = true;
                            break;
                        }
                    case 2:
                        z = aVar.eyE();
                        break;
                    case 3:
                        String eyD = aVar.eyD();
                        try {
                            if (Integer.parseInt(eyD) == 0) {
                                z = false;
                                break;
                            } else {
                                z = true;
                                break;
                            }
                        } catch (NumberFormatException e) {
                            throw new JsonSyntaxException("Error: Expecting: bitset number value (1, 0), Found: " + eyD);
                        }
                    default:
                        throw new JsonSyntaxException("Invalid bitset value type: " + eyz);
                }
                if (z) {
                    bitSet.set(i);
                }
                i++;
                eyz = aVar.eyz();
            }
            aVar.endArray();
            return bitSet;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, BitSet bitSet) throws IOException {
            bVar.eyO();
            int length = bitSet.length();
            for (int i = 0; i < length; i++) {
                bVar.iC(bitSet.get(i) ? 1 : 0);
            }
            bVar.eyP();
        }
    }.nullSafe();
    public static final TypeAdapterFactory pvv = a(BitSet.class, pvu);
    public static final TypeAdapter<Boolean> pvw = new TypeAdapter<Boolean>() { // from class: com.google.gson.internal.bind.TypeAdapters.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: x */
        public Boolean read(com.google.gson.stream.a aVar) throws IOException {
            JsonToken eyz = aVar.eyz();
            if (eyz == JsonToken.NULL) {
                aVar.eyF();
                return null;
            } else if (eyz == JsonToken.STRING) {
                return Boolean.valueOf(Boolean.parseBoolean(aVar.eyD()));
            } else {
                return Boolean.valueOf(aVar.eyE());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, Boolean bool) throws IOException {
            bVar.v(bool);
        }
    };
    public static final TypeAdapter<Boolean> pvx = new TypeAdapter<Boolean>() { // from class: com.google.gson.internal.bind.TypeAdapters.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: x */
        public Boolean read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.eyz() == JsonToken.NULL) {
                aVar.eyF();
                return null;
            }
            return Boolean.valueOf(aVar.eyD());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, Boolean bool) throws IOException {
            bVar.ZG(bool == null ? "null" : bool.toString());
        }
    };
    public static final TypeAdapterFactory pvy = a(Boolean.TYPE, Boolean.class, pvw);
    public static final TypeAdapter<Number> pvz = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.5
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.eyz() == JsonToken.NULL) {
                aVar.eyF();
                return null;
            }
            try {
                return Byte.valueOf((byte) aVar.eyI());
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
    public static final TypeAdapterFactory pvA = a(Byte.TYPE, Byte.class, pvz);
    public static final TypeAdapter<Number> pvB = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.6
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.eyz() == JsonToken.NULL) {
                aVar.eyF();
                return null;
            }
            try {
                return Short.valueOf((short) aVar.eyI());
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
    public static final TypeAdapterFactory pvC = a(Short.TYPE, Short.class, pvB);
    public static final TypeAdapter<Number> pvD = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.7
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.eyz() == JsonToken.NULL) {
                aVar.eyF();
                return null;
            }
            try {
                return Integer.valueOf(aVar.eyI());
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
    public static final TypeAdapterFactory pvE = a(Integer.TYPE, Integer.class, pvD);
    public static final TypeAdapter<AtomicInteger> pvF = new TypeAdapter<AtomicInteger>() { // from class: com.google.gson.internal.bind.TypeAdapters.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: y */
        public AtomicInteger read(com.google.gson.stream.a aVar) throws IOException {
            try {
                return new AtomicInteger(aVar.eyI());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, AtomicInteger atomicInteger) throws IOException {
            bVar.iC(atomicInteger.get());
        }
    }.nullSafe();
    public static final TypeAdapterFactory pvG = a(AtomicInteger.class, pvF);
    public static final TypeAdapter<AtomicBoolean> pvH = new TypeAdapter<AtomicBoolean>() { // from class: com.google.gson.internal.bind.TypeAdapters.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: z */
        public AtomicBoolean read(com.google.gson.stream.a aVar) throws IOException {
            return new AtomicBoolean(aVar.eyE());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, AtomicBoolean atomicBoolean) throws IOException {
            bVar.Bc(atomicBoolean.get());
        }
    }.nullSafe();
    public static final TypeAdapterFactory pvI = a(AtomicBoolean.class, pvH);
    public static final TypeAdapter<AtomicIntegerArray> pvJ = new TypeAdapter<AtomicIntegerArray>() { // from class: com.google.gson.internal.bind.TypeAdapters.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: g */
        public AtomicIntegerArray read(com.google.gson.stream.a aVar) throws IOException {
            ArrayList arrayList = new ArrayList();
            aVar.eyx();
            while (aVar.hasNext()) {
                try {
                    arrayList.add(Integer.valueOf(aVar.eyI()));
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
            bVar.eyO();
            int length = atomicIntegerArray.length();
            for (int i = 0; i < length; i++) {
                bVar.iC(atomicIntegerArray.get(i));
            }
            bVar.eyP();
        }
    }.nullSafe();
    public static final TypeAdapterFactory pvK = a(AtomicIntegerArray.class, pvJ);
    public static final TypeAdapter<Number> pvL = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.11
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.eyz() == JsonToken.NULL) {
                aVar.eyF();
                return null;
            }
            try {
                return Long.valueOf(aVar.eyH());
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
    public static final TypeAdapter<Number> pvM = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.12
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.eyz() == JsonToken.NULL) {
                aVar.eyF();
                return null;
            }
            return Float.valueOf((float) aVar.eyG());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.b bVar, Number number) throws IOException {
            bVar.a(number);
        }
    };
    public static final TypeAdapter<Number> pvN = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.13
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.eyz() == JsonToken.NULL) {
                aVar.eyF();
                return null;
            }
            return Double.valueOf(aVar.eyG());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.b bVar, Number number) throws IOException {
            bVar.a(number);
        }
    };
    public static final TypeAdapter<Number> pvO = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.14
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            JsonToken eyz = aVar.eyz();
            switch (AnonymousClass36.puW[eyz.ordinal()]) {
                case 1:
                case 3:
                    return new LazilyParsedNumber(aVar.eyD());
                case 2:
                default:
                    throw new JsonSyntaxException("Expecting number, got: " + eyz);
                case 4:
                    aVar.eyF();
                    return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.b bVar, Number number) throws IOException {
            bVar.a(number);
        }
    };
    public static final TypeAdapterFactory pvP = a(Number.class, pvO);
    public static final TypeAdapter<Character> pvQ = new TypeAdapter<Character>() { // from class: com.google.gson.internal.bind.TypeAdapters.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: h */
        public Character read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.eyz() == JsonToken.NULL) {
                aVar.eyF();
                return null;
            }
            String eyD = aVar.eyD();
            if (eyD.length() != 1) {
                throw new JsonSyntaxException("Expecting character, got: " + eyD);
            }
            return Character.valueOf(eyD.charAt(0));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, Character ch) throws IOException {
            bVar.ZG(ch == null ? null : String.valueOf(ch));
        }
    };
    public static final TypeAdapterFactory pvR = a(Character.TYPE, Character.class, pvQ);
    public static final TypeAdapter<String> pvS = new TypeAdapter<String>() { // from class: com.google.gson.internal.bind.TypeAdapters.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: i */
        public String read(com.google.gson.stream.a aVar) throws IOException {
            JsonToken eyz = aVar.eyz();
            if (eyz == JsonToken.NULL) {
                aVar.eyF();
                return null;
            } else if (eyz == JsonToken.BOOLEAN) {
                return Boolean.toString(aVar.eyE());
            } else {
                return aVar.eyD();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, String str) throws IOException {
            bVar.ZG(str);
        }
    };
    public static final TypeAdapter<BigDecimal> pvT = new TypeAdapter<BigDecimal>() { // from class: com.google.gson.internal.bind.TypeAdapters.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: j */
        public BigDecimal read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.eyz() == JsonToken.NULL) {
                aVar.eyF();
                return null;
            }
            try {
                return new BigDecimal(aVar.eyD());
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
    public static final TypeAdapter<BigInteger> pvU = new TypeAdapter<BigInteger>() { // from class: com.google.gson.internal.bind.TypeAdapters.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: k */
        public BigInteger read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.eyz() == JsonToken.NULL) {
                aVar.eyF();
                return null;
            }
            try {
                return new BigInteger(aVar.eyD());
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
    public static final TypeAdapterFactory pvV = a(String.class, pvS);
    public static final TypeAdapter<StringBuilder> pvW = new TypeAdapter<StringBuilder>() { // from class: com.google.gson.internal.bind.TypeAdapters.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: l */
        public StringBuilder read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.eyz() == JsonToken.NULL) {
                aVar.eyF();
                return null;
            }
            return new StringBuilder(aVar.eyD());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, StringBuilder sb) throws IOException {
            bVar.ZG(sb == null ? null : sb.toString());
        }
    };
    public static final TypeAdapterFactory pvX = a(StringBuilder.class, pvW);
    public static final TypeAdapter<StringBuffer> pvY = new TypeAdapter<StringBuffer>() { // from class: com.google.gson.internal.bind.TypeAdapters.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: n */
        public StringBuffer read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.eyz() == JsonToken.NULL) {
                aVar.eyF();
                return null;
            }
            return new StringBuffer(aVar.eyD());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, StringBuffer stringBuffer) throws IOException {
            bVar.ZG(stringBuffer == null ? null : stringBuffer.toString());
        }
    };
    public static final TypeAdapterFactory pvZ = a(StringBuffer.class, pvY);
    public static final TypeAdapter<URL> pwa = new TypeAdapter<URL>() { // from class: com.google.gson.internal.bind.TypeAdapters.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: o */
        public URL read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.eyz() == JsonToken.NULL) {
                aVar.eyF();
                return null;
            }
            String eyD = aVar.eyD();
            if ("null".equals(eyD)) {
                return null;
            }
            return new URL(eyD);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, URL url) throws IOException {
            bVar.ZG(url == null ? null : url.toExternalForm());
        }
    };
    public static final TypeAdapterFactory pwb = a(URL.class, pwa);
    public static final TypeAdapter<URI> pwc = new TypeAdapter<URI>() { // from class: com.google.gson.internal.bind.TypeAdapters.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: p */
        public URI read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.eyz() == JsonToken.NULL) {
                aVar.eyF();
                return null;
            }
            try {
                String eyD = aVar.eyD();
                if ("null".equals(eyD)) {
                    return null;
                }
                return new URI(eyD);
            } catch (URISyntaxException e) {
                throw new JsonIOException(e);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, URI uri) throws IOException {
            bVar.ZG(uri == null ? null : uri.toASCIIString());
        }
    };
    public static final TypeAdapterFactory pwd = a(URI.class, pwc);
    public static final TypeAdapter<InetAddress> pwe = new TypeAdapter<InetAddress>() { // from class: com.google.gson.internal.bind.TypeAdapters.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: q */
        public InetAddress read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.eyz() == JsonToken.NULL) {
                aVar.eyF();
                return null;
            }
            return InetAddress.getByName(aVar.eyD());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, InetAddress inetAddress) throws IOException {
            bVar.ZG(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    };
    public static final TypeAdapterFactory pwf = b(InetAddress.class, pwe);
    public static final TypeAdapter<UUID> pwg = new TypeAdapter<UUID>() { // from class: com.google.gson.internal.bind.TypeAdapters.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: r */
        public UUID read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.eyz() == JsonToken.NULL) {
                aVar.eyF();
                return null;
            }
            return UUID.fromString(aVar.eyD());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, UUID uuid) throws IOException {
            bVar.ZG(uuid == null ? null : uuid.toString());
        }
    };
    public static final TypeAdapterFactory pwh = a(UUID.class, pwg);
    public static final TypeAdapter<Currency> pwi = new TypeAdapter<Currency>() { // from class: com.google.gson.internal.bind.TypeAdapters.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: s */
        public Currency read(com.google.gson.stream.a aVar) throws IOException {
            return Currency.getInstance(aVar.eyD());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, Currency currency) throws IOException {
            bVar.ZG(currency.getCurrencyCode());
        }
    }.nullSafe();
    public static final TypeAdapterFactory pwj = a(Currency.class, pwi);
    public static final TypeAdapterFactory pwk = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.26
        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            if (aVar.eyW() != Timestamp.class) {
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
    public static final TypeAdapter<Calendar> pwl = new TypeAdapter<Calendar>() { // from class: com.google.gson.internal.bind.TypeAdapters.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: u */
        public Calendar read(com.google.gson.stream.a aVar) throws IOException {
            int i = 0;
            if (aVar.eyz() == JsonToken.NULL) {
                aVar.eyF();
                return null;
            }
            aVar.eyy();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (aVar.eyz() != JsonToken.END_OBJECT) {
                String eyC = aVar.eyC();
                int eyI = aVar.eyI();
                if ("year".equals(eyC)) {
                    i6 = eyI;
                } else if ("month".equals(eyC)) {
                    i5 = eyI;
                } else if ("dayOfMonth".equals(eyC)) {
                    i4 = eyI;
                } else if ("hourOfDay".equals(eyC)) {
                    i3 = eyI;
                } else if ("minute".equals(eyC)) {
                    i2 = eyI;
                } else if ("second".equals(eyC)) {
                    i = eyI;
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
                bVar.eyS();
                return;
            }
            bVar.eyQ();
            bVar.ZF("year");
            bVar.iC(calendar.get(1));
            bVar.ZF("month");
            bVar.iC(calendar.get(2));
            bVar.ZF("dayOfMonth");
            bVar.iC(calendar.get(5));
            bVar.ZF("hourOfDay");
            bVar.iC(calendar.get(11));
            bVar.ZF("minute");
            bVar.iC(calendar.get(12));
            bVar.ZF("second");
            bVar.iC(calendar.get(13));
            bVar.eyR();
        }
    };
    public static final TypeAdapterFactory pwm = b(Calendar.class, GregorianCalendar.class, pwl);
    public static final TypeAdapter<Locale> pwn = new TypeAdapter<Locale>() { // from class: com.google.gson.internal.bind.TypeAdapters.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: v */
        public Locale read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.eyz() == JsonToken.NULL) {
                aVar.eyF();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(aVar.eyD(), PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
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
            bVar.ZG(locale == null ? null : locale.toString());
        }
    };
    public static final TypeAdapterFactory pwo = a(Locale.class, pwn);
    public static final TypeAdapter<JsonElement> pwp = new TypeAdapter<JsonElement>() { // from class: com.google.gson.internal.bind.TypeAdapters.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: w */
        public JsonElement read(com.google.gson.stream.a aVar) throws IOException {
            switch (AnonymousClass36.puW[aVar.eyz().ordinal()]) {
                case 1:
                    return new JsonPrimitive((Number) new LazilyParsedNumber(aVar.eyD()));
                case 2:
                    return new JsonPrimitive(Boolean.valueOf(aVar.eyE()));
                case 3:
                    return new JsonPrimitive(aVar.eyD());
                case 4:
                    aVar.eyF();
                    return JsonNull.INSTANCE;
                case 5:
                    JsonArray jsonArray = new JsonArray();
                    aVar.eyx();
                    while (aVar.hasNext()) {
                        jsonArray.add(read(aVar));
                    }
                    aVar.endArray();
                    return jsonArray;
                case 6:
                    JsonObject jsonObject = new JsonObject();
                    aVar.eyy();
                    while (aVar.hasNext()) {
                        jsonObject.add(aVar.eyC(), read(aVar));
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
                bVar.eyS();
            } else if (jsonElement.isJsonPrimitive()) {
                JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
                if (asJsonPrimitive.isNumber()) {
                    bVar.a(asJsonPrimitive.getAsNumber());
                } else if (asJsonPrimitive.isBoolean()) {
                    bVar.Bc(asJsonPrimitive.getAsBoolean());
                } else {
                    bVar.ZG(asJsonPrimitive.getAsString());
                }
            } else if (jsonElement.isJsonArray()) {
                bVar.eyO();
                Iterator<JsonElement> it = jsonElement.getAsJsonArray().iterator();
                while (it.hasNext()) {
                    write(bVar, it.next());
                }
                bVar.eyP();
            } else if (jsonElement.isJsonObject()) {
                bVar.eyQ();
                for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
                    bVar.ZF(entry.getKey());
                    write(bVar, entry.getValue());
                }
                bVar.eyR();
            } else {
                throw new IllegalArgumentException("Couldn't write " + jsonElement.getClass());
            }
        }
    };
    public static final TypeAdapterFactory pwq = b(JsonElement.class, pwp);
    public static final TypeAdapterFactory pwr = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.30
        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            Class eyW = aVar.eyW();
            if (!Enum.class.isAssignableFrom(eyW) || eyW == Enum.class) {
                return null;
            }
            if (!eyW.isEnum()) {
                eyW = (Class<? super Object>) eyW.getSuperclass();
            }
            return new EnumTypeAdapter(eyW);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.gson.internal.bind.TypeAdapters$36  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass36 {
        static final /* synthetic */ int[] puW = new int[JsonToken.values().length];

        static {
            try {
                puW[JsonToken.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                puW[JsonToken.BOOLEAN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                puW[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                puW[JsonToken.NULL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                puW[JsonToken.BEGIN_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                puW[JsonToken.BEGIN_OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                puW[JsonToken.END_DOCUMENT.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                puW[JsonToken.NAME.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                puW[JsonToken.END_OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                puW[JsonToken.END_ARRAY.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
        }
    }

    /* loaded from: classes5.dex */
    private static final class EnumTypeAdapter<T extends Enum<T>> extends TypeAdapter<T> {
        private final Map<String, T> pwC = new HashMap();
        private final Map<T, String> pwD = new HashMap();

        public EnumTypeAdapter(Class<T> cls) {
            T[] enumConstants;
            try {
                for (T t : cls.getEnumConstants()) {
                    String name = t.name();
                    c cVar = (c) cls.getField(name).getAnnotation(c.class);
                    if (cVar != null) {
                        name = cVar.value();
                        String[] eyf = cVar.eyf();
                        for (String str : eyf) {
                            this.pwC.put(str, t);
                        }
                    }
                    String str2 = name;
                    this.pwC.put(str2, t);
                    this.pwD.put(t, str2);
                }
            } catch (NoSuchFieldException e) {
                throw new AssertionError(e);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: A */
        public T read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.eyz() == JsonToken.NULL) {
                aVar.eyF();
                return null;
            }
            return this.pwC.get(aVar.eyD());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, T t) throws IOException {
            bVar.ZG(t == null ? null : this.pwD.get(t));
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
                if (aVar.eyW() == cls) {
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
                Class<? super T> eyW = aVar.eyW();
                if (eyW == cls || eyW == cls2) {
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
                Class<? super T> eyW = aVar.eyW();
                if (eyW == cls || eyW == cls2) {
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
                final Class<? super T2> eyW = aVar.eyW();
                if (cls.isAssignableFrom(eyW)) {
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
                            if (read != 0 && !eyW.isInstance(read)) {
                                throw new JsonSyntaxException("Expected a " + eyW.getName() + " but was " + read.getClass().getName());
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
