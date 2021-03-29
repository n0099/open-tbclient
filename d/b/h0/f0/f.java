package d.b.h0.f0;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f50177a = false;

    /* renamed from: b  reason: collision with root package name */
    public static String f50178b;

    /* renamed from: c  reason: collision with root package name */
    public static String f50179c;

    /* renamed from: d  reason: collision with root package name */
    public static String f50180d;

    public static boolean a(Context context) {
        if (!f50177a) {
            j(context);
        }
        return f50177a;
    }

    public static String b() {
        return f50178b;
    }

    public static String c() {
        return f50179c;
    }

    public static String d() {
        return f50180d;
    }

    public static boolean e() {
        return f50177a;
    }

    public static void f(String str) {
        f50178b = str;
    }

    public static void g(boolean z) {
        f50177a = z;
    }

    public static void h(String str) {
        f50179c = str;
    }

    public static void i(String str) {
        f50180d = str;
    }

    public static void j(Context context) {
        if (context != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig(context, true)));
        }
    }
}
