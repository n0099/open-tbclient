package d.b.c0.k.d;

import android.widget.ImageView;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f42579b;

    /* renamed from: a  reason: collision with root package name */
    public c f42580a;

    public b(c cVar) {
        this.f42580a = cVar;
    }

    public static void a(c cVar) {
        if (f42579b == null) {
            synchronized (b.class) {
                if (f42579b == null) {
                    f42579b = new b(cVar);
                }
            }
        }
    }

    public static b c() {
        return f42579b;
    }

    public void b(ImageView imageView, String str) {
        c cVar = this.f42580a;
        if (cVar != null) {
            cVar.a(imageView, str);
        }
    }
}
