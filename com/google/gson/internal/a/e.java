package com.google.gson.internal.a;

import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes2.dex */
public final class e extends com.google.gson.stream.a {
    private static final Reader jOt = new Reader() { // from class: com.google.gson.internal.a.e.1
        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }
    };
    private static final Object jOu = new Object();
    private Object[] jOv;
    private int jOw;
    private String[] jOx;
    private int[] jOy;

    @Override // com.google.gson.stream.a
    public void beginArray() throws IOException {
        a(JsonToken.BEGIN_ARRAY);
        push(((com.google.gson.f) cBl()).iterator());
        this.jOy[this.jOw - 1] = 0;
    }

    @Override // com.google.gson.stream.a
    public void endArray() throws IOException {
        a(JsonToken.END_ARRAY);
        cBm();
        cBm();
        if (this.jOw > 0) {
            int[] iArr = this.jOy;
            int i = this.jOw - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public void beginObject() throws IOException {
        a(JsonToken.BEGIN_OBJECT);
        push(((com.google.gson.k) cBl()).entrySet().iterator());
    }

    @Override // com.google.gson.stream.a
    public void endObject() throws IOException {
        a(JsonToken.END_OBJECT);
        cBm();
        cBm();
        if (this.jOw > 0) {
            int[] iArr = this.jOy;
            int i = this.jOw - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public boolean hasNext() throws IOException {
        JsonToken cBk = cBk();
        return (cBk == JsonToken.END_OBJECT || cBk == JsonToken.END_ARRAY) ? false : true;
    }

    @Override // com.google.gson.stream.a
    public JsonToken cBk() throws IOException {
        if (this.jOw == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object cBl = cBl();
        if (cBl instanceof Iterator) {
            boolean z = this.jOv[this.jOw - 2] instanceof com.google.gson.k;
            Iterator it = (Iterator) cBl;
            if (!it.hasNext()) {
                return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            } else if (z) {
                return JsonToken.NAME;
            } else {
                push(it.next());
                return cBk();
            }
        } else if (cBl instanceof com.google.gson.k) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (cBl instanceof com.google.gson.f) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (cBl instanceof com.google.gson.l) {
                com.google.gson.l lVar = (com.google.gson.l) cBl;
                if (lVar.cAR()) {
                    return JsonToken.STRING;
                }
                if (lVar.cAP()) {
                    return JsonToken.BOOLEAN;
                }
                if (lVar.cAQ()) {
                    return JsonToken.NUMBER;
                }
                throw new AssertionError();
            } else if (cBl instanceof com.google.gson.j) {
                return JsonToken.NULL;
            } else {
                if (cBl == jOu) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    private Object cBl() {
        return this.jOv[this.jOw - 1];
    }

    private Object cBm() {
        Object[] objArr = this.jOv;
        int i = this.jOw - 1;
        this.jOw = i;
        Object obj = objArr[i];
        this.jOv[this.jOw] = null;
        return obj;
    }

    private void a(JsonToken jsonToken) throws IOException {
        if (cBk() != jsonToken) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + cBk() + cBo());
        }
    }

    @Override // com.google.gson.stream.a
    public String nextName() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) cBl()).next();
        String str = (String) entry.getKey();
        this.jOx[this.jOw - 1] = str;
        push(entry.getValue());
        return str;
    }

    @Override // com.google.gson.stream.a
    public String nextString() throws IOException {
        JsonToken cBk = cBk();
        if (cBk != JsonToken.STRING && cBk != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected " + JsonToken.STRING + " but was " + cBk + cBo());
        }
        String cAG = ((com.google.gson.l) cBm()).cAG();
        if (this.jOw > 0) {
            int[] iArr = this.jOy;
            int i = this.jOw - 1;
            iArr[i] = iArr[i] + 1;
        }
        return cAG;
    }

    @Override // com.google.gson.stream.a
    public boolean nextBoolean() throws IOException {
        a(JsonToken.BOOLEAN);
        boolean asBoolean = ((com.google.gson.l) cBm()).getAsBoolean();
        if (this.jOw > 0) {
            int[] iArr = this.jOy;
            int i = this.jOw - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asBoolean;
    }

    @Override // com.google.gson.stream.a
    public void nextNull() throws IOException {
        a(JsonToken.NULL);
        cBm();
        if (this.jOw > 0) {
            int[] iArr = this.jOy;
            int i = this.jOw - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public double nextDouble() throws IOException {
        JsonToken cBk = cBk();
        if (cBk != JsonToken.NUMBER && cBk != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + cBk + cBo());
        }
        double asDouble = ((com.google.gson.l) cBl()).getAsDouble();
        if (!isLenient() && (Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + asDouble);
        }
        cBm();
        if (this.jOw > 0) {
            int[] iArr = this.jOy;
            int i = this.jOw - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asDouble;
    }

    @Override // com.google.gson.stream.a
    public long nextLong() throws IOException {
        JsonToken cBk = cBk();
        if (cBk != JsonToken.NUMBER && cBk != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + cBk + cBo());
        }
        long asLong = ((com.google.gson.l) cBl()).getAsLong();
        cBm();
        if (this.jOw > 0) {
            int[] iArr = this.jOy;
            int i = this.jOw - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asLong;
    }

    @Override // com.google.gson.stream.a
    public int nextInt() throws IOException {
        JsonToken cBk = cBk();
        if (cBk != JsonToken.NUMBER && cBk != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + cBk + cBo());
        }
        int asInt = ((com.google.gson.l) cBl()).getAsInt();
        cBm();
        if (this.jOw > 0) {
            int[] iArr = this.jOy;
            int i = this.jOw - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asInt;
    }

    @Override // com.google.gson.stream.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.jOv = new Object[]{jOu};
        this.jOw = 1;
    }

    @Override // com.google.gson.stream.a
    public void skipValue() throws IOException {
        if (cBk() == JsonToken.NAME) {
            nextName();
            this.jOx[this.jOw - 2] = "null";
        } else {
            cBm();
            this.jOx[this.jOw - 1] = "null";
        }
        int[] iArr = this.jOy;
        int i = this.jOw - 1;
        iArr[i] = iArr[i] + 1;
    }

    @Override // com.google.gson.stream.a
    public String toString() {
        return getClass().getSimpleName();
    }

    public void cBn() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) cBl()).next();
        push(entry.getValue());
        push(new com.google.gson.l((String) entry.getKey()));
    }

    private void push(Object obj) {
        if (this.jOw == this.jOv.length) {
            Object[] objArr = new Object[this.jOw * 2];
            int[] iArr = new int[this.jOw * 2];
            String[] strArr = new String[this.jOw * 2];
            System.arraycopy(this.jOv, 0, objArr, 0, this.jOw);
            System.arraycopy(this.jOy, 0, iArr, 0, this.jOw);
            System.arraycopy(this.jOx, 0, strArr, 0, this.jOw);
            this.jOv = objArr;
            this.jOy = iArr;
            this.jOx = strArr;
        }
        Object[] objArr2 = this.jOv;
        int i = this.jOw;
        this.jOw = i + 1;
        objArr2[i] = obj;
    }

    @Override // com.google.gson.stream.a
    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = 0;
        while (i < this.jOw) {
            if (this.jOv[i] instanceof com.google.gson.f) {
                i++;
                if (this.jOv[i] instanceof Iterator) {
                    append.append('[').append(this.jOy[i]).append(']');
                }
            } else if (this.jOv[i] instanceof com.google.gson.k) {
                i++;
                if (this.jOv[i] instanceof Iterator) {
                    append.append('.');
                    if (this.jOx[i] != null) {
                        append.append(this.jOx[i]);
                    }
                }
            }
            i++;
        }
        return append.toString();
    }

    private String cBo() {
        return " at path " + getPath();
    }
}
