package com.google.gson.stream;

import com.baidu.android.imsdk.internal.Constants;
import com.google.gson.internal.d;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
/* loaded from: classes4.dex */
public class a implements Closeable {
    private static final char[] pKQ = ")]}'\n".toCharArray();
    private int pIS;
    private String[] pIT;
    private int[] pIU;
    private final Reader pKR;
    private long pKW;
    private int pKX;
    private String pKY;
    private boolean lenient = false;
    private final char[] pKS = new char[1024];
    private int pos = 0;
    private int limit = 0;
    private int pKT = 0;
    private int pKU = 0;
    int pKV = 0;
    private int[] pKZ = new int[32];

    static {
        d.pIh = new d() { // from class: com.google.gson.stream.a.1
            @Override // com.google.gson.internal.d
            public void a(a aVar) throws IOException {
                if (aVar instanceof com.google.gson.internal.bind.a) {
                    ((com.google.gson.internal.bind.a) aVar).ezi();
                    return;
                }
                int i = aVar.pKV;
                if (i == 0) {
                    i = aVar.ezw();
                }
                if (i == 13) {
                    aVar.pKV = 9;
                } else if (i == 12) {
                    aVar.pKV = 8;
                } else if (i == 14) {
                    aVar.pKV = 10;
                } else {
                    throw new IllegalStateException("Expected a name but was " + aVar.eyX() + aVar.ezj());
                }
            }
        };
    }

    public a(Reader reader) {
        this.pIS = 0;
        int[] iArr = this.pKZ;
        int i = this.pIS;
        this.pIS = i + 1;
        iArr[i] = 6;
        this.pIT = new String[32];
        this.pIU = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.pKR = reader;
    }

    public final void Bh(boolean z) {
        this.lenient = z;
    }

    public final boolean ezv() {
        return this.lenient;
    }

    public void eyV() throws IOException {
        int i = this.pKV;
        if (i == 0) {
            i = ezw();
        }
        if (i == 3) {
            push(1);
            this.pIU[this.pIS - 1] = 0;
            this.pKV = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + eyX() + ezj());
    }

    public void endArray() throws IOException {
        int i = this.pKV;
        if (i == 0) {
            i = ezw();
        }
        if (i == 4) {
            this.pIS--;
            int[] iArr = this.pIU;
            int i2 = this.pIS - 1;
            iArr[i2] = iArr[i2] + 1;
            this.pKV = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + eyX() + ezj());
    }

    public void eyW() throws IOException {
        int i = this.pKV;
        if (i == 0) {
            i = ezw();
        }
        if (i == 1) {
            push(3);
            this.pKV = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + eyX() + ezj());
    }

    public void endObject() throws IOException {
        int i = this.pKV;
        if (i == 0) {
            i = ezw();
        }
        if (i == 2) {
            this.pIS--;
            this.pIT[this.pIS] = null;
            int[] iArr = this.pIU;
            int i2 = this.pIS - 1;
            iArr[i2] = iArr[i2] + 1;
            this.pKV = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + eyX() + ezj());
    }

    public boolean hasNext() throws IOException {
        int i = this.pKV;
        if (i == 0) {
            i = ezw();
        }
        return (i == 2 || i == 4) ? false : true;
    }

    public JsonToken eyX() throws IOException {
        int i = this.pKV;
        if (i == 0) {
            i = ezw();
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
    int ezw() throws IOException {
        int i = this.pKZ[this.pIS - 1];
        if (i == 1) {
            this.pKZ[this.pIS - 1] = 2;
        } else if (i == 2) {
            switch (Bi(true)) {
                case 44:
                    break;
                case 59:
                    ezB();
                    break;
                case 93:
                    this.pKV = 4;
                    return 4;
                default:
                    throw YL("Unterminated array");
            }
        } else if (i == 3 || i == 5) {
            this.pKZ[this.pIS - 1] = 4;
            if (i == 5) {
                switch (Bi(true)) {
                    case 44:
                        break;
                    case 59:
                        ezB();
                        break;
                    case Constants.METHOD_IM_FRIEND_GROUP_ASSIGN /* 125 */:
                        this.pKV = 2;
                        return 2;
                    default:
                        throw YL("Unterminated object");
                }
            }
            int Bi = Bi(true);
            switch (Bi) {
                case 34:
                    this.pKV = 13;
                    return 13;
                case 39:
                    ezB();
                    this.pKV = 12;
                    return 12;
                case Constants.METHOD_IM_FRIEND_GROUP_ASSIGN /* 125 */:
                    if (i != 5) {
                        this.pKV = 2;
                        return 2;
                    }
                    throw YL("Expected name");
                default:
                    ezB();
                    this.pos--;
                    if (f((char) Bi)) {
                        this.pKV = 14;
                        return 14;
                    }
                    throw YL("Expected name");
            }
        } else if (i == 4) {
            this.pKZ[this.pIS - 1] = 5;
            switch (Bi(true)) {
                case 58:
                    break;
                case 59:
                case 60:
                default:
                    throw YL("Expected ':'");
                case 61:
                    ezB();
                    if ((this.pos < this.limit || Qd(1)) && this.pKS[this.pos] == '>') {
                        this.pos++;
                        break;
                    }
                    break;
            }
        } else if (i == 6) {
            if (this.lenient) {
                ezC();
            }
            this.pKZ[this.pIS - 1] = 7;
        } else if (i == 7) {
            if (Bi(false) == -1) {
                this.pKV = 17;
                return 17;
            }
            ezB();
            this.pos--;
        } else if (i == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        switch (Bi(true)) {
            case 34:
                this.pKV = 9;
                return 9;
            case 39:
                ezB();
                this.pKV = 8;
                return 8;
            case 44:
            case 59:
                break;
            case 91:
                this.pKV = 3;
                return 3;
            case 93:
                if (i == 1) {
                    this.pKV = 4;
                    return 4;
                }
                break;
            case Constants.METHOD_IM_FRIEND_GROUP_QUERY /* 123 */:
                this.pKV = 1;
                return 1;
            default:
                this.pos--;
                int ezx = ezx();
                if (ezx == 0) {
                    int ezy = ezy();
                    if (ezy == 0) {
                        if (!f(this.pKS[this.pos])) {
                            throw YL("Expected value");
                        }
                        ezB();
                        this.pKV = 10;
                        return 10;
                    }
                    return ezy;
                }
                return ezx;
        }
        if (i == 1 || i == 2) {
            ezB();
            this.pos--;
            this.pKV = 7;
            return 7;
        }
        throw YL("Unexpected value");
    }

    private int ezx() throws IOException {
        String str;
        String str2;
        int i;
        char c = this.pKS[this.pos];
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
            if (this.pos + i2 >= this.limit && !Qd(i2 + 1)) {
                return 0;
            }
            char c2 = this.pKS[this.pos + i2];
            if (c2 != str.charAt(i2) && c2 != str2.charAt(i2)) {
                return 0;
            }
        }
        if ((this.pos + length < this.limit || Qd(length + 1)) && f(this.pKS[this.pos + length])) {
            return 0;
        }
        this.pos += length;
        this.pKV = i;
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
        r14.pKW = r6;
        r14.pos += r10;
        r14.pKV = 15;
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
        r14.pKX = r10;
        r14.pKV = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x00e1, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int ezy() throws IOException {
        char c;
        char[] cArr = this.pKS;
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
                if (Qd(i3 + 1)) {
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
                ezB();
                break;
        }
        return false;
    }

    public String eza() throws IOException {
        String g;
        int i = this.pKV;
        if (i == 0) {
            i = ezw();
        }
        if (i == 14) {
            g = ezz();
        } else if (i == 12) {
            g = g('\'');
        } else if (i == 13) {
            g = g('\"');
        } else {
            throw new IllegalStateException("Expected a name but was " + eyX() + ezj());
        }
        this.pKV = 0;
        this.pIT[this.pIS - 1] = g;
        return g;
    }

    public String ezb() throws IOException {
        String str;
        int i = this.pKV;
        if (i == 0) {
            i = ezw();
        }
        if (i == 10) {
            str = ezz();
        } else if (i == 8) {
            str = g('\'');
        } else if (i == 9) {
            str = g('\"');
        } else if (i == 11) {
            str = this.pKY;
            this.pKY = null;
        } else if (i == 15) {
            str = Long.toString(this.pKW);
        } else if (i == 16) {
            str = new String(this.pKS, this.pos, this.pKX);
            this.pos += this.pKX;
        } else {
            throw new IllegalStateException("Expected a string but was " + eyX() + ezj());
        }
        this.pKV = 0;
        int[] iArr = this.pIU;
        int i2 = this.pIS - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    public boolean ezc() throws IOException {
        int i = this.pKV;
        if (i == 0) {
            i = ezw();
        }
        if (i == 5) {
            this.pKV = 0;
            int[] iArr = this.pIU;
            int i2 = this.pIS - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        } else if (i == 6) {
            this.pKV = 0;
            int[] iArr2 = this.pIU;
            int i3 = this.pIS - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + eyX() + ezj());
        }
    }

    public void ezd() throws IOException {
        int i = this.pKV;
        if (i == 0) {
            i = ezw();
        }
        if (i == 7) {
            this.pKV = 0;
            int[] iArr = this.pIU;
            int i2 = this.pIS - 1;
            iArr[i2] = iArr[i2] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + eyX() + ezj());
    }

    public double eze() throws IOException {
        int i = this.pKV;
        if (i == 0) {
            i = ezw();
        }
        if (i == 15) {
            this.pKV = 0;
            int[] iArr = this.pIU;
            int i2 = this.pIS - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.pKW;
        }
        if (i == 16) {
            this.pKY = new String(this.pKS, this.pos, this.pKX);
            this.pos += this.pKX;
        } else if (i == 8 || i == 9) {
            this.pKY = g(i == 8 ? '\'' : '\"');
        } else if (i == 10) {
            this.pKY = ezz();
        } else if (i != 11) {
            throw new IllegalStateException("Expected a double but was " + eyX() + ezj());
        }
        this.pKV = 11;
        double parseDouble = Double.parseDouble(this.pKY);
        if (!this.lenient && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + parseDouble + ezj());
        }
        this.pKY = null;
        this.pKV = 0;
        int[] iArr2 = this.pIU;
        int i3 = this.pIS - 1;
        iArr2[i3] = iArr2[i3] + 1;
        return parseDouble;
    }

    public long ezf() throws IOException {
        int i = this.pKV;
        if (i == 0) {
            i = ezw();
        }
        if (i == 15) {
            this.pKV = 0;
            int[] iArr = this.pIU;
            int i2 = this.pIS - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.pKW;
        }
        if (i == 16) {
            this.pKY = new String(this.pKS, this.pos, this.pKX);
            this.pos += this.pKX;
        } else if (i == 8 || i == 9 || i == 10) {
            if (i == 10) {
                this.pKY = ezz();
            } else {
                this.pKY = g(i == 8 ? '\'' : '\"');
            }
            try {
                long parseLong = Long.parseLong(this.pKY);
                this.pKV = 0;
                int[] iArr2 = this.pIU;
                int i3 = this.pIS - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return parseLong;
            } catch (NumberFormatException e) {
            }
        } else {
            throw new IllegalStateException("Expected a long but was " + eyX() + ezj());
        }
        this.pKV = 11;
        double parseDouble = Double.parseDouble(this.pKY);
        long j = (long) parseDouble;
        if (j != parseDouble) {
            throw new NumberFormatException("Expected a long but was " + this.pKY + ezj());
        }
        this.pKY = null;
        this.pKV = 0;
        int[] iArr3 = this.pIU;
        int i4 = this.pIS - 1;
        iArr3[i4] = iArr3[i4] + 1;
        return j;
    }

    private String g(char c) throws IOException {
        int i;
        char[] cArr = this.pKS;
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
                        this.pKT++;
                        this.pKU = i6;
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
        } while (Qd(1));
        throw YL("Unterminated string");
    }

    private String ezz() throws IOException {
        StringBuilder sb = null;
        int i = 0;
        while (true) {
            if (this.pos + i < this.limit) {
                switch (this.pKS[this.pos + i]) {
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
                        ezB();
                        break;
                    default:
                        i++;
                }
            } else if (i < this.pKS.length) {
                if (Qd(i + 1)) {
                }
            } else {
                if (sb == null) {
                    sb = new StringBuilder(Math.max(i, 16));
                }
                sb.append(this.pKS, this.pos, i);
                this.pos = i + this.pos;
                if (Qd(1)) {
                    i = 0;
                } else {
                    i = 0;
                }
            }
        }
        String str = sb == null ? new String(this.pKS, this.pos, i) : sb.append(this.pKS, this.pos, i).toString();
        this.pos = i + this.pos;
        return str;
    }

    private void h(char c) throws IOException {
        char[] cArr = this.pKS;
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
                    this.pKT++;
                    this.pKU = i4;
                }
                i3 = i4;
            }
            this.pos = i3;
        } while (Qd(1));
        throw YL("Unterminated string");
    }

    private void ezA() throws IOException {
        do {
            int i = 0;
            while (this.pos + i < this.limit) {
                switch (this.pKS[this.pos + i]) {
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
                        ezB();
                        this.pos = i + this.pos;
                        return;
                    default:
                        i++;
                }
            }
            this.pos = i + this.pos;
        } while (Qd(1));
    }

    public int ezg() throws IOException {
        int i = this.pKV;
        if (i == 0) {
            i = ezw();
        }
        if (i == 15) {
            int i2 = (int) this.pKW;
            if (this.pKW != i2) {
                throw new NumberFormatException("Expected an int but was " + this.pKW + ezj());
            }
            this.pKV = 0;
            int[] iArr = this.pIU;
            int i3 = this.pIS - 1;
            iArr[i3] = iArr[i3] + 1;
            return i2;
        }
        if (i == 16) {
            this.pKY = new String(this.pKS, this.pos, this.pKX);
            this.pos += this.pKX;
        } else if (i == 8 || i == 9 || i == 10) {
            if (i == 10) {
                this.pKY = ezz();
            } else {
                this.pKY = g(i == 8 ? '\'' : '\"');
            }
            try {
                int parseInt = Integer.parseInt(this.pKY);
                this.pKV = 0;
                int[] iArr2 = this.pIU;
                int i4 = this.pIS - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseInt;
            } catch (NumberFormatException e) {
            }
        } else {
            throw new IllegalStateException("Expected an int but was " + eyX() + ezj());
        }
        this.pKV = 11;
        double parseDouble = Double.parseDouble(this.pKY);
        int i5 = (int) parseDouble;
        if (i5 != parseDouble) {
            throw new NumberFormatException("Expected an int but was " + this.pKY + ezj());
        }
        this.pKY = null;
        this.pKV = 0;
        int[] iArr3 = this.pIU;
        int i6 = this.pIS - 1;
        iArr3[i6] = iArr3[i6] + 1;
        return i5;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.pKV = 0;
        this.pKZ[0] = 8;
        this.pIS = 1;
        this.pKR.close();
    }

    public void ezh() throws IOException {
        int i = 0;
        do {
            int i2 = this.pKV;
            if (i2 == 0) {
                i2 = ezw();
            }
            if (i2 == 3) {
                push(1);
                i++;
            } else if (i2 == 1) {
                push(3);
                i++;
            } else if (i2 == 4) {
                this.pIS--;
                i--;
            } else if (i2 == 2) {
                this.pIS--;
                i--;
            } else if (i2 == 14 || i2 == 10) {
                ezA();
            } else if (i2 == 8 || i2 == 12) {
                h('\'');
            } else if (i2 == 9 || i2 == 13) {
                h('\"');
            } else if (i2 == 16) {
                this.pos += this.pKX;
            }
            this.pKV = 0;
        } while (i != 0);
        int[] iArr = this.pIU;
        int i3 = this.pIS - 1;
        iArr[i3] = iArr[i3] + 1;
        this.pIT[this.pIS - 1] = "null";
    }

    private void push(int i) {
        if (this.pIS == this.pKZ.length) {
            int[] iArr = new int[this.pIS * 2];
            int[] iArr2 = new int[this.pIS * 2];
            String[] strArr = new String[this.pIS * 2];
            System.arraycopy(this.pKZ, 0, iArr, 0, this.pIS);
            System.arraycopy(this.pIU, 0, iArr2, 0, this.pIS);
            System.arraycopy(this.pIT, 0, strArr, 0, this.pIS);
            this.pKZ = iArr;
            this.pIU = iArr2;
            this.pIT = strArr;
        }
        int[] iArr3 = this.pKZ;
        int i2 = this.pIS;
        this.pIS = i2 + 1;
        iArr3[i2] = i;
    }

    private boolean Qd(int i) throws IOException {
        char[] cArr = this.pKS;
        this.pKU -= this.pos;
        if (this.limit != this.pos) {
            this.limit -= this.pos;
            System.arraycopy(cArr, this.pos, cArr, 0, this.limit);
        } else {
            this.limit = 0;
        }
        this.pos = 0;
        do {
            int read = this.pKR.read(cArr, this.limit, cArr.length - this.limit);
            if (read == -1) {
                return false;
            }
            this.limit = read + this.limit;
            if (this.pKT == 0 && this.pKU == 0 && this.limit > 0 && cArr[0] == 65279) {
                this.pos++;
                this.pKU++;
                i++;
            }
        } while (this.limit < i);
        return true;
    }

    private int Bi(boolean z) throws IOException {
        char[] cArr = this.pKS;
        int i = this.pos;
        int i2 = this.limit;
        while (true) {
            if (i == i2) {
                this.pos = i;
                if (Qd(1)) {
                    i = this.pos;
                    i2 = this.limit;
                } else if (z) {
                    throw new EOFException("End of input" + ezj());
                } else {
                    return -1;
                }
            }
            int i3 = i + 1;
            char c = cArr[i];
            if (c == '\n') {
                this.pKT++;
                this.pKU = i3;
                i = i3;
            } else if (c == ' ' || c == '\r') {
                i = i3;
            } else if (c == '\t') {
                i = i3;
            } else if (c == '/') {
                this.pos = i3;
                if (i3 == i2) {
                    this.pos--;
                    boolean Qd = Qd(2);
                    this.pos++;
                    if (!Qd) {
                        return c;
                    }
                }
                ezB();
                switch (cArr[this.pos]) {
                    case '*':
                        this.pos++;
                        if (!YK("*/")) {
                            throw YL("Unterminated comment");
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
                ezB();
                skipToEndOfLine();
                i = this.pos;
                i2 = this.limit;
            } else {
                this.pos = i3;
                return c;
            }
        }
    }

    private void ezB() throws IOException {
        if (!this.lenient) {
            throw YL("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void skipToEndOfLine() throws IOException {
        char c;
        do {
            if (this.pos < this.limit || Qd(1)) {
                char[] cArr = this.pKS;
                int i = this.pos;
                this.pos = i + 1;
                c = cArr[i];
                if (c == '\n') {
                    this.pKT++;
                    this.pKU = this.pos;
                    return;
                }
            } else {
                return;
            }
        } while (c != '\r');
    }

    private boolean YK(String str) throws IOException {
        int i;
        int length = str.length();
        while (true) {
            if (this.pos + length > this.limit && !Qd(length)) {
                return false;
            }
            if (this.pKS[this.pos] == '\n') {
                this.pKT++;
                this.pKU = this.pos + 1;
            } else {
                for (i = 0; i < length; i = i + 1) {
                    i = this.pKS[this.pos + i] == str.charAt(i) ? i + 1 : 0;
                }
                return true;
            }
            this.pos++;
        }
    }

    public String toString() {
        return getClass().getSimpleName() + ezj();
    }

    String ezj() {
        return " at line " + (this.pKT + 1) + " column " + ((this.pos - this.pKU) + 1) + " path " + getPath();
    }

    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = this.pIS;
        for (int i2 = 0; i2 < i; i2++) {
            switch (this.pKZ[i2]) {
                case 1:
                case 2:
                    append.append('[').append(this.pIU[i2]).append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    append.append('.');
                    if (this.pIT[i2] != null) {
                        append.append(this.pIT[i2]);
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
        if (this.pos == this.limit && !Qd(1)) {
            throw YL("Unterminated escape sequence");
        }
        char[] cArr = this.pKS;
        int i2 = this.pos;
        this.pos = i2 + 1;
        char c = cArr[i2];
        switch (c) {
            case '\n':
                this.pKT++;
                this.pKU = this.pos;
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
                if (this.pos + 4 > this.limit && !Qd(4)) {
                    throw YL("Unterminated escape sequence");
                }
                char c2 = 0;
                int i3 = this.pos;
                int i4 = i3 + 4;
                while (i3 < i4) {
                    char c3 = this.pKS[i3];
                    char c4 = (char) (c2 << 4);
                    if (c3 >= '0' && c3 <= '9') {
                        i = c3 - '0';
                    } else if (c3 >= 'a' && c3 <= 'f') {
                        i = (c3 - 'a') + 10;
                    } else if (c3 >= 'A' && c3 <= 'F') {
                        i = (c3 - 'A') + 10;
                    } else {
                        throw new NumberFormatException("\\u" + new String(this.pKS, this.pos, 4));
                    }
                    c2 = (char) (c4 + i);
                    i3++;
                }
                this.pos += 4;
                return c2;
            default:
                throw YL("Invalid escape sequence");
        }
    }

    private IOException YL(String str) throws IOException {
        throw new MalformedJsonException(str + ezj());
    }

    private void ezC() throws IOException {
        Bi(true);
        this.pos--;
        if (this.pos + pKQ.length <= this.limit || Qd(pKQ.length)) {
            for (int i = 0; i < pKQ.length; i++) {
                if (this.pKS[this.pos + i] != pKQ[i]) {
                    return;
                }
            }
            this.pos += pKQ.length;
        }
    }
}
