package d.a.o0.e;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.UIMsg;
import com.baidu.sapi2.activity.social.YYInnerSSOLoginActivity;
import com.baidu.sapi2.result.OneKeyLoginOptResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sdk.base.api.CallBack;
import com.sdk.base.module.manager.SDKManager;
import com.sdk.mobile.manager.login.cucc.UiOauthManager;
import com.sdk.mobile.manager.oauth.cucc.OauthManager;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class g extends j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean s;

    /* loaded from: classes8.dex */
    public class a implements CallBack<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f46324a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f46325b;

        public a(g gVar, long j, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, Long.valueOf(j), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46325b = gVar;
            this.f46324a = i2;
        }

        @Override // com.sdk.base.api.CallBack
        public void onFailed(int i2, int i3, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, str2}) == null) {
                this.f46325b.y(i3, str, this.f46324a);
            }
        }

        @Override // com.sdk.base.api.CallBack
        public void onSuccess(int i2, String str, int i3, Object obj, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), obj, str2}) == null) {
                if (i2 == 0) {
                    this.f46325b.x(obj, this.f46324a);
                } else {
                    this.f46325b.y(i3, str, this.f46324a);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements CallBack<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f46326a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f46327b;

        public b(g gVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46327b = gVar;
            this.f46326a = i2;
        }

        @Override // com.sdk.base.api.CallBack
        public void onFailed(int i2, int i3, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, str2}) == null) {
                this.f46327b.u(i3, str, this.f46326a);
            }
        }

        @Override // com.sdk.base.api.CallBack
        public void onSuccess(int i2, String str, int i3, Object obj, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), obj, str2}) == null) {
                if (i2 == 0) {
                    this.f46327b.A(obj, this.f46326a);
                } else {
                    this.f46327b.u(i3, str, this.f46326a);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends d.a.o0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f46328f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Object f46329g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g f46330h;

        public c(g gVar, int i2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, Integer.valueOf(i2), obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46330h = gVar;
            this.f46328f = i2;
            this.f46329g = obj;
        }

        @Override // d.a.o0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (d.a.o0.b.c.f46238c) {
                        this.f46330h.e(this.f46328f, 1, 999, this.f46330h.f46348c, "device has risk.", 1);
                        return;
                    }
                    JSONObject jSONObject = new JSONObject((String) this.f46329g);
                    this.f46330h.f46352g = jSONObject.optString(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE);
                    this.f46330h.f46350e = jSONObject.optString(YYInnerSSOLoginActivity.o);
                    this.f46330h.f46351f = jSONObject.optLong("exp");
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE, this.f46330h.a(this.f46330h.f46352g));
                    this.f46330h.e(this.f46328f, 0, 0, this.f46330h.f46348c, jSONObject2.toString(), 1);
                } catch (Throwable unused) {
                    g gVar = this.f46330h;
                    gVar.e(this.f46328f, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, gVar.f46348c, "cu on handle login unknown error.", 1);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends d.a.o0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f46331f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f46332g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f46333h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f46334i;

        public d(g gVar, int i2, int i3, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, Integer.valueOf(i2), Integer.valueOf(i3), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46334i = gVar;
            this.f46331f = i2;
            this.f46332g = i3;
            this.f46333h = str;
        }

        @Override // d.a.o0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f46334i.f46348c != this.f46334i.f46349d && this.f46331f == 1101) {
                        this.f46334i.e(this.f46332g, 3, 2002, this.f46334i.f46348c, "pre login error, wrong sim operator", 1);
                    } else {
                        g gVar = this.f46334i;
                        int i2 = this.f46332g;
                        int i3 = this.f46331f;
                        int i4 = this.f46334i.f46348c;
                        StringBuilder sb = new StringBuilder();
                        sb.append("cu pre login error.");
                        sb.append(this.f46333h);
                        sb.append(", status ");
                        sb.append(this.f46331f);
                        gVar.e(i2, 2, i3, i4, sb.toString(), 1);
                    }
                } catch (Throwable unused) {
                    g gVar2 = this.f46334i;
                    gVar2.e(this.f46332g, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, gVar2.f46348c, "cu on handle login unknown error.", 1);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends d.a.o0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f46335f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Object f46336g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g f46337h;

        public e(g gVar, int i2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, Integer.valueOf(i2), obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46337h = gVar;
            this.f46335f = i2;
            this.f46336g = obj;
        }

        @Override // d.a.o0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (d.a.o0.b.c.f46238c) {
                        this.f46337h.e(this.f46335f, 1, 999, this.f46337h.f46348c, "device has risk.", 3);
                        return;
                    }
                    JSONObject jSONObject = new JSONObject((String) this.f46336g);
                    this.f46337h.f46353h = jSONObject.optString(YYInnerSSOLoginActivity.o);
                    this.f46337h.f46354i = jSONObject.optLong("exp");
                    this.f46337h.e(this.f46335f, 0, 0, this.f46337h.f46348c, "preVerify success", 3);
                } catch (Throwable unused) {
                    g gVar = this.f46337h;
                    gVar.e(this.f46335f, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, gVar.f46348c, "cu on handle preVerify unknown error.", 3);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f extends d.a.o0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f46338f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f46339g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f46340h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f46341i;

        public f(g gVar, int i2, int i3, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, Integer.valueOf(i2), Integer.valueOf(i3), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46341i = gVar;
            this.f46338f = i2;
            this.f46339g = i3;
            this.f46340h = str;
        }

        @Override // d.a.o0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f46341i.f46348c != this.f46341i.f46349d && this.f46338f == 1101) {
                        this.f46341i.e(this.f46339g, 3, 2002, this.f46341i.f46348c, "pre verify error, wrong sim operator", 3);
                    } else {
                        g gVar = this.f46341i;
                        int i2 = this.f46339g;
                        int i3 = this.f46338f;
                        int i4 = this.f46341i.f46348c;
                        StringBuilder sb = new StringBuilder();
                        sb.append("cu pre verify error.");
                        sb.append(this.f46340h);
                        sb.append(", status ");
                        sb.append(this.f46338f);
                        gVar.e(i2, 2, i3, i4, sb.toString(), 3);
                    }
                } catch (Throwable unused) {
                    g gVar2 = this.f46341i;
                    gVar2.e(this.f46339g, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, gVar2.f46348c, "cu on handle verify unknown error.", 3);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.s = false;
        this.f46348c = 2;
    }

    public final void A(Object obj, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, obj, i2) == null) {
            d.a.o0.k.e.c().b(new e(this, i2, obj));
        }
    }

    @Override // d.a.o0.e.i
    public void h(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i2) == null) {
            super.h(context, i2);
            if (!d.a.o0.b.a.h(this.f46346a).d()) {
                e(i2, 3, 997, this.f46348c, "pre login error. sdk stop run", 1);
            } else if (!r()) {
                e(i2, 3, 2006, this.f46348c, "pre login error. cu has not valid config.", 1);
            } else if (d.a.o0.b.a.h(this.f46346a).b()) {
                if (!this.s) {
                    System.currentTimeMillis();
                    SDKManager.init(this.f46346a, i.o, i.p);
                    SDKManager.setUseCache(false);
                    this.s = true;
                }
                UiOauthManager.getInstance(context).login(8, new a(this, System.currentTimeMillis(), i2));
            } else {
                e(i2, 3, 995, this.f46348c, "pre login error. cu sdk stop run.", 1);
            }
        }
    }

    @Override // d.a.o0.e.i
    public void o(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, context, i2) == null) {
            super.o(context, i2);
            if (!d.a.o0.b.a.h(this.f46346a).d()) {
                e(i2, 3, 997, this.f46348c, "pre verify error. sdk stop run", 3);
            } else if (!r()) {
                e(i2, 3, 2006, this.f46348c, "pre verify error. cu has not valid config.", 3);
            } else if (d.a.o0.b.a.h(this.f46346a).b()) {
                if (!this.s) {
                    SDKManager.init(this.f46346a, i.o, i.p);
                    SDKManager.setUseCache(false);
                    this.s = true;
                }
                OauthManager.getInstance(this.f46346a).getAuthoriseCode(8, new b(this, i2));
            } else {
                e(i2, 3, 995, this.f46348c, "pre verify error. cu sdk stop run.", 3);
            }
        }
    }

    @Override // d.a.o0.e.j, d.a.o0.e.i
    public void p(Context context, int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            super.p(context, i2, j);
        }
    }

    public void u(int i2, String str, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3)}) == null) {
            d.a.o0.k.e.c().b(new f(this, i2, i3, str));
        }
    }

    public final void x(Object obj, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, obj, i2) == null) {
            d.a.o0.k.e.c().b(new c(this, i2, obj));
        }
    }

    public final void y(int i2, String str, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3)}) == null) {
            d.a.o0.k.e.c().b(new d(this, i2, i3, str));
        }
    }
}
