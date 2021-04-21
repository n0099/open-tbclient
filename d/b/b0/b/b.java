package d.b.b0.b;

import android.util.DisplayMetrics;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: g  reason: collision with root package name */
    public static final b f42128g = new b();

    /* renamed from: a  reason: collision with root package name */
    public final d.b.b0.a.b.a f42129a;

    /* renamed from: b  reason: collision with root package name */
    public final int f42130b;

    /* renamed from: c  reason: collision with root package name */
    public final int f42131c;

    /* renamed from: d  reason: collision with root package name */
    public int f42132d;

    /* renamed from: e  reason: collision with root package name */
    public int f42133e;

    /* renamed from: f  reason: collision with root package name */
    public final int f42134f;

    public b() {
        d.b.b0.a.b.a aVar = d.b.b0.a.b.a.f42106a.get();
        this.f42129a = aVar;
        aVar.D();
        DisplayMetrics displayMetrics = this.f42129a.y().getResources().getDisplayMetrics();
        this.f42131c = displayMetrics.heightPixels;
        this.f42130b = displayMetrics.widthPixels;
        this.f42134f = displayMetrics.densityDpi;
    }

    public static b a() {
        return f42128g;
    }

    public int[] b() {
        int i = this.f42132d;
        return i != 0 ? new int[]{i, this.f42133e, this.f42134f} : new int[]{this.f42130b, this.f42131c, this.f42134f};
    }
}
