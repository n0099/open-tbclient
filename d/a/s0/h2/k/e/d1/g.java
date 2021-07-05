package d.a.s0.h2.k.e.d1;

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
import d.a.r0.r.q.b2;
import d.a.r0.r.q.w0;
import d.a.s0.a0.b0;
/* loaded from: classes9.dex */
public class g extends d.a.s0.h2.k.e.d1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f60474f;

    /* renamed from: g  reason: collision with root package name */
    public g0 f60475g;

    /* renamed from: h  reason: collision with root package name */
    public ItemCardView f60476h;

    /* renamed from: i  reason: collision with root package name */
    public b2 f60477i;
    public d.a.r0.r.q.a j;
    public s0 k;

    /* loaded from: classes9.dex */
    public class a extends d.a.r0.r.q.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f60478e;

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
            this.f60478e = gVar;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f60478e.f60477i : (b2) invokeV.objValue;
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

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f60479e;

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
            this.f60479e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g gVar;
            a.InterfaceC0643a interfaceC0643a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (interfaceC0643a = (gVar = this.f60479e).f60446c) == null) {
                return;
            }
            interfaceC0643a.a(gVar.j);
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

    @Override // d.a.s0.h2.k.e.d1.a
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f60474f == null) {
                LinearLayout linearLayout = new LinearLayout(this.f60444a.getPageActivity());
                this.f60474f = linearLayout;
                linearLayout.setClipChildren(false);
                this.f60474f.setClipToPadding(false);
                SkinManager.setBackgroundColor(this.f60474f, R.color.CAM_X0206);
                this.f60474f.setOrientation(1);
                this.f60474f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            }
            this.f60474f.removeAllViews();
            if (this.f60475g == null) {
                g0 g0Var = new g0(this.f60444a);
                this.f60475g = g0Var;
                g0Var.n(Boolean.TRUE);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.f60444a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
            layoutParams.leftMargin = this.f60444a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            layoutParams.rightMargin = this.f60444a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            this.f60474f.addView(this.f60475g.g(), layoutParams);
            if (this.k == null) {
                s0 s0Var = new s0(this.f60444a.getPageActivity());
                this.k = s0Var;
                s0Var.v("pb");
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.topMargin = this.f60444a.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
            layoutParams2.bottomMargin = this.f60444a.getResources().getDimensionPixelOffset(R.dimen.tbds_30);
            this.f60474f.addView(this.k.g(), layoutParams2);
            if (this.f60476h == null) {
                this.f60476h = new ItemCardView(this.f60444a.getPageActivity());
            }
            this.f60476h.setBackGroundColor(R.color.CAM_X0205);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams3.topMargin = this.f60444a.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
            layoutParams3.leftMargin = this.f60444a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            layoutParams3.rightMargin = this.f60444a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            layoutParams3.bottomMargin = this.f60444a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
            this.f60474f.addView(this.f60476h, layoutParams3);
            return this.f60474f;
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
        SkinManager.setBackgroundColor(this.f60474f, R.color.CAM_X0206);
        g0 g0Var = this.f60475g;
        if (g0Var != null) {
            g0Var.onChangeSkinType(tbPageContext, i2);
        }
        ItemCardView itemCardView = this.f60476h;
        if (itemCardView != null) {
            itemCardView.b();
        }
        s0 s0Var = this.k;
        if (s0Var != null) {
            s0Var.onChangeSkinType(tbPageContext, i2);
        }
    }

    @Override // d.a.s0.h2.k.e.d1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, originalThreadInfo) == null) {
            this.f60447d = originalThreadInfo;
            this.f60477i = originalThreadInfo == null ? null : originalThreadInfo.a();
            a aVar = new a(this);
            this.j = aVar;
            s0 s0Var = this.k;
            if (s0Var != null) {
                s0Var.a(aVar);
            }
            ItemCardView itemCardView = this.f60476h;
            if (itemCardView != null && originalThreadInfo != null) {
                itemCardView.setData(originalThreadInfo.z, 17);
            }
            g0 g0Var = this.f60475g;
            if (g0Var != null) {
                g0Var.a(this.j);
            }
        }
    }

    @Override // d.a.s0.h2.k.e.d1.a
    public void d(a.InterfaceC0643a interfaceC0643a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC0643a) == null) {
            super.d(interfaceC0643a);
            s0 s0Var = this.k;
            if (s0Var != null) {
                s0Var.w(interfaceC0643a);
            }
            g0 g0Var = this.f60475g;
            if (g0Var != null) {
                g0Var.w(interfaceC0643a);
            }
            LinearLayout linearLayout = this.f60474f;
            if (linearLayout != null) {
                linearLayout.setOnClickListener(new b(this));
            }
        }
    }

    @Override // d.a.s0.h2.k.e.d1.a
    public void e(b0 b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, b0Var) == null) {
            super.e(b0Var);
            s0 s0Var = this.k;
            if (s0Var != null) {
                s0Var.l(this.f60445b);
            }
        }
    }
}
