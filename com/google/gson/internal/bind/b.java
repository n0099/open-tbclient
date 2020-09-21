package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes23.dex */
public final class b extends com.google.gson.stream.b {
    private static final Writer nNY = new Writer() { // from class: com.google.gson.internal.bind.b.1
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
    private static final JsonPrimitive nNZ = new JsonPrimitive("closed");
    private String nOa;
    private JsonElement nOb;
    private final List<JsonElement> stack;

    public b() {
        super(nNY);
        this.stack = new ArrayList();
        this.nOb = JsonNull.INSTANCE;
    }

    public JsonElement ebF() {
        if (!this.stack.isEmpty()) {
            throw new IllegalStateException("Expected one JSON element but was " + this.stack);
        }
        return this.nOb;
    }

    private JsonElement ebG() {
        return this.stack.get(this.stack.size() - 1);
    }

    private void a(JsonElement jsonElement) {
        if (this.nOa != null) {
            if (!jsonElement.isJsonNull() || ebZ()) {
                ((JsonObject) ebG()).add(this.nOa, jsonElement);
            }
            this.nOa = null;
        } else if (this.stack.isEmpty()) {
            this.nOb = jsonElement;
        } else {
            JsonElement ebG = ebG();
            if (ebG instanceof JsonArray) {
                ((JsonArray) ebG).add(jsonElement);
                return;
            }
            throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b ebH() throws IOException {
        JsonArray jsonArray = new JsonArray();
        a(jsonArray);
        this.stack.add(jsonArray);
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b ebI() throws IOException {
        if (this.stack.isEmpty() || this.nOa != null) {
            throw new IllegalStateException();
        }
        if (ebG() instanceof JsonArray) {
            this.stack.remove(this.stack.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b ebJ() throws IOException {
        JsonObject jsonObject = new JsonObject();
        a(jsonObject);
        this.stack.add(jsonObject);
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b ebK() throws IOException {
        if (this.stack.isEmpty() || this.nOa != null) {
            throw new IllegalStateException();
        }
        if (ebG() instanceof JsonObject) {
            this.stack.remove(this.stack.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b Vu(String str) throws IOException {
        if (this.stack.isEmpty() || this.nOa != null) {
            throw new IllegalStateException();
        }
        if (ebG() instanceof JsonObject) {
            this.nOa = str;
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b Vv(String str) throws IOException {
        if (str == null) {
            return ebL();
        }
        a(new JsonPrimitive(str));
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b ebL() throws IOException {
        a(JsonNull.INSTANCE);
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b yy(boolean z) throws IOException {
        a(new JsonPrimitive(Boolean.valueOf(z)));
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b u(Boolean bool) throws IOException {
        if (bool == null) {
            return ebL();
        }
        a(new JsonPrimitive(bool));
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b gP(long j) throws IOException {
        a(new JsonPrimitive((Number) Long.valueOf(j)));
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b a(Number number) throws IOException {
        if (number == null) {
            return ebL();
        }
        if (!ebQ()) {
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
        this.stack.add(nNZ);
    }
}
