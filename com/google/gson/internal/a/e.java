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
/* loaded from: classes5.dex */
public final class e extends com.google.gson.stream.a {
    private static final Reader mKA = new Reader() { // from class: com.google.gson.internal.a.e.1
        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }
    };
    private static final Object mKB = new Object();
    private Object[] mKC;
    private int mKD;
    private String[] mKE;
    private int[] mKF;

    public e(JsonElement jsonElement) {
        super(mKA);
        this.mKC = new Object[32];
        this.mKD = 0;
        this.mKE = new String[32];
        this.mKF = new int[32];
        push(jsonElement);
    }

    @Override // com.google.gson.stream.a
    public void dzF() throws IOException {
        a(JsonToken.BEGIN_ARRAY);
        push(((JsonArray) dzK()).iterator());
        this.mKF[this.mKD - 1] = 0;
    }

    @Override // com.google.gson.stream.a
    public void dzG() throws IOException {
        a(JsonToken.END_ARRAY);
        dzL();
        dzL();
        if (this.mKD > 0) {
            int[] iArr = this.mKF;
            int i = this.mKD - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public void dzH() throws IOException {
        a(JsonToken.BEGIN_OBJECT);
        push(((JsonObject) dzK()).entrySet().iterator());
    }

    @Override // com.google.gson.stream.a
    public void dzI() throws IOException {
        a(JsonToken.END_OBJECT);
        dzL();
        dzL();
        if (this.mKD > 0) {
            int[] iArr = this.mKF;
            int i = this.mKD - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public boolean hasNext() throws IOException {
        JsonToken dzJ = dzJ();
        return (dzJ == JsonToken.END_OBJECT || dzJ == JsonToken.END_ARRAY) ? false : true;
    }

    @Override // com.google.gson.stream.a
    public JsonToken dzJ() throws IOException {
        if (this.mKD == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object dzK = dzK();
        if (dzK instanceof Iterator) {
            boolean z = this.mKC[this.mKD - 2] instanceof JsonObject;
            Iterator it = (Iterator) dzK;
            if (!it.hasNext()) {
                return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            } else if (z) {
                return JsonToken.NAME;
            } else {
                push(it.next());
                return dzJ();
            }
        } else if (dzK instanceof JsonObject) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (dzK instanceof JsonArray) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (dzK instanceof JsonPrimitive) {
                JsonPrimitive jsonPrimitive = (JsonPrimitive) dzK;
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
            } else if (dzK instanceof JsonNull) {
                return JsonToken.NULL;
            } else {
                if (dzK == mKB) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    private Object dzK() {
        return this.mKC[this.mKD - 1];
    }

    private Object dzL() {
        Object[] objArr = this.mKC;
        int i = this.mKD - 1;
        this.mKD = i;
        Object obj = objArr[i];
        this.mKC[this.mKD] = null;
        return obj;
    }

    private void a(JsonToken jsonToken) throws IOException {
        if (dzJ() != jsonToken) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + dzJ() + dzR());
        }
    }

    @Override // com.google.gson.stream.a
    public String dzM() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) dzK()).next();
        String str = (String) entry.getKey();
        this.mKE[this.mKD - 1] = str;
        push(entry.getValue());
        return str;
    }

    @Override // com.google.gson.stream.a
    public String dzN() throws IOException {
        JsonToken dzJ = dzJ();
        if (dzJ != JsonToken.STRING && dzJ != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected " + JsonToken.STRING + " but was " + dzJ + dzR());
        }
        String asString = ((JsonPrimitive) dzL()).getAsString();
        if (this.mKD > 0) {
            int[] iArr = this.mKF;
            int i = this.mKD - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asString;
    }

    @Override // com.google.gson.stream.a
    public boolean nextBoolean() throws IOException {
        a(JsonToken.BOOLEAN);
        boolean asBoolean = ((JsonPrimitive) dzL()).getAsBoolean();
        if (this.mKD > 0) {
            int[] iArr = this.mKF;
            int i = this.mKD - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asBoolean;
    }

    @Override // com.google.gson.stream.a
    public void dzO() throws IOException {
        a(JsonToken.NULL);
        dzL();
        if (this.mKD > 0) {
            int[] iArr = this.mKF;
            int i = this.mKD - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public double nextDouble() throws IOException {
        JsonToken dzJ = dzJ();
        if (dzJ != JsonToken.NUMBER && dzJ != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + dzJ + dzR());
        }
        double asDouble = ((JsonPrimitive) dzK()).getAsDouble();
        if (!dAc() && (Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + asDouble);
        }
        dzL();
        if (this.mKD > 0) {
            int[] iArr = this.mKF;
            int i = this.mKD - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asDouble;
    }

    @Override // com.google.gson.stream.a
    public long nextLong() throws IOException {
        JsonToken dzJ = dzJ();
        if (dzJ != JsonToken.NUMBER && dzJ != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + dzJ + dzR());
        }
        long asLong = ((JsonPrimitive) dzK()).getAsLong();
        dzL();
        if (this.mKD > 0) {
            int[] iArr = this.mKF;
            int i = this.mKD - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asLong;
    }

    @Override // com.google.gson.stream.a
    public int nextInt() throws IOException {
        JsonToken dzJ = dzJ();
        if (dzJ != JsonToken.NUMBER && dzJ != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + dzJ + dzR());
        }
        int asInt = ((JsonPrimitive) dzK()).getAsInt();
        dzL();
        if (this.mKD > 0) {
            int[] iArr = this.mKF;
            int i = this.mKD - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asInt;
    }

    @Override // com.google.gson.stream.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mKC = new Object[]{mKB};
        this.mKD = 1;
    }

    @Override // com.google.gson.stream.a
    public void dzP() throws IOException {
        if (dzJ() == JsonToken.NAME) {
            dzM();
            this.mKE[this.mKD - 2] = "null";
        } else {
            dzL();
            if (this.mKD > 0) {
                this.mKE[this.mKD - 1] = "null";
            }
        }
        if (this.mKD > 0) {
            int[] iArr = this.mKF;
            int i = this.mKD - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public String toString() {
        return getClass().getSimpleName();
    }

    public void dzQ() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) dzK()).next();
        push(entry.getValue());
        push(new JsonPrimitive((String) entry.getKey()));
    }

    private void push(Object obj) {
        if (this.mKD == this.mKC.length) {
            Object[] objArr = new Object[this.mKD * 2];
            int[] iArr = new int[this.mKD * 2];
            String[] strArr = new String[this.mKD * 2];
            System.arraycopy(this.mKC, 0, objArr, 0, this.mKD);
            System.arraycopy(this.mKF, 0, iArr, 0, this.mKD);
            System.arraycopy(this.mKE, 0, strArr, 0, this.mKD);
            this.mKC = objArr;
            this.mKF = iArr;
            this.mKE = strArr;
        }
        Object[] objArr2 = this.mKC;
        int i = this.mKD;
        this.mKD = i + 1;
        objArr2[i] = obj;
    }

    @Override // com.google.gson.stream.a
    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = 0;
        while (i < this.mKD) {
            if (this.mKC[i] instanceof JsonArray) {
                i++;
                if (this.mKC[i] instanceof Iterator) {
                    append.append('[').append(this.mKF[i]).append(']');
                }
            } else if (this.mKC[i] instanceof JsonObject) {
                i++;
                if (this.mKC[i] instanceof Iterator) {
                    append.append('.');
                    if (this.mKE[i] != null) {
                        append.append(this.mKE[i]);
                    }
                }
            }
            i++;
        }
        return append.toString();
    }

    private String dzR() {
        return " at path " + getPath();
    }
}
