package d.a.p0.z0.d;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.r.f0.t.c;
import d.a.p0.a0.e0.h;
/* loaded from: classes8.dex */
public class a extends d.a.p0.a0.b<h> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CommonUserLikeButton m;
    public c n;
    public ClickableHeaderImageView o;
    public TextView p;
    public TextView q;
    public TextView r;
    public View s;
    public TbPageContext<?> t;
    public Drawable u;
    public MetaData v;
    public h w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext<?> tbPageContext) {
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
        this.t = tbPageContext;
        k().setOnClickListener(this);
        ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) k().findViewById(R.id.god_header_view);
        this.o = clickableHeaderImageView;
        clickableHeaderImageView.setGodIconMargin(R.dimen.ds4);
        this.o.setAfterClickListener(this);
        this.q = (TextView) k().findViewById(R.id.god_name);
        this.r = (TextView) k().findViewById(R.id.god_describe);
        CommonUserLikeButton commonUserLikeButton = (CommonUserLikeButton) k().findViewById(R.id.god_like_btn);
        this.m = commonUserLikeButton;
        this.n = new c(tbPageContext, commonUserLikeButton);
        this.m.setAfterOnClickListener(this);
        this.s = k().findViewById(R.id.bottom_line);
        this.p = (TextView) k().findViewById(R.id.god_rank);
        this.u = this.t.getResources().getDrawable(R.drawable.transparent_bg);
    }

    @Override // d.a.p0.a0.b
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.card_god_square_hot_god : invokeV.intValue;
    }

    @Override // d.a.p0.a0.b
    public void m(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            if (this.f53776e != i2) {
                SkinManager.setBackgroundResource(k(), R.drawable.home_thread_card_item_bg);
                SkinManager.setViewTextColor(this.q, R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.r, R.color.CAM_X0109);
                SkinManager.setBackgroundColor(this.s, R.color.CAM_X0204);
                SkinManager.setViewTextColor(this.p, R.color.CAM_X0109);
            }
            this.f53776e = i2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            if (h() != null) {
                h().a(view, this.w);
            }
            if (view != k() || (metaData = this.v) == null || StringUtils.isNull(metaData.getName_show()) || StringUtils.isNull(this.v.getUserId())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.t.getPageActivity()).createNormalConfig(d.a.c.e.m.b.f(this.v.getUserId(), 0L), false, this.v.isBigV())));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.p0.a0.b
    /* renamed from: q */
    public void l(h hVar) {
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, hVar) == null) || hVar == null || (metaData = hVar.f53811e) == null || metaData.getGodUserData() == null) {
            return;
        }
        this.w = hVar;
        this.v = hVar.f53811e;
        t(hVar.f53813g);
        this.o.setData(hVar.f53811e);
        this.q.setText(hVar.f53811e.getName_show());
        this.r.setText(hVar.f53811e.getGodUserData().getIntro());
        this.n.n(hVar.f53811e);
        m(null, TbadkCoreApplication.getInst().getSkinType());
    }

    public void s(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, bdUniqueId) != null) || bdUniqueId == null) {
        }
    }

    public final void t(int i2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            if (i2 == 1) {
                this.p.setText("");
                SkinManager.setBackgroundResource(this.p, R.drawable.icon_grade_round_no1);
            } else if (i2 == 2) {
                this.p.setText("");
                SkinManager.setBackgroundResource(this.p, R.drawable.icon_grade_round_no2);
            } else if (i2 != 3) {
                this.p.setBackgroundDrawable(this.u);
                if (i2 < 100) {
                    str = String.format("%02d", Integer.valueOf(i2));
                } else {
                    str = i2 + "";
                }
                this.p.setText(str);
            } else {
                this.p.setText("");
                SkinManager.setBackgroundResource(this.p, R.drawable.icon_grade_round_no3);
            }
        }
    }
}
