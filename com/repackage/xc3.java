package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.wc3;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class xc3 extends xo1 implements wc3.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean h;
    public transient /* synthetic */ FieldHolder $fh;
    public String f;
    public String g;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oq2 a;
        public final /* synthetic */ xc3 b;

        public a(xc3 xc3Var, oq2 oq2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xc3Var, oq2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xc3Var;
            this.a = oq2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (bk2.h().a(this.b.f, this.a)) {
                    this.b.A(this.a);
                    return;
                }
                xc3 xc3Var = this.b;
                xc3Var.d(xc3Var.g, new us1(2003, "upload fail"));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755176439, "Lcom/repackage/xc3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755176439, "Lcom/repackage/xc3;");
                return;
            }
        }
        h = eh1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xc3(@NonNull vo1 vo1Var) {
        super(vo1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vo1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((vo1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void A(oq2 oq2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, oq2Var) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("bosUrl", oq2Var.e);
                d(this.g, new us1(0, jSONObject));
            } catch (JSONException e) {
                if (h) {
                    e.printStackTrace();
                }
                d(this.g, new us1(2003, "upload fail"));
            }
        }
    }

    public final boolean B(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file)) == null) ? file.length() > 52428800 : invokeL.booleanValue;
    }

    public us1 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#uploadBosFile", false);
            if (h) {
                Log.d("UploadBosApi", "#uploadBosFile params=" + str);
            }
            Pair<us1, JSONObject> s = s(str);
            us1 us1Var = (us1) s.first;
            if (us1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = jSONObject.optString("cb");
                this.g = optString;
                if (TextUtils.isEmpty(optString)) {
                    return new us1(202);
                }
                String optString2 = jSONObject.optString("filePath");
                if (TextUtils.isEmpty(optString2)) {
                    return new us1(202);
                }
                hm2 U = hm2.U();
                String i = U.G().i(optString2);
                this.f = i;
                if (TextUtils.isEmpty(i)) {
                    return new us1(2001, "file not found");
                }
                File file = new File(this.f);
                if (file.exists() && file.isFile()) {
                    if (B(file)) {
                        return new us1(2002, "file over size");
                    }
                    if (!t03.J().r().M().e(U.getActivity())) {
                        return new us1(10004, "user not logged in");
                    }
                    bk2.h().b(U.getActivity(), this.f, this);
                    return us1.f();
                }
                return new us1(2001, "file not found");
            }
            return us1Var;
        }
        return (us1) invokeL.objValue;
    }

    @Override // com.repackage.wc3.a
    public void c(JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, jSONObject, str) == null) {
            if (jSONObject == null) {
                d(this.g, new us1(2003, "upload fail"));
                return;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                d(this.g, new us1(2003, "upload fail"));
                return;
            }
            String optString = jSONObject.optString("errno");
            if (!TextUtils.isEmpty(optString) && TextUtils.equals(optString, "0")) {
                oq2 a2 = oq2.a(optJSONObject, str);
                if (TextUtils.isEmpty(a2.e)) {
                    d(this.g, new us1(2003, "upload fail"));
                    return;
                } else {
                    ExecutorUtilsExt.postOnElastic(new a(this, a2), "doBosUpload", 2);
                    return;
                }
            }
            d(this.g, new us1(2003, "upload fail"));
        }
    }

    @Override // com.repackage.xo1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "PrivateFile" : (String) invokeV.objValue;
    }

    @Override // com.repackage.xo1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "UploadBosApi" : (String) invokeV.objValue;
    }
}
