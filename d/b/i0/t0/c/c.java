package d.b.i0.t0.c;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BuyTBeanActivityConfig;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.gift.myGiftList.MyGiftListActivity;
import d.b.b.a.d;
import d.b.b.e.p.j;
import d.b.b.e.p.l;
import d.b.h0.d0.h;
import d.b.h0.r.f0.f;
import d.b.h0.r.f0.g;
import d.b.i0.t0.c.a;
/* loaded from: classes4.dex */
public class c extends d<MyGiftListActivity> {
    public View.OnClickListener A;

    /* renamed from: a  reason: collision with root package name */
    public MyGiftListActivity f61057a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f61058b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f61059c;

    /* renamed from: d  reason: collision with root package name */
    public h f61060d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f61061e;

    /* renamed from: f  reason: collision with root package name */
    public View f61062f;

    /* renamed from: g  reason: collision with root package name */
    public View f61063g;

    /* renamed from: h  reason: collision with root package name */
    public View f61064h;
    public View i;
    public View j;
    public g k;
    public BdListView.p l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public LinearLayout r;
    public d.b.i0.t0.c.b s;
    public boolean t;
    public String u;
    public LinearLayout v;
    public View w;
    public TextView x;
    public ImageView y;
    public AdapterView.OnItemClickListener z;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.o();
            c.this.y();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AdapterView.OnItemClickListener {
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            a.C1581a item = c.this.s.getItem(i);
            if (item == null || item.f61031a <= 0 || StringUtils.isNull(item.f61032b)) {
                return;
            }
            if (c.this.t) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GiftTabActivityConfig(c.this.f61057a.getPageContext().getPageActivity(), item.f61031a, item.f61032b, item.k, GiftTabActivityConfig.FROM_PERSON_CENTER)));
            } else if (!j.z()) {
                c.this.f61057a.showToast(R.string.neterror);
            } else {
                c.this.f61057a.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(TbadkApplication.getInst().getContext(), String.valueOf(item.f61031a), item.f61032b)));
            }
        }
    }

    /* renamed from: d.b.i0.t0.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1583c implements View.OnClickListener {
        public View$OnClickListenerC1583c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == null) {
                return;
            }
            if (view != c.this.o) {
                if (view != c.this.q || StringUtils.isNull(c.this.u)) {
                    return;
                }
                UrlManager.getInstance().dealOneLink(c.this.f61057a.getPageContext(), new String[]{c.this.u});
            } else if (!l.C()) {
                UtilHelper.showToast(c.this.f61057a.getPageContext().getPageActivity(), c.this.f61057a.getResources().getString(R.string.neterror));
            } else {
                BuyTBeanActivityConfig buyTBeanActivityConfig = new BuyTBeanActivityConfig(c.this.f61057a.getPageContext().getPageActivity(), 0L);
                buyTBeanActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_MY_GIFT, MemberPayStatistic.CLICK_ZONE_OBTAIN_T);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, buyTBeanActivityConfig));
            }
        }
    }

    public c(MyGiftListActivity myGiftListActivity, BdListView.p pVar, boolean z) {
        super(myGiftListActivity.getPageContext());
        this.k = null;
        this.z = new b();
        this.A = new View$OnClickListenerC1583c();
        this.f61057a = myGiftListActivity;
        this.t = z;
        this.l = pVar;
        r();
        q();
        if (!this.t && TbadkApplication.getInst().isGiftSwitchOn()) {
            this.v.setVisibility(0);
        } else {
            this.v.setVisibility(8);
        }
    }

    public void k(NoNetworkView.b bVar) {
        this.f61059c.a(bVar);
    }

    public final SpannableString l(int i, long j, int i2) {
        String str = "[icon]" + StringHelper.formatOverBaiwanNum(j);
        SpannableString spannableString = new SpannableString(str);
        Drawable drawable = SkinManager.getDrawable(i);
        int g2 = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds30);
        if (i2 == 2) {
            drawable.setBounds(0, 3, g2, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds26));
        } else {
            drawable.setBounds(0, 0, g2, g2);
        }
        if (TbadkApplication.getInst().getSkinType() == 1) {
            drawable.setAlpha(179);
        } else {
            drawable.setAlpha(255);
        }
        d.b.h0.b1.d dVar = new d.b.h0.b1.d(drawable);
        dVar.c(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10));
        UtilHelper.setSpan(spannableString, str, "[icon]", dVar);
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(l.g(this.f61057a.getPageContext().getPageActivity(), R.dimen.fontsize22));
        UtilHelper.setSpan(spannableString, str, this.f61057a.getResources().getString(R.string.unit_wan), absoluteSizeSpan);
        UtilHelper.setSpan(spannableString, str, this.f61057a.getResources().getString(R.string.unit_yi), absoluteSizeSpan);
        return spannableString;
    }

    public void m() {
        this.f61061e.A(0L);
    }

    public View n() {
        return this.j;
    }

    public void o() {
        h hVar = this.f61060d;
        if (hVar != null) {
            hVar.dettachView(this.f61062f);
            this.f61060d = null;
            this.f61061e.setVisibility(0);
        }
    }

    public void onChangeSkinType(int i) {
        this.f61057a.getLayoutMode().k(i == 1);
        this.f61057a.getLayoutMode().j(this.f61062f);
        this.f61057a.getLayoutMode().j(this.f61063g);
        this.f61057a.getLayoutMode().j(this.f61064h);
        this.f61057a.getLayoutMode().j(this.i);
        this.f61058b.onChangeSkinType(getPageContext(), i);
        this.f61059c.c(this.f61057a.getPageContext(), i);
        this.k.I(i);
        d.b.i0.t0.c.b bVar = this.s;
        if (bVar != null) {
            bVar.notifyDataSetChanged();
        }
        SkinManager.setBackgroundColor(this.w, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.v, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.x, R.color.CAM_X0302);
        SkinManager.setImageResource(this.y, R.drawable.icon_gift_list);
    }

    public final void q() {
        this.v = (LinearLayout) this.f61057a.findViewById(R.id.gift_relation_ll);
        this.x = (TextView) this.f61057a.findViewById(R.id.gift_relation_text);
        this.v.setOnClickListener(this.f61057a.getSendGiftClickListener());
        this.w = this.f61057a.findViewById(R.id.gift_send_gift_top_line);
        this.y = (ImageView) this.f61057a.findViewById(R.id.gift_send_gift_icon);
    }

    public final void r() {
        this.f61057a.setContentView(R.layout.my_gift_list_activity);
        View findViewById = this.f61057a.findViewById(R.id.root);
        this.f61062f = findViewById;
        this.f61061e = (BdListView) findViewById.findViewById(R.id.list_view);
        NavigationBar navigationBar = (NavigationBar) this.f61062f.findViewById(R.id.navigation_bar);
        this.f61058b = navigationBar;
        MyGiftListActivity myGiftListActivity = this.f61057a;
        if (myGiftListActivity.userType == 1) {
            navigationBar.setCenterTextTitle(myGiftListActivity.getPageContext().getString(R.string.forum_gift_list));
        } else {
            String format = String.format(this.f61057a.getPageContext().getString(R.string.he_gift_title), myGiftListActivity.getUserSex());
            if (this.t) {
                this.f61058b.setCenterTextTitle(this.f61057a.getPageContext().getString(R.string.my_gift_list));
            } else {
                this.f61058b.setTitleText(format);
            }
        }
        this.f61058b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f61059c = (NoNetworkView) this.f61062f.findViewById(R.id.no_networkview);
        View inflate = LayoutInflater.from(this.f61057a.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_rank_head, (ViewGroup) null, false);
        this.f61064h = inflate;
        inflate.setVisibility(8);
        View inflate2 = LayoutInflater.from(this.f61057a.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_head, (ViewGroup) null, false);
        this.f61063g = inflate2;
        inflate2.setVisibility(8);
        this.r = (LinearLayout) this.f61063g.findViewById(R.id.view_link_info);
        this.m = (TextView) this.f61063g.findViewById(R.id.textview_gift_number);
        this.n = (TextView) this.f61063g.findViewById(R.id.textview_tdou_number);
        this.o = (TextView) this.f61063g.findViewById(R.id.view_get_tdou);
        this.p = (TextView) this.f61063g.findViewById(R.id.textview_blue_number);
        TextView textView = (TextView) this.f61063g.findViewById(R.id.view_get_blue);
        this.q = textView;
        textView.setOnClickListener(this.A);
        this.o.setOnClickListener(this.A);
        View inflate3 = LayoutInflater.from(this.f61057a.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_footer, (ViewGroup) null, false);
        this.i = inflate3;
        this.j = inflate3.findViewById(R.id.gift_footer_lay);
        if (this.t) {
            this.f61061e.addHeaderView(this.f61063g);
        } else {
            if (this.f61057a.userType == 1) {
                this.f61064h.setVisibility(0);
                this.f61061e.addHeaderView(this.f61064h);
            }
            if (TbadkApplication.getInst().isGiftSwitchOn()) {
                this.i.setPadding(0, 0, 0, l.g(this.f61057a.getPageContext().getPageActivity(), R.dimen.ds156));
            }
        }
        this.f61061e.addFooterView(this.i);
        d.b.i0.t0.c.b bVar = new d.b.i0.t0.c.b(this.f61057a, this.t);
        this.s = bVar;
        this.f61061e.setAdapter((ListAdapter) bVar);
        g gVar = new g(this.f61057a.getPageContext());
        this.k = gVar;
        this.f61061e.setPullRefresh(gVar);
        this.f61061e.setOnSrollToBottomListener(this.l);
        this.f61061e.setOnItemClickListener(this.z);
    }

    public final void s(d.b.i0.t0.c.a aVar) {
        if (aVar != null && this.t) {
            this.f61063g.setVisibility(0);
            String str = aVar.d().f61043b;
            String str2 = aVar.d().f61042a;
            this.u = aVar.f61030g.f50821b;
            this.m.setText(l(R.drawable.icon_gift_my_gift, aVar.b(), 0));
            this.n.setText(l(R.drawable.icon_gift_my_tdou, aVar.e(), 1));
            this.p.setText(l(R.drawable.icon_gift_bluedrill, aVar.f61029f, 2));
            this.q.setText(aVar.f61030g.f50820a);
            return;
        }
        this.f61063g.setVisibility(8);
    }

    public final void u(d.b.i0.t0.c.a aVar) {
        if (aVar != null && aVar.a() != null && aVar.a().size() > 0) {
            if (aVar.c() != null) {
                if (aVar.c().f61040b == 1) {
                    this.i.setVisibility(0);
                } else {
                    this.i.setVisibility(8);
                }
            }
            this.s.e(aVar.a());
            return;
        }
        this.i.setVisibility(8);
        this.v.setVisibility(8);
        this.s.e(null);
    }

    public void v(d.b.i0.t0.c.a aVar) {
        if (!this.t && TbadkApplication.getInst().isGiftSwitchOn()) {
            this.v.setVisibility(0);
        } else {
            this.v.setVisibility(8);
        }
        if (aVar != null) {
            TbadkCoreApplication.getInst().currentAccountTdouNum = aVar.e();
        }
        o();
        s(aVar);
        u(aVar);
    }

    public void w(f.g gVar) {
        this.k.b(gVar);
    }

    public void x(String str, boolean z) {
        if (this.f61060d == null) {
            this.f61060d = new h(this.mContext.getContext(), new a());
        }
        this.f61060d.j(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds280));
        this.f61060d.attachView(this.f61062f, z);
        this.f61060d.o();
        this.v.setVisibility(8);
        this.f61061e.setVisibility(8);
    }

    public void y() {
        this.f61061e.setVisibility(0);
        this.f61061e.F();
    }
}
