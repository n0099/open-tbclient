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
    private static final Reader mjR = new Reader() { // from class: com.google.gson.internal.a.e.1
        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }
    };
    private static final Object mjS = new Object();
    private Object[] mjT;
    private int mjU;
    private String[] mjV;
    private int[] mjW;

    public e(JsonElement jsonElement) {
        super(mjR);
        this.mjT = new Object[32];
        this.mjU = 0;
        this.mjV = new String[32];
        this.mjW = new int[32];
        push(jsonElement);
    }

    @Override // com.google.gson.stream.a
    public void dvE() throws IOException {
        a(JsonToken.BEGIN_ARRAY);
        push(((JsonArray) dvH()).iterator());
        this.mjW[this.mjU - 1] = 0;
    }

    @Override // com.google.gson.stream.a
    public void endArray() throws IOException {
        a(JsonToken.END_ARRAY);
        dvI();
        dvI();
        if (this.mjU > 0) {
            int[] iArr = this.mjW;
            int i = this.mjU - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public void dvF() throws IOException {
        a(JsonToken.BEGIN_OBJECT);
        push(((JsonObject) dvH()).entrySet().iterator());
    }

    @Override // com.google.gson.stream.a
    public void endObject() throws IOException {
        a(JsonToken.END_OBJECT);
        dvI();
        dvI();
        if (this.mjU > 0) {
            int[] iArr = this.mjW;
            int i = this.mjU - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public boolean hasNext() throws IOException {
        JsonToken dvG = dvG();
        return (dvG == JsonToken.END_OBJECT || dvG == JsonToken.END_ARRAY) ? false : true;
    }

    @Override // com.google.gson.stream.a
    public JsonToken dvG() throws IOException {
        if (this.mjU == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object dvH = dvH();
        if (dvH instanceof Iterator) {
            boolean z = this.mjT[this.mjU - 2] instanceof JsonObject;
            Iterator it = (Iterator) dvH;
            if (!it.hasNext()) {
                return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            } else if (z) {
                return JsonToken.NAME;
            } else {
                push(it.next());
                return dvG();
            }
        } else if (dvH instanceof JsonObject) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (dvH instanceof JsonArray) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (dvH instanceof JsonPrimitive) {
                JsonPrimitive jsonPrimitive = (JsonPrimitive) dvH;
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
            } else if (dvH instanceof JsonNull) {
                return JsonToken.NULL;
            } else {
                if (dvH == mjS) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    private Object dvH() {
        return this.mjT[this.mjU - 1];
    }

    private Object dvI() {
        Object[] objArr = this.mjT;
        int i = this.mjU - 1;
        this.mjU = i;
        Object obj = objArr[i];
        this.mjT[this.mjU] = null;
        return obj;
    }

    private void a(JsonToken jsonToken) throws IOException {
        if (dvG() != jsonToken) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + dvG() + dvO());
        }
    }

    @Override // com.google.gson.stream.a
    public String dvJ() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) dvH()).next();
        String str = (String) entry.getKey();
        this.mjV[this.mjU - 1] = str;
        push(entry.getValue());
        return str;
    }

    @Override // com.google.gson.stream.a
    public String dvK() throws IOException {
        JsonToken dvG = dvG();
        if (dvG != JsonToken.STRING && dvG != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected " + JsonToken.STRING + " but was " + dvG + dvO());
        }
        String asString = ((JsonPrimitive) dvI()).getAsString();
        if (this.mjU > 0) {
            int[] iArr = this.mjW;
            int i = this.mjU - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asString;
    }

    @Override // com.google.gson.stream.a
    public boolean nextBoolean() throws IOException {
        a(JsonToken.BOOLEAN);
        boolean asBoolean = ((JsonPrimitive) dvI()).getAsBoolean();
        if (this.mjU > 0) {
            int[] iArr = this.mjW;
            int i = this.mjU - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asBoolean;
    }

    @Override // com.google.gson.stream.a
    public void dvL() throws IOException {
        a(JsonToken.NULL);
        dvI();
        if (this.mjU > 0) {
            int[] iArr = this.mjW;
            int i = this.mjU - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public double nextDouble() throws IOException {
        JsonToken dvG = dvG();
        if (dvG != JsonToken.NUMBER && dvG != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + dvG + dvO());
        }
        double asDouble = ((JsonPrimitive) dvH()).getAsDouble();
        if (!dwa() && (Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + asDouble);
        }
        dvI();
        if (this.mjU > 0) {
            int[] iArr = this.mjW;
            int i = this.mjU - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asDouble;
    }

    @Override // com.google.gson.stream.a
    public long nextLong() throws IOException {
        JsonToken dvG = dvG();
        if (dvG != JsonToken.NUMBER && dvG != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + dvG + dvO());
        }
        long asLong = ((JsonPrimitive) dvH()).getAsLong();
        dvI();
        if (this.mjU > 0) {
            int[] iArr = this.mjW;
            int i = this.mjU - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asLong;
    }

    @Override // com.google.gson.stream.a
    public int nextInt() throws IOException {
        JsonToken dvG = dvG();
        if (dvG != JsonToken.NUMBER && dvG != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + dvG + dvO());
        }
        int asInt = ((JsonPrimitive) dvH()).getAsInt();
        dvI();
        if (this.mjU > 0) {
            int[] iArr = this.mjW;
            int i = this.mjU - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asInt;
    }

    @Override // com.google.gson.stream.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mjT = new Object[]{mjS};
        this.mjU = 1;
    }

    @Override // com.google.gson.stream.a
    public void dvM() throws IOException {
        if (dvG() == JsonToken.NAME) {
            dvJ();
            this.mjV[this.mjU - 2] = "null";
        } else {
            dvI();
            if (this.mjU > 0) {
                this.mjV[this.mjU - 1] = "null";
            }
        }
        if (this.mjU > 0) {
            int[] iArr = this.mjW;
            int i = this.mjU - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public String toString() {
        return getClass().getSimpleName();
    }

    public void dvN() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) dvH()).next();
        push(entry.getValue());
        push(new JsonPrimitive((String) entry.getKey()));
    }

    private void push(Object obj) {
        if (this.mjU == this.mjT.length) {
            Object[] objArr = new Object[this.mjU * 2];
            int[] iArr = new int[this.mjU * 2];
            String[] strArr = new String[this.mjU * 2];
            System.arraycopy(this.mjT, 0, objArr, 0, this.mjU);
            System.arraycopy(this.mjW, 0, iArr, 0, this.mjU);
            System.arraycopy(this.mjV, 0, strArr, 0, this.mjU);
            this.mjT = objArr;
            this.mjW = iArr;
            this.mjV = strArr;
        }
        Object[] objArr2 = this.mjT;
        int i = this.mjU;
        this.mjU = i + 1;
        objArr2[i] = obj;
    }

    @Override // com.google.gson.stream.a
    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = 0;
        while (i < this.mjU) {
            if (this.mjT[i] instanceof JsonArray) {
                i++;
                if (this.mjT[i] instanceof Iterator) {
                    append.append('[').append(this.mjW[i]).append(']');
                }
            } else if (this.mjT[i] instanceof JsonObject) {
                i++;
                if (this.mjT[i] instanceof Iterator) {
                    append.append('.');
                    if (this.mjV[i] != null) {
                        append.append(this.mjV[i]);
                    }
                }
            }
            i++;
        }
        return append.toString();
    }

    private String dvO() {
        return " at path " + getPath();
    }
}
