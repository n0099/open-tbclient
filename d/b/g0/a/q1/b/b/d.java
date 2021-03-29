package d.b.g0.a.q1.b.b;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.res.ui.BdDatePicker;
import d.b.g0.a.q1.b.b.h;
import java.util.Date;
/* loaded from: classes2.dex */
public class d extends h {

    /* renamed from: g  reason: collision with root package name */
    public BdDatePicker f45561g;

    /* renamed from: h  reason: collision with root package name */
    public int f45562h;
    public int i;
    public int j;
    public String k;
    public boolean l;
    public Date m;
    public Date n;

    /* loaded from: classes2.dex */
    public static class a extends h.a {

        /* renamed from: e  reason: collision with root package name */
        public Date f45563e;

        /* renamed from: f  reason: collision with root package name */
        public Date f45564f;

        /* renamed from: g  reason: collision with root package name */
        public Date f45565g;

        /* renamed from: h  reason: collision with root package name */
        public String f45566h;
        public boolean i;

        public a(Context context) {
            super(context);
        }

        @Override // d.b.g0.a.q1.b.b.h.a
        public h a() {
            d dVar = (d) super.a();
            dVar.n(this.f45566h);
            dVar.l(this.i);
            Date date = this.f45565g;
            if (date != null) {
                dVar.q(date.getYear() + 1900);
                dVar.o(this.f45565g.getMonth() + 1);
                dVar.k(this.f45565g.getDate());
            }
            Date date2 = this.f45563e;
            if (date2 != null) {
                dVar.p(date2);
            }
            Date date3 = this.f45564f;
            if (date3 != null) {
                dVar.m(date3);
            }
            return dVar;
        }

        @Override // d.b.g0.a.q1.b.b.h.a
        public h b(Context context) {
            return new d(context);
        }

        public a k(boolean z) {
            this.i = z;
            return this;
        }

        public a l(Date date) {
            this.f45564f = date;
            return this;
        }

        public a m(String str) {
            this.f45566h = str;
            return this;
        }

        public a n(Date date) {
            this.f45565g = date;
            return this;
        }

        public a o(Date date) {
            this.f45563e = date;
            return this;
        }
    }

    public d(Context context) {
        super(context, d.b.g0.a.i.NoTitleDialog);
    }

    public final void e() {
        this.f45561g = new BdDatePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.f45561g.setLayoutParams(layoutParams);
        this.f45561g.setScrollCycle(true);
        this.f45561g.setStartDate(this.m);
        this.f45561g.setEndDate(this.n);
        this.f45561g.setYear(this.f45562h);
        this.f45561g.setMonth(this.i);
        this.f45561g.setDay(this.j);
        this.f45561g.n();
        this.f45561g.setFields(this.k);
        this.f45561g.setDisabled(this.l);
    }

    public int f() {
        return this.f45561g.getDay();
    }

    public int g() {
        return this.f45561g.getMonth();
    }

    public String h() {
        StringBuilder sb = new StringBuilder();
        if (j("year")) {
            sb.append(String.format("%d-", Integer.valueOf(i())));
        }
        if (j("month")) {
            sb.append(String.format("%02d-", Integer.valueOf(g())));
        }
        if (j(Config.TRACE_VISIT_RECENT_DAY)) {
            sb.append(String.format("%02d", Integer.valueOf(f())));
        }
        String sb2 = sb.toString();
        return sb2.endsWith("-") ? sb2.substring(0, sb2.length() - 1) : sb2;
    }

    public int i() {
        return this.f45561g.getYear();
    }

    public final boolean j(String str) {
        return this.f45561g.l(str);
    }

    public void k(int i) {
        this.j = i;
    }

    public void l(boolean z) {
        this.l = z;
    }

    public void m(Date date) {
        this.n = date;
    }

    public void n(String str) {
        this.k = str;
    }

    public void o(int i) {
        this.i = i;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        e();
        b().i(this.f45561g);
    }

    public void p(Date date) {
        this.m = date;
    }

    public void q(int i) {
        this.f45562h = i;
    }

    @Override // d.b.g0.a.q1.b.b.c, android.app.Dialog
    public void show() {
        super.show();
    }
}
