package d.a.t.a.b;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.lcp.sdk.client.bean.BLCPRequest;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import d.a.t.a.h.f;
/* loaded from: classes2.dex */
public class a {
    public static void a(Context context, String str, String str2, int i2) {
        c.f().c(context, str, str2, i2, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE);
    }

    public static int b() {
        return c.g();
    }

    public static void c(@NonNull BLCPRequest bLCPRequest, @Nullable d.a.t.a.b.d.b bVar) {
        c.f().h(bLCPRequest, bVar);
    }

    public static boolean d(Context context) {
        return f.m(context);
    }

    public static void e() {
        c.f().i();
    }
}
