package d.a.c0.k.d;

import android.widget.ImageView;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f43074b;

    /* renamed from: a  reason: collision with root package name */
    public c f43075a;

    public b(c cVar) {
        this.f43075a = cVar;
    }

    public static void a(c cVar) {
        if (f43074b == null) {
            synchronized (b.class) {
                if (f43074b == null) {
                    f43074b = new b(cVar);
                }
            }
        }
    }

    public static b c() {
        return f43074b;
    }

    public void b(ImageView imageView, String str) {
        c cVar = this.f43075a;
        if (cVar != null) {
            cVar.a(imageView, str);
        }
    }
}
