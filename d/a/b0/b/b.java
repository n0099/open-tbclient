package d.a.b0.b;

import android.util.DisplayMetrics;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: g  reason: collision with root package name */
    public static final b f39310g = new b();

    /* renamed from: a  reason: collision with root package name */
    public final d.a.b0.a.b.a f39311a;

    /* renamed from: b  reason: collision with root package name */
    public final int f39312b;

    /* renamed from: c  reason: collision with root package name */
    public final int f39313c;

    /* renamed from: d  reason: collision with root package name */
    public int f39314d;

    /* renamed from: e  reason: collision with root package name */
    public int f39315e;

    /* renamed from: f  reason: collision with root package name */
    public final int f39316f;

    public b() {
        d.a.b0.a.b.a aVar = d.a.b0.a.b.a.f39288a.get();
        this.f39311a = aVar;
        aVar.s();
        DisplayMetrics displayMetrics = this.f39311a.o().getResources().getDisplayMetrics();
        this.f39313c = displayMetrics.heightPixels;
        this.f39312b = displayMetrics.widthPixels;
        this.f39316f = displayMetrics.densityDpi;
    }

    public static b a() {
        return f39310g;
    }

    public int[] b() {
        int i2 = this.f39314d;
        return i2 != 0 ? new int[]{i2, this.f39315e, this.f39316f} : new int[]{this.f39312b, this.f39313c, this.f39316f};
    }
}
