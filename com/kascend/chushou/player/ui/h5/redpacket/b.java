package com.kascend.chushou.player.ui.h5.redpacket;

import android.content.Context;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kascend.chushou.a;
import com.kascend.chushou.constants.H5Positon;
import com.kascend.chushou.d.h;
import com.kascend.chushou.player.ui.h5.c.e;
import com.kascend.chushou.toolkit.LoginManager;
import com.kascend.chushou.widget.cswebview.d;
import java.util.List;
import tv.chushou.zues.utils.g;
import tv.chushou.zues.widget.sweetalert.b;
/* loaded from: classes5.dex */
public class b extends FrameLayout implements View.OnClickListener {
    private Context a;
    private View b;
    private View c;
    private FrameLayout d;
    private FrameLayout e;
    private TextView f;
    private Animation j;
    private boolean n;
    private RedpacketItem nrR;
    private RedpacketItem nrS;
    private RedpacketItem nrT;
    private Animation nrU;
    private Animation nrV;
    private Animation nrW;
    private H5Positon nrX;
    private d nsa;
    private a nsx;
    private e nsy;
    private int o;
    private List<e> r;
    private int t;

    static /* synthetic */ int a(b bVar) {
        int i = bVar.t;
        bVar.t = i - 1;
        return i;
    }

    static /* synthetic */ int h(b bVar) {
        int i = bVar.t;
        bVar.t = i + 1;
        return i;
    }

    public b(@NonNull Context context) {
        super(context);
        this.n = false;
        this.o = 2;
        this.t = 0;
        a(context);
    }

    private void a(Context context) {
        this.a = context;
        this.nrV = AnimationUtils.loadAnimation(this.a, a.C0815a.slide_in_right_anim);
        this.nrW = AnimationUtils.loadAnimation(this.a, a.C0815a.slide_out_right_anim);
        this.j = AnimationUtils.loadAnimation(this.a, a.C0815a.slide_in_left_anim);
        this.nrU = AnimationUtils.loadAnimation(this.a, a.C0815a.slide_out_left_anim);
        setBackgroundColor(ContextCompat.getColor(this.a, a.c.transparent_60_black));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.btn_previous_image || id == a.f.btn_previous) {
            d();
        } else if (id == a.f.btn_next_image || id == a.f.btn_next) {
            e();
        } else if (id == a.f.view_redpacketlist_close) {
            if (!LoginManager.Instance().islogined()) {
                b();
            } else if (!h.dIT().r()) {
                b();
            } else {
                h.dIT().h(false);
                new tv.chushou.zues.widget.sweetalert.b(this.a, 0).a(new b.a() { // from class: com.kascend.chushou.player.ui.h5.redpacket.b.2
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar) {
                        bVar.dismiss();
                        h.dIT().g(false);
                        b.this.b();
                    }
                }).b(new b.a() { // from class: com.kascend.chushou.player.ui.h5.redpacket.b.1
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar) {
                        bVar.dismiss();
                        b.this.b();
                    }
                }).bh(this.a.getString(a.i.auto_popup_redpacket_title), true).B(this.a.getResources().getString(a.i.auto_popup_redpacket_content)).Tq(this.a.getResources().getString(a.i.auto_popup_redpacket_cancal)).Ts(this.a.getResources().getString(a.i.auto_popup_redpacket_confirm)).show();
            }
        }
    }

    public void a(int i, H5Positon h5Positon, a aVar) {
        this.o = i;
        this.nrX = h5Positon;
        this.nsx = aVar;
        this.r = aVar.a();
        if (this.b == null) {
            c();
        }
        if (this.o == 2) {
            g();
        } else {
            h();
        }
        this.t = 0;
        this.nsy = this.r.get(this.t);
        this.nrT = this.nrR;
        this.nrT.setVisibility(0);
        getNext().setVisibility(8);
        this.nrT.a(this.nsy, this.nsx);
        f();
    }

    private void c() {
        int i = a.h.dialog_videoplayer_redpacket_list;
        if (this.o == 1) {
            i = a.h.dialog_videoplayer_redpacket_list_landscape;
        }
        this.b = LayoutInflater.from(this.a).inflate(i, (ViewGroup) this, false);
        this.d = (FrameLayout) this.b.findViewById(a.f.btn_previous);
        this.d.setOnClickListener(this);
        this.b.findViewById(a.f.btn_previous_image).setOnClickListener(this);
        this.e = (FrameLayout) this.b.findViewById(a.f.btn_next);
        this.e.setOnClickListener(this);
        this.b.findViewById(a.f.btn_next_image).setOnClickListener(this);
        this.f = (TextView) this.b.findViewById(a.f.tv_redpacket_count);
        this.c = this.b.findViewById(a.f.view_redpacketlist_close);
        this.c.setOnClickListener(this);
        FrameLayout frameLayout = (FrameLayout) this.b.findViewById(a.f.redpacket_viewswitcher);
        this.nrR = (RedpacketItem) this.b.findViewById(a.f.redpacket_item_first);
        this.nrS = (RedpacketItem) this.b.findViewById(a.f.redpacket_item_second);
        d dVar = new d() { // from class: com.kascend.chushou.player.ui.h5.redpacket.b.3
            @Override // com.kascend.chushou.widget.cswebview.d
            public void a(Object obj) {
                b.this.b();
            }

            @Override // com.kascend.chushou.widget.cswebview.d
            public void a(String str) {
            }
        };
        this.nrR.setListener(dVar);
        this.nrS.setListener(dVar);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        addView(this.b, layoutParams);
    }

    public void a() {
        if (ViewCompat.isAttachedToWindow(this)) {
            int indexOf = this.r.indexOf(this.nsy);
            if (indexOf != -1) {
                this.t = indexOf;
            }
            f();
        }
    }

    public void b() {
        if (this.nsa != null) {
            this.nsa.a(this);
        }
    }

    public void setCloseH5Listener(d dVar) {
        this.nsa = dVar;
    }

    private void d() {
        if (this.t == 0) {
            g.F(this.a, a.i.red_packet_previous);
        } else if (!this.n) {
            this.n = true;
            final RedpacketItem redpacketItem = this.nrT;
            this.nrW.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.h5.redpacket.b.4
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    redpacketItem.a();
                    redpacketItem.setVisibility(8);
                }
            });
            redpacketItem.startAnimation(this.nrW);
            this.nrT = getNext();
            this.nrT.setVisibility(0);
            this.j.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.h5.redpacket.b.5
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    b.a(b.this);
                    if (b.this.t <= 0) {
                        b.this.t = 0;
                    }
                    b.this.nsy = (e) b.this.r.get(b.this.t);
                    b.this.nrT.a(b.this.nsy, b.this.nsx);
                    b.this.f();
                    b.this.n = false;
                }
            });
            this.nrT.startAnimation(this.j);
        }
    }

    private void e() {
        if (this.t >= this.r.size() - 1) {
            g.F(this.a, a.i.red_packet_next);
        } else if (!this.n) {
            this.n = true;
            final RedpacketItem redpacketItem = this.nrT;
            this.nrU.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.h5.redpacket.b.6
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    redpacketItem.a();
                    redpacketItem.setVisibility(8);
                }
            });
            redpacketItem.startAnimation(this.nrU);
            this.nrT = getNext();
            this.nrT.setVisibility(0);
            this.nrV.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.h5.redpacket.b.7
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    b.h(b.this);
                    if (b.this.t >= b.this.r.size() - 1) {
                        b.this.t = b.this.r.size() - 1;
                    }
                    b.this.nsy = (e) b.this.r.get(b.this.t);
                    b.this.nrT.a(b.this.nsy, b.this.nsx);
                    b.this.f();
                    b.this.n = false;
                }
            });
            this.nrT.startAnimation(this.nrV);
        }
    }

    private RedpacketItem getNext() {
        return this.nrT == this.nrR ? this.nrS : this.nrR;
    }

    private int getFragmentContainerId() {
        return this.nrT == this.nrR ? a.f.redpacket_item_first : a.f.redpacket_item_second;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        int size = this.r.size();
        if (size == 0) {
            b();
        } else if (size == 1) {
            this.d.setVisibility(4);
            this.e.setVisibility(4);
            this.f.setVisibility(4);
        } else {
            this.d.setVisibility(0);
            this.e.setVisibility(0);
            this.f.setVisibility(0);
            this.f.setText(this.a.getString(a.i.red_packet_count, Integer.valueOf(this.t + 1), Integer.valueOf(this.r.size())));
            if (this.t == 0) {
                tv.chushou.zues.utils.a.f(this.d, false);
            } else {
                tv.chushou.zues.utils.a.f(this.d, true);
            }
            if (this.t == size - 1) {
                tv.chushou.zues.utils.a.f(this.e, false);
            } else {
                tv.chushou.zues.utils.a.f(this.e, true);
            }
        }
    }

    private void g() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.b.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.b.setLayoutParams(layoutParams);
        Point gw = tv.chushou.zues.utils.a.gw(this.a);
        int statusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.a);
        int i = gw.x;
        int i2 = gw.y - statusBarHeight;
        View findViewById = this.b.findViewById(a.f.fl_top);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
        int i3 = (int) (((((100 - this.nrX.mHeight) * 1.0d) / 2.0d) / 100.0d) * i2);
        layoutParams2.height = i3;
        findViewById.setLayoutParams(layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.f.getLayoutParams();
        layoutParams3.bottomMargin = (int) (i3 * 0.2d);
        this.f.setLayoutParams(layoutParams3);
        LinearLayout linearLayout = (LinearLayout) this.b.findViewById(a.f.view_middle);
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        layoutParams4.height = (int) (((this.nrX.mHeight * 1.0d) / 100.0d) * i2);
        linearLayout.setLayoutParams(layoutParams4);
        View findViewById2 = this.b.findViewById(a.f.fl_bottom);
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) findViewById2.getLayoutParams();
        layoutParams5.height = i3;
        findViewById2.setLayoutParams(layoutParams5);
        FrameLayout.LayoutParams layoutParams6 = (FrameLayout.LayoutParams) this.c.getLayoutParams();
        layoutParams6.topMargin = (int) (i3 * 0.2d);
        this.c.setLayoutParams(layoutParams6);
        linearLayout.setWeightSum(100.0f);
        FrameLayout frameLayout = this.d;
        LinearLayout.LayoutParams layoutParams7 = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
        layoutParams7.weight = (100 - this.nrX.mWidth) / 2;
        frameLayout.setLayoutParams(layoutParams7);
        View findViewById3 = this.b.findViewById(a.f.redpacket_viewswitcher);
        LinearLayout.LayoutParams layoutParams8 = (LinearLayout.LayoutParams) findViewById3.getLayoutParams();
        layoutParams8.weight = this.nrX.mWidth;
        findViewById3.setLayoutParams(layoutParams8);
        FrameLayout frameLayout2 = this.e;
        LinearLayout.LayoutParams layoutParams9 = (LinearLayout.LayoutParams) frameLayout2.getLayoutParams();
        layoutParams9.weight = (100 - this.nrX.mWidth) / 2;
        frameLayout2.setLayoutParams(layoutParams9);
    }

    private void h() {
        Point gw = tv.chushou.zues.utils.a.gw(this.a);
        int i = (int) (((this.nrX.mHeight * 1.0d) / 100.0d) * gw.y);
        int dip2px = tv.chushou.zues.utils.a.dip2px(this.a, 120.0f) + ((int) (((this.nrX.mAspectRadio * 1.0d) / 100.0d) * i));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.b.getLayoutParams();
        layoutParams.width = dip2px;
        layoutParams.height = i;
        this.b.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
        layoutParams2.topMargin = (int) (gw.y * 0.05d);
        this.c.setLayoutParams(layoutParams2);
    }
}
