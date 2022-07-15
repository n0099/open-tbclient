package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class qf2 extends be2<sg2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public qf2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.repackage.be2
    @NonNull
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "enterRoom" : (String) invokeV.objValue;
    }

    @Override // com.repackage.be2
    public void c(@NonNull ZeusPlugin.Command command) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, command) == null) {
            Object obj = command.obj;
            if (obj instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) obj;
                command.ret = new vg2(jSONObject.optString("roomName"), jSONObject.optLong("userId", -1L), jSONObject.optString("displayName"), jSONObject.optString("rtcAppId"), jSONObject.optString("token")).a() ? 1 : 0;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.be2
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull sg2 sg2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, command, sg2Var) == null) {
            String str = command.what;
            d(sg2Var, str, "" + command.obj, true);
            Object obj = command.obj;
            if (obj instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) obj;
                vg2 vg2Var = new vg2(jSONObject.optString("roomName"), jSONObject.optLong("userId", -1L), jSONObject.optString("displayName"), jSONObject.optString("rtcAppId"), jSONObject.optString("token"));
                boolean a = vg2Var.a();
                if (a) {
                    sg2Var.u(vg2Var);
                }
                command.ret = a ? 1 : 0;
            }
            String str2 = command.what;
            d(sg2Var, str2, "result: " + command.ret, true);
        }
    }
}
