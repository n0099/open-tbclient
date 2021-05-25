package d.a.m0.f0;

import android.content.Context;
import android.util.Log;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f49371a = false;

    /* renamed from: b  reason: collision with root package name */
    public static String f49372b;

    /* renamed from: c  reason: collision with root package name */
    public static String f49373c;

    /* renamed from: d  reason: collision with root package name */
    public static String f49374d;

    public static boolean a(Context context) {
        if (!f49371a) {
            k(context);
        }
        return f49371a;
    }

    public static String b() {
        return f49372b;
    }

    public static String c() {
        return f49373c;
    }

    public static String d() {
        return f49374d;
    }

    public static boolean e() {
        return f49371a;
    }

    public static void f(String str) {
        if (TbadkCoreApplication.getInst().isDebugMode()) {
            Log.e("MutiProcess", str);
        }
    }

    public static void g(String str) {
        f49372b = str;
    }

    public static void h(boolean z) {
        f49371a = z;
    }

    public static void i(String str) {
        f49373c = str;
    }

    public static void j(String str) {
        f49374d = str;
    }

    public static void k(Context context) {
        if (context != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig(context, true)));
        }
    }
}
