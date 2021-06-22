package d.a.d0.b;

import android.util.DisplayMetrics;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: g  reason: collision with root package name */
    public static final b f43404g = new b();

    /* renamed from: a  reason: collision with root package name */
    public final d.a.d0.a.b.a f43405a;

    /* renamed from: b  reason: collision with root package name */
    public final int f43406b;

    /* renamed from: c  reason: collision with root package name */
    public final int f43407c;

    /* renamed from: d  reason: collision with root package name */
    public int f43408d;

    /* renamed from: e  reason: collision with root package name */
    public int f43409e;

    /* renamed from: f  reason: collision with root package name */
    public final int f43410f;

    public b() {
        d.a.d0.a.b.a aVar = d.a.d0.a.b.a.f43374a.get();
        this.f43405a = aVar;
        aVar.s();
        DisplayMetrics displayMetrics = this.f43405a.o().getResources().getDisplayMetrics();
        this.f43407c = displayMetrics.heightPixels;
        this.f43406b = displayMetrics.widthPixels;
        this.f43410f = displayMetrics.densityDpi;
    }

    public static b a() {
        return f43404g;
    }

    public int[] b() {
        int i2 = this.f43408d;
        return i2 != 0 ? new int[]{i2, this.f43409e, this.f43410f} : new int[]{this.f43406b, this.f43407c, this.f43410f};
    }
}
