package com.google.gson.internal.a;

import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes2.dex */
public final class e extends com.google.gson.stream.a {
    private static final Reader ixA = new Reader() { // from class: com.google.gson.internal.a.e.1
        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }
    };
    private static final Object ixB = new Object();
    private Object[] ixC;
    private int ixD;
    private String[] ixE;
    private int[] ixF;

    @Override // com.google.gson.stream.a
    public void beginArray() throws IOException {
        a(JsonToken.BEGIN_ARRAY);
        push(((com.google.gson.f) cby()).iterator());
        this.ixF[this.ixD - 1] = 0;
    }

    @Override // com.google.gson.stream.a
    public void endArray() throws IOException {
        a(JsonToken.END_ARRAY);
        cbz();
        cbz();
        if (this.ixD > 0) {
            int[] iArr = this.ixF;
            int i = this.ixD - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public void beginObject() throws IOException {
        a(JsonToken.BEGIN_OBJECT);
        push(((com.google.gson.k) cby()).entrySet().iterator());
    }

    @Override // com.google.gson.stream.a
    public void endObject() throws IOException {
        a(JsonToken.END_OBJECT);
        cbz();
        cbz();
        if (this.ixD > 0) {
            int[] iArr = this.ixF;
            int i = this.ixD - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public boolean hasNext() throws IOException {
        JsonToken cbx = cbx();
        return (cbx == JsonToken.END_OBJECT || cbx == JsonToken.END_ARRAY) ? false : true;
    }

    @Override // com.google.gson.stream.a
    public JsonToken cbx() throws IOException {
        if (this.ixD == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object cby = cby();
        if (cby instanceof Iterator) {
            boolean z = this.ixC[this.ixD - 2] instanceof com.google.gson.k;
            Iterator it = (Iterator) cby;
            if (!it.hasNext()) {
                return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            } else if (z) {
                return JsonToken.NAME;
            } else {
                push(it.next());
                return cbx();
            }
        } else if (cby instanceof com.google.gson.k) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (cby instanceof com.google.gson.f) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (cby instanceof com.google.gson.l) {
                com.google.gson.l lVar = (com.google.gson.l) cby;
                if (lVar.cbe()) {
                    return JsonToken.STRING;
                }
                if (lVar.cbc()) {
                    return JsonToken.BOOLEAN;
                }
                if (lVar.cbd()) {
                    return JsonToken.NUMBER;
                }
                throw new AssertionError();
            } else if (cby instanceof com.google.gson.j) {
                return JsonToken.NULL;
            } else {
                if (cby == ixB) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    private Object cby() {
        return this.ixC[this.ixD - 1];
    }

    private Object cbz() {
        Object[] objArr = this.ixC;
        int i = this.ixD - 1;
        this.ixD = i;
        Object obj = objArr[i];
        this.ixC[this.ixD] = null;
        return obj;
    }

    private void a(JsonToken jsonToken) throws IOException {
        if (cbx() != jsonToken) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + cbx() + cbB());
        }
    }

    @Override // com.google.gson.stream.a
    public String nextName() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) cby()).next();
        String str = (String) entry.getKey();
        this.ixE[this.ixD - 1] = str;
        push(entry.getValue());
        return str;
    }

    @Override // com.google.gson.stream.a
    public String nextString() throws IOException {
        JsonToken cbx = cbx();
        if (cbx != JsonToken.STRING && cbx != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected " + JsonToken.STRING + " but was " + cbx + cbB());
        }
        String caT = ((com.google.gson.l) cbz()).caT();
        if (this.ixD > 0) {
            int[] iArr = this.ixF;
            int i = this.ixD - 1;
            iArr[i] = iArr[i] + 1;
        }
        return caT;
    }

    @Override // com.google.gson.stream.a
    public boolean nextBoolean() throws IOException {
        a(JsonToken.BOOLEAN);
        boolean asBoolean = ((com.google.gson.l) cbz()).getAsBoolean();
        if (this.ixD > 0) {
            int[] iArr = this.ixF;
            int i = this.ixD - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asBoolean;
    }

    @Override // com.google.gson.stream.a
    public void nextNull() throws IOException {
        a(JsonToken.NULL);
        cbz();
        if (this.ixD > 0) {
            int[] iArr = this.ixF;
            int i = this.ixD - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public double nextDouble() throws IOException {
        JsonToken cbx = cbx();
        if (cbx != JsonToken.NUMBER && cbx != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + cbx + cbB());
        }
        double asDouble = ((com.google.gson.l) cby()).getAsDouble();
        if (!isLenient() && (Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + asDouble);
        }
        cbz();
        if (this.ixD > 0) {
            int[] iArr = this.ixF;
            int i = this.ixD - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asDouble;
    }

    @Override // com.google.gson.stream.a
    public long nextLong() throws IOException {
        JsonToken cbx = cbx();
        if (cbx != JsonToken.NUMBER && cbx != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + cbx + cbB());
        }
        long asLong = ((com.google.gson.l) cby()).getAsLong();
        cbz();
        if (this.ixD > 0) {
            int[] iArr = this.ixF;
            int i = this.ixD - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asLong;
    }

    @Override // com.google.gson.stream.a
    public int nextInt() throws IOException {
        JsonToken cbx = cbx();
        if (cbx != JsonToken.NUMBER && cbx != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + cbx + cbB());
        }
        int asInt = ((com.google.gson.l) cby()).getAsInt();
        cbz();
        if (this.ixD > 0) {
            int[] iArr = this.ixF;
            int i = this.ixD - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asInt;
    }

    @Override // com.google.gson.stream.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.ixC = new Object[]{ixB};
        this.ixD = 1;
    }

    @Override // com.google.gson.stream.a
    public void skipValue() throws IOException {
        if (cbx() == JsonToken.NAME) {
            nextName();
            this.ixE[this.ixD - 2] = "null";
        } else {
            cbz();
            this.ixE[this.ixD - 1] = "null";
        }
        int[] iArr = this.ixF;
        int i = this.ixD - 1;
        iArr[i] = iArr[i] + 1;
    }

    @Override // com.google.gson.stream.a
    public String toString() {
        return getClass().getSimpleName();
    }

    public void cbA() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) cby()).next();
        push(entry.getValue());
        push(new com.google.gson.l((String) entry.getKey()));
    }

    private void push(Object obj) {
        if (this.ixD == this.ixC.length) {
            Object[] objArr = new Object[this.ixD * 2];
            int[] iArr = new int[this.ixD * 2];
            String[] strArr = new String[this.ixD * 2];
            System.arraycopy(this.ixC, 0, objArr, 0, this.ixD);
            System.arraycopy(this.ixF, 0, iArr, 0, this.ixD);
            System.arraycopy(this.ixE, 0, strArr, 0, this.ixD);
            this.ixC = objArr;
            this.ixF = iArr;
            this.ixE = strArr;
        }
        Object[] objArr2 = this.ixC;
        int i = this.ixD;
        this.ixD = i + 1;
        objArr2[i] = obj;
    }

    @Override // com.google.gson.stream.a
    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = 0;
        while (i < this.ixD) {
            if (this.ixC[i] instanceof com.google.gson.f) {
                i++;
                if (this.ixC[i] instanceof Iterator) {
                    append.append('[').append(this.ixF[i]).append(']');
                }
            } else if (this.ixC[i] instanceof com.google.gson.k) {
                i++;
                if (this.ixC[i] instanceof Iterator) {
                    append.append('.');
                    if (this.ixE[i] != null) {
                        append.append(this.ixE[i]);
                    }
                }
            }
            i++;
        }
        return append.toString();
    }

    private String cbB() {
        return " at path " + getPath();
    }
}
