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
/* loaded from: classes10.dex */
public final class f extends com.google.gson.stream.b {
    private static final Writer njR = new Writer() { // from class: com.google.gson.internal.a.f.1
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
    private static final JsonPrimitive njS = new JsonPrimitive("closed");
    private String njT;
    private JsonElement njU;
    private final List<JsonElement> stack;

    public f() {
        super(njR);
        this.stack = new ArrayList();
        this.njU = JsonNull.INSTANCE;
    }

    public JsonElement dLw() {
        if (!this.stack.isEmpty()) {
            throw new IllegalStateException("Expected one JSON element but was " + this.stack);
        }
        return this.njU;
    }

    private JsonElement dLx() {
        return this.stack.get(this.stack.size() - 1);
    }

    private void a(JsonElement jsonElement) {
        if (this.njT != null) {
            if (!jsonElement.isJsonNull() || dLQ()) {
                ((JsonObject) dLx()).add(this.njT, jsonElement);
            }
            this.njT = null;
        } else if (this.stack.isEmpty()) {
            this.njU = jsonElement;
        } else {
            JsonElement dLx = dLx();
            if (dLx instanceof JsonArray) {
                ((JsonArray) dLx).add(jsonElement);
                return;
            }
            throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b dLy() throws IOException {
        JsonArray jsonArray = new JsonArray();
        a(jsonArray);
        this.stack.add(jsonArray);
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b dLz() throws IOException {
        if (this.stack.isEmpty() || this.njT != null) {
            throw new IllegalStateException();
        }
        if (dLx() instanceof JsonArray) {
            this.stack.remove(this.stack.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b dLA() throws IOException {
        JsonObject jsonObject = new JsonObject();
        a(jsonObject);
        this.stack.add(jsonObject);
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b dLB() throws IOException {
        if (this.stack.isEmpty() || this.njT != null) {
            throw new IllegalStateException();
        }
        if (dLx() instanceof JsonObject) {
            this.stack.remove(this.stack.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b RO(String str) throws IOException {
        if (this.stack.isEmpty() || this.njT != null) {
            throw new IllegalStateException();
        }
        if (dLx() instanceof JsonObject) {
            this.njT = str;
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b RP(String str) throws IOException {
        if (str == null) {
            return dLC();
        }
        a(new JsonPrimitive(str));
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b dLC() throws IOException {
        a(JsonNull.INSTANCE);
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b xw(boolean z) throws IOException {
        a(new JsonPrimitive(Boolean.valueOf(z)));
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b r(Boolean bool) throws IOException {
        if (bool == null) {
            return dLC();
        }
        a(new JsonPrimitive(bool));
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b gm(long j) throws IOException {
        a(new JsonPrimitive((Number) Long.valueOf(j)));
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b a(Number number) throws IOException {
        if (number == null) {
            return dLC();
        }
        if (!dLH()) {
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
        this.stack.add(njS);
    }
}
