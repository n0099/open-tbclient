package d.a.s0.u0.m1.g;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.r0.r.q.b2;
/* loaded from: classes9.dex */
public class b extends d.a.s0.u0.m1.g.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EntelechyUserLikeButton A0;
    public d.a.r0.r.f0.s.c B0;
    public int C0;
    public b2 D0;
    public CommonUserLikeButton.a E0;
    public View.OnClickListener F0;
    public TbPageContext y0;
    public TextView z0;

    /* loaded from: classes9.dex */
    public class a implements CommonUserLikeButton.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f66419a;

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
            this.f66419a = bVar;
        }

        @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f66419a.p0(i2);
            }
        }
    }

    /* renamed from: d.a.s0.u0.m1.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class View$OnClickListenerC1733b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f66420e;

        public View$OnClickListenerC1733b(b bVar) {
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
            this.f66420e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f66420e.D0 == null || this.f66420e.D0.H() == null || StringUtils.isNull(this.f66420e.D0.H().getName_show()) || StringUtils.isNull(this.f66420e.D0.H().getUserId()) || this.f66420e.D0.W() == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f66420e.y0.getPageActivity(), this.f66420e.D0.H().getUserId(), this.f66420e.D0.H().getName_show(), this.f66420e.D0.W(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.C0 = 3;
        this.E0 = new a(this);
        this.F0 = new View$OnClickListenerC1733b(this);
        this.y0 = tbPageContext;
        TextView textView = new TextView(tbPageContext.getPageActivity());
        this.z0 = textView;
        textView.setIncludeFontPadding(false);
        this.z0.setTextSize(0, l.g(tbPageContext.getPageActivity(), R.dimen.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = l.g(tbPageContext.getPageActivity(), R.dimen.ds6);
        this.z0.setLayoutParams(layoutParams);
        this.z0.setOnClickListener(this.F0);
        this.u.addView(this.z0, 1);
        EntelechyUserLikeButton entelechyUserLikeButton = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.A0 = entelechyUserLikeButton;
        entelechyUserLikeButton.setFanNumCallBack(this.E0);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, l.g(this.y0.getPageActivity(), R.dimen.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, R.id.header_divider);
        layoutParams2.rightMargin = l.g(this.y0.getPageActivity(), R.dimen.ds32);
        layoutParams2.topMargin = l.g(this.y0.getPageActivity(), R.dimen.ds24);
        this.A0.setLayoutParams(layoutParams2);
        ((ViewGroup) l()).addView(this.A0);
        d.a.r0.r.f0.s.c cVar = new d.a.r0.r.f0.s.c(tbPageContext, this.A0);
        this.B0 = cVar;
        cVar.m("1");
        this.B0.l(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.s0.u0.m1.g.a, d.a.s0.a0.b
    /* renamed from: X */
    public void m(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, b2Var) == null) {
            super.m(b2Var);
            if (b2Var == null) {
                return;
            }
            this.D0 = b2Var;
            if (b2Var.H() != null) {
                this.B0.n(b2Var.H());
                p0(b2Var.H().getFansNum());
                if (!this.D0.Q1()) {
                    this.A0.setVisibility(8);
                } else if (this.D0.H().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.D0.H().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.A0.setVisibility(8);
                    return;
                } else if (this.D0.H().getGodUserData() != null && this.D0.H().getGodUserData().getIsLike()) {
                    if (this.D0.H().getGodUserData().getIsFromNetWork()) {
                        this.A0.setVisibility(8);
                    } else {
                        this.A0.setVisibility(0);
                        this.A0.e(true, 1);
                    }
                } else {
                    this.A0.setVisibility(0);
                }
            }
            int i2 = ((RelativeLayout.LayoutParams) this.v.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.A0.getLayoutParams();
            if (b2Var.Y0() != null) {
                layoutParams.topMargin = l.g(this.y0.getPageActivity(), R.dimen.ds4) + i2;
            } else {
                layoutParams.topMargin = l.g(this.y0.getPageActivity(), R.dimen.ds24);
            }
        }
    }

    @Override // d.a.s0.u0.m1.g.a
    public void Z(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdUniqueId) == null) {
            super.Z(bdUniqueId);
        }
    }

    @Override // d.a.s0.u0.m1.g.a, d.a.s0.a0.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i2) == null) {
            super.n(tbPageContext, i2);
            if (this.C0 != i2) {
                SkinManager.setViewTextColor(this.z0, R.color.CAM_X0109);
                this.A0.g(i2);
            }
            this.C0 = i2;
        }
    }

    public final void p0(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || this.z0 == null) {
            return;
        }
        String string = this.y0.getResources().getString(R.string.fans_default_name_god_user);
        b2 b2Var = this.D0;
        if (b2Var != null && !StringUtils.isNull(b2Var.W()) && this.D0.W().equals(this.n0)) {
            if (this.D0.Q1()) {
                String format = String.format(string, StringHelper.numberUniformFormat(i2));
                this.z0.setVisibility(0);
                this.z0.setText(format);
                return;
            }
            this.z0.setVisibility(8);
            return;
        }
        this.z0.setText(this.y0.getResources().getString(R.string.default_personalized_name));
    }
}
