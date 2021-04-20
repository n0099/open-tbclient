package d.b.a0.b;

import android.util.DisplayMetrics;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: g  reason: collision with root package name */
    public static final b f41839g = new b();

    /* renamed from: a  reason: collision with root package name */
    public final d.b.a0.a.b.a f41840a;

    /* renamed from: b  reason: collision with root package name */
    public final int f41841b;

    /* renamed from: c  reason: collision with root package name */
    public final int f41842c;

    /* renamed from: d  reason: collision with root package name */
    public int f41843d;

    /* renamed from: e  reason: collision with root package name */
    public int f41844e;

    /* renamed from: f  reason: collision with root package name */
    public final int f41845f;

    public b() {
        d.b.a0.a.b.a aVar = d.b.a0.a.b.a.f41817a.get();
        this.f41840a = aVar;
        aVar.D();
        DisplayMetrics displayMetrics = this.f41840a.y().getResources().getDisplayMetrics();
        this.f41842c = displayMetrics.heightPixels;
        this.f41841b = displayMetrics.widthPixels;
        this.f41845f = displayMetrics.densityDpi;
    }

    public static b a() {
        return f41839g;
    }

    public int[] b() {
        int i = this.f41843d;
        return i != 0 ? new int[]{i, this.f41844e, this.f41845f} : new int[]{this.f41841b, this.f41842c, this.f41845f};
    }
}
