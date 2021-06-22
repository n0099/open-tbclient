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
    public TextView f40927a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f40928b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f40929c;

    /* renamed from: d  reason: collision with root package name */
    public Context f40930d;

    /* renamed from: e  reason: collision with root package name */
    public View f40931e;

    /* renamed from: f  reason: collision with root package name */
    public View f40932f;

    /* renamed from: g  reason: collision with root package name */
    public O1 f40933g;

    /* renamed from: h  reason: collision with root package name */
    public int f40934h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f40935i;

    public CloseParentView(Context context) {
        this(context, null);
    }

    public CloseParentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f40935i = new L1(this);
        this.f40930d = context;
        LinearLayout.inflate(context, R.layout.win_layout_close, this);
        this.f40928b = (LinearLayout) findViewById(R.id.win_parent);
        this.f40931e = findViewById(R.id.win_iv_clct);
        this.f40929c = (RelativeLayout) findViewById(R.id.win_parent_close);
        this.f40932f = findViewById(R.id.win_tv_area);
        this.f40927a = (TextView) findViewById(R.id.wn_tv_cdt);
        this.f40928b.setOnClickListener(new M1(this));
        this.f40932f.setOnClickListener(new N1(this));
        setAreaLevel(1);
    }

    public final void a() {
    }

    public void b() {
        Handler handler = this.f40935i;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public final void c() {
        this.f40928b.removeView(this.f40929c);
        this.f40928b.addView(this.f40929c, 1);
        ((LinearLayout.LayoutParams) this.f40931e.getLayoutParams()).rightMargin = z.a(this.f40930d, 12.0f);
        ((LinearLayout.LayoutParams) this.f40929c.getLayoutParams()).rightMargin = 0;
    }

    public void setAreaLevel(int i2) {
        int i3 = i2 != 0 ? i2 != 1 ? i2 != 2 ? 0 : 30 : 22 : 10;
        ViewGroup.LayoutParams layoutParams = this.f40932f.getLayoutParams();
        int a2 = z.a(this.f40930d, i3);
        layoutParams.width = a2;
        layoutParams.height = a2;
    }

    public void setCollectVisible(boolean z) {
        this.f40931e.setVisibility(z ? 0 : 8);
        this.f40928b.setClickable(z);
    }

    public void setCountDown(int i2) {
        this.f40934h = i2;
        this.f40935i.sendEmptyMessage(10);
    }

    public void setLocation(int i2) {
        if (i2 != 110) {
            c();
            return;
        }
        this.f40928b.removeView(this.f40929c);
        this.f40928b.addView(this.f40929c, 0);
        ((LinearLayout.LayoutParams) this.f40931e.getLayoutParams()).rightMargin = 0;
        ((LinearLayout.LayoutParams) this.f40929c.getLayoutParams()).rightMargin = z.a(this.f40930d, 12.0f);
    }

    public void setOnCloseListener(O1 o1) {
        this.f40933g = o1;
    }

    public void setOnCollectListener(P1 p1) {
    }
}
