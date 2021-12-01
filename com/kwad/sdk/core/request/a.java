package com.kwad.sdk.core.request;

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
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.request.model.f;
import com.kwad.sdk.core.request.model.j;
import com.kwad.sdk.core.request.model.k;
import com.kwad.sdk.core.request.model.l;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.plugin.DevelopMangerPlugin;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.t;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends com.kwad.sdk.core.network.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public f f57691b;

    /* renamed from: c  reason: collision with root package name */
    public int f57692c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(f fVar) {
        this(fVar, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((f) objArr2[0], (k) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(f fVar, k kVar) {
        this(fVar, null, false, kVar, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, kVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((f) objArr2[0], (List) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), (k) objArr2[3], (j) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(f fVar, @Nullable List<String> list, boolean z, k kVar, j jVar) {
        super(a(fVar));
        DevelopMangerPlugin.DevelopValue a;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, list, Boolean.valueOf(z), kVar, jVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f57691b = fVar;
        com.kwad.sdk.internal.api.a a2 = fVar.a();
        if (a2 != null && !a2.b()) {
            a(com.kwad.sdk.core.request.model.b.a(), a2);
        }
        JSONArray jSONArray = new JSONArray();
        t.a(jSONArray, fVar.toJson());
        a("impInfo", jSONArray);
        a("universePhotoInfo", kVar);
        int i4 = this.f57692c;
        if (i4 > 0) {
            a("calledUnionType", i4);
        }
        if (((DevelopMangerPlugin) com.kwad.sdk.plugin.f.a(DevelopMangerPlugin.class)).a("KEY_MODIFY_CREATEID") != null) {
            list = new ArrayList<>();
            list.add("creativeId_" + a.getValue());
        }
        if (list != null) {
            a("preloadIdList", new JSONArray((Collection) list));
            a("preloadCheck", z);
        }
        b("appTag", as.d(KsAdSDKImpl.get().getContext()));
        DevelopMangerPlugin.DevelopValue a3 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.f.a(DevelopMangerPlugin.class)).a("KEY_CAMPAIGNTYPE");
        if (a3 != null) {
            a("campaignType", ((Integer) a3.getValue()).intValue());
        }
        String a4 = this.f57691b.a("thirdUserId");
        l a5 = l.a();
        if (a4 != null) {
            a5.a(a4);
        }
        if (a2 != null && !a2.a()) {
            a(a5, a2);
        }
        a("userInfo", a5);
        if (jVar != null) {
            a("statusInfo", jVar);
        }
    }

    public static int a(f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, fVar)) == null) {
            try {
                return fVar.a.getScreenOrientation();
            } catch (Throwable unused) {
                return 0;
            }
        }
        return invokeL.intValue;
    }

    private void a(l lVar, com.kwad.sdk.internal.api.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, lVar, aVar) == null) {
            int i2 = aVar.a;
            if (i2 != 0) {
                lVar.a = i2;
            }
            int i3 = aVar.f58643b;
            if (i3 != 0) {
                lVar.f57806b = i3;
            }
            if (TextUtils.isEmpty(aVar.f58644c)) {
                return;
            }
            lVar.f57807c = aVar.f58644c;
        }
    }

    private void a(JSONObject jSONObject, com.kwad.sdk.internal.api.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, this, jSONObject, aVar) == null) {
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(aVar.f58645d)) {
                t.a(jSONObject2, "prevTitle", aVar.f58645d);
            }
            if (!TextUtils.isEmpty(aVar.f58646e)) {
                t.a(jSONObject2, "postTitle", aVar.f58646e);
            }
            if (!TextUtils.isEmpty(aVar.f58647f)) {
                t.a(jSONObject2, "historyTitle", aVar.f58647f);
            }
            if (!TextUtils.isEmpty(aVar.f58648g)) {
                t.a(jSONObject2, "channel", aVar.f58648g);
            }
            t.a(jSONObject, "content", jSONObject2);
            a(DI.APP_INFO_NAME, jSONObject);
        }
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? com.kwad.sdk.d.c() : (String) invokeV.objValue;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f57692c = i2;
        }
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public SceneImpl b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            f fVar = this.f57691b;
            if (fVar != null) {
                return fVar.a;
            }
            return null;
        }
        return (SceneImpl) invokeV.objValue;
    }
}
