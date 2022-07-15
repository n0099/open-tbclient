package com.repackage;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ii2 extends be2<si2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int b;
    public int c;

    public ii2() {
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
        this.b = 1;
        this.c = 3;
    }

    @Override // com.repackage.be2
    @NonNull
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "setZeusVideoExt" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.be2
    @SuppressLint({"BDThrowableCheck"})
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull si2 si2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, command, si2Var) == null) {
            Object obj = command.obj;
            if (!(obj instanceof String)) {
                if (be2.a) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("setZeusVideoExt with a illegal obj ");
                    sb.append(obj == null);
                    throw new RuntimeException(sb.toString());
                }
                return;
            }
            String str = command.what;
            d(si2Var, str, "setZeusVideoExt:" + obj, false);
            try {
                JSONObject jSONObject = new JSONObject((String) obj);
                if (jSONObject.has("instance-error")) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("instance-error", jSONObject.optString("instance-error"));
                    si2Var.T(hashMap);
                }
                String optString = jSONObject.optString("firstPlayStatus");
                if (!TextUtils.isEmpty(optString)) {
                    si2Var.b0(optString);
                }
                this.b = jSONObject.optInt("min-cache", this.b);
                int optInt = jSONObject.optInt("max-cache", this.c);
                this.c = optInt;
                if (this.b <= optInt) {
                    if (jSONObject.has("min-cache")) {
                        si2Var.G(this.b);
                    }
                    if (jSONObject.has("max-cache")) {
                        si2Var.g0(this.c);
                    }
                } else if (be2.a) {
                    Log.w("【InlineCommand】", "setZeusVideoExt: minCache " + this.b + " > maxCache " + this.c);
                }
            } catch (Exception e) {
                if (be2.a) {
                    throw new RuntimeException("setZeusVideoExt with a illegal str", e);
                }
            }
        }
    }
}
