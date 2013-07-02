package com.google.gson.stream;

import com.baidu.zeus.bouncycastle.DERTags;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class JsonWriter implements Closeable, Flushable {
    private static final String[] HTML_SAFE_REPLACEMENT_CHARS;
    private static final String[] REPLACEMENT_CHARS = new String[DERTags.TAGGED];
    private String deferredName;
    private boolean htmlSafe;
    private String indent;
    private boolean lenient;
    private final Writer out;
    private String separator;
    private boolean serializeNulls;
    private final List stack = new ArrayList();

    static {
        for (int i = 0; i <= 31; i++) {
            REPLACEMENT_CHARS[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        REPLACEMENT_CHARS[34] = "\\\"";
        REPLACEMENT_CHARS[92] = "\\\\";
        REPLACEMENT_CHARS[9] = "\\t";
        REPLACEMENT_CHARS[8] = "\\b";
        REPLACEMENT_CHARS[10] = "\\n";
        REPLACEMENT_CHARS[13] = "\\r";
        REPLACEMENT_CHARS[12] = "\\f";
        HTML_SAFE_REPLACEMENT_CHARS = (String[]) REPLACEMENT_CHARS.clone();
        HTML_SAFE_REPLACEMENT_CHARS[60] = "\\u003c";
        HTML_SAFE_REPLACEMENT_CHARS[62] = "\\u003e";
        HTML_SAFE_REPLACEMENT_CHARS[38] = "\\u0026";
        HTML_SAFE_REPLACEMENT_CHARS[61] = "\\u003d";
        HTML_SAFE_REPLACEMENT_CHARS[39] = "\\u0027";
    }

    public JsonWriter(Writer writer) {
        this.stack.add(JsonScope.EMPTY_DOCUMENT);
        this.separator = ":";
        this.serializeNulls = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.out = writer;
    }

    public final void setIndent(String str) {
        if (str.length() == 0) {
            this.indent = null;
            this.separator = ":";
            return;
        }
        this.indent = str;
        this.separator = ": ";
    }

    public final void setLenient(boolean z) {
        this.lenient = z;
    }

    public boolean isLenient() {
        return this.lenient;
    }

    public final void setHtmlSafe(boolean z) {
        this.htmlSafe = z;
    }

    public final boolean isHtmlSafe() {
        return this.htmlSafe;
    }

    public final void setSerializeNulls(boolean z) {
        this.serializeNulls = z;
    }

    public final boolean getSerializeNulls() {
        return this.serializeNulls;
    }

    public JsonWriter beginArray() {
        writeDeferredName();
        return open(JsonScope.EMPTY_ARRAY, "[");
    }

    public JsonWriter endArray() {
        return close(JsonScope.EMPTY_ARRAY, JsonScope.NONEMPTY_ARRAY, "]");
    }

    public JsonWriter beginObject() {
        writeDeferredName();
        return open(JsonScope.EMPTY_OBJECT, "{");
    }

    public JsonWriter endObject() {
        return close(JsonScope.EMPTY_OBJECT, JsonScope.NONEMPTY_OBJECT, "}");
    }

    private JsonWriter open(JsonScope jsonScope, String str) {
        beforeValue(true);
        this.stack.add(jsonScope);
        this.out.write(str);
        return this;
    }

    private JsonWriter close(JsonScope jsonScope, JsonScope jsonScope2, String str) {
        JsonScope peek = peek();
        if (peek != jsonScope2 && peek != jsonScope) {
            throw new IllegalStateException("Nesting problem: " + this.stack);
        }
        if (this.deferredName != null) {
            throw new IllegalStateException("Dangling name: " + this.deferredName);
        }
        this.stack.remove(this.stack.size() - 1);
        if (peek == jsonScope2) {
            newline();
        }
        this.out.write(str);
        return this;
    }

    private JsonScope peek() {
        int size = this.stack.size();
        if (size == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return (JsonScope) this.stack.get(size - 1);
    }

    private void replaceTop(JsonScope jsonScope) {
        this.stack.set(this.stack.size() - 1, jsonScope);
    }

    public JsonWriter name(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.deferredName != null) {
            throw new IllegalStateException();
        }
        if (this.stack.isEmpty()) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.deferredName = str;
        return this;
    }

    private void writeDeferredName() {
        if (this.deferredName != null) {
            beforeName();
            string(this.deferredName);
            this.deferredName = null;
        }
    }

    public JsonWriter value(String str) {
        if (str == null) {
            return nullValue();
        }
        writeDeferredName();
        beforeValue(false);
        string(str);
        return this;
    }

    public JsonWriter nullValue() {
        if (this.deferredName != null) {
            if (this.serializeNulls) {
                writeDeferredName();
            } else {
                this.deferredName = null;
                return this;
            }
        }
        beforeValue(false);
        this.out.write("null");
        return this;
    }

    public JsonWriter value(boolean z) {
        writeDeferredName();
        beforeValue(false);
        this.out.write(z ? "true" : "false");
        return this;
    }

    public JsonWriter value(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + d);
        }
        writeDeferredName();
        beforeValue(false);
        this.out.append((CharSequence) Double.toString(d));
        return this;
    }

    public JsonWriter value(long j) {
        writeDeferredName();
        beforeValue(false);
        this.out.write(Long.toString(j));
        return this;
    }

    public JsonWriter value(Number number) {
        if (number == null) {
            return nullValue();
        }
        writeDeferredName();
        String obj = number.toString();
        if (!this.lenient && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        beforeValue(false);
        this.out.append((CharSequence) obj);
        return this;
    }

    public void flush() {
        if (this.stack.isEmpty()) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.out.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.out.close();
        int size = this.stack.size();
        if (size > 1 || (size == 1 && this.stack.get(size - 1) != JsonScope.NONEMPTY_DOCUMENT)) {
            throw new IOException("Incomplete document");
        }
        this.stack.clear();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void string(String str) {
        int i;
        String str2;
        int i2 = 0;
        String[] strArr = this.htmlSafe ? HTML_SAFE_REPLACEMENT_CHARS : REPLACEMENT_CHARS;
        this.out.write("\"");
        int length = str.length();
        for (i = 0; i < length; i = i + 1) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                str2 = strArr[charAt];
                i = str2 == null ? i + 1 : 0;
                if (i2 < i) {
                    this.out.write(str, i2, i - i2);
                }
                this.out.write(str2);
                i2 = i + 1;
            } else {
                if (charAt == 8232) {
                    str2 = "\\u2028";
                } else if (charAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i2 < i) {
                }
                this.out.write(str2);
                i2 = i + 1;
            }
        }
        if (i2 < length) {
            this.out.write(str, i2, length - i2);
        }
        this.out.write("\"");
    }

    private void newline() {
        if (this.indent != null) {
            this.out.write("\n");
            for (int i = 1; i < this.stack.size(); i++) {
                this.out.write(this.indent);
            }
        }
    }

    private void beforeName() {
        JsonScope peek = peek();
        if (peek == JsonScope.NONEMPTY_OBJECT) {
            this.out.write(44);
        } else if (peek != JsonScope.EMPTY_OBJECT) {
            throw new IllegalStateException("Nesting problem: " + this.stack);
        }
        newline();
        replaceTop(JsonScope.DANGLING_NAME);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void beforeValue(boolean z) {
        switch (peek()) {
            case NONEMPTY_DOCUMENT:
                if (!this.lenient) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
            case EMPTY_DOCUMENT:
                break;
            case EMPTY_ARRAY:
                replaceTop(JsonScope.NONEMPTY_ARRAY);
                newline();
                return;
            case NONEMPTY_ARRAY:
                this.out.append(',');
                newline();
                return;
            case DANGLING_NAME:
                this.out.append((CharSequence) this.separator);
                replaceTop(JsonScope.NONEMPTY_OBJECT);
                return;
            default:
                throw new IllegalStateException("Nesting problem: " + this.stack);
        }
        if (!this.lenient && !z) {
            throw new IllegalStateException("JSON must start with an array or an object.");
        }
        replaceTop(JsonScope.NONEMPTY_DOCUMENT);
    }
}
