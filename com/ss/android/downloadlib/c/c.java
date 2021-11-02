package com.ss.android.downloadlib.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.download.api.config.l;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.socialbase.downloader.depend.m;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
/* loaded from: classes2.dex */
public class c implements m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
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

    @Override // com.ss.android.socialbase.downloader.depend.m
    public void a(DownloadInfo downloadInfo) throws BaseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, downloadInfo) == null) {
            l j = j.j();
            if (downloadInfo == null || j == null) {
                return;
            }
            String packageName = downloadInfo.getPackageName();
            String targetFilePath = downloadInfo.getTargetFilePath();
            File a2 = a(packageName, targetFilePath);
            com.ss.android.downloadad.api.a.b a3 = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo);
            j.a(packageName, targetFilePath, a2, a3 != null ? com.ss.android.downloadlib.g.l.a(a3.g()) : null);
            downloadInfo.setMimeType("application/vnd.android.package-archive");
            downloadInfo.setName(a2.getName());
            downloadInfo.setMd5(null);
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.m
    public boolean b(DownloadInfo downloadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo)) == null) {
            if (downloadInfo != null) {
                return com.ss.android.download.api.c.b.a(com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()), downloadInfo.getMimeType());
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private File a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, str, str2)) == null) {
            File file = new File(str2);
            String name = file.getName();
            int lastIndexOf = name.lastIndexOf(46);
            if (lastIndexOf > 0) {
                str = name.substring(0, lastIndexOf);
            }
            return new File(file.getParent(), str + ".apk");
        }
        return (File) invokeLL.objValue;
    }
}
