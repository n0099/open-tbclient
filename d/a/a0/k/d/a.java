package d.a.a0.k.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
/* loaded from: classes2.dex */
public class a implements c {

    /* renamed from: b  reason: collision with root package name */
    public static a f38368b;

    /* renamed from: c  reason: collision with root package name */
    public static e f38369c;

    /* renamed from: d  reason: collision with root package name */
    public static d.a.a0.k.e.b f38370d;

    /* renamed from: e  reason: collision with root package name */
    public static d.a.a0.k.e.a f38371e;

    /* renamed from: a  reason: collision with root package name */
    public Context f38372a;

    public a(Context context) {
        this.f38372a = context.getApplicationContext();
        f38370d = new d.a.a0.k.e.b();
        f38371e = new d.a.a0.k.e.a(context);
        f38369c = new e();
    }

    public static d.a.a0.k.e.b b() {
        if (f38370d == null) {
            f38370d = new d.a.a0.k.e.b();
        }
        return f38370d;
    }

    public static d.a.a0.k.e.a c(Context context) {
        if (f38371e == null) {
            f38371e = new d.a.a0.k.e.a(context);
        }
        return f38371e;
    }

    public static a e(Context context) {
        if (f38368b == null) {
            synchronized (a.class) {
                if (f38368b == null) {
                    f38368b = new a(context);
                }
            }
        }
        return f38368b;
    }

    @Override // d.a.a0.k.d.c
    public void a(ImageView imageView, String str) {
        d(imageView, str, 0, 0);
    }

    public void d(ImageView imageView, String str, int i2, int i3) {
        imageView.setTag(str);
        Bitmap b2 = f38370d.b(str);
        if (b2 != null) {
            imageView.setImageBitmap(b2);
        } else {
            d.a.a0.m.a.a(new g(this.f38372a, f38369c, str, imageView, i2, i3));
        }
    }
}
