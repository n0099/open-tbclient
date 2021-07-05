package d.a.s0.j1.b.p;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.imMessageCenter.mention.base.MessageCardBottomView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.s0.a0.b0;
/* loaded from: classes9.dex */
public class c extends d.a.s0.a0.b<d.a.s0.j1.b.p.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d.a.s0.j1.b.p.a A;
    public int B;
    public int C;
    public OriginalThreadCardView.b D;
    public HeadImageView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public View q;
    public TextView r;
    public TextView s;
    public View t;
    public TextView u;
    public OriginalThreadCardView v;
    public MessageCardBottomView w;
    public View x;
    public TbPageContext y;
    public int z;

    /* loaded from: classes9.dex */
    public class a implements OriginalThreadCardView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f62307a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62307a = cVar;
        }

        @Override // com.baidu.tieba.card.OriginalThreadCardView.b
        public void a(OriginalThreadInfo originalThreadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, originalThreadInfo) == null) {
                if (this.f62307a.A != null && this.f62307a.A.t() != null) {
                    StatisticItem param = new StatisticItem(this.f62307a.A.t()).param("obj_locate", 2);
                    if (this.f62307a.A.getType() != d.a.s0.j1.b.p.a.B && this.f62307a.A.getType() != d.a.s0.j1.b.p.a.x) {
                        param.param("obj_type", 2);
                    } else {
                        param.param("obj_type", 1);
                    }
                    TiebaStatic.log(param);
                }
                if (this.f62307a.i() != null) {
                    b0<d.a.s0.j1.b.p.a> i2 = this.f62307a.i();
                    c cVar = this.f62307a;
                    i2.a(cVar.v, cVar.A);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (ViewGroup) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.z = 3;
        this.D = new a(this);
        this.y = tbPageContext;
        this.B = l.g(tbPageContext.getContext(), R.dimen.tbds42);
        this.C = l.g(this.y.getContext(), R.dimen.tbds48);
        u();
    }

    @Override // d.a.s0.a0.b
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.card_message_layout : invokeV.intValue;
    }

    @Override // d.a.s0.a0.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.z == i2) {
            return;
        }
        this.z = i2;
        l().setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0205));
        SkinManager.setViewTextColor(this.n, R.color.CAM_X0106);
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0109);
        SkinManager.setBackgroundResource(this.o, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
        SkinManager.setViewTextColor(this.p, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.r, R.color.CAM_X0109);
        SkinManager.setBackgroundColor(this.q, R.color.CAM_X0110);
        SkinManager.setViewTextColor(this.s, R.color.CAM_X0105);
        SkinManager.setBackgroundColor(this.t, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.u, R.color.CAM_X0107);
        OriginalThreadCardView originalThreadCardView = this.v;
        if (originalThreadCardView != null) {
            originalThreadCardView.n();
        }
        MessageCardBottomView messageCardBottomView = this.w;
        if (messageCardBottomView != null) {
            messageCardBottomView.b();
        }
        SkinManager.setBackgroundResource(this.x, R.drawable.icon_news_red_dot);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            if (this.A == null && this.y == null) {
                return;
            }
            if (view == this.m || view == this.n) {
                if (this.A.q() == null) {
                    return;
                }
                String userId = this.A.q().getUserId();
                String userName = this.A.q().getUserName();
                if (userId != null && userId.length() > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.y.getContext(), userId, userName)));
                }
            }
            if (i() != null) {
                i().a(view, this.A);
            }
        }
    }

    public final CharSequence t(TextView textView, SpannableString spannableString) {
        InterceptResult invokeLL;
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, textView, spannableString)) == null) {
            if (textView == null || spannableString == null || (tbPageContext = this.y) == null) {
                return null;
            }
            return TextUtils.ellipsize(spannableString, textView.getPaint(), ((l.k(tbPageContext.getPageActivity()) - (this.y.getResources().getDimensionPixelSize(R.dimen.ds30) * 2)) - textView.getCompoundPaddingLeft()) * 2.0f, TextUtils.TruncateAt.END);
        }
        return (CharSequence) invokeLL.objValue;
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            View l = l();
            this.m = (HeadImageView) l.findViewById(R.id.photo);
            this.n = (TextView) l.findViewById(R.id.user_name);
            this.o = (TextView) l.findViewById(R.id.fans_reply);
            this.p = (TextView) l.findViewById(R.id.post_from);
            this.q = l.findViewById(R.id.divider_between_time_and_post_from);
            this.r = (TextView) l.findViewById(R.id.time);
            this.s = (TextView) l.findViewById(R.id.card_message_title);
            this.t = l.findViewById(R.id.card_message_divider_line);
            this.u = (TextView) l.findViewById(R.id.card_message_post_title);
            this.v = (OriginalThreadCardView) l.findViewById(R.id.original_thread_view);
            this.w = (MessageCardBottomView) l.findViewById(R.id.card_message_bottom_layout);
            this.x = l.findViewById(R.id.new_message);
            this.v.setUsePlaceHolder(false);
            this.m.setOnClickListener(this);
            this.n.setOnClickListener(this);
            this.w.getReplyContainer().setOnClickListener(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.s0.a0.b
    /* renamed from: v */
    public void m(d.a.s0.j1.b.p.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) || aVar == null || aVar.q() == null) {
            return;
        }
        this.A = aVar;
        MetaData q = aVar.q();
        this.m.setVisibility(0);
        boolean z = true;
        this.m.setPlaceHolder(1);
        this.m.setIsRound(true);
        UtilHelper.showHeadImageViewBigV(this.m, q, 0);
        this.m.setTag(null);
        this.m.setPageId(this.y.getUniqueId());
        this.m.M(aVar.q().getAvater(), 12, false);
        this.n.setText(StringHelper.cutChineseAndEnglishWithSuffix(UtilHelper.getUserName(q), 14, StringHelper.STRING_MORE));
        if (aVar.q().getIsMyFans() == 1) {
            this.o.setVisibility(0);
        } else {
            this.o.setVisibility(8);
        }
        if (!k.isEmpty(aVar.j())) {
            this.q.setVisibility(0);
            this.p.setVisibility(0);
            this.p.setText(aVar.j());
        } else {
            this.q.setVisibility(8);
            this.p.setVisibility(8);
        }
        this.r.setText(StringHelper.getFormatTime(aVar.z()));
        TextView textView = this.s;
        TbFaceManager e2 = TbFaceManager.e();
        Context applicationContext = this.y.getPageActivity().getApplicationContext();
        String title = aVar.getTitle();
        int i2 = this.C;
        textView.setText(t(textView, e2.k(applicationContext, title, i2, i2)));
        if (k.isEmpty(aVar.w())) {
            this.t.setVisibility(8);
            this.u.setVisibility(8);
        } else {
            TextView textView2 = this.u;
            TbFaceManager e3 = TbFaceManager.e();
            Context applicationContext2 = this.y.getPageActivity().getApplicationContext();
            String w = aVar.w();
            int i3 = this.B;
            textView2.setText(t(textView2, e3.k(applicationContext2, w, i3, i3)));
            this.u.setVisibility(0);
            this.t.setVisibility(0);
        }
        this.v.f(aVar.h());
        this.v.setSubClickListener(this.D);
        this.w.setData(aVar.d(), (aVar.getType() == d.a.s0.j1.b.p.a.x || aVar.getType() == d.a.s0.j1.b.p.a.y) ? false : false);
        if (aVar.B()) {
            this.x.setVisibility(0);
        } else {
            this.x.setVisibility(8);
        }
        n(this.y, TbadkCoreApplication.getInst().getSkinType());
    }
}
