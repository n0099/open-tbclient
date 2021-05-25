package d.a.l0.a.z1.b.b;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.res.ui.BdDatePicker;
import com.google.gson.internal.bind.TypeAdapters;
import d.a.l0.a.z1.b.b.i;
import java.util.Date;
/* loaded from: classes3.dex */
public class d extends i {

    /* renamed from: g  reason: collision with root package name */
    public BdDatePicker f46063g;

    /* renamed from: h  reason: collision with root package name */
    public int f46064h;

    /* renamed from: i  reason: collision with root package name */
    public int f46065i;
    public int j;
    public String k;
    public boolean l;
    public Date m;
    public Date n;

    /* loaded from: classes3.dex */
    public static class a extends i.a {

        /* renamed from: e  reason: collision with root package name */
        public Date f46066e;

        /* renamed from: f  reason: collision with root package name */
        public Date f46067f;

        /* renamed from: g  reason: collision with root package name */
        public Date f46068g;

        /* renamed from: h  reason: collision with root package name */
        public String f46069h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f46070i;

        public a(Context context) {
            super(context);
        }

        @Override // d.a.l0.a.z1.b.b.i.a
        public i a() {
            d dVar = (d) super.a();
            dVar.n(this.f46069h);
            dVar.l(this.f46070i);
            Date date = this.f46068g;
            if (date != null) {
                dVar.q(date.getYear() + 1900);
                dVar.o(this.f46068g.getMonth() + 1);
                dVar.k(this.f46068g.getDate());
            }
            Date date2 = this.f46066e;
            if (date2 != null) {
                dVar.p(date2);
            }
            Date date3 = this.f46067f;
            if (date3 != null) {
                dVar.m(date3);
            }
            return dVar;
        }

        @Override // d.a.l0.a.z1.b.b.i.a
        public i b(Context context) {
            return new d(context);
        }

        public a l(boolean z) {
            this.f46070i = z;
            return this;
        }

        public a m(Date date) {
            this.f46067f = date;
            return this;
        }

        public a n(String str) {
            this.f46069h = str;
            return this;
        }

        public a o(Date date) {
            this.f46068g = date;
            return this;
        }

        public a p(Date date) {
            this.f46066e = date;
            return this;
        }
    }

    public d(Context context) {
        super(context, d.a.l0.a.i.SwanAppNoTitleDialog);
    }

    public final void e() {
        this.f46063g = new BdDatePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.f46063g.setLayoutParams(layoutParams);
        this.f46063g.setScrollCycle(true);
        this.f46063g.setStartDate(this.m);
        this.f46063g.setEndDate(this.n);
        this.f46063g.setYear(this.f46064h);
        this.f46063g.setMonth(this.f46065i);
        this.f46063g.setDay(this.j);
        this.f46063g.n();
        this.f46063g.setFields(this.k);
        this.f46063g.setDisabled(this.l);
    }

    public int f() {
        return this.f46063g.getDay();
    }

    public int g() {
        return this.f46063g.getMonth();
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
        return this.f46063g.getYear();
    }

    public final boolean j(String str) {
        return this.f46063g.l(str);
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
        this.f46065i = i2;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        e();
        b().j(this.f46063g);
    }

    public void p(Date date) {
        this.m = date;
    }

    public void q(int i2) {
        this.f46064h = i2;
    }

    @Override // d.a.l0.a.z1.b.b.c, android.app.Dialog
    public void show() {
        super.show();
    }
}
