package d.a.o0.j0.j;

import android.content.Context;
import android.view.WindowManager;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static a f59802a;

    public static a b() {
        if (f59802a == null) {
            synchronized (a.class) {
                if (f59802a == null) {
                    f59802a = new a();
                }
            }
        }
        return f59802a;
    }

    public void a() {
        f59802a = null;
    }

    public void c(Context context, int i2) {
        if (context != null) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            return;
        }
        throw new IllegalArgumentException("context cannot be null");
    }
}
