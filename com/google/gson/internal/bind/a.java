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
/* loaded from: classes4.dex */
public final class a extends com.google.gson.stream.a {
    private static final Reader pUk = new Reader() { // from class: com.google.gson.internal.bind.a.1
        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }
    };
    private static final Object pUl = new Object();
    private Object[] pUm;
    private int pUn;
    private String[] pUo;
    private int[] pUp;

    public a(JsonElement jsonElement) {
        super(pUk);
        this.pUm = new Object[32];
        this.pUn = 0;
        this.pUo = new String[32];
        this.pUp = new int[32];
        push(jsonElement);
    }

    @Override // com.google.gson.stream.a
    public void eBB() throws IOException {
        a(JsonToken.BEGIN_ARRAY);
        push(((JsonArray) eBE()).iterator());
        this.pUp[this.pUn - 1] = 0;
    }

    @Override // com.google.gson.stream.a
    public void endArray() throws IOException {
        a(JsonToken.END_ARRAY);
        eBF();
        eBF();
        if (this.pUn > 0) {
            int[] iArr = this.pUp;
            int i = this.pUn - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public void eBC() throws IOException {
        a(JsonToken.BEGIN_OBJECT);
        push(((JsonObject) eBE()).entrySet().iterator());
    }

    @Override // com.google.gson.stream.a
    public void endObject() throws IOException {
        a(JsonToken.END_OBJECT);
        eBF();
        eBF();
        if (this.pUn > 0) {
            int[] iArr = this.pUp;
            int i = this.pUn - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public boolean hasNext() throws IOException {
        JsonToken eBD = eBD();
        return (eBD == JsonToken.END_OBJECT || eBD == JsonToken.END_ARRAY) ? false : true;
    }

    @Override // com.google.gson.stream.a
    public JsonToken eBD() throws IOException {
        if (this.pUn == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object eBE = eBE();
        if (eBE instanceof Iterator) {
            boolean z = this.pUm[this.pUn - 2] instanceof JsonObject;
            Iterator it = (Iterator) eBE;
            if (!it.hasNext()) {
                return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            } else if (z) {
                return JsonToken.NAME;
            } else {
                push(it.next());
                return eBD();
            }
        } else if (eBE instanceof JsonObject) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (eBE instanceof JsonArray) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (eBE instanceof JsonPrimitive) {
                JsonPrimitive jsonPrimitive = (JsonPrimitive) eBE;
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
            } else if (eBE instanceof JsonNull) {
                return JsonToken.NULL;
            } else {
                if (eBE == pUl) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    private Object eBE() {
        return this.pUm[this.pUn - 1];
    }

    private Object eBF() {
        Object[] objArr = this.pUm;
        int i = this.pUn - 1;
        this.pUn = i;
        Object obj = objArr[i];
        this.pUm[this.pUn] = null;
        return obj;
    }

    private void a(JsonToken jsonToken) throws IOException {
        if (eBD() != jsonToken) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + eBD() + eBP());
        }
    }

    @Override // com.google.gson.stream.a
    public String eBG() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) eBE()).next();
        String str = (String) entry.getKey();
        this.pUo[this.pUn - 1] = str;
        push(entry.getValue());
        return str;
    }

    @Override // com.google.gson.stream.a
    public String eBH() throws IOException {
        JsonToken eBD = eBD();
        if (eBD != JsonToken.STRING && eBD != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected " + JsonToken.STRING + " but was " + eBD + eBP());
        }
        String asString = ((JsonPrimitive) eBF()).getAsString();
        if (this.pUn > 0) {
            int[] iArr = this.pUp;
            int i = this.pUn - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asString;
    }

    @Override // com.google.gson.stream.a
    public boolean eBI() throws IOException {
        a(JsonToken.BOOLEAN);
        boolean asBoolean = ((JsonPrimitive) eBF()).getAsBoolean();
        if (this.pUn > 0) {
            int[] iArr = this.pUp;
            int i = this.pUn - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asBoolean;
    }

    @Override // com.google.gson.stream.a
    public void eBJ() throws IOException {
        a(JsonToken.NULL);
        eBF();
        if (this.pUn > 0) {
            int[] iArr = this.pUp;
            int i = this.pUn - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public double eBK() throws IOException {
        JsonToken eBD = eBD();
        if (eBD != JsonToken.NUMBER && eBD != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + eBD + eBP());
        }
        double asDouble = ((JsonPrimitive) eBE()).getAsDouble();
        if (!eCb() && (Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + asDouble);
        }
        eBF();
        if (this.pUn > 0) {
            int[] iArr = this.pUp;
            int i = this.pUn - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asDouble;
    }

    @Override // com.google.gson.stream.a
    public long eBL() throws IOException {
        JsonToken eBD = eBD();
        if (eBD != JsonToken.NUMBER && eBD != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + eBD + eBP());
        }
        long asLong = ((JsonPrimitive) eBE()).getAsLong();
        eBF();
        if (this.pUn > 0) {
            int[] iArr = this.pUp;
            int i = this.pUn - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asLong;
    }

    @Override // com.google.gson.stream.a
    public int eBM() throws IOException {
        JsonToken eBD = eBD();
        if (eBD != JsonToken.NUMBER && eBD != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + eBD + eBP());
        }
        int asInt = ((JsonPrimitive) eBE()).getAsInt();
        eBF();
        if (this.pUn > 0) {
            int[] iArr = this.pUp;
            int i = this.pUn - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asInt;
    }

    @Override // com.google.gson.stream.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.pUm = new Object[]{pUl};
        this.pUn = 1;
    }

    @Override // com.google.gson.stream.a
    public void eBN() throws IOException {
        if (eBD() == JsonToken.NAME) {
            eBG();
            this.pUo[this.pUn - 2] = "null";
        } else {
            eBF();
            if (this.pUn > 0) {
                this.pUo[this.pUn - 1] = "null";
            }
        }
        if (this.pUn > 0) {
            int[] iArr = this.pUp;
            int i = this.pUn - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public String toString() {
        return getClass().getSimpleName();
    }

    public void eBO() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) eBE()).next();
        push(entry.getValue());
        push(new JsonPrimitive((String) entry.getKey()));
    }

    private void push(Object obj) {
        if (this.pUn == this.pUm.length) {
            Object[] objArr = new Object[this.pUn * 2];
            int[] iArr = new int[this.pUn * 2];
            String[] strArr = new String[this.pUn * 2];
            System.arraycopy(this.pUm, 0, objArr, 0, this.pUn);
            System.arraycopy(this.pUp, 0, iArr, 0, this.pUn);
            System.arraycopy(this.pUo, 0, strArr, 0, this.pUn);
            this.pUm = objArr;
            this.pUp = iArr;
            this.pUo = strArr;
        }
        Object[] objArr2 = this.pUm;
        int i = this.pUn;
        this.pUn = i + 1;
        objArr2[i] = obj;
    }

    @Override // com.google.gson.stream.a
    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = 0;
        while (i < this.pUn) {
            if (this.pUm[i] instanceof JsonArray) {
                i++;
                if (this.pUm[i] instanceof Iterator) {
                    append.append('[').append(this.pUp[i]).append(']');
                }
            } else if (this.pUm[i] instanceof JsonObject) {
                i++;
                if (this.pUm[i] instanceof Iterator) {
                    append.append('.');
                    if (this.pUo[i] != null) {
                        append.append(this.pUo[i]);
                    }
                }
            }
            i++;
        }
        return append.toString();
    }

    private String eBP() {
        return " at path " + getPath();
    }
}
