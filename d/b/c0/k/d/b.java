package d.b.c0.k.d;

import android.widget.ImageView;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f42580b;

    /* renamed from: a  reason: collision with root package name */
    public c f42581a;

    public b(c cVar) {
        this.f42581a = cVar;
    }

    public static void a(c cVar) {
        if (f42580b == null) {
            synchronized (b.class) {
                if (f42580b == null) {
                    f42580b = new b(cVar);
                }
            }
        }
    }

    public static b c() {
        return f42580b;
    }

    public void b(ImageView imageView, String str) {
        c cVar = this.f42581a;
        if (cVar != null) {
            cVar.a(imageView, str);
        }
    }
}
