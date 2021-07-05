package d.a.c.g;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.interfa.IPackageDownloadCallback;
import com.baidu.searchbox.pms.bean.ErrorInfo;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.searchbox.pms.callback.DownloadCallback;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class b implements DownloadCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public IPackageDownloadCallback f44605a;

    public b(IPackageDownloadCallback iPackageDownloadCallback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iPackageDownloadCallback};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f44605a = iPackageDownloadCallback;
    }

    @Override // com.baidu.searchbox.pms.callback.DownloadCallback
    public void onBulkDownloaded(List<PackageInfo> list, List<PackageInfo> list2, List<PackageInfo> list3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, list, list2, list3) == null) {
        }
    }

    @Override // com.baidu.searchbox.pms.callback.DownloadCallback
    public void onDownloadCancel(PackageInfo packageInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, packageInfo) == null) {
        }
    }

    @Override // com.baidu.searchbox.pms.callback.DownloadCallback
    public void onDownloadError(PackageInfo packageInfo, ErrorInfo errorInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, packageInfo, errorInfo) == null) {
            this.f44605a.onPackageDownloadFail(packageInfo.packageName, errorInfo.code, errorInfo.errorMsg);
            d.a.c.g.h.b.b(packageInfo.packageName, 1, packageInfo.version);
        }
    }

    @Override // com.baidu.searchbox.pms.callback.DownloadCallback
    public void onDownloadPause(PackageInfo packageInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, packageInfo) == null) {
        }
    }

    @Override // com.baidu.searchbox.pms.callback.DownloadCallback
    public void onDownloadProgress(PackageInfo packageInfo, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{packageInfo, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.f44605a.onProgress(j, j2);
        }
    }

    @Override // com.baidu.searchbox.pms.callback.DownloadCallback
    public void onDownloadResume(PackageInfo packageInfo, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{packageInfo, Long.valueOf(j), Long.valueOf(j2)}) == null) {
        }
    }

    @Override // com.baidu.searchbox.pms.callback.DownloadCallback
    public void onDownloadStart(PackageInfo packageInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, packageInfo) == null) {
        }
    }

    @Override // com.baidu.searchbox.pms.callback.DownloadCallback
    public void onDownloadSuccess(PackageInfo packageInfo, ErrorInfo errorInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, packageInfo, errorInfo) == null) {
            this.f44605a.onPackageDownloadSuccess(packageInfo.packageName, packageInfo.filePath);
            d.a.c.g.h.b.b(packageInfo.packageName, 0, packageInfo.version);
        }
    }
}
