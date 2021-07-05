package d.a.s0.u0.v1;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gamesubpb.view.BlankView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.s0.i0.a;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final int f67104g;

    /* renamed from: h  reason: collision with root package name */
    public static final int f67105h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity f67106a;

    /* renamed from: b  reason: collision with root package name */
    public BlankView f67107b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.s0.i0.b f67108c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f67109d;

    /* renamed from: e  reason: collision with root package name */
    public e f67110e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f67111f;

    /* loaded from: classes9.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f67112e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67112e = cVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                this.f67112e.f67108c.c(motionEvent);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f67113a;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67113a = cVar;
        }

        @Override // d.a.s0.i0.a.b
        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                this.f67113a.i();
            }
        }

        @Override // d.a.s0.i0.a.b
        public void b(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) || this.f67113a.f67110e == null || !this.f67113a.f67110e.c() || Math.abs(i3) <= c.f67105h) {
                return;
            }
            if (this.f67113a.f67107b != null) {
                this.f67113a.f67107b.setBackgroundResource(R.color.transparent);
            }
            this.f67113a.f67106a.finish();
        }

        @Override // d.a.s0.i0.a.b
        public void c(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            }
        }

        @Override // d.a.s0.i0.a.b
        public void d(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            }
        }
    }

    /* renamed from: d.a.s0.u0.v1.c$c  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class View$OnClickListenerC1773c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f67114e;

        public View$OnClickListenerC1773c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67114e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f67114e.f67106a.finish();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements BlankView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f67115a;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67115a = cVar;
        }

        @Override // com.baidu.tieba.frs.gamesubpb.view.BlankView.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f67115a.f67107b != null) {
                    this.f67115a.f67107b.setVisibility(8);
                }
                this.f67115a.f67111f = false;
                if (this.f67115a.f67110e != null) {
                    this.f67115a.f67110e.b();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface e {
        void a();

        void b();

        boolean c();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-152152475, "Ld/a/s0/u0/v1/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-152152475, "Ld/a/s0/u0/v1/c;");
                return;
            }
        }
        f67104g = l.g(TbadkCoreApplication.getInst(), R.dimen.ds160);
        f67105h = l.g(TbadkCoreApplication.getInst(), R.dimen.ds20);
    }

    public c(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity, view, navigationBar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f67111f = false;
        this.f67106a = baseActivity;
        this.f67108c = new d.a.s0.i0.b(baseActivity.getPageContext().getPageActivity());
        this.f67109d = navigationBar;
        navigationBar.setStatusBarVisibility(8);
        view.setOnTouchListener(new a(this));
        this.f67108c.d(new b(this));
    }

    public void g() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f67111f || (viewGroup = (ViewGroup) this.f67106a.findViewById(16908290)) == null || !(viewGroup.getParent() instanceof LinearLayout)) {
            return;
        }
        BlankView blankView = new BlankView(this.f67106a.getPageContext().getPageActivity());
        this.f67107b = blankView;
        blankView.setBackgroundResource(R.color.transparent);
        ((LinearLayout) viewGroup.getParent()).addView(this.f67107b, 0, new LinearLayout.LayoutParams(-1, f67104g));
        this.f67107b.setVisibility(0);
        this.f67107b.setOnClickListener(new View$OnClickListenerC1773c(this));
        this.f67107b.setScrollCallBack(new d(this));
        this.f67106a.setExcludeHeight(f67104g);
        this.f67111f = true;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f67111f : invokeV.booleanValue;
    }

    public void i() {
        BlankView blankView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f67111f && this.f67109d != null && (blankView = this.f67107b) != null && blankView.getVisibility() == 0) {
            this.f67109d.setStatusBarVisibility(0);
            this.f67106a.setExcludeHeight(0);
            e eVar = this.f67110e;
            if (eVar != null) {
                eVar.a();
            }
            this.f67107b.a();
        }
    }

    public void j(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, eVar) == null) {
            this.f67110e = eVar;
        }
    }

    public void k(int i2) {
        BlankView blankView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || (blankView = this.f67107b) == null) {
            return;
        }
        SkinManager.setBackgroundResource(blankView, i2);
    }
}
