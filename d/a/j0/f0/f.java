package d.a.j0.f0;

import android.content.Context;
import android.util.Log;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f49327a = false;

    /* renamed from: b  reason: collision with root package name */
    public static String f49328b;

    /* renamed from: c  reason: collision with root package name */
    public static String f49329c;

    /* renamed from: d  reason: collision with root package name */
    public static String f49330d;

    public static boolean a(Context context) {
        if (!f49327a) {
            k(context);
        }
        return f49327a;
    }

    public static String b() {
        return f49328b;
    }

    public static String c() {
        return f49329c;
    }

    public static String d() {
        return f49330d;
    }

    public static boolean e() {
        return f49327a;
    }

    public static void f(String str) {
        if (TbadkCoreApplication.getInst().isDebugMode()) {
            Log.e("MutiProcess", str);
        }
    }

    public static void g(String str) {
        f49328b = str;
    }

    public static void h(boolean z) {
        f49327a = z;
    }

    public static void i(String str) {
        f49329c = str;
    }

    public static void j(String str) {
        f49330d = str;
    }

    public static void k(Context context) {
        if (context != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig(context, true)));
        }
    }
}
