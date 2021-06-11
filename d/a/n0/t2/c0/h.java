package d.a.n0.t2.c0;

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
import d.a.n0.t2.y;
import java.io.File;
/* loaded from: classes5.dex */
public class h {
    public static final void a(AdvertAppInfo advertAppInfo) {
        d.a.m0.s.c.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && !adAdSense.g()) {
            y.a(advertAppInfo);
        } else {
            i.l().g(advertAppInfo.a4, advertAppInfo.getDownloadId(), true);
        }
    }

    public static final boolean b(Context context, AdvertAppInfo advertAppInfo, int i2, DownloadStaticsData downloadStaticsData) {
        d.a.m0.s.c.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense == null || adAdSense.g()) {
            if (context == null || advertAppInfo == null) {
                return false;
            }
            String str = advertAppInfo.W3;
            if (StringUtils.isNull(str)) {
                str = "";
            }
            return c(context, advertAppInfo, i2, str, downloadStaticsData);
        }
        return y.i(context, advertAppInfo, i2, downloadStaticsData);
    }

    public static final boolean c(Context context, AdvertAppInfo advertAppInfo, int i2, String str, DownloadStaticsData downloadStaticsData) {
        if (context == null || advertAppInfo == null) {
            return false;
        }
        d.a.m0.u.a.k().h(advertAppInfo);
        String str2 = advertAppInfo.W3;
        i.l().x(advertAppInfo.getDownloadId(), advertAppInfo.a4, StringUtils.isNull(str2) ? str : str2, i2, i.m(advertAppInfo.b4).intValue(), null, true, false, true, advertAppInfo.X3, downloadStaticsData, advertAppInfo.W3);
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
