package d.a.o0.a.z.e;

import android.text.TextUtils;
import com.alipay.sdk.widget.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.e0.d;
import kotlinx.coroutines.DebugKt;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a extends d.a.o0.a.c0.b.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String n;
    public String o;

    /* renamed from: d.a.o0.a.z.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C1004a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static String a(String str) {
            InterceptResult invokeL;
            char c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
                int hashCode = str.hashCode();
                if (hashCode == 3551) {
                    if (str.equals(DebugKt.DEBUG_PROPERTY_VALUE_ON)) {
                        c2 = 2;
                    }
                    c2 = 65535;
                } else if (hashCode != 109935) {
                    if (hashCode == 3005871 && str.equals(DebugKt.DEBUG_PROPERTY_VALUE_AUTO)) {
                        c2 = 0;
                    }
                    c2 = 65535;
                } else {
                    if (str.equals(DebugKt.DEBUG_PROPERTY_VALUE_OFF)) {
                        c2 = 1;
                    }
                    c2 = 65535;
                }
                return (c2 == 0 || c2 == 1 || c2 == 2) ? str : DebugKt.DEBUG_PROPERTY_VALUE_AUTO;
            }
            return (String) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(String str) {
        super("camera", "cameraId");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        try {
            a(new JSONObject(str));
        } catch (JSONException e2) {
            d.c("Camera", "parsing CameraAttrModel occurs exception", e2);
        }
    }

    @Override // d.a.o0.a.c0.b.b, d.a.o0.a.l1.a
    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            super.a(jSONObject);
            this.n = jSONObject.optString("devicePosition", j.j);
            this.o = jSONObject.optString("flash", DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
        }
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? C1004a.a(this.o) : (String) invokeV.objValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            d.a.o0.a.l1.e.a.a aVar = this.l;
            if (aVar == null) {
                return 0;
            }
            return aVar.f();
        }
        return invokeV.intValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            d.a.o0.a.l1.e.a.a aVar = this.l;
            if (aVar == null) {
                return 0;
            }
            return aVar.i();
        }
        return invokeV.intValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? TextUtils.equals(this.n, "front") : invokeV.booleanValue;
    }
}
