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
    private static final Reader pNq = new Reader() { // from class: com.google.gson.internal.bind.a.1
        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }
    };
    private static final Object pNr = new Object();
    private Object[] pNs;
    private int pNt;
    private String[] pNu;
    private int[] pNv;

    public a(JsonElement jsonElement) {
        super(pNq);
        this.pNs = new Object[32];
        this.pNt = 0;
        this.pNu = new String[32];
        this.pNv = new int[32];
        push(jsonElement);
    }

    @Override // com.google.gson.stream.a
    public void eCN() throws IOException {
        a(JsonToken.BEGIN_ARRAY);
        push(((JsonArray) eCQ()).iterator());
        this.pNv[this.pNt - 1] = 0;
    }

    @Override // com.google.gson.stream.a
    public void endArray() throws IOException {
        a(JsonToken.END_ARRAY);
        eCR();
        eCR();
        if (this.pNt > 0) {
            int[] iArr = this.pNv;
            int i = this.pNt - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public void eCO() throws IOException {
        a(JsonToken.BEGIN_OBJECT);
        push(((JsonObject) eCQ()).entrySet().iterator());
    }

    @Override // com.google.gson.stream.a
    public void endObject() throws IOException {
        a(JsonToken.END_OBJECT);
        eCR();
        eCR();
        if (this.pNt > 0) {
            int[] iArr = this.pNv;
            int i = this.pNt - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public boolean hasNext() throws IOException {
        JsonToken eCP = eCP();
        return (eCP == JsonToken.END_OBJECT || eCP == JsonToken.END_ARRAY) ? false : true;
    }

    @Override // com.google.gson.stream.a
    public JsonToken eCP() throws IOException {
        if (this.pNt == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object eCQ = eCQ();
        if (eCQ instanceof Iterator) {
            boolean z = this.pNs[this.pNt - 2] instanceof JsonObject;
            Iterator it = (Iterator) eCQ;
            if (!it.hasNext()) {
                return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            } else if (z) {
                return JsonToken.NAME;
            } else {
                push(it.next());
                return eCP();
            }
        } else if (eCQ instanceof JsonObject) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (eCQ instanceof JsonArray) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (eCQ instanceof JsonPrimitive) {
                JsonPrimitive jsonPrimitive = (JsonPrimitive) eCQ;
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
            } else if (eCQ instanceof JsonNull) {
                return JsonToken.NULL;
            } else {
                if (eCQ == pNr) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    private Object eCQ() {
        return this.pNs[this.pNt - 1];
    }

    private Object eCR() {
        Object[] objArr = this.pNs;
        int i = this.pNt - 1;
        this.pNt = i;
        Object obj = objArr[i];
        this.pNs[this.pNt] = null;
        return obj;
    }

    private void a(JsonToken jsonToken) throws IOException {
        if (eCP() != jsonToken) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + eCP() + eDb());
        }
    }

    @Override // com.google.gson.stream.a
    public String eCS() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) eCQ()).next();
        String str = (String) entry.getKey();
        this.pNu[this.pNt - 1] = str;
        push(entry.getValue());
        return str;
    }

    @Override // com.google.gson.stream.a
    public String eCT() throws IOException {
        JsonToken eCP = eCP();
        if (eCP != JsonToken.STRING && eCP != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected " + JsonToken.STRING + " but was " + eCP + eDb());
        }
        String asString = ((JsonPrimitive) eCR()).getAsString();
        if (this.pNt > 0) {
            int[] iArr = this.pNv;
            int i = this.pNt - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asString;
    }

    @Override // com.google.gson.stream.a
    public boolean eCU() throws IOException {
        a(JsonToken.BOOLEAN);
        boolean asBoolean = ((JsonPrimitive) eCR()).getAsBoolean();
        if (this.pNt > 0) {
            int[] iArr = this.pNv;
            int i = this.pNt - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asBoolean;
    }

    @Override // com.google.gson.stream.a
    public void eCV() throws IOException {
        a(JsonToken.NULL);
        eCR();
        if (this.pNt > 0) {
            int[] iArr = this.pNv;
            int i = this.pNt - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public double eCW() throws IOException {
        JsonToken eCP = eCP();
        if (eCP != JsonToken.NUMBER && eCP != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + eCP + eDb());
        }
        double asDouble = ((JsonPrimitive) eCQ()).getAsDouble();
        if (!eDn() && (Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + asDouble);
        }
        eCR();
        if (this.pNt > 0) {
            int[] iArr = this.pNv;
            int i = this.pNt - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asDouble;
    }

    @Override // com.google.gson.stream.a
    public long eCX() throws IOException {
        JsonToken eCP = eCP();
        if (eCP != JsonToken.NUMBER && eCP != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + eCP + eDb());
        }
        long asLong = ((JsonPrimitive) eCQ()).getAsLong();
        eCR();
        if (this.pNt > 0) {
            int[] iArr = this.pNv;
            int i = this.pNt - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asLong;
    }

    @Override // com.google.gson.stream.a
    public int eCY() throws IOException {
        JsonToken eCP = eCP();
        if (eCP != JsonToken.NUMBER && eCP != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + eCP + eDb());
        }
        int asInt = ((JsonPrimitive) eCQ()).getAsInt();
        eCR();
        if (this.pNt > 0) {
            int[] iArr = this.pNv;
            int i = this.pNt - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asInt;
    }

    @Override // com.google.gson.stream.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.pNs = new Object[]{pNr};
        this.pNt = 1;
    }

    @Override // com.google.gson.stream.a
    public void eCZ() throws IOException {
        if (eCP() == JsonToken.NAME) {
            eCS();
            this.pNu[this.pNt - 2] = "null";
        } else {
            eCR();
            if (this.pNt > 0) {
                this.pNu[this.pNt - 1] = "null";
            }
        }
        if (this.pNt > 0) {
            int[] iArr = this.pNv;
            int i = this.pNt - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public String toString() {
        return getClass().getSimpleName();
    }

    public void eDa() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) eCQ()).next();
        push(entry.getValue());
        push(new JsonPrimitive((String) entry.getKey()));
    }

    private void push(Object obj) {
        if (this.pNt == this.pNs.length) {
            Object[] objArr = new Object[this.pNt * 2];
            int[] iArr = new int[this.pNt * 2];
            String[] strArr = new String[this.pNt * 2];
            System.arraycopy(this.pNs, 0, objArr, 0, this.pNt);
            System.arraycopy(this.pNv, 0, iArr, 0, this.pNt);
            System.arraycopy(this.pNu, 0, strArr, 0, this.pNt);
            this.pNs = objArr;
            this.pNv = iArr;
            this.pNu = strArr;
        }
        Object[] objArr2 = this.pNs;
        int i = this.pNt;
        this.pNt = i + 1;
        objArr2[i] = obj;
    }

    @Override // com.google.gson.stream.a
    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = 0;
        while (i < this.pNt) {
            if (this.pNs[i] instanceof JsonArray) {
                i++;
                if (this.pNs[i] instanceof Iterator) {
                    append.append('[').append(this.pNv[i]).append(']');
                }
            } else if (this.pNs[i] instanceof JsonObject) {
                i++;
                if (this.pNs[i] instanceof Iterator) {
                    append.append('.');
                    if (this.pNu[i] != null) {
                        append.append(this.pNu[i]);
                    }
                }
            }
            i++;
        }
        return append.toString();
    }

    private String eDb() {
        return " at path " + getPath();
    }
}
