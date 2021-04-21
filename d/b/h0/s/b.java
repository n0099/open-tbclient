package d.b.h0.s;

import android.util.Log;
import android.view.View;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public int f50071a;

    /* renamed from: b  reason: collision with root package name */
    public int f50072b;

    /* renamed from: c  reason: collision with root package name */
    public int f50073c;

    /* renamed from: d  reason: collision with root package name */
    public int f50074d;

    /* renamed from: e  reason: collision with root package name */
    public int f50075e;

    /* renamed from: f  reason: collision with root package name */
    public int f50076f;

    /* renamed from: g  reason: collision with root package name */
    public int f50077g;

    /* renamed from: h  reason: collision with root package name */
    public int f50078h = 0;

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
    public void a(int i, int i2) {
        int i3;
        float f2;
        int i4;
        int i5 = this.f50075e;
        if (i5 == 90 || i5 == 270) {
            i2 = i;
            i = i2;
        }
        int defaultSize = View.getDefaultSize(this.f50071a, i);
        int defaultSize2 = View.getDefaultSize(this.f50072b, i2);
        if (this.f50078h != 3) {
            if (this.f50071a > 0 && this.f50072b > 0) {
                int mode = View.MeasureSpec.getMode(i);
                i = View.MeasureSpec.getSize(i);
                int mode2 = View.MeasureSpec.getMode(i2);
                i2 = View.MeasureSpec.getSize(i2);
                if (mode == Integer.MIN_VALUE && mode2 == Integer.MIN_VALUE) {
                    float f3 = i;
                    float f4 = i2;
                    float f5 = f3 / f4;
                    int i6 = this.f50078h;
                    if (i6 == 4) {
                        int i7 = this.f50075e;
                        f2 = (i7 == 90 || i7 == 270) ? 0.5625f : 1.7777778f;
                    } else if (i6 != 5) {
                        f2 = this.f50071a / this.f50072b;
                        int i8 = this.f50073c;
                        if (i8 > 0 && (i4 = this.f50074d) > 0) {
                            f2 = (f2 * i8) / i4;
                        }
                    } else {
                        int i9 = this.f50075e;
                        f2 = (i9 == 90 || i9 == 270) ? 0.75f : 1.3333334f;
                    }
                    boolean z = f2 > f5;
                    int i10 = this.f50078h;
                    if (i10 != 0) {
                        if (i10 != 1) {
                            if (i10 != 4 && i10 != 5) {
                                if (z) {
                                    i = Math.min(this.f50071a, i);
                                    i2 = (int) (i / f2);
                                } else {
                                    i2 = Math.min(this.f50072b, i2);
                                    i = (int) (i2 * f2);
                                }
                            }
                        }
                    }
                } else if (mode == 1073741824 && mode2 == 1073741824) {
                    int i11 = this.f50071a;
                    int i12 = i11 * i2;
                    int i13 = this.f50072b;
                    if (i12 < i * i13) {
                        i = (i11 * i2) / i13;
                    } else if (i11 * i2 > i * i13) {
                        i2 = (i13 * i) / i11;
                    }
                } else if (mode == 1073741824) {
                    int i14 = (this.f50072b * i) / this.f50071a;
                    if (mode2 != Integer.MIN_VALUE || i14 <= i2) {
                        i2 = i14;
                    }
                } else if (mode2 == 1073741824) {
                    i3 = (this.f50071a * i2) / this.f50072b;
                    if (mode == Integer.MIN_VALUE) {
                    }
                    i = i3;
                } else {
                    i3 = this.f50071a;
                    int i15 = this.f50072b;
                    if (mode2 != Integer.MIN_VALUE || i15 <= i2) {
                        i2 = i15;
                    } else {
                        i3 = (i3 * i2) / i15;
                    }
                    if (mode == Integer.MIN_VALUE && i3 > i) {
                        i2 = (this.f50072b * i) / this.f50071a;
                    }
                    i = i3;
                }
            } else {
                Log.d("MeasureHelper", "no size yet");
                i = defaultSize;
                i2 = defaultSize2;
            }
        }
        this.f50076f = i;
        this.f50077g = i2;
    }

    public int b() {
        return this.f50077g;
    }

    public int c() {
        return this.f50076f;
    }

    public void d(int i) {
        this.f50078h = i;
    }

    public void e(int i) {
        this.f50075e = i;
    }

    public void f(int i, int i2) {
        this.f50073c = i;
        this.f50074d = i2;
    }

    public void g(int i, int i2) {
        this.f50071a = i;
        this.f50072b = i2;
    }
}
