package d.a.m0.e;

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
/* loaded from: classes7.dex */
public class g extends j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean s;

    /* loaded from: classes7.dex */
    public class a implements CallBack<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f43528a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f43529b;

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
            this.f43529b = gVar;
            this.f43528a = i2;
        }

        @Override // com.sdk.base.api.CallBack
        public void onFailed(int i2, int i3, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, str2}) == null) {
                this.f43529b.y(i3, str, this.f43528a);
            }
        }

        @Override // com.sdk.base.api.CallBack
        public void onSuccess(int i2, String str, int i3, Object obj, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), obj, str2}) == null) {
                if (i2 == 0) {
                    this.f43529b.x(obj, this.f43528a);
                } else {
                    this.f43529b.y(i3, str, this.f43528a);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements CallBack<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f43530a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f43531b;

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
            this.f43531b = gVar;
            this.f43530a = i2;
        }

        @Override // com.sdk.base.api.CallBack
        public void onFailed(int i2, int i3, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, str2}) == null) {
                this.f43531b.u(i3, str, this.f43530a);
            }
        }

        @Override // com.sdk.base.api.CallBack
        public void onSuccess(int i2, String str, int i3, Object obj, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), obj, str2}) == null) {
                if (i2 == 0) {
                    this.f43531b.A(obj, this.f43530a);
                } else {
                    this.f43531b.u(i3, str, this.f43530a);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends d.a.m0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f43532f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Object f43533g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g f43534h;

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
            this.f43534h = gVar;
            this.f43532f = i2;
            this.f43533g = obj;
        }

        @Override // d.a.m0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (d.a.m0.b.c.f43442c) {
                        this.f43534h.e(this.f43532f, 1, 999, this.f43534h.f43552c, "device has risk.", 1);
                        return;
                    }
                    JSONObject jSONObject = new JSONObject((String) this.f43533g);
                    this.f43534h.f43556g = jSONObject.optString(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE);
                    this.f43534h.f43554e = jSONObject.optString(YYInnerSSOLoginActivity.o);
                    this.f43534h.f43555f = jSONObject.optLong("exp");
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE, this.f43534h.a(this.f43534h.f43556g));
                    this.f43534h.e(this.f43532f, 0, 0, this.f43534h.f43552c, jSONObject2.toString(), 1);
                } catch (Throwable unused) {
                    g gVar = this.f43534h;
                    gVar.e(this.f43532f, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, gVar.f43552c, "cu on handle login unknown error.", 1);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends d.a.m0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f43535f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f43536g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f43537h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f43538i;

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
            this.f43538i = gVar;
            this.f43535f = i2;
            this.f43536g = i3;
            this.f43537h = str;
        }

        @Override // d.a.m0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f43538i.f43552c != this.f43538i.f43553d && this.f43535f == 1101) {
                        this.f43538i.e(this.f43536g, 3, 2002, this.f43538i.f43552c, "pre login error, wrong sim operator", 1);
                    } else {
                        g gVar = this.f43538i;
                        int i2 = this.f43536g;
                        int i3 = this.f43535f;
                        int i4 = this.f43538i.f43552c;
                        StringBuilder sb = new StringBuilder();
                        sb.append("cu pre login error.");
                        sb.append(this.f43537h);
                        sb.append(", status ");
                        sb.append(this.f43535f);
                        gVar.e(i2, 2, i3, i4, sb.toString(), 1);
                    }
                } catch (Throwable unused) {
                    g gVar2 = this.f43538i;
                    gVar2.e(this.f43536g, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, gVar2.f43552c, "cu on handle login unknown error.", 1);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends d.a.m0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f43539f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Object f43540g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g f43541h;

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
            this.f43541h = gVar;
            this.f43539f = i2;
            this.f43540g = obj;
        }

        @Override // d.a.m0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (d.a.m0.b.c.f43442c) {
                        this.f43541h.e(this.f43539f, 1, 999, this.f43541h.f43552c, "device has risk.", 3);
                        return;
                    }
                    JSONObject jSONObject = new JSONObject((String) this.f43540g);
                    this.f43541h.f43557h = jSONObject.optString(YYInnerSSOLoginActivity.o);
                    this.f43541h.f43558i = jSONObject.optLong("exp");
                    this.f43541h.e(this.f43539f, 0, 0, this.f43541h.f43552c, "preVerify success", 3);
                } catch (Throwable unused) {
                    g gVar = this.f43541h;
                    gVar.e(this.f43539f, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, gVar.f43552c, "cu on handle preVerify unknown error.", 3);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f extends d.a.m0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f43542f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f43543g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f43544h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f43545i;

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
            this.f43545i = gVar;
            this.f43542f = i2;
            this.f43543g = i3;
            this.f43544h = str;
        }

        @Override // d.a.m0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f43545i.f43552c != this.f43545i.f43553d && this.f43542f == 1101) {
                        this.f43545i.e(this.f43543g, 3, 2002, this.f43545i.f43552c, "pre verify error, wrong sim operator", 3);
                    } else {
                        g gVar = this.f43545i;
                        int i2 = this.f43543g;
                        int i3 = this.f43542f;
                        int i4 = this.f43545i.f43552c;
                        StringBuilder sb = new StringBuilder();
                        sb.append("cu pre verify error.");
                        sb.append(this.f43544h);
                        sb.append(", status ");
                        sb.append(this.f43542f);
                        gVar.e(i2, 2, i3, i4, sb.toString(), 3);
                    }
                } catch (Throwable unused) {
                    g gVar2 = this.f43545i;
                    gVar2.e(this.f43543g, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, gVar2.f43552c, "cu on handle verify unknown error.", 3);
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
        this.f43552c = 2;
    }

    public final void A(Object obj, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, obj, i2) == null) {
            d.a.m0.k.e.c().b(new e(this, i2, obj));
        }
    }

    @Override // d.a.m0.e.i
    public void h(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i2) == null) {
            super.h(context, i2);
            if (!d.a.m0.b.a.h(this.f43550a).d()) {
                e(i2, 3, 997, this.f43552c, "pre login error. sdk stop run", 1);
            } else if (!r()) {
                e(i2, 3, 2006, this.f43552c, "pre login error. cu has not valid config.", 1);
            } else if (d.a.m0.b.a.h(this.f43550a).b()) {
                if (!this.s) {
                    System.currentTimeMillis();
                    SDKManager.init(this.f43550a, i.o, i.p);
                    SDKManager.setUseCache(false);
                    this.s = true;
                }
                UiOauthManager.getInstance(context).login(8, new a(this, System.currentTimeMillis(), i2));
            } else {
                e(i2, 3, 995, this.f43552c, "pre login error. cu sdk stop run.", 1);
            }
        }
    }

    @Override // d.a.m0.e.i
    public void o(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, context, i2) == null) {
            super.o(context, i2);
            if (!d.a.m0.b.a.h(this.f43550a).d()) {
                e(i2, 3, 997, this.f43552c, "pre verify error. sdk stop run", 3);
            } else if (!r()) {
                e(i2, 3, 2006, this.f43552c, "pre verify error. cu has not valid config.", 3);
            } else if (d.a.m0.b.a.h(this.f43550a).b()) {
                if (!this.s) {
                    SDKManager.init(this.f43550a, i.o, i.p);
                    SDKManager.setUseCache(false);
                    this.s = true;
                }
                OauthManager.getInstance(this.f43550a).getAuthoriseCode(8, new b(this, i2));
            } else {
                e(i2, 3, 995, this.f43552c, "pre verify error. cu sdk stop run.", 3);
            }
        }
    }

    @Override // d.a.m0.e.j, d.a.m0.e.i
    public void p(Context context, int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            super.p(context, i2, j);
        }
    }

    public void u(int i2, String str, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3)}) == null) {
            d.a.m0.k.e.c().b(new f(this, i2, i3, str));
        }
    }

    public final void x(Object obj, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, obj, i2) == null) {
            d.a.m0.k.e.c().b(new c(this, i2, obj));
        }
    }

    public final void y(int i2, String str, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3)}) == null) {
            d.a.m0.k.e.c().b(new d(this, i2, i3, str));
        }
    }
}
