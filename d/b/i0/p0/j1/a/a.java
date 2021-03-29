package d.b.i0.p0.j1.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.brand.buttommenu.BottomMenuView;
import d.b.b.e.p.l;
import java.util.List;
import tbclient.BottomMenu;
import tbclient.SubBottomMenu;
/* loaded from: classes4.dex */
public class a implements BottomMenuView.a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f57692a;

    /* renamed from: b  reason: collision with root package name */
    public View f57693b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f57694c;

    /* renamed from: d  reason: collision with root package name */
    public BottomMenuView f57695d;

    /* renamed from: e  reason: collision with root package name */
    public ForumData f57696e;

    /* renamed from: f  reason: collision with root package name */
    public int f57697f;

    /* renamed from: g  reason: collision with root package name */
    public int f57698g;

    /* renamed from: h  reason: collision with root package name */
    public int f57699h;

    public a(TbPageContext tbPageContext, View view) {
        this.f57692a = tbPageContext;
        this.f57693b = view;
        this.f57694c = (ImageView) view.findViewById(R.id.normal_write_icon);
        BottomMenuView bottomMenuView = (BottomMenuView) view.findViewById(R.id.bottom_menu_view);
        this.f57695d = bottomMenuView;
        bottomMenuView.setOnMenuItemClickListener(this);
        this.f57697f = l.g(tbPageContext.getPageActivity(), R.dimen.tbds160);
        this.f57698g = l.g(tbPageContext.getPageActivity(), R.dimen.tbds44);
        this.f57699h = l.g(tbPageContext.getPageActivity(), R.dimen.ds4);
    }

    @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.a
    public void a(BottomMenuView.SubMenuItemView subMenuItemView, SubBottomMenu subBottomMenu) {
        if (subBottomMenu != null) {
            UrlManager.getInstance().dealOneLink(this.f57692a, new String[]{subBottomMenu.url});
            ForumData forumData = this.f57696e;
            String id = forumData != null ? forumData.getId() : "";
            ForumData forumData2 = this.f57696e;
            TiebaStatic.log(new StatisticItem("c13117").param("fid", id).param("fname", forumData2 != null ? forumData2.getName() : "").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_param1", subBottomMenu.name));
        }
    }

    @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.a
    public void b(BottomMenuView.MenuItemView menuItemView, BottomMenu bottomMenu) {
        long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
        if (bottomMenu != null && ListUtils.getCount(bottomMenu.submenu) == 0) {
            UrlManager.getInstance().dealOneLink(this.f57692a, new String[]{bottomMenu.url});
            ForumData forumData = this.f57696e;
            String id = forumData != null ? forumData.getId() : "";
            ForumData forumData2 = this.f57696e;
            TiebaStatic.log(new StatisticItem("c13117").param("fid", id).param("fname", forumData2 != null ? forumData2.getName() : "").param("uid", currentAccountId).param("obj_param1", bottomMenu.name));
            return;
        }
        TiebaStatic.log(new StatisticItem("c13118").param("uid", currentAccountId));
    }

    public final void c(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f57694c.getLayoutParams();
        if (z) {
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.addRule(14, 0);
            layoutParams.bottomMargin = this.f57697f;
            layoutParams.rightMargin = this.f57698g;
            return;
        }
        layoutParams.addRule(11, 0);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        layoutParams.bottomMargin = this.f57699h;
        layoutParams.rightMargin = 0;
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.f57695d.getVisibility() == 0) {
            this.f57695d.a(tbPageContext, i);
        }
    }

    public void e(List<BottomMenu> list, ForumData forumData) {
        this.f57696e = forumData;
        boolean z = ListUtils.getCount(list) > 0;
        c(z);
        if (z) {
            this.f57695d.setVisibility(0);
            this.f57695d.b(list, this.f57692a);
            return;
        }
        this.f57695d.setVisibility(8);
    }

    public void f(boolean z) {
        this.f57695d.setVisibility(z ? 0 : 8);
    }
}
