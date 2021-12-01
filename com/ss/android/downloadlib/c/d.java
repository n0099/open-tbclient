package com.ss.android.downloadlib.c;

import androidx.annotation.WorkerThread;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.downloadlib.addownload.b.i;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.g.l;
import com.ss.android.socialbase.downloader.depend.k;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d implements com.ss.android.socialbase.appdownloader.c.g, k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.k
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.c.g
    public void a(DownloadInfo downloadInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, downloadInfo, z) == null) || downloadInfo == null) {
            return;
        }
        a(downloadInfo, downloadInfo.getRealStatus(), z);
    }

    @Override // com.ss.android.socialbase.appdownloader.c.g
    public void a(List<DownloadInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.k
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            com.ss.android.downloadlib.d.a().a(new Runnable(this) { // from class: com.ss.android.downloadlib.c.d.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    DownloadInfo downloadInfo;
                    int spIntVal;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.ss.android.downloadlib.addownload.b.f.a().b();
                        for (com.ss.android.downloadad.api.a.b bVar : com.ss.android.downloadlib.addownload.b.f.a().c().values()) {
                            int s = bVar.s();
                            if (s != 0) {
                                com.ss.android.socialbase.downloader.g.a a = com.ss.android.socialbase.downloader.g.a.a(s);
                                if (a.b("notification_opt_2") == 1 && (downloadInfo = Downloader.getInstance(j.getContext()).getDownloadInfo(s)) != null) {
                                    if (l.b(bVar) && !l.c(bVar.e())) {
                                        int spIntVal2 = downloadInfo.getSpIntVal("restart_notify_open_app_count");
                                        if (spIntVal2 < a.a("noti_open_restart_times", 1)) {
                                            h.a().e(bVar);
                                            downloadInfo.setSpValue("restart_notify_open_app_count", String.valueOf(spIntVal2 + 1));
                                        }
                                    } else if (downloadInfo.getRealStatus() == -2) {
                                        int spIntVal3 = downloadInfo.getSpIntVal("restart_notify_continue_count");
                                        if (spIntVal3 < a.a("noti_continue_restart_times", 1)) {
                                            h.a().a(bVar);
                                            downloadInfo.setSpValue("restart_notify_continue_count", String.valueOf(spIntVal3 + 1));
                                        }
                                    } else if (downloadInfo.getRealStatus() == -3 && com.ss.android.socialbase.downloader.i.f.c(downloadInfo) && !l.b(bVar) && (spIntVal = downloadInfo.getSpIntVal("restart_notify_install_count")) < a.a("noti_install_restart_times", 1)) {
                                        h.a().c(bVar);
                                        downloadInfo.setSpValue("restart_notify_install_count", String.valueOf(spIntVal + 1));
                                    }
                                }
                            }
                        }
                    }
                }
            }, 5000L);
        }
    }

    @WorkerThread
    public void a(DownloadInfo downloadInfo, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{downloadInfo, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            com.ss.android.downloadlib.addownload.b.f.a().b();
            com.ss.android.downloadad.api.a.b a = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo);
            if (a == null) {
                return;
            }
            try {
                if (z) {
                    a.c(downloadInfo.getFailedResumeCount());
                } else if (a.D() == -1) {
                    return;
                } else {
                    a.c(-1);
                }
                i.a().a(a);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("download_id", downloadInfo.getId());
                jSONObject.put("name", downloadInfo.getName());
                jSONObject.put("url", downloadInfo.getUrl());
                jSONObject.put("download_time", downloadInfo.getDownloadTime());
                jSONObject.put("download_status", i2);
                jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
                jSONObject.put(DownloadDataConstants.Columns.COLUMN_TOTAL_BYTES, downloadInfo.getTotalBytes());
                int i3 = 1;
                jSONObject.put("only_wifi", downloadInfo.isOnlyWifi() ? 1 : 0);
                jSONObject.put("chunk_count", downloadInfo.getChunkCount());
                if (!z) {
                    i3 = 2;
                }
                jSONObject.put("launch_resumed", i3);
                jSONObject.put("failed_resume_count", downloadInfo.getFailedResumeCount());
                com.ss.android.downloadlib.d.a.a().a("embeded_ad", "download_uncompleted", jSONObject, a);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
