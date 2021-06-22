package d.a.c0.k.d;

import android.widget.ImageView;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f43177b;

    /* renamed from: a  reason: collision with root package name */
    public c f43178a;

    public b(c cVar) {
        this.f43178a = cVar;
    }

    public static void a(c cVar) {
        if (f43177b == null) {
            synchronized (b.class) {
                if (f43177b == null) {
                    f43177b = new b(cVar);
                }
            }
        }
    }

    public static b c() {
        return f43177b;
    }

    public void b(ImageView imageView, String str) {
        c cVar = this.f43178a;
        if (cVar != null) {
            cVar.a(imageView, str);
        }
    }
}
