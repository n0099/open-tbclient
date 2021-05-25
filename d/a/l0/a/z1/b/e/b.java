package d.a.l0.a.z1.b.e;

import android.content.Context;
import android.graphics.drawable.Drawable;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final int f46161a;

    /* renamed from: b  reason: collision with root package name */
    public CharSequence f46162b;

    /* renamed from: c  reason: collision with root package name */
    public Drawable f46163c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f46164d = true;

    /* renamed from: e  reason: collision with root package name */
    public long f46165e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f46166f = 0;

    /* renamed from: g  reason: collision with root package name */
    public a f46167g;

    /* renamed from: h  reason: collision with root package name */
    public Context f46168h;

    /* loaded from: classes3.dex */
    public interface a {
        void a(b bVar);
    }

    public b(Context context, int i2, CharSequence charSequence, Drawable drawable) {
        this.f46168h = context;
        this.f46161a = i2;
        this.f46162b = charSequence;
        this.f46163c = drawable;
    }

    public long a() {
        return this.f46165e;
    }

    public Drawable b() {
        Drawable drawable = this.f46163c;
        if (drawable != null) {
            return drawable;
        }
        if (this.f46166f != 0) {
            Drawable drawable2 = this.f46168h.getResources().getDrawable(this.f46166f);
            this.f46166f = 0;
            this.f46163c = drawable2;
            return drawable2;
        }
        return null;
    }

    public int c() {
        return this.f46161a;
    }

    public a d() {
        return this.f46167g;
    }

    public CharSequence e() {
        return this.f46162b;
    }

    public boolean f() {
        return this.f46164d;
    }

    public void g(d.a.l0.a.z1.b.e.a aVar) {
    }

    public void h(a aVar) {
        this.f46167g = aVar;
    }
}
