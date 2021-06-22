package d.a.o0.v0.c;

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
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.gift.myGiftList.MyGiftListActivity;
import com.baidu.tieba.wallet.CurrencyHelper;
import com.baidu.tieba.wallet.CurrencyJumpHelper;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import d.a.c.a.d;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.n0.d0.h;
import d.a.n0.r.f0.f;
import d.a.n0.r.f0.g;
import d.a.o0.v0.c.a;
/* loaded from: classes4.dex */
public class c extends d<MyGiftListActivity> {
    public AdapterView.OnItemClickListener A;
    public View.OnClickListener B;

    /* renamed from: a  reason: collision with root package name */
    public MyGiftListActivity f66104a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f66105b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f66106c;

    /* renamed from: d  reason: collision with root package name */
    public h f66107d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f66108e;

    /* renamed from: f  reason: collision with root package name */
    public View f66109f;

    /* renamed from: g  reason: collision with root package name */
    public View f66110g;

    /* renamed from: h  reason: collision with root package name */
    public View f66111h;

    /* renamed from: i  reason: collision with root package name */
    public View f66112i;
    public View j;
    public g k;
    public BdListView.p l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public TextView r;
    public LinearLayout s;
    public d.a.o0.v0.c.b t;
    public boolean u;
    public String v;
    public LinearLayout w;
    public View x;
    public TextView y;
    public ImageView z;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.o();
            c.this.w();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AdapterView.OnItemClickListener {
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            a.C1744a item = c.this.t.getItem(i2);
            if (item == null || item.f66075a <= 0 || StringUtils.isNull(item.f66076b)) {
                return;
            }
            if (c.this.u) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GiftTabActivityConfig(c.this.f66104a.getPageContext().getPageActivity(), item.f66075a, item.f66076b, item.k, GiftTabActivityConfig.FROM_PERSON_CENTER)));
            } else if (!j.z()) {
                c.this.f66104a.showToast(R.string.neterror);
            } else {
                c.this.f66104a.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(TbadkApplication.getInst().getContext(), String.valueOf(item.f66075a), item.f66076b)));
            }
        }
    }

    /* renamed from: d.a.o0.v0.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1746c implements View.OnClickListener {
        public View$OnClickListenerC1746c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == null) {
                return;
            }
            if (view != c.this.o) {
                if (view != c.this.r || StringUtils.isNull(c.this.v)) {
                    return;
                }
                UrlManager.getInstance().dealOneLink(c.this.f66104a.getPageContext(), new String[]{c.this.v});
            } else if (l.D()) {
                CurrencyJumpHelper.buyGiftGotoBuyTBeanPage(c.this.f66104a.getPageContext().getPageActivity());
            } else {
                UtilHelper.showToast(c.this.f66104a.getPageContext().getPageActivity(), c.this.f66104a.getResources().getString(R.string.neterror));
            }
        }
    }

    public c(MyGiftListActivity myGiftListActivity, BdListView.p pVar, boolean z) {
        super(myGiftListActivity.getPageContext());
        this.k = null;
        this.A = new b();
        this.B = new View$OnClickListenerC1746c();
        this.f66104a = myGiftListActivity;
        this.u = z;
        this.l = pVar;
        q();
        p();
        if (!this.u && TbadkApplication.getInst().isGiftSwitchOn()) {
            this.w.setVisibility(0);
        } else {
            this.w.setVisibility(8);
        }
    }

    public void k(NoNetworkView.b bVar) {
        this.f66106c.a(bVar);
    }

    public final SpannableString l(int i2, String str, int i3) {
        String str2 = "[icon]" + str;
        SpannableString spannableString = new SpannableString(str2);
        Drawable drawable = SkinManager.getDrawable(i2);
        int g2 = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds30);
        if (i3 == 2) {
            drawable.setBounds(0, 3, g2, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds26));
        } else {
            drawable.setBounds(0, 0, g2, g2);
        }
        if (TbadkApplication.getInst().getSkinType() == 1) {
            drawable.setAlpha(179);
        } else {
            drawable.setAlpha(255);
        }
        d.a.n0.b1.d dVar = new d.a.n0.b1.d(drawable);
        dVar.c(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10));
        UtilHelper.setSpan(spannableString, str2, "[icon]", dVar);
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(l.g(this.f66104a.getPageContext().getPageActivity(), R.dimen.fontsize22));
        UtilHelper.setSpan(spannableString, str2, this.f66104a.getResources().getString(R.string.unit_wan), absoluteSizeSpan);
        UtilHelper.setSpan(spannableString, str2, this.f66104a.getResources().getString(R.string.unit_yi), absoluteSizeSpan);
        return spannableString;
    }

    public void m() {
        this.f66108e.A(0L);
    }

    public View n() {
        return this.j;
    }

    public void o() {
        h hVar = this.f66107d;
        if (hVar != null) {
            hVar.dettachView(this.f66109f);
            this.f66107d = null;
            this.f66108e.setVisibility(0);
        }
    }

    public void onChangeSkinType(int i2) {
        this.f66104a.getLayoutMode().k(i2 == 1);
        this.f66104a.getLayoutMode().j(this.f66109f);
        this.f66104a.getLayoutMode().j(this.f66110g);
        this.f66104a.getLayoutMode().j(this.f66111h);
        this.f66104a.getLayoutMode().j(this.f66112i);
        this.f66105b.onChangeSkinType(getPageContext(), i2);
        this.f66106c.c(this.f66104a.getPageContext(), i2);
        this.k.I(i2);
        d.a.o0.v0.c.b bVar = this.t;
        if (bVar != null) {
            bVar.notifyDataSetChanged();
        }
        SkinManager.setBackgroundColor(this.x, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.w, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.y, R.color.CAM_X0302);
        SkinManager.setImageResource(this.z, R.drawable.icon_gift_list);
    }

    public final void p() {
        this.w = (LinearLayout) this.f66104a.findViewById(R.id.gift_relation_ll);
        this.y = (TextView) this.f66104a.findViewById(R.id.gift_relation_text);
        this.w.setOnClickListener(this.f66104a.getSendGiftClickListener());
        this.x = this.f66104a.findViewById(R.id.gift_send_gift_top_line);
        this.z = (ImageView) this.f66104a.findViewById(R.id.gift_send_gift_icon);
    }

    public final void q() {
        this.f66104a.setContentView(R.layout.my_gift_list_activity);
        View findViewById = this.f66104a.findViewById(R.id.root);
        this.f66109f = findViewById;
        this.f66108e = (BdListView) findViewById.findViewById(R.id.list_view);
        NavigationBar navigationBar = (NavigationBar) this.f66109f.findViewById(R.id.navigation_bar);
        this.f66105b = navigationBar;
        MyGiftListActivity myGiftListActivity = this.f66104a;
        if (myGiftListActivity.userType == 1) {
            navigationBar.setCenterTextTitle(myGiftListActivity.getPageContext().getString(R.string.forum_gift_list));
        } else {
            String format = String.format(this.f66104a.getPageContext().getString(R.string.he_gift_title), myGiftListActivity.getUserSex());
            if (this.u) {
                this.f66105b.setCenterTextTitle(this.f66104a.getPageContext().getString(R.string.my_gift_list));
            } else {
                this.f66105b.setTitleText(format);
            }
        }
        this.f66105b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f66106c = (NoNetworkView) this.f66109f.findViewById(R.id.no_networkview);
        View inflate = LayoutInflater.from(this.f66104a.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_rank_head, (ViewGroup) null, false);
        this.f66111h = inflate;
        inflate.setVisibility(8);
        View inflate2 = LayoutInflater.from(this.f66104a.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_head, (ViewGroup) null, false);
        this.f66110g = inflate2;
        inflate2.setVisibility(8);
        this.s = (LinearLayout) this.f66110g.findViewById(R.id.view_link_info);
        this.m = (TextView) this.f66110g.findViewById(R.id.textview_gift_number);
        this.n = (TextView) this.f66110g.findViewById(R.id.textview_tdou_number);
        this.p = (TextView) this.f66110g.findViewById(R.id.textview_tdou_number_title);
        this.o = (TextView) this.f66110g.findViewById(R.id.view_get_tdou);
        if (CurrencySwitchUtil.isYyIsConvert()) {
            this.p.setText(R.string.my_ybean);
            this.o.setText(R.string.get_ybean);
        } else {
            this.p.setText(R.string.my_tdou);
            this.o.setText(R.string.get_tdou);
        }
        this.q = (TextView) this.f66110g.findViewById(R.id.textview_blue_number);
        TextView textView = (TextView) this.f66110g.findViewById(R.id.view_get_blue);
        this.r = textView;
        textView.setOnClickListener(this.B);
        this.o.setOnClickListener(this.B);
        View inflate3 = LayoutInflater.from(this.f66104a.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_footer, (ViewGroup) null, false);
        this.f66112i = inflate3;
        this.j = inflate3.findViewById(R.id.gift_footer_lay);
        if (this.u) {
            this.f66108e.addHeaderView(this.f66110g);
        } else {
            if (this.f66104a.userType == 1) {
                this.f66111h.setVisibility(0);
                this.f66108e.addHeaderView(this.f66111h);
            }
            if (TbadkApplication.getInst().isGiftSwitchOn()) {
                this.f66112i.setPadding(0, 0, 0, l.g(this.f66104a.getPageContext().getPageActivity(), R.dimen.ds156));
            }
        }
        this.f66108e.addFooterView(this.f66112i);
        d.a.o0.v0.c.b bVar = new d.a.o0.v0.c.b(this.f66104a, this.u);
        this.t = bVar;
        this.f66108e.setAdapter((ListAdapter) bVar);
        g gVar = new g(this.f66104a.getPageContext());
        this.k = gVar;
        this.f66108e.setPullRefresh(gVar);
        this.f66108e.setOnSrollToBottomListener(this.l);
        this.f66108e.setOnItemClickListener(this.A);
    }

    public final void r(d.a.o0.v0.c.a aVar) {
        String formatOverBaiwanNum;
        if (aVar != null && this.u) {
            this.f66110g.setVisibility(0);
            String str = aVar.d().f66088b;
            String str2 = aVar.d().f66087a;
            this.v = aVar.f66073g.f53840b;
            this.m.setText(l(R.drawable.icon_gift_my_gift, StringHelper.formatOverBaiwanNum(aVar.b()), 0));
            if (CurrencySwitchUtil.isYyIsConvert(aVar.f66074h)) {
                formatOverBaiwanNum = CurrencyHelper.getFormatOverBaiwanNum(aVar.f66074h, aVar.e());
            } else {
                formatOverBaiwanNum = StringHelper.formatOverBaiwanNum(aVar.e());
            }
            this.q.setText(l(R.drawable.icon_gift_bluedrill, StringHelper.formatOverBaiwanNum(aVar.f66072f), 2));
            this.r.setText(aVar.f66073g.f53839a);
            this.n.setText(l(CurrencySwitchUtil.getGiftMoneyIconResId(aVar.f66074h), formatOverBaiwanNum, 1));
            if (CurrencySwitchUtil.isYyIsConvert(aVar.f66074h)) {
                this.p.setText(R.string.my_ybean);
                this.o.setText(R.string.get_ybean);
                return;
            }
            this.p.setText(R.string.my_tdou);
            this.o.setText(R.string.get_tdou);
            return;
        }
        this.f66110g.setVisibility(8);
    }

    public final void s(d.a.o0.v0.c.a aVar) {
        if (aVar != null && aVar.a() != null && aVar.a().size() > 0) {
            if (aVar.c() != null) {
                if (aVar.c().f66085b == 1) {
                    this.f66112i.setVisibility(0);
                } else {
                    this.f66112i.setVisibility(8);
                }
            }
            this.t.e(aVar.a(), aVar.f66074h);
            return;
        }
        this.f66112i.setVisibility(8);
        this.w.setVisibility(8);
        this.t.e(null, -1);
    }

    public void t(d.a.o0.v0.c.a aVar) {
        if (!this.u && TbadkApplication.getInst().isGiftSwitchOn()) {
            this.w.setVisibility(0);
        } else {
            this.w.setVisibility(8);
        }
        if (aVar != null) {
            TbadkCoreApplication.getInst().currentAccountTdouNum = aVar.e();
        }
        o();
        r(aVar);
        s(aVar);
    }

    public void u(f.g gVar) {
        this.k.a(gVar);
    }

    public void v(String str, boolean z) {
        if (this.f66107d == null) {
            this.f66107d = new h(this.mContext.getContext(), new a());
        }
        this.f66107d.j(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds280));
        this.f66107d.attachView(this.f66109f, z);
        this.f66107d.o();
        this.w.setVisibility(8);
        this.f66108e.setVisibility(8);
    }

    public void w() {
        this.f66108e.setVisibility(0);
        this.f66108e.F();
    }
}
