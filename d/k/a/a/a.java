package d.k.a.a;

import android.content.Context;
import android.os.Environment;
import com.meizu.cloud.pushsdk.base.h;
/* loaded from: classes6.dex */
public class a {
    public static void a(String str, String str2) {
        h.b().a(str, str2);
    }

    public static void b(String str, String str2) {
        h.b().d(str, str2);
    }

    public static void c() {
        h.b().a(false);
    }

    public static void d(String str, String str2) {
        h.b().b(str, str2);
    }

    public static void e(Context context) {
        h.b().a(context);
        h b2 = h.b();
        b2.a(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/pushSdk/" + context.getPackageName());
    }
}
