package d.a.h0.a.q1.b.b;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.res.ui.BdDatePicker;
import com.google.gson.internal.bind.TypeAdapters;
import d.a.h0.a.q1.b.b.h;
import java.util.Date;
/* loaded from: classes3.dex */
public class d extends h {

    /* renamed from: g  reason: collision with root package name */
    public BdDatePicker f43632g;

    /* renamed from: h  reason: collision with root package name */
    public int f43633h;

    /* renamed from: i  reason: collision with root package name */
    public int f43634i;
    public int j;
    public String k;
    public boolean l;
    public Date m;
    public Date n;

    /* loaded from: classes3.dex */
    public static class a extends h.a {

        /* renamed from: e  reason: collision with root package name */
        public Date f43635e;

        /* renamed from: f  reason: collision with root package name */
        public Date f43636f;

        /* renamed from: g  reason: collision with root package name */
        public Date f43637g;

        /* renamed from: h  reason: collision with root package name */
        public String f43638h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f43639i;

        public a(Context context) {
            super(context);
        }

        @Override // d.a.h0.a.q1.b.b.h.a
        public h a() {
            d dVar = (d) super.a();
            dVar.n(this.f43638h);
            dVar.l(this.f43639i);
            Date date = this.f43637g;
            if (date != null) {
                dVar.q(date.getYear() + 1900);
                dVar.o(this.f43637g.getMonth() + 1);
                dVar.k(this.f43637g.getDate());
            }
            Date date2 = this.f43635e;
            if (date2 != null) {
                dVar.p(date2);
            }
            Date date3 = this.f43636f;
            if (date3 != null) {
                dVar.m(date3);
            }
            return dVar;
        }

        @Override // d.a.h0.a.q1.b.b.h.a
        public h b(Context context) {
            return new d(context);
        }

        public a k(boolean z) {
            this.f43639i = z;
            return this;
        }

        public a l(Date date) {
            this.f43636f = date;
            return this;
        }

        public a m(String str) {
            this.f43638h = str;
            return this;
        }

        public a n(Date date) {
            this.f43637g = date;
            return this;
        }

        public a o(Date date) {
            this.f43635e = date;
            return this;
        }
    }

    public d(Context context) {
        super(context, d.a.h0.a.i.NoTitleDialog);
    }

    public final void e() {
        this.f43632g = new BdDatePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.f43632g.setLayoutParams(layoutParams);
        this.f43632g.setScrollCycle(true);
        this.f43632g.setStartDate(this.m);
        this.f43632g.setEndDate(this.n);
        this.f43632g.setYear(this.f43633h);
        this.f43632g.setMonth(this.f43634i);
        this.f43632g.setDay(this.j);
        this.f43632g.n();
        this.f43632g.setFields(this.k);
        this.f43632g.setDisabled(this.l);
    }

    public int f() {
        return this.f43632g.getDay();
    }

    public int g() {
        return this.f43632g.getMonth();
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
        return this.f43632g.getYear();
    }

    public final boolean j(String str) {
        return this.f43632g.l(str);
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
        this.f43634i = i2;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        e();
        b().i(this.f43632g);
    }

    public void p(Date date) {
        this.m = date;
    }

    public void q(int i2) {
        this.f43633h = i2;
    }

    @Override // d.a.h0.a.q1.b.b.c, android.app.Dialog
    public void show() {
        super.show();
    }
}
