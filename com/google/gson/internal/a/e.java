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
    private static final Reader mKF = new Reader() { // from class: com.google.gson.internal.a.e.1
        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }
    };
    private static final Object mKG = new Object();
    private Object[] mKH;
    private int mKI;
    private String[] mKJ;
    private int[] mKK;

    public e(JsonElement jsonElement) {
        super(mKF);
        this.mKH = new Object[32];
        this.mKI = 0;
        this.mKJ = new String[32];
        this.mKK = new int[32];
        push(jsonElement);
    }

    @Override // com.google.gson.stream.a
    public void dzH() throws IOException {
        a(JsonToken.BEGIN_ARRAY);
        push(((JsonArray) dzM()).iterator());
        this.mKK[this.mKI - 1] = 0;
    }

    @Override // com.google.gson.stream.a
    public void dzI() throws IOException {
        a(JsonToken.END_ARRAY);
        dzN();
        dzN();
        if (this.mKI > 0) {
            int[] iArr = this.mKK;
            int i = this.mKI - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public void dzJ() throws IOException {
        a(JsonToken.BEGIN_OBJECT);
        push(((JsonObject) dzM()).entrySet().iterator());
    }

    @Override // com.google.gson.stream.a
    public void dzK() throws IOException {
        a(JsonToken.END_OBJECT);
        dzN();
        dzN();
        if (this.mKI > 0) {
            int[] iArr = this.mKK;
            int i = this.mKI - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public boolean hasNext() throws IOException {
        JsonToken dzL = dzL();
        return (dzL == JsonToken.END_OBJECT || dzL == JsonToken.END_ARRAY) ? false : true;
    }

    @Override // com.google.gson.stream.a
    public JsonToken dzL() throws IOException {
        if (this.mKI == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object dzM = dzM();
        if (dzM instanceof Iterator) {
            boolean z = this.mKH[this.mKI - 2] instanceof JsonObject;
            Iterator it = (Iterator) dzM;
            if (!it.hasNext()) {
                return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            } else if (z) {
                return JsonToken.NAME;
            } else {
                push(it.next());
                return dzL();
            }
        } else if (dzM instanceof JsonObject) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (dzM instanceof JsonArray) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (dzM instanceof JsonPrimitive) {
                JsonPrimitive jsonPrimitive = (JsonPrimitive) dzM;
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
            } else if (dzM instanceof JsonNull) {
                return JsonToken.NULL;
            } else {
                if (dzM == mKG) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    private Object dzM() {
        return this.mKH[this.mKI - 1];
    }

    private Object dzN() {
        Object[] objArr = this.mKH;
        int i = this.mKI - 1;
        this.mKI = i;
        Object obj = objArr[i];
        this.mKH[this.mKI] = null;
        return obj;
    }

    private void a(JsonToken jsonToken) throws IOException {
        if (dzL() != jsonToken) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + dzL() + dzT());
        }
    }

    @Override // com.google.gson.stream.a
    public String dzO() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) dzM()).next();
        String str = (String) entry.getKey();
        this.mKJ[this.mKI - 1] = str;
        push(entry.getValue());
        return str;
    }

    @Override // com.google.gson.stream.a
    public String dzP() throws IOException {
        JsonToken dzL = dzL();
        if (dzL != JsonToken.STRING && dzL != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected " + JsonToken.STRING + " but was " + dzL + dzT());
        }
        String asString = ((JsonPrimitive) dzN()).getAsString();
        if (this.mKI > 0) {
            int[] iArr = this.mKK;
            int i = this.mKI - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asString;
    }

    @Override // com.google.gson.stream.a
    public boolean nextBoolean() throws IOException {
        a(JsonToken.BOOLEAN);
        boolean asBoolean = ((JsonPrimitive) dzN()).getAsBoolean();
        if (this.mKI > 0) {
            int[] iArr = this.mKK;
            int i = this.mKI - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asBoolean;
    }

    @Override // com.google.gson.stream.a
    public void dzQ() throws IOException {
        a(JsonToken.NULL);
        dzN();
        if (this.mKI > 0) {
            int[] iArr = this.mKK;
            int i = this.mKI - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public double nextDouble() throws IOException {
        JsonToken dzL = dzL();
        if (dzL != JsonToken.NUMBER && dzL != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + dzL + dzT());
        }
        double asDouble = ((JsonPrimitive) dzM()).getAsDouble();
        if (!dAe() && (Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + asDouble);
        }
        dzN();
        if (this.mKI > 0) {
            int[] iArr = this.mKK;
            int i = this.mKI - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asDouble;
    }

    @Override // com.google.gson.stream.a
    public long nextLong() throws IOException {
        JsonToken dzL = dzL();
        if (dzL != JsonToken.NUMBER && dzL != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + dzL + dzT());
        }
        long asLong = ((JsonPrimitive) dzM()).getAsLong();
        dzN();
        if (this.mKI > 0) {
            int[] iArr = this.mKK;
            int i = this.mKI - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asLong;
    }

    @Override // com.google.gson.stream.a
    public int nextInt() throws IOException {
        JsonToken dzL = dzL();
        if (dzL != JsonToken.NUMBER && dzL != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + dzL + dzT());
        }
        int asInt = ((JsonPrimitive) dzM()).getAsInt();
        dzN();
        if (this.mKI > 0) {
            int[] iArr = this.mKK;
            int i = this.mKI - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asInt;
    }

    @Override // com.google.gson.stream.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mKH = new Object[]{mKG};
        this.mKI = 1;
    }

    @Override // com.google.gson.stream.a
    public void dzR() throws IOException {
        if (dzL() == JsonToken.NAME) {
            dzO();
            this.mKJ[this.mKI - 2] = "null";
        } else {
            dzN();
            if (this.mKI > 0) {
                this.mKJ[this.mKI - 1] = "null";
            }
        }
        if (this.mKI > 0) {
            int[] iArr = this.mKK;
            int i = this.mKI - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public String toString() {
        return getClass().getSimpleName();
    }

    public void dzS() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) dzM()).next();
        push(entry.getValue());
        push(new JsonPrimitive((String) entry.getKey()));
    }

    private void push(Object obj) {
        if (this.mKI == this.mKH.length) {
            Object[] objArr = new Object[this.mKI * 2];
            int[] iArr = new int[this.mKI * 2];
            String[] strArr = new String[this.mKI * 2];
            System.arraycopy(this.mKH, 0, objArr, 0, this.mKI);
            System.arraycopy(this.mKK, 0, iArr, 0, this.mKI);
            System.arraycopy(this.mKJ, 0, strArr, 0, this.mKI);
            this.mKH = objArr;
            this.mKK = iArr;
            this.mKJ = strArr;
        }
        Object[] objArr2 = this.mKH;
        int i = this.mKI;
        this.mKI = i + 1;
        objArr2[i] = obj;
    }

    @Override // com.google.gson.stream.a
    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = 0;
        while (i < this.mKI) {
            if (this.mKH[i] instanceof JsonArray) {
                i++;
                if (this.mKH[i] instanceof Iterator) {
                    append.append('[').append(this.mKK[i]).append(']');
                }
            } else if (this.mKH[i] instanceof JsonObject) {
                i++;
                if (this.mKH[i] instanceof Iterator) {
                    append.append('.');
                    if (this.mKJ[i] != null) {
                        append.append(this.mKJ[i]);
                    }
                }
            }
            i++;
        }
        return append.toString();
    }

    private String dzT() {
        return " at path " + getPath();
    }
}
