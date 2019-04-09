package com.google.gson.internal.a;

import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes2.dex */
public final class e extends com.google.gson.stream.a {
    private static final Reader jNZ = new Reader() { // from class: com.google.gson.internal.a.e.1
        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }
    };
    private static final Object jOa = new Object();
    private Object[] jOb;
    private int jOc;
    private String[] jOd;
    private int[] jOe;

    @Override // com.google.gson.stream.a
    public void beginArray() throws IOException {
        a(JsonToken.BEGIN_ARRAY);
        push(((com.google.gson.f) cBr()).iterator());
        this.jOe[this.jOc - 1] = 0;
    }

    @Override // com.google.gson.stream.a
    public void endArray() throws IOException {
        a(JsonToken.END_ARRAY);
        cBs();
        cBs();
        if (this.jOc > 0) {
            int[] iArr = this.jOe;
            int i = this.jOc - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public void beginObject() throws IOException {
        a(JsonToken.BEGIN_OBJECT);
        push(((com.google.gson.k) cBr()).entrySet().iterator());
    }

    @Override // com.google.gson.stream.a
    public void endObject() throws IOException {
        a(JsonToken.END_OBJECT);
        cBs();
        cBs();
        if (this.jOc > 0) {
            int[] iArr = this.jOe;
            int i = this.jOc - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public boolean hasNext() throws IOException {
        JsonToken cBq = cBq();
        return (cBq == JsonToken.END_OBJECT || cBq == JsonToken.END_ARRAY) ? false : true;
    }

    @Override // com.google.gson.stream.a
    public JsonToken cBq() throws IOException {
        if (this.jOc == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object cBr = cBr();
        if (cBr instanceof Iterator) {
            boolean z = this.jOb[this.jOc - 2] instanceof com.google.gson.k;
            Iterator it = (Iterator) cBr;
            if (!it.hasNext()) {
                return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            } else if (z) {
                return JsonToken.NAME;
            } else {
                push(it.next());
                return cBq();
            }
        } else if (cBr instanceof com.google.gson.k) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (cBr instanceof com.google.gson.f) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (cBr instanceof com.google.gson.l) {
                com.google.gson.l lVar = (com.google.gson.l) cBr;
                if (lVar.cAX()) {
                    return JsonToken.STRING;
                }
                if (lVar.cAV()) {
                    return JsonToken.BOOLEAN;
                }
                if (lVar.cAW()) {
                    return JsonToken.NUMBER;
                }
                throw new AssertionError();
            } else if (cBr instanceof com.google.gson.j) {
                return JsonToken.NULL;
            } else {
                if (cBr == jOa) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    private Object cBr() {
        return this.jOb[this.jOc - 1];
    }

    private Object cBs() {
        Object[] objArr = this.jOb;
        int i = this.jOc - 1;
        this.jOc = i;
        Object obj = objArr[i];
        this.jOb[this.jOc] = null;
        return obj;
    }

    private void a(JsonToken jsonToken) throws IOException {
        if (cBq() != jsonToken) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + cBq() + cBu());
        }
    }

    @Override // com.google.gson.stream.a
    public String nextName() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) cBr()).next();
        String str = (String) entry.getKey();
        this.jOd[this.jOc - 1] = str;
        push(entry.getValue());
        return str;
    }

    @Override // com.google.gson.stream.a
    public String nextString() throws IOException {
        JsonToken cBq = cBq();
        if (cBq != JsonToken.STRING && cBq != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected " + JsonToken.STRING + " but was " + cBq + cBu());
        }
        String cAM = ((com.google.gson.l) cBs()).cAM();
        if (this.jOc > 0) {
            int[] iArr = this.jOe;
            int i = this.jOc - 1;
            iArr[i] = iArr[i] + 1;
        }
        return cAM;
    }

    @Override // com.google.gson.stream.a
    public boolean nextBoolean() throws IOException {
        a(JsonToken.BOOLEAN);
        boolean asBoolean = ((com.google.gson.l) cBs()).getAsBoolean();
        if (this.jOc > 0) {
            int[] iArr = this.jOe;
            int i = this.jOc - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asBoolean;
    }

    @Override // com.google.gson.stream.a
    public void nextNull() throws IOException {
        a(JsonToken.NULL);
        cBs();
        if (this.jOc > 0) {
            int[] iArr = this.jOe;
            int i = this.jOc - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public double nextDouble() throws IOException {
        JsonToken cBq = cBq();
        if (cBq != JsonToken.NUMBER && cBq != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + cBq + cBu());
        }
        double asDouble = ((com.google.gson.l) cBr()).getAsDouble();
        if (!isLenient() && (Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + asDouble);
        }
        cBs();
        if (this.jOc > 0) {
            int[] iArr = this.jOe;
            int i = this.jOc - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asDouble;
    }

    @Override // com.google.gson.stream.a
    public long nextLong() throws IOException {
        JsonToken cBq = cBq();
        if (cBq != JsonToken.NUMBER && cBq != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + cBq + cBu());
        }
        long asLong = ((com.google.gson.l) cBr()).getAsLong();
        cBs();
        if (this.jOc > 0) {
            int[] iArr = this.jOe;
            int i = this.jOc - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asLong;
    }

    @Override // com.google.gson.stream.a
    public int nextInt() throws IOException {
        JsonToken cBq = cBq();
        if (cBq != JsonToken.NUMBER && cBq != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + cBq + cBu());
        }
        int asInt = ((com.google.gson.l) cBr()).getAsInt();
        cBs();
        if (this.jOc > 0) {
            int[] iArr = this.jOe;
            int i = this.jOc - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asInt;
    }

    @Override // com.google.gson.stream.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.jOb = new Object[]{jOa};
        this.jOc = 1;
    }

    @Override // com.google.gson.stream.a
    public void skipValue() throws IOException {
        if (cBq() == JsonToken.NAME) {
            nextName();
            this.jOd[this.jOc - 2] = "null";
        } else {
            cBs();
            this.jOd[this.jOc - 1] = "null";
        }
        int[] iArr = this.jOe;
        int i = this.jOc - 1;
        iArr[i] = iArr[i] + 1;
    }

    @Override // com.google.gson.stream.a
    public String toString() {
        return getClass().getSimpleName();
    }

    public void cBt() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) cBr()).next();
        push(entry.getValue());
        push(new com.google.gson.l((String) entry.getKey()));
    }

    private void push(Object obj) {
        if (this.jOc == this.jOb.length) {
            Object[] objArr = new Object[this.jOc * 2];
            int[] iArr = new int[this.jOc * 2];
            String[] strArr = new String[this.jOc * 2];
            System.arraycopy(this.jOb, 0, objArr, 0, this.jOc);
            System.arraycopy(this.jOe, 0, iArr, 0, this.jOc);
            System.arraycopy(this.jOd, 0, strArr, 0, this.jOc);
            this.jOb = objArr;
            this.jOe = iArr;
            this.jOd = strArr;
        }
        Object[] objArr2 = this.jOb;
        int i = this.jOc;
        this.jOc = i + 1;
        objArr2[i] = obj;
    }

    @Override // com.google.gson.stream.a
    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = 0;
        while (i < this.jOc) {
            if (this.jOb[i] instanceof com.google.gson.f) {
                i++;
                if (this.jOb[i] instanceof Iterator) {
                    append.append('[').append(this.jOe[i]).append(']');
                }
            } else if (this.jOb[i] instanceof com.google.gson.k) {
                i++;
                if (this.jOb[i] instanceof Iterator) {
                    append.append('.');
                    if (this.jOd[i] != null) {
                        append.append(this.jOd[i]);
                    }
                }
            }
            i++;
        }
        return append.toString();
    }

    private String cBu() {
        return " at path " + getPath();
    }
}
