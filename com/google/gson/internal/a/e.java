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
    private static final Reader mLv = new Reader() { // from class: com.google.gson.internal.a.e.1
        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }
    };
    private static final Object mLw = new Object();
    private int[] mLA;
    private Object[] mLx;
    private int mLy;
    private String[] mLz;

    public e(JsonElement jsonElement) {
        super(mLv);
        this.mLx = new Object[32];
        this.mLy = 0;
        this.mLz = new String[32];
        this.mLA = new int[32];
        push(jsonElement);
    }

    @Override // com.google.gson.stream.a
    public void dAS() throws IOException {
        a(JsonToken.BEGIN_ARRAY);
        push(((JsonArray) dAV()).iterator());
        this.mLA[this.mLy - 1] = 0;
    }

    @Override // com.google.gson.stream.a
    public void endArray() throws IOException {
        a(JsonToken.END_ARRAY);
        dAW();
        dAW();
        if (this.mLy > 0) {
            int[] iArr = this.mLA;
            int i = this.mLy - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public void dAT() throws IOException {
        a(JsonToken.BEGIN_OBJECT);
        push(((JsonObject) dAV()).entrySet().iterator());
    }

    @Override // com.google.gson.stream.a
    public void endObject() throws IOException {
        a(JsonToken.END_OBJECT);
        dAW();
        dAW();
        if (this.mLy > 0) {
            int[] iArr = this.mLA;
            int i = this.mLy - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public boolean hasNext() throws IOException {
        JsonToken dAU = dAU();
        return (dAU == JsonToken.END_OBJECT || dAU == JsonToken.END_ARRAY) ? false : true;
    }

    @Override // com.google.gson.stream.a
    public JsonToken dAU() throws IOException {
        if (this.mLy == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object dAV = dAV();
        if (dAV instanceof Iterator) {
            boolean z = this.mLx[this.mLy - 2] instanceof JsonObject;
            Iterator it = (Iterator) dAV;
            if (!it.hasNext()) {
                return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            } else if (z) {
                return JsonToken.NAME;
            } else {
                push(it.next());
                return dAU();
            }
        } else if (dAV instanceof JsonObject) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (dAV instanceof JsonArray) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (dAV instanceof JsonPrimitive) {
                JsonPrimitive jsonPrimitive = (JsonPrimitive) dAV;
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
            } else if (dAV instanceof JsonNull) {
                return JsonToken.NULL;
            } else {
                if (dAV == mLw) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    private Object dAV() {
        return this.mLx[this.mLy - 1];
    }

    private Object dAW() {
        Object[] objArr = this.mLx;
        int i = this.mLy - 1;
        this.mLy = i;
        Object obj = objArr[i];
        this.mLx[this.mLy] = null;
        return obj;
    }

    private void a(JsonToken jsonToken) throws IOException {
        if (dAU() != jsonToken) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + dAU() + dBc());
        }
    }

    @Override // com.google.gson.stream.a
    public String dAX() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) dAV()).next();
        String str = (String) entry.getKey();
        this.mLz[this.mLy - 1] = str;
        push(entry.getValue());
        return str;
    }

    @Override // com.google.gson.stream.a
    public String dAY() throws IOException {
        JsonToken dAU = dAU();
        if (dAU != JsonToken.STRING && dAU != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected " + JsonToken.STRING + " but was " + dAU + dBc());
        }
        String asString = ((JsonPrimitive) dAW()).getAsString();
        if (this.mLy > 0) {
            int[] iArr = this.mLA;
            int i = this.mLy - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asString;
    }

    @Override // com.google.gson.stream.a
    public boolean nextBoolean() throws IOException {
        a(JsonToken.BOOLEAN);
        boolean asBoolean = ((JsonPrimitive) dAW()).getAsBoolean();
        if (this.mLy > 0) {
            int[] iArr = this.mLA;
            int i = this.mLy - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asBoolean;
    }

    @Override // com.google.gson.stream.a
    public void dAZ() throws IOException {
        a(JsonToken.NULL);
        dAW();
        if (this.mLy > 0) {
            int[] iArr = this.mLA;
            int i = this.mLy - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public double nextDouble() throws IOException {
        JsonToken dAU = dAU();
        if (dAU != JsonToken.NUMBER && dAU != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + dAU + dBc());
        }
        double asDouble = ((JsonPrimitive) dAV()).getAsDouble();
        if (!dBn() && (Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + asDouble);
        }
        dAW();
        if (this.mLy > 0) {
            int[] iArr = this.mLA;
            int i = this.mLy - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asDouble;
    }

    @Override // com.google.gson.stream.a
    public long nextLong() throws IOException {
        JsonToken dAU = dAU();
        if (dAU != JsonToken.NUMBER && dAU != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + dAU + dBc());
        }
        long asLong = ((JsonPrimitive) dAV()).getAsLong();
        dAW();
        if (this.mLy > 0) {
            int[] iArr = this.mLA;
            int i = this.mLy - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asLong;
    }

    @Override // com.google.gson.stream.a
    public int nextInt() throws IOException {
        JsonToken dAU = dAU();
        if (dAU != JsonToken.NUMBER && dAU != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + dAU + dBc());
        }
        int asInt = ((JsonPrimitive) dAV()).getAsInt();
        dAW();
        if (this.mLy > 0) {
            int[] iArr = this.mLA;
            int i = this.mLy - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asInt;
    }

    @Override // com.google.gson.stream.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mLx = new Object[]{mLw};
        this.mLy = 1;
    }

    @Override // com.google.gson.stream.a
    public void dBa() throws IOException {
        if (dAU() == JsonToken.NAME) {
            dAX();
            this.mLz[this.mLy - 2] = "null";
        } else {
            dAW();
            if (this.mLy > 0) {
                this.mLz[this.mLy - 1] = "null";
            }
        }
        if (this.mLy > 0) {
            int[] iArr = this.mLA;
            int i = this.mLy - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public String toString() {
        return getClass().getSimpleName();
    }

    public void dBb() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) dAV()).next();
        push(entry.getValue());
        push(new JsonPrimitive((String) entry.getKey()));
    }

    private void push(Object obj) {
        if (this.mLy == this.mLx.length) {
            Object[] objArr = new Object[this.mLy * 2];
            int[] iArr = new int[this.mLy * 2];
            String[] strArr = new String[this.mLy * 2];
            System.arraycopy(this.mLx, 0, objArr, 0, this.mLy);
            System.arraycopy(this.mLA, 0, iArr, 0, this.mLy);
            System.arraycopy(this.mLz, 0, strArr, 0, this.mLy);
            this.mLx = objArr;
            this.mLA = iArr;
            this.mLz = strArr;
        }
        Object[] objArr2 = this.mLx;
        int i = this.mLy;
        this.mLy = i + 1;
        objArr2[i] = obj;
    }

    @Override // com.google.gson.stream.a
    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = 0;
        while (i < this.mLy) {
            if (this.mLx[i] instanceof JsonArray) {
                i++;
                if (this.mLx[i] instanceof Iterator) {
                    append.append('[').append(this.mLA[i]).append(']');
                }
            } else if (this.mLx[i] instanceof JsonObject) {
                i++;
                if (this.mLx[i] instanceof Iterator) {
                    append.append('.');
                    if (this.mLz[i] != null) {
                        append.append(this.mLz[i]);
                    }
                }
            }
            i++;
        }
        return append.toString();
    }

    private String dBc() {
        return " at path " + getPath();
    }
}
