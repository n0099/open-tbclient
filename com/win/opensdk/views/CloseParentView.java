package com.win.opensdk.views;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.win.opensdk.bd;
import com.win.opensdk.dx;
import com.win.opensdk.eb;
import com.win.opensdk.ee;
import com.win.opensdk.ei;
import com.win.opensdk.em;
import com.win.opensdk.v;
/* loaded from: classes14.dex */
public class CloseParentView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public TextView f8177a;
    public LinearLayout b;
    public RelativeLayout c;
    public Context d;
    public View e;
    public View f;
    public int h;
    public Handler i;
    public ei qms;

    public CloseParentView(Context context) {
        this(context, null);
    }

    public CloseParentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = new dx(this);
        this.d = context;
        LinearLayout.inflate(context, bd.c.layout_close, this);
        this.b = (LinearLayout) findViewById(bd.b.parent);
        this.e = findViewById(bd.b.iv_clct);
        this.c = (RelativeLayout) findViewById(bd.b.parent_close);
        this.f = findViewById(bd.b.tv_area);
        this.f8177a = (TextView) findViewById(bd.b.tv_cdt);
        this.b.setOnClickListener(new eb(this));
        this.f.setOnClickListener(new ee(this));
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
        this.b.removeView(this.c);
        this.b.addView(this.c, 1);
        ((LinearLayout.LayoutParams) this.e.getLayoutParams()).rightMargin = v.a(this.d, 12.0f);
        ((LinearLayout.LayoutParams) this.c.getLayoutParams()).rightMargin = 0;
    }

    public void setAreaLevel(int i) {
        int i2 = 0;
        if (i == 0) {
            i2 = 10;
        } else if (i == 1) {
            i2 = 22;
        } else if (i == 2) {
            i2 = 30;
        }
        ViewGroup.LayoutParams layoutParams = this.f.getLayoutParams();
        int a2 = v.a(this.d, i2);
        layoutParams.width = a2;
        layoutParams.height = a2;
    }

    public void setCollectVisible(boolean z) {
        this.e.setVisibility(z ? 0 : 8);
        this.b.setClickable(z);
    }

    public void setCountDown(int i) {
        this.h = i;
        this.i.sendEmptyMessage(10);
    }

    public void setLocation(int i) {
        if (i != 110) {
            c();
            return;
        }
        this.b.removeView(this.c);
        this.b.addView(this.c, 0);
        ((LinearLayout.LayoutParams) this.e.getLayoutParams()).rightMargin = 0;
        ((LinearLayout.LayoutParams) this.c.getLayoutParams()).rightMargin = v.a(this.d, 12.0f);
    }

    public void setOnCloseListener(ei eiVar) {
        this.qms = eiVar;
    }

    public void setOnCollectListener(em emVar) {
    }
}
