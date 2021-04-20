package d.b.z.k.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
/* loaded from: classes2.dex */
public class a implements c {

    /* renamed from: b  reason: collision with root package name */
    public static a f65643b;

    /* renamed from: c  reason: collision with root package name */
    public static e f65644c;

    /* renamed from: d  reason: collision with root package name */
    public static d.b.z.k.e.b f65645d;

    /* renamed from: e  reason: collision with root package name */
    public static d.b.z.k.e.a f65646e;

    /* renamed from: a  reason: collision with root package name */
    public Context f65647a;

    public a(Context context) {
        this.f65647a = context.getApplicationContext();
        f65645d = new d.b.z.k.e.b();
        f65646e = new d.b.z.k.e.a(context);
        f65644c = new e();
    }

    public static d.b.z.k.e.b b() {
        if (f65645d == null) {
            f65645d = new d.b.z.k.e.b();
        }
        return f65645d;
    }

    public static d.b.z.k.e.a c(Context context) {
        if (f65646e == null) {
            f65646e = new d.b.z.k.e.a(context);
        }
        return f65646e;
    }

    public static a e(Context context) {
        if (f65643b == null) {
            synchronized (a.class) {
                if (f65643b == null) {
                    f65643b = new a(context);
                }
            }
        }
        return f65643b;
    }

    @Override // d.b.z.k.d.c
    public void a(ImageView imageView, String str) {
        d(imageView, str, 0, 0);
    }

    public void d(ImageView imageView, String str, int i, int i2) {
        imageView.setTag(str);
        Bitmap b2 = f65645d.b(str);
        if (b2 != null) {
            imageView.setImageBitmap(b2);
        } else {
            d.b.z.m.a.a(new g(this.f65647a, f65644c, str, imageView, i, i2));
        }
    }
}
