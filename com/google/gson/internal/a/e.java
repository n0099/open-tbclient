package com.google.gson.internal.a;

import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes2.dex */
public final class e extends com.google.gson.stream.a {
    private static final Reader jOM = new Reader() { // from class: com.google.gson.internal.a.e.1
        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }
    };
    private static final Object jON = new Object();
    private Object[] jOO;
    private int jOP;
    private String[] jOQ;
    private int[] jOR;

    @Override // com.google.gson.stream.a
    public void beginArray() throws IOException {
        a(JsonToken.BEGIN_ARRAY);
        push(((com.google.gson.f) cBv()).iterator());
        this.jOR[this.jOP - 1] = 0;
    }

    @Override // com.google.gson.stream.a
    public void endArray() throws IOException {
        a(JsonToken.END_ARRAY);
        cBw();
        cBw();
        if (this.jOP > 0) {
            int[] iArr = this.jOR;
            int i = this.jOP - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public void beginObject() throws IOException {
        a(JsonToken.BEGIN_OBJECT);
        push(((com.google.gson.k) cBv()).entrySet().iterator());
    }

    @Override // com.google.gson.stream.a
    public void endObject() throws IOException {
        a(JsonToken.END_OBJECT);
        cBw();
        cBw();
        if (this.jOP > 0) {
            int[] iArr = this.jOR;
            int i = this.jOP - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public boolean hasNext() throws IOException {
        JsonToken cBu = cBu();
        return (cBu == JsonToken.END_OBJECT || cBu == JsonToken.END_ARRAY) ? false : true;
    }

    @Override // com.google.gson.stream.a
    public JsonToken cBu() throws IOException {
        if (this.jOP == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object cBv = cBv();
        if (cBv instanceof Iterator) {
            boolean z = this.jOO[this.jOP - 2] instanceof com.google.gson.k;
            Iterator it = (Iterator) cBv;
            if (!it.hasNext()) {
                return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            } else if (z) {
                return JsonToken.NAME;
            } else {
                push(it.next());
                return cBu();
            }
        } else if (cBv instanceof com.google.gson.k) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (cBv instanceof com.google.gson.f) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (cBv instanceof com.google.gson.l) {
                com.google.gson.l lVar = (com.google.gson.l) cBv;
                if (lVar.cBb()) {
                    return JsonToken.STRING;
                }
                if (lVar.cAZ()) {
                    return JsonToken.BOOLEAN;
                }
                if (lVar.cBa()) {
                    return JsonToken.NUMBER;
                }
                throw new AssertionError();
            } else if (cBv instanceof com.google.gson.j) {
                return JsonToken.NULL;
            } else {
                if (cBv == jON) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    private Object cBv() {
        return this.jOO[this.jOP - 1];
    }

    private Object cBw() {
        Object[] objArr = this.jOO;
        int i = this.jOP - 1;
        this.jOP = i;
        Object obj = objArr[i];
        this.jOO[this.jOP] = null;
        return obj;
    }

    private void a(JsonToken jsonToken) throws IOException {
        if (cBu() != jsonToken) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + cBu() + cBy());
        }
    }

    @Override // com.google.gson.stream.a
    public String nextName() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) cBv()).next();
        String str = (String) entry.getKey();
        this.jOQ[this.jOP - 1] = str;
        push(entry.getValue());
        return str;
    }

    @Override // com.google.gson.stream.a
    public String nextString() throws IOException {
        JsonToken cBu = cBu();
        if (cBu != JsonToken.STRING && cBu != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected " + JsonToken.STRING + " but was " + cBu + cBy());
        }
        String cAQ = ((com.google.gson.l) cBw()).cAQ();
        if (this.jOP > 0) {
            int[] iArr = this.jOR;
            int i = this.jOP - 1;
            iArr[i] = iArr[i] + 1;
        }
        return cAQ;
    }

    @Override // com.google.gson.stream.a
    public boolean nextBoolean() throws IOException {
        a(JsonToken.BOOLEAN);
        boolean asBoolean = ((com.google.gson.l) cBw()).getAsBoolean();
        if (this.jOP > 0) {
            int[] iArr = this.jOR;
            int i = this.jOP - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asBoolean;
    }

    @Override // com.google.gson.stream.a
    public void nextNull() throws IOException {
        a(JsonToken.NULL);
        cBw();
        if (this.jOP > 0) {
            int[] iArr = this.jOR;
            int i = this.jOP - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public double nextDouble() throws IOException {
        JsonToken cBu = cBu();
        if (cBu != JsonToken.NUMBER && cBu != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + cBu + cBy());
        }
        double asDouble = ((com.google.gson.l) cBv()).getAsDouble();
        if (!isLenient() && (Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + asDouble);
        }
        cBw();
        if (this.jOP > 0) {
            int[] iArr = this.jOR;
            int i = this.jOP - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asDouble;
    }

    @Override // com.google.gson.stream.a
    public long nextLong() throws IOException {
        JsonToken cBu = cBu();
        if (cBu != JsonToken.NUMBER && cBu != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + cBu + cBy());
        }
        long asLong = ((com.google.gson.l) cBv()).getAsLong();
        cBw();
        if (this.jOP > 0) {
            int[] iArr = this.jOR;
            int i = this.jOP - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asLong;
    }

    @Override // com.google.gson.stream.a
    public int nextInt() throws IOException {
        JsonToken cBu = cBu();
        if (cBu != JsonToken.NUMBER && cBu != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + cBu + cBy());
        }
        int asInt = ((com.google.gson.l) cBv()).getAsInt();
        cBw();
        if (this.jOP > 0) {
            int[] iArr = this.jOR;
            int i = this.jOP - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asInt;
    }

    @Override // com.google.gson.stream.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.jOO = new Object[]{jON};
        this.jOP = 1;
    }

    @Override // com.google.gson.stream.a
    public void skipValue() throws IOException {
        if (cBu() == JsonToken.NAME) {
            nextName();
            this.jOQ[this.jOP - 2] = "null";
        } else {
            cBw();
            this.jOQ[this.jOP - 1] = "null";
        }
        int[] iArr = this.jOR;
        int i = this.jOP - 1;
        iArr[i] = iArr[i] + 1;
    }

    @Override // com.google.gson.stream.a
    public String toString() {
        return getClass().getSimpleName();
    }

    public void cBx() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) cBv()).next();
        push(entry.getValue());
        push(new com.google.gson.l((String) entry.getKey()));
    }

    private void push(Object obj) {
        if (this.jOP == this.jOO.length) {
            Object[] objArr = new Object[this.jOP * 2];
            int[] iArr = new int[this.jOP * 2];
            String[] strArr = new String[this.jOP * 2];
            System.arraycopy(this.jOO, 0, objArr, 0, this.jOP);
            System.arraycopy(this.jOR, 0, iArr, 0, this.jOP);
            System.arraycopy(this.jOQ, 0, strArr, 0, this.jOP);
            this.jOO = objArr;
            this.jOR = iArr;
            this.jOQ = strArr;
        }
        Object[] objArr2 = this.jOO;
        int i = this.jOP;
        this.jOP = i + 1;
        objArr2[i] = obj;
    }

    @Override // com.google.gson.stream.a
    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = 0;
        while (i < this.jOP) {
            if (this.jOO[i] instanceof com.google.gson.f) {
                i++;
                if (this.jOO[i] instanceof Iterator) {
                    append.append('[').append(this.jOR[i]).append(']');
                }
            } else if (this.jOO[i] instanceof com.google.gson.k) {
                i++;
                if (this.jOO[i] instanceof Iterator) {
                    append.append('.');
                    if (this.jOQ[i] != null) {
                        append.append(this.jOQ[i]);
                    }
                }
            }
            i++;
        }
        return append.toString();
    }

    private String cBy() {
        return " at path " + getPath();
    }
}
