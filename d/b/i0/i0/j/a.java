package d.b.i0.i0.j;

import android.content.Context;
import android.view.WindowManager;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static a f56746a;

    public static a b() {
        if (f56746a == null) {
            synchronized (a.class) {
                if (f56746a == null) {
                    f56746a = new a();
                }
            }
        }
        return f56746a;
    }

    public void a() {
        f56746a = null;
    }

    public void c(Context context, int i) {
        if (context != null) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            return;
        }
        throw new IllegalArgumentException("context cannot be null");
    }
}
