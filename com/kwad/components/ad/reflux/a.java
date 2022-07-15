package com.kwad.components.ad.reflux;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.b.b;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public final class a extends com.kwad.sdk.core.download.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    @Nullable
    public b b;
    public int c;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public boolean k;
    public int l;
    public com.kwad.components.core.c.a.b m;
    public int n;
    public int o;
    public InterfaceC0474a p;

    /* renamed from: com.kwad.components.ad.reflux.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0474a {
        void a();
    }

    public a(@Nullable b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = false;
        this.l = -1;
        this.b = bVar;
    }

    public static a a(b bVar) {
        InterceptResult invokeL;
        String k;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bVar)) == null) {
            AdTemplate b = bVar.b();
            AdInfo i = d.i(b);
            a aVar = new a(bVar);
            aVar.b(0);
            aVar.k = com.kwad.sdk.core.response.a.a.I(i);
            aVar.c = b.type;
            aVar.e = com.kwad.sdk.core.response.a.a.z(i);
            List<String> V = com.kwad.sdk.core.response.a.a.V(i);
            if (V.size() <= 0) {
                if (com.kwad.sdk.core.response.a.a.W(i)) {
                    k = com.kwad.sdk.core.response.a.a.k(i);
                }
                aVar.j = com.kwad.sdk.core.response.a.a.H(i);
                aVar.i = com.kwad.sdk.core.response.a.a.z(i);
                aVar.h = com.kwad.sdk.core.response.a.a.aC(i);
                aVar.f = com.kwad.sdk.core.response.a.a.aE(i);
                return aVar;
            }
            k = V.get(0);
            aVar.g = k;
            aVar.j = com.kwad.sdk.core.response.a.a.H(i);
            aVar.i = com.kwad.sdk.core.response.a.a.z(i);
            aVar.h = com.kwad.sdk.core.response.a.a.aC(i);
            aVar.f = com.kwad.sdk.core.response.a.a.aE(i);
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    public static List<a> a(List<b> list, List<com.kwad.components.core.c.a.b> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, list, list2)) == null) {
            ArrayList arrayList = null;
            if (list != null && list.size() != 0 && list2.size() != 0) {
                if (list.size() != list2.size()) {
                    return null;
                }
                arrayList = new ArrayList();
                int i = 0;
                for (b bVar : list) {
                    a a = a(bVar);
                    a.a(list2.get(i));
                    a.l = i;
                    arrayList.add(a);
                    i++;
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    private void a(com.kwad.components.core.c.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, bVar) == null) {
            this.m = bVar;
        }
    }

    private void p() {
        InterfaceC0474a interfaceC0474a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || (interfaceC0474a = this.p) == null) {
            return;
        }
        interfaceC0474a.a();
    }

    public final b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (b) invokeV.objValue;
    }

    public final void a(InterfaceC0474a interfaceC0474a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC0474a) == null) {
            this.p = interfaceC0474a;
        }
    }

    public final void b() {
        com.kwad.components.core.c.a.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && i() && (bVar = this.m) != null) {
            bVar.a(this);
        }
    }

    public final void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.a = i;
        }
    }

    public final AdTemplate c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            b bVar = this.b;
            if (bVar != null) {
                return bVar.b();
            }
            return null;
        }
        return (AdTemplate) invokeV.objValue;
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.e : (String) invokeV.objValue;
    }

    public final String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f : (String) invokeV.objValue;
    }

    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.h : (String) invokeV.objValue;
    }

    public final String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.i : (String) invokeV.objValue;
    }

    public final String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.g : (String) invokeV.objValue;
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public final int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.l : invokeV.intValue;
    }

    public final int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            int i = this.a;
            return i == 0 ? this.c : i;
        }
        return invokeV.intValue;
    }

    public final int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.n : invokeV.intValue;
    }

    public final int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.o : invokeV.intValue;
    }

    public final com.kwad.components.core.c.a.b n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.m : (com.kwad.components.core.c.a.b) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onDownloadFailed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.n = 11;
            p();
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onDownloadFinished() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.n = 8;
            p();
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onIdle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.n = 0;
            this.o = 0;
            p();
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onInstalled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.n = 12;
            p();
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onProgressUpdate(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.n = 2;
            this.o = i;
            p();
        }
    }
}
