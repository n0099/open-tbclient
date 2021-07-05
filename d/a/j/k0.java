package d.a.j;

import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PersonalCardDetailActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.r.q.b2;
/* loaded from: classes8.dex */
public class k0 extends c implements p<b2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public TbPageContext f45758i;
    public TbImageView j;
    public boolean k;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThemeCardInUserData f45759e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ k0 f45760f;

        public a(k0 k0Var, ThemeCardInUserData themeCardInUserData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k0Var, themeCardInUserData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45760f = k0Var;
            this.f45759e = themeCardInUserData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(this.f45760f.f45758i.getPageActivity(), this.f45759e.getCardId())));
            }
        }
    }

    public k0(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = true;
        this.f45758i = tbPageContext;
        h(-1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(d.a.c.e.p.l.g(tbPageContext.getPageActivity(), R.dimen.ds180), d.a.c.e.p.l.g(tbPageContext.getPageActivity(), R.dimen.ds50));
        layoutParams.addRule(11);
        layoutParams.topMargin = d.a.c.e.p.l.g(tbPageContext.getPageActivity(), R.dimen.tbds30);
        layoutParams.rightMargin = d.a.c.e.p.l.g(tbPageContext.getPageActivity(), R.dimen.tbds30);
        i(layoutParams);
        TbImageView tbImageView = new TbImageView(tbPageContext.getPageActivity());
        this.j = tbImageView;
        g(tbImageView);
    }

    public void l(b2 b2Var) {
        MetaData H;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b2Var) == null) || b2Var == null || this.j == null || (H = b2Var.H()) == null) {
            return;
        }
        ThemeCardInUserData themeCard = H.getThemeCard();
        if (themeCard != null && !StringUtils.isNull(themeCard.getCardImageUrlAndroid()) && !b2Var.S1) {
            if (this.k && (this.j.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.j.getLayoutParams();
                layoutParams.rightMargin = d.a.c.e.p.l.g(this.f45758i.getPageActivity(), R.dimen.tbds106);
                this.j.setLayoutParams(layoutParams);
            }
            this.j.setVisibility(0);
            this.j.setImageDrawable(null);
            this.j.M(themeCard.getCardImageUrlAndroid(), 10, false);
            this.j.setOnClickListener(new a(this, themeCard));
            return;
        }
        this.j.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j.p
    /* renamed from: m */
    public void a(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, b2Var) == null) {
            l(b2Var);
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.k = z;
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            this.j.setPageId(bdUniqueId);
        }
    }
}
