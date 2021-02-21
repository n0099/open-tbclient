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
    private Context qjn;
    private Handler qkv;
    private TextView qlH;
    private LinearLayout qlI;
    private RelativeLayout qlJ;
    private View qlK;
    private a qlL;
    private b qlM;
    private View qly;

    /* loaded from: classes3.dex */
    public interface a {
    }

    /* loaded from: classes3.dex */
    public interface b {
        void eIX();
    }

    static /* synthetic */ int d(CloseParentView closeParentView) {
        int i = closeParentView.java;
        closeParentView.java = i - 1;
        return i;
    }

    static /* synthetic */ void eIX() {
    }

    public CloseParentView(Context context) {
        this(context, null);
    }

    public CloseParentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.qkv = new Handler() { // from class: com.win.opensdk.views.CloseParentView.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                if (message.what == 10) {
                    CloseParentView.this.qlH.setText(String.valueOf(CloseParentView.this.java));
                    if (CloseParentView.this.java <= 0) {
                        CloseParentView.this.qlH.setVisibility(8);
                        CloseParentView.this.qlH.setClickable(false);
                        CloseParentView.this.qkv.removeMessages(10);
                    } else {
                        CloseParentView.this.qlH.setVisibility(0);
                        CloseParentView.this.qlH.setClickable(true);
                    }
                    CloseParentView.this.qkv.sendEmptyMessageDelayed(10, 1000L);
                    CloseParentView.d(CloseParentView.this);
                }
            }
        };
        this.qjn = context;
        inflate(context, d.c.layout_close, this);
        this.qlI = (LinearLayout) findViewById(d.b.parent);
        this.qly = findViewById(d.b.iv_clct);
        this.qlJ = (RelativeLayout) findViewById(d.b.parent_close);
        this.qlK = findViewById(d.b.tv_area);
        this.qlH = (TextView) findViewById(d.b.tv_cdt);
        this.qlI.setOnClickListener(new View.OnClickListener() { // from class: com.win.opensdk.views.CloseParentView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CloseParentView.eIX();
            }
        });
        this.qlK.setOnClickListener(new View.OnClickListener() { // from class: com.win.opensdk.views.CloseParentView.3
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
        ViewGroup.LayoutParams layoutParams = this.qlK.getLayoutParams();
        int k = bg.k(this.qjn, i2);
        layoutParams.width = k;
        layoutParams.height = k;
    }

    public void setCollectVisible(boolean z) {
        this.qly.setVisibility(z ? 0 : 8);
        this.qlI.setClickable(z);
    }

    public void setLocation(int i) {
        switch (i) {
            case 110:
                this.qlI.removeView(this.qlJ);
                this.qlI.addView(this.qlJ, 0);
                ((LinearLayout.LayoutParams) this.qly.getLayoutParams()).rightMargin = 0;
                ((LinearLayout.LayoutParams) this.qlJ.getLayoutParams()).rightMargin = bg.k(this.qjn, 12.0f);
                return;
            case VideoLiveConfig.EncodeType.PHONE_CODEC_HW_H265 /* 220 */:
                eIY();
                return;
            default:
                eIY();
                return;
        }
    }

    public void setCountDown(int i) {
        this.java = i;
        this.qkv.sendEmptyMessage(10);
    }

    public void setOnCollectListener(a aVar) {
        this.qlL = aVar;
    }

    public void setOnCloseListener(b bVar) {
        this.qlM = bVar;
    }

    private void eIY() {
        this.qlI.removeView(this.qlJ);
        this.qlI.addView(this.qlJ, 1);
        ((LinearLayout.LayoutParams) this.qly.getLayoutParams()).rightMargin = bg.k(this.qjn, 12.0f);
        ((LinearLayout.LayoutParams) this.qlJ.getLayoutParams()).rightMargin = 0;
    }

    static /* synthetic */ void e(CloseParentView closeParentView) {
        if (closeParentView.qlM == null) {
            return;
        }
        closeParentView.qlM.eIX();
    }
}
