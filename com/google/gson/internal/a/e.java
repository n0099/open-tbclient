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
    private static final Reader mDL = new Reader() { // from class: com.google.gson.internal.a.e.1
        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }
    };
    private static final Object mDM = new Object();
    private Object[] mDN;
    private int mDO;
    private String[] mDP;
    private int[] mDQ;

    public e(JsonElement jsonElement) {
        super(mDL);
        this.mDN = new Object[32];
        this.mDO = 0;
        this.mDP = new String[32];
        this.mDQ = new int[32];
        push(jsonElement);
    }

    @Override // com.google.gson.stream.a
    public void dCW() throws IOException {
        a(JsonToken.BEGIN_ARRAY);
        push(((JsonArray) dCZ()).iterator());
        this.mDQ[this.mDO - 1] = 0;
    }

    @Override // com.google.gson.stream.a
    public void endArray() throws IOException {
        a(JsonToken.END_ARRAY);
        dDa();
        dDa();
        if (this.mDO > 0) {
            int[] iArr = this.mDQ;
            int i = this.mDO - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public void dCX() throws IOException {
        a(JsonToken.BEGIN_OBJECT);
        push(((JsonObject) dCZ()).entrySet().iterator());
    }

    @Override // com.google.gson.stream.a
    public void endObject() throws IOException {
        a(JsonToken.END_OBJECT);
        dDa();
        dDa();
        if (this.mDO > 0) {
            int[] iArr = this.mDQ;
            int i = this.mDO - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public boolean hasNext() throws IOException {
        JsonToken dCY = dCY();
        return (dCY == JsonToken.END_OBJECT || dCY == JsonToken.END_ARRAY) ? false : true;
    }

    @Override // com.google.gson.stream.a
    public JsonToken dCY() throws IOException {
        if (this.mDO == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object dCZ = dCZ();
        if (dCZ instanceof Iterator) {
            boolean z = this.mDN[this.mDO - 2] instanceof JsonObject;
            Iterator it = (Iterator) dCZ;
            if (!it.hasNext()) {
                return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            } else if (z) {
                return JsonToken.NAME;
            } else {
                push(it.next());
                return dCY();
            }
        } else if (dCZ instanceof JsonObject) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (dCZ instanceof JsonArray) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (dCZ instanceof JsonPrimitive) {
                JsonPrimitive jsonPrimitive = (JsonPrimitive) dCZ;
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
            } else if (dCZ instanceof JsonNull) {
                return JsonToken.NULL;
            } else {
                if (dCZ == mDM) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    private Object dCZ() {
        return this.mDN[this.mDO - 1];
    }

    private Object dDa() {
        Object[] objArr = this.mDN;
        int i = this.mDO - 1;
        this.mDO = i;
        Object obj = objArr[i];
        this.mDN[this.mDO] = null;
        return obj;
    }

    private void a(JsonToken jsonToken) throws IOException {
        if (dCY() != jsonToken) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + dCY() + dDg());
        }
    }

    @Override // com.google.gson.stream.a
    public String dDb() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) dCZ()).next();
        String str = (String) entry.getKey();
        this.mDP[this.mDO - 1] = str;
        push(entry.getValue());
        return str;
    }

    @Override // com.google.gson.stream.a
    public String dDc() throws IOException {
        JsonToken dCY = dCY();
        if (dCY != JsonToken.STRING && dCY != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected " + JsonToken.STRING + " but was " + dCY + dDg());
        }
        String asString = ((JsonPrimitive) dDa()).getAsString();
        if (this.mDO > 0) {
            int[] iArr = this.mDQ;
            int i = this.mDO - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asString;
    }

    @Override // com.google.gson.stream.a
    public boolean nextBoolean() throws IOException {
        a(JsonToken.BOOLEAN);
        boolean asBoolean = ((JsonPrimitive) dDa()).getAsBoolean();
        if (this.mDO > 0) {
            int[] iArr = this.mDQ;
            int i = this.mDO - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asBoolean;
    }

    @Override // com.google.gson.stream.a
    public void dDd() throws IOException {
        a(JsonToken.NULL);
        dDa();
        if (this.mDO > 0) {
            int[] iArr = this.mDQ;
            int i = this.mDO - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public double nextDouble() throws IOException {
        JsonToken dCY = dCY();
        if (dCY != JsonToken.NUMBER && dCY != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + dCY + dDg());
        }
        double asDouble = ((JsonPrimitive) dCZ()).getAsDouble();
        if (!dDs() && (Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + asDouble);
        }
        dDa();
        if (this.mDO > 0) {
            int[] iArr = this.mDQ;
            int i = this.mDO - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asDouble;
    }

    @Override // com.google.gson.stream.a
    public long nextLong() throws IOException {
        JsonToken dCY = dCY();
        if (dCY != JsonToken.NUMBER && dCY != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + dCY + dDg());
        }
        long asLong = ((JsonPrimitive) dCZ()).getAsLong();
        dDa();
        if (this.mDO > 0) {
            int[] iArr = this.mDQ;
            int i = this.mDO - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asLong;
    }

    @Override // com.google.gson.stream.a
    public int nextInt() throws IOException {
        JsonToken dCY = dCY();
        if (dCY != JsonToken.NUMBER && dCY != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + dCY + dDg());
        }
        int asInt = ((JsonPrimitive) dCZ()).getAsInt();
        dDa();
        if (this.mDO > 0) {
            int[] iArr = this.mDQ;
            int i = this.mDO - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asInt;
    }

    @Override // com.google.gson.stream.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mDN = new Object[]{mDM};
        this.mDO = 1;
    }

    @Override // com.google.gson.stream.a
    public void dDe() throws IOException {
        if (dCY() == JsonToken.NAME) {
            dDb();
            this.mDP[this.mDO - 2] = "null";
        } else {
            dDa();
            if (this.mDO > 0) {
                this.mDP[this.mDO - 1] = "null";
            }
        }
        if (this.mDO > 0) {
            int[] iArr = this.mDQ;
            int i = this.mDO - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public String toString() {
        return getClass().getSimpleName();
    }

    public void dDf() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) dCZ()).next();
        push(entry.getValue());
        push(new JsonPrimitive((String) entry.getKey()));
    }

    private void push(Object obj) {
        if (this.mDO == this.mDN.length) {
            Object[] objArr = new Object[this.mDO * 2];
            int[] iArr = new int[this.mDO * 2];
            String[] strArr = new String[this.mDO * 2];
            System.arraycopy(this.mDN, 0, objArr, 0, this.mDO);
            System.arraycopy(this.mDQ, 0, iArr, 0, this.mDO);
            System.arraycopy(this.mDP, 0, strArr, 0, this.mDO);
            this.mDN = objArr;
            this.mDQ = iArr;
            this.mDP = strArr;
        }
        Object[] objArr2 = this.mDN;
        int i = this.mDO;
        this.mDO = i + 1;
        objArr2[i] = obj;
    }

    @Override // com.google.gson.stream.a
    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = 0;
        while (i < this.mDO) {
            if (this.mDN[i] instanceof JsonArray) {
                i++;
                if (this.mDN[i] instanceof Iterator) {
                    append.append('[').append(this.mDQ[i]).append(']');
                }
            } else if (this.mDN[i] instanceof JsonObject) {
                i++;
                if (this.mDN[i] instanceof Iterator) {
                    append.append('.');
                    if (this.mDP[i] != null) {
                        append.append(this.mDP[i]);
                    }
                }
            }
            i++;
        }
        return append.toString();
    }

    private String dDg() {
        return " at path " + getPath();
    }
}
