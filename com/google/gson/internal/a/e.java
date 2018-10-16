package com.google.gson.internal.a;

import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes2.dex */
public final class e extends com.google.gson.stream.a {
    private static final Reader ilt = new Reader() { // from class: com.google.gson.internal.a.e.1
        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }
    };
    private static final Object ilu = new Object();
    private Object[] ilv;
    private int ilw;
    private String[] ilx;
    private int[] ily;

    @Override // com.google.gson.stream.a
    public void beginArray() throws IOException {
        a(JsonToken.BEGIN_ARRAY);
        push(((com.google.gson.f) bZf()).iterator());
        this.ily[this.ilw - 1] = 0;
    }

    @Override // com.google.gson.stream.a
    public void endArray() throws IOException {
        a(JsonToken.END_ARRAY);
        bZg();
        bZg();
        if (this.ilw > 0) {
            int[] iArr = this.ily;
            int i = this.ilw - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public void beginObject() throws IOException {
        a(JsonToken.BEGIN_OBJECT);
        push(((com.google.gson.k) bZf()).entrySet().iterator());
    }

    @Override // com.google.gson.stream.a
    public void endObject() throws IOException {
        a(JsonToken.END_OBJECT);
        bZg();
        bZg();
        if (this.ilw > 0) {
            int[] iArr = this.ily;
            int i = this.ilw - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public boolean hasNext() throws IOException {
        JsonToken bZe = bZe();
        return (bZe == JsonToken.END_OBJECT || bZe == JsonToken.END_ARRAY) ? false : true;
    }

    @Override // com.google.gson.stream.a
    public JsonToken bZe() throws IOException {
        if (this.ilw == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object bZf = bZf();
        if (bZf instanceof Iterator) {
            boolean z = this.ilv[this.ilw - 2] instanceof com.google.gson.k;
            Iterator it = (Iterator) bZf;
            if (!it.hasNext()) {
                return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            } else if (z) {
                return JsonToken.NAME;
            } else {
                push(it.next());
                return bZe();
            }
        } else if (bZf instanceof com.google.gson.k) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (bZf instanceof com.google.gson.f) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (bZf instanceof com.google.gson.l) {
                com.google.gson.l lVar = (com.google.gson.l) bZf;
                if (lVar.bYL()) {
                    return JsonToken.STRING;
                }
                if (lVar.bYJ()) {
                    return JsonToken.BOOLEAN;
                }
                if (lVar.bYK()) {
                    return JsonToken.NUMBER;
                }
                throw new AssertionError();
            } else if (bZf instanceof com.google.gson.j) {
                return JsonToken.NULL;
            } else {
                if (bZf == ilu) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    private Object bZf() {
        return this.ilv[this.ilw - 1];
    }

    private Object bZg() {
        Object[] objArr = this.ilv;
        int i = this.ilw - 1;
        this.ilw = i;
        Object obj = objArr[i];
        this.ilv[this.ilw] = null;
        return obj;
    }

    private void a(JsonToken jsonToken) throws IOException {
        if (bZe() != jsonToken) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + bZe() + bZi());
        }
    }

    @Override // com.google.gson.stream.a
    public String nextName() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) bZf()).next();
        String str = (String) entry.getKey();
        this.ilx[this.ilw - 1] = str;
        push(entry.getValue());
        return str;
    }

    @Override // com.google.gson.stream.a
    public String nextString() throws IOException {
        JsonToken bZe = bZe();
        if (bZe != JsonToken.STRING && bZe != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected " + JsonToken.STRING + " but was " + bZe + bZi());
        }
        String bYA = ((com.google.gson.l) bZg()).bYA();
        if (this.ilw > 0) {
            int[] iArr = this.ily;
            int i = this.ilw - 1;
            iArr[i] = iArr[i] + 1;
        }
        return bYA;
    }

    @Override // com.google.gson.stream.a
    public boolean nextBoolean() throws IOException {
        a(JsonToken.BOOLEAN);
        boolean asBoolean = ((com.google.gson.l) bZg()).getAsBoolean();
        if (this.ilw > 0) {
            int[] iArr = this.ily;
            int i = this.ilw - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asBoolean;
    }

    @Override // com.google.gson.stream.a
    public void nextNull() throws IOException {
        a(JsonToken.NULL);
        bZg();
        if (this.ilw > 0) {
            int[] iArr = this.ily;
            int i = this.ilw - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public double nextDouble() throws IOException {
        JsonToken bZe = bZe();
        if (bZe != JsonToken.NUMBER && bZe != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + bZe + bZi());
        }
        double asDouble = ((com.google.gson.l) bZf()).getAsDouble();
        if (!isLenient() && (Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + asDouble);
        }
        bZg();
        if (this.ilw > 0) {
            int[] iArr = this.ily;
            int i = this.ilw - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asDouble;
    }

    @Override // com.google.gson.stream.a
    public long nextLong() throws IOException {
        JsonToken bZe = bZe();
        if (bZe != JsonToken.NUMBER && bZe != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + bZe + bZi());
        }
        long asLong = ((com.google.gson.l) bZf()).getAsLong();
        bZg();
        if (this.ilw > 0) {
            int[] iArr = this.ily;
            int i = this.ilw - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asLong;
    }

    @Override // com.google.gson.stream.a
    public int nextInt() throws IOException {
        JsonToken bZe = bZe();
        if (bZe != JsonToken.NUMBER && bZe != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + bZe + bZi());
        }
        int asInt = ((com.google.gson.l) bZf()).getAsInt();
        bZg();
        if (this.ilw > 0) {
            int[] iArr = this.ily;
            int i = this.ilw - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asInt;
    }

    @Override // com.google.gson.stream.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.ilv = new Object[]{ilu};
        this.ilw = 1;
    }

    @Override // com.google.gson.stream.a
    public void skipValue() throws IOException {
        if (bZe() == JsonToken.NAME) {
            nextName();
            this.ilx[this.ilw - 2] = "null";
        } else {
            bZg();
            this.ilx[this.ilw - 1] = "null";
        }
        int[] iArr = this.ily;
        int i = this.ilw - 1;
        iArr[i] = iArr[i] + 1;
    }

    @Override // com.google.gson.stream.a
    public String toString() {
        return getClass().getSimpleName();
    }

    public void bZh() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) bZf()).next();
        push(entry.getValue());
        push(new com.google.gson.l((String) entry.getKey()));
    }

    private void push(Object obj) {
        if (this.ilw == this.ilv.length) {
            Object[] objArr = new Object[this.ilw * 2];
            int[] iArr = new int[this.ilw * 2];
            String[] strArr = new String[this.ilw * 2];
            System.arraycopy(this.ilv, 0, objArr, 0, this.ilw);
            System.arraycopy(this.ily, 0, iArr, 0, this.ilw);
            System.arraycopy(this.ilx, 0, strArr, 0, this.ilw);
            this.ilv = objArr;
            this.ily = iArr;
            this.ilx = strArr;
        }
        Object[] objArr2 = this.ilv;
        int i = this.ilw;
        this.ilw = i + 1;
        objArr2[i] = obj;
    }

    @Override // com.google.gson.stream.a
    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = 0;
        while (i < this.ilw) {
            if (this.ilv[i] instanceof com.google.gson.f) {
                i++;
                if (this.ilv[i] instanceof Iterator) {
                    append.append('[').append(this.ily[i]).append(']');
                }
            } else if (this.ilv[i] instanceof com.google.gson.k) {
                i++;
                if (this.ilv[i] instanceof Iterator) {
                    append.append('.');
                    if (this.ilx[i] != null) {
                        append.append(this.ilx[i]);
                    }
                }
            }
            i++;
        }
        return append.toString();
    }

    private String bZi() {
        return " at path " + getPath();
    }
}
