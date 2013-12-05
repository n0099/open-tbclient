package javassist.bytecode.analysis;

import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.location.BDLocation;
import com.baidu.zeus.bouncycastle.DERTags;
import com.tencent.mm.sdk.contact.RContact;
import javassist.NotFoundException;
import javassist.bytecode.BadBytecode;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.an;
import javassist.bytecode.as;
import javassist.bytecode.y;
import javassist.bytecode.z;
/* loaded from: classes.dex */
public class Executor implements as {

    /* renamed from: a  reason: collision with root package name */
    private final y f2932a;
    private final javassist.c b;
    private final h c;
    private final h d;
    private final h e;
    private int g;

    public Executor(javassist.c cVar, y yVar) {
        this.f2932a = yVar;
        this.b = cVar;
        try {
            this.c = a("java.lang.String");
            this.d = a("java.lang.Class");
            this.e = a("java.lang.Throwable");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void a(an anVar, int i, CodeIterator codeIterator, c cVar, g gVar) {
        this.g = i;
        int c = codeIterator.c(i);
        switch (c) {
            case 0:
            case BDLocation.TypeServerError /* 167 */:
            case 177:
            case 200:
            default:
                return;
            case 1:
                cVar.a(h.j);
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                cVar.a(h.g);
                return;
            case 9:
            case 10:
                cVar.a(h.c);
                cVar.a(h.l);
                return;
            case 11:
            case 12:
            case 13:
                cVar.a(h.h);
                return;
            case 14:
            case 15:
                cVar.a(h.f2939a);
                cVar.a(h.l);
                return;
            case 16:
            case 17:
                cVar.a(h.g);
                return;
            case 18:
                a(codeIterator.c(i + 1), cVar);
                return;
            case 19:
            case 20:
                a(codeIterator.d(i + 1), cVar);
                return;
            case 21:
                a(h.g, codeIterator.c(i + 1), cVar, gVar);
                return;
            case 22:
                a(h.c, codeIterator.c(i + 1), cVar, gVar);
                return;
            case DERTags.UTC_TIME /* 23 */:
                a(h.h, codeIterator.c(i + 1), cVar, gVar);
                return;
            case DERTags.GENERALIZED_TIME /* 24 */:
                a(h.f2939a, codeIterator.c(i + 1), cVar, gVar);
                return;
            case DERTags.GRAPHIC_STRING /* 25 */:
                a(h.n, codeIterator.c(i + 1), cVar, gVar);
                return;
            case DERTags.VISIBLE_STRING /* 26 */:
            case DERTags.GENERAL_STRING /* 27 */:
            case DERTags.UNIVERSAL_STRING /* 28 */:
            case 29:
                a(h.g, c - 26, cVar, gVar);
                return;
            case DERTags.BMP_STRING /* 30 */:
            case 31:
            case 32:
            case 33:
                a(h.c, c - 30, cVar, gVar);
                return;
            case 34:
            case 35:
            case 36:
            case 37:
                a(h.h, c - 34, cVar, gVar);
                return;
            case 38:
            case 39:
            case 40:
            case 41:
                a(h.f2939a, c - 38, cVar, gVar);
                return;
            case 42:
            case 43:
            case 44:
            case 45:
                a(h.n, c - 42, cVar, gVar);
                return;
            case 46:
                a(h.g, cVar);
                return;
            case 47:
                a(h.c, cVar);
                return;
            case 48:
                a(h.h, cVar);
                return;
            case 49:
                a(h.f2939a, cVar);
                return;
            case 50:
                a(h.n, cVar);
                return;
            case 51:
            case 52:
            case 53:
                a(h.g, cVar);
                return;
            case 54:
                b(h.g, codeIterator.c(i + 1), cVar, gVar);
                return;
            case 55:
                b(h.c, codeIterator.c(i + 1), cVar, gVar);
                return;
            case 56:
                b(h.h, codeIterator.c(i + 1), cVar, gVar);
                return;
            case 57:
                b(h.f2939a, codeIterator.c(i + 1), cVar, gVar);
                return;
            case 58:
                b(h.n, codeIterator.c(i + 1), cVar, gVar);
                return;
            case 59:
            case 60:
            case BDLocation.TypeGpsLocation /* 61 */:
            case BDLocation.TypeCriteriaException /* 62 */:
                b(h.g, c - 59, cVar, gVar);
                return;
            case BDLocation.TypeNetWorkException /* 63 */:
            case 64:
            case BDLocation.TypeCacheLocation /* 65 */:
            case BDLocation.TypeOffLineLocation /* 66 */:
                b(h.c, c - 63, cVar, gVar);
                return;
            case BDLocation.TypeOffLineLocationFail /* 67 */:
            case BDLocation.TypeOffLineLocationNetworkFail /* 68 */:
            case 69:
            case 70:
                b(h.h, c - 67, cVar, gVar);
                return;
            case 71:
            case 72:
            case 73:
            case 74:
                b(h.f2939a, c - 71, cVar, gVar);
                return;
            case 75:
            case 76:
            case 77:
            case 78:
                b(h.n, c - 75, cVar, gVar);
                return;
            case 79:
                b(h.g, cVar);
                return;
            case com.baidu.loginshare.e.i /* 80 */:
                b(h.c, cVar);
                return;
            case 81:
                b(h.h, cVar);
                return;
            case 82:
                b(h.f2939a, cVar);
                return;
            case 83:
                b(h.n, cVar);
                return;
            case 84:
            case 85:
            case 86:
                b(h.g, cVar);
                return;
            case 87:
                if (cVar.e() == h.l) {
                    throw new BadBytecode("POP can not be used with a category 2 value, pos = " + i);
                }
                return;
            case 88:
                cVar.e();
                cVar.e();
                return;
            case 89:
                if (cVar.d() == h.l) {
                    throw new BadBytecode("DUP can not be used with a category 2 value, pos = " + i);
                }
                cVar.a(cVar.d());
                return;
            case 90:
            case 91:
                h d = cVar.d();
                if (d == h.l) {
                    throw new BadBytecode("DUP can not be used with a category 2 value, pos = " + i);
                }
                int b = cVar.b();
                int i2 = (b - (c - 90)) - 1;
                cVar.a(d);
                while (b > i2) {
                    cVar.b(b, cVar.b(b - 1));
                    b--;
                }
                cVar.b(i2, d);
                return;
            case 92:
                cVar.a(cVar.b(cVar.b() - 1));
                cVar.a(cVar.b(cVar.b() - 1));
                return;
            case 93:
            case 94:
                int b2 = cVar.b();
                int i3 = (b2 - (c - 93)) - 1;
                h b3 = cVar.b(cVar.b() - 1);
                h d2 = cVar.d();
                cVar.a(b3);
                cVar.a(d2);
                while (b2 > i3) {
                    cVar.b(b2, cVar.b(b2 - 2));
                    b2--;
                }
                cVar.b(i3, d2);
                cVar.b(i3 - 1, b3);
                return;
            case 95:
                h e = cVar.e();
                h e2 = cVar.e();
                if (e.e() == 2 || e2.e() == 2) {
                    throw new BadBytecode("Swap can not be used with category 2 values, pos = " + i);
                }
                cVar.a(e);
                cVar.a(e2);
                return;
            case 96:
                c(h.g, cVar);
                return;
            case 97:
                c(h.c, cVar);
                return;
            case 98:
                c(h.h, cVar);
                return;
            case 99:
                c(h.f2939a, cVar);
                return;
            case 100:
                c(h.g, cVar);
                return;
            case 101:
                c(h.c, cVar);
                return;
            case 102:
                c(h.h, cVar);
                return;
            case 103:
                c(h.f2939a, cVar);
                return;
            case 104:
                c(h.g, cVar);
                return;
            case 105:
                c(h.c, cVar);
                return;
            case SocialAPIErrorCodes.ERROR_INVALID_SIGNATURE_ALGORITHM /* 106 */:
                c(h.h, cVar);
                return;
            case SocialAPIErrorCodes.ERROR_INVALID_TIMESTAMP /* 107 */:
                c(h.f2939a, cVar);
                return;
            case 108:
                c(h.g, cVar);
                return;
            case 109:
                c(h.c, cVar);
                return;
            case SocialAPIErrorCodes.ERROR_MISS_ACCESS_TOKEN /* 110 */:
                c(h.h, cVar);
                return;
            case SocialAPIErrorCodes.ERROR_EXPIRED_ACCESS_TOKEN /* 111 */:
                c(h.f2939a, cVar);
                return;
            case SocialAPIErrorCodes.ERROR_EXPIRED_SESSION_KEY /* 112 */:
                c(h.g, cVar);
                return;
            case 113:
                c(h.c, cVar);
                return;
            case 114:
                c(h.h, cVar);
                return;
            case SocialAPIErrorCodes.ERROR_INVALID_RESPONSE_TYPE /* 115 */:
                c(h.f2939a, cVar);
                return;
            case SocialAPIErrorCodes.ERROR_INVALID_GRANT_TYPE /* 116 */:
                a(h.g, a(cVar));
                return;
            case SocialAPIErrorCodes.ERROR_INVALID_MEDIA_TYPE /* 117 */:
                a(h.c, a(cVar));
                return;
            case SocialAPIErrorCodes.ERROR_INVALID_REDIRECT_URI /* 118 */:
                a(h.h, a(cVar));
                return;
            case SocialAPIErrorCodes.ERROR_INVALID_SECRET_KEY /* 119 */:
                a(h.f2939a, a(cVar));
                return;
            case SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE /* 120 */:
                d(h.g, cVar);
                return;
            case SocialAPIErrorCodes.ERROR_INVALID_STATE /* 121 */:
                d(h.c, cVar);
                return;
            case SocialAPIErrorCodes.ERROR_SESSION_EXPIRED /* 122 */:
                d(h.g, cVar);
                return;
            case SocialAPIErrorCodes.ERROR_INVALID_BDUSS /* 123 */:
                d(h.c, cVar);
                return;
            case SocialAPIErrorCodes.ERROR_UPLOAD_FILE_SIZE_TOO_LARGE /* 124 */:
                d(h.g, cVar);
                return;
            case SocialAPIErrorCodes.ERROR_INVALID_UPLOAD_FILE /* 125 */:
                d(h.c, cVar);
                return;
            case 126:
                c(h.g, cVar);
                return;
            case RContact.MM_CONTACTFLAG_ALL /* 127 */:
                c(h.c, cVar);
                return;
            case DERTags.TAGGED /* 128 */:
                c(h.g, cVar);
                return;
            case 129:
                c(h.c, cVar);
                return;
            case 130:
                c(h.g, cVar);
                return;
            case 131:
                c(h.c, cVar);
                return;
            case 132:
                int c2 = codeIterator.c(i + 1);
                a(h.g, cVar.a(c2));
                a(c2, h.g, gVar);
                return;
            case 133:
                a(h.g, b(cVar));
                e(h.c, cVar);
                return;
            case 134:
                a(h.g, b(cVar));
                e(h.h, cVar);
                return;
            case 135:
                a(h.g, b(cVar));
                e(h.f2939a, cVar);
                return;
            case 136:
                a(h.c, b(cVar));
                e(h.g, cVar);
                return;
            case 137:
                a(h.c, b(cVar));
                e(h.h, cVar);
                return;
            case 138:
                a(h.c, b(cVar));
                e(h.f2939a, cVar);
                return;
            case 139:
                a(h.h, b(cVar));
                e(h.g, cVar);
                return;
            case 140:
                a(h.h, b(cVar));
                e(h.c, cVar);
                return;
            case 141:
                a(h.h, b(cVar));
                e(h.f2939a, cVar);
                return;
            case 142:
                a(h.f2939a, b(cVar));
                e(h.g, cVar);
                return;
            case 143:
                a(h.f2939a, b(cVar));
                e(h.c, cVar);
                return;
            case 144:
                a(h.f2939a, b(cVar));
                e(h.h, cVar);
                return;
            case 145:
            case 146:
            case 147:
                a(h.g, cVar.d());
                return;
            case 148:
                a(h.c, b(cVar));
                a(h.c, b(cVar));
                cVar.a(h.g);
                return;
            case 149:
            case 150:
                a(h.h, b(cVar));
                a(h.h, b(cVar));
                cVar.a(h.g);
                return;
            case 151:
            case 152:
                a(h.f2939a, b(cVar));
                a(h.f2939a, b(cVar));
                cVar.a(h.g);
                return;
            case RContact.MM_CONTACTIMGFLAG_LOCAL_EXIST /* 153 */:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
                a(h.g, b(cVar));
                return;
            case 159:
            case 160:
            case BDLocation.TypeNetWorkLocation /* 161 */:
            case 162:
            case 163:
            case 164:
                a(h.g, b(cVar));
                a(h.g, b(cVar));
                return;
            case 165:
            case 166:
                a(h.n, b(cVar));
                a(h.n, b(cVar));
                return;
            case 168:
                cVar.a(h.k);
                return;
            case 169:
                a(h.k, cVar.a(codeIterator.c(i + 1)));
                return;
            case 170:
            case 171:
            case 172:
                a(h.g, b(cVar));
                return;
            case 173:
                a(h.c, b(cVar));
                return;
            case 174:
                a(h.h, b(cVar));
                return;
            case 175:
                a(h.f2939a, b(cVar));
                return;
            case 176:
                try {
                    a(h.a(z.b(anVar.g(), this.b)), b(cVar));
                    return;
                } catch (NotFoundException e3) {
                    throw new RuntimeException(e3);
                }
            case 178:
                a(c, codeIterator.d(i + 1), cVar);
                return;
            case 179:
                e(c, codeIterator.d(i + 1), cVar);
                return;
            case 180:
                a(c, codeIterator.d(i + 1), cVar);
                return;
            case 181:
                e(c, codeIterator.d(i + 1), cVar);
                return;
            case 182:
            case 183:
            case 184:
                c(c, codeIterator.d(i + 1), cVar);
                return;
            case 185:
                b(c, codeIterator.d(i + 1), cVar);
                return;
            case 186:
                d(c, codeIterator.d(i + 1), cVar);
                return;
            case 187:
                cVar.a(d(this.f2932a.d(codeIterator.d(i + 1))));
                return;
            case 188:
                a(i, codeIterator, cVar);
                return;
            case 189:
                b(i, codeIterator, cVar);
                return;
            case 190:
                h b4 = b(cVar);
                if (!b4.f() && b4 != h.j) {
                    throw new BadBytecode("Array length passed a non-array [pos = " + i + "]: " + b4);
                }
                cVar.a(h.g);
                return;
            case 191:
                a(this.e, b(cVar));
                return;
            case 192:
                a(h.n, b(cVar));
                cVar.a(e(this.f2932a.e(codeIterator.d(i + 1))));
                return;
            case 193:
                a(h.n, b(cVar));
                cVar.a(h.g);
                return;
            case 194:
            case 195:
                a(h.n, b(cVar));
                return;
            case 196:
                a(i, codeIterator, cVar, gVar);
                return;
            case 197:
                b(i, codeIterator, cVar);
                return;
            case 198:
            case 199:
                a(h.n, b(cVar));
                return;
            case 201:
                cVar.a(h.k);
                return;
        }
    }

    private h a(h hVar) {
        if (hVar == h.f || hVar == h.e || hVar == h.d || hVar == h.b) {
            return h.g;
        }
        return hVar;
    }

    private void a(h hVar, c cVar) {
        h e = cVar.e();
        h e2 = cVar.e();
        if (e2 == h.j) {
            a(h.g, e);
            if (hVar == h.n) {
                e(h.j, cVar);
                return;
            } else {
                e(hVar, cVar);
                return;
            }
        }
        h d = e2.d();
        if (d == null) {
            throw new BadBytecode("Not an array! [pos = " + this.g + "]: " + d);
        }
        h a2 = a(d);
        a(hVar, a2);
        a(h.g, e);
        e(a2, cVar);
    }

    private void b(h hVar, c cVar) {
        h b = b(cVar);
        h e = cVar.e();
        h e2 = cVar.e();
        if (e2 == h.j) {
            a(h.g, e);
            return;
        }
        h d = e2.d();
        if (d == null) {
            throw new BadBytecode("Not an array! [pos = " + this.g + "]: " + d);
        }
        h a2 = a(d);
        a(hVar, a2);
        a(h.g, e);
        if (hVar == h.n) {
            a(hVar, b);
        } else {
            a(a2, b);
        }
    }

    private void c(h hVar, c cVar) {
        h b = b(cVar);
        h b2 = b(cVar);
        a(hVar, b);
        a(hVar, b2);
        e(b2, cVar);
    }

    private void a(int i, int i2, c cVar) {
        h a2 = a(e(this.f2932a.k(i2)));
        if (i == 180) {
            a(d(this.f2932a.i(i2)), b(cVar));
        }
        e(a2, cVar);
    }

    private void b(int i, int i2, c cVar) {
        String q = this.f2932a.q(i2);
        h[] b = b(q);
        int length = b.length;
        while (length > 0) {
            length--;
            a(a(b[length]), b(cVar));
        }
        a(d(this.f2932a.p(i2)), b(cVar));
        h c = c(q);
        if (c != h.i) {
            e(a(c), cVar);
        }
    }

    private void c(int i, int i2, c cVar) {
        String o = this.f2932a.o(i2);
        h[] b = b(o);
        int length = b.length;
        while (length > 0) {
            length--;
            a(a(b[length]), b(cVar));
        }
        if (i != 184) {
            a(d(this.f2932a.l(i2)), b(cVar));
        }
        h c = c(o);
        if (c != h.i) {
            e(a(c), cVar);
        }
    }

    private void d(int i, int i2, c cVar) {
        String x = this.f2932a.x(i2);
        h[] b = b(x);
        int length = b.length;
        while (length > 0) {
            length--;
            a(a(b[length]), b(cVar));
        }
        h c = c(x);
        if (c != h.i) {
            e(a(c), cVar);
        }
    }

    private void a(int i, c cVar) {
        h hVar;
        int c = this.f2932a.c(i);
        switch (c) {
            case 3:
                hVar = h.g;
                break;
            case 4:
                hVar = h.h;
                break;
            case 5:
                hVar = h.c;
                break;
            case 6:
                hVar = h.f2939a;
                break;
            case 7:
                hVar = this.d;
                break;
            case 8:
                hVar = this.c;
                break;
            default:
                throw new BadBytecode("bad LDC [pos = " + this.g + "]: " + c);
        }
        e(hVar, cVar);
    }

    private void a(h hVar, int i, c cVar, g gVar) {
        h a2 = cVar.a(i);
        a(hVar, a2);
        e(a2, cVar);
        a(i, a2, gVar);
    }

    private void a(int i, CodeIterator codeIterator, c cVar) {
        h a2;
        a(h.g, b(cVar));
        int c = codeIterator.c(i + 1);
        switch (c) {
            case 4:
                a2 = a("boolean[]");
                break;
            case 5:
                a2 = a("char[]");
                break;
            case 6:
                a2 = a("float[]");
                break;
            case 7:
                a2 = a("double[]");
                break;
            case 8:
                a2 = a("byte[]");
                break;
            case 9:
                a2 = a("short[]");
                break;
            case 10:
                a2 = a("int[]");
                break;
            case 11:
                a2 = a("long[]");
                break;
            default:
                throw new BadBytecode("Invalid array type [pos = " + i + "]: " + c);
        }
        cVar.a(a2);
    }

    private void b(int i, CodeIterator codeIterator, c cVar) {
        int i2;
        String str;
        String n = d(this.f2932a.d(codeIterator.d(i + 1))).a().n();
        if (codeIterator.c(i) == 197) {
            i2 = codeIterator.c(i + 3);
            str = n;
        } else {
            i2 = 1;
            str = n + "[]";
        }
        while (true) {
            int i3 = i2 - 1;
            if (i2 > 0) {
                a(h.g, b(cVar));
                i2 = i3;
            } else {
                e(a(str), cVar);
                return;
            }
        }
    }

    private void e(int i, int i2, c cVar) {
        a(a(e(this.f2932a.k(i2))), b(cVar));
        if (i == 181) {
            a(d(this.f2932a.i(i2)), b(cVar));
        }
    }

    private void d(h hVar, c cVar) {
        h b = b(cVar);
        h b2 = b(cVar);
        a(h.g, b);
        a(hVar, b2);
        e(b2, cVar);
    }

    private void b(h hVar, int i, c cVar, g gVar) {
        h b = b(cVar);
        if (hVar != h.n || b != h.k) {
            a(hVar, b);
        }
        a(i, b, cVar);
        a(i, b, gVar);
    }

    private void a(int i, CodeIterator codeIterator, c cVar, g gVar) {
        int c = codeIterator.c(i + 1);
        int d = codeIterator.d(i + 2);
        switch (c) {
            case 21:
                a(h.g, d, cVar, gVar);
                return;
            case 22:
                a(h.c, d, cVar, gVar);
                return;
            case DERTags.UTC_TIME /* 23 */:
                a(h.h, d, cVar, gVar);
                return;
            case DERTags.GENERALIZED_TIME /* 24 */:
                a(h.f2939a, d, cVar, gVar);
                return;
            case DERTags.GRAPHIC_STRING /* 25 */:
                a(h.n, d, cVar, gVar);
                return;
            case 54:
                b(h.g, d, cVar, gVar);
                return;
            case 55:
                b(h.c, d, cVar, gVar);
                return;
            case 56:
                b(h.h, d, cVar, gVar);
                return;
            case 57:
                b(h.f2939a, d, cVar, gVar);
                return;
            case 58:
                b(h.n, d, cVar, gVar);
                return;
            case 132:
                a(h.g, cVar.a(d));
                return;
            case 169:
                a(h.k, cVar.a(d));
                return;
            default:
                throw new BadBytecode("Invalid WIDE operand [pos = " + i + "]: " + c);
        }
    }

    private h a(String str) {
        try {
            return h.a(this.b.c(str));
        } catch (NotFoundException e) {
            throw new BadBytecode("Could not find class [pos = " + this.g + "]: " + str);
        }
    }

    private h[] b(String str) {
        try {
            javassist.h[] a2 = z.a(str, this.b);
            if (a2 == null) {
                throw new BadBytecode("Could not obtain parameters for descriptor [pos = " + this.g + "]: " + str);
            }
            h[] hVarArr = new h[a2.length];
            for (int i = 0; i < hVarArr.length; i++) {
                hVarArr[i] = h.a(a2[i]);
            }
            return hVarArr;
        } catch (NotFoundException e) {
            throw new BadBytecode("Could not find class in descriptor [pos = " + this.g + "]: " + e.getMessage());
        }
    }

    private h c(String str) {
        try {
            javassist.h b = z.b(str, this.b);
            if (b == null) {
                throw new BadBytecode("Could not obtain return type for descriptor [pos = " + this.g + "]: " + str);
            }
            return h.a(b);
        } catch (NotFoundException e) {
            throw new BadBytecode("Could not find class in descriptor [pos = " + this.g + "]: " + e.getMessage());
        }
    }

    private h a(c cVar) {
        h d = cVar.d();
        return d == h.l ? cVar.b(cVar.b() - 1) : d;
    }

    private h b(c cVar) {
        h e = cVar.e();
        return e == h.l ? cVar.e() : e;
    }

    private void e(h hVar, c cVar) {
        cVar.a(hVar);
        if (hVar.e() == 2) {
            cVar.a(h.l);
        }
    }

    private void a(int i, h hVar, g gVar) {
        if (gVar != null) {
            gVar.b(i);
            if (hVar.e() == 2) {
                gVar.b(i + 1);
            }
        }
    }

    private void a(int i, h hVar, c cVar) {
        cVar.a(i, hVar);
        if (hVar.e() == 2) {
            cVar.a(i + 1, h.l);
        }
    }

    private h d(String str) {
        javassist.h c;
        try {
            if (str.charAt(0) == '[') {
                c = z.c(str, this.b);
            } else {
                c = this.b.c(str);
            }
            if (c == null) {
                throw new BadBytecode("Could not obtain type for descriptor [pos = " + this.g + "]: " + str);
            }
            return h.a(c);
        } catch (NotFoundException e) {
            throw new BadBytecode("Could not find class in descriptor [pos = " + this.g + "]: " + e.getMessage());
        }
    }

    private h e(String str) {
        try {
            javassist.h c = z.c(str, this.b);
            if (c == null) {
                throw new BadBytecode("Could not obtain type for descriptor [pos = " + this.g + "]: " + str);
            }
            return h.a(c);
        } catch (NotFoundException e) {
            throw new BadBytecode("Could not find class in descriptor [pos = " + this.g + "]: " + e.getMessage());
        }
    }

    private void a(h hVar, h hVar2) {
        if (!hVar.a(hVar2)) {
            throw new BadBytecode("Expected type: " + hVar + " Got: " + hVar2 + " [pos = " + this.g + "]");
        }
    }
}
