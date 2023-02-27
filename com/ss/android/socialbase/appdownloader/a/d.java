package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.logsystem.exceptionhandler.impl.ExceptionHandlerImpl;
import com.facebook.cache.disk.DefaultDiskStorage;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class d {
    public static a a(Context context, String str, JSONObject jSONObject, DownloadInfo downloadInfo) {
        if (downloadInfo == null || context == null || jSONObject == null) {
            return null;
        }
        String savePath = downloadInfo.getSavePath();
        if (TextUtils.isEmpty(savePath) || TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(savePath);
        com.ss.android.socialbase.downloader.g.a a = com.ss.android.socialbase.downloader.g.a.a(downloadInfo);
        if (str.equals("v1")) {
            return new j(context, a, downloadInfo.getTargetFilePath());
        }
        if (str.equals(DefaultDiskStorage.DEFAULT_DISK_STORAGE_VERSION_PREFIX)) {
            return new k(context, a, file.getAbsolutePath());
        }
        if (str.equals("v3")) {
            return new l(context, a, file.getAbsolutePath());
        }
        if (str.equals("o1")) {
            return new g(context, a, file.getAbsolutePath());
        }
        if (str.equals("o2")) {
            return new h(context, a, file.getAbsolutePath());
        }
        if (str.equals("o3")) {
            String dBJsonString = downloadInfo.getDBJsonString("file_content_uri");
            if (TextUtils.isEmpty(dBJsonString)) {
                return null;
            }
            return new i(context, a, file.getAbsolutePath(), dBJsonString, downloadInfo.getName());
        } else if (str.equals(ExceptionHandlerImpl.KEY_CUSTOM)) {
            return new c(context, a, file.getAbsolutePath(), jSONObject);
        } else {
            if (!str.equals("vbi")) {
                return null;
            }
            IDownloadFileUriProvider downloadFileUriProvider = Downloader.getInstance(context).getDownloadFileUriProvider(downloadInfo.getId());
            String d = com.ss.android.socialbase.appdownloader.d.j().d();
            return new m(context, a, com.ss.android.socialbase.appdownloader.c.a(downloadInfo.getId(), downloadFileUriProvider, context, d, new File(downloadInfo.getSavePath() + File.separator + downloadInfo.getName())).toString());
        }
    }

    public static boolean a(Context context, String str, JSONObject jSONObject, com.ss.android.socialbase.downloader.g.a aVar) {
        if (context == null || str == null) {
            return false;
        }
        a aVar2 = null;
        String b = com.ss.android.socialbase.appdownloader.c.b();
        if (TextUtils.isEmpty(b) || TextUtils.isEmpty(str)) {
            return false;
        }
        if (com.ss.android.socialbase.appdownloader.f.d.c() && str.equals("v1")) {
            aVar2 = new j(context, aVar, b);
        } else if (com.ss.android.socialbase.appdownloader.f.d.c() && str.equals(DefaultDiskStorage.DEFAULT_DISK_STORAGE_VERSION_PREFIX)) {
            aVar2 = new k(context, aVar, b);
        } else if (com.ss.android.socialbase.appdownloader.f.d.c() && str.equals("v3")) {
            aVar2 = new l(context, aVar, b);
        } else if (com.ss.android.socialbase.appdownloader.f.d.d() && str.equals("o1")) {
            aVar2 = new g(context, aVar, b);
        } else if (com.ss.android.socialbase.appdownloader.f.d.d() && str.equals("o2")) {
            aVar2 = new h(context, aVar, b);
        } else if (com.ss.android.socialbase.appdownloader.f.d.d() && str.equals("o3")) {
            aVar2 = new i(context, aVar, b, b, b);
        } else if (com.ss.android.socialbase.appdownloader.f.d.c() && str.equals(ExceptionHandlerImpl.KEY_CUSTOM)) {
            aVar2 = new c(context, aVar, b, jSONObject);
        } else if (com.ss.android.socialbase.appdownloader.f.d.c() && str.equals("vbi")) {
            aVar2 = new m(context, aVar, b);
        }
        if (aVar2 == null || !aVar2.a()) {
            return false;
        }
        return true;
    }
}
