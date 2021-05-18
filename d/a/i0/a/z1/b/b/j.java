package d.a.i0.a.z1.b.b;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.swan.apps.res.ui.BdTimePicker;
import d.a.i0.a.z1.b.b.i;
import java.util.Date;
/* loaded from: classes3.dex */
public class j extends i {

    /* renamed from: g  reason: collision with root package name */
    public BdTimePicker f45958g;

    /* renamed from: h  reason: collision with root package name */
    public int f45959h;

    /* renamed from: i  reason: collision with root package name */
    public int f45960i;
    public boolean j;
    public boolean k;
    public Date l;
    public Date m;

    /* loaded from: classes3.dex */
    public static class a extends i.a {

        /* renamed from: e  reason: collision with root package name */
        public Date f45961e;

        /* renamed from: f  reason: collision with root package name */
        public Date f45962f;

        /* renamed from: g  reason: collision with root package name */
        public Date f45963g;

        /* renamed from: h  reason: collision with root package name */
        public String f45964h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f45965i;

        public a(Context context) {
            super(context);
        }

        @Override // d.a.i0.a.z1.b.b.i.a
        public i a() {
            j jVar = (j) super.a();
            jVar.j(this.f45964h);
            jVar.h(this.f45965i);
            Date date = this.f45963g;
            if (date != null) {
                jVar.k(date.getHours());
                jVar.l(this.f45963g.getMinutes());
            }
            Date date2 = this.f45961e;
            if (date2 != null) {
                jVar.m(date2);
            }
            Date date3 = this.f45962f;
            if (date3 != null) {
                jVar.i(date3);
            }
            return jVar;
        }

        @Override // d.a.i0.a.z1.b.b.i.a
        public i b(Context context) {
            return new j(context);
        }

        public a l(boolean z) {
            this.f45965i = z;
            return this;
        }

        public a m(Date date) {
            this.f45962f = date;
            return this;
        }

        public a n(String str) {
            this.f45964h = str;
            return this;
        }

        public a o(Date date) {
            this.f45963g = date;
            return this;
        }

        public a p(Date date) {
            this.f45961e = date;
            return this;
        }
    }

    public j(Context context) {
        super(context, d.a.i0.a.i.SwanAppNoTitleDialog);
        this.j = false;
    }

    public final void e() {
        this.f45958g = new BdTimePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.f45958g.setLayoutParams(layoutParams);
        this.f45958g.setScrollCycle(true);
        this.f45958g.setStartDate(this.l);
        this.f45958g.setmEndDate(this.m);
        this.f45958g.setHour(this.f45959h);
        this.f45958g.setMinute(this.f45960i);
        this.f45958g.l();
        this.f45958g.setDisabled(this.k);
    }

    public int f() {
        return this.f45958g.getHour();
    }

    public int g() {
        return this.f45958g.getMinute();
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
        this.f45959h = i2;
    }

    public void l(int i2) {
        this.f45960i = i2;
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
        b().j(this.f45958g);
    }

    @Override // d.a.i0.a.z1.b.b.c, android.app.Dialog
    public void show() {
        BdTimePicker bdTimePicker = this.f45958g;
        if (bdTimePicker != null) {
            if (this.f45959h != bdTimePicker.getHour()) {
                this.f45958g.setHour(this.f45959h);
            }
            if (this.f45960i != this.f45958g.getMinute()) {
                this.f45958g.setMinute(this.f45960i);
            }
        }
        super.show();
    }
}
