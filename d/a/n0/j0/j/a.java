package d.a.n0.j0.j;

import android.content.Context;
import android.view.WindowManager;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static a f55988a;

    public static a b() {
        if (f55988a == null) {
            synchronized (a.class) {
                if (f55988a == null) {
                    f55988a = new a();
                }
            }
        }
        return f55988a;
    }

    public void a() {
        f55988a = null;
    }

    public void c(Context context, int i2) {
        if (context != null) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            return;
        }
        throw new IllegalArgumentException("context cannot be null");
    }
}
