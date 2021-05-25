package d.a.d0.b;

import android.util.DisplayMetrics;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: g  reason: collision with root package name */
    public static final b f39620g = new b();

    /* renamed from: a  reason: collision with root package name */
    public final d.a.d0.a.b.a f39621a;

    /* renamed from: b  reason: collision with root package name */
    public final int f39622b;

    /* renamed from: c  reason: collision with root package name */
    public final int f39623c;

    /* renamed from: d  reason: collision with root package name */
    public int f39624d;

    /* renamed from: e  reason: collision with root package name */
    public int f39625e;

    /* renamed from: f  reason: collision with root package name */
    public final int f39626f;

    public b() {
        d.a.d0.a.b.a aVar = d.a.d0.a.b.a.f39590a.get();
        this.f39621a = aVar;
        aVar.s();
        DisplayMetrics displayMetrics = this.f39621a.o().getResources().getDisplayMetrics();
        this.f39623c = displayMetrics.heightPixels;
        this.f39622b = displayMetrics.widthPixels;
        this.f39626f = displayMetrics.densityDpi;
    }

    public static b a() {
        return f39620g;
    }

    public int[] b() {
        int i2 = this.f39624d;
        return i2 != 0 ? new int[]{i2, this.f39625e, this.f39626f} : new int[]{this.f39622b, this.f39623c, this.f39626f};
    }
}
