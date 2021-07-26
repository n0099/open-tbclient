package d.a.e0;

import android.content.Context;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.widget.PolyActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f42537a;

    /* renamed from: d.a.e0.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0580a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f42538a;

        /* renamed from: b  reason: collision with root package name */
        public Context f42539b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f42540c;

        public C0580a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42538a = 1;
            this.f42540c = false;
        }

        public a d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new a(this, null) : (a) invokeV.objValue;
        }

        public C0580a e(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                this.f42539b = context;
                return this;
            }
            return (C0580a) invokeL.objValue;
        }

        public C0580a f(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.f42540c = z;
                return this;
            }
            return (C0580a) invokeZ.objValue;
        }

        public C0580a g(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                this.f42538a = i2;
                return this;
            }
            return (C0580a) invokeI.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static abstract class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public abstract void a(int i2, String str);
    }

    /* loaded from: classes7.dex */
    public static /* synthetic */ class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public /* synthetic */ a(C0580a c0580a, c cVar) {
        this(c0580a);
    }

    public void a(Context context, Bundle bundle, d.a.e0.o.a.c cVar, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, context, bundle, cVar, bVar) == null) {
            if (context == null) {
                throw new IllegalArgumentException("context can not be null");
            }
            if (bundle == null) {
                throw new IllegalArgumentException("arguments can not be null");
            }
            if (cVar != null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f42537a < 1000) {
                    d.a.e0.n.d.e("cashier pay time interval less than 1s");
                    return;
                }
                this.f42537a = currentTimeMillis;
                d.a.e0.n.d.e("cashier pay");
                d.a.e0.k.h.a.c(Long.valueOf(currentTimeMillis));
                d.a.e0.k.h.d.b(new d.a.e0.k.h.b("0"));
                PolyActivity.a(context, cVar, bVar, bundle);
                return;
            }
            throw new IllegalArgumentException("channelPay can not be null");
        }
    }

    public void b(int i2, JSONObject jSONObject, d.a.e0.l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, jSONObject, aVar) == null) {
            if (i2 == 1) {
                d.a.e0.k.b.a.b(jSONObject, aVar);
            } else if (i2 == 2) {
                d.a.e0.k.c.a.a(aVar);
            } else if (aVar != null) {
                aVar.a(1, "unknown command");
            }
        }
    }

    public a(C0580a c0580a) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c0580a};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f42537a = 0L;
        if (c0580a != null) {
            if (c0580a.f42539b != null) {
                d.a.e0.k.b.a.c(c0580a.f42538a);
                d.a.e0.k.d.b.a(d.a.e0.k.d.a.e(c0580a.f42539b.getApplicationContext()));
                d.a.e0.n.g.b(c0580a.f42539b.getApplicationContext());
                d.a.e0.n.d.f42681d = c0580a.f42540c;
                return;
            }
            throw new IllegalArgumentException("context can not be null");
        }
        throw new IllegalArgumentException("builder can not be null");
    }
}
