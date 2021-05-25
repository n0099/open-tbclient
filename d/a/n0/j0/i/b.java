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
    public TbPageContext f55950a;

    /* renamed from: b  reason: collision with root package name */
    public View f55951b;

    /* renamed from: c  reason: collision with root package name */
    public RankListViewController.RankListViewHolder f55952c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f55953d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f55954e;

    /* renamed from: f  reason: collision with root package name */
    public String f55955f;

    /* renamed from: g  reason: collision with root package name */
    public int f55956g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f55957h = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(b.this.f55955f)) {
                b.this.f55950a.showToast(R.string.load_error_retry);
                return;
            }
            UrlManager.getInstance().dealOneLink(b.this.f55950a, new String[]{b.this.f55955f});
            if (b.this.f55956g == 0) {
                return;
            }
            if (b.this.f55956g != 2) {
                if (b.this.f55956g == 1) {
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
        this.f55950a = tbPageContext;
        this.f55951b = view;
        RankListViewController.RankListViewHolder rankListViewHolder = new RankListViewController.RankListViewHolder(view.findViewById(R.id.user_view));
        this.f55952c = rankListViewHolder;
        rankListViewHolder.i(1);
        this.f55953d = (TextView) view.findViewById(R.id.get_influence);
        TextView textView = (TextView) view.findViewById(R.id.rank_num);
        this.f55954e = textView;
        textView.setTextSize(0, l.g(this.f55950a.getPageActivity(), R.dimen.tbfontsize46));
        this.f55953d.setOnClickListener(this.f55957h);
    }

    public void d(int i2) {
        this.f55952c.f(i2);
        SkinManager.setBackgroundColor(this.f55952c.itemView, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.f55953d, R.color.CAM_X0302);
    }

    public void e(c cVar) {
        d.a.n0.j0.i.c.b bVar;
        MetaData metaData;
        if (cVar != null && (bVar = cVar.f55975c) != null && (metaData = bVar.f55970f) != null && !metaData.isMask && TbadkCoreApplication.isLogin()) {
            this.f55951b.setVisibility(0);
            this.f55952c.c(cVar.f55975c);
            this.f55952c.e();
            this.f55955f = cVar.f55977e;
            return;
        }
        this.f55951b.setVisibility(8);
    }

    public void f(int i2) {
        this.f55956g = i2;
    }
}
