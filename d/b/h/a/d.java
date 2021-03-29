package d.b.h.a;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, c> f49439a;

    public static synchronized c a(String str, Context context) {
        synchronized (d.class) {
            if (TextUtils.isEmpty(str)) {
                str = context.getPackageName() + "_preferences";
            }
            if (f49439a == null) {
                f49439a = new HashMap<>();
            }
            if (f49439a.get(str) != null) {
                return f49439a.get(str);
            }
            c cVar = new c(str);
            f49439a.put(str, cVar);
            return cVar;
        }
    }
}
