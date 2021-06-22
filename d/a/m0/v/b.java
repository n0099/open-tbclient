package d.a.m0.v;

import android.util.Log;
import android.view.View;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public int f52290a;

    /* renamed from: b  reason: collision with root package name */
    public int f52291b;

    /* renamed from: c  reason: collision with root package name */
    public int f52292c;

    /* renamed from: d  reason: collision with root package name */
    public int f52293d;

    /* renamed from: e  reason: collision with root package name */
    public int f52294e;

    /* renamed from: f  reason: collision with root package name */
    public int f52295f;

    /* renamed from: g  reason: collision with root package name */
    public int f52296g;

    /* renamed from: h  reason: collision with root package name */
    public int f52297h = 0;

    public b(View view) {
        new WeakReference(view);
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00ab, code lost:
        if (r4 != false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00ae, code lost:
        if (r4 != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b0, code lost:
        r12 = (int) (r0 / r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00b4, code lost:
        r11 = (int) (r3 * r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00f4, code lost:
        if (r1 > r11) goto L75;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i2, int i3) {
        int i4;
        float f2;
        int i5;
        int i6 = this.f52294e;
        if (i6 == 90 || i6 == 270) {
            i3 = i2;
            i2 = i3;
        }
        int defaultSize = View.getDefaultSize(this.f52290a, i2);
        int defaultSize2 = View.getDefaultSize(this.f52291b, i3);
        if (this.f52297h != 3) {
            if (this.f52290a > 0 && this.f52291b > 0) {
                int mode = View.MeasureSpec.getMode(i2);
                i2 = View.MeasureSpec.getSize(i2);
                int mode2 = View.MeasureSpec.getMode(i3);
                i3 = View.MeasureSpec.getSize(i3);
                if (mode == Integer.MIN_VALUE && mode2 == Integer.MIN_VALUE) {
                    float f3 = i2;
                    float f4 = i3;
                    float f5 = f3 / f4;
                    int i7 = this.f52297h;
                    if (i7 == 4) {
                        int i8 = this.f52294e;
                        f2 = (i8 == 90 || i8 == 270) ? 0.5625f : 1.7777778f;
                    } else if (i7 != 5) {
                        f2 = this.f52290a / this.f52291b;
                        int i9 = this.f52292c;
                        if (i9 > 0 && (i5 = this.f52293d) > 0) {
                            f2 = (f2 * i9) / i5;
                        }
                    } else {
                        int i10 = this.f52294e;
                        f2 = (i10 == 90 || i10 == 270) ? 0.75f : 1.3333334f;
                    }
                    boolean z = f2 > f5;
                    int i11 = this.f52297h;
                    if (i11 != 0) {
                        if (i11 != 1) {
                            if (i11 != 4 && i11 != 5) {
                                if (z) {
                                    i2 = Math.min(this.f52290a, i2);
                                    i3 = (int) (i2 / f2);
                                } else {
                                    i3 = Math.min(this.f52291b, i3);
                                    i2 = (int) (i3 * f2);
                                }
                            }
                        }
                    }
                } else if (mode == 1073741824 && mode2 == 1073741824) {
                    int i12 = this.f52290a;
                    int i13 = i12 * i3;
                    int i14 = this.f52291b;
                    if (i13 < i2 * i14) {
                        i2 = (i12 * i3) / i14;
                    } else if (i12 * i3 > i2 * i14) {
                        i3 = (i14 * i2) / i12;
                    }
                } else if (mode == 1073741824) {
                    int i15 = (this.f52291b * i2) / this.f52290a;
                    if (mode2 != Integer.MIN_VALUE || i15 <= i3) {
                        i3 = i15;
                    }
                } else if (mode2 == 1073741824) {
                    i4 = (this.f52290a * i3) / this.f52291b;
                    if (mode == Integer.MIN_VALUE) {
                    }
                    i2 = i4;
                } else {
                    i4 = this.f52290a;
                    int i16 = this.f52291b;
                    if (mode2 != Integer.MIN_VALUE || i16 <= i3) {
                        i3 = i16;
                    } else {
                        i4 = (i4 * i3) / i16;
                    }
                    if (mode == Integer.MIN_VALUE && i4 > i2) {
                        i3 = (this.f52291b * i2) / this.f52290a;
                    }
                    i2 = i4;
                }
            } else {
                Log.d("MeasureHelper", "no size yet");
                i2 = defaultSize;
                i3 = defaultSize2;
            }
        }
        this.f52295f = i2;
        this.f52296g = i3;
    }

    public int b() {
        return this.f52296g;
    }

    public int c() {
        return this.f52295f;
    }

    public void d(int i2) {
        this.f52297h = i2;
    }

    public void e(int i2) {
        this.f52294e = i2;
    }

    public void f(int i2, int i3) {
        this.f52292c = i2;
        this.f52293d = i3;
    }

    public void g(int i2, int i3) {
        this.f52290a = i2;
        this.f52291b = i3;
    }
}
