package d.a.c0.k.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
/* loaded from: classes2.dex */
public class a implements c {

    /* renamed from: b  reason: collision with root package name */
    public static a f43172b;

    /* renamed from: c  reason: collision with root package name */
    public static e f43173c;

    /* renamed from: d  reason: collision with root package name */
    public static d.a.c0.k.e.b f43174d;

    /* renamed from: e  reason: collision with root package name */
    public static d.a.c0.k.e.a f43175e;

    /* renamed from: a  reason: collision with root package name */
    public Context f43176a;

    public a(Context context) {
        this.f43176a = context.getApplicationContext();
        f43174d = new d.a.c0.k.e.b();
        f43175e = new d.a.c0.k.e.a(context);
        f43173c = new e();
    }

    public static d.a.c0.k.e.b b() {
        if (f43174d == null) {
            f43174d = new d.a.c0.k.e.b();
        }
        return f43174d;
    }

    public static d.a.c0.k.e.a c(Context context) {
        if (f43175e == null) {
            f43175e = new d.a.c0.k.e.a(context);
        }
        return f43175e;
    }

    public static a e(Context context) {
        if (f43172b == null) {
            synchronized (a.class) {
                if (f43172b == null) {
                    f43172b = new a(context);
                }
            }
        }
        return f43172b;
    }

    @Override // d.a.c0.k.d.c
    public void a(ImageView imageView, String str) {
        d(imageView, str, 0, 0);
    }

    public void d(ImageView imageView, String str, int i2, int i3) {
        imageView.setTag(str);
        Bitmap b2 = f43174d.b(str);
        if (b2 != null) {
            imageView.setImageBitmap(b2);
        } else {
            d.a.c0.m.a.a(new g(this.f43176a, f43173c, str, imageView, i2, i3));
        }
    }
}
