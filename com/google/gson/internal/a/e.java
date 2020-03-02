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
    private static final Reader mLk = new Reader() { // from class: com.google.gson.internal.a.e.1
        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }
    };
    private static final Object mLl = new Object();
    private Object[] mLm;
    private int mLn;
    private String[] mLo;
    private int[] mLp;

    public e(JsonElement jsonElement) {
        super(mLk);
        this.mLm = new Object[32];
        this.mLn = 0;
        this.mLo = new String[32];
        this.mLp = new int[32];
        push(jsonElement);
    }

    @Override // com.google.gson.stream.a
    public void dAR() throws IOException {
        a(JsonToken.BEGIN_ARRAY);
        push(((JsonArray) dAU()).iterator());
        this.mLp[this.mLn - 1] = 0;
    }

    @Override // com.google.gson.stream.a
    public void endArray() throws IOException {
        a(JsonToken.END_ARRAY);
        dAV();
        dAV();
        if (this.mLn > 0) {
            int[] iArr = this.mLp;
            int i = this.mLn - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public void dAS() throws IOException {
        a(JsonToken.BEGIN_OBJECT);
        push(((JsonObject) dAU()).entrySet().iterator());
    }

    @Override // com.google.gson.stream.a
    public void endObject() throws IOException {
        a(JsonToken.END_OBJECT);
        dAV();
        dAV();
        if (this.mLn > 0) {
            int[] iArr = this.mLp;
            int i = this.mLn - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public boolean hasNext() throws IOException {
        JsonToken dAT = dAT();
        return (dAT == JsonToken.END_OBJECT || dAT == JsonToken.END_ARRAY) ? false : true;
    }

    @Override // com.google.gson.stream.a
    public JsonToken dAT() throws IOException {
        if (this.mLn == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object dAU = dAU();
        if (dAU instanceof Iterator) {
            boolean z = this.mLm[this.mLn - 2] instanceof JsonObject;
            Iterator it = (Iterator) dAU;
            if (!it.hasNext()) {
                return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            } else if (z) {
                return JsonToken.NAME;
            } else {
                push(it.next());
                return dAT();
            }
        } else if (dAU instanceof JsonObject) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (dAU instanceof JsonArray) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (dAU instanceof JsonPrimitive) {
                JsonPrimitive jsonPrimitive = (JsonPrimitive) dAU;
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
            } else if (dAU instanceof JsonNull) {
                return JsonToken.NULL;
            } else {
                if (dAU == mLl) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    private Object dAU() {
        return this.mLm[this.mLn - 1];
    }

    private Object dAV() {
        Object[] objArr = this.mLm;
        int i = this.mLn - 1;
        this.mLn = i;
        Object obj = objArr[i];
        this.mLm[this.mLn] = null;
        return obj;
    }

    private void a(JsonToken jsonToken) throws IOException {
        if (dAT() != jsonToken) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + dAT() + dBb());
        }
    }

    @Override // com.google.gson.stream.a
    public String dAW() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) dAU()).next();
        String str = (String) entry.getKey();
        this.mLo[this.mLn - 1] = str;
        push(entry.getValue());
        return str;
    }

    @Override // com.google.gson.stream.a
    public String dAX() throws IOException {
        JsonToken dAT = dAT();
        if (dAT != JsonToken.STRING && dAT != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected " + JsonToken.STRING + " but was " + dAT + dBb());
        }
        String asString = ((JsonPrimitive) dAV()).getAsString();
        if (this.mLn > 0) {
            int[] iArr = this.mLp;
            int i = this.mLn - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asString;
    }

    @Override // com.google.gson.stream.a
    public boolean nextBoolean() throws IOException {
        a(JsonToken.BOOLEAN);
        boolean asBoolean = ((JsonPrimitive) dAV()).getAsBoolean();
        if (this.mLn > 0) {
            int[] iArr = this.mLp;
            int i = this.mLn - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asBoolean;
    }

    @Override // com.google.gson.stream.a
    public void dAY() throws IOException {
        a(JsonToken.NULL);
        dAV();
        if (this.mLn > 0) {
            int[] iArr = this.mLp;
            int i = this.mLn - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public double nextDouble() throws IOException {
        JsonToken dAT = dAT();
        if (dAT != JsonToken.NUMBER && dAT != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + dAT + dBb());
        }
        double asDouble = ((JsonPrimitive) dAU()).getAsDouble();
        if (!dBm() && (Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + asDouble);
        }
        dAV();
        if (this.mLn > 0) {
            int[] iArr = this.mLp;
            int i = this.mLn - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asDouble;
    }

    @Override // com.google.gson.stream.a
    public long nextLong() throws IOException {
        JsonToken dAT = dAT();
        if (dAT != JsonToken.NUMBER && dAT != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + dAT + dBb());
        }
        long asLong = ((JsonPrimitive) dAU()).getAsLong();
        dAV();
        if (this.mLn > 0) {
            int[] iArr = this.mLp;
            int i = this.mLn - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asLong;
    }

    @Override // com.google.gson.stream.a
    public int nextInt() throws IOException {
        JsonToken dAT = dAT();
        if (dAT != JsonToken.NUMBER && dAT != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + dAT + dBb());
        }
        int asInt = ((JsonPrimitive) dAU()).getAsInt();
        dAV();
        if (this.mLn > 0) {
            int[] iArr = this.mLp;
            int i = this.mLn - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asInt;
    }

    @Override // com.google.gson.stream.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mLm = new Object[]{mLl};
        this.mLn = 1;
    }

    @Override // com.google.gson.stream.a
    public void dAZ() throws IOException {
        if (dAT() == JsonToken.NAME) {
            dAW();
            this.mLo[this.mLn - 2] = "null";
        } else {
            dAV();
            if (this.mLn > 0) {
                this.mLo[this.mLn - 1] = "null";
            }
        }
        if (this.mLn > 0) {
            int[] iArr = this.mLp;
            int i = this.mLn - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public String toString() {
        return getClass().getSimpleName();
    }

    public void dBa() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) dAU()).next();
        push(entry.getValue());
        push(new JsonPrimitive((String) entry.getKey()));
    }

    private void push(Object obj) {
        if (this.mLn == this.mLm.length) {
            Object[] objArr = new Object[this.mLn * 2];
            int[] iArr = new int[this.mLn * 2];
            String[] strArr = new String[this.mLn * 2];
            System.arraycopy(this.mLm, 0, objArr, 0, this.mLn);
            System.arraycopy(this.mLp, 0, iArr, 0, this.mLn);
            System.arraycopy(this.mLo, 0, strArr, 0, this.mLn);
            this.mLm = objArr;
            this.mLp = iArr;
            this.mLo = strArr;
        }
        Object[] objArr2 = this.mLm;
        int i = this.mLn;
        this.mLn = i + 1;
        objArr2[i] = obj;
    }

    @Override // com.google.gson.stream.a
    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = 0;
        while (i < this.mLn) {
            if (this.mLm[i] instanceof JsonArray) {
                i++;
                if (this.mLm[i] instanceof Iterator) {
                    append.append('[').append(this.mLp[i]).append(']');
                }
            } else if (this.mLm[i] instanceof JsonObject) {
                i++;
                if (this.mLm[i] instanceof Iterator) {
                    append.append('.');
                    if (this.mLo[i] != null) {
                        append.append(this.mLo[i]);
                    }
                }
            }
            i++;
        }
        return append.toString();
    }

    private String dBb() {
        return " at path " + getPath();
    }
}
