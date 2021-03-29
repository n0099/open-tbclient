package d.b.i0.i0.j;

import android.content.Context;
import android.view.WindowManager;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static a f55623a;

    public static a b() {
        if (f55623a == null) {
            synchronized (a.class) {
                if (f55623a == null) {
                    f55623a = new a();
                }
            }
        }
        return f55623a;
    }

    public void a() {
        f55623a = null;
    }

    public void c(Context context, int i) {
        if (context != null) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            return;
        }
        throw new IllegalArgumentException("context cannot be null");
    }
}
