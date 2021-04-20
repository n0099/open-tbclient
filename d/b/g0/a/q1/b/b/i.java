package d.b.g0.a.q1.b.b;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.swan.apps.res.ui.BdTimePicker;
import d.b.g0.a.q1.b.b.h;
import java.util.Date;
/* loaded from: classes3.dex */
public class i extends h {

    /* renamed from: g  reason: collision with root package name */
    public BdTimePicker f46007g;

    /* renamed from: h  reason: collision with root package name */
    public int f46008h;
    public int i;
    public boolean j;
    public boolean k;
    public Date l;
    public Date m;

    /* loaded from: classes3.dex */
    public static class a extends h.a {

        /* renamed from: e  reason: collision with root package name */
        public Date f46009e;

        /* renamed from: f  reason: collision with root package name */
        public Date f46010f;

        /* renamed from: g  reason: collision with root package name */
        public Date f46011g;

        /* renamed from: h  reason: collision with root package name */
        public String f46012h;
        public boolean i;

        public a(Context context) {
            super(context);
        }

        @Override // d.b.g0.a.q1.b.b.h.a
        public h a() {
            i iVar = (i) super.a();
            iVar.j(this.f46012h);
            iVar.h(this.i);
            Date date = this.f46011g;
            if (date != null) {
                iVar.k(date.getHours());
                iVar.l(this.f46011g.getMinutes());
            }
            Date date2 = this.f46009e;
            if (date2 != null) {
                iVar.m(date2);
            }
            Date date3 = this.f46010f;
            if (date3 != null) {
                iVar.i(date3);
            }
            return iVar;
        }

        @Override // d.b.g0.a.q1.b.b.h.a
        public h b(Context context) {
            return new i(context);
        }

        public a k(boolean z) {
            this.i = z;
            return this;
        }

        public a l(Date date) {
            this.f46010f = date;
            return this;
        }

        public a m(String str) {
            this.f46012h = str;
            return this;
        }

        public a n(Date date) {
            this.f46011g = date;
            return this;
        }

        public a o(Date date) {
            this.f46009e = date;
            return this;
        }
    }

    public i(Context context) {
        super(context, d.b.g0.a.i.NoTitleDialog);
        this.j = false;
    }

    public final void e() {
        this.f46007g = new BdTimePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.f46007g.setLayoutParams(layoutParams);
        this.f46007g.setScrollCycle(true);
        this.f46007g.setStartDate(this.l);
        this.f46007g.setmEndDate(this.m);
        this.f46007g.setHour(this.f46008h);
        this.f46007g.setMinute(this.i);
        this.f46007g.l();
        this.f46007g.setDisabled(this.k);
    }

    public int f() {
        return this.f46007g.getHour();
    }

    public int g() {
        return this.f46007g.getMinute();
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
        this.f46008h = i;
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
        b().i(this.f46007g);
    }

    @Override // d.b.g0.a.q1.b.b.c, android.app.Dialog
    public void show() {
        BdTimePicker bdTimePicker = this.f46007g;
        if (bdTimePicker != null) {
            if (this.f46008h != bdTimePicker.getHour()) {
                this.f46007g.setHour(this.f46008h);
            }
            if (this.i != this.f46007g.getMinute()) {
                this.f46007g.setMinute(this.i);
            }
        }
        super.show();
    }
}
