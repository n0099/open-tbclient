package d.a.q0.a.h0.e;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.a2.e;
import d.a.q0.a.h;
import d.a.q0.a.p.d.n;
import d.a.q0.a.z1.b.b.h;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements n.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f47898a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f47899b;

        public a(Context context, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47898a = context;
            this.f47899b = bVar;
        }

        @Override // d.a.q0.a.p.d.n.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!z) {
                    d.a.q0.a.e0.d.b("DeveloperAuthenticateHelper", "Authentication Fail : Not developer");
                    this.f47899b.a(false, this.f47898a.getString(h.aiapps_authenticate_fail));
                    return;
                }
                d.a.q0.a.e0.d.b("DeveloperAuthenticateHelper", "Authentication Success");
                this.f47899b.a(true, "");
            }
        }

        @Override // d.a.q0.a.p.d.n.b
        public void b(Exception exc) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                d.a.q0.a.e0.d.c("DeveloperAuthenticateHelper", "onFail : Authentication exception :", exc);
                String message = exc.getMessage();
                StringBuilder sb = new StringBuilder();
                sb.append(this.f47898a.getString(h.aiapps_authenticate_fail));
                if (TextUtils.isEmpty(message)) {
                    str = "";
                } else {
                    str = "\n" + message;
                }
                sb.append(str);
                this.f47899b.a(false, sb.toString());
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a(boolean z, String str);
    }

    public static void a(@NonNull e eVar, @NonNull Context context, @NonNull b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, eVar, context, bVar) == null) {
            d.a.q0.a.m.b.b(eVar.D(), new a(context, bVar));
        }
    }

    public static void b(Context context, @StringRes int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65537, null, context, i2, str) == null) {
            h.a aVar = new h.a(context);
            aVar.U(i2);
            aVar.x(str);
            aVar.n(new d.a.q0.a.w2.h.a());
            aVar.O(d.a.q0.a.h.aiapps_confirm, null);
            aVar.X();
        }
    }

    public static void c(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, str) == null) {
            b(context, d.a.q0.a.h.aiapps_debug_switch_title, str);
        }
    }
}
