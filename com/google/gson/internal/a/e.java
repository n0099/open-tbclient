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
/* loaded from: classes7.dex */
public final class e extends com.google.gson.stream.a {
    private static final Reader mjN = new Reader() { // from class: com.google.gson.internal.a.e.1
        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }
    };
    private static final Object mjO = new Object();
    private Object[] mjP;
    private int mjQ;
    private String[] mjR;
    private int[] mjS;

    public e(JsonElement jsonElement) {
        super(mjN);
        this.mjP = new Object[32];
        this.mjQ = 0;
        this.mjR = new String[32];
        this.mjS = new int[32];
        push(jsonElement);
    }

    @Override // com.google.gson.stream.a
    public void dvH() throws IOException {
        a(JsonToken.BEGIN_ARRAY);
        push(((JsonArray) dvK()).iterator());
        this.mjS[this.mjQ - 1] = 0;
    }

    @Override // com.google.gson.stream.a
    public void endArray() throws IOException {
        a(JsonToken.END_ARRAY);
        dvL();
        dvL();
        if (this.mjQ > 0) {
            int[] iArr = this.mjS;
            int i = this.mjQ - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public void dvI() throws IOException {
        a(JsonToken.BEGIN_OBJECT);
        push(((JsonObject) dvK()).entrySet().iterator());
    }

    @Override // com.google.gson.stream.a
    public void endObject() throws IOException {
        a(JsonToken.END_OBJECT);
        dvL();
        dvL();
        if (this.mjQ > 0) {
            int[] iArr = this.mjS;
            int i = this.mjQ - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public boolean hasNext() throws IOException {
        JsonToken dvJ = dvJ();
        return (dvJ == JsonToken.END_OBJECT || dvJ == JsonToken.END_ARRAY) ? false : true;
    }

    @Override // com.google.gson.stream.a
    public JsonToken dvJ() throws IOException {
        if (this.mjQ == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object dvK = dvK();
        if (dvK instanceof Iterator) {
            boolean z = this.mjP[this.mjQ - 2] instanceof JsonObject;
            Iterator it = (Iterator) dvK;
            if (!it.hasNext()) {
                return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            } else if (z) {
                return JsonToken.NAME;
            } else {
                push(it.next());
                return dvJ();
            }
        } else if (dvK instanceof JsonObject) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (dvK instanceof JsonArray) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (dvK instanceof JsonPrimitive) {
                JsonPrimitive jsonPrimitive = (JsonPrimitive) dvK;
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
            } else if (dvK instanceof JsonNull) {
                return JsonToken.NULL;
            } else {
                if (dvK == mjO) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    private Object dvK() {
        return this.mjP[this.mjQ - 1];
    }

    private Object dvL() {
        Object[] objArr = this.mjP;
        int i = this.mjQ - 1;
        this.mjQ = i;
        Object obj = objArr[i];
        this.mjP[this.mjQ] = null;
        return obj;
    }

    private void a(JsonToken jsonToken) throws IOException {
        if (dvJ() != jsonToken) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + dvJ() + dvR());
        }
    }

    @Override // com.google.gson.stream.a
    public String dvM() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) dvK()).next();
        String str = (String) entry.getKey();
        this.mjR[this.mjQ - 1] = str;
        push(entry.getValue());
        return str;
    }

    @Override // com.google.gson.stream.a
    public String dvN() throws IOException {
        JsonToken dvJ = dvJ();
        if (dvJ != JsonToken.STRING && dvJ != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected " + JsonToken.STRING + " but was " + dvJ + dvR());
        }
        String asString = ((JsonPrimitive) dvL()).getAsString();
        if (this.mjQ > 0) {
            int[] iArr = this.mjS;
            int i = this.mjQ - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asString;
    }

    @Override // com.google.gson.stream.a
    public boolean nextBoolean() throws IOException {
        a(JsonToken.BOOLEAN);
        boolean asBoolean = ((JsonPrimitive) dvL()).getAsBoolean();
        if (this.mjQ > 0) {
            int[] iArr = this.mjS;
            int i = this.mjQ - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asBoolean;
    }

    @Override // com.google.gson.stream.a
    public void dvO() throws IOException {
        a(JsonToken.NULL);
        dvL();
        if (this.mjQ > 0) {
            int[] iArr = this.mjS;
            int i = this.mjQ - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public double nextDouble() throws IOException {
        JsonToken dvJ = dvJ();
        if (dvJ != JsonToken.NUMBER && dvJ != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + dvJ + dvR());
        }
        double asDouble = ((JsonPrimitive) dvK()).getAsDouble();
        if (!dwd() && (Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + asDouble);
        }
        dvL();
        if (this.mjQ > 0) {
            int[] iArr = this.mjS;
            int i = this.mjQ - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asDouble;
    }

    @Override // com.google.gson.stream.a
    public long nextLong() throws IOException {
        JsonToken dvJ = dvJ();
        if (dvJ != JsonToken.NUMBER && dvJ != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + dvJ + dvR());
        }
        long asLong = ((JsonPrimitive) dvK()).getAsLong();
        dvL();
        if (this.mjQ > 0) {
            int[] iArr = this.mjS;
            int i = this.mjQ - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asLong;
    }

    @Override // com.google.gson.stream.a
    public int nextInt() throws IOException {
        JsonToken dvJ = dvJ();
        if (dvJ != JsonToken.NUMBER && dvJ != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + dvJ + dvR());
        }
        int asInt = ((JsonPrimitive) dvK()).getAsInt();
        dvL();
        if (this.mjQ > 0) {
            int[] iArr = this.mjS;
            int i = this.mjQ - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asInt;
    }

    @Override // com.google.gson.stream.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mjP = new Object[]{mjO};
        this.mjQ = 1;
    }

    @Override // com.google.gson.stream.a
    public void dvP() throws IOException {
        if (dvJ() == JsonToken.NAME) {
            dvM();
            this.mjR[this.mjQ - 2] = "null";
        } else {
            dvL();
            if (this.mjQ > 0) {
                this.mjR[this.mjQ - 1] = "null";
            }
        }
        if (this.mjQ > 0) {
            int[] iArr = this.mjS;
            int i = this.mjQ - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public String toString() {
        return getClass().getSimpleName();
    }

    public void dvQ() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) dvK()).next();
        push(entry.getValue());
        push(new JsonPrimitive((String) entry.getKey()));
    }

    private void push(Object obj) {
        if (this.mjQ == this.mjP.length) {
            Object[] objArr = new Object[this.mjQ * 2];
            int[] iArr = new int[this.mjQ * 2];
            String[] strArr = new String[this.mjQ * 2];
            System.arraycopy(this.mjP, 0, objArr, 0, this.mjQ);
            System.arraycopy(this.mjS, 0, iArr, 0, this.mjQ);
            System.arraycopy(this.mjR, 0, strArr, 0, this.mjQ);
            this.mjP = objArr;
            this.mjS = iArr;
            this.mjR = strArr;
        }
        Object[] objArr2 = this.mjP;
        int i = this.mjQ;
        this.mjQ = i + 1;
        objArr2[i] = obj;
    }

    @Override // com.google.gson.stream.a
    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = 0;
        while (i < this.mjQ) {
            if (this.mjP[i] instanceof JsonArray) {
                i++;
                if (this.mjP[i] instanceof Iterator) {
                    append.append('[').append(this.mjS[i]).append(']');
                }
            } else if (this.mjP[i] instanceof JsonObject) {
                i++;
                if (this.mjP[i] instanceof Iterator) {
                    append.append('.');
                    if (this.mjR[i] != null) {
                        append.append(this.mjR[i]);
                    }
                }
            }
            i++;
        }
        return append.toString();
    }

    private String dvR() {
        return " at path " + getPath();
    }
}
