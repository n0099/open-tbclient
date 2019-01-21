package com.google.gson.internal.a;

import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes2.dex */
public final class e extends com.google.gson.stream.a {
    private static final Reader iyI = new Reader() { // from class: com.google.gson.internal.a.e.1
        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }
    };
    private static final Object iyJ = new Object();
    private Object[] iyK;
    private int iyL;
    private String[] iyM;
    private int[] iyN;

    @Override // com.google.gson.stream.a
    public void beginArray() throws IOException {
        a(JsonToken.BEGIN_ARRAY);
        push(((com.google.gson.f) ccg()).iterator());
        this.iyN[this.iyL - 1] = 0;
    }

    @Override // com.google.gson.stream.a
    public void endArray() throws IOException {
        a(JsonToken.END_ARRAY);
        cch();
        cch();
        if (this.iyL > 0) {
            int[] iArr = this.iyN;
            int i = this.iyL - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public void beginObject() throws IOException {
        a(JsonToken.BEGIN_OBJECT);
        push(((com.google.gson.k) ccg()).entrySet().iterator());
    }

    @Override // com.google.gson.stream.a
    public void endObject() throws IOException {
        a(JsonToken.END_OBJECT);
        cch();
        cch();
        if (this.iyL > 0) {
            int[] iArr = this.iyN;
            int i = this.iyL - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public boolean hasNext() throws IOException {
        JsonToken ccf = ccf();
        return (ccf == JsonToken.END_OBJECT || ccf == JsonToken.END_ARRAY) ? false : true;
    }

    @Override // com.google.gson.stream.a
    public JsonToken ccf() throws IOException {
        if (this.iyL == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object ccg = ccg();
        if (ccg instanceof Iterator) {
            boolean z = this.iyK[this.iyL - 2] instanceof com.google.gson.k;
            Iterator it = (Iterator) ccg;
            if (!it.hasNext()) {
                return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            } else if (z) {
                return JsonToken.NAME;
            } else {
                push(it.next());
                return ccf();
            }
        } else if (ccg instanceof com.google.gson.k) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (ccg instanceof com.google.gson.f) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (ccg instanceof com.google.gson.l) {
                com.google.gson.l lVar = (com.google.gson.l) ccg;
                if (lVar.cbM()) {
                    return JsonToken.STRING;
                }
                if (lVar.cbK()) {
                    return JsonToken.BOOLEAN;
                }
                if (lVar.cbL()) {
                    return JsonToken.NUMBER;
                }
                throw new AssertionError();
            } else if (ccg instanceof com.google.gson.j) {
                return JsonToken.NULL;
            } else {
                if (ccg == iyJ) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    private Object ccg() {
        return this.iyK[this.iyL - 1];
    }

    private Object cch() {
        Object[] objArr = this.iyK;
        int i = this.iyL - 1;
        this.iyL = i;
        Object obj = objArr[i];
        this.iyK[this.iyL] = null;
        return obj;
    }

    private void a(JsonToken jsonToken) throws IOException {
        if (ccf() != jsonToken) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + ccf() + ccj());
        }
    }

    @Override // com.google.gson.stream.a
    public String nextName() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) ccg()).next();
        String str = (String) entry.getKey();
        this.iyM[this.iyL - 1] = str;
        push(entry.getValue());
        return str;
    }

    @Override // com.google.gson.stream.a
    public String nextString() throws IOException {
        JsonToken ccf = ccf();
        if (ccf != JsonToken.STRING && ccf != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected " + JsonToken.STRING + " but was " + ccf + ccj());
        }
        String cbB = ((com.google.gson.l) cch()).cbB();
        if (this.iyL > 0) {
            int[] iArr = this.iyN;
            int i = this.iyL - 1;
            iArr[i] = iArr[i] + 1;
        }
        return cbB;
    }

    @Override // com.google.gson.stream.a
    public boolean nextBoolean() throws IOException {
        a(JsonToken.BOOLEAN);
        boolean asBoolean = ((com.google.gson.l) cch()).getAsBoolean();
        if (this.iyL > 0) {
            int[] iArr = this.iyN;
            int i = this.iyL - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asBoolean;
    }

    @Override // com.google.gson.stream.a
    public void nextNull() throws IOException {
        a(JsonToken.NULL);
        cch();
        if (this.iyL > 0) {
            int[] iArr = this.iyN;
            int i = this.iyL - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public double nextDouble() throws IOException {
        JsonToken ccf = ccf();
        if (ccf != JsonToken.NUMBER && ccf != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + ccf + ccj());
        }
        double asDouble = ((com.google.gson.l) ccg()).getAsDouble();
        if (!isLenient() && (Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + asDouble);
        }
        cch();
        if (this.iyL > 0) {
            int[] iArr = this.iyN;
            int i = this.iyL - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asDouble;
    }

    @Override // com.google.gson.stream.a
    public long nextLong() throws IOException {
        JsonToken ccf = ccf();
        if (ccf != JsonToken.NUMBER && ccf != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + ccf + ccj());
        }
        long asLong = ((com.google.gson.l) ccg()).getAsLong();
        cch();
        if (this.iyL > 0) {
            int[] iArr = this.iyN;
            int i = this.iyL - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asLong;
    }

    @Override // com.google.gson.stream.a
    public int nextInt() throws IOException {
        JsonToken ccf = ccf();
        if (ccf != JsonToken.NUMBER && ccf != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + ccf + ccj());
        }
        int asInt = ((com.google.gson.l) ccg()).getAsInt();
        cch();
        if (this.iyL > 0) {
            int[] iArr = this.iyN;
            int i = this.iyL - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asInt;
    }

    @Override // com.google.gson.stream.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.iyK = new Object[]{iyJ};
        this.iyL = 1;
    }

    @Override // com.google.gson.stream.a
    public void skipValue() throws IOException {
        if (ccf() == JsonToken.NAME) {
            nextName();
            this.iyM[this.iyL - 2] = "null";
        } else {
            cch();
            this.iyM[this.iyL - 1] = "null";
        }
        int[] iArr = this.iyN;
        int i = this.iyL - 1;
        iArr[i] = iArr[i] + 1;
    }

    @Override // com.google.gson.stream.a
    public String toString() {
        return getClass().getSimpleName();
    }

    public void cci() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) ccg()).next();
        push(entry.getValue());
        push(new com.google.gson.l((String) entry.getKey()));
    }

    private void push(Object obj) {
        if (this.iyL == this.iyK.length) {
            Object[] objArr = new Object[this.iyL * 2];
            int[] iArr = new int[this.iyL * 2];
            String[] strArr = new String[this.iyL * 2];
            System.arraycopy(this.iyK, 0, objArr, 0, this.iyL);
            System.arraycopy(this.iyN, 0, iArr, 0, this.iyL);
            System.arraycopy(this.iyM, 0, strArr, 0, this.iyL);
            this.iyK = objArr;
            this.iyN = iArr;
            this.iyM = strArr;
        }
        Object[] objArr2 = this.iyK;
        int i = this.iyL;
        this.iyL = i + 1;
        objArr2[i] = obj;
    }

    @Override // com.google.gson.stream.a
    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = 0;
        while (i < this.iyL) {
            if (this.iyK[i] instanceof com.google.gson.f) {
                i++;
                if (this.iyK[i] instanceof Iterator) {
                    append.append('[').append(this.iyN[i]).append(']');
                }
            } else if (this.iyK[i] instanceof com.google.gson.k) {
                i++;
                if (this.iyK[i] instanceof Iterator) {
                    append.append('.');
                    if (this.iyM[i] != null) {
                        append.append(this.iyM[i]);
                    }
                }
            }
            i++;
        }
        return append.toString();
    }

    private String ccj() {
        return " at path " + getPath();
    }
}
