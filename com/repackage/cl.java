package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.interfa.IPackageDownloadCallback;
import com.baidu.nps.interfa.IPackageGetCallback;
import com.baidu.nps.interfa.IPackageGetter;
import com.baidu.nps.pm.IBundleInfo;
import com.baidu.pyramid.annotation.Service;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
@Service
/* loaded from: classes5.dex */
public class cl implements IPackageGetter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1964043076, "Lcom/repackage/cl;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1964043076, "Lcom/repackage/cl;");
        }
    }

    public cl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.nps.interfa.IPackageGetter
    public void downloadBundle(IBundleInfo iBundleInfo, String str, int i, IPackageDownloadCallback iPackageDownloadCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048576, this, iBundleInfo, str, i, iPackageDownloadCallback) == null) {
            bl.e().f().i(iBundleInfo, str, i, iPackageDownloadCallback);
        }
    }

    @Override // com.baidu.nps.interfa.IPackageGetter
    public void getBundleInfo(List<IBundleInfo> list, IPackageGetCallback iPackageGetCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, iPackageGetCallback) == null) {
            bl.e().f().k(list, iPackageGetCallback);
        }
    }
}
