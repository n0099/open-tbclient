package com.kwai.adclient.kscommerciallogger;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.adclient.kscommerciallogger.model.c;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwai.adclient.kscommerciallogger.a.a aRP;
    public com.kwai.adclient.kscommerciallogger.a.b aRQ;
    public JSONObject aRR;
    public boolean aRS;
    public boolean isDebug;

    /* renamed from: com.kwai.adclient.kscommerciallogger.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C0731a {
        public static /* synthetic */ Interceptable $ic;
        public static a aRT;
        public transient /* synthetic */ FieldHolder $fh;

        public static a MB() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
                if (aRT == null) {
                    aRT = new a((byte) 0);
                }
                return aRT;
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
        this.isDebug = false;
        this.aRS = false;
    }

    public static a MB() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return C0731a.MB();
        }
        return (a) invokeV.objValue;
    }

    public final JSONObject MC() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.aRR;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final boolean MD() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.aRS;
        }
        return invokeV.booleanValue;
    }

    public final boolean isDebug() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.isDebug;
        }
        return invokeV.booleanValue;
    }

    public /* synthetic */ a(byte b) {
        this();
    }

    public final void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            if (cVar == null) {
                this.aRP.I("KSCommercialLogger", "rl rtLog is null please check it");
                return;
            }
            b(cVar);
            com.kwai.adclient.kscommerciallogger.a.b bVar = this.aRQ;
            if (bVar != null) {
                bVar.J(cVar.ME(), cVar.toString());
            }
        }
    }

    private void b(@NonNull c cVar) {
        com.kwai.adclient.kscommerciallogger.a.a aVar;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, this, cVar) == null) && (aVar = this.aRP) != null) {
            String tag = cVar.getTag();
            if (cVar.MF() == null) {
                str = "";
            } else {
                str = cVar.MF().value;
            }
            if (cVar.MG() != null) {
                String str2 = cVar.MG().value;
            }
            if (cVar.MH() != null) {
                cVar.MH().getValue();
            }
            cVar.MK();
            b.x(cVar.MI());
            b.x(cVar.MJ());
            aVar.H(tag, str);
        }
    }

    public final void a(@NonNull com.kwai.adclient.kscommerciallogger.a.a aVar, @NonNull com.kwai.adclient.kscommerciallogger.a.b bVar, @Nullable JSONObject jSONObject, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{aVar, bVar, jSONObject, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.aRP = aVar;
            this.aRQ = bVar;
            this.aRR = jSONObject;
            this.isDebug = z;
            this.aRS = z2;
        }
    }
}
