package d.a.s0.h2.k.e.d1;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.j.a;
import d.a.j.g0;
import d.a.j.o0;
import d.a.r0.r.q.b2;
import d.a.r0.r.q.w0;
import d.a.s0.a0.b0;
/* loaded from: classes9.dex */
public class b extends d.a.s0.h2.k.e.d1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f60449f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.r0.r.q.a f60450g;

    /* renamed from: h  reason: collision with root package name */
    public g0 f60451h;

    /* renamed from: i  reason: collision with root package name */
    public o0 f60452i;
    public b2 j;

    /* loaded from: classes9.dex */
    public class a extends d.a.r0.r.q.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f60453e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60453e = bVar;
        }

        @Override // d.a.r0.r.q.a
        public w0 getNegFeedBackData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return null;
            }
            return (w0) invokeV.objValue;
        }

        @Override // d.a.r0.r.q.a
        public b2 getThreadData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f60453e.j : (b2) invokeV.objValue;
        }

        @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
        public BdUniqueId getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (BdUniqueId) invokeV.objValue;
        }
    }

    /* renamed from: d.a.s0.h2.k.e.d1.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class View$OnClickListenerC1463b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f60454e;

        public View$OnClickListenerC1463b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60454e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar;
            a.InterfaceC0643a interfaceC0643a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (interfaceC0643a = (bVar = this.f60454e).f60446c) == null) {
                return;
            }
            interfaceC0643a.a(bVar.f60450g);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext tbPageContext, int i2) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // d.a.s0.h2.k.e.d1.a
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f60449f == null) {
                LinearLayout linearLayout = new LinearLayout(this.f60444a.getPageActivity());
                this.f60449f = linearLayout;
                SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0206);
                this.f60449f.setOrientation(1);
                this.f60449f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            }
            this.f60449f.removeAllViews();
            if (this.f60451h == null) {
                g0 g0Var = new g0(this.f60444a);
                this.f60451h = g0Var;
                g0Var.n(Boolean.TRUE);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.f60444a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
            layoutParams.leftMargin = this.f60444a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            layoutParams.rightMargin = this.f60444a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            this.f60449f.addView(this.f60451h.g(), layoutParams);
            if (this.f60452i == null) {
                this.f60452i = new o0(this.f60444a.getPageActivity());
            }
            this.f60449f.addView(this.f60452i.g());
            return this.f60449f;
        }
        return (View) invokeV.objValue;
    }

    @Override // d.a.s0.h2.k.e.d1.a
    public void b(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) || this.f60448e == i2) {
            return;
        }
        this.f60448e = i2;
        SkinManager.setBackgroundColor(this.f60449f, R.color.CAM_X0206);
        g0 g0Var = this.f60451h;
        if (g0Var != null) {
            g0Var.onChangeSkinType(tbPageContext, i2);
        }
        o0 o0Var = this.f60452i;
        if (o0Var != null) {
            o0Var.onChangeSkinType(tbPageContext, i2);
        }
    }

    @Override // d.a.s0.h2.k.e.d1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, originalThreadInfo) == null) {
            this.f60447d = originalThreadInfo;
            this.j = originalThreadInfo == null ? null : originalThreadInfo.a();
            a aVar = new a(this);
            this.f60450g = aVar;
            o0 o0Var = this.f60452i;
            if (o0Var != null) {
                o0Var.a(aVar);
            }
            g0 g0Var = this.f60451h;
            if (g0Var != null) {
                g0Var.a(this.f60450g);
            }
        }
    }

    @Override // d.a.s0.h2.k.e.d1.a
    public void d(a.InterfaceC0643a interfaceC0643a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC0643a) == null) {
            super.d(interfaceC0643a);
            o0 o0Var = this.f60452i;
            if (o0Var != null) {
                o0Var.u(interfaceC0643a);
            }
            g0 g0Var = this.f60451h;
            if (g0Var != null) {
                g0Var.w(interfaceC0643a);
            }
            LinearLayout linearLayout = this.f60449f;
            if (linearLayout != null) {
                linearLayout.setOnClickListener(new View$OnClickListenerC1463b(this));
            }
        }
    }

    @Override // d.a.s0.h2.k.e.d1.a
    public void e(b0 b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, b0Var) == null) {
            super.e(b0Var);
            o0 o0Var = this.f60452i;
            if (o0Var != null) {
                o0Var.l(this.f60445b);
            }
        }
    }
}
