package d.a.n0.j0.i;

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
import d.a.c.e.p.l;
import d.a.n0.j0.i.c.c;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f59639a;

    /* renamed from: b  reason: collision with root package name */
    public View f59640b;

    /* renamed from: c  reason: collision with root package name */
    public RankListViewController.RankListViewHolder f59641c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f59642d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f59643e;

    /* renamed from: f  reason: collision with root package name */
    public String f59644f;

    /* renamed from: g  reason: collision with root package name */
    public int f59645g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f59646h = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(b.this.f59644f)) {
                b.this.f59639a.showToast(R.string.load_error_retry);
                return;
            }
            UrlManager.getInstance().dealOneLink(b.this.f59639a, new String[]{b.this.f59644f});
            if (b.this.f59645g == 0) {
                return;
            }
            if (b.this.f59645g != 2) {
                if (b.this.f59645g == 1) {
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
        this.f59639a = tbPageContext;
        this.f59640b = view;
        RankListViewController.RankListViewHolder rankListViewHolder = new RankListViewController.RankListViewHolder(view.findViewById(R.id.user_view));
        this.f59641c = rankListViewHolder;
        rankListViewHolder.i(1);
        this.f59642d = (TextView) view.findViewById(R.id.get_influence);
        TextView textView = (TextView) view.findViewById(R.id.rank_num);
        this.f59643e = textView;
        textView.setTextSize(0, l.g(this.f59639a.getPageActivity(), R.dimen.tbfontsize46));
        this.f59642d.setOnClickListener(this.f59646h);
    }

    public void d(int i2) {
        this.f59641c.f(i2);
        SkinManager.setBackgroundColor(this.f59641c.itemView, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.f59642d, R.color.CAM_X0302);
    }

    public void e(c cVar) {
        d.a.n0.j0.i.c.b bVar;
        MetaData metaData;
        if (cVar != null && (bVar = cVar.f59664c) != null && (metaData = bVar.f59659f) != null && !metaData.isMask && TbadkCoreApplication.isLogin()) {
            this.f59640b.setVisibility(0);
            this.f59641c.c(cVar.f59664c);
            this.f59641c.e();
            this.f59644f = cVar.f59666e;
            return;
        }
        this.f59640b.setVisibility(8);
    }

    public void f(int i2) {
        this.f59645g = i2;
    }
}
