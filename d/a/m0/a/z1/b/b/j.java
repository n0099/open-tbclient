package d.a.m0.a.z1.b.b;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.swan.apps.res.ui.BdTimePicker;
import d.a.m0.a.z1.b.b.i;
import java.util.Date;
/* loaded from: classes3.dex */
public class j extends i {

    /* renamed from: g  reason: collision with root package name */
    public BdTimePicker f49916g;

    /* renamed from: h  reason: collision with root package name */
    public int f49917h;

    /* renamed from: i  reason: collision with root package name */
    public int f49918i;
    public boolean j;
    public boolean k;
    public Date l;
    public Date m;

    /* loaded from: classes3.dex */
    public static class a extends i.a {

        /* renamed from: e  reason: collision with root package name */
        public Date f49919e;

        /* renamed from: f  reason: collision with root package name */
        public Date f49920f;

        /* renamed from: g  reason: collision with root package name */
        public Date f49921g;

        /* renamed from: h  reason: collision with root package name */
        public String f49922h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f49923i;

        public a(Context context) {
            super(context);
        }

        @Override // d.a.m0.a.z1.b.b.i.a
        public i a() {
            j jVar = (j) super.a();
            jVar.j(this.f49922h);
            jVar.h(this.f49923i);
            Date date = this.f49921g;
            if (date != null) {
                jVar.k(date.getHours());
                jVar.l(this.f49921g.getMinutes());
            }
            Date date2 = this.f49919e;
            if (date2 != null) {
                jVar.m(date2);
            }
            Date date3 = this.f49920f;
            if (date3 != null) {
                jVar.i(date3);
            }
            return jVar;
        }

        @Override // d.a.m0.a.z1.b.b.i.a
        public i b(Context context) {
            return new j(context);
        }

        public a l(boolean z) {
            this.f49923i = z;
            return this;
        }

        public a m(Date date) {
            this.f49920f = date;
            return this;
        }

        public a n(String str) {
            this.f49922h = str;
            return this;
        }

        public a o(Date date) {
            this.f49921g = date;
            return this;
        }

        public a p(Date date) {
            this.f49919e = date;
            return this;
        }
    }

    public j(Context context) {
        super(context, d.a.m0.a.i.SwanAppNoTitleDialog);
        this.j = false;
    }

    public final void e() {
        this.f49916g = new BdTimePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.f49916g.setLayoutParams(layoutParams);
        this.f49916g.setScrollCycle(true);
        this.f49916g.setStartDate(this.l);
        this.f49916g.setmEndDate(this.m);
        this.f49916g.setHour(this.f49917h);
        this.f49916g.setMinute(this.f49918i);
        this.f49916g.l();
        this.f49916g.setDisabled(this.k);
    }

    public int f() {
        return this.f49916g.getHour();
    }

    public int g() {
        return this.f49916g.getMinute();
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
        this.f49917h = i2;
    }

    public void l(int i2) {
        this.f49918i = i2;
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
        b().j(this.f49916g);
    }

    @Override // d.a.m0.a.z1.b.b.c, android.app.Dialog
    public void show() {
        BdTimePicker bdTimePicker = this.f49916g;
        if (bdTimePicker != null) {
            if (this.f49917h != bdTimePicker.getHour()) {
                this.f49916g.setHour(this.f49917h);
            }
            if (this.f49918i != this.f49916g.getMinute()) {
                this.f49916g.setMinute(this.f49918i);
            }
        }
        super.show();
    }
}
