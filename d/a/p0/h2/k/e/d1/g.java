package d.a.p0.h2.k.e.d1;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.j.a;
import d.a.j.g0;
import d.a.j.s0;
import d.a.o0.r.q.b2;
import d.a.o0.r.q.w0;
import d.a.p0.a0.b0;
/* loaded from: classes8.dex */
public class g extends d.a.p0.h2.k.e.d1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f57230f;

    /* renamed from: g  reason: collision with root package name */
    public g0 f57231g;

    /* renamed from: h  reason: collision with root package name */
    public ItemCardView f57232h;

    /* renamed from: i  reason: collision with root package name */
    public b2 f57233i;
    public d.a.o0.r.q.a j;
    public s0 k;

    /* loaded from: classes8.dex */
    public class a extends d.a.o0.r.q.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f57234e;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57234e = gVar;
        }

        @Override // d.a.o0.r.q.a
        public w0 getNegFeedBackData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return null;
            }
            return (w0) invokeV.objValue;
        }

        @Override // d.a.o0.r.q.a
        public b2 getThreadData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f57234e.f57233i : (b2) invokeV.objValue;
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

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f57235e;

        public b(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57235e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g gVar;
            a.InterfaceC0609a interfaceC0609a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (interfaceC0609a = (gVar = this.f57235e).f57202c) == null) {
                return;
            }
            interfaceC0609a.a(gVar.j);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // d.a.p0.h2.k.e.d1.a
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f57230f == null) {
                LinearLayout linearLayout = new LinearLayout(this.f57200a.getPageActivity());
                this.f57230f = linearLayout;
                linearLayout.setClipChildren(false);
                this.f57230f.setClipToPadding(false);
                SkinManager.setBackgroundColor(this.f57230f, R.color.CAM_X0206);
                this.f57230f.setOrientation(1);
                this.f57230f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            }
            this.f57230f.removeAllViews();
            if (this.f57231g == null) {
                g0 g0Var = new g0(this.f57200a);
                this.f57231g = g0Var;
                g0Var.n(Boolean.TRUE);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.f57200a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
            layoutParams.leftMargin = this.f57200a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            layoutParams.rightMargin = this.f57200a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            this.f57230f.addView(this.f57231g.g(), layoutParams);
            if (this.k == null) {
                s0 s0Var = new s0(this.f57200a.getPageActivity());
                this.k = s0Var;
                s0Var.v("pb");
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.topMargin = this.f57200a.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
            layoutParams2.bottomMargin = this.f57200a.getResources().getDimensionPixelOffset(R.dimen.tbds_30);
            this.f57230f.addView(this.k.g(), layoutParams2);
            if (this.f57232h == null) {
                this.f57232h = new ItemCardView(this.f57200a.getPageActivity());
            }
            this.f57232h.setBackGroundColor(R.color.CAM_X0205);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams3.topMargin = this.f57200a.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
            layoutParams3.leftMargin = this.f57200a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            layoutParams3.rightMargin = this.f57200a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            layoutParams3.bottomMargin = this.f57200a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
            this.f57230f.addView(this.f57232h, layoutParams3);
            return this.f57230f;
        }
        return (View) invokeV.objValue;
    }

    @Override // d.a.p0.h2.k.e.d1.a
    public void b(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) || this.f57204e == i2) {
            return;
        }
        this.f57204e = i2;
        SkinManager.setBackgroundColor(this.f57230f, R.color.CAM_X0206);
        g0 g0Var = this.f57231g;
        if (g0Var != null) {
            g0Var.onChangeSkinType(tbPageContext, i2);
        }
        ItemCardView itemCardView = this.f57232h;
        if (itemCardView != null) {
            itemCardView.b();
        }
        s0 s0Var = this.k;
        if (s0Var != null) {
            s0Var.onChangeSkinType(tbPageContext, i2);
        }
    }

    @Override // d.a.p0.h2.k.e.d1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, originalThreadInfo) == null) {
            this.f57203d = originalThreadInfo;
            this.f57233i = originalThreadInfo == null ? null : originalThreadInfo.a();
            a aVar = new a(this);
            this.j = aVar;
            s0 s0Var = this.k;
            if (s0Var != null) {
                s0Var.a(aVar);
            }
            ItemCardView itemCardView = this.f57232h;
            if (itemCardView != null && originalThreadInfo != null) {
                itemCardView.setData(originalThreadInfo.z, 17);
            }
            g0 g0Var = this.f57231g;
            if (g0Var != null) {
                g0Var.a(this.j);
            }
        }
    }

    @Override // d.a.p0.h2.k.e.d1.a
    public void d(a.InterfaceC0609a interfaceC0609a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC0609a) == null) {
            super.d(interfaceC0609a);
            s0 s0Var = this.k;
            if (s0Var != null) {
                s0Var.w(interfaceC0609a);
            }
            g0 g0Var = this.f57231g;
            if (g0Var != null) {
                g0Var.w(interfaceC0609a);
            }
            LinearLayout linearLayout = this.f57230f;
            if (linearLayout != null) {
                linearLayout.setOnClickListener(new b(this));
            }
        }
    }

    @Override // d.a.p0.h2.k.e.d1.a
    public void e(b0 b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, b0Var) == null) {
            super.e(b0Var);
            s0 s0Var = this.k;
            if (s0Var != null) {
                s0Var.l(this.f57201b);
            }
        }
    }
}
