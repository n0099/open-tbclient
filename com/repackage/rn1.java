package com.repackage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArraySet;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.kn1;
import com.repackage.w23;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class rn1 extends kn1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements kn1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rn1 a;

        public a(rn1 rn1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rn1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rn1Var;
        }

        @Override // com.repackage.kn1.a
        public hr1 a(hz2 hz2Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, hz2Var, jSONObject, str)) == null) {
                String optString = jSONObject.optString("root");
                if (!TextUtils.isEmpty(optString)) {
                    this.a.D(hz2Var, optString, str);
                    return new hr1(0);
                }
                hw1.c("PreLoadSubPackageApi", "subPackage root is null");
                return new hr1(202);
            }
            return (hr1) invokeLLL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements kn1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rn1 a;

        public b(rn1 rn1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rn1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rn1Var;
        }

        @Override // com.repackage.kn1.a
        public hr1 a(hz2 hz2Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, hz2Var, jSONObject, str)) == null) {
                JSONArray optJSONArray = jSONObject.optJSONArray("roots");
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    this.a.B(hz2Var, str, optJSONArray);
                    return new hr1(0);
                }
                return new hr1(202);
            }
            return (hr1) invokeLLL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hz2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ JSONArray c;
        public final /* synthetic */ rn1 d;

        /* loaded from: classes7.dex */
        public class a implements w23.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CountDownLatch a;
            public final /* synthetic */ List b;
            public final /* synthetic */ String c;

            public a(c cVar, CountDownLatch countDownLatch, List list, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, countDownLatch, list, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = countDownLatch;
                this.b = list;
                this.c = str;
            }

            @Override // com.repackage.w23.e
            public void b(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    this.a.countDown();
                    this.b.add(this.c);
                }
            }

            @Override // com.repackage.w23.e
            public void c(int i, ab3 ab3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, ab3Var) == null) {
                    this.a.countDown();
                    hw1.o("PreLoadSubPackageApi", "downloadSubPackage fail, code=" + i);
                }
            }
        }

        public c(rn1 rn1Var, hz2 hz2Var, String str, JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rn1Var, hz2Var, str, jSONArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = rn1Var;
            this.a = hz2Var;
            this.b = str;
            this.c = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String j0 = this.a.j0();
                if (!TextUtils.isDigitsOnly(j0)) {
                    rn1 rn1Var = this.d;
                    String str = this.b;
                    rn1Var.d(str, new hr1(202, "current version error:" + j0));
                    return;
                }
                List<f84> k = c74.i().k(this.a.b, Integer.parseInt(j0));
                ArraySet<String> arraySet = new ArraySet();
                List synchronizedList = Collections.synchronizedList(new ArrayList());
                for (int i = 0; i < this.c.length(); i++) {
                    String optString = this.c.optString(i);
                    if (!TextUtils.isEmpty(optString)) {
                        if (rn1.E(optString, k) && this.a.t0(optString)) {
                            synchronizedList.add(optString);
                        } else {
                            arraySet.add(optString);
                        }
                    }
                }
                if (!arraySet.isEmpty()) {
                    CountDownLatch countDownLatch = new CountDownLatch(arraySet.size());
                    for (String str2 : arraySet) {
                        String Q = this.a.Q(str2);
                        if (TextUtils.isEmpty(Q)) {
                            countDownLatch.countDown();
                        } else {
                            hz2 hz2Var = this.a;
                            w23.l(hz2Var.b, hz2Var.j0(), "1", str2, Q, null, new a(this, countDownLatch, synchronizedList, str2));
                        }
                    }
                    try {
                        countDownLatch.await(1L, TimeUnit.MINUTES);
                    } catch (InterruptedException e) {
                        hw1.d("PreLoadSubPackageApi", "loadSubPackages", e);
                    }
                }
                JSONObject jSONObject = new JSONObject();
                for (int i2 = 0; i2 < this.c.length(); i2++) {
                    try {
                        jSONObject.put(this.c.optString(i2), synchronizedList.contains(this.c.optString(i2)) ? 0 : 1001);
                    } catch (Exception unused) {
                    }
                }
                this.d.d(this.b, new hr1(0, jSONObject));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hz2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ rn1 d;

        public d(rn1 rn1Var, hz2 hz2Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rn1Var, hz2Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = rn1Var;
            this.a = hz2Var;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.u0(this.b) && this.a.t0(this.b)) {
                    hw1.i("PreLoadSubPackageApi", "subPackage have existed");
                    this.d.d(this.c, new hr1(1001, "subPackage have existed"));
                    return;
                }
                String Q = this.a.Q(this.b);
                if (!TextUtils.isEmpty(Q)) {
                    this.d.C(this.a, this.b, Q, this.c);
                    return;
                }
                hw1.i("PreLoadSubPackageApi", "subPackage cannot find aps key");
                this.d.d(this.c, new hr1(202));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements w23.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ rn1 b;

        public e(rn1 rn1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rn1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rn1Var;
            this.a = str;
        }

        @Override // com.repackage.w23.e
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                hw1.i("PreLoadSubPackageApi", "preload subPackage success");
                this.b.d(this.a, new hr1(0, "preload subPackage success"));
            }
        }

        @Override // com.repackage.w23.e
        public void c(int i, ab3 ab3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, ab3Var) == null) {
                hw1.c("PreLoadSubPackageApi", "preload subPackage failed");
                this.b.d(this.a, new hr1(202, "No SubPackage"));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rn1(@NonNull in1 in1Var) {
        super(in1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {in1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((in1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static boolean E(@Nullable String str, @Nullable List<f84> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, list)) == null) {
            if (str != null && list != null && !list.isEmpty()) {
                for (f84 f84Var : list) {
                    if (f84Var != null && TextUtils.equals(f84Var.p, str)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void B(hz2 hz2Var, @Nullable String str, @NonNull JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, hz2Var, str, jSONArray) == null) {
            ExecutorUtilsExt.postOnElastic(new c(this, hz2Var, str, jSONArray), "PreLoadSubPackageApi", 2);
        }
    }

    public final void C(hz2 hz2Var, String str, String str2, @Nullable String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hz2Var, str, str2, str3) == null) {
            w23.l(hz2Var.b, hz2Var.j0(), "1", str, str2, null, new e(this, str3));
        }
    }

    public final void D(hz2 hz2Var, String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, hz2Var, str, str2) == null) {
            ExecutorUtilsExt.postOnElastic(new d(this, hz2Var, str, str2), "doLoadSubPackageAsync", 2);
        }
    }

    public hr1 F(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            q("#loadSubPackage", false);
            return l(str, true, new a(this));
        }
        return (hr1) invokeL.objValue;
    }

    public hr1 G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            q("#loadSubPackages", false);
            return l(str, true, new b(this));
        }
        return (hr1) invokeL.objValue;
    }

    @Override // com.repackage.kn1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "Basic" : (String) invokeV.objValue;
    }

    @Override // com.repackage.kn1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "PreLoadSubPackageApi" : (String) invokeV.objValue;
    }
}
