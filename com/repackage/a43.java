package com.repackage;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.xo1;
import java.util.Collections;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a43 extends tr1 {
    public static /* synthetic */ Interceptable $ic;
    public static a82 f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements xo1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a43 a;

        /* renamed from: com.repackage.a43$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0374a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ JSONObject a;
            public final /* synthetic */ String b;
            public final /* synthetic */ String c;
            public final /* synthetic */ a d;

            /* renamed from: com.repackage.a43$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class C0375a implements h84 {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String a;
                public final /* synthetic */ RunnableC0374a b;

                public C0375a(RunnableC0374a runnableC0374a, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0374a, str};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = runnableC0374a;
                    this.a = str;
                }

                @Override // com.repackage.h84
                public void a(@Nullable Map<String, String> map) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, map) == null) {
                        if (map == null) {
                            ux1.c("PreloadPackageApi", "preloadPackage keyMap null");
                            return;
                        }
                        RunnableC0374a runnableC0374a = this.b;
                        runnableC0374a.d.a.z(map.get(this.b.b), this.a, runnableC0374a.c);
                    }
                }

                @Override // com.repackage.h84
                public void onFail(Exception exc) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                        ux1.c("PreloadPackageApi", "preloadPackage transform openBundleId fail");
                    }
                }
            }

            public RunnableC0374a(a aVar, JSONObject jSONObject, String str, String str2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, jSONObject, str, str2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.d = aVar;
                this.a = jSONObject;
                this.b = str;
                this.c = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    boolean g = hd4.e().g(!oe3.G());
                    String optString = this.a.optString(PrefetchEvent.EVENT_KEY_PAGE_URL);
                    if (!g) {
                        this.d.a.z(this.b, optString, this.c);
                    } else {
                        c84.e(Collections.singletonList(this.b), a43.f.c(), new C0375a(this, optString));
                    }
                }
            }
        }

        public a(a43 a43Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a43Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a43Var;
        }

        @Override // com.repackage.xo1.a
        public us1 a(u03 u03Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, u03Var, jSONObject, str)) == null) {
                String optString = jSONObject.optString("appKey");
                if (!TextUtils.isEmpty(optString)) {
                    if (!a43.f.a(1)) {
                        return new us1(402, "over single max limit");
                    }
                    od3.h().execute(new RunnableC0374a(this, jSONObject, optString, str), "PreloadPackageApi");
                    return us1.f();
                }
                return new us1(202, "appKey must not empty");
            }
            return (us1) invokeLLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends ProviderDelegation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
                String string = bundle.getString("appKey");
                String e1 = sl2.e1(string, bundle.getString(PrefetchEvent.EVENT_KEY_PAGE_URL), 0, null);
                PrefetchEvent.b bVar = new PrefetchEvent.b();
                bVar.e("show");
                bVar.d(e1);
                bVar.c("10");
                bVar.a(string);
                t42.g().f(bVar.b());
                return null;
            }
            return (Bundle) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a43(@NonNull vo1 vo1Var) {
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

    public us1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#preloadPackage", false);
            String a2 = ws1.a(t03.J().getAppId());
            if (TextUtils.isEmpty(a2)) {
                return new us1(101, "runtime parameter error");
            }
            a82 a82Var = f;
            if (a82Var == null || !a82Var.d(a2)) {
                f = new a82(a2, ed4.b(a2));
            }
            if (f.e()) {
                return new us1(402, "over max limit");
            }
            if (!f.b()) {
                return new us1(402, "over time interval limit");
            }
            return l(str, false, new a(this));
        }
        return (us1) invokeL.objValue;
    }

    @Override // com.repackage.xo1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "PreloadPackageApi" : (String) invokeV.objValue;
    }

    public final void z(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, str3) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("appKey", str);
            bundle.putString(PrefetchEvent.EVENT_KEY_PAGE_URL, str2);
            hx2.b(b.class, bundle);
        }
    }
}
