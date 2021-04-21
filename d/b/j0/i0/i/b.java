package d.b.j0.i0.i;

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
import d.b.j0.i0.i.c.c;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f57129a;

    /* renamed from: b  reason: collision with root package name */
    public View f57130b;

    /* renamed from: c  reason: collision with root package name */
    public RankListViewController.RankListViewHolder f57131c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f57132d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f57133e;

    /* renamed from: f  reason: collision with root package name */
    public String f57134f;

    /* renamed from: g  reason: collision with root package name */
    public int f57135g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f57136h = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(b.this.f57134f)) {
                b.this.f57129a.showToast(R.string.load_error_retry);
                return;
            }
            UrlManager.getInstance().dealOneLink(b.this.f57129a, new String[]{b.this.f57134f});
            if (b.this.f57135g == 0) {
                return;
            }
            if (b.this.f57135g != 2) {
                if (b.this.f57135g == 1) {
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
        this.f57129a = tbPageContext;
        this.f57130b = view;
        RankListViewController.RankListViewHolder rankListViewHolder = new RankListViewController.RankListViewHolder(view.findViewById(R.id.user_view));
        this.f57131c = rankListViewHolder;
        rankListViewHolder.i(1);
        this.f57132d = (TextView) view.findViewById(R.id.get_influence);
        TextView textView = (TextView) view.findViewById(R.id.rank_num);
        this.f57133e = textView;
        textView.setTextSize(0, l.g(this.f57129a.getPageActivity(), R.dimen.tbfontsize46));
        this.f57132d.setOnClickListener(this.f57136h);
    }

    public void d(int i) {
        this.f57131c.f(i);
        SkinManager.setBackgroundColor(this.f57131c.itemView, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.f57132d, R.color.CAM_X0302);
    }

    public void e(c cVar) {
        d.b.j0.i0.i.c.b bVar;
        MetaData metaData;
        if (cVar != null && (bVar = cVar.f57154c) != null && (metaData = bVar.f57149f) != null && !metaData.isMask && TbadkCoreApplication.isLogin()) {
            this.f57130b.setVisibility(0);
            this.f57131c.c(cVar.f57154c);
            this.f57131c.e();
            this.f57134f = cVar.f57156e;
            return;
        }
        this.f57130b.setVisibility(8);
    }

    public void f(int i) {
        this.f57135g = i;
    }
}
