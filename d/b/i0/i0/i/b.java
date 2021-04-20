package d.b.i0.i0.i;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.hotuserrank.RankListViewController;
import d.b.c.e.p.l;
import d.b.i0.i0.i.c.c;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f56708a;

    /* renamed from: b  reason: collision with root package name */
    public View f56709b;

    /* renamed from: c  reason: collision with root package name */
    public RankListViewController.RankListViewHolder f56710c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f56711d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f56712e;

    /* renamed from: f  reason: collision with root package name */
    public String f56713f;

    /* renamed from: g  reason: collision with root package name */
    public int f56714g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f56715h = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(b.this.f56713f)) {
                b.this.f56708a.showToast(R.string.load_error_retry);
                return;
            }
            UrlManager.getInstance().dealOneLink(b.this.f56708a, new String[]{b.this.f56713f});
            if (b.this.f56714g == 0) {
                return;
            }
            if (b.this.f56714g != 2) {
                if (b.this.f56714g == 1) {
                    StatisticItem statisticItem = new StatisticItem("c13669");
                    statisticItem.param("obj_locate", 2);
                    TiebaStatic.log(statisticItem);
                    return;
                }
                return;
            }
            StatisticItem statisticItem2 = new StatisticItem("c13658");
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem2.param("obj_locate", 2);
            TiebaStatic.log(statisticItem2);
        }
    }

    public b(TbPageContext tbPageContext, View view) {
        this.f56708a = tbPageContext;
        this.f56709b = view;
        RankListViewController.RankListViewHolder rankListViewHolder = new RankListViewController.RankListViewHolder(view.findViewById(R.id.user_view));
        this.f56710c = rankListViewHolder;
        rankListViewHolder.i(1);
        this.f56711d = (TextView) view.findViewById(R.id.get_influence);
        TextView textView = (TextView) view.findViewById(R.id.rank_num);
        this.f56712e = textView;
        textView.setTextSize(0, l.g(this.f56708a.getPageActivity(), R.dimen.tbfontsize46));
        this.f56711d.setOnClickListener(this.f56715h);
    }

    public void d(int i) {
        this.f56710c.f(i);
        SkinManager.setBackgroundColor(this.f56710c.itemView, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.f56711d, R.color.CAM_X0302);
    }

    public void e(c cVar) {
        d.b.i0.i0.i.c.b bVar;
        MetaData metaData;
        if (cVar != null && (bVar = cVar.f56733c) != null && (metaData = bVar.f56728f) != null && !metaData.isMask && TbadkCoreApplication.isLogin()) {
            this.f56709b.setVisibility(0);
            this.f56710c.c(cVar.f56733c);
            this.f56710c.e();
            this.f56713f = cVar.f56735e;
            return;
        }
        this.f56709b.setVisibility(8);
    }

    public void f(int i) {
        this.f56714g = i;
    }
}
