package d.b.z.k.d;

import android.widget.ImageView;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f65648b;

    /* renamed from: a  reason: collision with root package name */
    public c f65649a;

    public b(c cVar) {
        this.f65649a = cVar;
    }

    public static void a(c cVar) {
        if (f65648b == null) {
            synchronized (b.class) {
                if (f65648b == null) {
                    f65648b = new b(cVar);
                }
            }
        }
    }

    public static b c() {
        return f65648b;
    }

    public void b(ImageView imageView, String str) {
        c cVar = this.f65649a;
        if (cVar != null) {
            cVar.a(imageView, str);
        }
    }
}
