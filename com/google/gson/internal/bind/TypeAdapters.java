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
/* loaded from: classes23.dex */
public final class TypeAdapters {
    public static final TypeAdapter<Class> nOB = new TypeAdapter<Class>() { // from class: com.google.gson.internal.bind.TypeAdapters.1
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
    public static final TypeAdapterFactory nOC = a(Class.class, nOB);
    public static final TypeAdapter<BitSet> nOD = new TypeAdapter<BitSet>() { // from class: com.google.gson.internal.bind.TypeAdapters.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: m */
        public BitSet read(com.google.gson.stream.a aVar) throws IOException {
            boolean z;
            BitSet bitSet = new BitSet();
            aVar.ebu();
            JsonToken ebw = aVar.ebw();
            int i = 0;
            while (ebw != JsonToken.END_ARRAY) {
                switch (AnonymousClass36.nOf[ebw.ordinal()]) {
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
                        String ebA = aVar.ebA();
                        try {
                            if (Integer.parseInt(ebA) == 0) {
                                z = false;
                                break;
                            } else {
                                z = true;
                                break;
                            }
                        } catch (NumberFormatException e) {
                            throw new JsonSyntaxException("Error: Expecting: bitset number value (1, 0), Found: " + ebA);
                        }
                    default:
                        throw new JsonSyntaxException("Invalid bitset value type: " + ebw);
                }
                if (z) {
                    bitSet.set(i);
                }
                i++;
                ebw = aVar.ebw();
            }
            aVar.endArray();
            return bitSet;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, BitSet bitSet) throws IOException {
            bVar.ebH();
            int length = bitSet.length();
            for (int i = 0; i < length; i++) {
                bVar.gP(bitSet.get(i) ? 1 : 0);
            }
            bVar.ebI();
        }
    }.nullSafe();
    public static final TypeAdapterFactory nOE = a(BitSet.class, nOD);
    public static final TypeAdapter<Boolean> nOF = new TypeAdapter<Boolean>() { // from class: com.google.gson.internal.bind.TypeAdapters.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: x */
        public Boolean read(com.google.gson.stream.a aVar) throws IOException {
            JsonToken ebw = aVar.ebw();
            if (ebw == JsonToken.NULL) {
                aVar.ebB();
                return null;
            } else if (ebw == JsonToken.STRING) {
                return Boolean.valueOf(Boolean.parseBoolean(aVar.ebA()));
            } else {
                return Boolean.valueOf(aVar.nextBoolean());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, Boolean bool) throws IOException {
            bVar.u(bool);
        }
    };
    public static final TypeAdapter<Boolean> nOG = new TypeAdapter<Boolean>() { // from class: com.google.gson.internal.bind.TypeAdapters.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: x */
        public Boolean read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.ebw() == JsonToken.NULL) {
                aVar.ebB();
                return null;
            }
            return Boolean.valueOf(aVar.ebA());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, Boolean bool) throws IOException {
            bVar.Vv(bool == null ? "null" : bool.toString());
        }
    };
    public static final TypeAdapterFactory nOH = a(Boolean.TYPE, Boolean.class, nOF);
    public static final TypeAdapter<Number> nOI = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.5
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.ebw() == JsonToken.NULL) {
                aVar.ebB();
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
    public static final TypeAdapterFactory nOJ = a(Byte.TYPE, Byte.class, nOI);
    public static final TypeAdapter<Number> nOK = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.6
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.ebw() == JsonToken.NULL) {
                aVar.ebB();
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
    public static final TypeAdapterFactory nOL = a(Short.TYPE, Short.class, nOK);
    public static final TypeAdapter<Number> nOM = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.7
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.ebw() == JsonToken.NULL) {
                aVar.ebB();
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
    public static final TypeAdapterFactory nON = a(Integer.TYPE, Integer.class, nOM);
    public static final TypeAdapter<AtomicInteger> nOO = new TypeAdapter<AtomicInteger>() { // from class: com.google.gson.internal.bind.TypeAdapters.8
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
            bVar.gP(atomicInteger.get());
        }
    }.nullSafe();
    public static final TypeAdapterFactory nOP = a(AtomicInteger.class, nOO);
    public static final TypeAdapter<AtomicBoolean> nOQ = new TypeAdapter<AtomicBoolean>() { // from class: com.google.gson.internal.bind.TypeAdapters.9
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
            bVar.yy(atomicBoolean.get());
        }
    }.nullSafe();
    public static final TypeAdapterFactory nOR = a(AtomicBoolean.class, nOQ);
    public static final TypeAdapter<AtomicIntegerArray> nOS = new TypeAdapter<AtomicIntegerArray>() { // from class: com.google.gson.internal.bind.TypeAdapters.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: g */
        public AtomicIntegerArray read(com.google.gson.stream.a aVar) throws IOException {
            ArrayList arrayList = new ArrayList();
            aVar.ebu();
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
            bVar.ebH();
            int length = atomicIntegerArray.length();
            for (int i = 0; i < length; i++) {
                bVar.gP(atomicIntegerArray.get(i));
            }
            bVar.ebI();
        }
    }.nullSafe();
    public static final TypeAdapterFactory nOT = a(AtomicIntegerArray.class, nOS);
    public static final TypeAdapter<Number> nOU = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.11
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.ebw() == JsonToken.NULL) {
                aVar.ebB();
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
    public static final TypeAdapter<Number> nOV = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.12
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.ebw() == JsonToken.NULL) {
                aVar.ebB();
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
    public static final TypeAdapter<Number> nOW = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.13
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.ebw() == JsonToken.NULL) {
                aVar.ebB();
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
    public static final TypeAdapter<Number> nOX = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.14
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            JsonToken ebw = aVar.ebw();
            switch (AnonymousClass36.nOf[ebw.ordinal()]) {
                case 1:
                case 3:
                    return new LazilyParsedNumber(aVar.ebA());
                case 2:
                default:
                    throw new JsonSyntaxException("Expecting number, got: " + ebw);
                case 4:
                    aVar.ebB();
                    return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.b bVar, Number number) throws IOException {
            bVar.a(number);
        }
    };
    public static final TypeAdapterFactory nOY = a(Number.class, nOX);
    public static final TypeAdapter<Character> nOZ = new TypeAdapter<Character>() { // from class: com.google.gson.internal.bind.TypeAdapters.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: h */
        public Character read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.ebw() == JsonToken.NULL) {
                aVar.ebB();
                return null;
            }
            String ebA = aVar.ebA();
            if (ebA.length() != 1) {
                throw new JsonSyntaxException("Expecting character, got: " + ebA);
            }
            return Character.valueOf(ebA.charAt(0));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, Character ch) throws IOException {
            bVar.Vv(ch == null ? null : String.valueOf(ch));
        }
    };
    public static final TypeAdapterFactory nPa = a(Character.TYPE, Character.class, nOZ);
    public static final TypeAdapter<String> nPb = new TypeAdapter<String>() { // from class: com.google.gson.internal.bind.TypeAdapters.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: i */
        public String read(com.google.gson.stream.a aVar) throws IOException {
            JsonToken ebw = aVar.ebw();
            if (ebw == JsonToken.NULL) {
                aVar.ebB();
                return null;
            } else if (ebw == JsonToken.BOOLEAN) {
                return Boolean.toString(aVar.nextBoolean());
            } else {
                return aVar.ebA();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, String str) throws IOException {
            bVar.Vv(str);
        }
    };
    public static final TypeAdapter<BigDecimal> nPc = new TypeAdapter<BigDecimal>() { // from class: com.google.gson.internal.bind.TypeAdapters.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: j */
        public BigDecimal read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.ebw() == JsonToken.NULL) {
                aVar.ebB();
                return null;
            }
            try {
                return new BigDecimal(aVar.ebA());
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
    public static final TypeAdapter<BigInteger> nPd = new TypeAdapter<BigInteger>() { // from class: com.google.gson.internal.bind.TypeAdapters.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: k */
        public BigInteger read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.ebw() == JsonToken.NULL) {
                aVar.ebB();
                return null;
            }
            try {
                return new BigInteger(aVar.ebA());
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
    public static final TypeAdapterFactory nPe = a(String.class, nPb);
    public static final TypeAdapter<StringBuilder> nPf = new TypeAdapter<StringBuilder>() { // from class: com.google.gson.internal.bind.TypeAdapters.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: l */
        public StringBuilder read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.ebw() == JsonToken.NULL) {
                aVar.ebB();
                return null;
            }
            return new StringBuilder(aVar.ebA());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, StringBuilder sb) throws IOException {
            bVar.Vv(sb == null ? null : sb.toString());
        }
    };
    public static final TypeAdapterFactory nPg = a(StringBuilder.class, nPf);
    public static final TypeAdapter<StringBuffer> nPh = new TypeAdapter<StringBuffer>() { // from class: com.google.gson.internal.bind.TypeAdapters.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: n */
        public StringBuffer read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.ebw() == JsonToken.NULL) {
                aVar.ebB();
                return null;
            }
            return new StringBuffer(aVar.ebA());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, StringBuffer stringBuffer) throws IOException {
            bVar.Vv(stringBuffer == null ? null : stringBuffer.toString());
        }
    };
    public static final TypeAdapterFactory nPi = a(StringBuffer.class, nPh);
    public static final TypeAdapter<URL> nPj = new TypeAdapter<URL>() { // from class: com.google.gson.internal.bind.TypeAdapters.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: o */
        public URL read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.ebw() == JsonToken.NULL) {
                aVar.ebB();
                return null;
            }
            String ebA = aVar.ebA();
            if ("null".equals(ebA)) {
                return null;
            }
            return new URL(ebA);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, URL url) throws IOException {
            bVar.Vv(url == null ? null : url.toExternalForm());
        }
    };
    public static final TypeAdapterFactory nPk = a(URL.class, nPj);
    public static final TypeAdapter<URI> nPl = new TypeAdapter<URI>() { // from class: com.google.gson.internal.bind.TypeAdapters.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: p */
        public URI read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.ebw() == JsonToken.NULL) {
                aVar.ebB();
                return null;
            }
            try {
                String ebA = aVar.ebA();
                if ("null".equals(ebA)) {
                    return null;
                }
                return new URI(ebA);
            } catch (URISyntaxException e) {
                throw new JsonIOException(e);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, URI uri) throws IOException {
            bVar.Vv(uri == null ? null : uri.toASCIIString());
        }
    };
    public static final TypeAdapterFactory nPm = a(URI.class, nPl);
    public static final TypeAdapter<InetAddress> nPn = new TypeAdapter<InetAddress>() { // from class: com.google.gson.internal.bind.TypeAdapters.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: q */
        public InetAddress read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.ebw() == JsonToken.NULL) {
                aVar.ebB();
                return null;
            }
            return InetAddress.getByName(aVar.ebA());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, InetAddress inetAddress) throws IOException {
            bVar.Vv(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    };
    public static final TypeAdapterFactory nPo = b(InetAddress.class, nPn);
    public static final TypeAdapter<UUID> nPp = new TypeAdapter<UUID>() { // from class: com.google.gson.internal.bind.TypeAdapters.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: r */
        public UUID read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.ebw() == JsonToken.NULL) {
                aVar.ebB();
                return null;
            }
            return UUID.fromString(aVar.ebA());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, UUID uuid) throws IOException {
            bVar.Vv(uuid == null ? null : uuid.toString());
        }
    };
    public static final TypeAdapterFactory nPq = a(UUID.class, nPp);
    public static final TypeAdapter<Currency> nPr = new TypeAdapter<Currency>() { // from class: com.google.gson.internal.bind.TypeAdapters.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: s */
        public Currency read(com.google.gson.stream.a aVar) throws IOException {
            return Currency.getInstance(aVar.ebA());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, Currency currency) throws IOException {
            bVar.Vv(currency.getCurrencyCode());
        }
    }.nullSafe();
    public static final TypeAdapterFactory nPs = a(Currency.class, nPr);
    public static final TypeAdapterFactory nPt = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.26
        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            if (aVar.ebP() != Timestamp.class) {
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
    public static final TypeAdapter<Calendar> nPu = new TypeAdapter<Calendar>() { // from class: com.google.gson.internal.bind.TypeAdapters.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: u */
        public Calendar read(com.google.gson.stream.a aVar) throws IOException {
            int i = 0;
            if (aVar.ebw() == JsonToken.NULL) {
                aVar.ebB();
                return null;
            }
            aVar.ebv();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (aVar.ebw() != JsonToken.END_OBJECT) {
                String ebz = aVar.ebz();
                int nextInt = aVar.nextInt();
                if ("year".equals(ebz)) {
                    i6 = nextInt;
                } else if ("month".equals(ebz)) {
                    i5 = nextInt;
                } else if ("dayOfMonth".equals(ebz)) {
                    i4 = nextInt;
                } else if ("hourOfDay".equals(ebz)) {
                    i3 = nextInt;
                } else if ("minute".equals(ebz)) {
                    i2 = nextInt;
                } else if ("second".equals(ebz)) {
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
                bVar.ebL();
                return;
            }
            bVar.ebJ();
            bVar.Vu("year");
            bVar.gP(calendar.get(1));
            bVar.Vu("month");
            bVar.gP(calendar.get(2));
            bVar.Vu("dayOfMonth");
            bVar.gP(calendar.get(5));
            bVar.Vu("hourOfDay");
            bVar.gP(calendar.get(11));
            bVar.Vu("minute");
            bVar.gP(calendar.get(12));
            bVar.Vu("second");
            bVar.gP(calendar.get(13));
            bVar.ebK();
        }
    };
    public static final TypeAdapterFactory nPv = b(Calendar.class, GregorianCalendar.class, nPu);
    public static final TypeAdapter<Locale> nPw = new TypeAdapter<Locale>() { // from class: com.google.gson.internal.bind.TypeAdapters.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: v */
        public Locale read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.ebw() == JsonToken.NULL) {
                aVar.ebB();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(aVar.ebA(), PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
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
            bVar.Vv(locale == null ? null : locale.toString());
        }
    };
    public static final TypeAdapterFactory nPx = a(Locale.class, nPw);
    public static final TypeAdapter<JsonElement> nPy = new TypeAdapter<JsonElement>() { // from class: com.google.gson.internal.bind.TypeAdapters.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: w */
        public JsonElement read(com.google.gson.stream.a aVar) throws IOException {
            switch (AnonymousClass36.nOf[aVar.ebw().ordinal()]) {
                case 1:
                    return new JsonPrimitive((Number) new LazilyParsedNumber(aVar.ebA()));
                case 2:
                    return new JsonPrimitive(Boolean.valueOf(aVar.nextBoolean()));
                case 3:
                    return new JsonPrimitive(aVar.ebA());
                case 4:
                    aVar.ebB();
                    return JsonNull.INSTANCE;
                case 5:
                    JsonArray jsonArray = new JsonArray();
                    aVar.ebu();
                    while (aVar.hasNext()) {
                        jsonArray.add(read(aVar));
                    }
                    aVar.endArray();
                    return jsonArray;
                case 6:
                    JsonObject jsonObject = new JsonObject();
                    aVar.ebv();
                    while (aVar.hasNext()) {
                        jsonObject.add(aVar.ebz(), read(aVar));
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
                bVar.ebL();
            } else if (jsonElement.isJsonPrimitive()) {
                JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
                if (asJsonPrimitive.isNumber()) {
                    bVar.a(asJsonPrimitive.getAsNumber());
                } else if (asJsonPrimitive.isBoolean()) {
                    bVar.yy(asJsonPrimitive.getAsBoolean());
                } else {
                    bVar.Vv(asJsonPrimitive.getAsString());
                }
            } else if (jsonElement.isJsonArray()) {
                bVar.ebH();
                Iterator<JsonElement> it = jsonElement.getAsJsonArray().iterator();
                while (it.hasNext()) {
                    write(bVar, it.next());
                }
                bVar.ebI();
            } else if (jsonElement.isJsonObject()) {
                bVar.ebJ();
                for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
                    bVar.Vu(entry.getKey());
                    write(bVar, entry.getValue());
                }
                bVar.ebK();
            } else {
                throw new IllegalArgumentException("Couldn't write " + jsonElement.getClass());
            }
        }
    };
    public static final TypeAdapterFactory nPz = b(JsonElement.class, nPy);
    public static final TypeAdapterFactory nPA = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.30
        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            Class ebP = aVar.ebP();
            if (!Enum.class.isAssignableFrom(ebP) || ebP == Enum.class) {
                return null;
            }
            if (!ebP.isEnum()) {
                ebP = (Class<? super Object>) ebP.getSuperclass();
            }
            return new EnumTypeAdapter(ebP);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.gson.internal.bind.TypeAdapters$36  reason: invalid class name */
    /* loaded from: classes23.dex */
    public static /* synthetic */ class AnonymousClass36 {
        static final /* synthetic */ int[] nOf = new int[JsonToken.values().length];

        static {
            try {
                nOf[JsonToken.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                nOf[JsonToken.BOOLEAN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                nOf[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                nOf[JsonToken.NULL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                nOf[JsonToken.BEGIN_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                nOf[JsonToken.BEGIN_OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                nOf[JsonToken.END_DOCUMENT.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                nOf[JsonToken.NAME.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                nOf[JsonToken.END_OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                nOf[JsonToken.END_ARRAY.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
        }
    }

    /* loaded from: classes23.dex */
    private static final class EnumTypeAdapter<T extends Enum<T>> extends TypeAdapter<T> {
        private final Map<String, T> nPL = new HashMap();
        private final Map<T, String> nPM = new HashMap();

        public EnumTypeAdapter(Class<T> cls) {
            T[] enumConstants;
            try {
                for (T t : cls.getEnumConstants()) {
                    String name = t.name();
                    c cVar = (c) cls.getField(name).getAnnotation(c.class);
                    if (cVar != null) {
                        name = cVar.value();
                        String[] ebc = cVar.ebc();
                        for (String str : ebc) {
                            this.nPL.put(str, t);
                        }
                    }
                    String str2 = name;
                    this.nPL.put(str2, t);
                    this.nPM.put(t, str2);
                }
            } catch (NoSuchFieldException e) {
                throw new AssertionError(e);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: A */
        public T read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.ebw() == JsonToken.NULL) {
                aVar.ebB();
                return null;
            }
            return this.nPL.get(aVar.ebA());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, T t) throws IOException {
            bVar.Vv(t == null ? null : this.nPM.get(t));
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
                if (aVar.ebP() == cls) {
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
                Class<? super T> ebP = aVar.ebP();
                if (ebP == cls || ebP == cls2) {
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
                Class<? super T> ebP = aVar.ebP();
                if (ebP == cls || ebP == cls2) {
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
                final Class<? super T2> ebP = aVar.ebP();
                if (cls.isAssignableFrom(ebP)) {
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
                            if (read != 0 && !ebP.isInstance(read)) {
                                throw new JsonSyntaxException("Expected a " + ebP.getName() + " but was " + read.getClass().getName());
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
