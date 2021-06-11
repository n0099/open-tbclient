package d.a.d0.b;

import android.util.DisplayMetrics;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: g  reason: collision with root package name */
    public static final b f43301g = new b();

    /* renamed from: a  reason: collision with root package name */
    public final d.a.d0.a.b.a f43302a;

    /* renamed from: b  reason: collision with root package name */
    public final int f43303b;

    /* renamed from: c  reason: collision with root package name */
    public final int f43304c;

    /* renamed from: d  reason: collision with root package name */
    public int f43305d;

    /* renamed from: e  reason: collision with root package name */
    public int f43306e;

    /* renamed from: f  reason: collision with root package name */
    public final int f43307f;

    public b() {
        d.a.d0.a.b.a aVar = d.a.d0.a.b.a.f43271a.get();
        this.f43302a = aVar;
        aVar.s();
        DisplayMetrics displayMetrics = this.f43302a.o().getResources().getDisplayMetrics();
        this.f43304c = displayMetrics.heightPixels;
        this.f43303b = displayMetrics.widthPixels;
        this.f43307f = displayMetrics.densityDpi;
    }

    public static b a() {
        return f43301g;
    }

    public int[] b() {
        int i2 = this.f43305d;
        return i2 != 0 ? new int[]{i2, this.f43306e, this.f43307f} : new int[]{this.f43303b, this.f43304c, this.f43307f};
    }
}
