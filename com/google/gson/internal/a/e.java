package com.google.gson.internal.a;

import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes2.dex */
public final class e extends com.google.gson.stream.a {
    private static final Reader jOE = new Reader() { // from class: com.google.gson.internal.a.e.1
        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }
    };
    private static final Object jOF = new Object();
    private Object[] jOG;
    private int jOH;
    private String[] jOI;
    private int[] jOJ;

    @Override // com.google.gson.stream.a
    public void beginArray() throws IOException {
        a(JsonToken.BEGIN_ARRAY);
        push(((com.google.gson.f) cBy()).iterator());
        this.jOJ[this.jOH - 1] = 0;
    }

    @Override // com.google.gson.stream.a
    public void endArray() throws IOException {
        a(JsonToken.END_ARRAY);
        cBz();
        cBz();
        if (this.jOH > 0) {
            int[] iArr = this.jOJ;
            int i = this.jOH - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public void beginObject() throws IOException {
        a(JsonToken.BEGIN_OBJECT);
        push(((com.google.gson.k) cBy()).entrySet().iterator());
    }

    @Override // com.google.gson.stream.a
    public void endObject() throws IOException {
        a(JsonToken.END_OBJECT);
        cBz();
        cBz();
        if (this.jOH > 0) {
            int[] iArr = this.jOJ;
            int i = this.jOH - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public boolean hasNext() throws IOException {
        JsonToken cBx = cBx();
        return (cBx == JsonToken.END_OBJECT || cBx == JsonToken.END_ARRAY) ? false : true;
    }

    @Override // com.google.gson.stream.a
    public JsonToken cBx() throws IOException {
        if (this.jOH == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object cBy = cBy();
        if (cBy instanceof Iterator) {
            boolean z = this.jOG[this.jOH - 2] instanceof com.google.gson.k;
            Iterator it = (Iterator) cBy;
            if (!it.hasNext()) {
                return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            } else if (z) {
                return JsonToken.NAME;
            } else {
                push(it.next());
                return cBx();
            }
        } else if (cBy instanceof com.google.gson.k) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (cBy instanceof com.google.gson.f) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (cBy instanceof com.google.gson.l) {
                com.google.gson.l lVar = (com.google.gson.l) cBy;
                if (lVar.cBe()) {
                    return JsonToken.STRING;
                }
                if (lVar.cBc()) {
                    return JsonToken.BOOLEAN;
                }
                if (lVar.cBd()) {
                    return JsonToken.NUMBER;
                }
                throw new AssertionError();
            } else if (cBy instanceof com.google.gson.j) {
                return JsonToken.NULL;
            } else {
                if (cBy == jOF) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    private Object cBy() {
        return this.jOG[this.jOH - 1];
    }

    private Object cBz() {
        Object[] objArr = this.jOG;
        int i = this.jOH - 1;
        this.jOH = i;
        Object obj = objArr[i];
        this.jOG[this.jOH] = null;
        return obj;
    }

    private void a(JsonToken jsonToken) throws IOException {
        if (cBx() != jsonToken) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + cBx() + cBB());
        }
    }

    @Override // com.google.gson.stream.a
    public String nextName() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) cBy()).next();
        String str = (String) entry.getKey();
        this.jOI[this.jOH - 1] = str;
        push(entry.getValue());
        return str;
    }

    @Override // com.google.gson.stream.a
    public String nextString() throws IOException {
        JsonToken cBx = cBx();
        if (cBx != JsonToken.STRING && cBx != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected " + JsonToken.STRING + " but was " + cBx + cBB());
        }
        String cAT = ((com.google.gson.l) cBz()).cAT();
        if (this.jOH > 0) {
            int[] iArr = this.jOJ;
            int i = this.jOH - 1;
            iArr[i] = iArr[i] + 1;
        }
        return cAT;
    }

    @Override // com.google.gson.stream.a
    public boolean nextBoolean() throws IOException {
        a(JsonToken.BOOLEAN);
        boolean asBoolean = ((com.google.gson.l) cBz()).getAsBoolean();
        if (this.jOH > 0) {
            int[] iArr = this.jOJ;
            int i = this.jOH - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asBoolean;
    }

    @Override // com.google.gson.stream.a
    public void nextNull() throws IOException {
        a(JsonToken.NULL);
        cBz();
        if (this.jOH > 0) {
            int[] iArr = this.jOJ;
            int i = this.jOH - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public double nextDouble() throws IOException {
        JsonToken cBx = cBx();
        if (cBx != JsonToken.NUMBER && cBx != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + cBx + cBB());
        }
        double asDouble = ((com.google.gson.l) cBy()).getAsDouble();
        if (!isLenient() && (Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + asDouble);
        }
        cBz();
        if (this.jOH > 0) {
            int[] iArr = this.jOJ;
            int i = this.jOH - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asDouble;
    }

    @Override // com.google.gson.stream.a
    public long nextLong() throws IOException {
        JsonToken cBx = cBx();
        if (cBx != JsonToken.NUMBER && cBx != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + cBx + cBB());
        }
        long asLong = ((com.google.gson.l) cBy()).getAsLong();
        cBz();
        if (this.jOH > 0) {
            int[] iArr = this.jOJ;
            int i = this.jOH - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asLong;
    }

    @Override // com.google.gson.stream.a
    public int nextInt() throws IOException {
        JsonToken cBx = cBx();
        if (cBx != JsonToken.NUMBER && cBx != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + cBx + cBB());
        }
        int asInt = ((com.google.gson.l) cBy()).getAsInt();
        cBz();
        if (this.jOH > 0) {
            int[] iArr = this.jOJ;
            int i = this.jOH - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asInt;
    }

    @Override // com.google.gson.stream.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.jOG = new Object[]{jOF};
        this.jOH = 1;
    }

    @Override // com.google.gson.stream.a
    public void skipValue() throws IOException {
        if (cBx() == JsonToken.NAME) {
            nextName();
            this.jOI[this.jOH - 2] = "null";
        } else {
            cBz();
            this.jOI[this.jOH - 1] = "null";
        }
        int[] iArr = this.jOJ;
        int i = this.jOH - 1;
        iArr[i] = iArr[i] + 1;
    }

    @Override // com.google.gson.stream.a
    public String toString() {
        return getClass().getSimpleName();
    }

    public void cBA() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) cBy()).next();
        push(entry.getValue());
        push(new com.google.gson.l((String) entry.getKey()));
    }

    private void push(Object obj) {
        if (this.jOH == this.jOG.length) {
            Object[] objArr = new Object[this.jOH * 2];
            int[] iArr = new int[this.jOH * 2];
            String[] strArr = new String[this.jOH * 2];
            System.arraycopy(this.jOG, 0, objArr, 0, this.jOH);
            System.arraycopy(this.jOJ, 0, iArr, 0, this.jOH);
            System.arraycopy(this.jOI, 0, strArr, 0, this.jOH);
            this.jOG = objArr;
            this.jOJ = iArr;
            this.jOI = strArr;
        }
        Object[] objArr2 = this.jOG;
        int i = this.jOH;
        this.jOH = i + 1;
        objArr2[i] = obj;
    }

    @Override // com.google.gson.stream.a
    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = 0;
        while (i < this.jOH) {
            if (this.jOG[i] instanceof com.google.gson.f) {
                i++;
                if (this.jOG[i] instanceof Iterator) {
                    append.append('[').append(this.jOJ[i]).append(']');
                }
            } else if (this.jOG[i] instanceof com.google.gson.k) {
                i++;
                if (this.jOG[i] instanceof Iterator) {
                    append.append('.');
                    if (this.jOI[i] != null) {
                        append.append(this.jOI[i]);
                    }
                }
            }
            i++;
        }
        return append.toString();
    }

    private String cBB() {
        return " at path " + getPath();
    }
}
