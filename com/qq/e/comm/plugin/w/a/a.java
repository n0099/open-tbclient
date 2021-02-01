package com.qq.e.comm.plugin.w.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.plugin.util.ar;
import com.qq.e.comm.plugin.w.a.d;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.GDTLogger;
/* loaded from: classes15.dex */
public class a {
    public static String a(Context context, String str, d.a aVar, d.e eVar) {
        Intent intent = new Intent();
        intent.setClassName(context, ar.a());
        intent.putExtra(ACTD.DELEGATE_NAME_KEY, "innerBrowser");
        intent.putExtra("url", str);
        intent.putExtra("appid", GDTADManager.getInstance().getAppStatus().getAPPID());
        intent.putExtra("clickStartTime", System.currentTimeMillis());
        intent.putExtra(Constants.KEYS.AD_INFO, aVar.f12641a.toString());
        intent.putExtra("posId", eVar.c);
        intent.putExtra("adType", eVar.f12650b.b());
        ai.a("gdt_tag_net", "get url, " + str);
        if (aVar.c != null && !TextUtils.isEmpty(aVar.c.A())) {
            intent.putExtra("reportUrl", aVar.c.A());
        }
        intent.addFlags(268435456);
        context.startActivity(intent);
        GDTLogger.d("Browse with sdk browser");
        u.a(100002, 1, new com.qq.e.comm.plugin.y.c().a(eVar.c).b(aVar.f12641a.optString(Config.CELL_LOCATION)).c(aVar.f12641a.optString("traceid")));
        return "InnerBrowser";
    }
}
