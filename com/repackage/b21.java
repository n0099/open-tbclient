package com.repackage;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.webview.AdWebActivity;
import com.baidu.nadcore.webview.AdWebActivityStandard;
import com.baidu.pyramid.annotation.Service;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.q21;
import java.util.HashMap;
import java.util.Map;
@Service
/* loaded from: classes5.dex */
public class b21 extends rg0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements q21.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ HashMap b;
        public final /* synthetic */ zg0 c;
        public final /* synthetic */ vg0 d;
        public final /* synthetic */ b21 e;

        public a(b21 b21Var, Context context, HashMap hashMap, zg0 zg0Var, vg0 vg0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b21Var, context, hashMap, zg0Var, vg0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = b21Var;
            this.a = context;
            this.b = hashMap;
            this.c = zg0Var;
            this.d = vg0Var;
        }

        @Override // com.repackage.q21.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean g = b21.g(this.a, this.b);
                this.e.c(this.c, this.d, g ? 0 : 1001, g);
            }
        }
    }

    public b21() {
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

    public static boolean g(Context context, @NonNull HashMap<String, String> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, hashMap)) == null) {
            if (xe0.a) {
                yz0.a().a(context, "启动SDK Webview");
            }
            if (x11.a.b(hashMap, 0)) {
                Intent intent = new Intent(context, "1".equals(hashMap.remove("newbrowser")) ? AdWebActivityStandard.class : AdWebActivity.class);
                intent.putExtra("map", hashMap);
                return k01.c(context, intent);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.repackage.rg0
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "easybrowse" : (String) invokeV.objValue;
    }

    @Override // com.repackage.rg0
    public boolean b(@NonNull Context context, @NonNull vg0 vg0Var, @Nullable Map<String, Object> map, @Nullable zg0 zg0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, vg0Var, map, zg0Var)) == null) {
            super.b(context, vg0Var, map, zg0Var);
            HashMap<String, String> d = vg0Var.d();
            int b = c21.b(context.getApplicationContext(), new a(this, context, d, zg0Var, vg0Var));
            if (4 != b && b != 0) {
                if (2 != b && 1 != b) {
                    boolean g = g(context, d);
                    c(zg0Var, vg0Var, g ? 0 : 1001, g);
                }
                return true;
            }
            c(zg0Var, vg0Var, 1001, false);
            if (xe0.a) {
                throw new IllegalStateException("web app init failed, state=" + b);
            }
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
