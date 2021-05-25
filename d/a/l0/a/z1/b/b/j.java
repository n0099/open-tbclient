package d.a.l0.a.z1.b.b;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.swan.apps.res.ui.BdTimePicker;
import d.a.l0.a.z1.b.b.i;
import java.util.Date;
/* loaded from: classes3.dex */
public class j extends i {

    /* renamed from: g  reason: collision with root package name */
    public BdTimePicker f46134g;

    /* renamed from: h  reason: collision with root package name */
    public int f46135h;

    /* renamed from: i  reason: collision with root package name */
    public int f46136i;
    public boolean j;
    public boolean k;
    public Date l;
    public Date m;

    /* loaded from: classes3.dex */
    public static class a extends i.a {

        /* renamed from: e  reason: collision with root package name */
        public Date f46137e;

        /* renamed from: f  reason: collision with root package name */
        public Date f46138f;

        /* renamed from: g  reason: collision with root package name */
        public Date f46139g;

        /* renamed from: h  reason: collision with root package name */
        public String f46140h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f46141i;

        public a(Context context) {
            super(context);
        }

        @Override // d.a.l0.a.z1.b.b.i.a
        public i a() {
            j jVar = (j) super.a();
            jVar.j(this.f46140h);
            jVar.h(this.f46141i);
            Date date = this.f46139g;
            if (date != null) {
                jVar.k(date.getHours());
                jVar.l(this.f46139g.getMinutes());
            }
            Date date2 = this.f46137e;
            if (date2 != null) {
                jVar.m(date2);
            }
            Date date3 = this.f46138f;
            if (date3 != null) {
                jVar.i(date3);
            }
            return jVar;
        }

        @Override // d.a.l0.a.z1.b.b.i.a
        public i b(Context context) {
            return new j(context);
        }

        public a l(boolean z) {
            this.f46141i = z;
            return this;
        }

        public a m(Date date) {
            this.f46138f = date;
            return this;
        }

        public a n(String str) {
            this.f46140h = str;
            return this;
        }

        public a o(Date date) {
            this.f46139g = date;
            return this;
        }

        public a p(Date date) {
            this.f46137e = date;
            return this;
        }
    }

    public j(Context context) {
        super(context, d.a.l0.a.i.SwanAppNoTitleDialog);
        this.j = false;
    }

    public final void e() {
        this.f46134g = new BdTimePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.f46134g.setLayoutParams(layoutParams);
        this.f46134g.setScrollCycle(true);
        this.f46134g.setStartDate(this.l);
        this.f46134g.setmEndDate(this.m);
        this.f46134g.setHour(this.f46135h);
        this.f46134g.setMinute(this.f46136i);
        this.f46134g.l();
        this.f46134g.setDisabled(this.k);
    }

    public int f() {
        return this.f46134g.getHour();
    }

    public int g() {
        return this.f46134g.getMinute();
    }

    public void h(boolean z) {
        this.k = z;
    }

    public void i(Date date) {
        this.m = date;
    }

    public void j(String str) {
    }

    public void k(int i2) {
        this.f46135h = i2;
    }

    public void l(int i2) {
        this.f46136i = i2;
    }

    public void m(Date date) {
        this.l = date;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        if (this.j) {
            getWindow().addFlags(4718592);
        }
        e();
        b().j(this.f46134g);
    }

    @Override // d.a.l0.a.z1.b.b.c, android.app.Dialog
    public void show() {
        BdTimePicker bdTimePicker = this.f46134g;
        if (bdTimePicker != null) {
            if (this.f46135h != bdTimePicker.getHour()) {
                this.f46134g.setHour(this.f46135h);
            }
            if (this.f46136i != this.f46134g.getMinute()) {
                this.f46134g.setMinute(this.f46136i);
            }
        }
        super.show();
    }
}
