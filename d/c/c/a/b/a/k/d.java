package d.c.c.a.b.a.k;

import javax.security.auth.x500.X500Principal;
/* loaded from: classes5.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final String f66274a;

    /* renamed from: b  reason: collision with root package name */
    public final int f66275b;

    /* renamed from: c  reason: collision with root package name */
    public int f66276c;

    /* renamed from: d  reason: collision with root package name */
    public int f66277d;

    /* renamed from: e  reason: collision with root package name */
    public int f66278e;

    /* renamed from: f  reason: collision with root package name */
    public int f66279f;

    /* renamed from: g  reason: collision with root package name */
    public char[] f66280g;

    public d(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.f66274a = name;
        this.f66275b = name.length();
    }

    public final int a(int i) {
        int i2;
        int i3;
        int i4 = i + 1;
        if (i4 < this.f66275b) {
            char c2 = this.f66280g[i];
            if (c2 >= '0' && c2 <= '9') {
                i2 = c2 - '0';
            } else if (c2 >= 'a' && c2 <= 'f') {
                i2 = c2 - 'W';
            } else if (c2 < 'A' || c2 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f66274a);
            } else {
                i2 = c2 - '7';
            }
            char c3 = this.f66280g[i4];
            if (c3 >= '0' && c3 <= '9') {
                i3 = c3 - '0';
            } else if (c3 >= 'a' && c3 <= 'f') {
                i3 = c3 - 'W';
            } else if (c3 < 'A' || c3 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f66274a);
            } else {
                i3 = c3 - '7';
            }
            return (i2 << 4) + i3;
        }
        throw new IllegalStateException("Malformed DN: " + this.f66274a);
    }

    public final String b() {
        while (true) {
            int i = this.f66276c;
            if (i >= this.f66275b || this.f66280g[i] != ' ') {
                break;
            }
            this.f66276c = i + 1;
        }
        int i2 = this.f66276c;
        if (i2 == this.f66275b) {
            return null;
        }
        this.f66277d = i2;
        this.f66276c = i2 + 1;
        while (true) {
            int i3 = this.f66276c;
            if (i3 >= this.f66275b) {
                break;
            }
            char[] cArr = this.f66280g;
            if (cArr[i3] == '=' || cArr[i3] == ' ') {
                break;
            }
            this.f66276c = i3 + 1;
        }
        int i4 = this.f66276c;
        if (i4 < this.f66275b) {
            this.f66278e = i4;
            if (this.f66280g[i4] == ' ') {
                while (true) {
                    int i5 = this.f66276c;
                    if (i5 >= this.f66275b) {
                        break;
                    }
                    char[] cArr2 = this.f66280g;
                    if (cArr2[i5] == '=' || cArr2[i5] != ' ') {
                        break;
                    }
                    this.f66276c = i5 + 1;
                }
                char[] cArr3 = this.f66280g;
                int i6 = this.f66276c;
                if (cArr3[i6] != '=' || i6 == this.f66275b) {
                    throw new IllegalStateException("Unexpected end of DN: " + this.f66274a);
                }
            }
            this.f66276c++;
            while (true) {
                int i7 = this.f66276c;
                if (i7 >= this.f66275b || this.f66280g[i7] != ' ') {
                    break;
                }
                this.f66276c = i7 + 1;
            }
            int i8 = this.f66278e;
            int i9 = this.f66277d;
            if (i8 - i9 > 4) {
                char[] cArr4 = this.f66280g;
                if (cArr4[i9 + 3] == '.' && (cArr4[i9] == 'O' || cArr4[i9] == 'o')) {
                    char[] cArr5 = this.f66280g;
                    int i10 = this.f66277d;
                    if (cArr5[i10 + 1] == 'I' || cArr5[i10 + 1] == 'i') {
                        char[] cArr6 = this.f66280g;
                        int i11 = this.f66277d;
                        if (cArr6[i11 + 2] == 'D' || cArr6[i11 + 2] == 'd') {
                            this.f66277d += 4;
                        }
                    }
                }
            }
            char[] cArr7 = this.f66280g;
            int i12 = this.f66277d;
            return new String(cArr7, i12, this.f66278e - i12);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f66274a);
    }

    public String c(String str) {
        String d2;
        this.f66276c = 0;
        this.f66277d = 0;
        this.f66278e = 0;
        this.f66279f = 0;
        this.f66280g = this.f66274a.toCharArray();
        String b2 = b();
        if (b2 == null) {
            return null;
        }
        do {
            int i = this.f66276c;
            if (i == this.f66275b) {
                return null;
            }
            char c2 = this.f66280g[i];
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
            int i2 = this.f66276c;
            if (i2 >= this.f66275b) {
                return null;
            }
            char[] cArr = this.f66280g;
            if (cArr[i2] != ',' && cArr[i2] != ';' && cArr[i2] != '+') {
                throw new IllegalStateException("Malformed DN: " + this.f66274a);
            }
            this.f66276c++;
            b2 = b();
        } while (b2 != null);
        throw new IllegalStateException("Malformed DN: " + this.f66274a);
    }

    public final String d() {
        int i = this.f66276c + 1;
        this.f66276c = i;
        this.f66277d = i;
        this.f66278e = i;
        while (true) {
            int i2 = this.f66276c;
            if (i2 != this.f66275b) {
                char[] cArr = this.f66280g;
                if (cArr[i2] == '\"') {
                    this.f66276c = i2 + 1;
                    while (true) {
                        int i3 = this.f66276c;
                        if (i3 >= this.f66275b || this.f66280g[i3] != ' ') {
                            break;
                        }
                        this.f66276c = i3 + 1;
                    }
                    char[] cArr2 = this.f66280g;
                    int i4 = this.f66277d;
                    return new String(cArr2, i4, this.f66278e - i4);
                }
                if (cArr[i2] == '\\') {
                    cArr[this.f66278e] = g();
                } else {
                    cArr[this.f66278e] = cArr[i2];
                }
                this.f66276c++;
                this.f66278e++;
            } else {
                throw new IllegalStateException("Unexpected end of DN: " + this.f66274a);
            }
        }
    }

    public final String e() {
        int i = this.f66276c;
        if (i + 4 < this.f66275b) {
            this.f66277d = i;
            this.f66276c = i + 1;
            while (true) {
                int i2 = this.f66276c;
                if (i2 == this.f66275b) {
                    break;
                }
                char[] cArr = this.f66280g;
                if (cArr[i2] == '+' || cArr[i2] == ',' || cArr[i2] == ';') {
                    break;
                } else if (cArr[i2] == ' ') {
                    this.f66278e = i2;
                    this.f66276c = i2 + 1;
                    while (true) {
                        int i3 = this.f66276c;
                        if (i3 >= this.f66275b || this.f66280g[i3] != ' ') {
                            break;
                        }
                        this.f66276c = i3 + 1;
                    }
                } else {
                    if (cArr[i2] >= 'A' && cArr[i2] <= 'F') {
                        cArr[i2] = (char) (cArr[i2] + ' ');
                    }
                    this.f66276c++;
                }
            }
            this.f66278e = this.f66276c;
            int i4 = this.f66278e;
            int i5 = this.f66277d;
            int i6 = i4 - i5;
            if (i6 >= 5 && (i6 & 1) != 0) {
                int i7 = i6 / 2;
                byte[] bArr = new byte[i7];
                int i8 = i5 + 1;
                for (int i9 = 0; i9 < i7; i9++) {
                    bArr[i9] = (byte) a(i8);
                    i8 += 2;
                }
                return new String(this.f66280g, this.f66277d, i6);
            }
            throw new IllegalStateException("Unexpected end of DN: " + this.f66274a);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f66274a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a7, code lost:
        return new java.lang.String(r1, r2, r8.f66279f - r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String f() {
        int i = this.f66276c;
        this.f66277d = i;
        this.f66278e = i;
        while (true) {
            int i2 = this.f66276c;
            if (i2 >= this.f66275b) {
                char[] cArr = this.f66280g;
                int i3 = this.f66277d;
                return new String(cArr, i3, this.f66278e - i3);
            }
            char[] cArr2 = this.f66280g;
            char c2 = cArr2[i2];
            if (c2 == ' ') {
                int i4 = this.f66278e;
                this.f66279f = i4;
                this.f66276c = i2 + 1;
                this.f66278e = i4 + 1;
                cArr2[i4] = ' ';
                while (true) {
                    int i5 = this.f66276c;
                    if (i5 >= this.f66275b) {
                        break;
                    }
                    char[] cArr3 = this.f66280g;
                    if (cArr3[i5] != ' ') {
                        break;
                    }
                    int i6 = this.f66278e;
                    this.f66278e = i6 + 1;
                    cArr3[i6] = ' ';
                    this.f66276c = i5 + 1;
                }
                int i7 = this.f66276c;
                if (i7 == this.f66275b) {
                    break;
                }
                char[] cArr4 = this.f66280g;
                if (cArr4[i7] == ',' || cArr4[i7] == '+' || cArr4[i7] == ';') {
                    break;
                }
            } else if (c2 == ';') {
                break;
            } else if (c2 == '\\') {
                int i8 = this.f66278e;
                this.f66278e = i8 + 1;
                cArr2[i8] = g();
                this.f66276c++;
            } else if (c2 == '+' || c2 == ',') {
                break;
            } else {
                int i9 = this.f66278e;
                this.f66278e = i9 + 1;
                cArr2[i9] = cArr2[i2];
                this.f66276c = i2 + 1;
            }
        }
        char[] cArr5 = this.f66280g;
        int i10 = this.f66277d;
        return new String(cArr5, i10, this.f66278e - i10);
    }

    public final char g() {
        int i = this.f66276c + 1;
        this.f66276c = i;
        if (i != this.f66275b) {
            char c2 = this.f66280g[i];
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
            return this.f66280g[this.f66276c];
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f66274a);
    }

    public final char h() {
        int i;
        int i2;
        int a2 = a(this.f66276c);
        this.f66276c++;
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
            int i4 = this.f66276c + 1;
            this.f66276c = i4;
            if (i4 == this.f66275b || this.f66280g[i4] != '\\') {
                return '?';
            }
            int i5 = i4 + 1;
            this.f66276c = i5;
            int a3 = a(i5);
            this.f66276c++;
            if ((a3 & 192) != 128) {
                return '?';
            }
            i2 = (i2 << 6) + (a3 & 63);
        }
        return (char) i2;
    }
}
