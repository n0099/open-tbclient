package d.a.m0.a.z1.b.e;

import android.content.Context;
import android.graphics.drawable.Drawable;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final int f49943a;

    /* renamed from: b  reason: collision with root package name */
    public CharSequence f49944b;

    /* renamed from: c  reason: collision with root package name */
    public Drawable f49945c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f49946d = true;

    /* renamed from: e  reason: collision with root package name */
    public long f49947e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f49948f = 0;

    /* renamed from: g  reason: collision with root package name */
    public a f49949g;

    /* renamed from: h  reason: collision with root package name */
    public Context f49950h;

    /* loaded from: classes3.dex */
    public interface a {
        void a(b bVar);
    }

    public b(Context context, int i2, CharSequence charSequence, Drawable drawable) {
        this.f49950h = context;
        this.f49943a = i2;
        this.f49944b = charSequence;
        this.f49945c = drawable;
    }

    public long a() {
        return this.f49947e;
    }

    public Drawable b() {
        Drawable drawable = this.f49945c;
        if (drawable != null) {
            return drawable;
        }
        if (this.f49948f != 0) {
            Drawable drawable2 = this.f49950h.getResources().getDrawable(this.f49948f);
            this.f49948f = 0;
            this.f49945c = drawable2;
            return drawable2;
        }
        return null;
    }

    public int c() {
        return this.f49943a;
    }

    public a d() {
        return this.f49949g;
    }

    public CharSequence e() {
        return this.f49944b;
    }

    public boolean f() {
        return this.f49946d;
    }

    public void g(d.a.m0.a.z1.b.e.a aVar) {
    }

    public void h(a aVar) {
        this.f49949g = aVar;
    }
}
