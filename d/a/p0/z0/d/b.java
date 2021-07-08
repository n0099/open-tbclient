package d.a.p0.z0.d;

import android.view.View;
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
public class b extends d.a.p0.a0.b<h> {
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
    public MetaData u;
    public h v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext<?> tbPageContext) {
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
        clickableHeaderImageView.setGodIconMargin(R.dimen.ds6);
        this.o.setAfterClickListener(this);
        this.p = (TextView) k().findViewById(R.id.god_name);
        this.q = (TextView) k().findViewById(R.id.god_describe);
        this.r = (TextView) k().findViewById(R.id.rec_reason);
        CommonUserLikeButton commonUserLikeButton = (CommonUserLikeButton) k().findViewById(R.id.god_like_btn);
        this.m = commonUserLikeButton;
        this.n = new c(tbPageContext, commonUserLikeButton);
        this.m.setAfterOnClickListener(this);
        this.s = k().findViewById(R.id.bottom_line);
    }

    @Override // d.a.p0.a0.b
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.card_god_square_rec_god : invokeV.intValue;
    }

    @Override // d.a.p0.a0.b
    public void m(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            if (this.f53776e != i2) {
                SkinManager.setBackgroundResource(k(), R.drawable.home_thread_card_item_bg);
                SkinManager.setViewTextColor(this.p, R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.q, R.color.CAM_X0109);
                SkinManager.setViewTextColor(this.r, R.color.CAM_X0109);
                SkinManager.setBackgroundColor(this.s, R.color.CAM_X0204);
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
                h().a(view, this.v);
            }
            if (view != k() || (metaData = this.u) == null || StringUtils.isNull(metaData.getName_show()) || StringUtils.isNull(this.u.getUserId())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.t.getPageActivity(), this.u.getUserId(), this.u.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
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
        this.v = hVar;
        MetaData metaData2 = hVar.f53811e;
        this.u = metaData2;
        this.o.setData(metaData2);
        this.p.setText(hVar.f53811e.getName_show());
        this.q.setText(hVar.f53811e.getGodUserData().getIntro());
        String string = this.t.getResources().getString(R.string.recommend_reason);
        String recommendReason = hVar.f53811e.getGodUserData().getRecommendReason();
        if (StringUtils.isNull(recommendReason)) {
            this.r.setText("");
        } else {
            this.r.setText(String.format(string, recommendReason));
        }
        this.n.n(hVar.f53811e);
        m(null, TbadkCoreApplication.getInst().getSkinType());
    }

    public void s(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, bdUniqueId) != null) || bdUniqueId == null) {
        }
    }
}
