package d.b.j0.b;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import java.util.Locale;
/* loaded from: classes5.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f63799a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static int f63800b;

    public static String a(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getPackageName());
        sb.append('/');
        sb.append(b(context));
        sb.append(" (Linux; U; Android ");
        sb.append(Build.VERSION.RELEASE);
        sb.append("; ");
        sb.append(Locale.getDefault().toString());
        String str = Build.MODEL;
        if (str.length() > 0) {
            sb.append("; ");
            sb.append(str);
        }
        String str2 = Build.ID;
        if (str2.length() > 0) {
            sb.append("; Build/");
            sb.append(str2);
        }
        sb.append("; TurboNet/");
        sb.append("53.0.2785.116");
        sb.append(')');
        return sb.toString();
    }

    public static int b(Context context) {
        int i;
        synchronized (f63799a) {
            if (f63800b == 0) {
                try {
                    f63800b = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
                } catch (PackageManager.NameNotFoundException unused) {
                    throw new IllegalStateException("Cannot determine package version");
                }
            }
            i = f63800b;
        }
        return i;
    }
}
