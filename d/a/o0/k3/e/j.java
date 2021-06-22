package d.a.o0.k3.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.widget.ListView.BdExpandListView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.SkinProgressView;
import com.baidu.tieba.themeCenter.background.BackgroundPreviewActivity;
import com.baidu.tieba.themeCenter.background.BackgroundSetHttpResponseMessage;
import com.baidu.tieba.themeCenter.background.BackgroundSetRequestMessage;
import com.baidu.tieba.themeCenter.background.BackgroundSetSocketResponseMessage;
import com.baidu.tieba.themeCenter.background.DressItemData;
import d.a.c.e.p.l;
/* loaded from: classes5.dex */
public class j {
    public static final int m = l.g(TbadkApplication.getInst().getContext(), R.dimen.ds320);

    /* renamed from: a  reason: collision with root package name */
    public BackgroundPreviewActivity f60855a;

    /* renamed from: b  reason: collision with root package name */
    public View f60856b;

    /* renamed from: c  reason: collision with root package name */
    public View f60857c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f60858d;

    /* renamed from: e  reason: collision with root package name */
    public i f60859e;

    /* renamed from: f  reason: collision with root package name */
    public BdExpandListView f60860f;

    /* renamed from: g  reason: collision with root package name */
    public g f60861g;

    /* renamed from: h  reason: collision with root package name */
    public SkinProgressView f60862h;

    /* renamed from: i  reason: collision with root package name */
    public DressItemData f60863i;
    public d j;
    public View.OnClickListener k = new a();
    public d.a.c.c.g.a l = new b(CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, 309022);

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == null || j.this.f60863i == null || j.this.j == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c10284"));
            if (j.this.f60863i.getInUse()) {
                d.a.n0.r.a0.b.e(j.this.f60855a.getPageContext().getPageActivity(), 8);
            } else {
                j.this.j.e(j.this.f60863i, true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends d.a.c.c.g.a {
        public b(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            if ((responsedMessage instanceof BackgroundSetHttpResponseMessage) || (responsedMessage instanceof BackgroundSetSocketResponseMessage)) {
                if (responsedMessage.getError() == 0) {
                    TiebaStatic.log(new StatisticItem("c10286").param("obj_id", j.this.f60863i.getPropsId()).param("obj_type", j.this.f60863i.getFreeUserLevel()));
                    j.this.f60863i.setInUse(true);
                    j.this.m();
                    d.a.n0.r.d0.b j = d.a.n0.r.d0.b.j();
                    j.v("current_used_personal_background_" + TbadkCoreApplication.getCurrentAccount(), j.this.f60863i.getPropsId());
                    return;
                }
                int i2 = d.a.o0.k3.c.f60772b;
                if (responsedMessage.getError() == d.a.o0.k3.c.f60773c) {
                    i2 = d.a.o0.k3.c.f60771a;
                }
                j.this.j.d(i2, responsedMessage.getErrorString(), j.this.f60863i, ((BackgroundSetRequestMessage) responsedMessage.getOrginalMessage().getExtra()).getFromDetail());
            }
        }
    }

    public j(BackgroundPreviewActivity backgroundPreviewActivity) {
        this.f60855a = backgroundPreviewActivity;
        View inflate = LayoutInflater.from(backgroundPreviewActivity.getPageContext().getPageActivity()).inflate(R.layout.background_preview, (ViewGroup) null);
        this.f60856b = inflate;
        this.f60855a.setContentView(inflate);
        this.f60857c = this.f60856b.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f60856b.findViewById(R.id.view_navigation_bar);
        this.f60858d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f60858d.showBottomLine(false);
        this.f60860f = (BdExpandListView) this.f60855a.findViewById(R.id.personcenter_list);
        this.f60862h = (SkinProgressView) this.f60856b.findViewById(R.id.view_bg_use);
        d dVar = new d(backgroundPreviewActivity.getPageContext(), this.f60855a.getUniqueId());
        this.j = dVar;
        dVar.c(this.f60855a.getFrom());
    }

    public void e() {
        SkinManager.setBackgroundColor(this.f60856b, R.color.CAM_X0204);
        this.f60855a.hideNetRefreshView(this.f60856b);
        this.f60857c.setVisibility(0);
    }

    public View f() {
        return this.f60856b;
    }

    public void g() {
        g gVar;
        d.a.n0.s0.a.a(this.f60855a.getPageContext(), this.f60856b);
        NavigationBar navigationBar = this.f60858d;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f60855a.getPageContext(), TbadkApplication.getInst().getSkinType());
            SkinManager.setBackgroundResource(this.f60858d, R.color.common_color_10262);
        }
        BdExpandListView bdExpandListView = this.f60860f;
        if (bdExpandListView == null || bdExpandListView.getVisibility() != 0 || (gVar = this.f60861g) == null) {
            return;
        }
        gVar.notifyDataSetChanged();
    }

    public void h() {
        MessageManager.getInstance().unRegisterListener(this.l);
    }

    public final void i() {
        d.a.o0.e3.d0.a.h(309022, BackgroundSetSocketResponseMessage.class, false, false);
        d.a.o0.e3.d0.a.c(309022, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, TbConfig.PERSONAL_BACKGROUND_SET, BackgroundSetHttpResponseMessage.class, false, false, false, false);
    }

    public void j(BdExpandListView.b bVar) {
        this.f60860f.setExpandListRefreshListener(bVar);
    }

    public void k() {
        this.f60857c.setVisibility(8);
        SkinManager.setBackgroundColor(this.f60856b, R.color.CAM_X0201);
        String string = this.f60855a.getPageContext().getResources().getString(R.string.no_data_text);
        this.f60855a.setNetRefreshViewTopMargin(m);
        this.f60855a.showNetRefreshView(this.f60856b, string, false);
    }

    public void l(DressItemData dressItemData) {
        this.f60863i = dressItemData;
        if (dressItemData == null) {
            k();
            return;
        }
        e();
        if (this.f60859e == null) {
            i iVar = new i(this.f60855a);
            this.f60859e = iVar;
            iVar.e(dressItemData);
            this.f60860f.addHeaderView(this.f60859e.b());
            this.f60859e.d();
            this.f60860f.setExpandView(this.f60859e.b(), this.f60855a.getResources().getDimensionPixelSize(R.dimen.ds400));
            g gVar = new g(this.f60855a.getPageContext(), dressItemData);
            this.f60861g = gVar;
            this.f60860f.setAdapter((ListAdapter) gVar);
            i();
            this.f60855a.registerListener(this.l);
        }
        this.f60862h.setDressData(this.f60863i);
        this.f60862h.setOnClickListener(this.k);
        m();
    }

    public final void m() {
        DressItemData dressItemData = this.f60863i;
        if (dressItemData == null) {
            return;
        }
        boolean inUse = dressItemData.getInUse();
        int activityFinish = this.f60863i.getActivityFinish();
        this.f60862h.setFontSize(l.g(this.f60855a.getPageContext().getPageActivity(), R.dimen.fontsize32));
        if (inUse) {
            this.f60862h.b(0, 0.0f, this.f60863i.getFreeUserLevel(), activityFinish, 2);
        } else {
            this.f60862h.b(9, 0.0f, this.f60863i.getFreeUserLevel(), activityFinish, 2);
        }
    }
}
