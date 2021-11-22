package com.kwai.filedownloader.services;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.filedownloader.a.c;
import com.kwai.filedownloader.e.b;
import com.kwai.filedownloader.f.c;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final a f67977a;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public c.InterfaceC1984c f67978a;

        /* renamed from: b  reason: collision with root package name */
        public Integer f67979b;

        /* renamed from: c  reason: collision with root package name */
        public c.e f67980c;

        /* renamed from: d  reason: collision with root package name */
        public c.b f67981d;

        /* renamed from: e  reason: collision with root package name */
        public c.a f67982e;

        /* renamed from: f  reason: collision with root package name */
        public c.d f67983f;

        public a() {
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

        public a a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                if (i2 > 0) {
                    this.f67979b = Integer.valueOf(i2);
                }
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a a(c.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar)) == null) {
                this.f67981d = bVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? com.kwai.filedownloader.f.f.a("component: database[%s], maxNetworkCount[%s], outputStream[%s], connection[%s], connectionCountAdapter[%s]", this.f67978a, this.f67979b, this.f67980c, this.f67981d, this.f67982e) : (String) invokeV.objValue;
        }
    }

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
                return;
            }
        }
        this.f67977a = null;
    }

    public c(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f67977a = aVar;
    }

    private c.d g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? new b() : (c.d) invokeV.objValue;
    }

    private int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? com.kwai.filedownloader.f.e.a().f67891e : invokeV.intValue;
    }

    private com.kwai.filedownloader.b.a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? new com.kwai.filedownloader.b.c() : (com.kwai.filedownloader.b.a) invokeV.objValue;
    }

    private c.e j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) ? new b.a() : (c.e) invokeV.objValue;
    }

    private c.b k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) ? new c.b() : (c.b) invokeV.objValue;
    }

    private c.a l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) ? new com.kwai.filedownloader.a.a() : (c.a) invokeV.objValue;
    }

    public int a() {
        InterceptResult invokeV;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            a aVar = this.f67977a;
            if (aVar != null && (num = aVar.f67979b) != null) {
                if (com.kwai.filedownloader.f.d.f67886a) {
                    com.kwai.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize maxNetworkThreadCount: %d", num);
                }
                return com.kwai.filedownloader.f.e.a(num.intValue());
            }
            return h();
        }
        return invokeV.intValue;
    }

    public com.kwai.filedownloader.b.a b() {
        InterceptResult invokeV;
        c.InterfaceC1984c interfaceC1984c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            a aVar = this.f67977a;
            if (aVar == null || (interfaceC1984c = aVar.f67978a) == null) {
                return i();
            }
            com.kwai.filedownloader.b.a a2 = interfaceC1984c.a();
            if (a2 != null) {
                if (com.kwai.filedownloader.f.d.f67886a) {
                    com.kwai.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize database: %s", a2);
                }
                return a2;
            }
            return i();
        }
        return (com.kwai.filedownloader.b.a) invokeV.objValue;
    }

    public c.e c() {
        InterceptResult invokeV;
        c.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            a aVar = this.f67977a;
            if (aVar != null && (eVar = aVar.f67980c) != null) {
                if (com.kwai.filedownloader.f.d.f67886a) {
                    com.kwai.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize output stream: %s", eVar);
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
            a aVar = this.f67977a;
            if (aVar != null && (bVar = aVar.f67981d) != null) {
                if (com.kwai.filedownloader.f.d.f67886a) {
                    com.kwai.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize connection creator: %s", bVar);
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
            a aVar2 = this.f67977a;
            if (aVar2 != null && (aVar = aVar2.f67982e) != null) {
                if (com.kwai.filedownloader.f.d.f67886a) {
                    com.kwai.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize connection count adapter: %s", aVar);
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
            a aVar = this.f67977a;
            if (aVar != null && (dVar = aVar.f67983f) != null) {
                if (com.kwai.filedownloader.f.d.f67886a) {
                    com.kwai.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize id generator: %s", dVar);
                }
                return dVar;
            }
            return g();
        }
        return (c.d) invokeV.objValue;
    }
}
