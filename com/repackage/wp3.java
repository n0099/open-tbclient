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
import com.repackage.zp3;
import okhttp3.Response;
/* loaded from: classes7.dex */
public class wp3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public kp3 b;
    public boolean c;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bq3 a;
        public final /* synthetic */ pp3 b;
        public final /* synthetic */ wp3 c;

        /* renamed from: com.repackage.wp3$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0612a extends ResponseCallback<AdResponseInfo> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;
            public final /* synthetic */ a b;

            /* renamed from: com.repackage.wp3$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class RunnableC0613a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AdElementInfo a;
                public final /* synthetic */ C0612a b;

                public RunnableC0613a(C0612a c0612a, AdElementInfo adElementInfo) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0612a, adElementInfo};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = c0612a;
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

            public C0612a(a aVar) {
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
                        if (this.a == 1 && this.b.a.i.c() == "video" && sq3.h()) {
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
                        nq3.c(new RunnableC0613a(this, adResponseInfo.getPrimaryAdInstanceInfo()));
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

        public a(wp3 wp3Var, bq3 bq3Var, pp3 pp3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wp3Var, bq3Var, pp3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = wp3Var;
            this.a = bq3Var;
            this.b = pp3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            bq3 bq3Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bq3Var = this.a) == null || bq3Var.i == null) {
                return;
            }
            C0612a c0612a = new C0612a(this);
            if (NetworkUtils.f(this.c.a)) {
                if (this.c.c) {
                    bq3 bq3Var2 = this.a;
                    if (bq3Var2 instanceof cq3) {
                        cq3 cq3Var = (cq3) bq3Var2;
                        if (this.b == null || cq3Var.i() == null) {
                            return;
                        }
                        this.b.a(cq3Var.g(), cq3Var.i(), c0612a);
                        return;
                    }
                }
                this.c.c = false;
                String g = this.a.g();
                pp3 pp3Var = this.b;
                if (pp3Var != null) {
                    pp3Var.f(g, c0612a);
                }
                this.c.j(this.a, "request", this.b);
                return;
            }
            this.c.g("3010003");
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ wp3 b;

        public b(wp3 wp3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wp3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wp3Var;
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

    public wp3(Context context) {
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
            nq3.c(new b(this, str));
        }
    }

    public void h(pp3 pp3Var, bq3 bq3Var, ResponseCallback<AdResponseInfo> responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pp3Var, bq3Var, responseCallback) == null) {
            if (NetworkUtils.f(this.a)) {
                this.c = true;
                if (bq3Var instanceof cq3) {
                    cq3 cq3Var = (cq3) bq3Var;
                    if (pp3Var == null || cq3Var.i() == null) {
                        return;
                    }
                    pp3Var.a(cq3Var.g(), cq3Var.i(), responseCallback);
                    return;
                }
                zp3.b bVar = new zp3.b();
                bVar.m(sq3.c());
                bVar.j(sq3.d());
                bVar.o(bq3Var.i.g());
                bVar.l(rq3.i(this.a));
                bVar.i(rq3.h(this.a));
                cq3 cq3Var2 = new cq3(this.a, bVar.h(), 5, 5);
                if (pp3Var == null || cq3Var2.i() == null) {
                    return;
                }
                pp3Var.a(cq3Var2.g(), cq3Var2.i(), responseCallback);
                return;
            }
            g("3010003");
        }
    }

    public void i(bq3 bq3Var, pp3 pp3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bq3Var, pp3Var) == null) {
            mq3.d(new a(this, bq3Var, pp3Var), "execAdRequest");
        }
    }

    public final void j(bq3 bq3Var, String str, pp3 pp3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, bq3Var, str, pp3Var) == null) {
            hq3.n(str, hq3.a(bq3Var.i.c(), bq3Var.i.f(), bq3Var.i.e(), bq3Var.i.b(), false), pp3Var);
        }
    }

    public void k(kp3 kp3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, kp3Var) == null) {
            this.b = kp3Var;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public wp3(Context context, boolean z) {
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
