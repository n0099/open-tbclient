package com.google.gson.stream;

import com.baidu.android.imsdk.internal.Constants;
import com.google.gson.internal.d;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
/* loaded from: classes4.dex */
public class a implements Closeable {
    private static final char[] pWl = ")]}'\n".toCharArray();
    private int pUn;
    private String[] pUo;
    private int[] pUp;
    private final Reader pWm;
    private long pWr;
    private int pWs;
    private String pWt;
    private boolean lenient = false;
    private final char[] pWn = new char[1024];
    private int pos = 0;
    private int limit = 0;
    private int pWo = 0;
    private int pWp = 0;
    int pWq = 0;
    private int[] pWu = new int[32];

    static {
        d.pTC = new d() { // from class: com.google.gson.stream.a.1
            @Override // com.google.gson.internal.d
            public void a(a aVar) throws IOException {
                if (aVar instanceof com.google.gson.internal.bind.a) {
                    ((com.google.gson.internal.bind.a) aVar).eBO();
                    return;
                }
                int i = aVar.pWq;
                if (i == 0) {
                    i = aVar.eCc();
                }
                if (i == 13) {
                    aVar.pWq = 9;
                } else if (i == 12) {
                    aVar.pWq = 8;
                } else if (i == 14) {
                    aVar.pWq = 10;
                } else {
                    throw new IllegalStateException("Expected a name but was " + aVar.eBD() + aVar.eBP());
                }
            }
        };
    }

    public a(Reader reader) {
        this.pUn = 0;
        int[] iArr = this.pWu;
        int i = this.pUn;
        this.pUn = i + 1;
        iArr[i] = 6;
        this.pUo = new String[32];
        this.pUp = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.pWm = reader;
    }

    public final void By(boolean z) {
        this.lenient = z;
    }

    public final boolean eCb() {
        return this.lenient;
    }

    public void eBB() throws IOException {
        int i = this.pWq;
        if (i == 0) {
            i = eCc();
        }
        if (i == 3) {
            push(1);
            this.pUp[this.pUn - 1] = 0;
            this.pWq = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + eBD() + eBP());
    }

    public void endArray() throws IOException {
        int i = this.pWq;
        if (i == 0) {
            i = eCc();
        }
        if (i == 4) {
            this.pUn--;
            int[] iArr = this.pUp;
            int i2 = this.pUn - 1;
            iArr[i2] = iArr[i2] + 1;
            this.pWq = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + eBD() + eBP());
    }

    public void eBC() throws IOException {
        int i = this.pWq;
        if (i == 0) {
            i = eCc();
        }
        if (i == 1) {
            push(3);
            this.pWq = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + eBD() + eBP());
    }

    public void endObject() throws IOException {
        int i = this.pWq;
        if (i == 0) {
            i = eCc();
        }
        if (i == 2) {
            this.pUn--;
            this.pUo[this.pUn] = null;
            int[] iArr = this.pUp;
            int i2 = this.pUn - 1;
            iArr[i2] = iArr[i2] + 1;
            this.pWq = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + eBD() + eBP());
    }

    public boolean hasNext() throws IOException {
        int i = this.pWq;
        if (i == 0) {
            i = eCc();
        }
        return (i == 2 || i == 4) ? false : true;
    }

    public JsonToken eBD() throws IOException {
        int i = this.pWq;
        if (i == 0) {
            i = eCc();
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
    int eCc() throws IOException {
        int i = this.pWu[this.pUn - 1];
        if (i == 1) {
            this.pWu[this.pUn - 1] = 2;
        } else if (i == 2) {
            switch (Bz(true)) {
                case 44:
                    break;
                case 59:
                    eCh();
                    break;
                case 93:
                    this.pWq = 4;
                    return 4;
                default:
                    throw aae("Unterminated array");
            }
        } else if (i == 3 || i == 5) {
            this.pWu[this.pUn - 1] = 4;
            if (i == 5) {
                switch (Bz(true)) {
                    case 44:
                        break;
                    case 59:
                        eCh();
                        break;
                    case Constants.METHOD_IM_FRIEND_GROUP_ASSIGN /* 125 */:
                        this.pWq = 2;
                        return 2;
                    default:
                        throw aae("Unterminated object");
                }
            }
            int Bz = Bz(true);
            switch (Bz) {
                case 34:
                    this.pWq = 13;
                    return 13;
                case 39:
                    eCh();
                    this.pWq = 12;
                    return 12;
                case Constants.METHOD_IM_FRIEND_GROUP_ASSIGN /* 125 */:
                    if (i != 5) {
                        this.pWq = 2;
                        return 2;
                    }
                    throw aae("Expected name");
                default:
                    eCh();
                    this.pos--;
                    if (f((char) Bz)) {
                        this.pWq = 14;
                        return 14;
                    }
                    throw aae("Expected name");
            }
        } else if (i == 4) {
            this.pWu[this.pUn - 1] = 5;
            switch (Bz(true)) {
                case 58:
                    break;
                case 59:
                case 60:
                default:
                    throw aae("Expected ':'");
                case 61:
                    eCh();
                    if ((this.pos < this.limit || QD(1)) && this.pWn[this.pos] == '>') {
                        this.pos++;
                        break;
                    }
                    break;
            }
        } else if (i == 6) {
            if (this.lenient) {
                eCi();
            }
            this.pWu[this.pUn - 1] = 7;
        } else if (i == 7) {
            if (Bz(false) == -1) {
                this.pWq = 17;
                return 17;
            }
            eCh();
            this.pos--;
        } else if (i == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        switch (Bz(true)) {
            case 34:
                this.pWq = 9;
                return 9;
            case 39:
                eCh();
                this.pWq = 8;
                return 8;
            case 44:
            case 59:
                break;
            case 91:
                this.pWq = 3;
                return 3;
            case 93:
                if (i == 1) {
                    this.pWq = 4;
                    return 4;
                }
                break;
            case Constants.METHOD_IM_FRIEND_GROUP_QUERY /* 123 */:
                this.pWq = 1;
                return 1;
            default:
                this.pos--;
                int eCd = eCd();
                if (eCd == 0) {
                    int eCe = eCe();
                    if (eCe == 0) {
                        if (!f(this.pWn[this.pos])) {
                            throw aae("Expected value");
                        }
                        eCh();
                        this.pWq = 10;
                        return 10;
                    }
                    return eCe;
                }
                return eCd;
        }
        if (i == 1 || i == 2) {
            eCh();
            this.pos--;
            this.pWq = 7;
            return 7;
        }
        throw aae("Unexpected value");
    }

    private int eCd() throws IOException {
        String str;
        String str2;
        int i;
        char c = this.pWn[this.pos];
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
            if (this.pos + i2 >= this.limit && !QD(i2 + 1)) {
                return 0;
            }
            char c2 = this.pWn[this.pos + i2];
            if (c2 != str.charAt(i2) && c2 != str2.charAt(i2)) {
                return 0;
            }
        }
        if ((this.pos + length < this.limit || QD(length + 1)) && f(this.pWn[this.pos + length])) {
            return 0;
        }
        this.pos += length;
        this.pWq = i;
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
        r14.pWr = r6;
        r14.pos += r10;
        r14.pWq = 15;
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
        r14.pWs = r10;
        r14.pWq = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x00e1, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int eCe() throws IOException {
        char c;
        char[] cArr = this.pWn;
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
                if (QD(i3 + 1)) {
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
                eCh();
                break;
        }
        return false;
    }

    public String eBG() throws IOException {
        String g;
        int i = this.pWq;
        if (i == 0) {
            i = eCc();
        }
        if (i == 14) {
            g = eCf();
        } else if (i == 12) {
            g = g('\'');
        } else if (i == 13) {
            g = g('\"');
        } else {
            throw new IllegalStateException("Expected a name but was " + eBD() + eBP());
        }
        this.pWq = 0;
        this.pUo[this.pUn - 1] = g;
        return g;
    }

    public String eBH() throws IOException {
        String str;
        int i = this.pWq;
        if (i == 0) {
            i = eCc();
        }
        if (i == 10) {
            str = eCf();
        } else if (i == 8) {
            str = g('\'');
        } else if (i == 9) {
            str = g('\"');
        } else if (i == 11) {
            str = this.pWt;
            this.pWt = null;
        } else if (i == 15) {
            str = Long.toString(this.pWr);
        } else if (i == 16) {
            str = new String(this.pWn, this.pos, this.pWs);
            this.pos += this.pWs;
        } else {
            throw new IllegalStateException("Expected a string but was " + eBD() + eBP());
        }
        this.pWq = 0;
        int[] iArr = this.pUp;
        int i2 = this.pUn - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    public boolean eBI() throws IOException {
        int i = this.pWq;
        if (i == 0) {
            i = eCc();
        }
        if (i == 5) {
            this.pWq = 0;
            int[] iArr = this.pUp;
            int i2 = this.pUn - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        } else if (i == 6) {
            this.pWq = 0;
            int[] iArr2 = this.pUp;
            int i3 = this.pUn - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + eBD() + eBP());
        }
    }

    public void eBJ() throws IOException {
        int i = this.pWq;
        if (i == 0) {
            i = eCc();
        }
        if (i == 7) {
            this.pWq = 0;
            int[] iArr = this.pUp;
            int i2 = this.pUn - 1;
            iArr[i2] = iArr[i2] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + eBD() + eBP());
    }

    public double eBK() throws IOException {
        int i = this.pWq;
        if (i == 0) {
            i = eCc();
        }
        if (i == 15) {
            this.pWq = 0;
            int[] iArr = this.pUp;
            int i2 = this.pUn - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.pWr;
        }
        if (i == 16) {
            this.pWt = new String(this.pWn, this.pos, this.pWs);
            this.pos += this.pWs;
        } else if (i == 8 || i == 9) {
            this.pWt = g(i == 8 ? '\'' : '\"');
        } else if (i == 10) {
            this.pWt = eCf();
        } else if (i != 11) {
            throw new IllegalStateException("Expected a double but was " + eBD() + eBP());
        }
        this.pWq = 11;
        double parseDouble = Double.parseDouble(this.pWt);
        if (!this.lenient && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + parseDouble + eBP());
        }
        this.pWt = null;
        this.pWq = 0;
        int[] iArr2 = this.pUp;
        int i3 = this.pUn - 1;
        iArr2[i3] = iArr2[i3] + 1;
        return parseDouble;
    }

    public long eBL() throws IOException {
        int i = this.pWq;
        if (i == 0) {
            i = eCc();
        }
        if (i == 15) {
            this.pWq = 0;
            int[] iArr = this.pUp;
            int i2 = this.pUn - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.pWr;
        }
        if (i == 16) {
            this.pWt = new String(this.pWn, this.pos, this.pWs);
            this.pos += this.pWs;
        } else if (i == 8 || i == 9 || i == 10) {
            if (i == 10) {
                this.pWt = eCf();
            } else {
                this.pWt = g(i == 8 ? '\'' : '\"');
            }
            try {
                long parseLong = Long.parseLong(this.pWt);
                this.pWq = 0;
                int[] iArr2 = this.pUp;
                int i3 = this.pUn - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return parseLong;
            } catch (NumberFormatException e) {
            }
        } else {
            throw new IllegalStateException("Expected a long but was " + eBD() + eBP());
        }
        this.pWq = 11;
        double parseDouble = Double.parseDouble(this.pWt);
        long j = (long) parseDouble;
        if (j != parseDouble) {
            throw new NumberFormatException("Expected a long but was " + this.pWt + eBP());
        }
        this.pWt = null;
        this.pWq = 0;
        int[] iArr3 = this.pUp;
        int i4 = this.pUn - 1;
        iArr3[i4] = iArr3[i4] + 1;
        return j;
    }

    private String g(char c) throws IOException {
        int i;
        char[] cArr = this.pWn;
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
                        this.pWo++;
                        this.pWp = i6;
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
        } while (QD(1));
        throw aae("Unterminated string");
    }

    private String eCf() throws IOException {
        StringBuilder sb = null;
        int i = 0;
        while (true) {
            if (this.pos + i < this.limit) {
                switch (this.pWn[this.pos + i]) {
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
                        eCh();
                        break;
                    default:
                        i++;
                }
            } else if (i < this.pWn.length) {
                if (QD(i + 1)) {
                }
            } else {
                if (sb == null) {
                    sb = new StringBuilder(Math.max(i, 16));
                }
                sb.append(this.pWn, this.pos, i);
                this.pos = i + this.pos;
                if (QD(1)) {
                    i = 0;
                } else {
                    i = 0;
                }
            }
        }
        String str = sb == null ? new String(this.pWn, this.pos, i) : sb.append(this.pWn, this.pos, i).toString();
        this.pos = i + this.pos;
        return str;
    }

    private void h(char c) throws IOException {
        char[] cArr = this.pWn;
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
                    this.pWo++;
                    this.pWp = i4;
                }
                i3 = i4;
            }
            this.pos = i3;
        } while (QD(1));
        throw aae("Unterminated string");
    }

    private void eCg() throws IOException {
        do {
            int i = 0;
            while (this.pos + i < this.limit) {
                switch (this.pWn[this.pos + i]) {
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
                        eCh();
                        this.pos = i + this.pos;
                        return;
                    default:
                        i++;
                }
            }
            this.pos = i + this.pos;
        } while (QD(1));
    }

    public int eBM() throws IOException {
        int i = this.pWq;
        if (i == 0) {
            i = eCc();
        }
        if (i == 15) {
            int i2 = (int) this.pWr;
            if (this.pWr != i2) {
                throw new NumberFormatException("Expected an int but was " + this.pWr + eBP());
            }
            this.pWq = 0;
            int[] iArr = this.pUp;
            int i3 = this.pUn - 1;
            iArr[i3] = iArr[i3] + 1;
            return i2;
        }
        if (i == 16) {
            this.pWt = new String(this.pWn, this.pos, this.pWs);
            this.pos += this.pWs;
        } else if (i == 8 || i == 9 || i == 10) {
            if (i == 10) {
                this.pWt = eCf();
            } else {
                this.pWt = g(i == 8 ? '\'' : '\"');
            }
            try {
                int parseInt = Integer.parseInt(this.pWt);
                this.pWq = 0;
                int[] iArr2 = this.pUp;
                int i4 = this.pUn - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseInt;
            } catch (NumberFormatException e) {
            }
        } else {
            throw new IllegalStateException("Expected an int but was " + eBD() + eBP());
        }
        this.pWq = 11;
        double parseDouble = Double.parseDouble(this.pWt);
        int i5 = (int) parseDouble;
        if (i5 != parseDouble) {
            throw new NumberFormatException("Expected an int but was " + this.pWt + eBP());
        }
        this.pWt = null;
        this.pWq = 0;
        int[] iArr3 = this.pUp;
        int i6 = this.pUn - 1;
        iArr3[i6] = iArr3[i6] + 1;
        return i5;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.pWq = 0;
        this.pWu[0] = 8;
        this.pUn = 1;
        this.pWm.close();
    }

    public void eBN() throws IOException {
        int i = 0;
        do {
            int i2 = this.pWq;
            if (i2 == 0) {
                i2 = eCc();
            }
            if (i2 == 3) {
                push(1);
                i++;
            } else if (i2 == 1) {
                push(3);
                i++;
            } else if (i2 == 4) {
                this.pUn--;
                i--;
            } else if (i2 == 2) {
                this.pUn--;
                i--;
            } else if (i2 == 14 || i2 == 10) {
                eCg();
            } else if (i2 == 8 || i2 == 12) {
                h('\'');
            } else if (i2 == 9 || i2 == 13) {
                h('\"');
            } else if (i2 == 16) {
                this.pos += this.pWs;
            }
            this.pWq = 0;
        } while (i != 0);
        int[] iArr = this.pUp;
        int i3 = this.pUn - 1;
        iArr[i3] = iArr[i3] + 1;
        this.pUo[this.pUn - 1] = "null";
    }

    private void push(int i) {
        if (this.pUn == this.pWu.length) {
            int[] iArr = new int[this.pUn * 2];
            int[] iArr2 = new int[this.pUn * 2];
            String[] strArr = new String[this.pUn * 2];
            System.arraycopy(this.pWu, 0, iArr, 0, this.pUn);
            System.arraycopy(this.pUp, 0, iArr2, 0, this.pUn);
            System.arraycopy(this.pUo, 0, strArr, 0, this.pUn);
            this.pWu = iArr;
            this.pUp = iArr2;
            this.pUo = strArr;
        }
        int[] iArr3 = this.pWu;
        int i2 = this.pUn;
        this.pUn = i2 + 1;
        iArr3[i2] = i;
    }

    private boolean QD(int i) throws IOException {
        char[] cArr = this.pWn;
        this.pWp -= this.pos;
        if (this.limit != this.pos) {
            this.limit -= this.pos;
            System.arraycopy(cArr, this.pos, cArr, 0, this.limit);
        } else {
            this.limit = 0;
        }
        this.pos = 0;
        do {
            int read = this.pWm.read(cArr, this.limit, cArr.length - this.limit);
            if (read == -1) {
                return false;
            }
            this.limit = read + this.limit;
            if (this.pWo == 0 && this.pWp == 0 && this.limit > 0 && cArr[0] == 65279) {
                this.pos++;
                this.pWp++;
                i++;
            }
        } while (this.limit < i);
        return true;
    }

    private int Bz(boolean z) throws IOException {
        char[] cArr = this.pWn;
        int i = this.pos;
        int i2 = this.limit;
        while (true) {
            if (i == i2) {
                this.pos = i;
                if (QD(1)) {
                    i = this.pos;
                    i2 = this.limit;
                } else if (z) {
                    throw new EOFException("End of input" + eBP());
                } else {
                    return -1;
                }
            }
            int i3 = i + 1;
            char c = cArr[i];
            if (c == '\n') {
                this.pWo++;
                this.pWp = i3;
                i = i3;
            } else if (c == ' ' || c == '\r') {
                i = i3;
            } else if (c == '\t') {
                i = i3;
            } else if (c == '/') {
                this.pos = i3;
                if (i3 == i2) {
                    this.pos--;
                    boolean QD = QD(2);
                    this.pos++;
                    if (!QD) {
                        return c;
                    }
                }
                eCh();
                switch (cArr[this.pos]) {
                    case '*':
                        this.pos++;
                        if (!aad("*/")) {
                            throw aae("Unterminated comment");
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
                eCh();
                skipToEndOfLine();
                i = this.pos;
                i2 = this.limit;
            } else {
                this.pos = i3;
                return c;
            }
        }
    }

    private void eCh() throws IOException {
        if (!this.lenient) {
            throw aae("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void skipToEndOfLine() throws IOException {
        char c;
        do {
            if (this.pos < this.limit || QD(1)) {
                char[] cArr = this.pWn;
                int i = this.pos;
                this.pos = i + 1;
                c = cArr[i];
                if (c == '\n') {
                    this.pWo++;
                    this.pWp = this.pos;
                    return;
                }
            } else {
                return;
            }
        } while (c != '\r');
    }

    private boolean aad(String str) throws IOException {
        int i;
        int length = str.length();
        while (true) {
            if (this.pos + length > this.limit && !QD(length)) {
                return false;
            }
            if (this.pWn[this.pos] == '\n') {
                this.pWo++;
                this.pWp = this.pos + 1;
            } else {
                for (i = 0; i < length; i = i + 1) {
                    i = this.pWn[this.pos + i] == str.charAt(i) ? i + 1 : 0;
                }
                return true;
            }
            this.pos++;
        }
    }

    public String toString() {
        return getClass().getSimpleName() + eBP();
    }

    String eBP() {
        return " at line " + (this.pWo + 1) + " column " + ((this.pos - this.pWp) + 1) + " path " + getPath();
    }

    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = this.pUn;
        for (int i2 = 0; i2 < i; i2++) {
            switch (this.pWu[i2]) {
                case 1:
                case 2:
                    append.append('[').append(this.pUp[i2]).append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    append.append('.');
                    if (this.pUo[i2] != null) {
                        append.append(this.pUo[i2]);
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
        if (this.pos == this.limit && !QD(1)) {
            throw aae("Unterminated escape sequence");
        }
        char[] cArr = this.pWn;
        int i2 = this.pos;
        this.pos = i2 + 1;
        char c = cArr[i2];
        switch (c) {
            case '\n':
                this.pWo++;
                this.pWp = this.pos;
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
                if (this.pos + 4 > this.limit && !QD(4)) {
                    throw aae("Unterminated escape sequence");
                }
                char c2 = 0;
                int i3 = this.pos;
                int i4 = i3 + 4;
                while (i3 < i4) {
                    char c3 = this.pWn[i3];
                    char c4 = (char) (c2 << 4);
                    if (c3 >= '0' && c3 <= '9') {
                        i = c3 - '0';
                    } else if (c3 >= 'a' && c3 <= 'f') {
                        i = (c3 - 'a') + 10;
                    } else if (c3 >= 'A' && c3 <= 'F') {
                        i = (c3 - 'A') + 10;
                    } else {
                        throw new NumberFormatException("\\u" + new String(this.pWn, this.pos, 4));
                    }
                    c2 = (char) (c4 + i);
                    i3++;
                }
                this.pos += 4;
                return c2;
            default:
                throw aae("Invalid escape sequence");
        }
    }

    private IOException aae(String str) throws IOException {
        throw new MalformedJsonException(str + eBP());
    }

    private void eCi() throws IOException {
        Bz(true);
        this.pos--;
        if (this.pos + pWl.length <= this.limit || QD(pWl.length)) {
            for (int i = 0; i < pWl.length; i++) {
                if (this.pWn[this.pos + i] != pWl[i]) {
                    return;
                }
            }
            this.pos += pWl.length;
        }
    }
}
