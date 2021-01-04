package com.qq.e.comm.plugin.y;

import android.os.Build;
import android.util.Pair;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobstat.Config;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.SM;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.plugin.util.ab;
import com.qq.e.comm.plugin.util.aj;
import com.qq.e.comm.plugin.util.al;
import com.qq.e.comm.plugin.util.av;
import com.qq.e.comm.util.StringUtil;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import org.json.JSONObject;
import yaq.gdtadv;
/* JADX WARN: Classes with same name are omitted:
  assets/yaqgdtadv0.sec
 */
/* loaded from: classes3.dex */
class j {

    /* renamed from: a  reason: collision with root package name */
    private static final String f13006a = UUID.randomUUID().toString();

    /* loaded from: classes3.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private JSONObject f13007a;

        a() {
            com.qq.e.comm.plugin.util.u uVar = new com.qq.e.comm.plugin.util.u();
            uVar.a(Config.INPUT_DEF_PKG, GDTADManager.getInstance().getAppStatus().getAPPName());
            uVar.a("av", GDTADManager.getInstance().getAppStatus().getAPPVersion());
            uVar.a("sv", SDKStatus.getSDKVersion());
            uVar.a("plv", GDTADManager.getInstance().getPM().getPluginVersion());
            uVar.a("sdk_st", aj.a());
            uVar.a("sdk_pt", 1);
            SM sm = GDTADManager.getInstance().getSM();
            if (sm != null && 1 == sm.getInteger("support_servers_upload_qadid", 0)) {
                uVar.a("qaid", al.a(GDTADManager.getInstance().getAppContext()));
            }
            uVar.a("ov", Build.VERSION.RELEASE);
            uVar.a("al", Build.VERSION.SDK_INT);
            uVar.a("os", 2);
            uVar.a("imei", com.qq.e.comm.plugin.h.b.IMEI.a().a(GDTADManager.getInstance().getAppContext()));
            uVar.a("st", 2);
            uVar.a("muid", com.qq.e.comm.plugin.util.o.l());
            uVar.a(IXAdRequestInfo.TEST_MODE, Build.MODEL);
            uVar.a(Config.PROCESS_LABEL, Build.FINGERPRINT);
            uVar.a("mn", Build.PRODUCT);
            Pair<Integer, Integer> a2 = com.qq.e.comm.plugin.util.o.a();
            if (((Integer) a2.first).intValue() > ((Integer) a2.second).intValue()) {
                uVar.a("w", a2.second);
                uVar.a("h", a2.first);
            } else {
                uVar.a("w", a2.first);
                uVar.a("h", a2.second);
            }
            uVar.a("lid", j.b());
            this.f13007a = uVar.a();
        }

        com.qq.e.comm.plugin.util.u a() {
            com.qq.e.comm.plugin.util.u uVar = new com.qq.e.comm.plugin.util.u();
            uVar.a("ts", System.currentTimeMillis());
            uVar.a("app", GDTADManager.getInstance().getAppStatus().getAPPID());
            uVar.a(Config.EXCEPTION_CRASH_TYPE, GDTADManager.getInstance().getDeviceStatus().getNetworkType().getConnValue());
            String a2 = ab.a();
            if (!StringUtil.isEmpty(a2)) {
                uVar.a("cell_native", a2);
            }
            uVar.a("lg", Locale.getDefault().getLanguage());
            uVar.a("tz", TimeZone.getDefault().getID());
            uVar.a("ca", com.qq.e.comm.plugin.util.o.e(GDTADManager.getInstance().getAppContext()));
            Iterator<String> keys = this.f13007a.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                uVar.a(next, this.f13007a.opt(next));
            }
            av.a(uVar, "/log or /event");
            return uVar;
        }
    }

    /* loaded from: classes3.dex */
    private static final class b {

        /* renamed from: a  reason: collision with root package name */
        private static final a f13008a = new a();
    }

    public static com.qq.e.comm.plugin.util.u a() {
        return (com.qq.e.comm.plugin.util.u) gdtadv.getobjresult(146, 1, new Object[0]);
    }

    static /* synthetic */ String b() {
        return (String) gdtadv.getobjresult(147, 1, new Object[0]);
    }
}
