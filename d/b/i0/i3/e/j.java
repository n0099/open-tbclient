package d.b.i0.i3.e;

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
import d.b.b.e.p.l;
/* loaded from: classes5.dex */
public class j {
    public static final int m = l.g(TbadkApplication.getInst().getContext(), R.dimen.ds320);

    /* renamed from: a  reason: collision with root package name */
    public BackgroundPreviewActivity f56297a;

    /* renamed from: b  reason: collision with root package name */
    public View f56298b;

    /* renamed from: c  reason: collision with root package name */
    public View f56299c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f56300d;

    /* renamed from: e  reason: collision with root package name */
    public i f56301e;

    /* renamed from: f  reason: collision with root package name */
    public BdExpandListView f56302f;

    /* renamed from: g  reason: collision with root package name */
    public g f56303g;

    /* renamed from: h  reason: collision with root package name */
    public SkinProgressView f56304h;
    public DressItemData i;
    public d j;
    public View.OnClickListener k = new a();
    public d.b.b.c.g.a l = new b(CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, 309022);

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == null || j.this.i == null || j.this.j == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c10284"));
            if (j.this.i.getInUse()) {
                d.b.h0.r.a0.b.e(j.this.f56297a.getPageContext().getPageActivity(), 8);
            } else {
                j.this.j.e(j.this.i, true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends d.b.b.c.g.a {
        public b(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            if ((responsedMessage instanceof BackgroundSetHttpResponseMessage) || (responsedMessage instanceof BackgroundSetSocketResponseMessage)) {
                if (responsedMessage.getError() == 0) {
                    TiebaStatic.log(new StatisticItem("c10286").param("obj_id", j.this.i.getPropsId()).param("obj_type", j.this.i.getFreeUserLevel()));
                    j.this.i.setInUse(true);
                    j.this.m();
                    d.b.h0.r.d0.b i = d.b.h0.r.d0.b.i();
                    i.u("current_used_personal_background_" + TbadkCoreApplication.getCurrentAccount(), j.this.i.getPropsId());
                    return;
                }
                int i2 = d.b.i0.i3.c.f56219b;
                if (responsedMessage.getError() == d.b.i0.i3.c.f56220c) {
                    i2 = d.b.i0.i3.c.f56218a;
                }
                j.this.j.d(i2, responsedMessage.getErrorString(), j.this.i, ((BackgroundSetRequestMessage) responsedMessage.getOrginalMessage().getExtra()).getFromDetail());
            }
        }
    }

    public j(BackgroundPreviewActivity backgroundPreviewActivity) {
        this.f56297a = backgroundPreviewActivity;
        View inflate = LayoutInflater.from(backgroundPreviewActivity.getPageContext().getPageActivity()).inflate(R.layout.background_preview, (ViewGroup) null);
        this.f56298b = inflate;
        this.f56297a.setContentView(inflate);
        this.f56299c = this.f56298b.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f56298b.findViewById(R.id.view_navigation_bar);
        this.f56300d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f56300d.showBottomLine(false);
        this.f56302f = (BdExpandListView) this.f56297a.findViewById(R.id.personcenter_list);
        this.f56304h = (SkinProgressView) this.f56298b.findViewById(R.id.view_bg_use);
        d dVar = new d(backgroundPreviewActivity.getPageContext(), this.f56297a.getUniqueId());
        this.j = dVar;
        dVar.c(this.f56297a.getFrom());
    }

    public void e() {
        SkinManager.setBackgroundColor(this.f56298b, R.color.CAM_X0204);
        this.f56297a.hideNetRefreshView(this.f56298b);
        this.f56299c.setVisibility(0);
    }

    public View f() {
        return this.f56298b;
    }

    public void g() {
        g gVar;
        d.b.h0.s0.a.a(this.f56297a.getPageContext(), this.f56298b);
        NavigationBar navigationBar = this.f56300d;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f56297a.getPageContext(), TbadkApplication.getInst().getSkinType());
            SkinManager.setBackgroundResource(this.f56300d, R.color.common_color_10262);
        }
        BdExpandListView bdExpandListView = this.f56302f;
        if (bdExpandListView == null || bdExpandListView.getVisibility() != 0 || (gVar = this.f56303g) == null) {
            return;
        }
        gVar.notifyDataSetChanged();
    }

    public void h() {
        MessageManager.getInstance().unRegisterListener(this.l);
    }

    public final void i() {
        d.b.i0.c3.d0.a.h(309022, BackgroundSetSocketResponseMessage.class, false, false);
        d.b.i0.c3.d0.a.c(309022, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, TbConfig.PERSONAL_BACKGROUND_SET, BackgroundSetHttpResponseMessage.class, false, false, false, false);
    }

    public void j(BdExpandListView.b bVar) {
        this.f56302f.setExpandListRefreshListener(bVar);
    }

    public void k() {
        this.f56299c.setVisibility(8);
        SkinManager.setBackgroundColor(this.f56298b, R.color.CAM_X0201);
        String string = this.f56297a.getPageContext().getResources().getString(R.string.no_data_text);
        this.f56297a.setNetRefreshViewTopMargin(m);
        this.f56297a.showNetRefreshView(this.f56298b, string, false);
    }

    public void l(DressItemData dressItemData) {
        this.i = dressItemData;
        if (dressItemData == null) {
            k();
            return;
        }
        e();
        if (this.f56301e == null) {
            i iVar = new i(this.f56297a);
            this.f56301e = iVar;
            iVar.e(dressItemData);
            this.f56302f.addHeaderView(this.f56301e.b());
            this.f56301e.d();
            this.f56302f.setExpandView(this.f56301e.b(), this.f56297a.getResources().getDimensionPixelSize(R.dimen.ds400));
            g gVar = new g(this.f56297a.getPageContext(), dressItemData);
            this.f56303g = gVar;
            this.f56302f.setAdapter((ListAdapter) gVar);
            i();
            this.f56297a.registerListener(this.l);
        }
        this.f56304h.setDressData(this.i);
        this.f56304h.setOnClickListener(this.k);
        m();
    }

    public final void m() {
        DressItemData dressItemData = this.i;
        if (dressItemData == null) {
            return;
        }
        boolean inUse = dressItemData.getInUse();
        int activityFinish = this.i.getActivityFinish();
        this.f56304h.setFontSize(l.g(this.f56297a.getPageContext().getPageActivity(), R.dimen.fontsize32));
        if (inUse) {
            this.f56304h.b(0, 0.0f, this.i.getFreeUserLevel(), activityFinish, 2);
        } else {
            this.f56304h.b(9, 0.0f, this.i.getFreeUserLevel(), activityFinish, 2);
        }
    }
}
