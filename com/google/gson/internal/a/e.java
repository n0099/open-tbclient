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
    private static final Reader njN = new Reader() { // from class: com.google.gson.internal.a.e.1
        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }
    };
    private static final Object njO = new Object();
    private Object[] njP;
    private int njQ;
    private String[] njR;
    private int[] njS;

    public e(JsonElement jsonElement) {
        super(njN);
        this.njP = new Object[32];
        this.njQ = 0;
        this.njR = new String[32];
        this.njS = new int[32];
        push(jsonElement);
    }

    @Override // com.google.gson.stream.a
    public void dLm() throws IOException {
        a(JsonToken.BEGIN_ARRAY);
        push(((JsonArray) dLp()).iterator());
        this.njS[this.njQ - 1] = 0;
    }

    @Override // com.google.gson.stream.a
    public void endArray() throws IOException {
        a(JsonToken.END_ARRAY);
        dLq();
        dLq();
        if (this.njQ > 0) {
            int[] iArr = this.njS;
            int i = this.njQ - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public void dLn() throws IOException {
        a(JsonToken.BEGIN_OBJECT);
        push(((JsonObject) dLp()).entrySet().iterator());
    }

    @Override // com.google.gson.stream.a
    public void endObject() throws IOException {
        a(JsonToken.END_OBJECT);
        dLq();
        dLq();
        if (this.njQ > 0) {
            int[] iArr = this.njS;
            int i = this.njQ - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public boolean hasNext() throws IOException {
        JsonToken dLo = dLo();
        return (dLo == JsonToken.END_OBJECT || dLo == JsonToken.END_ARRAY) ? false : true;
    }

    @Override // com.google.gson.stream.a
    public JsonToken dLo() throws IOException {
        if (this.njQ == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object dLp = dLp();
        if (dLp instanceof Iterator) {
            boolean z = this.njP[this.njQ - 2] instanceof JsonObject;
            Iterator it = (Iterator) dLp;
            if (!it.hasNext()) {
                return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            } else if (z) {
                return JsonToken.NAME;
            } else {
                push(it.next());
                return dLo();
            }
        } else if (dLp instanceof JsonObject) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (dLp instanceof JsonArray) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (dLp instanceof JsonPrimitive) {
                JsonPrimitive jsonPrimitive = (JsonPrimitive) dLp;
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
            } else if (dLp instanceof JsonNull) {
                return JsonToken.NULL;
            } else {
                if (dLp == njO) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    private Object dLp() {
        return this.njP[this.njQ - 1];
    }

    private Object dLq() {
        Object[] objArr = this.njP;
        int i = this.njQ - 1;
        this.njQ = i;
        Object obj = objArr[i];
        this.njP[this.njQ] = null;
        return obj;
    }

    private void a(JsonToken jsonToken) throws IOException {
        if (dLo() != jsonToken) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + dLo() + dLw());
        }
    }

    @Override // com.google.gson.stream.a
    public String dLr() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) dLp()).next();
        String str = (String) entry.getKey();
        this.njR[this.njQ - 1] = str;
        push(entry.getValue());
        return str;
    }

    @Override // com.google.gson.stream.a
    public String dLs() throws IOException {
        JsonToken dLo = dLo();
        if (dLo != JsonToken.STRING && dLo != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected " + JsonToken.STRING + " but was " + dLo + dLw());
        }
        String asString = ((JsonPrimitive) dLq()).getAsString();
        if (this.njQ > 0) {
            int[] iArr = this.njS;
            int i = this.njQ - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asString;
    }

    @Override // com.google.gson.stream.a
    public boolean nextBoolean() throws IOException {
        a(JsonToken.BOOLEAN);
        boolean asBoolean = ((JsonPrimitive) dLq()).getAsBoolean();
        if (this.njQ > 0) {
            int[] iArr = this.njS;
            int i = this.njQ - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asBoolean;
    }

    @Override // com.google.gson.stream.a
    public void dLt() throws IOException {
        a(JsonToken.NULL);
        dLq();
        if (this.njQ > 0) {
            int[] iArr = this.njS;
            int i = this.njQ - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public double nextDouble() throws IOException {
        JsonToken dLo = dLo();
        if (dLo != JsonToken.NUMBER && dLo != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + dLo + dLw());
        }
        double asDouble = ((JsonPrimitive) dLp()).getAsDouble();
        if (!dLI() && (Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + asDouble);
        }
        dLq();
        if (this.njQ > 0) {
            int[] iArr = this.njS;
            int i = this.njQ - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asDouble;
    }

    @Override // com.google.gson.stream.a
    public long nextLong() throws IOException {
        JsonToken dLo = dLo();
        if (dLo != JsonToken.NUMBER && dLo != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + dLo + dLw());
        }
        long asLong = ((JsonPrimitive) dLp()).getAsLong();
        dLq();
        if (this.njQ > 0) {
            int[] iArr = this.njS;
            int i = this.njQ - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asLong;
    }

    @Override // com.google.gson.stream.a
    public int nextInt() throws IOException {
        JsonToken dLo = dLo();
        if (dLo != JsonToken.NUMBER && dLo != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + dLo + dLw());
        }
        int asInt = ((JsonPrimitive) dLp()).getAsInt();
        dLq();
        if (this.njQ > 0) {
            int[] iArr = this.njS;
            int i = this.njQ - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asInt;
    }

    @Override // com.google.gson.stream.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.njP = new Object[]{njO};
        this.njQ = 1;
    }

    @Override // com.google.gson.stream.a
    public void dLu() throws IOException {
        if (dLo() == JsonToken.NAME) {
            dLr();
            this.njR[this.njQ - 2] = "null";
        } else {
            dLq();
            if (this.njQ > 0) {
                this.njR[this.njQ - 1] = "null";
            }
        }
        if (this.njQ > 0) {
            int[] iArr = this.njS;
            int i = this.njQ - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public String toString() {
        return getClass().getSimpleName();
    }

    public void dLv() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) dLp()).next();
        push(entry.getValue());
        push(new JsonPrimitive((String) entry.getKey()));
    }

    private void push(Object obj) {
        if (this.njQ == this.njP.length) {
            Object[] objArr = new Object[this.njQ * 2];
            int[] iArr = new int[this.njQ * 2];
            String[] strArr = new String[this.njQ * 2];
            System.arraycopy(this.njP, 0, objArr, 0, this.njQ);
            System.arraycopy(this.njS, 0, iArr, 0, this.njQ);
            System.arraycopy(this.njR, 0, strArr, 0, this.njQ);
            this.njP = objArr;
            this.njS = iArr;
            this.njR = strArr;
        }
        Object[] objArr2 = this.njP;
        int i = this.njQ;
        this.njQ = i + 1;
        objArr2[i] = obj;
    }

    @Override // com.google.gson.stream.a
    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = 0;
        while (i < this.njQ) {
            if (this.njP[i] instanceof JsonArray) {
                i++;
                if (this.njP[i] instanceof Iterator) {
                    append.append('[').append(this.njS[i]).append(']');
                }
            } else if (this.njP[i] instanceof JsonObject) {
                i++;
                if (this.njP[i] instanceof Iterator) {
                    append.append('.');
                    if (this.njR[i] != null) {
                        append.append(this.njR[i]);
                    }
                }
            }
            i++;
        }
        return append.toString();
    }

    private String dLw() {
        return " at path " + getPath();
    }
}
