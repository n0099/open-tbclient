package d.m.b.b.d;

import android.content.Context;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static b f65776a;

    public static b a(Context context, String str, int i2, a aVar) {
        if (f65776a == null) {
            synchronized (c.class) {
                if (f65776a == null) {
                    f65776a = com.pgl.sys.ces.b.a(context, str, i2, aVar);
                }
            }
        }
        return f65776a;
    }
}
