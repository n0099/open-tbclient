package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.swan.apps.statistic.interfacestability.SwanInterfaceType;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class n53 extends s53<JSONObject> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String m;
    public final Context n;

    public n53(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = str;
        this.n = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.e53
    /* renamed from: P */
    public JSONObject m(JSONObject jSONObject) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) ? f53.c(jSONObject) : (JSONObject) invokeL.objValue;
    }

    @Override // com.repackage.e53
    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(GameGuideConfigInfo.KEY_APP_KEY, this.m);
                jSONObject.put("host_pkgname", AppRuntime.getApplication().getPackageName());
                jSONObject.put("host_key_hash", f53.g());
                String l = oj2.o().l();
                if (!TextUtils.isEmpty(l)) {
                    jSONObject.put("host_api_key", l);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            v("data", jSONObject.toString());
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.s53
    public HttpRequest w(s53 s53Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, s53Var)) == null) ? oj2.o().a(this.n, s53Var.B()) : (HttpRequest) invokeL.objValue;
    }

    @Override // com.repackage.s53
    public SwanInterfaceType z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? SwanInterfaceType.CHECK_SESSION : (SwanInterfaceType) invokeV.objValue;
    }
}
