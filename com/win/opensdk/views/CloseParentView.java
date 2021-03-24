package com.win.opensdk.views;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.win.opensdk.G;
import com.win.opensdk.R;
import com.win.opensdk.p2;
import com.win.opensdk.q2;
import com.win.opensdk.r2;
import com.win.opensdk.s2;
import com.win.opensdk.t2;
/* loaded from: classes7.dex */
public class CloseParentView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public TextView f40077a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f40078b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f40079c;

    /* renamed from: d  reason: collision with root package name */
    public Context f40080d;

    /* renamed from: e  reason: collision with root package name */
    public View f40081e;

    /* renamed from: f  reason: collision with root package name */
    public View f40082f;

    /* renamed from: g  reason: collision with root package name */
    public s2 f40083g;

    /* renamed from: h  reason: collision with root package name */
    public int f40084h;
    public Handler i;

    public CloseParentView(Context context) {
        this(context, null);
    }

    public CloseParentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = new p2(this);
        this.f40080d = context;
        LinearLayout.inflate(context, R.layout.layout_close, this);
        this.f40078b = (LinearLayout) findViewById(R.id.parent);
        this.f40081e = findViewById(R.id.iv_clct);
        this.f40079c = (RelativeLayout) findViewById(R.id.parent_close);
        this.f40082f = findViewById(R.id.tv_area);
        this.f40077a = (TextView) findViewById(R.id.tv_cdt);
        this.f40078b.setOnClickListener(new q2(this));
        this.f40082f.setOnClickListener(new r2(this));
        setAreaLevel(1);
    }

    public final void a() {
    }

    public void b() {
        Handler handler = this.i;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public final void c() {
        this.f40078b.removeView(this.f40079c);
        this.f40078b.addView(this.f40079c, 1);
        ((LinearLayout.LayoutParams) this.f40081e.getLayoutParams()).rightMargin = G.a(this.f40080d, 12.0f);
        ((LinearLayout.LayoutParams) this.f40079c.getLayoutParams()).rightMargin = 0;
    }

    public void setAreaLevel(int i) {
        int i2 = i != 0 ? i != 1 ? i != 2 ? 0 : 30 : 22 : 10;
        ViewGroup.LayoutParams layoutParams = this.f40082f.getLayoutParams();
        int a2 = G.a(this.f40080d, i2);
        layoutParams.width = a2;
        layoutParams.height = a2;
    }

    public void setCollectVisible(boolean z) {
        this.f40081e.setVisibility(z ? 0 : 8);
        this.f40078b.setClickable(z);
    }

    public void setCountDown(int i) {
        this.f40084h = i;
        this.i.sendEmptyMessage(10);
    }

    public void setLocation(int i) {
        if (i != 110) {
            c();
            return;
        }
        this.f40078b.removeView(this.f40079c);
        this.f40078b.addView(this.f40079c, 0);
        ((LinearLayout.LayoutParams) this.f40081e.getLayoutParams()).rightMargin = 0;
        ((LinearLayout.LayoutParams) this.f40079c.getLayoutParams()).rightMargin = G.a(this.f40080d, 12.0f);
    }

    public void setOnCloseListener(s2 s2Var) {
        this.f40083g = s2Var;
    }

    public void setOnCollectListener(t2 t2Var) {
    }
}
