package com.repackage;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class wo1 extends ko1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements xo1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(wo1 wo1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wo1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements xo1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(wo1 wo1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wo1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements xo1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(wo1 wo1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wo1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wo1(@NonNull io1 io1Var) {
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
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "HostDownloadManager" : (String) invokeV.objValue;
    }

    @Override // com.repackage.ko1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "HostDownloadManagerApi" : (String) invokeV.objValue;
    }

    public hs1 query(String str) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#query", false);
            if (h03.b0() == null) {
                return new hs1(1001);
            }
            Pair<hs1, JSONObject> s = s(str);
            hs1 hs1Var = (hs1) s.first;
            if (hs1Var.isSuccess() && (obj = s.second) != null) {
                JSONObject jSONObject = (JSONObject) obj;
                String optString = jSONObject.optString("taskID");
                if (TextUtils.isEmpty(optString)) {
                    return new hs1(202, "taskId is empty");
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new hs1(202, "cb is empty");
                }
                zk1 z = oj2.z();
                if (z != null) {
                    z.b(optString, new b(this, optString2));
                }
                return hs1.f();
            }
            hx1.c("HostDownloadManagerApi", "parse fail");
            return hs1Var;
        }
        return (hs1) invokeL.objValue;
    }

    public hs1 x(String str) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            h03 b0 = h03.b0();
            if (b0 == null) {
                return new hs1(1001);
            }
            if (b0.w() == null) {
                return new hs1(1001);
            }
            Pair<hs1, JSONObject> s = s(str);
            hs1 hs1Var = (hs1) s.first;
            if (hs1Var.isSuccess() && (obj = s.second) != null) {
                JSONObject jSONObject = (JSONObject) obj;
                String optString = jSONObject.optString("url");
                if (TextUtils.isEmpty(optString)) {
                    return new hs1(202, "url is empty");
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new hs1(202, "cb is empty");
                }
                String optString3 = jSONObject.optString("name");
                JSONObject optJSONObject = jSONObject.optJSONObject("header");
                zk1 z = oj2.z();
                if (z != null) {
                    z.d(optString, optString3, optJSONObject, new a(this, optString2));
                }
                return hs1.f();
            }
            hx1.c("HostDownloadManagerApi", "parse fail");
            return hs1Var;
        }
        return (hs1) invokeL.objValue;
    }

    public hs1 y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            q("#openDownloadCenter", false);
            if (h03.b0() == null) {
                return new hs1(1001);
            }
            zk1 z = oj2.z();
            if (z != null) {
                z.a();
            }
            return hs1.f();
        }
        return (hs1) invokeV.objValue;
    }

    public hs1 z(String str) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#openFile", false);
            if (h03.b0() == null) {
                return new hs1(1001);
            }
            Pair<hs1, JSONObject> s = s(str);
            hs1 hs1Var = (hs1) s.first;
            if (hs1Var.isSuccess() && (obj = s.second) != null) {
                JSONObject jSONObject = (JSONObject) obj;
                String optString = jSONObject.optString("taskID");
                if (TextUtils.isEmpty(optString)) {
                    return new hs1(202, "taskId is empty");
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new hs1(202, "cb is empty");
                }
                SwanAppActivity activity = ul2.U().getActivity();
                if (activity == null) {
                    return new hs1(1001);
                }
                zk1 z = oj2.z();
                if (z != null) {
                    z.c(activity, optString, new c(this, optString2));
                }
                return hs1.f();
            }
            hx1.c("HostDownloadManagerApi", "parse fail");
            return hs1Var;
        }
        return (hs1) invokeL.objValue;
    }
}
