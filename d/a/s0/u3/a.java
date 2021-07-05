package d.a.s0.u3;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static d.a.c0.a.g.b f67391a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.s0.u3.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C1788a implements d.a.c0.a.g.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d.a.s0.u3.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C1789a implements d.a.r0.v.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.a.c0.a.g.a f67392a;

            public C1789a(C1788a c1788a, d.a.c0.a.g.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1788a, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f67392a = aVar;
            }

            @Override // d.a.r0.v.c
            public void onFileDownloadFailed(DownloadData downloadData, int i2, String str) {
                d.a.c0.a.g.a aVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeLIL(1048576, this, downloadData, i2, str) == null) || (aVar = this.f67392a) == null) {
                    return;
                }
                aVar.onFailed(new Exception(str));
            }

            @Override // d.a.r0.v.c
            public void onFileDownloadSucceed(DownloadData downloadData) {
                d.a.c0.a.g.a aVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) || (aVar = this.f67392a) == null) {
                    return;
                }
                aVar.b(downloadData.getPath());
            }

            @Override // d.a.r0.v.c
            public boolean onFileDownloaded(DownloadData downloadData) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadData)) == null) {
                    return true;
                }
                return invokeL.booleanValue;
            }

            @Override // d.a.r0.v.c
            public void onFileUpdateProgress(DownloadData downloadData) {
                d.a.c0.a.g.a aVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048579, this, downloadData) == null) || (aVar = this.f67392a) == null) {
                    return;
                }
                aVar.a(0L, 100L, (int) (downloadData.getLength() / downloadData.getSize()));
            }

            @Override // d.a.r0.v.c
            public boolean onPreDownload(DownloadData downloadData) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, downloadData)) == null) {
                    d.a.c0.a.g.a aVar = this.f67392a;
                    if (aVar != null) {
                        aVar.onStarted();
                        return true;
                    }
                    return true;
                }
                return invokeL.booleanValue;
            }
        }

        public C1788a() {
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

        @Override // d.a.c0.a.g.b
        public void a(String str, String str2, String str3, d.a.c0.a.g.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, str, str2, str3, aVar) == null) {
                DownloadData downloadData = new DownloadData();
                downloadData.setPath(str2 + "/" + str3);
                downloadData.setUrl(str);
                downloadData.setCallback(new C1789a(this, aVar));
                d.a.r0.v.d.j().k(downloadData);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-625325666, "Ld/a/s0/u3/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-625325666, "Ld/a/s0/u3/a;");
                return;
            }
        }
        f67391a = new C1788a();
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            d.a.c0.a.b.r(f67391a);
        }
    }
}
