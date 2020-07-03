package com.google.gson.internal.a;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public final class f extends com.google.gson.stream.b {
    private static final Writer nbe = new Writer() { // from class: com.google.gson.internal.a.f.1
        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }
    };
    private static final JsonPrimitive nbf = new JsonPrimitive("closed");
    private String nbg;
    private JsonElement nbh;
    private final List<JsonElement> stack;

    public f() {
        super(nbe);
        this.stack = new ArrayList();
        this.nbh = JsonNull.INSTANCE;
    }

    public JsonElement dHX() {
        if (!this.stack.isEmpty()) {
            throw new IllegalStateException("Expected one JSON element but was " + this.stack);
        }
        return this.nbh;
    }

    private JsonElement dHY() {
        return this.stack.get(this.stack.size() - 1);
    }

    private void a(JsonElement jsonElement) {
        if (this.nbg != null) {
            if (!jsonElement.isJsonNull() || dIr()) {
                ((JsonObject) dHY()).add(this.nbg, jsonElement);
            }
            this.nbg = null;
        } else if (this.stack.isEmpty()) {
            this.nbh = jsonElement;
        } else {
            JsonElement dHY = dHY();
            if (dHY instanceof JsonArray) {
                ((JsonArray) dHY).add(jsonElement);
                return;
            }
            throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b dHZ() throws IOException {
        JsonArray jsonArray = new JsonArray();
        a(jsonArray);
        this.stack.add(jsonArray);
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b dIa() throws IOException {
        if (this.stack.isEmpty() || this.nbg != null) {
            throw new IllegalStateException();
        }
        if (dHY() instanceof JsonArray) {
            this.stack.remove(this.stack.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b dIb() throws IOException {
        JsonObject jsonObject = new JsonObject();
        a(jsonObject);
        this.stack.add(jsonObject);
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b dIc() throws IOException {
        if (this.stack.isEmpty() || this.nbg != null) {
            throw new IllegalStateException();
        }
        if (dHY() instanceof JsonObject) {
            this.stack.remove(this.stack.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b Rb(String str) throws IOException {
        if (this.stack.isEmpty() || this.nbg != null) {
            throw new IllegalStateException();
        }
        if (dHY() instanceof JsonObject) {
            this.nbg = str;
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b Rc(String str) throws IOException {
        if (str == null) {
            return dId();
        }
        a(new JsonPrimitive(str));
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b dId() throws IOException {
        a(JsonNull.INSTANCE);
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b wR(boolean z) throws IOException {
        a(new JsonPrimitive(Boolean.valueOf(z)));
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b p(Boolean bool) throws IOException {
        if (bool == null) {
            return dId();
        }
        a(new JsonPrimitive(bool));
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b fZ(long j) throws IOException {
        a(new JsonPrimitive((Number) Long.valueOf(j)));
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b a(Number number) throws IOException {
        if (number == null) {
            return dId();
        }
        if (!dIi()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        a(new JsonPrimitive(number));
        return this;
    }

    @Override // com.google.gson.stream.b, java.io.Flushable
    public void flush() throws IOException {
    }

    @Override // com.google.gson.stream.b, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.stack.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.stack.add(nbf);
    }
}
