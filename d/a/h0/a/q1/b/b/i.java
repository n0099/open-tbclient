package d.a.h0.a.q1.b.b;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.swan.apps.res.ui.BdTimePicker;
import d.a.h0.a.q1.b.b.h;
import java.util.Date;
/* loaded from: classes3.dex */
public class i extends h {

    /* renamed from: g  reason: collision with root package name */
    public BdTimePicker f43691g;

    /* renamed from: h  reason: collision with root package name */
    public int f43692h;

    /* renamed from: i  reason: collision with root package name */
    public int f43693i;
    public boolean j;
    public boolean k;
    public Date l;
    public Date m;

    /* loaded from: classes3.dex */
    public static class a extends h.a {

        /* renamed from: e  reason: collision with root package name */
        public Date f43694e;

        /* renamed from: f  reason: collision with root package name */
        public Date f43695f;

        /* renamed from: g  reason: collision with root package name */
        public Date f43696g;

        /* renamed from: h  reason: collision with root package name */
        public String f43697h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f43698i;

        public a(Context context) {
            super(context);
        }

        @Override // d.a.h0.a.q1.b.b.h.a
        public h a() {
            i iVar = (i) super.a();
            iVar.j(this.f43697h);
            iVar.h(this.f43698i);
            Date date = this.f43696g;
            if (date != null) {
                iVar.k(date.getHours());
                iVar.l(this.f43696g.getMinutes());
            }
            Date date2 = this.f43694e;
            if (date2 != null) {
                iVar.m(date2);
            }
            Date date3 = this.f43695f;
            if (date3 != null) {
                iVar.i(date3);
            }
            return iVar;
        }

        @Override // d.a.h0.a.q1.b.b.h.a
        public h b(Context context) {
            return new i(context);
        }

        public a k(boolean z) {
            this.f43698i = z;
            return this;
        }

        public a l(Date date) {
            this.f43695f = date;
            return this;
        }

        public a m(String str) {
            this.f43697h = str;
            return this;
        }

        public a n(Date date) {
            this.f43696g = date;
            return this;
        }

        public a o(Date date) {
            this.f43694e = date;
            return this;
        }
    }

    public i(Context context) {
        super(context, d.a.h0.a.i.NoTitleDialog);
        this.j = false;
    }

    public final void e() {
        this.f43691g = new BdTimePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.f43691g.setLayoutParams(layoutParams);
        this.f43691g.setScrollCycle(true);
        this.f43691g.setStartDate(this.l);
        this.f43691g.setmEndDate(this.m);
        this.f43691g.setHour(this.f43692h);
        this.f43691g.setMinute(this.f43693i);
        this.f43691g.l();
        this.f43691g.setDisabled(this.k);
    }

    public int f() {
        return this.f43691g.getHour();
    }

    public int g() {
        return this.f43691g.getMinute();
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
        this.f43692h = i2;
    }

    public void l(int i2) {
        this.f43693i = i2;
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
        b().i(this.f43691g);
    }

    @Override // d.a.h0.a.q1.b.b.c, android.app.Dialog
    public void show() {
        BdTimePicker bdTimePicker = this.f43691g;
        if (bdTimePicker != null) {
            if (this.f43692h != bdTimePicker.getHour()) {
                this.f43691g.setHour(this.f43692h);
            }
            if (this.f43693i != this.f43691g.getMinute()) {
                this.f43691g.setMinute(this.f43693i);
            }
        }
        super.show();
    }
}
