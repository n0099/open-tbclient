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
        push(((com.google.gson.f) caI()).iterator());
        this.iuv[this.iut - 1] = 0;
    }

    @Override // com.google.gson.stream.a
    public void endArray() throws IOException {
        a(JsonToken.END_ARRAY);
        caJ();
        caJ();
        if (this.iut > 0) {
            int[] iArr = this.iuv;
            int i = this.iut - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public void beginObject() throws IOException {
        a(JsonToken.BEGIN_OBJECT);
        push(((com.google.gson.k) caI()).entrySet().iterator());
    }

    @Override // com.google.gson.stream.a
    public void endObject() throws IOException {
        a(JsonToken.END_OBJECT);
        caJ();
        caJ();
        if (this.iut > 0) {
            int[] iArr = this.iuv;
            int i = this.iut - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public boolean hasNext() throws IOException {
        JsonToken caH = caH();
        return (caH == JsonToken.END_OBJECT || caH == JsonToken.END_ARRAY) ? false : true;
    }

    @Override // com.google.gson.stream.a
    public JsonToken caH() throws IOException {
        if (this.iut == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object caI = caI();
        if (caI instanceof Iterator) {
            boolean z = this.ius[this.iut - 2] instanceof com.google.gson.k;
            Iterator it = (Iterator) caI;
            if (!it.hasNext()) {
                return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            } else if (z) {
                return JsonToken.NAME;
            } else {
                push(it.next());
                return caH();
            }
        } else if (caI instanceof com.google.gson.k) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (caI instanceof com.google.gson.f) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (caI instanceof com.google.gson.l) {
                com.google.gson.l lVar = (com.google.gson.l) caI;
                if (lVar.cao()) {
                    return JsonToken.STRING;
                }
                if (lVar.cam()) {
                    return JsonToken.BOOLEAN;
                }
                if (lVar.can()) {
                    return JsonToken.NUMBER;
                }
                throw new AssertionError();
            } else if (caI instanceof com.google.gson.j) {
                return JsonToken.NULL;
            } else {
                if (caI == iur) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    private Object caI() {
        return this.ius[this.iut - 1];
    }

    private Object caJ() {
        Object[] objArr = this.ius;
        int i = this.iut - 1;
        this.iut = i;
        Object obj = objArr[i];
        this.ius[this.iut] = null;
        return obj;
    }

    private void a(JsonToken jsonToken) throws IOException {
        if (caH() != jsonToken) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + caH() + caL());
        }
    }

    @Override // com.google.gson.stream.a
    public String nextName() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) caI()).next();
        String str = (String) entry.getKey();
        this.iuu[this.iut - 1] = str;
        push(entry.getValue());
        return str;
    }

    @Override // com.google.gson.stream.a
    public String nextString() throws IOException {
        JsonToken caH = caH();
        if (caH != JsonToken.STRING && caH != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected " + JsonToken.STRING + " but was " + caH + caL());
        }
        String cad = ((com.google.gson.l) caJ()).cad();
        if (this.iut > 0) {
            int[] iArr = this.iuv;
            int i = this.iut - 1;
            iArr[i] = iArr[i] + 1;
        }
        return cad;
    }

    @Override // com.google.gson.stream.a
    public boolean nextBoolean() throws IOException {
        a(JsonToken.BOOLEAN);
        boolean asBoolean = ((com.google.gson.l) caJ()).getAsBoolean();
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
        caJ();
        if (this.iut > 0) {
            int[] iArr = this.iuv;
            int i = this.iut - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public double nextDouble() throws IOException {
        JsonToken caH = caH();
        if (caH != JsonToken.NUMBER && caH != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + caH + caL());
        }
        double asDouble = ((com.google.gson.l) caI()).getAsDouble();
        if (!isLenient() && (Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + asDouble);
        }
        caJ();
        if (this.iut > 0) {
            int[] iArr = this.iuv;
            int i = this.iut - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asDouble;
    }

    @Override // com.google.gson.stream.a
    public long nextLong() throws IOException {
        JsonToken caH = caH();
        if (caH != JsonToken.NUMBER && caH != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + caH + caL());
        }
        long asLong = ((com.google.gson.l) caI()).getAsLong();
        caJ();
        if (this.iut > 0) {
            int[] iArr = this.iuv;
            int i = this.iut - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asLong;
    }

    @Override // com.google.gson.stream.a
    public int nextInt() throws IOException {
        JsonToken caH = caH();
        if (caH != JsonToken.NUMBER && caH != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + caH + caL());
        }
        int asInt = ((com.google.gson.l) caI()).getAsInt();
        caJ();
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
        if (caH() == JsonToken.NAME) {
            nextName();
            this.iuu[this.iut - 2] = "null";
        } else {
            caJ();
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

    public void caK() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) caI()).next();
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

    private String caL() {
        return " at path " + getPath();
    }
}
