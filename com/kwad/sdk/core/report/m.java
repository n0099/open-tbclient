package com.kwad.sdk.core.report;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.walletfacesdk.LightInvokerImpl;
import com.kwad.sdk.utils.t;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class m extends ReportAction {
    public static /* synthetic */ Interceptable $ic;
    public static final SparseArray<com.kwad.sdk.core.report.kwai.b> bP;
    public transient /* synthetic */ FieldHolder $fh;
    public String bN;
    public final Map<String, Object> bO;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-615486124, "Lcom/kwad/sdk/core/report/m;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-615486124, "Lcom/kwad/sdk/core/report/m;");
                return;
            }
        }
        SparseArray<com.kwad.sdk.core.report.kwai.b> sparseArray = new SparseArray<>();
        bP = sparseArray;
        sparseArray.put(1, new com.kwad.sdk.core.report.kwai.a());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(long j2, Map<String, Object> map) {
        super(j2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2), map};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Long) newInitContext.callArgs[0]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.bN = com.kwad.sdk.core.network.k.c();
        this.bO = new HashMap();
        if (map != null && !map.isEmpty()) {
            this.bO.putAll(map);
        }
        this.bK = 2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(JSONObject jSONObject) {
        super(jSONObject);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((JSONObject) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.bN = com.kwad.sdk.core.network.k.c();
        this.bO = new HashMap();
        com.kwad.sdk.core.report.kwai.b a = a(jSONObject.optInt(LightInvokerImpl.VOICE_ACTIONTYPE));
        if (a != null) {
            a.a(jSONObject, this.bO);
        }
        this.bK = 2;
    }

    private com.kwad.sdk.core.report.kwai.b a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, this, i2)) == null) ? bP.get(b(i2)) : (com.kwad.sdk.core.report.kwai.b) invokeI.objValue;
    }

    private int b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i2)) == null) {
            return 1;
        }
        return invokeI.intValue;
    }

    @Override // com.kwad.sdk.core.report.ReportAction, com.kwad.sdk.core.report.c, com.kwad.sdk.core.response.kwai.a
    public void afterToJson(JSONObject jSONObject) {
        com.kwad.sdk.core.report.kwai.b a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            super.afterToJson(jSONObject);
            if (this.bO.isEmpty() || (a = a(jSONObject.optInt(LightInvokerImpl.VOICE_ACTIONTYPE))) == null) {
                return;
            }
            a.b(jSONObject, this.bO);
            try {
                jSONObject.put("ecIdentityFlag", true);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            super.parseJson(jSONObject);
            if (jSONObject == null) {
                return;
            }
            try {
                this.bN = jSONObject.optString("ua");
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
        }
    }

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject json = super.toJson();
            t.a(json, "ua", this.bN);
            return json;
        }
        return (JSONObject) invokeV.objValue;
    }
}
