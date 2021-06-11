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
    public TextView f40824a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f40825b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f40826c;

    /* renamed from: d  reason: collision with root package name */
    public Context f40827d;

    /* renamed from: e  reason: collision with root package name */
    public View f40828e;

    /* renamed from: f  reason: collision with root package name */
    public View f40829f;

    /* renamed from: g  reason: collision with root package name */
    public O1 f40830g;

    /* renamed from: h  reason: collision with root package name */
    public int f40831h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f40832i;

    public CloseParentView(Context context) {
        this(context, null);
    }

    public CloseParentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f40832i = new L1(this);
        this.f40827d = context;
        LinearLayout.inflate(context, R.layout.win_layout_close, this);
        this.f40825b = (LinearLayout) findViewById(R.id.win_parent);
        this.f40828e = findViewById(R.id.win_iv_clct);
        this.f40826c = (RelativeLayout) findViewById(R.id.win_parent_close);
        this.f40829f = findViewById(R.id.win_tv_area);
        this.f40824a = (TextView) findViewById(R.id.wn_tv_cdt);
        this.f40825b.setOnClickListener(new M1(this));
        this.f40829f.setOnClickListener(new N1(this));
        setAreaLevel(1);
    }

    public final void a() {
    }

    public void b() {
        Handler handler = this.f40832i;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public final void c() {
        this.f40825b.removeView(this.f40826c);
        this.f40825b.addView(this.f40826c, 1);
        ((LinearLayout.LayoutParams) this.f40828e.getLayoutParams()).rightMargin = z.a(this.f40827d, 12.0f);
        ((LinearLayout.LayoutParams) this.f40826c.getLayoutParams()).rightMargin = 0;
    }

    public void setAreaLevel(int i2) {
        int i3 = i2 != 0 ? i2 != 1 ? i2 != 2 ? 0 : 30 : 22 : 10;
        ViewGroup.LayoutParams layoutParams = this.f40829f.getLayoutParams();
        int a2 = z.a(this.f40827d, i3);
        layoutParams.width = a2;
        layoutParams.height = a2;
    }

    public void setCollectVisible(boolean z) {
        this.f40828e.setVisibility(z ? 0 : 8);
        this.f40825b.setClickable(z);
    }

    public void setCountDown(int i2) {
        this.f40831h = i2;
        this.f40832i.sendEmptyMessage(10);
    }

    public void setLocation(int i2) {
        if (i2 != 110) {
            c();
            return;
        }
        this.f40825b.removeView(this.f40826c);
        this.f40825b.addView(this.f40826c, 0);
        ((LinearLayout.LayoutParams) this.f40828e.getLayoutParams()).rightMargin = 0;
        ((LinearLayout.LayoutParams) this.f40826c.getLayoutParams()).rightMargin = z.a(this.f40827d, 12.0f);
    }

    public void setOnCloseListener(O1 o1) {
        this.f40830g = o1;
    }

    public void setOnCollectListener(P1 p1) {
    }
}
