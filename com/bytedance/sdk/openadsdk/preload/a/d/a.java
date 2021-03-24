package com.bytedance.sdk.openadsdk.preload.a.d;

import com.alibaba.fastjson.parser.JSONLexerBase;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.common.others.lang.StringUtil;
import com.bytedance.sdk.openadsdk.preload.a.b.a.e;
import com.bytedance.sdk.openadsdk.preload.a.b.f;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import kotlin.text.Typography;
/* loaded from: classes6.dex */
public class a implements Closeable {

    /* renamed from: b  reason: collision with root package name */
    public final Reader f30091b;
    public long i;
    public int j;
    public String k;
    public int[] l;
    public int m;
    public String[] n;
    public int[] o;

    /* renamed from: c  reason: collision with root package name */
    public boolean f30092c = false;

    /* renamed from: d  reason: collision with root package name */
    public final char[] f30093d = new char[1024];

    /* renamed from: e  reason: collision with root package name */
    public int f30094e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f30095f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f30096g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f30097h = 0;

    /* renamed from: a  reason: collision with root package name */
    public int f30090a = 0;

    static {
        f.f30045a = new f() { // from class: com.bytedance.sdk.openadsdk.preload.a.d.a.1
            @Override // com.bytedance.sdk.openadsdk.preload.a.b.f
            public void a(a aVar) throws IOException {
                if (aVar instanceof e) {
                    ((e) aVar).o();
                    return;
                }
                int i = aVar.f30090a;
                if (i == 0) {
                    i = aVar.r();
                }
                if (i == 13) {
                    aVar.f30090a = 9;
                } else if (i == 12) {
                    aVar.f30090a = 8;
                } else if (i == 14) {
                    aVar.f30090a = 10;
                } else {
                    throw new IllegalStateException("Expected a name but was " + aVar.f() + aVar.s());
                }
            }
        };
    }

    public a(Reader reader) {
        int[] iArr = new int[32];
        this.l = iArr;
        this.m = 0;
        this.m = 0 + 1;
        iArr[0] = 6;
        this.n = new String[32];
        this.o = new int[32];
        if (reader != null) {
            this.f30091b = reader;
            return;
        }
        throw new NullPointerException("in == null");
    }

    private int o() throws IOException {
        int i;
        String str;
        String str2;
        char c2 = this.f30093d[this.f30094e];
        if (c2 == 't' || c2 == 'T') {
            i = 5;
            str = "true";
            str2 = "TRUE";
        } else if (c2 == 'f' || c2 == 'F') {
            i = 6;
            str = "false";
            str2 = "FALSE";
        } else if (c2 != 'n' && c2 != 'N') {
            return 0;
        } else {
            i = 7;
            str = StringUtil.NULL_STRING;
            str2 = "NULL";
        }
        int length = str.length();
        for (int i2 = 1; i2 < length; i2++) {
            if (this.f30094e + i2 >= this.f30095f && !b(i2 + 1)) {
                return 0;
            }
            char c3 = this.f30093d[this.f30094e + i2];
            if (c3 != str.charAt(i2) && c3 != str2.charAt(i2)) {
                return 0;
            }
        }
        if ((this.f30094e + length < this.f30095f || b(length + 1)) && a(this.f30093d[this.f30094e + length])) {
            return 0;
        }
        this.f30094e += length;
        this.f30090a = i;
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x0097, code lost:
        if (a(r14) != false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0099, code lost:
        if (r9 != 2) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x009b, code lost:
        if (r10 == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00a1, code lost:
        if (r11 != Long.MIN_VALUE) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00a3, code lost:
        if (r13 == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00a9, code lost:
        if (r11 != 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00ab, code lost:
        if (r13 != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00ad, code lost:
        if (r13 == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00b0, code lost:
        r11 = -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00b1, code lost:
        r18.i = r11;
        r18.f30094e += r8;
        r18.f30090a = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00bc, code lost:
        return 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00bd, code lost:
        if (r9 == 2) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00c0, code lost:
        if (r9 == 4) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00c3, code lost:
        if (r9 != 7) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00c6, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00c8, code lost:
        r18.j = r8;
        r18.f30090a = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00ce, code lost:
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x00cf, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int t() throws IOException {
        char[] cArr = this.f30093d;
        int i = this.f30094e;
        int i2 = this.f30095f;
        int i3 = 0;
        int i4 = 0;
        char c2 = 0;
        boolean z = true;
        long j = 0;
        boolean z2 = false;
        while (true) {
            if (i + i4 == i2) {
                if (i4 == cArr.length) {
                    return i3;
                }
                if (!b(i4 + 1)) {
                    break;
                }
                i = this.f30094e;
                i2 = this.f30095f;
            }
            char c3 = cArr[i + i4];
            if (c3 != '+') {
                if (c3 == 'E' || c3 == 'e') {
                    i3 = 0;
                    if (c2 != 2 && c2 != 4) {
                        return 0;
                    }
                    c2 = 5;
                } else if (c3 == '-') {
                    i3 = 0;
                    if (c2 == 0) {
                        c2 = 1;
                        z2 = true;
                    } else if (c2 != 5) {
                        return 0;
                    }
                } else if (c3 == '.') {
                    i3 = 0;
                    if (c2 != 2) {
                        return 0;
                    }
                    c2 = 3;
                } else if (c3 < '0' || c3 > '9') {
                    break;
                } else if (c2 == 1 || c2 == 0) {
                    j = -(c3 - '0');
                    i3 = 0;
                    c2 = 2;
                } else {
                    if (c2 == 2) {
                        if (j == 0) {
                            return 0;
                        }
                        long j2 = (10 * j) - (c3 - '0');
                        z &= j > JSONLexerBase.MULTMIN_RADIX_TEN || (j == JSONLexerBase.MULTMIN_RADIX_TEN && j2 < j);
                        j = j2;
                    } else if (c2 == 3) {
                        i3 = 0;
                        c2 = 4;
                    } else if (c2 == 5 || c2 == 6) {
                        i3 = 0;
                        c2 = 7;
                    }
                    i3 = 0;
                }
                i4++;
            } else {
                i3 = 0;
                if (c2 != 5) {
                    return 0;
                }
            }
            c2 = 6;
            i4++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x004a, code lost:
        w();
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String u() throws IOException {
        String sb;
        int i = 0;
        StringBuilder sb2 = null;
        do {
            int i2 = 0;
            while (true) {
                int i3 = this.f30094e;
                if (i3 + i2 < this.f30095f) {
                    char c2 = this.f30093d[i3 + i2];
                    if (c2 != '\t' && c2 != '\n' && c2 != '\f' && c2 != '\r' && c2 != ' ') {
                        if (c2 != '#') {
                            if (c2 != ',') {
                                if (c2 != '/' && c2 != '=') {
                                    if (c2 != '{' && c2 != '}' && c2 != ':') {
                                        if (c2 != ';') {
                                            switch (c2) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i2++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else if (i2 < this.f30093d.length) {
                    if (b(i2 + 1)) {
                    }
                } else {
                    if (sb2 == null) {
                        sb2 = new StringBuilder(Math.max(i2, 16));
                    }
                    sb2.append(this.f30093d, this.f30094e, i2);
                    this.f30094e += i2;
                }
            }
            i = i2;
            if (sb2 != null) {
                sb = new String(this.f30093d, this.f30094e, i);
            } else {
                sb2.append(this.f30093d, this.f30094e, i);
                sb = sb2.toString();
            }
            this.f30094e += i;
            return sb;
        } while (b(1));
        if (sb2 != null) {
        }
        this.f30094e += i;
        return sb;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0048, code lost:
        w();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void v() throws IOException {
        do {
            int i = 0;
            while (true) {
                int i2 = this.f30094e;
                if (i2 + i < this.f30095f) {
                    char c2 = this.f30093d[i2 + i];
                    if (c2 != '\t' && c2 != '\n' && c2 != '\f' && c2 != '\r' && c2 != ' ') {
                        if (c2 != '#') {
                            if (c2 != ',') {
                                if (c2 != '/' && c2 != '=') {
                                    if (c2 != '{' && c2 != '}' && c2 != ':') {
                                        if (c2 != ';') {
                                            switch (c2) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    this.f30094e = i2 + i;
                }
            }
            this.f30094e += i;
            return;
        } while (b(1));
    }

    private void w() throws IOException {
        if (!this.f30092c) {
            throw b("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void x() throws IOException {
        char c2;
        do {
            if (this.f30094e >= this.f30095f && !b(1)) {
                return;
            }
            char[] cArr = this.f30093d;
            int i = this.f30094e;
            int i2 = i + 1;
            this.f30094e = i2;
            c2 = cArr[i];
            if (c2 == '\n') {
                this.f30096g++;
                this.f30097h = i2;
                return;
            }
        } while (c2 != '\r');
    }

    private char y() throws IOException {
        int i;
        int i2;
        if (this.f30094e == this.f30095f && !b(1)) {
            throw b("Unterminated escape sequence");
        }
        char[] cArr = this.f30093d;
        int i3 = this.f30094e;
        int i4 = i3 + 1;
        this.f30094e = i4;
        char c2 = cArr[i3];
        if (c2 == '\n') {
            this.f30096g++;
            this.f30097h = i4;
        } else if (c2 != '\"' && c2 != '\'' && c2 != '/' && c2 != '\\') {
            if (c2 != 'b') {
                if (c2 != 'f') {
                    if (c2 != 'n') {
                        if (c2 != 'r') {
                            if (c2 != 't') {
                                if (c2 == 'u') {
                                    if (i4 + 4 > this.f30095f && !b(4)) {
                                        throw b("Unterminated escape sequence");
                                    }
                                    char c3 = 0;
                                    int i5 = this.f30094e;
                                    int i6 = i5 + 4;
                                    while (i5 < i6) {
                                        char c4 = this.f30093d[i5];
                                        char c5 = (char) (c3 << 4);
                                        if (c4 < '0' || c4 > '9') {
                                            if (c4 >= 'a' && c4 <= 'f') {
                                                i = c4 - 'a';
                                            } else if (c4 < 'A' || c4 > 'F') {
                                                throw new NumberFormatException("\\u" + new String(this.f30093d, this.f30094e, 4));
                                            } else {
                                                i = c4 - 'A';
                                            }
                                            i2 = i + 10;
                                        } else {
                                            i2 = c4 - '0';
                                        }
                                        c3 = (char) (c5 + i2);
                                        i5++;
                                    }
                                    this.f30094e += 4;
                                    return c3;
                                }
                                throw b("Invalid escape sequence");
                            }
                            return '\t';
                        }
                        return '\r';
                    }
                    return '\n';
                }
                return '\f';
            }
            return '\b';
        }
        return c2;
    }

    private void z() throws IOException {
        b(true);
        int i = this.f30094e - 1;
        this.f30094e = i;
        if (i + 5 <= this.f30095f || b(5)) {
            char[] cArr = this.f30093d;
            if (cArr[i] == ')' && cArr[i + 1] == ']' && cArr[i + 2] == '}' && cArr[i + 3] == '\'' && cArr[i + 4] == '\n') {
                this.f30094e += 5;
            }
        }
    }

    public final void a(boolean z) {
        this.f30092c = z;
    }

    public void b() throws IOException {
        int i = this.f30090a;
        if (i == 0) {
            i = r();
        }
        if (i == 4) {
            int i2 = this.m - 1;
            this.m = i2;
            int[] iArr = this.o;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
            this.f30090a = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + f() + s());
    }

    public void c() throws IOException {
        int i = this.f30090a;
        if (i == 0) {
            i = r();
        }
        if (i == 1) {
            a(3);
            this.f30090a = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + f() + s());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f30090a = 0;
        this.l[0] = 8;
        this.m = 1;
        this.f30091b.close();
    }

    public void d() throws IOException {
        int i = this.f30090a;
        if (i == 0) {
            i = r();
        }
        if (i == 2) {
            int i2 = this.m - 1;
            this.m = i2;
            this.n[i2] = null;
            int[] iArr = this.o;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
            this.f30090a = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + f() + s());
    }

    public boolean e() throws IOException {
        int i = this.f30090a;
        if (i == 0) {
            i = r();
        }
        return (i == 2 || i == 4) ? false : true;
    }

    public b f() throws IOException {
        int i = this.f30090a;
        if (i == 0) {
            i = r();
        }
        switch (i) {
            case 1:
                return b.BEGIN_OBJECT;
            case 2:
                return b.END_OBJECT;
            case 3:
                return b.BEGIN_ARRAY;
            case 4:
                return b.END_ARRAY;
            case 5:
            case 6:
                return b.BOOLEAN;
            case 7:
                return b.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return b.STRING;
            case 12:
            case 13:
            case 14:
                return b.NAME;
            case 15:
            case 16:
                return b.NUMBER;
            case 17:
                return b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public String g() throws IOException {
        String b2;
        int i = this.f30090a;
        if (i == 0) {
            i = r();
        }
        if (i == 14) {
            b2 = u();
        } else if (i == 12) {
            b2 = b('\'');
        } else if (i == 13) {
            b2 = b(Typography.quote);
        } else {
            throw new IllegalStateException("Expected a name but was " + f() + s());
        }
        this.f30090a = 0;
        this.n[this.m - 1] = b2;
        return b2;
    }

    public String h() throws IOException {
        String str;
        int i = this.f30090a;
        if (i == 0) {
            i = r();
        }
        if (i == 10) {
            str = u();
        } else if (i == 8) {
            str = b('\'');
        } else if (i == 9) {
            str = b(Typography.quote);
        } else if (i == 11) {
            str = this.k;
            this.k = null;
        } else if (i == 15) {
            str = Long.toString(this.i);
        } else if (i == 16) {
            str = new String(this.f30093d, this.f30094e, this.j);
            this.f30094e += this.j;
        } else {
            throw new IllegalStateException("Expected a string but was " + f() + s());
        }
        this.f30090a = 0;
        int[] iArr = this.o;
        int i2 = this.m - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    public boolean i() throws IOException {
        int i = this.f30090a;
        if (i == 0) {
            i = r();
        }
        if (i == 5) {
            this.f30090a = 0;
            int[] iArr = this.o;
            int i2 = this.m - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        } else if (i == 6) {
            this.f30090a = 0;
            int[] iArr2 = this.o;
            int i3 = this.m - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + f() + s());
        }
    }

    public void j() throws IOException {
        int i = this.f30090a;
        if (i == 0) {
            i = r();
        }
        if (i == 7) {
            this.f30090a = 0;
            int[] iArr = this.o;
            int i2 = this.m - 1;
            iArr[i2] = iArr[i2] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + f() + s());
    }

    public double k() throws IOException {
        int i = this.f30090a;
        if (i == 0) {
            i = r();
        }
        if (i == 15) {
            this.f30090a = 0;
            int[] iArr = this.o;
            int i2 = this.m - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.i;
        }
        if (i == 16) {
            this.k = new String(this.f30093d, this.f30094e, this.j);
            this.f30094e += this.j;
        } else if (i == 8 || i == 9) {
            this.k = b(i == 8 ? '\'' : Typography.quote);
        } else if (i == 10) {
            this.k = u();
        } else if (i != 11) {
            throw new IllegalStateException("Expected a double but was " + f() + s());
        }
        this.f30090a = 11;
        double parseDouble = Double.parseDouble(this.k);
        if (!this.f30092c && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            throw new d("JSON forbids NaN and infinities: " + parseDouble + s());
        }
        this.k = null;
        this.f30090a = 0;
        int[] iArr2 = this.o;
        int i3 = this.m - 1;
        iArr2[i3] = iArr2[i3] + 1;
        return parseDouble;
    }

    public long l() throws IOException {
        int i = this.f30090a;
        if (i == 0) {
            i = r();
        }
        if (i == 15) {
            this.f30090a = 0;
            int[] iArr = this.o;
            int i2 = this.m - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.i;
        }
        if (i == 16) {
            this.k = new String(this.f30093d, this.f30094e, this.j);
            this.f30094e += this.j;
        } else if (i != 8 && i != 9 && i != 10) {
            throw new IllegalStateException("Expected a long but was " + f() + s());
        } else {
            if (i == 10) {
                this.k = u();
            } else {
                this.k = b(i == 8 ? '\'' : Typography.quote);
            }
            try {
                long parseLong = Long.parseLong(this.k);
                this.f30090a = 0;
                int[] iArr2 = this.o;
                int i3 = this.m - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        this.f30090a = 11;
        double parseDouble = Double.parseDouble(this.k);
        long j = (long) parseDouble;
        if (j == parseDouble) {
            this.k = null;
            this.f30090a = 0;
            int[] iArr3 = this.o;
            int i4 = this.m - 1;
            iArr3[i4] = iArr3[i4] + 1;
            return j;
        }
        throw new NumberFormatException("Expected a long but was " + this.k + s());
    }

    public int m() throws IOException {
        int i = this.f30090a;
        if (i == 0) {
            i = r();
        }
        if (i == 15) {
            long j = this.i;
            int i2 = (int) j;
            if (j == i2) {
                this.f30090a = 0;
                int[] iArr = this.o;
                int i3 = this.m - 1;
                iArr[i3] = iArr[i3] + 1;
                return i2;
            }
            throw new NumberFormatException("Expected an int but was " + this.i + s());
        }
        if (i == 16) {
            this.k = new String(this.f30093d, this.f30094e, this.j);
            this.f30094e += this.j;
        } else if (i != 8 && i != 9 && i != 10) {
            throw new IllegalStateException("Expected an int but was " + f() + s());
        } else {
            if (i == 10) {
                this.k = u();
            } else {
                this.k = b(i == 8 ? '\'' : Typography.quote);
            }
            try {
                int parseInt = Integer.parseInt(this.k);
                this.f30090a = 0;
                int[] iArr2 = this.o;
                int i4 = this.m - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }
        this.f30090a = 11;
        double parseDouble = Double.parseDouble(this.k);
        int i5 = (int) parseDouble;
        if (i5 == parseDouble) {
            this.k = null;
            this.f30090a = 0;
            int[] iArr3 = this.o;
            int i6 = this.m - 1;
            iArr3[i6] = iArr3[i6] + 1;
            return i5;
        }
        throw new NumberFormatException("Expected an int but was " + this.k + s());
    }

    public void n() throws IOException {
        int i = 0;
        do {
            int i2 = this.f30090a;
            if (i2 == 0) {
                i2 = r();
            }
            if (i2 == 3) {
                a(1);
            } else if (i2 == 1) {
                a(3);
            } else {
                if (i2 == 4) {
                    this.m--;
                } else if (i2 == 2) {
                    this.m--;
                } else {
                    if (i2 == 14 || i2 == 10) {
                        v();
                    } else if (i2 == 8 || i2 == 12) {
                        c('\'');
                    } else if (i2 == 9 || i2 == 13) {
                        c(Typography.quote);
                    } else if (i2 == 16) {
                        this.f30094e += this.j;
                    }
                    this.f30090a = 0;
                }
                i--;
                this.f30090a = 0;
            }
            i++;
            this.f30090a = 0;
        } while (i != 0);
        int[] iArr = this.o;
        int i3 = this.m;
        int i4 = i3 - 1;
        iArr[i4] = iArr[i4] + 1;
        this.n[i3 - 1] = StringUtil.NULL_STRING;
    }

    public String p() {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i = this.m;
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.l[i2];
            if (i3 == 1 || i3 == 2) {
                sb.append('[');
                sb.append(this.o[i2]);
                sb.append(']');
            } else if (i3 == 3 || i3 == 4 || i3 == 5) {
                sb.append(IStringUtil.EXTENSION_SEPARATOR);
                String[] strArr = this.n;
                if (strArr[i2] != null) {
                    sb.append(strArr[i2]);
                }
            }
        }
        return sb.toString();
    }

    public final boolean q() {
        return this.f30092c;
    }

    public int r() throws IOException {
        int b2;
        int[] iArr = this.l;
        int i = this.m;
        int i2 = iArr[i - 1];
        if (i2 == 1) {
            iArr[i - 1] = 2;
        } else if (i2 == 2) {
            int b3 = b(true);
            if (b3 != 44) {
                if (b3 != 59) {
                    if (b3 == 93) {
                        this.f30090a = 4;
                        return 4;
                    }
                    throw b("Unterminated array");
                }
                w();
            }
        } else if (i2 == 3 || i2 == 5) {
            this.l[this.m - 1] = 4;
            if (i2 == 5 && (b2 = b(true)) != 44) {
                if (b2 != 59) {
                    if (b2 == 125) {
                        this.f30090a = 2;
                        return 2;
                    }
                    throw b("Unterminated object");
                }
                w();
            }
            int b4 = b(true);
            if (b4 == 34) {
                this.f30090a = 13;
                return 13;
            } else if (b4 == 39) {
                w();
                this.f30090a = 12;
                return 12;
            } else if (b4 == 125) {
                if (i2 != 5) {
                    this.f30090a = 2;
                    return 2;
                }
                throw b("Expected name");
            } else {
                w();
                this.f30094e--;
                if (a((char) b4)) {
                    this.f30090a = 14;
                    return 14;
                }
                throw b("Expected name");
            }
        } else if (i2 == 4) {
            iArr[i - 1] = 5;
            int b5 = b(true);
            if (b5 != 58) {
                if (b5 == 61) {
                    w();
                    if (this.f30094e < this.f30095f || b(1)) {
                        char[] cArr = this.f30093d;
                        int i3 = this.f30094e;
                        if (cArr[i3] == '>') {
                            this.f30094e = i3 + 1;
                        }
                    }
                } else {
                    throw b("Expected ':'");
                }
            }
        } else if (i2 == 6) {
            if (this.f30092c) {
                z();
            }
            this.l[this.m - 1] = 7;
        } else if (i2 == 7) {
            if (b(false) == -1) {
                this.f30090a = 17;
                return 17;
            }
            w();
            this.f30094e--;
        } else if (i2 == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        int b6 = b(true);
        if (b6 == 34) {
            this.f30090a = 9;
            return 9;
        } else if (b6 == 39) {
            w();
            this.f30090a = 8;
            return 8;
        } else {
            if (b6 != 44 && b6 != 59) {
                if (b6 == 91) {
                    this.f30090a = 3;
                    return 3;
                } else if (b6 != 93) {
                    if (b6 != 123) {
                        this.f30094e--;
                        int o = o();
                        if (o != 0) {
                            return o;
                        }
                        int t = t();
                        if (t != 0) {
                            return t;
                        }
                        if (a(this.f30093d[this.f30094e])) {
                            w();
                            this.f30090a = 10;
                            return 10;
                        }
                        throw b("Expected value");
                    }
                    this.f30090a = 1;
                    return 1;
                } else if (i2 == 1) {
                    this.f30090a = 4;
                    return 4;
                }
            }
            if (i2 != 1 && i2 != 2) {
                throw b("Unexpected value");
            }
            w();
            this.f30094e--;
            this.f30090a = 7;
            return 7;
        }
    }

    public String s() {
        return " at line " + (this.f30096g + 1) + " column " + ((this.f30094e - this.f30097h) + 1) + " path " + p();
    }

    public String toString() {
        return getClass().getSimpleName() + s();
    }

    public void a() throws IOException {
        int i = this.f30090a;
        if (i == 0) {
            i = r();
        }
        if (i == 3) {
            a(1);
            this.o[this.m - 1] = 0;
            this.f30090a = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + f() + s());
    }

    private void c(char c2) throws IOException {
        char[] cArr = this.f30093d;
        do {
            int i = this.f30094e;
            int i2 = this.f30095f;
            while (i < i2) {
                int i3 = i + 1;
                char c3 = cArr[i];
                if (c3 == c2) {
                    this.f30094e = i3;
                    return;
                } else if (c3 == '\\') {
                    this.f30094e = i3;
                    y();
                    i = this.f30094e;
                    i2 = this.f30095f;
                } else {
                    if (c3 == '\n') {
                        this.f30096g++;
                        this.f30097h = i3;
                    }
                    i = i3;
                }
            }
            this.f30094e = i;
        } while (b(1));
        throw b("Unterminated string");
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005c, code lost:
        if (r1 != null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005e, code lost:
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r2 - r3) * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006c, code lost:
        r1.append(r0, r3, r2 - r3);
        r9.f30094e = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String b(char c2) throws IOException {
        char[] cArr = this.f30093d;
        StringBuilder sb = null;
        do {
            int i = this.f30094e;
            int i2 = this.f30095f;
            while (true) {
                int i3 = i2;
                int i4 = i;
                while (i < i3) {
                    int i5 = i + 1;
                    char c3 = cArr[i];
                    if (c3 == c2) {
                        this.f30094e = i5;
                        int i6 = (i5 - i4) - 1;
                        if (sb == null) {
                            return new String(cArr, i4, i6);
                        }
                        sb.append(cArr, i4, i6);
                        return sb.toString();
                    } else if (c3 == '\\') {
                        this.f30094e = i5;
                        int i7 = (i5 - i4) - 1;
                        if (sb == null) {
                            sb = new StringBuilder(Math.max((i7 + 1) * 2, 16));
                        }
                        sb.append(cArr, i4, i7);
                        sb.append(y());
                        i = this.f30094e;
                        i2 = this.f30095f;
                    } else {
                        if (c3 == '\n') {
                            this.f30096g++;
                            this.f30097h = i5;
                        }
                        i = i5;
                    }
                }
                break;
            }
        } while (b(1));
        throw b("Unterminated string");
    }

    private boolean a(char c2) throws IOException {
        if (c2 == '\t' || c2 == '\n' || c2 == '\f' || c2 == '\r' || c2 == ' ') {
            return false;
        }
        if (c2 != '#') {
            if (c2 == ',') {
                return false;
            }
            if (c2 != '/' && c2 != '=') {
                if (c2 == '{' || c2 == '}' || c2 == ':') {
                    return false;
                }
                if (c2 != ';') {
                    switch (c2) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        w();
        return false;
    }

    private void a(int i) {
        int i2 = this.m;
        int[] iArr = this.l;
        if (i2 == iArr.length) {
            int i3 = i2 * 2;
            this.l = Arrays.copyOf(iArr, i3);
            this.o = Arrays.copyOf(this.o, i3);
            this.n = (String[]) Arrays.copyOf(this.n, i3);
        }
        int[] iArr2 = this.l;
        int i4 = this.m;
        this.m = i4 + 1;
        iArr2[i4] = i;
    }

    private boolean a(String str) throws IOException {
        int length = str.length();
        while (true) {
            if (this.f30094e + length > this.f30095f && !b(length)) {
                return false;
            }
            char[] cArr = this.f30093d;
            int i = this.f30094e;
            if (cArr[i] != '\n') {
                for (int i2 = 0; i2 < length; i2++) {
                    if (this.f30093d[this.f30094e + i2] != str.charAt(i2)) {
                        break;
                    }
                }
                return true;
            }
            this.f30096g++;
            this.f30097h = i + 1;
            this.f30094e++;
        }
    }

    private boolean b(int i) throws IOException {
        int i2;
        char[] cArr = this.f30093d;
        int i3 = this.f30097h;
        int i4 = this.f30094e;
        this.f30097h = i3 - i4;
        int i5 = this.f30095f;
        if (i5 != i4) {
            int i6 = i5 - i4;
            this.f30095f = i6;
            System.arraycopy(cArr, i4, cArr, 0, i6);
        } else {
            this.f30095f = 0;
        }
        this.f30094e = 0;
        do {
            Reader reader = this.f30091b;
            int i7 = this.f30095f;
            int read = reader.read(cArr, i7, cArr.length - i7);
            if (read == -1) {
                return false;
            }
            int i8 = this.f30095f + read;
            this.f30095f = i8;
            if (this.f30096g == 0 && (i2 = this.f30097h) == 0 && i8 > 0 && cArr[0] == 65279) {
                this.f30094e++;
                this.f30097h = i2 + 1;
                i++;
            }
        } while (this.f30095f < i);
        return true;
    }

    private int b(boolean z) throws IOException {
        char[] cArr = this.f30093d;
        int i = this.f30094e;
        int i2 = this.f30095f;
        while (true) {
            if (i == i2) {
                this.f30094e = i;
                if (!b(1)) {
                    if (z) {
                        throw new EOFException("End of input" + s());
                    }
                    return -1;
                }
                i = this.f30094e;
                i2 = this.f30095f;
            }
            int i3 = i + 1;
            char c2 = cArr[i];
            if (c2 == '\n') {
                this.f30096g++;
                this.f30097h = i3;
            } else if (c2 != ' ' && c2 != '\r' && c2 != '\t') {
                if (c2 == '/') {
                    this.f30094e = i3;
                    if (i3 == i2) {
                        this.f30094e = i3 - 1;
                        boolean b2 = b(2);
                        this.f30094e++;
                        if (!b2) {
                            return c2;
                        }
                    }
                    w();
                    int i4 = this.f30094e;
                    char c3 = cArr[i4];
                    if (c3 == '*') {
                        this.f30094e = i4 + 1;
                        if (a("*/")) {
                            i = this.f30094e + 2;
                            i2 = this.f30095f;
                        } else {
                            throw b("Unterminated comment");
                        }
                    } else if (c3 != '/') {
                        return c2;
                    } else {
                        this.f30094e = i4 + 1;
                        x();
                        i = this.f30094e;
                        i2 = this.f30095f;
                    }
                } else if (c2 == '#') {
                    this.f30094e = i3;
                    w();
                    x();
                    i = this.f30094e;
                    i2 = this.f30095f;
                } else {
                    this.f30094e = i3;
                    return c2;
                }
            }
            i = i3;
        }
    }

    private IOException b(String str) throws IOException {
        throw new d(str + s());
    }
}
