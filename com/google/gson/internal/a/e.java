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
/* loaded from: classes10.dex */
public final class e extends com.google.gson.stream.a {
    private static final Reader njL = new Reader() { // from class: com.google.gson.internal.a.e.1
        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }
    };
    private static final Object njM = new Object();
    private Object[] njN;
    private int njO;
    private String[] njP;
    private int[] njQ;

    public e(JsonElement jsonElement) {
        super(njL);
        this.njN = new Object[32];
        this.njO = 0;
        this.njP = new String[32];
        this.njQ = new int[32];
        push(jsonElement);
    }

    @Override // com.google.gson.stream.a
    public void dLl() throws IOException {
        a(JsonToken.BEGIN_ARRAY);
        push(((JsonArray) dLo()).iterator());
        this.njQ[this.njO - 1] = 0;
    }

    @Override // com.google.gson.stream.a
    public void endArray() throws IOException {
        a(JsonToken.END_ARRAY);
        dLp();
        dLp();
        if (this.njO > 0) {
            int[] iArr = this.njQ;
            int i = this.njO - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public void dLm() throws IOException {
        a(JsonToken.BEGIN_OBJECT);
        push(((JsonObject) dLo()).entrySet().iterator());
    }

    @Override // com.google.gson.stream.a
    public void endObject() throws IOException {
        a(JsonToken.END_OBJECT);
        dLp();
        dLp();
        if (this.njO > 0) {
            int[] iArr = this.njQ;
            int i = this.njO - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public boolean hasNext() throws IOException {
        JsonToken dLn = dLn();
        return (dLn == JsonToken.END_OBJECT || dLn == JsonToken.END_ARRAY) ? false : true;
    }

    @Override // com.google.gson.stream.a
    public JsonToken dLn() throws IOException {
        if (this.njO == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object dLo = dLo();
        if (dLo instanceof Iterator) {
            boolean z = this.njN[this.njO - 2] instanceof JsonObject;
            Iterator it = (Iterator) dLo;
            if (!it.hasNext()) {
                return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            } else if (z) {
                return JsonToken.NAME;
            } else {
                push(it.next());
                return dLn();
            }
        } else if (dLo instanceof JsonObject) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (dLo instanceof JsonArray) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (dLo instanceof JsonPrimitive) {
                JsonPrimitive jsonPrimitive = (JsonPrimitive) dLo;
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
            } else if (dLo instanceof JsonNull) {
                return JsonToken.NULL;
            } else {
                if (dLo == njM) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    private Object dLo() {
        return this.njN[this.njO - 1];
    }

    private Object dLp() {
        Object[] objArr = this.njN;
        int i = this.njO - 1;
        this.njO = i;
        Object obj = objArr[i];
        this.njN[this.njO] = null;
        return obj;
    }

    private void a(JsonToken jsonToken) throws IOException {
        if (dLn() != jsonToken) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + dLn() + dLv());
        }
    }

    @Override // com.google.gson.stream.a
    public String dLq() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) dLo()).next();
        String str = (String) entry.getKey();
        this.njP[this.njO - 1] = str;
        push(entry.getValue());
        return str;
    }

    @Override // com.google.gson.stream.a
    public String dLr() throws IOException {
        JsonToken dLn = dLn();
        if (dLn != JsonToken.STRING && dLn != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected " + JsonToken.STRING + " but was " + dLn + dLv());
        }
        String asString = ((JsonPrimitive) dLp()).getAsString();
        if (this.njO > 0) {
            int[] iArr = this.njQ;
            int i = this.njO - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asString;
    }

    @Override // com.google.gson.stream.a
    public boolean nextBoolean() throws IOException {
        a(JsonToken.BOOLEAN);
        boolean asBoolean = ((JsonPrimitive) dLp()).getAsBoolean();
        if (this.njO > 0) {
            int[] iArr = this.njQ;
            int i = this.njO - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asBoolean;
    }

    @Override // com.google.gson.stream.a
    public void dLs() throws IOException {
        a(JsonToken.NULL);
        dLp();
        if (this.njO > 0) {
            int[] iArr = this.njQ;
            int i = this.njO - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public double nextDouble() throws IOException {
        JsonToken dLn = dLn();
        if (dLn != JsonToken.NUMBER && dLn != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + dLn + dLv());
        }
        double asDouble = ((JsonPrimitive) dLo()).getAsDouble();
        if (!dLH() && (Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + asDouble);
        }
        dLp();
        if (this.njO > 0) {
            int[] iArr = this.njQ;
            int i = this.njO - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asDouble;
    }

    @Override // com.google.gson.stream.a
    public long nextLong() throws IOException {
        JsonToken dLn = dLn();
        if (dLn != JsonToken.NUMBER && dLn != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + dLn + dLv());
        }
        long asLong = ((JsonPrimitive) dLo()).getAsLong();
        dLp();
        if (this.njO > 0) {
            int[] iArr = this.njQ;
            int i = this.njO - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asLong;
    }

    @Override // com.google.gson.stream.a
    public int nextInt() throws IOException {
        JsonToken dLn = dLn();
        if (dLn != JsonToken.NUMBER && dLn != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + dLn + dLv());
        }
        int asInt = ((JsonPrimitive) dLo()).getAsInt();
        dLp();
        if (this.njO > 0) {
            int[] iArr = this.njQ;
            int i = this.njO - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asInt;
    }

    @Override // com.google.gson.stream.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.njN = new Object[]{njM};
        this.njO = 1;
    }

    @Override // com.google.gson.stream.a
    public void dLt() throws IOException {
        if (dLn() == JsonToken.NAME) {
            dLq();
            this.njP[this.njO - 2] = "null";
        } else {
            dLp();
            if (this.njO > 0) {
                this.njP[this.njO - 1] = "null";
            }
        }
        if (this.njO > 0) {
            int[] iArr = this.njQ;
            int i = this.njO - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public String toString() {
        return getClass().getSimpleName();
    }

    public void dLu() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) dLo()).next();
        push(entry.getValue());
        push(new JsonPrimitive((String) entry.getKey()));
    }

    private void push(Object obj) {
        if (this.njO == this.njN.length) {
            Object[] objArr = new Object[this.njO * 2];
            int[] iArr = new int[this.njO * 2];
            String[] strArr = new String[this.njO * 2];
            System.arraycopy(this.njN, 0, objArr, 0, this.njO);
            System.arraycopy(this.njQ, 0, iArr, 0, this.njO);
            System.arraycopy(this.njP, 0, strArr, 0, this.njO);
            this.njN = objArr;
            this.njQ = iArr;
            this.njP = strArr;
        }
        Object[] objArr2 = this.njN;
        int i = this.njO;
        this.njO = i + 1;
        objArr2[i] = obj;
    }

    @Override // com.google.gson.stream.a
    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = 0;
        while (i < this.njO) {
            if (this.njN[i] instanceof JsonArray) {
                i++;
                if (this.njN[i] instanceof Iterator) {
                    append.append('[').append(this.njQ[i]).append(']');
                }
            } else if (this.njN[i] instanceof JsonObject) {
                i++;
                if (this.njN[i] instanceof Iterator) {
                    append.append('.');
                    if (this.njP[i] != null) {
                        append.append(this.njP[i]);
                    }
                }
            }
            i++;
        }
        return append.toString();
    }

    private String dLv() {
        return " at path " + getPath();
    }
}
