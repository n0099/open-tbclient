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
/* loaded from: classes5.dex */
public final class a extends com.google.gson.stream.a {
    private static final Reader pfy = new Reader() { // from class: com.google.gson.internal.bind.a.1
        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }
    };
    private static final Object pfz = new Object();
    private Object[] pfA;
    private int pfB;
    private String[] pfC;
    private int[] pfD;

    public a(JsonElement jsonElement) {
        super(pfy);
        this.pfA = new Object[32];
        this.pfB = 0;
        this.pfC = new String[32];
        this.pfD = new int[32];
        push(jsonElement);
    }

    @Override // com.google.gson.stream.a
    public void esU() throws IOException {
        a(JsonToken.BEGIN_ARRAY);
        push(((JsonArray) esX()).iterator());
        this.pfD[this.pfB - 1] = 0;
    }

    @Override // com.google.gson.stream.a
    public void endArray() throws IOException {
        a(JsonToken.END_ARRAY);
        esY();
        esY();
        if (this.pfB > 0) {
            int[] iArr = this.pfD;
            int i = this.pfB - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public void esV() throws IOException {
        a(JsonToken.BEGIN_OBJECT);
        push(((JsonObject) esX()).entrySet().iterator());
    }

    @Override // com.google.gson.stream.a
    public void endObject() throws IOException {
        a(JsonToken.END_OBJECT);
        esY();
        esY();
        if (this.pfB > 0) {
            int[] iArr = this.pfD;
            int i = this.pfB - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public boolean hasNext() throws IOException {
        JsonToken esW = esW();
        return (esW == JsonToken.END_OBJECT || esW == JsonToken.END_ARRAY) ? false : true;
    }

    @Override // com.google.gson.stream.a
    public JsonToken esW() throws IOException {
        if (this.pfB == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object esX = esX();
        if (esX instanceof Iterator) {
            boolean z = this.pfA[this.pfB - 2] instanceof JsonObject;
            Iterator it = (Iterator) esX;
            if (!it.hasNext()) {
                return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            } else if (z) {
                return JsonToken.NAME;
            } else {
                push(it.next());
                return esW();
            }
        } else if (esX instanceof JsonObject) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (esX instanceof JsonArray) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (esX instanceof JsonPrimitive) {
                JsonPrimitive jsonPrimitive = (JsonPrimitive) esX;
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
            } else if (esX instanceof JsonNull) {
                return JsonToken.NULL;
            } else {
                if (esX == pfz) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    private Object esX() {
        return this.pfA[this.pfB - 1];
    }

    private Object esY() {
        Object[] objArr = this.pfA;
        int i = this.pfB - 1;
        this.pfB = i;
        Object obj = objArr[i];
        this.pfA[this.pfB] = null;
        return obj;
    }

    private void a(JsonToken jsonToken) throws IOException {
        if (esW() != jsonToken) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + esW() + ete());
        }
    }

    @Override // com.google.gson.stream.a
    public String esZ() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) esX()).next();
        String str = (String) entry.getKey();
        this.pfC[this.pfB - 1] = str;
        push(entry.getValue());
        return str;
    }

    @Override // com.google.gson.stream.a
    public String eta() throws IOException {
        JsonToken esW = esW();
        if (esW != JsonToken.STRING && esW != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected " + JsonToken.STRING + " but was " + esW + ete());
        }
        String asString = ((JsonPrimitive) esY()).getAsString();
        if (this.pfB > 0) {
            int[] iArr = this.pfD;
            int i = this.pfB - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asString;
    }

    @Override // com.google.gson.stream.a
    public boolean nextBoolean() throws IOException {
        a(JsonToken.BOOLEAN);
        boolean asBoolean = ((JsonPrimitive) esY()).getAsBoolean();
        if (this.pfB > 0) {
            int[] iArr = this.pfD;
            int i = this.pfB - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asBoolean;
    }

    @Override // com.google.gson.stream.a
    public void etb() throws IOException {
        a(JsonToken.NULL);
        esY();
        if (this.pfB > 0) {
            int[] iArr = this.pfD;
            int i = this.pfB - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public double nextDouble() throws IOException {
        JsonToken esW = esW();
        if (esW != JsonToken.NUMBER && esW != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + esW + ete());
        }
        double asDouble = ((JsonPrimitive) esX()).getAsDouble();
        if (!etq() && (Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + asDouble);
        }
        esY();
        if (this.pfB > 0) {
            int[] iArr = this.pfD;
            int i = this.pfB - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asDouble;
    }

    @Override // com.google.gson.stream.a
    public long nextLong() throws IOException {
        JsonToken esW = esW();
        if (esW != JsonToken.NUMBER && esW != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + esW + ete());
        }
        long asLong = ((JsonPrimitive) esX()).getAsLong();
        esY();
        if (this.pfB > 0) {
            int[] iArr = this.pfD;
            int i = this.pfB - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asLong;
    }

    @Override // com.google.gson.stream.a
    public int nextInt() throws IOException {
        JsonToken esW = esW();
        if (esW != JsonToken.NUMBER && esW != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + esW + ete());
        }
        int asInt = ((JsonPrimitive) esX()).getAsInt();
        esY();
        if (this.pfB > 0) {
            int[] iArr = this.pfD;
            int i = this.pfB - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asInt;
    }

    @Override // com.google.gson.stream.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.pfA = new Object[]{pfz};
        this.pfB = 1;
    }

    @Override // com.google.gson.stream.a
    public void etc() throws IOException {
        if (esW() == JsonToken.NAME) {
            esZ();
            this.pfC[this.pfB - 2] = "null";
        } else {
            esY();
            if (this.pfB > 0) {
                this.pfC[this.pfB - 1] = "null";
            }
        }
        if (this.pfB > 0) {
            int[] iArr = this.pfD;
            int i = this.pfB - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public String toString() {
        return getClass().getSimpleName();
    }

    public void etd() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) esX()).next();
        push(entry.getValue());
        push(new JsonPrimitive((String) entry.getKey()));
    }

    private void push(Object obj) {
        if (this.pfB == this.pfA.length) {
            Object[] objArr = new Object[this.pfB * 2];
            int[] iArr = new int[this.pfB * 2];
            String[] strArr = new String[this.pfB * 2];
            System.arraycopy(this.pfA, 0, objArr, 0, this.pfB);
            System.arraycopy(this.pfD, 0, iArr, 0, this.pfB);
            System.arraycopy(this.pfC, 0, strArr, 0, this.pfB);
            this.pfA = objArr;
            this.pfD = iArr;
            this.pfC = strArr;
        }
        Object[] objArr2 = this.pfA;
        int i = this.pfB;
        this.pfB = i + 1;
        objArr2[i] = obj;
    }

    @Override // com.google.gson.stream.a
    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = 0;
        while (i < this.pfB) {
            if (this.pfA[i] instanceof JsonArray) {
                i++;
                if (this.pfA[i] instanceof Iterator) {
                    append.append('[').append(this.pfD[i]).append(']');
                }
            } else if (this.pfA[i] instanceof JsonObject) {
                i++;
                if (this.pfA[i] instanceof Iterator) {
                    append.append('.');
                    if (this.pfC[i] != null) {
                        append.append(this.pfC[i]);
                    }
                }
            }
            i++;
        }
        return append.toString();
    }

    private String ete() {
        return " at path " + getPath();
    }
}
