package d.b.j0.j3.e;

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
import d.b.c.e.p.l;
/* loaded from: classes5.dex */
public class j {
    public static final int m = l.g(TbadkApplication.getInst().getContext(), R.dimen.ds320);

    /* renamed from: a  reason: collision with root package name */
    public BackgroundPreviewActivity f58166a;

    /* renamed from: b  reason: collision with root package name */
    public View f58167b;

    /* renamed from: c  reason: collision with root package name */
    public View f58168c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f58169d;

    /* renamed from: e  reason: collision with root package name */
    public i f58170e;

    /* renamed from: f  reason: collision with root package name */
    public BdExpandListView f58171f;

    /* renamed from: g  reason: collision with root package name */
    public g f58172g;

    /* renamed from: h  reason: collision with root package name */
    public SkinProgressView f58173h;
    public DressItemData i;
    public d j;
    public View.OnClickListener k = new a();
    public d.b.c.c.g.a l = new b(CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, 309022);

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
                d.b.i0.r.a0.b.e(j.this.f58166a.getPageContext().getPageActivity(), 8);
            } else {
                j.this.j.e(j.this.i, true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends d.b.c.c.g.a {
        public b(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            if ((responsedMessage instanceof BackgroundSetHttpResponseMessage) || (responsedMessage instanceof BackgroundSetSocketResponseMessage)) {
                if (responsedMessage.getError() == 0) {
                    TiebaStatic.log(new StatisticItem("c10286").param("obj_id", j.this.i.getPropsId()).param("obj_type", j.this.i.getFreeUserLevel()));
                    j.this.i.setInUse(true);
                    j.this.m();
                    d.b.i0.r.d0.b j = d.b.i0.r.d0.b.j();
                    j.v("current_used_personal_background_" + TbadkCoreApplication.getCurrentAccount(), j.this.i.getPropsId());
                    return;
                }
                int i = d.b.j0.j3.c.f58088b;
                if (responsedMessage.getError() == d.b.j0.j3.c.f58089c) {
                    i = d.b.j0.j3.c.f58087a;
                }
                j.this.j.d(i, responsedMessage.getErrorString(), j.this.i, ((BackgroundSetRequestMessage) responsedMessage.getOrginalMessage().getExtra()).getFromDetail());
            }
        }
    }

    public j(BackgroundPreviewActivity backgroundPreviewActivity) {
        this.f58166a = backgroundPreviewActivity;
        View inflate = LayoutInflater.from(backgroundPreviewActivity.getPageContext().getPageActivity()).inflate(R.layout.background_preview, (ViewGroup) null);
        this.f58167b = inflate;
        this.f58166a.setContentView(inflate);
        this.f58168c = this.f58167b.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f58167b.findViewById(R.id.view_navigation_bar);
        this.f58169d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f58169d.showBottomLine(false);
        this.f58171f = (BdExpandListView) this.f58166a.findViewById(R.id.personcenter_list);
        this.f58173h = (SkinProgressView) this.f58167b.findViewById(R.id.view_bg_use);
        d dVar = new d(backgroundPreviewActivity.getPageContext(), this.f58166a.getUniqueId());
        this.j = dVar;
        dVar.c(this.f58166a.getFrom());
    }

    public void e() {
        SkinManager.setBackgroundColor(this.f58167b, R.color.CAM_X0204);
        this.f58166a.hideNetRefreshView(this.f58167b);
        this.f58168c.setVisibility(0);
    }

    public View f() {
        return this.f58167b;
    }

    public void g() {
        g gVar;
        d.b.i0.s0.a.a(this.f58166a.getPageContext(), this.f58167b);
        NavigationBar navigationBar = this.f58169d;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f58166a.getPageContext(), TbadkApplication.getInst().getSkinType());
            SkinManager.setBackgroundResource(this.f58169d, R.color.common_color_10262);
        }
        BdExpandListView bdExpandListView = this.f58171f;
        if (bdExpandListView == null || bdExpandListView.getVisibility() != 0 || (gVar = this.f58172g) == null) {
            return;
        }
        gVar.notifyDataSetChanged();
    }

    public void h() {
        MessageManager.getInstance().unRegisterListener(this.l);
    }

    public final void i() {
        d.b.j0.d3.d0.a.h(309022, BackgroundSetSocketResponseMessage.class, false, false);
        d.b.j0.d3.d0.a.c(309022, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, TbConfig.PERSONAL_BACKGROUND_SET, BackgroundSetHttpResponseMessage.class, false, false, false, false);
    }

    public void j(BdExpandListView.b bVar) {
        this.f58171f.setExpandListRefreshListener(bVar);
    }

    public void k() {
        this.f58168c.setVisibility(8);
        SkinManager.setBackgroundColor(this.f58167b, R.color.CAM_X0201);
        String string = this.f58166a.getPageContext().getResources().getString(R.string.no_data_text);
        this.f58166a.setNetRefreshViewTopMargin(m);
        this.f58166a.showNetRefreshView(this.f58167b, string, false);
    }

    public void l(DressItemData dressItemData) {
        this.i = dressItemData;
        if (dressItemData == null) {
            k();
            return;
        }
        e();
        if (this.f58170e == null) {
            i iVar = new i(this.f58166a);
            this.f58170e = iVar;
            iVar.e(dressItemData);
            this.f58171f.addHeaderView(this.f58170e.b());
            this.f58170e.d();
            this.f58171f.setExpandView(this.f58170e.b(), this.f58166a.getResources().getDimensionPixelSize(R.dimen.ds400));
            g gVar = new g(this.f58166a.getPageContext(), dressItemData);
            this.f58172g = gVar;
            this.f58171f.setAdapter((ListAdapter) gVar);
            i();
            this.f58166a.registerListener(this.l);
        }
        this.f58173h.setDressData(this.i);
        this.f58173h.setOnClickListener(this.k);
        m();
    }

    public final void m() {
        DressItemData dressItemData = this.i;
        if (dressItemData == null) {
            return;
        }
        boolean inUse = dressItemData.getInUse();
        int activityFinish = this.i.getActivityFinish();
        this.f58173h.setFontSize(l.g(this.f58166a.getPageContext().getPageActivity(), R.dimen.fontsize32));
        if (inUse) {
            this.f58173h.b(0, 0.0f, this.i.getFreeUserLevel(), activityFinish, 2);
        } else {
            this.f58173h.b(9, 0.0f, this.i.getFreeUserLevel(), activityFinish, 2);
        }
    }
}
