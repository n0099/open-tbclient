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
import com.thunder.livesdk.video.serviceConfig.VideoLiveConfig;
import com.win.opensdk.bg;
import com.win.opensdk.d;
/* loaded from: classes3.dex */
public class CloseParentView extends LinearLayout {
    private int java;
    private Context qiN;
    private Handler qjV;
    private View qkY;
    private TextView qlh;
    private LinearLayout qli;
    private RelativeLayout qlj;
    private View qlk;
    private a qll;
    private b qlm;

    /* loaded from: classes3.dex */
    public interface a {
    }

    /* loaded from: classes3.dex */
    public interface b {
        void eIP();
    }

    static /* synthetic */ int d(CloseParentView closeParentView) {
        int i = closeParentView.java;
        closeParentView.java = i - 1;
        return i;
    }

    static /* synthetic */ void eIP() {
    }

    public CloseParentView(Context context) {
        this(context, null);
    }

    public CloseParentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.qjV = new Handler() { // from class: com.win.opensdk.views.CloseParentView.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                if (message.what == 10) {
                    CloseParentView.this.qlh.setText(String.valueOf(CloseParentView.this.java));
                    if (CloseParentView.this.java <= 0) {
                        CloseParentView.this.qlh.setVisibility(8);
                        CloseParentView.this.qlh.setClickable(false);
                        CloseParentView.this.qjV.removeMessages(10);
                    } else {
                        CloseParentView.this.qlh.setVisibility(0);
                        CloseParentView.this.qlh.setClickable(true);
                    }
                    CloseParentView.this.qjV.sendEmptyMessageDelayed(10, 1000L);
                    CloseParentView.d(CloseParentView.this);
                }
            }
        };
        this.qiN = context;
        inflate(context, d.c.layout_close, this);
        this.qli = (LinearLayout) findViewById(d.b.parent);
        this.qkY = findViewById(d.b.iv_clct);
        this.qlj = (RelativeLayout) findViewById(d.b.parent_close);
        this.qlk = findViewById(d.b.tv_area);
        this.qlh = (TextView) findViewById(d.b.tv_cdt);
        this.qli.setOnClickListener(new View.OnClickListener() { // from class: com.win.opensdk.views.CloseParentView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CloseParentView.eIP();
            }
        });
        this.qlk.setOnClickListener(new View.OnClickListener() { // from class: com.win.opensdk.views.CloseParentView.3
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
        ViewGroup.LayoutParams layoutParams = this.qlk.getLayoutParams();
        int k = bg.k(this.qiN, i2);
        layoutParams.width = k;
        layoutParams.height = k;
    }

    public void setCollectVisible(boolean z) {
        this.qkY.setVisibility(z ? 0 : 8);
        this.qli.setClickable(z);
    }

    public void setLocation(int i) {
        switch (i) {
            case 110:
                this.qli.removeView(this.qlj);
                this.qli.addView(this.qlj, 0);
                ((LinearLayout.LayoutParams) this.qkY.getLayoutParams()).rightMargin = 0;
                ((LinearLayout.LayoutParams) this.qlj.getLayoutParams()).rightMargin = bg.k(this.qiN, 12.0f);
                return;
            case VideoLiveConfig.EncodeType.PHONE_CODEC_HW_H265 /* 220 */:
                eIQ();
                return;
            default:
                eIQ();
                return;
        }
    }

    public void setCountDown(int i) {
        this.java = i;
        this.qjV.sendEmptyMessage(10);
    }

    public void setOnCollectListener(a aVar) {
        this.qll = aVar;
    }

    public void setOnCloseListener(b bVar) {
        this.qlm = bVar;
    }

    private void eIQ() {
        this.qli.removeView(this.qlj);
        this.qli.addView(this.qlj, 1);
        ((LinearLayout.LayoutParams) this.qkY.getLayoutParams()).rightMargin = bg.k(this.qiN, 12.0f);
        ((LinearLayout.LayoutParams) this.qlj.getLayoutParams()).rightMargin = 0;
    }

    static /* synthetic */ void e(CloseParentView closeParentView) {
        if (closeParentView.qlm == null) {
            return;
        }
        closeParentView.qlm.eIP();
    }
}
