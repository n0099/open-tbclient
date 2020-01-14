package com.kascend.chushou.player.ui.h5;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.kascend.chushou.a;
import com.kascend.chushou.constants.H5Positon;
import com.kascend.chushou.widget.cswebview.e;
/* loaded from: classes4.dex */
public class c extends FrameLayout implements View.OnClickListener {
    private Context a;
    private View b;
    private View c;
    private int e;
    private com.kascend.chushou.player.ui.h5.c.c nbV;
    private CommonH5Item nbd;
    private H5Positon nbe;
    private com.kascend.chushou.widget.cswebview.d nbg;

    public c(@NonNull Context context) {
        super(context);
        this.e = 2;
        this.a = context;
    }

    public void a(int i, H5Positon h5Positon, com.kascend.chushou.player.ui.h5.c.c cVar) {
        int i2;
        this.e = i;
        this.nbe = h5Positon;
        this.nbV = cVar;
        if (this.b == null) {
            c();
        }
        if (this.e == 2) {
            d();
        } else {
            e();
        }
        try {
            i2 = Color.parseColor(cVar.k);
        } catch (Exception e) {
            i2 = 0;
        }
        setBackgroundColor(i2);
        this.nbd.a(cVar);
    }

    private void c() {
        int i = a.h.layout_common_room_webview;
        if (this.e == 1) {
            i = a.h.layout_common_room_webview_landscape;
        }
        this.b = LayoutInflater.from(this.a).inflate(i, (ViewGroup) this, false);
        this.c = this.b.findViewById(a.f.view_redpacketlist_close);
        if (this.nbV.i == 0) {
            this.c.setVisibility(4);
        } else {
            this.c.setOnClickListener(this);
        }
        this.nbd = (CommonH5Item) this.b.findViewById(a.f.view_smallh5);
        this.nbd.setListener(new e() { // from class: com.kascend.chushou.player.ui.h5.c.1
            @Override // com.kascend.chushou.widget.cswebview.e, com.kascend.chushou.widget.cswebview.d
            public void a(Object obj) {
                c.this.a();
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
        Point he = tv.chushou.zues.utils.a.he(this.a);
        int statusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.a);
        int i = he.x;
        int i2 = he.y - statusBarHeight;
        View findViewById = this.b.findViewById(a.f.empty_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
        int i3 = (int) (((((100 - this.nbe.mHeight) * 1.0d) / 2.0d) / 100.0d) * i2);
        layoutParams2.height = i3;
        findViewById.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.nbd.getLayoutParams();
        layoutParams3.width = (int) (i * ((this.nbe.mWidth * 1.0d) / 100.0d));
        layoutParams3.height = (int) (((this.nbe.mHeight * 1.0d) / 100.0d) * i2);
        this.nbd.setLayoutParams(layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.c.getLayoutParams();
        layoutParams4.topMargin = (int) (i3 * 0.2d);
        this.c.setLayoutParams(layoutParams4);
    }

    private void e() {
        Point he = tv.chushou.zues.utils.a.he(this.a);
        int i = (int) (((this.nbe.mHeight * 1.0d) / 100.0d) * he.y);
        int i2 = (int) (((this.nbe.mAspectRadio * 1.0d) / 100.0d) * i);
        if (this.nbV.i == 0) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.b.getLayoutParams();
            layoutParams.width = i2;
            layoutParams.height = i;
            layoutParams.gravity = 17;
            this.b.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
        layoutParams2.topMargin = (int) (he.y * 0.05d);
        this.c.setLayoutParams(layoutParams2);
        int dip2px = tv.chushou.zues.utils.a.dip2px(this.a, 60.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.b.getLayoutParams();
        layoutParams3.width = dip2px + i2;
        layoutParams3.height = i;
        layoutParams3.gravity = 16;
        layoutParams3.leftMargin = (he.x - i2) / 2;
        this.b.setLayoutParams(layoutParams3);
    }

    public void a() {
        if (this.nbg != null) {
            this.nbg.a(this);
        }
    }

    public void setCloseH5Listener(com.kascend.chushou.widget.cswebview.d dVar) {
        this.nbg = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.f.view_redpacketlist_close) {
            a();
        }
    }

    public void b() {
        if (this.nbd != null) {
            tv.chushou.zues.toolkit.d.b.setScaleX(this.nbd, 0.0f);
            tv.chushou.zues.toolkit.d.b.setScaleY(this.nbd, 0.0f);
            this.nbd.animate().scaleX(1.0f).scaleY(1.0f).setDuration(300L).start();
        }
    }
}
