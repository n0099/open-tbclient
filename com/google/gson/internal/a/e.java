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
    private static final Reader mEV = new Reader() { // from class: com.google.gson.internal.a.e.1
        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }
    };
    private static final Object mEW = new Object();
    private Object[] mEX;
    private int mEY;
    private String[] mEZ;
    private int[] mFa;

    public e(JsonElement jsonElement) {
        super(mEV);
        this.mEX = new Object[32];
        this.mEY = 0;
        this.mEZ = new String[32];
        this.mFa = new int[32];
        push(jsonElement);
    }

    @Override // com.google.gson.stream.a
    public void dDk() throws IOException {
        a(JsonToken.BEGIN_ARRAY);
        push(((JsonArray) dDn()).iterator());
        this.mFa[this.mEY - 1] = 0;
    }

    @Override // com.google.gson.stream.a
    public void endArray() throws IOException {
        a(JsonToken.END_ARRAY);
        dDo();
        dDo();
        if (this.mEY > 0) {
            int[] iArr = this.mFa;
            int i = this.mEY - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public void dDl() throws IOException {
        a(JsonToken.BEGIN_OBJECT);
        push(((JsonObject) dDn()).entrySet().iterator());
    }

    @Override // com.google.gson.stream.a
    public void endObject() throws IOException {
        a(JsonToken.END_OBJECT);
        dDo();
        dDo();
        if (this.mEY > 0) {
            int[] iArr = this.mFa;
            int i = this.mEY - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public boolean hasNext() throws IOException {
        JsonToken dDm = dDm();
        return (dDm == JsonToken.END_OBJECT || dDm == JsonToken.END_ARRAY) ? false : true;
    }

    @Override // com.google.gson.stream.a
    public JsonToken dDm() throws IOException {
        if (this.mEY == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object dDn = dDn();
        if (dDn instanceof Iterator) {
            boolean z = this.mEX[this.mEY - 2] instanceof JsonObject;
            Iterator it = (Iterator) dDn;
            if (!it.hasNext()) {
                return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            } else if (z) {
                return JsonToken.NAME;
            } else {
                push(it.next());
                return dDm();
            }
        } else if (dDn instanceof JsonObject) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (dDn instanceof JsonArray) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (dDn instanceof JsonPrimitive) {
                JsonPrimitive jsonPrimitive = (JsonPrimitive) dDn;
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
            } else if (dDn instanceof JsonNull) {
                return JsonToken.NULL;
            } else {
                if (dDn == mEW) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    private Object dDn() {
        return this.mEX[this.mEY - 1];
    }

    private Object dDo() {
        Object[] objArr = this.mEX;
        int i = this.mEY - 1;
        this.mEY = i;
        Object obj = objArr[i];
        this.mEX[this.mEY] = null;
        return obj;
    }

    private void a(JsonToken jsonToken) throws IOException {
        if (dDm() != jsonToken) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + dDm() + dDu());
        }
    }

    @Override // com.google.gson.stream.a
    public String dDp() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) dDn()).next();
        String str = (String) entry.getKey();
        this.mEZ[this.mEY - 1] = str;
        push(entry.getValue());
        return str;
    }

    @Override // com.google.gson.stream.a
    public String dDq() throws IOException {
        JsonToken dDm = dDm();
        if (dDm != JsonToken.STRING && dDm != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected " + JsonToken.STRING + " but was " + dDm + dDu());
        }
        String asString = ((JsonPrimitive) dDo()).getAsString();
        if (this.mEY > 0) {
            int[] iArr = this.mFa;
            int i = this.mEY - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asString;
    }

    @Override // com.google.gson.stream.a
    public boolean nextBoolean() throws IOException {
        a(JsonToken.BOOLEAN);
        boolean asBoolean = ((JsonPrimitive) dDo()).getAsBoolean();
        if (this.mEY > 0) {
            int[] iArr = this.mFa;
            int i = this.mEY - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asBoolean;
    }

    @Override // com.google.gson.stream.a
    public void dDr() throws IOException {
        a(JsonToken.NULL);
        dDo();
        if (this.mEY > 0) {
            int[] iArr = this.mFa;
            int i = this.mEY - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public double nextDouble() throws IOException {
        JsonToken dDm = dDm();
        if (dDm != JsonToken.NUMBER && dDm != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + dDm + dDu());
        }
        double asDouble = ((JsonPrimitive) dDn()).getAsDouble();
        if (!dDG() && (Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + asDouble);
        }
        dDo();
        if (this.mEY > 0) {
            int[] iArr = this.mFa;
            int i = this.mEY - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asDouble;
    }

    @Override // com.google.gson.stream.a
    public long nextLong() throws IOException {
        JsonToken dDm = dDm();
        if (dDm != JsonToken.NUMBER && dDm != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + dDm + dDu());
        }
        long asLong = ((JsonPrimitive) dDn()).getAsLong();
        dDo();
        if (this.mEY > 0) {
            int[] iArr = this.mFa;
            int i = this.mEY - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asLong;
    }

    @Override // com.google.gson.stream.a
    public int nextInt() throws IOException {
        JsonToken dDm = dDm();
        if (dDm != JsonToken.NUMBER && dDm != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + dDm + dDu());
        }
        int asInt = ((JsonPrimitive) dDn()).getAsInt();
        dDo();
        if (this.mEY > 0) {
            int[] iArr = this.mFa;
            int i = this.mEY - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asInt;
    }

    @Override // com.google.gson.stream.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mEX = new Object[]{mEW};
        this.mEY = 1;
    }

    @Override // com.google.gson.stream.a
    public void dDs() throws IOException {
        if (dDm() == JsonToken.NAME) {
            dDp();
            this.mEZ[this.mEY - 2] = "null";
        } else {
            dDo();
            if (this.mEY > 0) {
                this.mEZ[this.mEY - 1] = "null";
            }
        }
        if (this.mEY > 0) {
            int[] iArr = this.mFa;
            int i = this.mEY - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public String toString() {
        return getClass().getSimpleName();
    }

    public void dDt() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) dDn()).next();
        push(entry.getValue());
        push(new JsonPrimitive((String) entry.getKey()));
    }

    private void push(Object obj) {
        if (this.mEY == this.mEX.length) {
            Object[] objArr = new Object[this.mEY * 2];
            int[] iArr = new int[this.mEY * 2];
            String[] strArr = new String[this.mEY * 2];
            System.arraycopy(this.mEX, 0, objArr, 0, this.mEY);
            System.arraycopy(this.mFa, 0, iArr, 0, this.mEY);
            System.arraycopy(this.mEZ, 0, strArr, 0, this.mEY);
            this.mEX = objArr;
            this.mFa = iArr;
            this.mEZ = strArr;
        }
        Object[] objArr2 = this.mEX;
        int i = this.mEY;
        this.mEY = i + 1;
        objArr2[i] = obj;
    }

    @Override // com.google.gson.stream.a
    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = 0;
        while (i < this.mEY) {
            if (this.mEX[i] instanceof JsonArray) {
                i++;
                if (this.mEX[i] instanceof Iterator) {
                    append.append('[').append(this.mFa[i]).append(']');
                }
            } else if (this.mEX[i] instanceof JsonObject) {
                i++;
                if (this.mEX[i] instanceof Iterator) {
                    append.append('.');
                    if (this.mEZ[i] != null) {
                        append.append(this.mEZ[i]);
                    }
                }
            }
            i++;
        }
        return append.toString();
    }

    private String dDu() {
        return " at path " + getPath();
    }
}
