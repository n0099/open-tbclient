package com.google.gson.internal.a;

import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes2.dex */
public final class e extends com.google.gson.stream.a {
    private static final Reader iuq = new Reader() { // from class: com.google.gson.internal.a.e.1
        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }
    };
    private static final Object iur = new Object();
    private Object[] ius;
    private int iut;
    private String[] iuu;
    private int[] iuv;

    @Override // com.google.gson.stream.a
    public void beginArray() throws IOException {
        a(JsonToken.BEGIN_ARRAY);
        push(((com.google.gson.f) caH()).iterator());
        this.iuv[this.iut - 1] = 0;
    }

    @Override // com.google.gson.stream.a
    public void endArray() throws IOException {
        a(JsonToken.END_ARRAY);
        caI();
        caI();
        if (this.iut > 0) {
            int[] iArr = this.iuv;
            int i = this.iut - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public void beginObject() throws IOException {
        a(JsonToken.BEGIN_OBJECT);
        push(((com.google.gson.k) caH()).entrySet().iterator());
    }

    @Override // com.google.gson.stream.a
    public void endObject() throws IOException {
        a(JsonToken.END_OBJECT);
        caI();
        caI();
        if (this.iut > 0) {
            int[] iArr = this.iuv;
            int i = this.iut - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public boolean hasNext() throws IOException {
        JsonToken caG = caG();
        return (caG == JsonToken.END_OBJECT || caG == JsonToken.END_ARRAY) ? false : true;
    }

    @Override // com.google.gson.stream.a
    public JsonToken caG() throws IOException {
        if (this.iut == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object caH = caH();
        if (caH instanceof Iterator) {
            boolean z = this.ius[this.iut - 2] instanceof com.google.gson.k;
            Iterator it = (Iterator) caH;
            if (!it.hasNext()) {
                return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            } else if (z) {
                return JsonToken.NAME;
            } else {
                push(it.next());
                return caG();
            }
        } else if (caH instanceof com.google.gson.k) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (caH instanceof com.google.gson.f) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (caH instanceof com.google.gson.l) {
                com.google.gson.l lVar = (com.google.gson.l) caH;
                if (lVar.can()) {
                    return JsonToken.STRING;
                }
                if (lVar.cal()) {
                    return JsonToken.BOOLEAN;
                }
                if (lVar.cam()) {
                    return JsonToken.NUMBER;
                }
                throw new AssertionError();
            } else if (caH instanceof com.google.gson.j) {
                return JsonToken.NULL;
            } else {
                if (caH == iur) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    private Object caH() {
        return this.ius[this.iut - 1];
    }

    private Object caI() {
        Object[] objArr = this.ius;
        int i = this.iut - 1;
        this.iut = i;
        Object obj = objArr[i];
        this.ius[this.iut] = null;
        return obj;
    }

    private void a(JsonToken jsonToken) throws IOException {
        if (caG() != jsonToken) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + caG() + caK());
        }
    }

    @Override // com.google.gson.stream.a
    public String nextName() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) caH()).next();
        String str = (String) entry.getKey();
        this.iuu[this.iut - 1] = str;
        push(entry.getValue());
        return str;
    }

    @Override // com.google.gson.stream.a
    public String nextString() throws IOException {
        JsonToken caG = caG();
        if (caG != JsonToken.STRING && caG != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected " + JsonToken.STRING + " but was " + caG + caK());
        }
        String cac = ((com.google.gson.l) caI()).cac();
        if (this.iut > 0) {
            int[] iArr = this.iuv;
            int i = this.iut - 1;
            iArr[i] = iArr[i] + 1;
        }
        return cac;
    }

    @Override // com.google.gson.stream.a
    public boolean nextBoolean() throws IOException {
        a(JsonToken.BOOLEAN);
        boolean asBoolean = ((com.google.gson.l) caI()).getAsBoolean();
        if (this.iut > 0) {
            int[] iArr = this.iuv;
            int i = this.iut - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asBoolean;
    }

    @Override // com.google.gson.stream.a
    public void nextNull() throws IOException {
        a(JsonToken.NULL);
        caI();
        if (this.iut > 0) {
            int[] iArr = this.iuv;
            int i = this.iut - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public double nextDouble() throws IOException {
        JsonToken caG = caG();
        if (caG != JsonToken.NUMBER && caG != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + caG + caK());
        }
        double asDouble = ((com.google.gson.l) caH()).getAsDouble();
        if (!isLenient() && (Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + asDouble);
        }
        caI();
        if (this.iut > 0) {
            int[] iArr = this.iuv;
            int i = this.iut - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asDouble;
    }

    @Override // com.google.gson.stream.a
    public long nextLong() throws IOException {
        JsonToken caG = caG();
        if (caG != JsonToken.NUMBER && caG != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + caG + caK());
        }
        long asLong = ((com.google.gson.l) caH()).getAsLong();
        caI();
        if (this.iut > 0) {
            int[] iArr = this.iuv;
            int i = this.iut - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asLong;
    }

    @Override // com.google.gson.stream.a
    public int nextInt() throws IOException {
        JsonToken caG = caG();
        if (caG != JsonToken.NUMBER && caG != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + caG + caK());
        }
        int asInt = ((com.google.gson.l) caH()).getAsInt();
        caI();
        if (this.iut > 0) {
            int[] iArr = this.iuv;
            int i = this.iut - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asInt;
    }

    @Override // com.google.gson.stream.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.ius = new Object[]{iur};
        this.iut = 1;
    }

    @Override // com.google.gson.stream.a
    public void skipValue() throws IOException {
        if (caG() == JsonToken.NAME) {
            nextName();
            this.iuu[this.iut - 2] = "null";
        } else {
            caI();
            this.iuu[this.iut - 1] = "null";
        }
        int[] iArr = this.iuv;
        int i = this.iut - 1;
        iArr[i] = iArr[i] + 1;
    }

    @Override // com.google.gson.stream.a
    public String toString() {
        return getClass().getSimpleName();
    }

    public void caJ() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) caH()).next();
        push(entry.getValue());
        push(new com.google.gson.l((String) entry.getKey()));
    }

    private void push(Object obj) {
        if (this.iut == this.ius.length) {
            Object[] objArr = new Object[this.iut * 2];
            int[] iArr = new int[this.iut * 2];
            String[] strArr = new String[this.iut * 2];
            System.arraycopy(this.ius, 0, objArr, 0, this.iut);
            System.arraycopy(this.iuv, 0, iArr, 0, this.iut);
            System.arraycopy(this.iuu, 0, strArr, 0, this.iut);
            this.ius = objArr;
            this.iuv = iArr;
            this.iuu = strArr;
        }
        Object[] objArr2 = this.ius;
        int i = this.iut;
        this.iut = i + 1;
        objArr2[i] = obj;
    }

    @Override // com.google.gson.stream.a
    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = 0;
        while (i < this.iut) {
            if (this.ius[i] instanceof com.google.gson.f) {
                i++;
                if (this.ius[i] instanceof Iterator) {
                    append.append('[').append(this.iuv[i]).append(']');
                }
            } else if (this.ius[i] instanceof com.google.gson.k) {
                i++;
                if (this.ius[i] instanceof Iterator) {
                    append.append('.');
                    if (this.iuu[i] != null) {
                        append.append(this.iuu[i]);
                    }
                }
            }
            i++;
        }
        return append.toString();
    }

    private String caK() {
        return " at path " + getPath();
    }
}
