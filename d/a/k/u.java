package d.a.k;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.k.v0.a;
import d.a.p0.s.q.b2;
/* loaded from: classes7.dex */
public class u extends c implements q, p<b2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public final RelativeLayout f43200i;
    public final LinearLayout j;
    public View k;
    public View l;
    public View m;
    public ImageView n;
    public TextView o;
    public b2 p;
    public boolean q;
    public boolean r;
    public CustomMessageListener s;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ u f43201a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(u uVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43201a = uVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof b2) && ((b2) customResponsedMessage.getData()) == this.f43201a.p) {
                this.f43201a.r();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ u f43202e;

        public b(u uVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43202e = uVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f43202e.n == null || this.f43202e.p == null || this.f43202e.o == null || this.f43202e.p.q2() || !this.f43202e.r) {
                return;
            }
            if (this.f43202e.p.a2() || !d.a.q0.u0.b.e().g()) {
                if (this.f43202e.p.b2() || !d.a.q0.u0.a.h().j()) {
                    d.a.q0.u0.b.e().j(this.f43202e.p);
                    this.f43202e.p.N3(false);
                    d.a.q0.u0.a.h().l(this.f43202e.p);
                    this.f43202e.p.O3(false);
                } else if (d.a.q0.u0.a.h().a(this.f43202e.p)) {
                    this.f43202e.p.O3(true);
                }
            } else if (d.a.q0.u0.b.e().a(this.f43202e.p)) {
                this.f43202e.p.N3(true);
            }
            this.f43202e.r();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921402, this.f43202e.p));
        }
    }

    public u(Context context) {
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
        this.q = false;
        this.r = true;
        this.s = new a(this, 2921402);
        View inflate = LayoutInflater.from(context).inflate(R.layout.multi_del_decor_layout, (ViewGroup) null);
        this.k = inflate;
        this.l = inflate.findViewById(R.id.multi_del_mask_top_view);
        this.j = (LinearLayout) this.k.findViewById(R.id.multi_del_bottom_layout);
        this.l.setAlpha(0.5f);
        View findViewById = this.k.findViewById(R.id.multi_del_mask_bottom_view);
        this.m = findViewById;
        findViewById.setAlpha(0.5f);
        this.n = (ImageView) this.k.findViewById(R.id.manage_select_img);
        this.f43200i = (RelativeLayout) this.k.findViewById(R.id.multi_del_bottom_root);
        this.o = (TextView) this.k.findViewById(R.id.manage_select_txt);
        g(this.k);
        this.k.setFocusable(true);
        this.k.setOnClickListener(new b(this));
        h(-1);
        if (context instanceof BaseActivity) {
            ((BaseActivity) context).registerListener(this.s);
        } else if (context instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) context).registerListener(this.s);
        }
    }

    @Override // d.a.k.c
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // d.a.k.c
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // d.a.k.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i2) == null) {
            if (!this.p.a2() && !this.p.b2()) {
                WebPManager.setPureDrawable(this.n, R.drawable.icon_pure_frs_select_22, R.color.CAM_X0107, null);
            } else {
                WebPManager.setPureDrawable(this.n, R.drawable.icon_pure_frs_chosen_22, R.color.CAM_X0304, null);
            }
            d.a.p0.s.u.c d2 = d.a.p0.s.u.c.d(this.l);
            d2.n(R.string.J_X06);
            d2.m(this.q ? 2 : 1);
            d2.f(R.color.CAM_X0201);
            d.a.p0.s.u.c d3 = d.a.p0.s.u.c.d(this.m);
            d3.n(R.string.J_X06);
            d3.m(2);
            d3.f(R.color.CAM_X0201);
            d.a.p0.s.u.c.d(this.o).y(R.string.F_X01);
            SkinManager.setViewTextColor(this.o, (this.p.a2() || this.p.b2()) ? R.color.CAM_X0302 : R.drawable.selector_comment_and_prise_item_text_color);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.k.p
    /* renamed from: p */
    public void a(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, b2Var) == null) {
            this.p = b2Var;
            this.r = b2Var.getType() != b2.K3 && (b2Var == null || b2Var.H() == null || !b2Var.H().isForumBusinessAccount() || b2Var.isSelf()) && b2Var != null && (!b2Var.n2() || b2Var.isSelf());
            if (!d.a.q0.u0.b.e().g() && !d.a.q0.u0.a.h().j()) {
                this.f43141h.o(new a.C0620a(4, Boolean.TRUE));
                this.k.setVisibility(8);
                return;
            }
            this.k.setVisibility(0);
            this.f43141h.o(new a.C0620a(4, Boolean.FALSE));
            r();
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.q = z;
        }
    }

    public final void r() {
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (b2Var = this.p) == null) {
            return;
        }
        int i2 = 4;
        this.l.setVisibility((b2Var.a2() || this.p.b2() || !this.r) ? 0 : 4);
        this.m.setVisibility((this.p.a2() || this.p.b2()) ? 0 : 0);
        if (this.q) {
            this.f43200i.setVisibility(0);
            if (this.r) {
                this.n.setVisibility(0);
                this.o.setVisibility(0);
                if (!this.p.a2() && !this.p.b2()) {
                    WebPManager.setPureDrawable(this.n, R.drawable.icon_pure_frs_select_22, R.color.CAM_X0107, null);
                } else {
                    WebPManager.setPureDrawable(this.n, R.drawable.icon_pure_frs_chosen_22, R.color.CAM_X0304, null);
                }
                SkinManager.setViewTextColor(this.o, (this.p.a2() || this.p.b2()) ? R.color.CAM_X0304 : R.drawable.selector_comment_and_prise_item_text_color);
                return;
            }
            this.n.setVisibility(8);
            this.o.setVisibility(8);
            return;
        }
        this.f43200i.setVisibility(8);
        this.n.setVisibility(8);
        this.o.setVisibility(8);
    }

    public void s(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
        }
    }

    public void t(int i2, m0 m0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, m0Var) == null) {
            this.j.setWeightSum(i2);
            if (this.j.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.j.getLayoutParams()).setMargins(m0Var.f43177f, m0Var.f43175d, m0Var.f43178g, m0Var.f43176e);
            }
        }
    }
}
