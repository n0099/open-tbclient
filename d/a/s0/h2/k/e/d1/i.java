package d.a.s0.h2.k.e.d1;

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
import d.a.j.a;
import d.a.j.g0;
import d.a.j.s0;
import d.a.r0.r.q.b2;
import d.a.r0.r.q.w0;
import d.a.s0.a0.b0;
/* loaded from: classes9.dex */
public class i extends d.a.s0.h2.k.e.d1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f60486f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.r0.r.q.a f60487g;

    /* renamed from: h  reason: collision with root package name */
    public g0 f60488h;

    /* renamed from: i  reason: collision with root package name */
    public s0 f60489i;
    public b2 j;
    public VoteView k;

    /* loaded from: classes9.dex */
    public class a extends d.a.r0.r.q.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f60490e;

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
            this.f60490e = iVar;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f60490e.j : (b2) invokeV.objValue;
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
        public final /* synthetic */ i f60491e;

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
            this.f60491e = iVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i iVar;
            a.InterfaceC0643a interfaceC0643a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (interfaceC0643a = (iVar = this.f60491e).f60446c) == null) {
                return;
            }
            interfaceC0643a.a(iVar.f60487g);
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

    @Override // d.a.s0.h2.k.e.d1.a
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f60486f == null) {
                LinearLayout linearLayout = new LinearLayout(this.f60444a.getPageActivity());
                this.f60486f = linearLayout;
                SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0206);
                this.f60486f.setOrientation(1);
                this.f60486f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            }
            this.f60486f.removeAllViews();
            if (this.f60488h == null) {
                g0 g0Var = new g0(this.f60444a);
                this.f60488h = g0Var;
                g0Var.n(Boolean.TRUE);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.f60444a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
            layoutParams.leftMargin = this.f60444a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            layoutParams.rightMargin = this.f60444a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            this.f60486f.addView(this.f60488h.g(), layoutParams);
            if (this.f60489i == null) {
                s0 s0Var = new s0(this.f60444a.getPageActivity());
                this.f60489i = s0Var;
                s0Var.v("pb");
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.topMargin = this.f60444a.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
            this.f60486f.addView(this.f60489i.g(), layoutParams2);
            if (this.k == null) {
                this.k = new VoteView(this.f60444a.getPageActivity());
            }
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams3.bottomMargin = this.f60444a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
            this.f60486f.addView(this.k, layoutParams3);
            return this.f60486f;
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
        SkinManager.setBackgroundColor(this.f60486f, R.color.CAM_X0206);
        g0 g0Var = this.f60488h;
        if (g0Var != null) {
            g0Var.onChangeSkinType(tbPageContext, i2);
        }
        s0 s0Var = this.f60489i;
        if (s0Var != null) {
            s0Var.onChangeSkinType(tbPageContext, i2);
        }
    }

    @Override // d.a.s0.h2.k.e.d1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, originalThreadInfo) == null) {
            this.f60447d = originalThreadInfo;
            this.j = originalThreadInfo == null ? null : originalThreadInfo.a();
            a aVar = new a(this);
            this.f60487g = aVar;
            s0 s0Var = this.f60489i;
            if (s0Var != null) {
                s0Var.a(aVar);
            }
            g0 g0Var = this.f60488h;
            if (g0Var != null) {
                g0Var.a(this.f60487g);
            }
            PollData pollData = this.f60447d.D;
            if (pollData != null && pollData.getOptions() != null && this.f60447d.D.getOptions().size() > 0) {
                this.k.setIsTransmit(true);
                VoteView voteView = this.k;
                OriginalThreadInfo originalThreadInfo2 = this.f60447d;
                voteView.setData(originalThreadInfo2.D, originalThreadInfo2.f12235f, originalThreadInfo2.f12234e);
                this.k.setVisibility(0);
                return;
            }
            this.f60486f.removeView(this.k);
        }
    }

    @Override // d.a.s0.h2.k.e.d1.a
    public void d(a.InterfaceC0643a interfaceC0643a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC0643a) == null) {
            super.d(interfaceC0643a);
            s0 s0Var = this.f60489i;
            if (s0Var != null) {
                s0Var.w(interfaceC0643a);
            }
            g0 g0Var = this.f60488h;
            if (g0Var != null) {
                g0Var.w(interfaceC0643a);
            }
            LinearLayout linearLayout = this.f60486f;
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
            s0 s0Var = this.f60489i;
            if (s0Var != null) {
                s0Var.l(this.f60445b);
            }
        }
    }
}
