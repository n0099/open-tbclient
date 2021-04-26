package d.a.h.a;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, c> f41015a;

    public static synchronized c a(String str, Context context) {
        synchronized (d.class) {
            if (TextUtils.isEmpty(str)) {
                str = context.getPackageName() + "_preferences";
            }
            if (f41015a == null) {
                f41015a = new HashMap<>();
            }
            if (f41015a.get(str) != null) {
                return f41015a.get(str);
            }
            c cVar = new c(str);
            f41015a.put(str, cVar);
            return cVar;
        }
    }
}
