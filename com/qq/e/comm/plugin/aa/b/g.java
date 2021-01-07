package com.qq.e.comm.plugin.aa.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.qq.e.comm.managers.GDTADManager;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static String f11995a = "#80000000";

    /* renamed from: b  reason: collision with root package name */
    public static String f11996b = "#40000000";
    public static String c = "#ff8600";
    public static boolean d = true;
    private static Context e = GDTADManager.getInstance().getAppContext();

    public static int a(String str) {
        return e.getResources().getIdentifier(str, "drawable", e.getPackageName());
    }

    public static Bitmap a(Context context) {
        if (d) {
            return a(context, a("gdt_ic_play"));
        }
        return null;
    }

    private static Bitmap a(Context context, int i) {
        return BitmapFactory.decodeResource(context.getResources(), i);
    }

    public static void a(boolean z) {
        d = z;
    }

    public static Bitmap b(Context context) {
        if (d) {
            return a(context, a("gdt_ic_pause"));
        }
        return null;
    }

    public static Bitmap c(Context context) {
        if (d) {
            return a(context, a("gdt_ic_volume_on"));
        }
        return null;
    }

    public static Bitmap d(Context context) {
        if (d) {
            return a(context, a("gdt_ic_volume_off"));
        }
        return null;
    }

    public static Bitmap e(Context context) {
        return a(context, a("gdt_ic_express_close"));
    }

    public static Bitmap f(Context context) {
        return a(context, a("gdt_ic_express_back_to_port"));
    }

    public static Bitmap g(Context context) {
        return a(context, a("gdt_ic_express_volume_on"));
    }

    public static Bitmap h(Context context) {
        return a(context, a("gdt_ic_express_volume_off"));
    }

    public static Bitmap i(Context context) {
        return a(context, a("gdt_ic_express_enter_fullscreen"));
    }

    public static Bitmap j(Context context) {
        return a(context, a("gdt_ic_express_play"));
    }

    public static Bitmap k(Context context) {
        return a(context, a("gdt_ic_express_pause"));
    }
}
