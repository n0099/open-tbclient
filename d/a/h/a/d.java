package d.a.h.a;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, c> f39944a;

    public static synchronized c a(String str, Context context) {
        synchronized (d.class) {
            if (TextUtils.isEmpty(str)) {
                str = context.getPackageName() + "_preferences";
            }
            if (f39944a == null) {
                f39944a = new HashMap<>();
            }
            if (f39944a.get(str) != null) {
                return f39944a.get(str);
            }
            c cVar = new c(str);
            f39944a.put(str, cVar);
            return cVar;
        }
    }
}
