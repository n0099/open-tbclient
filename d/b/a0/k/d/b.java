package d.b.a0.k.d;

import android.widget.ImageView;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f41950b;

    /* renamed from: a  reason: collision with root package name */
    public c f41951a;

    public b(c cVar) {
        this.f41951a = cVar;
    }

    public static void a(c cVar) {
        if (f41950b == null) {
            synchronized (b.class) {
                if (f41950b == null) {
                    f41950b = new b(cVar);
                }
            }
        }
    }

    public static b c() {
        return f41950b;
    }

    public void b(ImageView imageView, String str) {
        c cVar = this.f41951a;
        if (cVar != null) {
            cVar.a(imageView, str);
        }
    }
}
