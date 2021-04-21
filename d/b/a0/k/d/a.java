package d.b.a0.k.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
/* loaded from: classes2.dex */
public class a implements c {

    /* renamed from: b  reason: collision with root package name */
    public static a f41945b;

    /* renamed from: c  reason: collision with root package name */
    public static e f41946c;

    /* renamed from: d  reason: collision with root package name */
    public static d.b.a0.k.e.b f41947d;

    /* renamed from: e  reason: collision with root package name */
    public static d.b.a0.k.e.a f41948e;

    /* renamed from: a  reason: collision with root package name */
    public Context f41949a;

    public a(Context context) {
        this.f41949a = context.getApplicationContext();
        f41947d = new d.b.a0.k.e.b();
        f41948e = new d.b.a0.k.e.a(context);
        f41946c = new e();
    }

    public static d.b.a0.k.e.b b() {
        if (f41947d == null) {
            f41947d = new d.b.a0.k.e.b();
        }
        return f41947d;
    }

    public static d.b.a0.k.e.a c(Context context) {
        if (f41948e == null) {
            f41948e = new d.b.a0.k.e.a(context);
        }
        return f41948e;
    }

    public static a e(Context context) {
        if (f41945b == null) {
            synchronized (a.class) {
                if (f41945b == null) {
                    f41945b = new a(context);
                }
            }
        }
        return f41945b;
    }

    @Override // d.b.a0.k.d.c
    public void a(ImageView imageView, String str) {
        d(imageView, str, 0, 0);
    }

    public void d(ImageView imageView, String str, int i, int i2) {
        imageView.setTag(str);
        Bitmap b2 = f41947d.b(str);
        if (b2 != null) {
            imageView.setImageBitmap(b2);
        } else {
            d.b.a0.m.a.a(new g(this.f41949a, f41946c, str, imageView, i, i2));
        }
    }
}
