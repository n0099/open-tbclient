package d.c.c.a.b.a.k;

import javax.security.auth.x500.X500Principal;
/* loaded from: classes5.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final String f66369a;

    /* renamed from: b  reason: collision with root package name */
    public final int f66370b;

    /* renamed from: c  reason: collision with root package name */
    public int f66371c;

    /* renamed from: d  reason: collision with root package name */
    public int f66372d;

    /* renamed from: e  reason: collision with root package name */
    public int f66373e;

    /* renamed from: f  reason: collision with root package name */
    public int f66374f;

    /* renamed from: g  reason: collision with root package name */
    public char[] f66375g;

    public d(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.f66369a = name;
        this.f66370b = name.length();
    }

    public final int a(int i) {
        int i2;
        int i3;
        int i4 = i + 1;
        if (i4 < this.f66370b) {
            char c2 = this.f66375g[i];
            if (c2 >= '0' && c2 <= '9') {
                i2 = c2 - '0';
            } else if (c2 >= 'a' && c2 <= 'f') {
                i2 = c2 - 'W';
            } else if (c2 < 'A' || c2 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f66369a);
            } else {
                i2 = c2 - '7';
            }
            char c3 = this.f66375g[i4];
            if (c3 >= '0' && c3 <= '9') {
                i3 = c3 - '0';
            } else if (c3 >= 'a' && c3 <= 'f') {
                i3 = c3 - 'W';
            } else if (c3 < 'A' || c3 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f66369a);
            } else {
                i3 = c3 - '7';
            }
            return (i2 << 4) + i3;
        }
        throw new IllegalStateException("Malformed DN: " + this.f66369a);
    }

    public final String b() {
        while (true) {
            int i = this.f66371c;
            if (i >= this.f66370b || this.f66375g[i] != ' ') {
                break;
            }
            this.f66371c = i + 1;
        }
        int i2 = this.f66371c;
        if (i2 == this.f66370b) {
            return null;
        }
        this.f66372d = i2;
        this.f66371c = i2 + 1;
        while (true) {
            int i3 = this.f66371c;
            if (i3 >= this.f66370b) {
                break;
            }
            char[] cArr = this.f66375g;
            if (cArr[i3] == '=' || cArr[i3] == ' ') {
                break;
            }
            this.f66371c = i3 + 1;
        }
        int i4 = this.f66371c;
        if (i4 < this.f66370b) {
            this.f66373e = i4;
            if (this.f66375g[i4] == ' ') {
                while (true) {
                    int i5 = this.f66371c;
                    if (i5 >= this.f66370b) {
                        break;
                    }
                    char[] cArr2 = this.f66375g;
                    if (cArr2[i5] == '=' || cArr2[i5] != ' ') {
                        break;
                    }
                    this.f66371c = i5 + 1;
                }
                char[] cArr3 = this.f66375g;
                int i6 = this.f66371c;
                if (cArr3[i6] != '=' || i6 == this.f66370b) {
                    throw new IllegalStateException("Unexpected end of DN: " + this.f66369a);
                }
            }
            this.f66371c++;
            while (true) {
                int i7 = this.f66371c;
                if (i7 >= this.f66370b || this.f66375g[i7] != ' ') {
                    break;
                }
                this.f66371c = i7 + 1;
            }
            int i8 = this.f66373e;
            int i9 = this.f66372d;
            if (i8 - i9 > 4) {
                char[] cArr4 = this.f66375g;
                if (cArr4[i9 + 3] == '.' && (cArr4[i9] == 'O' || cArr4[i9] == 'o')) {
                    char[] cArr5 = this.f66375g;
                    int i10 = this.f66372d;
                    if (cArr5[i10 + 1] == 'I' || cArr5[i10 + 1] == 'i') {
                        char[] cArr6 = this.f66375g;
                        int i11 = this.f66372d;
                        if (cArr6[i11 + 2] == 'D' || cArr6[i11 + 2] == 'd') {
                            this.f66372d += 4;
                        }
                    }
                }
            }
            char[] cArr7 = this.f66375g;
            int i12 = this.f66372d;
            return new String(cArr7, i12, this.f66373e - i12);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f66369a);
    }

    public String c(String str) {
        String d2;
        this.f66371c = 0;
        this.f66372d = 0;
        this.f66373e = 0;
        this.f66374f = 0;
        this.f66375g = this.f66369a.toCharArray();
        String b2 = b();
        if (b2 == null) {
            return null;
        }
        do {
            int i = this.f66371c;
            if (i == this.f66370b) {
                return null;
            }
            char c2 = this.f66375g[i];
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
            int i2 = this.f66371c;
            if (i2 >= this.f66370b) {
                return null;
            }
            char[] cArr = this.f66375g;
            if (cArr[i2] != ',' && cArr[i2] != ';' && cArr[i2] != '+') {
                throw new IllegalStateException("Malformed DN: " + this.f66369a);
            }
            this.f66371c++;
            b2 = b();
        } while (b2 != null);
        throw new IllegalStateException("Malformed DN: " + this.f66369a);
    }

    public final String d() {
        int i = this.f66371c + 1;
        this.f66371c = i;
        this.f66372d = i;
        this.f66373e = i;
        while (true) {
            int i2 = this.f66371c;
            if (i2 != this.f66370b) {
                char[] cArr = this.f66375g;
                if (cArr[i2] == '\"') {
                    this.f66371c = i2 + 1;
                    while (true) {
                        int i3 = this.f66371c;
                        if (i3 >= this.f66370b || this.f66375g[i3] != ' ') {
                            break;
                        }
                        this.f66371c = i3 + 1;
                    }
                    char[] cArr2 = this.f66375g;
                    int i4 = this.f66372d;
                    return new String(cArr2, i4, this.f66373e - i4);
                }
                if (cArr[i2] == '\\') {
                    cArr[this.f66373e] = g();
                } else {
                    cArr[this.f66373e] = cArr[i2];
                }
                this.f66371c++;
                this.f66373e++;
            } else {
                throw new IllegalStateException("Unexpected end of DN: " + this.f66369a);
            }
        }
    }

    public final String e() {
        int i = this.f66371c;
        if (i + 4 < this.f66370b) {
            this.f66372d = i;
            this.f66371c = i + 1;
            while (true) {
                int i2 = this.f66371c;
                if (i2 == this.f66370b) {
                    break;
                }
                char[] cArr = this.f66375g;
                if (cArr[i2] == '+' || cArr[i2] == ',' || cArr[i2] == ';') {
                    break;
                } else if (cArr[i2] == ' ') {
                    this.f66373e = i2;
                    this.f66371c = i2 + 1;
                    while (true) {
                        int i3 = this.f66371c;
                        if (i3 >= this.f66370b || this.f66375g[i3] != ' ') {
                            break;
                        }
                        this.f66371c = i3 + 1;
                    }
                } else {
                    if (cArr[i2] >= 'A' && cArr[i2] <= 'F') {
                        cArr[i2] = (char) (cArr[i2] + ' ');
                    }
                    this.f66371c++;
                }
            }
            this.f66373e = this.f66371c;
            int i4 = this.f66373e;
            int i5 = this.f66372d;
            int i6 = i4 - i5;
            if (i6 >= 5 && (i6 & 1) != 0) {
                int i7 = i6 / 2;
                byte[] bArr = new byte[i7];
                int i8 = i5 + 1;
                for (int i9 = 0; i9 < i7; i9++) {
                    bArr[i9] = (byte) a(i8);
                    i8 += 2;
                }
                return new String(this.f66375g, this.f66372d, i6);
            }
            throw new IllegalStateException("Unexpected end of DN: " + this.f66369a);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f66369a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a7, code lost:
        return new java.lang.String(r1, r2, r8.f66374f - r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String f() {
        int i = this.f66371c;
        this.f66372d = i;
        this.f66373e = i;
        while (true) {
            int i2 = this.f66371c;
            if (i2 >= this.f66370b) {
                char[] cArr = this.f66375g;
                int i3 = this.f66372d;
                return new String(cArr, i3, this.f66373e - i3);
            }
            char[] cArr2 = this.f66375g;
            char c2 = cArr2[i2];
            if (c2 == ' ') {
                int i4 = this.f66373e;
                this.f66374f = i4;
                this.f66371c = i2 + 1;
                this.f66373e = i4 + 1;
                cArr2[i4] = ' ';
                while (true) {
                    int i5 = this.f66371c;
                    if (i5 >= this.f66370b) {
                        break;
                    }
                    char[] cArr3 = this.f66375g;
                    if (cArr3[i5] != ' ') {
                        break;
                    }
                    int i6 = this.f66373e;
                    this.f66373e = i6 + 1;
                    cArr3[i6] = ' ';
                    this.f66371c = i5 + 1;
                }
                int i7 = this.f66371c;
                if (i7 == this.f66370b) {
                    break;
                }
                char[] cArr4 = this.f66375g;
                if (cArr4[i7] == ',' || cArr4[i7] == '+' || cArr4[i7] == ';') {
                    break;
                }
            } else if (c2 == ';') {
                break;
            } else if (c2 == '\\') {
                int i8 = this.f66373e;
                this.f66373e = i8 + 1;
                cArr2[i8] = g();
                this.f66371c++;
            } else if (c2 == '+' || c2 == ',') {
                break;
            } else {
                int i9 = this.f66373e;
                this.f66373e = i9 + 1;
                cArr2[i9] = cArr2[i2];
                this.f66371c = i2 + 1;
            }
        }
        char[] cArr5 = this.f66375g;
        int i10 = this.f66372d;
        return new String(cArr5, i10, this.f66373e - i10);
    }

    public final char g() {
        int i = this.f66371c + 1;
        this.f66371c = i;
        if (i != this.f66370b) {
            char c2 = this.f66375g[i];
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
            return this.f66375g[this.f66371c];
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f66369a);
    }

    public final char h() {
        int i;
        int i2;
        int a2 = a(this.f66371c);
        this.f66371c++;
        if (a2 < 128) {
            return (char) a2;
        }
        if (a2 < 192 || a2 > 247) {
            return '?';
        }
        if (a2 <= 223) {
            i2 = a2 & 31;
            i = 1;
        } else if (a2 <= 239) {
            i = 2;
            i2 = a2 & 15;
        } else {
            i = 3;
            i2 = a2 & 7;
        }
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = this.f66371c + 1;
            this.f66371c = i4;
            if (i4 == this.f66370b || this.f66375g[i4] != '\\') {
                return '?';
            }
            int i5 = i4 + 1;
            this.f66371c = i5;
            int a3 = a(i5);
            this.f66371c++;
            if ((a3 & 192) != 128) {
                return '?';
            }
            i2 = (i2 << 6) + (a3 & 63);
        }
        return (char) i2;
    }
}
