package d.g.c.d;

import com.alibaba.fastjson.parser.JSONLexerBase;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.common.others.lang.StringUtil;
import com.google.gson.Gson;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import d.g.c.b.d;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import kotlin.text.Typography;
/* loaded from: classes6.dex */
public class a implements Closeable {
    public static final char[] t = Gson.JSON_NON_EXECUTABLE_PREFIX.toCharArray();

    /* renamed from: e  reason: collision with root package name */
    public final Reader f66119e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f66120f = false;

    /* renamed from: g  reason: collision with root package name */
    public final char[] f66121g = new char[1024];

    /* renamed from: h  reason: collision with root package name */
    public int f66122h = 0;
    public int i = 0;
    public int j = 0;
    public int k = 0;
    public int l = 0;
    public long m;
    public int n;
    public String o;
    public int[] p;
    public int q;
    public String[] r;
    public int[] s;

    /* renamed from: d.g.c.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1810a extends d {
        @Override // d.g.c.b.d
        public void a(a aVar) throws IOException {
            if (aVar instanceof d.g.c.b.j.a) {
                ((d.g.c.b.j.a) aVar).b0();
                return;
            }
            int i = aVar.l;
            if (i == 0) {
                i = aVar.s();
            }
            if (i == 13) {
                aVar.l = 9;
            } else if (i == 12) {
                aVar.l = 8;
            } else if (i == 14) {
                aVar.l = 10;
            } else {
                throw new IllegalStateException("Expected a name but was " + aVar.M() + aVar.B());
            }
        }
    }

    static {
        d.f66101a = new C1810a();
    }

    public a(Reader reader) {
        int[] iArr = new int[32];
        this.p = iArr;
        this.q = 0;
        this.q = 0 + 1;
        iArr[0] = 6;
        this.r = new String[32];
        this.s = new int[32];
        if (reader != null) {
            this.f66119e = reader;
            return;
        }
        throw new NullPointerException("in == null");
    }

    public final boolean A(char c2) throws IOException {
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
        q();
        return false;
    }

    public String B() {
        return " at line " + (this.j + 1) + " column " + ((this.f66122h - this.k) + 1) + " path " + x();
    }

    public boolean C() throws IOException {
        int i = this.l;
        if (i == 0) {
            i = s();
        }
        if (i == 5) {
            this.l = 0;
            int[] iArr = this.s;
            int i2 = this.q - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        } else if (i == 6) {
            this.l = 0;
            int[] iArr2 = this.s;
            int i3 = this.q - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + M() + B());
        }
    }

    public double D() throws IOException {
        int i = this.l;
        if (i == 0) {
            i = s();
        }
        if (i == 15) {
            this.l = 0;
            int[] iArr = this.s;
            int i2 = this.q - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.m;
        }
        if (i == 16) {
            this.o = new String(this.f66121g, this.f66122h, this.n);
            this.f66122h += this.n;
        } else if (i == 8 || i == 9) {
            this.o = J(i == 8 ? '\'' : Typography.quote);
        } else if (i == 10) {
            this.o = L();
        } else if (i != 11) {
            throw new IllegalStateException("Expected a double but was " + M() + B());
        }
        this.l = 11;
        double parseDouble = Double.parseDouble(this.o);
        if (!this.f66120f && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + parseDouble + B());
        }
        this.o = null;
        this.l = 0;
        int[] iArr2 = this.s;
        int i3 = this.q - 1;
        iArr2[i3] = iArr2[i3] + 1;
        return parseDouble;
    }

    public int E() throws IOException {
        int i = this.l;
        if (i == 0) {
            i = s();
        }
        if (i == 15) {
            long j = this.m;
            int i2 = (int) j;
            if (j == i2) {
                this.l = 0;
                int[] iArr = this.s;
                int i3 = this.q - 1;
                iArr[i3] = iArr[i3] + 1;
                return i2;
            }
            throw new NumberFormatException("Expected an int but was " + this.m + B());
        }
        if (i == 16) {
            this.o = new String(this.f66121g, this.f66122h, this.n);
            this.f66122h += this.n;
        } else if (i != 8 && i != 9 && i != 10) {
            throw new IllegalStateException("Expected an int but was " + M() + B());
        } else {
            if (i == 10) {
                this.o = L();
            } else {
                this.o = J(i == 8 ? '\'' : Typography.quote);
            }
            try {
                int parseInt = Integer.parseInt(this.o);
                this.l = 0;
                int[] iArr2 = this.s;
                int i4 = this.q - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }
        this.l = 11;
        double parseDouble = Double.parseDouble(this.o);
        int i5 = (int) parseDouble;
        if (i5 == parseDouble) {
            this.o = null;
            this.l = 0;
            int[] iArr3 = this.s;
            int i6 = this.q - 1;
            iArr3[i6] = iArr3[i6] + 1;
            return i5;
        }
        throw new NumberFormatException("Expected an int but was " + this.o + B());
    }

    public long F() throws IOException {
        int i = this.l;
        if (i == 0) {
            i = s();
        }
        if (i == 15) {
            this.l = 0;
            int[] iArr = this.s;
            int i2 = this.q - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.m;
        }
        if (i == 16) {
            this.o = new String(this.f66121g, this.f66122h, this.n);
            this.f66122h += this.n;
        } else if (i != 8 && i != 9 && i != 10) {
            throw new IllegalStateException("Expected a long but was " + M() + B());
        } else {
            if (i == 10) {
                this.o = L();
            } else {
                this.o = J(i == 8 ? '\'' : Typography.quote);
            }
            try {
                long parseLong = Long.parseLong(this.o);
                this.l = 0;
                int[] iArr2 = this.s;
                int i3 = this.q - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        this.l = 11;
        double parseDouble = Double.parseDouble(this.o);
        long j = (long) parseDouble;
        if (j == parseDouble) {
            this.o = null;
            this.l = 0;
            int[] iArr3 = this.s;
            int i4 = this.q - 1;
            iArr3[i4] = iArr3[i4] + 1;
            return j;
        }
        throw new NumberFormatException("Expected a long but was " + this.o + B());
    }

    public String G() throws IOException {
        String J;
        int i = this.l;
        if (i == 0) {
            i = s();
        }
        if (i == 14) {
            J = L();
        } else if (i == 12) {
            J = J('\'');
        } else if (i == 13) {
            J = J(Typography.quote);
        } else {
            throw new IllegalStateException("Expected a name but was " + M() + B());
        }
        this.l = 0;
        this.r[this.q - 1] = J;
        return J;
    }

    public final int H(boolean z) throws IOException {
        char[] cArr = this.f66121g;
        int i = this.f66122h;
        int i2 = this.i;
        while (true) {
            if (i == i2) {
                this.f66122h = i;
                if (!w(1)) {
                    if (z) {
                        throw new EOFException("End of input" + B());
                    }
                    return -1;
                }
                i = this.f66122h;
                i2 = this.i;
            }
            int i3 = i + 1;
            char c2 = cArr[i];
            if (c2 == '\n') {
                this.j++;
                this.k = i3;
            } else if (c2 != ' ' && c2 != '\r' && c2 != '\t') {
                if (c2 == '/') {
                    this.f66122h = i3;
                    if (i3 == i2) {
                        this.f66122h = i3 - 1;
                        boolean w = w(2);
                        this.f66122h++;
                        if (!w) {
                            return c2;
                        }
                    }
                    q();
                    int i4 = this.f66122h;
                    char c3 = cArr[i4];
                    if (c3 == '*') {
                        this.f66122h = i4 + 1;
                        if (T("*/")) {
                            i = this.f66122h + 2;
                            i2 = this.i;
                        } else {
                            X("Unterminated comment");
                            throw null;
                        }
                    } else if (c3 != '/') {
                        return c2;
                    } else {
                        this.f66122h = i4 + 1;
                        U();
                        i = this.f66122h;
                        i2 = this.i;
                    }
                } else if (c2 == '#') {
                    this.f66122h = i3;
                    q();
                    U();
                    i = this.f66122h;
                    i2 = this.i;
                } else {
                    this.f66122h = i3;
                    return c2;
                }
            }
            i = i3;
        }
    }

    public void I() throws IOException {
        int i = this.l;
        if (i == 0) {
            i = s();
        }
        if (i == 7) {
            this.l = 0;
            int[] iArr = this.s;
            int i2 = this.q - 1;
            iArr[i2] = iArr[i2] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + M() + B());
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005d, code lost:
        if (r2 != null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005f, code lost:
        r2 = new java.lang.StringBuilder(java.lang.Math.max((r3 - r4) * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006d, code lost:
        r2.append(r0, r4, r3 - r4);
        r10.f66122h = r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String J(char c2) throws IOException {
        char[] cArr = this.f66121g;
        StringBuilder sb = null;
        do {
            int i = this.f66122h;
            int i2 = this.i;
            while (true) {
                int i3 = i2;
                int i4 = i;
                while (i < i3) {
                    int i5 = i + 1;
                    char c3 = cArr[i];
                    if (c3 == c2) {
                        this.f66122h = i5;
                        int i6 = (i5 - i4) - 1;
                        if (sb == null) {
                            return new String(cArr, i4, i6);
                        }
                        sb.append(cArr, i4, i6);
                        return sb.toString();
                    } else if (c3 == '\\') {
                        this.f66122h = i5;
                        int i7 = (i5 - i4) - 1;
                        if (sb == null) {
                            sb = new StringBuilder(Math.max((i7 + 1) * 2, 16));
                        }
                        sb.append(cArr, i4, i7);
                        sb.append(Q());
                        i = this.f66122h;
                        i2 = this.i;
                    } else {
                        if (c3 == '\n') {
                            this.j++;
                            this.k = i5;
                        }
                        i = i5;
                    }
                }
                break;
            }
        } while (w(1));
        X("Unterminated string");
        throw null;
    }

    public String K() throws IOException {
        String str;
        int i = this.l;
        if (i == 0) {
            i = s();
        }
        if (i == 10) {
            str = L();
        } else if (i == 8) {
            str = J('\'');
        } else if (i == 9) {
            str = J(Typography.quote);
        } else if (i == 11) {
            str = this.o;
            this.o = null;
        } else if (i == 15) {
            str = Long.toString(this.m);
        } else if (i == 16) {
            str = new String(this.f66121g, this.f66122h, this.n);
            this.f66122h += this.n;
        } else {
            throw new IllegalStateException("Expected a string but was " + M() + B());
        }
        this.l = 0;
        int[] iArr = this.s;
        int i2 = this.q - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x004a, code lost:
        q();
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String L() throws IOException {
        String sb;
        int i = 0;
        StringBuilder sb2 = null;
        do {
            int i2 = 0;
            while (true) {
                int i3 = this.f66122h;
                if (i3 + i2 < this.i) {
                    char c2 = this.f66121g[i3 + i2];
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
                } else if (i2 < this.f66121g.length) {
                    if (w(i2 + 1)) {
                    }
                } else {
                    if (sb2 == null) {
                        sb2 = new StringBuilder(Math.max(i2, 16));
                    }
                    sb2.append(this.f66121g, this.f66122h, i2);
                    this.f66122h += i2;
                }
            }
            i = i2;
            if (sb2 != null) {
                sb = new String(this.f66121g, this.f66122h, i);
            } else {
                sb2.append(this.f66121g, this.f66122h, i);
                sb = sb2.toString();
            }
            this.f66122h += i;
            return sb;
        } while (w(1));
        if (sb2 != null) {
        }
        this.f66122h += i;
        return sb;
    }

    public JsonToken M() throws IOException {
        int i = this.l;
        if (i == 0) {
            i = s();
        }
        switch (i) {
            case 1:
                return JsonToken.BEGIN_OBJECT;
            case 2:
                return JsonToken.END_OBJECT;
            case 3:
                return JsonToken.BEGIN_ARRAY;
            case 4:
                return JsonToken.END_ARRAY;
            case 5:
            case 6:
                return JsonToken.BOOLEAN;
            case 7:
                return JsonToken.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonToken.STRING;
            case 12:
            case 13:
            case 14:
                return JsonToken.NAME;
            case 15:
            case 16:
                return JsonToken.NUMBER;
            case 17:
                return JsonToken.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public final int N() throws IOException {
        int i;
        String str;
        String str2;
        char c2 = this.f66121g[this.f66122h];
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
            if (this.f66122h + i2 >= this.i && !w(i2 + 1)) {
                return 0;
            }
            char c3 = this.f66121g[this.f66122h + i2];
            if (c3 != str.charAt(i2) && c3 != str2.charAt(i2)) {
                return 0;
            }
        }
        if ((this.f66122h + length < this.i || w(length + 1)) && A(this.f66121g[this.f66122h + length])) {
            return 0;
        }
        this.f66122h += length;
        this.l = i;
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x0097, code lost:
        if (A(r14) != false) goto L77;
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
        r18.m = r11;
        r18.f66122h += r8;
        r18.l = 15;
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
        r18.n = r8;
        r18.l = 16;
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
    public final int O() throws IOException {
        char[] cArr = this.f66121g;
        int i = this.f66122h;
        int i2 = this.i;
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
                if (!w(i4 + 1)) {
                    break;
                }
                i = this.f66122h;
                i2 = this.i;
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

    public final void P(int i) {
        int i2 = this.q;
        int[] iArr = this.p;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[i2 * 2];
            int[] iArr3 = new int[i2 * 2];
            String[] strArr = new String[i2 * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            System.arraycopy(this.s, 0, iArr3, 0, this.q);
            System.arraycopy(this.r, 0, strArr, 0, this.q);
            this.p = iArr2;
            this.s = iArr3;
            this.r = strArr;
        }
        int[] iArr4 = this.p;
        int i3 = this.q;
        this.q = i3 + 1;
        iArr4[i3] = i;
    }

    public final char Q() throws IOException {
        int i;
        int i2;
        if (this.f66122h == this.i && !w(1)) {
            X("Unterminated escape sequence");
            throw null;
        }
        char[] cArr = this.f66121g;
        int i3 = this.f66122h;
        int i4 = i3 + 1;
        this.f66122h = i4;
        char c2 = cArr[i3];
        if (c2 == '\n') {
            this.j++;
            this.k = i4;
        } else if (c2 != '\"' && c2 != '\'' && c2 != '/' && c2 != '\\') {
            if (c2 != 'b') {
                if (c2 != 'f') {
                    if (c2 != 'n') {
                        if (c2 != 'r') {
                            if (c2 != 't') {
                                if (c2 == 'u') {
                                    if (i4 + 4 > this.i && !w(4)) {
                                        X("Unterminated escape sequence");
                                        throw null;
                                    }
                                    char c3 = 0;
                                    int i5 = this.f66122h;
                                    int i6 = i5 + 4;
                                    while (i5 < i6) {
                                        char c4 = this.f66121g[i5];
                                        char c5 = (char) (c3 << 4);
                                        if (c4 < '0' || c4 > '9') {
                                            if (c4 >= 'a' && c4 <= 'f') {
                                                i = c4 - 'a';
                                            } else if (c4 < 'A' || c4 > 'F') {
                                                throw new NumberFormatException("\\u" + new String(this.f66121g, this.f66122h, 4));
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
                                    this.f66122h += 4;
                                    return c3;
                                }
                                X("Invalid escape sequence");
                                throw null;
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

    public final void R(boolean z) {
        this.f66120f = z;
    }

    public final void S(char c2) throws IOException {
        char[] cArr = this.f66121g;
        do {
            int i = this.f66122h;
            int i2 = this.i;
            while (i < i2) {
                int i3 = i + 1;
                char c3 = cArr[i];
                if (c3 == c2) {
                    this.f66122h = i3;
                    return;
                } else if (c3 == '\\') {
                    this.f66122h = i3;
                    Q();
                    i = this.f66122h;
                    i2 = this.i;
                } else {
                    if (c3 == '\n') {
                        this.j++;
                        this.k = i3;
                    }
                    i = i3;
                }
            }
            this.f66122h = i;
        } while (w(1));
        X("Unterminated string");
        throw null;
    }

    public final boolean T(String str) throws IOException {
        int length = str.length();
        while (true) {
            if (this.f66122h + length > this.i && !w(length)) {
                return false;
            }
            char[] cArr = this.f66121g;
            int i = this.f66122h;
            if (cArr[i] != '\n') {
                for (int i2 = 0; i2 < length; i2++) {
                    if (this.f66121g[this.f66122h + i2] != str.charAt(i2)) {
                        break;
                    }
                }
                return true;
            }
            this.j++;
            this.k = i + 1;
            this.f66122h++;
        }
    }

    public final void U() throws IOException {
        char c2;
        do {
            if (this.f66122h >= this.i && !w(1)) {
                return;
            }
            char[] cArr = this.f66121g;
            int i = this.f66122h;
            int i2 = i + 1;
            this.f66122h = i2;
            c2 = cArr[i];
            if (c2 == '\n') {
                this.j++;
                this.k = i2;
                return;
            }
        } while (c2 != '\r');
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0048, code lost:
        q();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void V() throws IOException {
        do {
            int i = 0;
            while (true) {
                int i2 = this.f66122h;
                if (i2 + i < this.i) {
                    char c2 = this.f66121g[i2 + i];
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
                    this.f66122h = i2 + i;
                }
            }
            this.f66122h += i;
            return;
        } while (w(1));
    }

    public void W() throws IOException {
        int i = 0;
        do {
            int i2 = this.l;
            if (i2 == 0) {
                i2 = s();
            }
            if (i2 == 3) {
                P(1);
            } else if (i2 == 1) {
                P(3);
            } else {
                if (i2 == 4) {
                    this.q--;
                } else if (i2 == 2) {
                    this.q--;
                } else {
                    if (i2 == 14 || i2 == 10) {
                        V();
                    } else if (i2 == 8 || i2 == 12) {
                        S('\'');
                    } else if (i2 == 9 || i2 == 13) {
                        S(Typography.quote);
                    } else if (i2 == 16) {
                        this.f66122h += this.n;
                    }
                    this.l = 0;
                }
                i--;
                this.l = 0;
            }
            i++;
            this.l = 0;
        } while (i != 0);
        int[] iArr = this.s;
        int i3 = this.q;
        int i4 = i3 - 1;
        iArr[i4] = iArr[i4] + 1;
        this.r[i3 - 1] = StringUtil.NULL_STRING;
    }

    public final IOException X(String str) throws IOException {
        throw new MalformedJsonException(str + B());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.l = 0;
        this.p[0] = 8;
        this.q = 1;
        this.f66119e.close();
    }

    public void n() throws IOException {
        int i = this.l;
        if (i == 0) {
            i = s();
        }
        if (i == 3) {
            P(1);
            this.s[this.q - 1] = 0;
            this.l = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + M() + B());
    }

    public void o() throws IOException {
        int i = this.l;
        if (i == 0) {
            i = s();
        }
        if (i == 1) {
            P(3);
            this.l = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + M() + B());
    }

    public final void q() throws IOException {
        if (this.f66120f) {
            return;
        }
        X("Use JsonReader.setLenient(true) to accept malformed JSON");
        throw null;
    }

    public final void r() throws IOException {
        H(true);
        int i = this.f66122h - 1;
        this.f66122h = i;
        char[] cArr = t;
        if (i + cArr.length > this.i && !w(cArr.length)) {
            return;
        }
        int i2 = 0;
        while (true) {
            char[] cArr2 = t;
            if (i2 < cArr2.length) {
                if (this.f66121g[this.f66122h + i2] != cArr2[i2]) {
                    return;
                }
                i2++;
            } else {
                this.f66122h += cArr2.length;
                return;
            }
        }
    }

    public int s() throws IOException {
        int H;
        int[] iArr = this.p;
        int i = this.q;
        int i2 = iArr[i - 1];
        if (i2 == 1) {
            iArr[i - 1] = 2;
        } else if (i2 == 2) {
            int H2 = H(true);
            if (H2 != 44) {
                if (H2 != 59) {
                    if (H2 == 93) {
                        this.l = 4;
                        return 4;
                    }
                    X("Unterminated array");
                    throw null;
                }
                q();
            }
        } else if (i2 == 3 || i2 == 5) {
            this.p[this.q - 1] = 4;
            if (i2 == 5 && (H = H(true)) != 44) {
                if (H != 59) {
                    if (H == 125) {
                        this.l = 2;
                        return 2;
                    }
                    X("Unterminated object");
                    throw null;
                }
                q();
            }
            int H3 = H(true);
            if (H3 == 34) {
                this.l = 13;
                return 13;
            } else if (H3 == 39) {
                q();
                this.l = 12;
                return 12;
            } else if (H3 == 125) {
                if (i2 != 5) {
                    this.l = 2;
                    return 2;
                }
                X("Expected name");
                throw null;
            } else {
                q();
                this.f66122h--;
                if (A((char) H3)) {
                    this.l = 14;
                    return 14;
                }
                X("Expected name");
                throw null;
            }
        } else if (i2 == 4) {
            iArr[i - 1] = 5;
            int H4 = H(true);
            if (H4 != 58) {
                if (H4 == 61) {
                    q();
                    if (this.f66122h < this.i || w(1)) {
                        char[] cArr = this.f66121g;
                        int i3 = this.f66122h;
                        if (cArr[i3] == '>') {
                            this.f66122h = i3 + 1;
                        }
                    }
                } else {
                    X("Expected ':'");
                    throw null;
                }
            }
        } else if (i2 == 6) {
            if (this.f66120f) {
                r();
            }
            this.p[this.q - 1] = 7;
        } else if (i2 == 7) {
            if (H(false) == -1) {
                this.l = 17;
                return 17;
            }
            q();
            this.f66122h--;
        } else if (i2 == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        int H5 = H(true);
        if (H5 == 34) {
            this.l = 9;
            return 9;
        } else if (H5 == 39) {
            q();
            this.l = 8;
            return 8;
        } else {
            if (H5 != 44 && H5 != 59) {
                if (H5 == 91) {
                    this.l = 3;
                    return 3;
                } else if (H5 != 93) {
                    if (H5 != 123) {
                        this.f66122h--;
                        int N = N();
                        if (N != 0) {
                            return N;
                        }
                        int O = O();
                        if (O != 0) {
                            return O;
                        }
                        if (A(this.f66121g[this.f66122h])) {
                            q();
                            this.l = 10;
                            return 10;
                        }
                        X("Expected value");
                        throw null;
                    }
                    this.l = 1;
                    return 1;
                } else if (i2 == 1) {
                    this.l = 4;
                    return 4;
                }
            }
            if (i2 != 1 && i2 != 2) {
                X("Unexpected value");
                throw null;
            }
            q();
            this.f66122h--;
            this.l = 7;
            return 7;
        }
    }

    public void t() throws IOException {
        int i = this.l;
        if (i == 0) {
            i = s();
        }
        if (i == 4) {
            int i2 = this.q - 1;
            this.q = i2;
            int[] iArr = this.s;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
            this.l = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + M() + B());
    }

    public String toString() {
        return getClass().getSimpleName() + B();
    }

    public void v() throws IOException {
        int i = this.l;
        if (i == 0) {
            i = s();
        }
        if (i == 2) {
            int i2 = this.q - 1;
            this.q = i2;
            this.r[i2] = null;
            int[] iArr = this.s;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
            this.l = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + M() + B());
    }

    public final boolean w(int i) throws IOException {
        int i2;
        char[] cArr = this.f66121g;
        int i3 = this.k;
        int i4 = this.f66122h;
        this.k = i3 - i4;
        int i5 = this.i;
        if (i5 != i4) {
            int i6 = i5 - i4;
            this.i = i6;
            System.arraycopy(cArr, i4, cArr, 0, i6);
        } else {
            this.i = 0;
        }
        this.f66122h = 0;
        do {
            Reader reader = this.f66119e;
            int i7 = this.i;
            int read = reader.read(cArr, i7, cArr.length - i7);
            if (read == -1) {
                return false;
            }
            int i8 = this.i + read;
            this.i = i8;
            if (this.j == 0 && (i2 = this.k) == 0 && i8 > 0 && cArr[0] == 65279) {
                this.f66122h++;
                this.k = i2 + 1;
                i++;
            }
        } while (this.i < i);
        return true;
    }

    public String x() {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i = this.q;
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.p[i2];
            if (i3 == 1 || i3 == 2) {
                sb.append('[');
                sb.append(this.s[i2]);
                sb.append(']');
            } else if (i3 == 3 || i3 == 4 || i3 == 5) {
                sb.append(IStringUtil.EXTENSION_SEPARATOR);
                String[] strArr = this.r;
                if (strArr[i2] != null) {
                    sb.append(strArr[i2]);
                }
            }
        }
        return sb.toString();
    }

    public boolean y() throws IOException {
        int i = this.l;
        if (i == 0) {
            i = s();
        }
        return (i == 2 || i == 4) ? false : true;
    }

    public final boolean z() {
        return this.f66120f;
    }
}
