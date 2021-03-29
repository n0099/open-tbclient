package d.o.a.d.n;

import android.text.TextUtils;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import d.o.a.d.f.n;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, a> f66785a = Collections.synchronizedMap(new HashMap());

    /* loaded from: classes7.dex */
    public interface a {
        void a();

        void a(String str);
    }

    public static void a(String str) {
        a f2;
        if (TextUtils.isEmpty(str) || (f2 = f(str)) == null) {
            return;
        }
        f2.a();
    }

    public static void b(String str, a aVar) {
        if (TextUtils.isEmpty(str) || aVar == null) {
            return;
        }
        f66785a.put(str, aVar);
    }

    public static void c(String str, String str2) {
        a f2;
        if (TextUtils.isEmpty(str) || (f2 = f(str)) == null) {
            return;
        }
        f2.a(str2);
    }

    public static void d(String[] strArr, a aVar) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        String valueOf = String.valueOf(System.currentTimeMillis());
        b(valueOf, aVar);
        TTDelegateActivity.a(valueOf, strArr);
    }

    public static boolean e(String str) {
        return n.p().a(n.a(), str);
    }

    public static a f(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return f66785a.remove(str);
    }
}
