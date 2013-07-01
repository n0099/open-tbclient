package com.google.gson.stream;

import com.baidu.zeus.bouncycastle.DERTags;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d implements Closeable, Flushable {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f1677a = new String[DERTags.TAGGED];
    private static final String[] b;
    private final Writer c;
    private final List d = new ArrayList();
    private String e;
    private String f;
    private boolean g;
    private boolean h;
    private String i;
    private boolean j;

    static {
        for (int i = 0; i <= 31; i++) {
            f1677a[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        f1677a[34] = "\\\"";
        f1677a[92] = "\\\\";
        f1677a[9] = "\\t";
        f1677a[8] = "\\b";
        f1677a[10] = "\\n";
        f1677a[13] = "\\r";
        f1677a[12] = "\\f";
        b = (String[]) f1677a.clone();
        b[60] = "\\u003c";
        b[62] = "\\u003e";
        b[38] = "\\u0026";
        b[61] = "\\u003d";
        b[39] = "\\u0027";
    }

    public d(Writer writer) {
        this.d.add(JsonScope.EMPTY_DOCUMENT);
        this.f = ":";
        this.j = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.c = writer;
    }

    public final void b(boolean z) {
        this.g = z;
    }

    public boolean g() {
        return this.g;
    }

    public final boolean h() {
        return this.j;
    }

    public d b() {
        i();
        return a(JsonScope.EMPTY_ARRAY, "[");
    }

    public d c() {
        return a(JsonScope.EMPTY_ARRAY, JsonScope.NONEMPTY_ARRAY, "]");
    }

    public d d() {
        i();
        return a(JsonScope.EMPTY_OBJECT, "{");
    }

    public d e() {
        return a(JsonScope.EMPTY_OBJECT, JsonScope.NONEMPTY_OBJECT, "}");
    }

    private d a(JsonScope jsonScope, String str) {
        c(true);
        this.d.add(jsonScope);
        this.c.write(str);
        return this;
    }

    private d a(JsonScope jsonScope, JsonScope jsonScope2, String str) {
        JsonScope a2 = a();
        if (a2 != jsonScope2 && a2 != jsonScope) {
            throw new IllegalStateException("Nesting problem: " + this.d);
        }
        if (this.i != null) {
            throw new IllegalStateException("Dangling name: " + this.i);
        }
        this.d.remove(this.d.size() - 1);
        if (a2 == jsonScope2) {
            j();
        }
        this.c.write(str);
        return this;
    }

    private JsonScope a() {
        int size = this.d.size();
        if (size == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return (JsonScope) this.d.get(size - 1);
    }

    private void a(JsonScope jsonScope) {
        this.d.set(this.d.size() - 1, jsonScope);
    }

    public d a(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.i != null) {
            throw new IllegalStateException();
        }
        if (this.d.isEmpty()) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.i = str;
        return this;
    }

    private void i() {
        if (this.i != null) {
            k();
            c(this.i);
            this.i = null;
        }
    }

    public d b(String str) {
        if (str == null) {
            return f();
        }
        i();
        c(false);
        c(str);
        return this;
    }

    public d f() {
        if (this.i != null) {
            if (this.j) {
                i();
            } else {
                this.i = null;
                return this;
            }
        }
        c(false);
        this.c.write("null");
        return this;
    }

    public d a(boolean z) {
        i();
        c(false);
        this.c.write(z ? "true" : "false");
        return this;
    }

    public d a(long j) {
        i();
        c(false);
        this.c.write(Long.toString(j));
        return this;
    }

    public d a(Number number) {
        if (number == null) {
            return f();
        }
        i();
        String obj = number.toString();
        if (!this.g && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        c(false);
        this.c.append((CharSequence) obj);
        return this;
    }

    public void flush() {
        if (this.d.isEmpty()) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.c.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.c.close();
        int size = this.d.size();
        if (size > 1 || (size == 1 && this.d.get(size - 1) != JsonScope.NONEMPTY_DOCUMENT)) {
            throw new IOException("Incomplete document");
        }
        this.d.clear();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void c(String str) {
        int i;
        String str2;
        int i2 = 0;
        String[] strArr = this.h ? b : f1677a;
        this.c.write("\"");
        int length = str.length();
        for (i = 0; i < length; i = i + 1) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                str2 = strArr[charAt];
                i = str2 == null ? i + 1 : 0;
                if (i2 < i) {
                    this.c.write(str, i2, i - i2);
                }
                this.c.write(str2);
                i2 = i + 1;
            } else {
                if (charAt == 8232) {
                    str2 = "\\u2028";
                } else if (charAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i2 < i) {
                }
                this.c.write(str2);
                i2 = i + 1;
            }
        }
        if (i2 < length) {
            this.c.write(str, i2, length - i2);
        }
        this.c.write("\"");
    }

    private void j() {
        if (this.e != null) {
            this.c.write("\n");
            for (int i = 1; i < this.d.size(); i++) {
                this.c.write(this.e);
            }
        }
    }

    private void k() {
        JsonScope a2 = a();
        if (a2 == JsonScope.NONEMPTY_OBJECT) {
            this.c.write(44);
        } else if (a2 != JsonScope.EMPTY_OBJECT) {
            throw new IllegalStateException("Nesting problem: " + this.d);
        }
        j();
        a(JsonScope.DANGLING_NAME);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void c(boolean z) {
        switch (a()) {
            case NONEMPTY_DOCUMENT:
                if (!this.g) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
            case EMPTY_DOCUMENT:
                break;
            case EMPTY_ARRAY:
                a(JsonScope.NONEMPTY_ARRAY);
                j();
                return;
            case NONEMPTY_ARRAY:
                this.c.append(',');
                j();
                return;
            case DANGLING_NAME:
                this.c.append((CharSequence) this.f);
                a(JsonScope.NONEMPTY_OBJECT);
                return;
            default:
                throw new IllegalStateException("Nesting problem: " + this.d);
        }
        if (!this.g && !z) {
            throw new IllegalStateException("JSON must start with an array or an object.");
        }
        a(JsonScope.NONEMPTY_DOCUMENT);
    }
}
