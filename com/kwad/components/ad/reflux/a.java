package com.kwad.components.ad.reflux;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.c.b;
import com.kwad.components.core.c.a.c;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public final class a extends com.kwad.sdk.core.download.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int itemType;
    @Nullable
    public b kW;
    public int kX;
    public String kY;
    public String kZ;
    public String la;
    public String lb;
    public String lc;
    public boolean ld;
    public int le;
    public int lf;
    public int lg;
    public InterfaceC0543a lh;
    public c mApkDownloadHelper;
    public String title;

    /* renamed from: com.kwad.components.ad.reflux.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0543a {
        void eF();
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
        this.ld = false;
        this.le = -1;
        this.kW = bVar;
    }

    public static a a(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bVar)) == null) {
            AdTemplate adTemplate = bVar.getAdTemplate();
            AdInfo bQ = d.bQ(adTemplate);
            a aVar = new a(bVar);
            aVar.K(0);
            aVar.ld = com.kwad.sdk.core.response.a.a.am(bQ);
            aVar.kX = adTemplate.type;
            aVar.title = com.kwad.sdk.core.response.a.a.ad(bQ);
            aVar.kZ = com.kwad.sdk.core.response.a.a.J(bQ);
            aVar.lc = com.kwad.sdk.core.response.a.a.al(bQ);
            aVar.lb = com.kwad.sdk.core.response.a.a.ad(bQ);
            aVar.la = com.kwad.sdk.core.response.a.a.bl(bQ);
            aVar.kY = com.kwad.sdk.core.response.a.a.bn(bQ);
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    public static List<a> b(List<b> list, List<c> list2) {
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
                    a.setApkDownloadHelper(list2.get(i));
                    a.le = i;
                    arrayList.add(a);
                    i++;
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    private void eU() {
        InterfaceC0543a interfaceC0543a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || (interfaceC0543a = this.lh) == null) {
            return;
        }
        interfaceC0543a.eF();
    }

    private void setApkDownloadHelper(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, cVar) == null) {
            this.mApkDownloadHelper = cVar;
        }
    }

    public final void K(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.itemType = i;
        }
    }

    public final void a(InterfaceC0543a interfaceC0543a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC0543a) == null) {
            this.lh = interfaceC0543a;
        }
    }

    public final b eJ() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.kW : (b) invokeV.objValue;
    }

    public final void eK() {
        c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && eP() && (cVar = this.mApkDownloadHelper) != null) {
            cVar.b(this);
        }
    }

    public final String eL() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.kY : (String) invokeV.objValue;
    }

    public final String eM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.la : (String) invokeV.objValue;
    }

    public final String eN() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.lb : (String) invokeV.objValue;
    }

    public final String eO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.kZ : (String) invokeV.objValue;
    }

    public final boolean eP() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.ld : invokeV.booleanValue;
    }

    public final int eQ() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.le : invokeV.intValue;
    }

    public final int eR() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int i = this.itemType;
            return i == 0 ? this.kX : i;
        }
        return invokeV.intValue;
    }

    public final int eS() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.lf : invokeV.intValue;
    }

    public final int eT() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.lg : invokeV.intValue;
    }

    public final AdTemplate getAdTemplate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            b bVar = this.kW;
            if (bVar != null) {
                return bVar.getAdTemplate();
            }
            return null;
        }
        return (AdTemplate) invokeV.objValue;
    }

    public final c getApkDownloadHelper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mApkDownloadHelper : (c) invokeV.objValue;
    }

    public final String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.title : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onDownloadFailed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.lf = 11;
            eU();
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onDownloadFinished() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.lf = 8;
            eU();
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onIdle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.lf = 0;
            this.lg = 0;
            eU();
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onInstalled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.lf = 12;
            eU();
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onProgressUpdate(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.lf = 2;
            this.lg = i;
            eU();
        }
    }
}
