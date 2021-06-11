package d.a.n0.r0.j1.a;

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
    public TbPageContext<?> f62457a;

    /* renamed from: b  reason: collision with root package name */
    public View f62458b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f62459c;

    /* renamed from: d  reason: collision with root package name */
    public BottomMenuView f62460d;

    /* renamed from: e  reason: collision with root package name */
    public ForumData f62461e;

    /* renamed from: f  reason: collision with root package name */
    public int f62462f;

    /* renamed from: g  reason: collision with root package name */
    public int f62463g;

    /* renamed from: h  reason: collision with root package name */
    public int f62464h;

    public a(TbPageContext tbPageContext, View view) {
        this.f62457a = tbPageContext;
        this.f62458b = view;
        this.f62459c = (ImageView) view.findViewById(R.id.normal_write_icon);
        BottomMenuView bottomMenuView = (BottomMenuView) view.findViewById(R.id.bottom_menu_view);
        this.f62460d = bottomMenuView;
        bottomMenuView.setOnMenuItemClickListener(this);
        this.f62462f = l.g(tbPageContext.getPageActivity(), R.dimen.tbds160);
        this.f62463g = l.g(tbPageContext.getPageActivity(), R.dimen.tbds44);
        this.f62464h = l.g(tbPageContext.getPageActivity(), R.dimen.ds4);
    }

    @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.a
    public void a(BottomMenuView.SubMenuItemView subMenuItemView, SubBottomMenu subBottomMenu) {
        if (subBottomMenu != null) {
            UrlManager.getInstance().dealOneLink(this.f62457a, new String[]{subBottomMenu.url});
            ForumData forumData = this.f62461e;
            String id = forumData != null ? forumData.getId() : "";
            ForumData forumData2 = this.f62461e;
            TiebaStatic.log(new StatisticItem("c13117").param("fid", id).param("fname", forumData2 != null ? forumData2.getName() : "").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_param1", subBottomMenu.name));
        }
    }

    @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.a
    public void b(BottomMenuView.MenuItemView menuItemView, BottomMenu bottomMenu) {
        long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
        if (bottomMenu != null && ListUtils.getCount(bottomMenu.submenu) == 0) {
            UrlManager.getInstance().dealOneLink(this.f62457a, new String[]{bottomMenu.url});
            ForumData forumData = this.f62461e;
            String id = forumData != null ? forumData.getId() : "";
            ForumData forumData2 = this.f62461e;
            TiebaStatic.log(new StatisticItem("c13117").param("fid", id).param("fname", forumData2 != null ? forumData2.getName() : "").param("uid", currentAccountId).param("obj_param1", bottomMenu.name));
            return;
        }
        TiebaStatic.log(new StatisticItem("c13118").param("uid", currentAccountId));
    }

    public final void c(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f62459c.getLayoutParams();
        if (z) {
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.addRule(14, 0);
            layoutParams.bottomMargin = this.f62462f;
            layoutParams.rightMargin = this.f62463g;
            return;
        }
        layoutParams.addRule(11, 0);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        layoutParams.bottomMargin = this.f62464h;
        layoutParams.rightMargin = 0;
    }

    public void d(TbPageContext<?> tbPageContext, int i2) {
        if (this.f62460d.getVisibility() == 0) {
            this.f62460d.a(tbPageContext, i2);
        }
    }

    public void e(List<BottomMenu> list, ForumData forumData) {
        this.f62461e = forumData;
        boolean z = ListUtils.getCount(list) > 0;
        c(z);
        if (z) {
            this.f62460d.setVisibility(0);
            this.f62460d.b(list, this.f62457a);
            return;
        }
        this.f62460d.setVisibility(8);
    }

    public void f(boolean z) {
        this.f62460d.setVisibility(z ? 0 : 8);
    }
}
