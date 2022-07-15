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
/* loaded from: classes7.dex */
public class zo1 extends yo1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ File a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ h03 d;
        public final /* synthetic */ zo1 e;

        public a(zo1 zo1Var, File file, int i, String str, h03 h03Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zo1Var, file, Integer.valueOf(i), str, h03Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = zo1Var;
            this.a = file;
            this.b = i;
            this.c = str;
            this.d = h03Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                File k = fd3.k(this.a.getName());
                if (!fd3.b(this.a, k, this.b)) {
                    hx1.c("ImageApi", "compress image failed");
                    this.e.d(this.c, new hs1(1001, "compress image failed"));
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("tempFilePath", p73.J(k.getAbsolutePath(), this.d.b));
                } catch (JSONException e) {
                    hx1.c("ImageApi", e.toString());
                }
                this.e.d(this.c, new hs1(0, jSONObject));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zo1(@NonNull io1 io1Var) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "ImageApi" : (String) invokeV.objValue;
    }

    public hs1 x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#compressImage", false);
            Pair<hs1, JSONObject> s = s(str);
            hs1 hs1Var = (hs1) s.first;
            if (hs1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    hx1.c("ImageApi", "cb is empty");
                    return new hs1(202, "cb is empty");
                }
                return y(optString, jSONObject.optString("src"), jSONObject.optInt("quality", 80));
            }
            return hs1Var;
        }
        return (hs1) invokeL.objValue;
    }

    public final hs1 y(String str, String str2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, str, str2, i)) == null) {
            h03 b0 = h03.b0();
            if (b0 == null) {
                return new hs1(1001, "swan app is null");
            }
            int i2 = (i < 0 || i > 100) ? 80 : i;
            if (TextUtils.isEmpty(str2)) {
                hx1.c("ImageApi", "src is null");
                return new hs1(202, "src is null");
            }
            PathType s = p73.s(str2);
            String str3 = null;
            if (s == PathType.BD_FILE) {
                str3 = p73.M(str2, b0.b);
            } else if (s == PathType.RELATIVE) {
                str3 = p73.L(str2, b0, b0.k0());
            }
            if (TextUtils.isEmpty(str3)) {
                hx1.c("ImageApi", "file path error");
                return new hs1(2001, "file path error");
            }
            File file = new File(str3);
            if (!file.exists()) {
                hx1.c("ImageApi", "file does not exist");
                return new hs1(2001, "file does not exist");
            }
            bd3.k(new a(this, file, i2, str, b0), "compressImage");
            return hs1.f();
        }
        return (hs1) invokeLLI.objValue;
    }
}
