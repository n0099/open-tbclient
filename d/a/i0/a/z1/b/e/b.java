package d.a.i0.a.z1.b.e;

import android.content.Context;
import android.graphics.drawable.Drawable;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final int f45985a;

    /* renamed from: b  reason: collision with root package name */
    public CharSequence f45986b;

    /* renamed from: c  reason: collision with root package name */
    public Drawable f45987c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f45988d = true;

    /* renamed from: e  reason: collision with root package name */
    public long f45989e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f45990f = 0;

    /* renamed from: g  reason: collision with root package name */
    public a f45991g;

    /* renamed from: h  reason: collision with root package name */
    public Context f45992h;

    /* loaded from: classes3.dex */
    public interface a {
        void a(b bVar);
    }

    public b(Context context, int i2, CharSequence charSequence, Drawable drawable) {
        this.f45992h = context;
        this.f45985a = i2;
        this.f45986b = charSequence;
        this.f45987c = drawable;
    }

    public long a() {
        return this.f45989e;
    }

    public Drawable b() {
        Drawable drawable = this.f45987c;
        if (drawable != null) {
            return drawable;
        }
        if (this.f45990f != 0) {
            Drawable drawable2 = this.f45992h.getResources().getDrawable(this.f45990f);
            this.f45990f = 0;
            this.f45987c = drawable2;
            return drawable2;
        }
        return null;
    }

    public int c() {
        return this.f45985a;
    }

    public a d() {
        return this.f45991g;
    }

    public CharSequence e() {
        return this.f45986b;
    }

    public boolean f() {
        return this.f45988d;
    }

    public void g(d.a.i0.a.z1.b.e.a aVar) {
    }

    public void h(a aVar) {
        this.f45991g = aVar;
    }
}
