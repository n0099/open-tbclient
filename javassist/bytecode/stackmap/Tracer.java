package javassist.bytecode.stackmap;

import com.baidu.location.BDLocation;
import com.baidu.loginshare.e;
import com.baidu.zeus.bouncycastle.DERTags;
import com.tencent.mm.sdk.contact.RContact;
import javassist.bytecode.BadBytecode;
import javassist.bytecode.as;
import javassist.bytecode.g;
import javassist.bytecode.stackmap.TypeData;
import javassist.bytecode.y;
import javassist.bytecode.z;
/* loaded from: classes.dex */
public abstract class Tracer implements d {

    /* renamed from: a  reason: collision with root package name */
    protected javassist.c f2803a;
    protected y b;
    protected String c;
    protected int d;
    protected TypeData[] e;
    protected TypeData[] f;

    public Tracer(javassist.c cVar, y yVar, int i, int i2, String str) {
        this.f2803a = cVar;
        this.b = yVar;
        this.c = str;
        this.d = 0;
        this.e = TypeData.a(i);
        this.f = TypeData.a(i2);
    }

    public Tracer(Tracer tracer) {
        this.f2803a = tracer.f2803a;
        this.b = tracer.b;
        this.c = tracer.c;
        this.d = tracer.d;
        this.e = TypeData.a(tracer.e.length);
        this.f = TypeData.a(tracer.f.length);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int a(int i, byte[] bArr) {
        try {
            int i2 = bArr[i] & 255;
            if (i2 < 96) {
                if (i2 < 54) {
                    return c(i, bArr, i2);
                }
                return d(i, bArr, i2);
            } else if (i2 < 148) {
                return e(i, bArr, i2);
            } else {
                return f(i, bArr, i2);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new BadBytecode("inconsistent stack height " + e.getMessage());
        }
    }

    protected void a(int i, byte[] bArr, int i2) {
    }

    protected void b(int i, byte[] bArr, int i2) {
    }

    protected void b(int i, byte[] bArr) {
    }

    protected void c(int i, byte[] bArr) {
    }

    protected void a(int i, byte[] bArr, int i2, int i3, int i4) {
    }

    protected void b(int i, byte[] bArr, int i2, int i3, int i4) {
    }

    protected void d(int i, byte[] bArr) {
    }

    protected void e(int i, byte[] bArr) {
    }

    private int c(int i, byte[] bArr, int i2) {
        TypeData[] typeDataArr = this.e;
        switch (i2) {
            case 0:
                break;
            case 1:
                int i3 = this.d;
                this.d = i3 + 1;
                typeDataArr[i3] = new TypeData.NullType();
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                int i4 = this.d;
                this.d = i4 + 1;
                typeDataArr[i4] = h;
                break;
            case 9:
            case 10:
                int i5 = this.d;
                this.d = i5 + 1;
                typeDataArr[i5] = k;
                int i6 = this.d;
                this.d = i6 + 1;
                typeDataArr[i6] = g;
                break;
            case 11:
            case 12:
            case 13:
                int i7 = this.d;
                this.d = i7 + 1;
                typeDataArr[i7] = i;
                break;
            case 14:
            case 15:
                int i8 = this.d;
                this.d = i8 + 1;
                typeDataArr[i8] = j;
                int i9 = this.d;
                this.d = i9 + 1;
                typeDataArr[i9] = g;
                break;
            case 16:
            case 17:
                int i10 = this.d;
                this.d = i10 + 1;
                typeDataArr[i10] = h;
                return i2 != 17 ? 2 : 3;
            case 18:
                a(bArr[i + 1] & 255);
                return 2;
            case 19:
            case 20:
                a(g.a(bArr, i + 1));
                return 3;
            case 21:
                return a(h, bArr, i);
            case 22:
                return a(k, bArr, i);
            case DERTags.UTC_TIME /* 23 */:
                return a(i, bArr, i);
            case DERTags.GENERALIZED_TIME /* 24 */:
                return a(j, bArr, i);
            case DERTags.GRAPHIC_STRING /* 25 */:
                return b(bArr[i + 1] & 255);
            case DERTags.VISIBLE_STRING /* 26 */:
            case DERTags.GENERAL_STRING /* 27 */:
            case DERTags.UNIVERSAL_STRING /* 28 */:
            case 29:
                int i11 = this.d;
                this.d = i11 + 1;
                typeDataArr[i11] = h;
                break;
            case DERTags.BMP_STRING /* 30 */:
            case 31:
            case 32:
            case 33:
                int i12 = this.d;
                this.d = i12 + 1;
                typeDataArr[i12] = k;
                int i13 = this.d;
                this.d = i13 + 1;
                typeDataArr[i13] = g;
                break;
            case 34:
            case 35:
            case 36:
            case 37:
                int i14 = this.d;
                this.d = i14 + 1;
                typeDataArr[i14] = i;
                break;
            case 38:
            case 39:
            case 40:
            case 41:
                int i15 = this.d;
                this.d = i15 + 1;
                typeDataArr[i15] = j;
                int i16 = this.d;
                this.d = i16 + 1;
                typeDataArr[i16] = g;
                break;
            case 42:
            case 43:
            case 44:
            case 45:
                int i17 = this.d;
                this.d = i17 + 1;
                typeDataArr[i17] = this.f[i2 - 42];
                break;
            case 46:
                int i18 = this.d - 1;
                this.d = i18;
                typeDataArr[i18 - 1] = h;
                break;
            case 47:
                typeDataArr[this.d - 2] = k;
                typeDataArr[this.d - 1] = g;
                break;
            case 48:
                int i19 = this.d - 1;
                this.d = i19;
                typeDataArr[i19 - 1] = i;
                break;
            case 49:
                typeDataArr[this.d - 2] = j;
                typeDataArr[this.d - 1] = g;
                break;
            case 50:
                int i20 = this.d - 1;
                this.d = i20;
                int i21 = i20 - 1;
                typeDataArr[i21] = TypeData.ArrayElement.c(typeDataArr[i21]);
                break;
            case 51:
            case 52:
            case 53:
                int i22 = this.d - 1;
                this.d = i22;
                typeDataArr[i22 - 1] = h;
                break;
            default:
                throw new RuntimeException("fatal");
        }
        return 1;
    }

    private void a(int i) {
        TypeData[] typeDataArr = this.e;
        int c = this.b.c(i);
        if (c == 8) {
            int i2 = this.d;
            this.d = i2 + 1;
            typeDataArr[i2] = new TypeData.ClassName("java.lang.String");
        } else if (c == 3) {
            int i3 = this.d;
            this.d = i3 + 1;
            typeDataArr[i3] = h;
        } else if (c == 4) {
            int i4 = this.d;
            this.d = i4 + 1;
            typeDataArr[i4] = i;
        } else if (c == 5) {
            int i5 = this.d;
            this.d = i5 + 1;
            typeDataArr[i5] = k;
            int i6 = this.d;
            this.d = i6 + 1;
            typeDataArr[i6] = g;
        } else if (c == 6) {
            int i7 = this.d;
            this.d = i7 + 1;
            typeDataArr[i7] = j;
            int i8 = this.d;
            this.d = i8 + 1;
            typeDataArr[i8] = g;
        } else if (c == 7) {
            int i9 = this.d;
            this.d = i9 + 1;
            typeDataArr[i9] = new TypeData.ClassName("java.lang.Class");
        } else {
            throw new RuntimeException("bad LDC: " + c);
        }
    }

    private int a(TypeData typeData, byte[] bArr, int i) {
        return a(bArr[i + 1] & 255, typeData);
    }

    private int a(int i, TypeData typeData) {
        TypeData[] typeDataArr = this.e;
        int i2 = this.d;
        this.d = i2 + 1;
        typeDataArr[i2] = typeData;
        if (typeData.d()) {
            TypeData[] typeDataArr2 = this.e;
            int i3 = this.d;
            this.d = i3 + 1;
            typeDataArr2[i3] = g;
            return 2;
        }
        return 2;
    }

    private int b(int i) {
        TypeData[] typeDataArr = this.e;
        int i2 = this.d;
        this.d = i2 + 1;
        typeDataArr[i2] = this.f[i];
        return 2;
    }

    private int d(int i, byte[] bArr, int i2) {
        switch (i2) {
            case 54:
                return a(i, bArr, h);
            case 55:
                return a(i, bArr, k);
            case 56:
                return a(i, bArr, i);
            case 57:
                return a(i, bArr, j);
            case 58:
                return c(bArr[i + 1] & 255);
            case 59:
            case 60:
            case BDLocation.TypeGpsLocation /* 61 */:
            case BDLocation.TypeCriteriaException /* 62 */:
                this.f[i2 - 59] = h;
                this.d--;
                break;
            case BDLocation.TypeNetWorkException /* 63 */:
            case 64:
            case BDLocation.TypeCacheLocation /* 65 */:
            case BDLocation.TypeOffLineLocation /* 66 */:
                int i3 = i2 - 63;
                this.f[i3] = k;
                this.f[i3 + 1] = g;
                this.d -= 2;
                break;
            case BDLocation.TypeOffLineLocationFail /* 67 */:
            case BDLocation.TypeOffLineLocationNetworkFail /* 68 */:
            case 69:
            case 70:
                this.f[i2 - 67] = i;
                this.d--;
                break;
            case 71:
            case 72:
            case 73:
            case 74:
                int i4 = i2 - 71;
                this.f[i4] = j;
                this.f[i4 + 1] = g;
                this.d -= 2;
                break;
            case 75:
            case 76:
            case 77:
            case 78:
                c(i2 - 75);
                break;
            case 79:
            case e.i /* 80 */:
            case 81:
            case 82:
                this.d -= (i2 == 80 || i2 == 82) ? 4 : 3;
                break;
            case 83:
                TypeData.ArrayElement.a(this.e[this.d - 3], this.e[this.d - 1], this.f2803a);
                this.d -= 3;
                break;
            case 84:
            case 85:
            case 86:
                this.d -= 3;
                break;
            case 87:
                this.d--;
                break;
            case 88:
                this.d -= 2;
                break;
            case 89:
                int i5 = this.d;
                this.e[i5] = this.e[i5 - 1];
                this.d = i5 + 1;
                break;
            case 90:
            case 91:
                int i6 = (i2 - 90) + 2;
                a(1, i6);
                int i7 = this.d;
                this.e[i7 - i6] = this.e[i7];
                this.d = i7 + 1;
                break;
            case 92:
                a(2, 2);
                this.d += 2;
                break;
            case 93:
            case 94:
                int i8 = (i2 - 93) + 3;
                a(2, i8);
                int i9 = this.d;
                this.e[i9 - i8] = this.e[i9];
                this.e[(i9 - i8) + 1] = this.e[i9 + 1];
                this.d = i9 + 2;
                break;
            case 95:
                int i10 = this.d - 1;
                TypeData typeData = this.e[i10];
                this.e[i10] = this.e[i10 - 1];
                this.e[i10 - 1] = typeData;
                break;
            default:
                throw new RuntimeException("fatal");
        }
        return 1;
    }

    private int a(int i, byte[] bArr, TypeData typeData) {
        return b(bArr[i + 1] & 255, typeData);
    }

    private int b(int i, TypeData typeData) {
        this.d--;
        this.f[i] = typeData;
        if (typeData.d()) {
            this.d--;
            this.f[i + 1] = g;
            return 2;
        }
        return 2;
    }

    private int c(int i) {
        this.d--;
        this.f[i] = this.e[this.d];
        return 2;
    }

    private void a(int i, int i2) {
        TypeData[] typeDataArr = this.e;
        int i3 = this.d - 1;
        int i4 = i3 - i2;
        while (i3 > i4) {
            typeDataArr[i3 + i] = typeDataArr[i3];
            i3--;
        }
    }

    private int e(int i, byte[] bArr, int i2) {
        if (i2 <= 131) {
            this.d += as.f[i2];
            return 1;
        }
        switch (i2) {
            case 132:
                return 3;
            case 133:
                this.e[this.d - 1] = k;
                this.e[this.d] = g;
                this.d++;
                return 1;
            case 134:
                this.e[this.d - 1] = i;
                return 1;
            case 135:
                this.e[this.d - 1] = j;
                this.e[this.d] = g;
                this.d++;
                return 1;
            case 136:
                TypeData[] typeDataArr = this.e;
                int i3 = this.d - 1;
                this.d = i3;
                typeDataArr[i3 - 1] = h;
                return 1;
            case 137:
                TypeData[] typeDataArr2 = this.e;
                int i4 = this.d - 1;
                this.d = i4;
                typeDataArr2[i4 - 1] = i;
                return 1;
            case 138:
                this.e[this.d - 2] = j;
                return 1;
            case 139:
                this.e[this.d - 1] = h;
                return 1;
            case 140:
                this.e[this.d - 1] = k;
                this.e[this.d] = g;
                this.d++;
                return 1;
            case 141:
                this.e[this.d - 1] = j;
                this.e[this.d] = g;
                this.d++;
                return 1;
            case 142:
                TypeData[] typeDataArr3 = this.e;
                int i5 = this.d - 1;
                this.d = i5;
                typeDataArr3[i5 - 1] = h;
                return 1;
            case 143:
                this.e[this.d - 2] = k;
                return 1;
            case 144:
                TypeData[] typeDataArr4 = this.e;
                int i6 = this.d - 1;
                this.d = i6;
                typeDataArr4[i6 - 1] = i;
                return 1;
            case 145:
            case 146:
            case 147:
                return 1;
            default:
                throw new RuntimeException("fatal");
        }
    }

    private int f(int i, byte[] bArr, int i2) {
        String str;
        switch (i2) {
            case 148:
                this.e[this.d - 4] = h;
                this.d -= 3;
                break;
            case 149:
            case 150:
                TypeData[] typeDataArr = this.e;
                int i3 = this.d - 1;
                this.d = i3;
                typeDataArr[i3 - 1] = h;
                break;
            case 151:
            case 152:
                this.e[this.d - 4] = h;
                this.d -= 3;
                break;
            case RContact.MM_CONTACTIMGFLAG_LOCAL_EXIST /* 153 */:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
                this.d--;
                a(i, bArr, g.b(bArr, i + 1));
                return 3;
            case 159:
            case 160:
            case BDLocation.TypeNetWorkLocation /* 161 */:
            case 162:
            case 163:
            case 164:
            case 165:
            case 166:
                this.d -= 2;
                a(i, bArr, g.b(bArr, i + 1));
                return 3;
            case BDLocation.TypeServerError /* 167 */:
                b(i, bArr, g.b(bArr, i + 1));
                return 3;
            case 168:
                d(i, bArr);
                return 3;
            case 169:
                e(i, bArr);
                return 2;
            case 170:
                this.d--;
                int i4 = (i & (-4)) + 8;
                int c = (g.c(bArr, i4 + 4) - g.c(bArr, i4)) + 1;
                a(i, bArr, c, i4 + 8, g.c(bArr, i4 - 4));
                return ((c * 4) + 16) - (i & 3);
            case 171:
                this.d--;
                int i5 = (i & (-4)) + 8;
                int c2 = g.c(bArr, i5);
                b(i, bArr, c2, i5 + 4, g.c(bArr, i5 - 4));
                return ((c2 * 8) + 12) - (i & 3);
            case 172:
                this.d--;
                b(i, bArr);
                break;
            case 173:
                this.d -= 2;
                b(i, bArr);
                break;
            case 174:
                this.d--;
                b(i, bArr);
                break;
            case 175:
                this.d -= 2;
                b(i, bArr);
                break;
            case 176:
                TypeData[] typeDataArr2 = this.e;
                int i6 = this.d - 1;
                this.d = i6;
                typeDataArr2[i6].a(this.c, this.f2803a);
                b(i, bArr);
                break;
            case 177:
                b(i, bArr);
                break;
            case 178:
                return b(i, bArr, false);
            case 179:
                return a(i, bArr, false);
            case 180:
                return b(i, bArr, true);
            case 181:
                return a(i, bArr, true);
            case 182:
            case 183:
                return c(i, bArr, true);
            case 184:
                return c(i, bArr, false);
            case 185:
                return i(i, bArr);
            case 186:
                return j(i, bArr);
            case 187:
                int a2 = g.a(bArr, i + 1);
                TypeData[] typeDataArr3 = this.e;
                int i7 = this.d;
                this.d = i7 + 1;
                typeDataArr3[i7] = new TypeData.UninitData(i, this.b.d(a2));
                return 3;
            case 188:
                return g(i, bArr);
            case 189:
                String replace = this.b.d(g.a(bArr, i + 1)).replace('.', '/');
                if (replace.charAt(0) == '[') {
                    str = "[" + replace;
                } else {
                    str = "[L" + replace + ";";
                }
                this.e[this.d - 1] = new TypeData.ClassName(str);
                return 3;
            case 190:
                this.e[this.d - 1].a("[Ljava.lang.Object;", this.f2803a);
                this.e[this.d - 1] = h;
                break;
            case 191:
                TypeData[] typeDataArr4 = this.e;
                int i8 = this.d - 1;
                this.d = i8;
                typeDataArr4[i8].a("java.lang.Throwable", this.f2803a);
                c(i, bArr);
                break;
            case 192:
                String d = this.b.d(g.a(bArr, i + 1));
                if (d.charAt(0) == '[') {
                    d = d.replace('.', '/');
                }
                this.e[this.d - 1] = new TypeData.ClassName(d);
                return 3;
            case 193:
                this.e[this.d - 1] = h;
                return 3;
            case 194:
            case 195:
                this.d--;
                break;
            case 196:
                return f(i, bArr);
            case 197:
                return h(i, bArr);
            case 198:
            case 199:
                this.d--;
                a(i, bArr, g.b(bArr, i + 1));
                return 3;
            case 200:
                b(i, bArr, g.c(bArr, i + 1));
                return 5;
            case 201:
                d(i, bArr);
                return 5;
        }
        return 1;
    }

    private int f(int i, byte[] bArr) {
        int i2 = bArr[i + 1] & 255;
        switch (i2) {
            case 21:
                b(i, bArr, h);
                break;
            case 22:
                b(i, bArr, k);
                break;
            case DERTags.UTC_TIME /* 23 */:
                b(i, bArr, i);
                break;
            case DERTags.GENERALIZED_TIME /* 24 */:
                b(i, bArr, j);
                break;
            case DERTags.GRAPHIC_STRING /* 25 */:
                b(g.a(bArr, i + 2));
                break;
            case 54:
                c(i, bArr, h);
                break;
            case 55:
                c(i, bArr, k);
                break;
            case 56:
                c(i, bArr, i);
                break;
            case 57:
                c(i, bArr, j);
                break;
            case 58:
                c(g.a(bArr, i + 2));
                break;
            case 132:
                return 6;
            case 169:
                e(i, bArr);
                break;
            default:
                throw new RuntimeException("bad WIDE instruction: " + i2);
        }
        return 4;
    }

    private void b(int i, byte[] bArr, TypeData typeData) {
        a(g.a(bArr, i + 2), typeData);
    }

    private void c(int i, byte[] bArr, TypeData typeData) {
        b(g.a(bArr, i + 2), typeData);
    }

    private int a(int i, byte[] bArr, boolean z) {
        int a2 = g.a(bArr, i + 1);
        String k = this.b.k(a2);
        this.d -= z.g(k);
        char charAt = k.charAt(0);
        if (charAt == 'L') {
            this.e[this.d].a(a(k, 0), this.f2803a);
        } else if (charAt == '[') {
            this.e[this.d].a(k, this.f2803a);
        }
        a(z, a2);
        return 3;
    }

    private int b(int i, byte[] bArr, boolean z) {
        int a2 = g.a(bArr, i + 1);
        a(z, a2);
        a(this.b.k(a2));
        return 3;
    }

    private void a(boolean z, int i) {
        if (z) {
            String i2 = this.b.i(i);
            TypeData[] typeDataArr = this.e;
            int i3 = this.d - 1;
            this.d = i3;
            typeDataArr[i3].a(i2, this.f2803a);
        }
    }

    private int g(int i, byte[] bArr) {
        String str;
        int i2 = this.d - 1;
        switch (bArr[i + 1] & 255) {
            case 4:
                str = "[Z";
                break;
            case 5:
                str = "[C";
                break;
            case 6:
                str = "[F";
                break;
            case 7:
                str = "[D";
                break;
            case 8:
                str = "[B";
                break;
            case 9:
                str = "[S";
                break;
            case 10:
                str = "[I";
                break;
            case 11:
                str = "[J";
                break;
            default:
                throw new RuntimeException("bad newarray");
        }
        this.e[i2] = new TypeData.ClassName(str);
        return 2;
    }

    private int h(int i, byte[] bArr) {
        int a2 = g.a(bArr, i + 1);
        this.d -= (bArr[i + 3] & 255) - 1;
        this.e[this.d - 1] = new TypeData.ClassName(this.b.d(a2).replace('.', '/'));
        return 4;
    }

    private int c(int i, byte[] bArr, boolean z) {
        int a2 = g.a(bArr, i + 1);
        String o = this.b.o(a2);
        b(o, 1);
        if (z) {
            String l = this.b.l(a2);
            TypeData[] typeDataArr = this.e;
            int i2 = this.d - 1;
            this.d = i2;
            TypeData typeData = typeDataArr[i2];
            if ((typeData instanceof TypeData.UninitTypeVar) && typeData.f()) {
                a(typeData, ((TypeData.UninitTypeVar) typeData).i());
            } else if (typeData instanceof TypeData.UninitData) {
                a(typeData, ((TypeData.UninitData) typeData).j());
            }
            typeData.a(l, this.f2803a);
        }
        a(o);
        return 3;
    }

    private void a(TypeData typeData, int i) {
        typeData.b(i);
        for (int i2 = 0; i2 < this.d; i2++) {
            this.e[i2].b(i);
        }
        for (int i3 = 0; i3 < this.f.length; i3++) {
            this.f[i3].b(i);
        }
    }

    private int i(int i, byte[] bArr) {
        int a2 = g.a(bArr, i + 1);
        String q = this.b.q(a2);
        b(q, 1);
        String p = this.b.p(a2);
        TypeData[] typeDataArr = this.e;
        int i2 = this.d - 1;
        this.d = i2;
        typeDataArr[i2].a(p, this.f2803a);
        a(q);
        return 5;
    }

    private int j(int i, byte[] bArr) {
        String x = this.b.x(g.a(bArr, i + 1));
        b(x, 1);
        a(x);
        return 5;
    }

    private void a(String str) {
        int i = 0;
        if (str.charAt(0) == '(' && (i = str.indexOf(41) + 1) < 1) {
            throw new IndexOutOfBoundsException("bad descriptor: " + str);
        }
        TypeData[] typeDataArr = this.e;
        int i2 = this.d;
        switch (str.charAt(i)) {
            case BDLocation.TypeOffLineLocationNetworkFail /* 68 */:
                typeDataArr[i2] = j;
                typeDataArr[i2 + 1] = g;
                this.d += 2;
                return;
            case 'F':
                typeDataArr[i2] = i;
                break;
            case 'J':
                typeDataArr[i2] = k;
                typeDataArr[i2 + 1] = g;
                this.d += 2;
                return;
            case 'L':
                typeDataArr[i2] = new TypeData.ClassName(a(str, i));
                break;
            case 'V':
                return;
            case '[':
                typeDataArr[i2] = new TypeData.ClassName(str.substring(i));
                break;
            default:
                typeDataArr[i2] = h;
                break;
        }
        this.d++;
    }

    private static String a(String str, int i) {
        return str.substring(i + 1, str.length() - 1).replace('/', '.');
    }

    private void b(String str, int i) {
        boolean z;
        int i2;
        char charAt = str.charAt(i);
        if (charAt != ')') {
            boolean z2 = false;
            int i3 = i;
            char c = charAt;
            while (true) {
                z = z2;
                if (c != '[') {
                    break;
                }
                z2 = true;
                int i4 = i3 + 1;
                c = str.charAt(i4);
                i3 = i4;
            }
            if (c == 'L') {
                i2 = str.indexOf(59, i3) + 1;
                if (i2 <= 0) {
                    throw new IndexOutOfBoundsException("bad descriptor");
                }
            } else {
                i2 = i3 + 1;
            }
            b(str, i2);
            if (!z && (c == 'J' || c == 'D')) {
                this.d -= 2;
            } else {
                this.d--;
            }
            if (z) {
                this.e[this.d].a(str.substring(i, i2), this.f2803a);
            } else if (c == 'L') {
                this.e[this.d].a(str.substring(i + 1, i2 - 1).replace('/', '.'), this.f2803a);
            }
        }
    }
}
