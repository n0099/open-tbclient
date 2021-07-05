package d.a.s0.u0.m2;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbSingleton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.u0.m2.b;
/* loaded from: classes9.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f66474a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f66475b;

    /* renamed from: c  reason: collision with root package name */
    public g f66476c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.s0.u0.m2.b f66477d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.r0.m0.o.a f66478e;

    /* renamed from: f  reason: collision with root package name */
    public b.a f66479f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f66480g;

    /* loaded from: classes9.dex */
    public class a implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f66481a;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66481a = fVar;
        }

        @Override // d.a.s0.u0.m2.b.a
        public void onStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 == 1) {
                    if (!TbSingleton.getInstance().isEnableBenchmark() || TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                        return;
                    }
                    if (this.f66481a.f66478e == null) {
                        this.f66481a.f66478e = new d.a.r0.m0.o.a("anim_switch_trans_frs");
                    }
                    this.f66481a.f66478e.b();
                } else if (i2 != 2) {
                    if (i2 == 0) {
                        this.f66481a.j();
                    }
                } else {
                    this.f66481a.k();
                    if (this.f66481a.f66478e == null || !TbSingleton.getInstance().isEnableBenchmark() || TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                        return;
                    }
                    this.f66481a.f66478e.c();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f66482e;

        public b(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66482e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f66482e.f();
            }
        }
    }

    public f(Context context, ViewGroup viewGroup, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, viewGroup, intent};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66479f = new a(this);
        this.f66480g = new b(this);
        this.f66474a = context;
        this.f66475b = viewGroup;
        g gVar = new g(context);
        this.f66476c = gVar;
        d.a.s0.u0.m2.b a2 = c.a(gVar, intent);
        this.f66477d = a2;
        a2.b(this.f66479f);
    }

    public static boolean i(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, intent)) == null) ? (intent == null || intent.getIntExtra("transition_type", 0) == 0) ? false : true : invokeL.booleanValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            d.a.c.e.m.e.a().removeCallbacks(this.f66480g);
            if (this.f66477d.a() == 1) {
                d.a.c.e.m.e.a().postDelayed(this.f66480g, 10L);
                return;
            }
            k();
            this.f66477d.c();
        }
    }

    public final void g() {
        View findViewById;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ViewGroup viewGroup = this.f66475b;
            if (viewGroup != null && (viewGroup.getChildAt(0) instanceof SwipeBackLayout)) {
                this.f66475b.getChildAt(0).setVisibility(8);
            }
            ViewGroup viewGroup2 = this.f66475b;
            if (viewGroup2 == null || (findViewById = viewGroup2.findViewById(16908290)) == null) {
                return;
            }
            findViewById.setVisibility(8);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f66475b == null) {
            return;
        }
        f();
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ViewParent parent = this.f66476c.f66483a.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f66476c.f66483a);
            }
            d.a.c.e.m.e.a().removeCallbacks(this.f66480g);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ViewGroup viewGroup = this.f66475b;
            if (viewGroup != null && (viewGroup.getChildAt(0) instanceof SwipeBackLayout)) {
                this.f66475b.getChildAt(0).setVisibility(0);
            }
            ViewGroup viewGroup2 = this.f66475b;
            if (viewGroup2 == null || viewGroup2.findViewById(16908290) == null) {
                return;
            }
            this.f66475b.findViewById(16908290).setVisibility(0);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f66475b == null) {
            return;
        }
        j();
        this.f66475b.addView(this.f66476c.f66483a);
        g();
        this.f66477d.d();
    }
}
