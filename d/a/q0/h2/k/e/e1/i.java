package d.a.q0.h2.k.e.e1;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PollData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.k.a;
import d.a.k.g0;
import d.a.k.s0;
import d.a.p0.s.q.b2;
import d.a.p0.s.q.w0;
import d.a.q0.a0.b0;
/* loaded from: classes8.dex */
public class i extends d.a.q0.h2.k.e.e1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f57831f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.p0.s.q.a f57832g;

    /* renamed from: h  reason: collision with root package name */
    public g0 f57833h;

    /* renamed from: i  reason: collision with root package name */
    public s0 f57834i;
    public b2 j;
    public VoteView k;

    /* loaded from: classes8.dex */
    public class a extends d.a.p0.s.q.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f57835e;

        public a(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57835e = iVar;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f57835e.j : (b2) invokeV.objValue;
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
        public final /* synthetic */ i f57836e;

        public b(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57836e = iVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i iVar;
            a.InterfaceC0618a interfaceC0618a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (interfaceC0618a = (iVar = this.f57836e).f57791c) == null) {
                return;
            }
            interfaceC0618a.a(iVar.f57832g);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(TbPageContext tbPageContext, int i2) {
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

    @Override // d.a.q0.h2.k.e.e1.a
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f57831f == null) {
                LinearLayout linearLayout = new LinearLayout(this.f57789a.getPageActivity());
                this.f57831f = linearLayout;
                SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0206);
                this.f57831f.setOrientation(1);
                this.f57831f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            }
            this.f57831f.removeAllViews();
            if (this.f57833h == null) {
                g0 g0Var = new g0(this.f57789a);
                this.f57833h = g0Var;
                g0Var.n(Boolean.TRUE);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.f57789a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
            layoutParams.leftMargin = this.f57789a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            layoutParams.rightMargin = this.f57789a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            this.f57831f.addView(this.f57833h.g(), layoutParams);
            if (this.f57834i == null) {
                s0 s0Var = new s0(this.f57789a.getPageActivity());
                this.f57834i = s0Var;
                s0Var.v("pb");
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.topMargin = this.f57789a.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
            this.f57831f.addView(this.f57834i.g(), layoutParams2);
            if (this.k == null) {
                this.k = new VoteView(this.f57789a.getPageActivity());
            }
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams3.bottomMargin = this.f57789a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
            this.f57831f.addView(this.k, layoutParams3);
            return this.f57831f;
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
        SkinManager.setBackgroundColor(this.f57831f, R.color.CAM_X0206);
        g0 g0Var = this.f57833h;
        if (g0Var != null) {
            g0Var.onChangeSkinType(tbPageContext, i2);
        }
        s0 s0Var = this.f57834i;
        if (s0Var != null) {
            s0Var.onChangeSkinType(tbPageContext, i2);
        }
    }

    @Override // d.a.q0.h2.k.e.e1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, originalThreadInfo) == null) {
            this.f57792d = originalThreadInfo;
            this.j = originalThreadInfo == null ? null : originalThreadInfo.a();
            a aVar = new a(this);
            this.f57832g = aVar;
            s0 s0Var = this.f57834i;
            if (s0Var != null) {
                s0Var.a(aVar);
            }
            g0 g0Var = this.f57833h;
            if (g0Var != null) {
                g0Var.a(this.f57832g);
            }
            PollData pollData = this.f57792d.D;
            if (pollData != null && pollData.getOptions() != null && this.f57792d.D.getOptions().size() > 0) {
                this.k.setIsTransmit(true);
                VoteView voteView = this.k;
                OriginalThreadInfo originalThreadInfo2 = this.f57792d;
                voteView.setData(originalThreadInfo2.D, originalThreadInfo2.f12282f, originalThreadInfo2.f12281e);
                this.k.setVisibility(0);
                return;
            }
            this.f57831f.removeView(this.k);
        }
    }

    @Override // d.a.q0.h2.k.e.e1.a
    public void d(a.InterfaceC0618a interfaceC0618a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC0618a) == null) {
            super.d(interfaceC0618a);
            s0 s0Var = this.f57834i;
            if (s0Var != null) {
                s0Var.w(interfaceC0618a);
            }
            g0 g0Var = this.f57833h;
            if (g0Var != null) {
                g0Var.w(interfaceC0618a);
            }
            LinearLayout linearLayout = this.f57831f;
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
            s0 s0Var = this.f57834i;
            if (s0Var != null) {
                s0Var.l(this.f57790b);
            }
        }
    }
}
