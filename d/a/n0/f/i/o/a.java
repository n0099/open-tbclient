package d.a.n0.f.i.o;

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
import d.a.n0.f.i.o.c;
import d.a.n0.f.i.r.h;
import d.a.n0.f.i.r.i;
import okhttp3.Response;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f49389a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.f.i.l.b f49390b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f49391c;

    /* renamed from: d.a.n0.f.i.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC1051a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f49392e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.f.i.l.g f49393f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f49394g;

        /* renamed from: d.a.n0.f.i.o.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1052a extends ResponseCallback<AdResponseInfo> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f49395a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ RunnableC1051a f49396b;

            /* renamed from: d.a.n0.f.i.o.a$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class RunnableC1053a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ AdElementInfo f49397e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ C1052a f49398f;

                public RunnableC1053a(C1052a c1052a, AdElementInfo adElementInfo) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c1052a, adElementInfo};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f49398f = c1052a;
                    this.f49397e = adElementInfo;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f49398f.f49396b.f49394g.f49390b == null) {
                        return;
                    }
                    this.f49398f.f49396b.f49394g.f49390b.c(this.f49397e);
                }
            }

            public C1052a(RunnableC1051a runnableC1051a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC1051a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f49396b = runnableC1051a;
                this.f49395a = 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public void onSuccess(AdResponseInfo adResponseInfo, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, adResponseInfo, i2) == null) {
                    RunnableC1051a runnableC1051a = this.f49396b;
                    runnableC1051a.f49394g.j(runnableC1051a.f49392e, "requestSuccess", runnableC1051a.f49393f);
                    if (adResponseInfo == null) {
                        this.f49396b.f49394g.g("200000");
                    } else if (adResponseInfo.getAdInstanceList().size() <= 0) {
                        if (!this.f49396b.f49394g.f49391c) {
                            RunnableC1051a runnableC1051a2 = this.f49396b;
                            runnableC1051a2.f49394g.j(runnableC1051a2.f49392e, "requestNoAd", runnableC1051a2.f49393f);
                        }
                        if (this.f49395a == 1 && this.f49396b.f49392e.f49425i.c() == "video" && i.h()) {
                            RunnableC1051a runnableC1051a3 = this.f49396b;
                            runnableC1051a3.f49394g.h(runnableC1051a3.f49393f, runnableC1051a3.f49392e, this);
                            return;
                        }
                        this.f49395a = 0;
                        String errorCode = adResponseInfo.getErrorCode();
                        if (errorCode.equals("0")) {
                            errorCode = "201000";
                        }
                        this.f49396b.f49394g.g(errorCode);
                    } else {
                        d.a.n0.f.i.r.d.c(new RunnableC1053a(this, adResponseInfo.getPrimaryAdInstanceInfo()));
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: b */
            public AdResponseInfo parseResponse(Response response, int i2) {
                InterceptResult invokeLI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i2)) == null) {
                    if (response != null && response.body() != null) {
                        this.f49395a++;
                        if (!response.isSuccessful()) {
                            return null;
                        }
                        try {
                            String string = response.body().string();
                            if (!TextUtils.isEmpty(string)) {
                                if (this.f49396b.f49394g.f49391c) {
                                    return new AdResponseInfo(string, this.f49396b.f49394g.f49391c);
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
                    this.f49396b.f49394g.g("3010002");
                    RunnableC1051a runnableC1051a = this.f49396b;
                    runnableC1051a.f49394g.j(runnableC1051a.f49392e, "requestFail", runnableC1051a.f49393f);
                }
            }
        }

        public RunnableC1051a(a aVar, e eVar, d.a.n0.f.i.l.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, eVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49394g = aVar;
            this.f49392e = eVar;
            this.f49393f = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (eVar = this.f49392e) == null || eVar.f49425i == null) {
                return;
            }
            C1052a c1052a = new C1052a(this);
            if (NetworkUtils.f(this.f49394g.f49389a)) {
                if (this.f49394g.f49391c) {
                    e eVar2 = this.f49392e;
                    if (eVar2 instanceof f) {
                        f fVar = (f) eVar2;
                        if (this.f49393f == null || fVar.i() == null) {
                            return;
                        }
                        this.f49393f.a(fVar.g(), fVar.i(), c1052a);
                        return;
                    }
                }
                this.f49394g.f49391c = false;
                String g2 = this.f49392e.g();
                d.a.n0.f.i.l.g gVar = this.f49393f;
                if (gVar != null) {
                    gVar.e(g2, c1052a);
                }
                this.f49394g.j(this.f49392e, "request", this.f49393f);
                return;
            }
            this.f49394g.g("3010003");
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f49399e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f49400f;

        public b(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49400f = aVar;
            this.f49399e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f49400f.f49390b == null) {
                return;
            }
            this.f49400f.f49390b.a(this.f49399e);
        }
    }

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f49389a = context;
    }

    public final void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            d.a.n0.f.i.r.d.c(new b(this, str));
        }
    }

    public void h(d.a.n0.f.i.l.g gVar, e eVar, ResponseCallback<AdResponseInfo> responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar, eVar, responseCallback) == null) {
            if (NetworkUtils.f(this.f49389a)) {
                this.f49391c = true;
                if (eVar instanceof f) {
                    f fVar = (f) eVar;
                    if (gVar == null || fVar.i() == null) {
                        return;
                    }
                    gVar.a(fVar.g(), fVar.i(), responseCallback);
                    return;
                }
                c.b bVar = new c.b();
                bVar.m(i.c());
                bVar.j(i.d());
                bVar.o(eVar.f49425i.g());
                bVar.l(h.i(this.f49389a));
                bVar.i(h.h(this.f49389a));
                f fVar2 = new f(this.f49389a, bVar.h(), 5, 5);
                if (gVar == null || fVar2.i() == null) {
                    return;
                }
                gVar.a(fVar2.g(), fVar2.i(), responseCallback);
                return;
            }
            g("3010003");
        }
    }

    public void i(e eVar, d.a.n0.f.i.l.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, eVar, gVar) == null) {
            d.a.n0.f.i.r.c.d(new RunnableC1051a(this, eVar, gVar), "execAdRequest");
        }
    }

    public final void j(e eVar, String str, d.a.n0.f.i.l.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, eVar, str, gVar) == null) {
            d.a.n0.f.i.q.b.n(str, d.a.n0.f.i.q.b.a(eVar.f49425i.c(), eVar.f49425i.f(), eVar.f49425i.e(), eVar.f49425i.b(), false), gVar);
        }
    }

    public void k(d.a.n0.f.i.l.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f49390b = bVar;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(Context context, boolean z) {
        this(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f49391c = z;
    }
}
