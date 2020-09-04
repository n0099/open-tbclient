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
/* loaded from: classes3.dex */
public final class e extends com.google.gson.stream.a {
    private static final Reader nDW = new Reader() { // from class: com.google.gson.internal.a.e.1
        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }
    };
    private static final Object nDX = new Object();
    private Object[] nDY;
    private int nDZ;
    private String[] nEa;
    private int[] nEb;

    public e(JsonElement jsonElement) {
        super(nDW);
        this.nDY = new Object[32];
        this.nDZ = 0;
        this.nEa = new String[32];
        this.nEb = new int[32];
        push(jsonElement);
    }

    @Override // com.google.gson.stream.a
    public void dXw() throws IOException {
        a(JsonToken.BEGIN_ARRAY);
        push(((JsonArray) dXz()).iterator());
        this.nEb[this.nDZ - 1] = 0;
    }

    @Override // com.google.gson.stream.a
    public void endArray() throws IOException {
        a(JsonToken.END_ARRAY);
        dXA();
        dXA();
        if (this.nDZ > 0) {
            int[] iArr = this.nEb;
            int i = this.nDZ - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public void dXx() throws IOException {
        a(JsonToken.BEGIN_OBJECT);
        push(((JsonObject) dXz()).entrySet().iterator());
    }

    @Override // com.google.gson.stream.a
    public void endObject() throws IOException {
        a(JsonToken.END_OBJECT);
        dXA();
        dXA();
        if (this.nDZ > 0) {
            int[] iArr = this.nEb;
            int i = this.nDZ - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public boolean hasNext() throws IOException {
        JsonToken dXy = dXy();
        return (dXy == JsonToken.END_OBJECT || dXy == JsonToken.END_ARRAY) ? false : true;
    }

    @Override // com.google.gson.stream.a
    public JsonToken dXy() throws IOException {
        if (this.nDZ == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object dXz = dXz();
        if (dXz instanceof Iterator) {
            boolean z = this.nDY[this.nDZ - 2] instanceof JsonObject;
            Iterator it = (Iterator) dXz;
            if (!it.hasNext()) {
                return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            } else if (z) {
                return JsonToken.NAME;
            } else {
                push(it.next());
                return dXy();
            }
        } else if (dXz instanceof JsonObject) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (dXz instanceof JsonArray) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (dXz instanceof JsonPrimitive) {
                JsonPrimitive jsonPrimitive = (JsonPrimitive) dXz;
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
            } else if (dXz instanceof JsonNull) {
                return JsonToken.NULL;
            } else {
                if (dXz == nDX) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    private Object dXz() {
        return this.nDY[this.nDZ - 1];
    }

    private Object dXA() {
        Object[] objArr = this.nDY;
        int i = this.nDZ - 1;
        this.nDZ = i;
        Object obj = objArr[i];
        this.nDY[this.nDZ] = null;
        return obj;
    }

    private void a(JsonToken jsonToken) throws IOException {
        if (dXy() != jsonToken) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + dXy() + dXG());
        }
    }

    @Override // com.google.gson.stream.a
    public String dXB() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) dXz()).next();
        String str = (String) entry.getKey();
        this.nEa[this.nDZ - 1] = str;
        push(entry.getValue());
        return str;
    }

    @Override // com.google.gson.stream.a
    public String dXC() throws IOException {
        JsonToken dXy = dXy();
        if (dXy != JsonToken.STRING && dXy != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected " + JsonToken.STRING + " but was " + dXy + dXG());
        }
        String asString = ((JsonPrimitive) dXA()).getAsString();
        if (this.nDZ > 0) {
            int[] iArr = this.nEb;
            int i = this.nDZ - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asString;
    }

    @Override // com.google.gson.stream.a
    public boolean nextBoolean() throws IOException {
        a(JsonToken.BOOLEAN);
        boolean asBoolean = ((JsonPrimitive) dXA()).getAsBoolean();
        if (this.nDZ > 0) {
            int[] iArr = this.nEb;
            int i = this.nDZ - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asBoolean;
    }

    @Override // com.google.gson.stream.a
    public void dXD() throws IOException {
        a(JsonToken.NULL);
        dXA();
        if (this.nDZ > 0) {
            int[] iArr = this.nEb;
            int i = this.nDZ - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public double nextDouble() throws IOException {
        JsonToken dXy = dXy();
        if (dXy != JsonToken.NUMBER && dXy != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + dXy + dXG());
        }
        double asDouble = ((JsonPrimitive) dXz()).getAsDouble();
        if (!dXS() && (Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + asDouble);
        }
        dXA();
        if (this.nDZ > 0) {
            int[] iArr = this.nEb;
            int i = this.nDZ - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asDouble;
    }

    @Override // com.google.gson.stream.a
    public long nextLong() throws IOException {
        JsonToken dXy = dXy();
        if (dXy != JsonToken.NUMBER && dXy != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + dXy + dXG());
        }
        long asLong = ((JsonPrimitive) dXz()).getAsLong();
        dXA();
        if (this.nDZ > 0) {
            int[] iArr = this.nEb;
            int i = this.nDZ - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asLong;
    }

    @Override // com.google.gson.stream.a
    public int nextInt() throws IOException {
        JsonToken dXy = dXy();
        if (dXy != JsonToken.NUMBER && dXy != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + dXy + dXG());
        }
        int asInt = ((JsonPrimitive) dXz()).getAsInt();
        dXA();
        if (this.nDZ > 0) {
            int[] iArr = this.nEb;
            int i = this.nDZ - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asInt;
    }

    @Override // com.google.gson.stream.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.nDY = new Object[]{nDX};
        this.nDZ = 1;
    }

    @Override // com.google.gson.stream.a
    public void dXE() throws IOException {
        if (dXy() == JsonToken.NAME) {
            dXB();
            this.nEa[this.nDZ - 2] = "null";
        } else {
            dXA();
            if (this.nDZ > 0) {
                this.nEa[this.nDZ - 1] = "null";
            }
        }
        if (this.nDZ > 0) {
            int[] iArr = this.nEb;
            int i = this.nDZ - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public String toString() {
        return getClass().getSimpleName();
    }

    public void dXF() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) dXz()).next();
        push(entry.getValue());
        push(new JsonPrimitive((String) entry.getKey()));
    }

    private void push(Object obj) {
        if (this.nDZ == this.nDY.length) {
            Object[] objArr = new Object[this.nDZ * 2];
            int[] iArr = new int[this.nDZ * 2];
            String[] strArr = new String[this.nDZ * 2];
            System.arraycopy(this.nDY, 0, objArr, 0, this.nDZ);
            System.arraycopy(this.nEb, 0, iArr, 0, this.nDZ);
            System.arraycopy(this.nEa, 0, strArr, 0, this.nDZ);
            this.nDY = objArr;
            this.nEb = iArr;
            this.nEa = strArr;
        }
        Object[] objArr2 = this.nDY;
        int i = this.nDZ;
        this.nDZ = i + 1;
        objArr2[i] = obj;
    }

    @Override // com.google.gson.stream.a
    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = 0;
        while (i < this.nDZ) {
            if (this.nDY[i] instanceof JsonArray) {
                i++;
                if (this.nDY[i] instanceof Iterator) {
                    append.append('[').append(this.nEb[i]).append(']');
                }
            } else if (this.nDY[i] instanceof JsonObject) {
                i++;
                if (this.nDY[i] instanceof Iterator) {
                    append.append('.');
                    if (this.nEa[i] != null) {
                        append.append(this.nEa[i]);
                    }
                }
            }
            i++;
        }
        return append.toString();
    }

    private String dXG() {
        return " at path " + getPath();
    }
}
