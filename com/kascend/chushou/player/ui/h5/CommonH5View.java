package com.kascend.chushou.player.ui.h5;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.kascend.chushou.a;
import com.kascend.chushou.constants.H5Positon;
import com.kascend.chushou.player.VideoPlayer;
/* loaded from: classes6.dex */
public class CommonH5View extends FrameLayout implements View.OnClickListener {
    private Context a;
    private View b;
    private View c;
    private int e;
    private CommonH5Item nAe;
    private H5Positon nAf;
    private com.kascend.chushou.player.ui.h5.c.a nAg;
    private com.kascend.chushou.widget.cswebview.d nAh;

    public CommonH5View(@NonNull Context context) {
        this(context, null);
    }

    public CommonH5View(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonH5View(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = 2;
        a(context);
    }

    private void a(Context context) {
        this.a = context;
    }

    public void a(int i, H5Positon h5Positon, com.kascend.chushou.player.ui.h5.c.a aVar) {
        int i2;
        this.e = i;
        this.nAf = h5Positon;
        this.nAg = aVar;
        if (this.b == null) {
            c();
        }
        if (this.e == 2) {
            d();
        } else {
            e();
        }
        try {
            i2 = Color.parseColor(aVar.k);
        } catch (Exception e) {
            i2 = 0;
        }
        setBackgroundColor(i2);
        this.nAe.a(aVar);
    }

    private void c() {
        int i = a.h.layout_common_room_webview;
        if (this.e == 1) {
            i = a.h.layout_common_room_webview_landscape;
        }
        this.b = LayoutInflater.from(this.a).inflate(i, (ViewGroup) this, false);
        this.c = this.b.findViewById(a.f.view_redpacketlist_close);
        if (this.nAg.i == 0) {
            this.c.setVisibility(4);
        } else {
            this.c.setOnClickListener(this);
        }
        this.nAe = (CommonH5Item) this.b.findViewById(a.f.view_smallh5);
        this.nAe.setListener(new com.kascend.chushou.widget.cswebview.d() { // from class: com.kascend.chushou.player.ui.h5.CommonH5View.1
            @Override // com.kascend.chushou.widget.cswebview.d
            public void a(Object obj) {
                CommonH5View.this.a();
            }

            @Override // com.kascend.chushou.widget.cswebview.d
            public void a(String str) {
                if (CommonH5View.this.nAg != null) {
                    tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.c(com.kascend.chushou.b.a.a.c.b, str, CommonH5View.this.nAg.p));
                }
            }
        });
        addView(this.b, new FrameLayout.LayoutParams(-1, -1));
    }

    private void d() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.b.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.gravity = 17;
        this.b.setLayoutParams(layoutParams);
        Point gE = tv.chushou.zues.utils.a.gE(this.a);
        int statusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.a);
        int i = gE.x;
        int i2 = gE.y - statusBarHeight;
        if (this.a != null && (this.a instanceof VideoPlayer) && ((VideoPlayer) this.a).getWindow().getDecorView().getSystemUiVisibility() == 1792) {
            i2 = gE.y;
        }
        View findViewById = this.b.findViewById(a.f.empty_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
        int i3 = (int) (((((100 - this.nAf.mHeight) * 1.0d) / 2.0d) / 100.0d) * i2);
        layoutParams2.height = i3;
        findViewById.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.nAe.getLayoutParams();
        layoutParams3.width = (int) (i * ((this.nAf.mWidth * 1.0d) / 100.0d));
        layoutParams3.height = (int) (((this.nAf.mHeight * 1.0d) / 100.0d) * i2);
        this.nAe.setLayoutParams(layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.c.getLayoutParams();
        layoutParams4.topMargin = (int) (i3 * 0.2d);
        this.c.setLayoutParams(layoutParams4);
    }

    private void e() {
        int i;
        Point gE = tv.chushou.zues.utils.a.gE(this.a);
        int i2 = (int) (((this.nAf.mHeight * 1.0d) / 100.0d) * gE.y);
        if (this.nAf.mAspectRadio == 0) {
            i = (int) (((this.nAf.mWidth * 1.0d) / 100.0d) * gE.x);
        } else {
            i = (int) (((this.nAf.mAspectRadio * 1.0d) / 100.0d) * i2);
        }
        if (this.nAg.i == 0) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.b.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            layoutParams.gravity = 17;
            this.b.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
        layoutParams2.topMargin = (int) (gE.y * 0.05d);
        this.c.setLayoutParams(layoutParams2);
        int dip2px = tv.chushou.zues.utils.a.dip2px(this.a, 60.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.b.getLayoutParams();
        layoutParams3.width = dip2px + i;
        layoutParams3.height = i2;
        layoutParams3.gravity = 16;
        layoutParams3.leftMargin = (gE.x - i) / 2;
        this.b.setLayoutParams(layoutParams3);
    }

    public void a() {
        if (this.nAh != null) {
            this.nAh.a(this);
        }
    }

    public void setCloseH5Listener(com.kascend.chushou.widget.cswebview.d dVar) {
        this.nAh = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.f.view_redpacketlist_close) {
            if (this.nAg != null && this.nAg.j == 1) {
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.c(com.kascend.chushou.b.a.a.c.b, this.nAg.b, this.nAg.p));
            } else {
                a();
            }
        }
    }

    public void b() {
        if (this.nAe != null) {
            tv.chushou.zues.toolkit.d.b.setScaleX(this.nAe, 0.0f);
            tv.chushou.zues.toolkit.d.b.setScaleY(this.nAe, 0.0f);
            this.nAe.animate().scaleX(1.0f).scaleY(1.0f).setDuration(300L).start();
        }
    }
}
