package com.repackage;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class to1 extends ko1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h03 a;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ String c;
        public final /* synthetic */ to1 d;

        public a(to1 to1Var, h03 h03Var, JSONObject jSONObject, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {to1Var, h03Var, jSONObject, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = to1Var;
            this.a = h03Var;
            this.b = jSONObject;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.b.put("isFavor", f72.n(this.a.O()) ? "1" : "0");
                } catch (JSONException unused) {
                    hx1.c("FollowStatusApi", "json put data fail");
                }
                this.d.d(this.c, new hs1(0, this.b));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public to1(@NonNull io1 io1Var) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "Favorite" : (String) invokeV.objValue;
    }

    @Override // com.repackage.ko1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "FollowStatusApi" : (String) invokeV.objValue;
    }

    public hs1 x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            h03 b0 = h03.b0();
            if (b0 == null) {
                hx1.c("FollowStatusApi", "swan app is null");
                return new hs1(1001, "swan app is null");
            } else if (b0.w() == null) {
                hx1.c("FollowStatusApi", "swan activity is null");
                return new hs1(1001, "swan activity is null");
            } else {
                Pair<hs1, JSONObject> s = s(str);
                hs1 hs1Var = (hs1) s.first;
                if (!hs1Var.isSuccess()) {
                    hx1.c("FollowStatusApi", "json str parse fail");
                    return hs1Var;
                }
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    hx1.c("FollowStatusApi", "cb is empty");
                    return new hs1(202, "cb is empty");
                }
                if (b0.N().e(oj2.c())) {
                    SwanFavorDataManager.h().d();
                }
                bd3.k(new a(this, b0, new JSONObject(), optString), "getFavorStatus");
                return new hs1(0);
            }
        }
        return (hs1) invokeL.objValue;
    }
}
