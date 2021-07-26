package d.a.o0.f.i.o;

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
import d.a.o0.f.i.o.c;
import d.a.o0.f.i.r.h;
import d.a.o0.f.i.r.i;
import okhttp3.Response;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f49893a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.o0.f.i.l.b f49894b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f49895c;

    /* renamed from: d.a.o0.f.i.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC1060a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f49896e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.f.i.l.g f49897f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f49898g;

        /* renamed from: d.a.o0.f.i.o.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1061a extends ResponseCallback<AdResponseInfo> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f49899a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ RunnableC1060a f49900b;

            /* renamed from: d.a.o0.f.i.o.a$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class RunnableC1062a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ AdElementInfo f49901e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ C1061a f49902f;

                public RunnableC1062a(C1061a c1061a, AdElementInfo adElementInfo) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c1061a, adElementInfo};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f49902f = c1061a;
                    this.f49901e = adElementInfo;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f49902f.f49900b.f49898g.f49894b == null) {
                        return;
                    }
                    this.f49902f.f49900b.f49898g.f49894b.c(this.f49901e);
                }
            }

            public C1061a(RunnableC1060a runnableC1060a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC1060a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f49900b = runnableC1060a;
                this.f49899a = 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public void onSuccess(AdResponseInfo adResponseInfo, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, adResponseInfo, i2) == null) {
                    RunnableC1060a runnableC1060a = this.f49900b;
                    runnableC1060a.f49898g.j(runnableC1060a.f49896e, "requestSuccess", runnableC1060a.f49897f);
                    if (adResponseInfo == null) {
                        this.f49900b.f49898g.g("200000");
                    } else if (adResponseInfo.getAdInstanceList().size() <= 0) {
                        if (!this.f49900b.f49898g.f49895c) {
                            RunnableC1060a runnableC1060a2 = this.f49900b;
                            runnableC1060a2.f49898g.j(runnableC1060a2.f49896e, "requestNoAd", runnableC1060a2.f49897f);
                        }
                        if (this.f49899a == 1 && this.f49900b.f49896e.f49929i.c() == "video" && i.h()) {
                            RunnableC1060a runnableC1060a3 = this.f49900b;
                            runnableC1060a3.f49898g.h(runnableC1060a3.f49897f, runnableC1060a3.f49896e, this);
                            return;
                        }
                        this.f49899a = 0;
                        String errorCode = adResponseInfo.getErrorCode();
                        if (errorCode.equals("0")) {
                            errorCode = "201000";
                        }
                        this.f49900b.f49898g.g(errorCode);
                    } else {
                        d.a.o0.f.i.r.d.c(new RunnableC1062a(this, adResponseInfo.getPrimaryAdInstanceInfo()));
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
                        this.f49899a++;
                        if (!response.isSuccessful()) {
                            return null;
                        }
                        try {
                            String string = response.body().string();
                            if (!TextUtils.isEmpty(string)) {
                                if (this.f49900b.f49898g.f49895c) {
                                    return new AdResponseInfo(string, this.f49900b.f49898g.f49895c);
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
                    this.f49900b.f49898g.g("3010002");
                    RunnableC1060a runnableC1060a = this.f49900b;
                    runnableC1060a.f49898g.j(runnableC1060a.f49896e, "requestFail", runnableC1060a.f49897f);
                }
            }
        }

        public RunnableC1060a(a aVar, e eVar, d.a.o0.f.i.l.g gVar) {
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
            this.f49898g = aVar;
            this.f49896e = eVar;
            this.f49897f = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (eVar = this.f49896e) == null || eVar.f49929i == null) {
                return;
            }
            C1061a c1061a = new C1061a(this);
            if (NetworkUtils.f(this.f49898g.f49893a)) {
                if (this.f49898g.f49895c) {
                    e eVar2 = this.f49896e;
                    if (eVar2 instanceof f) {
                        f fVar = (f) eVar2;
                        if (this.f49897f == null || fVar.i() == null) {
                            return;
                        }
                        this.f49897f.a(fVar.g(), fVar.i(), c1061a);
                        return;
                    }
                }
                this.f49898g.f49895c = false;
                String g2 = this.f49896e.g();
                d.a.o0.f.i.l.g gVar = this.f49897f;
                if (gVar != null) {
                    gVar.e(g2, c1061a);
                }
                this.f49898g.j(this.f49896e, "request", this.f49897f);
                return;
            }
            this.f49898g.g("3010003");
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f49903e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f49904f;

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
            this.f49904f = aVar;
            this.f49903e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f49904f.f49894b == null) {
                return;
            }
            this.f49904f.f49894b.a(this.f49903e);
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
        this.f49893a = context;
    }

    public final void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            d.a.o0.f.i.r.d.c(new b(this, str));
        }
    }

    public void h(d.a.o0.f.i.l.g gVar, e eVar, ResponseCallback<AdResponseInfo> responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar, eVar, responseCallback) == null) {
            if (NetworkUtils.f(this.f49893a)) {
                this.f49895c = true;
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
                bVar.o(eVar.f49929i.g());
                bVar.l(h.i(this.f49893a));
                bVar.i(h.h(this.f49893a));
                f fVar2 = new f(this.f49893a, bVar.h(), 5, 5);
                if (gVar == null || fVar2.i() == null) {
                    return;
                }
                gVar.a(fVar2.g(), fVar2.i(), responseCallback);
                return;
            }
            g("3010003");
        }
    }

    public void i(e eVar, d.a.o0.f.i.l.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, eVar, gVar) == null) {
            d.a.o0.f.i.r.c.d(new RunnableC1060a(this, eVar, gVar), "execAdRequest");
        }
    }

    public final void j(e eVar, String str, d.a.o0.f.i.l.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, eVar, str, gVar) == null) {
            d.a.o0.f.i.q.b.n(str, d.a.o0.f.i.q.b.a(eVar.f49929i.c(), eVar.f49929i.f(), eVar.f49929i.e(), eVar.f49929i.b(), false), gVar);
        }
    }

    public void k(d.a.o0.f.i.l.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f49894b = bVar;
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
        this.f49895c = z;
    }
}
