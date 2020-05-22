package com.kascend.chushou.player.ui.h5.b;

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
import com.kascend.chushou.player.ui.h5.redpacket.RedpacketItem;
import com.kascend.chushou.widget.cswebview.d;
import java.util.List;
import tv.chushou.zues.utils.g;
/* loaded from: classes5.dex */
public class a extends FrameLayout implements View.OnClickListener {
    private Context a;
    private View b;
    private View c;
    private FrameLayout d;
    private FrameLayout e;
    private TextView f;
    private Animation j;
    private RedpacketItem mUN;
    private RedpacketItem mUO;
    private RedpacketItem mUP;
    private Animation mUQ;
    private Animation mUR;
    private Animation mUS;
    private H5Positon mUT;
    private b mUU;
    private com.kascend.chushou.player.ui.h5.c.c mUV;
    private d mUW;
    private boolean n;
    private int o;
    private List<com.kascend.chushou.player.ui.h5.c.c> r;
    private int t;

    static /* synthetic */ int a(a aVar) {
        int i = aVar.t;
        aVar.t = i - 1;
        return i;
    }

    static /* synthetic */ int g(a aVar) {
        int i = aVar.t;
        aVar.t = i + 1;
        return i;
    }

    public a(@NonNull Context context) {
        super(context);
        this.n = false;
        this.o = 2;
        this.t = 0;
        a(context);
    }

    private void a(Context context) {
        this.a = context;
        this.mUR = AnimationUtils.loadAnimation(this.a, a.C0794a.slide_in_right_anim);
        this.mUS = AnimationUtils.loadAnimation(this.a, a.C0794a.slide_out_right_anim);
        this.j = AnimationUtils.loadAnimation(this.a, a.C0794a.slide_in_left_anim);
        this.mUQ = AnimationUtils.loadAnimation(this.a, a.C0794a.slide_out_left_anim);
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
            b();
        }
    }

    public void a(int i, H5Positon h5Positon, b bVar) {
        this.o = i;
        this.mUT = h5Positon;
        this.mUU = bVar;
        this.r = bVar.d();
        if (this.b == null) {
            c();
        }
        if (this.o == 2) {
            g();
        } else {
            h();
        }
        this.t = 0;
        this.mUV = this.r.get(this.t);
        this.mUP = this.mUN;
        this.mUP.setVisibility(0);
        getNext().setVisibility(8);
        this.mUP.a(this.mUV);
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
        this.mUN = (RedpacketItem) this.b.findViewById(a.f.redpacket_item_first);
        this.mUO = (RedpacketItem) this.b.findViewById(a.f.redpacket_item_second);
        d dVar = new d() { // from class: com.kascend.chushou.player.ui.h5.b.a.1
            @Override // com.kascend.chushou.widget.cswebview.d
            public void a(Object obj) {
                a.this.b();
            }

            @Override // com.kascend.chushou.widget.cswebview.d
            public void a(String str) {
            }
        };
        this.mUN.setListener(dVar);
        this.mUO.setListener(dVar);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        addView(this.b, layoutParams);
    }

    public void a() {
        if (ViewCompat.isAttachedToWindow(this)) {
            int indexOf = this.r.indexOf(this.mUV);
            if (indexOf != -1) {
                this.t = indexOf;
            }
            f();
        }
    }

    public void b() {
        if (this.mUW != null) {
            this.mUW.a(this);
        }
    }

    public void setCloseH5Listener(d dVar) {
        this.mUW = dVar;
    }

    private void d() {
        if (this.t == 0) {
            g.F(this.a, a.i.red_packet_previous);
        } else if (!this.n) {
            this.n = true;
            final RedpacketItem redpacketItem = this.mUP;
            this.mUS.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.h5.b.a.2
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    redpacketItem.a();
                    redpacketItem.setVisibility(8);
                }
            });
            redpacketItem.startAnimation(this.mUS);
            this.mUP = getNext();
            this.mUP.setVisibility(0);
            this.j.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.h5.b.a.3
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    a.a(a.this);
                    if (a.this.t <= 0) {
                        a.this.t = 0;
                    }
                    a.this.mUV = (com.kascend.chushou.player.ui.h5.c.c) a.this.r.get(a.this.t);
                    a.this.mUP.a(a.this.mUV);
                    a.this.f();
                    a.this.n = false;
                }
            });
            this.mUP.startAnimation(this.j);
        }
    }

    private void e() {
        if (this.t >= this.r.size() - 1) {
            g.F(this.a, a.i.red_packet_next);
        } else if (!this.n) {
            this.n = true;
            final RedpacketItem redpacketItem = this.mUP;
            this.mUQ.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.h5.b.a.4
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    redpacketItem.a();
                    redpacketItem.setVisibility(8);
                }
            });
            redpacketItem.startAnimation(this.mUQ);
            this.mUP = getNext();
            this.mUP.setVisibility(0);
            this.mUR.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.h5.b.a.5
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    a.g(a.this);
                    if (a.this.t >= a.this.r.size() - 1) {
                        a.this.t = a.this.r.size() - 1;
                    }
                    a.this.mUV = (com.kascend.chushou.player.ui.h5.c.c) a.this.r.get(a.this.t);
                    a.this.mUP.a(a.this.mUV);
                    a.this.f();
                    a.this.n = false;
                }
            });
            this.mUP.startAnimation(this.mUR);
        }
    }

    private RedpacketItem getNext() {
        return this.mUP == this.mUN ? this.mUO : this.mUN;
    }

    private int getFragmentContainerId() {
        return this.mUP == this.mUN ? a.f.redpacket_item_first : a.f.redpacket_item_second;
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
        Point gv = tv.chushou.zues.utils.a.gv(this.a);
        int statusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.a);
        int i = gv.x;
        int i2 = gv.y - statusBarHeight;
        View findViewById = this.b.findViewById(a.f.fl_top);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
        int i3 = (int) (((((100 - this.mUT.mHeight) * 1.0d) / 2.0d) / 100.0d) * i2);
        layoutParams2.height = i3;
        findViewById.setLayoutParams(layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.f.getLayoutParams();
        layoutParams3.bottomMargin = (int) (i3 * 0.2d);
        this.f.setLayoutParams(layoutParams3);
        LinearLayout linearLayout = (LinearLayout) this.b.findViewById(a.f.view_middle);
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        layoutParams4.height = (int) (((this.mUT.mHeight * 1.0d) / 100.0d) * i2);
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
        layoutParams7.weight = (100 - this.mUT.mWidth) / 2;
        frameLayout.setLayoutParams(layoutParams7);
        View findViewById3 = this.b.findViewById(a.f.redpacket_viewswitcher);
        LinearLayout.LayoutParams layoutParams8 = (LinearLayout.LayoutParams) findViewById3.getLayoutParams();
        layoutParams8.weight = this.mUT.mWidth;
        findViewById3.setLayoutParams(layoutParams8);
        FrameLayout frameLayout2 = this.e;
        LinearLayout.LayoutParams layoutParams9 = (LinearLayout.LayoutParams) frameLayout2.getLayoutParams();
        layoutParams9.weight = (100 - this.mUT.mWidth) / 2;
        frameLayout2.setLayoutParams(layoutParams9);
    }

    private void h() {
        Point gv = tv.chushou.zues.utils.a.gv(this.a);
        int i = (int) (((this.mUT.mHeight * 1.0d) / 100.0d) * gv.y);
        int dip2px = tv.chushou.zues.utils.a.dip2px(this.a, 120.0f) + ((int) (((this.mUT.mAspectRadio * 1.0d) / 100.0d) * i));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.b.getLayoutParams();
        layoutParams.width = dip2px;
        layoutParams.height = i;
        this.b.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
        layoutParams2.topMargin = (int) (gv.y * 0.05d);
        this.c.setLayoutParams(layoutParams2);
    }
}
