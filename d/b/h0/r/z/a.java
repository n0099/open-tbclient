package d.b.h0.r.z;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes3.dex */
public class a {
    public static void a(String str, long j, int i, String str2, int i2, String str3, Object... objArr) {
        d.b.b.e.n.a aVar = new d.b.b.e.n.a();
        aVar.c("cmd", Integer.valueOf(i));
        if (!TextUtils.isEmpty(str2)) {
            aVar.b("action", str2);
        }
        aVar.b("errNo", String.valueOf(i2));
        if (!TextUtils.isEmpty(str3) && i2 != 0) {
            aVar.b("errMsg", str3);
        }
        if (objArr != null && objArr.length > 0) {
            aVar.c(objArr);
        }
        if (i2 == 0) {
            BdStatisticsManager.getInstance().debug(str, j, null, aVar);
        } else {
            BdStatisticsManager.getInstance().error(str, j, (String) null, aVar);
        }
    }
}
