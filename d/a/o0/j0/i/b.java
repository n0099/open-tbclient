package d.a.o0.j0.i;

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
import d.a.o0.j0.i.c.c;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f59764a;

    /* renamed from: b  reason: collision with root package name */
    public View f59765b;

    /* renamed from: c  reason: collision with root package name */
    public RankListViewController.RankListViewHolder f59766c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f59767d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f59768e;

    /* renamed from: f  reason: collision with root package name */
    public String f59769f;

    /* renamed from: g  reason: collision with root package name */
    public int f59770g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f59771h = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(b.this.f59769f)) {
                b.this.f59764a.showToast(R.string.load_error_retry);
                return;
            }
            UrlManager.getInstance().dealOneLink(b.this.f59764a, new String[]{b.this.f59769f});
            if (b.this.f59770g == 0) {
                return;
            }
            if (b.this.f59770g != 2) {
                if (b.this.f59770g == 1) {
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
        this.f59764a = tbPageContext;
        this.f59765b = view;
        RankListViewController.RankListViewHolder rankListViewHolder = new RankListViewController.RankListViewHolder(view.findViewById(R.id.user_view));
        this.f59766c = rankListViewHolder;
        rankListViewHolder.i(1);
        this.f59767d = (TextView) view.findViewById(R.id.get_influence);
        TextView textView = (TextView) view.findViewById(R.id.rank_num);
        this.f59768e = textView;
        textView.setTextSize(0, l.g(this.f59764a.getPageActivity(), R.dimen.tbfontsize46));
        this.f59767d.setOnClickListener(this.f59771h);
    }

    public void d(int i2) {
        this.f59766c.f(i2);
        SkinManager.setBackgroundColor(this.f59766c.itemView, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.f59767d, R.color.CAM_X0302);
    }

    public void e(c cVar) {
        d.a.o0.j0.i.c.b bVar;
        MetaData metaData;
        if (cVar != null && (bVar = cVar.f59789c) != null && (metaData = bVar.f59784f) != null && !metaData.isMask && TbadkCoreApplication.isLogin()) {
            this.f59765b.setVisibility(0);
            this.f59766c.c(cVar.f59789c);
            this.f59766c.e();
            this.f59769f = cVar.f59791e;
            return;
        }
        this.f59765b.setVisibility(8);
    }

    public void f(int i2) {
        this.f59770g = i2;
    }
}
