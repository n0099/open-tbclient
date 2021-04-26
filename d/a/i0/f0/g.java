package d.a.i0.f0;

import android.content.ContentResolver;
import android.net.Uri;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes3.dex */
public class g {
    public static String a() {
        return d.a.i0.r.d0.b.j().h();
    }

    public static ContentResolver b() {
        return d.a.i0.r.d0.b.j().i();
    }

    public static OrmObject c(String str, Class<?> cls) {
        if (str == null || cls == null) {
            return null;
        }
        return OrmObject.objectWithJsonStr(d(str), cls);
    }

    public static String d(String str) {
        return e(Uri.parse(a() + str));
    }

    public static String e(Uri uri) {
        String str;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            str = b().getType(uri);
        } catch (SecurityException e2) {
            BdLog.detailException(e2);
            str = null;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        f.f("getValue uri=" + uri + " Time:" + (currentTimeMillis2 - currentTimeMillis));
        return str;
    }
}
