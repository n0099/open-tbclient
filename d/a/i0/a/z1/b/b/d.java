package d.a.i0.a.z1.b.b;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.res.ui.BdDatePicker;
import com.google.gson.internal.bind.TypeAdapters;
import d.a.i0.a.z1.b.b.i;
import java.util.Date;
/* loaded from: classes3.dex */
public class d extends i {

    /* renamed from: g  reason: collision with root package name */
    public BdDatePicker f45887g;

    /* renamed from: h  reason: collision with root package name */
    public int f45888h;

    /* renamed from: i  reason: collision with root package name */
    public int f45889i;
    public int j;
    public String k;
    public boolean l;
    public Date m;
    public Date n;

    /* loaded from: classes3.dex */
    public static class a extends i.a {

        /* renamed from: e  reason: collision with root package name */
        public Date f45890e;

        /* renamed from: f  reason: collision with root package name */
        public Date f45891f;

        /* renamed from: g  reason: collision with root package name */
        public Date f45892g;

        /* renamed from: h  reason: collision with root package name */
        public String f45893h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f45894i;

        public a(Context context) {
            super(context);
        }

        @Override // d.a.i0.a.z1.b.b.i.a
        public i a() {
            d dVar = (d) super.a();
            dVar.n(this.f45893h);
            dVar.l(this.f45894i);
            Date date = this.f45892g;
            if (date != null) {
                dVar.q(date.getYear() + 1900);
                dVar.o(this.f45892g.getMonth() + 1);
                dVar.k(this.f45892g.getDate());
            }
            Date date2 = this.f45890e;
            if (date2 != null) {
                dVar.p(date2);
            }
            Date date3 = this.f45891f;
            if (date3 != null) {
                dVar.m(date3);
            }
            return dVar;
        }

        @Override // d.a.i0.a.z1.b.b.i.a
        public i b(Context context) {
            return new d(context);
        }

        public a l(boolean z) {
            this.f45894i = z;
            return this;
        }

        public a m(Date date) {
            this.f45891f = date;
            return this;
        }

        public a n(String str) {
            this.f45893h = str;
            return this;
        }

        public a o(Date date) {
            this.f45892g = date;
            return this;
        }

        public a p(Date date) {
            this.f45890e = date;
            return this;
        }
    }

    public d(Context context) {
        super(context, d.a.i0.a.i.SwanAppNoTitleDialog);
    }

    public final void e() {
        this.f45887g = new BdDatePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.f45887g.setLayoutParams(layoutParams);
        this.f45887g.setScrollCycle(true);
        this.f45887g.setStartDate(this.m);
        this.f45887g.setEndDate(this.n);
        this.f45887g.setYear(this.f45888h);
        this.f45887g.setMonth(this.f45889i);
        this.f45887g.setDay(this.j);
        this.f45887g.n();
        this.f45887g.setFields(this.k);
        this.f45887g.setDisabled(this.l);
    }

    public int f() {
        return this.f45887g.getDay();
    }

    public int g() {
        return this.f45887g.getMonth();
    }

    public String h() {
        StringBuilder sb = new StringBuilder();
        if (j(TypeAdapters.AnonymousClass27.YEAR)) {
            sb.append(String.format("%d-", Integer.valueOf(i())));
        }
        if (j(TypeAdapters.AnonymousClass27.MONTH)) {
            sb.append(String.format("%02d-", Integer.valueOf(g())));
        }
        if (j(Config.TRACE_VISIT_RECENT_DAY)) {
            sb.append(String.format("%02d", Integer.valueOf(f())));
        }
        String sb2 = sb.toString();
        return sb2.endsWith("-") ? sb2.substring(0, sb2.length() - 1) : sb2;
    }

    public int i() {
        return this.f45887g.getYear();
    }

    public final boolean j(String str) {
        return this.f45887g.l(str);
    }

    public void k(int i2) {
        this.j = i2;
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

    public void o(int i2) {
        this.f45889i = i2;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        e();
        b().j(this.f45887g);
    }

    public void p(Date date) {
        this.m = date;
    }

    public void q(int i2) {
        this.f45888h = i2;
    }

    @Override // d.a.i0.a.z1.b.b.c, android.app.Dialog
    public void show() {
        super.show();
    }
}
