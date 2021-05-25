package d.m.b.b.d;

import android.content.Context;
/* loaded from: classes7.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static b f66505a;

    public static b a(Context context, String str, int i2, a aVar) {
        if (f66505a == null) {
            synchronized (c.class) {
                if (f66505a == null) {
                    f66505a = com.pgl.sys.ces.b.a(context, str, i2, aVar);
                }
            }
        }
        return f66505a;
    }
}
