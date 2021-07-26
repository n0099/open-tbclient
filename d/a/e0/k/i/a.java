package d.a.e0.k.i;

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
import d.a.e0.f;
import d.a.e0.g;
import d.a.e0.h;
import d.a.e0.p.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static volatile a f42635e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f42636a;

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.poly.a.l.c f42637b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.e0.p.c f42638c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.e0.p.c f42639d;

    /* renamed from: d.a.e0.k.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0588a extends d.a.e0.k.a.a<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f42640a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f42641b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f42642c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Bundle f42643d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f42644e;

        public C0588a(a aVar, m mVar, boolean z, Context context, Bundle bundle) {
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
            this.f42644e = aVar;
            this.f42640a = mVar;
            this.f42641b = z;
            this.f42642c = context;
            this.f42643d = bundle;
        }

        @Override // d.a.e0.k.a.a
        public void b(Throwable th, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th, str) == null) {
                this.f42644e.j("2", str);
                m mVar = this.f42640a;
                mVar.m("get trade state failed : " + str, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.e0.k.a.a
        /* renamed from: c */
        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
                int optInt = jSONObject.optInt("payStatus", 3);
                this.f42644e.j("1", String.valueOf(optInt));
                if (optInt == 2) {
                    this.f42640a.g(0, d.a.e0.n.b.a(0, jSONObject.optString("payOrderNo"), jSONObject.optString("msg")));
                } else if (this.f42641b) {
                    this.f42644e.c(this.f42642c, this.f42643d, this.f42640a);
                } else {
                    this.f42644e.e(this.f42642c, this.f42640a);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f42645e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f42646f;

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
            this.f42646f = aVar;
            this.f42645e = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f42646f.f42638c.q();
                d.a.e0.k.h.b bVar = new d.a.e0.k.h.b("103");
                bVar.c("1");
                d.a.e0.k.h.d.b(bVar);
                this.f42645e.g(3, "pay failed , click choose window");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f42647e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bundle f42648f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ m f42649g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f42650h;

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
            this.f42650h = aVar;
            this.f42647e = context;
            this.f42648f = bundle;
            this.f42649g = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f42650h.f42638c.q();
                d.a.e0.k.h.b bVar = new d.a.e0.k.h.b("103");
                bVar.c("2");
                d.a.e0.k.h.d.b(bVar);
                this.f42650h.d(this.f42647e, this.f42648f, this.f42649g, false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f42651e;

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
            this.f42651e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f42651e.f42639d != null && this.f42651e.f42639d.u()) {
                this.f42651e.f42639d.q();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f42652a;

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
            this.f42652a = mVar;
        }

        @Override // d.a.e0.p.c.b
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f42652a.g(3, "pay failed , click error window");
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
            if (f42635e == null) {
                synchronized (a.class) {
                    if (f42635e == null) {
                        f42635e = new a();
                    }
                }
            }
            return f42635e;
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
            d.a.e0.p.c cVar = new d.a.e0.p.c(inflate, -1, -1, true);
            this.f42638c = cVar;
            cVar.y(false);
            this.f42638c.C(false);
            ((TextView) inflate.findViewById(f.bt_pay_meet_problems)).setOnClickListener(new b(this, mVar));
            ((TextView) inflate.findViewById(f.bt_pay_already_finish)).setOnClickListener(new c(this, context, bundle, mVar));
            this.f42638c.E(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
            d.a.e0.k.h.d.b(new d.a.e0.k.h.b("102"));
        }
    }

    public void d(Context context, Bundle bundle, m mVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, bundle, mVar, Boolean.valueOf(z)}) == null) || context == null || bundle == null || mVar == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.f42637b = d.a.e0.k.k.a.a((ViewGroup) a((Activity) context), layoutParams, null, -1L);
        this.f42636a = System.currentTimeMillis();
        d.a.e0.k.b.b.j().g(bundle, new C0588a(this, mVar, z, context, bundle));
    }

    public final void e(Context context, m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, mVar) == null) {
            View inflate = View.inflate(mVar.getContext(), g.default_pop_window, null);
            ((TextView) inflate.findViewById(f.pop_title)).setText(h.pay_failed);
            ((TextView) inflate.findViewById(f.pop_tips)).setText(h.pay_failed_sub_text);
            d.a.e0.p.c cVar = new d.a.e0.p.c(inflate, -1, -1, true);
            this.f42639d = cVar;
            cVar.y(false);
            this.f42639d.C(false);
            this.f42639d.x(new ColorDrawable(0));
            ((TextView) inflate.findViewById(f.pop_button)).setOnClickListener(new d(this));
            this.f42639d.h(new e(this, mVar));
            this.f42639d.E(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
        }
    }

    public final void j(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            d.a.e0.k.k.a.c(this.f42637b);
            try {
                if (this.f42636a == 0) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("rt", str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("msg", str2);
                }
                Long valueOf = Long.valueOf(System.currentTimeMillis() - this.f42636a);
                if (valueOf.longValue() >= 0) {
                    jSONObject.put("du", String.valueOf(valueOf));
                }
                d.a.e0.k.h.b bVar = new d.a.e0.k.h.b(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN);
                bVar.b(jSONObject);
                d.a.e0.k.h.d.b(bVar);
            } catch (JSONException e2) {
                if (d.a.e0.n.d.f42681d) {
                    e2.printStackTrace();
                }
            } finally {
                this.f42636a = 0L;
            }
        }
    }
}
