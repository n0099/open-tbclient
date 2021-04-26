package d.a.j0.j3.e;

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
    public BackgroundPreviewActivity f56154a;

    /* renamed from: b  reason: collision with root package name */
    public View f56155b;

    /* renamed from: c  reason: collision with root package name */
    public View f56156c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f56157d;

    /* renamed from: e  reason: collision with root package name */
    public i f56158e;

    /* renamed from: f  reason: collision with root package name */
    public BdExpandListView f56159f;

    /* renamed from: g  reason: collision with root package name */
    public g f56160g;

    /* renamed from: h  reason: collision with root package name */
    public SkinProgressView f56161h;

    /* renamed from: i  reason: collision with root package name */
    public DressItemData f56162i;
    public d j;
    public View.OnClickListener k = new a();
    public d.a.c.c.g.a l = new b(CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, 309022);

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == null || j.this.f56162i == null || j.this.j == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c10284"));
            if (j.this.f56162i.getInUse()) {
                d.a.i0.r.a0.b.e(j.this.f56154a.getPageContext().getPageActivity(), 8);
            } else {
                j.this.j.e(j.this.f56162i, true);
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
                    TiebaStatic.log(new StatisticItem("c10286").param("obj_id", j.this.f56162i.getPropsId()).param("obj_type", j.this.f56162i.getFreeUserLevel()));
                    j.this.f56162i.setInUse(true);
                    j.this.m();
                    d.a.i0.r.d0.b j = d.a.i0.r.d0.b.j();
                    j.v("current_used_personal_background_" + TbadkCoreApplication.getCurrentAccount(), j.this.f56162i.getPropsId());
                    return;
                }
                int i2 = d.a.j0.j3.c.f56071b;
                if (responsedMessage.getError() == d.a.j0.j3.c.f56072c) {
                    i2 = d.a.j0.j3.c.f56070a;
                }
                j.this.j.d(i2, responsedMessage.getErrorString(), j.this.f56162i, ((BackgroundSetRequestMessage) responsedMessage.getOrginalMessage().getExtra()).getFromDetail());
            }
        }
    }

    public j(BackgroundPreviewActivity backgroundPreviewActivity) {
        this.f56154a = backgroundPreviewActivity;
        View inflate = LayoutInflater.from(backgroundPreviewActivity.getPageContext().getPageActivity()).inflate(R.layout.background_preview, (ViewGroup) null);
        this.f56155b = inflate;
        this.f56154a.setContentView(inflate);
        this.f56156c = this.f56155b.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f56155b.findViewById(R.id.view_navigation_bar);
        this.f56157d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f56157d.showBottomLine(false);
        this.f56159f = (BdExpandListView) this.f56154a.findViewById(R.id.personcenter_list);
        this.f56161h = (SkinProgressView) this.f56155b.findViewById(R.id.view_bg_use);
        d dVar = new d(backgroundPreviewActivity.getPageContext(), this.f56154a.getUniqueId());
        this.j = dVar;
        dVar.c(this.f56154a.getFrom());
    }

    public void e() {
        SkinManager.setBackgroundColor(this.f56155b, R.color.CAM_X0204);
        this.f56154a.hideNetRefreshView(this.f56155b);
        this.f56156c.setVisibility(0);
    }

    public View f() {
        return this.f56155b;
    }

    public void g() {
        g gVar;
        d.a.i0.s0.a.a(this.f56154a.getPageContext(), this.f56155b);
        NavigationBar navigationBar = this.f56157d;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f56154a.getPageContext(), TbadkApplication.getInst().getSkinType());
            SkinManager.setBackgroundResource(this.f56157d, R.color.common_color_10262);
        }
        BdExpandListView bdExpandListView = this.f56159f;
        if (bdExpandListView == null || bdExpandListView.getVisibility() != 0 || (gVar = this.f56160g) == null) {
            return;
        }
        gVar.notifyDataSetChanged();
    }

    public void h() {
        MessageManager.getInstance().unRegisterListener(this.l);
    }

    public final void i() {
        d.a.j0.d3.d0.a.h(309022, BackgroundSetSocketResponseMessage.class, false, false);
        d.a.j0.d3.d0.a.c(309022, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, TbConfig.PERSONAL_BACKGROUND_SET, BackgroundSetHttpResponseMessage.class, false, false, false, false);
    }

    public void j(BdExpandListView.b bVar) {
        this.f56159f.setExpandListRefreshListener(bVar);
    }

    public void k() {
        this.f56156c.setVisibility(8);
        SkinManager.setBackgroundColor(this.f56155b, R.color.CAM_X0201);
        String string = this.f56154a.getPageContext().getResources().getString(R.string.no_data_text);
        this.f56154a.setNetRefreshViewTopMargin(m);
        this.f56154a.showNetRefreshView(this.f56155b, string, false);
    }

    public void l(DressItemData dressItemData) {
        this.f56162i = dressItemData;
        if (dressItemData == null) {
            k();
            return;
        }
        e();
        if (this.f56158e == null) {
            i iVar = new i(this.f56154a);
            this.f56158e = iVar;
            iVar.e(dressItemData);
            this.f56159f.addHeaderView(this.f56158e.b());
            this.f56158e.d();
            this.f56159f.setExpandView(this.f56158e.b(), this.f56154a.getResources().getDimensionPixelSize(R.dimen.ds400));
            g gVar = new g(this.f56154a.getPageContext(), dressItemData);
            this.f56160g = gVar;
            this.f56159f.setAdapter((ListAdapter) gVar);
            i();
            this.f56154a.registerListener(this.l);
        }
        this.f56161h.setDressData(this.f56162i);
        this.f56161h.setOnClickListener(this.k);
        m();
    }

    public final void m() {
        DressItemData dressItemData = this.f56162i;
        if (dressItemData == null) {
            return;
        }
        boolean inUse = dressItemData.getInUse();
        int activityFinish = this.f56162i.getActivityFinish();
        this.f56161h.setFontSize(l.g(this.f56154a.getPageContext().getPageActivity(), R.dimen.fontsize32));
        if (inUse) {
            this.f56161h.b(0, 0.0f, this.f56162i.getFreeUserLevel(), activityFinish, 2);
        } else {
            this.f56161h.b(9, 0.0f, this.f56162i.getFreeUserLevel(), activityFinish, 2);
        }
    }
}
