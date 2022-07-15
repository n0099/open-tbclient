package com.repackage;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.PushManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ir1 extends gr1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONArray a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ir1 c;

        public a(ir1 ir1Var, JSONArray jSONArray, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ir1Var, jSONArray, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ir1Var;
            this.a = jSONArray;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.d(this.b, this.c.D(this.a));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ir1 c;

        public b(ir1 ir1Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ir1Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ir1Var;
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.d(this.b, this.c.B(this.a));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ir1(@NonNull io1 io1Var) {
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

    public hs1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#checkAppInstalled", false);
            Pair<hs1, JSONObject> s = s(str);
            hs1 hs1Var = (hs1) s.first;
            if (hs1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = jSONObject.optString("name");
                JSONArray optJSONArray = jSONObject.optJSONArray("name");
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString) && optJSONArray == null) {
                    hx1.c("CheckAppInstallApi", "parameter error");
                    return new hs1(201, "parameter error");
                }
                boolean z = optJSONArray == null;
                if (TextUtils.isEmpty(optString2)) {
                    if (z) {
                        return B(optString);
                    }
                    return D(optJSONArray);
                }
                if (z) {
                    z(optString, optString2);
                } else {
                    C(optJSONArray, optString2);
                }
                return hs1.f();
            }
            return hs1Var;
        }
        return (hs1) invokeL.objValue;
    }

    public final hs1 B(String str) {
        InterceptResult invokeL;
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            try {
                packageInfo = getContext().getPackageManager().getPackageInfo(str, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                hx1.o("CheckAppInstallApi", str + " cannot be found");
                packageInfo = null;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                if (packageInfo != null) {
                    jSONObject.put("hasApp", true);
                    jSONObject.put(PushManager.APP_VERSION_NAME, packageInfo.versionName);
                    jSONObject.put(PushManager.APP_VERSION_CODE, packageInfo.versionCode);
                } else {
                    jSONObject.put("hasApp", false);
                }
                return new hs1(0, "success", jSONObject);
            } catch (JSONException e) {
                hx1.d("CheckAppInstallApi", "internal error: " + e.getMessage(), e);
                return new hs1(1001, "internal error: " + e.getMessage());
            }
        }
        return (hs1) invokeL.objValue;
    }

    public final void C(JSONArray jSONArray, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, jSONArray, str) == null) {
            bd3.f().execute(new a(this, jSONArray, str));
        }
    }

    public final hs1 D(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jSONArray)) == null) {
            JSONObject jSONObject = new JSONObject();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    String string = jSONArray.getString(i);
                    if (!TextUtils.isEmpty(string)) {
                        jSONObject.put(string, E(string));
                    }
                } catch (JSONException e) {
                    hx1.d("CheckAppInstallApi", "internal error: " + e.getMessage(), e);
                }
            }
            return new hs1(0, "success", jSONObject);
        }
        return (hs1) invokeL.objValue;
    }

    public final boolean E(String str) {
        InterceptResult invokeL;
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            try {
                packageInfo = getContext().getPackageManager().getPackageInfo(str, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                hx1.o("CheckAppInstallApi", str + " cannot be found");
                packageInfo = null;
            }
            return packageInfo != null;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.ko1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "CheckAppInstallApi" : (String) invokeV.objValue;
    }

    public final void z(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) {
            bd3.f().execute(new b(this, str, str2));
        }
    }
}
