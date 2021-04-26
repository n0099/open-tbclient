package d.a.a0.k.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
/* loaded from: classes2.dex */
public class a implements c {

    /* renamed from: b  reason: collision with root package name */
    public static a f39123b;

    /* renamed from: c  reason: collision with root package name */
    public static e f39124c;

    /* renamed from: d  reason: collision with root package name */
    public static d.a.a0.k.e.b f39125d;

    /* renamed from: e  reason: collision with root package name */
    public static d.a.a0.k.e.a f39126e;

    /* renamed from: a  reason: collision with root package name */
    public Context f39127a;

    public a(Context context) {
        this.f39127a = context.getApplicationContext();
        f39125d = new d.a.a0.k.e.b();
        f39126e = new d.a.a0.k.e.a(context);
        f39124c = new e();
    }

    public static d.a.a0.k.e.b b() {
        if (f39125d == null) {
            f39125d = new d.a.a0.k.e.b();
        }
        return f39125d;
    }

    public static d.a.a0.k.e.a c(Context context) {
        if (f39126e == null) {
            f39126e = new d.a.a0.k.e.a(context);
        }
        return f39126e;
    }

    public static a e(Context context) {
        if (f39123b == null) {
            synchronized (a.class) {
                if (f39123b == null) {
                    f39123b = new a(context);
                }
            }
        }
        return f39123b;
    }

    @Override // d.a.a0.k.d.c
    public void a(ImageView imageView, String str) {
        d(imageView, str, 0, 0);
    }

    public void d(ImageView imageView, String str, int i2, int i3) {
        imageView.setTag(str);
        Bitmap b2 = f39125d.b(str);
        if (b2 != null) {
            imageView.setImageBitmap(b2);
        } else {
            d.a.a0.m.a.a(new g(this.f39127a, f39124c, str, imageView, i2, i3));
        }
    }
}
