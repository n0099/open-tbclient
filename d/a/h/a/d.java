package d.a.h.a;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, c> f43690a;

    public static synchronized c a(String str, Context context) {
        synchronized (d.class) {
            if (TextUtils.isEmpty(str)) {
                str = context.getPackageName() + "_preferences";
            }
            if (f43690a == null) {
                f43690a = new HashMap<>();
            }
            if (f43690a.get(str) != null) {
                return f43690a.get(str);
            }
            c cVar = new c(str);
            f43690a.put(str, cVar);
            return cVar;
        }
    }
}
