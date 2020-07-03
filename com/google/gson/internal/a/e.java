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
    private static final Reader naY = new Reader() { // from class: com.google.gson.internal.a.e.1
        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }
    };
    private static final Object naZ = new Object();
    private Object[] nba;
    private int nbb;
    private String[] nbc;
    private int[] nbd;

    public e(JsonElement jsonElement) {
        super(naY);
        this.nba = new Object[32];
        this.nbb = 0;
        this.nbc = new String[32];
        this.nbd = new int[32];
        push(jsonElement);
    }

    @Override // com.google.gson.stream.a
    public void dHM() throws IOException {
        a(JsonToken.BEGIN_ARRAY);
        push(((JsonArray) dHP()).iterator());
        this.nbd[this.nbb - 1] = 0;
    }

    @Override // com.google.gson.stream.a
    public void endArray() throws IOException {
        a(JsonToken.END_ARRAY);
        dHQ();
        dHQ();
        if (this.nbb > 0) {
            int[] iArr = this.nbd;
            int i = this.nbb - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public void dHN() throws IOException {
        a(JsonToken.BEGIN_OBJECT);
        push(((JsonObject) dHP()).entrySet().iterator());
    }

    @Override // com.google.gson.stream.a
    public void endObject() throws IOException {
        a(JsonToken.END_OBJECT);
        dHQ();
        dHQ();
        if (this.nbb > 0) {
            int[] iArr = this.nbd;
            int i = this.nbb - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public boolean hasNext() throws IOException {
        JsonToken dHO = dHO();
        return (dHO == JsonToken.END_OBJECT || dHO == JsonToken.END_ARRAY) ? false : true;
    }

    @Override // com.google.gson.stream.a
    public JsonToken dHO() throws IOException {
        if (this.nbb == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object dHP = dHP();
        if (dHP instanceof Iterator) {
            boolean z = this.nba[this.nbb - 2] instanceof JsonObject;
            Iterator it = (Iterator) dHP;
            if (!it.hasNext()) {
                return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            } else if (z) {
                return JsonToken.NAME;
            } else {
                push(it.next());
                return dHO();
            }
        } else if (dHP instanceof JsonObject) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (dHP instanceof JsonArray) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (dHP instanceof JsonPrimitive) {
                JsonPrimitive jsonPrimitive = (JsonPrimitive) dHP;
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
            } else if (dHP instanceof JsonNull) {
                return JsonToken.NULL;
            } else {
                if (dHP == naZ) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    private Object dHP() {
        return this.nba[this.nbb - 1];
    }

    private Object dHQ() {
        Object[] objArr = this.nba;
        int i = this.nbb - 1;
        this.nbb = i;
        Object obj = objArr[i];
        this.nba[this.nbb] = null;
        return obj;
    }

    private void a(JsonToken jsonToken) throws IOException {
        if (dHO() != jsonToken) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + dHO() + dHW());
        }
    }

    @Override // com.google.gson.stream.a
    public String dHR() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) dHP()).next();
        String str = (String) entry.getKey();
        this.nbc[this.nbb - 1] = str;
        push(entry.getValue());
        return str;
    }

    @Override // com.google.gson.stream.a
    public String dHS() throws IOException {
        JsonToken dHO = dHO();
        if (dHO != JsonToken.STRING && dHO != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected " + JsonToken.STRING + " but was " + dHO + dHW());
        }
        String asString = ((JsonPrimitive) dHQ()).getAsString();
        if (this.nbb > 0) {
            int[] iArr = this.nbd;
            int i = this.nbb - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asString;
    }

    @Override // com.google.gson.stream.a
    public boolean nextBoolean() throws IOException {
        a(JsonToken.BOOLEAN);
        boolean asBoolean = ((JsonPrimitive) dHQ()).getAsBoolean();
        if (this.nbb > 0) {
            int[] iArr = this.nbd;
            int i = this.nbb - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asBoolean;
    }

    @Override // com.google.gson.stream.a
    public void dHT() throws IOException {
        a(JsonToken.NULL);
        dHQ();
        if (this.nbb > 0) {
            int[] iArr = this.nbd;
            int i = this.nbb - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public double nextDouble() throws IOException {
        JsonToken dHO = dHO();
        if (dHO != JsonToken.NUMBER && dHO != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + dHO + dHW());
        }
        double asDouble = ((JsonPrimitive) dHP()).getAsDouble();
        if (!dIi() && (Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + asDouble);
        }
        dHQ();
        if (this.nbb > 0) {
            int[] iArr = this.nbd;
            int i = this.nbb - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asDouble;
    }

    @Override // com.google.gson.stream.a
    public long nextLong() throws IOException {
        JsonToken dHO = dHO();
        if (dHO != JsonToken.NUMBER && dHO != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + dHO + dHW());
        }
        long asLong = ((JsonPrimitive) dHP()).getAsLong();
        dHQ();
        if (this.nbb > 0) {
            int[] iArr = this.nbd;
            int i = this.nbb - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asLong;
    }

    @Override // com.google.gson.stream.a
    public int nextInt() throws IOException {
        JsonToken dHO = dHO();
        if (dHO != JsonToken.NUMBER && dHO != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + dHO + dHW());
        }
        int asInt = ((JsonPrimitive) dHP()).getAsInt();
        dHQ();
        if (this.nbb > 0) {
            int[] iArr = this.nbd;
            int i = this.nbb - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asInt;
    }

    @Override // com.google.gson.stream.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.nba = new Object[]{naZ};
        this.nbb = 1;
    }

    @Override // com.google.gson.stream.a
    public void dHU() throws IOException {
        if (dHO() == JsonToken.NAME) {
            dHR();
            this.nbc[this.nbb - 2] = "null";
        } else {
            dHQ();
            if (this.nbb > 0) {
                this.nbc[this.nbb - 1] = "null";
            }
        }
        if (this.nbb > 0) {
            int[] iArr = this.nbd;
            int i = this.nbb - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public String toString() {
        return getClass().getSimpleName();
    }

    public void dHV() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) dHP()).next();
        push(entry.getValue());
        push(new JsonPrimitive((String) entry.getKey()));
    }

    private void push(Object obj) {
        if (this.nbb == this.nba.length) {
            Object[] objArr = new Object[this.nbb * 2];
            int[] iArr = new int[this.nbb * 2];
            String[] strArr = new String[this.nbb * 2];
            System.arraycopy(this.nba, 0, objArr, 0, this.nbb);
            System.arraycopy(this.nbd, 0, iArr, 0, this.nbb);
            System.arraycopy(this.nbc, 0, strArr, 0, this.nbb);
            this.nba = objArr;
            this.nbd = iArr;
            this.nbc = strArr;
        }
        Object[] objArr2 = this.nba;
        int i = this.nbb;
        this.nbb = i + 1;
        objArr2[i] = obj;
    }

    @Override // com.google.gson.stream.a
    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = 0;
        while (i < this.nbb) {
            if (this.nba[i] instanceof JsonArray) {
                i++;
                if (this.nba[i] instanceof Iterator) {
                    append.append('[').append(this.nbd[i]).append(']');
                }
            } else if (this.nba[i] instanceof JsonObject) {
                i++;
                if (this.nba[i] instanceof Iterator) {
                    append.append('.');
                    if (this.nbc[i] != null) {
                        append.append(this.nbc[i]);
                    }
                }
            }
            i++;
        }
        return append.toString();
    }

    private String dHW() {
        return " at path " + getPath();
    }
}
