package d.b.i0.p0.m2;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.OriginalForumInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.SelectImageHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.b.h0.r.q.a2;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class m {
    public static void a(TbPageContext tbPageContext, Intent intent, String str) {
        if (tbPageContext == null) {
            return;
        }
        if (intent != null && !intent.getBooleanExtra("back_special", false)) {
            tbPageContext.getPageActivity().finish();
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(str)) {
                tbPageContext.sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(1)));
            } else {
                d.b.h0.r.a0.b.e(tbPageContext.getPageActivity(), 1);
            }
        } else if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(str)) {
            tbPageContext.sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(2)));
        } else {
            d.b.h0.r.a0.b.e(tbPageContext.getPageActivity(), 2);
        }
        if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(str)) {
            tbPageContext.getPageActivity().finish();
        }
    }

    public static g b(Intent intent) {
        int i;
        if (intent == null || intent.getParcelableExtra(IntentConfig.KEY_URI) == null) {
            return null;
        }
        Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
        String uri2 = uri.toString();
        g gVar = new g();
        if (!StringUtils.isNull(uri2) && uri2.startsWith("tbfrs://")) {
            String decode = Uri.decode(uri.getEncodedPath());
            if (StringUtils.isNull(decode)) {
                return null;
            }
            Matcher matcher = Pattern.compile(".*fr=(.*)&kw=(.*)").matcher(decode);
            if (matcher.find()) {
                if (!"mpush".equals(matcher.group(1)) && "bpush".equals(matcher.group(1))) {
                    k(decode);
                }
                gVar.f57917a = matcher.group(2);
            } else {
                k(decode);
                int indexOf = decode.indexOf("kw=");
                if (indexOf < 0 || (i = indexOf + 3) > decode.length()) {
                    return null;
                }
                gVar.f57917a = decode.substring(i);
                try {
                    gVar.f57918b = uri.getQueryParameter("from");
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SCHEMA_UPLOAD);
            httpMessage.addParam("call_url", uri2);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
        return gVar;
    }

    public static Intent c(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return null;
        }
        Intent intent = new Intent(context, DealIntentService.class);
        intent.putExtra(DealIntentService.KEY_CLASS, 2);
        intent.putExtra("fname", str);
        intent.putExtra("from", "nas");
        return intent;
    }

    public static void d(TbPageContext tbPageContext, FrsViewData frsViewData) {
        if (tbPageContext == null || frsViewData == null) {
            return;
        }
        d.b.h0.l.a.o(tbPageContext.getPageActivity(), "福袋", TbConfig.SERVER_ADDRESS + TbConfig.FORTUNE_ADDRESS + "?fid=" + frsViewData.getForum().getId(), true, true, true);
    }

    public static void e(FrsFragment frsFragment, a2 a2Var, int i, boolean z) {
        PbActivityConfig createFromThreadCfg;
        if (frsFragment == null || a2Var == null) {
            return;
        }
        String str = null;
        String valueOf = String.valueOf(a2Var.c0());
        OriginalForumInfo originalForumInfo = a2Var.C1;
        if (originalForumInfo != null) {
            valueOf = originalForumInfo.id;
            str = valueOf;
        }
        if (a2Var.A0() > 0 && d.b.i0.c3.n0.e.c()) {
            createFromThreadCfg = new PbActivityConfig(frsFragment.getPageContext().getPageActivity()).createHistoryCfg(a2Var.w1(), String.valueOf(a2Var.A0()), false, true, "frs_page");
        } else {
            createFromThreadCfg = new PbActivityConfig(frsFragment.getPageContext().getPageActivity()).createFromThreadCfg(a2Var, frsFragment.i(), "frs_page", 18003, true, false, z);
        }
        if (i == 4) {
            createFromThreadCfg.setVideo_source("floor5");
        } else {
            createFromThreadCfg.setVideo_source("frs");
        }
        createFromThreadCfg.setFromSmartFrs(a2Var.s2());
        createFromThreadCfg.setSmartFrsPosition(i);
        createFromThreadCfg.setForumId(valueOf);
        createFromThreadCfg.setFromForumId(str);
        createFromThreadCfg.setStartFrom(3);
        createFromThreadCfg.setFrom("from_frs");
        if (a2Var.d2() && createFromThreadCfg.getIntent() != null) {
            createFromThreadCfg.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
        }
        if (TbSingleton.getInstance().isPbPreloadSwitchOn() && j(a2Var)) {
            createFromThreadCfg.setNeedPreLoad(true);
            d.b.i0.p0.l.c(a2Var);
        }
        frsFragment.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    public static void f(FrsFragment frsFragment, String str, a2 a2Var, boolean z) {
        if (frsFragment == null || a2Var == null || str == null) {
            return;
        }
        if (!(a2Var == null || a2Var.N1())) {
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(frsFragment.getPageContext().getPageActivity()).createFromThreadCfg(a2Var, frsFragment.i(), "frs_page", 18003, true, true, z);
            createFromThreadCfg.setVideo_source("frs");
            createFromThreadCfg.setStartFrom(3);
            frsFragment.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
            return;
        }
        PbActivityConfig createFromThreadCfg2 = new PbActivityConfig(frsFragment.getPageContext().getPageActivity()).createFromThreadCfg(a2Var, frsFragment.i(), "frs_page", 18003, true, false, z);
        createFromThreadCfg2.setVideo_source("frs");
        createFromThreadCfg2.setStartFrom(3);
        frsFragment.sendMessage(new CustomMessage(2004001, createFromThreadCfg2));
    }

    public static void g(FrsFragment frsFragment, String str, a2 a2Var, boolean z) {
        if (frsFragment == null || a2Var == null || str == null) {
            return;
        }
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(frsFragment.getPageContext().getPageActivity()).createFromThreadCfg(a2Var, frsFragment.i(), "frs_page", 18003, false, false, z);
        createFromThreadCfg.setVideo_source("frs");
        createFromThreadCfg.setStartFrom(3);
        frsFragment.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    public static void h(FrsFragment frsFragment, int i, String[] strArr, int[] iArr) {
        if (frsFragment == null || strArr == null || iArr == null || i != 1) {
            return;
        }
        if (PermissionUtil.checkCamera(TbadkCoreApplication.getInst().getApplicationContext())) {
            SelectImageHelper.takePhoto(frsFragment.getPageContext());
        } else {
            frsFragment.showToast(R.string.system_permission_prompt_camera);
        }
        ArrayMap<String, Boolean> transformPermissionResult = PermissionUtil.transformPermissionResult(strArr, iArr);
        if (!transformPermissionResult.containsKey(StorageUtils.EXTERNAL_STORAGE_PERMISSION) || transformPermissionResult.get(StorageUtils.EXTERNAL_STORAGE_PERMISSION).booleanValue()) {
            return;
        }
        frsFragment.showToast(R.string.sdcard_permission_denied_advert_for_camera);
    }

    public static boolean i(Context context, String str) {
        Iterator<ActivityManager.RunningTaskInfo> it = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(10).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ActivityManager.RunningTaskInfo next = it.next();
            if (next.topActivity.getClassName().equals(str)) {
                if (next.numActivities <= 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean j(a2 a2Var) {
        if (a2Var == null || a2Var.s1) {
            return false;
        }
        int i = a2Var.Z;
        return i == 0 || i == 11 || i == 40 || a2Var.x2();
    }

    public static void k(String str) {
        if (str.startsWith("//")) {
            str = str.substring(2);
        }
        Map<String, String> paramPair = UrlManager.getParamPair(str);
        if (paramPair != null) {
            StatisticItem statisticItem = new StatisticItem("c10320");
            statisticItem.param("obj_locate", paramPair.get("obj_locate"));
            statisticItem.param("obj_type", 1);
            statisticItem.param("fname", paramPair.get(TiebaStatic.Params.H5_FORUM_NAME));
            statisticItem.param("obj_source", paramPair.get("obj_source"));
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, paramPair.get(TiebaStatic.Params.OBJ_PARAM2));
            statisticItem.param(TiebaStatic.Params.OBJ_TO, 2);
            statisticItem.param("obj_id", paramPair.get("bdid"));
            statisticItem.param("obj_name", TbadkCoreApplication.getInst().getStartType());
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, 1);
            if (!d.b.b.e.p.k.isEmpty(paramPair.get("ext_log"))) {
                try {
                    JSONObject jSONObject = new JSONObject(paramPair.get("ext_log"));
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        statisticItem.param(next, jSONObject.getString(next));
                    }
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
            TiebaStatic.log(statisticItem);
        }
    }
}
