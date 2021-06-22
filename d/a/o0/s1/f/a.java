package d.a.o0.s1.f;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.memberpay.CardBoxMemberPayActivity;
import d.a.c.e.p.k;
import d.a.o0.s1.f.f;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public CardBoxMemberPayActivity f64314a;

    /* renamed from: b  reason: collision with root package name */
    public TbImageView f64315b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f64316c;

    /* renamed from: d  reason: collision with root package name */
    public HeadImageView f64317d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f64318e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f64319f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f64320g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f64321h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f64322i;
    public TextView j;
    public TextView k;
    public TextView l;
    public View m;
    public LinearLayout n;
    public View o;
    public List<f.d> p;
    public f.d q = null;
    public String r = "";

    /* renamed from: d.a.o0.s1.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1653a implements View.OnClickListener {
        public View$OnClickListenerC1653a(List<f.d> list) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f64320g == null) {
                return;
            }
            for (int i2 = 0; i2 < a.this.f64320g.getChildCount(); i2++) {
                View childAt = a.this.f64320g.getChildAt(i2);
                if (childAt == null || childAt.getTag() == null) {
                    return;
                }
                f.d dVar = childAt.getTag() instanceof f.d ? (f.d) childAt.getTag() : null;
                if (dVar == null) {
                    return;
                }
                if (view == childAt) {
                    dVar.m = true;
                    a.this.q = dVar;
                    a.this.r = dVar.f64373g;
                    SkinManager.setViewTextColor(childAt, R.color.CAM_X0305);
                    SkinManager.setBackgroundResource(childAt, R.drawable.card_box_selected_bg);
                } else {
                    dVar.m = false;
                    SkinManager.setViewTextColor(childAt, R.color.CAM_X0105);
                    SkinManager.setBackgroundResource(childAt, R.drawable.card_box_normal_bg);
                }
            }
            a.this.p();
        }
    }

    public a(CardBoxMemberPayActivity cardBoxMemberPayActivity) {
        this.f64314a = cardBoxMemberPayActivity;
        cardBoxMemberPayActivity.setContentView(R.layout.card_box_member_pay_activity);
        this.m = this.f64314a.findViewById(R.id.card_box_member_pay_root_view);
        LinearLayout linearLayout = (LinearLayout) this.f64314a.findViewById(R.id.card_box_member_pay_info);
        this.n = linearLayout;
        linearLayout.setOnClickListener(cardBoxMemberPayActivity);
        View findViewById = this.f64314a.findViewById(R.id.empty_layout);
        this.o = findViewById;
        findViewById.setOnClickListener(cardBoxMemberPayActivity);
        this.f64315b = (TbImageView) this.f64314a.findViewById(R.id.title_image);
        this.f64316c = (TextView) this.f64314a.findViewById(R.id.title_info);
        this.f64317d = (HeadImageView) this.f64314a.findViewById(R.id.head_portrait);
        this.f64318e = (TextView) this.f64314a.findViewById(R.id.user_name);
        this.f64319f = (TextView) this.f64314a.findViewById(R.id.desc_info);
        this.f64320g = (LinearLayout) this.f64314a.findViewById(R.id.choice_month_info);
        this.f64321h = (TextView) this.f64314a.findViewById(R.id.before_discount);
        this.f64322i = (TextView) this.f64314a.findViewById(R.id.after_discount);
        this.j = (TextView) this.f64314a.findViewById(R.id.discount_desc);
        TextView textView = (TextView) this.f64314a.findViewById(R.id.open_member_view);
        this.k = textView;
        textView.setOnClickListener(cardBoxMemberPayActivity);
        TextView textView2 = (TextView) this.f64314a.findViewById(R.id.card_box_member_agreement_view);
        this.l = textView2;
        textView2.setOnClickListener(cardBoxMemberPayActivity);
        this.f64321h.getPaint().setFlags(16);
        this.f64317d.setIsRound(true);
        this.f64317d.setDrawBorder(false);
    }

    public f.d d() {
        return this.q;
    }

    public View e() {
        return this.o;
    }

    public View f() {
        return this.l;
    }

    public LinearLayout g() {
        return this.n;
    }

    public View h() {
        return this.k;
    }

    public String i() {
        TextView textView = this.f64316c;
        if (textView != null) {
            return textView.getText().toString();
        }
        return null;
    }

    public void j(int i2) {
        this.f64314a.getLayoutMode().k(i2 == 1);
        this.f64314a.getLayoutMode().j(this.m);
    }

    public final void k(f fVar) {
        f.b bVar;
        f.a aVar;
        if (fVar == null || (bVar = fVar.f64354b) == null || (aVar = bVar.f64361b) == null) {
            return;
        }
        this.p = aVar.f64355a;
    }

    public final void l() {
        List<f.d> list = this.p;
        if (list == null || list.size() <= 0) {
            return;
        }
        int size = this.p.size();
        for (int i2 = 0; i2 < size; i2++) {
            f.d dVar = this.p.get(i2);
            if (dVar != null && dVar.m) {
                this.q = dVar;
                return;
            }
        }
    }

    public void m(f fVar) {
        if (fVar == null) {
            return;
        }
        k(fVar);
        l();
        q(fVar);
        p();
        o();
    }

    public String n(String str, int i2) {
        if (str == null) {
            return "";
        }
        if (str.length() > i2) {
            return str.substring(0, i2 - 1) + StringHelper.STRING_MORE;
        }
        return str;
    }

    public final void o() {
        List<f.d> list = this.p;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f64320g.removeAllViews();
        int size = this.p.size();
        for (int i2 = 0; i2 < size; i2++) {
            f.d dVar = this.p.get(i2);
            if (dVar != null) {
                TextView textView = new TextView(this.f64314a.getActivity());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2, 1.0f);
                layoutParams.setMargins(0, 0, (int) this.f64314a.getResources().getDimension(R.dimen.ds16), 0);
                textView.setLayoutParams(layoutParams);
                textView.setText(n(dVar.f64368b, 7));
                textView.setGravity(17);
                textView.setSingleLine(true);
                textView.setTextSize(0, this.f64314a.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                if (dVar.m) {
                    this.r = dVar.f64373g;
                    SkinManager.setViewTextColor(textView, R.color.CAM_X0312);
                    SkinManager.setBackgroundResource(textView, R.drawable.card_box_selected_bg);
                } else {
                    SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
                    SkinManager.setBackgroundResource(textView, R.drawable.card_box_normal_bg);
                }
                textView.setTag(dVar);
                textView.setOnClickListener(new View$OnClickListenerC1653a(this.p));
                this.f64320g.addView(textView);
            }
        }
    }

    public final void p() {
        if (this.q == null) {
            return;
        }
        TextView textView = this.f64322i;
        textView.setText(this.f64314a.getResources().getString(R.string.yuan) + (this.q.j / 100));
        if (!k.isEmpty(this.q.f64370d)) {
            TextView textView2 = this.f64321h;
            textView2.setText(this.f64314a.getResources().getString(R.string.origin_price) + this.q.f64370d);
        }
        this.j.setText(this.q.f64372f);
    }

    public final void q(f fVar) {
        f.a aVar;
        if (fVar == null) {
            return;
        }
        f.g gVar = fVar.f64353a;
        if (gVar != null) {
            this.f64317d.U(gVar.f64379b, 12, false);
            this.f64318e.setText(fVar.f64353a.f64378a);
            f.e eVar = fVar.f64353a.f64380c;
            if (eVar != null) {
                if (eVar.f64376a > 0) {
                    this.k.setText(this.f64314a.getResources().getString(R.string.renew_now));
                }
                this.f64315b.U(fVar.f64353a.f64380c.f64377b, 21, false);
            }
        }
        f.b bVar = fVar.f64354b;
        if (bVar == null || (aVar = bVar.f64361b) == null) {
            return;
        }
        this.f64319f.setText(aVar.f64358d);
        this.f64316c.setText(fVar.f64354b.f64361b.f64357c);
    }
}
