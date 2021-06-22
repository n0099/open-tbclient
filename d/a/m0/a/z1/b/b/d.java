package d.a.m0.a.z1.b.b;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.res.ui.BdDatePicker;
import com.google.gson.internal.bind.TypeAdapters;
import d.a.m0.a.z1.b.b.i;
import java.util.Date;
/* loaded from: classes3.dex */
public class d extends i {

    /* renamed from: g  reason: collision with root package name */
    public BdDatePicker f49845g;

    /* renamed from: h  reason: collision with root package name */
    public int f49846h;

    /* renamed from: i  reason: collision with root package name */
    public int f49847i;
    public int j;
    public String k;
    public boolean l;
    public Date m;
    public Date n;

    /* loaded from: classes3.dex */
    public static class a extends i.a {

        /* renamed from: e  reason: collision with root package name */
        public Date f49848e;

        /* renamed from: f  reason: collision with root package name */
        public Date f49849f;

        /* renamed from: g  reason: collision with root package name */
        public Date f49850g;

        /* renamed from: h  reason: collision with root package name */
        public String f49851h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f49852i;

        public a(Context context) {
            super(context);
        }

        @Override // d.a.m0.a.z1.b.b.i.a
        public i a() {
            d dVar = (d) super.a();
            dVar.n(this.f49851h);
            dVar.l(this.f49852i);
            Date date = this.f49850g;
            if (date != null) {
                dVar.q(date.getYear() + 1900);
                dVar.o(this.f49850g.getMonth() + 1);
                dVar.k(this.f49850g.getDate());
            }
            Date date2 = this.f49848e;
            if (date2 != null) {
                dVar.p(date2);
            }
            Date date3 = this.f49849f;
            if (date3 != null) {
                dVar.m(date3);
            }
            return dVar;
        }

        @Override // d.a.m0.a.z1.b.b.i.a
        public i b(Context context) {
            return new d(context);
        }

        public a l(boolean z) {
            this.f49852i = z;
            return this;
        }

        public a m(Date date) {
            this.f49849f = date;
            return this;
        }

        public a n(String str) {
            this.f49851h = str;
            return this;
        }

        public a o(Date date) {
            this.f49850g = date;
            return this;
        }

        public a p(Date date) {
            this.f49848e = date;
            return this;
        }
    }

    public d(Context context) {
        super(context, d.a.m0.a.i.SwanAppNoTitleDialog);
    }

    public final void e() {
        this.f49845g = new BdDatePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.f49845g.setLayoutParams(layoutParams);
        this.f49845g.setScrollCycle(true);
        this.f49845g.setStartDate(this.m);
        this.f49845g.setEndDate(this.n);
        this.f49845g.setYear(this.f49846h);
        this.f49845g.setMonth(this.f49847i);
        this.f49845g.setDay(this.j);
        this.f49845g.n();
        this.f49845g.setFields(this.k);
        this.f49845g.setDisabled(this.l);
    }

    public int f() {
        return this.f49845g.getDay();
    }

    public int g() {
        return this.f49845g.getMonth();
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
        return this.f49845g.getYear();
    }

    public final boolean j(String str) {
        return this.f49845g.l(str);
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
        this.f49847i = i2;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        e();
        b().j(this.f49845g);
    }

    public void p(Date date) {
        this.m = date;
    }

    public void q(int i2) {
        this.f49846h = i2;
    }

    @Override // d.a.m0.a.z1.b.b.c, android.app.Dialog
    public void show() {
        super.show();
    }
}
