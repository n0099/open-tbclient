package d.a.a0.k.d;

import android.widget.ImageView;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f39128b;

    /* renamed from: a  reason: collision with root package name */
    public c f39129a;

    public b(c cVar) {
        this.f39129a = cVar;
    }

    public static void a(c cVar) {
        if (f39128b == null) {
            synchronized (b.class) {
                if (f39128b == null) {
                    f39128b = new b(cVar);
                }
            }
        }
    }

    public static b c() {
        return f39128b;
    }

    public void b(ImageView imageView, String str) {
        c cVar = this.f39129a;
        if (cVar != null) {
            cVar.a(imageView, str);
        }
    }
}
