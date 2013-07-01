package com.google.gson.stream;

import com.baidu.zeus.NotificationProxy;
import com.baidu.zeus.WebChromeClient;
import com.google.gson.internal.m;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
/* loaded from: classes.dex */
public class a implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f1675a = ")]}'\n".toCharArray();
    private final Reader c;
    private JsonToken l;
    private String m;
    private String n;
    private int o;
    private int p;
    private boolean q;
    private final f b = new f();
    private boolean d = false;
    private final char[] e = new char[NotificationProxy.MAX_URL_LENGTH];
    private int f = 0;
    private int g = 0;
    private int h = 1;
    private int i = 1;
    private JsonScope[] j = new JsonScope[32];
    private int k = 0;

    static {
        m.f1657a = new b();
    }

    public a(Reader reader) {
        a(JsonScope.EMPTY_DOCUMENT);
        this.q = false;
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.c = reader;
    }

    public final void a(boolean z) {
        this.d = z;
    }

    public final boolean p() {
        return this.d;
    }

    public void a() {
        a(JsonToken.BEGIN_ARRAY);
    }

    public void b() {
        a(JsonToken.END_ARRAY);
    }

    public void c() {
        a(JsonToken.BEGIN_OBJECT);
    }

    public void d() {
        a(JsonToken.END_OBJECT);
    }

    private void a(JsonToken jsonToken) {
        f();
        if (this.l != jsonToken) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + f() + " at line " + t() + " column " + u());
        }
        q();
    }

    public boolean e() {
        f();
        return (this.l == JsonToken.END_OBJECT || this.l == JsonToken.END_ARRAY) ? false : true;
    }

    public JsonToken f() {
        if (this.l != null) {
            return this.l;
        }
        switch (this.j[this.k + (-1)]) {
            case EMPTY_DOCUMENT:
                if (this.d) {
                    o();
                }
                this.j[this.k - 1] = JsonScope.NONEMPTY_DOCUMENT;
                JsonToken s = s();
                if (!this.d && this.l != JsonToken.BEGIN_ARRAY && this.l != JsonToken.BEGIN_OBJECT) {
                    throw new IOException("Expected JSON document to start with '[' or '{' but was " + this.l + " at line " + t() + " column " + u());
                }
                return s;
            case EMPTY_ARRAY:
                return b(true);
            case NONEMPTY_ARRAY:
                return b(false);
            case EMPTY_OBJECT:
                return c(true);
            case DANGLING_NAME:
                return r();
            case NONEMPTY_OBJECT:
                return c(false);
            case NONEMPTY_DOCUMENT:
                if (d(false) == -1) {
                    return JsonToken.END_DOCUMENT;
                }
                this.f--;
                if (!this.d) {
                    throw b("Expected EOF");
                }
                return s();
            case CLOSED:
                throw new IllegalStateException("JsonReader is closed");
            default:
                throw new AssertionError();
        }
    }

    private void o() {
        d(true);
        this.f--;
        if (this.f + f1675a.length <= this.g || a(f1675a.length)) {
            for (int i = 0; i < f1675a.length; i++) {
                if (this.e[this.f + i] != f1675a[i]) {
                    return;
                }
            }
            this.f += f1675a.length;
        }
    }

    private JsonToken q() {
        f();
        JsonToken jsonToken = this.l;
        this.l = null;
        this.n = null;
        this.m = null;
        return jsonToken;
    }

    public String g() {
        f();
        if (this.l != JsonToken.NAME) {
            throw new IllegalStateException("Expected a name but was " + f() + " at line " + t() + " column " + u());
        }
        String str = this.m;
        q();
        return str;
    }

    public String h() {
        f();
        if (this.l != JsonToken.STRING && this.l != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected a string but was " + f() + " at line " + t() + " column " + u());
        }
        String str = this.n;
        q();
        return str;
    }

    public boolean i() {
        f();
        if (this.l != JsonToken.BOOLEAN) {
            throw new IllegalStateException("Expected a boolean but was " + this.l + " at line " + t() + " column " + u());
        }
        boolean z = this.n == "true";
        q();
        return z;
    }

    public void j() {
        f();
        if (this.l != JsonToken.NULL) {
            throw new IllegalStateException("Expected null but was " + this.l + " at line " + t() + " column " + u());
        }
        q();
    }

    public double k() {
        f();
        if (this.l != JsonToken.STRING && this.l != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected a double but was " + this.l + " at line " + t() + " column " + u());
        }
        double parseDouble = Double.parseDouble(this.n);
        if (parseDouble >= 1.0d && this.n.startsWith("0")) {
            throw new MalformedJsonException("JSON forbids octal prefixes: " + this.n + " at line " + t() + " column " + u());
        }
        if (!this.d && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + this.n + " at line " + t() + " column " + u());
        }
        q();
        return parseDouble;
    }

    public long l() {
        long j;
        f();
        if (this.l != JsonToken.STRING && this.l != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected a long but was " + this.l + " at line " + t() + " column " + u());
        }
        try {
            j = Long.parseLong(this.n);
        } catch (NumberFormatException e) {
            double parseDouble = Double.parseDouble(this.n);
            j = (long) parseDouble;
            if (j != parseDouble) {
                throw new NumberFormatException("Expected a long but was " + this.n + " at line " + t() + " column " + u());
            }
        }
        if (j >= 1 && this.n.startsWith("0")) {
            throw new MalformedJsonException("JSON forbids octal prefixes: " + this.n + " at line " + t() + " column " + u());
        }
        q();
        return j;
    }

    public int m() {
        int i;
        f();
        if (this.l != JsonToken.STRING && this.l != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected an int but was " + this.l + " at line " + t() + " column " + u());
        }
        try {
            i = Integer.parseInt(this.n);
        } catch (NumberFormatException e) {
            double parseDouble = Double.parseDouble(this.n);
            i = (int) parseDouble;
            if (i != parseDouble) {
                throw new NumberFormatException("Expected an int but was " + this.n + " at line " + t() + " column " + u());
            }
        }
        if (i >= 1 && this.n.startsWith("0")) {
            throw new MalformedJsonException("JSON forbids octal prefixes: " + this.n + " at line " + t() + " column " + u());
        }
        q();
        return i;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.n = null;
        this.l = null;
        this.j[0] = JsonScope.CLOSED;
        this.k = 1;
        this.c.close();
    }

    public void n() {
        this.q = true;
        int i = 0;
        do {
            try {
                JsonToken q = q();
                if (q == JsonToken.BEGIN_ARRAY || q == JsonToken.BEGIN_OBJECT) {
                    i++;
                    continue;
                } else if (q == JsonToken.END_ARRAY || q == JsonToken.END_OBJECT) {
                    i--;
                    continue;
                }
            } finally {
                this.q = false;
            }
        } while (i != 0);
    }

    private void a(JsonScope jsonScope) {
        if (this.k == this.j.length) {
            JsonScope[] jsonScopeArr = new JsonScope[this.k * 2];
            System.arraycopy(this.j, 0, jsonScopeArr, 0, this.k);
            this.j = jsonScopeArr;
        }
        JsonScope[] jsonScopeArr2 = this.j;
        int i = this.k;
        this.k = i + 1;
        jsonScopeArr2[i] = jsonScope;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private JsonToken b(boolean z) {
        if (z) {
            this.j[this.k - 1] = JsonScope.NONEMPTY_ARRAY;
        } else {
            switch (d(true)) {
                case 44:
                    break;
                case 59:
                    v();
                    break;
                case 93:
                    this.k--;
                    JsonToken jsonToken = JsonToken.END_ARRAY;
                    this.l = jsonToken;
                    return jsonToken;
                default:
                    throw b("Unterminated array");
            }
        }
        switch (d(true)) {
            case 44:
            case 59:
                break;
            default:
                this.f--;
                return s();
            case 93:
                if (z) {
                    this.k--;
                    JsonToken jsonToken2 = JsonToken.END_ARRAY;
                    this.l = jsonToken2;
                    return jsonToken2;
                }
                break;
        }
        v();
        this.f--;
        this.n = "null";
        JsonToken jsonToken3 = JsonToken.NULL;
        this.l = jsonToken3;
        return jsonToken3;
    }

    private JsonToken c(boolean z) {
        if (z) {
            switch (d(true)) {
                case 125:
                    this.k--;
                    JsonToken jsonToken = JsonToken.END_OBJECT;
                    this.l = jsonToken;
                    return jsonToken;
                default:
                    this.f--;
                    break;
            }
        } else {
            switch (d(true)) {
                case 44:
                case 59:
                    break;
                case 125:
                    this.k--;
                    JsonToken jsonToken2 = JsonToken.END_OBJECT;
                    this.l = jsonToken2;
                    return jsonToken2;
                default:
                    throw b("Unterminated object");
            }
        }
        int d = d(true);
        switch (d) {
            case 39:
                v();
            case 34:
                this.m = a((char) d);
                break;
            default:
                v();
                this.f--;
                this.m = e(false);
                if (this.m.length() == 0) {
                    throw b("Expected name");
                }
                break;
        }
        this.j[this.k - 1] = JsonScope.DANGLING_NAME;
        JsonToken jsonToken3 = JsonToken.NAME;
        this.l = jsonToken3;
        return jsonToken3;
    }

    private JsonToken r() {
        switch (d(true)) {
            case 58:
                break;
            case 59:
            case 60:
            default:
                throw b("Expected ':'");
            case 61:
                v();
                if ((this.f < this.g || a(1)) && this.e[this.f] == '>') {
                    this.f++;
                    break;
                }
                break;
        }
        this.j[this.k - 1] = JsonScope.NONEMPTY_OBJECT;
        return s();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private JsonToken s() {
        int d = d(true);
        switch (d) {
            case 34:
                break;
            case 39:
                v();
                break;
            case 91:
                a(JsonScope.EMPTY_ARRAY);
                JsonToken jsonToken = JsonToken.BEGIN_ARRAY;
                this.l = jsonToken;
                return jsonToken;
            case 123:
                a(JsonScope.EMPTY_OBJECT);
                JsonToken jsonToken2 = JsonToken.BEGIN_OBJECT;
                this.l = jsonToken2;
                return jsonToken2;
            default:
                this.f--;
                return y();
        }
        this.n = a((char) d);
        JsonToken jsonToken3 = JsonToken.STRING;
        this.l = jsonToken3;
        return jsonToken3;
    }

    private boolean a(int i) {
        char[] cArr = this.e;
        int i2 = this.h;
        int i3 = this.i;
        int i4 = this.f;
        for (int i5 = 0; i5 < i4; i5++) {
            if (cArr[i5] == '\n') {
                i2++;
                i3 = 1;
            } else {
                i3++;
            }
        }
        this.h = i2;
        this.i = i3;
        if (this.g != this.f) {
            this.g -= this.f;
            System.arraycopy(cArr, this.f, cArr, 0, this.g);
        } else {
            this.g = 0;
        }
        this.f = 0;
        do {
            int read = this.c.read(cArr, this.g, cArr.length - this.g);
            if (read == -1) {
                return false;
            }
            this.g = read + this.g;
            if (this.h == 1 && this.i == 1 && this.g > 0 && cArr[0] == 65279) {
                this.f++;
                this.i--;
            }
        } while (this.g < i);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int t() {
        int i = this.h;
        for (int i2 = 0; i2 < this.f; i2++) {
            if (this.e[i2] == '\n') {
                i++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int u() {
        int i = this.i;
        for (int i2 = 0; i2 < this.f; i2++) {
            if (this.e[i2] == '\n') {
                i = 1;
            } else {
                i++;
            }
        }
        return i;
    }

    private int d(boolean z) {
        char[] cArr = this.e;
        int i = this.f;
        int i2 = this.g;
        while (true) {
            if (i == i2) {
                this.f = i;
                if (a(1)) {
                    i = this.f;
                    i2 = this.g;
                } else if (z) {
                    throw new EOFException("End of input at line " + t() + " column " + u());
                } else {
                    return -1;
                }
            }
            int i3 = i + 1;
            char c = cArr[i];
            switch (c) {
                case '\t':
                case '\n':
                case '\r':
                case ' ':
                    i = i3;
                    break;
                case '#':
                    this.f = i3;
                    v();
                    w();
                    i = this.f;
                    i2 = this.g;
                    break;
                case '/':
                    this.f = i3;
                    if (i3 == i2) {
                        this.f--;
                        boolean a2 = a(2);
                        this.f++;
                        if (!a2) {
                            return c;
                        }
                    }
                    v();
                    switch (cArr[this.f]) {
                        case '*':
                            this.f++;
                            if (!a("*/")) {
                                throw b("Unterminated comment");
                            }
                            i = this.f + 2;
                            i2 = this.g;
                            continue;
                        case '/':
                            this.f++;
                            w();
                            i = this.f;
                            i2 = this.g;
                            continue;
                        default:
                            return c;
                    }
                default:
                    this.f = i3;
                    return c;
            }
        }
    }

    private void v() {
        if (!this.d) {
            throw b("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void w() {
        char c;
        do {
            if (this.f < this.g || a(1)) {
                char[] cArr = this.e;
                int i = this.f;
                this.f = i + 1;
                c = cArr[i];
                if (c == '\r') {
                    return;
                }
            } else {
                return;
            }
        } while (c != '\n');
    }

    private boolean a(String str) {
        while (true) {
            if (this.f + str.length() <= this.g || a(str.length())) {
                for (int i = 0; i < str.length(); i++) {
                    if (this.e[this.f + i] != str.charAt(i)) {
                        break;
                    }
                }
                return true;
            }
            return false;
            this.f++;
        }
    }

    private String a(char c) {
        int i;
        int i2;
        StringBuilder sb;
        int i3;
        char[] cArr = this.e;
        StringBuilder sb2 = null;
        do {
            int i4 = this.f;
            int i5 = this.g;
            int i6 = i4;
            while (i6 < i5) {
                int i7 = i6 + 1;
                char c2 = cArr[i6];
                if (c2 == c) {
                    this.f = i7;
                    if (this.q) {
                        return "skipped!";
                    }
                    if (sb2 == null) {
                        return this.b.a(cArr, i4, (i7 - i4) - 1);
                    }
                    sb2.append(cArr, i4, (i7 - i4) - 1);
                    return sb2.toString();
                }
                if (c2 == '\\') {
                    this.f = i7;
                    if (sb2 == null) {
                        sb2 = new StringBuilder();
                    }
                    sb2.append(cArr, i4, (i7 - i4) - 1);
                    sb2.append(x());
                    int i8 = this.f;
                    sb = sb2;
                    i3 = i8;
                    i = this.g;
                    i2 = i8;
                } else {
                    int i9 = i4;
                    i = i5;
                    i2 = i7;
                    sb = sb2;
                    i3 = i9;
                }
                i6 = i2;
                i5 = i;
                i4 = i3;
                sb2 = sb;
            }
            if (sb2 == null) {
                sb2 = new StringBuilder();
            }
            sb2.append(cArr, i4, i6 - i4);
            this.f = i6;
        } while (a(1));
        throw b("Unterminated string");
    }

    private String e(boolean z) {
        String str = null;
        this.o = -1;
        this.p = 0;
        int i = 0;
        StringBuilder sb = null;
        while (true) {
            if (this.f + i < this.g) {
                switch (this.e[this.f + i]) {
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                    case ' ':
                    case ',':
                    case ':':
                    case '[':
                    case ']':
                    case '{':
                    case '}':
                        break;
                    case '#':
                    case '/':
                    case ';':
                    case '=':
                    case '\\':
                        v();
                        break;
                    default:
                        i++;
                }
            } else if (i < this.e.length) {
                if (!a(i + 1)) {
                    this.e[this.g] = 0;
                }
            } else {
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append(this.e, this.f, i);
                this.p += i;
                this.f = i + this.f;
                if (a(1)) {
                    i = 0;
                } else {
                    i = 0;
                }
            }
        }
        if (z && sb == null) {
            this.o = this.f;
        } else if (this.q) {
            str = "skipped!";
        } else if (sb == null) {
            str = this.b.a(this.e, this.f, i);
        } else {
            sb.append(this.e, this.f, i);
            str = sb.toString();
        }
        this.p += i;
        this.f += i;
        return str;
    }

    public String toString() {
        return getClass().getSimpleName() + " at line " + t() + " column " + u();
    }

    private char x() {
        int i;
        if (this.f == this.g && !a(1)) {
            throw b("Unterminated escape sequence");
        }
        char[] cArr = this.e;
        int i2 = this.f;
        this.f = i2 + 1;
        char c = cArr[i2];
        switch (c) {
            case 'b':
                return '\b';
            case WebChromeClient.STRING_DLG_TITLE_WEEK /* 102 */:
                return '\f';
            case 'n':
                return '\n';
            case 'r':
                return '\r';
            case 't':
                return '\t';
            case 'u':
                if (this.f + 4 > this.g && !a(4)) {
                    throw b("Unterminated escape sequence");
                }
                int i3 = this.f;
                int i4 = i3 + 4;
                char c2 = 0;
                for (int i5 = i3; i5 < i4; i5++) {
                    char c3 = this.e[i5];
                    char c4 = (char) (c2 << 4);
                    if (c3 >= '0' && c3 <= '9') {
                        i = c3 - '0';
                    } else if (c3 >= 'a' && c3 <= 'f') {
                        i = (c3 - 'a') + 10;
                    } else if (c3 >= 'A' && c3 <= 'F') {
                        i = (c3 - 'A') + 10;
                    } else {
                        throw new NumberFormatException("\\u" + this.b.a(this.e, this.f, 4));
                    }
                    c2 = (char) (c4 + i);
                }
                this.f += 4;
                return c2;
            default:
                return c;
        }
    }

    private JsonToken y() {
        this.n = e(true);
        if (this.p == 0) {
            throw b("Expected literal value");
        }
        this.l = z();
        if (this.l == JsonToken.STRING) {
            v();
        }
        return this.l;
    }

    private JsonToken z() {
        if (this.o == -1) {
            return JsonToken.STRING;
        }
        if (this.p == 4 && (('n' == this.e[this.o] || 'N' == this.e[this.o]) && (('u' == this.e[this.o + 1] || 'U' == this.e[this.o + 1]) && (('l' == this.e[this.o + 2] || 'L' == this.e[this.o + 2]) && ('l' == this.e[this.o + 3] || 'L' == this.e[this.o + 3]))))) {
            this.n = "null";
            return JsonToken.NULL;
        } else if (this.p == 4 && (('t' == this.e[this.o] || 'T' == this.e[this.o]) && (('r' == this.e[this.o + 1] || 'R' == this.e[this.o + 1]) && (('u' == this.e[this.o + 2] || 'U' == this.e[this.o + 2]) && ('e' == this.e[this.o + 3] || 'E' == this.e[this.o + 3]))))) {
            this.n = "true";
            return JsonToken.BOOLEAN;
        } else if (this.p == 5 && (('f' == this.e[this.o] || 'F' == this.e[this.o]) && (('a' == this.e[this.o + 1] || 'A' == this.e[this.o + 1]) && (('l' == this.e[this.o + 2] || 'L' == this.e[this.o + 2]) && (('s' == this.e[this.o + 3] || 'S' == this.e[this.o + 3]) && ('e' == this.e[this.o + 4] || 'E' == this.e[this.o + 4])))))) {
            this.n = "false";
            return JsonToken.BOOLEAN;
        } else {
            this.n = this.b.a(this.e, this.o, this.p);
            return a(this.e, this.o, this.p);
        }
    }

    private JsonToken a(char[] cArr, int i, int i2) {
        int i3;
        int i4;
        char c;
        char c2 = cArr[i];
        if (c2 == '-') {
            i3 = i + 1;
            c2 = cArr[i3];
        } else {
            i3 = i;
        }
        if (c2 == '0') {
            i4 = i3 + 1;
            c = cArr[i4];
        } else if (c2 >= '1' && c2 <= '9') {
            i4 = i3 + 1;
            c = cArr[i4];
            while (c >= '0' && c <= '9') {
                i4++;
                c = cArr[i4];
            }
        } else {
            return JsonToken.STRING;
        }
        if (c == '.') {
            i4++;
            c = cArr[i4];
            while (c >= '0' && c <= '9') {
                i4++;
                c = cArr[i4];
            }
        }
        char c3 = c;
        int i5 = i4;
        if (c3 == 'e' || c3 == 'E') {
            int i6 = i5 + 1;
            char c4 = cArr[i6];
            if (c4 == '+' || c4 == '-') {
                i6++;
                c4 = cArr[i6];
            }
            if (c4 >= '0' && c4 <= '9') {
                int i7 = i6 + 1;
                i5 = i7;
                char c5 = cArr[i7];
                while (c5 >= '0' && c5 <= '9') {
                    int i8 = i5 + 1;
                    i5 = i8;
                    c5 = cArr[i8];
                }
            } else {
                return JsonToken.STRING;
            }
        }
        if (i5 == i + i2) {
            return JsonToken.NUMBER;
        }
        return JsonToken.STRING;
    }

    private IOException b(String str) {
        throw new MalformedJsonException(str + " at line " + t() + " column " + u());
    }
}
