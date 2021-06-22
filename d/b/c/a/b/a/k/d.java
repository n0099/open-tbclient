package d.b.c.a.b.a.k;

import javax.security.auth.x500.X500Principal;
/* loaded from: classes6.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final String f69318a;

    /* renamed from: b  reason: collision with root package name */
    public final int f69319b;

    /* renamed from: c  reason: collision with root package name */
    public int f69320c;

    /* renamed from: d  reason: collision with root package name */
    public int f69321d;

    /* renamed from: e  reason: collision with root package name */
    public int f69322e;

    /* renamed from: f  reason: collision with root package name */
    public int f69323f;

    /* renamed from: g  reason: collision with root package name */
    public char[] f69324g;

    public d(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.f69318a = name;
        this.f69319b = name.length();
    }

    public final int a(int i2) {
        int i3;
        int i4;
        int i5 = i2 + 1;
        if (i5 < this.f69319b) {
            char c2 = this.f69324g[i2];
            if (c2 >= '0' && c2 <= '9') {
                i3 = c2 - '0';
            } else if (c2 >= 'a' && c2 <= 'f') {
                i3 = c2 - 'W';
            } else if (c2 < 'A' || c2 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f69318a);
            } else {
                i3 = c2 - '7';
            }
            char c3 = this.f69324g[i5];
            if (c3 >= '0' && c3 <= '9') {
                i4 = c3 - '0';
            } else if (c3 >= 'a' && c3 <= 'f') {
                i4 = c3 - 'W';
            } else if (c3 < 'A' || c3 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f69318a);
            } else {
                i4 = c3 - '7';
            }
            return (i3 << 4) + i4;
        }
        throw new IllegalStateException("Malformed DN: " + this.f69318a);
    }

    public final String b() {
        while (true) {
            int i2 = this.f69320c;
            if (i2 >= this.f69319b || this.f69324g[i2] != ' ') {
                break;
            }
            this.f69320c = i2 + 1;
        }
        int i3 = this.f69320c;
        if (i3 == this.f69319b) {
            return null;
        }
        this.f69321d = i3;
        this.f69320c = i3 + 1;
        while (true) {
            int i4 = this.f69320c;
            if (i4 >= this.f69319b) {
                break;
            }
            char[] cArr = this.f69324g;
            if (cArr[i4] == '=' || cArr[i4] == ' ') {
                break;
            }
            this.f69320c = i4 + 1;
        }
        int i5 = this.f69320c;
        if (i5 < this.f69319b) {
            this.f69322e = i5;
            if (this.f69324g[i5] == ' ') {
                while (true) {
                    int i6 = this.f69320c;
                    if (i6 >= this.f69319b) {
                        break;
                    }
                    char[] cArr2 = this.f69324g;
                    if (cArr2[i6] == '=' || cArr2[i6] != ' ') {
                        break;
                    }
                    this.f69320c = i6 + 1;
                }
                char[] cArr3 = this.f69324g;
                int i7 = this.f69320c;
                if (cArr3[i7] != '=' || i7 == this.f69319b) {
                    throw new IllegalStateException("Unexpected end of DN: " + this.f69318a);
                }
            }
            this.f69320c++;
            while (true) {
                int i8 = this.f69320c;
                if (i8 >= this.f69319b || this.f69324g[i8] != ' ') {
                    break;
                }
                this.f69320c = i8 + 1;
            }
            int i9 = this.f69322e;
            int i10 = this.f69321d;
            if (i9 - i10 > 4) {
                char[] cArr4 = this.f69324g;
                if (cArr4[i10 + 3] == '.' && (cArr4[i10] == 'O' || cArr4[i10] == 'o')) {
                    char[] cArr5 = this.f69324g;
                    int i11 = this.f69321d;
                    if (cArr5[i11 + 1] == 'I' || cArr5[i11 + 1] == 'i') {
                        char[] cArr6 = this.f69324g;
                        int i12 = this.f69321d;
                        if (cArr6[i12 + 2] == 'D' || cArr6[i12 + 2] == 'd') {
                            this.f69321d += 4;
                        }
                    }
                }
            }
            char[] cArr7 = this.f69324g;
            int i13 = this.f69321d;
            return new String(cArr7, i13, this.f69322e - i13);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f69318a);
    }

    public String c(String str) {
        String d2;
        this.f69320c = 0;
        this.f69321d = 0;
        this.f69322e = 0;
        this.f69323f = 0;
        this.f69324g = this.f69318a.toCharArray();
        String b2 = b();
        if (b2 == null) {
            return null;
        }
        do {
            int i2 = this.f69320c;
            if (i2 == this.f69319b) {
                return null;
            }
            char c2 = this.f69324g[i2];
            if (c2 == '\"') {
                d2 = d();
            } else if (c2 != '#') {
                d2 = (c2 == '+' || c2 == ',' || c2 == ';') ? "" : f();
            } else {
                d2 = e();
            }
            if (str.equalsIgnoreCase(b2)) {
                return d2;
            }
            int i3 = this.f69320c;
            if (i3 >= this.f69319b) {
                return null;
            }
            char[] cArr = this.f69324g;
            if (cArr[i3] != ',' && cArr[i3] != ';' && cArr[i3] != '+') {
                throw new IllegalStateException("Malformed DN: " + this.f69318a);
            }
            this.f69320c++;
            b2 = b();
        } while (b2 != null);
        throw new IllegalStateException("Malformed DN: " + this.f69318a);
    }

    public final String d() {
        int i2 = this.f69320c + 1;
        this.f69320c = i2;
        this.f69321d = i2;
        this.f69322e = i2;
        while (true) {
            int i3 = this.f69320c;
            if (i3 != this.f69319b) {
                char[] cArr = this.f69324g;
                if (cArr[i3] == '\"') {
                    this.f69320c = i3 + 1;
                    while (true) {
                        int i4 = this.f69320c;
                        if (i4 >= this.f69319b || this.f69324g[i4] != ' ') {
                            break;
                        }
                        this.f69320c = i4 + 1;
                    }
                    char[] cArr2 = this.f69324g;
                    int i5 = this.f69321d;
                    return new String(cArr2, i5, this.f69322e - i5);
                }
                if (cArr[i3] == '\\') {
                    cArr[this.f69322e] = g();
                } else {
                    cArr[this.f69322e] = cArr[i3];
                }
                this.f69320c++;
                this.f69322e++;
            } else {
                throw new IllegalStateException("Unexpected end of DN: " + this.f69318a);
            }
        }
    }

    public final String e() {
        int i2 = this.f69320c;
        if (i2 + 4 < this.f69319b) {
            this.f69321d = i2;
            this.f69320c = i2 + 1;
            while (true) {
                int i3 = this.f69320c;
                if (i3 == this.f69319b) {
                    break;
                }
                char[] cArr = this.f69324g;
                if (cArr[i3] == '+' || cArr[i3] == ',' || cArr[i3] == ';') {
                    break;
                } else if (cArr[i3] == ' ') {
                    this.f69322e = i3;
                    this.f69320c = i3 + 1;
                    while (true) {
                        int i4 = this.f69320c;
                        if (i4 >= this.f69319b || this.f69324g[i4] != ' ') {
                            break;
                        }
                        this.f69320c = i4 + 1;
                    }
                } else {
                    if (cArr[i3] >= 'A' && cArr[i3] <= 'F') {
                        cArr[i3] = (char) (cArr[i3] + ' ');
                    }
                    this.f69320c++;
                }
            }
            this.f69322e = this.f69320c;
            int i5 = this.f69322e;
            int i6 = this.f69321d;
            int i7 = i5 - i6;
            if (i7 >= 5 && (i7 & 1) != 0) {
                int i8 = i7 / 2;
                byte[] bArr = new byte[i8];
                int i9 = i6 + 1;
                for (int i10 = 0; i10 < i8; i10++) {
                    bArr[i10] = (byte) a(i9);
                    i9 += 2;
                }
                return new String(this.f69324g, this.f69321d, i7);
            }
            throw new IllegalStateException("Unexpected end of DN: " + this.f69318a);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f69318a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a7, code lost:
        return new java.lang.String(r1, r2, r8.f69323f - r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String f() {
        int i2 = this.f69320c;
        this.f69321d = i2;
        this.f69322e = i2;
        while (true) {
            int i3 = this.f69320c;
            if (i3 >= this.f69319b) {
                char[] cArr = this.f69324g;
                int i4 = this.f69321d;
                return new String(cArr, i4, this.f69322e - i4);
            }
            char[] cArr2 = this.f69324g;
            char c2 = cArr2[i3];
            if (c2 == ' ') {
                int i5 = this.f69322e;
                this.f69323f = i5;
                this.f69320c = i3 + 1;
                this.f69322e = i5 + 1;
                cArr2[i5] = ' ';
                while (true) {
                    int i6 = this.f69320c;
                    if (i6 >= this.f69319b) {
                        break;
                    }
                    char[] cArr3 = this.f69324g;
                    if (cArr3[i6] != ' ') {
                        break;
                    }
                    int i7 = this.f69322e;
                    this.f69322e = i7 + 1;
                    cArr3[i7] = ' ';
                    this.f69320c = i6 + 1;
                }
                int i8 = this.f69320c;
                if (i8 == this.f69319b) {
                    break;
                }
                char[] cArr4 = this.f69324g;
                if (cArr4[i8] == ',' || cArr4[i8] == '+' || cArr4[i8] == ';') {
                    break;
                }
            } else if (c2 == ';') {
                break;
            } else if (c2 == '\\') {
                int i9 = this.f69322e;
                this.f69322e = i9 + 1;
                cArr2[i9] = g();
                this.f69320c++;
            } else if (c2 == '+' || c2 == ',') {
                break;
            } else {
                int i10 = this.f69322e;
                this.f69322e = i10 + 1;
                cArr2[i10] = cArr2[i3];
                this.f69320c = i3 + 1;
            }
        }
        char[] cArr5 = this.f69324g;
        int i11 = this.f69321d;
        return new String(cArr5, i11, this.f69322e - i11);
    }

    public final char g() {
        int i2 = this.f69320c + 1;
        this.f69320c = i2;
        if (i2 != this.f69319b) {
            char c2 = this.f69324g[i2];
            if (c2 != ' ' && c2 != '%' && c2 != '\\' && c2 != '_' && c2 != '\"' && c2 != '#') {
                switch (c2) {
                    case '*':
                    case '+':
                    case ',':
                        break;
                    default:
                        switch (c2) {
                            case ';':
                            case '<':
                            case '=':
                            case '>':
                                break;
                            default:
                                return h();
                        }
                }
            }
            return this.f69324g[this.f69320c];
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f69318a);
    }

    public final char h() {
        int i2;
        int i3;
        int a2 = a(this.f69320c);
        this.f69320c++;
        if (a2 < 128) {
            return (char) a2;
        }
        if (a2 < 192 || a2 > 247) {
            return '?';
        }
        if (a2 <= 223) {
            i3 = a2 & 31;
            i2 = 1;
        } else if (a2 <= 239) {
            i2 = 2;
            i3 = a2 & 15;
        } else {
            i2 = 3;
            i3 = a2 & 7;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = this.f69320c + 1;
            this.f69320c = i5;
            if (i5 == this.f69319b || this.f69324g[i5] != '\\') {
                return '?';
            }
            int i6 = i5 + 1;
            this.f69320c = i6;
            int a3 = a(i6);
            this.f69320c++;
            if ((a3 & 192) != 128) {
                return '?';
            }
            i3 = (i3 << 6) + (a3 & 63);
        }
        return (char) i3;
    }
}
