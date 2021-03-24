package d.b.g0.a.q1.b.b;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.res.ui.BdDatePicker;
import d.b.g0.a.q1.b.b.h;
import java.util.Date;
/* loaded from: classes3.dex */
public class d extends h {

    /* renamed from: g  reason: collision with root package name */
    public BdDatePicker f45560g;

    /* renamed from: h  reason: collision with root package name */
    public int f45561h;
    public int i;
    public int j;
    public String k;
    public boolean l;
    public Date m;
    public Date n;

    /* loaded from: classes3.dex */
    public static class a extends h.a {

        /* renamed from: e  reason: collision with root package name */
        public Date f45562e;

        /* renamed from: f  reason: collision with root package name */
        public Date f45563f;

        /* renamed from: g  reason: collision with root package name */
        public Date f45564g;

        /* renamed from: h  reason: collision with root package name */
        public String f45565h;
        public boolean i;

        public a(Context context) {
            super(context);
        }

        @Override // d.b.g0.a.q1.b.b.h.a
        public h a() {
            d dVar = (d) super.a();
            dVar.n(this.f45565h);
            dVar.l(this.i);
            Date date = this.f45564g;
            if (date != null) {
                dVar.q(date.getYear() + 1900);
                dVar.o(this.f45564g.getMonth() + 1);
                dVar.k(this.f45564g.getDate());
            }
            Date date2 = this.f45562e;
            if (date2 != null) {
                dVar.p(date2);
            }
            Date date3 = this.f45563f;
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
            this.f45563f = date;
            return this;
        }

        public a m(String str) {
            this.f45565h = str;
            return this;
        }

        public a n(Date date) {
            this.f45564g = date;
            return this;
        }

        public a o(Date date) {
            this.f45562e = date;
            return this;
        }
    }

    public d(Context context) {
        super(context, d.b.g0.a.i.NoTitleDialog);
    }

    public final void e() {
        this.f45560g = new BdDatePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.f45560g.setLayoutParams(layoutParams);
        this.f45560g.setScrollCycle(true);
        this.f45560g.setStartDate(this.m);
        this.f45560g.setEndDate(this.n);
        this.f45560g.setYear(this.f45561h);
        this.f45560g.setMonth(this.i);
        this.f45560g.setDay(this.j);
        this.f45560g.n();
        this.f45560g.setFields(this.k);
        this.f45560g.setDisabled(this.l);
    }

    public int f() {
        return this.f45560g.getDay();
    }

    public int g() {
        return this.f45560g.getMonth();
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
        return this.f45560g.getYear();
    }

    public final boolean j(String str) {
        return this.f45560g.l(str);
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
        b().i(this.f45560g);
    }

    public void p(Date date) {
        this.m = date;
    }

    public void q(int i) {
        this.f45561h = i;
    }

    @Override // d.b.g0.a.q1.b.b.c, android.app.Dialog
    public void show() {
        super.show();
    }
}
