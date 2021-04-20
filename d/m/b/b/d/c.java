package d.m.b.b.d;

import android.content.Context;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static b f67300a;

    public static b a(Context context, String str, int i, a aVar) {
        if (f67300a == null) {
            synchronized (c.class) {
                if (f67300a == null) {
                    f67300a = com.pgl.sys.ces.b.a(context, str, i, aVar);
                }
            }
        }
        return f67300a;
    }
}
