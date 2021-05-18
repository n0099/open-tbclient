package d.a.k0.i0.i;

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
import d.a.k0.i0.i.c.c;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f55766a;

    /* renamed from: b  reason: collision with root package name */
    public View f55767b;

    /* renamed from: c  reason: collision with root package name */
    public RankListViewController.RankListViewHolder f55768c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f55769d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f55770e;

    /* renamed from: f  reason: collision with root package name */
    public String f55771f;

    /* renamed from: g  reason: collision with root package name */
    public int f55772g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f55773h = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(b.this.f55771f)) {
                b.this.f55766a.showToast(R.string.load_error_retry);
                return;
            }
            UrlManager.getInstance().dealOneLink(b.this.f55766a, new String[]{b.this.f55771f});
            if (b.this.f55772g == 0) {
                return;
            }
            if (b.this.f55772g != 2) {
                if (b.this.f55772g == 1) {
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
        this.f55766a = tbPageContext;
        this.f55767b = view;
        RankListViewController.RankListViewHolder rankListViewHolder = new RankListViewController.RankListViewHolder(view.findViewById(R.id.user_view));
        this.f55768c = rankListViewHolder;
        rankListViewHolder.i(1);
        this.f55769d = (TextView) view.findViewById(R.id.get_influence);
        TextView textView = (TextView) view.findViewById(R.id.rank_num);
        this.f55770e = textView;
        textView.setTextSize(0, l.g(this.f55766a.getPageActivity(), R.dimen.tbfontsize46));
        this.f55769d.setOnClickListener(this.f55773h);
    }

    public void d(int i2) {
        this.f55768c.f(i2);
        SkinManager.setBackgroundColor(this.f55768c.itemView, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.f55769d, R.color.CAM_X0302);
    }

    public void e(c cVar) {
        d.a.k0.i0.i.c.b bVar;
        MetaData metaData;
        if (cVar != null && (bVar = cVar.f55791c) != null && (metaData = bVar.f55786f) != null && !metaData.isMask && TbadkCoreApplication.isLogin()) {
            this.f55767b.setVisibility(0);
            this.f55768c.c(cVar.f55791c);
            this.f55768c.e();
            this.f55771f = cVar.f55793e;
            return;
        }
        this.f55767b.setVisibility(8);
    }

    public void f(int i2) {
        this.f55772g = i2;
    }
}
