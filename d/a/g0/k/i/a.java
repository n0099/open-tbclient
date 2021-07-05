package d.a.g0.k.i;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.poly.widget.m;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.g0.f;
import d.a.g0.g;
import d.a.g0.h;
import d.a.g0.p.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static volatile a f45450e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f45451a;

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.poly.a.l.c f45452b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.g0.p.c f45453c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.g0.p.c f45454d;

    /* renamed from: d.a.g0.k.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0630a extends d.a.g0.k.a.a<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f45455a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f45456b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f45457c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Bundle f45458d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f45459e;

        public C0630a(a aVar, m mVar, boolean z, Context context, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, mVar, Boolean.valueOf(z), context, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45459e = aVar;
            this.f45455a = mVar;
            this.f45456b = z;
            this.f45457c = context;
            this.f45458d = bundle;
        }

        @Override // d.a.g0.k.a.a
        public void b(Throwable th, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th, str) == null) {
                this.f45459e.j("2", str);
                m mVar = this.f45455a;
                mVar.m("get trade state failed : " + str, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.g0.k.a.a
        /* renamed from: c */
        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
                int optInt = jSONObject.optInt("payStatus", 3);
                this.f45459e.j("1", String.valueOf(optInt));
                if (optInt == 2) {
                    this.f45455a.g(0, d.a.g0.n.b.a(0, jSONObject.optString("payOrderNo"), jSONObject.optString("msg")));
                } else if (this.f45456b) {
                    this.f45459e.c(this.f45457c, this.f45458d, this.f45455a);
                } else {
                    this.f45459e.e(this.f45457c, this.f45455a);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f45460e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f45461f;

        public b(a aVar, m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45461f = aVar;
            this.f45460e = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f45461f.f45453c.q();
                d.a.g0.k.h.b bVar = new d.a.g0.k.h.b("103");
                bVar.c("1");
                d.a.g0.k.h.d.b(bVar);
                this.f45460e.g(3, "pay failed , click choose window");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f45462e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bundle f45463f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ m f45464g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f45465h;

        public c(a aVar, Context context, Bundle bundle, m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context, bundle, mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45465h = aVar;
            this.f45462e = context;
            this.f45463f = bundle;
            this.f45464g = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f45465h.f45453c.q();
                d.a.g0.k.h.b bVar = new d.a.g0.k.h.b("103");
                bVar.c("2");
                d.a.g0.k.h.d.b(bVar);
                this.f45465h.d(this.f45462e, this.f45463f, this.f45464g, false);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f45466e;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45466e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f45466e.f45454d != null && this.f45466e.f45454d.u()) {
                this.f45466e.f45454d.q();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f45467a;

        public e(a aVar, m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45467a = mVar;
        }

        @Override // d.a.g0.p.c.b
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f45467a.g(3, "pay failed , click error window");
            }
        }
    }

    public a() {
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

    public static a k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            if (f45450e == null) {
                synchronized (a.class) {
                    if (f45450e == null) {
                        f45450e = new a();
                    }
                }
            }
            return f45450e;
        }
        return (a) invokeV.objValue;
    }

    public final View a(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, activity)) == null) {
            if (activity == null || activity.getWindow() == null) {
                return null;
            }
            return activity.getWindow().getDecorView().findViewById(16908290);
        }
        return (View) invokeL.objValue;
    }

    public final void c(Context context, Bundle bundle, m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, bundle, mVar) == null) {
            View inflate = View.inflate(mVar.getContext(), g.pay_confirm, null);
            d.a.g0.p.c cVar = new d.a.g0.p.c(inflate, -1, -1, true);
            this.f45453c = cVar;
            cVar.y(false);
            this.f45453c.C(false);
            ((TextView) inflate.findViewById(f.bt_pay_meet_problems)).setOnClickListener(new b(this, mVar));
            ((TextView) inflate.findViewById(f.bt_pay_already_finish)).setOnClickListener(new c(this, context, bundle, mVar));
            this.f45453c.E(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
            d.a.g0.k.h.d.b(new d.a.g0.k.h.b("102"));
        }
    }

    public void d(Context context, Bundle bundle, m mVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, bundle, mVar, Boolean.valueOf(z)}) == null) || context == null || bundle == null || mVar == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.f45452b = d.a.g0.k.k.a.a((ViewGroup) a((Activity) context), layoutParams, null, -1L);
        this.f45451a = System.currentTimeMillis();
        d.a.g0.k.b.b.j().g(bundle, new C0630a(this, mVar, z, context, bundle));
    }

    public final void e(Context context, m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, mVar) == null) {
            View inflate = View.inflate(mVar.getContext(), g.default_pop_window, null);
            ((TextView) inflate.findViewById(f.pop_title)).setText(h.pay_failed);
            ((TextView) inflate.findViewById(f.pop_tips)).setText(h.pay_failed_sub_text);
            d.a.g0.p.c cVar = new d.a.g0.p.c(inflate, -1, -1, true);
            this.f45454d = cVar;
            cVar.y(false);
            this.f45454d.C(false);
            this.f45454d.x(new ColorDrawable(0));
            ((TextView) inflate.findViewById(f.pop_button)).setOnClickListener(new d(this));
            this.f45454d.h(new e(this, mVar));
            this.f45454d.E(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
        }
    }

    public final void j(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            d.a.g0.k.k.a.c(this.f45452b);
            try {
                if (this.f45451a == 0) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("rt", str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("msg", str2);
                }
                Long valueOf = Long.valueOf(System.currentTimeMillis() - this.f45451a);
                if (valueOf.longValue() >= 0) {
                    jSONObject.put("du", String.valueOf(valueOf));
                }
                d.a.g0.k.h.b bVar = new d.a.g0.k.h.b(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN);
                bVar.b(jSONObject);
                d.a.g0.k.h.d.b(bVar);
            } catch (JSONException e2) {
                if (d.a.g0.n.d.f45496d) {
                    e2.printStackTrace();
                }
            } finally {
                this.f45451a = 0L;
            }
        }
    }
}
