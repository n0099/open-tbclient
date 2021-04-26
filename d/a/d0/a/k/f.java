package d.a.d0.a.k;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f40620a = false;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f40621b = false;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f40622c = false;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f40623d = true;

    public static boolean a(Context context, String str) {
        try {
            return Build.VERSION.SDK_INT >= 23 ? context.checkSelfPermission(str) == 0 : context.checkCallingOrSelfPermission(str) == 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if ("permission_location".equalsIgnoreCase(str)) {
            return f40621b;
        }
        if ("permission_storage".equalsIgnoreCase(str)) {
            return f40622c;
        }
        if ("permission_app_list".equalsIgnoreCase(str)) {
            return f40623d;
        }
        if ("permission_read_phone_state".equalsIgnoreCase(str)) {
            return f40620a;
        }
        return false;
    }
}
