package com.win.opensdk.views;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.win.opensdk.L1;
import com.win.opensdk.M1;
import com.win.opensdk.N1;
import com.win.opensdk.O1;
import com.win.opensdk.P1;
import com.win.opensdk.R;
import com.win.opensdk.z;
/* loaded from: classes7.dex */
public class CloseParentView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public TextView f37216a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f37217b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f37218c;

    /* renamed from: d  reason: collision with root package name */
    public Context f37219d;

    /* renamed from: e  reason: collision with root package name */
    public View f37220e;

    /* renamed from: f  reason: collision with root package name */
    public View f37221f;

    /* renamed from: g  reason: collision with root package name */
    public O1 f37222g;

    /* renamed from: h  reason: collision with root package name */
    public int f37223h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f37224i;

    public CloseParentView(Context context) {
        this(context, null);
    }

    public CloseParentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f37224i = new L1(this);
        this.f37219d = context;
        LinearLayout.inflate(context, R.layout.win_layout_close, this);
        this.f37217b = (LinearLayout) findViewById(R.id.win_parent);
        this.f37220e = findViewById(R.id.win_iv_clct);
        this.f37218c = (RelativeLayout) findViewById(R.id.win_parent_close);
        this.f37221f = findViewById(R.id.win_tv_area);
        this.f37216a = (TextView) findViewById(R.id.wn_tv_cdt);
        this.f37217b.setOnClickListener(new M1(this));
        this.f37221f.setOnClickListener(new N1(this));
        setAreaLevel(1);
    }

    public final void a() {
    }

    public void b() {
        Handler handler = this.f37224i;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public final void c() {
        this.f37217b.removeView(this.f37218c);
        this.f37217b.addView(this.f37218c, 1);
        ((LinearLayout.LayoutParams) this.f37220e.getLayoutParams()).rightMargin = z.a(this.f37219d, 12.0f);
        ((LinearLayout.LayoutParams) this.f37218c.getLayoutParams()).rightMargin = 0;
    }

    public void setAreaLevel(int i2) {
        int i3 = i2 != 0 ? i2 != 1 ? i2 != 2 ? 0 : 30 : 22 : 10;
        ViewGroup.LayoutParams layoutParams = this.f37221f.getLayoutParams();
        int a2 = z.a(this.f37219d, i3);
        layoutParams.width = a2;
        layoutParams.height = a2;
    }

    public void setCollectVisible(boolean z) {
        this.f37220e.setVisibility(z ? 0 : 8);
        this.f37217b.setClickable(z);
    }

    public void setCountDown(int i2) {
        this.f37223h = i2;
        this.f37224i.sendEmptyMessage(10);
    }

    public void setLocation(int i2) {
        if (i2 != 110) {
            c();
            return;
        }
        this.f37217b.removeView(this.f37218c);
        this.f37217b.addView(this.f37218c, 0);
        ((LinearLayout.LayoutParams) this.f37220e.getLayoutParams()).rightMargin = 0;
        ((LinearLayout.LayoutParams) this.f37218c.getLayoutParams()).rightMargin = z.a(this.f37219d, 12.0f);
    }

    public void setOnCloseListener(O1 o1) {
        this.f37222g = o1;
    }

    public void setOnCollectListener(P1 p1) {
    }
}
