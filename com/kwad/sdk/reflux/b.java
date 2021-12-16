package com.kwad.sdk.reflux;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.download.a.c;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f59428b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f59429c;

    /* renamed from: d  reason: collision with root package name */
    public int f59430d;

    /* renamed from: e  reason: collision with root package name */
    public String f59431e;

    /* renamed from: f  reason: collision with root package name */
    public String f59432f;

    /* renamed from: g  reason: collision with root package name */
    public String f59433g;

    /* renamed from: h  reason: collision with root package name */
    public String f59434h;

    /* renamed from: i  reason: collision with root package name */
    public String f59435i;

    /* renamed from: j  reason: collision with root package name */
    public String f59436j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f59437k;
    public int l;
    public com.kwad.sdk.core.download.a.b m;
    public int n;
    public int o;
    public a p;

    /* loaded from: classes3.dex */
    public interface a {
        void a(b bVar);
    }

    public b() {
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
        this.f59437k = false;
        this.l = -1;
    }

    public static b a(AdTemplate adTemplate) {
        InterceptResult invokeL;
        String h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adTemplate)) == null) {
            AdInfo j2 = d.j(adTemplate);
            b bVar = new b();
            bVar.b(0);
            bVar.f59437k = com.kwad.sdk.core.response.a.a.B(j2);
            bVar.f59430d = adTemplate.type;
            bVar.f59429c = adTemplate;
            bVar.f59431e = com.kwad.sdk.core.response.a.a.s(j2);
            List<String> O = com.kwad.sdk.core.response.a.a.O(j2);
            if (O.size() <= 0) {
                if (com.kwad.sdk.core.response.a.a.P(j2)) {
                    h2 = com.kwad.sdk.core.response.a.a.h(j2);
                }
                bVar.f59436j = com.kwad.sdk.core.response.a.a.A(j2);
                bVar.f59435i = com.kwad.sdk.core.response.a.a.s(j2);
                bVar.f59434h = com.kwad.sdk.core.response.a.a.at(j2);
                bVar.f59432f = com.kwad.sdk.core.response.a.a.au(j2);
                return bVar;
            }
            h2 = O.get(0);
            bVar.f59433g = h2;
            bVar.f59436j = com.kwad.sdk.core.response.a.a.A(j2);
            bVar.f59435i = com.kwad.sdk.core.response.a.a.s(j2);
            bVar.f59434h = com.kwad.sdk.core.response.a.a.at(j2);
            bVar.f59432f = com.kwad.sdk.core.response.a.a.au(j2);
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public static List<b> a(List<AdTemplate> list, List<com.kwad.sdk.core.download.a.b> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, list, list2)) == null) {
            ArrayList arrayList = null;
            if (list != null && list.size() != 0 && list2.size() != 0) {
                if (list.size() != list2.size()) {
                    return null;
                }
                arrayList = new ArrayList();
                int i2 = 0;
                for (AdTemplate adTemplate : list) {
                    b a2 = a(adTemplate);
                    a2.a(list2.get(i2));
                    a2.l = i2;
                    arrayList.add(a2);
                    i2++;
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    private void o() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || (aVar = this.p) == null) {
            return;
        }
        aVar.a(this);
    }

    public void a(com.kwad.sdk.core.download.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.m = bVar;
        }
    }

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.p = aVar;
        }
    }

    public void b() {
        com.kwad.sdk.core.download.a.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && i() && (bVar = this.m) != null) {
            bVar.a(this);
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f59428b = i2;
        }
    }

    public AdTemplate c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f59429c : (AdTemplate) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f59431e : (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f59432f : (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f59434h : (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f59435i : (String) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f59433g : (String) invokeV.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f59437k : invokeV.booleanValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.l : invokeV.intValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            int i2 = this.f59428b;
            return i2 == 0 ? this.f59430d : i2;
        }
        return invokeV.intValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.n : invokeV.intValue;
    }

    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.o : invokeV.intValue;
    }

    public com.kwad.sdk.core.download.a.b n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.m : (com.kwad.sdk.core.download.a.b) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFailed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.n = 11;
            o();
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFinished() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.n = 8;
            o();
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onIdle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.n = 0;
            this.o = 0;
            o();
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onInstalled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.n = 12;
            o();
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onProgressUpdate(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.n = 2;
            this.o = i2;
            o();
        }
    }
}
