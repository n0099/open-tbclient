package com.repackage;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class bp1 extends ap1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ File a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ j03 d;
        public final /* synthetic */ bp1 e;

        public a(bp1 bp1Var, File file, int i, String str, j03 j03Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bp1Var, file, Integer.valueOf(i), str, j03Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = bp1Var;
            this.a = file;
            this.b = i;
            this.c = str;
            this.d = j03Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                File k = hd3.k(this.a.getName());
                if (!hd3.b(this.a, k, this.b)) {
                    jx1.c("ImageApi", "compress image failed");
                    this.e.d(this.c, new js1(1001, "compress image failed"));
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("tempFilePath", r73.J(k.getAbsolutePath(), this.d.b));
                } catch (JSONException e) {
                    jx1.c("ImageApi", e.toString());
                }
                this.e.d(this.c, new js1(0, jSONObject));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bp1(@NonNull ko1 ko1Var) {
        super(ko1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ko1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ko1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.mo1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "ImageApi" : (String) invokeV.objValue;
    }

    public js1 x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#compressImage", false);
            Pair<js1, JSONObject> s = s(str);
            js1 js1Var = (js1) s.first;
            if (js1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    jx1.c("ImageApi", "cb is empty");
                    return new js1(202, "cb is empty");
                }
                return y(optString, jSONObject.optString("src"), jSONObject.optInt("quality", 80));
            }
            return js1Var;
        }
        return (js1) invokeL.objValue;
    }

    public final js1 y(String str, String str2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, str, str2, i)) == null) {
            j03 a0 = j03.a0();
            if (a0 == null) {
                return new js1(1001, "swan app is null");
            }
            int i2 = (i < 0 || i > 100) ? 80 : i;
            if (TextUtils.isEmpty(str2)) {
                jx1.c("ImageApi", "src is null");
                return new js1(202, "src is null");
            }
            PathType s = r73.s(str2);
            String str3 = null;
            if (s == PathType.BD_FILE) {
                str3 = r73.M(str2, a0.b);
            } else if (s == PathType.RELATIVE) {
                str3 = r73.L(str2, a0, a0.j0());
            }
            if (TextUtils.isEmpty(str3)) {
                jx1.c("ImageApi", "file path error");
                return new js1(2001, "file path error");
            }
            File file = new File(str3);
            if (!file.exists()) {
                jx1.c("ImageApi", "file does not exist");
                return new js1(2001, "file does not exist");
            }
            dd3.k(new a(this, file, i2, str, a0), "compressImage");
            return js1.f();
        }
        return (js1) invokeLLI.objValue;
    }
}
