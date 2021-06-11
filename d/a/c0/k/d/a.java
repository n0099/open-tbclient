package d.a.c0.k.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
/* loaded from: classes2.dex */
public class a implements c {

    /* renamed from: b  reason: collision with root package name */
    public static a f43069b;

    /* renamed from: c  reason: collision with root package name */
    public static e f43070c;

    /* renamed from: d  reason: collision with root package name */
    public static d.a.c0.k.e.b f43071d;

    /* renamed from: e  reason: collision with root package name */
    public static d.a.c0.k.e.a f43072e;

    /* renamed from: a  reason: collision with root package name */
    public Context f43073a;

    public a(Context context) {
        this.f43073a = context.getApplicationContext();
        f43071d = new d.a.c0.k.e.b();
        f43072e = new d.a.c0.k.e.a(context);
        f43070c = new e();
    }

    public static d.a.c0.k.e.b b() {
        if (f43071d == null) {
            f43071d = new d.a.c0.k.e.b();
        }
        return f43071d;
    }

    public static d.a.c0.k.e.a c(Context context) {
        if (f43072e == null) {
            f43072e = new d.a.c0.k.e.a(context);
        }
        return f43072e;
    }

    public static a e(Context context) {
        if (f43069b == null) {
            synchronized (a.class) {
                if (f43069b == null) {
                    f43069b = new a(context);
                }
            }
        }
        return f43069b;
    }

    @Override // d.a.c0.k.d.c
    public void a(ImageView imageView, String str) {
        d(imageView, str, 0, 0);
    }

    public void d(ImageView imageView, String str, int i2, int i3) {
        imageView.setTag(str);
        Bitmap b2 = f43071d.b(str);
        if (b2 != null) {
            imageView.setImageBitmap(b2);
        } else {
            d.a.c0.m.a.a(new g(this.f43073a, f43070c, str, imageView, i2, i3));
        }
    }
}
