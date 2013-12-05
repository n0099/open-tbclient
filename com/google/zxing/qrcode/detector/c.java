package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.g;
import com.google.zxing.i;
import com.google.zxing.j;
import com.google.zxing.qrcode.decoder.o;
import java.util.Map;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.zxing.common.a f2891a;
    private j b;

    public c(com.google.zxing.common.a aVar) {
        this.f2891a = aVar;
    }

    public final com.google.zxing.common.e a(Map<DecodeHintType, ?> map) {
        this.b = map == null ? null : (j) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        return a(new FinderPatternFinder(this.f2891a, this.b).a(map));
    }

    protected final com.google.zxing.common.e a(e eVar) {
        d b = eVar.b();
        d c = eVar.c();
        d a2 = eVar.a();
        float a3 = a(b, c, a2);
        if (a3 < 1.0f) {
            throw NotFoundException.getNotFoundInstance();
        }
        int a4 = a(b, c, a2, a3);
        o a5 = o.a(a4);
        int d = a5.d() - 7;
        a aVar = null;
        if (a5.b().length > 0) {
            float a6 = (c.a() - b.a()) + a2.a();
            float b2 = (c.b() - b.b()) + a2.b();
            float f = 1.0f - (3.0f / d);
            int a7 = (int) (((a6 - b.a()) * f) + b.a());
            int b3 = (int) (b.b() + (f * (b2 - b.b())));
            for (int i = 4; i <= 16; i <<= 1) {
                try {
                    aVar = a(a3, a7, b3, i);
                    break;
                } catch (NotFoundException e) {
                }
            }
        }
        return new com.google.zxing.common.e(a(this.f2891a, a(b, c, a2, aVar, a4), a4), aVar == null ? new i[]{a2, b, c} : new i[]{a2, b, c, aVar});
    }

    private static com.google.zxing.common.i a(i iVar, i iVar2, i iVar3, i iVar4, int i) {
        float a2;
        float b;
        float f;
        float f2;
        float f3 = i - 3.5f;
        if (iVar4 != null) {
            a2 = iVar4.a();
            b = iVar4.b();
            f = f3 - 3.0f;
            f2 = f;
        } else {
            a2 = (iVar2.a() - iVar.a()) + iVar3.a();
            b = (iVar2.b() - iVar.b()) + iVar3.b();
            f = f3;
            f2 = f3;
        }
        return com.google.zxing.common.i.a(3.5f, 3.5f, f3, 3.5f, f2, f, 3.5f, f3, iVar.a(), iVar.b(), iVar2.a(), iVar2.b(), a2, b, iVar3.a(), iVar3.b());
    }

    private static com.google.zxing.common.a a(com.google.zxing.common.a aVar, com.google.zxing.common.i iVar, int i) {
        return g.a().a(aVar, i, i, iVar);
    }

    private static int a(i iVar, i iVar2, i iVar3, float f) {
        int a2 = ((com.google.zxing.common.a.a.a(i.a(iVar, iVar2) / f) + com.google.zxing.common.a.a.a(i.a(iVar, iVar3) / f)) >> 1) + 7;
        switch (a2 & 3) {
            case 0:
                return a2 + 1;
            case 1:
            default:
                return a2;
            case 2:
                return a2 - 1;
            case 3:
                throw NotFoundException.getNotFoundInstance();
        }
    }

    protected final float a(i iVar, i iVar2, i iVar3) {
        return (a(iVar, iVar2) + a(iVar, iVar3)) / 2.0f;
    }

    private float a(i iVar, i iVar2) {
        float a2 = a((int) iVar.a(), (int) iVar.b(), (int) iVar2.a(), (int) iVar2.b());
        float a3 = a((int) iVar2.a(), (int) iVar2.b(), (int) iVar.a(), (int) iVar.b());
        if (Float.isNaN(a2)) {
            return a3 / 7.0f;
        }
        if (Float.isNaN(a3)) {
            return a2 / 7.0f;
        }
        return (a2 + a3) / 14.0f;
    }

    private float a(int i, int i2, int i3, int i4) {
        int i5;
        float f;
        float f2;
        int i6 = 0;
        float b = b(i, i2, i3, i4);
        int i7 = i - (i3 - i);
        if (i7 < 0) {
            f = i / (i - i7);
            i5 = 0;
        } else if (i7 >= this.f2891a.c()) {
            f = ((this.f2891a.c() - 1) - i) / (i7 - i);
            i5 = this.f2891a.c() - 1;
        } else {
            i5 = i7;
            f = 1.0f;
        }
        int i8 = (int) (i2 - (f * (i4 - i2)));
        if (i8 < 0) {
            f2 = i2 / (i2 - i8);
        } else if (i8 >= this.f2891a.d()) {
            f2 = ((this.f2891a.d() - 1) - i2) / (i8 - i2);
            i6 = this.f2891a.d() - 1;
        } else {
            i6 = i8;
            f2 = 1.0f;
        }
        return (b(i, i2, (int) ((f2 * (i5 - i)) + i), i6) + b) - 1.0f;
    }

    private float b(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z = Math.abs(i4 - i2) > Math.abs(i3 - i);
        if (!z) {
            i4 = i3;
            i3 = i4;
            i2 = i;
            i = i2;
        }
        int abs = Math.abs(i4 - i2);
        int abs2 = Math.abs(i3 - i);
        int i9 = (-abs) >> 1;
        int i10 = i2 < i4 ? 1 : -1;
        int i11 = i < i3 ? 1 : -1;
        int i12 = 0;
        int i13 = i4 + i10;
        int i14 = i2;
        int i15 = i9;
        int i16 = i;
        while (true) {
            if (i14 == i13) {
                i5 = i12;
                break;
            }
            if ((i12 == 1) != this.f2891a.a(z ? i16 : i14, z ? i14 : i16)) {
                i6 = i12;
            } else if (i12 == 2) {
                return com.google.zxing.common.a.a.a(i14, i16, i2, i);
            } else {
                i6 = i12 + 1;
            }
            int i17 = i15 + abs2;
            if (i17 <= 0) {
                i7 = i16;
                i8 = i17;
            } else if (i16 == i3) {
                i5 = i6;
                break;
            } else {
                i7 = i16 + i11;
                i8 = i17 - abs;
            }
            i14 += i10;
            i12 = i6;
            i15 = i8;
            i16 = i7;
        }
        if (i5 == 2) {
            return com.google.zxing.common.a.a.a(i4 + i10, i3, i2, i);
        }
        return Float.NaN;
    }

    protected final a a(float f, int i, int i2, float f2) {
        int i3 = (int) (f2 * f);
        int max = Math.max(0, i - i3);
        int min = Math.min(this.f2891a.c() - 1, i + i3);
        if (min - max < f * 3.0f) {
            throw NotFoundException.getNotFoundInstance();
        }
        int max2 = Math.max(0, i2 - i3);
        int min2 = Math.min(this.f2891a.d() - 1, i3 + i2);
        if (min2 - max2 < f * 3.0f) {
            throw NotFoundException.getNotFoundInstance();
        }
        return new b(this.f2891a, max, max2, min - max, min2 - max2, f, this.b).a();
    }
}
