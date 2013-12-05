package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.i;
import com.google.zxing.j;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class FinderPatternFinder {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.zxing.common.a f2888a;
    private boolean c;
    private final j e;
    private final List<d> b = new ArrayList();
    private final int[] d = new int[5];

    public FinderPatternFinder(com.google.zxing.common.a aVar, j jVar) {
        this.f2888a = aVar;
        this.e = jVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final e a(Map<DecodeHintType, ?> map) {
        int i;
        int i2;
        boolean z;
        boolean z2 = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        int d = this.f2888a.d();
        int c = this.f2888a.c();
        int i3 = (d * 3) / 228;
        int i4 = (i3 < 3 || z2) ? 3 : i3;
        boolean z3 = false;
        int[] iArr = new int[5];
        int i5 = i4 - 1;
        int i6 = i4;
        while (i5 < d && !z3) {
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            iArr[3] = 0;
            iArr[4] = 0;
            int i7 = 0;
            int i8 = 0;
            while (i8 < c) {
                if (this.f2888a.a(i8, i5)) {
                    if ((i7 & 1) == 1) {
                        i7++;
                    }
                    iArr[i7] = iArr[i7] + 1;
                } else if ((i7 & 1) == 0) {
                    if (i7 == 4) {
                        if (a(iArr)) {
                            if (a(iArr, i5, i8)) {
                                i6 = 2;
                                if (this.c) {
                                    int i9 = i8;
                                    i2 = i5;
                                    z = c();
                                    i = i9;
                                } else {
                                    int b = b();
                                    if (b > iArr[2]) {
                                        i2 = i5 + ((b - iArr[2]) - 2);
                                        i = c - 1;
                                        z = z3;
                                    } else {
                                        i = i8;
                                        i2 = i5;
                                        z = z3;
                                    }
                                }
                                iArr[0] = 0;
                                iArr[1] = 0;
                                iArr[2] = 0;
                                iArr[3] = 0;
                                iArr[4] = 0;
                                int i10 = i;
                                i7 = 0;
                                z3 = z;
                                i5 = i2;
                                i8 = i10;
                            } else {
                                iArr[0] = iArr[2];
                                iArr[1] = iArr[3];
                                iArr[2] = iArr[4];
                                iArr[3] = 1;
                                iArr[4] = 0;
                                i7 = 3;
                            }
                        } else {
                            iArr[0] = iArr[2];
                            iArr[1] = iArr[3];
                            iArr[2] = iArr[4];
                            iArr[3] = 1;
                            iArr[4] = 0;
                            i7 = 3;
                        }
                    } else {
                        i7++;
                        iArr[i7] = iArr[i7] + 1;
                    }
                } else {
                    iArr[i7] = iArr[i7] + 1;
                }
                i8++;
            }
            if (a(iArr) && a(iArr, i5, c)) {
                i6 = iArr[0];
                if (this.c) {
                    z3 = c();
                }
            }
            i5 += i6;
        }
        d[] d2 = d();
        i.a(d2);
        return new e(d2);
    }

    private static float a(int[] iArr, int i) {
        return ((i - iArr[4]) - iArr[3]) - (iArr[2] / 2.0f);
    }

    protected static boolean a(int[] iArr) {
        int i;
        int i2;
        int i3 = 0;
        for (int i4 = 0; i4 < 5; i4++) {
            int i5 = iArr[i4];
            if (i5 == 0) {
                return false;
            }
            i3 += i5;
        }
        return i3 >= 7 && Math.abs(i - (iArr[0] << 8)) < (i2 = (i = (i3 << 8) / 7) / 2) && Math.abs(i - (iArr[1] << 8)) < i2 && Math.abs((i * 3) - (iArr[2] << 8)) < i2 * 3 && Math.abs(i - (iArr[3] << 8)) < i2 && Math.abs(i - (iArr[4] << 8)) < i2;
    }

    private int[] a() {
        this.d[0] = 0;
        this.d[1] = 0;
        this.d[2] = 0;
        this.d[3] = 0;
        this.d[4] = 0;
        return this.d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003e, code lost:
        if (r4[1] > r14) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0040, code lost:
        if (r1 < 0) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0046, code lost:
        if (r2.a(r13, r1) == false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004a, code lost:
        if (r4[0] <= r14) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004e, code lost:
        if (r4[0] > r14) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0050, code lost:
        r1 = r12 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0052, code lost:
        if (r1 >= r3) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0058, code lost:
        if (r2.a(r13, r1) != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005a, code lost:
        if (r1 == r3) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005c, code lost:
        if (r1 >= r3) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0062, code lost:
        if (r2.a(r13, r1) != false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0066, code lost:
        if (r4[3] < r14) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0068, code lost:
        if (r1 == r3) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006c, code lost:
        if (r4[3] >= r14) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006e, code lost:
        if (r1 >= r3) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0074, code lost:
        if (r2.a(r13, r1) == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0078, code lost:
        if (r4[4] < r14) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x007c, code lost:
        if (r4[4] >= r14) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0096, code lost:
        if ((java.lang.Math.abs(((((r4[0] + r4[1]) + r4[2]) + r4[3]) + r4[4]) - r15) * 5) >= (r15 * 2)) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x009c, code lost:
        if (a(r4) == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a4, code lost:
        r4[0] = r4[0] + 1;
        r1 = r1 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00ad, code lost:
        r4[2] = r4[2] + 1;
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00b7, code lost:
        r4[3] = r4[3] + 1;
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00c0, code lost:
        r4[4] = r4[4] + 1;
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:?, code lost:
        return a(r4, r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private float a(int i, int i2, int i3, int i4) {
        com.google.zxing.common.a aVar = this.f2888a;
        int d = aVar.d();
        int[] a2 = a();
        int i5 = i;
        while (i5 >= 0 && aVar.a(i2, i5)) {
            a2[2] = a2[2] + 1;
            i5--;
        }
        if (i5 < 0) {
            return Float.NaN;
        }
        while (i5 >= 0 && !aVar.a(i2, i5) && a2[1] <= i3) {
            a2[1] = a2[1] + 1;
            i5--;
        }
        return Float.NaN;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003e, code lost:
        if (r4[1] > r14) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0040, code lost:
        if (r1 < 0) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0046, code lost:
        if (r2.a(r1, r13) == false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004a, code lost:
        if (r4[0] <= r14) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004e, code lost:
        if (r4[0] > r14) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0050, code lost:
        r1 = r12 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0052, code lost:
        if (r1 >= r3) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0058, code lost:
        if (r2.a(r1, r13) != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005a, code lost:
        if (r1 == r3) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005c, code lost:
        if (r1 >= r3) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0062, code lost:
        if (r2.a(r1, r13) != false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0066, code lost:
        if (r4[3] < r14) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0068, code lost:
        if (r1 == r3) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006c, code lost:
        if (r4[3] >= r14) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006e, code lost:
        if (r1 >= r3) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0074, code lost:
        if (r2.a(r1, r13) == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0078, code lost:
        if (r4[4] < r14) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x007c, code lost:
        if (r4[4] >= r14) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0094, code lost:
        if ((java.lang.Math.abs(((((r4[0] + r4[1]) + r4[2]) + r4[3]) + r4[4]) - r15) * 5) >= r15) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x009a, code lost:
        if (a(r4) == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a2, code lost:
        r4[0] = r4[0] + 1;
        r1 = r1 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00ab, code lost:
        r4[2] = r4[2] + 1;
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00b5, code lost:
        r4[3] = r4[3] + 1;
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00be, code lost:
        r4[4] = r4[4] + 1;
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:?, code lost:
        return a(r4, r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private float b(int i, int i2, int i3, int i4) {
        com.google.zxing.common.a aVar = this.f2888a;
        int c = aVar.c();
        int[] a2 = a();
        int i5 = i;
        while (i5 >= 0 && aVar.a(i5, i2)) {
            a2[2] = a2[2] + 1;
            i5--;
        }
        if (i5 < 0) {
            return Float.NaN;
        }
        while (i5 >= 0 && !aVar.a(i5, i2) && a2[1] <= i3) {
            a2[1] = a2[1] + 1;
            i5--;
        }
        return Float.NaN;
    }

    protected final boolean a(int[] iArr, int i, int i2) {
        boolean z = false;
        int i3 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        float a2 = a(iArr, i2);
        float a3 = a(i, (int) a2, iArr[2], i3);
        if (Float.isNaN(a3)) {
            return false;
        }
        float b = b((int) a2, (int) a3, iArr[2], i3);
        if (Float.isNaN(b)) {
            return false;
        }
        float f = i3 / 7.0f;
        int i4 = 0;
        while (true) {
            if (i4 >= this.b.size()) {
                break;
            }
            d dVar = this.b.get(i4);
            if (!dVar.a(f, a3, b)) {
                i4++;
            } else {
                this.b.set(i4, dVar.b(a3, b, f));
                z = true;
                break;
            }
        }
        if (!z) {
            d dVar2 = new d(b, a3, f);
            this.b.add(dVar2);
            if (this.e != null) {
                this.e.a(dVar2);
            }
        }
        return true;
    }

    private int b() {
        if (this.b.size() <= 1) {
            return 0;
        }
        d dVar = null;
        for (d dVar2 : this.b) {
            if (dVar2.d() >= 2) {
                if (dVar != null) {
                    this.c = true;
                    return ((int) (Math.abs(dVar.a() - dVar2.a()) - Math.abs(dVar.b() - dVar2.b()))) / 2;
                }
                dVar = dVar2;
            }
        }
        return 0;
    }

    private boolean c() {
        float f = 0.0f;
        int size = this.b.size();
        float f2 = 0.0f;
        int i = 0;
        for (d dVar : this.b) {
            if (dVar.d() >= 2) {
                i++;
                f2 = dVar.c() + f2;
            }
        }
        if (i < 3) {
            return false;
        }
        float f3 = f2 / size;
        for (d dVar2 : this.b) {
            f += Math.abs(dVar2.c() - f3);
        }
        return f <= 0.05f * f2;
    }

    private d[] d() {
        float f = 0.0f;
        int size = this.b.size();
        if (size < 3) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (size > 3) {
            float f2 = 0.0f;
            float f3 = 0.0f;
            for (d dVar : this.b) {
                float c = dVar.c();
                f3 += c;
                f2 = (c * c) + f2;
            }
            float f4 = f3 / size;
            Collections.sort(this.b, new FurthestFromAverageComparator(f4, null));
            float max = Math.max(0.2f * f4, (float) Math.sqrt((f2 / size) - (f4 * f4)));
            int i = 0;
            while (i < this.b.size() && this.b.size() > 3) {
                if (Math.abs(this.b.get(i).c() - f4) > max) {
                    this.b.remove(i);
                    i--;
                }
                i++;
            }
        }
        if (this.b.size() > 3) {
            for (d dVar2 : this.b) {
                f += dVar2.c();
            }
            Collections.sort(this.b, new CenterComparator(f / this.b.size(), null));
            this.b.subList(3, this.b.size()).clear();
        }
        return new d[]{this.b.get(0), this.b.get(1), this.b.get(2)};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class FurthestFromAverageComparator implements Serializable, Comparator<d> {
        private final float average;

        private FurthestFromAverageComparator(float f) {
            this.average = f;
        }

        /* synthetic */ FurthestFromAverageComparator(float f, FurthestFromAverageComparator furthestFromAverageComparator) {
            this(f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(d dVar, d dVar2) {
            float abs = Math.abs(dVar2.c() - this.average);
            float abs2 = Math.abs(dVar.c() - this.average);
            if (abs < abs2) {
                return -1;
            }
            return abs == abs2 ? 0 : 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class CenterComparator implements Serializable, Comparator<d> {
        private final float average;

        private CenterComparator(float f) {
            this.average = f;
        }

        /* synthetic */ CenterComparator(float f, CenterComparator centerComparator) {
            this(f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(d dVar, d dVar2) {
            if (dVar2.d() == dVar.d()) {
                float abs = Math.abs(dVar2.c() - this.average);
                float abs2 = Math.abs(dVar.c() - this.average);
                if (abs < abs2) {
                    return 1;
                }
                return abs == abs2 ? 0 : -1;
            }
            return dVar2.d() - dVar.d();
        }
    }
}
