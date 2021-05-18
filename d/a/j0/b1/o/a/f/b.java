package d.a.j0.b1.o.a.f;

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
public class b extends d.a.j0.b1.o.a.f.a implements View.OnClickListener {
    public c u;

    /* loaded from: classes3.dex */
    public class a implements d.a.j0.b1.o.a.d.b {
        public a() {
        }

        @Override // d.a.j0.b1.o.a.d.b
        public void a() {
            try {
                b.this.f49140i.f49120b.a(c.y.parse(b.this.u.o()));
            } catch (ParseException e2) {
                e2.printStackTrace();
            }
        }
    }

    public b(d.a.j0.b1.o.a.c.a aVar) {
        super(aVar.A);
        this.f49140i = aVar;
        y(aVar.A);
    }

    public void A() {
        if (this.f49140i.f49119a != null) {
            try {
                this.f49140i.f49119a.a(c.y.parse(this.u.o()), this.q);
            } catch (ParseException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void B() {
        c cVar = this.u;
        d.a.j0.b1.o.a.c.a aVar = this.f49140i;
        cVar.E(aVar.f49124f, aVar.f49125g);
        x();
    }

    public final void F() {
        this.u.I(this.f49140i.f49126h);
        this.u.x(this.f49140i.f49127i);
    }

    public final void G() {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = this.f49140i.f49123e;
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
            i3 = this.f49140i.f49123e.get(2);
            i4 = this.f49140i.f49123e.get(5);
            i5 = this.f49140i.f49123e.get(11);
            i6 = this.f49140i.f49123e.get(12);
            i7 = this.f49140i.f49123e.get(13);
        }
        int i8 = i5;
        int i9 = i4;
        int i10 = i3;
        c cVar = this.u;
        cVar.D(i2, i10, i9, i8, i6, i7);
    }

    @Override // d.a.j0.b1.o.a.f.a
    public boolean o() {
        return this.f49140i.R;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals("submit")) {
            A();
        }
        f();
    }

    public final void x() {
        d.a.j0.b1.o.a.c.a aVar = this.f49140i;
        if (aVar.f49124f != null && aVar.f49125g != null) {
            Calendar calendar = aVar.f49123e;
            if (calendar == null || calendar.getTimeInMillis() < this.f49140i.f49124f.getTimeInMillis() || this.f49140i.f49123e.getTimeInMillis() > this.f49140i.f49125g.getTimeInMillis()) {
                d.a.j0.b1.o.a.c.a aVar2 = this.f49140i;
                aVar2.f49123e = aVar2.f49124f;
                return;
            }
            return;
        }
        d.a.j0.b1.o.a.c.a aVar3 = this.f49140i;
        Calendar calendar2 = aVar3.f49124f;
        if (calendar2 != null) {
            aVar3.f49123e = calendar2;
            return;
        }
        Calendar calendar3 = aVar3.f49125g;
        if (calendar3 != null) {
            aVar3.f49123e = calendar3;
        }
    }

    public final void y(Context context) {
        r();
        n();
        m();
        d.a.j0.b1.o.a.d.a aVar = this.f49140i.f49121c;
        if (aVar == null) {
            LayoutInflater.from(context).inflate(R.layout.pickerview_time, this.f49137f);
            TextView textView = (TextView) i(R.id.tvTitle);
            RelativeLayout relativeLayout = (RelativeLayout) i(R.id.rv_topbar);
            Button button = (Button) i(R.id.btnSubmit);
            Button button2 = (Button) i(R.id.btnCancel);
            button.setTag("submit");
            button2.setTag(QueryResponse.Options.CANCEL);
            button.setOnClickListener(this);
            button2.setOnClickListener(this);
            button.setText(TextUtils.isEmpty(this.f49140i.B) ? context.getResources().getString(R.string.pickerview_submit) : this.f49140i.B);
            button2.setText(TextUtils.isEmpty(this.f49140i.C) ? context.getResources().getString(R.string.pickerview_cancel) : this.f49140i.C);
            textView.setText(TextUtils.isEmpty(this.f49140i.D) ? "" : this.f49140i.D);
            button.setTextColor(this.f49140i.E);
            button2.setTextColor(this.f49140i.F);
            textView.setTextColor(this.f49140i.G);
            relativeLayout.setBackgroundColor(this.f49140i.I);
            button.setTextSize(this.f49140i.J);
            button2.setTextSize(this.f49140i.J);
            textView.setTextSize(this.f49140i.K);
        } else {
            aVar.a(LayoutInflater.from(context).inflate(this.f49140i.x, this.f49137f));
        }
        LinearLayout linearLayout = (LinearLayout) i(R.id.timepicker);
        linearLayout.setBackgroundColor(this.f49140i.H);
        z(linearLayout);
    }

    public final void z(LinearLayout linearLayout) {
        int i2;
        d.a.j0.b1.o.a.c.a aVar = this.f49140i;
        c cVar = new c(linearLayout, aVar.f49122d, aVar.z, aVar.L);
        this.u = cVar;
        if (this.f49140i.f49120b != null) {
            cVar.G(new a());
        }
        this.u.C(this.f49140i.k);
        d.a.j0.b1.o.a.c.a aVar2 = this.f49140i;
        int i3 = aVar2.f49126h;
        if (i3 != 0 && (i2 = aVar2.f49127i) != 0 && i3 <= i2) {
            F();
        }
        d.a.j0.b1.o.a.c.a aVar3 = this.f49140i;
        Calendar calendar = aVar3.f49124f;
        if (calendar != null && aVar3.f49125g != null) {
            if (calendar.getTimeInMillis() <= this.f49140i.f49125g.getTimeInMillis()) {
                B();
            } else {
                throw new IllegalArgumentException("startDate can't be later than endDate");
            }
        } else {
            d.a.j0.b1.o.a.c.a aVar4 = this.f49140i;
            Calendar calendar2 = aVar4.f49124f;
            if (calendar2 != null) {
                if (calendar2.get(1) >= 1900) {
                    B();
                } else {
                    throw new IllegalArgumentException("The startDate can not as early as 1900");
                }
            } else {
                Calendar calendar3 = aVar4.f49125g;
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
        d.a.j0.b1.o.a.c.a aVar5 = this.f49140i;
        cVar2.y(aVar5.l, aVar5.m, aVar5.n, aVar5.o, aVar5.p, aVar5.q);
        c cVar3 = this.u;
        d.a.j0.b1.o.a.c.a aVar6 = this.f49140i;
        cVar3.N(aVar6.r, aVar6.s, aVar6.t, aVar6.u, aVar6.v, aVar6.w);
        t(this.f49140i.S);
        this.u.s(this.f49140i.j);
        this.u.u(this.f49140i.O);
        this.u.w(this.f49140i.U);
        this.u.A(this.f49140i.Q);
        this.u.M(this.f49140i.M);
        this.u.K(this.f49140i.N);
        this.u.p(this.f49140i.T);
    }
}
