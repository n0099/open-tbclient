package d.a.n0.f0;

import android.content.Context;
import android.util.Log;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f53152a = false;

    /* renamed from: b  reason: collision with root package name */
    public static String f53153b;

    /* renamed from: c  reason: collision with root package name */
    public static String f53154c;

    /* renamed from: d  reason: collision with root package name */
    public static String f53155d;

    public static boolean a(Context context) {
        if (!f53152a) {
            k(context);
        }
        return f53152a;
    }

    public static String b() {
        return f53153b;
    }

    public static String c() {
        return f53154c;
    }

    public static String d() {
        return f53155d;
    }

    public static boolean e() {
        return f53152a;
    }

    public static void f(String str) {
        if (TbadkCoreApplication.getInst().isDebugMode()) {
            Log.e("MutiProcess", str);
        }
    }

    public static void g(String str) {
        f53153b = str;
    }

    public static void h(boolean z) {
        f53152a = z;
    }

    public static void i(String str) {
        f53154c = str;
    }

    public static void j(String str) {
        f53155d = str;
    }

    public static void k(Context context) {
        if (context != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig(context, true)));
        }
    }
}
