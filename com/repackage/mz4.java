package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class mz4 {
    public static /* synthetic */ Interceptable $ic;
    public static cd0 a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements cd0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.repackage.mz4$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0479a implements nz4 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ bd0 a;

            public C0479a(a aVar, bd0 bd0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, bd0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bd0Var;
            }

            @Override // com.repackage.nz4
            public void onFileDownloadFailed(DownloadData downloadData, int i, String str) {
                bd0 bd0Var;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeLIL(1048576, this, downloadData, i, str) == null) || (bd0Var = this.a) == null) {
                    return;
                }
                bd0Var.onFailed(new Exception(str));
            }

            @Override // com.repackage.nz4
            public void onFileDownloadSucceed(DownloadData downloadData) {
                bd0 bd0Var;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) || (bd0Var = this.a) == null) {
                    return;
                }
                bd0Var.b(downloadData.getPath());
            }

            @Override // com.repackage.nz4
            public boolean onFileDownloaded(DownloadData downloadData) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadData)) == null) {
                    return true;
                }
                return invokeL.booleanValue;
            }

            @Override // com.repackage.nz4
            public void onFileUpdateProgress(DownloadData downloadData) {
                bd0 bd0Var;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048579, this, downloadData) == null) || (bd0Var = this.a) == null) {
                    return;
                }
                bd0Var.a(0L, 100L, (int) (downloadData.getLength() / downloadData.getSize()));
            }

            @Override // com.repackage.nz4
            public boolean onPreDownload(DownloadData downloadData) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, downloadData)) == null) {
                    bd0 bd0Var = this.a;
                    if (bd0Var != null) {
                        bd0Var.onStarted();
                        return true;
                    }
                    return true;
                }
                return invokeL.booleanValue;
            }
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.cd0
        public void a(String str, String str2, String str3, bd0 bd0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, str, str2, str3, bd0Var) == null) {
                DownloadData downloadData = new DownloadData();
                downloadData.setPath(str2 + "/" + str3);
                downloadData.setUrl(str);
                downloadData.setCallback(new C0479a(this, bd0Var));
                oz4.k().l(downloadData);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755482006, "Lcom/repackage/mz4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755482006, "Lcom/repackage/mz4;");
                return;
            }
        }
        a = new a();
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            vc0.q(a);
        }
    }
}
