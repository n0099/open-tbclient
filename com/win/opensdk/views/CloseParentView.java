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
    public TextView f37145a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f37146b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f37147c;

    /* renamed from: d  reason: collision with root package name */
    public Context f37148d;

    /* renamed from: e  reason: collision with root package name */
    public View f37149e;

    /* renamed from: f  reason: collision with root package name */
    public View f37150f;

    /* renamed from: g  reason: collision with root package name */
    public O1 f37151g;

    /* renamed from: h  reason: collision with root package name */
    public int f37152h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f37153i;

    public CloseParentView(Context context) {
        this(context, null);
    }

    public CloseParentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f37153i = new L1(this);
        this.f37148d = context;
        LinearLayout.inflate(context, R.layout.win_layout_close, this);
        this.f37146b = (LinearLayout) findViewById(R.id.win_parent);
        this.f37149e = findViewById(R.id.win_iv_clct);
        this.f37147c = (RelativeLayout) findViewById(R.id.win_parent_close);
        this.f37150f = findViewById(R.id.win_tv_area);
        this.f37145a = (TextView) findViewById(R.id.wn_tv_cdt);
        this.f37146b.setOnClickListener(new M1(this));
        this.f37150f.setOnClickListener(new N1(this));
        setAreaLevel(1);
    }

    public final void a() {
    }

    public void b() {
        Handler handler = this.f37153i;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public final void c() {
        this.f37146b.removeView(this.f37147c);
        this.f37146b.addView(this.f37147c, 1);
        ((LinearLayout.LayoutParams) this.f37149e.getLayoutParams()).rightMargin = z.a(this.f37148d, 12.0f);
        ((LinearLayout.LayoutParams) this.f37147c.getLayoutParams()).rightMargin = 0;
    }

    public void setAreaLevel(int i2) {
        int i3 = i2 != 0 ? i2 != 1 ? i2 != 2 ? 0 : 30 : 22 : 10;
        ViewGroup.LayoutParams layoutParams = this.f37150f.getLayoutParams();
        int a2 = z.a(this.f37148d, i3);
        layoutParams.width = a2;
        layoutParams.height = a2;
    }

    public void setCollectVisible(boolean z) {
        this.f37149e.setVisibility(z ? 0 : 8);
        this.f37146b.setClickable(z);
    }

    public void setCountDown(int i2) {
        this.f37152h = i2;
        this.f37153i.sendEmptyMessage(10);
    }

    public void setLocation(int i2) {
        if (i2 != 110) {
            c();
            return;
        }
        this.f37146b.removeView(this.f37147c);
        this.f37146b.addView(this.f37147c, 0);
        ((LinearLayout.LayoutParams) this.f37149e.getLayoutParams()).rightMargin = 0;
        ((LinearLayout.LayoutParams) this.f37147c.getLayoutParams()).rightMargin = z.a(this.f37148d, 12.0f);
    }

    public void setOnCloseListener(O1 o1) {
        this.f37151g = o1;
    }

    public void setOnCollectListener(P1 p1) {
    }
}
