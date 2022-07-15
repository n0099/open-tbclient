package com.repackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class qq1 extends nq1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public a(qq1 qq1Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qq1Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || zz2.d()) {
                return;
            }
            zz2.f(this.a, R.string.obfuscated_res_0x7f0f03e7).G();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qq1(@NonNull io1 io1Var) {
        super(io1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {io1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((io1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.ko1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "ClipboardApi" : (String) invokeV.objValue;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public hs1 x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#getClipboardData", false);
            JSONObject jSONObject = new JSONObject();
            try {
                CharSequence a2 = ce3.b(getContext()).a();
                jSONObject.put("data", TextUtils.isEmpty(a2) ? "" : a2.toString());
                return new hs1(0, jSONObject);
            } catch (JSONException e) {
                p("#getClipboardData json put data fail", e, false);
                return new hs1(1001, "JSONException");
            }
        }
        return (hs1) invokeV.objValue;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public hs1 y(String str) {
        InterceptResult invokeL;
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#setClipboardData", false);
            Pair<hs1, JSONObject> s = s(str);
            hs1 hs1Var = (hs1) s.first;
            if (hs1Var.isSuccess()) {
                ce3.b(getContext()).c(((JSONObject) s.second).optString("data"));
                h03 q = g03.K().q();
                if (q != null && (w = q.w()) != null) {
                    be3.f0(new a(this, w), 200L);
                }
                return hs1.f();
            }
            return hs1Var;
        }
        return (hs1) invokeL.objValue;
    }
}
