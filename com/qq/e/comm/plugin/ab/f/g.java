package com.qq.e.comm.plugin.ab.f;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.plugin.util.az;
import com.qq.e.comm.util.GDTLogger;
import java.io.InputStream;
/* loaded from: classes15.dex */
class g {
    @TargetApi(21)
    public Pair<? extends InputStream, az.a> a(boolean z, Uri uri) {
        if (z) {
            if (com.qq.e.comm.plugin.ab.j.e().a()) {
                return new Pair<>(com.qq.e.comm.plugin.ab.j.e().a(uri), az.c(az.a(uri)));
            }
            ai.a("UnJsWebViewDelegate", "enableProxy == false");
            return null;
        }
        return null;
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str) || az.a(str)) {
            return false;
        }
        try {
            GDTLogger.d("Try to open third party scheme: " + str);
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            GDTADManager.getInstance().getAppContext().startActivity(intent);
            return true;
        } catch (Exception e) {
            GDTLogger.d("Open third party scheme exception: " + e.getMessage());
            com.qq.e.comm.plugin.c.g.a(1, e, (com.qq.e.comm.plugin.y.c) null);
            return true;
        }
    }
}
