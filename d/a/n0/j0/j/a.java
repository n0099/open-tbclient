package d.a.n0.j0.j;

import android.content.Context;
import android.view.WindowManager;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static a f59677a;

    public static a b() {
        if (f59677a == null) {
            synchronized (a.class) {
                if (f59677a == null) {
                    f59677a = new a();
                }
            }
        }
        return f59677a;
    }

    public void a() {
        f59677a = null;
    }

    public void c(Context context, int i2) {
        if (context != null) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            return;
        }
        throw new IllegalArgumentException("context cannot be null");
    }
}
