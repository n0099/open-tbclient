package d.b.h0.f0;

import android.content.ContentResolver;
import android.net.Uri;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes3.dex */
public class g {
    public static String a() {
        return d.b.h0.r.d0.b.j().h();
    }

    public static ContentResolver b() {
        return d.b.h0.r.d0.b.j().i();
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
        try {
            return b().getType(uri);
        } catch (SecurityException e2) {
            BdLog.detailException(e2);
            return null;
        }
    }
}
