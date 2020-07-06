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
    private static final Reader nbb = new Reader() { // from class: com.google.gson.internal.a.e.1
        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }
    };
    private static final Object nbc = new Object();
    private Object[] nbd;
    private int nbe;
    private String[] nbf;
    private int[] nbg;

    public e(JsonElement jsonElement) {
        super(nbb);
        this.nbd = new Object[32];
        this.nbe = 0;
        this.nbf = new String[32];
        this.nbg = new int[32];
        push(jsonElement);
    }

    @Override // com.google.gson.stream.a
    public void dHQ() throws IOException {
        a(JsonToken.BEGIN_ARRAY);
        push(((JsonArray) dHT()).iterator());
        this.nbg[this.nbe - 1] = 0;
    }

    @Override // com.google.gson.stream.a
    public void endArray() throws IOException {
        a(JsonToken.END_ARRAY);
        dHU();
        dHU();
        if (this.nbe > 0) {
            int[] iArr = this.nbg;
            int i = this.nbe - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public void dHR() throws IOException {
        a(JsonToken.BEGIN_OBJECT);
        push(((JsonObject) dHT()).entrySet().iterator());
    }

    @Override // com.google.gson.stream.a
    public void endObject() throws IOException {
        a(JsonToken.END_OBJECT);
        dHU();
        dHU();
        if (this.nbe > 0) {
            int[] iArr = this.nbg;
            int i = this.nbe - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public boolean hasNext() throws IOException {
        JsonToken dHS = dHS();
        return (dHS == JsonToken.END_OBJECT || dHS == JsonToken.END_ARRAY) ? false : true;
    }

    @Override // com.google.gson.stream.a
    public JsonToken dHS() throws IOException {
        if (this.nbe == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object dHT = dHT();
        if (dHT instanceof Iterator) {
            boolean z = this.nbd[this.nbe - 2] instanceof JsonObject;
            Iterator it = (Iterator) dHT;
            if (!it.hasNext()) {
                return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            } else if (z) {
                return JsonToken.NAME;
            } else {
                push(it.next());
                return dHS();
            }
        } else if (dHT instanceof JsonObject) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (dHT instanceof JsonArray) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (dHT instanceof JsonPrimitive) {
                JsonPrimitive jsonPrimitive = (JsonPrimitive) dHT;
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
            } else if (dHT instanceof JsonNull) {
                return JsonToken.NULL;
            } else {
                if (dHT == nbc) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    private Object dHT() {
        return this.nbd[this.nbe - 1];
    }

    private Object dHU() {
        Object[] objArr = this.nbd;
        int i = this.nbe - 1;
        this.nbe = i;
        Object obj = objArr[i];
        this.nbd[this.nbe] = null;
        return obj;
    }

    private void a(JsonToken jsonToken) throws IOException {
        if (dHS() != jsonToken) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + dHS() + dIa());
        }
    }

    @Override // com.google.gson.stream.a
    public String dHV() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) dHT()).next();
        String str = (String) entry.getKey();
        this.nbf[this.nbe - 1] = str;
        push(entry.getValue());
        return str;
    }

    @Override // com.google.gson.stream.a
    public String dHW() throws IOException {
        JsonToken dHS = dHS();
        if (dHS != JsonToken.STRING && dHS != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected " + JsonToken.STRING + " but was " + dHS + dIa());
        }
        String asString = ((JsonPrimitive) dHU()).getAsString();
        if (this.nbe > 0) {
            int[] iArr = this.nbg;
            int i = this.nbe - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asString;
    }

    @Override // com.google.gson.stream.a
    public boolean nextBoolean() throws IOException {
        a(JsonToken.BOOLEAN);
        boolean asBoolean = ((JsonPrimitive) dHU()).getAsBoolean();
        if (this.nbe > 0) {
            int[] iArr = this.nbg;
            int i = this.nbe - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asBoolean;
    }

    @Override // com.google.gson.stream.a
    public void dHX() throws IOException {
        a(JsonToken.NULL);
        dHU();
        if (this.nbe > 0) {
            int[] iArr = this.nbg;
            int i = this.nbe - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public double nextDouble() throws IOException {
        JsonToken dHS = dHS();
        if (dHS != JsonToken.NUMBER && dHS != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + dHS + dIa());
        }
        double asDouble = ((JsonPrimitive) dHT()).getAsDouble();
        if (!dIm() && (Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + asDouble);
        }
        dHU();
        if (this.nbe > 0) {
            int[] iArr = this.nbg;
            int i = this.nbe - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asDouble;
    }

    @Override // com.google.gson.stream.a
    public long nextLong() throws IOException {
        JsonToken dHS = dHS();
        if (dHS != JsonToken.NUMBER && dHS != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + dHS + dIa());
        }
        long asLong = ((JsonPrimitive) dHT()).getAsLong();
        dHU();
        if (this.nbe > 0) {
            int[] iArr = this.nbg;
            int i = this.nbe - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asLong;
    }

    @Override // com.google.gson.stream.a
    public int nextInt() throws IOException {
        JsonToken dHS = dHS();
        if (dHS != JsonToken.NUMBER && dHS != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + dHS + dIa());
        }
        int asInt = ((JsonPrimitive) dHT()).getAsInt();
        dHU();
        if (this.nbe > 0) {
            int[] iArr = this.nbg;
            int i = this.nbe - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asInt;
    }

    @Override // com.google.gson.stream.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.nbd = new Object[]{nbc};
        this.nbe = 1;
    }

    @Override // com.google.gson.stream.a
    public void dHY() throws IOException {
        if (dHS() == JsonToken.NAME) {
            dHV();
            this.nbf[this.nbe - 2] = "null";
        } else {
            dHU();
            if (this.nbe > 0) {
                this.nbf[this.nbe - 1] = "null";
            }
        }
        if (this.nbe > 0) {
            int[] iArr = this.nbg;
            int i = this.nbe - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public String toString() {
        return getClass().getSimpleName();
    }

    public void dHZ() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) dHT()).next();
        push(entry.getValue());
        push(new JsonPrimitive((String) entry.getKey()));
    }

    private void push(Object obj) {
        if (this.nbe == this.nbd.length) {
            Object[] objArr = new Object[this.nbe * 2];
            int[] iArr = new int[this.nbe * 2];
            String[] strArr = new String[this.nbe * 2];
            System.arraycopy(this.nbd, 0, objArr, 0, this.nbe);
            System.arraycopy(this.nbg, 0, iArr, 0, this.nbe);
            System.arraycopy(this.nbf, 0, strArr, 0, this.nbe);
            this.nbd = objArr;
            this.nbg = iArr;
            this.nbf = strArr;
        }
        Object[] objArr2 = this.nbd;
        int i = this.nbe;
        this.nbe = i + 1;
        objArr2[i] = obj;
    }

    @Override // com.google.gson.stream.a
    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = 0;
        while (i < this.nbe) {
            if (this.nbd[i] instanceof JsonArray) {
                i++;
                if (this.nbd[i] instanceof Iterator) {
                    append.append('[').append(this.nbg[i]).append(']');
                }
            } else if (this.nbd[i] instanceof JsonObject) {
                i++;
                if (this.nbd[i] instanceof Iterator) {
                    append.append('.');
                    if (this.nbf[i] != null) {
                        append.append(this.nbf[i]);
                    }
                }
            }
            i++;
        }
        return append.toString();
    }

    private String dIa() {
        return " at path " + getPath();
    }
}
