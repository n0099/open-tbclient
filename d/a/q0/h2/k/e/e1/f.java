package d.a.q0.h2.k.e.e1;

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
import d.a.k.a;
import d.a.k.o;
import d.a.p0.s.q.b2;
import d.a.p0.s.q.w0;
import d.a.q0.a0.b0;
/* loaded from: classes8.dex */
public class f extends d.a.q0.h2.k.e.e1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f57813f;

    /* renamed from: g  reason: collision with root package name */
    public ItemCardView f57814g;

    /* renamed from: h  reason: collision with root package name */
    public b2 f57815h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.p0.s.q.a f57816i;
    public o j;

    /* loaded from: classes8.dex */
    public class a extends d.a.p0.s.q.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f57817e;

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
            this.f57817e = fVar;
        }

        @Override // d.a.p0.s.q.a
        public w0 getNegFeedBackData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return null;
            }
            return (w0) invokeV.objValue;
        }

        @Override // d.a.p0.s.q.a
        public b2 getThreadData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f57817e.f57815h : (b2) invokeV.objValue;
        }

        @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.d.k.e.n
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
        public final /* synthetic */ f f57818e;

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
            this.f57818e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f fVar;
            a.InterfaceC0618a interfaceC0618a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (interfaceC0618a = (fVar = this.f57818e).f57791c) == null) {
                return;
            }
            interfaceC0618a.a(fVar.f57816i);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(TbPageContext tbPageContext) {
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

    @Override // d.a.q0.h2.k.e.e1.a
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f57813f == null) {
                LinearLayout linearLayout = new LinearLayout(this.f57789a.getPageActivity());
                this.f57813f = linearLayout;
                linearLayout.setClipChildren(false);
                this.f57813f.setClipToPadding(false);
                SkinManager.setBackgroundColor(this.f57813f, R.color.CAM_X0206);
                this.f57813f.setOrientation(1);
                this.f57813f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            }
            this.f57813f.removeAllViews();
            if (this.j == null) {
                o oVar = new o(this.f57789a.getPageActivity());
                this.j = oVar;
                oVar.n(Boolean.TRUE);
                this.j.x("pb");
                this.j.z(0);
                this.j.F(this.f57789a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), this.f57789a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005), this.f57789a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), 0);
                this.j.G(false);
                this.j.E(true);
            }
            this.f57813f.addView(this.j.g());
            if (this.f57814g == null) {
                ItemCardView itemCardView = new ItemCardView(this.f57789a.getPageActivity());
                this.f57814g = itemCardView;
                itemCardView.setIsShowRightBtn(true);
            }
            this.f57814g.setBackGroundColor(R.color.CAM_X0205);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.f57789a.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
            layoutParams.leftMargin = this.f57789a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            layoutParams.rightMargin = this.f57789a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            layoutParams.bottomMargin = this.f57789a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
            this.f57813f.addView(this.f57814g, layoutParams);
            return this.f57813f;
        }
        return (View) invokeV.objValue;
    }

    @Override // d.a.q0.h2.k.e.e1.a
    public void b(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) || this.f57793e == i2) {
            return;
        }
        this.f57793e = i2;
        SkinManager.setBackgroundColor(this.f57813f, R.color.CAM_X0206);
        o oVar = this.j;
        if (oVar != null) {
            oVar.onChangeSkinType(tbPageContext, i2);
        }
        ItemCardView itemCardView = this.f57814g;
        if (itemCardView != null) {
            itemCardView.x();
        }
    }

    @Override // d.a.q0.h2.k.e.e1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, originalThreadInfo) == null) {
            this.f57792d = originalThreadInfo;
            this.f57815h = originalThreadInfo == null ? null : originalThreadInfo.a();
            this.f57816i = new a(this);
            ItemCardView itemCardView = this.f57814g;
            if (itemCardView != null && originalThreadInfo != null) {
                itemCardView.setData(originalThreadInfo.z, 17, originalThreadInfo.f12282f);
            }
            o oVar = this.j;
            if (oVar != null) {
                oVar.a(this.f57816i);
            }
        }
    }

    @Override // d.a.q0.h2.k.e.e1.a
    public void d(a.InterfaceC0618a interfaceC0618a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC0618a) == null) {
            super.d(interfaceC0618a);
            o oVar = this.j;
            if (oVar != null) {
                oVar.A(interfaceC0618a);
            }
            LinearLayout linearLayout = this.f57813f;
            if (linearLayout != null) {
                linearLayout.setOnClickListener(new b(this));
            }
        }
    }

    @Override // d.a.q0.h2.k.e.e1.a
    public void e(b0 b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, b0Var) == null) {
            super.e(b0Var);
            o oVar = this.j;
            if (oVar != null) {
                oVar.l(this.f57790b);
            }
        }
    }
}
