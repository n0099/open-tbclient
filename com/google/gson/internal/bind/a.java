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
/* loaded from: classes23.dex */
public final class a extends com.google.gson.stream.a {
    private static final Reader nNS = new Reader() { // from class: com.google.gson.internal.bind.a.1
        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }
    };
    private static final Object nNT = new Object();
    private Object[] nNU;
    private int nNV;
    private String[] nNW;
    private int[] nNX;

    public a(JsonElement jsonElement) {
        super(nNS);
        this.nNU = new Object[32];
        this.nNV = 0;
        this.nNW = new String[32];
        this.nNX = new int[32];
        push(jsonElement);
    }

    @Override // com.google.gson.stream.a
    public void ebu() throws IOException {
        a(JsonToken.BEGIN_ARRAY);
        push(((JsonArray) ebx()).iterator());
        this.nNX[this.nNV - 1] = 0;
    }

    @Override // com.google.gson.stream.a
    public void endArray() throws IOException {
        a(JsonToken.END_ARRAY);
        eby();
        eby();
        if (this.nNV > 0) {
            int[] iArr = this.nNX;
            int i = this.nNV - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public void ebv() throws IOException {
        a(JsonToken.BEGIN_OBJECT);
        push(((JsonObject) ebx()).entrySet().iterator());
    }

    @Override // com.google.gson.stream.a
    public void endObject() throws IOException {
        a(JsonToken.END_OBJECT);
        eby();
        eby();
        if (this.nNV > 0) {
            int[] iArr = this.nNX;
            int i = this.nNV - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public boolean hasNext() throws IOException {
        JsonToken ebw = ebw();
        return (ebw == JsonToken.END_OBJECT || ebw == JsonToken.END_ARRAY) ? false : true;
    }

    @Override // com.google.gson.stream.a
    public JsonToken ebw() throws IOException {
        if (this.nNV == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object ebx = ebx();
        if (ebx instanceof Iterator) {
            boolean z = this.nNU[this.nNV - 2] instanceof JsonObject;
            Iterator it = (Iterator) ebx;
            if (!it.hasNext()) {
                return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            } else if (z) {
                return JsonToken.NAME;
            } else {
                push(it.next());
                return ebw();
            }
        } else if (ebx instanceof JsonObject) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (ebx instanceof JsonArray) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (ebx instanceof JsonPrimitive) {
                JsonPrimitive jsonPrimitive = (JsonPrimitive) ebx;
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
            } else if (ebx instanceof JsonNull) {
                return JsonToken.NULL;
            } else {
                if (ebx == nNT) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    private Object ebx() {
        return this.nNU[this.nNV - 1];
    }

    private Object eby() {
        Object[] objArr = this.nNU;
        int i = this.nNV - 1;
        this.nNV = i;
        Object obj = objArr[i];
        this.nNU[this.nNV] = null;
        return obj;
    }

    private void a(JsonToken jsonToken) throws IOException {
        if (ebw() != jsonToken) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + ebw() + ebE());
        }
    }

    @Override // com.google.gson.stream.a
    public String ebz() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) ebx()).next();
        String str = (String) entry.getKey();
        this.nNW[this.nNV - 1] = str;
        push(entry.getValue());
        return str;
    }

    @Override // com.google.gson.stream.a
    public String ebA() throws IOException {
        JsonToken ebw = ebw();
        if (ebw != JsonToken.STRING && ebw != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected " + JsonToken.STRING + " but was " + ebw + ebE());
        }
        String asString = ((JsonPrimitive) eby()).getAsString();
        if (this.nNV > 0) {
            int[] iArr = this.nNX;
            int i = this.nNV - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asString;
    }

    @Override // com.google.gson.stream.a
    public boolean nextBoolean() throws IOException {
        a(JsonToken.BOOLEAN);
        boolean asBoolean = ((JsonPrimitive) eby()).getAsBoolean();
        if (this.nNV > 0) {
            int[] iArr = this.nNX;
            int i = this.nNV - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asBoolean;
    }

    @Override // com.google.gson.stream.a
    public void ebB() throws IOException {
        a(JsonToken.NULL);
        eby();
        if (this.nNV > 0) {
            int[] iArr = this.nNX;
            int i = this.nNV - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public double nextDouble() throws IOException {
        JsonToken ebw = ebw();
        if (ebw != JsonToken.NUMBER && ebw != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + ebw + ebE());
        }
        double asDouble = ((JsonPrimitive) ebx()).getAsDouble();
        if (!ebQ() && (Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + asDouble);
        }
        eby();
        if (this.nNV > 0) {
            int[] iArr = this.nNX;
            int i = this.nNV - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asDouble;
    }

    @Override // com.google.gson.stream.a
    public long nextLong() throws IOException {
        JsonToken ebw = ebw();
        if (ebw != JsonToken.NUMBER && ebw != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + ebw + ebE());
        }
        long asLong = ((JsonPrimitive) ebx()).getAsLong();
        eby();
        if (this.nNV > 0) {
            int[] iArr = this.nNX;
            int i = this.nNV - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asLong;
    }

    @Override // com.google.gson.stream.a
    public int nextInt() throws IOException {
        JsonToken ebw = ebw();
        if (ebw != JsonToken.NUMBER && ebw != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + ebw + ebE());
        }
        int asInt = ((JsonPrimitive) ebx()).getAsInt();
        eby();
        if (this.nNV > 0) {
            int[] iArr = this.nNX;
            int i = this.nNV - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asInt;
    }

    @Override // com.google.gson.stream.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.nNU = new Object[]{nNT};
        this.nNV = 1;
    }

    @Override // com.google.gson.stream.a
    public void ebC() throws IOException {
        if (ebw() == JsonToken.NAME) {
            ebz();
            this.nNW[this.nNV - 2] = "null";
        } else {
            eby();
            if (this.nNV > 0) {
                this.nNW[this.nNV - 1] = "null";
            }
        }
        if (this.nNV > 0) {
            int[] iArr = this.nNX;
            int i = this.nNV - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public String toString() {
        return getClass().getSimpleName();
    }

    public void ebD() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) ebx()).next();
        push(entry.getValue());
        push(new JsonPrimitive((String) entry.getKey()));
    }

    private void push(Object obj) {
        if (this.nNV == this.nNU.length) {
            Object[] objArr = new Object[this.nNV * 2];
            int[] iArr = new int[this.nNV * 2];
            String[] strArr = new String[this.nNV * 2];
            System.arraycopy(this.nNU, 0, objArr, 0, this.nNV);
            System.arraycopy(this.nNX, 0, iArr, 0, this.nNV);
            System.arraycopy(this.nNW, 0, strArr, 0, this.nNV);
            this.nNU = objArr;
            this.nNX = iArr;
            this.nNW = strArr;
        }
        Object[] objArr2 = this.nNU;
        int i = this.nNV;
        this.nNV = i + 1;
        objArr2[i] = obj;
    }

    @Override // com.google.gson.stream.a
    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = 0;
        while (i < this.nNV) {
            if (this.nNU[i] instanceof JsonArray) {
                i++;
                if (this.nNU[i] instanceof Iterator) {
                    append.append('[').append(this.nNX[i]).append(']');
                }
            } else if (this.nNU[i] instanceof JsonObject) {
                i++;
                if (this.nNU[i] instanceof Iterator) {
                    append.append('.');
                    if (this.nNW[i] != null) {
                        append.append(this.nNW[i]);
                    }
                }
            }
            i++;
        }
        return append.toString();
    }

    private String ebE() {
        return " at path " + getPath();
    }
}
