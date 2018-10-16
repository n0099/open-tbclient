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

    /* renamed from: int  reason: not valid java name */
    private static final char[] f0int = ")]}'\n".toCharArray();
    private int ilw;
    private String[] ilx;
    private int[] ily;
    private final Reader in;
    private String inA;
    private long iny;
    private int inz;
    private boolean ika = false;
    private final char[] inu = new char[1024];
    private int pos = 0;
    private int limit = 0;
    private int inv = 0;
    private int inw = 0;
    int inx = 0;
    private int[] inB = new int[32];

    static {
        d.ikF = new d() { // from class: com.google.gson.stream.a.1
            @Override // com.google.gson.internal.d
            public void g(a aVar) throws IOException {
                if (aVar instanceof e) {
                    ((e) aVar).bZh();
                    return;
                }
                int i = aVar.inx;
                if (i == 0) {
                    i = aVar.bZs();
                }
                if (i == 13) {
                    aVar.inx = 9;
                } else if (i == 12) {
                    aVar.inx = 8;
                } else if (i == 14) {
                    aVar.inx = 10;
                } else {
                    throw new IllegalStateException("Expected a name but was " + aVar.bZe() + aVar.bZi());
                }
            }
        };
    }

    public a(Reader reader) {
        this.ilw = 0;
        int[] iArr = this.inB;
        int i = this.ilw;
        this.ilw = i + 1;
        iArr[i] = 6;
        this.ilx = new String[32];
        this.ily = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.in = reader;
    }

    public final void setLenient(boolean z) {
        this.ika = z;
    }

    public final boolean isLenient() {
        return this.ika;
    }

    public void beginArray() throws IOException {
        int i = this.inx;
        if (i == 0) {
            i = bZs();
        }
        if (i == 3) {
            ye(1);
            this.ily[this.ilw - 1] = 0;
            this.inx = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + bZe() + bZi());
    }

    public void endArray() throws IOException {
        int i = this.inx;
        if (i == 0) {
            i = bZs();
        }
        if (i == 4) {
            this.ilw--;
            int[] iArr = this.ily;
            int i2 = this.ilw - 1;
            iArr[i2] = iArr[i2] + 1;
            this.inx = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + bZe() + bZi());
    }

    public void beginObject() throws IOException {
        int i = this.inx;
        if (i == 0) {
            i = bZs();
        }
        if (i == 1) {
            ye(3);
            this.inx = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + bZe() + bZi());
    }

    public void endObject() throws IOException {
        int i = this.inx;
        if (i == 0) {
            i = bZs();
        }
        if (i == 2) {
            this.ilw--;
            this.ilx[this.ilw] = null;
            int[] iArr = this.ily;
            int i2 = this.ilw - 1;
            iArr[i2] = iArr[i2] + 1;
            this.inx = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + bZe() + bZi());
    }

    public boolean hasNext() throws IOException {
        int i = this.inx;
        if (i == 0) {
            i = bZs();
        }
        return (i == 2 || i == 4) ? false : true;
    }

    public JsonToken bZe() throws IOException {
        int i = this.inx;
        if (i == 0) {
            i = bZs();
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
    int bZs() throws IOException {
        int i = this.inB[this.ilw - 1];
        if (i == 1) {
            this.inB[this.ilw - 1] = 2;
        } else if (i == 2) {
            switch (oP(true)) {
                case 44:
                    break;
                case 59:
                    bZx();
                    break;
                case 93:
                    this.inx = 4;
                    return 4;
                default:
                    throw yO("Unterminated array");
            }
        } else if (i == 3 || i == 5) {
            this.inB[this.ilw - 1] = 4;
            if (i == 5) {
                switch (oP(true)) {
                    case 44:
                        break;
                    case 59:
                        bZx();
                        break;
                    case 125:
                        this.inx = 2;
                        return 2;
                    default:
                        throw yO("Unterminated object");
                }
            }
            int oP = oP(true);
            switch (oP) {
                case 34:
                    this.inx = 13;
                    return 13;
                case 39:
                    bZx();
                    this.inx = 12;
                    return 12;
                case 125:
                    if (i != 5) {
                        this.inx = 2;
                        return 2;
                    }
                    throw yO("Expected name");
                default:
                    bZx();
                    this.pos--;
                    if (h((char) oP)) {
                        this.inx = 14;
                        return 14;
                    }
                    throw yO("Expected name");
            }
        } else if (i == 4) {
            this.inB[this.ilw - 1] = 5;
            switch (oP(true)) {
                case 58:
                    break;
                case 59:
                case 60:
                default:
                    throw yO("Expected ':'");
                case 61:
                    bZx();
                    if ((this.pos < this.limit || yf(1)) && this.inu[this.pos] == '>') {
                        this.pos++;
                        break;
                    }
                    break;
            }
        } else if (i == 6) {
            if (this.ika) {
                bZA();
            }
            this.inB[this.ilw - 1] = 7;
        } else if (i == 7) {
            if (oP(false) == -1) {
                this.inx = 17;
                return 17;
            }
            bZx();
            this.pos--;
        } else if (i == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        switch (oP(true)) {
            case 34:
                this.inx = 9;
                return 9;
            case 39:
                bZx();
                this.inx = 8;
                return 8;
            case 44:
            case 59:
                break;
            case 91:
                this.inx = 3;
                return 3;
            case 93:
                if (i == 1) {
                    this.inx = 4;
                    return 4;
                }
                break;
            case 123:
                this.inx = 1;
                return 1;
            default:
                this.pos--;
                int bZt = bZt();
                if (bZt == 0) {
                    int bZu = bZu();
                    if (bZu == 0) {
                        if (!h(this.inu[this.pos])) {
                            throw yO("Expected value");
                        }
                        bZx();
                        this.inx = 10;
                        return 10;
                    }
                    return bZu;
                }
                return bZt;
        }
        if (i == 1 || i == 2) {
            bZx();
            this.pos--;
            this.inx = 7;
            return 7;
        }
        throw yO("Unexpected value");
    }

    private int bZt() throws IOException {
        String str;
        String str2;
        int i;
        char c = this.inu[this.pos];
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
            if (this.pos + i2 >= this.limit && !yf(i2 + 1)) {
                return 0;
            }
            char c2 = this.inu[this.pos + i2];
            if (c2 != str.charAt(i2) && c2 != str2.charAt(i2)) {
                return 0;
            }
        }
        if ((this.pos + length < this.limit || yf(length + 1)) && h(this.inu[this.pos + length])) {
            return 0;
        }
        this.pos += length;
        this.inx = i;
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
        r15.iny = r6;
        r15.pos += r10;
        r15.inx = 15;
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
        r15.inz = r10;
        r15.inx = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x00f0, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int bZu() throws IOException {
        char c;
        boolean z;
        boolean z2;
        char[] cArr = this.inu;
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
                if (yf(i2 + 1)) {
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
                bZx();
                break;
        }
        return false;
    }

    public String nextName() throws IOException {
        String i;
        int i2 = this.inx;
        if (i2 == 0) {
            i2 = bZs();
        }
        if (i2 == 14) {
            i = bZv();
        } else if (i2 == 12) {
            i = i('\'');
        } else if (i2 == 13) {
            i = i('\"');
        } else {
            throw new IllegalStateException("Expected a name but was " + bZe() + bZi());
        }
        this.inx = 0;
        this.ilx[this.ilw - 1] = i;
        return i;
    }

    public String nextString() throws IOException {
        String str;
        int i = this.inx;
        if (i == 0) {
            i = bZs();
        }
        if (i == 10) {
            str = bZv();
        } else if (i == 8) {
            str = i('\'');
        } else if (i == 9) {
            str = i('\"');
        } else if (i == 11) {
            str = this.inA;
            this.inA = null;
        } else if (i == 15) {
            str = Long.toString(this.iny);
        } else if (i == 16) {
            str = new String(this.inu, this.pos, this.inz);
            this.pos += this.inz;
        } else {
            throw new IllegalStateException("Expected a string but was " + bZe() + bZi());
        }
        this.inx = 0;
        int[] iArr = this.ily;
        int i2 = this.ilw - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    public boolean nextBoolean() throws IOException {
        int i = this.inx;
        if (i == 0) {
            i = bZs();
        }
        if (i == 5) {
            this.inx = 0;
            int[] iArr = this.ily;
            int i2 = this.ilw - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        } else if (i == 6) {
            this.inx = 0;
            int[] iArr2 = this.ily;
            int i3 = this.ilw - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + bZe() + bZi());
        }
    }

    public void nextNull() throws IOException {
        int i = this.inx;
        if (i == 0) {
            i = bZs();
        }
        if (i == 7) {
            this.inx = 0;
            int[] iArr = this.ily;
            int i2 = this.ilw - 1;
            iArr[i2] = iArr[i2] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + bZe() + bZi());
    }

    public double nextDouble() throws IOException {
        int i = this.inx;
        if (i == 0) {
            i = bZs();
        }
        if (i == 15) {
            this.inx = 0;
            int[] iArr = this.ily;
            int i2 = this.ilw - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.iny;
        }
        if (i == 16) {
            this.inA = new String(this.inu, this.pos, this.inz);
            this.pos += this.inz;
        } else if (i == 8 || i == 9) {
            this.inA = i(i == 8 ? '\'' : '\"');
        } else if (i == 10) {
            this.inA = bZv();
        } else if (i != 11) {
            throw new IllegalStateException("Expected a double but was " + bZe() + bZi());
        }
        this.inx = 11;
        double parseDouble = Double.parseDouble(this.inA);
        if (!this.ika && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + parseDouble + bZi());
        }
        this.inA = null;
        this.inx = 0;
        int[] iArr2 = this.ily;
        int i3 = this.ilw - 1;
        iArr2[i3] = iArr2[i3] + 1;
        return parseDouble;
    }

    public long nextLong() throws IOException {
        int i = this.inx;
        if (i == 0) {
            i = bZs();
        }
        if (i == 15) {
            this.inx = 0;
            int[] iArr = this.ily;
            int i2 = this.ilw - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.iny;
        }
        if (i == 16) {
            this.inA = new String(this.inu, this.pos, this.inz);
            this.pos += this.inz;
        } else if (i == 8 || i == 9 || i == 10) {
            if (i == 10) {
                this.inA = bZv();
            } else {
                this.inA = i(i == 8 ? '\'' : '\"');
            }
            try {
                long parseLong = Long.parseLong(this.inA);
                this.inx = 0;
                int[] iArr2 = this.ily;
                int i3 = this.ilw - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return parseLong;
            } catch (NumberFormatException e) {
            }
        } else {
            throw new IllegalStateException("Expected a long but was " + bZe() + bZi());
        }
        this.inx = 11;
        double parseDouble = Double.parseDouble(this.inA);
        long j = (long) parseDouble;
        if (j != parseDouble) {
            throw new NumberFormatException("Expected a long but was " + this.inA + bZi());
        }
        this.inA = null;
        this.inx = 0;
        int[] iArr3 = this.ily;
        int i4 = this.ilw - 1;
        iArr3[i4] = iArr3[i4] + 1;
        return j;
    }

    private String i(char c) throws IOException {
        char[] cArr = this.inu;
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
                    sb.append(bZz());
                    i = this.pos;
                    i2 = this.limit;
                    i4 = i;
                } else if (c2 == '\n') {
                    this.inv++;
                    this.inw = i4;
                }
                i3 = i4;
            }
            sb.append(cArr, i, i3 - i);
            this.pos = i3;
        } while (yf(1));
        throw yO("Unterminated string");
    }

    private String bZv() throws IOException {
        String sb;
        StringBuilder sb2 = null;
        int i = 0;
        while (true) {
            if (this.pos + i < this.limit) {
                switch (this.inu[this.pos + i]) {
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
                        bZx();
                        break;
                    default:
                        i++;
                }
            } else if (i < this.inu.length) {
                if (yf(i + 1)) {
                }
            } else {
                if (sb2 == null) {
                    sb2 = new StringBuilder();
                }
                sb2.append(this.inu, this.pos, i);
                this.pos = i + this.pos;
                if (yf(1)) {
                    i = 0;
                } else {
                    i = 0;
                }
            }
        }
        if (sb2 == null) {
            sb = new String(this.inu, this.pos, i);
        } else {
            sb2.append(this.inu, this.pos, i);
            sb = sb2.toString();
        }
        this.pos = i + this.pos;
        return sb;
    }

    private void j(char c) throws IOException {
        char[] cArr = this.inu;
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
                    bZz();
                    i4 = this.pos;
                    i2 = this.limit;
                } else if (c2 == '\n') {
                    this.inv++;
                    this.inw = i4;
                }
                i3 = i4;
            }
            this.pos = i3;
        } while (yf(1));
        throw yO("Unterminated string");
    }

    private void bZw() throws IOException {
        do {
            int i = 0;
            while (this.pos + i < this.limit) {
                switch (this.inu[this.pos + i]) {
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
                        bZx();
                        this.pos = i + this.pos;
                        return;
                    default:
                        i++;
                }
            }
            this.pos = i + this.pos;
        } while (yf(1));
    }

    public int nextInt() throws IOException {
        int i = this.inx;
        if (i == 0) {
            i = bZs();
        }
        if (i == 15) {
            int i2 = (int) this.iny;
            if (this.iny != i2) {
                throw new NumberFormatException("Expected an int but was " + this.iny + bZi());
            }
            this.inx = 0;
            int[] iArr = this.ily;
            int i3 = this.ilw - 1;
            iArr[i3] = iArr[i3] + 1;
            return i2;
        }
        if (i == 16) {
            this.inA = new String(this.inu, this.pos, this.inz);
            this.pos += this.inz;
        } else if (i == 8 || i == 9 || i == 10) {
            if (i == 10) {
                this.inA = bZv();
            } else {
                this.inA = i(i == 8 ? '\'' : '\"');
            }
            try {
                int parseInt = Integer.parseInt(this.inA);
                this.inx = 0;
                int[] iArr2 = this.ily;
                int i4 = this.ilw - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseInt;
            } catch (NumberFormatException e) {
            }
        } else {
            throw new IllegalStateException("Expected an int but was " + bZe() + bZi());
        }
        this.inx = 11;
        double parseDouble = Double.parseDouble(this.inA);
        int i5 = (int) parseDouble;
        if (i5 != parseDouble) {
            throw new NumberFormatException("Expected an int but was " + this.inA + bZi());
        }
        this.inA = null;
        this.inx = 0;
        int[] iArr3 = this.ily;
        int i6 = this.ilw - 1;
        iArr3[i6] = iArr3[i6] + 1;
        return i5;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.inx = 0;
        this.inB[0] = 8;
        this.ilw = 1;
        this.in.close();
    }

    public void skipValue() throws IOException {
        int i = 0;
        do {
            int i2 = this.inx;
            if (i2 == 0) {
                i2 = bZs();
            }
            if (i2 == 3) {
                ye(1);
                i++;
            } else if (i2 == 1) {
                ye(3);
                i++;
            } else if (i2 == 4) {
                this.ilw--;
                i--;
            } else if (i2 == 2) {
                this.ilw--;
                i--;
            } else if (i2 == 14 || i2 == 10) {
                bZw();
            } else if (i2 == 8 || i2 == 12) {
                j('\'');
            } else if (i2 == 9 || i2 == 13) {
                j('\"');
            } else if (i2 == 16) {
                this.pos += this.inz;
            }
            this.inx = 0;
        } while (i != 0);
        int[] iArr = this.ily;
        int i3 = this.ilw - 1;
        iArr[i3] = iArr[i3] + 1;
        this.ilx[this.ilw - 1] = "null";
    }

    private void ye(int i) {
        if (this.ilw == this.inB.length) {
            int[] iArr = new int[this.ilw * 2];
            int[] iArr2 = new int[this.ilw * 2];
            String[] strArr = new String[this.ilw * 2];
            System.arraycopy(this.inB, 0, iArr, 0, this.ilw);
            System.arraycopy(this.ily, 0, iArr2, 0, this.ilw);
            System.arraycopy(this.ilx, 0, strArr, 0, this.ilw);
            this.inB = iArr;
            this.ily = iArr2;
            this.ilx = strArr;
        }
        int[] iArr3 = this.inB;
        int i2 = this.ilw;
        this.ilw = i2 + 1;
        iArr3[i2] = i;
    }

    private boolean yf(int i) throws IOException {
        char[] cArr = this.inu;
        this.inw -= this.pos;
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
            if (this.inv == 0 && this.inw == 0 && this.limit > 0 && cArr[0] == 65279) {
                this.pos++;
                this.inw++;
                i++;
            }
        } while (this.limit < i);
        return true;
    }

    private int oP(boolean z) throws IOException {
        char[] cArr = this.inu;
        int i = this.pos;
        int i2 = this.limit;
        while (true) {
            if (i == i2) {
                this.pos = i;
                if (yf(1)) {
                    i = this.pos;
                    i2 = this.limit;
                } else if (z) {
                    throw new EOFException("End of input" + bZi());
                } else {
                    return -1;
                }
            }
            int i3 = i + 1;
            char c = cArr[i];
            if (c == '\n') {
                this.inv++;
                this.inw = i3;
                i = i3;
            } else if (c == ' ' || c == '\r') {
                i = i3;
            } else if (c == '\t') {
                i = i3;
            } else if (c == '/') {
                this.pos = i3;
                if (i3 == i2) {
                    this.pos--;
                    boolean yf = yf(2);
                    this.pos++;
                    if (!yf) {
                        return c;
                    }
                }
                bZx();
                switch (cArr[this.pos]) {
                    case '*':
                        this.pos++;
                        if (!yN("*/")) {
                            throw yO("Unterminated comment");
                        }
                        i = this.pos + 2;
                        i2 = this.limit;
                        continue;
                    case '/':
                        this.pos++;
                        bZy();
                        i = this.pos;
                        i2 = this.limit;
                        continue;
                    default:
                        return c;
                }
            } else if (c == '#') {
                this.pos = i3;
                bZx();
                bZy();
                i = this.pos;
                i2 = this.limit;
            } else {
                this.pos = i3;
                return c;
            }
        }
    }

    private void bZx() throws IOException {
        if (!this.ika) {
            throw yO("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void bZy() throws IOException {
        char c;
        do {
            if (this.pos < this.limit || yf(1)) {
                char[] cArr = this.inu;
                int i = this.pos;
                this.pos = i + 1;
                c = cArr[i];
                if (c == '\n') {
                    this.inv++;
                    this.inw = this.pos;
                    return;
                }
            } else {
                return;
            }
        } while (c != '\r');
    }

    private boolean yN(String str) throws IOException {
        int i;
        while (true) {
            if (this.pos + str.length() > this.limit && !yf(str.length())) {
                return false;
            }
            if (this.inu[this.pos] == '\n') {
                this.inv++;
                this.inw = this.pos + 1;
            } else {
                for (i = 0; i < str.length(); i = i + 1) {
                    i = this.inu[this.pos + i] == str.charAt(i) ? i + 1 : 0;
                }
                return true;
            }
            this.pos++;
        }
    }

    public String toString() {
        return getClass().getSimpleName() + bZi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bZi() {
        return " at line " + (this.inv + 1) + " column " + ((this.pos - this.inw) + 1) + " path " + getPath();
    }

    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = this.ilw;
        for (int i2 = 0; i2 < i; i2++) {
            switch (this.inB[i2]) {
                case 1:
                case 2:
                    append.append('[').append(this.ily[i2]).append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    append.append('.');
                    if (this.ilx[i2] != null) {
                        append.append(this.ilx[i2]);
                        break;
                    } else {
                        break;
                    }
            }
        }
        return append.toString();
    }

    private char bZz() throws IOException {
        int i;
        if (this.pos == this.limit && !yf(1)) {
            throw yO("Unterminated escape sequence");
        }
        char[] cArr = this.inu;
        int i2 = this.pos;
        this.pos = i2 + 1;
        char c = cArr[i2];
        switch (c) {
            case '\n':
                this.inv++;
                this.inw = this.pos;
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
                if (this.pos + 4 > this.limit && !yf(4)) {
                    throw yO("Unterminated escape sequence");
                }
                int i3 = this.pos;
                int i4 = i3 + 4;
                char c2 = 0;
                for (int i5 = i3; i5 < i4; i5++) {
                    char c3 = this.inu[i5];
                    char c4 = (char) (c2 << 4);
                    if (c3 >= '0' && c3 <= '9') {
                        i = c3 - '0';
                    } else if (c3 >= 'a' && c3 <= 'f') {
                        i = (c3 - 'a') + 10;
                    } else if (c3 >= 'A' && c3 <= 'F') {
                        i = (c3 - 'A') + 10;
                    } else {
                        throw new NumberFormatException("\\u" + new String(this.inu, this.pos, 4));
                    }
                    c2 = (char) (c4 + i);
                }
                this.pos += 4;
                return c2;
            default:
                throw yO("Invalid escape sequence");
        }
    }

    private IOException yO(String str) throws IOException {
        throw new MalformedJsonException(str + bZi());
    }

    private void bZA() throws IOException {
        oP(true);
        this.pos--;
        if (this.pos + f0int.length <= this.limit || yf(f0int.length)) {
            for (int i = 0; i < f0int.length; i++) {
                if (this.inu[this.pos + i] != f0int[i]) {
                    return;
                }
            }
            this.pos += f0int.length;
        }
    }
}
