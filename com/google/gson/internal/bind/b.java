package com.google.gson.internal.bind;

import com.baidu.live.tbadk.log.LogConfig;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public final class b extends com.google.gson.stream.b {
    private static final Writer pIV = new Writer() { // from class: com.google.gson.internal.bind.b.1
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
    private static final JsonPrimitive pIW = new JsonPrimitive(LogConfig.TYPE_CLOSED);
    private String pIX;
    private JsonElement pIY;
    private final List<JsonElement> stack;

    public b() {
        super(pIV);
        this.stack = new ArrayList();
        this.pIY = JsonNull.INSTANCE;
    }

    public JsonElement ezk() {
        if (!this.stack.isEmpty()) {
            throw new IllegalStateException("Expected one JSON element but was " + this.stack);
        }
        return this.pIY;
    }

    private JsonElement ezl() {
        return this.stack.get(this.stack.size() - 1);
    }

    private void a(JsonElement jsonElement) {
        if (this.pIX != null) {
            if (!jsonElement.isJsonNull() || ezE()) {
                ((JsonObject) ezl()).add(this.pIX, jsonElement);
            }
            this.pIX = null;
        } else if (this.stack.isEmpty()) {
            this.pIY = jsonElement;
        } else {
            JsonElement ezl = ezl();
            if (ezl instanceof JsonArray) {
                ((JsonArray) ezl).add(jsonElement);
                return;
            }
            throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b ezm() throws IOException {
        JsonArray jsonArray = new JsonArray();
        a(jsonArray);
        this.stack.add(jsonArray);
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b ezn() throws IOException {
        if (this.stack.isEmpty() || this.pIX != null) {
            throw new IllegalStateException();
        }
        if (ezl() instanceof JsonArray) {
            this.stack.remove(this.stack.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b ezo() throws IOException {
        JsonObject jsonObject = new JsonObject();
        a(jsonObject);
        this.stack.add(jsonObject);
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b ezp() throws IOException {
        if (this.stack.isEmpty() || this.pIX != null) {
            throw new IllegalStateException();
        }
        if (ezl() instanceof JsonObject) {
            this.stack.remove(this.stack.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b YI(String str) throws IOException {
        if (this.stack.isEmpty() || this.pIX != null) {
            throw new IllegalStateException();
        }
        if (ezl() instanceof JsonObject) {
            this.pIX = str;
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b YJ(String str) throws IOException {
        if (str == null) {
            return ezq();
        }
        a(new JsonPrimitive(str));
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b ezq() throws IOException {
        a(JsonNull.INSTANCE);
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b Bg(boolean z) throws IOException {
        a(new JsonPrimitive(Boolean.valueOf(z)));
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b w(Boolean bool) throws IOException {
        if (bool == null) {
            return ezq();
        }
        a(new JsonPrimitive(bool));
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b iQ(long j) throws IOException {
        a(new JsonPrimitive((Number) Long.valueOf(j)));
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b b(Number number) throws IOException {
        if (number == null) {
            return ezq();
        }
        if (!ezv()) {
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
        this.stack.add(pIW);
    }
}
