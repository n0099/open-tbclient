package com.kascend.chushou.player.ui.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kascend.chushou.a;
import com.kascend.chushou.constants.BangInfo;
import com.kascend.chushou.constants.IconConfig;
import com.kascend.chushou.constants.ListItem;
import com.kascend.chushou.d.e;
import com.kascend.chushou.player.ui.food.FoodView;
import com.kascend.chushou.widget.RoundProgressBar;
import com.kascend.chushou.widget.dispalymenu.EggacheDisplayView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import tv.chushou.zues.utils.h;
import tv.chushou.zues.widget.a.c;
import tv.chushou.zues.widget.fresco.FrescoThumbnailView;
import tv.chushou.zues.widget.fresco.b;
/* loaded from: classes6.dex */
public class EmbeddedButtonLayout extends LinearLayout implements View.OnClickListener {
    private Context b;
    private LinearLayout f;
    private TextView i;
    private int k;
    private long l;
    private Runnable m;
    private Runnable n;
    public ListItem nnr;
    private FrescoThumbnailView npn;
    private FrameLayout nyV;
    private EggacheDisplayView nyW;
    private RoundProgressBar nyX;
    private FrescoThumbnailView nyY;
    private FoodView nyZ;
    private IconConfig.Config nza;
    private FrescoThumbnailView nzb;
    private ImageView nzc;
    private RelativeLayout nzd;
    private boolean p;
    private boolean q;
    private int r;
    private int s;
    private int t;
    private List<View> x;
    private boolean y;

    public EmbeddedButtonLayout(Context context) {
        this(context, null, 0);
    }

    public EmbeddedButtonLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EmbeddedButtonLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.k = 0;
        this.l = 0L;
        this.nza = new IconConfig.Config();
        this.p = false;
        this.q = false;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.x = new ArrayList();
        this.y = false;
        this.b = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.EmbeddedButtonLayout);
        int color = obtainStyledAttributes.getColor(a.k.EmbeddedButtonLayout_roundBgColor, 0);
        int color2 = obtainStyledAttributes.getColor(a.k.EmbeddedButtonLayout_roundProcessColor, Color.parseColor("#e94681"));
        int resourceId = obtainStyledAttributes.getResourceId(a.k.EmbeddedButtonLayout_textBgColor, a.e.bg_pao_text);
        this.s = obtainStyledAttributes.getColor(a.k.EmbeddedButtonLayout_textcolor, Color.parseColor("#0091A7"));
        this.t = obtainStyledAttributes.getInteger(a.k.EmbeddedButtonLayout_showType, 0);
        obtainStyledAttributes.recycle();
        setOrientation(1);
        this.r = ContextCompat.getColor(this.b, a.c.kas_red_n);
        View inflate = LayoutInflater.from(context).inflate(a.h.view_embedded_button_layout, (ViewGroup) this, true);
        this.nyV = (FrameLayout) inflate.findViewById(a.f.fl_pao);
        this.npn = (FrescoThumbnailView) inflate.findViewById(a.f.gift_popup_gift);
        this.f = (LinearLayout) findViewById(a.f.btn_paopao);
        this.nyX = (RoundProgressBar) findViewById(a.f.progress_paopao);
        this.nyX.setRoundColor(color);
        this.nyX.setRoundProgressColor(color2);
        this.nyY = (FrescoThumbnailView) findViewById(a.f.iv_paoicon);
        this.nzb = (FrescoThumbnailView) findViewById(a.f.ic_shopwindow);
        this.nzc = (ImageView) findViewById(a.f.iv_shopwindow_close);
        this.nzd = (RelativeLayout) findViewById(a.f.rl_shopwindow);
        this.i = (TextView) findViewById(a.f.tv_paopao);
        this.i.setBackgroundResource(resourceId);
        this.f.setOnClickListener(this);
        this.npn.setOnClickListener(this);
        this.nyW = (EggacheDisplayView) inflate.findViewById(a.f.menu_display_layout);
        this.nyZ = (FoodView) inflate.findViewById(a.f.iv_ad);
        a();
        this.nzb.setOnClickListener(this);
        this.nzc.setOnClickListener(this);
    }

    private void a() {
        if (this.t == 0) {
            this.nyV.setBackgroundResource(a.e.bg_paoicon_p);
        } else {
            this.npn.setVisibility(8);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.f.removeCallbacks(this.m);
        this.nyY.removeCallbacks(this.n);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.btn_paopao) {
            tv.chushou.zues.a.a.post(new b(1, null));
        } else if (id == a.f.gift_popup_gift) {
            tv.chushou.zues.a.a.post(new b(8, null));
        } else if (id == a.f.ic_shopwindow) {
            if (this.nnr != null) {
                e.a(this.b, this.nnr, (JSONObject) null);
            }
        } else if (id == a.f.iv_shopwindow_close && this.nzd != null) {
            this.nzd.setVisibility(8);
        }
    }

    public void a(ListItem listItem) {
        if (this.t != 1 && this.npn != null && listItem != null && !h.isEmpty(listItem.mPackIcon)) {
            this.npn.setVisibility(0);
            this.npn.setAnim(true);
            this.npn.a(listItem.mPackIcon, a.e.default_color_bg, tv.chushou.zues.widget.fresco.b.ouE, b.C0959b.ouG, 0);
        }
    }

    public void a(IconConfig.Config config) {
        if (config != null) {
            this.nza = config;
            if (!this.nza.display) {
                this.f.setVisibility(8);
            }
            b();
        }
    }

    public void a(List<ListItem> list) {
        if (this.nzb != null && !h.isEmpty(list) && this.t != 1) {
            this.nnr = list.get(0);
            this.nzb.setVisibility(0);
            this.nzb.a(this.nnr.mCover, 0, 0, 0, 1);
            if (this.nzc != null) {
                if (this.nnr.mShowClose) {
                    this.nzc.setVisibility(0);
                } else {
                    this.nzc.setVisibility(8);
                }
            }
        }
    }

    public void a(BangInfo bangInfo, String str) {
        if (bangInfo != null) {
            if (!this.nza.display) {
                this.f.setVisibility(8);
                b();
                return;
            }
            this.nyW.setVisibility(0);
            this.f.setVisibility(0);
            this.nyY.bS(str, a.e.pao_circle_default);
            int i = (int) ((((float) bangInfo.mCurPoint) / ((float) bangInfo.mEndPoint)) * 100.0f);
            this.nyX.setProgress(i);
            if (!this.q) {
                long j = bangInfo.mEndPoint - bangInfo.mCurPoint;
                c cVar = new c();
                if (j <= 0) {
                    cVar.a(this.b.getString(a.i.pao_full), new ForegroundColorSpan(this.s));
                } else if (j < 99999) {
                    cVar.a(this.b.getString(a.i.pao_leave, String.valueOf(j)), new ForegroundColorSpan(this.s));
                } else {
                    cVar.a(this.b.getString(a.i.pao_leave, tv.chushou.zues.utils.b.formatNumber(String.valueOf(j))), new ForegroundColorSpan(this.s));
                }
                this.i.setText(cVar);
            }
            if (this.m == null) {
                this.m = new Runnable() { // from class: com.kascend.chushou.player.ui.button.EmbeddedButtonLayout.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ViewCompat.isAttachedToWindow(EmbeddedButtonLayout.this)) {
                            EmbeddedButtonLayout.this.p = true;
                            EmbeddedButtonLayout.this.c();
                        }
                    }
                };
            }
            this.f.removeCallbacks(this.m);
            this.f.postDelayed(this.m, 400L);
            if (this.l != i) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.b, a.C0824a.pao_beat_anim);
                loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.kascend.chushou.player.ui.button.EmbeddedButtonLayout.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                        if (EmbeddedButtonLayout.this.nyW != null) {
                            EmbeddedButtonLayout.this.nyW.e();
                        }
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        if (EmbeddedButtonLayout.this.nyW != null) {
                            EmbeddedButtonLayout.this.nyW.c();
                        }
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.nyY.startAnimation(loadAnimation);
                this.l = i;
            }
            if (this.k != bangInfo.mLevel) {
                if (this.n == null) {
                    this.n = new Runnable() { // from class: com.kascend.chushou.player.ui.button.EmbeddedButtonLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (ViewCompat.isAttachedToWindow(EmbeddedButtonLayout.this) && EmbeddedButtonLayout.this.nyY != null) {
                                EmbeddedButtonLayout.this.nyY.clearAnimation();
                                com.kascend.chushou.widget.b.a aVar = new com.kascend.chushou.widget.b.a(0.0f, -360.0f, 0.0f, 0.0f, EmbeddedButtonLayout.this.nyY.getWidth() / 2, EmbeddedButtonLayout.this.nyY.getHeight() / 2);
                                aVar.setDuration(1000L);
                                EmbeddedButtonLayout.this.nyY.startAnimation(aVar);
                            }
                        }
                    };
                }
                this.nyY.removeCallbacks(this.n);
                this.nyY.postDelayed(this.n, 500L);
                this.k = bangInfo.mLevel;
            }
        }
    }

    public void a(long j, BangInfo bangInfo, String str) {
        if (this.nza.display && this.f != null) {
            if (j > 0) {
                this.nyW.setVisibility(0);
                this.f.setVisibility(0);
                this.q = true;
                c cVar = new c();
                cVar.a(this.b.getString(a.i.auto_bang_count_down, Long.valueOf(j)), new ForegroundColorSpan(this.s));
                this.i.setText(cVar);
                return;
            }
            this.q = false;
            a(bangInfo, str);
        }
    }

    private void b() {
        if (this.f != null) {
            this.p = true;
            this.f.removeCallbacks(this.m);
            this.nyY.clearAnimation();
            this.nyY.removeCallbacks(this.n);
            c();
        }
    }

    public void b(List<ListItem> list) {
        if (this.nyW != null) {
            this.x.clear();
            this.y = true;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    com.kascend.chushou.player.ui.giftpopup.b bVar = new com.kascend.chushou.player.ui.giftpopup.b(getContext());
                    bVar.a(3, list, list.get(i2));
                    this.x.add(bVar);
                    i = i2 + 1;
                } else {
                    c();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.p && this.nyW != null && this.y) {
            this.y = false;
            if (!this.nza.display && h.isEmpty(this.x)) {
                this.nyW.setVisibility(8);
                return;
            }
            this.nyW.setVisibility(0);
            this.nyW.a(this.x, 1);
            this.nyW.postDelayed(new Runnable() { // from class: com.kascend.chushou.player.ui.button.EmbeddedButtonLayout.4
                @Override // java.lang.Runnable
                public void run() {
                    EmbeddedButtonLayout.this.nyW.b();
                }
            }, 3000L);
        }
    }

    public void a(@DrawableRes int i, @DrawableRes int i2) {
        if (this.nyW != null) {
            this.nyW.setDownRes(i);
            this.nyW.setUpRes(i2);
        }
    }

    public void a(ListItem listItem, FoodView.a aVar) {
        if (this.nyZ != null && listItem != null && this.t != 1) {
            this.nyZ.a(listItem, 0, aVar);
        }
    }
}
