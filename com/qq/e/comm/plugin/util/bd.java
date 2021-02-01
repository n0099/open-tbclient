package com.qq.e.comm.plugin.util;

import android.content.Context;
import android.view.View;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.baidu.fsg.base.activity.BaseActivity;
import yaq.gdtadv;
/* JADX WARN: Classes with same name are omitted:
  assets/yaqgdtadv0.sec
 */
/* loaded from: classes15.dex */
public class bd {
    private static boolean a(Context context) {
        return gdtadv.getZresult(BaseActivity.DIALOG_LOADING, 1, context);
    }

    public static boolean a(Context context, View view, int i) {
        return gdtadv.getZresult(243, 1, context, view, Integer.valueOf(i));
    }

    public static boolean a(Context context, View view, int i, boolean z) {
        return gdtadv.getZresult(GDiffPatcher.COPY_UBYTE_UBYTE, 1, context, view, Integer.valueOf(i), Boolean.valueOf(z));
    }

    public static boolean a(View view) {
        return gdtadv.getZresult(GDiffPatcher.COPY_UBYTE_USHORT, 1, view);
    }

    private static boolean a(View view, int i) {
        return gdtadv.getZresult(246, 1, view, Integer.valueOf(i));
    }

    public static float b(View view) {
        return gdtadv.getFresult(GDiffPatcher.DATA_USHORT, 1, view);
    }
}
