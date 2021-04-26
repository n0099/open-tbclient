package d.a.h0.g.k0.f.a;

import android.text.TextUtils;
import com.baidu.swan.apps.storage.PathType;
import d.a.h0.a.k;
import d.a.h0.a.r1.d;
import d.a.h0.a.r1.e;
import d.a.h0.g.q.a;
import java.io.File;
/* loaded from: classes3.dex */
public class c {
    static {
        boolean z = k.f43101a;
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
        e p = d.e().p();
        if (p.d() && p.W() != null && (h2 = a.d.h(p.getAppId(), p.W())) != null && h2.exists()) {
            return "file://" + h2.getAbsolutePath();
        }
        return null;
    }
}
