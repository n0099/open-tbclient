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
/* loaded from: classes6.dex */
public class mp1 extends lp1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ File a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ u03 d;
        public final /* synthetic */ mp1 e;

        public a(mp1 mp1Var, File file, int i, String str, u03 u03Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mp1Var, file, Integer.valueOf(i), str, u03Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = mp1Var;
            this.a = file;
            this.b = i;
            this.c = str;
            this.d = u03Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                File k = sd3.k(this.a.getName());
                if (!sd3.b(this.a, k, this.b)) {
                    ux1.c("ImageApi", "compress image failed");
                    this.e.d(this.c, new us1(1001, "compress image failed"));
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("tempFilePath", c83.J(k.getAbsolutePath(), this.d.b));
                } catch (JSONException e) {
                    ux1.c("ImageApi", e.toString());
                }
                this.e.d(this.c, new us1(0, jSONObject));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mp1(@NonNull vo1 vo1Var) {
        super(vo1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vo1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((vo1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.xo1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "ImageApi" : (String) invokeV.objValue;
    }

    public us1 x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#compressImage", false);
            Pair<us1, JSONObject> s = s(str);
            us1 us1Var = (us1) s.first;
            if (us1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    ux1.c("ImageApi", "cb is empty");
                    return new us1(202, "cb is empty");
                }
                return y(optString, jSONObject.optString("src"), jSONObject.optInt("quality", 80));
            }
            return us1Var;
        }
        return (us1) invokeL.objValue;
    }

    public final us1 y(String str, String str2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, str, str2, i)) == null) {
            u03 a0 = u03.a0();
            if (a0 == null) {
                return new us1(1001, "swan app is null");
            }
            int i2 = (i < 0 || i > 100) ? 80 : i;
            if (TextUtils.isEmpty(str2)) {
                ux1.c("ImageApi", "src is null");
                return new us1(202, "src is null");
            }
            PathType s = c83.s(str2);
            String str3 = null;
            if (s == PathType.BD_FILE) {
                str3 = c83.M(str2, a0.b);
            } else if (s == PathType.RELATIVE) {
                str3 = c83.L(str2, a0, a0.j0());
            }
            if (TextUtils.isEmpty(str3)) {
                ux1.c("ImageApi", "file path error");
                return new us1(2001, "file path error");
            }
            File file = new File(str3);
            if (!file.exists()) {
                ux1.c("ImageApi", "file does not exist");
                return new us1(2001, "file does not exist");
            }
            od3.k(new a(this, file, i2, str, a0), "compressImage");
            return us1.f();
        }
        return (us1) invokeLLI.objValue;
    }
}
