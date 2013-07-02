package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.plus.PlusClient;
import com.google.android.gms.plus.PlusOneButton;
/* loaded from: classes.dex */
public class dz extends LinearLayout implements GooglePlayServicesClient.ConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener {
    private static final int l = Color.parseColor("#666666");
    protected boolean a;
    protected int b;
    protected final LinearLayout c;
    protected final FrameLayout d;
    protected final CompoundButton e;
    protected final ea f;
    protected int g;
    protected String h;
    protected PlusClient i;
    protected du j;
    protected final Resources k;
    private final ProgressBar m;
    private final dt[] n;
    private int o;
    private int p;
    private Uri[] q;
    private String[] r;
    private String[] s;
    private b t;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener, PlusOneButton.OnPlusOneClickListener {
        private final PlusOneButton.OnPlusOneClickListener b;

        public a(PlusOneButton.OnPlusOneClickListener onPlusOneClickListener) {
            this.b = onPlusOneClickListener;
        }

        @Override // com.google.android.gms.plus.PlusOneButton.OnPlusOneClickListener
        public void a(Intent intent) {
            Context context = dz.this.getContext();
            if (!(context instanceof Activity) || intent == null) {
                return;
            }
            ((Activity) context).startActivityForResult(intent, dz.this.b);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == dz.this.e || view == dz.this.f) {
                Intent e = dz.this.j == null ? null : dz.this.j.e();
                if (this.b != null) {
                    this.b.a(e);
                } else {
                    a(e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements PlusClient.b {
        final /* synthetic */ dz a;

        @Override // com.google.android.gms.plus.PlusClient.b
        public void a(ConnectionResult connectionResult, du duVar) {
            if (this.a.a) {
                this.a.a = false;
                this.a.e.refreshDrawableState();
            }
            if (!connectionResult.a() || duVar == null) {
                this.a.d();
                return;
            }
            this.a.j = duVar;
            this.a.g();
            this.a.b();
        }
    }

    /* loaded from: classes.dex */
    class c extends CompoundButton {
        final /* synthetic */ dz a;

        @Override // android.widget.CompoundButton, android.widget.Checkable
        public void toggle() {
            if (this.a.a) {
                super.toggle();
                return;
            }
            this.a.a = true;
            this.a.c();
        }
    }

    private void a(int i, int i2) {
        this.g = i2;
        this.p = i;
        b();
    }

    private void a(Point point) {
        int i = 24;
        int i2 = 20;
        switch (this.p) {
            case 0:
                i2 = 14;
                break;
            case 1:
                i = 32;
                break;
            case 2:
                i = 50;
                break;
            default:
                i = 38;
                i2 = 24;
                break;
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float applyDimension = TypedValue.applyDimension(1, i, displayMetrics);
        float applyDimension2 = TypedValue.applyDimension(1, i2, displayMetrics);
        point.x = (int) (applyDimension + 0.5d);
        point.y = (int) (applyDimension2 + 0.5d);
    }

    private void a(View view) {
        int applyDimension = (int) TypedValue.applyDimension(1, 3.0f, getContext().getResources().getDisplayMetrics());
        int applyDimension2 = (int) TypedValue.applyDimension(1, 5.0f, getContext().getResources().getDisplayMetrics());
        if (this.o != 2) {
            applyDimension2 = 0;
        }
        if (this.p != 2 || this.o != 1) {
            applyDimension = 0;
        }
        view.setPadding(applyDimension2, 0, 0, applyDimension);
    }

    private void a(Uri[] uriArr) {
        this.q = uriArr;
        l();
    }

    private void a(String[] strArr) {
        this.r = strArr;
        k();
    }

    private static int b(int i, int i2) {
        switch (i) {
            case 0:
                return 11;
            case 1:
            default:
                return 13;
            case 2:
                return i2 != 2 ? 15 : 13;
        }
    }

    private void b(Point point) {
        point.y = (int) (point.y - TypedValue.applyDimension(1, 6.0f, getResources().getDisplayMetrics()));
        point.x = point.y;
    }

    private void b(String[] strArr) {
        this.s = strArr;
        k();
    }

    private void i() {
        boolean z = true;
        int applyDimension = (int) TypedValue.applyDimension(1, 5.0f, getContext().getResources().getDisplayMetrics());
        int applyDimension2 = (int) TypedValue.applyDimension(1, 1.0f, getContext().getResources().getDisplayMetrics());
        int length = this.n.length;
        for (int i = 0; i < length; i++) {
            if (this.n[i].getVisibility() == 0) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.n[i].getLayoutParams());
                if (z) {
                    layoutParams.setMargins(applyDimension, 0, applyDimension2, 0);
                    z = false;
                } else {
                    layoutParams.setMargins(applyDimension2, 0, applyDimension2, 0);
                }
                this.n[i].setLayoutParams(layoutParams);
            }
        }
    }

    private LinearLayout.LayoutParams j() {
        LinearLayout.LayoutParams layoutParams;
        switch (this.o) {
            case 1:
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
                break;
            case 2:
                layoutParams = new LinearLayout.LayoutParams(-2, -1);
                break;
            default:
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
                break;
        }
        layoutParams.bottomMargin = this.p == 2 ? 1 : 0;
        layoutParams.leftMargin = this.p != 2 ? 1 : 0;
        return layoutParams;
    }

    private void k() {
        switch (this.o) {
            case 1:
                this.f.a(this.s);
                this.f.setVisibility(0);
                return;
            case 2:
                this.f.a(this.r);
                this.f.setVisibility(0);
                return;
            default:
                this.f.a((String[]) null);
                this.f.setVisibility(8);
                return;
        }
    }

    private void l() {
        if (this.q == null || this.o != 2) {
            int length = this.n.length;
            for (int i = 0; i < length; i++) {
                this.n[i].setVisibility(8);
            }
        } else {
            Point point = new Point();
            a(point);
            point.x = point.y;
            int length2 = this.n.length;
            int length3 = this.q.length;
            int i2 = 0;
            while (i2 < length2) {
                Uri uri = i2 < length3 ? this.q[i2] : null;
                if (uri == null) {
                    this.n[i2].setVisibility(8);
                } else {
                    this.n[i2].setLayoutParams(new LinearLayout.LayoutParams(point.x, point.y));
                    this.n[i2].a(uri, point.y);
                    this.n[i2].setVisibility(0);
                }
                i2++;
            }
        }
        i();
    }

    private Drawable m() {
        if (this.k == null) {
            return null;
        }
        return this.k.getDrawable(this.k.getIdentifier(n(), "drawable", "com.google.android.gms"));
    }

    private String n() {
        switch (this.p) {
            case 0:
                return "ic_plusone_small";
            case 1:
                return "ic_plusone_medium";
            case 2:
                return "ic_plusone_tall";
            default:
                return "ic_plusone_standard";
        }
    }

    private Uri o() {
        return y.a(p());
    }

    private String p() {
        switch (this.p) {
            case 0:
                return "global_count_bubble_small";
            case 1:
                return "global_count_bubble_medium";
            case 2:
                return "global_count_bubble_tall";
            default:
                return "global_count_bubble_standard";
        }
    }

    @Override // com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks
    public void a() {
    }

    @Override // com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks
    public void a(Bundle bundle) {
        if (this.h != null) {
            this.i.a(this.t, this.h);
        }
    }

    @Override // com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener
    public void a(ConnectionResult connectionResult) {
        d();
    }

    protected void b() {
        if (isInEditMode()) {
            return;
        }
        this.c.removeAllViews();
        Point point = new Point();
        a(point);
        this.e.setLayoutParams(new FrameLayout.LayoutParams(point.x, point.y, 17));
        b(point);
        this.m.setLayoutParams(new FrameLayout.LayoutParams(point.x, point.y, 17));
        if (this.o == 1) {
            this.f.a(o());
        } else {
            this.f.a((Uri) null);
        }
        l();
        this.f.setLayoutParams(j());
        this.f.a(0, TypedValue.applyDimension(2, b(this.p, this.o), getContext().getResources().getDisplayMetrics()));
        a(this.f);
        if (this.p == 2 && this.o == 1) {
            this.c.setOrientation(1);
            this.c.addView(this.f);
            this.c.addView(this.d);
        } else {
            this.c.setOrientation(0);
            this.c.addView(this.d);
            int length = this.n.length;
            for (int i = 0; i < length; i++) {
                this.c.addView(this.n[i]);
            }
            this.c.addView(this.f);
        }
        requestLayout();
    }

    public void c() {
        setType(2);
        this.m.setVisibility(0);
        h();
    }

    public void d() {
        setType(3);
        this.m.setVisibility(4);
        h();
    }

    protected void e() {
        setType(1);
        this.m.setVisibility(4);
        h();
    }

    protected void f() {
        setType(0);
        this.m.setVisibility(4);
        h();
    }

    protected void g() {
        if (this.j == null) {
            return;
        }
        a(this.j.c());
        b(new String[]{this.j.b()});
        a(this.j.d());
        if (this.j.a()) {
            f();
        } else {
            e();
        }
    }

    protected void h() {
        this.e.setButtonDrawable(m());
        switch (this.g) {
            case 0:
                this.e.setEnabled(true);
                this.e.setChecked(true);
                return;
            case 1:
                this.e.setEnabled(true);
                this.e.setChecked(false);
                return;
            case 2:
                this.e.setEnabled(false);
                this.e.setChecked(true);
                return;
            default:
                this.e.setEnabled(false);
                this.e.setChecked(false);
                return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.i != null) {
            if (!this.i.b((GooglePlayServicesClient.ConnectionCallbacks) this)) {
                this.i.a((GooglePlayServicesClient.ConnectionCallbacks) this);
            }
            if (this.i.b((GooglePlayServicesClient.OnConnectionFailedListener) this)) {
                return;
            }
            this.i.a((GooglePlayServicesClient.OnConnectionFailedListener) this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.i != null) {
            if (this.i.b((GooglePlayServicesClient.ConnectionCallbacks) this)) {
                this.i.c((GooglePlayServicesClient.ConnectionCallbacks) this);
            }
            if (this.i.b((GooglePlayServicesClient.OnConnectionFailedListener) this)) {
                this.i.c((GooglePlayServicesClient.OnConnectionFailedListener) this);
            }
        }
    }

    @Override // android.view.View
    public boolean performClick() {
        return this.e.performClick();
    }

    public void setAnnotation(int i) {
        x.a(Integer.valueOf(i), "Annotation must not be null.");
        this.o = i;
        k();
        b();
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.e.setOnClickListener(onClickListener);
        this.f.setOnClickListener(onClickListener);
    }

    public void setOnPlusOneClickListener(PlusOneButton.OnPlusOneClickListener onPlusOneClickListener) {
        setOnClickListener(new a(onPlusOneClickListener));
    }

    public void setSize(int i) {
        a(i, this.g);
    }

    public void setType(int i) {
        a(this.p, i);
    }
}
