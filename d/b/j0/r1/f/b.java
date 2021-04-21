package d.b.j0.r1.f;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.pay.PayConfig;
import com.baidu.tbadk.util.PageDialogHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.AdapterView;
import com.baidu.tieba.horizonalList.widget.HListView;
import d.b.c.e.p.l;
import d.b.j0.r1.f.f;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class b {
    public static String F = "https://tieba.baidu.com/tb/vip_eula_mobile.html";
    public static String G = "https://tieba.baidu.com/tb/viprenew_eula_mobile.html";
    public String A;
    public int B;
    public Boolean C;
    public AdapterView.d D = new a();
    public View.OnClickListener E = new View$OnClickListenerC1569b();

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f61492a;

    /* renamed from: b  reason: collision with root package name */
    public View f61493b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f61494c;

    /* renamed from: d  reason: collision with root package name */
    public HListView f61495d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f61496e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f61497f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f61498g;

    /* renamed from: h  reason: collision with root package name */
    public GridView f61499h;
    public LinearLayout i;
    public TextView j;
    public NoNetworkView k;
    public TextView l;
    public c m;
    public e n;
    public f o;
    public f.g p;
    public f.b q;
    public f.c r;
    public f.a s;
    public String t;
    public String u;
    public String v;
    public String w;
    public int x;
    public long y;
    public String z;

    /* loaded from: classes3.dex */
    public class a implements AdapterView.d {
        public a() {
        }

        @Override // com.baidu.tieba.horizonalList.widget.AdapterView.d
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            f.d item = b.this.m.getItem(i);
            if (item == null) {
                return;
            }
            item.m = true;
            b.this.m.g(item);
            b.this.u(item.n);
            b.this.x(item.j);
        }
    }

    /* renamed from: d.b.j0.r1.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1569b implements View.OnClickListener {
        public View$OnClickListenerC1569b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = 0;
            if (view == b.this.j) {
                b.this.l();
                int i2 = 2;
                if (b.this.x != 1) {
                    int unused = b.this.x;
                    i2 = 1;
                }
                f.d b2 = b.this.m.b();
                if (b2 != null && b2.n != 1) {
                    long j = b2.l;
                    if (j == 1) {
                        i = 1;
                    } else if (j == 3) {
                        i = 3;
                    } else if (j == 6) {
                        i = 6;
                    } else if (j == 12) {
                        i = 12;
                    }
                }
                TiebaStatic.log(new StatisticItem("c13200").param("obj_type", i2).param("obj_locate", i));
            } else if (view != b.this.f61496e) {
                if (view == b.this.f61498g) {
                    UrlManager.getInstance().dealOneLink(b.this.f61492a, new String[]{b.F});
                }
            } else {
                UrlManager.getInstance().dealOneLink(b.this.f61492a, new String[]{b.G});
            }
        }
    }

    public b(TbPageContext tbPageContext, View view, int i, String str, String str2, boolean z, int i2) {
        this.x = 2;
        this.C = Boolean.FALSE;
        this.f61493b = view;
        this.f61492a = tbPageContext;
        this.x = i;
        this.C = Boolean.valueOf(z);
        this.z = str;
        this.A = str2;
        this.B = i2;
        o();
    }

    public final void l() {
        f.d b2 = this.m.b();
        if (b2 == null) {
            l.K(this.f61492a.getPageActivity(), R.string.tb_member_select_money_tip);
        } else if (b2.n == 1 && b2.o) {
            l.K(this.f61492a.getPageActivity(), R.string.tips_auto_pay_succ);
        } else {
            t(b2.i, b2.j / 100, b2.l, b2.n);
            if (this.B == 26) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.MEMBER_PAY_PAGE_SHOW_PAY_CLICK).param("obj_source", 1));
            }
        }
    }

    public final void m() {
        f.e eVar;
        f fVar = this.o;
        if (fVar == null) {
            return;
        }
        f.b bVar = fVar.f61520b;
        this.q = bVar;
        f.g gVar = fVar.f61519a;
        this.p = gVar;
        if (bVar == null || gVar == null || (eVar = gVar.f61545c) == null) {
            return;
        }
        this.y = eVar.f61541a;
        f.a aVar = bVar.f61527b;
        this.s = aVar;
        if (aVar != null) {
            this.t = aVar.f61523c;
        }
        f.c cVar = this.q.f61526a;
        this.r = cVar;
        if (cVar != null) {
            this.u = cVar.f61530c;
        }
    }

    public final ArrayList<d> n() {
        ArrayList<d> arrayList = new ArrayList<>();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i = this.x;
        if (i == 1) {
            linkedHashMap.put(this.f61492a.getPageActivity().getResources().getString(R.string.member_privilege_update_name), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_nickname24_svg));
            linkedHashMap.put(this.f61492a.getPageActivity().getResources().getString(R.string.member_privilege_special_identity), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_member24_svg));
            linkedHashMap.put(this.f61492a.getPageActivity().getResources().getString(R.string.member_privilege_patch_card), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_remedy24_svg));
            linkedHashMap.put(this.f61492a.getPageActivity().getResources().getString(R.string.member_privilege_write_pop), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_qipao24_svg));
            linkedHashMap.put(this.f61492a.getPageActivity().getResources().getString(R.string.member_privilege_tail), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_tail24_1x));
        } else if (i == 2) {
            linkedHashMap.put(this.f61492a.getPageActivity().getResources().getString(R.string.member_privilege_update_name), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_nickname24_svg));
            linkedHashMap.put(this.f61492a.getPageActivity().getResources().getString(R.string.member_privilege_special_identity), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_member24_svg));
            linkedHashMap.put(this.f61492a.getPageActivity().getResources().getString(R.string.member_privilege_forbid_adv), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_advertising24_svg));
            linkedHashMap.put(this.f61492a.getPageActivity().getResources().getString(R.string.member_privilege_experience_acc), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_accelerate24_svg));
            linkedHashMap.put(this.f61492a.getPageActivity().getResources().getString(R.string.member_privilege_one_key_sign), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_checkin24_svg));
            linkedHashMap.put(this.f61492a.getPageActivity().getResources().getString(R.string.member_privilege_special_bg), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_bg24_svg));
            linkedHashMap.put(this.f61492a.getPageActivity().getResources().getString(R.string.member_privilege_patch_card), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_remedy24_svg));
            linkedHashMap.put(this.f61492a.getPageActivity().getResources().getString(R.string.member_privilege_write_pop), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_qipao24_svg));
            linkedHashMap.put(this.f61492a.getPageActivity().getResources().getString(R.string.member_privilege_forbid_speak), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_notalk24_svg));
            linkedHashMap.put(this.f61492a.getPageActivity().getResources().getString(R.string.member_privilege_tail), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_tail24_1x));
            linkedHashMap.put(this.f61492a.getPageActivity().getResources().getString(R.string.member_privilege_more_link), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_morelink26_svg));
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            d dVar = new d();
            dVar.f61514b = (String) entry.getKey();
            dVar.f61513a = ((Integer) entry.getValue()).intValue();
            arrayList.add(dVar);
        }
        return arrayList;
    }

    public final void o() {
        this.f61494c = (RelativeLayout) this.f61493b.findViewById(R.id.root);
        this.f61495d = (HListView) this.f61493b.findViewById(R.id.price_listview);
        this.i = (LinearLayout) this.f61493b.findViewById(R.id.renew_layout);
        this.f61496e = (ImageView) this.f61493b.findViewById(R.id.renew_tip_img);
        this.f61497f = (TextView) this.f61493b.findViewById(R.id.privilege_title);
        this.f61498g = (TextView) this.f61493b.findViewById(R.id.privilege_rule);
        this.f61499h = (GridView) this.f61493b.findViewById(R.id.privilege_container);
        this.k = (NoNetworkView) this.f61493b.findViewById(R.id.view_no_network);
        this.j = (TextView) this.f61493b.findViewById(R.id.member_pay_button);
        this.l = (TextView) this.f61493b.findViewById(R.id.tv_member_auto_pay_cancel_tip);
        this.f61495d.setBackgroundResource(R.drawable.transparent_bg);
        this.f61495d.setOnItemClickListener(this.D);
        this.f61495d.setSelector(this.f61492a.getPageActivity().getResources().getDrawable(R.drawable.transparent_bg));
        this.f61499h.setVerticalSpacing(this.f61492a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds58));
        this.f61499h.setHorizontalSpacing(this.f61492a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds108));
        this.j.setOnClickListener(this.E);
        this.f61496e.setOnClickListener(this.E);
        this.f61498g.setOnClickListener(this.E);
    }

    public void p(int i) {
        this.k.c(this.f61492a, i);
        SkinManager.setBackgroundColor(this.f61494c, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.l, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f61497f, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f61498g, R.color.CAM_X0107);
        this.f61498g.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_tbvip_arrow_right), (Drawable) null);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0101);
        SkinManager.setBackgroundResource(this.j, R.drawable.member_price_btn_bg);
        SkinManager.setImageResource(this.f61496e, R.drawable.icon_tbvip_attention);
    }

    public void q(boolean z) {
        f.c cVar;
        List<f.d> list;
        f.a aVar;
        if (this.o == null) {
            return;
        }
        List<f.d> list2 = null;
        if (2 != this.x ? !((cVar = this.r) == null || (list = cVar.f61528a) == null) : !((aVar = this.s) == null || (list = aVar.f61521a) == null)) {
            list2 = list;
        }
        if (ListUtils.isEmpty(list2)) {
            return;
        }
        for (int i = 0; i < list2.size(); i++) {
            f.d dVar = list2.get(i);
            if (dVar != null && dVar.j >= 0 && dVar.n == 1) {
                dVar.o = z;
                return;
            }
        }
    }

    public final void r() {
        f.g gVar;
        f.a aVar;
        if (this.o == null) {
            this.f61494c.setVisibility(8);
        } else if (this.q != null && (gVar = this.p) != null) {
            if (gVar.f61545c == null) {
                this.f61494c.setVisibility(8);
            } else if (this.s == null && this.r == null) {
                this.f61494c.setVisibility(8);
            } else if (this.x == 2 && ((aVar = this.s) == null || ListUtils.isEmpty(aVar.f61521a))) {
                this.f61494c.setVisibility(8);
            } else {
                this.f61494c.setVisibility(0);
                v();
                w();
                y();
            }
        } else {
            this.f61494c.setVisibility(8);
        }
    }

    public void s(f fVar) {
        if (fVar == null) {
            this.f61494c.setVisibility(8);
            return;
        }
        this.o = fVar;
        m();
        r();
    }

    public final void t(long j, long j2, long j3, int i) {
        PayConfig payConfig = new PayConfig(1, "0", String.valueOf(j), String.valueOf(j2), String.valueOf(j3), true, this.C.booleanValue(), PageDialogHelper.PayForm.NOT_SET, this.z, this.A);
        payConfig.setTitle(this.v);
        payConfig.setOrderName(this.w + this.f61492a.getPageActivity().getString(R.string.member_month, new Object[]{String.valueOf(j3)}));
        payConfig.setAutoPay(i);
        if (this.B == 23) {
            payConfig.paymentPosKey = PayConfig.PAYMENT_POS_KEY_MANGA;
        }
        d.b.i0.l0.c.c().a(payConfig, this.f61492a.getPageActivity());
    }

    public final void u(int i) {
        if (i == 1) {
            this.i.setVisibility(0);
        } else {
            this.i.setVisibility(8);
        }
    }

    public final void v() {
        f.c cVar;
        List<f.d> list;
        f.a aVar;
        if (2 != this.x ? (cVar = this.r) == null || (list = cVar.f61528a) == null : (aVar = this.s) == null || (list = aVar.f61521a) == null) {
            list = null;
        }
        if (ListUtils.isEmpty(list)) {
            return;
        }
        for (f.d dVar : list) {
            if (dVar.m) {
                u(dVar.n);
                x(dVar.j);
            }
        }
        if (this.m == null) {
            c cVar2 = new c(this.f61492a);
            this.m = cVar2;
            cVar2.d(list);
            this.f61495d.setAdapter((ListAdapter) this.m);
        }
        this.m.d(list);
        this.m.notifyDataSetChanged();
    }

    public final void w() {
        if (this.n == null) {
            ArrayList<d> n = n();
            e eVar = new e(this.f61492a.getPageActivity());
            this.n = eVar;
            eVar.c(n);
            this.f61499h.setAdapter((ListAdapter) this.n);
        }
    }

    public final void x(long j) {
        this.j.setText(this.f61492a.getPageActivity().getResources().getString(R.string.tb_member_need_pay_money, "" + (j / 100)));
    }

    public final void y() {
        String string;
        int i = this.x;
        if (2 == i) {
            if (this.y == 2) {
                string = this.f61492a.getPageActivity().getString(R.string.continue_dredge, new Object[]{this.t});
            } else {
                string = this.f61492a.getPageActivity().getString(R.string.dredge, new Object[]{this.t});
            }
            this.w = this.t;
        } else if (1 == i) {
            long j = this.y;
            if (j == 1) {
                string = this.f61492a.getPageActivity().getString(R.string.continue_dredge, new Object[]{this.u});
            } else {
                string = j == 0 ? this.f61492a.getPageActivity().getString(R.string.dredge, new Object[]{this.u}) : null;
            }
            this.w = this.u;
        } else {
            string = this.f61492a.getPageActivity().getString(R.string.dredge, new Object[]{this.u});
            this.w = this.u;
        }
        this.v = string;
    }
}
