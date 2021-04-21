package d.b.h0.a.q1.b.b;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.res.ui.BdDatePicker;
import d.b.h0.a.q1.b.b.h;
import java.util.Date;
/* loaded from: classes3.dex */
public class d extends h {

    /* renamed from: g  reason: collision with root package name */
    public BdDatePicker f46282g;

    /* renamed from: h  reason: collision with root package name */
    public int f46283h;
    public int i;
    public int j;
    public String k;
    public boolean l;
    public Date m;
    public Date n;

    /* loaded from: classes3.dex */
    public static class a extends h.a {

        /* renamed from: e  reason: collision with root package name */
        public Date f46284e;

        /* renamed from: f  reason: collision with root package name */
        public Date f46285f;

        /* renamed from: g  reason: collision with root package name */
        public Date f46286g;

        /* renamed from: h  reason: collision with root package name */
        public String f46287h;
        public boolean i;

        public a(Context context) {
            super(context);
        }

        @Override // d.b.h0.a.q1.b.b.h.a
        public h a() {
            d dVar = (d) super.a();
            dVar.n(this.f46287h);
            dVar.l(this.i);
            Date date = this.f46286g;
            if (date != null) {
                dVar.q(date.getYear() + 1900);
                dVar.o(this.f46286g.getMonth() + 1);
                dVar.k(this.f46286g.getDate());
            }
            Date date2 = this.f46284e;
            if (date2 != null) {
                dVar.p(date2);
            }
            Date date3 = this.f46285f;
            if (date3 != null) {
                dVar.m(date3);
            }
            return dVar;
        }

        @Override // d.b.h0.a.q1.b.b.h.a
        public h b(Context context) {
            return new d(context);
        }

        public a k(boolean z) {
            this.i = z;
            return this;
        }

        public a l(Date date) {
            this.f46285f = date;
            return this;
        }

        public a m(String str) {
            this.f46287h = str;
            return this;
        }

        public a n(Date date) {
            this.f46286g = date;
            return this;
        }

        public a o(Date date) {
            this.f46284e = date;
            return this;
        }
    }

    public d(Context context) {
        super(context, d.b.h0.a.i.NoTitleDialog);
    }

    public final void e() {
        this.f46282g = new BdDatePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.f46282g.setLayoutParams(layoutParams);
        this.f46282g.setScrollCycle(true);
        this.f46282g.setStartDate(this.m);
        this.f46282g.setEndDate(this.n);
        this.f46282g.setYear(this.f46283h);
        this.f46282g.setMonth(this.i);
        this.f46282g.setDay(this.j);
        this.f46282g.n();
        this.f46282g.setFields(this.k);
        this.f46282g.setDisabled(this.l);
    }

    public int f() {
        return this.f46282g.getDay();
    }

    public int g() {
        return this.f46282g.getMonth();
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
        return this.f46282g.getYear();
    }

    public final boolean j(String str) {
        return this.f46282g.l(str);
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
        b().i(this.f46282g);
    }

    public void p(Date date) {
        this.m = date;
    }

    public void q(int i) {
        this.f46283h = i;
    }

    @Override // d.b.h0.a.q1.b.b.c, android.app.Dialog
    public void show() {
        super.show();
    }
}
