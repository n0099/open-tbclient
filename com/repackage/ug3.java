package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.agent.activity.MainProcessDelegateActivity;
import com.baidu.searchbox.process.ipc.agent.activity.PluginDelegateActivity;
import com.baidu.searchbox.process.ipc.delegate.DelegateListener;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bi3;
import com.repackage.fh3;
import com.repackage.mj3;
import com.repackage.xh3;
import com.repackage.yz2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class ug3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements DelegateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gh1 a;

        public a(gh1 gh1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gh1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gh1Var;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, delegateResult) == null) || this.a == null) {
                return;
            }
            if (!delegateResult.isOk()) {
                this.a.onResult(-1);
                return;
            }
            this.a.onResult(delegateResult.mResult.getInt("result_code", -1));
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends ax2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bi3.c c;

        public b(bi3.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = cVar;
        }

        @Override // com.repackage.ax2, com.repackage.zw2
        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 30000L;
            }
            return invokeV.longValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ax2, com.repackage.bx2, com.repackage.zw2
        public void onEvent(@NonNull xw2 xw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xw2Var) == null) {
                if (ug3.a) {
                    Log.d("AccountUtils", "get openBduss messenger delegate observer receive event");
                }
                String str = null;
                if (xw2Var.a() == null) {
                    if (ug3.a) {
                        Log.d("AccountUtils", "get openBduss : result null");
                    }
                } else {
                    str = xw2Var.a().getString("result");
                }
                this.c.a(str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c extends ax2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nf3 c;

        public c(nf3 nf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nf3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = nf3Var;
        }

        @Override // com.repackage.ax2, com.repackage.zw2
        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 30000L;
            }
            return invokeV.longValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ax2, com.repackage.bx2, com.repackage.zw2
        public void onEvent(@NonNull xw2 xw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xw2Var) == null) {
                if (ug3.a) {
                    Log.d("AccountUtils", "get stoken messenger delegate observer receive event");
                }
                Bundle bundle = null;
                if (xw2Var.a() != null) {
                    if (ug3.a) {
                        Log.d("AccountUtils", "get stoken : result " + xw2Var.a());
                    }
                    bundle = xw2Var.a().getBundle("key_result_stokent");
                } else if (ug3.a) {
                    Log.d("AccountUtils", "get stoken : result null");
                }
                this.c.onCallback(bundle);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d implements fh3.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nf3 a;

        public d(nf3 nf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nf3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nf3Var;
        }

        @Override // com.repackage.fh3.a
        public void a(fh3 fh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fh3Var) == null) {
                this.a.onCallback(null);
            }
        }

        @Override // com.repackage.fh3.a
        public void b(fh3 fh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fh3Var) == null) {
                if (fh3Var.a != 0 || fh3Var.b == null) {
                    this.a.onCallback(null);
                }
                Bundle bundle = new Bundle();
                for (Map.Entry<String, String> entry : fh3Var.b.entrySet()) {
                    String key = entry.getKey();
                    if (!TextUtils.isEmpty(key)) {
                        bundle.putString(key, entry.getValue());
                    }
                }
                this.a.onCallback(bundle);
            }
        }

        @Override // com.repackage.fh3.a
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // com.repackage.fh3.a
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class e implements DelegateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kh1 a;

        public e(kh1 kh1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kh1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kh1Var;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, delegateResult) == null) {
                String string = delegateResult.mResult.getString("address_info");
                if (TextUtils.isEmpty(string)) {
                    if (eh1.a) {
                        Log.e("AccountUtils", delegateResult.mResult.getString("errorMsg"));
                    }
                    this.a.a(0);
                    return;
                }
                if (eh1.a) {
                    Log.i("AccountUtils", string);
                }
                this.a.b(ud3.d(string));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class f implements vh3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Bundle a;
        public final /* synthetic */ nf3 b;

        public f(Bundle bundle, nf3 nf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bundle, nf3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bundle;
            this.b = nf3Var;
        }

        @Override // com.repackage.vh3
        public void a(th3 th3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th3Var) == null) {
                if (ug3.a) {
                    Log.d("AccountUtils", "callbackkey=" + th3Var.a);
                }
                this.a.putString("callbackKey", th3Var.a);
                nf3 nf3Var = this.b;
                if (nf3Var != null) {
                    nf3Var.onCallback(this.a);
                }
            }
        }

        @Override // com.repackage.vh3
        public void onFailure(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (ug3.a) {
                    Log.d("AccountUtils", "onFailure=" + str);
                }
                this.a.putString("failMsg", str);
                nf3 nf3Var = this.b;
                if (nf3Var != null) {
                    nf3Var.onCallback(this.a);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class g implements DelegateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nf3 a;

        public g(nf3 nf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nf3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nf3Var;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, delegateResult) == null) {
                Bundle bundle = delegateResult.mResult;
                nf3 nf3Var = this.a;
                if (nf3Var != null) {
                    nf3Var.onCallback(td3.d(bundle, "result"));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public h(Activity activity, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = activity;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ug3.O(this.a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class i implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;

        public i(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                ug3.M(this.a, true, null, null);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755261968, "Lcom/repackage/ug3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755261968, "Lcom/repackage/ug3;");
                return;
            }
        }
        a = eh1.a;
    }

    public static uh3 A(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (ProcessUtils.isMainProcess()) {
                return ph3.a().d(context);
            }
            return null;
        }
        return (uh3) invokeL.objValue;
    }

    public static uh3 B(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, ch3.class, null);
            if (callOnMainWithContentProvider.isOk()) {
                uh3 uh3Var = new uh3();
                uh3Var.a = callOnMainWithContentProvider.mResult.getString("NICK_NAME", "");
                uh3Var.b = callOnMainWithContentProvider.mResult.getString("AVATAR_URL", "");
                return uh3Var;
            }
            return null;
        }
        return (uh3) invokeL.objValue;
    }

    public static vh3 C(nf3<Bundle> nf3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, nf3Var)) == null) ? new f(new Bundle(), nf3Var) : (vh3) invokeL.objValue;
    }

    public static void D(Activity activity, JSONObject jSONObject) {
        JSONObject c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, jSONObject) == null) || (c2 = s53.c(jSONObject)) == null || activity == null) {
            return;
        }
        int optInt = c2.optInt("errno", 10001);
        String optString = c2.optString("tipmsg");
        if (optInt == 401 || optInt == 400701) {
            JSONObject optJSONObject = c2.optJSONObject("tipoption");
            String optString2 = optJSONObject != null ? optJSONObject.optString("title") : null;
            if (TextUtils.isEmpty(optString2) || TextUtils.isEmpty(optString)) {
                return;
            }
            oe3.e0(new h(activity, optString2, optString));
        }
    }

    public static boolean E(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            if (ProcessUtils.isMainProcess()) {
                return ph3.a().g(context);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean F(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            if (ProcessUtils.isMainProcess()) {
                return E(context);
            }
            return G(context);
        }
        return invokeL.booleanValue;
    }

    public static boolean G(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, dh3.class, null);
            return callOnMainWithContentProvider.isOk() && callOnMainWithContentProvider.mResult.getBoolean("result", false);
        }
        return invokeL.booleanValue;
    }

    public static void H(Activity activity, String str, nf3<Bundle> nf3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, activity, str, nf3Var) == null) {
            ph3.a().l(activity, "baidu_mini_programs_" + str, i(activity), C(nf3Var));
        }
    }

    public static void I(Activity activity, boolean z, String str, nf3<Bundle> nf3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{activity, Boolean.valueOf(z), str, nf3Var}) == null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("isRealName", z);
            bundle.putString("swanAppId", str);
            DelegateUtils.callOnMainWithActivity(activity, PluginDelegateActivity.class, vg3.class, bundle, new g(nf3Var));
        }
    }

    public static void J(Activity activity, String str, String str2, nf3<Bundle> nf3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65546, null, activity, str, str2, nf3Var) == null) {
            boolean equals = TextUtils.equals(str, "1");
            if (!ProcessUtils.isMainProcess()) {
                I(activity, equals, str2, nf3Var);
            } else if (equals) {
                H(activity, str2, nf3Var);
            } else {
                K(activity, str2, nf3Var);
            }
        }
    }

    public static void K(Activity activity, String str, nf3<Bundle> nf3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, activity, str, nf3Var) == null) {
            ph3.a().e(activity, "baidu_mini_programs_" + str, i(activity), C(nf3Var));
        }
    }

    public static void L(Context context, Bundle bundle, gh1 gh1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65548, null, context, bundle, gh1Var) == null) {
            if (!ProcessUtils.isMainProcess()) {
                gh1Var.onResult(-1);
            } else {
                ph3.a().c(context, bundle, gh1Var);
            }
        }
    }

    public static void M(Activity activity, boolean z, Bundle bundle, gh1 gh1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{activity, Boolean.valueOf(z), bundle, gh1Var}) == null) {
            if (ProcessUtils.isMainProcess()) {
                L(activity, bundle, gh1Var);
            } else {
                N(activity, z, bundle, gh1Var);
            }
        }
    }

    public static void N(Activity activity, boolean z, Bundle bundle, gh1 gh1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{activity, Boolean.valueOf(z), bundle, gh1Var}) == null) {
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("key_login_force", z);
            bundle2.putBundle("key_login_params", bundle);
            DelegateUtils.callOnMainWithActivity(activity, MainProcessDelegateActivity.class, eh3.class, bundle2, new a(gh1Var));
        }
    }

    public static void O(Activity activity, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65551, null, activity, str, str2) == null) {
            yz2.a aVar = new yz2.a(activity);
            aVar.V(str);
            aVar.x(str2);
            aVar.n(new cg3());
            aVar.m(true);
            aVar.P(activity.getString(R.string.obfuscated_res_0x7f0f1241), new i(activity));
            aVar.C(activity.getString(R.string.obfuscated_res_0x7f0f1242), null);
            aVar.X();
        }
    }

    public static void P(Context context, SwanAppPhoneLoginDialog.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65552, null, context, gVar, str) == null) {
            ph3.a().j(context, gVar, str);
        }
    }

    public static void c(ih1 ih1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65555, null, ih1Var) == null) || ih1Var == null) {
            return;
        }
        ph3.a().h(ih1Var);
    }

    public static void d(Context context, xh3.d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65556, null, context, dVar) == null) && ProcessUtils.isMainProcess()) {
            ph3.a().i(context, dVar);
        }
    }

    public static void e(Activity activity, kh1 kh1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65557, null, activity, kh1Var) == null) {
            DelegateUtils.callOnMainWithActivity(activity, MainProcessDelegateActivity.class, xh3.class, new e(kh1Var));
        }
    }

    public static void f(Context context, mj3.d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65558, null, context, dVar) == null) && ProcessUtils.isMainProcess()) {
            ph3.a().f(context, dVar);
        }
    }

    public static uh3 g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, context)) == null) {
            if (ProcessUtils.isMainProcess()) {
                return A(context);
            }
            return B(context);
        }
        return (uh3) invokeL.objValue;
    }

    public static String h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, context)) == null) {
            if (ProcessUtils.isMainProcess()) {
                String bduss = ph3.a().getBduss(context);
                return TextUtils.isEmpty(bduss) ? "" : bduss;
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, context)) == null) {
            if (ProcessUtils.isMainProcess()) {
                return h(context);
            }
            return j(context);
        }
        return (String) invokeL.objValue;
    }

    public static String j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, context)) == null) {
            DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, wg3.class, null);
            return callOnMainWithContentProvider.isOk() ? callOnMainWithContentProvider.mResult.getString("result", "") : "";
        }
        return (String) invokeL.objValue;
    }

    public static String k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65563, null, context)) == null) ? !ProcessUtils.isMainProcess() ? "" : ph3.a().k(context) : (String) invokeL.objValue;
    }

    public static String l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, context)) == null) {
            if (ProcessUtils.isMainProcess()) {
                return k(context);
            }
            return m(context);
        }
        return (String) invokeL.objValue;
    }

    public static String m(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, context)) == null) {
            DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, xg3.class, null);
            return callOnMainWithContentProvider.isOk() ? callOnMainWithContentProvider.mResult.getString("result", "") : "";
        }
        return (String) invokeL.objValue;
    }

    public static void n(String str, ArrayList<String> arrayList, bi3.c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65566, null, str, arrayList, cVar) == null) && ProcessUtils.isMainProcess()) {
            ph3.a().n(str, arrayList, cVar);
        }
    }

    public static void o(Context context, String str, ArrayList<String> arrayList, bi3.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65567, null, context, str, arrayList, cVar) == null) {
            if (ProcessUtils.isMainProcess()) {
                n(str, arrayList, cVar);
            } else {
                p(context, str, arrayList, cVar);
            }
        }
    }

    public static void p(Context context, String str, ArrayList<String> arrayList, bi3.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65568, null, context, str, arrayList, cVar) == null) {
            u03 L = u03.L();
            if (L == null) {
                cVar.a(null);
                return;
            }
            px2 z = L.z();
            if (z == null) {
                cVar.a(null);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("key_result_client_id", str);
            bundle.putStringArrayList("key_param_tpl_list", arrayList);
            z.W(bundle, yg3.class, new b(cVar));
        }
    }

    public static String q(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65569, null, context)) == null) ? !ProcessUtils.isMainProcess() ? "" : ph3.a().a(context) : (String) invokeL.objValue;
    }

    public static String r(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, context)) == null) {
            if (ProcessUtils.isMainProcess()) {
                return q(context);
            }
            return s(context);
        }
        return (String) invokeL.objValue;
    }

    public static String s(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, context)) == null) {
            DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, zg3.class, null);
            return callOnMainWithContentProvider.isOk() ? callOnMainWithContentProvider.mResult.getString("result", "") : "";
        }
        return (String) invokeL.objValue;
    }

    public static void t(Context context, nf3<Bundle> nf3Var, @Nullable String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65572, null, context, nf3Var, strArr) == null) {
            if (ProcessUtils.isMainProcess()) {
                u(context, nf3Var, strArr);
            } else {
                w(nf3Var, strArr);
            }
        }
    }

    public static void u(Context context, nf3<Bundle> nf3Var, @Nullable String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65573, null, context, nf3Var, strArr) == null) {
            if (ProcessUtils.isMainProcess()) {
                String h2 = h(context);
                if (TextUtils.isEmpty(h2)) {
                    nf3Var.onCallback(null);
                    return;
                } else {
                    v(new d(nf3Var), h2, strArr == null ? Collections.emptyList() : Arrays.asList(strArr));
                    return;
                }
            }
            throw new IllegalStateException("must call in MainProcess");
        }
    }

    public static void v(fh3.a aVar, String str, List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65574, null, aVar, str, list) == null) {
            ph3.a().o(aVar, str, list);
        }
    }

    public static void w(nf3<Bundle> nf3Var, String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65575, null, nf3Var, strArr) == null) {
            if (strArr != null && strArr.length >= 1) {
                u03 L = u03.L();
                if (L == null) {
                    nf3Var.onCallback(null);
                    return;
                }
                px2 z = L.z();
                if (z == null) {
                    nf3Var.onCallback(null);
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putStringArray("key_param_tpl_list", strArr);
                z.W(bundle, ah3.class, new c(nf3Var));
                return;
            }
            nf3Var.onCallback(null);
        }
    }

    public static String x(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65576, null, context)) == null) ? !ProcessUtils.isMainProcess() ? "" : ph3.a().b(context) : (String) invokeL.objValue;
    }

    public static String y(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65577, null, context)) == null) {
            if (ProcessUtils.isMainProcess()) {
                return x(context);
            }
            return z(context);
        }
        return (String) invokeL.objValue;
    }

    public static String z(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65578, null, context)) == null) {
            DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, bh3.class, null);
            return callOnMainWithContentProvider.isOk() ? callOnMainWithContentProvider.mResult.getString("result", "") : "";
        }
        return (String) invokeL.objValue;
    }
}
