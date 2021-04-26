package d.a.j0.s2.b0;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.alibaba.fastjson.asm.Label;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import d.a.c.e.p.l;
import d.a.j0.s2.x;
import java.io.File;
/* loaded from: classes3.dex */
public class h {
    public static final void a(AdvertAppInfo advertAppInfo) {
        d.a.i0.s.c.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && !adAdSense.g()) {
            x.a(advertAppInfo);
        } else {
            i.l().g(advertAppInfo.I3, advertAppInfo.J3, true);
        }
    }

    public static final boolean b(Context context, AdvertAppInfo advertAppInfo, int i2, DownloadStaticsData downloadStaticsData) {
        AdvertAppInfo.a aVar;
        d.a.i0.s.c.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense == null || adAdSense.g()) {
            if (context == null || advertAppInfo == null) {
                return false;
            }
            String str = advertAppInfo.F3;
            if (StringUtils.isNull(str) && (aVar = advertAppInfo.U3) != null) {
                str = aVar.f12788b;
            }
            if (StringUtils.isNull(str)) {
                str = "";
            }
            return c(context, advertAppInfo, i2, str, downloadStaticsData);
        }
        return x.i(context, advertAppInfo, i2, downloadStaticsData);
    }

    public static final boolean c(Context context, AdvertAppInfo advertAppInfo, int i2, String str, DownloadStaticsData downloadStaticsData) {
        if (context == null || advertAppInfo == null) {
            return false;
        }
        d.a.i0.u.a.l().i(advertAppInfo);
        String str2 = advertAppInfo.F3;
        String str3 = StringUtils.isNull(str2) ? str : str2;
        i l = i.l();
        String str4 = advertAppInfo.J3;
        String str5 = advertAppInfo.I3;
        int intValue = i.m(str4).intValue();
        AdvertAppInfo.a aVar = advertAppInfo.U3;
        l.x(str4, str5, str3, i2, intValue, null, true, false, true, aVar.f12789c, downloadStaticsData, aVar.f12788b);
        return true;
    }

    public static final void d(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            l.L(context, R.string.download_error);
            return;
        }
        File GetFile = FileHelper.GetFile(str.replace(".", "_") + ".apk");
        if (GetFile != null) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(UtilHelper.getUriFromFile(GetFile, intent, context), "application/vnd.android.package-archive");
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            context.startActivity(intent);
        }
    }
}
