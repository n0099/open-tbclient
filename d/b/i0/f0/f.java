package d.b.i0.f0;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f50920a = false;

    /* renamed from: b  reason: collision with root package name */
    public static String f50921b;

    /* renamed from: c  reason: collision with root package name */
    public static String f50922c;

    /* renamed from: d  reason: collision with root package name */
    public static String f50923d;

    public static boolean a(Context context) {
        if (!f50920a) {
            j(context);
        }
        return f50920a;
    }

    public static String b() {
        return f50921b;
    }

    public static String c() {
        return f50922c;
    }

    public static String d() {
        return f50923d;
    }

    public static boolean e() {
        return f50920a;
    }

    public static void f(String str) {
        f50921b = str;
    }

    public static void g(boolean z) {
        f50920a = z;
    }

    public static void h(String str) {
        f50922c = str;
    }

    public static void i(String str) {
        f50923d = str;
    }

    public static void j(Context context) {
        if (context != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig(context, true)));
        }
    }
}
