package com.google.gson.stream;

import com.baidu.android.imsdk.internal.Constants;
import com.google.gson.internal.d;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
/* loaded from: classes5.dex */
public class a implements Closeable {
    private static final char[] pVw = ")]}'\n".toCharArray();
    private int[] pTA;
    private int pTy;
    private String[] pTz;
    private long pVC;
    private int pVD;
    private String pVE;
    private final Reader pVx;
    private boolean lenient = false;
    private final char[] pVy = new char[1024];
    private int pos = 0;
    private int limit = 0;
    private int pVz = 0;
    private int pVA = 0;
    int pVB = 0;
    private int[] pVF = new int[32];

    static {
        d.pSN = new d() { // from class: com.google.gson.stream.a.1
            @Override // com.google.gson.internal.d
            public void a(a aVar) throws IOException {
                if (aVar instanceof com.google.gson.internal.bind.a) {
                    ((com.google.gson.internal.bind.a) aVar).eBI();
                    return;
                }
                int i = aVar.pVB;
                if (i == 0) {
                    i = aVar.eBW();
                }
                if (i == 13) {
                    aVar.pVB = 9;
                } else if (i == 12) {
                    aVar.pVB = 8;
                } else if (i == 14) {
                    aVar.pVB = 10;
                } else {
                    throw new IllegalStateException("Expected a name but was " + aVar.eBx() + aVar.eBJ());
                }
            }
        };
    }

    public a(Reader reader) {
        this.pTy = 0;
        int[] iArr = this.pVF;
        int i = this.pTy;
        this.pTy = i + 1;
        iArr[i] = 6;
        this.pTz = new String[32];
        this.pTA = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.pVx = reader;
    }

    public final void BA(boolean z) {
        this.lenient = z;
    }

    public final boolean eBV() {
        return this.lenient;
    }

    public void eBv() throws IOException {
        int i = this.pVB;
        if (i == 0) {
            i = eBW();
        }
        if (i == 3) {
            push(1);
            this.pTA[this.pTy - 1] = 0;
            this.pVB = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + eBx() + eBJ());
    }

    public void endArray() throws IOException {
        int i = this.pVB;
        if (i == 0) {
            i = eBW();
        }
        if (i == 4) {
            this.pTy--;
            int[] iArr = this.pTA;
            int i2 = this.pTy - 1;
            iArr[i2] = iArr[i2] + 1;
            this.pVB = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + eBx() + eBJ());
    }

    public void eBw() throws IOException {
        int i = this.pVB;
        if (i == 0) {
            i = eBW();
        }
        if (i == 1) {
            push(3);
            this.pVB = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + eBx() + eBJ());
    }

    public void endObject() throws IOException {
        int i = this.pVB;
        if (i == 0) {
            i = eBW();
        }
        if (i == 2) {
            this.pTy--;
            this.pTz[this.pTy] = null;
            int[] iArr = this.pTA;
            int i2 = this.pTy - 1;
            iArr[i2] = iArr[i2] + 1;
            this.pVB = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + eBx() + eBJ());
    }

    public boolean hasNext() throws IOException {
        int i = this.pVB;
        if (i == 0) {
            i = eBW();
        }
        return (i == 2 || i == 4) ? false : true;
    }

    public JsonToken eBx() throws IOException {
        int i = this.pVB;
        if (i == 0) {
            i = eBW();
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
    int eBW() throws IOException {
        int i = this.pVF[this.pTy - 1];
        if (i == 1) {
            this.pVF[this.pTy - 1] = 2;
        } else if (i == 2) {
            switch (BB(true)) {
                case 44:
                    break;
                case 59:
                    eCb();
                    break;
                case 93:
                    this.pVB = 4;
                    return 4;
                default:
                    throw ZZ("Unterminated array");
            }
        } else if (i == 3 || i == 5) {
            this.pVF[this.pTy - 1] = 4;
            if (i == 5) {
                switch (BB(true)) {
                    case 44:
                        break;
                    case 59:
                        eCb();
                        break;
                    case Constants.METHOD_IM_FRIEND_GROUP_ASSIGN /* 125 */:
                        this.pVB = 2;
                        return 2;
                    default:
                        throw ZZ("Unterminated object");
                }
            }
            int BB = BB(true);
            switch (BB) {
                case 34:
                    this.pVB = 13;
                    return 13;
                case 39:
                    eCb();
                    this.pVB = 12;
                    return 12;
                case Constants.METHOD_IM_FRIEND_GROUP_ASSIGN /* 125 */:
                    if (i != 5) {
                        this.pVB = 2;
                        return 2;
                    }
                    throw ZZ("Expected name");
                default:
                    eCb();
                    this.pos--;
                    if (f((char) BB)) {
                        this.pVB = 14;
                        return 14;
                    }
                    throw ZZ("Expected name");
            }
        } else if (i == 4) {
            this.pVF[this.pTy - 1] = 5;
            switch (BB(true)) {
                case 58:
                    break;
                case 59:
                case 60:
                default:
                    throw ZZ("Expected ':'");
                case 61:
                    eCb();
                    if ((this.pos < this.limit || Qz(1)) && this.pVy[this.pos] == '>') {
                        this.pos++;
                        break;
                    }
                    break;
            }
        } else if (i == 6) {
            if (this.lenient) {
                eCc();
            }
            this.pVF[this.pTy - 1] = 7;
        } else if (i == 7) {
            if (BB(false) == -1) {
                this.pVB = 17;
                return 17;
            }
            eCb();
            this.pos--;
        } else if (i == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        switch (BB(true)) {
            case 34:
                this.pVB = 9;
                return 9;
            case 39:
                eCb();
                this.pVB = 8;
                return 8;
            case 44:
            case 59:
                break;
            case 91:
                this.pVB = 3;
                return 3;
            case 93:
                if (i == 1) {
                    this.pVB = 4;
                    return 4;
                }
                break;
            case Constants.METHOD_IM_FRIEND_GROUP_QUERY /* 123 */:
                this.pVB = 1;
                return 1;
            default:
                this.pos--;
                int eBX = eBX();
                if (eBX == 0) {
                    int eBY = eBY();
                    if (eBY == 0) {
                        if (!f(this.pVy[this.pos])) {
                            throw ZZ("Expected value");
                        }
                        eCb();
                        this.pVB = 10;
                        return 10;
                    }
                    return eBY;
                }
                return eBX;
        }
        if (i == 1 || i == 2) {
            eCb();
            this.pos--;
            this.pVB = 7;
            return 7;
        }
        throw ZZ("Unexpected value");
    }

    private int eBX() throws IOException {
        String str;
        String str2;
        int i;
        char c = this.pVy[this.pos];
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
            if (this.pos + i2 >= this.limit && !Qz(i2 + 1)) {
                return 0;
            }
            char c2 = this.pVy[this.pos + i2];
            if (c2 != str.charAt(i2) && c2 != str2.charAt(i2)) {
                return 0;
            }
        }
        if ((this.pos + length < this.limit || Qz(length + 1)) && f(this.pVy[this.pos + length])) {
            return 0;
        }
        this.pos += length;
        this.pVB = i;
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:108:?, code lost:
        return 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:?, code lost:
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001f, code lost:
        if (r3 != 2) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0021, code lost:
        if (r4 == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0027, code lost:
        if (r6 != Long.MIN_VALUE) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0029, code lost:
        if (r5 == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002f, code lost:
        if (r6 != 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0031, code lost:
        if (r5 != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0033, code lost:
        if (r5 == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0035, code lost:
        r14.pVC = r6;
        r14.pos += r10;
        r14.pVB = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0058, code lost:
        if (f(r2) == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005a, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00cd, code lost:
        r6 = -r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00d1, code lost:
        if (r3 == 2) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x00d4, code lost:
        if (r3 == 4) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x00d7, code lost:
        if (r3 != 7) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x00d9, code lost:
        r14.pVD = r10;
        r14.pVB = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x00e1, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int eBY() throws IOException {
        char c;
        char[] cArr = this.pVy;
        int i = this.pos;
        int i2 = this.limit;
        long j = 0;
        boolean z = false;
        boolean z2 = true;
        char c2 = 0;
        int i3 = 0;
        while (true) {
            if (i + i3 == i2) {
                if (i3 == cArr.length) {
                    return 0;
                }
                if (Qz(i3 + 1)) {
                    i = this.pos;
                    i2 = this.limit;
                }
            }
            char c3 = cArr[i + i3];
            switch (c3) {
                case '+':
                    if (c2 == 5) {
                        c = 6;
                        break;
                    } else {
                        return 0;
                    }
                case '-':
                    if (c2 == 0) {
                        c = 1;
                        z = true;
                        break;
                    } else if (c2 == 5) {
                        c = 6;
                        break;
                    } else {
                        return 0;
                    }
                case '.':
                    if (c2 == 2) {
                        c = 3;
                        break;
                    } else {
                        return 0;
                    }
                case 'E':
                case 'e':
                    if (c2 == 2 || c2 == 4) {
                        c = 5;
                        break;
                    } else {
                        return 0;
                    }
                default:
                    if (c3 >= '0' && c3 <= '9') {
                        if (c2 == 1 || c2 == 0) {
                            j = -(c3 - '0');
                            c = 2;
                            break;
                        } else if (c2 == 2) {
                            if (j == 0) {
                                return 0;
                            }
                            long j2 = (10 * j) - (c3 - '0');
                            z2 &= j > -922337203685477580L || (j == -922337203685477580L && j2 < j);
                            c = c2;
                            j = j2;
                            break;
                        } else if (c2 == 3) {
                            c = 4;
                            break;
                        } else if (c2 != 5 && c2 != 6) {
                            c = c2;
                            break;
                        } else {
                            c = 7;
                            break;
                        }
                    }
                    break;
            }
            i3++;
            c2 = c;
        }
    }

    private boolean f(char c) throws IOException {
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
                eCb();
                break;
        }
        return false;
    }

    public String eBA() throws IOException {
        String g;
        int i = this.pVB;
        if (i == 0) {
            i = eBW();
        }
        if (i == 14) {
            g = eBZ();
        } else if (i == 12) {
            g = g('\'');
        } else if (i == 13) {
            g = g('\"');
        } else {
            throw new IllegalStateException("Expected a name but was " + eBx() + eBJ());
        }
        this.pVB = 0;
        this.pTz[this.pTy - 1] = g;
        return g;
    }

    public String eBB() throws IOException {
        String str;
        int i = this.pVB;
        if (i == 0) {
            i = eBW();
        }
        if (i == 10) {
            str = eBZ();
        } else if (i == 8) {
            str = g('\'');
        } else if (i == 9) {
            str = g('\"');
        } else if (i == 11) {
            str = this.pVE;
            this.pVE = null;
        } else if (i == 15) {
            str = Long.toString(this.pVC);
        } else if (i == 16) {
            str = new String(this.pVy, this.pos, this.pVD);
            this.pos += this.pVD;
        } else {
            throw new IllegalStateException("Expected a string but was " + eBx() + eBJ());
        }
        this.pVB = 0;
        int[] iArr = this.pTA;
        int i2 = this.pTy - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    public boolean eBC() throws IOException {
        int i = this.pVB;
        if (i == 0) {
            i = eBW();
        }
        if (i == 5) {
            this.pVB = 0;
            int[] iArr = this.pTA;
            int i2 = this.pTy - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        } else if (i == 6) {
            this.pVB = 0;
            int[] iArr2 = this.pTA;
            int i3 = this.pTy - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + eBx() + eBJ());
        }
    }

    public void eBD() throws IOException {
        int i = this.pVB;
        if (i == 0) {
            i = eBW();
        }
        if (i == 7) {
            this.pVB = 0;
            int[] iArr = this.pTA;
            int i2 = this.pTy - 1;
            iArr[i2] = iArr[i2] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + eBx() + eBJ());
    }

    public double eBE() throws IOException {
        int i = this.pVB;
        if (i == 0) {
            i = eBW();
        }
        if (i == 15) {
            this.pVB = 0;
            int[] iArr = this.pTA;
            int i2 = this.pTy - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.pVC;
        }
        if (i == 16) {
            this.pVE = new String(this.pVy, this.pos, this.pVD);
            this.pos += this.pVD;
        } else if (i == 8 || i == 9) {
            this.pVE = g(i == 8 ? '\'' : '\"');
        } else if (i == 10) {
            this.pVE = eBZ();
        } else if (i != 11) {
            throw new IllegalStateException("Expected a double but was " + eBx() + eBJ());
        }
        this.pVB = 11;
        double parseDouble = Double.parseDouble(this.pVE);
        if (!this.lenient && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + parseDouble + eBJ());
        }
        this.pVE = null;
        this.pVB = 0;
        int[] iArr2 = this.pTA;
        int i3 = this.pTy - 1;
        iArr2[i3] = iArr2[i3] + 1;
        return parseDouble;
    }

    public long eBF() throws IOException {
        int i = this.pVB;
        if (i == 0) {
            i = eBW();
        }
        if (i == 15) {
            this.pVB = 0;
            int[] iArr = this.pTA;
            int i2 = this.pTy - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.pVC;
        }
        if (i == 16) {
            this.pVE = new String(this.pVy, this.pos, this.pVD);
            this.pos += this.pVD;
        } else if (i == 8 || i == 9 || i == 10) {
            if (i == 10) {
                this.pVE = eBZ();
            } else {
                this.pVE = g(i == 8 ? '\'' : '\"');
            }
            try {
                long parseLong = Long.parseLong(this.pVE);
                this.pVB = 0;
                int[] iArr2 = this.pTA;
                int i3 = this.pTy - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return parseLong;
            } catch (NumberFormatException e) {
            }
        } else {
            throw new IllegalStateException("Expected a long but was " + eBx() + eBJ());
        }
        this.pVB = 11;
        double parseDouble = Double.parseDouble(this.pVE);
        long j = (long) parseDouble;
        if (j != parseDouble) {
            throw new NumberFormatException("Expected a long but was " + this.pVE + eBJ());
        }
        this.pVE = null;
        this.pVB = 0;
        int[] iArr3 = this.pTA;
        int i4 = this.pTy - 1;
        iArr3[i4] = iArr3[i4] + 1;
        return j;
    }

    private String g(char c) throws IOException {
        int i;
        char[] cArr = this.pVy;
        StringBuilder sb = null;
        do {
            int i2 = this.pos;
            int i3 = this.limit;
            int i4 = i2;
            int i5 = i2;
            while (i5 < i3) {
                int i6 = i5 + 1;
                char c2 = cArr[i5];
                if (c2 == c) {
                    this.pos = i6;
                    int i7 = (i6 - i4) - 1;
                    if (sb == null) {
                        return new String(cArr, i4, i7);
                    }
                    sb.append(cArr, i4, i7);
                    return sb.toString();
                }
                if (c2 == '\\') {
                    this.pos = i6;
                    int i8 = (i6 - i4) - 1;
                    if (sb == null) {
                        sb = new StringBuilder(Math.max((i8 + 1) * 2, 16));
                    }
                    sb.append(cArr, i4, i8);
                    sb.append(readEscapeCharacter());
                    int i9 = this.pos;
                    i = this.limit;
                    i4 = i9;
                    i6 = i9;
                } else {
                    if (c2 == '\n') {
                        this.pVz++;
                        this.pVA = i6;
                    }
                    i = i3;
                }
                i3 = i;
                i5 = i6;
            }
            if (sb == null) {
                sb = new StringBuilder(Math.max((i5 - i4) * 2, 16));
            }
            sb.append(cArr, i4, i5 - i4);
            this.pos = i5;
        } while (Qz(1));
        throw ZZ("Unterminated string");
    }

    private String eBZ() throws IOException {
        StringBuilder sb = null;
        int i = 0;
        while (true) {
            if (this.pos + i < this.limit) {
                switch (this.pVy[this.pos + i]) {
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
                        eCb();
                        break;
                    default:
                        i++;
                }
            } else if (i < this.pVy.length) {
                if (Qz(i + 1)) {
                }
            } else {
                if (sb == null) {
                    sb = new StringBuilder(Math.max(i, 16));
                }
                sb.append(this.pVy, this.pos, i);
                this.pos = i + this.pos;
                if (Qz(1)) {
                    i = 0;
                } else {
                    i = 0;
                }
            }
        }
        String str = sb == null ? new String(this.pVy, this.pos, i) : sb.append(this.pVy, this.pos, i).toString();
        this.pos = i + this.pos;
        return str;
    }

    private void h(char c) throws IOException {
        char[] cArr = this.pVy;
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
                    this.pVz++;
                    this.pVA = i4;
                }
                i3 = i4;
            }
            this.pos = i3;
        } while (Qz(1));
        throw ZZ("Unterminated string");
    }

    private void eCa() throws IOException {
        do {
            int i = 0;
            while (this.pos + i < this.limit) {
                switch (this.pVy[this.pos + i]) {
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
                        eCb();
                        this.pos = i + this.pos;
                        return;
                    default:
                        i++;
                }
            }
            this.pos = i + this.pos;
        } while (Qz(1));
    }

    public int eBG() throws IOException {
        int i = this.pVB;
        if (i == 0) {
            i = eBW();
        }
        if (i == 15) {
            int i2 = (int) this.pVC;
            if (this.pVC != i2) {
                throw new NumberFormatException("Expected an int but was " + this.pVC + eBJ());
            }
            this.pVB = 0;
            int[] iArr = this.pTA;
            int i3 = this.pTy - 1;
            iArr[i3] = iArr[i3] + 1;
            return i2;
        }
        if (i == 16) {
            this.pVE = new String(this.pVy, this.pos, this.pVD);
            this.pos += this.pVD;
        } else if (i == 8 || i == 9 || i == 10) {
            if (i == 10) {
                this.pVE = eBZ();
            } else {
                this.pVE = g(i == 8 ? '\'' : '\"');
            }
            try {
                int parseInt = Integer.parseInt(this.pVE);
                this.pVB = 0;
                int[] iArr2 = this.pTA;
                int i4 = this.pTy - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseInt;
            } catch (NumberFormatException e) {
            }
        } else {
            throw new IllegalStateException("Expected an int but was " + eBx() + eBJ());
        }
        this.pVB = 11;
        double parseDouble = Double.parseDouble(this.pVE);
        int i5 = (int) parseDouble;
        if (i5 != parseDouble) {
            throw new NumberFormatException("Expected an int but was " + this.pVE + eBJ());
        }
        this.pVE = null;
        this.pVB = 0;
        int[] iArr3 = this.pTA;
        int i6 = this.pTy - 1;
        iArr3[i6] = iArr3[i6] + 1;
        return i5;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.pVB = 0;
        this.pVF[0] = 8;
        this.pTy = 1;
        this.pVx.close();
    }

    public void eBH() throws IOException {
        int i = 0;
        do {
            int i2 = this.pVB;
            if (i2 == 0) {
                i2 = eBW();
            }
            if (i2 == 3) {
                push(1);
                i++;
            } else if (i2 == 1) {
                push(3);
                i++;
            } else if (i2 == 4) {
                this.pTy--;
                i--;
            } else if (i2 == 2) {
                this.pTy--;
                i--;
            } else if (i2 == 14 || i2 == 10) {
                eCa();
            } else if (i2 == 8 || i2 == 12) {
                h('\'');
            } else if (i2 == 9 || i2 == 13) {
                h('\"');
            } else if (i2 == 16) {
                this.pos += this.pVD;
            }
            this.pVB = 0;
        } while (i != 0);
        int[] iArr = this.pTA;
        int i3 = this.pTy - 1;
        iArr[i3] = iArr[i3] + 1;
        this.pTz[this.pTy - 1] = "null";
    }

    private void push(int i) {
        if (this.pTy == this.pVF.length) {
            int[] iArr = new int[this.pTy * 2];
            int[] iArr2 = new int[this.pTy * 2];
            String[] strArr = new String[this.pTy * 2];
            System.arraycopy(this.pVF, 0, iArr, 0, this.pTy);
            System.arraycopy(this.pTA, 0, iArr2, 0, this.pTy);
            System.arraycopy(this.pTz, 0, strArr, 0, this.pTy);
            this.pVF = iArr;
            this.pTA = iArr2;
            this.pTz = strArr;
        }
        int[] iArr3 = this.pVF;
        int i2 = this.pTy;
        this.pTy = i2 + 1;
        iArr3[i2] = i;
    }

    private boolean Qz(int i) throws IOException {
        char[] cArr = this.pVy;
        this.pVA -= this.pos;
        if (this.limit != this.pos) {
            this.limit -= this.pos;
            System.arraycopy(cArr, this.pos, cArr, 0, this.limit);
        } else {
            this.limit = 0;
        }
        this.pos = 0;
        do {
            int read = this.pVx.read(cArr, this.limit, cArr.length - this.limit);
            if (read == -1) {
                return false;
            }
            this.limit = read + this.limit;
            if (this.pVz == 0 && this.pVA == 0 && this.limit > 0 && cArr[0] == 65279) {
                this.pos++;
                this.pVA++;
                i++;
            }
        } while (this.limit < i);
        return true;
    }

    private int BB(boolean z) throws IOException {
        char[] cArr = this.pVy;
        int i = this.pos;
        int i2 = this.limit;
        while (true) {
            if (i == i2) {
                this.pos = i;
                if (Qz(1)) {
                    i = this.pos;
                    i2 = this.limit;
                } else if (z) {
                    throw new EOFException("End of input" + eBJ());
                } else {
                    return -1;
                }
            }
            int i3 = i + 1;
            char c = cArr[i];
            if (c == '\n') {
                this.pVz++;
                this.pVA = i3;
                i = i3;
            } else if (c == ' ' || c == '\r') {
                i = i3;
            } else if (c == '\t') {
                i = i3;
            } else if (c == '/') {
                this.pos = i3;
                if (i3 == i2) {
                    this.pos--;
                    boolean Qz = Qz(2);
                    this.pos++;
                    if (!Qz) {
                        return c;
                    }
                }
                eCb();
                switch (cArr[this.pos]) {
                    case '*':
                        this.pos++;
                        if (!ZY("*/")) {
                            throw ZZ("Unterminated comment");
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
                eCb();
                skipToEndOfLine();
                i = this.pos;
                i2 = this.limit;
            } else {
                this.pos = i3;
                return c;
            }
        }
    }

    private void eCb() throws IOException {
        if (!this.lenient) {
            throw ZZ("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void skipToEndOfLine() throws IOException {
        char c;
        do {
            if (this.pos < this.limit || Qz(1)) {
                char[] cArr = this.pVy;
                int i = this.pos;
                this.pos = i + 1;
                c = cArr[i];
                if (c == '\n') {
                    this.pVz++;
                    this.pVA = this.pos;
                    return;
                }
            } else {
                return;
            }
        } while (c != '\r');
    }

    private boolean ZY(String str) throws IOException {
        int i;
        int length = str.length();
        while (true) {
            if (this.pos + length > this.limit && !Qz(length)) {
                return false;
            }
            if (this.pVy[this.pos] == '\n') {
                this.pVz++;
                this.pVA = this.pos + 1;
            } else {
                for (i = 0; i < length; i = i + 1) {
                    i = this.pVy[this.pos + i] == str.charAt(i) ? i + 1 : 0;
                }
                return true;
            }
            this.pos++;
        }
    }

    public String toString() {
        return getClass().getSimpleName() + eBJ();
    }

    String eBJ() {
        return " at line " + (this.pVz + 1) + " column " + ((this.pos - this.pVA) + 1) + " path " + getPath();
    }

    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = this.pTy;
        for (int i2 = 0; i2 < i; i2++) {
            switch (this.pVF[i2]) {
                case 1:
                case 2:
                    append.append('[').append(this.pTA[i2]).append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    append.append('.');
                    if (this.pTz[i2] != null) {
                        append.append(this.pTz[i2]);
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
        if (this.pos == this.limit && !Qz(1)) {
            throw ZZ("Unterminated escape sequence");
        }
        char[] cArr = this.pVy;
        int i2 = this.pos;
        this.pos = i2 + 1;
        char c = cArr[i2];
        switch (c) {
            case '\n':
                this.pVz++;
                this.pVA = this.pos;
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
                if (this.pos + 4 > this.limit && !Qz(4)) {
                    throw ZZ("Unterminated escape sequence");
                }
                char c2 = 0;
                int i3 = this.pos;
                int i4 = i3 + 4;
                while (i3 < i4) {
                    char c3 = this.pVy[i3];
                    char c4 = (char) (c2 << 4);
                    if (c3 >= '0' && c3 <= '9') {
                        i = c3 - '0';
                    } else if (c3 >= 'a' && c3 <= 'f') {
                        i = (c3 - 'a') + 10;
                    } else if (c3 >= 'A' && c3 <= 'F') {
                        i = (c3 - 'A') + 10;
                    } else {
                        throw new NumberFormatException("\\u" + new String(this.pVy, this.pos, 4));
                    }
                    c2 = (char) (c4 + i);
                    i3++;
                }
                this.pos += 4;
                return c2;
            default:
                throw ZZ("Invalid escape sequence");
        }
    }

    private IOException ZZ(String str) throws IOException {
        throw new MalformedJsonException(str + eBJ());
    }

    private void eCc() throws IOException {
        BB(true);
        this.pos--;
        if (this.pos + pVw.length <= this.limit || Qz(pVw.length)) {
            for (int i = 0; i < pVw.length; i++) {
                if (this.pVy[this.pos + i] != pVw[i]) {
                    return;
                }
            }
            this.pos += pVw.length;
        }
    }
}
