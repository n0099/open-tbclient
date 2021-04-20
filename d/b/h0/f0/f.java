package d.b.h0.f0;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f50584a = false;

    /* renamed from: b  reason: collision with root package name */
    public static String f50585b;

    /* renamed from: c  reason: collision with root package name */
    public static String f50586c;

    /* renamed from: d  reason: collision with root package name */
    public static String f50587d;

    public static boolean a(Context context) {
        if (!f50584a) {
            j(context);
        }
        return f50584a;
    }

    public static String b() {
        return f50585b;
    }

    public static String c() {
        return f50586c;
    }

    public static String d() {
        return f50587d;
    }

    public static boolean e() {
        return f50584a;
    }

    public static void f(String str) {
        f50585b = str;
    }

    public static void g(boolean z) {
        f50584a = z;
    }

    public static void h(String str) {
        f50586c = str;
    }

    public static void i(String str) {
        f50587d = str;
    }

    public static void j(Context context) {
        if (context != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig(context, true)));
        }
    }
}
