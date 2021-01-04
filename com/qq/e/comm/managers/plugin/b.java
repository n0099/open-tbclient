package com.qq.e.comm.managers.plugin;

import android.content.Context;
import com.qq.e.comm.util.SystemUtil;
import java.io.File;
/* loaded from: classes3.dex */
final class b {

    /* renamed from: a  reason: collision with root package name */
    private static String f11850a = SystemUtil.buildNewPathByProcessName("e_qq_com_plugin");

    static {
        SystemUtil.buildNewPathByProcessName("e_qq_com_dex");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File a(Context context) {
        return new File(context.getDir(f11850a, 0), "update_lc");
    }
}
