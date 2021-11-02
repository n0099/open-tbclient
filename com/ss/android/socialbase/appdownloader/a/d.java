package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import io.reactivex.annotations.SchedulerSupport;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes2.dex */
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
            com.ss.android.socialbase.downloader.g.a a2 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo);
            if (str.equals("v1")) {
                return new j(context, a2, downloadInfo.getTargetFilePath());
            }
            if (str.equals("v2")) {
                return new k(context, a2, file.getAbsolutePath());
            }
            if (str.equals("v3")) {
                return new l(context, a2, file.getAbsolutePath());
            }
            if (str.equals("o1")) {
                return new g(context, a2, file.getAbsolutePath());
            }
            if (str.equals("o2")) {
                return new h(context, a2, file.getAbsolutePath());
            }
            if (str.equals("o3")) {
                String dBJsonString = downloadInfo.getDBJsonString("file_content_uri");
                if (TextUtils.isEmpty(dBJsonString)) {
                    return null;
                }
                return new i(context, a2, file.getAbsolutePath(), dBJsonString, downloadInfo.getName());
            } else if (str.equals(SchedulerSupport.CUSTOM)) {
                return new c(context, a2, file.getAbsolutePath(), jSONObject);
            } else {
                if (str.equals("vbi")) {
                    IDownloadFileUriProvider downloadFileUriProvider = Downloader.getInstance(context).getDownloadFileUriProvider(downloadInfo.getId());
                    String d2 = com.ss.android.socialbase.appdownloader.d.j().d();
                    return new m(context, a2, com.ss.android.socialbase.appdownloader.c.a(downloadInfo.getId(), downloadFileUriProvider, context, d2, new File(downloadInfo.getSavePath() + File.separator + downloadInfo.getName())).toString());
                }
                return null;
            }
        }
        return (a) invokeLLLL.objValue;
    }

    public static boolean a(Context context, String str, JSONObject jSONObject, com.ss.android.socialbase.downloader.g.a aVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, context, str, jSONObject, aVar)) == null) {
            if (context == null || str == null) {
                return false;
            }
            a aVar2 = null;
            String b2 = com.ss.android.socialbase.appdownloader.c.b();
            if (TextUtils.isEmpty(b2) || TextUtils.isEmpty(str)) {
                return false;
            }
            if (com.ss.android.socialbase.appdownloader.f.d.c() && str.equals("v1")) {
                aVar2 = new j(context, aVar, b2);
            } else if (com.ss.android.socialbase.appdownloader.f.d.c() && str.equals("v2")) {
                aVar2 = new k(context, aVar, b2);
            } else if (com.ss.android.socialbase.appdownloader.f.d.c() && str.equals("v3")) {
                aVar2 = new l(context, aVar, b2);
            } else if (com.ss.android.socialbase.appdownloader.f.d.d() && str.equals("o1")) {
                aVar2 = new g(context, aVar, b2);
            } else if (com.ss.android.socialbase.appdownloader.f.d.d() && str.equals("o2")) {
                aVar2 = new h(context, aVar, b2);
            } else if (com.ss.android.socialbase.appdownloader.f.d.d() && str.equals("o3")) {
                aVar2 = new i(context, aVar, b2, b2, b2);
            } else if (com.ss.android.socialbase.appdownloader.f.d.c() && str.equals(SchedulerSupport.CUSTOM)) {
                aVar2 = new c(context, aVar, b2, jSONObject);
            } else if (com.ss.android.socialbase.appdownloader.f.d.c() && str.equals("vbi")) {
                aVar2 = new m(context, aVar, b2);
            }
            return aVar2 != null && aVar2.a();
        }
        return invokeLLLL.booleanValue;
    }
}
