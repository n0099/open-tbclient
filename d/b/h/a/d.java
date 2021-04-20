package d.b.h.a;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, c> f49831a;

    public static synchronized c a(String str, Context context) {
        synchronized (d.class) {
            if (TextUtils.isEmpty(str)) {
                str = context.getPackageName() + "_preferences";
            }
            if (f49831a == null) {
                f49831a = new HashMap<>();
            }
            if (f49831a.get(str) != null) {
                return f49831a.get(str);
            }
            c cVar = new c(str);
            f49831a.put(str, cVar);
            return cVar;
        }
    }
}
