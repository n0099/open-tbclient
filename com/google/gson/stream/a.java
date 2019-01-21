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
    private static final char[] iAG = ")]}'\n".toCharArray();
    private long iAL;
    private int iAM;
    private String iAN;
    private final Reader in;
    private int iyL;
    private String[] iyM;
    private int[] iyN;
    private boolean ixp = false;
    private final char[] iAH = new char[1024];
    private int pos = 0;
    private int limit = 0;
    private int iAI = 0;
    private int iAJ = 0;
    int iAK = 0;
    private int[] iAO = new int[32];

    static {
        d.ixU = new d() { // from class: com.google.gson.stream.a.1
            @Override // com.google.gson.internal.d
            public void g(a aVar) throws IOException {
                if (aVar instanceof e) {
                    ((e) aVar).cci();
                    return;
                }
                int i = aVar.iAK;
                if (i == 0) {
                    i = aVar.cct();
                }
                if (i == 13) {
                    aVar.iAK = 9;
                } else if (i == 12) {
                    aVar.iAK = 8;
                } else if (i == 14) {
                    aVar.iAK = 10;
                } else {
                    throw new IllegalStateException("Expected a name but was " + aVar.ccf() + aVar.ccj());
                }
            }
        };
    }

    public a(Reader reader) {
        this.iyL = 0;
        int[] iArr = this.iAO;
        int i = this.iyL;
        this.iyL = i + 1;
        iArr[i] = 6;
        this.iyM = new String[32];
        this.iyN = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.in = reader;
    }

    public final void setLenient(boolean z) {
        this.ixp = z;
    }

    public final boolean isLenient() {
        return this.ixp;
    }

    public void beginArray() throws IOException {
        int i = this.iAK;
        if (i == 0) {
            i = cct();
        }
        if (i == 3) {
            zj(1);
            this.iyN[this.iyL - 1] = 0;
            this.iAK = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + ccf() + ccj());
    }

    public void endArray() throws IOException {
        int i = this.iAK;
        if (i == 0) {
            i = cct();
        }
        if (i == 4) {
            this.iyL--;
            int[] iArr = this.iyN;
            int i2 = this.iyL - 1;
            iArr[i2] = iArr[i2] + 1;
            this.iAK = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + ccf() + ccj());
    }

    public void beginObject() throws IOException {
        int i = this.iAK;
        if (i == 0) {
            i = cct();
        }
        if (i == 1) {
            zj(3);
            this.iAK = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + ccf() + ccj());
    }

    public void endObject() throws IOException {
        int i = this.iAK;
        if (i == 0) {
            i = cct();
        }
        if (i == 2) {
            this.iyL--;
            this.iyM[this.iyL] = null;
            int[] iArr = this.iyN;
            int i2 = this.iyL - 1;
            iArr[i2] = iArr[i2] + 1;
            this.iAK = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + ccf() + ccj());
    }

    public boolean hasNext() throws IOException {
        int i = this.iAK;
        if (i == 0) {
            i = cct();
        }
        return (i == 2 || i == 4) ? false : true;
    }

    public JsonToken ccf() throws IOException {
        int i = this.iAK;
        if (i == 0) {
            i = cct();
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
    int cct() throws IOException {
        int i = this.iAO[this.iyL - 1];
        if (i == 1) {
            this.iAO[this.iyL - 1] = 2;
        } else if (i == 2) {
            switch (pi(true)) {
                case 44:
                    break;
                case 59:
                    ccy();
                    break;
                case 93:
                    this.iAK = 4;
                    return 4;
                default:
                    throw zP("Unterminated array");
            }
        } else if (i == 3 || i == 5) {
            this.iAO[this.iyL - 1] = 4;
            if (i == 5) {
                switch (pi(true)) {
                    case 44:
                        break;
                    case 59:
                        ccy();
                        break;
                    case 125:
                        this.iAK = 2;
                        return 2;
                    default:
                        throw zP("Unterminated object");
                }
            }
            int pi = pi(true);
            switch (pi) {
                case 34:
                    this.iAK = 13;
                    return 13;
                case 39:
                    ccy();
                    this.iAK = 12;
                    return 12;
                case 125:
                    if (i != 5) {
                        this.iAK = 2;
                        return 2;
                    }
                    throw zP("Expected name");
                default:
                    ccy();
                    this.pos--;
                    if (h((char) pi)) {
                        this.iAK = 14;
                        return 14;
                    }
                    throw zP("Expected name");
            }
        } else if (i == 4) {
            this.iAO[this.iyL - 1] = 5;
            switch (pi(true)) {
                case 58:
                    break;
                case 59:
                case 60:
                default:
                    throw zP("Expected ':'");
                case 61:
                    ccy();
                    if ((this.pos < this.limit || zk(1)) && this.iAH[this.pos] == '>') {
                        this.pos++;
                        break;
                    }
                    break;
            }
        } else if (i == 6) {
            if (this.ixp) {
                ccB();
            }
            this.iAO[this.iyL - 1] = 7;
        } else if (i == 7) {
            if (pi(false) == -1) {
                this.iAK = 17;
                return 17;
            }
            ccy();
            this.pos--;
        } else if (i == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        switch (pi(true)) {
            case 34:
                this.iAK = 9;
                return 9;
            case 39:
                ccy();
                this.iAK = 8;
                return 8;
            case 44:
            case 59:
                break;
            case 91:
                this.iAK = 3;
                return 3;
            case 93:
                if (i == 1) {
                    this.iAK = 4;
                    return 4;
                }
                break;
            case 123:
                this.iAK = 1;
                return 1;
            default:
                this.pos--;
                int ccu = ccu();
                if (ccu == 0) {
                    int ccv = ccv();
                    if (ccv == 0) {
                        if (!h(this.iAH[this.pos])) {
                            throw zP("Expected value");
                        }
                        ccy();
                        this.iAK = 10;
                        return 10;
                    }
                    return ccv;
                }
                return ccu;
        }
        if (i == 1 || i == 2) {
            ccy();
            this.pos--;
            this.iAK = 7;
            return 7;
        }
        throw zP("Unexpected value");
    }

    private int ccu() throws IOException {
        String str;
        String str2;
        int i;
        char c = this.iAH[this.pos];
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
            if (this.pos + i2 >= this.limit && !zk(i2 + 1)) {
                return 0;
            }
            char c2 = this.iAH[this.pos + i2];
            if (c2 != str.charAt(i2) && c2 != str2.charAt(i2)) {
                return 0;
            }
        }
        if ((this.pos + length < this.limit || zk(length + 1)) && h(this.iAH[this.pos + length])) {
            return 0;
        }
        this.pos += length;
        this.iAK = i;
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
        r15.iAL = r6;
        r15.pos += r10;
        r15.iAK = 15;
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
        r15.iAM = r10;
        r15.iAK = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x00f0, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int ccv() throws IOException {
        char c;
        boolean z;
        boolean z2;
        char[] cArr = this.iAH;
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
                if (zk(i2 + 1)) {
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
                ccy();
                break;
        }
        return false;
    }

    public String nextName() throws IOException {
        String i;
        int i2 = this.iAK;
        if (i2 == 0) {
            i2 = cct();
        }
        if (i2 == 14) {
            i = ccw();
        } else if (i2 == 12) {
            i = i('\'');
        } else if (i2 == 13) {
            i = i('\"');
        } else {
            throw new IllegalStateException("Expected a name but was " + ccf() + ccj());
        }
        this.iAK = 0;
        this.iyM[this.iyL - 1] = i;
        return i;
    }

    public String nextString() throws IOException {
        String str;
        int i = this.iAK;
        if (i == 0) {
            i = cct();
        }
        if (i == 10) {
            str = ccw();
        } else if (i == 8) {
            str = i('\'');
        } else if (i == 9) {
            str = i('\"');
        } else if (i == 11) {
            str = this.iAN;
            this.iAN = null;
        } else if (i == 15) {
            str = Long.toString(this.iAL);
        } else if (i == 16) {
            str = new String(this.iAH, this.pos, this.iAM);
            this.pos += this.iAM;
        } else {
            throw new IllegalStateException("Expected a string but was " + ccf() + ccj());
        }
        this.iAK = 0;
        int[] iArr = this.iyN;
        int i2 = this.iyL - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    public boolean nextBoolean() throws IOException {
        int i = this.iAK;
        if (i == 0) {
            i = cct();
        }
        if (i == 5) {
            this.iAK = 0;
            int[] iArr = this.iyN;
            int i2 = this.iyL - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        } else if (i == 6) {
            this.iAK = 0;
            int[] iArr2 = this.iyN;
            int i3 = this.iyL - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + ccf() + ccj());
        }
    }

    public void nextNull() throws IOException {
        int i = this.iAK;
        if (i == 0) {
            i = cct();
        }
        if (i == 7) {
            this.iAK = 0;
            int[] iArr = this.iyN;
            int i2 = this.iyL - 1;
            iArr[i2] = iArr[i2] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + ccf() + ccj());
    }

    public double nextDouble() throws IOException {
        int i = this.iAK;
        if (i == 0) {
            i = cct();
        }
        if (i == 15) {
            this.iAK = 0;
            int[] iArr = this.iyN;
            int i2 = this.iyL - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.iAL;
        }
        if (i == 16) {
            this.iAN = new String(this.iAH, this.pos, this.iAM);
            this.pos += this.iAM;
        } else if (i == 8 || i == 9) {
            this.iAN = i(i == 8 ? '\'' : '\"');
        } else if (i == 10) {
            this.iAN = ccw();
        } else if (i != 11) {
            throw new IllegalStateException("Expected a double but was " + ccf() + ccj());
        }
        this.iAK = 11;
        double parseDouble = Double.parseDouble(this.iAN);
        if (!this.ixp && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + parseDouble + ccj());
        }
        this.iAN = null;
        this.iAK = 0;
        int[] iArr2 = this.iyN;
        int i3 = this.iyL - 1;
        iArr2[i3] = iArr2[i3] + 1;
        return parseDouble;
    }

    public long nextLong() throws IOException {
        int i = this.iAK;
        if (i == 0) {
            i = cct();
        }
        if (i == 15) {
            this.iAK = 0;
            int[] iArr = this.iyN;
            int i2 = this.iyL - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.iAL;
        }
        if (i == 16) {
            this.iAN = new String(this.iAH, this.pos, this.iAM);
            this.pos += this.iAM;
        } else if (i == 8 || i == 9 || i == 10) {
            if (i == 10) {
                this.iAN = ccw();
            } else {
                this.iAN = i(i == 8 ? '\'' : '\"');
            }
            try {
                long parseLong = Long.parseLong(this.iAN);
                this.iAK = 0;
                int[] iArr2 = this.iyN;
                int i3 = this.iyL - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return parseLong;
            } catch (NumberFormatException e) {
            }
        } else {
            throw new IllegalStateException("Expected a long but was " + ccf() + ccj());
        }
        this.iAK = 11;
        double parseDouble = Double.parseDouble(this.iAN);
        long j = (long) parseDouble;
        if (j != parseDouble) {
            throw new NumberFormatException("Expected a long but was " + this.iAN + ccj());
        }
        this.iAN = null;
        this.iAK = 0;
        int[] iArr3 = this.iyN;
        int i4 = this.iyL - 1;
        iArr3[i4] = iArr3[i4] + 1;
        return j;
    }

    private String i(char c) throws IOException {
        char[] cArr = this.iAH;
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
                    sb.append(ccA());
                    i = this.pos;
                    i2 = this.limit;
                    i4 = i;
                } else if (c2 == '\n') {
                    this.iAI++;
                    this.iAJ = i4;
                }
                i3 = i4;
            }
            sb.append(cArr, i, i3 - i);
            this.pos = i3;
        } while (zk(1));
        throw zP("Unterminated string");
    }

    private String ccw() throws IOException {
        String sb;
        StringBuilder sb2 = null;
        int i = 0;
        while (true) {
            if (this.pos + i < this.limit) {
                switch (this.iAH[this.pos + i]) {
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
                        ccy();
                        break;
                    default:
                        i++;
                }
            } else if (i < this.iAH.length) {
                if (zk(i + 1)) {
                }
            } else {
                if (sb2 == null) {
                    sb2 = new StringBuilder();
                }
                sb2.append(this.iAH, this.pos, i);
                this.pos = i + this.pos;
                if (zk(1)) {
                    i = 0;
                } else {
                    i = 0;
                }
            }
        }
        if (sb2 == null) {
            sb = new String(this.iAH, this.pos, i);
        } else {
            sb2.append(this.iAH, this.pos, i);
            sb = sb2.toString();
        }
        this.pos = i + this.pos;
        return sb;
    }

    private void j(char c) throws IOException {
        char[] cArr = this.iAH;
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
                    ccA();
                    i4 = this.pos;
                    i2 = this.limit;
                } else if (c2 == '\n') {
                    this.iAI++;
                    this.iAJ = i4;
                }
                i3 = i4;
            }
            this.pos = i3;
        } while (zk(1));
        throw zP("Unterminated string");
    }

    private void ccx() throws IOException {
        do {
            int i = 0;
            while (this.pos + i < this.limit) {
                switch (this.iAH[this.pos + i]) {
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
                        ccy();
                        this.pos = i + this.pos;
                        return;
                    default:
                        i++;
                }
            }
            this.pos = i + this.pos;
        } while (zk(1));
    }

    public int nextInt() throws IOException {
        int i = this.iAK;
        if (i == 0) {
            i = cct();
        }
        if (i == 15) {
            int i2 = (int) this.iAL;
            if (this.iAL != i2) {
                throw new NumberFormatException("Expected an int but was " + this.iAL + ccj());
            }
            this.iAK = 0;
            int[] iArr = this.iyN;
            int i3 = this.iyL - 1;
            iArr[i3] = iArr[i3] + 1;
            return i2;
        }
        if (i == 16) {
            this.iAN = new String(this.iAH, this.pos, this.iAM);
            this.pos += this.iAM;
        } else if (i == 8 || i == 9 || i == 10) {
            if (i == 10) {
                this.iAN = ccw();
            } else {
                this.iAN = i(i == 8 ? '\'' : '\"');
            }
            try {
                int parseInt = Integer.parseInt(this.iAN);
                this.iAK = 0;
                int[] iArr2 = this.iyN;
                int i4 = this.iyL - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseInt;
            } catch (NumberFormatException e) {
            }
        } else {
            throw new IllegalStateException("Expected an int but was " + ccf() + ccj());
        }
        this.iAK = 11;
        double parseDouble = Double.parseDouble(this.iAN);
        int i5 = (int) parseDouble;
        if (i5 != parseDouble) {
            throw new NumberFormatException("Expected an int but was " + this.iAN + ccj());
        }
        this.iAN = null;
        this.iAK = 0;
        int[] iArr3 = this.iyN;
        int i6 = this.iyL - 1;
        iArr3[i6] = iArr3[i6] + 1;
        return i5;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.iAK = 0;
        this.iAO[0] = 8;
        this.iyL = 1;
        this.in.close();
    }

    public void skipValue() throws IOException {
        int i = 0;
        do {
            int i2 = this.iAK;
            if (i2 == 0) {
                i2 = cct();
            }
            if (i2 == 3) {
                zj(1);
                i++;
            } else if (i2 == 1) {
                zj(3);
                i++;
            } else if (i2 == 4) {
                this.iyL--;
                i--;
            } else if (i2 == 2) {
                this.iyL--;
                i--;
            } else if (i2 == 14 || i2 == 10) {
                ccx();
            } else if (i2 == 8 || i2 == 12) {
                j('\'');
            } else if (i2 == 9 || i2 == 13) {
                j('\"');
            } else if (i2 == 16) {
                this.pos += this.iAM;
            }
            this.iAK = 0;
        } while (i != 0);
        int[] iArr = this.iyN;
        int i3 = this.iyL - 1;
        iArr[i3] = iArr[i3] + 1;
        this.iyM[this.iyL - 1] = "null";
    }

    private void zj(int i) {
        if (this.iyL == this.iAO.length) {
            int[] iArr = new int[this.iyL * 2];
            int[] iArr2 = new int[this.iyL * 2];
            String[] strArr = new String[this.iyL * 2];
            System.arraycopy(this.iAO, 0, iArr, 0, this.iyL);
            System.arraycopy(this.iyN, 0, iArr2, 0, this.iyL);
            System.arraycopy(this.iyM, 0, strArr, 0, this.iyL);
            this.iAO = iArr;
            this.iyN = iArr2;
            this.iyM = strArr;
        }
        int[] iArr3 = this.iAO;
        int i2 = this.iyL;
        this.iyL = i2 + 1;
        iArr3[i2] = i;
    }

    private boolean zk(int i) throws IOException {
        char[] cArr = this.iAH;
        this.iAJ -= this.pos;
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
            if (this.iAI == 0 && this.iAJ == 0 && this.limit > 0 && cArr[0] == 65279) {
                this.pos++;
                this.iAJ++;
                i++;
            }
        } while (this.limit < i);
        return true;
    }

    private int pi(boolean z) throws IOException {
        char[] cArr = this.iAH;
        int i = this.pos;
        int i2 = this.limit;
        while (true) {
            if (i == i2) {
                this.pos = i;
                if (zk(1)) {
                    i = this.pos;
                    i2 = this.limit;
                } else if (z) {
                    throw new EOFException("End of input" + ccj());
                } else {
                    return -1;
                }
            }
            int i3 = i + 1;
            char c = cArr[i];
            if (c == '\n') {
                this.iAI++;
                this.iAJ = i3;
                i = i3;
            } else if (c == ' ' || c == '\r') {
                i = i3;
            } else if (c == '\t') {
                i = i3;
            } else if (c == '/') {
                this.pos = i3;
                if (i3 == i2) {
                    this.pos--;
                    boolean zk = zk(2);
                    this.pos++;
                    if (!zk) {
                        return c;
                    }
                }
                ccy();
                switch (cArr[this.pos]) {
                    case '*':
                        this.pos++;
                        if (!zO("*/")) {
                            throw zP("Unterminated comment");
                        }
                        i = this.pos + 2;
                        i2 = this.limit;
                        continue;
                    case '/':
                        this.pos++;
                        ccz();
                        i = this.pos;
                        i2 = this.limit;
                        continue;
                    default:
                        return c;
                }
            } else if (c == '#') {
                this.pos = i3;
                ccy();
                ccz();
                i = this.pos;
                i2 = this.limit;
            } else {
                this.pos = i3;
                return c;
            }
        }
    }

    private void ccy() throws IOException {
        if (!this.ixp) {
            throw zP("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void ccz() throws IOException {
        char c;
        do {
            if (this.pos < this.limit || zk(1)) {
                char[] cArr = this.iAH;
                int i = this.pos;
                this.pos = i + 1;
                c = cArr[i];
                if (c == '\n') {
                    this.iAI++;
                    this.iAJ = this.pos;
                    return;
                }
            } else {
                return;
            }
        } while (c != '\r');
    }

    private boolean zO(String str) throws IOException {
        int i;
        while (true) {
            if (this.pos + str.length() > this.limit && !zk(str.length())) {
                return false;
            }
            if (this.iAH[this.pos] == '\n') {
                this.iAI++;
                this.iAJ = this.pos + 1;
            } else {
                for (i = 0; i < str.length(); i = i + 1) {
                    i = this.iAH[this.pos + i] == str.charAt(i) ? i + 1 : 0;
                }
                return true;
            }
            this.pos++;
        }
    }

    public String toString() {
        return getClass().getSimpleName() + ccj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ccj() {
        return " at line " + (this.iAI + 1) + " column " + ((this.pos - this.iAJ) + 1) + " path " + getPath();
    }

    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = this.iyL;
        for (int i2 = 0; i2 < i; i2++) {
            switch (this.iAO[i2]) {
                case 1:
                case 2:
                    append.append('[').append(this.iyN[i2]).append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    append.append('.');
                    if (this.iyM[i2] != null) {
                        append.append(this.iyM[i2]);
                        break;
                    } else {
                        break;
                    }
            }
        }
        return append.toString();
    }

    private char ccA() throws IOException {
        int i;
        if (this.pos == this.limit && !zk(1)) {
            throw zP("Unterminated escape sequence");
        }
        char[] cArr = this.iAH;
        int i2 = this.pos;
        this.pos = i2 + 1;
        char c = cArr[i2];
        switch (c) {
            case '\n':
                this.iAI++;
                this.iAJ = this.pos;
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
                if (this.pos + 4 > this.limit && !zk(4)) {
                    throw zP("Unterminated escape sequence");
                }
                int i3 = this.pos;
                int i4 = i3 + 4;
                char c2 = 0;
                for (int i5 = i3; i5 < i4; i5++) {
                    char c3 = this.iAH[i5];
                    char c4 = (char) (c2 << 4);
                    if (c3 >= '0' && c3 <= '9') {
                        i = c3 - '0';
                    } else if (c3 >= 'a' && c3 <= 'f') {
                        i = (c3 - 'a') + 10;
                    } else if (c3 >= 'A' && c3 <= 'F') {
                        i = (c3 - 'A') + 10;
                    } else {
                        throw new NumberFormatException("\\u" + new String(this.iAH, this.pos, 4));
                    }
                    c2 = (char) (c4 + i);
                }
                this.pos += 4;
                return c2;
            default:
                throw zP("Invalid escape sequence");
        }
    }

    private IOException zP(String str) throws IOException {
        throw new MalformedJsonException(str + ccj());
    }

    private void ccB() throws IOException {
        pi(true);
        this.pos--;
        if (this.pos + iAG.length <= this.limit || zk(iAG.length)) {
            for (int i = 0; i < iAG.length; i++) {
                if (this.iAH[this.pos + i] != iAG[i]) {
                    return;
                }
            }
            this.pos += iAG.length;
        }
    }
}
