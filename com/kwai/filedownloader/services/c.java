package com.kwai.filedownloader.services;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.filedownloader.d.b;
import com.kwai.filedownloader.e.c;
import com.kwai.filedownloader.kwai.c;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a a;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c.InterfaceC2016c a;

        /* renamed from: b  reason: collision with root package name */
        public Integer f41770b;

        /* renamed from: c  reason: collision with root package name */
        public c.e f41771c;

        /* renamed from: d  reason: collision with root package name */
        public c.b f41772d;

        /* renamed from: e  reason: collision with root package name */
        public c.a f41773e;

        /* renamed from: f  reason: collision with root package name */
        public c.d f41774f;

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

        public a a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                if (i > 0) {
                    this.f41770b = Integer.valueOf(i);
                }
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a a(c.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar)) == null) {
                this.f41772d = bVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? com.kwai.filedownloader.e.f.a("component: database[%s], maxNetworkCount[%s], outputStream[%s], connection[%s], connectionCountAdapter[%s]", this.a, this.f41770b, this.f41771c, this.f41772d, this.f41773e) : (String) invokeV.objValue;
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
    }

    public c(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = aVar;
    }

    private c.d g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? new b() : (c.d) invokeV.objValue;
    }

    private int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? com.kwai.filedownloader.e.e.a().f41702e : invokeV.intValue;
    }

    private com.kwai.filedownloader.a.a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? new com.kwai.filedownloader.a.c() : (com.kwai.filedownloader.a.a) invokeV.objValue;
    }

    private c.e j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) ? new b.a() : (c.e) invokeV.objValue;
    }

    private c.b k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) ? new c.b() : (c.b) invokeV.objValue;
    }

    private c.a l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) ? new com.kwai.filedownloader.kwai.a() : (c.a) invokeV.objValue;
    }

    public int a() {
        InterceptResult invokeV;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            a aVar = this.a;
            if (aVar != null && (num = aVar.f41770b) != null) {
                if (com.kwai.filedownloader.e.d.a) {
                    com.kwai.filedownloader.e.d.c(this, "initial FileDownloader manager with the customize maxNetworkThreadCount: %d", num);
                }
                return com.kwai.filedownloader.e.e.a(num.intValue());
            }
            return h();
        }
        return invokeV.intValue;
    }

    public com.kwai.filedownloader.a.a b() {
        InterceptResult invokeV;
        c.InterfaceC2016c interfaceC2016c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            a aVar = this.a;
            if (aVar == null || (interfaceC2016c = aVar.a) == null) {
                return i();
            }
            com.kwai.filedownloader.a.a a2 = interfaceC2016c.a();
            if (a2 != null) {
                if (com.kwai.filedownloader.e.d.a) {
                    com.kwai.filedownloader.e.d.c(this, "initial FileDownloader manager with the customize database: %s", a2);
                }
                return a2;
            }
            return i();
        }
        return (com.kwai.filedownloader.a.a) invokeV.objValue;
    }

    public c.e c() {
        InterceptResult invokeV;
        c.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            a aVar = this.a;
            if (aVar != null && (eVar = aVar.f41771c) != null) {
                if (com.kwai.filedownloader.e.d.a) {
                    com.kwai.filedownloader.e.d.c(this, "initial FileDownloader manager with the customize output stream: %s", eVar);
                }
                return eVar;
            }
            return j();
        }
        return (c.e) invokeV.objValue;
    }

    public c.b d() {
        InterceptResult invokeV;
        c.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            a aVar = this.a;
            if (aVar != null && (bVar = aVar.f41772d) != null) {
                if (com.kwai.filedownloader.e.d.a) {
                    com.kwai.filedownloader.e.d.c(this, "initial FileDownloader manager with the customize connection creator: %s", bVar);
                }
                return bVar;
            }
            return k();
        }
        return (c.b) invokeV.objValue;
    }

    public c.a e() {
        InterceptResult invokeV;
        c.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            a aVar2 = this.a;
            if (aVar2 != null && (aVar = aVar2.f41773e) != null) {
                if (com.kwai.filedownloader.e.d.a) {
                    com.kwai.filedownloader.e.d.c(this, "initial FileDownloader manager with the customize connection count adapter: %s", aVar);
                }
                return aVar;
            }
            return l();
        }
        return (c.a) invokeV.objValue;
    }

    public c.d f() {
        InterceptResult invokeV;
        c.d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            a aVar = this.a;
            if (aVar != null && (dVar = aVar.f41774f) != null) {
                if (com.kwai.filedownloader.e.d.a) {
                    com.kwai.filedownloader.e.d.c(this, "initial FileDownloader manager with the customize id generator: %s", dVar);
                }
                return dVar;
            }
            return g();
        }
        return (c.d) invokeV.objValue;
    }
}
