package com.google.gson.internal.a;

import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes2.dex */
public final class e extends com.google.gson.stream.a {
    private static final Reader inf = new Reader() { // from class: com.google.gson.internal.a.e.1
        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }
    };
    private static final Object ing = new Object();
    private Object[] inh;
    private int ini;
    private String[] inj;
    private int[] ink;

    @Override // com.google.gson.stream.a
    public void beginArray() throws IOException {
        a(JsonToken.BEGIN_ARRAY);
        push(((com.google.gson.f) bYC()).iterator());
        this.ink[this.ini - 1] = 0;
    }

    @Override // com.google.gson.stream.a
    public void endArray() throws IOException {
        a(JsonToken.END_ARRAY);
        bYD();
        bYD();
        if (this.ini > 0) {
            int[] iArr = this.ink;
            int i = this.ini - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public void beginObject() throws IOException {
        a(JsonToken.BEGIN_OBJECT);
        push(((com.google.gson.k) bYC()).entrySet().iterator());
    }

    @Override // com.google.gson.stream.a
    public void endObject() throws IOException {
        a(JsonToken.END_OBJECT);
        bYD();
        bYD();
        if (this.ini > 0) {
            int[] iArr = this.ink;
            int i = this.ini - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public boolean hasNext() throws IOException {
        JsonToken bYB = bYB();
        return (bYB == JsonToken.END_OBJECT || bYB == JsonToken.END_ARRAY) ? false : true;
    }

    @Override // com.google.gson.stream.a
    public JsonToken bYB() throws IOException {
        if (this.ini == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object bYC = bYC();
        if (bYC instanceof Iterator) {
            boolean z = this.inh[this.ini - 2] instanceof com.google.gson.k;
            Iterator it = (Iterator) bYC;
            if (!it.hasNext()) {
                return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            } else if (z) {
                return JsonToken.NAME;
            } else {
                push(it.next());
                return bYB();
            }
        } else if (bYC instanceof com.google.gson.k) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (bYC instanceof com.google.gson.f) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (bYC instanceof com.google.gson.l) {
                com.google.gson.l lVar = (com.google.gson.l) bYC;
                if (lVar.bYi()) {
                    return JsonToken.STRING;
                }
                if (lVar.bYg()) {
                    return JsonToken.BOOLEAN;
                }
                if (lVar.bYh()) {
                    return JsonToken.NUMBER;
                }
                throw new AssertionError();
            } else if (bYC instanceof com.google.gson.j) {
                return JsonToken.NULL;
            } else {
                if (bYC == ing) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    private Object bYC() {
        return this.inh[this.ini - 1];
    }

    private Object bYD() {
        Object[] objArr = this.inh;
        int i = this.ini - 1;
        this.ini = i;
        Object obj = objArr[i];
        this.inh[this.ini] = null;
        return obj;
    }

    private void a(JsonToken jsonToken) throws IOException {
        if (bYB() != jsonToken) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + bYB() + bYF());
        }
    }

    @Override // com.google.gson.stream.a
    public String nextName() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) bYC()).next();
        String str = (String) entry.getKey();
        this.inj[this.ini - 1] = str;
        push(entry.getValue());
        return str;
    }

    @Override // com.google.gson.stream.a
    public String nextString() throws IOException {
        JsonToken bYB = bYB();
        if (bYB != JsonToken.STRING && bYB != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected " + JsonToken.STRING + " but was " + bYB + bYF());
        }
        String bXX = ((com.google.gson.l) bYD()).bXX();
        if (this.ini > 0) {
            int[] iArr = this.ink;
            int i = this.ini - 1;
            iArr[i] = iArr[i] + 1;
        }
        return bXX;
    }

    @Override // com.google.gson.stream.a
    public boolean nextBoolean() throws IOException {
        a(JsonToken.BOOLEAN);
        boolean asBoolean = ((com.google.gson.l) bYD()).getAsBoolean();
        if (this.ini > 0) {
            int[] iArr = this.ink;
            int i = this.ini - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asBoolean;
    }

    @Override // com.google.gson.stream.a
    public void nextNull() throws IOException {
        a(JsonToken.NULL);
        bYD();
        if (this.ini > 0) {
            int[] iArr = this.ink;
            int i = this.ini - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public double nextDouble() throws IOException {
        JsonToken bYB = bYB();
        if (bYB != JsonToken.NUMBER && bYB != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + bYB + bYF());
        }
        double asDouble = ((com.google.gson.l) bYC()).getAsDouble();
        if (!isLenient() && (Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + asDouble);
        }
        bYD();
        if (this.ini > 0) {
            int[] iArr = this.ink;
            int i = this.ini - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asDouble;
    }

    @Override // com.google.gson.stream.a
    public long nextLong() throws IOException {
        JsonToken bYB = bYB();
        if (bYB != JsonToken.NUMBER && bYB != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + bYB + bYF());
        }
        long asLong = ((com.google.gson.l) bYC()).getAsLong();
        bYD();
        if (this.ini > 0) {
            int[] iArr = this.ink;
            int i = this.ini - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asLong;
    }

    @Override // com.google.gson.stream.a
    public int nextInt() throws IOException {
        JsonToken bYB = bYB();
        if (bYB != JsonToken.NUMBER && bYB != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + bYB + bYF());
        }
        int asInt = ((com.google.gson.l) bYC()).getAsInt();
        bYD();
        if (this.ini > 0) {
            int[] iArr = this.ink;
            int i = this.ini - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asInt;
    }

    @Override // com.google.gson.stream.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.inh = new Object[]{ing};
        this.ini = 1;
    }

    @Override // com.google.gson.stream.a
    public void skipValue() throws IOException {
        if (bYB() == JsonToken.NAME) {
            nextName();
            this.inj[this.ini - 2] = "null";
        } else {
            bYD();
            this.inj[this.ini - 1] = "null";
        }
        int[] iArr = this.ink;
        int i = this.ini - 1;
        iArr[i] = iArr[i] + 1;
    }

    @Override // com.google.gson.stream.a
    public String toString() {
        return getClass().getSimpleName();
    }

    public void bYE() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) bYC()).next();
        push(entry.getValue());
        push(new com.google.gson.l((String) entry.getKey()));
    }

    private void push(Object obj) {
        if (this.ini == this.inh.length) {
            Object[] objArr = new Object[this.ini * 2];
            int[] iArr = new int[this.ini * 2];
            String[] strArr = new String[this.ini * 2];
            System.arraycopy(this.inh, 0, objArr, 0, this.ini);
            System.arraycopy(this.ink, 0, iArr, 0, this.ini);
            System.arraycopy(this.inj, 0, strArr, 0, this.ini);
            this.inh = objArr;
            this.ink = iArr;
            this.inj = strArr;
        }
        Object[] objArr2 = this.inh;
        int i = this.ini;
        this.ini = i + 1;
        objArr2[i] = obj;
    }

    @Override // com.google.gson.stream.a
    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = 0;
        while (i < this.ini) {
            if (this.inh[i] instanceof com.google.gson.f) {
                i++;
                if (this.inh[i] instanceof Iterator) {
                    append.append('[').append(this.ink[i]).append(']');
                }
            } else if (this.inh[i] instanceof com.google.gson.k) {
                i++;
                if (this.inh[i] instanceof Iterator) {
                    append.append('.');
                    if (this.inj[i] != null) {
                        append.append(this.inj[i]);
                    }
                }
            }
            i++;
        }
        return append.toString();
    }

    private String bYF() {
        return " at path " + getPath();
    }
}
