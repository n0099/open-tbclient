package com.google.gson.stream;

import com.baidu.webkit.internal.ABTestConstants;
import com.google.gson.internal.a.e;
import com.google.gson.internal.d;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
/* loaded from: classes2.dex */
public class a implements Closeable {
    private static final char[] izy = ")]}'\n".toCharArray();
    private final Reader in;
    private int ixD;
    private String[] ixE;
    private int[] ixF;
    private long izD;
    private int izE;
    private String izF;
    private boolean iwh = false;
    private final char[] izz = new char[1024];
    private int pos = 0;
    private int limit = 0;
    private int izA = 0;
    private int izB = 0;
    int izC = 0;
    private int[] izG = new int[32];

    static {
        d.iwM = new d() { // from class: com.google.gson.stream.a.1
            @Override // com.google.gson.internal.d
            public void g(a aVar) throws IOException {
                if (aVar instanceof e) {
                    ((e) aVar).cbA();
                    return;
                }
                int i = aVar.izC;
                if (i == 0) {
                    i = aVar.cbL();
                }
                if (i == 13) {
                    aVar.izC = 9;
                } else if (i == 12) {
                    aVar.izC = 8;
                } else if (i == 14) {
                    aVar.izC = 10;
                } else {
                    throw new IllegalStateException("Expected a name but was " + aVar.cbx() + aVar.cbB());
                }
            }
        };
    }

    public a(Reader reader) {
        this.ixD = 0;
        int[] iArr = this.izG;
        int i = this.ixD;
        this.ixD = i + 1;
        iArr[i] = 6;
        this.ixE = new String[32];
        this.ixF = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.in = reader;
    }

    public final void setLenient(boolean z) {
        this.iwh = z;
    }

    public final boolean isLenient() {
        return this.iwh;
    }

    public void beginArray() throws IOException {
        int i = this.izC;
        if (i == 0) {
            i = cbL();
        }
        if (i == 3) {
            zh(1);
            this.ixF[this.ixD - 1] = 0;
            this.izC = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + cbx() + cbB());
    }

    public void endArray() throws IOException {
        int i = this.izC;
        if (i == 0) {
            i = cbL();
        }
        if (i == 4) {
            this.ixD--;
            int[] iArr = this.ixF;
            int i2 = this.ixD - 1;
            iArr[i2] = iArr[i2] + 1;
            this.izC = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + cbx() + cbB());
    }

    public void beginObject() throws IOException {
        int i = this.izC;
        if (i == 0) {
            i = cbL();
        }
        if (i == 1) {
            zh(3);
            this.izC = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + cbx() + cbB());
    }

    public void endObject() throws IOException {
        int i = this.izC;
        if (i == 0) {
            i = cbL();
        }
        if (i == 2) {
            this.ixD--;
            this.ixE[this.ixD] = null;
            int[] iArr = this.ixF;
            int i2 = this.ixD - 1;
            iArr[i2] = iArr[i2] + 1;
            this.izC = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + cbx() + cbB());
    }

    public boolean hasNext() throws IOException {
        int i = this.izC;
        if (i == 0) {
            i = cbL();
        }
        return (i == 2 || i == 4) ? false : true;
    }

    public JsonToken cbx() throws IOException {
        int i = this.izC;
        if (i == 0) {
            i = cbL();
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
    int cbL() throws IOException {
        int i = this.izG[this.ixD - 1];
        if (i == 1) {
            this.izG[this.ixD - 1] = 2;
        } else if (i == 2) {
            switch (ph(true)) {
                case 44:
                    break;
                case 59:
                    cbQ();
                    break;
                case 93:
                    this.izC = 4;
                    return 4;
                default:
                    throw zz("Unterminated array");
            }
        } else if (i == 3 || i == 5) {
            this.izG[this.ixD - 1] = 4;
            if (i == 5) {
                switch (ph(true)) {
                    case 44:
                        break;
                    case 59:
                        cbQ();
                        break;
                    case 125:
                        this.izC = 2;
                        return 2;
                    default:
                        throw zz("Unterminated object");
                }
            }
            int ph = ph(true);
            switch (ph) {
                case 34:
                    this.izC = 13;
                    return 13;
                case 39:
                    cbQ();
                    this.izC = 12;
                    return 12;
                case 125:
                    if (i != 5) {
                        this.izC = 2;
                        return 2;
                    }
                    throw zz("Expected name");
                default:
                    cbQ();
                    this.pos--;
                    if (h((char) ph)) {
                        this.izC = 14;
                        return 14;
                    }
                    throw zz("Expected name");
            }
        } else if (i == 4) {
            this.izG[this.ixD - 1] = 5;
            switch (ph(true)) {
                case 58:
                    break;
                case 59:
                case 60:
                default:
                    throw zz("Expected ':'");
                case 61:
                    cbQ();
                    if ((this.pos < this.limit || zi(1)) && this.izz[this.pos] == '>') {
                        this.pos++;
                        break;
                    }
                    break;
            }
        } else if (i == 6) {
            if (this.iwh) {
                cbT();
            }
            this.izG[this.ixD - 1] = 7;
        } else if (i == 7) {
            if (ph(false) == -1) {
                this.izC = 17;
                return 17;
            }
            cbQ();
            this.pos--;
        } else if (i == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        switch (ph(true)) {
            case 34:
                this.izC = 9;
                return 9;
            case 39:
                cbQ();
                this.izC = 8;
                return 8;
            case 44:
            case 59:
                break;
            case 91:
                this.izC = 3;
                return 3;
            case 93:
                if (i == 1) {
                    this.izC = 4;
                    return 4;
                }
                break;
            case 123:
                this.izC = 1;
                return 1;
            default:
                this.pos--;
                int cbM = cbM();
                if (cbM == 0) {
                    int cbN = cbN();
                    if (cbN == 0) {
                        if (!h(this.izz[this.pos])) {
                            throw zz("Expected value");
                        }
                        cbQ();
                        this.izC = 10;
                        return 10;
                    }
                    return cbN;
                }
                return cbM;
        }
        if (i == 1 || i == 2) {
            cbQ();
            this.pos--;
            this.izC = 7;
            return 7;
        }
        throw zz("Unexpected value");
    }

    private int cbM() throws IOException {
        String str;
        String str2;
        int i;
        char c = this.izz[this.pos];
        if (c == 't' || c == 'T') {
            str = "true";
            str2 = "TRUE";
            i = 5;
        } else if (c == 'f' || c == 'F') {
            str = ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE;
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
            if (this.pos + i2 >= this.limit && !zi(i2 + 1)) {
                return 0;
            }
            char c2 = this.izz[this.pos + i2];
            if (c2 != str.charAt(i2) && c2 != str2.charAt(i2)) {
                return 0;
            }
        }
        if ((this.pos + length < this.limit || zi(length + 1)) && h(this.izz[this.pos + length])) {
            return 0;
        }
        this.pos += length;
        this.izC = i;
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:105:?, code lost:
        return 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:?, code lost:
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0021, code lost:
        if (r3 != 2) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        if (r4 == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0029, code lost:
        if (r6 != Long.MIN_VALUE) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002b, code lost:
        if (r5 == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002d, code lost:
        if (r5 == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002f, code lost:
        r15.izD = r6;
        r15.pos += r10;
        r15.izC = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0052, code lost:
        if (h(r2) == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0054, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00dc, code lost:
        r6 = -r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00e0, code lost:
        if (r3 == 2) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x00e3, code lost:
        if (r3 == 4) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x00e6, code lost:
        if (r3 != 7) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x00e8, code lost:
        r15.izE = r10;
        r15.izC = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x00f0, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int cbN() throws IOException {
        char c;
        boolean z;
        boolean z2;
        char[] cArr = this.izz;
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
                if (zi(i2 + 1)) {
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
                    break;
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

    private boolean h(char c) throws IOException {
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
            case '{':
            case '}':
                break;
            default:
                return true;
            case '#':
            case '/':
            case ';':
            case '=':
            case '\\':
                cbQ();
                break;
        }
        return false;
    }

    public String nextName() throws IOException {
        String i;
        int i2 = this.izC;
        if (i2 == 0) {
            i2 = cbL();
        }
        if (i2 == 14) {
            i = cbO();
        } else if (i2 == 12) {
            i = i('\'');
        } else if (i2 == 13) {
            i = i('\"');
        } else {
            throw new IllegalStateException("Expected a name but was " + cbx() + cbB());
        }
        this.izC = 0;
        this.ixE[this.ixD - 1] = i;
        return i;
    }

    public String nextString() throws IOException {
        String str;
        int i = this.izC;
        if (i == 0) {
            i = cbL();
        }
        if (i == 10) {
            str = cbO();
        } else if (i == 8) {
            str = i('\'');
        } else if (i == 9) {
            str = i('\"');
        } else if (i == 11) {
            str = this.izF;
            this.izF = null;
        } else if (i == 15) {
            str = Long.toString(this.izD);
        } else if (i == 16) {
            str = new String(this.izz, this.pos, this.izE);
            this.pos += this.izE;
        } else {
            throw new IllegalStateException("Expected a string but was " + cbx() + cbB());
        }
        this.izC = 0;
        int[] iArr = this.ixF;
        int i2 = this.ixD - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    public boolean nextBoolean() throws IOException {
        int i = this.izC;
        if (i == 0) {
            i = cbL();
        }
        if (i == 5) {
            this.izC = 0;
            int[] iArr = this.ixF;
            int i2 = this.ixD - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        } else if (i == 6) {
            this.izC = 0;
            int[] iArr2 = this.ixF;
            int i3 = this.ixD - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + cbx() + cbB());
        }
    }

    public void nextNull() throws IOException {
        int i = this.izC;
        if (i == 0) {
            i = cbL();
        }
        if (i == 7) {
            this.izC = 0;
            int[] iArr = this.ixF;
            int i2 = this.ixD - 1;
            iArr[i2] = iArr[i2] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + cbx() + cbB());
    }

    public double nextDouble() throws IOException {
        int i = this.izC;
        if (i == 0) {
            i = cbL();
        }
        if (i == 15) {
            this.izC = 0;
            int[] iArr = this.ixF;
            int i2 = this.ixD - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.izD;
        }
        if (i == 16) {
            this.izF = new String(this.izz, this.pos, this.izE);
            this.pos += this.izE;
        } else if (i == 8 || i == 9) {
            this.izF = i(i == 8 ? '\'' : '\"');
        } else if (i == 10) {
            this.izF = cbO();
        } else if (i != 11) {
            throw new IllegalStateException("Expected a double but was " + cbx() + cbB());
        }
        this.izC = 11;
        double parseDouble = Double.parseDouble(this.izF);
        if (!this.iwh && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + parseDouble + cbB());
        }
        this.izF = null;
        this.izC = 0;
        int[] iArr2 = this.ixF;
        int i3 = this.ixD - 1;
        iArr2[i3] = iArr2[i3] + 1;
        return parseDouble;
    }

    public long nextLong() throws IOException {
        int i = this.izC;
        if (i == 0) {
            i = cbL();
        }
        if (i == 15) {
            this.izC = 0;
            int[] iArr = this.ixF;
            int i2 = this.ixD - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.izD;
        }
        if (i == 16) {
            this.izF = new String(this.izz, this.pos, this.izE);
            this.pos += this.izE;
        } else if (i == 8 || i == 9 || i == 10) {
            if (i == 10) {
                this.izF = cbO();
            } else {
                this.izF = i(i == 8 ? '\'' : '\"');
            }
            try {
                long parseLong = Long.parseLong(this.izF);
                this.izC = 0;
                int[] iArr2 = this.ixF;
                int i3 = this.ixD - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return parseLong;
            } catch (NumberFormatException e) {
            }
        } else {
            throw new IllegalStateException("Expected a long but was " + cbx() + cbB());
        }
        this.izC = 11;
        double parseDouble = Double.parseDouble(this.izF);
        long j = (long) parseDouble;
        if (j != parseDouble) {
            throw new NumberFormatException("Expected a long but was " + this.izF + cbB());
        }
        this.izF = null;
        this.izC = 0;
        int[] iArr3 = this.ixF;
        int i4 = this.ixD - 1;
        iArr3[i4] = iArr3[i4] + 1;
        return j;
    }

    private String i(char c) throws IOException {
        char[] cArr = this.izz;
        StringBuilder sb = new StringBuilder();
        do {
            int i = this.pos;
            int i2 = this.limit;
            int i3 = i;
            while (i3 < i2) {
                int i4 = i3 + 1;
                char c2 = cArr[i3];
                if (c2 == c) {
                    this.pos = i4;
                    sb.append(cArr, i, (i4 - i) - 1);
                    return sb.toString();
                }
                if (c2 == '\\') {
                    this.pos = i4;
                    sb.append(cArr, i, (i4 - i) - 1);
                    sb.append(cbS());
                    i = this.pos;
                    i2 = this.limit;
                    i4 = i;
                } else if (c2 == '\n') {
                    this.izA++;
                    this.izB = i4;
                }
                i3 = i4;
            }
            sb.append(cArr, i, i3 - i);
            this.pos = i3;
        } while (zi(1));
        throw zz("Unterminated string");
    }

    private String cbO() throws IOException {
        String sb;
        StringBuilder sb2 = null;
        int i = 0;
        while (true) {
            if (this.pos + i < this.limit) {
                switch (this.izz[this.pos + i]) {
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
                        cbQ();
                        break;
                    default:
                        i++;
                }
            } else if (i < this.izz.length) {
                if (zi(i + 1)) {
                }
            } else {
                if (sb2 == null) {
                    sb2 = new StringBuilder();
                }
                sb2.append(this.izz, this.pos, i);
                this.pos = i + this.pos;
                if (zi(1)) {
                    i = 0;
                } else {
                    i = 0;
                }
            }
        }
        if (sb2 == null) {
            sb = new String(this.izz, this.pos, i);
        } else {
            sb2.append(this.izz, this.pos, i);
            sb = sb2.toString();
        }
        this.pos = i + this.pos;
        return sb;
    }

    private void j(char c) throws IOException {
        char[] cArr = this.izz;
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
                    cbS();
                    i4 = this.pos;
                    i2 = this.limit;
                } else if (c2 == '\n') {
                    this.izA++;
                    this.izB = i4;
                }
                i3 = i4;
            }
            this.pos = i3;
        } while (zi(1));
        throw zz("Unterminated string");
    }

    private void cbP() throws IOException {
        do {
            int i = 0;
            while (this.pos + i < this.limit) {
                switch (this.izz[this.pos + i]) {
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
                        this.pos = i + this.pos;
                        return;
                    case '#':
                    case '/':
                    case ';':
                    case '=':
                    case '\\':
                        cbQ();
                        this.pos = i + this.pos;
                        return;
                    default:
                        i++;
                }
            }
            this.pos = i + this.pos;
        } while (zi(1));
    }

    public int nextInt() throws IOException {
        int i = this.izC;
        if (i == 0) {
            i = cbL();
        }
        if (i == 15) {
            int i2 = (int) this.izD;
            if (this.izD != i2) {
                throw new NumberFormatException("Expected an int but was " + this.izD + cbB());
            }
            this.izC = 0;
            int[] iArr = this.ixF;
            int i3 = this.ixD - 1;
            iArr[i3] = iArr[i3] + 1;
            return i2;
        }
        if (i == 16) {
            this.izF = new String(this.izz, this.pos, this.izE);
            this.pos += this.izE;
        } else if (i == 8 || i == 9 || i == 10) {
            if (i == 10) {
                this.izF = cbO();
            } else {
                this.izF = i(i == 8 ? '\'' : '\"');
            }
            try {
                int parseInt = Integer.parseInt(this.izF);
                this.izC = 0;
                int[] iArr2 = this.ixF;
                int i4 = this.ixD - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseInt;
            } catch (NumberFormatException e) {
            }
        } else {
            throw new IllegalStateException("Expected an int but was " + cbx() + cbB());
        }
        this.izC = 11;
        double parseDouble = Double.parseDouble(this.izF);
        int i5 = (int) parseDouble;
        if (i5 != parseDouble) {
            throw new NumberFormatException("Expected an int but was " + this.izF + cbB());
        }
        this.izF = null;
        this.izC = 0;
        int[] iArr3 = this.ixF;
        int i6 = this.ixD - 1;
        iArr3[i6] = iArr3[i6] + 1;
        return i5;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.izC = 0;
        this.izG[0] = 8;
        this.ixD = 1;
        this.in.close();
    }

    public void skipValue() throws IOException {
        int i = 0;
        do {
            int i2 = this.izC;
            if (i2 == 0) {
                i2 = cbL();
            }
            if (i2 == 3) {
                zh(1);
                i++;
            } else if (i2 == 1) {
                zh(3);
                i++;
            } else if (i2 == 4) {
                this.ixD--;
                i--;
            } else if (i2 == 2) {
                this.ixD--;
                i--;
            } else if (i2 == 14 || i2 == 10) {
                cbP();
            } else if (i2 == 8 || i2 == 12) {
                j('\'');
            } else if (i2 == 9 || i2 == 13) {
                j('\"');
            } else if (i2 == 16) {
                this.pos += this.izE;
            }
            this.izC = 0;
        } while (i != 0);
        int[] iArr = this.ixF;
        int i3 = this.ixD - 1;
        iArr[i3] = iArr[i3] + 1;
        this.ixE[this.ixD - 1] = "null";
    }

    private void zh(int i) {
        if (this.ixD == this.izG.length) {
            int[] iArr = new int[this.ixD * 2];
            int[] iArr2 = new int[this.ixD * 2];
            String[] strArr = new String[this.ixD * 2];
            System.arraycopy(this.izG, 0, iArr, 0, this.ixD);
            System.arraycopy(this.ixF, 0, iArr2, 0, this.ixD);
            System.arraycopy(this.ixE, 0, strArr, 0, this.ixD);
            this.izG = iArr;
            this.ixF = iArr2;
            this.ixE = strArr;
        }
        int[] iArr3 = this.izG;
        int i2 = this.ixD;
        this.ixD = i2 + 1;
        iArr3[i2] = i;
    }

    private boolean zi(int i) throws IOException {
        char[] cArr = this.izz;
        this.izB -= this.pos;
        if (this.limit != this.pos) {
            this.limit -= this.pos;
            System.arraycopy(cArr, this.pos, cArr, 0, this.limit);
        } else {
            this.limit = 0;
        }
        this.pos = 0;
        do {
            int read = this.in.read(cArr, this.limit, cArr.length - this.limit);
            if (read == -1) {
                return false;
            }
            this.limit = read + this.limit;
            if (this.izA == 0 && this.izB == 0 && this.limit > 0 && cArr[0] == 65279) {
                this.pos++;
                this.izB++;
                i++;
            }
        } while (this.limit < i);
        return true;
    }

    private int ph(boolean z) throws IOException {
        char[] cArr = this.izz;
        int i = this.pos;
        int i2 = this.limit;
        while (true) {
            if (i == i2) {
                this.pos = i;
                if (zi(1)) {
                    i = this.pos;
                    i2 = this.limit;
                } else if (z) {
                    throw new EOFException("End of input" + cbB());
                } else {
                    return -1;
                }
            }
            int i3 = i + 1;
            char c = cArr[i];
            if (c == '\n') {
                this.izA++;
                this.izB = i3;
                i = i3;
            } else if (c == ' ' || c == '\r') {
                i = i3;
            } else if (c == '\t') {
                i = i3;
            } else if (c == '/') {
                this.pos = i3;
                if (i3 == i2) {
                    this.pos--;
                    boolean zi = zi(2);
                    this.pos++;
                    if (!zi) {
                        return c;
                    }
                }
                cbQ();
                switch (cArr[this.pos]) {
                    case '*':
                        this.pos++;
                        if (!zy("*/")) {
                            throw zz("Unterminated comment");
                        }
                        i = this.pos + 2;
                        i2 = this.limit;
                        continue;
                    case '/':
                        this.pos++;
                        cbR();
                        i = this.pos;
                        i2 = this.limit;
                        continue;
                    default:
                        return c;
                }
            } else if (c == '#') {
                this.pos = i3;
                cbQ();
                cbR();
                i = this.pos;
                i2 = this.limit;
            } else {
                this.pos = i3;
                return c;
            }
        }
    }

    private void cbQ() throws IOException {
        if (!this.iwh) {
            throw zz("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void cbR() throws IOException {
        char c;
        do {
            if (this.pos < this.limit || zi(1)) {
                char[] cArr = this.izz;
                int i = this.pos;
                this.pos = i + 1;
                c = cArr[i];
                if (c == '\n') {
                    this.izA++;
                    this.izB = this.pos;
                    return;
                }
            } else {
                return;
            }
        } while (c != '\r');
    }

    private boolean zy(String str) throws IOException {
        int i;
        while (true) {
            if (this.pos + str.length() > this.limit && !zi(str.length())) {
                return false;
            }
            if (this.izz[this.pos] == '\n') {
                this.izA++;
                this.izB = this.pos + 1;
            } else {
                for (i = 0; i < str.length(); i = i + 1) {
                    i = this.izz[this.pos + i] == str.charAt(i) ? i + 1 : 0;
                }
                return true;
            }
            this.pos++;
        }
    }

    public String toString() {
        return getClass().getSimpleName() + cbB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cbB() {
        return " at line " + (this.izA + 1) + " column " + ((this.pos - this.izB) + 1) + " path " + getPath();
    }

    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = this.ixD;
        for (int i2 = 0; i2 < i; i2++) {
            switch (this.izG[i2]) {
                case 1:
                case 2:
                    append.append('[').append(this.ixF[i2]).append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    append.append('.');
                    if (this.ixE[i2] != null) {
                        append.append(this.ixE[i2]);
                        break;
                    } else {
                        break;
                    }
            }
        }
        return append.toString();
    }

    private char cbS() throws IOException {
        int i;
        if (this.pos == this.limit && !zi(1)) {
            throw zz("Unterminated escape sequence");
        }
        char[] cArr = this.izz;
        int i2 = this.pos;
        this.pos = i2 + 1;
        char c = cArr[i2];
        switch (c) {
            case '\n':
                this.izA++;
                this.izB = this.pos;
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
                if (this.pos + 4 > this.limit && !zi(4)) {
                    throw zz("Unterminated escape sequence");
                }
                int i3 = this.pos;
                int i4 = i3 + 4;
                char c2 = 0;
                for (int i5 = i3; i5 < i4; i5++) {
                    char c3 = this.izz[i5];
                    char c4 = (char) (c2 << 4);
                    if (c3 >= '0' && c3 <= '9') {
                        i = c3 - '0';
                    } else if (c3 >= 'a' && c3 <= 'f') {
                        i = (c3 - 'a') + 10;
                    } else if (c3 >= 'A' && c3 <= 'F') {
                        i = (c3 - 'A') + 10;
                    } else {
                        throw new NumberFormatException("\\u" + new String(this.izz, this.pos, 4));
                    }
                    c2 = (char) (c4 + i);
                }
                this.pos += 4;
                return c2;
            default:
                throw zz("Invalid escape sequence");
        }
    }

    private IOException zz(String str) throws IOException {
        throw new MalformedJsonException(str + cbB());
    }

    private void cbT() throws IOException {
        ph(true);
        this.pos--;
        if (this.pos + izy.length <= this.limit || zi(izy.length)) {
            for (int i = 0; i < izy.length; i++) {
                if (this.izz[this.pos + i] != izy[i]) {
                    return;
                }
            }
            this.pos += izy.length;
        }
    }
}
