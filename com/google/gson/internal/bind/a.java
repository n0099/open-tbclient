package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes17.dex */
public final class a extends com.google.gson.stream.a {
    private static final Reader odk = new Reader() { // from class: com.google.gson.internal.bind.a.1
        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }
    };
    private static final Object odl = new Object();
    private Object[] odm;
    private int odn;
    private String[] odo;
    private int[] odp;

    public a(JsonElement jsonElement) {
        super(odk);
        this.odm = new Object[32];
        this.odn = 0;
        this.odo = new String[32];
        this.odp = new int[32];
        push(jsonElement);
    }

    @Override // com.google.gson.stream.a
    public void eff() throws IOException {
        a(JsonToken.BEGIN_ARRAY);
        push(((JsonArray) efi()).iterator());
        this.odp[this.odn - 1] = 0;
    }

    @Override // com.google.gson.stream.a
    public void endArray() throws IOException {
        a(JsonToken.END_ARRAY);
        efj();
        efj();
        if (this.odn > 0) {
            int[] iArr = this.odp;
            int i = this.odn - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public void efg() throws IOException {
        a(JsonToken.BEGIN_OBJECT);
        push(((JsonObject) efi()).entrySet().iterator());
    }

    @Override // com.google.gson.stream.a
    public void endObject() throws IOException {
        a(JsonToken.END_OBJECT);
        efj();
        efj();
        if (this.odn > 0) {
            int[] iArr = this.odp;
            int i = this.odn - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public boolean hasNext() throws IOException {
        JsonToken efh = efh();
        return (efh == JsonToken.END_OBJECT || efh == JsonToken.END_ARRAY) ? false : true;
    }

    @Override // com.google.gson.stream.a
    public JsonToken efh() throws IOException {
        if (this.odn == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object efi = efi();
        if (efi instanceof Iterator) {
            boolean z = this.odm[this.odn - 2] instanceof JsonObject;
            Iterator it = (Iterator) efi;
            if (!it.hasNext()) {
                return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            } else if (z) {
                return JsonToken.NAME;
            } else {
                push(it.next());
                return efh();
            }
        } else if (efi instanceof JsonObject) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (efi instanceof JsonArray) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (efi instanceof JsonPrimitive) {
                JsonPrimitive jsonPrimitive = (JsonPrimitive) efi;
                if (jsonPrimitive.isString()) {
                    return JsonToken.STRING;
                }
                if (jsonPrimitive.isBoolean()) {
                    return JsonToken.BOOLEAN;
                }
                if (jsonPrimitive.isNumber()) {
                    return JsonToken.NUMBER;
                }
                throw new AssertionError();
            } else if (efi instanceof JsonNull) {
                return JsonToken.NULL;
            } else {
                if (efi == odl) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    private Object efi() {
        return this.odm[this.odn - 1];
    }

    private Object efj() {
        Object[] objArr = this.odm;
        int i = this.odn - 1;
        this.odn = i;
        Object obj = objArr[i];
        this.odm[this.odn] = null;
        return obj;
    }

    private void a(JsonToken jsonToken) throws IOException {
        if (efh() != jsonToken) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + efh() + efp());
        }
    }

    @Override // com.google.gson.stream.a
    public String efk() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) efi()).next();
        String str = (String) entry.getKey();
        this.odo[this.odn - 1] = str;
        push(entry.getValue());
        return str;
    }

    @Override // com.google.gson.stream.a
    public String efl() throws IOException {
        JsonToken efh = efh();
        if (efh != JsonToken.STRING && efh != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected " + JsonToken.STRING + " but was " + efh + efp());
        }
        String asString = ((JsonPrimitive) efj()).getAsString();
        if (this.odn > 0) {
            int[] iArr = this.odp;
            int i = this.odn - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asString;
    }

    @Override // com.google.gson.stream.a
    public boolean nextBoolean() throws IOException {
        a(JsonToken.BOOLEAN);
        boolean asBoolean = ((JsonPrimitive) efj()).getAsBoolean();
        if (this.odn > 0) {
            int[] iArr = this.odp;
            int i = this.odn - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asBoolean;
    }

    @Override // com.google.gson.stream.a
    public void efm() throws IOException {
        a(JsonToken.NULL);
        efj();
        if (this.odn > 0) {
            int[] iArr = this.odp;
            int i = this.odn - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public double nextDouble() throws IOException {
        JsonToken efh = efh();
        if (efh != JsonToken.NUMBER && efh != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + efh + efp());
        }
        double asDouble = ((JsonPrimitive) efi()).getAsDouble();
        if (!efB() && (Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + asDouble);
        }
        efj();
        if (this.odn > 0) {
            int[] iArr = this.odp;
            int i = this.odn - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asDouble;
    }

    @Override // com.google.gson.stream.a
    public long nextLong() throws IOException {
        JsonToken efh = efh();
        if (efh != JsonToken.NUMBER && efh != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + efh + efp());
        }
        long asLong = ((JsonPrimitive) efi()).getAsLong();
        efj();
        if (this.odn > 0) {
            int[] iArr = this.odp;
            int i = this.odn - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asLong;
    }

    @Override // com.google.gson.stream.a
    public int nextInt() throws IOException {
        JsonToken efh = efh();
        if (efh != JsonToken.NUMBER && efh != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + efh + efp());
        }
        int asInt = ((JsonPrimitive) efi()).getAsInt();
        efj();
        if (this.odn > 0) {
            int[] iArr = this.odp;
            int i = this.odn - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asInt;
    }

    @Override // com.google.gson.stream.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.odm = new Object[]{odl};
        this.odn = 1;
    }

    @Override // com.google.gson.stream.a
    public void efn() throws IOException {
        if (efh() == JsonToken.NAME) {
            efk();
            this.odo[this.odn - 2] = "null";
        } else {
            efj();
            if (this.odn > 0) {
                this.odo[this.odn - 1] = "null";
            }
        }
        if (this.odn > 0) {
            int[] iArr = this.odp;
            int i = this.odn - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public String toString() {
        return getClass().getSimpleName();
    }

    public void efo() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) efi()).next();
        push(entry.getValue());
        push(new JsonPrimitive((String) entry.getKey()));
    }

    private void push(Object obj) {
        if (this.odn == this.odm.length) {
            Object[] objArr = new Object[this.odn * 2];
            int[] iArr = new int[this.odn * 2];
            String[] strArr = new String[this.odn * 2];
            System.arraycopy(this.odm, 0, objArr, 0, this.odn);
            System.arraycopy(this.odp, 0, iArr, 0, this.odn);
            System.arraycopy(this.odo, 0, strArr, 0, this.odn);
            this.odm = objArr;
            this.odp = iArr;
            this.odo = strArr;
        }
        Object[] objArr2 = this.odm;
        int i = this.odn;
        this.odn = i + 1;
        objArr2[i] = obj;
    }

    @Override // com.google.gson.stream.a
    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = 0;
        while (i < this.odn) {
            if (this.odm[i] instanceof JsonArray) {
                i++;
                if (this.odm[i] instanceof Iterator) {
                    append.append('[').append(this.odp[i]).append(']');
                }
            } else if (this.odm[i] instanceof JsonObject) {
                i++;
                if (this.odm[i] instanceof Iterator) {
                    append.append('.');
                    if (this.odo[i] != null) {
                        append.append(this.odo[i]);
                    }
                }
            }
            i++;
        }
        return append.toString();
    }

    private String efp() {
        return " at path " + getPath();
    }
}
