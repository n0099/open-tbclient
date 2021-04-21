package d.b.j0.f1.b;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class a extends d.b.i0.g0.f.a<FeedData, d.b.i0.g0.d.b> {
    public HeadImageView k;
    public TextView l;
    public ImageView m;
    public TextView n;
    public TextView o;
    public View p;
    public int q;

    /* renamed from: d.b.j0.f1.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1316a implements View.OnClickListener {
        public View$OnClickListenerC1316a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.d().dispatchMvcEvent(new d.b.i0.g0.c.b(9483, a.this.c(), null, null));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FeedData c2 = a.this.c();
            a.this.d().dispatchMvcEvent(new d.b.i0.g0.c.b(9484, c2, null, null));
            StatisticItem statisticItem = new StatisticItem("c13784");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fname", c2.getFname());
            statisticItem.param("tid", c2.getThread_id());
            statisticItem.param("obj_type", 1);
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnLongClickListener {
        public c() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            a.this.d().dispatchMvcEvent(new d.b.i0.g0.c.b(9489, a.this.c(), null, null));
            return true;
        }
    }

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.q = R.color.CAM_X0108;
        HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.photo);
        this.k = headImageView;
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.k.setAutoChangeStyle(true);
        this.k.setPlaceHolder(1);
        this.l = (TextView) view.findViewById(R.id.user_name);
        this.m = (ImageView) view.findViewById(R.id.fans_reply);
        this.n = (TextView) view.findViewById(R.id.time);
        this.o = (TextView) view.findViewById(R.id.content);
        this.p = view.findViewById(R.id.line);
        this.k.setOnClickListener(new View$OnClickListenerC1316a());
        view.setOnClickListener(new b());
        view.setOnLongClickListener(new c());
    }

    @Override // d.b.j0.d3.t
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        g().setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0205));
        SkinManager.setBackgroundColor(this.p, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.n, R.color.CAM_X0109);
        SkinManager.setBackgroundResource(this.m, R.drawable.icon_pb_fans);
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.l, this.q);
        this.k.invalidate();
        this.n.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(R.drawable.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.g0.f.e
    /* renamed from: r */
    public void k(FeedData feedData) {
        super.k(feedData);
        if (feedData.getReplyer() != null) {
            MetaData replyer = feedData.getReplyer();
            this.l.setText(UtilHelper.getUserName(replyer));
            if (feedData.getReplyer().isBigV()) {
                this.q = R.color.cp_cont_r;
            } else {
                this.q = R.color.CAM_X0108;
            }
            SkinManager.setViewTextColor(this.l, this.q);
            this.k.setIsRound(true);
            this.k.setVisibility(0);
            UtilHelper.showHeadImageViewBigV(this.k, replyer, 0);
            this.k.setTag(null);
            String avater = feedData.getReplyer().getAvater();
            if (avater != null && avater.length() > 0) {
                this.k.W(avater, 12, false);
            } else {
                this.k.setImageResource(R.drawable.photo);
            }
            if (feedData.getReplyer().getIsMyFans() == 1) {
                this.m.setVisibility(0);
            } else {
                this.m.setVisibility(8);
            }
        }
        this.n.setText(StringHelper.getFormatTime(feedData.getTime()));
        this.o.setText(feedData.getContent());
    }
}
