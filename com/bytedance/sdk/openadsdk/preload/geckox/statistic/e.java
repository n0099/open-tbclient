package com.bytedance.sdk.openadsdk.preload.geckox.statistic;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.utils.ZeusInitConfigUtils;
import com.bytedance.sdk.openadsdk.preload.geckox.model.Common;
import com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.StatisticModel;
import com.bytedance.sdk.openadsdk.preload.geckox.utils.i;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(com.bytedance.sdk.openadsdk.preload.geckox.b bVar, b bVar2) {
        StatisticModel b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, bVar, bVar2) == null) || (b2 = b(bVar, bVar2)) == null || b2.packages == null) {
            return;
        }
        a p = bVar.p();
        if (p != null) {
            try {
                for (StatisticModel.PackageStatisticModel packageStatisticModel : b2.packages) {
                    p.a("geckosdk_update_stats", a(packageStatisticModel, b2.f69141common));
                }
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "UploadStatistic.upload:", th);
            }
        }
        if (bVar.c()) {
            String a2 = com.bytedance.sdk.openadsdk.preload.geckox.c.b.a().b().a(b2);
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            a(bVar, a2);
        }
    }

    public static JSONObject b(com.bytedance.sdk.openadsdk.preload.geckox.b bVar, com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.b bVar2) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, bVar, bVar2)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("params_for_special", "gecko");
            jSONObject.put("device_id", bVar.q());
            jSONObject.put("os", 0);
            jSONObject.put("app_version", bVar.n());
            jSONObject.put(com.alipay.sdk.packet.e.l, "v3");
            jSONObject.put("aid", bVar.j());
            jSONObject.put("x_tt_logid", bVar2.f69156e);
            jSONObject.put("http_status", bVar2.f69158g);
            jSONObject.put(PmsConstant.Statistic.STATISTIC_ERRMSG, bVar2.f69155d);
            if (TextUtils.isEmpty(bVar2.f69156e)) {
                jSONObject.put("deployments_info", bVar2.f69153b);
                jSONObject.put("local_info", bVar2.f69152a);
                jSONObject.put("custom_info", bVar2.f69154c);
            } else {
                jSONObject.put("deployments_info", "");
                jSONObject.put("local_info", "");
                jSONObject.put("custom_info", "");
            }
            jSONObject.put(HttpConstants.OS_VERSION, Build.VERSION.SDK_INT + "");
            jSONObject.put("device_platform", "android");
            jSONObject.put("device_model", Build.MODEL);
            jSONObject.put("ac", bVar2.f69157f);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static void a(com.bytedance.sdk.openadsdk.preload.geckox.b bVar, com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.b bVar2) {
        a p;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, bVar, bVar2) == null) || (p = bVar.p()) == null) {
            return;
        }
        try {
            p.a("geckosdk_query_pkgs", b(bVar, bVar2));
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "UploadStatistic.upload:", th);
        }
    }

    public static void a(com.bytedance.sdk.openadsdk.preload.geckox.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bVar, str) == null) {
            bVar.f().execute(new Runnable(bVar, "https://" + bVar.i() + "/gecko/server/packages/stats", str) { // from class: com.bytedance.sdk.openadsdk.preload.geckox.statistic.e.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.openadsdk.preload.geckox.b f69138a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f69139b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f69140c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar, r7, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f69138a = bVar;
                    this.f69139b = r7;
                    this.f69140c = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.preload.geckox.i.c a2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        for (int i2 = 0; i2 < 3; i2++) {
                            try {
                                a2 = this.f69138a.h().a(this.f69139b, this.f69140c);
                            } catch (Exception e2) {
                                com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "upload statistic:", e2);
                            }
                            if (a2.f69117c == 200) {
                                if (new JSONObject(a2.f69116b).getInt("status") == 0) {
                                    return;
                                }
                            } else {
                                throw new NetworkErrorException("net work get failed, code: " + a2.f69117c + ", url:" + this.f69139b);
                                break;
                            }
                        }
                    }
                }
            });
        }
    }

    public static JSONObject a(StatisticModel.PackageStatisticModel packageStatisticModel, Common common2) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, packageStatisticModel, common2)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("params_for_special", "gecko");
            jSONObject.put("region", common2.region);
            jSONObject.put(PmsConstant.Statistic.STATISTIC_ERRCODE, packageStatisticModel.errCode);
            jSONObject.put(PmsConstant.Statistic.STATISTIC_ERRMSG, packageStatisticModel.errMsg);
            jSONObject.put(ZeusInitConfigUtils.PREF_KEY_SDK_VERSION, common2.sdkVersion);
            jSONObject.put("access_key", packageStatisticModel.accessKey);
            jSONObject.put("stats_type", packageStatisticModel.statsType);
            jSONObject.put("device_id", common2.deviceId);
            Long l = packageStatisticModel.patchId;
            jSONObject.put("patch_id", l == null ? 0L : l.longValue());
            jSONObject.put("group_name", packageStatisticModel.groupName);
            jSONObject.put("os", common2.os);
            jSONObject.put("app_version", common2.appVersion);
            jSONObject.put("device_model", common2.deviceModel);
            jSONObject.put("channel", packageStatisticModel.channel);
            Long l2 = packageStatisticModel.id;
            jSONObject.put("id", l2 == null ? 0L : l2.longValue());
            jSONObject.put("ac", common2.ac);
            Integer num = packageStatisticModel.downloadRetryTimes;
            jSONObject.put("download_retry_times", num == null ? 0 : num.intValue());
            String str = packageStatisticModel.downloadUrl;
            if (str == null) {
                str = "";
            }
            jSONObject.put("download_url", str);
            jSONObject.put("download_duration", packageStatisticModel.downloadDuration);
            List<StatisticModel.PackageStatisticModel.DownloadFailRecords> list = packageStatisticModel.downloadFailRecords;
            jSONObject.put("download_fail_records", list != null ? list : "");
            jSONObject.put(TiebaStatic.Params.LOGID, packageStatisticModel.logId);
            Long l3 = packageStatisticModel.activeCheckDuration;
            jSONObject.put("active_check_duration", l3 == null ? 0L : l3.longValue());
            Long l4 = packageStatisticModel.applyDuration;
            jSONObject.put("apply_duration", l4 != null ? l4.longValue() : 0L);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static StatisticModel b(com.bytedance.sdk.openadsdk.preload.geckox.b bVar, b bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, bVar, bVar2)) == null) {
            ArrayList<StatisticModel.PackageStatisticModel> arrayList = new ArrayList();
            for (com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a aVar : bVar2.a()) {
                if (aVar.f69145d == null && aVar.f69147f == 0) {
                    a(aVar, bVar, bVar2, arrayList);
                } else if (aVar.f69149h && aVar.f69150i) {
                    StatisticModel.PackageStatisticModel packageStatisticModel = new StatisticModel.PackageStatisticModel();
                    arrayList.add(packageStatisticModel);
                    packageStatisticModel.statsType = 100;
                    packageStatisticModel.groupName = aVar.f69143b;
                    packageStatisticModel.accessKey = aVar.f69142a;
                    packageStatisticModel.channel = aVar.f69144c;
                    packageStatisticModel.ac = aVar.p;
                    packageStatisticModel.id = aVar.r;
                    packageStatisticModel.patchId = aVar.q;
                    packageStatisticModel.downloadRetryTimes = a(aVar.f69146e);
                    packageStatisticModel.downloadUrl = aVar.f69145d;
                    packageStatisticModel.downloadFailRecords = b(aVar.f69146e);
                    packageStatisticModel.downloadDuration = Long.valueOf(aVar.f69148g - aVar.f69147f);
                    if (!aVar.f69151j) {
                        StatisticModel.PackageStatisticModel packageStatisticModel2 = new StatisticModel.PackageStatisticModel();
                        arrayList.add(packageStatisticModel2);
                        packageStatisticModel2.statsType = 100;
                        packageStatisticModel2.channel = aVar.f69144c;
                        packageStatisticModel2.errCode = "403";
                        packageStatisticModel2.errMsg = aVar.t;
                        packageStatisticModel2.ac = aVar.p;
                        packageStatisticModel2.patchId = aVar.q;
                        packageStatisticModel2.id = aVar.r;
                        packageStatisticModel2.downloadRetryTimes = a(aVar.f69146e);
                        packageStatisticModel2.downloadUrl = aVar.f69145d;
                        packageStatisticModel2.downloadFailRecords = b(aVar.f69146e);
                        a(aVar, bVar, bVar2, arrayList);
                    } else if (aVar.k) {
                        StatisticModel.PackageStatisticModel packageStatisticModel3 = new StatisticModel.PackageStatisticModel();
                        arrayList.add(packageStatisticModel3);
                        packageStatisticModel3.accessKey = aVar.f69142a;
                        packageStatisticModel3.groupName = aVar.f69143b;
                        packageStatisticModel3.statsType = 102;
                        packageStatisticModel3.patchId = aVar.q;
                        packageStatisticModel3.id = aVar.r;
                        packageStatisticModel3.channel = aVar.f69144c;
                        packageStatisticModel3.activeCheckDuration = Long.valueOf(aVar.n - aVar.f69148g);
                        packageStatisticModel3.applyDuration = Long.valueOf(aVar.o - aVar.n);
                    } else {
                        StatisticModel.PackageStatisticModel packageStatisticModel4 = new StatisticModel.PackageStatisticModel();
                        arrayList.add(packageStatisticModel4);
                        packageStatisticModel4.accessKey = aVar.f69142a;
                        packageStatisticModel4.groupName = aVar.f69143b;
                        packageStatisticModel4.statsType = 103;
                        packageStatisticModel4.errCode = "501";
                        packageStatisticModel4.channel = aVar.f69144c;
                        packageStatisticModel4.patchId = aVar.q;
                        packageStatisticModel4.id = aVar.r;
                        packageStatisticModel4.errMsg = aVar.u;
                        a(aVar, bVar, bVar2, arrayList);
                    }
                } else {
                    StatisticModel.PackageStatisticModel packageStatisticModel5 = new StatisticModel.PackageStatisticModel();
                    arrayList.add(packageStatisticModel5);
                    packageStatisticModel5.statsType = 101;
                    packageStatisticModel5.accessKey = aVar.f69142a;
                    packageStatisticModel5.groupName = aVar.f69143b;
                    packageStatisticModel5.channel = aVar.f69144c;
                    packageStatisticModel5.ac = aVar.p;
                    packageStatisticModel5.patchId = aVar.q;
                    packageStatisticModel5.id = aVar.r;
                    packageStatisticModel5.downloadRetryTimes = a(aVar.f69146e);
                    packageStatisticModel5.downloadUrl = aVar.f69145d;
                    packageStatisticModel5.downloadFailRecords = b(aVar.f69146e);
                    if (!aVar.f69149h) {
                        packageStatisticModel5.errCode = "301";
                        List<StatisticModel.PackageStatisticModel.DownloadFailRecords> list = aVar.f69146e;
                        if (list != null && !list.isEmpty()) {
                            packageStatisticModel5.errMsg = aVar.f69146e.get(0).reason;
                        }
                    } else if (!aVar.f69150i) {
                        packageStatisticModel5.errCode = TbEnum.SystemMessage.EVENT_ID_PASSED_FRIEND;
                        packageStatisticModel5.errMsg = aVar.s;
                    }
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
            statisticModel.f69141common = common2;
            statisticModel.packages = arrayList;
            String uuid = UUID.randomUUID().toString();
            for (StatisticModel.PackageStatisticModel packageStatisticModel6 : arrayList) {
                packageStatisticModel6.logId = uuid;
            }
            return statisticModel;
        }
        return (StatisticModel) invokeLL.objValue;
    }

    public static Integer a(List<StatisticModel.PackageStatisticModel.DownloadFailRecords> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (list == null || list.isEmpty()) {
                return null;
            }
            return Integer.valueOf(list.size());
        }
        return (Integer) invokeL.objValue;
    }

    public static void a(com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a aVar, com.bytedance.sdk.openadsdk.preload.geckox.b bVar, b bVar2, List<StatisticModel.PackageStatisticModel> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(AdIconUtil.AD_TEXT_ID, null, aVar, bVar, bVar2, list) == null) {
            if (aVar.B && aVar.C) {
                StatisticModel.PackageStatisticModel packageStatisticModel = new StatisticModel.PackageStatisticModel();
                list.add(packageStatisticModel);
                packageStatisticModel.statsType = 0;
                packageStatisticModel.accessKey = aVar.f69142a;
                packageStatisticModel.groupName = aVar.f69143b;
                packageStatisticModel.channel = aVar.f69144c;
                packageStatisticModel.ac = aVar.p;
                packageStatisticModel.id = aVar.r;
                packageStatisticModel.downloadRetryTimes = a(aVar.w);
                packageStatisticModel.downloadUrl = aVar.v;
                packageStatisticModel.downloadFailRecords = b(aVar.w);
                packageStatisticModel.downloadDuration = Long.valueOf(aVar.y - aVar.x);
                if (aVar.D) {
                    StatisticModel.PackageStatisticModel packageStatisticModel2 = new StatisticModel.PackageStatisticModel();
                    list.add(packageStatisticModel2);
                    packageStatisticModel2.accessKey = aVar.f69142a;
                    packageStatisticModel2.groupName = aVar.f69143b;
                    packageStatisticModel2.statsType = 2;
                    packageStatisticModel2.id = aVar.r;
                    packageStatisticModel2.channel = aVar.f69144c;
                    packageStatisticModel2.activeCheckDuration = Long.valueOf(aVar.z - aVar.y);
                    packageStatisticModel2.applyDuration = Long.valueOf(aVar.A - aVar.z);
                    return;
                }
                StatisticModel.PackageStatisticModel packageStatisticModel3 = new StatisticModel.PackageStatisticModel();
                list.add(packageStatisticModel3);
                packageStatisticModel3.statsType = 3;
                packageStatisticModel3.accessKey = aVar.f69142a;
                packageStatisticModel3.groupName = aVar.f69143b;
                packageStatisticModel3.errCode = "500";
                packageStatisticModel3.id = aVar.r;
                packageStatisticModel3.channel = aVar.f69144c;
                packageStatisticModel3.errMsg = aVar.F;
                return;
            }
            StatisticModel.PackageStatisticModel packageStatisticModel4 = new StatisticModel.PackageStatisticModel();
            list.add(packageStatisticModel4);
            packageStatisticModel4.statsType = 1;
            packageStatisticModel4.accessKey = aVar.f69142a;
            packageStatisticModel4.groupName = aVar.f69143b;
            packageStatisticModel4.channel = aVar.f69144c;
            packageStatisticModel4.ac = aVar.p;
            packageStatisticModel4.id = aVar.r;
            packageStatisticModel4.downloadRetryTimes = a(aVar.w);
            packageStatisticModel4.downloadUrl = aVar.v;
            packageStatisticModel4.downloadFailRecords = b(aVar.w);
            if (!aVar.B) {
                packageStatisticModel4.errCode = "300";
                List<StatisticModel.PackageStatisticModel.DownloadFailRecords> list2 = aVar.w;
                if (list2 == null || list2.isEmpty()) {
                    return;
                }
                packageStatisticModel4.errMsg = aVar.w.get(0).reason;
            } else if (aVar.C) {
            } else {
                packageStatisticModel4.errCode = "450";
                packageStatisticModel4.errMsg = aVar.E;
            }
        }
    }

    public static List<StatisticModel.PackageStatisticModel.DownloadFailRecords> b(List<StatisticModel.PackageStatisticModel.DownloadFailRecords> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, list)) == null) {
            if (list == null || list.isEmpty()) {
                return null;
            }
            return list;
        }
        return (List) invokeL.objValue;
    }
}
