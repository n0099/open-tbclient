package d.a.m0.b1.o.a.f;

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
public class b extends d.a.m0.b1.o.a.f.a implements View.OnClickListener {
    public c u;

    /* loaded from: classes3.dex */
    public class a implements d.a.m0.b1.o.a.d.b {
        public a() {
        }

        @Override // d.a.m0.b1.o.a.d.b
        public void a() {
            try {
                b.this.f52839i.f52819b.a(c.y.parse(b.this.u.o()));
            } catch (ParseException e2) {
                e2.printStackTrace();
            }
        }
    }

    public b(d.a.m0.b1.o.a.c.a aVar) {
        super(aVar.A);
        this.f52839i = aVar;
        z(aVar.A);
    }

    public final void A(LinearLayout linearLayout) {
        int i2;
        d.a.m0.b1.o.a.c.a aVar = this.f52839i;
        c cVar = new c(linearLayout, aVar.f52821d, aVar.z, aVar.L);
        this.u = cVar;
        if (this.f52839i.f52819b != null) {
            cVar.G(new a());
        }
        this.u.C(this.f52839i.k);
        d.a.m0.b1.o.a.c.a aVar2 = this.f52839i;
        int i3 = aVar2.f52825h;
        if (i3 != 0 && (i2 = aVar2.f52826i) != 0 && i3 <= i2) {
            G();
        }
        d.a.m0.b1.o.a.c.a aVar3 = this.f52839i;
        Calendar calendar = aVar3.f52823f;
        if (calendar != null && aVar3.f52824g != null) {
            if (calendar.getTimeInMillis() <= this.f52839i.f52824g.getTimeInMillis()) {
                F();
            } else {
                throw new IllegalArgumentException("startDate can't be later than endDate");
            }
        } else {
            d.a.m0.b1.o.a.c.a aVar4 = this.f52839i;
            Calendar calendar2 = aVar4.f52823f;
            if (calendar2 != null) {
                if (calendar2.get(1) >= 1900) {
                    F();
                } else {
                    throw new IllegalArgumentException("The startDate can not as early as 1900");
                }
            } else {
                Calendar calendar3 = aVar4.f52824g;
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
        d.a.m0.b1.o.a.c.a aVar5 = this.f52839i;
        cVar2.y(aVar5.l, aVar5.m, aVar5.n, aVar5.o, aVar5.p, aVar5.q);
        c cVar3 = this.u;
        d.a.m0.b1.o.a.c.a aVar6 = this.f52839i;
        cVar3.N(aVar6.r, aVar6.s, aVar6.t, aVar6.u, aVar6.v, aVar6.w);
        u(this.f52839i.S);
        this.u.s(this.f52839i.j);
        this.u.u(this.f52839i.O);
        this.u.w(this.f52839i.U);
        this.u.A(this.f52839i.Q);
        this.u.M(this.f52839i.M);
        this.u.K(this.f52839i.N);
        this.u.p(this.f52839i.T);
    }

    public void B() {
        if (this.f52839i.f52818a != null) {
            try {
                this.f52839i.f52818a.a(c.y.parse(this.u.o()), this.q);
            } catch (ParseException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void F() {
        c cVar = this.u;
        d.a.m0.b1.o.a.c.a aVar = this.f52839i;
        cVar.E(aVar.f52823f, aVar.f52824g);
        y();
    }

    public final void G() {
        this.u.I(this.f52839i.f52825h);
        this.u.x(this.f52839i.f52826i);
    }

    public final void H() {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = this.f52839i.f52822e;
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
            i3 = this.f52839i.f52822e.get(2);
            i4 = this.f52839i.f52822e.get(5);
            i5 = this.f52839i.f52822e.get(11);
            i6 = this.f52839i.f52822e.get(12);
            i7 = this.f52839i.f52822e.get(13);
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

    @Override // d.a.m0.b1.o.a.f.a
    public boolean p() {
        return this.f52839i.R;
    }

    public final void y() {
        d.a.m0.b1.o.a.c.a aVar = this.f52839i;
        if (aVar.f52823f != null && aVar.f52824g != null) {
            Calendar calendar = aVar.f52822e;
            if (calendar == null || calendar.getTimeInMillis() < this.f52839i.f52823f.getTimeInMillis() || this.f52839i.f52822e.getTimeInMillis() > this.f52839i.f52824g.getTimeInMillis()) {
                d.a.m0.b1.o.a.c.a aVar2 = this.f52839i;
                aVar2.f52822e = aVar2.f52823f;
                return;
            }
            return;
        }
        d.a.m0.b1.o.a.c.a aVar3 = this.f52839i;
        Calendar calendar2 = aVar3.f52823f;
        if (calendar2 != null) {
            aVar3.f52822e = calendar2;
            return;
        }
        Calendar calendar3 = aVar3.f52824g;
        if (calendar3 != null) {
            aVar3.f52822e = calendar3;
        }
    }

    public final void z(Context context) {
        s();
        o();
        n();
        d.a.m0.b1.o.a.d.a aVar = this.f52839i.f52820c;
        if (aVar == null) {
            LayoutInflater.from(context).inflate(R.layout.pickerview_time, this.f52836f);
            TextView textView = (TextView) j(R.id.tvTitle);
            RelativeLayout relativeLayout = (RelativeLayout) j(R.id.rv_topbar);
            Button button = (Button) j(R.id.btnSubmit);
            Button button2 = (Button) j(R.id.btnCancel);
            button.setTag("submit");
            button2.setTag(QueryResponse.Options.CANCEL);
            button.setOnClickListener(this);
            button2.setOnClickListener(this);
            button.setText(TextUtils.isEmpty(this.f52839i.B) ? context.getResources().getString(R.string.pickerview_submit) : this.f52839i.B);
            button2.setText(TextUtils.isEmpty(this.f52839i.C) ? context.getResources().getString(R.string.pickerview_cancel) : this.f52839i.C);
            textView.setText(TextUtils.isEmpty(this.f52839i.D) ? "" : this.f52839i.D);
            button.setTextColor(this.f52839i.E);
            button2.setTextColor(this.f52839i.F);
            textView.setTextColor(this.f52839i.G);
            relativeLayout.setBackgroundColor(this.f52839i.I);
            button.setTextSize(this.f52839i.J);
            button2.setTextSize(this.f52839i.J);
            textView.setTextSize(this.f52839i.K);
        } else {
            aVar.a(LayoutInflater.from(context).inflate(this.f52839i.x, this.f52836f));
        }
        LinearLayout linearLayout = (LinearLayout) j(R.id.timepicker);
        linearLayout.setBackgroundColor(this.f52839i.H);
        A(linearLayout);
    }
}
