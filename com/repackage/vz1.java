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
import com.repackage.d03;
import com.repackage.wk1;
/* loaded from: classes7.dex */
public class vz1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements wk1.b {
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

        @Override // com.repackage.wk1.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!z) {
                    zx1.c("DeveloperAuthenticateHelper", "Authentication Fail : Not developer");
                    this.b.a(false, this.a.getString(R.string.obfuscated_res_0x7f0f010b));
                    return;
                }
                zx1.c("DeveloperAuthenticateHelper", "Authentication Success");
                this.b.a(true, "");
            }
        }

        @Override // com.repackage.wk1.b
        public void b(Exception exc) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                zx1.d("DeveloperAuthenticateHelper", "onFail : Authentication exception :", exc);
                String message = exc.getMessage();
                StringBuilder sb = new StringBuilder();
                sb.append(this.a.getString(R.string.obfuscated_res_0x7f0f010b));
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

    /* loaded from: classes7.dex */
    public interface b {
        void a(boolean z, String str);
    }

    public static void a(@NonNull z03 z03Var, @NonNull Context context, @NonNull b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, z03Var, context, bVar) == null) {
            mh1.b(z03Var.O(), new a(context, bVar));
        }
    }

    public static void b(Context context, @StringRes int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65537, null, context, i, str) == null) {
            d03.a aVar = new d03.a(context);
            aVar.U(i);
            aVar.x(str);
            aVar.n(new hg3());
            aVar.O(R.string.obfuscated_res_0x7f0f0118, null);
            aVar.X();
        }
    }

    public static void c(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, str) == null) {
            b(context, R.string.obfuscated_res_0x7f0f0151, str);
        }
    }
}
