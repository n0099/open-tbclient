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
    private static final Reader puJ = new Reader() { // from class: com.google.gson.internal.bind.a.1
        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }
    };
    private static final Object puK = new Object();
    private Object[] puL;
    private int puM;
    private String[] puN;
    private int[] puO;

    public a(JsonElement jsonElement) {
        super(puJ);
        this.puL = new Object[32];
        this.puM = 0;
        this.puN = new String[32];
        this.puO = new int[32];
        push(jsonElement);
    }

    @Override // com.google.gson.stream.a
    public void eyx() throws IOException {
        a(JsonToken.BEGIN_ARRAY);
        push(((JsonArray) eyA()).iterator());
        this.puO[this.puM - 1] = 0;
    }

    @Override // com.google.gson.stream.a
    public void endArray() throws IOException {
        a(JsonToken.END_ARRAY);
        eyB();
        eyB();
        if (this.puM > 0) {
            int[] iArr = this.puO;
            int i = this.puM - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public void eyy() throws IOException {
        a(JsonToken.BEGIN_OBJECT);
        push(((JsonObject) eyA()).entrySet().iterator());
    }

    @Override // com.google.gson.stream.a
    public void endObject() throws IOException {
        a(JsonToken.END_OBJECT);
        eyB();
        eyB();
        if (this.puM > 0) {
            int[] iArr = this.puO;
            int i = this.puM - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public boolean hasNext() throws IOException {
        JsonToken eyz = eyz();
        return (eyz == JsonToken.END_OBJECT || eyz == JsonToken.END_ARRAY) ? false : true;
    }

    @Override // com.google.gson.stream.a
    public JsonToken eyz() throws IOException {
        if (this.puM == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object eyA = eyA();
        if (eyA instanceof Iterator) {
            boolean z = this.puL[this.puM - 2] instanceof JsonObject;
            Iterator it = (Iterator) eyA;
            if (!it.hasNext()) {
                return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            } else if (z) {
                return JsonToken.NAME;
            } else {
                push(it.next());
                return eyz();
            }
        } else if (eyA instanceof JsonObject) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (eyA instanceof JsonArray) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (eyA instanceof JsonPrimitive) {
                JsonPrimitive jsonPrimitive = (JsonPrimitive) eyA;
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
            } else if (eyA instanceof JsonNull) {
                return JsonToken.NULL;
            } else {
                if (eyA == puK) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    private Object eyA() {
        return this.puL[this.puM - 1];
    }

    private Object eyB() {
        Object[] objArr = this.puL;
        int i = this.puM - 1;
        this.puM = i;
        Object obj = objArr[i];
        this.puL[this.puM] = null;
        return obj;
    }

    private void a(JsonToken jsonToken) throws IOException {
        if (eyz() != jsonToken) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + eyz() + eyL());
        }
    }

    @Override // com.google.gson.stream.a
    public String eyC() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) eyA()).next();
        String str = (String) entry.getKey();
        this.puN[this.puM - 1] = str;
        push(entry.getValue());
        return str;
    }

    @Override // com.google.gson.stream.a
    public String eyD() throws IOException {
        JsonToken eyz = eyz();
        if (eyz != JsonToken.STRING && eyz != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected " + JsonToken.STRING + " but was " + eyz + eyL());
        }
        String asString = ((JsonPrimitive) eyB()).getAsString();
        if (this.puM > 0) {
            int[] iArr = this.puO;
            int i = this.puM - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asString;
    }

    @Override // com.google.gson.stream.a
    public boolean eyE() throws IOException {
        a(JsonToken.BOOLEAN);
        boolean asBoolean = ((JsonPrimitive) eyB()).getAsBoolean();
        if (this.puM > 0) {
            int[] iArr = this.puO;
            int i = this.puM - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asBoolean;
    }

    @Override // com.google.gson.stream.a
    public void eyF() throws IOException {
        a(JsonToken.NULL);
        eyB();
        if (this.puM > 0) {
            int[] iArr = this.puO;
            int i = this.puM - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public double eyG() throws IOException {
        JsonToken eyz = eyz();
        if (eyz != JsonToken.NUMBER && eyz != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + eyz + eyL());
        }
        double asDouble = ((JsonPrimitive) eyA()).getAsDouble();
        if (!eyX() && (Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + asDouble);
        }
        eyB();
        if (this.puM > 0) {
            int[] iArr = this.puO;
            int i = this.puM - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asDouble;
    }

    @Override // com.google.gson.stream.a
    public long eyH() throws IOException {
        JsonToken eyz = eyz();
        if (eyz != JsonToken.NUMBER && eyz != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + eyz + eyL());
        }
        long asLong = ((JsonPrimitive) eyA()).getAsLong();
        eyB();
        if (this.puM > 0) {
            int[] iArr = this.puO;
            int i = this.puM - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asLong;
    }

    @Override // com.google.gson.stream.a
    public int eyI() throws IOException {
        JsonToken eyz = eyz();
        if (eyz != JsonToken.NUMBER && eyz != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + eyz + eyL());
        }
        int asInt = ((JsonPrimitive) eyA()).getAsInt();
        eyB();
        if (this.puM > 0) {
            int[] iArr = this.puO;
            int i = this.puM - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asInt;
    }

    @Override // com.google.gson.stream.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.puL = new Object[]{puK};
        this.puM = 1;
    }

    @Override // com.google.gson.stream.a
    public void eyJ() throws IOException {
        if (eyz() == JsonToken.NAME) {
            eyC();
            this.puN[this.puM - 2] = "null";
        } else {
            eyB();
            if (this.puM > 0) {
                this.puN[this.puM - 1] = "null";
            }
        }
        if (this.puM > 0) {
            int[] iArr = this.puO;
            int i = this.puM - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public String toString() {
        return getClass().getSimpleName();
    }

    public void eyK() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) eyA()).next();
        push(entry.getValue());
        push(new JsonPrimitive((String) entry.getKey()));
    }

    private void push(Object obj) {
        if (this.puM == this.puL.length) {
            Object[] objArr = new Object[this.puM * 2];
            int[] iArr = new int[this.puM * 2];
            String[] strArr = new String[this.puM * 2];
            System.arraycopy(this.puL, 0, objArr, 0, this.puM);
            System.arraycopy(this.puO, 0, iArr, 0, this.puM);
            System.arraycopy(this.puN, 0, strArr, 0, this.puM);
            this.puL = objArr;
            this.puO = iArr;
            this.puN = strArr;
        }
        Object[] objArr2 = this.puL;
        int i = this.puM;
        this.puM = i + 1;
        objArr2[i] = obj;
    }

    @Override // com.google.gson.stream.a
    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = 0;
        while (i < this.puM) {
            if (this.puL[i] instanceof JsonArray) {
                i++;
                if (this.puL[i] instanceof Iterator) {
                    append.append('[').append(this.puO[i]).append(']');
                }
            } else if (this.puL[i] instanceof JsonObject) {
                i++;
                if (this.puL[i] instanceof Iterator) {
                    append.append('.');
                    if (this.puN[i] != null) {
                        append.append(this.puN[i]);
                    }
                }
            }
            i++;
        }
        return append.toString();
    }

    private String eyL() {
        return " at path " + getPath();
    }
}
