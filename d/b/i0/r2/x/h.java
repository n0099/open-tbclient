package d.b.i0.r2.x;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.nps.utils.Constant;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import d.b.b.e.p.l;
import d.b.i0.r2.t;
import java.io.File;
/* loaded from: classes5.dex */
public class h {
    public static final void a(AdvertAppInfo advertAppInfo) {
        d.b.h0.s.c.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && !adAdSense.g()) {
            t.a(advertAppInfo);
        } else {
            i.l().g(advertAppInfo.I3, advertAppInfo.J3, true);
        }
    }

    public static final boolean b(Context context, AdvertAppInfo advertAppInfo, int i, DownloadStaticsData downloadStaticsData) {
        AdvertAppInfo.a aVar;
        d.b.h0.s.c.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense == null || adAdSense.g()) {
            if (context == null || advertAppInfo == null) {
                return false;
            }
            String str = advertAppInfo.F3;
            if (StringUtils.isNull(str) && (aVar = advertAppInfo.U3) != null) {
                str = aVar.f13203b;
            }
            if (StringUtils.isNull(str)) {
                str = "";
            }
            return c(context, advertAppInfo, i, str, downloadStaticsData);
        }
        return t.i(context, advertAppInfo, i, downloadStaticsData);
    }

    public static final boolean c(Context context, AdvertAppInfo advertAppInfo, int i, String str, DownloadStaticsData downloadStaticsData) {
        if (context == null || advertAppInfo == null) {
            return false;
        }
        d.b.h0.u.a.l().i(advertAppInfo);
        String str2 = advertAppInfo.F3;
        String str3 = StringUtils.isNull(str2) ? str : str2;
        i l = i.l();
        String str4 = advertAppInfo.J3;
        String str5 = advertAppInfo.I3;
        int intValue = i.m(str4).intValue();
        AdvertAppInfo.a aVar = advertAppInfo.U3;
        l.x(str4, str5, str3, i, intValue, null, true, false, true, aVar.f13204c, downloadStaticsData, aVar.f13203b);
        return true;
    }

    public static final void d(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            l.K(context, R.string.download_error);
            return;
        }
        File GetFile = FileHelper.GetFile(str.replace(".", "_") + Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
        if (GetFile != null) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(UtilHelper.getUriFromFile(GetFile, intent, context), "application/vnd.android.package-archive");
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }
}
