package com.kwad.sdk.entry.model;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.core.response.model.a f37235a;

    /* renamed from: b  reason: collision with root package name */
    public int f37236b;

    public a(@NonNull com.kwad.sdk.core.response.model.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f37235a = aVar;
    }

    public List<AdTemplate> a(SceneImpl sceneImpl) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sceneImpl)) == null) {
            List<AdTemplate> list = this.f37235a.k;
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (AdTemplate adTemplate : list) {
                arrayList.add(new CacheTemplate(adTemplate, sceneImpl));
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void a(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate) == null) || adTemplate == null || this.f37235a.k == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f37235a.k.size(); i2++) {
            if (adTemplate.equals(this.f37235a.k.get(i2))) {
                this.f37236b = i2;
                return;
            }
        }
    }
}
