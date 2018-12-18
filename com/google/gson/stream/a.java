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
    private static final char[] iwo = ")]}'\n".toCharArray();
    private final Reader in;
    private int iut;
    private String[] iuu;
    private int[] iuv;
    private long iwt;
    private int iwu;
    private String iwv;
    private boolean isX = false;
    private final char[] iwp = new char[1024];
    private int pos = 0;
    private int limit = 0;
    private int iwq = 0;
    private int iwr = 0;
    int iws = 0;
    private int[] iww = new int[32];

    static {
        d.itC = new d() { // from class: com.google.gson.stream.a.1
            @Override // com.google.gson.internal.d
            public void g(a aVar) throws IOException {
                if (aVar instanceof e) {
                    ((e) aVar).caJ();
                    return;
                }
                int i = aVar.iws;
                if (i == 0) {
                    i = aVar.caU();
                }
                if (i == 13) {
                    aVar.iws = 9;
                } else if (i == 12) {
                    aVar.iws = 8;
                } else if (i == 14) {
                    aVar.iws = 10;
                } else {
                    throw new IllegalStateException("Expected a name but was " + aVar.caG() + aVar.caK());
                }
            }
        };
    }

    public a(Reader reader) {
        this.iut = 0;
        int[] iArr = this.iww;
        int i = this.iut;
        this.iut = i + 1;
        iArr[i] = 6;
        this.iuu = new String[32];
        this.iuv = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.in = reader;
    }

    public final void setLenient(boolean z) {
        this.isX = z;
    }

    public final boolean isLenient() {
        return this.isX;
    }

    public void beginArray() throws IOException {
        int i = this.iws;
        if (i == 0) {
            i = caU();
        }
        if (i == 3) {
            yU(1);
            this.iuv[this.iut - 1] = 0;
            this.iws = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + caG() + caK());
    }

    public void endArray() throws IOException {
        int i = this.iws;
        if (i == 0) {
            i = caU();
        }
        if (i == 4) {
            this.iut--;
            int[] iArr = this.iuv;
            int i2 = this.iut - 1;
            iArr[i2] = iArr[i2] + 1;
            this.iws = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + caG() + caK());
    }

    public void beginObject() throws IOException {
        int i = this.iws;
        if (i == 0) {
            i = caU();
        }
        if (i == 1) {
            yU(3);
            this.iws = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + caG() + caK());
    }

    public void endObject() throws IOException {
        int i = this.iws;
        if (i == 0) {
            i = caU();
        }
        if (i == 2) {
            this.iut--;
            this.iuu[this.iut] = null;
            int[] iArr = this.iuv;
            int i2 = this.iut - 1;
            iArr[i2] = iArr[i2] + 1;
            this.iws = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + caG() + caK());
    }

    public boolean hasNext() throws IOException {
        int i = this.iws;
        if (i == 0) {
            i = caU();
        }
        return (i == 2 || i == 4) ? false : true;
    }

    public JsonToken caG() throws IOException {
        int i = this.iws;
        if (i == 0) {
            i = caU();
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
    int caU() throws IOException {
        int i = this.iww[this.iut - 1];
        if (i == 1) {
            this.iww[this.iut - 1] = 2;
        } else if (i == 2) {
            switch (pe(true)) {
                case 44:
                    break;
                case 59:
                    caZ();
                    break;
                case 93:
                    this.iws = 4;
                    return 4;
                default:
                    throw zw("Unterminated array");
            }
        } else if (i == 3 || i == 5) {
            this.iww[this.iut - 1] = 4;
            if (i == 5) {
                switch (pe(true)) {
                    case 44:
                        break;
                    case 59:
                        caZ();
                        break;
                    case 125:
                        this.iws = 2;
                        return 2;
                    default:
                        throw zw("Unterminated object");
                }
            }
            int pe = pe(true);
            switch (pe) {
                case 34:
                    this.iws = 13;
                    return 13;
                case 39:
                    caZ();
                    this.iws = 12;
                    return 12;
                case 125:
                    if (i != 5) {
                        this.iws = 2;
                        return 2;
                    }
                    throw zw("Expected name");
                default:
                    caZ();
                    this.pos--;
                    if (h((char) pe)) {
                        this.iws = 14;
                        return 14;
                    }
                    throw zw("Expected name");
            }
        } else if (i == 4) {
            this.iww[this.iut - 1] = 5;
            switch (pe(true)) {
                case 58:
                    break;
                case 59:
                case 60:
                default:
                    throw zw("Expected ':'");
                case 61:
                    caZ();
                    if ((this.pos < this.limit || yV(1)) && this.iwp[this.pos] == '>') {
                        this.pos++;
                        break;
                    }
                    break;
            }
        } else if (i == 6) {
            if (this.isX) {
                cbc();
            }
            this.iww[this.iut - 1] = 7;
        } else if (i == 7) {
            if (pe(false) == -1) {
                this.iws = 17;
                return 17;
            }
            caZ();
            this.pos--;
        } else if (i == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        switch (pe(true)) {
            case 34:
                this.iws = 9;
                return 9;
            case 39:
                caZ();
                this.iws = 8;
                return 8;
            case 44:
            case 59:
                break;
            case 91:
                this.iws = 3;
                return 3;
            case 93:
                if (i == 1) {
                    this.iws = 4;
                    return 4;
                }
                break;
            case 123:
                this.iws = 1;
                return 1;
            default:
                this.pos--;
                int caV = caV();
                if (caV == 0) {
                    int caW = caW();
                    if (caW == 0) {
                        if (!h(this.iwp[this.pos])) {
                            throw zw("Expected value");
                        }
                        caZ();
                        this.iws = 10;
                        return 10;
                    }
                    return caW;
                }
                return caV;
        }
        if (i == 1 || i == 2) {
            caZ();
            this.pos--;
            this.iws = 7;
            return 7;
        }
        throw zw("Unexpected value");
    }

    private int caV() throws IOException {
        String str;
        String str2;
        int i;
        char c = this.iwp[this.pos];
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
            if (this.pos + i2 >= this.limit && !yV(i2 + 1)) {
                return 0;
            }
            char c2 = this.iwp[this.pos + i2];
            if (c2 != str.charAt(i2) && c2 != str2.charAt(i2)) {
                return 0;
            }
        }
        if ((this.pos + length < this.limit || yV(length + 1)) && h(this.iwp[this.pos + length])) {
            return 0;
        }
        this.pos += length;
        this.iws = i;
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
        r15.iwt = r6;
        r15.pos += r10;
        r15.iws = 15;
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
        r15.iwu = r10;
        r15.iws = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x00f0, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int caW() throws IOException {
        char c;
        boolean z;
        boolean z2;
        char[] cArr = this.iwp;
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
                if (yV(i2 + 1)) {
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
                caZ();
                break;
        }
        return false;
    }

    public String nextName() throws IOException {
        String i;
        int i2 = this.iws;
        if (i2 == 0) {
            i2 = caU();
        }
        if (i2 == 14) {
            i = caX();
        } else if (i2 == 12) {
            i = i('\'');
        } else if (i2 == 13) {
            i = i('\"');
        } else {
            throw new IllegalStateException("Expected a name but was " + caG() + caK());
        }
        this.iws = 0;
        this.iuu[this.iut - 1] = i;
        return i;
    }

    public String nextString() throws IOException {
        String str;
        int i = this.iws;
        if (i == 0) {
            i = caU();
        }
        if (i == 10) {
            str = caX();
        } else if (i == 8) {
            str = i('\'');
        } else if (i == 9) {
            str = i('\"');
        } else if (i == 11) {
            str = this.iwv;
            this.iwv = null;
        } else if (i == 15) {
            str = Long.toString(this.iwt);
        } else if (i == 16) {
            str = new String(this.iwp, this.pos, this.iwu);
            this.pos += this.iwu;
        } else {
            throw new IllegalStateException("Expected a string but was " + caG() + caK());
        }
        this.iws = 0;
        int[] iArr = this.iuv;
        int i2 = this.iut - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    public boolean nextBoolean() throws IOException {
        int i = this.iws;
        if (i == 0) {
            i = caU();
        }
        if (i == 5) {
            this.iws = 0;
            int[] iArr = this.iuv;
            int i2 = this.iut - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        } else if (i == 6) {
            this.iws = 0;
            int[] iArr2 = this.iuv;
            int i3 = this.iut - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + caG() + caK());
        }
    }

    public void nextNull() throws IOException {
        int i = this.iws;
        if (i == 0) {
            i = caU();
        }
        if (i == 7) {
            this.iws = 0;
            int[] iArr = this.iuv;
            int i2 = this.iut - 1;
            iArr[i2] = iArr[i2] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + caG() + caK());
    }

    public double nextDouble() throws IOException {
        int i = this.iws;
        if (i == 0) {
            i = caU();
        }
        if (i == 15) {
            this.iws = 0;
            int[] iArr = this.iuv;
            int i2 = this.iut - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.iwt;
        }
        if (i == 16) {
            this.iwv = new String(this.iwp, this.pos, this.iwu);
            this.pos += this.iwu;
        } else if (i == 8 || i == 9) {
            this.iwv = i(i == 8 ? '\'' : '\"');
        } else if (i == 10) {
            this.iwv = caX();
        } else if (i != 11) {
            throw new IllegalStateException("Expected a double but was " + caG() + caK());
        }
        this.iws = 11;
        double parseDouble = Double.parseDouble(this.iwv);
        if (!this.isX && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + parseDouble + caK());
        }
        this.iwv = null;
        this.iws = 0;
        int[] iArr2 = this.iuv;
        int i3 = this.iut - 1;
        iArr2[i3] = iArr2[i3] + 1;
        return parseDouble;
    }

    public long nextLong() throws IOException {
        int i = this.iws;
        if (i == 0) {
            i = caU();
        }
        if (i == 15) {
            this.iws = 0;
            int[] iArr = this.iuv;
            int i2 = this.iut - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.iwt;
        }
        if (i == 16) {
            this.iwv = new String(this.iwp, this.pos, this.iwu);
            this.pos += this.iwu;
        } else if (i == 8 || i == 9 || i == 10) {
            if (i == 10) {
                this.iwv = caX();
            } else {
                this.iwv = i(i == 8 ? '\'' : '\"');
            }
            try {
                long parseLong = Long.parseLong(this.iwv);
                this.iws = 0;
                int[] iArr2 = this.iuv;
                int i3 = this.iut - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return parseLong;
            } catch (NumberFormatException e) {
            }
        } else {
            throw new IllegalStateException("Expected a long but was " + caG() + caK());
        }
        this.iws = 11;
        double parseDouble = Double.parseDouble(this.iwv);
        long j = (long) parseDouble;
        if (j != parseDouble) {
            throw new NumberFormatException("Expected a long but was " + this.iwv + caK());
        }
        this.iwv = null;
        this.iws = 0;
        int[] iArr3 = this.iuv;
        int i4 = this.iut - 1;
        iArr3[i4] = iArr3[i4] + 1;
        return j;
    }

    private String i(char c) throws IOException {
        char[] cArr = this.iwp;
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
                    sb.append(cbb());
                    i = this.pos;
                    i2 = this.limit;
                    i4 = i;
                } else if (c2 == '\n') {
                    this.iwq++;
                    this.iwr = i4;
                }
                i3 = i4;
            }
            sb.append(cArr, i, i3 - i);
            this.pos = i3;
        } while (yV(1));
        throw zw("Unterminated string");
    }

    private String caX() throws IOException {
        String sb;
        StringBuilder sb2 = null;
        int i = 0;
        while (true) {
            if (this.pos + i < this.limit) {
                switch (this.iwp[this.pos + i]) {
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
                        caZ();
                        break;
                    default:
                        i++;
                }
            } else if (i < this.iwp.length) {
                if (yV(i + 1)) {
                }
            } else {
                if (sb2 == null) {
                    sb2 = new StringBuilder();
                }
                sb2.append(this.iwp, this.pos, i);
                this.pos = i + this.pos;
                if (yV(1)) {
                    i = 0;
                } else {
                    i = 0;
                }
            }
        }
        if (sb2 == null) {
            sb = new String(this.iwp, this.pos, i);
        } else {
            sb2.append(this.iwp, this.pos, i);
            sb = sb2.toString();
        }
        this.pos = i + this.pos;
        return sb;
    }

    private void j(char c) throws IOException {
        char[] cArr = this.iwp;
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
                    cbb();
                    i4 = this.pos;
                    i2 = this.limit;
                } else if (c2 == '\n') {
                    this.iwq++;
                    this.iwr = i4;
                }
                i3 = i4;
            }
            this.pos = i3;
        } while (yV(1));
        throw zw("Unterminated string");
    }

    private void caY() throws IOException {
        do {
            int i = 0;
            while (this.pos + i < this.limit) {
                switch (this.iwp[this.pos + i]) {
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
                        caZ();
                        this.pos = i + this.pos;
                        return;
                    default:
                        i++;
                }
            }
            this.pos = i + this.pos;
        } while (yV(1));
    }

    public int nextInt() throws IOException {
        int i = this.iws;
        if (i == 0) {
            i = caU();
        }
        if (i == 15) {
            int i2 = (int) this.iwt;
            if (this.iwt != i2) {
                throw new NumberFormatException("Expected an int but was " + this.iwt + caK());
            }
            this.iws = 0;
            int[] iArr = this.iuv;
            int i3 = this.iut - 1;
            iArr[i3] = iArr[i3] + 1;
            return i2;
        }
        if (i == 16) {
            this.iwv = new String(this.iwp, this.pos, this.iwu);
            this.pos += this.iwu;
        } else if (i == 8 || i == 9 || i == 10) {
            if (i == 10) {
                this.iwv = caX();
            } else {
                this.iwv = i(i == 8 ? '\'' : '\"');
            }
            try {
                int parseInt = Integer.parseInt(this.iwv);
                this.iws = 0;
                int[] iArr2 = this.iuv;
                int i4 = this.iut - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseInt;
            } catch (NumberFormatException e) {
            }
        } else {
            throw new IllegalStateException("Expected an int but was " + caG() + caK());
        }
        this.iws = 11;
        double parseDouble = Double.parseDouble(this.iwv);
        int i5 = (int) parseDouble;
        if (i5 != parseDouble) {
            throw new NumberFormatException("Expected an int but was " + this.iwv + caK());
        }
        this.iwv = null;
        this.iws = 0;
        int[] iArr3 = this.iuv;
        int i6 = this.iut - 1;
        iArr3[i6] = iArr3[i6] + 1;
        return i5;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.iws = 0;
        this.iww[0] = 8;
        this.iut = 1;
        this.in.close();
    }

    public void skipValue() throws IOException {
        int i = 0;
        do {
            int i2 = this.iws;
            if (i2 == 0) {
                i2 = caU();
            }
            if (i2 == 3) {
                yU(1);
                i++;
            } else if (i2 == 1) {
                yU(3);
                i++;
            } else if (i2 == 4) {
                this.iut--;
                i--;
            } else if (i2 == 2) {
                this.iut--;
                i--;
            } else if (i2 == 14 || i2 == 10) {
                caY();
            } else if (i2 == 8 || i2 == 12) {
                j('\'');
            } else if (i2 == 9 || i2 == 13) {
                j('\"');
            } else if (i2 == 16) {
                this.pos += this.iwu;
            }
            this.iws = 0;
        } while (i != 0);
        int[] iArr = this.iuv;
        int i3 = this.iut - 1;
        iArr[i3] = iArr[i3] + 1;
        this.iuu[this.iut - 1] = "null";
    }

    private void yU(int i) {
        if (this.iut == this.iww.length) {
            int[] iArr = new int[this.iut * 2];
            int[] iArr2 = new int[this.iut * 2];
            String[] strArr = new String[this.iut * 2];
            System.arraycopy(this.iww, 0, iArr, 0, this.iut);
            System.arraycopy(this.iuv, 0, iArr2, 0, this.iut);
            System.arraycopy(this.iuu, 0, strArr, 0, this.iut);
            this.iww = iArr;
            this.iuv = iArr2;
            this.iuu = strArr;
        }
        int[] iArr3 = this.iww;
        int i2 = this.iut;
        this.iut = i2 + 1;
        iArr3[i2] = i;
    }

    private boolean yV(int i) throws IOException {
        char[] cArr = this.iwp;
        this.iwr -= this.pos;
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
            if (this.iwq == 0 && this.iwr == 0 && this.limit > 0 && cArr[0] == 65279) {
                this.pos++;
                this.iwr++;
                i++;
            }
        } while (this.limit < i);
        return true;
    }

    private int pe(boolean z) throws IOException {
        char[] cArr = this.iwp;
        int i = this.pos;
        int i2 = this.limit;
        while (true) {
            if (i == i2) {
                this.pos = i;
                if (yV(1)) {
                    i = this.pos;
                    i2 = this.limit;
                } else if (z) {
                    throw new EOFException("End of input" + caK());
                } else {
                    return -1;
                }
            }
            int i3 = i + 1;
            char c = cArr[i];
            if (c == '\n') {
                this.iwq++;
                this.iwr = i3;
                i = i3;
            } else if (c == ' ' || c == '\r') {
                i = i3;
            } else if (c == '\t') {
                i = i3;
            } else if (c == '/') {
                this.pos = i3;
                if (i3 == i2) {
                    this.pos--;
                    boolean yV = yV(2);
                    this.pos++;
                    if (!yV) {
                        return c;
                    }
                }
                caZ();
                switch (cArr[this.pos]) {
                    case '*':
                        this.pos++;
                        if (!zv("*/")) {
                            throw zw("Unterminated comment");
                        }
                        i = this.pos + 2;
                        i2 = this.limit;
                        continue;
                    case '/':
                        this.pos++;
                        cba();
                        i = this.pos;
                        i2 = this.limit;
                        continue;
                    default:
                        return c;
                }
            } else if (c == '#') {
                this.pos = i3;
                caZ();
                cba();
                i = this.pos;
                i2 = this.limit;
            } else {
                this.pos = i3;
                return c;
            }
        }
    }

    private void caZ() throws IOException {
        if (!this.isX) {
            throw zw("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void cba() throws IOException {
        char c;
        do {
            if (this.pos < this.limit || yV(1)) {
                char[] cArr = this.iwp;
                int i = this.pos;
                this.pos = i + 1;
                c = cArr[i];
                if (c == '\n') {
                    this.iwq++;
                    this.iwr = this.pos;
                    return;
                }
            } else {
                return;
            }
        } while (c != '\r');
    }

    private boolean zv(String str) throws IOException {
        int i;
        while (true) {
            if (this.pos + str.length() > this.limit && !yV(str.length())) {
                return false;
            }
            if (this.iwp[this.pos] == '\n') {
                this.iwq++;
                this.iwr = this.pos + 1;
            } else {
                for (i = 0; i < str.length(); i = i + 1) {
                    i = this.iwp[this.pos + i] == str.charAt(i) ? i + 1 : 0;
                }
                return true;
            }
            this.pos++;
        }
    }

    public String toString() {
        return getClass().getSimpleName() + caK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String caK() {
        return " at line " + (this.iwq + 1) + " column " + ((this.pos - this.iwr) + 1) + " path " + getPath();
    }

    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = this.iut;
        for (int i2 = 0; i2 < i; i2++) {
            switch (this.iww[i2]) {
                case 1:
                case 2:
                    append.append('[').append(this.iuv[i2]).append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    append.append('.');
                    if (this.iuu[i2] != null) {
                        append.append(this.iuu[i2]);
                        break;
                    } else {
                        break;
                    }
            }
        }
        return append.toString();
    }

    private char cbb() throws IOException {
        int i;
        if (this.pos == this.limit && !yV(1)) {
            throw zw("Unterminated escape sequence");
        }
        char[] cArr = this.iwp;
        int i2 = this.pos;
        this.pos = i2 + 1;
        char c = cArr[i2];
        switch (c) {
            case '\n':
                this.iwq++;
                this.iwr = this.pos;
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
                if (this.pos + 4 > this.limit && !yV(4)) {
                    throw zw("Unterminated escape sequence");
                }
                int i3 = this.pos;
                int i4 = i3 + 4;
                char c2 = 0;
                for (int i5 = i3; i5 < i4; i5++) {
                    char c3 = this.iwp[i5];
                    char c4 = (char) (c2 << 4);
                    if (c3 >= '0' && c3 <= '9') {
                        i = c3 - '0';
                    } else if (c3 >= 'a' && c3 <= 'f') {
                        i = (c3 - 'a') + 10;
                    } else if (c3 >= 'A' && c3 <= 'F') {
                        i = (c3 - 'A') + 10;
                    } else {
                        throw new NumberFormatException("\\u" + new String(this.iwp, this.pos, 4));
                    }
                    c2 = (char) (c4 + i);
                }
                this.pos += 4;
                return c2;
            default:
                throw zw("Invalid escape sequence");
        }
    }

    private IOException zw(String str) throws IOException {
        throw new MalformedJsonException(str + caK());
    }

    private void cbc() throws IOException {
        pe(true);
        this.pos--;
        if (this.pos + iwo.length <= this.limit || yV(iwo.length)) {
            for (int i = 0; i < iwo.length; i++) {
                if (this.iwp[this.pos + i] != iwo[i]) {
                    return;
                }
            }
            this.pos += iwo.length;
        }
    }
}
