package d.b.h.a;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, c> f43758a;

    public static synchronized c a(String str, Context context) {
        synchronized (d.class) {
            if (TextUtils.isEmpty(str)) {
                str = context.getPackageName() + "_preferences";
            }
            if (f43758a == null) {
                f43758a = new HashMap<>();
            }
            if (f43758a.get(str) != null) {
                return f43758a.get(str);
            }
            c cVar = new c(str);
            f43758a.put(str, cVar);
            return cVar;
        }
    }
}
