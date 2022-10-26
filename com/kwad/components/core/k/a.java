package com.kwad.components.core.k;

import android.text.TextUtils;
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
import com.kwad.sdk.utils.r;
import com.kwad.sdk.utils.w;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a extends com.kwad.sdk.core.network.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.components.core.k.kwai.b EI;
    public int HI;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(com.kwad.components.core.k.kwai.a aVar) {
        this(aVar.EI, aVar.HO, aVar.HP, aVar.HR);
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
                this((com.kwad.components.core.k.kwai.b) objArr2[0], (List) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), (com.kwad.components.core.k.kwai.d) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.HI = aVar.HQ ? 1 : 0;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(com.kwad.components.core.k.kwai.b bVar) {
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
                this((com.kwad.components.core.k.kwai.b) objArr2[0], (com.kwad.components.core.k.kwai.d) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(com.kwad.components.core.k.kwai.b bVar, com.kwad.components.core.k.kwai.d dVar) {
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
                this((com.kwad.components.core.k.kwai.b) objArr2[0], (List) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), (com.kwad.components.core.k.kwai.d) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(com.kwad.components.core.k.kwai.b bVar, List list, boolean z, com.kwad.components.core.k.kwai.d dVar) {
        super(b(bVar), a(bVar), bVar != null ? bVar.HS : null);
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
        putBody("timestamp", System.currentTimeMillis());
        this.EI = bVar;
        com.kwad.sdk.internal.api.a op = bVar.op();
        if (op != null && !op.xq()) {
            a(com.kwad.sdk.core.request.model.a.uM(), op);
        }
        JSONArray jSONArray = new JSONArray();
        r.putValue(jSONArray, bVar.toJson());
        putBody("impInfo", jSONArray);
        putBody("universePhotoInfo", dVar);
        int i3 = this.HI;
        if (i3 > 0) {
            putBody("calledUnionType", i3);
        }
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        if (!TextUtils.isEmpty("")) {
            putBody("universeDebugParam", "");
        }
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        if (list != null) {
            putBody("preloadIdList", new JSONArray((Collection) list));
            putBody("preloadCheck", z);
        }
        putBody("appTag", w.zD());
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        String av = this.EI.av("thirdUserId");
        com.kwad.sdk.core.request.model.g uT = com.kwad.sdk.core.request.model.g.uT();
        if (av != null) {
            uT.cu(av);
        }
        if (op != null && !op.xp()) {
            a(uT, op);
        }
        putBody("userInfo", uT);
    }

    public static int a(com.kwad.components.core.k.kwai.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bVar)) == null) {
            try {
                return bVar.HS.getScreenOrientation();
            } catch (Throwable unused) {
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public static void a(com.kwad.sdk.core.request.model.g gVar, com.kwad.sdk.internal.api.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, gVar, aVar) == null) {
            int i = aVar.acZ;
            if (i != 0) {
                gVar.acZ = i;
            }
            int i2 = aVar.ada;
            if (i2 != 0) {
                gVar.ada = i2;
            }
            if (TextUtils.isEmpty(aVar.adb)) {
                return;
            }
            gVar.adb = aVar.adb;
        }
    }

    private void a(JSONObject jSONObject, com.kwad.sdk.internal.api.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, this, jSONObject, aVar) == null) {
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(aVar.aiz)) {
                r.putValue(jSONObject2, "prevTitle", aVar.aiz);
            }
            if (!TextUtils.isEmpty(aVar.aiA)) {
                r.putValue(jSONObject2, "postTitle", aVar.aiA);
            }
            if (!TextUtils.isEmpty(aVar.aiB)) {
                r.putValue(jSONObject2, "historyTitle", aVar.aiB);
            }
            if (!TextUtils.isEmpty(aVar.agM)) {
                r.putValue(jSONObject2, "channel", aVar.agM);
            }
            r.putValue(jSONObject, "content", jSONObject2);
            putBody(DI.APP_INFO_NAME, jSONObject);
        }
    }

    public static long b(com.kwad.components.core.k.kwai.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, bVar)) == null) ? bVar.HS.getPosId() : invokeL.longValue;
    }

    public final void ao(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.HI = i;
        }
    }

    public final int getAdNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.EI.HS.getAdNum() : invokeV.intValue;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public SceneImpl getScene() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            com.kwad.components.core.k.kwai.b bVar = this.EI;
            if (bVar != null) {
                return bVar.HS;
            }
            return null;
        }
        return (SceneImpl) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? com.kwad.sdk.b.qK() : (String) invokeV.objValue;
    }
}
