package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ej1;
import com.repackage.ly2;
/* loaded from: classes5.dex */
public class dy1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements ej1.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ b b;

        public a(Context context, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = bVar;
        }

        @Override // com.repackage.ej1.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!z) {
                    hw1.c("DeveloperAuthenticateHelper", "Authentication Fail : Not developer");
                    this.b.a(false, this.a.getString(R.string.obfuscated_res_0x7f0f0106));
                    return;
                }
                hw1.c("DeveloperAuthenticateHelper", "Authentication Success");
                this.b.a(true, "");
            }
        }

        @Override // com.repackage.ej1.b
        public void b(Exception exc) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                hw1.d("DeveloperAuthenticateHelper", "onFail : Authentication exception :", exc);
                String message = exc.getMessage();
                StringBuilder sb = new StringBuilder();
                sb.append(this.a.getString(R.string.obfuscated_res_0x7f0f0106));
                if (TextUtils.isEmpty(message)) {
                    str = "";
                } else {
                    str = "\n" + message;
                }
                sb.append(str);
                this.b.a(false, sb.toString());
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(boolean z, String str);
    }

    public static void a(@NonNull hz2 hz2Var, @NonNull Context context, @NonNull b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, hz2Var, context, bVar) == null) {
            uf1.b(hz2Var.N(), new a(context, bVar));
        }
    }

    public static void b(Context context, @StringRes int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65537, null, context, i, str) == null) {
            ly2.a aVar = new ly2.a(context);
            aVar.U(i);
            aVar.x(str);
            aVar.n(new pe3());
            aVar.O(R.string.obfuscated_res_0x7f0f0113, null);
            aVar.X();
        }
    }

    public static void c(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, str) == null) {
            b(context, R.string.obfuscated_res_0x7f0f014c, str);
        }
    }
}
