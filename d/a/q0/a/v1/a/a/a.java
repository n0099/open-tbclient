package d.a.q0.a.v1.a.a;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.k;
/* loaded from: classes8.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f51196e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Bundle f51197a;

    /* renamed from: b  reason: collision with root package name */
    public int f51198b;

    /* renamed from: c  reason: collision with root package name */
    public String f51199c;

    /* renamed from: d  reason: collision with root package name */
    public Bundle f51200d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1337564689, "Ld/a/q0/a/v1/a/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1337564689, "Ld/a/q0/a/v1/a/a/a;");
                return;
            }
        }
        f51196e = k.f49133a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f51197a = new Bundle();
        this.f51199c = "";
        this.f51200d = new Bundle();
    }

    public abstract void b(@NonNull Bundle bundle);

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d(this.f51200d);
        }
    }

    public void d(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            if (f51196e) {
                Log.d("MDelegate-Delegation", "messenger delegation finish");
            }
            if (d.a.q0.a.v1.a.b.d.a.a(this.f51199c)) {
                return;
            }
            if (f51196e) {
                Log.d("MDelegate-Delegation", "messenger delegation finish with send result to client: " + this.f51198b + " observer: " + this.f51199c);
            }
            b.c(this.f51198b, this.f51199c, bundle);
        }
    }
}
