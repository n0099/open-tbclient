package d.b.c0.k.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
/* loaded from: classes2.dex */
public class a implements c {

    /* renamed from: b  reason: collision with root package name */
    public static a f42575b;

    /* renamed from: c  reason: collision with root package name */
    public static e f42576c;

    /* renamed from: d  reason: collision with root package name */
    public static d.b.c0.k.e.b f42577d;

    /* renamed from: e  reason: collision with root package name */
    public static d.b.c0.k.e.a f42578e;

    /* renamed from: a  reason: collision with root package name */
    public Context f42579a;

    public a(Context context) {
        this.f42579a = context.getApplicationContext();
        f42577d = new d.b.c0.k.e.b();
        f42578e = new d.b.c0.k.e.a(context);
        f42576c = new e();
    }

    public static d.b.c0.k.e.b b() {
        if (f42577d == null) {
            f42577d = new d.b.c0.k.e.b();
        }
        return f42577d;
    }

    public static d.b.c0.k.e.a c(Context context) {
        if (f42578e == null) {
            f42578e = new d.b.c0.k.e.a(context);
        }
        return f42578e;
    }

    public static a e(Context context) {
        if (f42575b == null) {
            synchronized (a.class) {
                if (f42575b == null) {
                    f42575b = new a(context);
                }
            }
        }
        return f42575b;
    }

    @Override // d.b.c0.k.d.c
    public void a(ImageView imageView, String str) {
        d(imageView, str, 0, 0);
    }

    public void d(ImageView imageView, String str, int i, int i2) {
        imageView.setTag(str);
        Bitmap b2 = f42577d.b(str);
        if (b2 != null) {
            imageView.setImageBitmap(b2);
        } else {
            d.b.c0.m.a.a(new g(this.f42579a, f42576c, str, imageView, i, i2));
        }
    }
}
