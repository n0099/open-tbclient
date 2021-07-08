package d.a.l0.e;

import android.content.Context;
import cn.com.chinatelecom.gateway.lib.CtAuth;
import cn.com.chinatelecom.gateway.lib.PreCodeListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.retrieve.RetrieveFileData;
import com.baidu.mapapi.UIMsg;
import com.baidu.sapi2.activity.social.YYInnerSSOLoginActivity;
import com.baidu.sapi2.result.OneKeyLoginOptResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.iddetect.IdCardActivity;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class f extends j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean s;

    /* loaded from: classes7.dex */
    public class a implements PreCodeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f43008a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f43009b;

        public a(f fVar, long j, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Long.valueOf(j), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43009b = fVar;
            this.f43008a = i2;
        }

        @Override // cn.com.chinatelecom.gateway.lib.PreCodeListener
        public void onResult(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f43009b.w(str, this.f43008a, 1);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements PreCodeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f43010a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f43011b;

        public b(f fVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43011b = fVar;
            this.f43010a = i2;
        }

        @Override // cn.com.chinatelecom.gateway.lib.PreCodeListener
        public void onResult(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f43011b.w(str, this.f43010a, 3);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends d.a.l0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f43012f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f43013g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f43014h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ f f43015i;

        public c(f fVar, String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43015i = fVar;
            this.f43012f = str;
            this.f43013g = i2;
            this.f43014h = i3;
        }

        @Override // d.a.l0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(this.f43012f);
                    if (jSONObject.optInt("result", -1) == 0) {
                        this.f43015i.z(jSONObject, this.f43013g, this.f43014h);
                    } else {
                        this.f43015i.x(jSONObject, this.f43013g, this.f43014h);
                    }
                } catch (Throwable th) {
                    d.a.l0.l.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends d.a.l0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f43016f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f43017g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ JSONObject f43018h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ f f43019i;

        public d(f fVar, int i2, int i3, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Integer.valueOf(i2), Integer.valueOf(i3), jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43019i = fVar;
            this.f43016f = i2;
            this.f43017g = i3;
            this.f43018h = jSONObject;
        }

        @Override // d.a.l0.k.c
        public void b() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (d.a.l0.b.c.f42938c) {
                        this.f43019i.e(this.f43016f, 1, 999, this.f43019i.f43048c, "device has risk.", this.f43017g);
                        return;
                    }
                    JSONObject optJSONObject = this.f43018h.optJSONObject("data");
                    if (this.f43017g == 1) {
                        this.f43019i.f43050e = optJSONObject.optString(YYInnerSSOLoginActivity.o, "");
                        this.f43019i.f43052g = optJSONObject.optString(IdCardActivity.KEY_NUMBER, "");
                        this.f43019i.f43051f = System.currentTimeMillis() + (optJSONObject.optInt(RetrieveFileData.EXPIRED, 0) * 1000);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE, this.f43019i.a(this.f43019i.f43052g));
                        str = jSONObject.toString();
                    } else {
                        this.f43019i.f43053h = optJSONObject.optString(YYInnerSSOLoginActivity.o, "");
                        this.f43019i.f43054i = System.currentTimeMillis() + (optJSONObject.optInt(RetrieveFileData.EXPIRED, 0) * 1000);
                        str = "preVerify success";
                    }
                    this.f43019i.e(this.f43016f, 0, 0, this.f43019i.f43048c, str, this.f43017g);
                } catch (Throwable unused) {
                    f fVar = this.f43019i;
                    fVar.e(this.f43016f, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, fVar.f43048c, "ct on handle pre login or verify unknown error.", this.f43017g);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends d.a.l0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f43020f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f43021g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f43022h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ f f43023i;

        public e(f fVar, JSONObject jSONObject, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, jSONObject, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43023i = fVar;
            this.f43020f = jSONObject;
            this.f43021g = i2;
            this.f43022h = i3;
        }

        @Override // d.a.l0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    int optInt = this.f43020f.optInt("result", -1);
                    String optString = this.f43020f.optString("msg", "");
                    if (this.f43023i.f43048c != this.f43023i.f43049d && (optInt == -10009 || optInt == -10008)) {
                        this.f43023i.e(this.f43021g, 3, 2002, this.f43023i.f43048c, "pre login error, wrong sim operator", this.f43022h);
                    } else {
                        f fVar = this.f43023i;
                        int i2 = this.f43021g;
                        int i3 = this.f43023i.f43048c;
                        StringBuilder sb = new StringBuilder();
                        sb.append("ct pre login error.");
                        sb.append(optString);
                        sb.append(", status ");
                        sb.append(optInt);
                        fVar.e(i2, 2, optInt, i3, sb.toString(), this.f43022h);
                    }
                } catch (Throwable unused) {
                    f fVar2 = this.f43023i;
                    fVar2.e(this.f43021g, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, fVar2.f43048c, "ct on handle pre login or verify unknown error.", this.f43022h);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Context context) {
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
        this.f43048c = 3;
    }

    @Override // d.a.l0.e.i
    public void h(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, context, i2) == null) {
            super.h(context, i2);
            if (!d.a.l0.b.a.h(this.f43046a).d()) {
                e(i2, 3, 997, this.f43048c, "pre login error. sdk stop run.", 1);
            } else if (!r()) {
                e(i2, 3, 2006, this.f43048c, "pre login error. ct has not valid config.", 1);
            } else if (d.a.l0.b.a.h(this.f43046a).a()) {
                if (!this.s) {
                    System.currentTimeMillis();
                    CtAuth.init(0, 0, 8000, null);
                    this.s = true;
                }
                CtAuth.requestPreAuthCode(context, i.m, i.n, new a(this, System.currentTimeMillis(), i2));
            } else {
                e(i2, 3, 996, this.f43048c, "pre login error. ct sdk stop run.", 1);
            }
        }
    }

    @Override // d.a.l0.e.i
    public void o(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i2) == null) {
            super.o(context, i2);
            if (!d.a.l0.b.a.h(this.f43046a).d()) {
                e(i2, 3, 997, this.f43048c, "pre verify error. sdk stop run.", 3);
            } else if (!r()) {
                e(i2, 3, 2006, this.f43048c, "pre verify error. ct has not valid config.", 3);
            } else if (d.a.l0.b.a.h(this.f43046a).a()) {
                if (!this.s) {
                    CtAuth.init(0, 0, 8000, null);
                    this.s = true;
                }
                CtAuth.requestPreAuthCode(context, i.m, i.n, new b(this, i2));
            } else {
                e(i2, 3, 996, this.f43048c, "pre verify error. ct sdk stop run.", 3);
            }
        }
    }

    @Override // d.a.l0.e.j, d.a.l0.e.i
    public void p(Context context, int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            super.p(context, i2, j);
        }
    }

    public final void w(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048579, this, str, i2, i3) == null) {
            d.a.l0.k.e.c().b(new c(this, str, i2, i3));
        }
    }

    public final void x(JSONObject jSONObject, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048580, this, jSONObject, i2, i3) == null) {
            d.a.l0.k.e.c().b(new e(this, jSONObject, i2, i3));
        }
    }

    public final void z(JSONObject jSONObject, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048581, this, jSONObject, i2, i3) == null) {
            d.a.l0.k.e.c().b(new d(this, i2, i3, jSONObject));
        }
    }
}
