package d.a.q0.f.i.o;

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
import d.a.q0.f.i.o.c;
import d.a.q0.f.i.r.h;
import d.a.q0.f.i.r.i;
import okhttp3.Response;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f52691a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.q0.f.i.l.b f52692b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f52693c;

    /* renamed from: d.a.q0.f.i.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC1102a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f52694e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.f.i.l.g f52695f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f52696g;

        /* renamed from: d.a.q0.f.i.o.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C1103a extends ResponseCallback<AdResponseInfo> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f52697a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ RunnableC1102a f52698b;

            /* renamed from: d.a.q0.f.i.o.a$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class RunnableC1104a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ AdElementInfo f52699e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ C1103a f52700f;

                public RunnableC1104a(C1103a c1103a, AdElementInfo adElementInfo) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c1103a, adElementInfo};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f52700f = c1103a;
                    this.f52699e = adElementInfo;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f52700f.f52698b.f52696g.f52692b == null) {
                        return;
                    }
                    this.f52700f.f52698b.f52696g.f52692b.c(this.f52699e);
                }
            }

            public C1103a(RunnableC1102a runnableC1102a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC1102a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f52698b = runnableC1102a;
                this.f52697a = 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public void onSuccess(AdResponseInfo adResponseInfo, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, adResponseInfo, i2) == null) {
                    RunnableC1102a runnableC1102a = this.f52698b;
                    runnableC1102a.f52696g.j(runnableC1102a.f52694e, "requestSuccess", runnableC1102a.f52695f);
                    if (adResponseInfo == null) {
                        this.f52698b.f52696g.g("200000");
                    } else if (adResponseInfo.getAdInstanceList().size() <= 0) {
                        if (!this.f52698b.f52696g.f52693c) {
                            RunnableC1102a runnableC1102a2 = this.f52698b;
                            runnableC1102a2.f52696g.j(runnableC1102a2.f52694e, "requestNoAd", runnableC1102a2.f52695f);
                        }
                        if (this.f52697a == 1 && this.f52698b.f52694e.f52727i.c() == "video" && i.h()) {
                            RunnableC1102a runnableC1102a3 = this.f52698b;
                            runnableC1102a3.f52696g.h(runnableC1102a3.f52695f, runnableC1102a3.f52694e, this);
                            return;
                        }
                        this.f52697a = 0;
                        String errorCode = adResponseInfo.getErrorCode();
                        if (errorCode.equals("0")) {
                            errorCode = "201000";
                        }
                        this.f52698b.f52696g.g(errorCode);
                    } else {
                        d.a.q0.f.i.r.d.c(new RunnableC1104a(this, adResponseInfo.getPrimaryAdInstanceInfo()));
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
                        this.f52697a++;
                        if (!response.isSuccessful()) {
                            return null;
                        }
                        try {
                            String string = response.body().string();
                            if (!TextUtils.isEmpty(string)) {
                                if (this.f52698b.f52696g.f52693c) {
                                    return new AdResponseInfo(string, this.f52698b.f52696g.f52693c);
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
                    this.f52698b.f52696g.g("3010002");
                    RunnableC1102a runnableC1102a = this.f52698b;
                    runnableC1102a.f52696g.j(runnableC1102a.f52694e, "requestFail", runnableC1102a.f52695f);
                }
            }
        }

        public RunnableC1102a(a aVar, e eVar, d.a.q0.f.i.l.g gVar) {
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
            this.f52696g = aVar;
            this.f52694e = eVar;
            this.f52695f = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (eVar = this.f52694e) == null || eVar.f52727i == null) {
                return;
            }
            C1103a c1103a = new C1103a(this);
            if (NetworkUtils.f(this.f52696g.f52691a)) {
                if (this.f52696g.f52693c) {
                    e eVar2 = this.f52694e;
                    if (eVar2 instanceof f) {
                        f fVar = (f) eVar2;
                        if (this.f52695f == null || fVar.i() == null) {
                            return;
                        }
                        this.f52695f.a(fVar.g(), fVar.i(), c1103a);
                        return;
                    }
                }
                this.f52696g.f52693c = false;
                String g2 = this.f52694e.g();
                d.a.q0.f.i.l.g gVar = this.f52695f;
                if (gVar != null) {
                    gVar.e(g2, c1103a);
                }
                this.f52696g.j(this.f52694e, "request", this.f52695f);
                return;
            }
            this.f52696g.g("3010003");
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f52701e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f52702f;

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
            this.f52702f = aVar;
            this.f52701e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f52702f.f52692b == null) {
                return;
            }
            this.f52702f.f52692b.a(this.f52701e);
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
        this.f52691a = context;
    }

    public final void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            d.a.q0.f.i.r.d.c(new b(this, str));
        }
    }

    public void h(d.a.q0.f.i.l.g gVar, e eVar, ResponseCallback<AdResponseInfo> responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar, eVar, responseCallback) == null) {
            if (NetworkUtils.f(this.f52691a)) {
                this.f52693c = true;
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
                bVar.o(eVar.f52727i.g());
                bVar.l(h.i(this.f52691a));
                bVar.i(h.h(this.f52691a));
                f fVar2 = new f(this.f52691a, bVar.h(), 5, 5);
                if (gVar == null || fVar2.i() == null) {
                    return;
                }
                gVar.a(fVar2.g(), fVar2.i(), responseCallback);
                return;
            }
            g("3010003");
        }
    }

    public void i(e eVar, d.a.q0.f.i.l.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, eVar, gVar) == null) {
            d.a.q0.f.i.r.c.d(new RunnableC1102a(this, eVar, gVar), "execAdRequest");
        }
    }

    public final void j(e eVar, String str, d.a.q0.f.i.l.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, eVar, str, gVar) == null) {
            d.a.q0.f.i.q.b.n(str, d.a.q0.f.i.q.b.a(eVar.f52727i.c(), eVar.f52727i.f(), eVar.f52727i.e(), eVar.f52727i.b(), false), gVar);
        }
    }

    public void k(d.a.q0.f.i.l.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f52692b = bVar;
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
        this.f52693c = z;
    }
}
