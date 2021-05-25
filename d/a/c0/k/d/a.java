package d.a.c0.k.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
/* loaded from: classes2.dex */
public class a implements c {

    /* renamed from: b  reason: collision with root package name */
    public static a f39388b;

    /* renamed from: c  reason: collision with root package name */
    public static e f39389c;

    /* renamed from: d  reason: collision with root package name */
    public static d.a.c0.k.e.b f39390d;

    /* renamed from: e  reason: collision with root package name */
    public static d.a.c0.k.e.a f39391e;

    /* renamed from: a  reason: collision with root package name */
    public Context f39392a;

    public a(Context context) {
        this.f39392a = context.getApplicationContext();
        f39390d = new d.a.c0.k.e.b();
        f39391e = new d.a.c0.k.e.a(context);
        f39389c = new e();
    }

    public static d.a.c0.k.e.b b() {
        if (f39390d == null) {
            f39390d = new d.a.c0.k.e.b();
        }
        return f39390d;
    }

    public static d.a.c0.k.e.a c(Context context) {
        if (f39391e == null) {
            f39391e = new d.a.c0.k.e.a(context);
        }
        return f39391e;
    }

    public static a e(Context context) {
        if (f39388b == null) {
            synchronized (a.class) {
                if (f39388b == null) {
                    f39388b = new a(context);
                }
            }
        }
        return f39388b;
    }

    @Override // d.a.c0.k.d.c
    public void a(ImageView imageView, String str) {
        d(imageView, str, 0, 0);
    }

    public void d(ImageView imageView, String str, int i2, int i3) {
        imageView.setTag(str);
        Bitmap b2 = f39390d.b(str);
        if (b2 != null) {
            imageView.setImageBitmap(b2);
        } else {
            d.a.c0.m.a.a(new g(this.f39392a, f39389c, str, imageView, i2, i3));
        }
    }
}
