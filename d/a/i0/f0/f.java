package d.a.i0.f0;

import android.content.Context;
import android.util.Log;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f48499a = false;

    /* renamed from: b  reason: collision with root package name */
    public static String f48500b;

    /* renamed from: c  reason: collision with root package name */
    public static String f48501c;

    /* renamed from: d  reason: collision with root package name */
    public static String f48502d;

    public static boolean a(Context context) {
        if (!f48499a) {
            k(context);
        }
        return f48499a;
    }

    public static String b() {
        return f48500b;
    }

    public static String c() {
        return f48501c;
    }

    public static String d() {
        return f48502d;
    }

    public static boolean e() {
        return f48499a;
    }

    public static void f(String str) {
        if (TbadkCoreApplication.getInst().isDebugMode()) {
            Log.e("MutiProcess", str);
        }
    }

    public static void g(String str) {
        f48500b = str;
    }

    public static void h(boolean z) {
        f48499a = z;
    }

    public static void i(String str) {
        f48501c = str;
    }

    public static void j(String str) {
        f48502d = str;
    }

    public static void k(Context context) {
        if (context != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig(context, true)));
        }
    }
}
