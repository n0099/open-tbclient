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
/* loaded from: classes4.dex */
public final class e extends com.google.gson.stream.a {
    private static final Reader mGI = new Reader() { // from class: com.google.gson.internal.a.e.1
        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }
    };
    private static final Object mGJ = new Object();
    private Object[] mGK;
    private int mGL;
    private String[] mGM;
    private int[] mGN;

    public e(JsonElement jsonElement) {
        super(mGI);
        this.mGK = new Object[32];
        this.mGL = 0;
        this.mGM = new String[32];
        this.mGN = new int[32];
        push(jsonElement);
    }

    @Override // com.google.gson.stream.a
    public void dyw() throws IOException {
        a(JsonToken.BEGIN_ARRAY);
        push(((JsonArray) dyB()).iterator());
        this.mGN[this.mGL - 1] = 0;
    }

    @Override // com.google.gson.stream.a
    public void dyx() throws IOException {
        a(JsonToken.END_ARRAY);
        dyC();
        dyC();
        if (this.mGL > 0) {
            int[] iArr = this.mGN;
            int i = this.mGL - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public void dyy() throws IOException {
        a(JsonToken.BEGIN_OBJECT);
        push(((JsonObject) dyB()).entrySet().iterator());
    }

    @Override // com.google.gson.stream.a
    public void dyz() throws IOException {
        a(JsonToken.END_OBJECT);
        dyC();
        dyC();
        if (this.mGL > 0) {
            int[] iArr = this.mGN;
            int i = this.mGL - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public boolean hasNext() throws IOException {
        JsonToken dyA = dyA();
        return (dyA == JsonToken.END_OBJECT || dyA == JsonToken.END_ARRAY) ? false : true;
    }

    @Override // com.google.gson.stream.a
    public JsonToken dyA() throws IOException {
        if (this.mGL == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object dyB = dyB();
        if (dyB instanceof Iterator) {
            boolean z = this.mGK[this.mGL - 2] instanceof JsonObject;
            Iterator it = (Iterator) dyB;
            if (!it.hasNext()) {
                return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            } else if (z) {
                return JsonToken.NAME;
            } else {
                push(it.next());
                return dyA();
            }
        } else if (dyB instanceof JsonObject) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (dyB instanceof JsonArray) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (dyB instanceof JsonPrimitive) {
                JsonPrimitive jsonPrimitive = (JsonPrimitive) dyB;
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
            } else if (dyB instanceof JsonNull) {
                return JsonToken.NULL;
            } else {
                if (dyB == mGJ) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    private Object dyB() {
        return this.mGK[this.mGL - 1];
    }

    private Object dyC() {
        Object[] objArr = this.mGK;
        int i = this.mGL - 1;
        this.mGL = i;
        Object obj = objArr[i];
        this.mGK[this.mGL] = null;
        return obj;
    }

    private void a(JsonToken jsonToken) throws IOException {
        if (dyA() != jsonToken) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + dyA() + dyM());
        }
    }

    @Override // com.google.gson.stream.a
    public String dyD() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) dyB()).next();
        String str = (String) entry.getKey();
        this.mGM[this.mGL - 1] = str;
        push(entry.getValue());
        return str;
    }

    @Override // com.google.gson.stream.a
    public String dyE() throws IOException {
        JsonToken dyA = dyA();
        if (dyA != JsonToken.STRING && dyA != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected " + JsonToken.STRING + " but was " + dyA + dyM());
        }
        String asString = ((JsonPrimitive) dyC()).getAsString();
        if (this.mGL > 0) {
            int[] iArr = this.mGN;
            int i = this.mGL - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asString;
    }

    @Override // com.google.gson.stream.a
    public boolean dyF() throws IOException {
        a(JsonToken.BOOLEAN);
        boolean asBoolean = ((JsonPrimitive) dyC()).getAsBoolean();
        if (this.mGL > 0) {
            int[] iArr = this.mGN;
            int i = this.mGL - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asBoolean;
    }

    @Override // com.google.gson.stream.a
    public void dyG() throws IOException {
        a(JsonToken.NULL);
        dyC();
        if (this.mGL > 0) {
            int[] iArr = this.mGN;
            int i = this.mGL - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public double dyH() throws IOException {
        JsonToken dyA = dyA();
        if (dyA != JsonToken.NUMBER && dyA != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + dyA + dyM());
        }
        double asDouble = ((JsonPrimitive) dyB()).getAsDouble();
        if (!dyX() && (Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + asDouble);
        }
        dyC();
        if (this.mGL > 0) {
            int[] iArr = this.mGN;
            int i = this.mGL - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asDouble;
    }

    @Override // com.google.gson.stream.a
    public long dyI() throws IOException {
        JsonToken dyA = dyA();
        if (dyA != JsonToken.NUMBER && dyA != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + dyA + dyM());
        }
        long asLong = ((JsonPrimitive) dyB()).getAsLong();
        dyC();
        if (this.mGL > 0) {
            int[] iArr = this.mGN;
            int i = this.mGL - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asLong;
    }

    @Override // com.google.gson.stream.a
    public int dyJ() throws IOException {
        JsonToken dyA = dyA();
        if (dyA != JsonToken.NUMBER && dyA != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + dyA + dyM());
        }
        int asInt = ((JsonPrimitive) dyB()).getAsInt();
        dyC();
        if (this.mGL > 0) {
            int[] iArr = this.mGN;
            int i = this.mGL - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asInt;
    }

    @Override // com.google.gson.stream.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mGK = new Object[]{mGJ};
        this.mGL = 1;
    }

    @Override // com.google.gson.stream.a
    public void dyK() throws IOException {
        if (dyA() == JsonToken.NAME) {
            dyD();
            this.mGM[this.mGL - 2] = "null";
        } else {
            dyC();
            if (this.mGL > 0) {
                this.mGM[this.mGL - 1] = "null";
            }
        }
        if (this.mGL > 0) {
            int[] iArr = this.mGN;
            int i = this.mGL - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public String toString() {
        return getClass().getSimpleName();
    }

    public void dyL() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) dyB()).next();
        push(entry.getValue());
        push(new JsonPrimitive((String) entry.getKey()));
    }

    private void push(Object obj) {
        if (this.mGL == this.mGK.length) {
            Object[] objArr = new Object[this.mGL * 2];
            int[] iArr = new int[this.mGL * 2];
            String[] strArr = new String[this.mGL * 2];
            System.arraycopy(this.mGK, 0, objArr, 0, this.mGL);
            System.arraycopy(this.mGN, 0, iArr, 0, this.mGL);
            System.arraycopy(this.mGM, 0, strArr, 0, this.mGL);
            this.mGK = objArr;
            this.mGN = iArr;
            this.mGM = strArr;
        }
        Object[] objArr2 = this.mGK;
        int i = this.mGL;
        this.mGL = i + 1;
        objArr2[i] = obj;
    }

    @Override // com.google.gson.stream.a
    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = 0;
        while (i < this.mGL) {
            if (this.mGK[i] instanceof JsonArray) {
                i++;
                if (this.mGK[i] instanceof Iterator) {
                    append.append('[').append(this.mGN[i]).append(']');
                }
            } else if (this.mGK[i] instanceof JsonObject) {
                i++;
                if (this.mGK[i] instanceof Iterator) {
                    append.append('.');
                    if (this.mGM[i] != null) {
                        append.append(this.mGM[i]);
                    }
                }
            }
            i++;
        }
        return append.toString();
    }

    private String dyM() {
        return " at path " + getPath();
    }
}
