package com.qq.e.comm.managers.plugin;

import android.content.Context;
import com.qq.e.comm.util.SystemUtil;
import java.io.File;
/* loaded from: classes7.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static String f35514a = SystemUtil.buildNewPathByProcessName("e_qq_com_plugin");

    /* renamed from: b  reason: collision with root package name */
    public static String f35515b = SystemUtil.buildNewPathByProcessName("e_qq_com_dex");

    public static File a(Context context) {
        return context.getDir(f35515b, 0);
    }

    public static File b(Context context) {
        return new File(i(context), "gdt_plugin.jar");
    }

    public static File c(Context context) {
        return new File(i(context), "gdt_plugin.tmp");
    }

    public static File d(Context context) {
        return new File(i(context), "gdt_plugin.next");
    }

    public static File e(Context context) {
        return new File(i(context), "gdt_plugin.jar.sig");
    }

    public static File f(Context context) {
        return new File(i(context), "gdt_plugin.tmp.sig");
    }

    public static File g(Context context) {
        return new File(i(context), "gdt_plugin.next.sig");
    }

    public static File h(Context context) {
        return new File(i(context), "update_lc");
    }

    public static File i(Context context) {
        return context.getDir(f35514a, 0);
    }
}
