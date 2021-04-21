package d.p.a.e.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.cache.disk.DefaultDiskStorage;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.p.a.e.b.f.u;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d {
    public static a a(Context context, String str, JSONObject jSONObject, DownloadInfo downloadInfo) {
        if (downloadInfo == null || context == null || jSONObject == null) {
            return null;
        }
        String F0 = downloadInfo.F0();
        if (TextUtils.isEmpty(F0) || TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(F0);
        d.p.a.e.b.j.a f2 = d.p.a.e.b.j.a.f(downloadInfo);
        if (str.equals("v1")) {
            return new j(context, f2, downloadInfo.K0());
        }
        if (str.equals(DefaultDiskStorage.DEFAULT_DISK_STORAGE_VERSION_PREFIX)) {
            return new k(context, f2, file.getAbsolutePath());
        }
        if (str.equals("v3")) {
            return new l(context, f2, file.getAbsolutePath());
        }
        if (str.equals("o1")) {
            return new g(context, f2, file.getAbsolutePath());
        }
        if (str.equals("o2")) {
            return new h(context, f2, file.getAbsolutePath());
        }
        if (str.equals("o3")) {
            String I = downloadInfo.I("file_content_uri");
            if (TextUtils.isEmpty(I)) {
                return null;
            }
            return new i(context, f2, file.getAbsolutePath(), I, downloadInfo.q0());
        } else if (str.equals("custom")) {
            return new c(context, f2, file.getAbsolutePath(), jSONObject);
        } else {
            if (str.equals("vbi")) {
                u e2 = d.p.a.e.b.g.a.l(context).e(downloadInfo.c0());
                String z = d.p.a.e.a.e.F().z();
                return new m(context, f2, d.p.a.e.a.d.j(downloadInfo.c0(), e2, context, z, new File(downloadInfo.F0() + File.separator + downloadInfo.q0())).toString());
            }
            return null;
        }
    }

    public static boolean b(Context context, String str, JSONObject jSONObject, d.p.a.e.b.j.a aVar) {
        if (context == null || str == null) {
            return false;
        }
        a aVar2 = null;
        String F = d.p.a.e.a.d.F();
        if (TextUtils.isEmpty(F) || TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.equals("v1")) {
            aVar2 = new j(context, aVar, F);
        } else if (str.equals(DefaultDiskStorage.DEFAULT_DISK_STORAGE_VERSION_PREFIX)) {
            aVar2 = new k(context, aVar, F);
        } else if (str.equals("v3")) {
            aVar2 = new l(context, aVar, F);
        } else if (str.equals("o1")) {
            aVar2 = new g(context, aVar, F);
        } else if (str.equals("o2")) {
            aVar2 = new h(context, aVar, F);
        } else if (str.equals("o3")) {
            aVar2 = new i(context, aVar, F, F, F);
        } else if (str.equals("custom")) {
            aVar2 = new c(context, aVar, F, jSONObject);
        } else if (str.equals("vbi")) {
            aVar2 = new m(context, aVar, F);
        }
        return aVar2 != null && aVar2.a();
    }
}
