package com.google.gson.internal.bind;

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
/* loaded from: classes5.dex */
public final class a extends com.google.gson.stream.a {
    private static final Reader pLI = new Reader() { // from class: com.google.gson.internal.bind.a.1
        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }
    };
    private static final Object pLJ = new Object();
    private Object[] pLK;
    private int pLL;
    private String[] pLM;
    private int[] pLN;

    public a(JsonElement jsonElement) {
        super(pLI);
        this.pLK = new Object[32];
        this.pLL = 0;
        this.pLM = new String[32];
        this.pLN = new int[32];
        push(jsonElement);
    }

    @Override // com.google.gson.stream.a
    public void eCj() throws IOException {
        a(JsonToken.BEGIN_ARRAY);
        push(((JsonArray) eCm()).iterator());
        this.pLN[this.pLL - 1] = 0;
    }

    @Override // com.google.gson.stream.a
    public void endArray() throws IOException {
        a(JsonToken.END_ARRAY);
        eCn();
        eCn();
        if (this.pLL > 0) {
            int[] iArr = this.pLN;
            int i = this.pLL - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public void eCk() throws IOException {
        a(JsonToken.BEGIN_OBJECT);
        push(((JsonObject) eCm()).entrySet().iterator());
    }

    @Override // com.google.gson.stream.a
    public void endObject() throws IOException {
        a(JsonToken.END_OBJECT);
        eCn();
        eCn();
        if (this.pLL > 0) {
            int[] iArr = this.pLN;
            int i = this.pLL - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public boolean hasNext() throws IOException {
        JsonToken eCl = eCl();
        return (eCl == JsonToken.END_OBJECT || eCl == JsonToken.END_ARRAY) ? false : true;
    }

    @Override // com.google.gson.stream.a
    public JsonToken eCl() throws IOException {
        if (this.pLL == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object eCm = eCm();
        if (eCm instanceof Iterator) {
            boolean z = this.pLK[this.pLL - 2] instanceof JsonObject;
            Iterator it = (Iterator) eCm;
            if (!it.hasNext()) {
                return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            } else if (z) {
                return JsonToken.NAME;
            } else {
                push(it.next());
                return eCl();
            }
        } else if (eCm instanceof JsonObject) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (eCm instanceof JsonArray) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (eCm instanceof JsonPrimitive) {
                JsonPrimitive jsonPrimitive = (JsonPrimitive) eCm;
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
            } else if (eCm instanceof JsonNull) {
                return JsonToken.NULL;
            } else {
                if (eCm == pLJ) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    private Object eCm() {
        return this.pLK[this.pLL - 1];
    }

    private Object eCn() {
        Object[] objArr = this.pLK;
        int i = this.pLL - 1;
        this.pLL = i;
        Object obj = objArr[i];
        this.pLK[this.pLL] = null;
        return obj;
    }

    private void a(JsonToken jsonToken) throws IOException {
        if (eCl() != jsonToken) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + eCl() + eCx());
        }
    }

    @Override // com.google.gson.stream.a
    public String eCo() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) eCm()).next();
        String str = (String) entry.getKey();
        this.pLM[this.pLL - 1] = str;
        push(entry.getValue());
        return str;
    }

    @Override // com.google.gson.stream.a
    public String eCp() throws IOException {
        JsonToken eCl = eCl();
        if (eCl != JsonToken.STRING && eCl != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected " + JsonToken.STRING + " but was " + eCl + eCx());
        }
        String asString = ((JsonPrimitive) eCn()).getAsString();
        if (this.pLL > 0) {
            int[] iArr = this.pLN;
            int i = this.pLL - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asString;
    }

    @Override // com.google.gson.stream.a
    public boolean eCq() throws IOException {
        a(JsonToken.BOOLEAN);
        boolean asBoolean = ((JsonPrimitive) eCn()).getAsBoolean();
        if (this.pLL > 0) {
            int[] iArr = this.pLN;
            int i = this.pLL - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asBoolean;
    }

    @Override // com.google.gson.stream.a
    public void eCr() throws IOException {
        a(JsonToken.NULL);
        eCn();
        if (this.pLL > 0) {
            int[] iArr = this.pLN;
            int i = this.pLL - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public double eCs() throws IOException {
        JsonToken eCl = eCl();
        if (eCl != JsonToken.NUMBER && eCl != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + eCl + eCx());
        }
        double asDouble = ((JsonPrimitive) eCm()).getAsDouble();
        if (!eCJ() && (Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + asDouble);
        }
        eCn();
        if (this.pLL > 0) {
            int[] iArr = this.pLN;
            int i = this.pLL - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asDouble;
    }

    @Override // com.google.gson.stream.a
    public long eCt() throws IOException {
        JsonToken eCl = eCl();
        if (eCl != JsonToken.NUMBER && eCl != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + eCl + eCx());
        }
        long asLong = ((JsonPrimitive) eCm()).getAsLong();
        eCn();
        if (this.pLL > 0) {
            int[] iArr = this.pLN;
            int i = this.pLL - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asLong;
    }

    @Override // com.google.gson.stream.a
    public int eCu() throws IOException {
        JsonToken eCl = eCl();
        if (eCl != JsonToken.NUMBER && eCl != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + eCl + eCx());
        }
        int asInt = ((JsonPrimitive) eCm()).getAsInt();
        eCn();
        if (this.pLL > 0) {
            int[] iArr = this.pLN;
            int i = this.pLL - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asInt;
    }

    @Override // com.google.gson.stream.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.pLK = new Object[]{pLJ};
        this.pLL = 1;
    }

    @Override // com.google.gson.stream.a
    public void eCv() throws IOException {
        if (eCl() == JsonToken.NAME) {
            eCo();
            this.pLM[this.pLL - 2] = "null";
        } else {
            eCn();
            if (this.pLL > 0) {
                this.pLM[this.pLL - 1] = "null";
            }
        }
        if (this.pLL > 0) {
            int[] iArr = this.pLN;
            int i = this.pLL - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public String toString() {
        return getClass().getSimpleName();
    }

    public void eCw() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) eCm()).next();
        push(entry.getValue());
        push(new JsonPrimitive((String) entry.getKey()));
    }

    private void push(Object obj) {
        if (this.pLL == this.pLK.length) {
            Object[] objArr = new Object[this.pLL * 2];
            int[] iArr = new int[this.pLL * 2];
            String[] strArr = new String[this.pLL * 2];
            System.arraycopy(this.pLK, 0, objArr, 0, this.pLL);
            System.arraycopy(this.pLN, 0, iArr, 0, this.pLL);
            System.arraycopy(this.pLM, 0, strArr, 0, this.pLL);
            this.pLK = objArr;
            this.pLN = iArr;
            this.pLM = strArr;
        }
        Object[] objArr2 = this.pLK;
        int i = this.pLL;
        this.pLL = i + 1;
        objArr2[i] = obj;
    }

    @Override // com.google.gson.stream.a
    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = 0;
        while (i < this.pLL) {
            if (this.pLK[i] instanceof JsonArray) {
                i++;
                if (this.pLK[i] instanceof Iterator) {
                    append.append('[').append(this.pLN[i]).append(']');
                }
            } else if (this.pLK[i] instanceof JsonObject) {
                i++;
                if (this.pLK[i] instanceof Iterator) {
                    append.append('.');
                    if (this.pLM[i] != null) {
                        append.append(this.pLM[i]);
                    }
                }
            }
            i++;
        }
        return append.toString();
    }

    private String eCx() {
        return " at path " + getPath();
    }
}
