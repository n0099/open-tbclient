package com.win.opensdk.views;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.win.opensdk.bg;
import com.win.opensdk.d;
/* loaded from: classes3.dex */
public class CloseParentView extends LinearLayout {
    private int java;
    private Context pYI;
    private Handler pZQ;
    private View qaT;
    private TextView qbc;
    private LinearLayout qbd;
    private RelativeLayout qbe;
    private View qbf;
    private a qbg;
    private b qbh;

    /* loaded from: classes3.dex */
    public interface a {
    }

    /* loaded from: classes3.dex */
    public interface b {
        void eGz();
    }

    static /* synthetic */ int d(CloseParentView closeParentView) {
        int i = closeParentView.java;
        closeParentView.java = i - 1;
        return i;
    }

    static /* synthetic */ void eGz() {
    }

    public CloseParentView(Context context) {
        this(context, null);
    }

    public CloseParentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pZQ = new Handler() { // from class: com.win.opensdk.views.CloseParentView.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                if (message.what == 10) {
                    CloseParentView.this.qbc.setText(String.valueOf(CloseParentView.this.java));
                    if (CloseParentView.this.java <= 0) {
                        CloseParentView.this.qbc.setVisibility(8);
                        CloseParentView.this.qbc.setClickable(false);
                        CloseParentView.this.pZQ.removeMessages(10);
                    } else {
                        CloseParentView.this.qbc.setVisibility(0);
                        CloseParentView.this.qbc.setClickable(true);
                    }
                    CloseParentView.this.pZQ.sendEmptyMessageDelayed(10, 1000L);
                    CloseParentView.d(CloseParentView.this);
                }
            }
        };
        this.pYI = context;
        inflate(context, d.c.layout_close, this);
        this.qbd = (LinearLayout) findViewById(d.b.parent);
        this.qaT = findViewById(d.b.iv_clct);
        this.qbe = (RelativeLayout) findViewById(d.b.parent_close);
        this.qbf = findViewById(d.b.tv_area);
        this.qbc = (TextView) findViewById(d.b.tv_cdt);
        this.qbd.setOnClickListener(new View.OnClickListener() { // from class: com.win.opensdk.views.CloseParentView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CloseParentView.eGz();
            }
        });
        this.qbf.setOnClickListener(new View.OnClickListener() { // from class: com.win.opensdk.views.CloseParentView.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CloseParentView.e(CloseParentView.this);
            }
        });
        setAreaLevel(1);
    }

    public void setAreaLevel(int i) {
        int i2 = 0;
        switch (i) {
            case 0:
                i2 = 10;
                break;
            case 1:
                i2 = 22;
                break;
            case 2:
                i2 = 30;
                break;
        }
        ViewGroup.LayoutParams layoutParams = this.qbf.getLayoutParams();
        int k = bg.k(this.pYI, i2);
        layoutParams.width = k;
        layoutParams.height = k;
    }

    public void setCollectVisible(boolean z) {
        this.qaT.setVisibility(z ? 0 : 8);
        this.qbd.setClickable(z);
    }

    public void setLocation(int i) {
        switch (i) {
            case 110:
                this.qbd.removeView(this.qbe);
                this.qbd.addView(this.qbe, 0);
                ((LinearLayout.LayoutParams) this.qaT.getLayoutParams()).rightMargin = 0;
                ((LinearLayout.LayoutParams) this.qbe.getLayoutParams()).rightMargin = bg.k(this.pYI, 12.0f);
                return;
            case 220:
                eGA();
                return;
            default:
                eGA();
                return;
        }
    }

    public void setCountDown(int i) {
        this.java = i;
        this.pZQ.sendEmptyMessage(10);
    }

    public void setOnCollectListener(a aVar) {
        this.qbg = aVar;
    }

    public void setOnCloseListener(b bVar) {
        this.qbh = bVar;
    }

    private void eGA() {
        this.qbd.removeView(this.qbe);
        this.qbd.addView(this.qbe, 1);
        ((LinearLayout.LayoutParams) this.qaT.getLayoutParams()).rightMargin = bg.k(this.pYI, 12.0f);
        ((LinearLayout.LayoutParams) this.qbe.getLayoutParams()).rightMargin = 0;
    }

    static /* synthetic */ void e(CloseParentView closeParentView) {
        if (closeParentView.qbh == null) {
            return;
        }
        closeParentView.qbh.eGz();
    }
}
