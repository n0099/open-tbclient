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
/* loaded from: classes5.dex */
public final class b extends com.google.gson.stream.b {
    private static final Writer pTB = new Writer() { // from class: com.google.gson.internal.bind.b.1
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
    private static final JsonPrimitive pTC = new JsonPrimitive(LogConfig.TYPE_CLOSED);
    private String pTD;
    private JsonElement pTE;
    private final List<JsonElement> stack;

    public b() {
        super(pTB);
        this.stack = new ArrayList();
        this.pTE = JsonNull.INSTANCE;
    }

    public JsonElement eBK() {
        if (!this.stack.isEmpty()) {
            throw new IllegalStateException("Expected one JSON element but was " + this.stack);
        }
        return this.pTE;
    }

    private JsonElement eBL() {
        return this.stack.get(this.stack.size() - 1);
    }

    private void a(JsonElement jsonElement) {
        if (this.pTD != null) {
            if (!jsonElement.isJsonNull() || eCe()) {
                ((JsonObject) eBL()).add(this.pTD, jsonElement);
            }
            this.pTD = null;
        } else if (this.stack.isEmpty()) {
            this.pTE = jsonElement;
        } else {
            JsonElement eBL = eBL();
            if (eBL instanceof JsonArray) {
                ((JsonArray) eBL).add(jsonElement);
                return;
            }
            throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b eBM() throws IOException {
        JsonArray jsonArray = new JsonArray();
        a(jsonArray);
        this.stack.add(jsonArray);
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b eBN() throws IOException {
        if (this.stack.isEmpty() || this.pTD != null) {
            throw new IllegalStateException();
        }
        if (eBL() instanceof JsonArray) {
            this.stack.remove(this.stack.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b eBO() throws IOException {
        JsonObject jsonObject = new JsonObject();
        a(jsonObject);
        this.stack.add(jsonObject);
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b eBP() throws IOException {
        if (this.stack.isEmpty() || this.pTD != null) {
            throw new IllegalStateException();
        }
        if (eBL() instanceof JsonObject) {
            this.stack.remove(this.stack.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b ZW(String str) throws IOException {
        if (this.stack.isEmpty() || this.pTD != null) {
            throw new IllegalStateException();
        }
        if (eBL() instanceof JsonObject) {
            this.pTD = str;
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b ZX(String str) throws IOException {
        if (str == null) {
            return eBQ();
        }
        a(new JsonPrimitive(str));
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b eBQ() throws IOException {
        a(JsonNull.INSTANCE);
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b Bz(boolean z) throws IOException {
        a(new JsonPrimitive(Boolean.valueOf(z)));
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b v(Boolean bool) throws IOException {
        if (bool == null) {
            return eBQ();
        }
        a(new JsonPrimitive(bool));
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b iT(long j) throws IOException {
        a(new JsonPrimitive((Number) Long.valueOf(j)));
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b b(Number number) throws IOException {
        if (number == null) {
            return eBQ();
        }
        if (!eBV()) {
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
        this.stack.add(pTC);
    }
}
