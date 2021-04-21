package d.b.x.h;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.nps.pm.provider.BundleOpProvider;
import com.baidu.nps.utils.ContextHolder;
import com.baidu.searchbox.pms.db.PackageTable;
/* loaded from: classes2.dex */
public class i {
    public static f a(Uri uri) {
        f fVar = new f();
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("downloaded_size");
            long longValue = !TextUtils.isEmpty(queryParameter) ? Long.valueOf(queryParameter).longValue() : 0L;
            String queryParameter2 = uri.getQueryParameter(PackageTable.TOTAL_SIZE);
            long longValue2 = TextUtils.isEmpty(queryParameter2) ? 0L : Long.valueOf(queryParameter2).longValue();
            fVar.f65857a = longValue;
            fVar.f65858b = longValue2;
        }
        return fVar;
    }

    public static Uri b() {
        return new Uri.Builder().scheme("content").authority(BundleOpProvider.getAuth(ContextHolder.getApplicationContext())).build();
    }

    public static Uri c(String str, long j, long j2) {
        return new Uri.Builder().scheme("content").authority(BundleOpProvider.getAuth(ContextHolder.getApplicationContext())).path(str).appendQueryParameter("downloaded_size", String.valueOf(j)).appendQueryParameter(PackageTable.TOTAL_SIZE, String.valueOf(j2)).build();
    }

    public static Uri d(String str) {
        return new Uri.Builder().scheme("content").authority(BundleOpProvider.getAuth(ContextHolder.getApplicationContext())).path(str).build();
    }

    public static Uri e(String str) {
        return new Uri.Builder().scheme("content").authority(BundleOpProvider.getAuth(ContextHolder.getApplicationContext())).path(str).build();
    }
}
