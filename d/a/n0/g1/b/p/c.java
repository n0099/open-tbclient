package d.a.n0.g1.b.p;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
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
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.n0.z.b0;
/* loaded from: classes4.dex */
public class c extends d.a.n0.z.b<d.a.n0.g1.b.p.a> {
    public d.a.n0.g1.b.p.a A;
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

    /* loaded from: classes4.dex */
    public class a implements OriginalThreadCardView.b {
        public a() {
        }

        @Override // com.baidu.tieba.card.OriginalThreadCardView.b
        public void a(OriginalThreadInfo originalThreadInfo) {
            if (c.this.A != null && c.this.A.w() != null) {
                StatisticItem param = new StatisticItem(c.this.A.w()).param("obj_locate", 2);
                if (c.this.A.getType() != d.a.n0.g1.b.p.a.B && c.this.A.getType() != d.a.n0.g1.b.p.a.x) {
                    param.param("obj_type", 2);
                } else {
                    param.param("obj_type", 1);
                }
                TiebaStatic.log(param);
            }
            if (c.this.i() != null) {
                b0<d.a.n0.g1.b.p.a> i2 = c.this.i();
                c cVar = c.this;
                i2.a(cVar.v, cVar.A);
            }
        }
    }

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.z = 3;
        this.D = new a();
        this.y = tbPageContext;
        this.B = l.g(tbPageContext.getContext(), R.dimen.tbds42);
        this.C = l.g(this.y.getContext(), R.dimen.tbds48);
        v();
    }

    @Override // d.a.n0.z.b
    public int h() {
        return R.layout.card_message_layout;
    }

    @Override // d.a.n0.z.b
    public void o(TbPageContext<?> tbPageContext, int i2) {
        if (this.z != i2) {
            this.z = i2;
            m().setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0205));
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.A == null && this.y == null) {
            return;
        }
        if (view == this.m || view == this.n) {
            if (this.A.t() == null) {
                return;
            }
            String userId = this.A.t().getUserId();
            String userName = this.A.t().getUserName();
            if (userId != null && userId.length() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.y.getContext(), userId, userName)));
            }
        }
        if (i() != null) {
            i().a(view, this.A);
        }
    }

    public final CharSequence u(TextView textView, SpannableString spannableString) {
        TbPageContext tbPageContext;
        if (textView == null || spannableString == null || (tbPageContext = this.y) == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), ((l.k(tbPageContext.getPageActivity()) - (this.y.getResources().getDimensionPixelSize(R.dimen.ds30) * 2)) - textView.getCompoundPaddingLeft()) * 2.0f, TextUtils.TruncateAt.END);
    }

    public final void v() {
        View m = m();
        this.m = (HeadImageView) m.findViewById(R.id.photo);
        this.n = (TextView) m.findViewById(R.id.user_name);
        this.o = (TextView) m.findViewById(R.id.fans_reply);
        this.p = (TextView) m.findViewById(R.id.post_from);
        this.q = m.findViewById(R.id.divider_between_time_and_post_from);
        this.r = (TextView) m.findViewById(R.id.time);
        this.s = (TextView) m.findViewById(R.id.card_message_title);
        this.t = m.findViewById(R.id.card_message_divider_line);
        this.u = (TextView) m.findViewById(R.id.card_message_post_title);
        this.v = (OriginalThreadCardView) m.findViewById(R.id.original_thread_view);
        this.w = (MessageCardBottomView) m.findViewById(R.id.card_message_bottom_layout);
        this.x = m.findViewById(R.id.new_message);
        this.v.setUsePlaceHolder(false);
        this.m.setOnClickListener(this);
        this.n.setOnClickListener(this);
        this.w.getReplyContainer().setOnClickListener(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.z.b
    /* renamed from: w */
    public void n(d.a.n0.g1.b.p.a aVar) {
        if (aVar == null || aVar.t() == null) {
            return;
        }
        this.A = aVar;
        MetaData t = aVar.t();
        this.m.setVisibility(0);
        boolean z = true;
        this.m.setPlaceHolder(1);
        this.m.setIsRound(true);
        UtilHelper.showHeadImageViewBigV(this.m, t, 0);
        this.m.setTag(null);
        this.m.setPageId(this.y.getUniqueId());
        this.m.U(aVar.t().getAvater(), 12, false);
        this.n.setText(StringHelper.cutChineseAndEnglishWithSuffix(UtilHelper.getUserName(t), 14, StringHelper.STRING_MORE));
        if (aVar.t().getIsMyFans() == 1) {
            this.o.setVisibility(0);
        } else {
            this.o.setVisibility(8);
        }
        if (!k.isEmpty(aVar.o())) {
            this.q.setVisibility(0);
            this.p.setVisibility(0);
            this.p.setText(aVar.o());
        } else {
            this.q.setVisibility(8);
            this.p.setVisibility(8);
        }
        this.r.setText(StringHelper.getFormatTime(aVar.A()));
        TextView textView = this.s;
        TbFaceManager e2 = TbFaceManager.e();
        Context applicationContext = this.y.getPageActivity().getApplicationContext();
        String B = aVar.B();
        int i2 = this.C;
        textView.setText(u(textView, e2.k(applicationContext, B, i2, i2)));
        if (k.isEmpty(aVar.x())) {
            this.t.setVisibility(8);
            this.u.setVisibility(8);
        } else {
            TextView textView2 = this.u;
            TbFaceManager e3 = TbFaceManager.e();
            Context applicationContext2 = this.y.getPageActivity().getApplicationContext();
            String x = aVar.x();
            int i3 = this.B;
            textView2.setText(u(textView2, e3.k(applicationContext2, x, i3, i3)));
            this.u.setVisibility(0);
            this.t.setVisibility(0);
        }
        this.v.f(aVar.k());
        this.v.setSubClickListener(this.D);
        this.w.setData(aVar.g(), (aVar.getType() == d.a.n0.g1.b.p.a.x || aVar.getType() == d.a.n0.g1.b.p.a.y) ? false : false);
        if (aVar.D()) {
            this.x.setVisibility(0);
        } else {
            this.x.setVisibility(8);
        }
        o(this.y, TbadkCoreApplication.getInst().getSkinType());
    }
}
