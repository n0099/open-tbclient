package javassist.compiler;

import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.cyberplayer.sdk.BVideoView;
import com.baidu.location.BDLocation;
/* loaded from: classes.dex */
public class Lex implements j {
    private static final int[] j = {350, 0, 0, 0, 351, 352, 0, 0, 0, 353, 354, 0, 355, 0, 356, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 357, 358, 359, 0};
    private static final KeywordTable k = new KeywordTable();
    private String e;
    private int h;

    /* renamed from: a  reason: collision with root package name */
    private int f2787a = -1;
    private StringBuffer b = new StringBuffer();
    private i c = new i();
    private i d = null;
    private int g = 0;
    private int i = 0;

    public Lex(String str) {
        this.e = str;
        this.h = str.length();
    }

    public int a() {
        if (this.d == null) {
            return a(this.c);
        }
        i iVar = this.d;
        this.c = iVar;
        this.d = this.d.f2797a;
        return iVar.b;
    }

    public int b() {
        return a(0);
    }

    public int a(int i) {
        i iVar = this.d;
        if (iVar == null) {
            iVar = this.c;
            this.d = iVar;
            iVar.f2797a = null;
            a(iVar);
        }
        while (true) {
            int i2 = i - 1;
            if (i > 0) {
                if (iVar.f2797a == null) {
                    i iVar2 = new i();
                    iVar.f2797a = iVar2;
                    a(iVar2);
                }
                iVar = iVar.f2797a;
                i = i2;
            } else {
                this.c = iVar;
                return iVar.b;
            }
        }
    }

    public String c() {
        return this.c.e;
    }

    public long d() {
        return this.c.c;
    }

    public double e() {
        return this.c.d;
    }

    private int a(i iVar) {
        int b;
        do {
            b = b(iVar);
        } while (b == 10);
        iVar.b = b;
        return b;
    }

    private int b(i iVar) {
        int g = g();
        if (g >= 0) {
            if (g == 10) {
                this.i++;
                return 10;
            } else if (g == 39) {
                return c(iVar);
            } else {
                if (g == 34) {
                    return d(iVar);
                }
                if (48 <= g && g <= 57) {
                    return a(g, iVar);
                }
                if (g == 46) {
                    int i = i();
                    if (48 <= i && i <= 57) {
                        StringBuffer stringBuffer = this.b;
                        stringBuffer.setLength(0);
                        stringBuffer.append('.');
                        return a(stringBuffer, i, iVar);
                    }
                    d(i);
                    return b(46);
                } else if (Character.isJavaIdentifierStart((char) g)) {
                    return b(g, iVar);
                } else {
                    return b(g);
                }
            }
        }
        return g;
    }

    private int g() {
        int i;
        do {
            i = i();
            if (i == 47) {
                int i2 = i();
                if (i2 == 47) {
                    do {
                        i = i();
                        if (i == 10 || i == 13) {
                            break;
                        }
                    } while (i != -1);
                } else if (i2 == 42) {
                    while (true) {
                        i = i();
                        if (i == -1) {
                            break;
                        } else if (i == 42) {
                            int i3 = i();
                            if (i3 == 47) {
                                i = 32;
                                break;
                            }
                            d(i3);
                        }
                    }
                } else {
                    d(i2);
                    i = 47;
                }
            }
        } while (c(i));
        return i;
    }

    private int c(i iVar) {
        int i = 0;
        while (true) {
            int i2 = i();
            if (i2 != 39) {
                if (i2 == 92) {
                    i = h();
                } else if (i2 < 32) {
                    if (i2 == 10) {
                        this.i++;
                    }
                    return BdWebErrorView.ERROR_CODE_500;
                } else {
                    i = i2;
                }
            } else {
                iVar.c = i;
                return BdWebErrorView.ERROR_CODE_401;
            }
        }
    }

    private int h() {
        int i = i();
        if (i == 110) {
            return 10;
        }
        if (i == 116) {
            return 9;
        }
        if (i == 114) {
            return 13;
        }
        if (i == 102) {
            return 12;
        }
        if (i == 10) {
            this.i++;
        }
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0021, code lost:
        r5.i++;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0029, code lost:
        return com.baidu.browser.explorer.BdWebErrorView.ERROR_CODE_500;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int d(i iVar) {
        int i;
        StringBuffer stringBuffer = this.b;
        stringBuffer.setLength(0);
        while (true) {
            int i2 = i();
            if (i2 != 34) {
                if (i2 == 92) {
                    i2 = h();
                } else if (i2 == 10 || i2 < 0) {
                    break;
                }
                stringBuffer.append((char) i2);
            } else {
                while (true) {
                    i = i();
                    if (i == 10) {
                        this.i++;
                    } else if (!c(i)) {
                        break;
                    }
                }
                if (i != 34) {
                    d(i);
                    iVar.e = stringBuffer.toString();
                    return BdWebErrorView.ERROR_CODE_406;
                }
            }
        }
    }

    private int a(int i, i iVar) {
        int i2;
        int i3;
        long j2 = 0;
        int i4 = i();
        if (i == 48) {
            if (i4 == 88 || i4 == 120) {
                while (true) {
                    i2 = i();
                    if (48 <= i2 && i2 <= 57) {
                        j2 = (j2 * 16) + (i2 - 48);
                    } else if (65 <= i2 && i2 <= 70) {
                        j2 = (j2 * 16) + (i2 - 65) + 10;
                    } else if (97 > i2 || i2 > 102) {
                        break;
                    } else {
                        j2 = (j2 * 16) + (i2 - 97) + 10;
                    }
                }
                iVar.c = j2;
                if (i2 == 76 || i2 == 108) {
                    return BdWebErrorView.ERROR_CODE_403;
                }
                d(i2);
                return 402;
            } else if (48 <= i4 && i4 <= 55) {
                long j3 = i4 - 48;
                while (true) {
                    i3 = i();
                    if (48 > i3 || i3 > 55) {
                        break;
                    }
                    j3 = (j3 * 8) + (i3 - 48);
                }
                iVar.c = j3;
                if (i3 == 76 || i3 == 108) {
                    return BdWebErrorView.ERROR_CODE_403;
                }
                d(i3);
                return 402;
            }
        }
        long j4 = i - 48;
        int i5 = i4;
        while (48 <= i5 && i5 <= 57) {
            j4 = (i5 + (j4 * 10)) - 48;
            i5 = i();
        }
        iVar.c = j4;
        if (i5 == 70 || i5 == 102) {
            iVar.d = j4;
            return BdWebErrorView.ERROR_CODE_404;
        } else if (i5 == 69 || i5 == 101 || i5 == 68 || i5 == 100 || i5 == 46) {
            StringBuffer stringBuffer = this.b;
            stringBuffer.setLength(0);
            stringBuffer.append(j4);
            return a(stringBuffer, i5, iVar);
        } else if (i5 == 76 || i5 == 108) {
            return BdWebErrorView.ERROR_CODE_403;
        } else {
            d(i5);
            return 402;
        }
    }

    private int a(StringBuffer stringBuffer, int i, i iVar) {
        if (i != 69 && i != 101 && i != 68 && i != 100) {
            stringBuffer.append((char) i);
            while (true) {
                i = i();
                if (48 > i || i > 57) {
                    break;
                }
                stringBuffer.append((char) i);
            }
        }
        int i2 = i;
        if (i2 == 69 || i2 == 101) {
            stringBuffer.append((char) i2);
            i2 = i();
            if (i2 == 43 || i2 == 45) {
                stringBuffer.append((char) i2);
                i2 = i();
            }
            while (48 <= i2 && i2 <= 57) {
                stringBuffer.append((char) i2);
                i2 = i();
            }
        }
        try {
            iVar.d = Double.parseDouble(stringBuffer.toString());
            if (i2 == 70 || i2 == 102) {
                return BdWebErrorView.ERROR_CODE_404;
            }
            if (i2 != 68 && i2 != 100) {
                d(i2);
            }
            return BdWebErrorView.ERROR_CODE_405;
        } catch (NumberFormatException e) {
            return BdWebErrorView.ERROR_CODE_500;
        }
    }

    static {
        k.append("abstract", 300);
        k.append("boolean", BVideoView.MEDIA_ERROR_NO_INPUTFILE);
        k.append("break", BVideoView.MEDIA_ERROR_INVALID_INPUTFILE);
        k.append("byte", BVideoView.MEDIA_ERROR_NO_SUPPORTED_CODEC);
        k.append("case", BVideoView.MEDIA_ERROR_DISPLAY);
        k.append("catch", BVideoView.MEDIA_ERROR_EIO);
        k.append("char", 306);
        k.append("class", 307);
        k.append("const", 308);
        k.append("continue", 309);
        k.append("default", 310);
        k.append("do", 311);
        k.append("double", 312);
        k.append("else", 313);
        k.append("extends", 314);
        k.append("false", BdWebErrorView.ERROR_CODE_411);
        k.append("final", 315);
        k.append("finally", 316);
        k.append("float", 317);
        k.append("for", 318);
        k.append("goto", 319);
        k.append("if", 320);
        k.append("implements", 321);
        k.append("import", 322);
        k.append("instanceof", 323);
        k.append("int", 324);
        k.append("interface", 325);
        k.append("long", 326);
        k.append("native", 327);
        k.append("new", 328);
        k.append("null", BdWebErrorView.ERROR_CODE_412);
        k.append("package", 329);
        k.append("private", 330);
        k.append("protected", 331);
        k.append("public", 332);
        k.append("return", 333);
        k.append("short", 334);
        k.append("static", 335);
        k.append("strictfp", 347);
        k.append("super", 336);
        k.append("switch", 337);
        k.append("synchronized", 338);
        k.append("this", 339);
        k.append("throw", 340);
        k.append("throws", 341);
        k.append("transient", 342);
        k.append("true", BdWebErrorView.ERROR_CODE_410);
        k.append("try", 343);
        k.append("void", 344);
        k.append("volatile", 345);
        k.append("while", 346);
    }

    private int b(int i) {
        int i2;
        if (33 <= i && i <= 63) {
            int i3 = j[i - 33];
            if (i3 != 0) {
                i2 = i();
                if (i == i2) {
                    switch (i) {
                        case 38:
                            return 369;
                        case 43:
                            return 362;
                        case 45:
                            return 363;
                        case 60:
                            int i4 = i();
                            if (i4 == 61) {
                                return 365;
                            }
                            d(i4);
                            return 364;
                        case BDLocation.TypeGpsLocation /* 61 */:
                            return 358;
                        case BDLocation.TypeCriteriaException /* 62 */:
                            int i5 = i();
                            if (i5 == 61) {
                                return 367;
                            }
                            if (i5 == 62) {
                                int i6 = i();
                                if (i6 == 61) {
                                    return 371;
                                }
                                d(i6);
                                return 370;
                            }
                            d(i5);
                            return 366;
                    }
                } else if (i2 == 61) {
                    return i3;
                }
            } else {
                return i;
            }
        } else if (i == 94) {
            i2 = i();
            if (i2 == 61) {
                return 360;
            }
        } else if (i == 124) {
            i2 = i();
            if (i2 == 61) {
                return 361;
            }
            if (i2 == 124) {
                return 368;
            }
        } else {
            return i;
        }
        d(i2);
        return i;
    }

    private int b(int i, i iVar) {
        StringBuffer stringBuffer = this.b;
        stringBuffer.setLength(0);
        do {
            stringBuffer.append((char) i);
            i = i();
        } while (Character.isJavaIdentifierPart((char) i));
        d(i);
        String stringBuffer2 = stringBuffer.toString();
        int lookup = k.lookup(stringBuffer2);
        if (lookup < 0) {
            iVar.e = stringBuffer2;
            return BdWebErrorView.ERROR_CODE_400;
        }
        return lookup;
    }

    private static boolean c(int i) {
        return i == 32 || i == 9 || i == 12 || i == 13 || i == 10;
    }

    private void d(int i) {
        this.f2787a = i;
    }

    public String f() {
        int i = this.g - 10;
        if (i < 0) {
            i = 0;
        }
        int i2 = this.g + 10;
        if (i2 > this.h) {
            i2 = this.h;
        }
        return this.e.substring(i, i2);
    }

    private int i() {
        if (this.f2787a < 0) {
            if (this.g < this.h) {
                String str = this.e;
                int i = this.g;
                this.g = i + 1;
                return str.charAt(i);
            }
            return -1;
        }
        int i2 = this.f2787a;
        this.f2787a = -1;
        return i2;
    }
}
