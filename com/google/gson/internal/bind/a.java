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
    private static final Reader pIP = new Reader() { // from class: com.google.gson.internal.bind.a.1
        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }
    };
    private static final Object pIQ = new Object();
    private Object[] pIR;
    private int pIS;
    private String[] pIT;
    private int[] pIU;

    public a(JsonElement jsonElement) {
        super(pIP);
        this.pIR = new Object[32];
        this.pIS = 0;
        this.pIT = new String[32];
        this.pIU = new int[32];
        push(jsonElement);
    }

    @Override // com.google.gson.stream.a
    public void eyV() throws IOException {
        a(JsonToken.BEGIN_ARRAY);
        push(((JsonArray) eyY()).iterator());
        this.pIU[this.pIS - 1] = 0;
    }

    @Override // com.google.gson.stream.a
    public void endArray() throws IOException {
        a(JsonToken.END_ARRAY);
        eyZ();
        eyZ();
        if (this.pIS > 0) {
            int[] iArr = this.pIU;
            int i = this.pIS - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public void eyW() throws IOException {
        a(JsonToken.BEGIN_OBJECT);
        push(((JsonObject) eyY()).entrySet().iterator());
    }

    @Override // com.google.gson.stream.a
    public void endObject() throws IOException {
        a(JsonToken.END_OBJECT);
        eyZ();
        eyZ();
        if (this.pIS > 0) {
            int[] iArr = this.pIU;
            int i = this.pIS - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public boolean hasNext() throws IOException {
        JsonToken eyX = eyX();
        return (eyX == JsonToken.END_OBJECT || eyX == JsonToken.END_ARRAY) ? false : true;
    }

    @Override // com.google.gson.stream.a
    public JsonToken eyX() throws IOException {
        if (this.pIS == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object eyY = eyY();
        if (eyY instanceof Iterator) {
            boolean z = this.pIR[this.pIS - 2] instanceof JsonObject;
            Iterator it = (Iterator) eyY;
            if (!it.hasNext()) {
                return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            } else if (z) {
                return JsonToken.NAME;
            } else {
                push(it.next());
                return eyX();
            }
        } else if (eyY instanceof JsonObject) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (eyY instanceof JsonArray) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (eyY instanceof JsonPrimitive) {
                JsonPrimitive jsonPrimitive = (JsonPrimitive) eyY;
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
            } else if (eyY instanceof JsonNull) {
                return JsonToken.NULL;
            } else {
                if (eyY == pIQ) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    private Object eyY() {
        return this.pIR[this.pIS - 1];
    }

    private Object eyZ() {
        Object[] objArr = this.pIR;
        int i = this.pIS - 1;
        this.pIS = i;
        Object obj = objArr[i];
        this.pIR[this.pIS] = null;
        return obj;
    }

    private void a(JsonToken jsonToken) throws IOException {
        if (eyX() != jsonToken) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + eyX() + ezj());
        }
    }

    @Override // com.google.gson.stream.a
    public String eza() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) eyY()).next();
        String str = (String) entry.getKey();
        this.pIT[this.pIS - 1] = str;
        push(entry.getValue());
        return str;
    }

    @Override // com.google.gson.stream.a
    public String ezb() throws IOException {
        JsonToken eyX = eyX();
        if (eyX != JsonToken.STRING && eyX != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected " + JsonToken.STRING + " but was " + eyX + ezj());
        }
        String asString = ((JsonPrimitive) eyZ()).getAsString();
        if (this.pIS > 0) {
            int[] iArr = this.pIU;
            int i = this.pIS - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asString;
    }

    @Override // com.google.gson.stream.a
    public boolean ezc() throws IOException {
        a(JsonToken.BOOLEAN);
        boolean asBoolean = ((JsonPrimitive) eyZ()).getAsBoolean();
        if (this.pIS > 0) {
            int[] iArr = this.pIU;
            int i = this.pIS - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asBoolean;
    }

    @Override // com.google.gson.stream.a
    public void ezd() throws IOException {
        a(JsonToken.NULL);
        eyZ();
        if (this.pIS > 0) {
            int[] iArr = this.pIU;
            int i = this.pIS - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public double eze() throws IOException {
        JsonToken eyX = eyX();
        if (eyX != JsonToken.NUMBER && eyX != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + eyX + ezj());
        }
        double asDouble = ((JsonPrimitive) eyY()).getAsDouble();
        if (!ezv() && (Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + asDouble);
        }
        eyZ();
        if (this.pIS > 0) {
            int[] iArr = this.pIU;
            int i = this.pIS - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asDouble;
    }

    @Override // com.google.gson.stream.a
    public long ezf() throws IOException {
        JsonToken eyX = eyX();
        if (eyX != JsonToken.NUMBER && eyX != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + eyX + ezj());
        }
        long asLong = ((JsonPrimitive) eyY()).getAsLong();
        eyZ();
        if (this.pIS > 0) {
            int[] iArr = this.pIU;
            int i = this.pIS - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asLong;
    }

    @Override // com.google.gson.stream.a
    public int ezg() throws IOException {
        JsonToken eyX = eyX();
        if (eyX != JsonToken.NUMBER && eyX != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + eyX + ezj());
        }
        int asInt = ((JsonPrimitive) eyY()).getAsInt();
        eyZ();
        if (this.pIS > 0) {
            int[] iArr = this.pIU;
            int i = this.pIS - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asInt;
    }

    @Override // com.google.gson.stream.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.pIR = new Object[]{pIQ};
        this.pIS = 1;
    }

    @Override // com.google.gson.stream.a
    public void ezh() throws IOException {
        if (eyX() == JsonToken.NAME) {
            eza();
            this.pIT[this.pIS - 2] = "null";
        } else {
            eyZ();
            if (this.pIS > 0) {
                this.pIT[this.pIS - 1] = "null";
            }
        }
        if (this.pIS > 0) {
            int[] iArr = this.pIU;
            int i = this.pIS - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public String toString() {
        return getClass().getSimpleName();
    }

    public void ezi() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) eyY()).next();
        push(entry.getValue());
        push(new JsonPrimitive((String) entry.getKey()));
    }

    private void push(Object obj) {
        if (this.pIS == this.pIR.length) {
            Object[] objArr = new Object[this.pIS * 2];
            int[] iArr = new int[this.pIS * 2];
            String[] strArr = new String[this.pIS * 2];
            System.arraycopy(this.pIR, 0, objArr, 0, this.pIS);
            System.arraycopy(this.pIU, 0, iArr, 0, this.pIS);
            System.arraycopy(this.pIT, 0, strArr, 0, this.pIS);
            this.pIR = objArr;
            this.pIU = iArr;
            this.pIT = strArr;
        }
        Object[] objArr2 = this.pIR;
        int i = this.pIS;
        this.pIS = i + 1;
        objArr2[i] = obj;
    }

    @Override // com.google.gson.stream.a
    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = 0;
        while (i < this.pIS) {
            if (this.pIR[i] instanceof JsonArray) {
                i++;
                if (this.pIR[i] instanceof Iterator) {
                    append.append('[').append(this.pIU[i]).append(']');
                }
            } else if (this.pIR[i] instanceof JsonObject) {
                i++;
                if (this.pIR[i] instanceof Iterator) {
                    append.append('.');
                    if (this.pIT[i] != null) {
                        append.append(this.pIT[i]);
                    }
                }
            }
            i++;
        }
        return append.toString();
    }

    private String ezj() {
        return " at path " + getPath();
    }
}
