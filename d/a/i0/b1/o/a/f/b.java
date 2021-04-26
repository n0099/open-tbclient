package d.a.i0.b1.o.a.f;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import java.text.ParseException;
import java.util.Calendar;
/* loaded from: classes3.dex */
public class b extends d.a.i0.b1.o.a.f.a implements View.OnClickListener {
    public c u;

    /* loaded from: classes3.dex */
    public class a implements d.a.i0.b1.o.a.d.b {
        public a() {
        }

        @Override // d.a.i0.b1.o.a.d.b
        public void a() {
            try {
                b.this.f48312i.f48292b.a(c.y.parse(b.this.u.o()));
            } catch (ParseException e2) {
                e2.printStackTrace();
            }
        }
    }

    public b(d.a.i0.b1.o.a.c.a aVar) {
        super(aVar.A);
        this.f48312i = aVar;
        y(aVar.A);
    }

    public void A() {
        if (this.f48312i.f48291a != null) {
            try {
                this.f48312i.f48291a.a(c.y.parse(this.u.o()), this.q);
            } catch (ParseException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void B() {
        c cVar = this.u;
        d.a.i0.b1.o.a.c.a aVar = this.f48312i;
        cVar.E(aVar.f48296f, aVar.f48297g);
        x();
    }

    public final void F() {
        this.u.I(this.f48312i.f48298h);
        this.u.x(this.f48312i.f48299i);
    }

    public final void G() {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = this.f48312i.f48295e;
        if (calendar2 == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i2 = calendar.get(1);
            i3 = calendar.get(2);
            i4 = calendar.get(5);
            i5 = calendar.get(11);
            i6 = calendar.get(12);
            i7 = calendar.get(13);
        } else {
            i2 = calendar2.get(1);
            i3 = this.f48312i.f48295e.get(2);
            i4 = this.f48312i.f48295e.get(5);
            i5 = this.f48312i.f48295e.get(11);
            i6 = this.f48312i.f48295e.get(12);
            i7 = this.f48312i.f48295e.get(13);
        }
        int i8 = i5;
        int i9 = i4;
        int i10 = i3;
        c cVar = this.u;
        cVar.D(i2, i10, i9, i8, i6, i7);
    }

    @Override // d.a.i0.b1.o.a.f.a
    public boolean o() {
        return this.f48312i.R;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals("submit")) {
            A();
        }
        f();
    }

    public final void x() {
        d.a.i0.b1.o.a.c.a aVar = this.f48312i;
        if (aVar.f48296f != null && aVar.f48297g != null) {
            Calendar calendar = aVar.f48295e;
            if (calendar == null || calendar.getTimeInMillis() < this.f48312i.f48296f.getTimeInMillis() || this.f48312i.f48295e.getTimeInMillis() > this.f48312i.f48297g.getTimeInMillis()) {
                d.a.i0.b1.o.a.c.a aVar2 = this.f48312i;
                aVar2.f48295e = aVar2.f48296f;
                return;
            }
            return;
        }
        d.a.i0.b1.o.a.c.a aVar3 = this.f48312i;
        Calendar calendar2 = aVar3.f48296f;
        if (calendar2 != null) {
            aVar3.f48295e = calendar2;
            return;
        }
        Calendar calendar3 = aVar3.f48297g;
        if (calendar3 != null) {
            aVar3.f48295e = calendar3;
        }
    }

    public final void y(Context context) {
        r();
        n();
        m();
        d.a.i0.b1.o.a.d.a aVar = this.f48312i.f48293c;
        if (aVar == null) {
            LayoutInflater.from(context).inflate(R.layout.pickerview_time, this.f48309f);
            TextView textView = (TextView) i(R.id.tvTitle);
            RelativeLayout relativeLayout = (RelativeLayout) i(R.id.rv_topbar);
            Button button = (Button) i(R.id.btnSubmit);
            Button button2 = (Button) i(R.id.btnCancel);
            button.setTag("submit");
            button2.setTag(QueryResponse.Options.CANCEL);
            button.setOnClickListener(this);
            button2.setOnClickListener(this);
            button.setText(TextUtils.isEmpty(this.f48312i.B) ? context.getResources().getString(R.string.pickerview_submit) : this.f48312i.B);
            button2.setText(TextUtils.isEmpty(this.f48312i.C) ? context.getResources().getString(R.string.pickerview_cancel) : this.f48312i.C);
            textView.setText(TextUtils.isEmpty(this.f48312i.D) ? "" : this.f48312i.D);
            button.setTextColor(this.f48312i.E);
            button2.setTextColor(this.f48312i.F);
            textView.setTextColor(this.f48312i.G);
            relativeLayout.setBackgroundColor(this.f48312i.I);
            button.setTextSize(this.f48312i.J);
            button2.setTextSize(this.f48312i.J);
            textView.setTextSize(this.f48312i.K);
        } else {
            aVar.a(LayoutInflater.from(context).inflate(this.f48312i.x, this.f48309f));
        }
        LinearLayout linearLayout = (LinearLayout) i(R.id.timepicker);
        linearLayout.setBackgroundColor(this.f48312i.H);
        z(linearLayout);
    }

    public final void z(LinearLayout linearLayout) {
        int i2;
        d.a.i0.b1.o.a.c.a aVar = this.f48312i;
        c cVar = new c(linearLayout, aVar.f48294d, aVar.z, aVar.L);
        this.u = cVar;
        if (this.f48312i.f48292b != null) {
            cVar.G(new a());
        }
        this.u.C(this.f48312i.k);
        d.a.i0.b1.o.a.c.a aVar2 = this.f48312i;
        int i3 = aVar2.f48298h;
        if (i3 != 0 && (i2 = aVar2.f48299i) != 0 && i3 <= i2) {
            F();
        }
        d.a.i0.b1.o.a.c.a aVar3 = this.f48312i;
        Calendar calendar = aVar3.f48296f;
        if (calendar != null && aVar3.f48297g != null) {
            if (calendar.getTimeInMillis() <= this.f48312i.f48297g.getTimeInMillis()) {
                B();
            } else {
                throw new IllegalArgumentException("startDate can't be later than endDate");
            }
        } else {
            d.a.i0.b1.o.a.c.a aVar4 = this.f48312i;
            Calendar calendar2 = aVar4.f48296f;
            if (calendar2 != null) {
                if (calendar2.get(1) >= 1900) {
                    B();
                } else {
                    throw new IllegalArgumentException("The startDate can not as early as 1900");
                }
            } else {
                Calendar calendar3 = aVar4.f48297g;
                if (calendar3 != null) {
                    if (calendar3.get(1) <= 2100) {
                        B();
                    } else {
                        throw new IllegalArgumentException("The endDate should not be later than 2100");
                    }
                } else {
                    B();
                }
            }
        }
        G();
        c cVar2 = this.u;
        d.a.i0.b1.o.a.c.a aVar5 = this.f48312i;
        cVar2.y(aVar5.l, aVar5.m, aVar5.n, aVar5.o, aVar5.p, aVar5.q);
        c cVar3 = this.u;
        d.a.i0.b1.o.a.c.a aVar6 = this.f48312i;
        cVar3.N(aVar6.r, aVar6.s, aVar6.t, aVar6.u, aVar6.v, aVar6.w);
        t(this.f48312i.S);
        this.u.s(this.f48312i.j);
        this.u.u(this.f48312i.O);
        this.u.w(this.f48312i.U);
        this.u.A(this.f48312i.Q);
        this.u.M(this.f48312i.M);
        this.u.K(this.f48312i.N);
        this.u.p(this.f48312i.T);
    }
}
