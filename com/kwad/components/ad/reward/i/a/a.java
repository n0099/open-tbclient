package com.kwad.components.ad.reward.i.a;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.r;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class a extends com.kwad.components.ad.reward.i.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c uc;
    public C0553a ud;
    public final b ue;

    /* renamed from: com.kwad.components.ad.reward.i.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0553a extends com.kwad.components.ad.reward.i.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0553a() {
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
            this.tY = "安装应用";
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends com.kwad.components.ad.reward.i.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r6v0 int)] */
        public b(int i) {
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
            this.tY = String.format("进阶奖励：安装并激活APP %ss", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i);
            this.tZ = String.format("进阶奖励：安装并激活APP %ss", sb2.toString());
        }
    }

    /* loaded from: classes7.dex */
    public static class c extends com.kwad.components.ad.reward.i.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
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
            this.tY = "基础奖励：观看视频";
            this.tZ = "基础奖励：需再观看%ss视频";
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
        this.uc = new c();
        this.ud = new C0553a();
        this.ue = new b(com.kwad.components.ad.reward.kwai.b.fX());
    }

    public static void a(a aVar, Context context, AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, aVar, context, adTemplate) == null) {
            if (ai.U(context, com.kwad.sdk.core.response.a.a.ag(d.bQ(adTemplate)))) {
                aVar.iF();
            } else {
                aVar.iG();
            }
        }
    }

    private void iE() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            if (this.uc.isCompleted() && this.ud.isCompleted() && this.ue.isCompleted()) {
                it();
            } else {
                iu();
            }
        }
    }

    private void iG() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            com.kwad.sdk.core.e.b.d("LaunchAppTask", "markInstallUncompleted");
            this.ud.iu();
            iE();
        }
    }

    public final void iB() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            com.kwad.sdk.core.e.b.d("LaunchAppTask", "markWatchVideoCompleted");
            this.uc.it();
            iE();
        }
    }

    public final boolean iC() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.uc.isCompleted() : invokeV.booleanValue;
    }

    public final void iF() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            com.kwad.sdk.core.e.b.d("LaunchAppTask", "markInstallCompleted");
            this.ud.it();
            iE();
        }
    }

    public final void iH() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            com.kwad.sdk.core.e.b.d("LaunchAppTask", "markUseAppCompleted");
            this.ue.it();
            iE();
        }
    }

    public final boolean iI() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            com.kwad.sdk.core.e.b.d("LaunchAppTask", "isInstallCompleted");
            return this.ud.isCompleted();
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.components.ad.reward.i.a
    public final List<com.kwad.components.ad.reward.i.c> ir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.uc);
            arrayList.add(this.ue);
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.kwad.components.ad.reward.i.a
    public final int is() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int i = 0;
            for (com.kwad.components.ad.reward.i.c cVar : ir()) {
                if (!cVar.isCompleted()) {
                    i++;
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    @Override // com.kwad.components.ad.reward.i.b, com.kwad.components.ad.reward.i.c
    public final boolean isCompleted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.ud.isCompleted() && this.ue.isCompleted() : invokeV.booleanValue;
    }

    @Override // com.kwad.components.ad.reward.i.b, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) == null) {
            try {
                this.uc.parseJson(jSONObject.optJSONObject("mWatchVideoTask"));
                this.ue.parseJson(jSONObject.optJSONObject("mUseAppTask"));
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.kwad.components.ad.reward.i.b, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            r.a(jSONObject, "mWatchVideoTask", this.uc);
            r.a(jSONObject, "mInstallAppTask", this.ud);
            r.a(jSONObject, "mUseAppTask", this.ue);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
