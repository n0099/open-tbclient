package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.entity.AdResponseInfo;
import com.baidu.swan.game.ad.utils.NetworkUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.hp3;
import okhttp3.Response;
/* loaded from: classes6.dex */
public class ep3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public so3 b;
    public boolean c;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jp3 a;
        public final /* synthetic */ xo3 b;
        public final /* synthetic */ ep3 c;

        /* renamed from: com.repackage.ep3$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0622a extends ResponseCallback<AdResponseInfo> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;
            public final /* synthetic */ a b;

            /* renamed from: com.repackage.ep3$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class RunnableC0623a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AdElementInfo a;
                public final /* synthetic */ C0622a b;

                public RunnableC0623a(C0622a c0622a, AdElementInfo adElementInfo) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0622a, adElementInfo};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = c0622a;
                    this.a = adElementInfo;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.b.b.c.b == null) {
                        return;
                    }
                    this.b.b.c.b.c(this.a);
                }
            }

            public C0622a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public void onSuccess(AdResponseInfo adResponseInfo, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, adResponseInfo, i) == null) {
                    a aVar = this.b;
                    aVar.c.j(aVar.a, "requestSuccess", aVar.b);
                    if (adResponseInfo == null) {
                        this.b.c.g("200000");
                    } else if (adResponseInfo.getAdInstanceList().size() <= 0) {
                        if (!this.b.c.c) {
                            a aVar2 = this.b;
                            aVar2.c.j(aVar2.a, "requestNoAd", aVar2.b);
                        }
                        if (this.a == 1 && this.b.a.i.c() == "video" && aq3.h()) {
                            a aVar3 = this.b;
                            aVar3.c.h(aVar3.b, aVar3.a, this);
                            return;
                        }
                        this.a = 0;
                        String errorCode = adResponseInfo.getErrorCode();
                        if (errorCode.equals("0")) {
                            errorCode = "201000";
                        }
                        this.b.c.g(errorCode);
                    } else {
                        vp3.c(new RunnableC0623a(this, adResponseInfo.getPrimaryAdInstanceInfo()));
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: b */
            public AdResponseInfo parseResponse(Response response, int i) {
                InterceptResult invokeLI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i)) == null) {
                    if (response != null && response.body() != null) {
                        this.a++;
                        if (!response.isSuccessful()) {
                            return null;
                        }
                        try {
                            String string = response.body().string();
                            if (!TextUtils.isEmpty(string)) {
                                if (this.b.c.c) {
                                    return new AdResponseInfo(string, this.b.c.c);
                                }
                                return new AdResponseInfo(string);
                            }
                        } catch (Exception | OutOfMemoryError unused) {
                        }
                    }
                    return null;
                }
                return (AdResponseInfo) invokeLI.objValue;
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                    this.b.c.g("3010002");
                    a aVar = this.b;
                    aVar.c.j(aVar.a, "requestFail", aVar.b);
                }
            }
        }

        public a(ep3 ep3Var, jp3 jp3Var, xo3 xo3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ep3Var, jp3Var, xo3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ep3Var;
            this.a = jp3Var;
            this.b = xo3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            jp3 jp3Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (jp3Var = this.a) == null || jp3Var.i == null) {
                return;
            }
            C0622a c0622a = new C0622a(this);
            if (NetworkUtils.f(this.c.a)) {
                if (this.c.c) {
                    jp3 jp3Var2 = this.a;
                    if (jp3Var2 instanceof kp3) {
                        kp3 kp3Var = (kp3) jp3Var2;
                        if (this.b == null || kp3Var.i() == null) {
                            return;
                        }
                        this.b.a(kp3Var.g(), kp3Var.i(), c0622a);
                        return;
                    }
                }
                this.c.c = false;
                String g = this.a.g();
                xo3 xo3Var = this.b;
                if (xo3Var != null) {
                    xo3Var.f(g, c0622a);
                }
                this.c.j(this.a, "request", this.b);
                return;
            }
            this.c.g("3010003");
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ep3 b;

        public b(ep3 ep3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ep3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ep3Var;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.b.b == null) {
                return;
            }
            this.b.b.a(this.a);
        }
    }

    public ep3(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
    }

    public final void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            vp3.c(new b(this, str));
        }
    }

    public void h(xo3 xo3Var, jp3 jp3Var, ResponseCallback<AdResponseInfo> responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xo3Var, jp3Var, responseCallback) == null) {
            if (NetworkUtils.f(this.a)) {
                this.c = true;
                if (jp3Var instanceof kp3) {
                    kp3 kp3Var = (kp3) jp3Var;
                    if (xo3Var == null || kp3Var.i() == null) {
                        return;
                    }
                    xo3Var.a(kp3Var.g(), kp3Var.i(), responseCallback);
                    return;
                }
                hp3.b bVar = new hp3.b();
                bVar.m(aq3.c());
                bVar.j(aq3.d());
                bVar.o(jp3Var.i.g());
                bVar.l(zp3.i(this.a));
                bVar.i(zp3.h(this.a));
                kp3 kp3Var2 = new kp3(this.a, bVar.h(), 5, 5);
                if (xo3Var == null || kp3Var2.i() == null) {
                    return;
                }
                xo3Var.a(kp3Var2.g(), kp3Var2.i(), responseCallback);
                return;
            }
            g("3010003");
        }
    }

    public void i(jp3 jp3Var, xo3 xo3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, jp3Var, xo3Var) == null) {
            up3.d(new a(this, jp3Var, xo3Var), "execAdRequest");
        }
    }

    public final void j(jp3 jp3Var, String str, xo3 xo3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, jp3Var, str, xo3Var) == null) {
            pp3.n(str, pp3.a(jp3Var.i.c(), jp3Var.i.f(), jp3Var.i.e(), jp3Var.i.b(), false), xo3Var);
        }
    }

    public void k(so3 so3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, so3Var) == null) {
            this.b = so3Var;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ep3(Context context, boolean z) {
        this(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = z;
    }
}
