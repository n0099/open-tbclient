package d.a.c0.k.d;

import android.widget.ImageView;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f39393b;

    /* renamed from: a  reason: collision with root package name */
    public c f39394a;

    public b(c cVar) {
        this.f39394a = cVar;
    }

    public static void a(c cVar) {
        if (f39393b == null) {
            synchronized (b.class) {
                if (f39393b == null) {
                    f39393b = new b(cVar);
                }
            }
        }
    }

    public static b c() {
        return f39393b;
    }

    public void b(ImageView imageView, String str) {
        c cVar = this.f39394a;
        if (cVar != null) {
            cVar.a(imageView, str);
        }
    }
}
