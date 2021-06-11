package d.a.l0.a.z1.b.e;

import android.content.Context;
import android.graphics.drawable.Drawable;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final int f49835a;

    /* renamed from: b  reason: collision with root package name */
    public CharSequence f49836b;

    /* renamed from: c  reason: collision with root package name */
    public Drawable f49837c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f49838d = true;

    /* renamed from: e  reason: collision with root package name */
    public long f49839e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f49840f = 0;

    /* renamed from: g  reason: collision with root package name */
    public a f49841g;

    /* renamed from: h  reason: collision with root package name */
    public Context f49842h;

    /* loaded from: classes3.dex */
    public interface a {
        void a(b bVar);
    }

    public b(Context context, int i2, CharSequence charSequence, Drawable drawable) {
        this.f49842h = context;
        this.f49835a = i2;
        this.f49836b = charSequence;
        this.f49837c = drawable;
    }

    public long a() {
        return this.f49839e;
    }

    public Drawable b() {
        Drawable drawable = this.f49837c;
        if (drawable != null) {
            return drawable;
        }
        if (this.f49840f != 0) {
            Drawable drawable2 = this.f49842h.getResources().getDrawable(this.f49840f);
            this.f49840f = 0;
            this.f49837c = drawable2;
            return drawable2;
        }
        return null;
    }

    public int c() {
        return this.f49835a;
    }

    public a d() {
        return this.f49841g;
    }

    public CharSequence e() {
        return this.f49836b;
    }

    public boolean f() {
        return this.f49838d;
    }

    public void g(d.a.l0.a.z1.b.e.a aVar) {
    }

    public void h(a aVar) {
        this.f49841g = aVar;
    }
}
