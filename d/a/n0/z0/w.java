package d.a.n0.z0;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.PermissionUtil;
import java.lang.reflect.Field;
import tbclient.CommonReq;
/* loaded from: classes3.dex */
public class w {
    public static void a(Object obj, boolean z) {
        b(obj, z, false);
    }

    public static void b(Object obj, boolean z, boolean z2) {
        c(obj, z, z2, false);
    }

    public static void c(Object obj, boolean z, boolean z2, boolean z3) {
        if (obj == null) {
            return;
        }
        try {
            Field field = obj.getClass().getField("common");
            int i2 = 1;
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            CommonReq.Builder builder = new CommonReq.Builder();
            builder._client_type = 2;
            builder._client_version = TbConfig.getVersion();
            builder._client_id = TbadkCoreApplication.getClientId();
            if (!TextUtils.isEmpty(TbConfig.getSubappType())) {
                builder.subapp_type = TbConfig.getSubappType();
            }
            if (!TbadkCoreApplication.getInst().isOfficial()) {
                builder.apid = "sw";
            }
            builder._phone_imei = TbadkCoreApplication.getInst().getImei();
            builder.from = TbadkCoreApplication.getFrom();
            builder.cuid = TbadkCoreApplication.getInst().getCuid();
            builder.cuid_galaxy2 = TbadkCoreApplication.getInst().getCuidGalaxy2();
            builder.c3_aid = TbadkCoreApplication.getInst().getCuidGalaxy3();
            builder.cuid_gid = TbadkCoreApplication.getInst().getCuidGid();
            builder._timestamp = Long.valueOf(System.currentTimeMillis());
            builder.model = Build.MODEL;
            builder._os_version = Build.VERSION.RELEASE;
            builder.brand = Build.BRAND;
            if (z) {
                if (!TbadkCoreApplication.getInst().isMainProcess(false)) {
                    builder.BDUSS = d.a.n0.f0.f.b();
                    if (!StringUtils.isNull(d.a.n0.f0.f.c())) {
                        builder.stoken = d.a.n0.f0.f.c();
                    }
                } else {
                    AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                    if (currentAccountInfo != null) {
                        builder.BDUSS = currentAccountInfo.getBDUSS();
                        String a2 = d.a.n0.r.l.e.a(currentAccountInfo);
                        if (!StringUtils.isNull(a2)) {
                            builder.stoken = a2;
                        }
                    }
                }
            }
            if (z2) {
                if (!TbadkCoreApplication.getInst().isMainProcess(false)) {
                    builder.tbs = d.a.n0.f0.f.d();
                } else {
                    builder.tbs = TbadkCoreApplication.getInst().getTbs();
                }
            }
            if (z3) {
                builder.applist = TbadkCoreApplication.getInst().getInstalledAppIds();
            }
            builder.pversion = "1.0.3";
            builder.lego_lib_version = TbConfig.getLegoLibVersion();
            if (d.a.n0.r.d0.b.j().k("android_safe_sdk_open", 0) == 1) {
                builder.z_id = TbadkCoreApplication.getInst().getZid();
            }
            builder.net_type = Integer.valueOf(d.a.c.e.p.j.I());
            builder.oaid = PermissionUtil.getLastCachedOid(TbadkCoreApplication.getInst());
            builder.sample_id = TbSingleton.getInstance().getSampleId();
            builder.is_teenager = Integer.valueOf(d.a.n0.c1.b.e.d() ? 1 : 0);
            builder.sdk_ver = TbadkCoreApplication.getInst().getSdk_ver();
            builder.framework_ver = TbadkCoreApplication.getInst().getFramework_ver();
            builder.swan_game_ver = TbadkCoreApplication.getInst().getSwan_game_ver();
            builder.q_type = Integer.valueOf(d.a.n0.r.k.c().e());
            builder.scr_h = Integer.valueOf(d.a.c.e.p.l.i(TbadkCoreApplication.getInst()));
            builder.scr_w = Integer.valueOf(d.a.c.e.p.l.k(TbadkCoreApplication.getInst()));
            builder.scr_dip = Double.valueOf(d.a.c.e.p.l.h(TbadkCoreApplication.getInst()));
            builder.active_timestamp = Long.valueOf(TbSingleton.getInstance().getActiveTimeStamp());
            builder.first_install_time = Long.valueOf(TbSingleton.getInstance().getAppFirstInstallTime());
            builder.last_update_time = Long.valueOf(TbSingleton.getInstance().getAppLastUpdateTime());
            builder.event_day = TbSingleton.getInstance().getData();
            builder.android_id = TbadkCoreApplication.getInst().getAndroidId();
            if (!PermissionUtil.isAgreePrivacyPolicy()) {
                i2 = 2;
            }
            builder.cmode = Integer.valueOf(i2);
            field.set(obj, builder.build(false));
        } catch (Throwable th) {
            if (BdLog.isDebugMode()) {
                th.printStackTrace();
            }
        }
    }
}
