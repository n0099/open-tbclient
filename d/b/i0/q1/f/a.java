package d.b.i0.q1.f;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.memberpay.CardBoxMemberPayActivity;
import d.b.b.e.p.k;
import d.b.i0.q1.f.f;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public CardBoxMemberPayActivity f59368a;

    /* renamed from: b  reason: collision with root package name */
    public TbImageView f59369b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f59370c;

    /* renamed from: d  reason: collision with root package name */
    public HeadImageView f59371d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f59372e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f59373f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f59374g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f59375h;
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

    /* renamed from: d.b.i0.q1.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1481a implements View.OnClickListener {
        public View$OnClickListenerC1481a(List<f.d> list) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f59374g == null) {
                return;
            }
            for (int i = 0; i < a.this.f59374g.getChildCount(); i++) {
                View childAt = a.this.f59374g.getChildAt(i);
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
                    a.this.r = dVar.f59424g;
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
        this.f59368a = cardBoxMemberPayActivity;
        cardBoxMemberPayActivity.setContentView(R.layout.card_box_member_pay_activity);
        this.m = this.f59368a.findViewById(R.id.card_box_member_pay_root_view);
        LinearLayout linearLayout = (LinearLayout) this.f59368a.findViewById(R.id.card_box_member_pay_info);
        this.n = linearLayout;
        linearLayout.setOnClickListener(cardBoxMemberPayActivity);
        View findViewById = this.f59368a.findViewById(R.id.empty_layout);
        this.o = findViewById;
        findViewById.setOnClickListener(cardBoxMemberPayActivity);
        this.f59369b = (TbImageView) this.f59368a.findViewById(R.id.title_image);
        this.f59370c = (TextView) this.f59368a.findViewById(R.id.title_info);
        this.f59371d = (HeadImageView) this.f59368a.findViewById(R.id.head_portrait);
        this.f59372e = (TextView) this.f59368a.findViewById(R.id.user_name);
        this.f59373f = (TextView) this.f59368a.findViewById(R.id.desc_info);
        this.f59374g = (LinearLayout) this.f59368a.findViewById(R.id.choice_month_info);
        this.f59375h = (TextView) this.f59368a.findViewById(R.id.before_discount);
        this.i = (TextView) this.f59368a.findViewById(R.id.after_discount);
        this.j = (TextView) this.f59368a.findViewById(R.id.discount_desc);
        TextView textView = (TextView) this.f59368a.findViewById(R.id.open_member_view);
        this.k = textView;
        textView.setOnClickListener(cardBoxMemberPayActivity);
        TextView textView2 = (TextView) this.f59368a.findViewById(R.id.card_box_member_agreement_view);
        this.l = textView2;
        textView2.setOnClickListener(cardBoxMemberPayActivity);
        this.f59375h.getPaint().setFlags(16);
        this.f59371d.setIsRound(true);
        this.f59371d.setDrawBorder(false);
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
        TextView textView = this.f59370c;
        if (textView != null) {
            return textView.getText().toString();
        }
        return null;
    }

    public void j(int i) {
        this.f59368a.getLayoutMode().k(i == 1);
        this.f59368a.getLayoutMode().j(this.m);
    }

    public final void k(f fVar) {
        f.b bVar;
        f.a aVar;
        if (fVar == null || (bVar = fVar.f59405b) == null || (aVar = bVar.f59412b) == null) {
            return;
        }
        this.p = aVar.f59406a;
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
        this.f59374g.removeAllViews();
        int size = this.p.size();
        for (int i = 0; i < size; i++) {
            f.d dVar = this.p.get(i);
            if (dVar != null) {
                TextView textView = new TextView(this.f59368a.getActivity());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2, 1.0f);
                layoutParams.setMargins(0, 0, (int) this.f59368a.getResources().getDimension(R.dimen.ds16), 0);
                textView.setLayoutParams(layoutParams);
                textView.setText(n(dVar.f59419b, 7));
                textView.setGravity(17);
                textView.setSingleLine(true);
                textView.setTextSize(0, this.f59368a.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                if (dVar.m) {
                    this.r = dVar.f59424g;
                    SkinManager.setViewTextColor(textView, R.color.CAM_X0312);
                    SkinManager.setBackgroundResource(textView, R.drawable.card_box_selected_bg);
                } else {
                    SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
                    SkinManager.setBackgroundResource(textView, R.drawable.card_box_normal_bg);
                }
                textView.setTag(dVar);
                textView.setOnClickListener(new View$OnClickListenerC1481a(this.p));
                this.f59374g.addView(textView);
            }
        }
    }

    public final void p() {
        if (this.q == null) {
            return;
        }
        TextView textView = this.i;
        textView.setText(this.f59368a.getResources().getString(R.string.yuan) + (this.q.j / 100));
        if (!k.isEmpty(this.q.f59421d)) {
            TextView textView2 = this.f59375h;
            textView2.setText(this.f59368a.getResources().getString(R.string.origin_price) + this.q.f59421d);
        }
        this.j.setText(this.q.f59423f);
    }

    public final void q(f fVar) {
        f.a aVar;
        if (fVar == null) {
            return;
        }
        f.g gVar = fVar.f59404a;
        if (gVar != null) {
            this.f59371d.W(gVar.f59429b, 12, false);
            this.f59372e.setText(fVar.f59404a.f59428a);
            f.e eVar = fVar.f59404a.f59430c;
            if (eVar != null) {
                if (eVar.f59426a > 0) {
                    this.k.setText(this.f59368a.getResources().getString(R.string.renew_now));
                }
                this.f59369b.W(fVar.f59404a.f59430c.f59427b, 21, false);
            }
        }
        f.b bVar = fVar.f59405b;
        if (bVar == null || (aVar = bVar.f59412b) == null) {
            return;
        }
        this.f59373f.setText(aVar.f59409d);
        this.f59370c.setText(fVar.f59405b.f59412b.f59408c);
    }
}
