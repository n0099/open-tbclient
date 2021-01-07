package com.qq.e.comm.plugin.rewardvideo.b;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.aa.b.f;
import com.qq.e.comm.plugin.ab.d.e;
import com.qq.e.comm.plugin.ac.k;
import com.qq.e.comm.plugin.ad.g;
import com.qq.e.comm.plugin.rewardvideo.d;
import com.qq.e.comm.plugin.rewardvideo.n;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.util.ao;
/* loaded from: classes4.dex */
public class c extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private final f f12689a;

    /* renamed from: b  reason: collision with root package name */
    private final ImageView f12690b;
    private final com.qq.e.comm.plugin.ac.b c;
    private k d;
    private final ImageView e;
    private final ImageView f;
    private TextView g;
    private com.qq.e.comm.plugin.ab.d.a h;
    private RelativeLayout i;
    private boolean j;
    private g k;

    public c(Context context, boolean z, boolean z2, d dVar, g gVar) {
        super(context);
        this.k = gVar;
        this.i = new RelativeLayout(context);
        addView(this.i, new RelativeLayout.LayoutParams(-1, -1));
        this.f12689a = new f(context);
        this.f12689a.setId(2131755010);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13, -1);
        this.i.addView(this.f12689a, layoutParams);
        this.f12690b = new ImageView(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 17;
        addView(this.f12690b, layoutParams2);
        if (z2) {
            this.h = new e(context, null).a();
            this.h.b().setBackgroundColor(0);
            this.i.addView(this.h.b(), new RelativeLayout.LayoutParams(-1, -1));
        }
        boolean z3 = dVar != null ? !z && dVar.P() < dVar.Q() && GDTADManager.getInstance().getSM().getInteger("rewardVideoPortraitAlignTop", 1) == 1 : false;
        this.c = new com.qq.e.comm.plugin.ac.b(context);
        this.c.setId(2131755009);
        this.c.a(ak.a(context, 2));
        this.c.a(Color.argb(77, 255, 255, 255));
        this.c.b(-1);
        this.c.c(Color.argb(128, 0, 0, 0));
        this.c.b(ak.a(context, 14));
        this.e = new ImageView(context);
        this.e.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.e.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(ak.a(context, 30), ak.a(context, 30));
        layoutParams3.addRule(11, -1);
        layoutParams3.rightMargin = ak.a(context, 20);
        if (z3) {
            layoutParams3.addRule(6, 2131755010);
        } else {
            layoutParams3.addRule(10, -1);
            layoutParams3.topMargin = ak.a(context, 15);
        }
        this.i.addView(this.c, layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(ak.a(context, 30), ak.a(context, 30));
        layoutParams4.addRule(0, 2131755009);
        layoutParams4.rightMargin = ak.a(context, 20);
        if (z3) {
            layoutParams4.addRule(6, 2131755010);
        } else {
            layoutParams4.addRule(10, -1);
            layoutParams4.topMargin = ak.a(context, 15);
        }
        this.i.addView(this.e, layoutParams4);
        this.f = new ImageView(context);
        this.f.setId(2131755011);
        this.f.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.f.setImageBitmap(ao.a("iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAMAAACdt4HsAAAAbFBMVEUAAAAAAAD////p6eknJyf/\n//8MDAz///////8REREbGxs9PT11dXWlpaX39/f///////////////9qamoZGRksLCxQUFBkZGSL\ni4u/v7/Z2dny8vL///////////////////////////////8d9apUAAAAI3RSTlOAAE3qikd6JQV3\nc2hbVE5AKx4RoYZtY15YUVBORD48MhoKNpZmpn4AAAHhSURBVFjDpZfbloIwDEXPVFsoFwW830H/\n/x+HRMYRIQIr54EHl2eTNiVN8CMoLIPb5WyNsefLLShD6X/9gCJbmg8ts2IsIAwad4cRhIMAslsj\nyhLiOyB/2Q/JduMd4PxmmxxeiPwroLoa1iKNHVpycbowrGslAwr7tCcOPXLJE2ELCZAb1t5DkN8b\nVt4PyAwpjfBFUWpIWR/gbkg7DGhnSPcugN9/ijGo+NSKAe/rP0YYoejI+9AGFOz3GCXPhOIdUFmK\nP8JIRbQKW70B+PzEGK2YT9Q/IBf2fyAX+R8gtJR/TFJKiwgbQEC4CJMUkScgQBPAHhO1b0LAM4CF\nx0T5BYXAAKo/CVpardHReoWWEqpRBCgoANf2P2ZzfGg+e7QJjkIoakDWTcF6RoRP/2zdTURWA5Y9\nZ2hOBPGHRjGvASHlw0EiyH44coYoqX4CEkH2A1RpSwScA5kg+zkPAW71cwuZIPuxra03XOrnBjJB\n9mNTWy84108PmSD74WvrGZaTIBNkP6fBgnIByATZD/aqAeolqDdRnUb1QVIfZfXHpP6ctQVFXdLU\nRVVb1tUXi/pq016u6utd22BoWxx1k6Vt87SNprbVVTfb+nZfP3DoRx790KUf+/SDp3701Q/f6vH/\nFzOPJ4ULw0zxAAAAAElFTkSuQmCC\n"));
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(ak.a(context, 30), ak.a(context, 30));
        layoutParams5.addRule(9, -1);
        layoutParams5.leftMargin = ak.a(context, 20);
        if (z3) {
            layoutParams5.addRule(6, 2131755010);
        } else {
            layoutParams5.addRule(10, -1);
            layoutParams5.topMargin = ak.a(context, 15);
        }
        this.i.addView(this.f, layoutParams5);
        this.j = n.c(dVar == null ? "" : dVar.B());
        if (this.j) {
            this.g = new TextView(getContext());
            this.g.setTextSize(12.0f);
            this.g.setTextColor(-1);
            RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams6.addRule(1, 2131755011);
            layoutParams6.leftMargin = 20;
            if (z3) {
                layoutParams6.addRule(6, 2131755010);
            } else {
                layoutParams6.addRule(10, -1);
                layoutParams6.topMargin = ak.a(context, 15);
            }
            this.g.setLayoutParams(layoutParams6);
            this.g.setPadding(ak.a(context, 7), ak.a(context, 7), ak.a(context, 7), ak.a(context, 7));
            int parseColor = Color.parseColor("#48FFFFFF");
            int parseColor2 = Color.parseColor("#80000000");
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(parseColor2);
            gradientDrawable.setCornerRadius(54);
            gradientDrawable.setStroke(5, parseColor);
            this.g.setBackgroundDrawable(gradientDrawable);
            this.i.addView(this.g);
        }
        a(dVar);
    }

    private void a(d dVar) {
        if (dVar == null || TextUtils.isEmpty(dVar.ac())) {
            return;
        }
        this.d = new k(getContext(), dVar.ac(), this.k);
    }

    public int a(Context context) {
        return 45;
    }

    public ImageView a() {
        return this.e;
    }

    public void a(ViewGroup viewGroup) {
        if (getParent() == null) {
            viewGroup.addView(this, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public ImageView b() {
        return this.f;
    }

    public f c() {
        return this.f12689a;
    }

    public ImageView d() {
        return this.f12690b;
    }

    public com.qq.e.comm.plugin.ac.b e() {
        return this.c;
    }

    public com.qq.e.comm.plugin.ab.d.a f() {
        return this.h;
    }

    public TextView g() {
        if (this.j) {
            return this.g;
        }
        return null;
    }

    public k h() {
        return this.d;
    }

    public void i() {
        this.i.setVisibility(4);
    }

    public void j() {
        this.i.setVisibility(0);
    }
}
