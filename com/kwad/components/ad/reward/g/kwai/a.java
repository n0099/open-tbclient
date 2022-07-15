package com.kwad.components.ad.reward.g.kwai;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.g.c;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.utils.r;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class a extends com.kwad.components.ad.reward.g.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b c;
    public final C0482a d;

    /* renamed from: com.kwad.components.ad.reward.g.kwai.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0482a extends com.kwad.components.ad.reward.g.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r6v0 int)] */
        public C0482a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            this.a = String.format("进阶奖励：浏览详情页 %ss", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i);
            this.b = String.format("进阶奖励：浏览详情页 %ss", sb2.toString());
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends com.kwad.components.ad.reward.g.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = "基础奖励：观看视频";
            this.b = "基础奖励：需再观看%ss视频";
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new b();
        this.d = new C0482a(d.R());
    }

    private void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            if (this.d.g()) {
                c();
            } else {
                d();
            }
        }
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final List<c> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.c);
            arrayList.add(this.d);
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i = 0;
            for (c cVar : a()) {
                if (!cVar.g()) {
                    i++;
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    @Override // com.kwad.components.ad.reward.g.b, com.kwad.components.ad.reward.g.c
    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.d.g() : invokeV.booleanValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            com.kwad.sdk.core.d.b.a("LandPageOpenTask", "markWatchVideoCompleted");
            this.c.c();
            k();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            com.kwad.sdk.core.d.b.a("LandPageOpenTask", "markOpenNsCompleted");
            this.d.c();
            k();
        }
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.c.g() : invokeV.booleanValue;
    }

    @Override // com.kwad.components.ad.reward.g.b, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) {
            try {
                this.c.parseJson(jSONObject.optJSONObject("mWatchVideoTask"));
                this.d.parseJson(jSONObject.optJSONObject("mOpenNsTask"));
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.kwad.components.ad.reward.g.b, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            r.a(jSONObject, "mWatchVideoTask", this.c);
            r.a(jSONObject, "mOpenNsTask", this.d);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
