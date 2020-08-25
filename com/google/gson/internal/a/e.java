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
/* loaded from: classes3.dex */
public final class e extends com.google.gson.stream.a {
    private static final Reader nDE = new Reader() { // from class: com.google.gson.internal.a.e.1
        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }
    };
    private static final Object nDF = new Object();
    private Object[] nDG;
    private int nDH;
    private String[] nDI;
    private int[] nDJ;

    public e(JsonElement jsonElement) {
        super(nDE);
        this.nDG = new Object[32];
        this.nDH = 0;
        this.nDI = new String[32];
        this.nDJ = new int[32];
        push(jsonElement);
    }

    @Override // com.google.gson.stream.a
    public void dXn() throws IOException {
        a(JsonToken.BEGIN_ARRAY);
        push(((JsonArray) dXq()).iterator());
        this.nDJ[this.nDH - 1] = 0;
    }

    @Override // com.google.gson.stream.a
    public void endArray() throws IOException {
        a(JsonToken.END_ARRAY);
        dXr();
        dXr();
        if (this.nDH > 0) {
            int[] iArr = this.nDJ;
            int i = this.nDH - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public void dXo() throws IOException {
        a(JsonToken.BEGIN_OBJECT);
        push(((JsonObject) dXq()).entrySet().iterator());
    }

    @Override // com.google.gson.stream.a
    public void endObject() throws IOException {
        a(JsonToken.END_OBJECT);
        dXr();
        dXr();
        if (this.nDH > 0) {
            int[] iArr = this.nDJ;
            int i = this.nDH - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public boolean hasNext() throws IOException {
        JsonToken dXp = dXp();
        return (dXp == JsonToken.END_OBJECT || dXp == JsonToken.END_ARRAY) ? false : true;
    }

    @Override // com.google.gson.stream.a
    public JsonToken dXp() throws IOException {
        if (this.nDH == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object dXq = dXq();
        if (dXq instanceof Iterator) {
            boolean z = this.nDG[this.nDH - 2] instanceof JsonObject;
            Iterator it = (Iterator) dXq;
            if (!it.hasNext()) {
                return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            } else if (z) {
                return JsonToken.NAME;
            } else {
                push(it.next());
                return dXp();
            }
        } else if (dXq instanceof JsonObject) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (dXq instanceof JsonArray) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (dXq instanceof JsonPrimitive) {
                JsonPrimitive jsonPrimitive = (JsonPrimitive) dXq;
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
            } else if (dXq instanceof JsonNull) {
                return JsonToken.NULL;
            } else {
                if (dXq == nDF) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    private Object dXq() {
        return this.nDG[this.nDH - 1];
    }

    private Object dXr() {
        Object[] objArr = this.nDG;
        int i = this.nDH - 1;
        this.nDH = i;
        Object obj = objArr[i];
        this.nDG[this.nDH] = null;
        return obj;
    }

    private void a(JsonToken jsonToken) throws IOException {
        if (dXp() != jsonToken) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + dXp() + dXx());
        }
    }

    @Override // com.google.gson.stream.a
    public String dXs() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) dXq()).next();
        String str = (String) entry.getKey();
        this.nDI[this.nDH - 1] = str;
        push(entry.getValue());
        return str;
    }

    @Override // com.google.gson.stream.a
    public String dXt() throws IOException {
        JsonToken dXp = dXp();
        if (dXp != JsonToken.STRING && dXp != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected " + JsonToken.STRING + " but was " + dXp + dXx());
        }
        String asString = ((JsonPrimitive) dXr()).getAsString();
        if (this.nDH > 0) {
            int[] iArr = this.nDJ;
            int i = this.nDH - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asString;
    }

    @Override // com.google.gson.stream.a
    public boolean nextBoolean() throws IOException {
        a(JsonToken.BOOLEAN);
        boolean asBoolean = ((JsonPrimitive) dXr()).getAsBoolean();
        if (this.nDH > 0) {
            int[] iArr = this.nDJ;
            int i = this.nDH - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asBoolean;
    }

    @Override // com.google.gson.stream.a
    public void dXu() throws IOException {
        a(JsonToken.NULL);
        dXr();
        if (this.nDH > 0) {
            int[] iArr = this.nDJ;
            int i = this.nDH - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public double nextDouble() throws IOException {
        JsonToken dXp = dXp();
        if (dXp != JsonToken.NUMBER && dXp != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + dXp + dXx());
        }
        double asDouble = ((JsonPrimitive) dXq()).getAsDouble();
        if (!dXJ() && (Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + asDouble);
        }
        dXr();
        if (this.nDH > 0) {
            int[] iArr = this.nDJ;
            int i = this.nDH - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asDouble;
    }

    @Override // com.google.gson.stream.a
    public long nextLong() throws IOException {
        JsonToken dXp = dXp();
        if (dXp != JsonToken.NUMBER && dXp != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + dXp + dXx());
        }
        long asLong = ((JsonPrimitive) dXq()).getAsLong();
        dXr();
        if (this.nDH > 0) {
            int[] iArr = this.nDJ;
            int i = this.nDH - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asLong;
    }

    @Override // com.google.gson.stream.a
    public int nextInt() throws IOException {
        JsonToken dXp = dXp();
        if (dXp != JsonToken.NUMBER && dXp != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + dXp + dXx());
        }
        int asInt = ((JsonPrimitive) dXq()).getAsInt();
        dXr();
        if (this.nDH > 0) {
            int[] iArr = this.nDJ;
            int i = this.nDH - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asInt;
    }

    @Override // com.google.gson.stream.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.nDG = new Object[]{nDF};
        this.nDH = 1;
    }

    @Override // com.google.gson.stream.a
    public void dXv() throws IOException {
        if (dXp() == JsonToken.NAME) {
            dXs();
            this.nDI[this.nDH - 2] = "null";
        } else {
            dXr();
            if (this.nDH > 0) {
                this.nDI[this.nDH - 1] = "null";
            }
        }
        if (this.nDH > 0) {
            int[] iArr = this.nDJ;
            int i = this.nDH - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public String toString() {
        return getClass().getSimpleName();
    }

    public void dXw() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) dXq()).next();
        push(entry.getValue());
        push(new JsonPrimitive((String) entry.getKey()));
    }

    private void push(Object obj) {
        if (this.nDH == this.nDG.length) {
            Object[] objArr = new Object[this.nDH * 2];
            int[] iArr = new int[this.nDH * 2];
            String[] strArr = new String[this.nDH * 2];
            System.arraycopy(this.nDG, 0, objArr, 0, this.nDH);
            System.arraycopy(this.nDJ, 0, iArr, 0, this.nDH);
            System.arraycopy(this.nDI, 0, strArr, 0, this.nDH);
            this.nDG = objArr;
            this.nDJ = iArr;
            this.nDI = strArr;
        }
        Object[] objArr2 = this.nDG;
        int i = this.nDH;
        this.nDH = i + 1;
        objArr2[i] = obj;
    }

    @Override // com.google.gson.stream.a
    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = 0;
        while (i < this.nDH) {
            if (this.nDG[i] instanceof JsonArray) {
                i++;
                if (this.nDG[i] instanceof Iterator) {
                    append.append('[').append(this.nDJ[i]).append(']');
                }
            } else if (this.nDG[i] instanceof JsonObject) {
                i++;
                if (this.nDG[i] instanceof Iterator) {
                    append.append('.');
                    if (this.nDI[i] != null) {
                        append.append(this.nDI[i]);
                    }
                }
            }
            i++;
        }
        return append.toString();
    }

    private String dXx() {
        return " at path " + getPath();
    }
}
