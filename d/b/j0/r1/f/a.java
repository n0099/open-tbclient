package d.b.j0.r1.f;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.memberpay.CardBoxMemberPayActivity;
import d.b.c.e.p.k;
import d.b.j0.r1.f.f;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public CardBoxMemberPayActivity f61483a;

    /* renamed from: b  reason: collision with root package name */
    public TbImageView f61484b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f61485c;

    /* renamed from: d  reason: collision with root package name */
    public HeadImageView f61486d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f61487e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f61488f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f61489g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f61490h;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public View m;
    public LinearLayout n;
    public View o;
    public List<f.d> p;
    public f.d q = null;
    public String r = "";

    /* renamed from: d.b.j0.r1.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1568a implements View.OnClickListener {
        public View$OnClickListenerC1568a(List<f.d> list) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f61489g == null) {
                return;
            }
            for (int i = 0; i < a.this.f61489g.getChildCount(); i++) {
                View childAt = a.this.f61489g.getChildAt(i);
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
                    a.this.r = dVar.f61539g;
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
        this.f61483a = cardBoxMemberPayActivity;
        cardBoxMemberPayActivity.setContentView(R.layout.card_box_member_pay_activity);
        this.m = this.f61483a.findViewById(R.id.card_box_member_pay_root_view);
        LinearLayout linearLayout = (LinearLayout) this.f61483a.findViewById(R.id.card_box_member_pay_info);
        this.n = linearLayout;
        linearLayout.setOnClickListener(cardBoxMemberPayActivity);
        View findViewById = this.f61483a.findViewById(R.id.empty_layout);
        this.o = findViewById;
        findViewById.setOnClickListener(cardBoxMemberPayActivity);
        this.f61484b = (TbImageView) this.f61483a.findViewById(R.id.title_image);
        this.f61485c = (TextView) this.f61483a.findViewById(R.id.title_info);
        this.f61486d = (HeadImageView) this.f61483a.findViewById(R.id.head_portrait);
        this.f61487e = (TextView) this.f61483a.findViewById(R.id.user_name);
        this.f61488f = (TextView) this.f61483a.findViewById(R.id.desc_info);
        this.f61489g = (LinearLayout) this.f61483a.findViewById(R.id.choice_month_info);
        this.f61490h = (TextView) this.f61483a.findViewById(R.id.before_discount);
        this.i = (TextView) this.f61483a.findViewById(R.id.after_discount);
        this.j = (TextView) this.f61483a.findViewById(R.id.discount_desc);
        TextView textView = (TextView) this.f61483a.findViewById(R.id.open_member_view);
        this.k = textView;
        textView.setOnClickListener(cardBoxMemberPayActivity);
        TextView textView2 = (TextView) this.f61483a.findViewById(R.id.card_box_member_agreement_view);
        this.l = textView2;
        textView2.setOnClickListener(cardBoxMemberPayActivity);
        this.f61490h.getPaint().setFlags(16);
        this.f61486d.setIsRound(true);
        this.f61486d.setDrawBorder(false);
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
        TextView textView = this.f61485c;
        if (textView != null) {
            return textView.getText().toString();
        }
        return null;
    }

    public void j(int i) {
        this.f61483a.getLayoutMode().k(i == 1);
        this.f61483a.getLayoutMode().j(this.m);
    }

    public final void k(f fVar) {
        f.b bVar;
        f.a aVar;
        if (fVar == null || (bVar = fVar.f61520b) == null || (aVar = bVar.f61527b) == null) {
            return;
        }
        this.p = aVar.f61521a;
    }

    public final void l() {
        List<f.d> list = this.p;
        if (list == null || list.size() <= 0) {
            return;
        }
        int size = this.p.size();
        for (int i = 0; i < size; i++) {
            f.d dVar = this.p.get(i);
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

    public String n(String str, int i) {
        if (str == null) {
            return "";
        }
        if (str.length() > i) {
            return str.substring(0, i - 1) + StringHelper.STRING_MORE;
        }
        return str;
    }

    public final void o() {
        List<f.d> list = this.p;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f61489g.removeAllViews();
        int size = this.p.size();
        for (int i = 0; i < size; i++) {
            f.d dVar = this.p.get(i);
            if (dVar != null) {
                TextView textView = new TextView(this.f61483a.getActivity());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2, 1.0f);
                layoutParams.setMargins(0, 0, (int) this.f61483a.getResources().getDimension(R.dimen.ds16), 0);
                textView.setLayoutParams(layoutParams);
                textView.setText(n(dVar.f61534b, 7));
                textView.setGravity(17);
                textView.setSingleLine(true);
                textView.setTextSize(0, this.f61483a.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                if (dVar.m) {
                    this.r = dVar.f61539g;
                    SkinManager.setViewTextColor(textView, R.color.CAM_X0312);
                    SkinManager.setBackgroundResource(textView, R.drawable.card_box_selected_bg);
                } else {
                    SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
                    SkinManager.setBackgroundResource(textView, R.drawable.card_box_normal_bg);
                }
                textView.setTag(dVar);
                textView.setOnClickListener(new View$OnClickListenerC1568a(this.p));
                this.f61489g.addView(textView);
            }
        }
    }

    public final void p() {
        if (this.q == null) {
            return;
        }
        TextView textView = this.i;
        textView.setText(this.f61483a.getResources().getString(R.string.yuan) + (this.q.j / 100));
        if (!k.isEmpty(this.q.f61536d)) {
            TextView textView2 = this.f61490h;
            textView2.setText(this.f61483a.getResources().getString(R.string.origin_price) + this.q.f61536d);
        }
        this.j.setText(this.q.f61538f);
    }

    public final void q(f fVar) {
        f.a aVar;
        if (fVar == null) {
            return;
        }
        f.g gVar = fVar.f61519a;
        if (gVar != null) {
            this.f61486d.W(gVar.f61544b, 12, false);
            this.f61487e.setText(fVar.f61519a.f61543a);
            f.e eVar = fVar.f61519a.f61545c;
            if (eVar != null) {
                if (eVar.f61541a > 0) {
                    this.k.setText(this.f61483a.getResources().getString(R.string.renew_now));
                }
                this.f61484b.W(fVar.f61519a.f61545c.f61542b, 21, false);
            }
        }
        f.b bVar = fVar.f61520b;
        if (bVar == null || (aVar = bVar.f61527b) == null) {
            return;
        }
        this.f61488f.setText(aVar.f61524d);
        this.f61485c.setText(fVar.f61520b.f61527b.f61523c);
    }
}
