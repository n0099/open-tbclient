package com.google.gson.stream;

import com.baidu.android.imsdk.internal.Constants;
import com.google.gson.internal.e;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
/* loaded from: classes7.dex */
public class a implements Closeable {
    private static final char[] mNu = ")]}'\n".toCharArray();
    private int[] mLA;
    private int mLy;
    private String[] mLz;
    private long mNA;
    private int mNB;
    private String mNC;
    private final Reader mNv;
    private boolean lenient = false;
    private final char[] mNw = new char[1024];
    private int pos = 0;
    private int limit = 0;
    private int mNx = 0;
    private int mNy = 0;
    int mNz = 0;
    private int[] mND = new int[32];

    static {
        e.mKN = new e() { // from class: com.google.gson.stream.a.1
            @Override // com.google.gson.internal.e
            public void a(a aVar) throws IOException {
                if (aVar instanceof com.google.gson.internal.a.e) {
                    ((com.google.gson.internal.a.e) aVar).dBb();
                    return;
                }
                int i = aVar.mNz;
                if (i == 0) {
                    i = aVar.dBo();
                }
                if (i == 13) {
                    aVar.mNz = 9;
                } else if (i == 12) {
                    aVar.mNz = 8;
                } else if (i == 14) {
                    aVar.mNz = 10;
                } else {
                    throw new IllegalStateException("Expected a name but was " + aVar.dAU() + aVar.dBc());
                }
            }
        };
    }

    public a(Reader reader) {
        this.mLy = 0;
        int[] iArr = this.mND;
        int i = this.mLy;
        this.mLy = i + 1;
        iArr[i] = 6;
        this.mLz = new String[32];
        this.mLA = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.mNv = reader;
    }

    public final void wd(boolean z) {
        this.lenient = z;
    }

    public final boolean dBn() {
        return this.lenient;
    }

    public void dAS() throws IOException {
        int i = this.mNz;
        if (i == 0) {
            i = dBo();
        }
        if (i == 3) {
            MD(1);
            this.mLA[this.mLy - 1] = 0;
            this.mNz = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + dAU() + dBc());
    }

    public void endArray() throws IOException {
        int i = this.mNz;
        if (i == 0) {
            i = dBo();
        }
        if (i == 4) {
            this.mLy--;
            int[] iArr = this.mLA;
            int i2 = this.mLy - 1;
            iArr[i2] = iArr[i2] + 1;
            this.mNz = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + dAU() + dBc());
    }

    public void dAT() throws IOException {
        int i = this.mNz;
        if (i == 0) {
            i = dBo();
        }
        if (i == 1) {
            MD(3);
            this.mNz = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + dAU() + dBc());
    }

    public void endObject() throws IOException {
        int i = this.mNz;
        if (i == 0) {
            i = dBo();
        }
        if (i == 2) {
            this.mLy--;
            this.mLz[this.mLy] = null;
            int[] iArr = this.mLA;
            int i2 = this.mLy - 1;
            iArr[i2] = iArr[i2] + 1;
            this.mNz = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + dAU() + dBc());
    }

    public boolean hasNext() throws IOException {
        int i = this.mNz;
        if (i == 0) {
            i = dBo();
        }
        return (i == 2 || i == 4) ? false : true;
    }

    public JsonToken dAU() throws IOException {
        int i = this.mNz;
        if (i == 0) {
            i = dBo();
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    int dBo() throws IOException {
        int i = this.mND[this.mLy - 1];
        if (i == 1) {
            this.mND[this.mLy - 1] = 2;
        } else if (i == 2) {
            switch (we(true)) {
                case 44:
                    break;
                case 59:
                    dBt();
                    break;
                case 93:
                    this.mNz = 4;
                    return 4;
                default:
                    throw QP("Unterminated array");
            }
        } else if (i == 3 || i == 5) {
            this.mND[this.mLy - 1] = 4;
            if (i == 5) {
                switch (we(true)) {
                    case 44:
                        break;
                    case 59:
                        dBt();
                        break;
                    case Constants.METHOD_IM_FRIEND_GROUP_ASSIGN /* 125 */:
                        this.mNz = 2;
                        return 2;
                    default:
                        throw QP("Unterminated object");
                }
            }
            int we = we(true);
            switch (we) {
                case 34:
                    this.mNz = 13;
                    return 13;
                case 39:
                    dBt();
                    this.mNz = 12;
                    return 12;
                case Constants.METHOD_IM_FRIEND_GROUP_ASSIGN /* 125 */:
                    if (i != 5) {
                        this.mNz = 2;
                        return 2;
                    }
                    throw QP("Expected name");
                default:
                    dBt();
                    this.pos--;
                    if (m((char) we)) {
                        this.mNz = 14;
                        return 14;
                    }
                    throw QP("Expected name");
            }
        } else if (i == 4) {
            this.mND[this.mLy - 1] = 5;
            switch (we(true)) {
                case 58:
                    break;
                case 59:
                case 60:
                default:
                    throw QP("Expected ':'");
                case 61:
                    dBt();
                    if ((this.pos < this.limit || ME(1)) && this.mNw[this.pos] == '>') {
                        this.pos++;
                        break;
                    }
                    break;
            }
        } else if (i == 6) {
            if (this.lenient) {
                dBu();
            }
            this.mND[this.mLy - 1] = 7;
        } else if (i == 7) {
            if (we(false) == -1) {
                this.mNz = 17;
                return 17;
            }
            dBt();
            this.pos--;
        } else if (i == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        switch (we(true)) {
            case 34:
                this.mNz = 9;
                return 9;
            case 39:
                dBt();
                this.mNz = 8;
                return 8;
            case 44:
            case 59:
                break;
            case 91:
                this.mNz = 3;
                return 3;
            case 93:
                if (i == 1) {
                    this.mNz = 4;
                    return 4;
                }
                break;
            case Constants.METHOD_IM_FRIEND_GROUP_QUERY /* 123 */:
                this.mNz = 1;
                return 1;
            default:
                this.pos--;
                int dBp = dBp();
                if (dBp == 0) {
                    int dBq = dBq();
                    if (dBq == 0) {
                        if (!m(this.mNw[this.pos])) {
                            throw QP("Expected value");
                        }
                        dBt();
                        this.mNz = 10;
                        return 10;
                    }
                    return dBq;
                }
                return dBp;
        }
        if (i == 1 || i == 2) {
            dBt();
            this.pos--;
            this.mNz = 7;
            return 7;
        }
        throw QP("Unexpected value");
    }

    private int dBp() throws IOException {
        String str;
        String str2;
        int i;
        char c = this.mNw[this.pos];
        if (c == 't' || c == 'T') {
            str = "true";
            str2 = "TRUE";
            i = 5;
        } else if (c == 'f' || c == 'F') {
            str = "false";
            str2 = "FALSE";
            i = 6;
        } else if (c != 'n' && c != 'N') {
            return 0;
        } else {
            str = "null";
            str2 = "NULL";
            i = 7;
        }
        int length = str.length();
        for (int i2 = 1; i2 < length; i2++) {
            if (this.pos + i2 >= this.limit && !ME(i2 + 1)) {
                return 0;
            }
            char c2 = this.mNw[this.pos + i2];
            if (c2 != str.charAt(i2) && c2 != str2.charAt(i2)) {
                return 0;
            }
        }
        if ((this.pos + length < this.limit || ME(length + 1)) && m(this.mNw[this.pos + length])) {
            return 0;
        }
        this.pos += length;
        this.mNz = i;
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:108:?, code lost:
        return 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:?, code lost:
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0021, code lost:
        if (r3 != 2) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        if (r4 == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0029, code lost:
        if (r6 != Long.MIN_VALUE) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002b, code lost:
        if (r5 == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0031, code lost:
        if (r6 != 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0033, code lost:
        if (r5 != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0035, code lost:
        if (r5 == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0037, code lost:
        r15.mNA = r6;
        r15.pos += r10;
        r15.mNz = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005a, code lost:
        if (m(r2) == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005c, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00e4, code lost:
        r6 = -r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00e8, code lost:
        if (r3 == 2) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x00eb, code lost:
        if (r3 == 4) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x00ee, code lost:
        if (r3 != 7) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x00f0, code lost:
        r15.mNB = r10;
        r15.mNz = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x00f8, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int dBq() throws IOException {
        char c;
        boolean z;
        boolean z2;
        char[] cArr = this.mNw;
        int i = this.pos;
        long j = 0;
        boolean z3 = false;
        boolean z4 = true;
        char c2 = 0;
        int i2 = 0;
        int i3 = this.limit;
        int i4 = i;
        while (true) {
            if (i4 + i2 == i3) {
                if (i2 == cArr.length) {
                    return 0;
                }
                if (ME(i2 + 1)) {
                    i4 = this.pos;
                    i3 = this.limit;
                }
            }
            char c3 = cArr[i4 + i2];
            switch (c3) {
                case '+':
                    if (c2 == 5) {
                        c = 6;
                        z = z4;
                        z2 = z3;
                        break;
                    } else {
                        return 0;
                    }
                case '-':
                    if (c2 == 0) {
                        c = 1;
                        boolean z5 = z4;
                        z2 = true;
                        z = z5;
                        break;
                    } else if (c2 == 5) {
                        c = 6;
                        z = z4;
                        z2 = z3;
                        break;
                    } else {
                        return 0;
                    }
                case '.':
                    if (c2 == 2) {
                        c = 3;
                        z = z4;
                        z2 = z3;
                        break;
                    } else {
                        return 0;
                    }
                case 'E':
                case 'e':
                    if (c2 == 2 || c2 == 4) {
                        c = 5;
                        z = z4;
                        z2 = z3;
                        break;
                    } else {
                        return 0;
                    }
                default:
                    if (c3 >= '0' && c3 <= '9') {
                        if (c2 == 1 || c2 == 0) {
                            j = -(c3 - '0');
                            c = 2;
                            z = z4;
                            z2 = z3;
                            break;
                        } else if (c2 == 2) {
                            if (j == 0) {
                                return 0;
                            }
                            long j2 = (10 * j) - (c3 - '0');
                            boolean z6 = (j > -922337203685477580L || (j == -922337203685477580L && j2 < j)) & z4;
                            z2 = z3;
                            j = j2;
                            char c4 = c2;
                            z = z6;
                            c = c4;
                            break;
                        } else if (c2 == 3) {
                            c = 4;
                            z = z4;
                            z2 = z3;
                            break;
                        } else if (c2 != 5 && c2 != 6) {
                            c = c2;
                            z = z4;
                            z2 = z3;
                            break;
                        } else {
                            c = 7;
                            z = z4;
                            z2 = z3;
                            break;
                        }
                    }
                    break;
            }
            i2++;
            z3 = z2;
            z4 = z;
            c2 = c;
        }
    }

    private boolean m(char c) throws IOException {
        switch (c) {
            case '\t':
            case '\n':
            case '\f':
            case '\r':
            case ' ':
            case ',':
            case ':':
            case '[':
            case ']':
            case Constants.METHOD_IM_FRIEND_GROUP_QUERY /* 123 */:
            case Constants.METHOD_IM_FRIEND_GROUP_ASSIGN /* 125 */:
                break;
            default:
                return true;
            case '#':
            case '/':
            case ';':
            case '=':
            case '\\':
                dBt();
                break;
        }
        return false;
    }

    public String dAX() throws IOException {
        String n;
        int i = this.mNz;
        if (i == 0) {
            i = dBo();
        }
        if (i == 14) {
            n = dBr();
        } else if (i == 12) {
            n = n('\'');
        } else if (i == 13) {
            n = n('\"');
        } else {
            throw new IllegalStateException("Expected a name but was " + dAU() + dBc());
        }
        this.mNz = 0;
        this.mLz[this.mLy - 1] = n;
        return n;
    }

    public String dAY() throws IOException {
        String str;
        int i = this.mNz;
        if (i == 0) {
            i = dBo();
        }
        if (i == 10) {
            str = dBr();
        } else if (i == 8) {
            str = n('\'');
        } else if (i == 9) {
            str = n('\"');
        } else if (i == 11) {
            str = this.mNC;
            this.mNC = null;
        } else if (i == 15) {
            str = Long.toString(this.mNA);
        } else if (i == 16) {
            str = new String(this.mNw, this.pos, this.mNB);
            this.pos += this.mNB;
        } else {
            throw new IllegalStateException("Expected a string but was " + dAU() + dBc());
        }
        this.mNz = 0;
        int[] iArr = this.mLA;
        int i2 = this.mLy - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    public boolean nextBoolean() throws IOException {
        int i = this.mNz;
        if (i == 0) {
            i = dBo();
        }
        if (i == 5) {
            this.mNz = 0;
            int[] iArr = this.mLA;
            int i2 = this.mLy - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        } else if (i == 6) {
            this.mNz = 0;
            int[] iArr2 = this.mLA;
            int i3 = this.mLy - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + dAU() + dBc());
        }
    }

    public void dAZ() throws IOException {
        int i = this.mNz;
        if (i == 0) {
            i = dBo();
        }
        if (i == 7) {
            this.mNz = 0;
            int[] iArr = this.mLA;
            int i2 = this.mLy - 1;
            iArr[i2] = iArr[i2] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + dAU() + dBc());
    }

    public double nextDouble() throws IOException {
        int i = this.mNz;
        if (i == 0) {
            i = dBo();
        }
        if (i == 15) {
            this.mNz = 0;
            int[] iArr = this.mLA;
            int i2 = this.mLy - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.mNA;
        }
        if (i == 16) {
            this.mNC = new String(this.mNw, this.pos, this.mNB);
            this.pos += this.mNB;
        } else if (i == 8 || i == 9) {
            this.mNC = n(i == 8 ? '\'' : '\"');
        } else if (i == 10) {
            this.mNC = dBr();
        } else if (i != 11) {
            throw new IllegalStateException("Expected a double but was " + dAU() + dBc());
        }
        this.mNz = 11;
        double parseDouble = Double.parseDouble(this.mNC);
        if (!this.lenient && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + parseDouble + dBc());
        }
        this.mNC = null;
        this.mNz = 0;
        int[] iArr2 = this.mLA;
        int i3 = this.mLy - 1;
        iArr2[i3] = iArr2[i3] + 1;
        return parseDouble;
    }

    public long nextLong() throws IOException {
        int i = this.mNz;
        if (i == 0) {
            i = dBo();
        }
        if (i == 15) {
            this.mNz = 0;
            int[] iArr = this.mLA;
            int i2 = this.mLy - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.mNA;
        }
        if (i == 16) {
            this.mNC = new String(this.mNw, this.pos, this.mNB);
            this.pos += this.mNB;
        } else if (i == 8 || i == 9 || i == 10) {
            if (i == 10) {
                this.mNC = dBr();
            } else {
                this.mNC = n(i == 8 ? '\'' : '\"');
            }
            try {
                long parseLong = Long.parseLong(this.mNC);
                this.mNz = 0;
                int[] iArr2 = this.mLA;
                int i3 = this.mLy - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return parseLong;
            } catch (NumberFormatException e) {
            }
        } else {
            throw new IllegalStateException("Expected a long but was " + dAU() + dBc());
        }
        this.mNz = 11;
        double parseDouble = Double.parseDouble(this.mNC);
        long j = (long) parseDouble;
        if (j != parseDouble) {
            throw new NumberFormatException("Expected a long but was " + this.mNC + dBc());
        }
        this.mNC = null;
        this.mNz = 0;
        int[] iArr3 = this.mLA;
        int i4 = this.mLy - 1;
        iArr3[i4] = iArr3[i4] + 1;
        return j;
    }

    private String n(char c) throws IOException {
        int i;
        int i2;
        StringBuilder sb;
        int i3;
        char[] cArr = this.mNw;
        StringBuilder sb2 = null;
        do {
            int i4 = this.pos;
            int i5 = this.limit;
            int i6 = i4;
            while (i6 < i5) {
                int i7 = i6 + 1;
                char c2 = cArr[i6];
                if (c2 == c) {
                    this.pos = i7;
                    int i8 = (i7 - i4) - 1;
                    if (sb2 == null) {
                        return new String(cArr, i4, i8);
                    }
                    sb2.append(cArr, i4, i8);
                    return sb2.toString();
                }
                if (c2 == '\\') {
                    this.pos = i7;
                    int i9 = (i7 - i4) - 1;
                    if (sb2 == null) {
                        sb2 = new StringBuilder(Math.max((i9 + 1) * 2, 16));
                    }
                    sb2.append(cArr, i4, i9);
                    sb2.append(readEscapeCharacter());
                    int i10 = this.pos;
                    sb = sb2;
                    i3 = i10;
                    i = this.limit;
                    i2 = i10;
                } else {
                    if (c2 == '\n') {
                        this.mNx++;
                        this.mNy = i7;
                    }
                    int i11 = i4;
                    i = i5;
                    i2 = i7;
                    sb = sb2;
                    i3 = i11;
                }
                i6 = i2;
                i5 = i;
                i4 = i3;
                sb2 = sb;
            }
            if (sb2 == null) {
                sb2 = new StringBuilder(Math.max((i6 - i4) * 2, 16));
            }
            sb2.append(cArr, i4, i6 - i4);
            this.pos = i6;
        } while (ME(1));
        throw QP("Unterminated string");
    }

    private String dBr() throws IOException {
        StringBuilder sb = null;
        int i = 0;
        while (true) {
            if (this.pos + i < this.limit) {
                switch (this.mNw[this.pos + i]) {
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                    case ' ':
                    case ',':
                    case ':':
                    case '[':
                    case ']':
                    case Constants.METHOD_IM_FRIEND_GROUP_QUERY /* 123 */:
                    case Constants.METHOD_IM_FRIEND_GROUP_ASSIGN /* 125 */:
                        break;
                    case '#':
                    case '/':
                    case ';':
                    case '=':
                    case '\\':
                        dBt();
                        break;
                    default:
                        i++;
                }
            } else if (i < this.mNw.length) {
                if (ME(i + 1)) {
                }
            } else {
                if (sb == null) {
                    sb = new StringBuilder(Math.max(i, 16));
                }
                sb.append(this.mNw, this.pos, i);
                this.pos = i + this.pos;
                if (ME(1)) {
                    i = 0;
                } else {
                    i = 0;
                }
            }
        }
        String str = sb == null ? new String(this.mNw, this.pos, i) : sb.append(this.mNw, this.pos, i).toString();
        this.pos = i + this.pos;
        return str;
    }

    private void o(char c) throws IOException {
        char[] cArr = this.mNw;
        do {
            int i = this.pos;
            int i2 = this.limit;
            int i3 = i;
            while (i3 < i2) {
                int i4 = i3 + 1;
                char c2 = cArr[i3];
                if (c2 == c) {
                    this.pos = i4;
                    return;
                }
                if (c2 == '\\') {
                    this.pos = i4;
                    readEscapeCharacter();
                    i4 = this.pos;
                    i2 = this.limit;
                } else if (c2 == '\n') {
                    this.mNx++;
                    this.mNy = i4;
                }
                i3 = i4;
            }
            this.pos = i3;
        } while (ME(1));
        throw QP("Unterminated string");
    }

    private void dBs() throws IOException {
        do {
            int i = 0;
            while (this.pos + i < this.limit) {
                switch (this.mNw[this.pos + i]) {
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                    case ' ':
                    case ',':
                    case ':':
                    case '[':
                    case ']':
                    case Constants.METHOD_IM_FRIEND_GROUP_QUERY /* 123 */:
                    case Constants.METHOD_IM_FRIEND_GROUP_ASSIGN /* 125 */:
                        this.pos = i + this.pos;
                        return;
                    case '#':
                    case '/':
                    case ';':
                    case '=':
                    case '\\':
                        dBt();
                        this.pos = i + this.pos;
                        return;
                    default:
                        i++;
                }
            }
            this.pos = i + this.pos;
        } while (ME(1));
    }

    public int nextInt() throws IOException {
        int i = this.mNz;
        if (i == 0) {
            i = dBo();
        }
        if (i == 15) {
            int i2 = (int) this.mNA;
            if (this.mNA != i2) {
                throw new NumberFormatException("Expected an int but was " + this.mNA + dBc());
            }
            this.mNz = 0;
            int[] iArr = this.mLA;
            int i3 = this.mLy - 1;
            iArr[i3] = iArr[i3] + 1;
            return i2;
        }
        if (i == 16) {
            this.mNC = new String(this.mNw, this.pos, this.mNB);
            this.pos += this.mNB;
        } else if (i == 8 || i == 9 || i == 10) {
            if (i == 10) {
                this.mNC = dBr();
            } else {
                this.mNC = n(i == 8 ? '\'' : '\"');
            }
            try {
                int parseInt = Integer.parseInt(this.mNC);
                this.mNz = 0;
                int[] iArr2 = this.mLA;
                int i4 = this.mLy - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseInt;
            } catch (NumberFormatException e) {
            }
        } else {
            throw new IllegalStateException("Expected an int but was " + dAU() + dBc());
        }
        this.mNz = 11;
        double parseDouble = Double.parseDouble(this.mNC);
        int i5 = (int) parseDouble;
        if (i5 != parseDouble) {
            throw new NumberFormatException("Expected an int but was " + this.mNC + dBc());
        }
        this.mNC = null;
        this.mNz = 0;
        int[] iArr3 = this.mLA;
        int i6 = this.mLy - 1;
        iArr3[i6] = iArr3[i6] + 1;
        return i5;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mNz = 0;
        this.mND[0] = 8;
        this.mLy = 1;
        this.mNv.close();
    }

    public void dBa() throws IOException {
        int i = 0;
        do {
            int i2 = this.mNz;
            if (i2 == 0) {
                i2 = dBo();
            }
            if (i2 == 3) {
                MD(1);
                i++;
            } else if (i2 == 1) {
                MD(3);
                i++;
            } else if (i2 == 4) {
                this.mLy--;
                i--;
            } else if (i2 == 2) {
                this.mLy--;
                i--;
            } else if (i2 == 14 || i2 == 10) {
                dBs();
            } else if (i2 == 8 || i2 == 12) {
                o('\'');
            } else if (i2 == 9 || i2 == 13) {
                o('\"');
            } else if (i2 == 16) {
                this.pos += this.mNB;
            }
            this.mNz = 0;
        } while (i != 0);
        int[] iArr = this.mLA;
        int i3 = this.mLy - 1;
        iArr[i3] = iArr[i3] + 1;
        this.mLz[this.mLy - 1] = "null";
    }

    private void MD(int i) {
        if (this.mLy == this.mND.length) {
            int[] iArr = new int[this.mLy * 2];
            int[] iArr2 = new int[this.mLy * 2];
            String[] strArr = new String[this.mLy * 2];
            System.arraycopy(this.mND, 0, iArr, 0, this.mLy);
            System.arraycopy(this.mLA, 0, iArr2, 0, this.mLy);
            System.arraycopy(this.mLz, 0, strArr, 0, this.mLy);
            this.mND = iArr;
            this.mLA = iArr2;
            this.mLz = strArr;
        }
        int[] iArr3 = this.mND;
        int i2 = this.mLy;
        this.mLy = i2 + 1;
        iArr3[i2] = i;
    }

    private boolean ME(int i) throws IOException {
        char[] cArr = this.mNw;
        this.mNy -= this.pos;
        if (this.limit != this.pos) {
            this.limit -= this.pos;
            System.arraycopy(cArr, this.pos, cArr, 0, this.limit);
        } else {
            this.limit = 0;
        }
        this.pos = 0;
        do {
            int read = this.mNv.read(cArr, this.limit, cArr.length - this.limit);
            if (read == -1) {
                return false;
            }
            this.limit = read + this.limit;
            if (this.mNx == 0 && this.mNy == 0 && this.limit > 0 && cArr[0] == 65279) {
                this.pos++;
                this.mNy++;
                i++;
            }
        } while (this.limit < i);
        return true;
    }

    private int we(boolean z) throws IOException {
        char[] cArr = this.mNw;
        int i = this.pos;
        int i2 = this.limit;
        while (true) {
            if (i == i2) {
                this.pos = i;
                if (ME(1)) {
                    i = this.pos;
                    i2 = this.limit;
                } else if (z) {
                    throw new EOFException("End of input" + dBc());
                } else {
                    return -1;
                }
            }
            int i3 = i + 1;
            char c = cArr[i];
            if (c == '\n') {
                this.mNx++;
                this.mNy = i3;
                i = i3;
            } else if (c == ' ' || c == '\r') {
                i = i3;
            } else if (c == '\t') {
                i = i3;
            } else if (c == '/') {
                this.pos = i3;
                if (i3 == i2) {
                    this.pos--;
                    boolean ME = ME(2);
                    this.pos++;
                    if (!ME) {
                        return c;
                    }
                }
                dBt();
                switch (cArr[this.pos]) {
                    case '*':
                        this.pos++;
                        if (!QO("*/")) {
                            throw QP("Unterminated comment");
                        }
                        i = this.pos + 2;
                        i2 = this.limit;
                        continue;
                    case '/':
                        this.pos++;
                        skipToEndOfLine();
                        i = this.pos;
                        i2 = this.limit;
                        continue;
                    default:
                        return c;
                }
            } else if (c == '#') {
                this.pos = i3;
                dBt();
                skipToEndOfLine();
                i = this.pos;
                i2 = this.limit;
            } else {
                this.pos = i3;
                return c;
            }
        }
    }

    private void dBt() throws IOException {
        if (!this.lenient) {
            throw QP("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void skipToEndOfLine() throws IOException {
        char c;
        do {
            if (this.pos < this.limit || ME(1)) {
                char[] cArr = this.mNw;
                int i = this.pos;
                this.pos = i + 1;
                c = cArr[i];
                if (c == '\n') {
                    this.mNx++;
                    this.mNy = this.pos;
                    return;
                }
            } else {
                return;
            }
        } while (c != '\r');
    }

    private boolean QO(String str) throws IOException {
        int i;
        int length = str.length();
        while (true) {
            if (this.pos + length > this.limit && !ME(length)) {
                return false;
            }
            if (this.mNw[this.pos] == '\n') {
                this.mNx++;
                this.mNy = this.pos + 1;
            } else {
                for (i = 0; i < length; i = i + 1) {
                    i = this.mNw[this.pos + i] == str.charAt(i) ? i + 1 : 0;
                }
                return true;
            }
            this.pos++;
        }
    }

    public String toString() {
        return getClass().getSimpleName() + dBc();
    }

    String dBc() {
        return " at line " + (this.mNx + 1) + " column " + ((this.pos - this.mNy) + 1) + " path " + getPath();
    }

    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = this.mLy;
        for (int i2 = 0; i2 < i; i2++) {
            switch (this.mND[i2]) {
                case 1:
                case 2:
                    append.append('[').append(this.mLA[i2]).append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    append.append('.');
                    if (this.mLz[i2] != null) {
                        append.append(this.mLz[i2]);
                        break;
                    } else {
                        break;
                    }
            }
        }
        return append.toString();
    }

    private char readEscapeCharacter() throws IOException {
        int i;
        if (this.pos == this.limit && !ME(1)) {
            throw QP("Unterminated escape sequence");
        }
        char[] cArr = this.mNw;
        int i2 = this.pos;
        this.pos = i2 + 1;
        char c = cArr[i2];
        switch (c) {
            case '\n':
                this.mNx++;
                this.mNy = this.pos;
                return c;
            case '\"':
            case '\'':
            case '/':
            case '\\':
                return c;
            case 'b':
                return '\b';
            case 'f':
                return '\f';
            case 'n':
                return '\n';
            case 'r':
                return '\r';
            case 't':
                return '\t';
            case 'u':
                if (this.pos + 4 > this.limit && !ME(4)) {
                    throw QP("Unterminated escape sequence");
                }
                int i3 = this.pos;
                int i4 = i3 + 4;
                char c2 = 0;
                for (int i5 = i3; i5 < i4; i5++) {
                    char c3 = this.mNw[i5];
                    char c4 = (char) (c2 << 4);
                    if (c3 >= '0' && c3 <= '9') {
                        i = c3 - '0';
                    } else if (c3 >= 'a' && c3 <= 'f') {
                        i = (c3 - 'a') + 10;
                    } else if (c3 >= 'A' && c3 <= 'F') {
                        i = (c3 - 'A') + 10;
                    } else {
                        throw new NumberFormatException("\\u" + new String(this.mNw, this.pos, 4));
                    }
                    c2 = (char) (c4 + i);
                }
                this.pos += 4;
                return c2;
            default:
                throw QP("Invalid escape sequence");
        }
    }

    private IOException QP(String str) throws IOException {
        throw new MalformedJsonException(str + dBc());
    }

    private void dBu() throws IOException {
        we(true);
        this.pos--;
        if (this.pos + mNu.length <= this.limit || ME(mNu.length)) {
            for (int i = 0; i < mNu.length; i++) {
                if (this.mNw[this.pos + i] != mNu[i]) {
                    return;
                }
            }
            this.pos += mNu.length;
        }
    }
}
