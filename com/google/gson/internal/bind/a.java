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
    private static final Reader pdV = new Reader() { // from class: com.google.gson.internal.bind.a.1
        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }
    };
    private static final Object pdW = new Object();
    private Object[] pdX;
    private int pdY;
    private String[] pdZ;
    private int[] pea;

    public a(JsonElement jsonElement) {
        super(pdV);
        this.pdX = new Object[32];
        this.pdY = 0;
        this.pdZ = new String[32];
        this.pea = new int[32];
        push(jsonElement);
    }

    @Override // com.google.gson.stream.a
    public void esU() throws IOException {
        a(JsonToken.BEGIN_ARRAY);
        push(((JsonArray) esX()).iterator());
        this.pea[this.pdY - 1] = 0;
    }

    @Override // com.google.gson.stream.a
    public void endArray() throws IOException {
        a(JsonToken.END_ARRAY);
        esY();
        esY();
        if (this.pdY > 0) {
            int[] iArr = this.pea;
            int i = this.pdY - 1;
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
        if (this.pdY > 0) {
            int[] iArr = this.pea;
            int i = this.pdY - 1;
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
        if (this.pdY == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object esX = esX();
        if (esX instanceof Iterator) {
            boolean z = this.pdX[this.pdY - 2] instanceof JsonObject;
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
                if (esX == pdW) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    private Object esX() {
        return this.pdX[this.pdY - 1];
    }

    private Object esY() {
        Object[] objArr = this.pdX;
        int i = this.pdY - 1;
        this.pdY = i;
        Object obj = objArr[i];
        this.pdX[this.pdY] = null;
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
        this.pdZ[this.pdY - 1] = str;
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
        if (this.pdY > 0) {
            int[] iArr = this.pea;
            int i = this.pdY - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asString;
    }

    @Override // com.google.gson.stream.a
    public boolean nextBoolean() throws IOException {
        a(JsonToken.BOOLEAN);
        boolean asBoolean = ((JsonPrimitive) esY()).getAsBoolean();
        if (this.pdY > 0) {
            int[] iArr = this.pea;
            int i = this.pdY - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asBoolean;
    }

    @Override // com.google.gson.stream.a
    public void etb() throws IOException {
        a(JsonToken.NULL);
        esY();
        if (this.pdY > 0) {
            int[] iArr = this.pea;
            int i = this.pdY - 1;
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
        if (this.pdY > 0) {
            int[] iArr = this.pea;
            int i = this.pdY - 1;
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
        if (this.pdY > 0) {
            int[] iArr = this.pea;
            int i = this.pdY - 1;
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
        if (this.pdY > 0) {
            int[] iArr = this.pea;
            int i = this.pdY - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asInt;
    }

    @Override // com.google.gson.stream.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.pdX = new Object[]{pdW};
        this.pdY = 1;
    }

    @Override // com.google.gson.stream.a
    public void etc() throws IOException {
        if (esW() == JsonToken.NAME) {
            esZ();
            this.pdZ[this.pdY - 2] = "null";
        } else {
            esY();
            if (this.pdY > 0) {
                this.pdZ[this.pdY - 1] = "null";
            }
        }
        if (this.pdY > 0) {
            int[] iArr = this.pea;
            int i = this.pdY - 1;
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
        if (this.pdY == this.pdX.length) {
            Object[] objArr = new Object[this.pdY * 2];
            int[] iArr = new int[this.pdY * 2];
            String[] strArr = new String[this.pdY * 2];
            System.arraycopy(this.pdX, 0, objArr, 0, this.pdY);
            System.arraycopy(this.pea, 0, iArr, 0, this.pdY);
            System.arraycopy(this.pdZ, 0, strArr, 0, this.pdY);
            this.pdX = objArr;
            this.pea = iArr;
            this.pdZ = strArr;
        }
        Object[] objArr2 = this.pdX;
        int i = this.pdY;
        this.pdY = i + 1;
        objArr2[i] = obj;
    }

    @Override // com.google.gson.stream.a
    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = 0;
        while (i < this.pdY) {
            if (this.pdX[i] instanceof JsonArray) {
                i++;
                if (this.pdX[i] instanceof Iterator) {
                    append.append('[').append(this.pea[i]).append(']');
                }
            } else if (this.pdX[i] instanceof JsonObject) {
                i++;
                if (this.pdX[i] instanceof Iterator) {
                    append.append('.');
                    if (this.pdZ[i] != null) {
                        append.append(this.pdZ[i]);
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
