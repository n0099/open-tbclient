package com.ss.android.downloadlib.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.g.l;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e implements com.ss.android.socialbase.downloader.d.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public e() {
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

    @Override // com.ss.android.socialbase.downloader.d.c
    public void a(int i2, String str, JSONObject jSONObject) {
        DownloadInfo downloadInfo;
        com.ss.android.downloadad.api.a.b a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(1048576, this, i2, str, jSONObject) == null) || (downloadInfo = Downloader.getInstance(j.getContext()).getDownloadInfo(i2)) == null || (a = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo)) == null) {
            return;
        }
        if ("install_view_result".equals(str)) {
            jSONObject = l.a(jSONObject);
            com.ss.android.downloadlib.a.a(jSONObject, downloadInfo);
            l.a(jSONObject, "model_id", Long.valueOf(a.b()));
        }
        com.ss.android.downloadlib.d.a.a().b(str, jSONObject, a);
    }

    @Override // com.ss.android.socialbase.downloader.d.c
    public void b(int i2, String str, JSONObject jSONObject) {
        DownloadInfo downloadInfo;
        com.ss.android.downloadad.api.a.b a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, jSONObject) == null) || (downloadInfo = Downloader.getInstance(j.getContext()).getDownloadInfo(i2)) == null || (a = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo)) == null) {
            return;
        }
        com.ss.android.downloadlib.d.a.a().a(str, jSONObject, a);
    }
}
