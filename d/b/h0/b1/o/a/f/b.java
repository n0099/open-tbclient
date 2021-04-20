package d.b.h0.b1.o.a.f;

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
public class b extends d.b.h0.b1.o.a.f.a implements View.OnClickListener {
    public c u;

    /* loaded from: classes3.dex */
    public class a implements d.b.h0.b1.o.a.d.b {
        public a() {
        }

        @Override // d.b.h0.b1.o.a.d.b
        public void a() {
            try {
                b.this.i.f50388b.a(c.y.parse(b.this.u.o()));
            } catch (ParseException e2) {
                e2.printStackTrace();
            }
        }
    }

    public b(d.b.h0.b1.o.a.c.a aVar) {
        super(aVar.A);
        this.i = aVar;
        A(aVar.A);
    }

    public final void A(Context context) {
        s();
        o();
        n();
        d.b.h0.b1.o.a.d.a aVar = this.i.f50389c;
        if (aVar == null) {
            LayoutInflater.from(context).inflate(R.layout.pickerview_time, this.f50404f);
            TextView textView = (TextView) j(R.id.tvTitle);
            RelativeLayout relativeLayout = (RelativeLayout) j(R.id.rv_topbar);
            Button button = (Button) j(R.id.btnSubmit);
            Button button2 = (Button) j(R.id.btnCancel);
            button.setTag("submit");
            button2.setTag(QueryResponse.Options.CANCEL);
            button.setOnClickListener(this);
            button2.setOnClickListener(this);
            button.setText(TextUtils.isEmpty(this.i.B) ? context.getResources().getString(R.string.pickerview_submit) : this.i.B);
            button2.setText(TextUtils.isEmpty(this.i.C) ? context.getResources().getString(R.string.pickerview_cancel) : this.i.C);
            textView.setText(TextUtils.isEmpty(this.i.D) ? "" : this.i.D);
            button.setTextColor(this.i.E);
            button2.setTextColor(this.i.F);
            textView.setTextColor(this.i.G);
            relativeLayout.setBackgroundColor(this.i.I);
            button.setTextSize(this.i.J);
            button2.setTextSize(this.i.J);
            textView.setTextSize(this.i.K);
        } else {
            aVar.a(LayoutInflater.from(context).inflate(this.i.x, this.f50404f));
        }
        LinearLayout linearLayout = (LinearLayout) j(R.id.timepicker);
        linearLayout.setBackgroundColor(this.i.H);
        B(linearLayout);
    }

    public final void B(LinearLayout linearLayout) {
        int i;
        d.b.h0.b1.o.a.c.a aVar = this.i;
        c cVar = new c(linearLayout, aVar.f50390d, aVar.z, aVar.L);
        this.u = cVar;
        if (this.i.f50388b != null) {
            cVar.G(new a());
        }
        this.u.C(this.i.k);
        d.b.h0.b1.o.a.c.a aVar2 = this.i;
        int i2 = aVar2.f50394h;
        if (i2 != 0 && (i = aVar2.i) != 0 && i2 <= i) {
            G();
        }
        d.b.h0.b1.o.a.c.a aVar3 = this.i;
        Calendar calendar = aVar3.f50392f;
        if (calendar != null && aVar3.f50393g != null) {
            if (calendar.getTimeInMillis() <= this.i.f50393g.getTimeInMillis()) {
                F();
            } else {
                throw new IllegalArgumentException("startDate can't be later than endDate");
            }
        } else {
            d.b.h0.b1.o.a.c.a aVar4 = this.i;
            Calendar calendar2 = aVar4.f50392f;
            if (calendar2 != null) {
                if (calendar2.get(1) >= 1900) {
                    F();
                } else {
                    throw new IllegalArgumentException("The startDate can not as early as 1900");
                }
            } else {
                Calendar calendar3 = aVar4.f50393g;
                if (calendar3 != null) {
                    if (calendar3.get(1) <= 2100) {
                        F();
                    } else {
                        throw new IllegalArgumentException("The endDate should not be later than 2100");
                    }
                } else {
                    F();
                }
            }
        }
        I();
        c cVar2 = this.u;
        d.b.h0.b1.o.a.c.a aVar5 = this.i;
        cVar2.y(aVar5.l, aVar5.m, aVar5.n, aVar5.o, aVar5.p, aVar5.q);
        c cVar3 = this.u;
        d.b.h0.b1.o.a.c.a aVar6 = this.i;
        cVar3.N(aVar6.r, aVar6.s, aVar6.t, aVar6.u, aVar6.v, aVar6.w);
        v(this.i.S);
        this.u.s(this.i.j);
        this.u.u(this.i.O);
        this.u.w(this.i.U);
        this.u.A(this.i.Q);
        this.u.M(this.i.M);
        this.u.K(this.i.N);
        this.u.p(this.i.T);
    }

    public void E() {
        if (this.i.f50387a != null) {
            try {
                this.i.f50387a.a(c.y.parse(this.u.o()), this.q);
            } catch (ParseException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void F() {
        c cVar = this.u;
        d.b.h0.b1.o.a.c.a aVar = this.i;
        cVar.E(aVar.f50392f, aVar.f50393g);
        z();
    }

    public final void G() {
        this.u.I(this.i.f50394h);
        this.u.x(this.i.i);
    }

    public final void I() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = this.i.f50391e;
        if (calendar2 == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i = calendar.get(1);
            i2 = calendar.get(2);
            i3 = calendar.get(5);
            i4 = calendar.get(11);
            i5 = calendar.get(12);
            i6 = calendar.get(13);
        } else {
            i = calendar2.get(1);
            i2 = this.i.f50391e.get(2);
            i3 = this.i.f50391e.get(5);
            i4 = this.i.f50391e.get(11);
            i5 = this.i.f50391e.get(12);
            i6 = this.i.f50391e.get(13);
        }
        int i7 = i4;
        int i8 = i3;
        int i9 = i2;
        c cVar = this.u;
        cVar.D(i, i9, i8, i7, i5, i6);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals("submit")) {
            E();
        }
        f();
    }

    @Override // d.b.h0.b1.o.a.f.a
    public boolean p() {
        return this.i.R;
    }

    public final void z() {
        d.b.h0.b1.o.a.c.a aVar = this.i;
        if (aVar.f50392f != null && aVar.f50393g != null) {
            Calendar calendar = aVar.f50391e;
            if (calendar == null || calendar.getTimeInMillis() < this.i.f50392f.getTimeInMillis() || this.i.f50391e.getTimeInMillis() > this.i.f50393g.getTimeInMillis()) {
                d.b.h0.b1.o.a.c.a aVar2 = this.i;
                aVar2.f50391e = aVar2.f50392f;
                return;
            }
            return;
        }
        d.b.h0.b1.o.a.c.a aVar3 = this.i;
        Calendar calendar2 = aVar3.f50392f;
        if (calendar2 != null) {
            aVar3.f50391e = calendar2;
            return;
        }
        Calendar calendar3 = aVar3.f50393g;
        if (calendar3 != null) {
            aVar3.f50391e = calendar3;
        }
    }
}
