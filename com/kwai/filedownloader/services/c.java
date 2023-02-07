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
/* loaded from: classes8.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a awq;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c.InterfaceC0654c awr;
        public Integer aws;
        public c.e awt;
        public c.b awu;
        public c.a awv;
        public c.d aww;

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

        public final a a(c.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                this.awu = bVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a cA(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                this.aws = Integer.MAX_VALUE;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? com.kwai.filedownloader.e.f.h("component: database[%s], maxNetworkCount[%s], outputStream[%s], connection[%s], connectionCountAdapter[%s]", this.awr, this.aws, this.awt, this.awu, this.awv) : (String) invokeV.objValue;
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
        this.awq = null;
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
        this.awq = aVar;
    }

    public static c.b EA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new c.b() : (c.b) invokeV.objValue;
    }

    public static c.a EB() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new com.kwai.filedownloader.kwai.a() : (c.a) invokeV.objValue;
    }

    public static c.d Ew() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? new b() : (c.d) invokeV.objValue;
    }

    public static int Ex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? com.kwai.filedownloader.e.e.EL().awQ : invokeV.intValue;
    }

    public static com.kwai.filedownloader.a.a Ey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? new com.kwai.filedownloader.a.c() : (com.kwai.filedownloader.a.a) invokeV.objValue;
    }

    public static c.e Ez() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? new b.a() : (c.e) invokeV.objValue;
    }

    public final int Ds() {
        InterceptResult invokeV;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            a aVar = this.awq;
            if (aVar != null && (num = aVar.aws) != null) {
                if (com.kwai.filedownloader.e.d.awL) {
                    com.kwai.filedownloader.e.d.e(this, "initial FileDownloader manager with the customize maxNetworkThreadCount: %d", num);
                }
                return com.kwai.filedownloader.e.e.cE(num.intValue());
            }
            return Ex();
        }
        return invokeV.intValue;
    }

    public final com.kwai.filedownloader.a.a Er() {
        InterceptResult invokeV;
        c.InterfaceC0654c interfaceC0654c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            a aVar = this.awq;
            if (aVar == null || (interfaceC0654c = aVar.awr) == null) {
                return Ey();
            }
            com.kwai.filedownloader.a.a EK = interfaceC0654c.EK();
            if (EK != null) {
                if (com.kwai.filedownloader.e.d.awL) {
                    com.kwai.filedownloader.e.d.e(this, "initial FileDownloader manager with the customize database: %s", EK);
                }
                return EK;
            }
            return Ey();
        }
        return (com.kwai.filedownloader.a.a) invokeV.objValue;
    }

    public final c.e Es() {
        InterceptResult invokeV;
        c.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            a aVar = this.awq;
            if (aVar != null && (eVar = aVar.awt) != null) {
                if (com.kwai.filedownloader.e.d.awL) {
                    com.kwai.filedownloader.e.d.e(this, "initial FileDownloader manager with the customize output stream: %s", eVar);
                }
                return eVar;
            }
            return Ez();
        }
        return (c.e) invokeV.objValue;
    }

    public final c.b Et() {
        InterceptResult invokeV;
        c.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            a aVar = this.awq;
            if (aVar != null && (bVar = aVar.awu) != null) {
                if (com.kwai.filedownloader.e.d.awL) {
                    com.kwai.filedownloader.e.d.e(this, "initial FileDownloader manager with the customize connection creator: %s", bVar);
                }
                return bVar;
            }
            return EA();
        }
        return (c.b) invokeV.objValue;
    }

    public final c.a Eu() {
        InterceptResult invokeV;
        c.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            a aVar2 = this.awq;
            if (aVar2 != null && (aVar = aVar2.awv) != null) {
                if (com.kwai.filedownloader.e.d.awL) {
                    com.kwai.filedownloader.e.d.e(this, "initial FileDownloader manager with the customize connection count adapter: %s", aVar);
                }
                return aVar;
            }
            return EB();
        }
        return (c.a) invokeV.objValue;
    }

    public final c.d Ev() {
        InterceptResult invokeV;
        c.d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            a aVar = this.awq;
            if (aVar != null && (dVar = aVar.aww) != null) {
                if (com.kwai.filedownloader.e.d.awL) {
                    com.kwai.filedownloader.e.d.e(this, "initial FileDownloader manager with the customize id generator: %s", dVar);
                }
                return dVar;
            }
            return Ew();
        }
        return (c.d) invokeV.objValue;
    }
}
