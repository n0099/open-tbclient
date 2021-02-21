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
    private static final Reader pTv = new Reader() { // from class: com.google.gson.internal.bind.a.1
        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }
    };
    private static final Object pTw = new Object();
    private int[] pTA;
    private Object[] pTx;
    private int pTy;
    private String[] pTz;

    public a(JsonElement jsonElement) {
        super(pTv);
        this.pTx = new Object[32];
        this.pTy = 0;
        this.pTz = new String[32];
        this.pTA = new int[32];
        push(jsonElement);
    }

    @Override // com.google.gson.stream.a
    public void eBv() throws IOException {
        a(JsonToken.BEGIN_ARRAY);
        push(((JsonArray) eBy()).iterator());
        this.pTA[this.pTy - 1] = 0;
    }

    @Override // com.google.gson.stream.a
    public void endArray() throws IOException {
        a(JsonToken.END_ARRAY);
        eBz();
        eBz();
        if (this.pTy > 0) {
            int[] iArr = this.pTA;
            int i = this.pTy - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public void eBw() throws IOException {
        a(JsonToken.BEGIN_OBJECT);
        push(((JsonObject) eBy()).entrySet().iterator());
    }

    @Override // com.google.gson.stream.a
    public void endObject() throws IOException {
        a(JsonToken.END_OBJECT);
        eBz();
        eBz();
        if (this.pTy > 0) {
            int[] iArr = this.pTA;
            int i = this.pTy - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public boolean hasNext() throws IOException {
        JsonToken eBx = eBx();
        return (eBx == JsonToken.END_OBJECT || eBx == JsonToken.END_ARRAY) ? false : true;
    }

    @Override // com.google.gson.stream.a
    public JsonToken eBx() throws IOException {
        if (this.pTy == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object eBy = eBy();
        if (eBy instanceof Iterator) {
            boolean z = this.pTx[this.pTy - 2] instanceof JsonObject;
            Iterator it = (Iterator) eBy;
            if (!it.hasNext()) {
                return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            } else if (z) {
                return JsonToken.NAME;
            } else {
                push(it.next());
                return eBx();
            }
        } else if (eBy instanceof JsonObject) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (eBy instanceof JsonArray) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (eBy instanceof JsonPrimitive) {
                JsonPrimitive jsonPrimitive = (JsonPrimitive) eBy;
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
            } else if (eBy instanceof JsonNull) {
                return JsonToken.NULL;
            } else {
                if (eBy == pTw) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    private Object eBy() {
        return this.pTx[this.pTy - 1];
    }

    private Object eBz() {
        Object[] objArr = this.pTx;
        int i = this.pTy - 1;
        this.pTy = i;
        Object obj = objArr[i];
        this.pTx[this.pTy] = null;
        return obj;
    }

    private void a(JsonToken jsonToken) throws IOException {
        if (eBx() != jsonToken) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + eBx() + eBJ());
        }
    }

    @Override // com.google.gson.stream.a
    public String eBA() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) eBy()).next();
        String str = (String) entry.getKey();
        this.pTz[this.pTy - 1] = str;
        push(entry.getValue());
        return str;
    }

    @Override // com.google.gson.stream.a
    public String eBB() throws IOException {
        JsonToken eBx = eBx();
        if (eBx != JsonToken.STRING && eBx != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected " + JsonToken.STRING + " but was " + eBx + eBJ());
        }
        String asString = ((JsonPrimitive) eBz()).getAsString();
        if (this.pTy > 0) {
            int[] iArr = this.pTA;
            int i = this.pTy - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asString;
    }

    @Override // com.google.gson.stream.a
    public boolean eBC() throws IOException {
        a(JsonToken.BOOLEAN);
        boolean asBoolean = ((JsonPrimitive) eBz()).getAsBoolean();
        if (this.pTy > 0) {
            int[] iArr = this.pTA;
            int i = this.pTy - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asBoolean;
    }

    @Override // com.google.gson.stream.a
    public void eBD() throws IOException {
        a(JsonToken.NULL);
        eBz();
        if (this.pTy > 0) {
            int[] iArr = this.pTA;
            int i = this.pTy - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public double eBE() throws IOException {
        JsonToken eBx = eBx();
        if (eBx != JsonToken.NUMBER && eBx != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + eBx + eBJ());
        }
        double asDouble = ((JsonPrimitive) eBy()).getAsDouble();
        if (!eBV() && (Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + asDouble);
        }
        eBz();
        if (this.pTy > 0) {
            int[] iArr = this.pTA;
            int i = this.pTy - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asDouble;
    }

    @Override // com.google.gson.stream.a
    public long eBF() throws IOException {
        JsonToken eBx = eBx();
        if (eBx != JsonToken.NUMBER && eBx != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + eBx + eBJ());
        }
        long asLong = ((JsonPrimitive) eBy()).getAsLong();
        eBz();
        if (this.pTy > 0) {
            int[] iArr = this.pTA;
            int i = this.pTy - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asLong;
    }

    @Override // com.google.gson.stream.a
    public int eBG() throws IOException {
        JsonToken eBx = eBx();
        if (eBx != JsonToken.NUMBER && eBx != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + eBx + eBJ());
        }
        int asInt = ((JsonPrimitive) eBy()).getAsInt();
        eBz();
        if (this.pTy > 0) {
            int[] iArr = this.pTA;
            int i = this.pTy - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asInt;
    }

    @Override // com.google.gson.stream.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.pTx = new Object[]{pTw};
        this.pTy = 1;
    }

    @Override // com.google.gson.stream.a
    public void eBH() throws IOException {
        if (eBx() == JsonToken.NAME) {
            eBA();
            this.pTz[this.pTy - 2] = "null";
        } else {
            eBz();
            if (this.pTy > 0) {
                this.pTz[this.pTy - 1] = "null";
            }
        }
        if (this.pTy > 0) {
            int[] iArr = this.pTA;
            int i = this.pTy - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public String toString() {
        return getClass().getSimpleName();
    }

    public void eBI() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) eBy()).next();
        push(entry.getValue());
        push(new JsonPrimitive((String) entry.getKey()));
    }

    private void push(Object obj) {
        if (this.pTy == this.pTx.length) {
            Object[] objArr = new Object[this.pTy * 2];
            int[] iArr = new int[this.pTy * 2];
            String[] strArr = new String[this.pTy * 2];
            System.arraycopy(this.pTx, 0, objArr, 0, this.pTy);
            System.arraycopy(this.pTA, 0, iArr, 0, this.pTy);
            System.arraycopy(this.pTz, 0, strArr, 0, this.pTy);
            this.pTx = objArr;
            this.pTA = iArr;
            this.pTz = strArr;
        }
        Object[] objArr2 = this.pTx;
        int i = this.pTy;
        this.pTy = i + 1;
        objArr2[i] = obj;
    }

    @Override // com.google.gson.stream.a
    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = 0;
        while (i < this.pTy) {
            if (this.pTx[i] instanceof JsonArray) {
                i++;
                if (this.pTx[i] instanceof Iterator) {
                    append.append('[').append(this.pTA[i]).append(']');
                }
            } else if (this.pTx[i] instanceof JsonObject) {
                i++;
                if (this.pTx[i] instanceof Iterator) {
                    append.append('.');
                    if (this.pTz[i] != null) {
                        append.append(this.pTz[i]);
                    }
                }
            }
            i++;
        }
        return append.toString();
    }

    private String eBJ() {
        return " at path " + getPath();
    }
}
