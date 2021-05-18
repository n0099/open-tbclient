package d.a.b0.b;

import android.util.DisplayMetrics;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: g  reason: collision with root package name */
    public static final b f38555g = new b();

    /* renamed from: a  reason: collision with root package name */
    public final d.a.b0.a.b.a f38556a;

    /* renamed from: b  reason: collision with root package name */
    public final int f38557b;

    /* renamed from: c  reason: collision with root package name */
    public final int f38558c;

    /* renamed from: d  reason: collision with root package name */
    public int f38559d;

    /* renamed from: e  reason: collision with root package name */
    public int f38560e;

    /* renamed from: f  reason: collision with root package name */
    public final int f38561f;

    public b() {
        d.a.b0.a.b.a aVar = d.a.b0.a.b.a.f38533a.get();
        this.f38556a = aVar;
        aVar.s();
        DisplayMetrics displayMetrics = this.f38556a.o().getResources().getDisplayMetrics();
        this.f38558c = displayMetrics.heightPixels;
        this.f38557b = displayMetrics.widthPixels;
        this.f38561f = displayMetrics.densityDpi;
    }

    public static b a() {
        return f38555g;
    }

    public int[] b() {
        int i2 = this.f38559d;
        return i2 != 0 ? new int[]{i2, this.f38560e, this.f38561f} : new int[]{this.f38557b, this.f38558c, this.f38561f};
    }
}
