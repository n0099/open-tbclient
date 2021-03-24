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
    public TbPageContext f55584a;

    /* renamed from: b  reason: collision with root package name */
    public View f55585b;

    /* renamed from: c  reason: collision with root package name */
    public RankListViewController.RankListViewHolder f55586c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f55587d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f55588e;

    /* renamed from: f  reason: collision with root package name */
    public String f55589f;

    /* renamed from: g  reason: collision with root package name */
    public int f55590g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f55591h = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(b.this.f55589f)) {
                b.this.f55584a.showToast(R.string.load_error_retry);
                return;
            }
            UrlManager.getInstance().dealOneLink(b.this.f55584a, new String[]{b.this.f55589f});
            if (b.this.f55590g == 0) {
                return;
            }
            if (b.this.f55590g != 2) {
                if (b.this.f55590g == 1) {
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
        this.f55584a = tbPageContext;
        this.f55585b = view;
        RankListViewController.RankListViewHolder rankListViewHolder = new RankListViewController.RankListViewHolder(view.findViewById(R.id.user_view));
        this.f55586c = rankListViewHolder;
        rankListViewHolder.i(1);
        this.f55587d = (TextView) view.findViewById(R.id.get_influence);
        TextView textView = (TextView) view.findViewById(R.id.rank_num);
        this.f55588e = textView;
        textView.setTextSize(0, l.g(this.f55584a.getPageActivity(), R.dimen.tbfontsize46));
        this.f55587d.setOnClickListener(this.f55591h);
    }

    public void d(int i) {
        this.f55586c.f(i);
        SkinManager.setBackgroundColor(this.f55586c.itemView, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.f55587d, R.color.CAM_X0302);
    }

    public void e(c cVar) {
        d.b.i0.i0.i.c.b bVar;
        MetaData metaData;
        if (cVar != null && (bVar = cVar.f55609c) != null && (metaData = bVar.f55604f) != null && !metaData.isMask && TbadkCoreApplication.isLogin()) {
            this.f55585b.setVisibility(0);
            this.f55586c.c(cVar.f55609c);
            this.f55586c.e();
            this.f55589f = cVar.f55611e;
            return;
        }
        this.f55585b.setVisibility(8);
    }

    public void f(int i) {
        this.f55590g = i;
    }
}
