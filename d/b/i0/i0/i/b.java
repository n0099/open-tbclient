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
import d.b.b.e.p.l;
import d.b.i0.i0.i.c.c;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f55585a;

    /* renamed from: b  reason: collision with root package name */
    public View f55586b;

    /* renamed from: c  reason: collision with root package name */
    public RankListViewController.RankListViewHolder f55587c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f55588d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f55589e;

    /* renamed from: f  reason: collision with root package name */
    public String f55590f;

    /* renamed from: g  reason: collision with root package name */
    public int f55591g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f55592h = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(b.this.f55590f)) {
                b.this.f55585a.showToast(R.string.load_error_retry);
                return;
            }
            UrlManager.getInstance().dealOneLink(b.this.f55585a, new String[]{b.this.f55590f});
            if (b.this.f55591g == 0) {
                return;
            }
            if (b.this.f55591g != 2) {
                if (b.this.f55591g == 1) {
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
        this.f55585a = tbPageContext;
        this.f55586b = view;
        RankListViewController.RankListViewHolder rankListViewHolder = new RankListViewController.RankListViewHolder(view.findViewById(R.id.user_view));
        this.f55587c = rankListViewHolder;
        rankListViewHolder.i(1);
        this.f55588d = (TextView) view.findViewById(R.id.get_influence);
        TextView textView = (TextView) view.findViewById(R.id.rank_num);
        this.f55589e = textView;
        textView.setTextSize(0, l.g(this.f55585a.getPageActivity(), R.dimen.tbfontsize46));
        this.f55588d.setOnClickListener(this.f55592h);
    }

    public void d(int i) {
        this.f55587c.f(i);
        SkinManager.setBackgroundColor(this.f55587c.itemView, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.f55588d, R.color.CAM_X0302);
    }

    public void e(c cVar) {
        d.b.i0.i0.i.c.b bVar;
        MetaData metaData;
        if (cVar != null && (bVar = cVar.f55610c) != null && (metaData = bVar.f55605f) != null && !metaData.isMask && TbadkCoreApplication.isLogin()) {
            this.f55586b.setVisibility(0);
            this.f55587c.c(cVar.f55610c);
            this.f55587c.e();
            this.f55590f = cVar.f55612e;
            return;
        }
        this.f55586b.setVisibility(8);
    }

    public void f(int i) {
        this.f55591g = i;
    }
}
