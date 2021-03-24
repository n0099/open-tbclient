package d.b.c0.k.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
/* loaded from: classes2.dex */
public class a implements c {

    /* renamed from: b  reason: collision with root package name */
    public static a f42574b;

    /* renamed from: c  reason: collision with root package name */
    public static e f42575c;

    /* renamed from: d  reason: collision with root package name */
    public static d.b.c0.k.e.b f42576d;

    /* renamed from: e  reason: collision with root package name */
    public static d.b.c0.k.e.a f42577e;

    /* renamed from: a  reason: collision with root package name */
    public Context f42578a;

    public a(Context context) {
        this.f42578a = context.getApplicationContext();
        f42576d = new d.b.c0.k.e.b();
        f42577e = new d.b.c0.k.e.a(context);
        f42575c = new e();
    }

    public static d.b.c0.k.e.b b() {
        if (f42576d == null) {
            f42576d = new d.b.c0.k.e.b();
        }
        return f42576d;
    }

    public static d.b.c0.k.e.a c(Context context) {
        if (f42577e == null) {
            f42577e = new d.b.c0.k.e.a(context);
        }
        return f42577e;
    }

    public static a e(Context context) {
        if (f42574b == null) {
            synchronized (a.class) {
                if (f42574b == null) {
                    f42574b = new a(context);
                }
            }
        }
        return f42574b;
    }

    @Override // d.b.c0.k.d.c
    public void a(ImageView imageView, String str) {
        d(imageView, str, 0, 0);
    }

    public void d(ImageView imageView, String str, int i, int i2) {
        imageView.setTag(str);
        Bitmap b2 = f42576d.b(str);
        if (b2 != null) {
            imageView.setImageBitmap(b2);
        } else {
            d.b.c0.m.a.a(new g(this.f42578a, f42575c, str, imageView, i, i2));
        }
    }
}
