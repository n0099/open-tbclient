package d.a.n0.b1.o.a.f;

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
public class b extends d.a.n0.b1.o.a.f.a implements View.OnClickListener {
    public c u;

    /* loaded from: classes3.dex */
    public class a implements d.a.n0.b1.o.a.d.b {
        public a() {
        }

        @Override // d.a.n0.b1.o.a.d.b
        public void a() {
            try {
                b.this.f52946i.f52926b.a(c.y.parse(b.this.u.o()));
            } catch (ParseException e2) {
                e2.printStackTrace();
            }
        }
    }

    public b(d.a.n0.b1.o.a.c.a aVar) {
        super(aVar.A);
        this.f52946i = aVar;
        z(aVar.A);
    }

    public final void A(LinearLayout linearLayout) {
        int i2;
        d.a.n0.b1.o.a.c.a aVar = this.f52946i;
        c cVar = new c(linearLayout, aVar.f52928d, aVar.z, aVar.L);
        this.u = cVar;
        if (this.f52946i.f52926b != null) {
            cVar.G(new a());
        }
        this.u.C(this.f52946i.k);
        d.a.n0.b1.o.a.c.a aVar2 = this.f52946i;
        int i3 = aVar2.f52932h;
        if (i3 != 0 && (i2 = aVar2.f52933i) != 0 && i3 <= i2) {
            G();
        }
        d.a.n0.b1.o.a.c.a aVar3 = this.f52946i;
        Calendar calendar = aVar3.f52930f;
        if (calendar != null && aVar3.f52931g != null) {
            if (calendar.getTimeInMillis() <= this.f52946i.f52931g.getTimeInMillis()) {
                F();
            } else {
                throw new IllegalArgumentException("startDate can't be later than endDate");
            }
        } else {
            d.a.n0.b1.o.a.c.a aVar4 = this.f52946i;
            Calendar calendar2 = aVar4.f52930f;
            if (calendar2 != null) {
                if (calendar2.get(1) >= 1900) {
                    F();
                } else {
                    throw new IllegalArgumentException("The startDate can not as early as 1900");
                }
            } else {
                Calendar calendar3 = aVar4.f52931g;
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
        H();
        c cVar2 = this.u;
        d.a.n0.b1.o.a.c.a aVar5 = this.f52946i;
        cVar2.y(aVar5.l, aVar5.m, aVar5.n, aVar5.o, aVar5.p, aVar5.q);
        c cVar3 = this.u;
        d.a.n0.b1.o.a.c.a aVar6 = this.f52946i;
        cVar3.N(aVar6.r, aVar6.s, aVar6.t, aVar6.u, aVar6.v, aVar6.w);
        u(this.f52946i.S);
        this.u.s(this.f52946i.j);
        this.u.u(this.f52946i.O);
        this.u.w(this.f52946i.U);
        this.u.A(this.f52946i.Q);
        this.u.M(this.f52946i.M);
        this.u.K(this.f52946i.N);
        this.u.p(this.f52946i.T);
    }

    public void B() {
        if (this.f52946i.f52925a != null) {
            try {
                this.f52946i.f52925a.a(c.y.parse(this.u.o()), this.q);
            } catch (ParseException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void F() {
        c cVar = this.u;
        d.a.n0.b1.o.a.c.a aVar = this.f52946i;
        cVar.E(aVar.f52930f, aVar.f52931g);
        y();
    }

    public final void G() {
        this.u.I(this.f52946i.f52932h);
        this.u.x(this.f52946i.f52933i);
    }

    public final void H() {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = this.f52946i.f52929e;
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
            i3 = this.f52946i.f52929e.get(2);
            i4 = this.f52946i.f52929e.get(5);
            i5 = this.f52946i.f52929e.get(11);
            i6 = this.f52946i.f52929e.get(12);
            i7 = this.f52946i.f52929e.get(13);
        }
        int i8 = i5;
        int i9 = i4;
        int i10 = i3;
        c cVar = this.u;
        cVar.D(i2, i10, i9, i8, i6, i7);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals("submit")) {
            B();
        }
        f();
    }

    @Override // d.a.n0.b1.o.a.f.a
    public boolean p() {
        return this.f52946i.R;
    }

    public final void y() {
        d.a.n0.b1.o.a.c.a aVar = this.f52946i;
        if (aVar.f52930f != null && aVar.f52931g != null) {
            Calendar calendar = aVar.f52929e;
            if (calendar == null || calendar.getTimeInMillis() < this.f52946i.f52930f.getTimeInMillis() || this.f52946i.f52929e.getTimeInMillis() > this.f52946i.f52931g.getTimeInMillis()) {
                d.a.n0.b1.o.a.c.a aVar2 = this.f52946i;
                aVar2.f52929e = aVar2.f52930f;
                return;
            }
            return;
        }
        d.a.n0.b1.o.a.c.a aVar3 = this.f52946i;
        Calendar calendar2 = aVar3.f52930f;
        if (calendar2 != null) {
            aVar3.f52929e = calendar2;
            return;
        }
        Calendar calendar3 = aVar3.f52931g;
        if (calendar3 != null) {
            aVar3.f52929e = calendar3;
        }
    }

    public final void z(Context context) {
        s();
        o();
        n();
        d.a.n0.b1.o.a.d.a aVar = this.f52946i.f52927c;
        if (aVar == null) {
            LayoutInflater.from(context).inflate(R.layout.pickerview_time, this.f52943f);
            TextView textView = (TextView) j(R.id.tvTitle);
            RelativeLayout relativeLayout = (RelativeLayout) j(R.id.rv_topbar);
            Button button = (Button) j(R.id.btnSubmit);
            Button button2 = (Button) j(R.id.btnCancel);
            button.setTag("submit");
            button2.setTag(QueryResponse.Options.CANCEL);
            button.setOnClickListener(this);
            button2.setOnClickListener(this);
            button.setText(TextUtils.isEmpty(this.f52946i.B) ? context.getResources().getString(R.string.pickerview_submit) : this.f52946i.B);
            button2.setText(TextUtils.isEmpty(this.f52946i.C) ? context.getResources().getString(R.string.pickerview_cancel) : this.f52946i.C);
            textView.setText(TextUtils.isEmpty(this.f52946i.D) ? "" : this.f52946i.D);
            button.setTextColor(this.f52946i.E);
            button2.setTextColor(this.f52946i.F);
            textView.setTextColor(this.f52946i.G);
            relativeLayout.setBackgroundColor(this.f52946i.I);
            button.setTextSize(this.f52946i.J);
            button2.setTextSize(this.f52946i.J);
            textView.setTextSize(this.f52946i.K);
        } else {
            aVar.a(LayoutInflater.from(context).inflate(this.f52946i.x, this.f52943f));
        }
        LinearLayout linearLayout = (LinearLayout) j(R.id.timepicker);
        linearLayout.setBackgroundColor(this.f52946i.H);
        A(linearLayout);
    }
}
