package d.b.i0.t.j.g.c;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.utils.AlaStringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.model.AlaUpdateMarkStatusModel;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.MarkLevelGroup;
import com.google.protobuf.CodedInputStream;
import d.b.h0.r.s.a;
import d.b.i0.t.j.g.a;
import d.b.i0.t.j.g.b;
/* loaded from: classes4.dex */
public class a extends Dialog {
    public static final int y = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds36);
    public static final int z = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds32);

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f62452e;

    /* renamed from: f  reason: collision with root package name */
    public View f62453f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f62454g;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout f62455h;
    public TextView i;
    public RelativeLayout j;
    public TextView k;
    public TextView l;
    public MarkLevelGroup m;
    public TextView n;
    public d.b.i0.t.j.g.c.c.b o;
    public AlaUpdateMarkStatusModel p;
    public i q;
    public LinearLayout r;
    public TextView s;
    public TextView t;
    public LinearLayout u;
    public TextView v;
    public d.b.i0.t.j.g.b w;
    public d.b.i0.t.j.g.a x;

    /* renamed from: d.b.i0.t.j.g.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1624a implements AlaUpdateMarkStatusModel.b {
        public C1624a() {
        }

        @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.model.AlaUpdateMarkStatusModel.b
        public void onResult(boolean z, String str) {
            a.this.n.setEnabled(true);
            if (z) {
                if (a.this.q != null) {
                    a.this.q.a(true, a.this.o);
                }
                a.this.dismiss();
                return;
            }
            if (StringUtils.isNull(str)) {
                str = a.this.getContext().getResources().getString(R.string.ala_achievement_ops_failed_tip);
            }
            a.this.f62452e.showToast(str);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements b.c {
        public b() {
        }

        @Override // d.b.i0.t.j.g.b.c
        public void a(boolean z) {
            if (!z || a.this.o.n > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                return;
            }
            a.this.v();
            a.this.u();
            a.this.s();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.b {
        public c() {
        }

        @Override // d.b.i0.t.j.g.a.b
        public void a(boolean z, String str) {
            if (z) {
                if (a.this.o != null) {
                    a.this.f62452e.showToast(R.string.ala_achievement_tdou_buy_success);
                    if (a.this.q != null) {
                        a.this.q.a(true, a.this.o);
                    }
                    a.this.o.q(2);
                    a.this.v();
                    a.this.u();
                    a.this.s();
                }
            } else if (!StringUtils.isNull(str)) {
                a.this.f62452e.showToast(str);
            } else {
                a.this.f62452e.showToast(R.string.ala_achievement_tdou_buy_fail);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.q != null) {
                a.this.q.a(false, a.this.o);
            }
            a.this.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements MarkLevelGroup.b {
        public e() {
        }

        @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.MarkLevelGroup.b
        public void a(String str, String str2) {
            a.this.t(str, str2);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.o.j() == 0 || 3 == a.this.o.j()) {
                if (a.this.o.m()) {
                    if (a.this.o.n > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        if (a.this.w != null) {
                            a.this.w.c(a.this.o.n);
                        }
                    } else if (a.this.x != null) {
                        a.this.x.c(a.this.o.d(), a.this.o.m, false);
                    }
                } else if (a.this.o.l()) {
                } else {
                    a.this.dismiss();
                }
            } else if (!a.this.o.k() || 2 != a.this.o.j()) {
                a.this.q();
            } else {
                a.this.r();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements a.e {
        public g() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
            a.this.n.setEnabled(false);
            a.this.q();
        }
    }

    /* loaded from: classes4.dex */
    public class h implements a.e {
        public h() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public interface i {
        void a(boolean z, d.b.i0.t.j.g.c.c.b bVar);
    }

    public a(TbPageContext tbPageContext, i iVar) {
        super(tbPageContext.getPageActivity());
        this.f62452e = tbPageContext;
        this.q = iVar;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
    }

    public final void m() {
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().setLayout(-1, -1);
        setCancelable(true);
        setCanceledOnTouchOutside(true);
    }

    public final void n() {
        AlaUpdateMarkStatusModel alaUpdateMarkStatusModel = new AlaUpdateMarkStatusModel(getContext());
        this.p = alaUpdateMarkStatusModel;
        alaUpdateMarkStatusModel.v(new C1624a());
        d.b.i0.t.j.g.b bVar = new d.b.i0.t.j.g.b(this.f62452e);
        this.w = bVar;
        bVar.e(new b());
        this.x = new d.b.i0.t.j.g.a(this.f62452e, new c());
    }

    public final void o() {
        View inflate = getLayoutInflater().inflate(R.layout.ala_achievement_mark_mask_layout, (ViewGroup) null);
        this.f62453f = inflate;
        setContentView(inflate);
        this.f62453f.setOnClickListener(new d());
        TbImageView tbImageView = (TbImageView) this.f62453f.findViewById(R.id.mark_img);
        this.f62454g = tbImageView;
        tbImageView.setDefaultBgResource(R.color.transparent);
        this.f62454g.setDefaultResource(R.drawable.pic_live_honor);
        this.f62455h = (FrameLayout) this.f62453f.findViewById(R.id.mark_img_layout);
        this.i = (TextView) this.f62453f.findViewById(R.id.mark_title);
        this.j = (RelativeLayout) this.f62453f.findViewById(R.id.mark_desc_layout);
        this.k = (TextView) this.f62453f.findViewById(R.id.mark_desc);
        this.l = (TextView) this.f62453f.findViewById(R.id.mark_upgrade_desc);
        MarkLevelGroup markLevelGroup = (MarkLevelGroup) this.f62453f.findViewById(R.id.mark_level_view);
        this.m = markLevelGroup;
        markLevelGroup.setCallback(new e());
        this.n = (TextView) this.f62453f.findViewById(R.id.mark_ops_btn);
        this.t = (TextView) this.f62453f.findViewById(R.id.mark_limit_time);
        this.r = (LinearLayout) findViewById(R.id.mark_tdou_layout);
        this.s = (TextView) findViewById(R.id.mark_tdou_price);
        this.u = (LinearLayout) findViewById(R.id.user_tdou_layout);
        this.v = (TextView) findViewById(R.id.user_tdou_price);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().addFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
            getWindow().addFlags(134217728);
        }
        super.onCreate(bundle);
        getWindow().requestFeature(1);
        o();
        m();
        n();
    }

    public void p() {
        AlaUpdateMarkStatusModel alaUpdateMarkStatusModel = this.p;
        if (alaUpdateMarkStatusModel != null) {
            alaUpdateMarkStatusModel.onDestroy();
        }
    }

    public final void q() {
        if (1 == this.o.j()) {
            this.p.w(false, this.o.d());
        } else if (2 == this.o.j()) {
            this.p.w(true, this.o.d());
        }
    }

    public final void r() {
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(this.f62452e.getPageActivity());
        aVar.setMessageShowCenter(true);
        aVar.setCanceledOnTouchOutside(false);
        aVar.setTitle(R.string.ala_achievement_ops_alert_title);
        aVar.setMessageId(R.string.ala_achievement_ops_alert_content);
        aVar.setPositiveButton(R.string.dialog_ok, new g());
        aVar.setNegativeButton(R.string.dialog_cancel, new h());
        aVar.create(this.f62452e).show();
    }

    public final void s() {
        this.k.setVisibility(4);
        this.l.setVisibility(4);
        this.r.setVisibility(4);
        this.m.setVisibility(4);
        this.u.setVisibility(8);
        if (this.o.m()) {
            this.r.setVisibility(0);
            this.u.setVisibility(0);
            this.s.setText(AlaStringHelper.formatLowercasekDou(this.o.n));
            Drawable drawable = getContext().getResources().getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            this.v.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(R.dimen.ds4));
            this.v.setCompoundDrawables(drawable, null, null, null);
            this.v.setText(AlaStringHelper.formatLowercasekDou(TbadkCoreApplication.getInst().currentAccountTdouNum));
            if (this.o.j() == 1) {
                this.u.setVisibility(8);
            }
        } else if (this.o.l()) {
            this.k.setVisibility(0);
            this.k.setText(this.o.a());
        } else {
            this.m.setVisibility(0);
            this.k.setVisibility(0);
            this.l.setVisibility(0);
            this.k.setText(this.o.a());
            this.l.setText(this.o.i());
            this.m.f(this.o);
        }
    }

    public final void t(String str, String str2) {
        if (StringUtils.isNull(str)) {
            this.f62454g.W(String.valueOf(R.drawable.pic_live_honor), 24, false);
        } else {
            this.f62454g.W(str, 10, false);
        }
        this.i.setText(str2);
    }

    public final void u() {
        if (this.o.j() != 1 && this.o.j() != 2) {
            this.t.setVisibility(8);
            return;
        }
        this.t.setVisibility(0);
        this.t.setText(this.o.b());
    }

    public final void v() {
        int j = this.o.j();
        if (j != 0) {
            if (j != 1) {
                if (j != 2) {
                    if (j == 3) {
                        if (this.o.m()) {
                            this.n.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                            this.n.setTextSize(0, z);
                            this.n.setText(R.string.ala_enter_effect_tdou_buy);
                            this.n.setTextColor(getContext().getResources().getColor(R.color.CAM_X0201));
                            if (this.o.n > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                                this.n.setText(R.string.ala_achievement_get_tdou_label);
                            }
                        } else if (this.o.l()) {
                            this.n.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                            this.n.setTextSize(0, z);
                            this.n.setText(R.string.ala_nobility_open);
                            this.n.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
                        } else {
                            this.n.setBackgroundResource(R.drawable.transparent_bg);
                            this.n.setTextSize(0, y);
                            this.n.setText(R.string.ala_achievement_mark_status_expired);
                            this.n.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                        }
                    }
                } else if (this.o.m()) {
                    this.n.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.n.setTextSize(0, z);
                    this.n.setText(R.string.ala_achievement_wear_mark);
                    this.n.setTextColor(getContext().getResources().getColorStateList(R.color.CAM_X0201));
                } else if (this.o.l()) {
                    this.n.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.n.setTextSize(0, z);
                    this.n.setText(R.string.ala_achievement_wear_mark);
                    this.n.setTextColor(getContext().getResources().getColorStateList(R.color.ala_nobility_bottom_btn_color));
                } else {
                    this.n.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                    this.n.setTextSize(0, z);
                    this.n.setText(R.string.ala_achievement_wear_mark);
                    this.n.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
                }
            } else if (this.o.m()) {
                this.n.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                this.n.setTextSize(0, z);
                this.n.setText(R.string.ala_achievement_unwear_mark);
                this.n.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
            } else if (this.o.l()) {
                this.n.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                this.n.setTextSize(0, z);
                this.n.setText(R.string.ala_achievement_unwear_mark);
                this.n.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
            } else {
                this.n.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                this.n.setTextSize(0, z);
                this.n.setText(R.string.ala_achievement_unwear_mark);
                this.n.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
            }
        } else if (this.o.m()) {
            this.n.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
            this.n.setTextSize(0, z);
            this.n.setText(R.string.ala_enter_effect_tdou_buy);
            this.n.setTextColor(getContext().getResources().getColor(R.color.CAM_X0201));
            if (this.o.n > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                this.n.setText(R.string.ala_achievement_get_tdou_label);
            }
        } else if (this.o.l()) {
            this.n.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
            this.n.setTextSize(0, z);
            this.n.setText(R.string.ala_nobility_open);
            this.n.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
        } else {
            this.n.setBackgroundResource(R.drawable.transparent_bg);
            this.n.setTextSize(0, y);
            this.n.setText(R.string.ala_achievement_mark_status_unlock);
            this.n.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
        }
        this.n.setOnClickListener(new f());
    }
}
