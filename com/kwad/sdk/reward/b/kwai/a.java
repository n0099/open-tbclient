package com.kwad.sdk.reward.b.kwai;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.utils.t;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends com.kwad.sdk.reward.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public b f59465b;

    /* renamed from: c  reason: collision with root package name */
    public final C2110a f59466c;

    /* renamed from: com.kwad.sdk.reward.b.kwai.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C2110a extends com.kwad.sdk.reward.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C2110a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = String.format("浏览详情页%s秒", i2 + "");
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends com.kwad.sdk.reward.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
            this.a = "观看视频";
        }
    }

    public a() {
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
        this.f59465b = new b();
        this.f59466c = new C2110a(com.kwad.sdk.core.config.b.aA());
    }

    private void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            if (this.f59465b.d() && this.f59466c.d()) {
                a();
            } else {
                b();
            }
        }
    }

    @Override // com.kwad.sdk.reward.b.a, com.kwad.sdk.reward.b.b
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f59465b.d() && this.f59466c.d() : invokeV.booleanValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            com.kwad.sdk.core.d.a.a("LandPageOpenTask", "markWatchVideoCompleted");
            this.f59465b.a();
            k();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            com.kwad.sdk.core.d.a.a("LandPageOpenTask", "markOpenNsCompleted");
            this.f59466c.a();
            k();
        }
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int i2 = 0;
            for (com.kwad.sdk.reward.b.b bVar : j()) {
                if (!bVar.d()) {
                    i2++;
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public List<com.kwad.sdk.reward.b.b> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f59465b);
            arrayList.add(this.f59466c);
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.kwad.sdk.reward.b.a, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) {
            try {
                this.f59465b.parseJson(jSONObject.optJSONObject("mWatchVideoTask"));
                this.f59466c.parseJson(jSONObject.optJSONObject("mOpenNsTask"));
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.kwad.sdk.reward.b.a, com.kwad.sdk.core.b
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            t.a(jSONObject, "mWatchVideoTask", this.f59465b);
            t.a(jSONObject, "mOpenNsTask", this.f59466c);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
