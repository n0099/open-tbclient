package d.b.i0.o.c;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import d.b.i0.r2.b0.e;
/* loaded from: classes4.dex */
public class c {
    public void a(int i, @Nullable String str, String str2) {
        b("DOWNLOAD_PAGE", i, str, str2);
    }

    public void b(String str, int i, @Nullable String str2, String str3) {
        d.b.i0.r2.b0.c cVar = new d.b.i0.r2.b0.c();
        cVar.j(i);
        if (TextUtils.isEmpty(str)) {
            str = "DOWNLOAD_PAGE";
        }
        cVar.h(str);
        cVar.c("DOWNLOAD_BUTTON");
        if (!TextUtils.isEmpty(str2)) {
            DownloadStaticsData downloadStaticsData = new DownloadStaticsData();
            downloadStaticsData.setApk_name(str2);
            cVar.q(downloadStaticsData);
        }
        if (!TextUtils.isEmpty(str3)) {
            cVar.s(str3);
        }
        e.b().d(cVar);
    }
}
