package d.a.j0.q0.j1.a;

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
import d.a.c.e.p.l;
import java.util.List;
import tbclient.BottomMenu;
import tbclient.SubBottomMenu;
/* loaded from: classes4.dex */
public class a implements BottomMenuView.a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f57883a;

    /* renamed from: b  reason: collision with root package name */
    public View f57884b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f57885c;

    /* renamed from: d  reason: collision with root package name */
    public BottomMenuView f57886d;

    /* renamed from: e  reason: collision with root package name */
    public ForumData f57887e;

    /* renamed from: f  reason: collision with root package name */
    public int f57888f;

    /* renamed from: g  reason: collision with root package name */
    public int f57889g;

    /* renamed from: h  reason: collision with root package name */
    public int f57890h;

    public a(TbPageContext tbPageContext, View view) {
        this.f57883a = tbPageContext;
        this.f57884b = view;
        this.f57885c = (ImageView) view.findViewById(R.id.normal_write_icon);
        BottomMenuView bottomMenuView = (BottomMenuView) view.findViewById(R.id.bottom_menu_view);
        this.f57886d = bottomMenuView;
        bottomMenuView.setOnMenuItemClickListener(this);
        this.f57888f = l.g(tbPageContext.getPageActivity(), R.dimen.tbds160);
        this.f57889g = l.g(tbPageContext.getPageActivity(), R.dimen.tbds44);
        this.f57890h = l.g(tbPageContext.getPageActivity(), R.dimen.ds4);
    }

    @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.a
    public void a(BottomMenuView.SubMenuItemView subMenuItemView, SubBottomMenu subBottomMenu) {
        if (subBottomMenu != null) {
            UrlManager.getInstance().dealOneLink(this.f57883a, new String[]{subBottomMenu.url});
            ForumData forumData = this.f57887e;
            String id = forumData != null ? forumData.getId() : "";
            ForumData forumData2 = this.f57887e;
            TiebaStatic.log(new StatisticItem("c13117").param("fid", id).param("fname", forumData2 != null ? forumData2.getName() : "").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_param1", subBottomMenu.name));
        }
    }

    @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.a
    public void b(BottomMenuView.MenuItemView menuItemView, BottomMenu bottomMenu) {
        long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
        if (bottomMenu != null && ListUtils.getCount(bottomMenu.submenu) == 0) {
            UrlManager.getInstance().dealOneLink(this.f57883a, new String[]{bottomMenu.url});
            ForumData forumData = this.f57887e;
            String id = forumData != null ? forumData.getId() : "";
            ForumData forumData2 = this.f57887e;
            TiebaStatic.log(new StatisticItem("c13117").param("fid", id).param("fname", forumData2 != null ? forumData2.getName() : "").param("uid", currentAccountId).param("obj_param1", bottomMenu.name));
            return;
        }
        TiebaStatic.log(new StatisticItem("c13118").param("uid", currentAccountId));
    }

    public final void c(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f57885c.getLayoutParams();
        if (z) {
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.addRule(14, 0);
            layoutParams.bottomMargin = this.f57888f;
            layoutParams.rightMargin = this.f57889g;
            return;
        }
        layoutParams.addRule(11, 0);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        layoutParams.bottomMargin = this.f57890h;
        layoutParams.rightMargin = 0;
    }

    public void d(TbPageContext<?> tbPageContext, int i2) {
        if (this.f57886d.getVisibility() == 0) {
            this.f57886d.a(tbPageContext, i2);
        }
    }

    public void e(List<BottomMenu> list, ForumData forumData) {
        this.f57887e = forumData;
        boolean z = ListUtils.getCount(list) > 0;
        c(z);
        if (z) {
            this.f57886d.setVisibility(0);
            this.f57886d.b(list, this.f57883a);
            return;
        }
        this.f57886d.setVisibility(8);
    }

    public void f(boolean z) {
        this.f57886d.setVisibility(z ? 0 : 8);
    }
}
