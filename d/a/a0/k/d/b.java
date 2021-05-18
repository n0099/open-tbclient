package d.a.a0.k.d;

import android.widget.ImageView;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f38373b;

    /* renamed from: a  reason: collision with root package name */
    public c f38374a;

    public b(c cVar) {
        this.f38374a = cVar;
    }

    public static void a(c cVar) {
        if (f38373b == null) {
            synchronized (b.class) {
                if (f38373b == null) {
                    f38373b = new b(cVar);
                }
            }
        }
    }

    public static b c() {
        return f38373b;
    }

    public void b(ImageView imageView, String str) {
        c cVar = this.f38374a;
        if (cVar != null) {
            cVar.a(imageView, str);
        }
    }
}
