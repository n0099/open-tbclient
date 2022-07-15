package com.kwad.components.ad.reward.b;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Object a;
    public AdTemplate b;

    public b(@NonNull AdTemplate adTemplate, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adTemplate, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        try {
            this.a = new a(adTemplate, i);
        } catch (Throwable unused) {
            this.b = adTemplate;
        }
    }

    public static List<AdTemplate> a(List<b> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (b bVar : list) {
                arrayList.add(bVar.b());
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final Object a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0012  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final AdTemplate b() {
        InterceptResult invokeV;
        AdTemplate a;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) != null) {
            return (AdTemplate) invokeV.objValue;
        }
        Object obj = this.a;
        if (obj != null) {
            try {
                a = ((a) obj).a();
            } catch (Exception unused) {
            }
            return a != null ? this.b : a;
        }
        a = null;
        if (a != null) {
        }
    }
}
