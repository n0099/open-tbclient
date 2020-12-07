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
    private static final Reader puH = new Reader() { // from class: com.google.gson.internal.bind.a.1
        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }
    };
    private static final Object puI = new Object();
    private Object[] puJ;
    private int puK;
    private String[] puL;
    private int[] puM;

    public a(JsonElement jsonElement) {
        super(puH);
        this.puJ = new Object[32];
        this.puK = 0;
        this.puL = new String[32];
        this.puM = new int[32];
        push(jsonElement);
    }

    @Override // com.google.gson.stream.a
    public void eyw() throws IOException {
        a(JsonToken.BEGIN_ARRAY);
        push(((JsonArray) eyz()).iterator());
        this.puM[this.puK - 1] = 0;
    }

    @Override // com.google.gson.stream.a
    public void endArray() throws IOException {
        a(JsonToken.END_ARRAY);
        eyA();
        eyA();
        if (this.puK > 0) {
            int[] iArr = this.puM;
            int i = this.puK - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public void eyx() throws IOException {
        a(JsonToken.BEGIN_OBJECT);
        push(((JsonObject) eyz()).entrySet().iterator());
    }

    @Override // com.google.gson.stream.a
    public void endObject() throws IOException {
        a(JsonToken.END_OBJECT);
        eyA();
        eyA();
        if (this.puK > 0) {
            int[] iArr = this.puM;
            int i = this.puK - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public boolean hasNext() throws IOException {
        JsonToken eyy = eyy();
        return (eyy == JsonToken.END_OBJECT || eyy == JsonToken.END_ARRAY) ? false : true;
    }

    @Override // com.google.gson.stream.a
    public JsonToken eyy() throws IOException {
        if (this.puK == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object eyz = eyz();
        if (eyz instanceof Iterator) {
            boolean z = this.puJ[this.puK - 2] instanceof JsonObject;
            Iterator it = (Iterator) eyz;
            if (!it.hasNext()) {
                return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            } else if (z) {
                return JsonToken.NAME;
            } else {
                push(it.next());
                return eyy();
            }
        } else if (eyz instanceof JsonObject) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (eyz instanceof JsonArray) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (eyz instanceof JsonPrimitive) {
                JsonPrimitive jsonPrimitive = (JsonPrimitive) eyz;
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
            } else if (eyz instanceof JsonNull) {
                return JsonToken.NULL;
            } else {
                if (eyz == puI) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    private Object eyz() {
        return this.puJ[this.puK - 1];
    }

    private Object eyA() {
        Object[] objArr = this.puJ;
        int i = this.puK - 1;
        this.puK = i;
        Object obj = objArr[i];
        this.puJ[this.puK] = null;
        return obj;
    }

    private void a(JsonToken jsonToken) throws IOException {
        if (eyy() != jsonToken) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + eyy() + eyK());
        }
    }

    @Override // com.google.gson.stream.a
    public String eyB() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) eyz()).next();
        String str = (String) entry.getKey();
        this.puL[this.puK - 1] = str;
        push(entry.getValue());
        return str;
    }

    @Override // com.google.gson.stream.a
    public String eyC() throws IOException {
        JsonToken eyy = eyy();
        if (eyy != JsonToken.STRING && eyy != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected " + JsonToken.STRING + " but was " + eyy + eyK());
        }
        String asString = ((JsonPrimitive) eyA()).getAsString();
        if (this.puK > 0) {
            int[] iArr = this.puM;
            int i = this.puK - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asString;
    }

    @Override // com.google.gson.stream.a
    public boolean eyD() throws IOException {
        a(JsonToken.BOOLEAN);
        boolean asBoolean = ((JsonPrimitive) eyA()).getAsBoolean();
        if (this.puK > 0) {
            int[] iArr = this.puM;
            int i = this.puK - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asBoolean;
    }

    @Override // com.google.gson.stream.a
    public void eyE() throws IOException {
        a(JsonToken.NULL);
        eyA();
        if (this.puK > 0) {
            int[] iArr = this.puM;
            int i = this.puK - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public double eyF() throws IOException {
        JsonToken eyy = eyy();
        if (eyy != JsonToken.NUMBER && eyy != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + eyy + eyK());
        }
        double asDouble = ((JsonPrimitive) eyz()).getAsDouble();
        if (!eyW() && (Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + asDouble);
        }
        eyA();
        if (this.puK > 0) {
            int[] iArr = this.puM;
            int i = this.puK - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asDouble;
    }

    @Override // com.google.gson.stream.a
    public long eyG() throws IOException {
        JsonToken eyy = eyy();
        if (eyy != JsonToken.NUMBER && eyy != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + eyy + eyK());
        }
        long asLong = ((JsonPrimitive) eyz()).getAsLong();
        eyA();
        if (this.puK > 0) {
            int[] iArr = this.puM;
            int i = this.puK - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asLong;
    }

    @Override // com.google.gson.stream.a
    public int eyH() throws IOException {
        JsonToken eyy = eyy();
        if (eyy != JsonToken.NUMBER && eyy != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + eyy + eyK());
        }
        int asInt = ((JsonPrimitive) eyz()).getAsInt();
        eyA();
        if (this.puK > 0) {
            int[] iArr = this.puM;
            int i = this.puK - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asInt;
    }

    @Override // com.google.gson.stream.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.puJ = new Object[]{puI};
        this.puK = 1;
    }

    @Override // com.google.gson.stream.a
    public void eyI() throws IOException {
        if (eyy() == JsonToken.NAME) {
            eyB();
            this.puL[this.puK - 2] = "null";
        } else {
            eyA();
            if (this.puK > 0) {
                this.puL[this.puK - 1] = "null";
            }
        }
        if (this.puK > 0) {
            int[] iArr = this.puM;
            int i = this.puK - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public String toString() {
        return getClass().getSimpleName();
    }

    public void eyJ() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) eyz()).next();
        push(entry.getValue());
        push(new JsonPrimitive((String) entry.getKey()));
    }

    private void push(Object obj) {
        if (this.puK == this.puJ.length) {
            Object[] objArr = new Object[this.puK * 2];
            int[] iArr = new int[this.puK * 2];
            String[] strArr = new String[this.puK * 2];
            System.arraycopy(this.puJ, 0, objArr, 0, this.puK);
            System.arraycopy(this.puM, 0, iArr, 0, this.puK);
            System.arraycopy(this.puL, 0, strArr, 0, this.puK);
            this.puJ = objArr;
            this.puM = iArr;
            this.puL = strArr;
        }
        Object[] objArr2 = this.puJ;
        int i = this.puK;
        this.puK = i + 1;
        objArr2[i] = obj;
    }

    @Override // com.google.gson.stream.a
    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = 0;
        while (i < this.puK) {
            if (this.puJ[i] instanceof JsonArray) {
                i++;
                if (this.puJ[i] instanceof Iterator) {
                    append.append('[').append(this.puM[i]).append(']');
                }
            } else if (this.puJ[i] instanceof JsonObject) {
                i++;
                if (this.puJ[i] instanceof Iterator) {
                    append.append('.');
                    if (this.puL[i] != null) {
                        append.append(this.puL[i]);
                    }
                }
            }
            i++;
        }
        return append.toString();
    }

    private String eyK() {
        return " at path " + getPath();
    }
}
