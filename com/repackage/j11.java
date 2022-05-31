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
import com.repackage.y11;
import java.util.HashMap;
import java.util.Map;
@Service
/* loaded from: classes6.dex */
public class j11 extends hg0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements y11.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ HashMap b;
        public final /* synthetic */ pg0 c;
        public final /* synthetic */ lg0 d;
        public final /* synthetic */ j11 e;

        public a(j11 j11Var, Context context, HashMap hashMap, pg0 pg0Var, lg0 lg0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j11Var, context, hashMap, pg0Var, lg0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = j11Var;
            this.a = context;
            this.b = hashMap;
            this.c = pg0Var;
            this.d = lg0Var;
        }

        @Override // com.repackage.y11.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean g = j11.g(this.a, this.b);
                this.e.c(this.c, this.d, g ? 0 : 1001, g);
            }
        }
    }

    public j11() {
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
            if (oe0.a) {
                hz0.a().a(context, "启动SDK Webview");
            }
            if (f11.a.b(hashMap, 0)) {
                Intent intent = new Intent(context, "1".equals(hashMap.remove("newbrowser")) ? AdWebActivityStandard.class : AdWebActivity.class);
                intent.putExtra("map", hashMap);
                return tz0.c(context, intent);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.repackage.hg0
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "easybrowse" : (String) invokeV.objValue;
    }

    @Override // com.repackage.hg0
    public boolean b(@NonNull Context context, @NonNull lg0 lg0Var, @Nullable Map<String, Object> map, @Nullable pg0 pg0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, lg0Var, map, pg0Var)) == null) {
            super.b(context, lg0Var, map, pg0Var);
            HashMap<String, String> d = lg0Var.d();
            int b = k11.b(context.getApplicationContext(), new a(this, context, d, pg0Var, lg0Var));
            if (4 != b && b != 0) {
                if (2 != b && 1 != b) {
                    boolean g = g(context, d);
                    c(pg0Var, lg0Var, g ? 0 : 1001, g);
                }
                return true;
            }
            c(pg0Var, lg0Var, 1001, false);
            if (oe0.a) {
                throw new IllegalStateException("web app init failed, state=" + b);
            }
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
