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
import d.a.r0.r.q.b2;
import d.a.r0.r.q.w0;
/* loaded from: classes9.dex */
public class e extends d.a.s0.h2.k.e.d1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f60462f;

    /* renamed from: g  reason: collision with root package name */
    public g0 f60463g;

    /* renamed from: h  reason: collision with root package name */
    public ItemCardView f60464h;

    /* renamed from: i  reason: collision with root package name */
    public b2 f60465i;
    public d.a.r0.r.q.a j;

    /* loaded from: classes9.dex */
    public class a extends d.a.r0.r.q.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f60466e;

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
            this.f60466e = eVar;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f60466e.f60465i : (b2) invokeV.objValue;
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
        public final /* synthetic */ e f60467e;

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
            this.f60467e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e eVar;
            a.InterfaceC0643a interfaceC0643a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (interfaceC0643a = (eVar = this.f60467e).f60446c) == null) {
                return;
            }
            interfaceC0643a.a(eVar.j);
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

    @Override // d.a.s0.h2.k.e.d1.a
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f60462f == null) {
                LinearLayout linearLayout = new LinearLayout(this.f60444a.getPageActivity());
                this.f60462f = linearLayout;
                linearLayout.setClipChildren(false);
                this.f60462f.setClipToPadding(false);
                SkinManager.setBackgroundColor(this.f60462f, R.color.CAM_X0206);
                this.f60462f.setOrientation(1);
                this.f60462f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            }
            this.f60462f.removeAllViews();
            if (this.f60463g == null) {
                g0 g0Var = new g0(this.f60444a);
                this.f60463g = g0Var;
                g0Var.n(Boolean.TRUE);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.f60444a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
            layoutParams.leftMargin = this.f60444a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            layoutParams.rightMargin = this.f60444a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            this.f60462f.addView(this.f60463g.g(), layoutParams);
            if (this.f60464h == null) {
                this.f60464h = new ItemCardView(this.f60444a.getPageActivity());
            }
            this.f60464h.setBackGroundColor(R.color.CAM_X0205);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.topMargin = this.f60444a.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
            layoutParams2.leftMargin = this.f60444a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            layoutParams2.rightMargin = this.f60444a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            layoutParams2.bottomMargin = this.f60444a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
            this.f60462f.addView(this.f60464h, layoutParams2);
            return this.f60462f;
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
        SkinManager.setBackgroundColor(this.f60462f, R.color.CAM_X0206);
        g0 g0Var = this.f60463g;
        if (g0Var != null) {
            g0Var.onChangeSkinType(tbPageContext, i2);
        }
        ItemCardView itemCardView = this.f60464h;
        if (itemCardView != null) {
            itemCardView.b();
        }
    }

    @Override // d.a.s0.h2.k.e.d1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, originalThreadInfo) == null) {
            this.f60447d = originalThreadInfo;
            this.f60465i = originalThreadInfo == null ? null : originalThreadInfo.a();
            this.j = new a(this);
            ItemCardView itemCardView = this.f60464h;
            if (itemCardView != null && originalThreadInfo != null) {
                itemCardView.setData(originalThreadInfo.z, 17);
            }
            g0 g0Var = this.f60463g;
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
            g0 g0Var = this.f60463g;
            if (g0Var != null) {
                g0Var.w(interfaceC0643a);
            }
            LinearLayout linearLayout = this.f60462f;
            if (linearLayout != null) {
                linearLayout.setOnClickListener(new b(this));
            }
        }
    }
}
