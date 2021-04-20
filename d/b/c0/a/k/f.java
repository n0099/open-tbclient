package d.b.c0.a.k;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f43056a = false;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f43057b = false;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f43058c = false;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f43059d = true;

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
            return f43057b;
        }
        if ("permission_storage".equalsIgnoreCase(str)) {
            return f43058c;
        }
        if ("permission_app_list".equalsIgnoreCase(str)) {
            return f43059d;
        }
        if ("permission_read_phone_state".equalsIgnoreCase(str)) {
            return f43056a;
        }
        return false;
    }
}
