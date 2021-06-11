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
    public BackgroundPreviewActivity f60730a;

    /* renamed from: b  reason: collision with root package name */
    public View f60731b;

    /* renamed from: c  reason: collision with root package name */
    public View f60732c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f60733d;

    /* renamed from: e  reason: collision with root package name */
    public i f60734e;

    /* renamed from: f  reason: collision with root package name */
    public BdExpandListView f60735f;

    /* renamed from: g  reason: collision with root package name */
    public g f60736g;

    /* renamed from: h  reason: collision with root package name */
    public SkinProgressView f60737h;

    /* renamed from: i  reason: collision with root package name */
    public DressItemData f60738i;
    public d j;
    public View.OnClickListener k = new a();
    public d.a.c.c.g.a l = new b(CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, 309022);

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == null || j.this.f60738i == null || j.this.j == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c10284"));
            if (j.this.f60738i.getInUse()) {
                d.a.m0.r.a0.b.e(j.this.f60730a.getPageContext().getPageActivity(), 8);
            } else {
                j.this.j.e(j.this.f60738i, true);
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
                    TiebaStatic.log(new StatisticItem("c10286").param("obj_id", j.this.f60738i.getPropsId()).param("obj_type", j.this.f60738i.getFreeUserLevel()));
                    j.this.f60738i.setInUse(true);
                    j.this.m();
                    d.a.m0.r.d0.b j = d.a.m0.r.d0.b.j();
                    j.v("current_used_personal_background_" + TbadkCoreApplication.getCurrentAccount(), j.this.f60738i.getPropsId());
                    return;
                }
                int i2 = d.a.n0.k3.c.f60647b;
                if (responsedMessage.getError() == d.a.n0.k3.c.f60648c) {
                    i2 = d.a.n0.k3.c.f60646a;
                }
                j.this.j.d(i2, responsedMessage.getErrorString(), j.this.f60738i, ((BackgroundSetRequestMessage) responsedMessage.getOrginalMessage().getExtra()).getFromDetail());
            }
        }
    }

    public j(BackgroundPreviewActivity backgroundPreviewActivity) {
        this.f60730a = backgroundPreviewActivity;
        View inflate = LayoutInflater.from(backgroundPreviewActivity.getPageContext().getPageActivity()).inflate(R.layout.background_preview, (ViewGroup) null);
        this.f60731b = inflate;
        this.f60730a.setContentView(inflate);
        this.f60732c = this.f60731b.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f60731b.findViewById(R.id.view_navigation_bar);
        this.f60733d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f60733d.showBottomLine(false);
        this.f60735f = (BdExpandListView) this.f60730a.findViewById(R.id.personcenter_list);
        this.f60737h = (SkinProgressView) this.f60731b.findViewById(R.id.view_bg_use);
        d dVar = new d(backgroundPreviewActivity.getPageContext(), this.f60730a.getUniqueId());
        this.j = dVar;
        dVar.c(this.f60730a.getFrom());
    }

    public void e() {
        SkinManager.setBackgroundColor(this.f60731b, R.color.CAM_X0204);
        this.f60730a.hideNetRefreshView(this.f60731b);
        this.f60732c.setVisibility(0);
    }

    public View f() {
        return this.f60731b;
    }

    public void g() {
        g gVar;
        d.a.m0.s0.a.a(this.f60730a.getPageContext(), this.f60731b);
        NavigationBar navigationBar = this.f60733d;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f60730a.getPageContext(), TbadkApplication.getInst().getSkinType());
            SkinManager.setBackgroundResource(this.f60733d, R.color.common_color_10262);
        }
        BdExpandListView bdExpandListView = this.f60735f;
        if (bdExpandListView == null || bdExpandListView.getVisibility() != 0 || (gVar = this.f60736g) == null) {
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
        this.f60735f.setExpandListRefreshListener(bVar);
    }

    public void k() {
        this.f60732c.setVisibility(8);
        SkinManager.setBackgroundColor(this.f60731b, R.color.CAM_X0201);
        String string = this.f60730a.getPageContext().getResources().getString(R.string.no_data_text);
        this.f60730a.setNetRefreshViewTopMargin(m);
        this.f60730a.showNetRefreshView(this.f60731b, string, false);
    }

    public void l(DressItemData dressItemData) {
        this.f60738i = dressItemData;
        if (dressItemData == null) {
            k();
            return;
        }
        e();
        if (this.f60734e == null) {
            i iVar = new i(this.f60730a);
            this.f60734e = iVar;
            iVar.e(dressItemData);
            this.f60735f.addHeaderView(this.f60734e.b());
            this.f60734e.d();
            this.f60735f.setExpandView(this.f60734e.b(), this.f60730a.getResources().getDimensionPixelSize(R.dimen.ds400));
            g gVar = new g(this.f60730a.getPageContext(), dressItemData);
            this.f60736g = gVar;
            this.f60735f.setAdapter((ListAdapter) gVar);
            i();
            this.f60730a.registerListener(this.l);
        }
        this.f60737h.setDressData(this.f60738i);
        this.f60737h.setOnClickListener(this.k);
        m();
    }

    public final void m() {
        DressItemData dressItemData = this.f60738i;
        if (dressItemData == null) {
            return;
        }
        boolean inUse = dressItemData.getInUse();
        int activityFinish = this.f60738i.getActivityFinish();
        this.f60737h.setFontSize(l.g(this.f60730a.getPageContext().getPageActivity(), R.dimen.fontsize32));
        if (inUse) {
            this.f60737h.b(0, 0.0f, this.f60738i.getFreeUserLevel(), activityFinish, 2);
        } else {
            this.f60737h.b(9, 0.0f, this.f60738i.getFreeUserLevel(), activityFinish, 2);
        }
    }
}
