package com.kwad.components.core.j;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.r;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a extends com.kwad.sdk.core.network.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.components.core.j.kwai.b a;
    public int b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(com.kwad.components.core.j.kwai.a aVar) {
        this(aVar.a, aVar.c, aVar.d, aVar.f);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((com.kwad.components.core.j.kwai.b) objArr2[0], (List) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), (com.kwad.components.core.j.kwai.d) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = aVar.e ? 1 : 0;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(com.kwad.components.core.j.kwai.b bVar) {
        this(bVar, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((com.kwad.components.core.j.kwai.b) objArr2[0], (com.kwad.components.core.j.kwai.d) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(com.kwad.components.core.j.kwai.b bVar, com.kwad.components.core.j.kwai.d dVar) {
        this(bVar, null, false, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, dVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((com.kwad.components.core.j.kwai.b) objArr2[0], (List) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), (com.kwad.components.core.j.kwai.d) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(com.kwad.components.core.j.kwai.b bVar, @Nullable List<String> list, boolean z, com.kwad.components.core.j.kwai.d dVar) {
        super(b(bVar), a(bVar), bVar != null ? bVar.a : null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, list, Boolean.valueOf(z), dVar};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Long) objArr2[0]).longValue(), ((Integer) objArr2[1]).intValue(), (SceneImpl) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.a = bVar;
        com.kwad.sdk.internal.api.a a = bVar.a();
        if (a != null && !a.b()) {
            a(com.kwad.sdk.core.request.model.a.a(), a);
        }
        JSONArray jSONArray = new JSONArray();
        r.a(jSONArray, bVar.toJson());
        putBody("impInfo", jSONArray);
        putBody("universePhotoInfo", dVar);
        int i3 = this.b;
        if (i3 > 0) {
            putBody("calledUnionType", i3);
        }
        com.kwad.sdk.components.c.a(DevelopMangerComponents.class);
        if (!TextUtils.isEmpty("")) {
            putBody("universeDebugParam", "");
        }
        com.kwad.sdk.components.c.a(DevelopMangerComponents.class);
        if (list != null) {
            putBody("preloadIdList", new JSONArray((Collection) list));
            putBody("preloadCheck", z);
        }
        putBody("appTag", as.e());
        com.kwad.sdk.components.c.a(DevelopMangerComponents.class);
        String a2 = this.a.a("thirdUserId");
        com.kwad.sdk.core.request.model.g a3 = com.kwad.sdk.core.request.model.g.a();
        if (a2 != null) {
            a3.a(a2);
        }
        if (a != null && !a.a()) {
            a(a3, a);
        }
        putBody("userInfo", a3);
    }

    public static int a(com.kwad.components.core.j.kwai.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bVar)) == null) {
            try {
                return bVar.a.getScreenOrientation();
            } catch (Throwable unused) {
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public static void a(com.kwad.sdk.core.request.model.g gVar, com.kwad.sdk.internal.api.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, gVar, aVar) == null) {
            int i = aVar.a;
            if (i != 0) {
                gVar.a = i;
            }
            int i2 = aVar.b;
            if (i2 != 0) {
                gVar.b = i2;
            }
            if (TextUtils.isEmpty(aVar.c)) {
                return;
            }
            gVar.c = aVar.c;
        }
    }

    private void a(JSONObject jSONObject, com.kwad.sdk.internal.api.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, this, jSONObject, aVar) == null) {
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(aVar.d)) {
                r.a(jSONObject2, "prevTitle", aVar.d);
            }
            if (!TextUtils.isEmpty(aVar.e)) {
                r.a(jSONObject2, "postTitle", aVar.e);
            }
            if (!TextUtils.isEmpty(aVar.f)) {
                r.a(jSONObject2, "historyTitle", aVar.f);
            }
            if (!TextUtils.isEmpty(aVar.g)) {
                r.a(jSONObject2, "channel", aVar.g);
            }
            r.a(jSONObject, "content", jSONObject2);
            putBody(DI.APP_INFO_NAME, jSONObject);
        }
    }

    public static long b(com.kwad.components.core.j.kwai.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, bVar)) == null) ? bVar.a.getPosId() : invokeL.longValue;
    }

    public final int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.a.getAdNum() : invokeV.intValue;
    }

    public final void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.b = i;
        }
    }

    @Override // com.kwad.sdk.core.network.b
    public SceneImpl getScene() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            com.kwad.components.core.j.kwai.b bVar = this.a;
            if (bVar != null) {
                return bVar.a;
            }
            return null;
        }
        return (SceneImpl) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? com.kwad.sdk.b.b() : (String) invokeV.objValue;
    }
}
