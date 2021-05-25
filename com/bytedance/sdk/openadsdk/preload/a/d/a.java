package com.bytedance.sdk.openadsdk.preload.a.d;

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
    public final Reader f29867b;

    /* renamed from: i  reason: collision with root package name */
    public long f29874i;
    public int j;
    public String k;
    public int[] l;
    public int m;
    public String[] n;
    public int[] o;

    /* renamed from: c  reason: collision with root package name */
    public boolean f29868c = false;

    /* renamed from: d  reason: collision with root package name */
    public final char[] f29869d = new char[1024];

    /* renamed from: e  reason: collision with root package name */
    public int f29870e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f29871f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f29872g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f29873h = 0;

    /* renamed from: a  reason: collision with root package name */
    public int f29866a = 0;

    static {
        f.f29820a = new f() { // from class: com.bytedance.sdk.openadsdk.preload.a.d.a.1
            @Override // com.bytedance.sdk.openadsdk.preload.a.b.f
            public void a(a aVar) throws IOException {
                if (aVar instanceof e) {
                    ((e) aVar).o();
                    return;
                }
                int i2 = aVar.f29866a;
                if (i2 == 0) {
                    i2 = aVar.r();
                }
                if (i2 == 13) {
                    aVar.f29866a = 9;
                } else if (i2 == 12) {
                    aVar.f29866a = 8;
                } else if (i2 == 14) {
                    aVar.f29866a = 10;
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
            this.f29867b = reader;
            return;
        }
        throw new NullPointerException("in == null");
    }

    private int o() throws IOException {
        int i2;
        String str;
        String str2;
        char c2 = this.f29869d[this.f29870e];
        if (c2 == 't' || c2 == 'T') {
            i2 = 5;
            str = "true";
            str2 = "TRUE";
        } else if (c2 == 'f' || c2 == 'F') {
            i2 = 6;
            str = "false";
            str2 = "FALSE";
        } else if (c2 != 'n' && c2 != 'N') {
            return 0;
        } else {
            i2 = 7;
            str = StringUtil.NULL_STRING;
            str2 = "NULL";
        }
        int length = str.length();
        for (int i3 = 1; i3 < length; i3++) {
            if (this.f29870e + i3 >= this.f29871f && !b(i3 + 1)) {
                return 0;
            }
            char c3 = this.f29869d[this.f29870e + i3];
            if (c3 != str.charAt(i3) && c3 != str2.charAt(i3)) {
                return 0;
            }
        }
        if ((this.f29870e + length < this.f29871f || b(length + 1)) && a(this.f29869d[this.f29870e + length])) {
            return 0;
        }
        this.f29870e += length;
        this.f29866a = i2;
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0095, code lost:
        if (a(r14) != false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0097, code lost:
        if (r9 != 2) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0099, code lost:
        if (r10 == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x009f, code lost:
        if (r11 != Long.MIN_VALUE) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00a1, code lost:
        if (r13 == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a7, code lost:
        if (r11 != 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00a9, code lost:
        if (r13 != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00ab, code lost:
        if (r13 == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00ae, code lost:
        r11 = -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00af, code lost:
        r18.f29874i = r11;
        r18.f29870e += r8;
        r18.f29866a = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00ba, code lost:
        return 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00bb, code lost:
        if (r9 == 2) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00be, code lost:
        if (r9 == 4) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00c1, code lost:
        if (r9 != 7) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00c4, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00c6, code lost:
        r18.j = r8;
        r18.f29866a = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00cc, code lost:
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00cd, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int t() throws IOException {
        char[] cArr = this.f29869d;
        int i2 = this.f29870e;
        int i3 = this.f29871f;
        int i4 = 0;
        int i5 = 0;
        char c2 = 0;
        boolean z = true;
        long j = 0;
        boolean z2 = false;
        while (true) {
            if (i2 + i5 == i3) {
                if (i5 == cArr.length) {
                    return i4;
                }
                if (!b(i5 + 1)) {
                    break;
                }
                i2 = this.f29870e;
                i3 = this.f29871f;
            }
            char c3 = cArr[i2 + i5];
            if (c3 != '+') {
                if (c3 == 'E' || c3 == 'e') {
                    i4 = 0;
                    if (c2 != 2 && c2 != 4) {
                        return 0;
                    }
                    c2 = 5;
                } else if (c3 == '-') {
                    i4 = 0;
                    if (c2 == 0) {
                        c2 = 1;
                        z2 = true;
                    } else if (c2 != 5) {
                        return 0;
                    }
                } else if (c3 == '.') {
                    i4 = 0;
                    if (c2 != 2) {
                        return 0;
                    }
                    c2 = 3;
                } else if (c3 < '0' || c3 > '9') {
                    break;
                } else if (c2 == 1 || c2 == 0) {
                    j = -(c3 - '0');
                    i4 = 0;
                    c2 = 2;
                } else {
                    if (c2 == 2) {
                        if (j == 0) {
                            return 0;
                        }
                        long j2 = (10 * j) - (c3 - '0');
                        int i6 = (j > (-922337203685477580L) ? 1 : (j == (-922337203685477580L) ? 0 : -1));
                        z &= i6 > 0 || (i6 == 0 && j2 < j);
                        j = j2;
                    } else if (c2 == 3) {
                        i4 = 0;
                        c2 = 4;
                    } else if (c2 == 5 || c2 == 6) {
                        i4 = 0;
                        c2 = 7;
                    }
                    i4 = 0;
                }
                i5++;
            } else {
                i4 = 0;
                if (c2 != 5) {
                    return 0;
                }
            }
            c2 = 6;
            i5++;
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
        int i2 = 0;
        StringBuilder sb2 = null;
        do {
            int i3 = 0;
            while (true) {
                int i4 = this.f29870e;
                if (i4 + i3 < this.f29871f) {
                    char c2 = this.f29869d[i4 + i3];
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
                                                    i3++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else if (i3 < this.f29869d.length) {
                    if (b(i3 + 1)) {
                    }
                } else {
                    if (sb2 == null) {
                        sb2 = new StringBuilder(Math.max(i3, 16));
                    }
                    sb2.append(this.f29869d, this.f29870e, i3);
                    this.f29870e += i3;
                }
            }
            i2 = i3;
            if (sb2 != null) {
                sb = new String(this.f29869d, this.f29870e, i2);
            } else {
                sb2.append(this.f29869d, this.f29870e, i2);
                sb = sb2.toString();
            }
            this.f29870e += i2;
            return sb;
        } while (b(1));
        if (sb2 != null) {
        }
        this.f29870e += i2;
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
            int i2 = 0;
            while (true) {
                int i3 = this.f29870e;
                if (i3 + i2 < this.f29871f) {
                    char c2 = this.f29869d[i3 + i2];
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
                } else {
                    this.f29870e = i3 + i2;
                }
            }
            this.f29870e += i2;
            return;
        } while (b(1));
    }

    private void w() throws IOException {
        if (!this.f29868c) {
            throw b("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void x() throws IOException {
        char c2;
        do {
            if (this.f29870e >= this.f29871f && !b(1)) {
                return;
            }
            char[] cArr = this.f29869d;
            int i2 = this.f29870e;
            int i3 = i2 + 1;
            this.f29870e = i3;
            c2 = cArr[i2];
            if (c2 == '\n') {
                this.f29872g++;
                this.f29873h = i3;
                return;
            }
        } while (c2 != '\r');
    }

    private char y() throws IOException {
        int i2;
        int i3;
        if (this.f29870e == this.f29871f && !b(1)) {
            throw b("Unterminated escape sequence");
        }
        char[] cArr = this.f29869d;
        int i4 = this.f29870e;
        int i5 = i4 + 1;
        this.f29870e = i5;
        char c2 = cArr[i4];
        if (c2 == '\n') {
            this.f29872g++;
            this.f29873h = i5;
        } else if (c2 != '\"' && c2 != '\'' && c2 != '/' && c2 != '\\') {
            if (c2 != 'b') {
                if (c2 != 'f') {
                    if (c2 != 'n') {
                        if (c2 != 'r') {
                            if (c2 != 't') {
                                if (c2 == 'u') {
                                    if (i5 + 4 > this.f29871f && !b(4)) {
                                        throw b("Unterminated escape sequence");
                                    }
                                    char c3 = 0;
                                    int i6 = this.f29870e;
                                    int i7 = i6 + 4;
                                    while (i6 < i7) {
                                        char c4 = this.f29869d[i6];
                                        char c5 = (char) (c3 << 4);
                                        if (c4 < '0' || c4 > '9') {
                                            if (c4 >= 'a' && c4 <= 'f') {
                                                i2 = c4 - 'a';
                                            } else if (c4 < 'A' || c4 > 'F') {
                                                throw new NumberFormatException("\\u" + new String(this.f29869d, this.f29870e, 4));
                                            } else {
                                                i2 = c4 - 'A';
                                            }
                                            i3 = i2 + 10;
                                        } else {
                                            i3 = c4 - '0';
                                        }
                                        c3 = (char) (c5 + i3);
                                        i6++;
                                    }
                                    this.f29870e += 4;
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
        int i2 = this.f29870e - 1;
        this.f29870e = i2;
        if (i2 + 5 <= this.f29871f || b(5)) {
            char[] cArr = this.f29869d;
            if (cArr[i2] == ')' && cArr[i2 + 1] == ']' && cArr[i2 + 2] == '}' && cArr[i2 + 3] == '\'' && cArr[i2 + 4] == '\n') {
                this.f29870e += 5;
            }
        }
    }

    public final void a(boolean z) {
        this.f29868c = z;
    }

    public void b() throws IOException {
        int i2 = this.f29866a;
        if (i2 == 0) {
            i2 = r();
        }
        if (i2 == 4) {
            int i3 = this.m - 1;
            this.m = i3;
            int[] iArr = this.o;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
            this.f29866a = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + f() + s());
    }

    public void c() throws IOException {
        int i2 = this.f29866a;
        if (i2 == 0) {
            i2 = r();
        }
        if (i2 == 1) {
            a(3);
            this.f29866a = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + f() + s());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f29866a = 0;
        this.l[0] = 8;
        this.m = 1;
        this.f29867b.close();
    }

    public void d() throws IOException {
        int i2 = this.f29866a;
        if (i2 == 0) {
            i2 = r();
        }
        if (i2 == 2) {
            int i3 = this.m - 1;
            this.m = i3;
            this.n[i3] = null;
            int[] iArr = this.o;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
            this.f29866a = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + f() + s());
    }

    public boolean e() throws IOException {
        int i2 = this.f29866a;
        if (i2 == 0) {
            i2 = r();
        }
        return (i2 == 2 || i2 == 4) ? false : true;
    }

    public b f() throws IOException {
        int i2 = this.f29866a;
        if (i2 == 0) {
            i2 = r();
        }
        switch (i2) {
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
        int i2 = this.f29866a;
        if (i2 == 0) {
            i2 = r();
        }
        if (i2 == 14) {
            b2 = u();
        } else if (i2 == 12) {
            b2 = b('\'');
        } else if (i2 == 13) {
            b2 = b(Typography.quote);
        } else {
            throw new IllegalStateException("Expected a name but was " + f() + s());
        }
        this.f29866a = 0;
        this.n[this.m - 1] = b2;
        return b2;
    }

    public String h() throws IOException {
        String str;
        int i2 = this.f29866a;
        if (i2 == 0) {
            i2 = r();
        }
        if (i2 == 10) {
            str = u();
        } else if (i2 == 8) {
            str = b('\'');
        } else if (i2 == 9) {
            str = b(Typography.quote);
        } else if (i2 == 11) {
            str = this.k;
            this.k = null;
        } else if (i2 == 15) {
            str = Long.toString(this.f29874i);
        } else if (i2 == 16) {
            str = new String(this.f29869d, this.f29870e, this.j);
            this.f29870e += this.j;
        } else {
            throw new IllegalStateException("Expected a string but was " + f() + s());
        }
        this.f29866a = 0;
        int[] iArr = this.o;
        int i3 = this.m - 1;
        iArr[i3] = iArr[i3] + 1;
        return str;
    }

    public boolean i() throws IOException {
        int i2 = this.f29866a;
        if (i2 == 0) {
            i2 = r();
        }
        if (i2 == 5) {
            this.f29866a = 0;
            int[] iArr = this.o;
            int i3 = this.m - 1;
            iArr[i3] = iArr[i3] + 1;
            return true;
        } else if (i2 == 6) {
            this.f29866a = 0;
            int[] iArr2 = this.o;
            int i4 = this.m - 1;
            iArr2[i4] = iArr2[i4] + 1;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + f() + s());
        }
    }

    public void j() throws IOException {
        int i2 = this.f29866a;
        if (i2 == 0) {
            i2 = r();
        }
        if (i2 == 7) {
            this.f29866a = 0;
            int[] iArr = this.o;
            int i3 = this.m - 1;
            iArr[i3] = iArr[i3] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + f() + s());
    }

    public double k() throws IOException {
        int i2 = this.f29866a;
        if (i2 == 0) {
            i2 = r();
        }
        if (i2 == 15) {
            this.f29866a = 0;
            int[] iArr = this.o;
            int i3 = this.m - 1;
            iArr[i3] = iArr[i3] + 1;
            return this.f29874i;
        }
        if (i2 == 16) {
            this.k = new String(this.f29869d, this.f29870e, this.j);
            this.f29870e += this.j;
        } else if (i2 == 8 || i2 == 9) {
            this.k = b(i2 == 8 ? '\'' : Typography.quote);
        } else if (i2 == 10) {
            this.k = u();
        } else if (i2 != 11) {
            throw new IllegalStateException("Expected a double but was " + f() + s());
        }
        this.f29866a = 11;
        double parseDouble = Double.parseDouble(this.k);
        if (!this.f29868c && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            throw new d("JSON forbids NaN and infinities: " + parseDouble + s());
        }
        this.k = null;
        this.f29866a = 0;
        int[] iArr2 = this.o;
        int i4 = this.m - 1;
        iArr2[i4] = iArr2[i4] + 1;
        return parseDouble;
    }

    public long l() throws IOException {
        int i2 = this.f29866a;
        if (i2 == 0) {
            i2 = r();
        }
        if (i2 == 15) {
            this.f29866a = 0;
            int[] iArr = this.o;
            int i3 = this.m - 1;
            iArr[i3] = iArr[i3] + 1;
            return this.f29874i;
        }
        if (i2 == 16) {
            this.k = new String(this.f29869d, this.f29870e, this.j);
            this.f29870e += this.j;
        } else if (i2 != 8 && i2 != 9 && i2 != 10) {
            throw new IllegalStateException("Expected a long but was " + f() + s());
        } else {
            if (i2 == 10) {
                this.k = u();
            } else {
                this.k = b(i2 == 8 ? '\'' : Typography.quote);
            }
            try {
                long parseLong = Long.parseLong(this.k);
                this.f29866a = 0;
                int[] iArr2 = this.o;
                int i4 = this.m - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        this.f29866a = 11;
        double parseDouble = Double.parseDouble(this.k);
        long j = (long) parseDouble;
        if (j == parseDouble) {
            this.k = null;
            this.f29866a = 0;
            int[] iArr3 = this.o;
            int i5 = this.m - 1;
            iArr3[i5] = iArr3[i5] + 1;
            return j;
        }
        throw new NumberFormatException("Expected a long but was " + this.k + s());
    }

    public int m() throws IOException {
        int i2 = this.f29866a;
        if (i2 == 0) {
            i2 = r();
        }
        if (i2 == 15) {
            long j = this.f29874i;
            int i3 = (int) j;
            if (j == i3) {
                this.f29866a = 0;
                int[] iArr = this.o;
                int i4 = this.m - 1;
                iArr[i4] = iArr[i4] + 1;
                return i3;
            }
            throw new NumberFormatException("Expected an int but was " + this.f29874i + s());
        }
        if (i2 == 16) {
            this.k = new String(this.f29869d, this.f29870e, this.j);
            this.f29870e += this.j;
        } else if (i2 != 8 && i2 != 9 && i2 != 10) {
            throw new IllegalStateException("Expected an int but was " + f() + s());
        } else {
            if (i2 == 10) {
                this.k = u();
            } else {
                this.k = b(i2 == 8 ? '\'' : Typography.quote);
            }
            try {
                int parseInt = Integer.parseInt(this.k);
                this.f29866a = 0;
                int[] iArr2 = this.o;
                int i5 = this.m - 1;
                iArr2[i5] = iArr2[i5] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }
        this.f29866a = 11;
        double parseDouble = Double.parseDouble(this.k);
        int i6 = (int) parseDouble;
        if (i6 == parseDouble) {
            this.k = null;
            this.f29866a = 0;
            int[] iArr3 = this.o;
            int i7 = this.m - 1;
            iArr3[i7] = iArr3[i7] + 1;
            return i6;
        }
        throw new NumberFormatException("Expected an int but was " + this.k + s());
    }

    public void n() throws IOException {
        int i2 = 0;
        do {
            int i3 = this.f29866a;
            if (i3 == 0) {
                i3 = r();
            }
            if (i3 == 3) {
                a(1);
            } else if (i3 == 1) {
                a(3);
            } else {
                if (i3 == 4) {
                    this.m--;
                } else if (i3 == 2) {
                    this.m--;
                } else {
                    if (i3 == 14 || i3 == 10) {
                        v();
                    } else if (i3 == 8 || i3 == 12) {
                        c('\'');
                    } else if (i3 == 9 || i3 == 13) {
                        c(Typography.quote);
                    } else if (i3 == 16) {
                        this.f29870e += this.j;
                    }
                    this.f29866a = 0;
                }
                i2--;
                this.f29866a = 0;
            }
            i2++;
            this.f29866a = 0;
        } while (i2 != 0);
        int[] iArr = this.o;
        int i4 = this.m;
        int i5 = i4 - 1;
        iArr[i5] = iArr[i5] + 1;
        this.n[i4 - 1] = StringUtil.NULL_STRING;
    }

    public String p() {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i2 = this.m;
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = this.l[i3];
            if (i4 == 1 || i4 == 2) {
                sb.append('[');
                sb.append(this.o[i3]);
                sb.append(']');
            } else if (i4 == 3 || i4 == 4 || i4 == 5) {
                sb.append(IStringUtil.EXTENSION_SEPARATOR);
                String[] strArr = this.n;
                if (strArr[i3] != null) {
                    sb.append(strArr[i3]);
                }
            }
        }
        return sb.toString();
    }

    public final boolean q() {
        return this.f29868c;
    }

    public int r() throws IOException {
        int b2;
        int[] iArr = this.l;
        int i2 = this.m;
        int i3 = iArr[i2 - 1];
        if (i3 == 1) {
            iArr[i2 - 1] = 2;
        } else if (i3 == 2) {
            int b3 = b(true);
            if (b3 != 44) {
                if (b3 != 59) {
                    if (b3 == 93) {
                        this.f29866a = 4;
                        return 4;
                    }
                    throw b("Unterminated array");
                }
                w();
            }
        } else if (i3 == 3 || i3 == 5) {
            this.l[this.m - 1] = 4;
            if (i3 == 5 && (b2 = b(true)) != 44) {
                if (b2 != 59) {
                    if (b2 == 125) {
                        this.f29866a = 2;
                        return 2;
                    }
                    throw b("Unterminated object");
                }
                w();
            }
            int b4 = b(true);
            if (b4 == 34) {
                this.f29866a = 13;
                return 13;
            } else if (b4 == 39) {
                w();
                this.f29866a = 12;
                return 12;
            } else if (b4 == 125) {
                if (i3 != 5) {
                    this.f29866a = 2;
                    return 2;
                }
                throw b("Expected name");
            } else {
                w();
                this.f29870e--;
                if (a((char) b4)) {
                    this.f29866a = 14;
                    return 14;
                }
                throw b("Expected name");
            }
        } else if (i3 == 4) {
            iArr[i2 - 1] = 5;
            int b5 = b(true);
            if (b5 != 58) {
                if (b5 == 61) {
                    w();
                    if (this.f29870e < this.f29871f || b(1)) {
                        char[] cArr = this.f29869d;
                        int i4 = this.f29870e;
                        if (cArr[i4] == '>') {
                            this.f29870e = i4 + 1;
                        }
                    }
                } else {
                    throw b("Expected ':'");
                }
            }
        } else if (i3 == 6) {
            if (this.f29868c) {
                z();
            }
            this.l[this.m - 1] = 7;
        } else if (i3 == 7) {
            if (b(false) == -1) {
                this.f29866a = 17;
                return 17;
            }
            w();
            this.f29870e--;
        } else if (i3 == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        int b6 = b(true);
        if (b6 == 34) {
            this.f29866a = 9;
            return 9;
        } else if (b6 == 39) {
            w();
            this.f29866a = 8;
            return 8;
        } else {
            if (b6 != 44 && b6 != 59) {
                if (b6 == 91) {
                    this.f29866a = 3;
                    return 3;
                } else if (b6 != 93) {
                    if (b6 != 123) {
                        this.f29870e--;
                        int o = o();
                        if (o != 0) {
                            return o;
                        }
                        int t = t();
                        if (t != 0) {
                            return t;
                        }
                        if (a(this.f29869d[this.f29870e])) {
                            w();
                            this.f29866a = 10;
                            return 10;
                        }
                        throw b("Expected value");
                    }
                    this.f29866a = 1;
                    return 1;
                } else if (i3 == 1) {
                    this.f29866a = 4;
                    return 4;
                }
            }
            if (i3 != 1 && i3 != 2) {
                throw b("Unexpected value");
            }
            w();
            this.f29870e--;
            this.f29866a = 7;
            return 7;
        }
    }

    public String s() {
        return " at line " + (this.f29872g + 1) + " column " + ((this.f29870e - this.f29873h) + 1) + " path " + p();
    }

    public String toString() {
        return getClass().getSimpleName() + s();
    }

    public void a() throws IOException {
        int i2 = this.f29866a;
        if (i2 == 0) {
            i2 = r();
        }
        if (i2 == 3) {
            a(1);
            this.o[this.m - 1] = 0;
            this.f29866a = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + f() + s());
    }

    private void c(char c2) throws IOException {
        char[] cArr = this.f29869d;
        do {
            int i2 = this.f29870e;
            int i3 = this.f29871f;
            while (i2 < i3) {
                int i4 = i2 + 1;
                char c3 = cArr[i2];
                if (c3 == c2) {
                    this.f29870e = i4;
                    return;
                } else if (c3 == '\\') {
                    this.f29870e = i4;
                    y();
                    i2 = this.f29870e;
                    i3 = this.f29871f;
                } else {
                    if (c3 == '\n') {
                        this.f29872g++;
                        this.f29873h = i4;
                    }
                    i2 = i4;
                }
            }
            this.f29870e = i2;
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
        r9.f29870e = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String b(char c2) throws IOException {
        char[] cArr = this.f29869d;
        StringBuilder sb = null;
        do {
            int i2 = this.f29870e;
            int i3 = this.f29871f;
            while (true) {
                int i4 = i3;
                int i5 = i2;
                while (i2 < i4) {
                    int i6 = i2 + 1;
                    char c3 = cArr[i2];
                    if (c3 == c2) {
                        this.f29870e = i6;
                        int i7 = (i6 - i5) - 1;
                        if (sb == null) {
                            return new String(cArr, i5, i7);
                        }
                        sb.append(cArr, i5, i7);
                        return sb.toString();
                    } else if (c3 == '\\') {
                        this.f29870e = i6;
                        int i8 = (i6 - i5) - 1;
                        if (sb == null) {
                            sb = new StringBuilder(Math.max((i8 + 1) * 2, 16));
                        }
                        sb.append(cArr, i5, i8);
                        sb.append(y());
                        i2 = this.f29870e;
                        i3 = this.f29871f;
                    } else {
                        if (c3 == '\n') {
                            this.f29872g++;
                            this.f29873h = i6;
                        }
                        i2 = i6;
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

    private void a(int i2) {
        int i3 = this.m;
        int[] iArr = this.l;
        if (i3 == iArr.length) {
            int i4 = i3 * 2;
            this.l = Arrays.copyOf(iArr, i4);
            this.o = Arrays.copyOf(this.o, i4);
            this.n = (String[]) Arrays.copyOf(this.n, i4);
        }
        int[] iArr2 = this.l;
        int i5 = this.m;
        this.m = i5 + 1;
        iArr2[i5] = i2;
    }

    private boolean a(String str) throws IOException {
        int length = str.length();
        while (true) {
            if (this.f29870e + length > this.f29871f && !b(length)) {
                return false;
            }
            char[] cArr = this.f29869d;
            int i2 = this.f29870e;
            if (cArr[i2] != '\n') {
                for (int i3 = 0; i3 < length; i3++) {
                    if (this.f29869d[this.f29870e + i3] != str.charAt(i3)) {
                        break;
                    }
                }
                return true;
            }
            this.f29872g++;
            this.f29873h = i2 + 1;
            this.f29870e++;
        }
    }

    private boolean b(int i2) throws IOException {
        int i3;
        char[] cArr = this.f29869d;
        int i4 = this.f29873h;
        int i5 = this.f29870e;
        this.f29873h = i4 - i5;
        int i6 = this.f29871f;
        if (i6 != i5) {
            int i7 = i6 - i5;
            this.f29871f = i7;
            System.arraycopy(cArr, i5, cArr, 0, i7);
        } else {
            this.f29871f = 0;
        }
        this.f29870e = 0;
        do {
            Reader reader = this.f29867b;
            int i8 = this.f29871f;
            int read = reader.read(cArr, i8, cArr.length - i8);
            if (read == -1) {
                return false;
            }
            int i9 = this.f29871f + read;
            this.f29871f = i9;
            if (this.f29872g == 0 && (i3 = this.f29873h) == 0 && i9 > 0 && cArr[0] == 65279) {
                this.f29870e++;
                this.f29873h = i3 + 1;
                i2++;
            }
        } while (this.f29871f < i2);
        return true;
    }

    private int b(boolean z) throws IOException {
        char[] cArr = this.f29869d;
        int i2 = this.f29870e;
        int i3 = this.f29871f;
        while (true) {
            if (i2 == i3) {
                this.f29870e = i2;
                if (!b(1)) {
                    if (z) {
                        throw new EOFException("End of input" + s());
                    }
                    return -1;
                }
                i2 = this.f29870e;
                i3 = this.f29871f;
            }
            int i4 = i2 + 1;
            char c2 = cArr[i2];
            if (c2 == '\n') {
                this.f29872g++;
                this.f29873h = i4;
            } else if (c2 != ' ' && c2 != '\r' && c2 != '\t') {
                if (c2 == '/') {
                    this.f29870e = i4;
                    if (i4 == i3) {
                        this.f29870e = i4 - 1;
                        boolean b2 = b(2);
                        this.f29870e++;
                        if (!b2) {
                            return c2;
                        }
                    }
                    w();
                    int i5 = this.f29870e;
                    char c3 = cArr[i5];
                    if (c3 == '*') {
                        this.f29870e = i5 + 1;
                        if (a("*/")) {
                            i2 = this.f29870e + 2;
                            i3 = this.f29871f;
                        } else {
                            throw b("Unterminated comment");
                        }
                    } else if (c3 != '/') {
                        return c2;
                    } else {
                        this.f29870e = i5 + 1;
                        x();
                        i2 = this.f29870e;
                        i3 = this.f29871f;
                    }
                } else if (c2 == '#') {
                    this.f29870e = i4;
                    w();
                    x();
                    i2 = this.f29870e;
                    i3 = this.f29871f;
                } else {
                    this.f29870e = i4;
                    return c2;
                }
            }
            i2 = i4;
        }
    }

    private IOException b(String str) throws IOException {
        throw new d(str + s());
    }
}
