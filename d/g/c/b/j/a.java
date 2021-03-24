package d.g.c.b.j;

import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.common.others.lang.StringUtil;
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
/* loaded from: classes6.dex */
public final class a extends d.g.c.d.a {
    public static final Reader y = new C1809a();
    public static final Object z = new Object();
    public Object[] u;
    public int v;
    public String[] w;
    public int[] x;

    /* renamed from: d.g.c.b.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1809a extends Reader {
        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }
    }

    public a(JsonElement jsonElement) {
        super(y);
        this.u = new Object[32];
        this.v = 0;
        this.w = new String[32];
        this.x = new int[32];
        c0(jsonElement);
    }

    private String B() {
        return " at path " + x();
    }

    @Override // d.g.c.d.a
    public boolean C() throws IOException {
        Y(JsonToken.BOOLEAN);
        boolean asBoolean = ((JsonPrimitive) a0()).getAsBoolean();
        int i = this.v;
        if (i > 0) {
            int[] iArr = this.x;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return asBoolean;
    }

    @Override // d.g.c.d.a
    public double D() throws IOException {
        JsonToken M = M();
        if (M != JsonToken.NUMBER && M != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + M + B());
        }
        double asDouble = ((JsonPrimitive) Z()).getAsDouble();
        if (!z() && (Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + asDouble);
        }
        a0();
        int i = this.v;
        if (i > 0) {
            int[] iArr = this.x;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return asDouble;
    }

    @Override // d.g.c.d.a
    public int E() throws IOException {
        JsonToken M = M();
        if (M != JsonToken.NUMBER && M != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + M + B());
        }
        int asInt = ((JsonPrimitive) Z()).getAsInt();
        a0();
        int i = this.v;
        if (i > 0) {
            int[] iArr = this.x;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return asInt;
    }

    @Override // d.g.c.d.a
    public long F() throws IOException {
        JsonToken M = M();
        if (M != JsonToken.NUMBER && M != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + M + B());
        }
        long asLong = ((JsonPrimitive) Z()).getAsLong();
        a0();
        int i = this.v;
        if (i > 0) {
            int[] iArr = this.x;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return asLong;
    }

    @Override // d.g.c.d.a
    public String G() throws IOException {
        Y(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) Z()).next();
        String str = (String) entry.getKey();
        this.w[this.v - 1] = str;
        c0(entry.getValue());
        return str;
    }

    @Override // d.g.c.d.a
    public void I() throws IOException {
        Y(JsonToken.NULL);
        a0();
        int i = this.v;
        if (i > 0) {
            int[] iArr = this.x;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // d.g.c.d.a
    public String K() throws IOException {
        JsonToken M = M();
        if (M != JsonToken.STRING && M != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected " + JsonToken.STRING + " but was " + M + B());
        }
        String asString = ((JsonPrimitive) a0()).getAsString();
        int i = this.v;
        if (i > 0) {
            int[] iArr = this.x;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return asString;
    }

    @Override // d.g.c.d.a
    public JsonToken M() throws IOException {
        if (this.v == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object Z = Z();
        if (Z instanceof Iterator) {
            boolean z2 = this.u[this.v - 2] instanceof JsonObject;
            Iterator it = (Iterator) Z;
            if (!it.hasNext()) {
                return z2 ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            } else if (z2) {
                return JsonToken.NAME;
            } else {
                c0(it.next());
                return M();
            }
        } else if (Z instanceof JsonObject) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (Z instanceof JsonArray) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (Z instanceof JsonPrimitive) {
                JsonPrimitive jsonPrimitive = (JsonPrimitive) Z;
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
            } else if (Z instanceof JsonNull) {
                return JsonToken.NULL;
            } else {
                if (Z == z) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    @Override // d.g.c.d.a
    public void W() throws IOException {
        if (M() == JsonToken.NAME) {
            G();
            this.w[this.v - 2] = StringUtil.NULL_STRING;
        } else {
            a0();
            int i = this.v;
            if (i > 0) {
                this.w[i - 1] = StringUtil.NULL_STRING;
            }
        }
        int i2 = this.v;
        if (i2 > 0) {
            int[] iArr = this.x;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    public final void Y(JsonToken jsonToken) throws IOException {
        if (M() == jsonToken) {
            return;
        }
        throw new IllegalStateException("Expected " + jsonToken + " but was " + M() + B());
    }

    public final Object Z() {
        return this.u[this.v - 1];
    }

    public final Object a0() {
        Object[] objArr = this.u;
        int i = this.v - 1;
        this.v = i;
        Object obj = objArr[i];
        objArr[i] = null;
        return obj;
    }

    public void b0() throws IOException {
        Y(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) Z()).next();
        c0(entry.getValue());
        c0(new JsonPrimitive((String) entry.getKey()));
    }

    public final void c0(Object obj) {
        int i = this.v;
        Object[] objArr = this.u;
        if (i == objArr.length) {
            Object[] objArr2 = new Object[i * 2];
            int[] iArr = new int[i * 2];
            String[] strArr = new String[i * 2];
            System.arraycopy(objArr, 0, objArr2, 0, i);
            System.arraycopy(this.x, 0, iArr, 0, this.v);
            System.arraycopy(this.w, 0, strArr, 0, this.v);
            this.u = objArr2;
            this.x = iArr;
            this.w = strArr;
        }
        Object[] objArr3 = this.u;
        int i2 = this.v;
        this.v = i2 + 1;
        objArr3[i2] = obj;
    }

    @Override // d.g.c.d.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.u = new Object[]{z};
        this.v = 1;
    }

    @Override // d.g.c.d.a
    public void n() throws IOException {
        Y(JsonToken.BEGIN_ARRAY);
        c0(((JsonArray) Z()).iterator());
        this.x[this.v - 1] = 0;
    }

    @Override // d.g.c.d.a
    public void o() throws IOException {
        Y(JsonToken.BEGIN_OBJECT);
        c0(((JsonObject) Z()).entrySet().iterator());
    }

    @Override // d.g.c.d.a
    public void t() throws IOException {
        Y(JsonToken.END_ARRAY);
        a0();
        a0();
        int i = this.v;
        if (i > 0) {
            int[] iArr = this.x;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // d.g.c.d.a
    public String toString() {
        return a.class.getSimpleName();
    }

    @Override // d.g.c.d.a
    public void v() throws IOException {
        Y(JsonToken.END_OBJECT);
        a0();
        a0();
        int i = this.v;
        if (i > 0) {
            int[] iArr = this.x;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // d.g.c.d.a
    public String x() {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i = 0;
        while (i < this.v) {
            Object[] objArr = this.u;
            if (objArr[i] instanceof JsonArray) {
                i++;
                if (objArr[i] instanceof Iterator) {
                    sb.append('[');
                    sb.append(this.x[i]);
                    sb.append(']');
                }
            } else if (objArr[i] instanceof JsonObject) {
                i++;
                if (objArr[i] instanceof Iterator) {
                    sb.append(IStringUtil.EXTENSION_SEPARATOR);
                    String[] strArr = this.w;
                    if (strArr[i] != null) {
                        sb.append(strArr[i]);
                    }
                }
            }
            i++;
        }
        return sb.toString();
    }

    @Override // d.g.c.d.a
    public boolean y() throws IOException {
        JsonToken M = M();
        return (M == JsonToken.END_OBJECT || M == JsonToken.END_ARRAY) ? false : true;
    }
}
