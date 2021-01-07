package com.qq.e.comm.plugin.m;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.w.a.d;
import com.qq.e.comm.util.GDTLogger;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class d {
    private static com.qq.e.comm.plugin.ad.f a(View view) {
        if (view == null) {
            return null;
        }
        Rect rect = new Rect();
        if (view.getGlobalVisibleRect(rect)) {
            return new com.qq.e.comm.plugin.ad.f(true, view.getWidth(), view.getHeight(), rect.width(), rect.height(), view.toString());
        }
        GDTLogger.d("Ad is not visible.");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d.b a(int i, int i2, com.qq.e.comm.plugin.s.a aVar, View view, String str, int i3) {
        int integerForPlacement = GDTADManager.getInstance().getSM().getIntegerForPlacement(Constants.KEYS.DownConfirm, aVar.B(), 0);
        com.qq.e.comm.plugin.ad.f fVar = null;
        if (view != null) {
            fVar = a(view);
        } else {
            GDTLogger.e("ExpressAdUtil: AD view is null");
        }
        boolean a2 = com.qq.e.comm.plugin.util.d.a(aVar);
        if (i2 == -1) {
            i2 = (!a2 || com.qq.e.comm.plugin.util.b.d(aVar)) ? 0 : 1;
        }
        if (aVar.a_() == 48) {
            i2 = 48;
        }
        return new d.b(i2, i3 == 2 ? d.c.SysBrowser : d.c.InnerBrowser).a(i).a(str).b(integerForPlacement).a(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str) {
        return com.qq.e.comm.plugin.ad.g.a(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, com.qq.e.comm.plugin.s.a aVar) {
        com.qq.e.comm.plugin.s.c l = aVar.l();
        if (l == null) {
            return;
        }
        String c = l.c();
        if (TextUtils.isEmpty(c)) {
            return;
        }
        new com.qq.e.comm.plugin.ac.e(context).a(c);
    }
}
