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
/* loaded from: classes4.dex */
public class CloseParentView extends LinearLayout {
    private int java;
    private Context qdj;
    private Handler qer;
    private TextView qfD;
    private LinearLayout qfE;
    private RelativeLayout qfF;
    private View qfG;
    private a qfH;
    private b qfI;
    private View qfu;

    /* loaded from: classes4.dex */
    public interface a {
    }

    /* loaded from: classes4.dex */
    public interface b {
        void eKp();
    }

    static /* synthetic */ int d(CloseParentView closeParentView) {
        int i = closeParentView.java;
        closeParentView.java = i - 1;
        return i;
    }

    static /* synthetic */ void eKp() {
    }

    public CloseParentView(Context context) {
        this(context, null);
    }

    public CloseParentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.qer = new Handler() { // from class: com.win.opensdk.views.CloseParentView.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                if (message.what == 10) {
                    CloseParentView.this.qfD.setText(String.valueOf(CloseParentView.this.java));
                    if (CloseParentView.this.java <= 0) {
                        CloseParentView.this.qfD.setVisibility(8);
                        CloseParentView.this.qfD.setClickable(false);
                        CloseParentView.this.qer.removeMessages(10);
                    } else {
                        CloseParentView.this.qfD.setVisibility(0);
                        CloseParentView.this.qfD.setClickable(true);
                    }
                    CloseParentView.this.qer.sendEmptyMessageDelayed(10, 1000L);
                    CloseParentView.d(CloseParentView.this);
                }
            }
        };
        this.qdj = context;
        inflate(context, d.c.layout_close, this);
        this.qfE = (LinearLayout) findViewById(d.b.parent);
        this.qfu = findViewById(d.b.iv_clct);
        this.qfF = (RelativeLayout) findViewById(d.b.parent_close);
        this.qfG = findViewById(d.b.tv_area);
        this.qfD = (TextView) findViewById(d.b.tv_cdt);
        this.qfE.setOnClickListener(new View.OnClickListener() { // from class: com.win.opensdk.views.CloseParentView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CloseParentView.eKp();
            }
        });
        this.qfG.setOnClickListener(new View.OnClickListener() { // from class: com.win.opensdk.views.CloseParentView.3
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
        ViewGroup.LayoutParams layoutParams = this.qfG.getLayoutParams();
        int k = bg.k(this.qdj, i2);
        layoutParams.width = k;
        layoutParams.height = k;
    }

    public void setCollectVisible(boolean z) {
        this.qfu.setVisibility(z ? 0 : 8);
        this.qfE.setClickable(z);
    }

    public void setLocation(int i) {
        switch (i) {
            case 110:
                this.qfE.removeView(this.qfF);
                this.qfE.addView(this.qfF, 0);
                ((LinearLayout.LayoutParams) this.qfu.getLayoutParams()).rightMargin = 0;
                ((LinearLayout.LayoutParams) this.qfF.getLayoutParams()).rightMargin = bg.k(this.qdj, 12.0f);
                return;
            case 220:
                eKq();
                return;
            default:
                eKq();
                return;
        }
    }

    public void setCountDown(int i) {
        this.java = i;
        this.qer.sendEmptyMessage(10);
    }

    public void setOnCollectListener(a aVar) {
        this.qfH = aVar;
    }

    public void setOnCloseListener(b bVar) {
        this.qfI = bVar;
    }

    private void eKq() {
        this.qfE.removeView(this.qfF);
        this.qfE.addView(this.qfF, 1);
        ((LinearLayout.LayoutParams) this.qfu.getLayoutParams()).rightMargin = bg.k(this.qdj, 12.0f);
        ((LinearLayout.LayoutParams) this.qfF.getLayoutParams()).rightMargin = 0;
    }

    static /* synthetic */ void e(CloseParentView closeParentView) {
        if (closeParentView.qfI == null) {
            return;
        }
        closeParentView.qfI.eKp();
    }
}
