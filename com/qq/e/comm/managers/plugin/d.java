package com.qq.e.comm.managers.plugin;

import android.content.Context;
import com.qq.e.comm.util.SystemUtil;
import java.io.File;
/* loaded from: classes4.dex */
final class d {

    /* renamed from: a  reason: collision with root package name */
    private static String f7569a = SystemUtil.buildNewPathByProcessName("e_qq_com_plugin");
    private static String b = SystemUtil.buildNewPathByProcessName("e_qq_com_dex");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File a(Context context) {
        return context.getDir(b, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File b(Context context) {
        return new File(i(context), "gdt_plugin.jar");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File c(Context context) {
        return new File(i(context), "gdt_plugin.tmp");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File d(Context context) {
        return new File(i(context), "gdt_plugin.next");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File e(Context context) {
        return new File(i(context), "gdt_plugin.jar.sig");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File f(Context context) {
        return new File(i(context), "gdt_plugin.tmp.sig");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File g(Context context) {
        return new File(i(context), "gdt_plugin.next.sig");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File h(Context context) {
        return new File(i(context), "update_lc");
    }

    private static File i(Context context) {
        return context.getDir(f7569a, 0);
    }
}
