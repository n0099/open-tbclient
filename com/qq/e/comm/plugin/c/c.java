package com.qq.e.comm.plugin.c;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.qq.e.ads.cfg.BrowserType;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.plugin.util.ar;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
/* loaded from: classes15.dex */
public class c {
    public static BrowserType a(String str) {
        if (StringUtil.isEmpty(str)) {
            return null;
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        intent.addFlags(268435456);
        Context appContext = GDTADManager.getInstance().getAppContext();
        if (intent.resolveActivity(appContext.getPackageManager()) == null) {
            GDTLogger.w("openWithSystemBrowser fail, can't resolve intent: " + intent);
            return null;
        }
        appContext.startActivity(intent);
        GDTLogger.d("Browse with system browser");
        return BrowserType.Sys;
    }

    public static BrowserType a(String str, com.qq.e.comm.plugin.s.a aVar) {
        if (StringUtil.isEmpty(str)) {
            return null;
        }
        Context appContext = GDTADManager.getInstance().getAppContext();
        Intent intent = new Intent();
        intent.setClassName(appContext, ar.a());
        intent.putExtra(ACTD.DELEGATE_NAME_KEY, "innerBrowser");
        intent.putExtra("url", str);
        intent.putExtra("appid", GDTADManager.getInstance().getAppStatus().getAPPID());
        if (aVar != null) {
            intent.putExtra("clickStartTime", System.currentTimeMillis());
            intent.putExtra(Constants.KEYS.AD_INFO, aVar.E().toString());
            intent.putExtra("posId", aVar.B());
            intent.putExtra("adType", aVar.C().b());
        }
        intent.addFlags(268435456);
        appContext.startActivity(intent);
        GDTLogger.d("Browse with sdk browser");
        return BrowserType.Inner;
    }
}
