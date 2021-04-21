package d.b.h0.a.q1.b.b;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.swan.apps.res.ui.BdTimePicker;
import d.b.h0.a.q1.b.b.h;
import java.util.Date;
/* loaded from: classes3.dex */
public class i extends h {

    /* renamed from: g  reason: collision with root package name */
    public BdTimePicker f46336g;

    /* renamed from: h  reason: collision with root package name */
    public int f46337h;
    public int i;
    public boolean j;
    public boolean k;
    public Date l;
    public Date m;

    /* loaded from: classes3.dex */
    public static class a extends h.a {

        /* renamed from: e  reason: collision with root package name */
        public Date f46338e;

        /* renamed from: f  reason: collision with root package name */
        public Date f46339f;

        /* renamed from: g  reason: collision with root package name */
        public Date f46340g;

        /* renamed from: h  reason: collision with root package name */
        public String f46341h;
        public boolean i;

        public a(Context context) {
            super(context);
        }

        @Override // d.b.h0.a.q1.b.b.h.a
        public h a() {
            i iVar = (i) super.a();
            iVar.j(this.f46341h);
            iVar.h(this.i);
            Date date = this.f46340g;
            if (date != null) {
                iVar.k(date.getHours());
                iVar.l(this.f46340g.getMinutes());
            }
            Date date2 = this.f46338e;
            if (date2 != null) {
                iVar.m(date2);
            }
            Date date3 = this.f46339f;
            if (date3 != null) {
                iVar.i(date3);
            }
            return iVar;
        }

        @Override // d.b.h0.a.q1.b.b.h.a
        public h b(Context context) {
            return new i(context);
        }

        public a k(boolean z) {
            this.i = z;
            return this;
        }

        public a l(Date date) {
            this.f46339f = date;
            return this;
        }

        public a m(String str) {
            this.f46341h = str;
            return this;
        }

        public a n(Date date) {
            this.f46340g = date;
            return this;
        }

        public a o(Date date) {
            this.f46338e = date;
            return this;
        }
    }

    public i(Context context) {
        super(context, d.b.h0.a.i.NoTitleDialog);
        this.j = false;
    }

    public final void e() {
        this.f46336g = new BdTimePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.f46336g.setLayoutParams(layoutParams);
        this.f46336g.setScrollCycle(true);
        this.f46336g.setStartDate(this.l);
        this.f46336g.setmEndDate(this.m);
        this.f46336g.setHour(this.f46337h);
        this.f46336g.setMinute(this.i);
        this.f46336g.l();
        this.f46336g.setDisabled(this.k);
    }

    public int f() {
        return this.f46336g.getHour();
    }

    public int g() {
        return this.f46336g.getMinute();
    }

    public void h(boolean z) {
        this.k = z;
    }

    public void i(Date date) {
        this.m = date;
    }

    public void j(String str) {
    }

    public void k(int i) {
        this.f46337h = i;
    }

    public void l(int i) {
        this.i = i;
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
        b().i(this.f46336g);
    }

    @Override // d.b.h0.a.q1.b.b.c, android.app.Dialog
    public void show() {
        BdTimePicker bdTimePicker = this.f46336g;
        if (bdTimePicker != null) {
            if (this.f46337h != bdTimePicker.getHour()) {
                this.f46336g.setHour(this.f46337h);
            }
            if (this.i != this.f46336g.getMinute()) {
                this.f46336g.setMinute(this.i);
            }
        }
        super.show();
    }
}
