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
    private Context pYJ;
    private Handler pZR;
    private View qaU;
    private TextView qbd;
    private LinearLayout qbe;
    private RelativeLayout qbf;
    private View qbg;
    private a qbh;
    private b qbi;

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
        this.pZR = new Handler() { // from class: com.win.opensdk.views.CloseParentView.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                if (message.what == 10) {
                    CloseParentView.this.qbd.setText(String.valueOf(CloseParentView.this.java));
                    if (CloseParentView.this.java <= 0) {
                        CloseParentView.this.qbd.setVisibility(8);
                        CloseParentView.this.qbd.setClickable(false);
                        CloseParentView.this.pZR.removeMessages(10);
                    } else {
                        CloseParentView.this.qbd.setVisibility(0);
                        CloseParentView.this.qbd.setClickable(true);
                    }
                    CloseParentView.this.pZR.sendEmptyMessageDelayed(10, 1000L);
                    CloseParentView.d(CloseParentView.this);
                }
            }
        };
        this.pYJ = context;
        inflate(context, d.c.layout_close, this);
        this.qbe = (LinearLayout) findViewById(d.b.parent);
        this.qaU = findViewById(d.b.iv_clct);
        this.qbf = (RelativeLayout) findViewById(d.b.parent_close);
        this.qbg = findViewById(d.b.tv_area);
        this.qbd = (TextView) findViewById(d.b.tv_cdt);
        this.qbe.setOnClickListener(new View.OnClickListener() { // from class: com.win.opensdk.views.CloseParentView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CloseParentView.eGz();
            }
        });
        this.qbg.setOnClickListener(new View.OnClickListener() { // from class: com.win.opensdk.views.CloseParentView.3
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
        ViewGroup.LayoutParams layoutParams = this.qbg.getLayoutParams();
        int k = bg.k(this.pYJ, i2);
        layoutParams.width = k;
        layoutParams.height = k;
    }

    public void setCollectVisible(boolean z) {
        this.qaU.setVisibility(z ? 0 : 8);
        this.qbe.setClickable(z);
    }

    public void setLocation(int i) {
        switch (i) {
            case 110:
                this.qbe.removeView(this.qbf);
                this.qbe.addView(this.qbf, 0);
                ((LinearLayout.LayoutParams) this.qaU.getLayoutParams()).rightMargin = 0;
                ((LinearLayout.LayoutParams) this.qbf.getLayoutParams()).rightMargin = bg.k(this.pYJ, 12.0f);
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
        this.pZR.sendEmptyMessage(10);
    }

    public void setOnCollectListener(a aVar) {
        this.qbh = aVar;
    }

    public void setOnCloseListener(b bVar) {
        this.qbi = bVar;
    }

    private void eGA() {
        this.qbe.removeView(this.qbf);
        this.qbe.addView(this.qbf, 1);
        ((LinearLayout.LayoutParams) this.qaU.getLayoutParams()).rightMargin = bg.k(this.pYJ, 12.0f);
        ((LinearLayout.LayoutParams) this.qbf.getLayoutParams()).rightMargin = 0;
    }

    static /* synthetic */ void e(CloseParentView closeParentView) {
        if (closeParentView.qbi == null) {
            return;
        }
        closeParentView.qbi.eGz();
    }
}
