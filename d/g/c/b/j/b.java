package d.g.c.b.j;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public final class b extends d.g.c.d.b {
    public static final Writer s = new a();
    public static final JsonPrimitive t = new JsonPrimitive("closed");
    public final List<JsonElement> p;
    public String q;
    public JsonElement r;

    /* loaded from: classes6.dex */
    public static class a extends Writer {
        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }
    }

    public b() {
        super(s);
        this.p = new ArrayList();
        this.r = JsonNull.INSTANCE;
    }

    @Override // d.g.c.d.b
    public d.g.c.d.b B() throws IOException {
        T(JsonNull.INSTANCE);
        return this;
    }

    @Override // d.g.c.d.b
    public d.g.c.d.b L(long j) throws IOException {
        T(new JsonPrimitive((Number) Long.valueOf(j)));
        return this;
    }

    @Override // d.g.c.d.b
    public d.g.c.d.b M(Boolean bool) throws IOException {
        if (bool == null) {
            B();
            return this;
        }
        T(new JsonPrimitive(bool));
        return this;
    }

    @Override // d.g.c.d.b
    public d.g.c.d.b N(Number number) throws IOException {
        if (number == null) {
            B();
            return this;
        }
        if (!y()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        T(new JsonPrimitive(number));
        return this;
    }

    @Override // d.g.c.d.b
    public d.g.c.d.b O(String str) throws IOException {
        if (str == null) {
            B();
            return this;
        }
        T(new JsonPrimitive(str));
        return this;
    }

    @Override // d.g.c.d.b
    public d.g.c.d.b P(boolean z) throws IOException {
        T(new JsonPrimitive(Boolean.valueOf(z)));
        return this;
    }

    public JsonElement R() {
        if (this.p.isEmpty()) {
            return this.r;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.p);
    }

    public final JsonElement S() {
        List<JsonElement> list = this.p;
        return list.get(list.size() - 1);
    }

    public final void T(JsonElement jsonElement) {
        if (this.q != null) {
            if (!jsonElement.isJsonNull() || w()) {
                ((JsonObject) S()).add(this.q, jsonElement);
            }
            this.q = null;
        } else if (this.p.isEmpty()) {
            this.r = jsonElement;
        } else {
            JsonElement S = S();
            if (S instanceof JsonArray) {
                ((JsonArray) S).add(jsonElement);
                return;
            }
            throw new IllegalStateException();
        }
    }

    @Override // d.g.c.d.b, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.p.isEmpty()) {
            this.p.add(t);
            return;
        }
        throw new IOException("Incomplete document");
    }

    @Override // d.g.c.d.b, java.io.Flushable
    public void flush() throws IOException {
    }

    @Override // d.g.c.d.b
    public d.g.c.d.b q() throws IOException {
        JsonArray jsonArray = new JsonArray();
        T(jsonArray);
        this.p.add(jsonArray);
        return this;
    }

    @Override // d.g.c.d.b
    public d.g.c.d.b r() throws IOException {
        JsonObject jsonObject = new JsonObject();
        T(jsonObject);
        this.p.add(jsonObject);
        return this;
    }

    @Override // d.g.c.d.b
    public d.g.c.d.b t() throws IOException {
        if (!this.p.isEmpty() && this.q == null) {
            if (S() instanceof JsonArray) {
                List<JsonElement> list = this.p;
                list.remove(list.size() - 1);
                return this;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    @Override // d.g.c.d.b
    public d.g.c.d.b v() throws IOException {
        if (!this.p.isEmpty() && this.q == null) {
            if (S() instanceof JsonObject) {
                List<JsonElement> list = this.p;
                list.remove(list.size() - 1);
                return this;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    @Override // d.g.c.d.b
    public d.g.c.d.b z(String str) throws IOException {
        if (!this.p.isEmpty() && this.q == null) {
            if (S() instanceof JsonObject) {
                this.q = str;
                return this;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }
}
