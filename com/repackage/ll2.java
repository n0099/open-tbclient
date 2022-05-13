package com.repackage;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.kl2;
import java.util.Map;
/* loaded from: classes6.dex */
public class ll2 extends uw2 {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, nf3<Bundle>> h;
    public transient /* synthetic */ FieldHolder $fh;
    public int f;
    public String g;

    /* loaded from: classes6.dex */
    public class a implements nf3<Bundle> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ll2 b;

        public a(ll2 ll2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ll2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ll2Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
                this.b.g = bundle.getString("key_launch_app_id");
                this.b.f = bundle.getInt("key_launch_status");
                if (TextUtils.equals(this.a, this.b.g)) {
                    ll2 ll2Var = this.b;
                    ll2Var.d.putInt("ok", ll2Var.f);
                    this.b.c();
                }
                ll2.h.remove(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements nf3<Bundle> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ kl2.e b;

        public b(String str, kl2.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
                String string = bundle.getString("key_launch_app_id");
                int i = bundle.getInt("key_launch_status");
                if (TextUtils.equals(this.a, string)) {
                    if (i == 0) {
                        this.b.b();
                    } else {
                        this.b.a();
                    }
                }
                ll2.h.remove(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755525313, "Lcom/repackage/ll2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755525313, "Lcom/repackage/ll2;");
                return;
            }
        }
        boolean z = eh1.a;
        h = new af4();
    }

    public ll2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = -1;
        this.g = "";
    }

    public static void j(String str, kl2.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, null, str, eVar) == null) || TextUtils.isEmpty(str) || eVar == null) {
            return;
        }
        h.put(str, new b(str, eVar));
    }

    public static void k(String str) {
        nf3<Bundle> nf3Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, null, str) == null) || (nf3Var = h.get(str)) == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("key_launch_app_id", str);
        bundle.putInt("key_launch_status", 1);
        nf3Var.onCallback(bundle);
    }

    public static void l(String str) {
        nf3<Bundle> nf3Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, null, str) == null) || (nf3Var = h.get(str)) == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("key_launch_app_id", str);
        bundle.putInt("key_launch_status", 0);
        nf3Var.onCallback(bundle);
    }

    @Override // com.repackage.uw2
    public void b(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            String string = bundle.getString("desAppId");
            h.put(string, new a(this, string));
        }
    }
}
