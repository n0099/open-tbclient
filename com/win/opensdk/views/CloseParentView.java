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
    private Context qbB;
    private Handler qcJ;
    private View qdM;
    private TextView qdV;
    private LinearLayout qdW;
    private RelativeLayout qdX;
    private View qdY;
    private a qdZ;
    private b qea;

    /* loaded from: classes4.dex */
    public interface a {
    }

    /* loaded from: classes4.dex */
    public interface b {
        void eJL();
    }

    static /* synthetic */ int d(CloseParentView closeParentView) {
        int i = closeParentView.java;
        closeParentView.java = i - 1;
        return i;
    }

    static /* synthetic */ void eJL() {
    }

    public CloseParentView(Context context) {
        this(context, null);
    }

    public CloseParentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.qcJ = new Handler() { // from class: com.win.opensdk.views.CloseParentView.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                if (message.what == 10) {
                    CloseParentView.this.qdV.setText(String.valueOf(CloseParentView.this.java));
                    if (CloseParentView.this.java <= 0) {
                        CloseParentView.this.qdV.setVisibility(8);
                        CloseParentView.this.qdV.setClickable(false);
                        CloseParentView.this.qcJ.removeMessages(10);
                    } else {
                        CloseParentView.this.qdV.setVisibility(0);
                        CloseParentView.this.qdV.setClickable(true);
                    }
                    CloseParentView.this.qcJ.sendEmptyMessageDelayed(10, 1000L);
                    CloseParentView.d(CloseParentView.this);
                }
            }
        };
        this.qbB = context;
        inflate(context, d.c.layout_close, this);
        this.qdW = (LinearLayout) findViewById(d.b.parent);
        this.qdM = findViewById(d.b.iv_clct);
        this.qdX = (RelativeLayout) findViewById(d.b.parent_close);
        this.qdY = findViewById(d.b.tv_area);
        this.qdV = (TextView) findViewById(d.b.tv_cdt);
        this.qdW.setOnClickListener(new View.OnClickListener() { // from class: com.win.opensdk.views.CloseParentView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CloseParentView.eJL();
            }
        });
        this.qdY.setOnClickListener(new View.OnClickListener() { // from class: com.win.opensdk.views.CloseParentView.3
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
        ViewGroup.LayoutParams layoutParams = this.qdY.getLayoutParams();
        int k = bg.k(this.qbB, i2);
        layoutParams.width = k;
        layoutParams.height = k;
    }

    public void setCollectVisible(boolean z) {
        this.qdM.setVisibility(z ? 0 : 8);
        this.qdW.setClickable(z);
    }

    public void setLocation(int i) {
        switch (i) {
            case 110:
                this.qdW.removeView(this.qdX);
                this.qdW.addView(this.qdX, 0);
                ((LinearLayout.LayoutParams) this.qdM.getLayoutParams()).rightMargin = 0;
                ((LinearLayout.LayoutParams) this.qdX.getLayoutParams()).rightMargin = bg.k(this.qbB, 12.0f);
                return;
            case 220:
                eJM();
                return;
            default:
                eJM();
                return;
        }
    }

    public void setCountDown(int i) {
        this.java = i;
        this.qcJ.sendEmptyMessage(10);
    }

    public void setOnCollectListener(a aVar) {
        this.qdZ = aVar;
    }

    public void setOnCloseListener(b bVar) {
        this.qea = bVar;
    }

    private void eJM() {
        this.qdW.removeView(this.qdX);
        this.qdW.addView(this.qdX, 1);
        ((LinearLayout.LayoutParams) this.qdM.getLayoutParams()).rightMargin = bg.k(this.qbB, 12.0f);
        ((LinearLayout.LayoutParams) this.qdX.getLayoutParams()).rightMargin = 0;
    }

    static /* synthetic */ void e(CloseParentView closeParentView) {
        if (closeParentView.qea == null) {
            return;
        }
        closeParentView.qea.eJL();
    }
}
