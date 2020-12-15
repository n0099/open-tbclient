package com.google.gson.stream;

import com.baidu.android.imsdk.internal.Constants;
import com.google.gson.internal.d;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
/* loaded from: classes5.dex */
public class a implements Closeable {
    private static final char[] pwK = ")]}'\n".toCharArray();
    private int puM;
    private String[] puN;
    private int[] puO;
    private final Reader pwL;
    private long pwQ;
    private int pwR;
    private String pwS;
    private boolean lenient = false;
    private final char[] pwM = new char[1024];
    private int pos = 0;
    private int limit = 0;
    private int pwN = 0;
    private int pwO = 0;
    int pwP = 0;
    private int[] pwT = new int[32];

    static {
        d.pua = new d() { // from class: com.google.gson.stream.a.1
            @Override // com.google.gson.internal.d
            public void a(a aVar) throws IOException {
                if (aVar instanceof com.google.gson.internal.bind.a) {
                    ((com.google.gson.internal.bind.a) aVar).eyK();
                    return;
                }
                int i = aVar.pwP;
                if (i == 0) {
                    i = aVar.eyY();
                }
                if (i == 13) {
                    aVar.pwP = 9;
                } else if (i == 12) {
                    aVar.pwP = 8;
                } else if (i == 14) {
                    aVar.pwP = 10;
                } else {
                    throw new IllegalStateException("Expected a name but was " + aVar.eyz() + aVar.eyL());
                }
            }
        };
    }

    public a(Reader reader) {
        this.puM = 0;
        int[] iArr = this.pwT;
        int i = this.puM;
        this.puM = i + 1;
        iArr[i] = 6;
        this.puN = new String[32];
        this.puO = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.pwL = reader;
    }

    public final void Bd(boolean z) {
        this.lenient = z;
    }

    public final boolean eyX() {
        return this.lenient;
    }

    public void eyx() throws IOException {
        int i = this.pwP;
        if (i == 0) {
            i = eyY();
        }
        if (i == 3) {
            push(1);
            this.puO[this.puM - 1] = 0;
            this.pwP = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + eyz() + eyL());
    }

    public void endArray() throws IOException {
        int i = this.pwP;
        if (i == 0) {
            i = eyY();
        }
        if (i == 4) {
            this.puM--;
            int[] iArr = this.puO;
            int i2 = this.puM - 1;
            iArr[i2] = iArr[i2] + 1;
            this.pwP = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + eyz() + eyL());
    }

    public void eyy() throws IOException {
        int i = this.pwP;
        if (i == 0) {
            i = eyY();
        }
        if (i == 1) {
            push(3);
            this.pwP = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + eyz() + eyL());
    }

    public void endObject() throws IOException {
        int i = this.pwP;
        if (i == 0) {
            i = eyY();
        }
        if (i == 2) {
            this.puM--;
            this.puN[this.puM] = null;
            int[] iArr = this.puO;
            int i2 = this.puM - 1;
            iArr[i2] = iArr[i2] + 1;
            this.pwP = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + eyz() + eyL());
    }

    public boolean hasNext() throws IOException {
        int i = this.pwP;
        if (i == 0) {
            i = eyY();
        }
        return (i == 2 || i == 4) ? false : true;
    }

    public JsonToken eyz() throws IOException {
        int i = this.pwP;
        if (i == 0) {
            i = eyY();
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
    int eyY() throws IOException {
        int i = this.pwT[this.puM - 1];
        if (i == 1) {
            this.pwT[this.puM - 1] = 2;
        } else if (i == 2) {
            switch (Be(true)) {
                case 44:
                    break;
                case 59:
                    ezd();
                    break;
                case 93:
                    this.pwP = 4;
                    return 4;
                default:
                    throw ZI("Unterminated array");
            }
        } else if (i == 3 || i == 5) {
            this.pwT[this.puM - 1] = 4;
            if (i == 5) {
                switch (Be(true)) {
                    case 44:
                        break;
                    case 59:
                        ezd();
                        break;
                    case Constants.METHOD_IM_FRIEND_GROUP_ASSIGN /* 125 */:
                        this.pwP = 2;
                        return 2;
                    default:
                        throw ZI("Unterminated object");
                }
            }
            int Be = Be(true);
            switch (Be) {
                case 34:
                    this.pwP = 13;
                    return 13;
                case 39:
                    ezd();
                    this.pwP = 12;
                    return 12;
                case Constants.METHOD_IM_FRIEND_GROUP_ASSIGN /* 125 */:
                    if (i != 5) {
                        this.pwP = 2;
                        return 2;
                    }
                    throw ZI("Expected name");
                default:
                    ezd();
                    this.pos--;
                    if (f((char) Be)) {
                        this.pwP = 14;
                        return 14;
                    }
                    throw ZI("Expected name");
            }
        } else if (i == 4) {
            this.pwT[this.puM - 1] = 5;
            switch (Be(true)) {
                case 58:
                    break;
                case 59:
                case 60:
                default:
                    throw ZI("Expected ':'");
                case 61:
                    ezd();
                    if ((this.pos < this.limit || Rx(1)) && this.pwM[this.pos] == '>') {
                        this.pos++;
                        break;
                    }
                    break;
            }
        } else if (i == 6) {
            if (this.lenient) {
                eze();
            }
            this.pwT[this.puM - 1] = 7;
        } else if (i == 7) {
            if (Be(false) == -1) {
                this.pwP = 17;
                return 17;
            }
            ezd();
            this.pos--;
        } else if (i == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        switch (Be(true)) {
            case 34:
                this.pwP = 9;
                return 9;
            case 39:
                ezd();
                this.pwP = 8;
                return 8;
            case 44:
            case 59:
                break;
            case 91:
                this.pwP = 3;
                return 3;
            case 93:
                if (i == 1) {
                    this.pwP = 4;
                    return 4;
                }
                break;
            case Constants.METHOD_IM_FRIEND_GROUP_QUERY /* 123 */:
                this.pwP = 1;
                return 1;
            default:
                this.pos--;
                int eyZ = eyZ();
                if (eyZ == 0) {
                    int eza = eza();
                    if (eza == 0) {
                        if (!f(this.pwM[this.pos])) {
                            throw ZI("Expected value");
                        }
                        ezd();
                        this.pwP = 10;
                        return 10;
                    }
                    return eza;
                }
                return eyZ;
        }
        if (i == 1 || i == 2) {
            ezd();
            this.pos--;
            this.pwP = 7;
            return 7;
        }
        throw ZI("Unexpected value");
    }

    private int eyZ() throws IOException {
        String str;
        String str2;
        int i;
        char c = this.pwM[this.pos];
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
            if (this.pos + i2 >= this.limit && !Rx(i2 + 1)) {
                return 0;
            }
            char c2 = this.pwM[this.pos + i2];
            if (c2 != str.charAt(i2) && c2 != str2.charAt(i2)) {
                return 0;
            }
        }
        if ((this.pos + length < this.limit || Rx(length + 1)) && f(this.pwM[this.pos + length])) {
            return 0;
        }
        this.pos += length;
        this.pwP = i;
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
        r15.pwQ = r6;
        r15.pos += r10;
        r15.pwP = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005a, code lost:
        if (f(r2) == false) goto L10;
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
        r15.pwR = r10;
        r15.pwP = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x00f8, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int eza() throws IOException {
        char c;
        boolean z;
        boolean z2;
        char[] cArr = this.pwM;
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
                if (Rx(i2 + 1)) {
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
                ezd();
                break;
        }
        return false;
    }

    public String eyC() throws IOException {
        String g;
        int i = this.pwP;
        if (i == 0) {
            i = eyY();
        }
        if (i == 14) {
            g = ezb();
        } else if (i == 12) {
            g = g('\'');
        } else if (i == 13) {
            g = g('\"');
        } else {
            throw new IllegalStateException("Expected a name but was " + eyz() + eyL());
        }
        this.pwP = 0;
        this.puN[this.puM - 1] = g;
        return g;
    }

    public String eyD() throws IOException {
        String str;
        int i = this.pwP;
        if (i == 0) {
            i = eyY();
        }
        if (i == 10) {
            str = ezb();
        } else if (i == 8) {
            str = g('\'');
        } else if (i == 9) {
            str = g('\"');
        } else if (i == 11) {
            str = this.pwS;
            this.pwS = null;
        } else if (i == 15) {
            str = Long.toString(this.pwQ);
        } else if (i == 16) {
            str = new String(this.pwM, this.pos, this.pwR);
            this.pos += this.pwR;
        } else {
            throw new IllegalStateException("Expected a string but was " + eyz() + eyL());
        }
        this.pwP = 0;
        int[] iArr = this.puO;
        int i2 = this.puM - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    public boolean eyE() throws IOException {
        int i = this.pwP;
        if (i == 0) {
            i = eyY();
        }
        if (i == 5) {
            this.pwP = 0;
            int[] iArr = this.puO;
            int i2 = this.puM - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        } else if (i == 6) {
            this.pwP = 0;
            int[] iArr2 = this.puO;
            int i3 = this.puM - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + eyz() + eyL());
        }
    }

    public void eyF() throws IOException {
        int i = this.pwP;
        if (i == 0) {
            i = eyY();
        }
        if (i == 7) {
            this.pwP = 0;
            int[] iArr = this.puO;
            int i2 = this.puM - 1;
            iArr[i2] = iArr[i2] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + eyz() + eyL());
    }

    public double eyG() throws IOException {
        int i = this.pwP;
        if (i == 0) {
            i = eyY();
        }
        if (i == 15) {
            this.pwP = 0;
            int[] iArr = this.puO;
            int i2 = this.puM - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.pwQ;
        }
        if (i == 16) {
            this.pwS = new String(this.pwM, this.pos, this.pwR);
            this.pos += this.pwR;
        } else if (i == 8 || i == 9) {
            this.pwS = g(i == 8 ? '\'' : '\"');
        } else if (i == 10) {
            this.pwS = ezb();
        } else if (i != 11) {
            throw new IllegalStateException("Expected a double but was " + eyz() + eyL());
        }
        this.pwP = 11;
        double parseDouble = Double.parseDouble(this.pwS);
        if (!this.lenient && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + parseDouble + eyL());
        }
        this.pwS = null;
        this.pwP = 0;
        int[] iArr2 = this.puO;
        int i3 = this.puM - 1;
        iArr2[i3] = iArr2[i3] + 1;
        return parseDouble;
    }

    public long eyH() throws IOException {
        int i = this.pwP;
        if (i == 0) {
            i = eyY();
        }
        if (i == 15) {
            this.pwP = 0;
            int[] iArr = this.puO;
            int i2 = this.puM - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.pwQ;
        }
        if (i == 16) {
            this.pwS = new String(this.pwM, this.pos, this.pwR);
            this.pos += this.pwR;
        } else if (i == 8 || i == 9 || i == 10) {
            if (i == 10) {
                this.pwS = ezb();
            } else {
                this.pwS = g(i == 8 ? '\'' : '\"');
            }
            try {
                long parseLong = Long.parseLong(this.pwS);
                this.pwP = 0;
                int[] iArr2 = this.puO;
                int i3 = this.puM - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return parseLong;
            } catch (NumberFormatException e) {
            }
        } else {
            throw new IllegalStateException("Expected a long but was " + eyz() + eyL());
        }
        this.pwP = 11;
        double parseDouble = Double.parseDouble(this.pwS);
        long j = (long) parseDouble;
        if (j != parseDouble) {
            throw new NumberFormatException("Expected a long but was " + this.pwS + eyL());
        }
        this.pwS = null;
        this.pwP = 0;
        int[] iArr3 = this.puO;
        int i4 = this.puM - 1;
        iArr3[i4] = iArr3[i4] + 1;
        return j;
    }

    private String g(char c) throws IOException {
        int i;
        int i2;
        StringBuilder sb;
        int i3;
        char[] cArr = this.pwM;
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
                        this.pwN++;
                        this.pwO = i7;
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
        } while (Rx(1));
        throw ZI("Unterminated string");
    }

    private String ezb() throws IOException {
        StringBuilder sb = null;
        int i = 0;
        while (true) {
            if (this.pos + i < this.limit) {
                switch (this.pwM[this.pos + i]) {
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
                        ezd();
                        break;
                    default:
                        i++;
                }
            } else if (i < this.pwM.length) {
                if (Rx(i + 1)) {
                }
            } else {
                if (sb == null) {
                    sb = new StringBuilder(Math.max(i, 16));
                }
                sb.append(this.pwM, this.pos, i);
                this.pos = i + this.pos;
                if (Rx(1)) {
                    i = 0;
                } else {
                    i = 0;
                }
            }
        }
        String str = sb == null ? new String(this.pwM, this.pos, i) : sb.append(this.pwM, this.pos, i).toString();
        this.pos = i + this.pos;
        return str;
    }

    private void h(char c) throws IOException {
        char[] cArr = this.pwM;
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
                    this.pwN++;
                    this.pwO = i4;
                }
                i3 = i4;
            }
            this.pos = i3;
        } while (Rx(1));
        throw ZI("Unterminated string");
    }

    private void ezc() throws IOException {
        do {
            int i = 0;
            while (this.pos + i < this.limit) {
                switch (this.pwM[this.pos + i]) {
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
                        ezd();
                        this.pos = i + this.pos;
                        return;
                    default:
                        i++;
                }
            }
            this.pos = i + this.pos;
        } while (Rx(1));
    }

    public int eyI() throws IOException {
        int i = this.pwP;
        if (i == 0) {
            i = eyY();
        }
        if (i == 15) {
            int i2 = (int) this.pwQ;
            if (this.pwQ != i2) {
                throw new NumberFormatException("Expected an int but was " + this.pwQ + eyL());
            }
            this.pwP = 0;
            int[] iArr = this.puO;
            int i3 = this.puM - 1;
            iArr[i3] = iArr[i3] + 1;
            return i2;
        }
        if (i == 16) {
            this.pwS = new String(this.pwM, this.pos, this.pwR);
            this.pos += this.pwR;
        } else if (i == 8 || i == 9 || i == 10) {
            if (i == 10) {
                this.pwS = ezb();
            } else {
                this.pwS = g(i == 8 ? '\'' : '\"');
            }
            try {
                int parseInt = Integer.parseInt(this.pwS);
                this.pwP = 0;
                int[] iArr2 = this.puO;
                int i4 = this.puM - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseInt;
            } catch (NumberFormatException e) {
            }
        } else {
            throw new IllegalStateException("Expected an int but was " + eyz() + eyL());
        }
        this.pwP = 11;
        double parseDouble = Double.parseDouble(this.pwS);
        int i5 = (int) parseDouble;
        if (i5 != parseDouble) {
            throw new NumberFormatException("Expected an int but was " + this.pwS + eyL());
        }
        this.pwS = null;
        this.pwP = 0;
        int[] iArr3 = this.puO;
        int i6 = this.puM - 1;
        iArr3[i6] = iArr3[i6] + 1;
        return i5;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.pwP = 0;
        this.pwT[0] = 8;
        this.puM = 1;
        this.pwL.close();
    }

    public void eyJ() throws IOException {
        int i = 0;
        do {
            int i2 = this.pwP;
            if (i2 == 0) {
                i2 = eyY();
            }
            if (i2 == 3) {
                push(1);
                i++;
            } else if (i2 == 1) {
                push(3);
                i++;
            } else if (i2 == 4) {
                this.puM--;
                i--;
            } else if (i2 == 2) {
                this.puM--;
                i--;
            } else if (i2 == 14 || i2 == 10) {
                ezc();
            } else if (i2 == 8 || i2 == 12) {
                h('\'');
            } else if (i2 == 9 || i2 == 13) {
                h('\"');
            } else if (i2 == 16) {
                this.pos += this.pwR;
            }
            this.pwP = 0;
        } while (i != 0);
        int[] iArr = this.puO;
        int i3 = this.puM - 1;
        iArr[i3] = iArr[i3] + 1;
        this.puN[this.puM - 1] = "null";
    }

    private void push(int i) {
        if (this.puM == this.pwT.length) {
            int[] iArr = new int[this.puM * 2];
            int[] iArr2 = new int[this.puM * 2];
            String[] strArr = new String[this.puM * 2];
            System.arraycopy(this.pwT, 0, iArr, 0, this.puM);
            System.arraycopy(this.puO, 0, iArr2, 0, this.puM);
            System.arraycopy(this.puN, 0, strArr, 0, this.puM);
            this.pwT = iArr;
            this.puO = iArr2;
            this.puN = strArr;
        }
        int[] iArr3 = this.pwT;
        int i2 = this.puM;
        this.puM = i2 + 1;
        iArr3[i2] = i;
    }

    private boolean Rx(int i) throws IOException {
        char[] cArr = this.pwM;
        this.pwO -= this.pos;
        if (this.limit != this.pos) {
            this.limit -= this.pos;
            System.arraycopy(cArr, this.pos, cArr, 0, this.limit);
        } else {
            this.limit = 0;
        }
        this.pos = 0;
        do {
            int read = this.pwL.read(cArr, this.limit, cArr.length - this.limit);
            if (read == -1) {
                return false;
            }
            this.limit = read + this.limit;
            if (this.pwN == 0 && this.pwO == 0 && this.limit > 0 && cArr[0] == 65279) {
                this.pos++;
                this.pwO++;
                i++;
            }
        } while (this.limit < i);
        return true;
    }

    private int Be(boolean z) throws IOException {
        char[] cArr = this.pwM;
        int i = this.pos;
        int i2 = this.limit;
        while (true) {
            if (i == i2) {
                this.pos = i;
                if (Rx(1)) {
                    i = this.pos;
                    i2 = this.limit;
                } else if (z) {
                    throw new EOFException("End of input" + eyL());
                } else {
                    return -1;
                }
            }
            int i3 = i + 1;
            char c = cArr[i];
            if (c == '\n') {
                this.pwN++;
                this.pwO = i3;
                i = i3;
            } else if (c == ' ' || c == '\r') {
                i = i3;
            } else if (c == '\t') {
                i = i3;
            } else if (c == '/') {
                this.pos = i3;
                if (i3 == i2) {
                    this.pos--;
                    boolean Rx = Rx(2);
                    this.pos++;
                    if (!Rx) {
                        return c;
                    }
                }
                ezd();
                switch (cArr[this.pos]) {
                    case '*':
                        this.pos++;
                        if (!ZH("*/")) {
                            throw ZI("Unterminated comment");
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
                ezd();
                skipToEndOfLine();
                i = this.pos;
                i2 = this.limit;
            } else {
                this.pos = i3;
                return c;
            }
        }
    }

    private void ezd() throws IOException {
        if (!this.lenient) {
            throw ZI("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void skipToEndOfLine() throws IOException {
        char c;
        do {
            if (this.pos < this.limit || Rx(1)) {
                char[] cArr = this.pwM;
                int i = this.pos;
                this.pos = i + 1;
                c = cArr[i];
                if (c == '\n') {
                    this.pwN++;
                    this.pwO = this.pos;
                    return;
                }
            } else {
                return;
            }
        } while (c != '\r');
    }

    private boolean ZH(String str) throws IOException {
        int i;
        int length = str.length();
        while (true) {
            if (this.pos + length > this.limit && !Rx(length)) {
                return false;
            }
            if (this.pwM[this.pos] == '\n') {
                this.pwN++;
                this.pwO = this.pos + 1;
            } else {
                for (i = 0; i < length; i = i + 1) {
                    i = this.pwM[this.pos + i] == str.charAt(i) ? i + 1 : 0;
                }
                return true;
            }
            this.pos++;
        }
    }

    public String toString() {
        return getClass().getSimpleName() + eyL();
    }

    String eyL() {
        return " at line " + (this.pwN + 1) + " column " + ((this.pos - this.pwO) + 1) + " path " + getPath();
    }

    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = this.puM;
        for (int i2 = 0; i2 < i; i2++) {
            switch (this.pwT[i2]) {
                case 1:
                case 2:
                    append.append('[').append(this.puO[i2]).append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    append.append('.');
                    if (this.puN[i2] != null) {
                        append.append(this.puN[i2]);
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
        if (this.pos == this.limit && !Rx(1)) {
            throw ZI("Unterminated escape sequence");
        }
        char[] cArr = this.pwM;
        int i2 = this.pos;
        this.pos = i2 + 1;
        char c = cArr[i2];
        switch (c) {
            case '\n':
                this.pwN++;
                this.pwO = this.pos;
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
                if (this.pos + 4 > this.limit && !Rx(4)) {
                    throw ZI("Unterminated escape sequence");
                }
                int i3 = this.pos;
                int i4 = i3 + 4;
                char c2 = 0;
                for (int i5 = i3; i5 < i4; i5++) {
                    char c3 = this.pwM[i5];
                    char c4 = (char) (c2 << 4);
                    if (c3 >= '0' && c3 <= '9') {
                        i = c3 - '0';
                    } else if (c3 >= 'a' && c3 <= 'f') {
                        i = (c3 - 'a') + 10;
                    } else if (c3 >= 'A' && c3 <= 'F') {
                        i = (c3 - 'A') + 10;
                    } else {
                        throw new NumberFormatException("\\u" + new String(this.pwM, this.pos, 4));
                    }
                    c2 = (char) (c4 + i);
                }
                this.pos += 4;
                return c2;
            default:
                throw ZI("Invalid escape sequence");
        }
    }

    private IOException ZI(String str) throws IOException {
        throw new MalformedJsonException(str + eyL());
    }

    private void eze() throws IOException {
        Be(true);
        this.pos--;
        if (this.pos + pwK.length <= this.limit || Rx(pwK.length)) {
            for (int i = 0; i < pwK.length; i++) {
                if (this.pwM[this.pos + i] != pwK[i]) {
                    return;
                }
            }
            this.pos += pwK.length;
        }
    }
}
