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
import com.repackage.l31;
import java.util.HashMap;
import java.util.Map;
@Service
/* loaded from: classes7.dex */
public class w21 extends uh0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements l31.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ HashMap b;
        public final /* synthetic */ ci0 c;
        public final /* synthetic */ yh0 d;
        public final /* synthetic */ w21 e;

        public a(w21 w21Var, Context context, HashMap hashMap, ci0 ci0Var, yh0 yh0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w21Var, context, hashMap, ci0Var, yh0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = w21Var;
            this.a = context;
            this.b = hashMap;
            this.c = ci0Var;
            this.d = yh0Var;
        }

        @Override // com.repackage.l31.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean g = w21.g(this.a, this.b);
                this.e.c(this.c, this.d, g ? 0 : 1001, g);
            }
        }
    }

    public w21() {
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
            if (bg0.a) {
                u01.a().a(context, "启动SDK Webview");
            }
            if (s21.a.b(hashMap, 0)) {
                Intent intent = new Intent(context, "1".equals(hashMap.remove("newbrowser")) ? AdWebActivityStandard.class : AdWebActivity.class);
                intent.putExtra("map", hashMap);
                return g11.c(context, intent);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.repackage.uh0
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "easybrowse" : (String) invokeV.objValue;
    }

    @Override // com.repackage.uh0
    public boolean b(@NonNull Context context, @NonNull yh0 yh0Var, @Nullable Map<String, Object> map, @Nullable ci0 ci0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, yh0Var, map, ci0Var)) == null) {
            super.b(context, yh0Var, map, ci0Var);
            HashMap<String, String> d = yh0Var.d();
            int b = x21.b(context.getApplicationContext(), new a(this, context, d, ci0Var, yh0Var));
            if (4 != b && b != 0) {
                if (2 != b && 1 != b) {
                    boolean g = g(context, d);
                    c(ci0Var, yh0Var, g ? 0 : 1001, g);
                }
                return true;
            }
            c(ci0Var, yh0Var, 1001, false);
            if (bg0.a) {
                throw new IllegalStateException("web app init failed, state=" + b);
            }
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
