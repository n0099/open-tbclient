package d.m.b.b.d;

import android.content.Context;
/* loaded from: classes7.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static b f70395a;

    public static b a(Context context, String str, int i2, a aVar) {
        if (f70395a == null) {
            synchronized (c.class) {
                if (f70395a == null) {
                    f70395a = com.pgl.sys.ces.b.a(context, str, i2, aVar);
                }
            }
        }
        return f70395a;
    }
}
