package com.repackage;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLEncoder;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class re1 extends le1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile re1 g;
    public transient /* synthetic */ FieldHolder $fh;
    public oe1 c;
    public se1 d;
    public Context e;
    public int f;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ re1 a;

        public a(re1 re1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {re1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = re1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.a.i(true);
                } catch (Throwable th) {
                    df1.d(th);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ re1 b;

        public b(re1 re1Var, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {re1Var, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = re1Var;
            this.a = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.b.i(false)) {
                        sd1.f(this.b.e).F(this.a);
                    }
                } catch (Throwable th) {
                    df1.d(th);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ re1 a;

        public c(re1 re1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {re1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = re1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    re1.c(this.a.e).i(true);
                } catch (Throwable th) {
                    df1.d(th);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public re1(Context context, Handler handler) {
        super(context, handler);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, handler};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (Handler) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = 0;
        this.e = context;
        this.c = oe1.a(context);
        this.d = new se1();
    }

    public static re1 c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (g == null) {
                synchronized (re1.class) {
                    if (g == null) {
                        g = new re1(context, null);
                    }
                }
            }
            return g;
        }
        return (re1) invokeL.objValue;
    }

    public final JSONArray d(JSONArray jSONArray, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONArray, str)) == null) {
            try {
                jSONArray.put(new JSONObject(str));
            } catch (Throwable th) {
                df1.d(th);
            }
            return jSONArray;
        }
        return (JSONArray) invokeLL.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            long c0 = sd1.f(this.e).c0();
            long j0 = sd1.f(this.e).j0() * df1.e;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - c0 >= j0 && df1.j(this.e) != 0 && df1.n(this.e)) {
                qe1.a().post(new b(this, currentTimeMillis));
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION] complete} */
    public synchronized void f(String str, String str2, int i) {
        ve1 a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, str, str2, i) == null) {
            synchronized (this) {
                try {
                    a2 = this.d.a(this.e, str, str2, i, 1);
                } finally {
                }
                if (a2 == null) {
                    return;
                }
                this.f++;
                ue1.a(this.e).c(a2);
                if (this.f >= 2 && df1.n(this.e)) {
                    this.f = 0;
                    qe1.a().post(new a(this));
                }
            }
        }
    }

    public final boolean h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                byte[] bytes = hf1.b(ef1.a(this.e)).getBytes();
                byte[] f = df1.f();
                String b2 = this.c.b("p/1/r", URLEncoder.encode(Base64.encodeToString(ff1.h(f, bytes), 0)));
                byte[] e = this.c.e(f, str);
                if (e == null) {
                    return false;
                }
                String a2 = a(b2, e);
                if (TextUtils.isEmpty(a2)) {
                    return false;
                }
                try {
                } catch (Throwable th) {
                    df1.d(th);
                }
                return new JSONObject(a2).getInt("response") == 1;
            } catch (Throwable th2) {
                df1.d(th2);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final boolean i(boolean z) {
        InterceptResult invokeZ;
        boolean z2;
        ArrayList<ve1> b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            try {
                int j = df1.j(this.e);
                if (j != 2) {
                    z2 = j == 1 ? true : true;
                    return false;
                }
                z2 = false;
                String valueOf = z ? String.valueOf(1) : "1,2";
                if (z2) {
                    b2 = ue1.a(this.e).e(valueOf);
                    String b0 = sd1.f(this.e).b0();
                    String a2 = df1.a();
                    if (!TextUtils.isEmpty(a2) && !a2.equals(b0)) {
                        sd1.f(this.e).G(a2);
                        sd1.f(this.e).U(0L);
                    }
                } else {
                    b2 = ue1.a(this.e).b(valueOf);
                }
                if (b2 != null && b2.size() != 0) {
                    long n0 = sd1.f(this.e).n0();
                    int size = b2.size();
                    long h0 = sd1.f(this.e).h0() * 1048576;
                    JSONArray jSONArray = new JSONArray();
                    ArrayList<ve1> arrayList = new ArrayList<>();
                    for (int i = 0; i < size; i++) {
                        ve1 ve1Var = b2.get(i);
                        if (ve1Var != null) {
                            String d = ve1Var.d();
                            if (z2) {
                                if (d.length() + n0 > h0) {
                                    break;
                                }
                                n0 += d.length();
                            }
                            d(jSONArray, d);
                            arrayList.add(ve1Var);
                        }
                    }
                    if (jSONArray.length() == 0) {
                        return false;
                    }
                    boolean h = h(jSONArray.toString());
                    if (h) {
                        ue1.a(this.e).d(arrayList);
                        if (z2) {
                            sd1.f(this.e).U(sd1.f(this.e).n0() + jSONArray.toString().length());
                        }
                    }
                    return h;
                }
                return false;
            } catch (Throwable th) {
                df1.d(th);
                return false;
            }
        }
        return invokeZ.booleanValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && df1.n(this.e)) {
            qe1.a().post(new c(this));
        }
    }
}
