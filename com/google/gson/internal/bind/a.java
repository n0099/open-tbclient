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
    private static final Reader pSV = new Reader() { // from class: com.google.gson.internal.bind.a.1
        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }
    };
    private static final Object pSW = new Object();
    private Object[] pSX;
    private int pSY;
    private String[] pSZ;
    private int[] pTa;

    public a(JsonElement jsonElement) {
        super(pSV);
        this.pSX = new Object[32];
        this.pSY = 0;
        this.pSZ = new String[32];
        this.pTa = new int[32];
        push(jsonElement);
    }

    @Override // com.google.gson.stream.a
    public void eBn() throws IOException {
        a(JsonToken.BEGIN_ARRAY);
        push(((JsonArray) eBq()).iterator());
        this.pTa[this.pSY - 1] = 0;
    }

    @Override // com.google.gson.stream.a
    public void endArray() throws IOException {
        a(JsonToken.END_ARRAY);
        eBr();
        eBr();
        if (this.pSY > 0) {
            int[] iArr = this.pTa;
            int i = this.pSY - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public void eBo() throws IOException {
        a(JsonToken.BEGIN_OBJECT);
        push(((JsonObject) eBq()).entrySet().iterator());
    }

    @Override // com.google.gson.stream.a
    public void endObject() throws IOException {
        a(JsonToken.END_OBJECT);
        eBr();
        eBr();
        if (this.pSY > 0) {
            int[] iArr = this.pTa;
            int i = this.pSY - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public boolean hasNext() throws IOException {
        JsonToken eBp = eBp();
        return (eBp == JsonToken.END_OBJECT || eBp == JsonToken.END_ARRAY) ? false : true;
    }

    @Override // com.google.gson.stream.a
    public JsonToken eBp() throws IOException {
        if (this.pSY == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object eBq = eBq();
        if (eBq instanceof Iterator) {
            boolean z = this.pSX[this.pSY - 2] instanceof JsonObject;
            Iterator it = (Iterator) eBq;
            if (!it.hasNext()) {
                return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            } else if (z) {
                return JsonToken.NAME;
            } else {
                push(it.next());
                return eBp();
            }
        } else if (eBq instanceof JsonObject) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (eBq instanceof JsonArray) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (eBq instanceof JsonPrimitive) {
                JsonPrimitive jsonPrimitive = (JsonPrimitive) eBq;
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
            } else if (eBq instanceof JsonNull) {
                return JsonToken.NULL;
            } else {
                if (eBq == pSW) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    private Object eBq() {
        return this.pSX[this.pSY - 1];
    }

    private Object eBr() {
        Object[] objArr = this.pSX;
        int i = this.pSY - 1;
        this.pSY = i;
        Object obj = objArr[i];
        this.pSX[this.pSY] = null;
        return obj;
    }

    private void a(JsonToken jsonToken) throws IOException {
        if (eBp() != jsonToken) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + eBp() + eBB());
        }
    }

    @Override // com.google.gson.stream.a
    public String eBs() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) eBq()).next();
        String str = (String) entry.getKey();
        this.pSZ[this.pSY - 1] = str;
        push(entry.getValue());
        return str;
    }

    @Override // com.google.gson.stream.a
    public String eBt() throws IOException {
        JsonToken eBp = eBp();
        if (eBp != JsonToken.STRING && eBp != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected " + JsonToken.STRING + " but was " + eBp + eBB());
        }
        String asString = ((JsonPrimitive) eBr()).getAsString();
        if (this.pSY > 0) {
            int[] iArr = this.pTa;
            int i = this.pSY - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asString;
    }

    @Override // com.google.gson.stream.a
    public boolean eBu() throws IOException {
        a(JsonToken.BOOLEAN);
        boolean asBoolean = ((JsonPrimitive) eBr()).getAsBoolean();
        if (this.pSY > 0) {
            int[] iArr = this.pTa;
            int i = this.pSY - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asBoolean;
    }

    @Override // com.google.gson.stream.a
    public void eBv() throws IOException {
        a(JsonToken.NULL);
        eBr();
        if (this.pSY > 0) {
            int[] iArr = this.pTa;
            int i = this.pSY - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public double eBw() throws IOException {
        JsonToken eBp = eBp();
        if (eBp != JsonToken.NUMBER && eBp != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + eBp + eBB());
        }
        double asDouble = ((JsonPrimitive) eBq()).getAsDouble();
        if (!eBN() && (Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + asDouble);
        }
        eBr();
        if (this.pSY > 0) {
            int[] iArr = this.pTa;
            int i = this.pSY - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asDouble;
    }

    @Override // com.google.gson.stream.a
    public long eBx() throws IOException {
        JsonToken eBp = eBp();
        if (eBp != JsonToken.NUMBER && eBp != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + eBp + eBB());
        }
        long asLong = ((JsonPrimitive) eBq()).getAsLong();
        eBr();
        if (this.pSY > 0) {
            int[] iArr = this.pTa;
            int i = this.pSY - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asLong;
    }

    @Override // com.google.gson.stream.a
    public int eBy() throws IOException {
        JsonToken eBp = eBp();
        if (eBp != JsonToken.NUMBER && eBp != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + eBp + eBB());
        }
        int asInt = ((JsonPrimitive) eBq()).getAsInt();
        eBr();
        if (this.pSY > 0) {
            int[] iArr = this.pTa;
            int i = this.pSY - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asInt;
    }

    @Override // com.google.gson.stream.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.pSX = new Object[]{pSW};
        this.pSY = 1;
    }

    @Override // com.google.gson.stream.a
    public void eBz() throws IOException {
        if (eBp() == JsonToken.NAME) {
            eBs();
            this.pSZ[this.pSY - 2] = "null";
        } else {
            eBr();
            if (this.pSY > 0) {
                this.pSZ[this.pSY - 1] = "null";
            }
        }
        if (this.pSY > 0) {
            int[] iArr = this.pTa;
            int i = this.pSY - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public String toString() {
        return getClass().getSimpleName();
    }

    public void eBA() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) eBq()).next();
        push(entry.getValue());
        push(new JsonPrimitive((String) entry.getKey()));
    }

    private void push(Object obj) {
        if (this.pSY == this.pSX.length) {
            Object[] objArr = new Object[this.pSY * 2];
            int[] iArr = new int[this.pSY * 2];
            String[] strArr = new String[this.pSY * 2];
            System.arraycopy(this.pSX, 0, objArr, 0, this.pSY);
            System.arraycopy(this.pTa, 0, iArr, 0, this.pSY);
            System.arraycopy(this.pSZ, 0, strArr, 0, this.pSY);
            this.pSX = objArr;
            this.pTa = iArr;
            this.pSZ = strArr;
        }
        Object[] objArr2 = this.pSX;
        int i = this.pSY;
        this.pSY = i + 1;
        objArr2[i] = obj;
    }

    @Override // com.google.gson.stream.a
    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = 0;
        while (i < this.pSY) {
            if (this.pSX[i] instanceof JsonArray) {
                i++;
                if (this.pSX[i] instanceof Iterator) {
                    append.append('[').append(this.pTa[i]).append(']');
                }
            } else if (this.pSX[i] instanceof JsonObject) {
                i++;
                if (this.pSX[i] instanceof Iterator) {
                    append.append('.');
                    if (this.pSZ[i] != null) {
                        append.append(this.pSZ[i]);
                    }
                }
            }
            i++;
        }
        return append.toString();
    }

    private String eBB() {
        return " at path " + getPath();
    }
}
