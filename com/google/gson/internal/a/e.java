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
    private static final Reader mNb = new Reader() { // from class: com.google.gson.internal.a.e.1
        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }
    };
    private static final Object mNc = new Object();
    private Object[] mNd;
    private int mNe;
    private String[] mNf;
    private int[] mNg;

    public e(JsonElement jsonElement) {
        super(mNb);
        this.mNd = new Object[32];
        this.mNe = 0;
        this.mNf = new String[32];
        this.mNg = new int[32];
        push(jsonElement);
    }

    @Override // com.google.gson.stream.a
    public void dBp() throws IOException {
        a(JsonToken.BEGIN_ARRAY);
        push(((JsonArray) dBs()).iterator());
        this.mNg[this.mNe - 1] = 0;
    }

    @Override // com.google.gson.stream.a
    public void endArray() throws IOException {
        a(JsonToken.END_ARRAY);
        dBt();
        dBt();
        if (this.mNe > 0) {
            int[] iArr = this.mNg;
            int i = this.mNe - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public void dBq() throws IOException {
        a(JsonToken.BEGIN_OBJECT);
        push(((JsonObject) dBs()).entrySet().iterator());
    }

    @Override // com.google.gson.stream.a
    public void endObject() throws IOException {
        a(JsonToken.END_OBJECT);
        dBt();
        dBt();
        if (this.mNe > 0) {
            int[] iArr = this.mNg;
            int i = this.mNe - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public boolean hasNext() throws IOException {
        JsonToken dBr = dBr();
        return (dBr == JsonToken.END_OBJECT || dBr == JsonToken.END_ARRAY) ? false : true;
    }

    @Override // com.google.gson.stream.a
    public JsonToken dBr() throws IOException {
        if (this.mNe == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object dBs = dBs();
        if (dBs instanceof Iterator) {
            boolean z = this.mNd[this.mNe - 2] instanceof JsonObject;
            Iterator it = (Iterator) dBs;
            if (!it.hasNext()) {
                return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            } else if (z) {
                return JsonToken.NAME;
            } else {
                push(it.next());
                return dBr();
            }
        } else if (dBs instanceof JsonObject) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (dBs instanceof JsonArray) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (dBs instanceof JsonPrimitive) {
                JsonPrimitive jsonPrimitive = (JsonPrimitive) dBs;
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
            } else if (dBs instanceof JsonNull) {
                return JsonToken.NULL;
            } else {
                if (dBs == mNc) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    private Object dBs() {
        return this.mNd[this.mNe - 1];
    }

    private Object dBt() {
        Object[] objArr = this.mNd;
        int i = this.mNe - 1;
        this.mNe = i;
        Object obj = objArr[i];
        this.mNd[this.mNe] = null;
        return obj;
    }

    private void a(JsonToken jsonToken) throws IOException {
        if (dBr() != jsonToken) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + dBr() + dBz());
        }
    }

    @Override // com.google.gson.stream.a
    public String dBu() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) dBs()).next();
        String str = (String) entry.getKey();
        this.mNf[this.mNe - 1] = str;
        push(entry.getValue());
        return str;
    }

    @Override // com.google.gson.stream.a
    public String dBv() throws IOException {
        JsonToken dBr = dBr();
        if (dBr != JsonToken.STRING && dBr != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected " + JsonToken.STRING + " but was " + dBr + dBz());
        }
        String asString = ((JsonPrimitive) dBt()).getAsString();
        if (this.mNe > 0) {
            int[] iArr = this.mNg;
            int i = this.mNe - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asString;
    }

    @Override // com.google.gson.stream.a
    public boolean nextBoolean() throws IOException {
        a(JsonToken.BOOLEAN);
        boolean asBoolean = ((JsonPrimitive) dBt()).getAsBoolean();
        if (this.mNe > 0) {
            int[] iArr = this.mNg;
            int i = this.mNe - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asBoolean;
    }

    @Override // com.google.gson.stream.a
    public void dBw() throws IOException {
        a(JsonToken.NULL);
        dBt();
        if (this.mNe > 0) {
            int[] iArr = this.mNg;
            int i = this.mNe - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public double nextDouble() throws IOException {
        JsonToken dBr = dBr();
        if (dBr != JsonToken.NUMBER && dBr != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + dBr + dBz());
        }
        double asDouble = ((JsonPrimitive) dBs()).getAsDouble();
        if (!dBK() && (Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + asDouble);
        }
        dBt();
        if (this.mNe > 0) {
            int[] iArr = this.mNg;
            int i = this.mNe - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asDouble;
    }

    @Override // com.google.gson.stream.a
    public long nextLong() throws IOException {
        JsonToken dBr = dBr();
        if (dBr != JsonToken.NUMBER && dBr != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + dBr + dBz());
        }
        long asLong = ((JsonPrimitive) dBs()).getAsLong();
        dBt();
        if (this.mNe > 0) {
            int[] iArr = this.mNg;
            int i = this.mNe - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asLong;
    }

    @Override // com.google.gson.stream.a
    public int nextInt() throws IOException {
        JsonToken dBr = dBr();
        if (dBr != JsonToken.NUMBER && dBr != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + dBr + dBz());
        }
        int asInt = ((JsonPrimitive) dBs()).getAsInt();
        dBt();
        if (this.mNe > 0) {
            int[] iArr = this.mNg;
            int i = this.mNe - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asInt;
    }

    @Override // com.google.gson.stream.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mNd = new Object[]{mNc};
        this.mNe = 1;
    }

    @Override // com.google.gson.stream.a
    public void dBx() throws IOException {
        if (dBr() == JsonToken.NAME) {
            dBu();
            this.mNf[this.mNe - 2] = "null";
        } else {
            dBt();
            if (this.mNe > 0) {
                this.mNf[this.mNe - 1] = "null";
            }
        }
        if (this.mNe > 0) {
            int[] iArr = this.mNg;
            int i = this.mNe - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public String toString() {
        return getClass().getSimpleName();
    }

    public void dBy() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) dBs()).next();
        push(entry.getValue());
        push(new JsonPrimitive((String) entry.getKey()));
    }

    private void push(Object obj) {
        if (this.mNe == this.mNd.length) {
            Object[] objArr = new Object[this.mNe * 2];
            int[] iArr = new int[this.mNe * 2];
            String[] strArr = new String[this.mNe * 2];
            System.arraycopy(this.mNd, 0, objArr, 0, this.mNe);
            System.arraycopy(this.mNg, 0, iArr, 0, this.mNe);
            System.arraycopy(this.mNf, 0, strArr, 0, this.mNe);
            this.mNd = objArr;
            this.mNg = iArr;
            this.mNf = strArr;
        }
        Object[] objArr2 = this.mNd;
        int i = this.mNe;
        this.mNe = i + 1;
        objArr2[i] = obj;
    }

    @Override // com.google.gson.stream.a
    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = 0;
        while (i < this.mNe) {
            if (this.mNd[i] instanceof JsonArray) {
                i++;
                if (this.mNd[i] instanceof Iterator) {
                    append.append('[').append(this.mNg[i]).append(']');
                }
            } else if (this.mNd[i] instanceof JsonObject) {
                i++;
                if (this.mNd[i] instanceof Iterator) {
                    append.append('.');
                    if (this.mNf[i] != null) {
                        append.append(this.mNf[i]);
                    }
                }
            }
            i++;
        }
        return append.toString();
    }

    private String dBz() {
        return " at path " + getPath();
    }
}
