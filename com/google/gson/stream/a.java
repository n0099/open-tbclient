package com.google.gson.stream;

import com.baidu.android.imsdk.internal.Constants;
import com.google.gson.internal.d;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
/* loaded from: classes17.dex */
public class a implements Closeable {
    private static final char[] pfW = ")]}'\n".toCharArray();
    private int pdY;
    private String[] pdZ;
    private int[] pea;
    private final Reader pfX;
    private long pgc;
    private int pgd;
    private String pge;
    private boolean lenient = false;
    private final char[] pfY = new char[1024];
    private int pos = 0;
    private int limit = 0;
    private int pfZ = 0;
    private int pga = 0;
    int pgb = 0;
    private int[] pgf = new int[32];

    static {
        d.pdm = new d() { // from class: com.google.gson.stream.a.1
            @Override // com.google.gson.internal.d
            public void a(a aVar) throws IOException {
                if (aVar instanceof com.google.gson.internal.bind.a) {
                    ((com.google.gson.internal.bind.a) aVar).etd();
                    return;
                }
                int i = aVar.pgb;
                if (i == 0) {
                    i = aVar.etr();
                }
                if (i == 13) {
                    aVar.pgb = 9;
                } else if (i == 12) {
                    aVar.pgb = 8;
                } else if (i == 14) {
                    aVar.pgb = 10;
                } else {
                    throw new IllegalStateException("Expected a name but was " + aVar.esW() + aVar.ete());
                }
            }
        };
    }

    public a(Reader reader) {
        this.pdY = 0;
        int[] iArr = this.pgf;
        int i = this.pdY;
        this.pdY = i + 1;
        iArr[i] = 6;
        this.pdZ = new String[32];
        this.pea = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.pfX = reader;
    }

    public final void Az(boolean z) {
        this.lenient = z;
    }

    public final boolean etq() {
        return this.lenient;
    }

    public void esU() throws IOException {
        int i = this.pgb;
        if (i == 0) {
            i = etr();
        }
        if (i == 3) {
            push(1);
            this.pea[this.pdY - 1] = 0;
            this.pgb = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + esW() + ete());
    }

    public void endArray() throws IOException {
        int i = this.pgb;
        if (i == 0) {
            i = etr();
        }
        if (i == 4) {
            this.pdY--;
            int[] iArr = this.pea;
            int i2 = this.pdY - 1;
            iArr[i2] = iArr[i2] + 1;
            this.pgb = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + esW() + ete());
    }

    public void esV() throws IOException {
        int i = this.pgb;
        if (i == 0) {
            i = etr();
        }
        if (i == 1) {
            push(3);
            this.pgb = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + esW() + ete());
    }

    public void endObject() throws IOException {
        int i = this.pgb;
        if (i == 0) {
            i = etr();
        }
        if (i == 2) {
            this.pdY--;
            this.pdZ[this.pdY] = null;
            int[] iArr = this.pea;
            int i2 = this.pdY - 1;
            iArr[i2] = iArr[i2] + 1;
            this.pgb = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + esW() + ete());
    }

    public boolean hasNext() throws IOException {
        int i = this.pgb;
        if (i == 0) {
            i = etr();
        }
        return (i == 2 || i == 4) ? false : true;
    }

    public JsonToken esW() throws IOException {
        int i = this.pgb;
        if (i == 0) {
            i = etr();
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
    int etr() throws IOException {
        int i = this.pgf[this.pdY - 1];
        if (i == 1) {
            this.pgf[this.pdY - 1] = 2;
        } else if (i == 2) {
            switch (AA(true)) {
                case 44:
                    break;
                case 59:
                    etw();
                    break;
                case 93:
                    this.pgb = 4;
                    return 4;
                default:
                    throw YC("Unterminated array");
            }
        } else if (i == 3 || i == 5) {
            this.pgf[this.pdY - 1] = 4;
            if (i == 5) {
                switch (AA(true)) {
                    case 44:
                        break;
                    case 59:
                        etw();
                        break;
                    case Constants.METHOD_IM_FRIEND_GROUP_ASSIGN /* 125 */:
                        this.pgb = 2;
                        return 2;
                    default:
                        throw YC("Unterminated object");
                }
            }
            int AA = AA(true);
            switch (AA) {
                case 34:
                    this.pgb = 13;
                    return 13;
                case 39:
                    etw();
                    this.pgb = 12;
                    return 12;
                case Constants.METHOD_IM_FRIEND_GROUP_ASSIGN /* 125 */:
                    if (i != 5) {
                        this.pgb = 2;
                        return 2;
                    }
                    throw YC("Expected name");
                default:
                    etw();
                    this.pos--;
                    if (f((char) AA)) {
                        this.pgb = 14;
                        return 14;
                    }
                    throw YC("Expected name");
            }
        } else if (i == 4) {
            this.pgf[this.pdY - 1] = 5;
            switch (AA(true)) {
                case 58:
                    break;
                case 59:
                case 60:
                default:
                    throw YC("Expected ':'");
                case 61:
                    etw();
                    if ((this.pos < this.limit || Qu(1)) && this.pfY[this.pos] == '>') {
                        this.pos++;
                        break;
                    }
                    break;
            }
        } else if (i == 6) {
            if (this.lenient) {
                etx();
            }
            this.pgf[this.pdY - 1] = 7;
        } else if (i == 7) {
            if (AA(false) == -1) {
                this.pgb = 17;
                return 17;
            }
            etw();
            this.pos--;
        } else if (i == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        switch (AA(true)) {
            case 34:
                this.pgb = 9;
                return 9;
            case 39:
                etw();
                this.pgb = 8;
                return 8;
            case 44:
            case 59:
                break;
            case 91:
                this.pgb = 3;
                return 3;
            case 93:
                if (i == 1) {
                    this.pgb = 4;
                    return 4;
                }
                break;
            case Constants.METHOD_IM_FRIEND_GROUP_QUERY /* 123 */:
                this.pgb = 1;
                return 1;
            default:
                this.pos--;
                int ets = ets();
                if (ets == 0) {
                    int ett = ett();
                    if (ett == 0) {
                        if (!f(this.pfY[this.pos])) {
                            throw YC("Expected value");
                        }
                        etw();
                        this.pgb = 10;
                        return 10;
                    }
                    return ett;
                }
                return ets;
        }
        if (i == 1 || i == 2) {
            etw();
            this.pos--;
            this.pgb = 7;
            return 7;
        }
        throw YC("Unexpected value");
    }

    private int ets() throws IOException {
        String str;
        String str2;
        int i;
        char c = this.pfY[this.pos];
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
            if (this.pos + i2 >= this.limit && !Qu(i2 + 1)) {
                return 0;
            }
            char c2 = this.pfY[this.pos + i2];
            if (c2 != str.charAt(i2) && c2 != str2.charAt(i2)) {
                return 0;
            }
        }
        if ((this.pos + length < this.limit || Qu(length + 1)) && f(this.pfY[this.pos + length])) {
            return 0;
        }
        this.pos += length;
        this.pgb = i;
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
        r15.pgc = r6;
        r15.pos += r10;
        r15.pgb = 15;
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
        r15.pgd = r10;
        r15.pgb = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x00f8, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int ett() throws IOException {
        char c;
        boolean z;
        boolean z2;
        char[] cArr = this.pfY;
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
                if (Qu(i2 + 1)) {
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
                etw();
                break;
        }
        return false;
    }

    public String esZ() throws IOException {
        String g;
        int i = this.pgb;
        if (i == 0) {
            i = etr();
        }
        if (i == 14) {
            g = etu();
        } else if (i == 12) {
            g = g('\'');
        } else if (i == 13) {
            g = g('\"');
        } else {
            throw new IllegalStateException("Expected a name but was " + esW() + ete());
        }
        this.pgb = 0;
        this.pdZ[this.pdY - 1] = g;
        return g;
    }

    public String eta() throws IOException {
        String str;
        int i = this.pgb;
        if (i == 0) {
            i = etr();
        }
        if (i == 10) {
            str = etu();
        } else if (i == 8) {
            str = g('\'');
        } else if (i == 9) {
            str = g('\"');
        } else if (i == 11) {
            str = this.pge;
            this.pge = null;
        } else if (i == 15) {
            str = Long.toString(this.pgc);
        } else if (i == 16) {
            str = new String(this.pfY, this.pos, this.pgd);
            this.pos += this.pgd;
        } else {
            throw new IllegalStateException("Expected a string but was " + esW() + ete());
        }
        this.pgb = 0;
        int[] iArr = this.pea;
        int i2 = this.pdY - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    public boolean nextBoolean() throws IOException {
        int i = this.pgb;
        if (i == 0) {
            i = etr();
        }
        if (i == 5) {
            this.pgb = 0;
            int[] iArr = this.pea;
            int i2 = this.pdY - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        } else if (i == 6) {
            this.pgb = 0;
            int[] iArr2 = this.pea;
            int i3 = this.pdY - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + esW() + ete());
        }
    }

    public void etb() throws IOException {
        int i = this.pgb;
        if (i == 0) {
            i = etr();
        }
        if (i == 7) {
            this.pgb = 0;
            int[] iArr = this.pea;
            int i2 = this.pdY - 1;
            iArr[i2] = iArr[i2] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + esW() + ete());
    }

    public double nextDouble() throws IOException {
        int i = this.pgb;
        if (i == 0) {
            i = etr();
        }
        if (i == 15) {
            this.pgb = 0;
            int[] iArr = this.pea;
            int i2 = this.pdY - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.pgc;
        }
        if (i == 16) {
            this.pge = new String(this.pfY, this.pos, this.pgd);
            this.pos += this.pgd;
        } else if (i == 8 || i == 9) {
            this.pge = g(i == 8 ? '\'' : '\"');
        } else if (i == 10) {
            this.pge = etu();
        } else if (i != 11) {
            throw new IllegalStateException("Expected a double but was " + esW() + ete());
        }
        this.pgb = 11;
        double parseDouble = Double.parseDouble(this.pge);
        if (!this.lenient && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + parseDouble + ete());
        }
        this.pge = null;
        this.pgb = 0;
        int[] iArr2 = this.pea;
        int i3 = this.pdY - 1;
        iArr2[i3] = iArr2[i3] + 1;
        return parseDouble;
    }

    public long nextLong() throws IOException {
        int i = this.pgb;
        if (i == 0) {
            i = etr();
        }
        if (i == 15) {
            this.pgb = 0;
            int[] iArr = this.pea;
            int i2 = this.pdY - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.pgc;
        }
        if (i == 16) {
            this.pge = new String(this.pfY, this.pos, this.pgd);
            this.pos += this.pgd;
        } else if (i == 8 || i == 9 || i == 10) {
            if (i == 10) {
                this.pge = etu();
            } else {
                this.pge = g(i == 8 ? '\'' : '\"');
            }
            try {
                long parseLong = Long.parseLong(this.pge);
                this.pgb = 0;
                int[] iArr2 = this.pea;
                int i3 = this.pdY - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return parseLong;
            } catch (NumberFormatException e) {
            }
        } else {
            throw new IllegalStateException("Expected a long but was " + esW() + ete());
        }
        this.pgb = 11;
        double parseDouble = Double.parseDouble(this.pge);
        long j = (long) parseDouble;
        if (j != parseDouble) {
            throw new NumberFormatException("Expected a long but was " + this.pge + ete());
        }
        this.pge = null;
        this.pgb = 0;
        int[] iArr3 = this.pea;
        int i4 = this.pdY - 1;
        iArr3[i4] = iArr3[i4] + 1;
        return j;
    }

    private String g(char c) throws IOException {
        int i;
        int i2;
        StringBuilder sb;
        int i3;
        char[] cArr = this.pfY;
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
                        this.pfZ++;
                        this.pga = i7;
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
        } while (Qu(1));
        throw YC("Unterminated string");
    }

    private String etu() throws IOException {
        StringBuilder sb = null;
        int i = 0;
        while (true) {
            if (this.pos + i < this.limit) {
                switch (this.pfY[this.pos + i]) {
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
                        etw();
                        break;
                    default:
                        i++;
                }
            } else if (i < this.pfY.length) {
                if (Qu(i + 1)) {
                }
            } else {
                if (sb == null) {
                    sb = new StringBuilder(Math.max(i, 16));
                }
                sb.append(this.pfY, this.pos, i);
                this.pos = i + this.pos;
                if (Qu(1)) {
                    i = 0;
                } else {
                    i = 0;
                }
            }
        }
        String str = sb == null ? new String(this.pfY, this.pos, i) : sb.append(this.pfY, this.pos, i).toString();
        this.pos = i + this.pos;
        return str;
    }

    private void h(char c) throws IOException {
        char[] cArr = this.pfY;
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
                    this.pfZ++;
                    this.pga = i4;
                }
                i3 = i4;
            }
            this.pos = i3;
        } while (Qu(1));
        throw YC("Unterminated string");
    }

    private void etv() throws IOException {
        do {
            int i = 0;
            while (this.pos + i < this.limit) {
                switch (this.pfY[this.pos + i]) {
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
                        etw();
                        this.pos = i + this.pos;
                        return;
                    default:
                        i++;
                }
            }
            this.pos = i + this.pos;
        } while (Qu(1));
    }

    public int nextInt() throws IOException {
        int i = this.pgb;
        if (i == 0) {
            i = etr();
        }
        if (i == 15) {
            int i2 = (int) this.pgc;
            if (this.pgc != i2) {
                throw new NumberFormatException("Expected an int but was " + this.pgc + ete());
            }
            this.pgb = 0;
            int[] iArr = this.pea;
            int i3 = this.pdY - 1;
            iArr[i3] = iArr[i3] + 1;
            return i2;
        }
        if (i == 16) {
            this.pge = new String(this.pfY, this.pos, this.pgd);
            this.pos += this.pgd;
        } else if (i == 8 || i == 9 || i == 10) {
            if (i == 10) {
                this.pge = etu();
            } else {
                this.pge = g(i == 8 ? '\'' : '\"');
            }
            try {
                int parseInt = Integer.parseInt(this.pge);
                this.pgb = 0;
                int[] iArr2 = this.pea;
                int i4 = this.pdY - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseInt;
            } catch (NumberFormatException e) {
            }
        } else {
            throw new IllegalStateException("Expected an int but was " + esW() + ete());
        }
        this.pgb = 11;
        double parseDouble = Double.parseDouble(this.pge);
        int i5 = (int) parseDouble;
        if (i5 != parseDouble) {
            throw new NumberFormatException("Expected an int but was " + this.pge + ete());
        }
        this.pge = null;
        this.pgb = 0;
        int[] iArr3 = this.pea;
        int i6 = this.pdY - 1;
        iArr3[i6] = iArr3[i6] + 1;
        return i5;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.pgb = 0;
        this.pgf[0] = 8;
        this.pdY = 1;
        this.pfX.close();
    }

    public void etc() throws IOException {
        int i = 0;
        do {
            int i2 = this.pgb;
            if (i2 == 0) {
                i2 = etr();
            }
            if (i2 == 3) {
                push(1);
                i++;
            } else if (i2 == 1) {
                push(3);
                i++;
            } else if (i2 == 4) {
                this.pdY--;
                i--;
            } else if (i2 == 2) {
                this.pdY--;
                i--;
            } else if (i2 == 14 || i2 == 10) {
                etv();
            } else if (i2 == 8 || i2 == 12) {
                h('\'');
            } else if (i2 == 9 || i2 == 13) {
                h('\"');
            } else if (i2 == 16) {
                this.pos += this.pgd;
            }
            this.pgb = 0;
        } while (i != 0);
        int[] iArr = this.pea;
        int i3 = this.pdY - 1;
        iArr[i3] = iArr[i3] + 1;
        this.pdZ[this.pdY - 1] = "null";
    }

    private void push(int i) {
        if (this.pdY == this.pgf.length) {
            int[] iArr = new int[this.pdY * 2];
            int[] iArr2 = new int[this.pdY * 2];
            String[] strArr = new String[this.pdY * 2];
            System.arraycopy(this.pgf, 0, iArr, 0, this.pdY);
            System.arraycopy(this.pea, 0, iArr2, 0, this.pdY);
            System.arraycopy(this.pdZ, 0, strArr, 0, this.pdY);
            this.pgf = iArr;
            this.pea = iArr2;
            this.pdZ = strArr;
        }
        int[] iArr3 = this.pgf;
        int i2 = this.pdY;
        this.pdY = i2 + 1;
        iArr3[i2] = i;
    }

    private boolean Qu(int i) throws IOException {
        char[] cArr = this.pfY;
        this.pga -= this.pos;
        if (this.limit != this.pos) {
            this.limit -= this.pos;
            System.arraycopy(cArr, this.pos, cArr, 0, this.limit);
        } else {
            this.limit = 0;
        }
        this.pos = 0;
        do {
            int read = this.pfX.read(cArr, this.limit, cArr.length - this.limit);
            if (read == -1) {
                return false;
            }
            this.limit = read + this.limit;
            if (this.pfZ == 0 && this.pga == 0 && this.limit > 0 && cArr[0] == 65279) {
                this.pos++;
                this.pga++;
                i++;
            }
        } while (this.limit < i);
        return true;
    }

    private int AA(boolean z) throws IOException {
        char[] cArr = this.pfY;
        int i = this.pos;
        int i2 = this.limit;
        while (true) {
            if (i == i2) {
                this.pos = i;
                if (Qu(1)) {
                    i = this.pos;
                    i2 = this.limit;
                } else if (z) {
                    throw new EOFException("End of input" + ete());
                } else {
                    return -1;
                }
            }
            int i3 = i + 1;
            char c = cArr[i];
            if (c == '\n') {
                this.pfZ++;
                this.pga = i3;
                i = i3;
            } else if (c == ' ' || c == '\r') {
                i = i3;
            } else if (c == '\t') {
                i = i3;
            } else if (c == '/') {
                this.pos = i3;
                if (i3 == i2) {
                    this.pos--;
                    boolean Qu = Qu(2);
                    this.pos++;
                    if (!Qu) {
                        return c;
                    }
                }
                etw();
                switch (cArr[this.pos]) {
                    case '*':
                        this.pos++;
                        if (!YB("*/")) {
                            throw YC("Unterminated comment");
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
                etw();
                skipToEndOfLine();
                i = this.pos;
                i2 = this.limit;
            } else {
                this.pos = i3;
                return c;
            }
        }
    }

    private void etw() throws IOException {
        if (!this.lenient) {
            throw YC("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void skipToEndOfLine() throws IOException {
        char c;
        do {
            if (this.pos < this.limit || Qu(1)) {
                char[] cArr = this.pfY;
                int i = this.pos;
                this.pos = i + 1;
                c = cArr[i];
                if (c == '\n') {
                    this.pfZ++;
                    this.pga = this.pos;
                    return;
                }
            } else {
                return;
            }
        } while (c != '\r');
    }

    private boolean YB(String str) throws IOException {
        int i;
        int length = str.length();
        while (true) {
            if (this.pos + length > this.limit && !Qu(length)) {
                return false;
            }
            if (this.pfY[this.pos] == '\n') {
                this.pfZ++;
                this.pga = this.pos + 1;
            } else {
                for (i = 0; i < length; i = i + 1) {
                    i = this.pfY[this.pos + i] == str.charAt(i) ? i + 1 : 0;
                }
                return true;
            }
            this.pos++;
        }
    }

    public String toString() {
        return getClass().getSimpleName() + ete();
    }

    String ete() {
        return " at line " + (this.pfZ + 1) + " column " + ((this.pos - this.pga) + 1) + " path " + getPath();
    }

    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = this.pdY;
        for (int i2 = 0; i2 < i; i2++) {
            switch (this.pgf[i2]) {
                case 1:
                case 2:
                    append.append('[').append(this.pea[i2]).append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    append.append('.');
                    if (this.pdZ[i2] != null) {
                        append.append(this.pdZ[i2]);
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
        if (this.pos == this.limit && !Qu(1)) {
            throw YC("Unterminated escape sequence");
        }
        char[] cArr = this.pfY;
        int i2 = this.pos;
        this.pos = i2 + 1;
        char c = cArr[i2];
        switch (c) {
            case '\n':
                this.pfZ++;
                this.pga = this.pos;
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
                if (this.pos + 4 > this.limit && !Qu(4)) {
                    throw YC("Unterminated escape sequence");
                }
                int i3 = this.pos;
                int i4 = i3 + 4;
                char c2 = 0;
                for (int i5 = i3; i5 < i4; i5++) {
                    char c3 = this.pfY[i5];
                    char c4 = (char) (c2 << 4);
                    if (c3 >= '0' && c3 <= '9') {
                        i = c3 - '0';
                    } else if (c3 >= 'a' && c3 <= 'f') {
                        i = (c3 - 'a') + 10;
                    } else if (c3 >= 'A' && c3 <= 'F') {
                        i = (c3 - 'A') + 10;
                    } else {
                        throw new NumberFormatException("\\u" + new String(this.pfY, this.pos, 4));
                    }
                    c2 = (char) (c4 + i);
                }
                this.pos += 4;
                return c2;
            default:
                throw YC("Invalid escape sequence");
        }
    }

    private IOException YC(String str) throws IOException {
        throw new MalformedJsonException(str + ete());
    }

    private void etx() throws IOException {
        AA(true);
        this.pos--;
        if (this.pos + pfW.length <= this.limit || Qu(pfW.length)) {
            for (int i = 0; i < pfW.length; i++) {
                if (this.pfY[this.pos + i] != pfW[i]) {
                    return;
                }
            }
            this.pos += pfW.length;
        }
    }
}
