package d.b.j0.i0.j;

import android.content.Context;
import android.view.WindowManager;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static a f57167a;

    public static a b() {
        if (f57167a == null) {
            synchronized (a.class) {
                if (f57167a == null) {
                    f57167a = new a();
                }
            }
        }
        return f57167a;
    }

    public void a() {
        f57167a = null;
    }

    public void c(Context context, int i) {
        if (context != null) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            return;
        }
        throw new IllegalArgumentException("context cannot be null");
    }
}
