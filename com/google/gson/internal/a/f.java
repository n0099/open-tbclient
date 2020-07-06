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
    private static final Writer nbh = new Writer() { // from class: com.google.gson.internal.a.f.1
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
    private static final JsonPrimitive nbi = new JsonPrimitive("closed");
    private String nbj;
    private JsonElement nbk;
    private final List<JsonElement> stack;

    public f() {
        super(nbh);
        this.stack = new ArrayList();
        this.nbk = JsonNull.INSTANCE;
    }

    public JsonElement dIb() {
        if (!this.stack.isEmpty()) {
            throw new IllegalStateException("Expected one JSON element but was " + this.stack);
        }
        return this.nbk;
    }

    private JsonElement dIc() {
        return this.stack.get(this.stack.size() - 1);
    }

    private void a(JsonElement jsonElement) {
        if (this.nbj != null) {
            if (!jsonElement.isJsonNull() || dIv()) {
                ((JsonObject) dIc()).add(this.nbj, jsonElement);
            }
            this.nbj = null;
        } else if (this.stack.isEmpty()) {
            this.nbk = jsonElement;
        } else {
            JsonElement dIc = dIc();
            if (dIc instanceof JsonArray) {
                ((JsonArray) dIc).add(jsonElement);
                return;
            }
            throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b dId() throws IOException {
        JsonArray jsonArray = new JsonArray();
        a(jsonArray);
        this.stack.add(jsonArray);
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b dIe() throws IOException {
        if (this.stack.isEmpty() || this.nbj != null) {
            throw new IllegalStateException();
        }
        if (dIc() instanceof JsonArray) {
            this.stack.remove(this.stack.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b dIf() throws IOException {
        JsonObject jsonObject = new JsonObject();
        a(jsonObject);
        this.stack.add(jsonObject);
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b dIg() throws IOException {
        if (this.stack.isEmpty() || this.nbj != null) {
            throw new IllegalStateException();
        }
        if (dIc() instanceof JsonObject) {
            this.stack.remove(this.stack.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b Rc(String str) throws IOException {
        if (this.stack.isEmpty() || this.nbj != null) {
            throw new IllegalStateException();
        }
        if (dIc() instanceof JsonObject) {
            this.nbj = str;
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b Rd(String str) throws IOException {
        if (str == null) {
            return dIh();
        }
        a(new JsonPrimitive(str));
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b dIh() throws IOException {
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
            return dIh();
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
            return dIh();
        }
        if (!dIm()) {
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
        this.stack.add(nbi);
    }
}
