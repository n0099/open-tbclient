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
import d.a.k.g0;
import d.a.p0.s.q.b2;
import d.a.p0.s.q.w0;
/* loaded from: classes8.dex */
public class e extends d.a.q0.h2.k.e.e1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f57807f;

    /* renamed from: g  reason: collision with root package name */
    public g0 f57808g;

    /* renamed from: h  reason: collision with root package name */
    public ItemCardView f57809h;

    /* renamed from: i  reason: collision with root package name */
    public b2 f57810i;
    public d.a.p0.s.q.a j;

    /* loaded from: classes8.dex */
    public class a extends d.a.p0.s.q.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f57811e;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57811e = eVar;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f57811e.f57810i : (b2) invokeV.objValue;
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
        public final /* synthetic */ e f57812e;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57812e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e eVar;
            a.InterfaceC0618a interfaceC0618a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (interfaceC0618a = (eVar = this.f57812e).f57791c) == null) {
                return;
            }
            interfaceC0618a.a(eVar.j);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(TbPageContext tbPageContext) {
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
            if (this.f57807f == null) {
                LinearLayout linearLayout = new LinearLayout(this.f57789a.getPageActivity());
                this.f57807f = linearLayout;
                linearLayout.setClipChildren(false);
                this.f57807f.setClipToPadding(false);
                SkinManager.setBackgroundColor(this.f57807f, R.color.CAM_X0206);
                this.f57807f.setOrientation(1);
                this.f57807f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            }
            this.f57807f.removeAllViews();
            if (this.f57808g == null) {
                g0 g0Var = new g0(this.f57789a);
                this.f57808g = g0Var;
                g0Var.n(Boolean.TRUE);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.f57789a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
            layoutParams.leftMargin = this.f57789a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            layoutParams.rightMargin = this.f57789a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            this.f57807f.addView(this.f57808g.g(), layoutParams);
            if (this.f57809h == null) {
                this.f57809h = new ItemCardView(this.f57789a.getPageActivity());
            }
            this.f57809h.setBackGroundColor(R.color.CAM_X0205);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.topMargin = this.f57789a.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
            layoutParams2.leftMargin = this.f57789a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            layoutParams2.rightMargin = this.f57789a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            layoutParams2.bottomMargin = this.f57789a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
            this.f57807f.addView(this.f57809h, layoutParams2);
            return this.f57807f;
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
        SkinManager.setBackgroundColor(this.f57807f, R.color.CAM_X0206);
        g0 g0Var = this.f57808g;
        if (g0Var != null) {
            g0Var.onChangeSkinType(tbPageContext, i2);
        }
        ItemCardView itemCardView = this.f57809h;
        if (itemCardView != null) {
            itemCardView.x();
        }
    }

    @Override // d.a.q0.h2.k.e.e1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, originalThreadInfo) == null) {
            this.f57792d = originalThreadInfo;
            this.f57810i = originalThreadInfo == null ? null : originalThreadInfo.a();
            this.j = new a(this);
            ItemCardView itemCardView = this.f57809h;
            if (itemCardView != null && originalThreadInfo != null) {
                itemCardView.setData(originalThreadInfo.z, 17, originalThreadInfo.f12282f);
            }
            g0 g0Var = this.f57808g;
            if (g0Var != null) {
                g0Var.a(this.j);
            }
        }
    }

    @Override // d.a.q0.h2.k.e.e1.a
    public void d(a.InterfaceC0618a interfaceC0618a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC0618a) == null) {
            super.d(interfaceC0618a);
            g0 g0Var = this.f57808g;
            if (g0Var != null) {
                g0Var.w(interfaceC0618a);
            }
            LinearLayout linearLayout = this.f57807f;
            if (linearLayout != null) {
                linearLayout.setOnClickListener(new b(this));
            }
        }
    }
}
