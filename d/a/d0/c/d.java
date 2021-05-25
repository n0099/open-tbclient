package d.a.d0.c;

import android.content.Context;
import android.net.Uri;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
/* loaded from: classes2.dex */
public class d {
    static {
        h e2 = h.e();
        i iVar = new i();
        e2.f("splash_ad", iVar);
        e2.g(iVar);
    }

    public static boolean a(Context context, String str) {
        if (j.g(str)) {
            return d(context, Uri.parse(str));
        }
        return false;
    }

    public static boolean b(Context context, Uri uri, String str) {
        return c(context, uri, str, null);
    }

    public static boolean c(Context context, Uri uri, String str, a aVar) {
        if (context == null) {
            context = c.a();
        }
        h e2 = h.e();
        g gVar = new g(uri, str);
        gVar.i(false);
        return e2.b(context, gVar, aVar);
    }

    public static boolean d(Context context, Uri uri) {
        return b(context, uri, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
    }
}
