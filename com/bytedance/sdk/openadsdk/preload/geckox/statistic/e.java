package com.bytedance.sdk.openadsdk.preload.geckox.statistic;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.webkit.internal.ABTestConstants;
import com.bytedance.sdk.openadsdk.preload.geckox.model.Common;
import com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.StatisticModel;
import com.bytedance.sdk.openadsdk.preload.geckox.utils.i;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class e {
    public static void a(com.bytedance.sdk.openadsdk.preload.geckox.b bVar, b bVar2) {
        StatisticModel b = b(bVar, bVar2);
        if (b != null && b.packages != null) {
            a p = bVar.p();
            if (p != null) {
                try {
                    for (StatisticModel.PackageStatisticModel packageStatisticModel : b.packages) {
                        p.a("geckosdk_update_stats", a(packageStatisticModel, b.f5100common));
                    }
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "UploadStatistic.upload:", th);
                }
            }
            if (bVar.c()) {
                String a2 = com.bytedance.sdk.openadsdk.preload.geckox.c.b.a().b().a(b);
                if (!TextUtils.isEmpty(a2)) {
                    a(bVar, a2);
                }
            }
        }
    }

    public static void a(com.bytedance.sdk.openadsdk.preload.geckox.b bVar, com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.b bVar2) {
        a p = bVar.p();
        if (p != null) {
            try {
                p.a("geckosdk_query_pkgs", b(bVar, bVar2));
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "UploadStatistic.upload:", th);
            }
        }
    }

    private static void a(final com.bytedance.sdk.openadsdk.preload.geckox.b bVar, final String str) {
        final String str2 = SapiUtils.COOKIE_HTTPS_URL_PREFIX + bVar.i() + "/gecko/server/packages/stats";
        bVar.f().execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.preload.geckox.statistic.e.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.preload.geckox.i.c a2;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < 3) {
                        try {
                            a2 = com.bytedance.sdk.openadsdk.preload.geckox.b.this.h().a(str2, str);
                        } catch (Exception e) {
                            com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "upload statistic:", e);
                        }
                        if (a2.c != 200) {
                            throw new NetworkErrorException("net work get failed, code: " + a2.c + ", url:" + str2);
                            break;
                        } else if (new JSONObject(a2.b).getInt("status") != 0) {
                            i = i2 + 1;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        });
    }

    private static JSONObject a(StatisticModel.PackageStatisticModel packageStatisticModel, Common common2) throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("params_for_special", "gecko");
        jSONObject.put("region", common2.region);
        jSONObject.put("err_code", packageStatisticModel.errCode);
        jSONObject.put("err_msg", packageStatisticModel.errMsg);
        jSONObject.put(SapiContext.KEY_SDK_VERSION, common2.sdkVersion);
        jSONObject.put("access_key", packageStatisticModel.accessKey);
        jSONObject.put("stats_type", packageStatisticModel.statsType);
        jSONObject.put("device_id", common2.deviceId);
        jSONObject.put("patch_id", packageStatisticModel.patchId == null ? 0L : packageStatisticModel.patchId.longValue());
        jSONObject.put("group_name", packageStatisticModel.groupName);
        jSONObject.put("os", common2.os);
        jSONObject.put("app_version", common2.appVersion);
        jSONObject.put("device_model", common2.deviceModel);
        jSONObject.put("channel", packageStatisticModel.channel);
        jSONObject.put("id", packageStatisticModel.id == null ? 0L : packageStatisticModel.id.longValue());
        jSONObject.put("ac", common2.ac);
        jSONObject.put("download_retry_times", packageStatisticModel.downloadRetryTimes == null ? 0 : packageStatisticModel.downloadRetryTimes.intValue());
        jSONObject.put("download_url", packageStatisticModel.downloadUrl == null ? "" : packageStatisticModel.downloadUrl);
        jSONObject.put("download_duration", packageStatisticModel.downloadDuration);
        jSONObject.put("download_fail_records", packageStatisticModel.downloadFailRecords == null ? "" : packageStatisticModel.downloadFailRecords);
        jSONObject.put("log_id", packageStatisticModel.logId);
        jSONObject.put("active_check_duration", packageStatisticModel.activeCheckDuration == null ? 0L : packageStatisticModel.activeCheckDuration.longValue());
        jSONObject.put("apply_duration", packageStatisticModel.applyDuration != null ? packageStatisticModel.applyDuration.longValue() : 0L);
        return jSONObject;
    }

    private static JSONObject b(com.bytedance.sdk.openadsdk.preload.geckox.b bVar, com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.b bVar2) throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("params_for_special", "gecko");
        jSONObject.put("device_id", bVar.q());
        jSONObject.put("os", 0);
        jSONObject.put("app_version", bVar.n());
        jSONObject.put("api_version", "v3");
        jSONObject.put("aid", bVar.j());
        jSONObject.put("x_tt_logid", bVar2.e);
        jSONObject.put("http_status", bVar2.g);
        jSONObject.put("err_msg", bVar2.d);
        if (TextUtils.isEmpty(bVar2.e)) {
            jSONObject.put("deployments_info", bVar2.b);
            jSONObject.put("local_info", bVar2.f5102a);
            jSONObject.put("custom_info", bVar2.c);
        } else {
            jSONObject.put("deployments_info", "");
            jSONObject.put("local_info", "");
            jSONObject.put("custom_info", "");
        }
        jSONObject.put("os_version", Build.VERSION.SDK_INT + "");
        jSONObject.put("device_platform", HttpConstants.OS_TYPE_VALUE);
        jSONObject.put("device_model", Build.MODEL);
        jSONObject.put("ac", bVar2.f);
        return jSONObject;
    }

    private static StatisticModel b(com.bytedance.sdk.openadsdk.preload.geckox.b bVar, b bVar2) {
        ArrayList<StatisticModel.PackageStatisticModel> arrayList = new ArrayList();
        for (com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a aVar : bVar2.a()) {
            if (aVar.d != null || aVar.f != 0) {
                if (aVar.h && aVar.i) {
                    StatisticModel.PackageStatisticModel packageStatisticModel = new StatisticModel.PackageStatisticModel();
                    arrayList.add(packageStatisticModel);
                    packageStatisticModel.statsType = 100;
                    packageStatisticModel.groupName = aVar.b;
                    packageStatisticModel.accessKey = aVar.f5101a;
                    packageStatisticModel.channel = aVar.c;
                    packageStatisticModel.ac = aVar.p;
                    packageStatisticModel.id = aVar.r;
                    packageStatisticModel.patchId = aVar.q;
                    packageStatisticModel.downloadRetryTimes = a(aVar.e);
                    packageStatisticModel.downloadUrl = aVar.d;
                    packageStatisticModel.downloadFailRecords = b(aVar.e);
                    packageStatisticModel.downloadDuration = Long.valueOf(aVar.g - aVar.f);
                    if (!aVar.j) {
                        StatisticModel.PackageStatisticModel packageStatisticModel2 = new StatisticModel.PackageStatisticModel();
                        arrayList.add(packageStatisticModel2);
                        packageStatisticModel2.statsType = 100;
                        packageStatisticModel2.channel = aVar.c;
                        packageStatisticModel2.errCode = "403";
                        packageStatisticModel2.errMsg = aVar.t;
                        packageStatisticModel2.ac = aVar.p;
                        packageStatisticModel2.patchId = aVar.q;
                        packageStatisticModel2.id = aVar.r;
                        packageStatisticModel2.downloadRetryTimes = a(aVar.e);
                        packageStatisticModel2.downloadUrl = aVar.d;
                        packageStatisticModel2.downloadFailRecords = b(aVar.e);
                        a(aVar, bVar, bVar2, arrayList);
                    } else if (aVar.k) {
                        StatisticModel.PackageStatisticModel packageStatisticModel3 = new StatisticModel.PackageStatisticModel();
                        arrayList.add(packageStatisticModel3);
                        packageStatisticModel3.accessKey = aVar.f5101a;
                        packageStatisticModel3.groupName = aVar.b;
                        packageStatisticModel3.statsType = 102;
                        packageStatisticModel3.patchId = aVar.q;
                        packageStatisticModel3.id = aVar.r;
                        packageStatisticModel3.channel = aVar.c;
                        packageStatisticModel3.activeCheckDuration = Long.valueOf(aVar.n - aVar.g);
                        packageStatisticModel3.applyDuration = Long.valueOf(aVar.o - aVar.n);
                    } else {
                        StatisticModel.PackageStatisticModel packageStatisticModel4 = new StatisticModel.PackageStatisticModel();
                        arrayList.add(packageStatisticModel4);
                        packageStatisticModel4.accessKey = aVar.f5101a;
                        packageStatisticModel4.groupName = aVar.b;
                        packageStatisticModel4.statsType = 103;
                        packageStatisticModel4.errCode = TbEnum.SystemMessage.EVENT_ID_UPLOAD_STAT;
                        packageStatisticModel4.channel = aVar.c;
                        packageStatisticModel4.patchId = aVar.q;
                        packageStatisticModel4.id = aVar.r;
                        packageStatisticModel4.errMsg = aVar.u;
                        a(aVar, bVar, bVar2, arrayList);
                    }
                } else {
                    StatisticModel.PackageStatisticModel packageStatisticModel5 = new StatisticModel.PackageStatisticModel();
                    arrayList.add(packageStatisticModel5);
                    packageStatisticModel5.statsType = 101;
                    packageStatisticModel5.accessKey = aVar.f5101a;
                    packageStatisticModel5.groupName = aVar.b;
                    packageStatisticModel5.channel = aVar.c;
                    packageStatisticModel5.ac = aVar.p;
                    packageStatisticModel5.patchId = aVar.q;
                    packageStatisticModel5.id = aVar.r;
                    packageStatisticModel5.downloadRetryTimes = a(aVar.e);
                    packageStatisticModel5.downloadUrl = aVar.d;
                    packageStatisticModel5.downloadFailRecords = b(aVar.e);
                    if (!aVar.h) {
                        packageStatisticModel5.errCode = "301";
                        if (aVar.e != null && !aVar.e.isEmpty()) {
                            packageStatisticModel5.errMsg = aVar.e.get(0).reason;
                        }
                    } else if (!aVar.i) {
                        packageStatisticModel5.errCode = TbEnum.SystemMessage.EVENT_ID_PASSED_FRIEND;
                        packageStatisticModel5.errMsg = aVar.s;
                    }
                    a(aVar, bVar, bVar2, arrayList);
                }
            } else {
                a(aVar, bVar, bVar2, arrayList);
            }
        }
        Context a2 = bVar.a();
        arrayList.addAll(com.bytedance.sdk.openadsdk.preload.geckox.a.a.a(a2));
        if (arrayList.isEmpty()) {
            return null;
        }
        Common common2 = new Common(bVar.j(), bVar.n(), bVar.q(), com.bytedance.sdk.openadsdk.preload.geckox.utils.a.b(a2), i.a(a2), bVar.k(), bVar.l());
        StatisticModel statisticModel = new StatisticModel();
        statisticModel.f5100common = common2;
        statisticModel.packages = arrayList;
        String uuid = UUID.randomUUID().toString();
        for (StatisticModel.PackageStatisticModel packageStatisticModel6 : arrayList) {
            packageStatisticModel6.logId = uuid;
        }
        return statisticModel;
    }

    private static Integer a(List<StatisticModel.PackageStatisticModel.DownloadFailRecords> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return Integer.valueOf(list.size());
    }

    private static void a(com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a aVar, com.bytedance.sdk.openadsdk.preload.geckox.b bVar, b bVar2, List<StatisticModel.PackageStatisticModel> list) {
        if (aVar.B && aVar.C) {
            StatisticModel.PackageStatisticModel packageStatisticModel = new StatisticModel.PackageStatisticModel();
            list.add(packageStatisticModel);
            packageStatisticModel.statsType = 0;
            packageStatisticModel.accessKey = aVar.f5101a;
            packageStatisticModel.groupName = aVar.b;
            packageStatisticModel.channel = aVar.c;
            packageStatisticModel.ac = aVar.p;
            packageStatisticModel.id = aVar.r;
            packageStatisticModel.downloadRetryTimes = a(aVar.w);
            packageStatisticModel.downloadUrl = aVar.v;
            packageStatisticModel.downloadFailRecords = b(aVar.w);
            packageStatisticModel.downloadDuration = Long.valueOf(aVar.y - aVar.x);
            if (aVar.D) {
                StatisticModel.PackageStatisticModel packageStatisticModel2 = new StatisticModel.PackageStatisticModel();
                list.add(packageStatisticModel2);
                packageStatisticModel2.accessKey = aVar.f5101a;
                packageStatisticModel2.groupName = aVar.b;
                packageStatisticModel2.statsType = 2;
                packageStatisticModel2.id = aVar.r;
                packageStatisticModel2.channel = aVar.c;
                packageStatisticModel2.activeCheckDuration = Long.valueOf(aVar.z - aVar.y);
                packageStatisticModel2.applyDuration = Long.valueOf(aVar.A - aVar.z);
                return;
            }
            StatisticModel.PackageStatisticModel packageStatisticModel3 = new StatisticModel.PackageStatisticModel();
            list.add(packageStatisticModel3);
            packageStatisticModel3.statsType = 3;
            packageStatisticModel3.accessKey = aVar.f5101a;
            packageStatisticModel3.groupName = aVar.b;
            packageStatisticModel3.errCode = "500";
            packageStatisticModel3.id = aVar.r;
            packageStatisticModel3.channel = aVar.c;
            packageStatisticModel3.errMsg = aVar.F;
            return;
        }
        StatisticModel.PackageStatisticModel packageStatisticModel4 = new StatisticModel.PackageStatisticModel();
        list.add(packageStatisticModel4);
        packageStatisticModel4.statsType = 1;
        packageStatisticModel4.accessKey = aVar.f5101a;
        packageStatisticModel4.groupName = aVar.b;
        packageStatisticModel4.channel = aVar.c;
        packageStatisticModel4.ac = aVar.p;
        packageStatisticModel4.id = aVar.r;
        packageStatisticModel4.downloadRetryTimes = a(aVar.w);
        packageStatisticModel4.downloadUrl = aVar.v;
        packageStatisticModel4.downloadFailRecords = b(aVar.w);
        if (!aVar.B) {
            packageStatisticModel4.errCode = ABTestConstants.PREFETCH_REUSE_AGE_DEFAULT_VALUE;
            if (aVar.w != null && !aVar.w.isEmpty()) {
                packageStatisticModel4.errMsg = aVar.w.get(0).reason;
            }
        } else if (!aVar.C) {
            packageStatisticModel4.errCode = "450";
            packageStatisticModel4.errMsg = aVar.E;
        }
    }

    private static List<StatisticModel.PackageStatisticModel.DownloadFailRecords> b(List<StatisticModel.PackageStatisticModel.DownloadFailRecords> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list;
    }
}
