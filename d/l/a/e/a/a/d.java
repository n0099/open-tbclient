package d.l.a.e.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.facebook.cache.disk.DefaultDiskStorage;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.l.a.e.b.f.v;
import io.reactivex.annotations.SchedulerSupport;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static a a(Context context, String str, JSONObject jSONObject, DownloadInfo downloadInfo) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, context, str, jSONObject, downloadInfo)) == null) {
            if (downloadInfo == null || context == null || jSONObject == null) {
                return null;
            }
            String savePath = downloadInfo.getSavePath();
            if (TextUtils.isEmpty(savePath) || TextUtils.isEmpty(str)) {
                return null;
            }
            File file = new File(savePath);
            d.l.a.e.b.j.a f2 = d.l.a.e.b.j.a.f(downloadInfo);
            if (str.equals("v1")) {
                return new j(context, f2, downloadInfo.getTargetFilePath());
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
                String dBJsonString = downloadInfo.getDBJsonString("file_content_uri");
                if (TextUtils.isEmpty(dBJsonString)) {
                    return null;
                }
                return new i(context, f2, file.getAbsolutePath(), dBJsonString, downloadInfo.getName());
            } else if (str.equals(SchedulerSupport.CUSTOM)) {
                return new c(context, f2, file.getAbsolutePath(), jSONObject);
            } else {
                if (str.equals("vbi")) {
                    v e2 = d.l.a.e.b.g.a.H(context).e(downloadInfo.getId());
                    String A = d.l.a.e.a.e.G().A();
                    return new m(context, f2, d.l.a.e.a.d.j(downloadInfo.getId(), e2, context, A, new File(downloadInfo.getSavePath() + File.separator + downloadInfo.getName())).toString());
                }
                return null;
            }
        }
        return (a) invokeLLLL.objValue;
    }

    public static boolean b(Context context, String str, JSONObject jSONObject, d.l.a.e.b.j.a aVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, context, str, jSONObject, aVar)) == null) {
            if (context == null || str == null) {
                return false;
            }
            a aVar2 = null;
            String F = d.l.a.e.a.d.F();
            if (TextUtils.isEmpty(F) || TextUtils.isEmpty(str)) {
                return false;
            }
            if (d.l.a.e.a.h.e.f() && str.equals("v1")) {
                aVar2 = new j(context, aVar, F);
            } else if (d.l.a.e.a.h.e.f() && str.equals(DefaultDiskStorage.DEFAULT_DISK_STORAGE_VERSION_PREFIX)) {
                aVar2 = new k(context, aVar, F);
            } else if (d.l.a.e.a.h.e.f() && str.equals("v3")) {
                aVar2 = new l(context, aVar, F);
            } else if (d.l.a.e.a.h.e.h() && str.equals("o1")) {
                aVar2 = new g(context, aVar, F);
            } else if (d.l.a.e.a.h.e.h() && str.equals("o2")) {
                aVar2 = new h(context, aVar, F);
            } else if (d.l.a.e.a.h.e.h() && str.equals("o3")) {
                aVar2 = new i(context, aVar, F, F, F);
            } else if (d.l.a.e.a.h.e.f() && str.equals(SchedulerSupport.CUSTOM)) {
                aVar2 = new c(context, aVar, F, jSONObject);
            } else if (d.l.a.e.a.h.e.f() && str.equals("vbi")) {
                aVar2 = new m(context, aVar, F);
            }
            return aVar2 != null && aVar2.a();
        }
        return invokeLLLL.booleanValue;
    }
}
