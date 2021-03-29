package d.b.g0.g.k0.f.a;

import android.text.TextUtils;
import com.baidu.swan.apps.storage.PathType;
import d.b.g0.a.k;
import d.b.g0.a.r1.d;
import d.b.g0.a.r1.e;
import d.b.g0.g.q.a;
import java.io.File;
/* loaded from: classes3.dex */
public class c {
    static {
        boolean z = k.f45051a;
    }

    public static PathType a(String str) {
        if (TextUtils.isEmpty(str)) {
            return PathType.ERROR;
        }
        if (!str.startsWith("http://") && !str.startsWith("https://")) {
            return PathType.RELATIVE;
        }
        return PathType.NETWORK;
    }

    public static String b() {
        File h2;
        e s = d.e().s();
        if (s.d() && s.W() != null && (h2 = a.d.h(s.getAppId(), s.W())) != null && h2.exists()) {
            return "file://" + h2.getAbsolutePath();
        }
        return null;
    }
}
