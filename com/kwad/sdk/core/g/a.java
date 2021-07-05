package com.kwad.sdk.core.g;

import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.plugin.DevelopMangerPlugin;
import com.kwad.sdk.utils.ae;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public class a extends com.kwad.sdk.core.network.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.g.a.f f36115b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(com.kwad.sdk.core.g.a.f fVar, com.kwad.sdk.core.g.a.l lVar) {
        this(fVar, null, false, lVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, lVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((com.kwad.sdk.core.g.a.f) objArr2[0], (List) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), (com.kwad.sdk.core.g.a.l) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public a(com.kwad.sdk.core.g.a.f fVar, @Nullable List<String> list, boolean z, com.kwad.sdk.core.g.a.l lVar) {
        DevelopMangerPlugin.DevelopValue a2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, list, Boolean.valueOf(z), lVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f36115b = fVar;
        JSONArray jSONArray = new JSONArray();
        com.kwad.sdk.utils.o.a(jSONArray, fVar.toJson());
        a("impInfo", jSONArray);
        a("universePhotoInfo", lVar);
        if (((DevelopMangerPlugin) com.kwad.sdk.plugin.g.a(DevelopMangerPlugin.class)).a("KEY_MODIFY_CREATEID") != null) {
            list = new ArrayList<>();
            list.add("creativeId_" + a2.getValue());
        }
        if (list != null) {
            a("preloadIdList", new JSONArray((Collection) list));
            a("preloadCheck", z);
        }
        b("appTag", ae.g(KsAdSDKImpl.get().getContext()));
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? com.kwad.sdk.d.b() : (String) invokeV.objValue;
    }
}
