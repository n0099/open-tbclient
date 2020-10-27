package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes17.dex */
public final class a extends com.google.gson.stream.a {
    private static final Reader oUA = new Reader() { // from class: com.google.gson.internal.bind.a.1
        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }
    };
    private static final Object oUB = new Object();
    private Object[] oUC;
    private int oUD;
    private String[] oUE;
    private int[] oUF;

    public a(JsonElement jsonElement) {
        super(oUA);
        this.oUC = new Object[32];
        this.oUD = 0;
        this.oUE = new String[32];
        this.oUF = new int[32];
        push(jsonElement);
    }

    @Override // com.google.gson.stream.a
    public void epf() throws IOException {
        a(JsonToken.BEGIN_ARRAY);
        push(((JsonArray) epi()).iterator());
        this.oUF[this.oUD - 1] = 0;
    }

    @Override // com.google.gson.stream.a
    public void endArray() throws IOException {
        a(JsonToken.END_ARRAY);
        epj();
        epj();
        if (this.oUD > 0) {
            int[] iArr = this.oUF;
            int i = this.oUD - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public void epg() throws IOException {
        a(JsonToken.BEGIN_OBJECT);
        push(((JsonObject) epi()).entrySet().iterator());
    }

    @Override // com.google.gson.stream.a
    public void endObject() throws IOException {
        a(JsonToken.END_OBJECT);
        epj();
        epj();
        if (this.oUD > 0) {
            int[] iArr = this.oUF;
            int i = this.oUD - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public boolean hasNext() throws IOException {
        JsonToken eph = eph();
        return (eph == JsonToken.END_OBJECT || eph == JsonToken.END_ARRAY) ? false : true;
    }

    @Override // com.google.gson.stream.a
    public JsonToken eph() throws IOException {
        if (this.oUD == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object epi = epi();
        if (epi instanceof Iterator) {
            boolean z = this.oUC[this.oUD - 2] instanceof JsonObject;
            Iterator it = (Iterator) epi;
            if (!it.hasNext()) {
                return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            } else if (z) {
                return JsonToken.NAME;
            } else {
                push(it.next());
                return eph();
            }
        } else if (epi instanceof JsonObject) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (epi instanceof JsonArray) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (epi instanceof JsonPrimitive) {
                JsonPrimitive jsonPrimitive = (JsonPrimitive) epi;
                if (jsonPrimitive.isString()) {
                    return JsonToken.STRING;
                }
                if (jsonPrimitive.isBoolean()) {
                    return JsonToken.BOOLEAN;
                }
                if (jsonPrimitive.isNumber()) {
                    return JsonToken.NUMBER;
                }
                throw new AssertionError();
            } else if (epi instanceof JsonNull) {
                return JsonToken.NULL;
            } else {
                if (epi == oUB) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    private Object epi() {
        return this.oUC[this.oUD - 1];
    }

    private Object epj() {
        Object[] objArr = this.oUC;
        int i = this.oUD - 1;
        this.oUD = i;
        Object obj = objArr[i];
        this.oUC[this.oUD] = null;
        return obj;
    }

    private void a(JsonToken jsonToken) throws IOException {
        if (eph() != jsonToken) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + eph() + epp());
        }
    }

    @Override // com.google.gson.stream.a
    public String epk() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) epi()).next();
        String str = (String) entry.getKey();
        this.oUE[this.oUD - 1] = str;
        push(entry.getValue());
        return str;
    }

    @Override // com.google.gson.stream.a
    public String epl() throws IOException {
        JsonToken eph = eph();
        if (eph != JsonToken.STRING && eph != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected " + JsonToken.STRING + " but was " + eph + epp());
        }
        String asString = ((JsonPrimitive) epj()).getAsString();
        if (this.oUD > 0) {
            int[] iArr = this.oUF;
            int i = this.oUD - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asString;
    }

    @Override // com.google.gson.stream.a
    public boolean nextBoolean() throws IOException {
        a(JsonToken.BOOLEAN);
        boolean asBoolean = ((JsonPrimitive) epj()).getAsBoolean();
        if (this.oUD > 0) {
            int[] iArr = this.oUF;
            int i = this.oUD - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asBoolean;
    }

    @Override // com.google.gson.stream.a
    public void epm() throws IOException {
        a(JsonToken.NULL);
        epj();
        if (this.oUD > 0) {
            int[] iArr = this.oUF;
            int i = this.oUD - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public double nextDouble() throws IOException {
        JsonToken eph = eph();
        if (eph != JsonToken.NUMBER && eph != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + eph + epp());
        }
        double asDouble = ((JsonPrimitive) epi()).getAsDouble();
        if (!epB() && (Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + asDouble);
        }
        epj();
        if (this.oUD > 0) {
            int[] iArr = this.oUF;
            int i = this.oUD - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asDouble;
    }

    @Override // com.google.gson.stream.a
    public long nextLong() throws IOException {
        JsonToken eph = eph();
        if (eph != JsonToken.NUMBER && eph != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + eph + epp());
        }
        long asLong = ((JsonPrimitive) epi()).getAsLong();
        epj();
        if (this.oUD > 0) {
            int[] iArr = this.oUF;
            int i = this.oUD - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asLong;
    }

    @Override // com.google.gson.stream.a
    public int nextInt() throws IOException {
        JsonToken eph = eph();
        if (eph != JsonToken.NUMBER && eph != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + eph + epp());
        }
        int asInt = ((JsonPrimitive) epi()).getAsInt();
        epj();
        if (this.oUD > 0) {
            int[] iArr = this.oUF;
            int i = this.oUD - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asInt;
    }

    @Override // com.google.gson.stream.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.oUC = new Object[]{oUB};
        this.oUD = 1;
    }

    @Override // com.google.gson.stream.a
    public void epn() throws IOException {
        if (eph() == JsonToken.NAME) {
            epk();
            this.oUE[this.oUD - 2] = "null";
        } else {
            epj();
            if (this.oUD > 0) {
                this.oUE[this.oUD - 1] = "null";
            }
        }
        if (this.oUD > 0) {
            int[] iArr = this.oUF;
            int i = this.oUD - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public String toString() {
        return getClass().getSimpleName();
    }

    public void epo() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) epi()).next();
        push(entry.getValue());
        push(new JsonPrimitive((String) entry.getKey()));
    }

    private void push(Object obj) {
        if (this.oUD == this.oUC.length) {
            Object[] objArr = new Object[this.oUD * 2];
            int[] iArr = new int[this.oUD * 2];
            String[] strArr = new String[this.oUD * 2];
            System.arraycopy(this.oUC, 0, objArr, 0, this.oUD);
            System.arraycopy(this.oUF, 0, iArr, 0, this.oUD);
            System.arraycopy(this.oUE, 0, strArr, 0, this.oUD);
            this.oUC = objArr;
            this.oUF = iArr;
            this.oUE = strArr;
        }
        Object[] objArr2 = this.oUC;
        int i = this.oUD;
        this.oUD = i + 1;
        objArr2[i] = obj;
    }

    @Override // com.google.gson.stream.a
    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = 0;
        while (i < this.oUD) {
            if (this.oUC[i] instanceof JsonArray) {
                i++;
                if (this.oUC[i] instanceof Iterator) {
                    append.append('[').append(this.oUF[i]).append(']');
                }
            } else if (this.oUC[i] instanceof JsonObject) {
                i++;
                if (this.oUC[i] instanceof Iterator) {
                    append.append('.');
                    if (this.oUE[i] != null) {
                        append.append(this.oUE[i]);
                    }
                }
            }
            i++;
        }
        return append.toString();
    }

    private String epp() {
        return " at path " + getPath();
    }
}
