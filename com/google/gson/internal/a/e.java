package com.google.gson.internal.a;

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
/* loaded from: classes7.dex */
public final class e extends com.google.gson.stream.a {
    private static final Reader mLi = new Reader() { // from class: com.google.gson.internal.a.e.1
        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }
    };
    private static final Object mLj = new Object();
    private Object[] mLk;
    private int mLl;
    private String[] mLm;
    private int[] mLn;

    public e(JsonElement jsonElement) {
        super(mLi);
        this.mLk = new Object[32];
        this.mLl = 0;
        this.mLm = new String[32];
        this.mLn = new int[32];
        push(jsonElement);
    }

    @Override // com.google.gson.stream.a
    public void dAP() throws IOException {
        a(JsonToken.BEGIN_ARRAY);
        push(((JsonArray) dAS()).iterator());
        this.mLn[this.mLl - 1] = 0;
    }

    @Override // com.google.gson.stream.a
    public void endArray() throws IOException {
        a(JsonToken.END_ARRAY);
        dAT();
        dAT();
        if (this.mLl > 0) {
            int[] iArr = this.mLn;
            int i = this.mLl - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public void dAQ() throws IOException {
        a(JsonToken.BEGIN_OBJECT);
        push(((JsonObject) dAS()).entrySet().iterator());
    }

    @Override // com.google.gson.stream.a
    public void endObject() throws IOException {
        a(JsonToken.END_OBJECT);
        dAT();
        dAT();
        if (this.mLl > 0) {
            int[] iArr = this.mLn;
            int i = this.mLl - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public boolean hasNext() throws IOException {
        JsonToken dAR = dAR();
        return (dAR == JsonToken.END_OBJECT || dAR == JsonToken.END_ARRAY) ? false : true;
    }

    @Override // com.google.gson.stream.a
    public JsonToken dAR() throws IOException {
        if (this.mLl == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object dAS = dAS();
        if (dAS instanceof Iterator) {
            boolean z = this.mLk[this.mLl - 2] instanceof JsonObject;
            Iterator it = (Iterator) dAS;
            if (!it.hasNext()) {
                return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            } else if (z) {
                return JsonToken.NAME;
            } else {
                push(it.next());
                return dAR();
            }
        } else if (dAS instanceof JsonObject) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (dAS instanceof JsonArray) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (dAS instanceof JsonPrimitive) {
                JsonPrimitive jsonPrimitive = (JsonPrimitive) dAS;
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
            } else if (dAS instanceof JsonNull) {
                return JsonToken.NULL;
            } else {
                if (dAS == mLj) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    private Object dAS() {
        return this.mLk[this.mLl - 1];
    }

    private Object dAT() {
        Object[] objArr = this.mLk;
        int i = this.mLl - 1;
        this.mLl = i;
        Object obj = objArr[i];
        this.mLk[this.mLl] = null;
        return obj;
    }

    private void a(JsonToken jsonToken) throws IOException {
        if (dAR() != jsonToken) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + dAR() + dAZ());
        }
    }

    @Override // com.google.gson.stream.a
    public String dAU() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) dAS()).next();
        String str = (String) entry.getKey();
        this.mLm[this.mLl - 1] = str;
        push(entry.getValue());
        return str;
    }

    @Override // com.google.gson.stream.a
    public String dAV() throws IOException {
        JsonToken dAR = dAR();
        if (dAR != JsonToken.STRING && dAR != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected " + JsonToken.STRING + " but was " + dAR + dAZ());
        }
        String asString = ((JsonPrimitive) dAT()).getAsString();
        if (this.mLl > 0) {
            int[] iArr = this.mLn;
            int i = this.mLl - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asString;
    }

    @Override // com.google.gson.stream.a
    public boolean nextBoolean() throws IOException {
        a(JsonToken.BOOLEAN);
        boolean asBoolean = ((JsonPrimitive) dAT()).getAsBoolean();
        if (this.mLl > 0) {
            int[] iArr = this.mLn;
            int i = this.mLl - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asBoolean;
    }

    @Override // com.google.gson.stream.a
    public void dAW() throws IOException {
        a(JsonToken.NULL);
        dAT();
        if (this.mLl > 0) {
            int[] iArr = this.mLn;
            int i = this.mLl - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public double nextDouble() throws IOException {
        JsonToken dAR = dAR();
        if (dAR != JsonToken.NUMBER && dAR != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + dAR + dAZ());
        }
        double asDouble = ((JsonPrimitive) dAS()).getAsDouble();
        if (!dBk() && (Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + asDouble);
        }
        dAT();
        if (this.mLl > 0) {
            int[] iArr = this.mLn;
            int i = this.mLl - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asDouble;
    }

    @Override // com.google.gson.stream.a
    public long nextLong() throws IOException {
        JsonToken dAR = dAR();
        if (dAR != JsonToken.NUMBER && dAR != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + dAR + dAZ());
        }
        long asLong = ((JsonPrimitive) dAS()).getAsLong();
        dAT();
        if (this.mLl > 0) {
            int[] iArr = this.mLn;
            int i = this.mLl - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asLong;
    }

    @Override // com.google.gson.stream.a
    public int nextInt() throws IOException {
        JsonToken dAR = dAR();
        if (dAR != JsonToken.NUMBER && dAR != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + dAR + dAZ());
        }
        int asInt = ((JsonPrimitive) dAS()).getAsInt();
        dAT();
        if (this.mLl > 0) {
            int[] iArr = this.mLn;
            int i = this.mLl - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asInt;
    }

    @Override // com.google.gson.stream.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mLk = new Object[]{mLj};
        this.mLl = 1;
    }

    @Override // com.google.gson.stream.a
    public void dAX() throws IOException {
        if (dAR() == JsonToken.NAME) {
            dAU();
            this.mLm[this.mLl - 2] = "null";
        } else {
            dAT();
            if (this.mLl > 0) {
                this.mLm[this.mLl - 1] = "null";
            }
        }
        if (this.mLl > 0) {
            int[] iArr = this.mLn;
            int i = this.mLl - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public String toString() {
        return getClass().getSimpleName();
    }

    public void dAY() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) dAS()).next();
        push(entry.getValue());
        push(new JsonPrimitive((String) entry.getKey()));
    }

    private void push(Object obj) {
        if (this.mLl == this.mLk.length) {
            Object[] objArr = new Object[this.mLl * 2];
            int[] iArr = new int[this.mLl * 2];
            String[] strArr = new String[this.mLl * 2];
            System.arraycopy(this.mLk, 0, objArr, 0, this.mLl);
            System.arraycopy(this.mLn, 0, iArr, 0, this.mLl);
            System.arraycopy(this.mLm, 0, strArr, 0, this.mLl);
            this.mLk = objArr;
            this.mLn = iArr;
            this.mLm = strArr;
        }
        Object[] objArr2 = this.mLk;
        int i = this.mLl;
        this.mLl = i + 1;
        objArr2[i] = obj;
    }

    @Override // com.google.gson.stream.a
    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = 0;
        while (i < this.mLl) {
            if (this.mLk[i] instanceof JsonArray) {
                i++;
                if (this.mLk[i] instanceof Iterator) {
                    append.append('[').append(this.mLn[i]).append(']');
                }
            } else if (this.mLk[i] instanceof JsonObject) {
                i++;
                if (this.mLk[i] instanceof Iterator) {
                    append.append('.');
                    if (this.mLm[i] != null) {
                        append.append(this.mLm[i]);
                    }
                }
            }
            i++;
        }
        return append.toString();
    }

    private String dAZ() {
        return " at path " + getPath();
    }
}
