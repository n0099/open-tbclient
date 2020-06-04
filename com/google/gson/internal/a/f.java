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
    private static final Writer mFb = new Writer() { // from class: com.google.gson.internal.a.f.1
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
    private static final JsonPrimitive mFc = new JsonPrimitive("closed");
    private String mFe;
    private JsonElement mFf;
    private final List<JsonElement> stack;

    public f() {
        super(mFb);
        this.stack = new ArrayList();
        this.mFf = JsonNull.INSTANCE;
    }

    public JsonElement dDv() {
        if (!this.stack.isEmpty()) {
            throw new IllegalStateException("Expected one JSON element but was " + this.stack);
        }
        return this.mFf;
    }

    private JsonElement dDw() {
        return this.stack.get(this.stack.size() - 1);
    }

    private void a(JsonElement jsonElement) {
        if (this.mFe != null) {
            if (!jsonElement.isJsonNull() || dDP()) {
                ((JsonObject) dDw()).add(this.mFe, jsonElement);
            }
            this.mFe = null;
        } else if (this.stack.isEmpty()) {
            this.mFf = jsonElement;
        } else {
            JsonElement dDw = dDw();
            if (dDw instanceof JsonArray) {
                ((JsonArray) dDw).add(jsonElement);
                return;
            }
            throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b dDx() throws IOException {
        JsonArray jsonArray = new JsonArray();
        a(jsonArray);
        this.stack.add(jsonArray);
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b dDy() throws IOException {
        if (this.stack.isEmpty() || this.mFe != null) {
            throw new IllegalStateException();
        }
        if (dDw() instanceof JsonArray) {
            this.stack.remove(this.stack.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b dDz() throws IOException {
        JsonObject jsonObject = new JsonObject();
        a(jsonObject);
        this.stack.add(jsonObject);
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b dDA() throws IOException {
        if (this.stack.isEmpty() || this.mFe != null) {
            throw new IllegalStateException();
        }
        if (dDw() instanceof JsonObject) {
            this.stack.remove(this.stack.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b Qp(String str) throws IOException {
        if (this.stack.isEmpty() || this.mFe != null) {
            throw new IllegalStateException();
        }
        if (dDw() instanceof JsonObject) {
            this.mFe = str;
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b Qq(String str) throws IOException {
        if (str == null) {
            return dDB();
        }
        a(new JsonPrimitive(str));
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b dDB() throws IOException {
        a(JsonNull.INSTANCE);
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b wv(boolean z) throws IOException {
        a(new JsonPrimitive(Boolean.valueOf(z)));
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b p(Boolean bool) throws IOException {
        if (bool == null) {
            return dDB();
        }
        a(new JsonPrimitive(bool));
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b fU(long j) throws IOException {
        a(new JsonPrimitive((Number) Long.valueOf(j)));
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b a(Number number) throws IOException {
        if (number == null) {
            return dDB();
        }
        if (!dDG()) {
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
        this.stack.add(mFc);
    }
}
