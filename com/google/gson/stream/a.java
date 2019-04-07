package com.google.gson.stream;

import com.google.gson.internal.a.e;
import com.google.gson.internal.d;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
/* loaded from: classes2.dex */
public class a implements Closeable {
    private static final char[] jPV = ")]}'\n".toCharArray();
    private final Reader in;
    private int jOb;
    private String[] jOc;
    private int[] jOd;
    private long jQa;
    private int jQb;
    private String jQc;
    private boolean jMF = false;
    private final char[] jPW = new char[1024];
    private int pos = 0;
    private int limit = 0;
    private int jPX = 0;
    private int jPY = 0;
    int jPZ = 0;
    private int[] jQd = new int[32];

    static {
        d.jNk = new d() { // from class: com.google.gson.stream.a.1
            @Override // com.google.gson.internal.d
            public void g(a aVar) throws IOException {
                if (aVar instanceof e) {
                    ((e) aVar).cBt();
                    return;
                }
                int i = aVar.jPZ;
                if (i == 0) {
                    i = aVar.cBE();
                }
                if (i == 13) {
                    aVar.jPZ = 9;
                } else if (i == 12) {
                    aVar.jPZ = 8;
                } else if (i == 14) {
                    aVar.jPZ = 10;
                } else {
                    throw new IllegalStateException("Expected a name but was " + aVar.cBq() + aVar.cBu());
                }
            }
        };
    }

    public a(Reader reader) {
        this.jOb = 0;
        int[] iArr = this.jQd;
        int i = this.jOb;
        this.jOb = i + 1;
        iArr[i] = 6;
        this.jOc = new String[32];
        this.jOd = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.in = reader;
    }

    public final void setLenient(boolean z) {
        this.jMF = z;
    }

    public final boolean isLenient() {
        return this.jMF;
    }

    public void beginArray() throws IOException {
        int i = this.jPZ;
        if (i == 0) {
            i = cBE();
        }
        if (i == 3) {
            CM(1);
            this.jOd[this.jOb - 1] = 0;
            this.jPZ = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + cBq() + cBu());
    }

    public void endArray() throws IOException {
        int i = this.jPZ;
        if (i == 0) {
            i = cBE();
        }
        if (i == 4) {
            this.jOb--;
            int[] iArr = this.jOd;
            int i2 = this.jOb - 1;
            iArr[i2] = iArr[i2] + 1;
            this.jPZ = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + cBq() + cBu());
    }

    public void beginObject() throws IOException {
        int i = this.jPZ;
        if (i == 0) {
            i = cBE();
        }
        if (i == 1) {
            CM(3);
            this.jPZ = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + cBq() + cBu());
    }

    public void endObject() throws IOException {
        int i = this.jPZ;
        if (i == 0) {
            i = cBE();
        }
        if (i == 2) {
            this.jOb--;
            this.jOc[this.jOb] = null;
            int[] iArr = this.jOd;
            int i2 = this.jOb - 1;
            iArr[i2] = iArr[i2] + 1;
            this.jPZ = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + cBq() + cBu());
    }

    public boolean hasNext() throws IOException {
        int i = this.jPZ;
        if (i == 0) {
            i = cBE();
        }
        return (i == 2 || i == 4) ? false : true;
    }

    public JsonToken cBq() throws IOException {
        int i = this.jPZ;
        if (i == 0) {
            i = cBE();
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
    int cBE() throws IOException {
        int i = this.jQd[this.jOb - 1];
        if (i == 1) {
            this.jQd[this.jOb - 1] = 2;
        } else if (i == 2) {
            switch (rC(true)) {
                case 44:
                    break;
                case 59:
                    cBJ();
                    break;
                case 93:
                    this.jPZ = 4;
                    return 4;
                default:
                    throw FJ("Unterminated array");
            }
        } else if (i == 3 || i == 5) {
            this.jQd[this.jOb - 1] = 4;
            if (i == 5) {
                switch (rC(true)) {
                    case 44:
                        break;
                    case 59:
                        cBJ();
                        break;
                    case 125:
                        this.jPZ = 2;
                        return 2;
                    default:
                        throw FJ("Unterminated object");
                }
            }
            int rC = rC(true);
            switch (rC) {
                case 34:
                    this.jPZ = 13;
                    return 13;
                case 39:
                    cBJ();
                    this.jPZ = 12;
                    return 12;
                case 125:
                    if (i != 5) {
                        this.jPZ = 2;
                        return 2;
                    }
                    throw FJ("Expected name");
                default:
                    cBJ();
                    this.pos--;
                    if (h((char) rC)) {
                        this.jPZ = 14;
                        return 14;
                    }
                    throw FJ("Expected name");
            }
        } else if (i == 4) {
            this.jQd[this.jOb - 1] = 5;
            switch (rC(true)) {
                case 58:
                    break;
                case 59:
                case 60:
                default:
                    throw FJ("Expected ':'");
                case 61:
                    cBJ();
                    if ((this.pos < this.limit || CN(1)) && this.jPW[this.pos] == '>') {
                        this.pos++;
                        break;
                    }
                    break;
            }
        } else if (i == 6) {
            if (this.jMF) {
                cBK();
            }
            this.jQd[this.jOb - 1] = 7;
        } else if (i == 7) {
            if (rC(false) == -1) {
                this.jPZ = 17;
                return 17;
            }
            cBJ();
            this.pos--;
        } else if (i == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        switch (rC(true)) {
            case 34:
                this.jPZ = 9;
                return 9;
            case 39:
                cBJ();
                this.jPZ = 8;
                return 8;
            case 44:
            case 59:
                break;
            case 91:
                this.jPZ = 3;
                return 3;
            case 93:
                if (i == 1) {
                    this.jPZ = 4;
                    return 4;
                }
                break;
            case 123:
                this.jPZ = 1;
                return 1;
            default:
                this.pos--;
                int cBF = cBF();
                if (cBF == 0) {
                    int cBG = cBG();
                    if (cBG == 0) {
                        if (!h(this.jPW[this.pos])) {
                            throw FJ("Expected value");
                        }
                        cBJ();
                        this.jPZ = 10;
                        return 10;
                    }
                    return cBG;
                }
                return cBF;
        }
        if (i == 1 || i == 2) {
            cBJ();
            this.pos--;
            this.jPZ = 7;
            return 7;
        }
        throw FJ("Unexpected value");
    }

    private int cBF() throws IOException {
        String str;
        String str2;
        int i;
        char c = this.jPW[this.pos];
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
            if (this.pos + i2 >= this.limit && !CN(i2 + 1)) {
                return 0;
            }
            char c2 = this.jPW[this.pos + i2];
            if (c2 != str.charAt(i2) && c2 != str2.charAt(i2)) {
                return 0;
            }
        }
        if ((this.pos + length < this.limit || CN(length + 1)) && h(this.jPW[this.pos + length])) {
            return 0;
        }
        this.pos += length;
        this.jPZ = i;
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
        r15.jQa = r6;
        r15.pos += r10;
        r15.jPZ = 15;
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
        r15.jQb = r10;
        r15.jPZ = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x00f0, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int cBG() throws IOException {
        char c;
        boolean z;
        boolean z2;
        char[] cArr = this.jPW;
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
                if (CN(i2 + 1)) {
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
                cBJ();
                break;
        }
        return false;
    }

    public String nextName() throws IOException {
        String i;
        int i2 = this.jPZ;
        if (i2 == 0) {
            i2 = cBE();
        }
        if (i2 == 14) {
            i = cBH();
        } else if (i2 == 12) {
            i = i('\'');
        } else if (i2 == 13) {
            i = i('\"');
        } else {
            throw new IllegalStateException("Expected a name but was " + cBq() + cBu());
        }
        this.jPZ = 0;
        this.jOc[this.jOb - 1] = i;
        return i;
    }

    public String nextString() throws IOException {
        String str;
        int i = this.jPZ;
        if (i == 0) {
            i = cBE();
        }
        if (i == 10) {
            str = cBH();
        } else if (i == 8) {
            str = i('\'');
        } else if (i == 9) {
            str = i('\"');
        } else if (i == 11) {
            str = this.jQc;
            this.jQc = null;
        } else if (i == 15) {
            str = Long.toString(this.jQa);
        } else if (i == 16) {
            str = new String(this.jPW, this.pos, this.jQb);
            this.pos += this.jQb;
        } else {
            throw new IllegalStateException("Expected a string but was " + cBq() + cBu());
        }
        this.jPZ = 0;
        int[] iArr = this.jOd;
        int i2 = this.jOb - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    public boolean nextBoolean() throws IOException {
        int i = this.jPZ;
        if (i == 0) {
            i = cBE();
        }
        if (i == 5) {
            this.jPZ = 0;
            int[] iArr = this.jOd;
            int i2 = this.jOb - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        } else if (i == 6) {
            this.jPZ = 0;
            int[] iArr2 = this.jOd;
            int i3 = this.jOb - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + cBq() + cBu());
        }
    }

    public void nextNull() throws IOException {
        int i = this.jPZ;
        if (i == 0) {
            i = cBE();
        }
        if (i == 7) {
            this.jPZ = 0;
            int[] iArr = this.jOd;
            int i2 = this.jOb - 1;
            iArr[i2] = iArr[i2] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + cBq() + cBu());
    }

    public double nextDouble() throws IOException {
        int i = this.jPZ;
        if (i == 0) {
            i = cBE();
        }
        if (i == 15) {
            this.jPZ = 0;
            int[] iArr = this.jOd;
            int i2 = this.jOb - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.jQa;
        }
        if (i == 16) {
            this.jQc = new String(this.jPW, this.pos, this.jQb);
            this.pos += this.jQb;
        } else if (i == 8 || i == 9) {
            this.jQc = i(i == 8 ? '\'' : '\"');
        } else if (i == 10) {
            this.jQc = cBH();
        } else if (i != 11) {
            throw new IllegalStateException("Expected a double but was " + cBq() + cBu());
        }
        this.jPZ = 11;
        double parseDouble = Double.parseDouble(this.jQc);
        if (!this.jMF && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + parseDouble + cBu());
        }
        this.jQc = null;
        this.jPZ = 0;
        int[] iArr2 = this.jOd;
        int i3 = this.jOb - 1;
        iArr2[i3] = iArr2[i3] + 1;
        return parseDouble;
    }

    public long nextLong() throws IOException {
        int i = this.jPZ;
        if (i == 0) {
            i = cBE();
        }
        if (i == 15) {
            this.jPZ = 0;
            int[] iArr = this.jOd;
            int i2 = this.jOb - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.jQa;
        }
        if (i == 16) {
            this.jQc = new String(this.jPW, this.pos, this.jQb);
            this.pos += this.jQb;
        } else if (i == 8 || i == 9 || i == 10) {
            if (i == 10) {
                this.jQc = cBH();
            } else {
                this.jQc = i(i == 8 ? '\'' : '\"');
            }
            try {
                long parseLong = Long.parseLong(this.jQc);
                this.jPZ = 0;
                int[] iArr2 = this.jOd;
                int i3 = this.jOb - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return parseLong;
            } catch (NumberFormatException e) {
            }
        } else {
            throw new IllegalStateException("Expected a long but was " + cBq() + cBu());
        }
        this.jPZ = 11;
        double parseDouble = Double.parseDouble(this.jQc);
        long j = (long) parseDouble;
        if (j != parseDouble) {
            throw new NumberFormatException("Expected a long but was " + this.jQc + cBu());
        }
        this.jQc = null;
        this.jPZ = 0;
        int[] iArr3 = this.jOd;
        int i4 = this.jOb - 1;
        iArr3[i4] = iArr3[i4] + 1;
        return j;
    }

    private String i(char c) throws IOException {
        char[] cArr = this.jPW;
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
                    sb.append(readEscapeCharacter());
                    i = this.pos;
                    i2 = this.limit;
                    i4 = i;
                } else if (c2 == '\n') {
                    this.jPX++;
                    this.jPY = i4;
                }
                i3 = i4;
            }
            sb.append(cArr, i, i3 - i);
            this.pos = i3;
        } while (CN(1));
        throw FJ("Unterminated string");
    }

    private String cBH() throws IOException {
        String sb;
        StringBuilder sb2 = null;
        int i = 0;
        while (true) {
            if (this.pos + i < this.limit) {
                switch (this.jPW[this.pos + i]) {
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
                        cBJ();
                        break;
                    default:
                        i++;
                }
            } else if (i < this.jPW.length) {
                if (CN(i + 1)) {
                }
            } else {
                if (sb2 == null) {
                    sb2 = new StringBuilder();
                }
                sb2.append(this.jPW, this.pos, i);
                this.pos = i + this.pos;
                if (CN(1)) {
                    i = 0;
                } else {
                    i = 0;
                }
            }
        }
        if (sb2 == null) {
            sb = new String(this.jPW, this.pos, i);
        } else {
            sb2.append(this.jPW, this.pos, i);
            sb = sb2.toString();
        }
        this.pos = i + this.pos;
        return sb;
    }

    private void j(char c) throws IOException {
        char[] cArr = this.jPW;
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
                    this.jPX++;
                    this.jPY = i4;
                }
                i3 = i4;
            }
            this.pos = i3;
        } while (CN(1));
        throw FJ("Unterminated string");
    }

    private void cBI() throws IOException {
        do {
            int i = 0;
            while (this.pos + i < this.limit) {
                switch (this.jPW[this.pos + i]) {
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
                        cBJ();
                        this.pos = i + this.pos;
                        return;
                    default:
                        i++;
                }
            }
            this.pos = i + this.pos;
        } while (CN(1));
    }

    public int nextInt() throws IOException {
        int i = this.jPZ;
        if (i == 0) {
            i = cBE();
        }
        if (i == 15) {
            int i2 = (int) this.jQa;
            if (this.jQa != i2) {
                throw new NumberFormatException("Expected an int but was " + this.jQa + cBu());
            }
            this.jPZ = 0;
            int[] iArr = this.jOd;
            int i3 = this.jOb - 1;
            iArr[i3] = iArr[i3] + 1;
            return i2;
        }
        if (i == 16) {
            this.jQc = new String(this.jPW, this.pos, this.jQb);
            this.pos += this.jQb;
        } else if (i == 8 || i == 9 || i == 10) {
            if (i == 10) {
                this.jQc = cBH();
            } else {
                this.jQc = i(i == 8 ? '\'' : '\"');
            }
            try {
                int parseInt = Integer.parseInt(this.jQc);
                this.jPZ = 0;
                int[] iArr2 = this.jOd;
                int i4 = this.jOb - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseInt;
            } catch (NumberFormatException e) {
            }
        } else {
            throw new IllegalStateException("Expected an int but was " + cBq() + cBu());
        }
        this.jPZ = 11;
        double parseDouble = Double.parseDouble(this.jQc);
        int i5 = (int) parseDouble;
        if (i5 != parseDouble) {
            throw new NumberFormatException("Expected an int but was " + this.jQc + cBu());
        }
        this.jQc = null;
        this.jPZ = 0;
        int[] iArr3 = this.jOd;
        int i6 = this.jOb - 1;
        iArr3[i6] = iArr3[i6] + 1;
        return i5;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.jPZ = 0;
        this.jQd[0] = 8;
        this.jOb = 1;
        this.in.close();
    }

    public void skipValue() throws IOException {
        int i = 0;
        do {
            int i2 = this.jPZ;
            if (i2 == 0) {
                i2 = cBE();
            }
            if (i2 == 3) {
                CM(1);
                i++;
            } else if (i2 == 1) {
                CM(3);
                i++;
            } else if (i2 == 4) {
                this.jOb--;
                i--;
            } else if (i2 == 2) {
                this.jOb--;
                i--;
            } else if (i2 == 14 || i2 == 10) {
                cBI();
            } else if (i2 == 8 || i2 == 12) {
                j('\'');
            } else if (i2 == 9 || i2 == 13) {
                j('\"');
            } else if (i2 == 16) {
                this.pos += this.jQb;
            }
            this.jPZ = 0;
        } while (i != 0);
        int[] iArr = this.jOd;
        int i3 = this.jOb - 1;
        iArr[i3] = iArr[i3] + 1;
        this.jOc[this.jOb - 1] = "null";
    }

    private void CM(int i) {
        if (this.jOb == this.jQd.length) {
            int[] iArr = new int[this.jOb * 2];
            int[] iArr2 = new int[this.jOb * 2];
            String[] strArr = new String[this.jOb * 2];
            System.arraycopy(this.jQd, 0, iArr, 0, this.jOb);
            System.arraycopy(this.jOd, 0, iArr2, 0, this.jOb);
            System.arraycopy(this.jOc, 0, strArr, 0, this.jOb);
            this.jQd = iArr;
            this.jOd = iArr2;
            this.jOc = strArr;
        }
        int[] iArr3 = this.jQd;
        int i2 = this.jOb;
        this.jOb = i2 + 1;
        iArr3[i2] = i;
    }

    private boolean CN(int i) throws IOException {
        char[] cArr = this.jPW;
        this.jPY -= this.pos;
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
            if (this.jPX == 0 && this.jPY == 0 && this.limit > 0 && cArr[0] == 65279) {
                this.pos++;
                this.jPY++;
                i++;
            }
        } while (this.limit < i);
        return true;
    }

    private int rC(boolean z) throws IOException {
        char[] cArr = this.jPW;
        int i = this.pos;
        int i2 = this.limit;
        while (true) {
            if (i == i2) {
                this.pos = i;
                if (CN(1)) {
                    i = this.pos;
                    i2 = this.limit;
                } else if (z) {
                    throw new EOFException("End of input" + cBu());
                } else {
                    return -1;
                }
            }
            int i3 = i + 1;
            char c = cArr[i];
            if (c == '\n') {
                this.jPX++;
                this.jPY = i3;
                i = i3;
            } else if (c == ' ' || c == '\r') {
                i = i3;
            } else if (c == '\t') {
                i = i3;
            } else if (c == '/') {
                this.pos = i3;
                if (i3 == i2) {
                    this.pos--;
                    boolean CN = CN(2);
                    this.pos++;
                    if (!CN) {
                        return c;
                    }
                }
                cBJ();
                switch (cArr[this.pos]) {
                    case '*':
                        this.pos++;
                        if (!FI("*/")) {
                            throw FJ("Unterminated comment");
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
                cBJ();
                skipToEndOfLine();
                i = this.pos;
                i2 = this.limit;
            } else {
                this.pos = i3;
                return c;
            }
        }
    }

    private void cBJ() throws IOException {
        if (!this.jMF) {
            throw FJ("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void skipToEndOfLine() throws IOException {
        char c;
        do {
            if (this.pos < this.limit || CN(1)) {
                char[] cArr = this.jPW;
                int i = this.pos;
                this.pos = i + 1;
                c = cArr[i];
                if (c == '\n') {
                    this.jPX++;
                    this.jPY = this.pos;
                    return;
                }
            } else {
                return;
            }
        } while (c != '\r');
    }

    private boolean FI(String str) throws IOException {
        int i;
        while (true) {
            if (this.pos + str.length() > this.limit && !CN(str.length())) {
                return false;
            }
            if (this.jPW[this.pos] == '\n') {
                this.jPX++;
                this.jPY = this.pos + 1;
            } else {
                for (i = 0; i < str.length(); i = i + 1) {
                    i = this.jPW[this.pos + i] == str.charAt(i) ? i + 1 : 0;
                }
                return true;
            }
            this.pos++;
        }
    }

    public String toString() {
        return getClass().getSimpleName() + cBu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cBu() {
        return " at line " + (this.jPX + 1) + " column " + ((this.pos - this.jPY) + 1) + " path " + getPath();
    }

    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = this.jOb;
        for (int i2 = 0; i2 < i; i2++) {
            switch (this.jQd[i2]) {
                case 1:
                case 2:
                    append.append('[').append(this.jOd[i2]).append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    append.append('.');
                    if (this.jOc[i2] != null) {
                        append.append(this.jOc[i2]);
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
        if (this.pos == this.limit && !CN(1)) {
            throw FJ("Unterminated escape sequence");
        }
        char[] cArr = this.jPW;
        int i2 = this.pos;
        this.pos = i2 + 1;
        char c = cArr[i2];
        switch (c) {
            case '\n':
                this.jPX++;
                this.jPY = this.pos;
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
                if (this.pos + 4 > this.limit && !CN(4)) {
                    throw FJ("Unterminated escape sequence");
                }
                int i3 = this.pos;
                int i4 = i3 + 4;
                char c2 = 0;
                for (int i5 = i3; i5 < i4; i5++) {
                    char c3 = this.jPW[i5];
                    char c4 = (char) (c2 << 4);
                    if (c3 >= '0' && c3 <= '9') {
                        i = c3 - '0';
                    } else if (c3 >= 'a' && c3 <= 'f') {
                        i = (c3 - 'a') + 10;
                    } else if (c3 >= 'A' && c3 <= 'F') {
                        i = (c3 - 'A') + 10;
                    } else {
                        throw new NumberFormatException("\\u" + new String(this.jPW, this.pos, 4));
                    }
                    c2 = (char) (c4 + i);
                }
                this.pos += 4;
                return c2;
            default:
                throw FJ("Invalid escape sequence");
        }
    }

    private IOException FJ(String str) throws IOException {
        throw new MalformedJsonException(str + cBu());
    }

    private void cBK() throws IOException {
        rC(true);
        this.pos--;
        if (this.pos + jPV.length <= this.limit || CN(jPV.length)) {
            for (int i = 0; i < jPV.length; i++) {
                if (this.jPW[this.pos + i] != jPV[i]) {
                    return;
                }
            }
            this.pos += jPV.length;
        }
    }
}
