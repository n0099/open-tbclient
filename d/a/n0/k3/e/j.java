package d.a.n0.k3.e;

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
    public BackgroundPreviewActivity f57041a;

    /* renamed from: b  reason: collision with root package name */
    public View f57042b;

    /* renamed from: c  reason: collision with root package name */
    public View f57043c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f57044d;

    /* renamed from: e  reason: collision with root package name */
    public i f57045e;

    /* renamed from: f  reason: collision with root package name */
    public BdExpandListView f57046f;

    /* renamed from: g  reason: collision with root package name */
    public g f57047g;

    /* renamed from: h  reason: collision with root package name */
    public SkinProgressView f57048h;

    /* renamed from: i  reason: collision with root package name */
    public DressItemData f57049i;
    public d j;
    public View.OnClickListener k = new a();
    public d.a.c.c.g.a l = new b(CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, 309022);

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == null || j.this.f57049i == null || j.this.j == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c10284"));
            if (j.this.f57049i.getInUse()) {
                d.a.m0.r.a0.b.e(j.this.f57041a.getPageContext().getPageActivity(), 8);
            } else {
                j.this.j.e(j.this.f57049i, true);
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
                    TiebaStatic.log(new StatisticItem("c10286").param("obj_id", j.this.f57049i.getPropsId()).param("obj_type", j.this.f57049i.getFreeUserLevel()));
                    j.this.f57049i.setInUse(true);
                    j.this.m();
                    d.a.m0.r.d0.b j = d.a.m0.r.d0.b.j();
                    j.v("current_used_personal_background_" + TbadkCoreApplication.getCurrentAccount(), j.this.f57049i.getPropsId());
                    return;
                }
                int i2 = d.a.n0.k3.c.f56958b;
                if (responsedMessage.getError() == d.a.n0.k3.c.f56959c) {
                    i2 = d.a.n0.k3.c.f56957a;
                }
                j.this.j.d(i2, responsedMessage.getErrorString(), j.this.f57049i, ((BackgroundSetRequestMessage) responsedMessage.getOrginalMessage().getExtra()).getFromDetail());
            }
        }
    }

    public j(BackgroundPreviewActivity backgroundPreviewActivity) {
        this.f57041a = backgroundPreviewActivity;
        View inflate = LayoutInflater.from(backgroundPreviewActivity.getPageContext().getPageActivity()).inflate(R.layout.background_preview, (ViewGroup) null);
        this.f57042b = inflate;
        this.f57041a.setContentView(inflate);
        this.f57043c = this.f57042b.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f57042b.findViewById(R.id.view_navigation_bar);
        this.f57044d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f57044d.showBottomLine(false);
        this.f57046f = (BdExpandListView) this.f57041a.findViewById(R.id.personcenter_list);
        this.f57048h = (SkinProgressView) this.f57042b.findViewById(R.id.view_bg_use);
        d dVar = new d(backgroundPreviewActivity.getPageContext(), this.f57041a.getUniqueId());
        this.j = dVar;
        dVar.c(this.f57041a.getFrom());
    }

    public void e() {
        SkinManager.setBackgroundColor(this.f57042b, R.color.CAM_X0204);
        this.f57041a.hideNetRefreshView(this.f57042b);
        this.f57043c.setVisibility(0);
    }

    public View f() {
        return this.f57042b;
    }

    public void g() {
        g gVar;
        d.a.m0.s0.a.a(this.f57041a.getPageContext(), this.f57042b);
        NavigationBar navigationBar = this.f57044d;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f57041a.getPageContext(), TbadkApplication.getInst().getSkinType());
            SkinManager.setBackgroundResource(this.f57044d, R.color.common_color_10262);
        }
        BdExpandListView bdExpandListView = this.f57046f;
        if (bdExpandListView == null || bdExpandListView.getVisibility() != 0 || (gVar = this.f57047g) == null) {
            return;
        }
        gVar.notifyDataSetChanged();
    }

    public void h() {
        MessageManager.getInstance().unRegisterListener(this.l);
    }

    public final void i() {
        d.a.n0.e3.d0.a.h(309022, BackgroundSetSocketResponseMessage.class, false, false);
        d.a.n0.e3.d0.a.c(309022, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, TbConfig.PERSONAL_BACKGROUND_SET, BackgroundSetHttpResponseMessage.class, false, false, false, false);
    }

    public void j(BdExpandListView.b bVar) {
        this.f57046f.setExpandListRefreshListener(bVar);
    }

    public void k() {
        this.f57043c.setVisibility(8);
        SkinManager.setBackgroundColor(this.f57042b, R.color.CAM_X0201);
        String string = this.f57041a.getPageContext().getResources().getString(R.string.no_data_text);
        this.f57041a.setNetRefreshViewTopMargin(m);
        this.f57041a.showNetRefreshView(this.f57042b, string, false);
    }

    public void l(DressItemData dressItemData) {
        this.f57049i = dressItemData;
        if (dressItemData == null) {
            k();
            return;
        }
        e();
        if (this.f57045e == null) {
            i iVar = new i(this.f57041a);
            this.f57045e = iVar;
            iVar.e(dressItemData);
            this.f57046f.addHeaderView(this.f57045e.b());
            this.f57045e.d();
            this.f57046f.setExpandView(this.f57045e.b(), this.f57041a.getResources().getDimensionPixelSize(R.dimen.ds400));
            g gVar = new g(this.f57041a.getPageContext(), dressItemData);
            this.f57047g = gVar;
            this.f57046f.setAdapter((ListAdapter) gVar);
            i();
            this.f57041a.registerListener(this.l);
        }
        this.f57048h.setDressData(this.f57049i);
        this.f57048h.setOnClickListener(this.k);
        m();
    }

    public final void m() {
        DressItemData dressItemData = this.f57049i;
        if (dressItemData == null) {
            return;
        }
        boolean inUse = dressItemData.getInUse();
        int activityFinish = this.f57049i.getActivityFinish();
        this.f57048h.setFontSize(l.g(this.f57041a.getPageContext().getPageActivity(), R.dimen.fontsize32));
        if (inUse) {
            this.f57048h.b(0, 0.0f, this.f57049i.getFreeUserLevel(), activityFinish, 2);
        } else {
            this.f57048h.b(9, 0.0f, this.f57049i.getFreeUserLevel(), activityFinish, 2);
        }
    }
}
