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
/* loaded from: classes6.dex */
public class CloseParentView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public TextView f37971a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f37972b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f37973c;

    /* renamed from: d  reason: collision with root package name */
    public Context f37974d;

    /* renamed from: e  reason: collision with root package name */
    public View f37975e;

    /* renamed from: f  reason: collision with root package name */
    public View f37976f;

    /* renamed from: g  reason: collision with root package name */
    public O1 f37977g;

    /* renamed from: h  reason: collision with root package name */
    public int f37978h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f37979i;

    public CloseParentView(Context context) {
        this(context, null);
    }

    public CloseParentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f37979i = new L1(this);
        this.f37974d = context;
        LinearLayout.inflate(context, R.layout.win_layout_close, this);
        this.f37972b = (LinearLayout) findViewById(R.id.win_parent);
        this.f37975e = findViewById(R.id.win_iv_clct);
        this.f37973c = (RelativeLayout) findViewById(R.id.win_parent_close);
        this.f37976f = findViewById(R.id.win_tv_area);
        this.f37971a = (TextView) findViewById(R.id.wn_tv_cdt);
        this.f37972b.setOnClickListener(new M1(this));
        this.f37976f.setOnClickListener(new N1(this));
        setAreaLevel(1);
    }

    public final void a() {
    }

    public void b() {
        Handler handler = this.f37979i;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public final void c() {
        this.f37972b.removeView(this.f37973c);
        this.f37972b.addView(this.f37973c, 1);
        ((LinearLayout.LayoutParams) this.f37975e.getLayoutParams()).rightMargin = z.a(this.f37974d, 12.0f);
        ((LinearLayout.LayoutParams) this.f37973c.getLayoutParams()).rightMargin = 0;
    }

    public void setAreaLevel(int i2) {
        int i3 = i2 != 0 ? i2 != 1 ? i2 != 2 ? 0 : 30 : 22 : 10;
        ViewGroup.LayoutParams layoutParams = this.f37976f.getLayoutParams();
        int a2 = z.a(this.f37974d, i3);
        layoutParams.width = a2;
        layoutParams.height = a2;
    }

    public void setCollectVisible(boolean z) {
        this.f37975e.setVisibility(z ? 0 : 8);
        this.f37972b.setClickable(z);
    }

    public void setCountDown(int i2) {
        this.f37978h = i2;
        this.f37979i.sendEmptyMessage(10);
    }

    public void setLocation(int i2) {
        if (i2 != 110) {
            c();
            return;
        }
        this.f37972b.removeView(this.f37973c);
        this.f37972b.addView(this.f37973c, 0);
        ((LinearLayout.LayoutParams) this.f37975e.getLayoutParams()).rightMargin = 0;
        ((LinearLayout.LayoutParams) this.f37973c.getLayoutParams()).rightMargin = z.a(this.f37974d, 12.0f);
    }

    public void setOnCloseListener(O1 o1) {
        this.f37977g = o1;
    }

    public void setOnCollectListener(P1 p1) {
    }
}
