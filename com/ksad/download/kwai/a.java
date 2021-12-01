package com.ksad.download.kwai;

import android.content.Context;
import android.content.Intent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.ksad.download.DownloadTask;
import com.kwad.sdk.api.proxy.app.DownloadService;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, context, str) == null) {
            com.kwad.sdk.core.d.a.a("DownloadClient", "pauseDownload");
            try {
                Intent intent = new Intent(context, DownloadService.class);
                intent.putExtra("download_service_type_tag", 2);
                intent.putExtra("download_service_id_tag", str);
                context.startService(intent);
            } catch (Exception unused) {
            }
        }
    }

    public static void a(Context context, String str, DownloadTask.DownloadRequest downloadRequest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, context, str, downloadRequest) == null) {
            try {
                Intent intent = new Intent(context, DownloadService.class);
                intent.putExtra("download_service_type_tag", 1);
                intent.putExtra("download_service_id_tag", str);
                intent.putExtra("download_service_args_tag", downloadRequest);
                context.startService(intent);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void b(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, str) == null) {
            com.kwad.sdk.core.d.a.a("DownloadClient", "cancelDownload");
            try {
                Intent intent = new Intent(context, DownloadService.class);
                intent.putExtra("download_service_type_tag", 4);
                intent.putExtra("download_service_id_tag", str);
                context.startService(intent);
            } catch (Exception unused) {
            }
        }
    }
}
