package com.kwai.adclient.kscommerciallogger;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.adclient.kscommerciallogger.model.c;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwai.adclient.kscommerciallogger.kwai.a ars;
    public com.kwai.adclient.kscommerciallogger.kwai.b art;
    public JSONObject aru;
    public boolean arv;
    public boolean arw;

    /* renamed from: com.kwai.adclient.kscommerciallogger.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0404a {
        public static /* synthetic */ Interceptable $ic;
        public static a arx;
        public transient /* synthetic */ FieldHolder $fh;

        public static a BE() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
                if (arx == null) {
                    arx = new a((byte) 0);
                }
                return arx;
            }
            return (a) invokeV.objValue;
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
        this.arv = false;
        this.arw = false;
    }

    public /* synthetic */ a(byte b) {
        this();
    }

    public static a BE() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? C0404a.BE() : (a) invokeV.objValue;
    }

    private void a(@NonNull com.kwai.adclient.kscommerciallogger.kwai.a aVar, @NonNull com.kwai.adclient.kscommerciallogger.kwai.b bVar, @Nullable JSONObject jSONObject, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{aVar, bVar, jSONObject, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.ars = aVar;
            this.art = bVar;
            this.aru = jSONObject;
            this.arv = z;
            this.arw = true;
        }
    }

    private void b(@NonNull c cVar) {
        com.kwai.adclient.kscommerciallogger.kwai.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, cVar) == null) || (aVar = this.ars) == null) {
            return;
        }
        String tag = cVar.getTag();
        String str = cVar.BI() == null ? "" : cVar.BI().value;
        if (cVar.BJ() != null) {
            String str2 = cVar.BJ().value;
        }
        if (cVar.BK() != null) {
            cVar.BK().getValue();
        }
        cVar.BN();
        b.k(cVar.BL());
        b.k(cVar.BM());
        aVar.I(tag, str);
    }

    public final JSONObject BF() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.aru : (JSONObject) invokeV.objValue;
    }

    public final boolean BG() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.arw : invokeV.booleanValue;
    }

    public final void a(@NonNull com.kwai.adclient.kscommerciallogger.kwai.a aVar, @NonNull com.kwai.adclient.kscommerciallogger.kwai.b bVar, @Nullable JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{aVar, bVar, jSONObject, Boolean.valueOf(z)}) == null) {
            a(aVar, bVar, null, z, true);
        }
    }

    public final void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            if (cVar == null) {
                this.ars.J("KSCommercialLogger", "rl rtLog is null please check it");
                return;
            }
            b(cVar);
            com.kwai.adclient.kscommerciallogger.kwai.b bVar = this.art;
            if (bVar != null) {
                bVar.K(cVar.BH(), cVar.toString());
            }
        }
    }

    public final boolean isDebug() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.arv : invokeV.booleanValue;
    }
}
