package d.b.h0.f0;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f50176a = false;

    /* renamed from: b  reason: collision with root package name */
    public static String f50177b;

    /* renamed from: c  reason: collision with root package name */
    public static String f50178c;

    /* renamed from: d  reason: collision with root package name */
    public static String f50179d;

    public static boolean a(Context context) {
        if (!f50176a) {
            j(context);
        }
        return f50176a;
    }

    public static String b() {
        return f50177b;
    }

    public static String c() {
        return f50178c;
    }

    public static String d() {
        return f50179d;
    }

    public static boolean e() {
        return f50176a;
    }

    public static void f(String str) {
        f50177b = str;
    }

    public static void g(boolean z) {
        f50176a = z;
    }

    public static void h(String str) {
        f50178c = str;
    }

    public static void i(String str) {
        f50179d = str;
    }

    public static void j(Context context) {
        if (context != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig(context, true)));
        }
    }
}
