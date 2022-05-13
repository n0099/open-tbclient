package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class gg2 extends oe2<fh2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public gg2() {
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

    @Override // com.repackage.oe2
    @NonNull
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getRemoteUserList" : (String) invokeV.objValue;
    }

    @Override // com.repackage.oe2
    public void c(@NonNull ZeusPlugin.Command command) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, command) == null) {
            command.obj = new JSONObject();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.oe2
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull fh2 fh2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, command, fh2Var) == null) {
            ArrayList<jh2> h = fh2Var.h();
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (h != null) {
                Iterator<jh2> it = h.iterator();
                while (it.hasNext()) {
                    jh2 next = it.next();
                    JSONObject a = next == null ? null : next.a();
                    if (a != null) {
                        jSONArray.put(a);
                    }
                }
            }
            try {
                jSONObject.put("userList", jSONArray);
            } catch (JSONException unused) {
            }
            command.obj = jSONObject;
            String str = command.what;
            d(fh2Var, str, "" + command.obj, true);
        }
    }
}
