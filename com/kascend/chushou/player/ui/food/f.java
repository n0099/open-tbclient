package com.kascend.chushou.player.ui.food;

import android.annotation.SuppressLint;
import android.graphics.Point;
import android.os.Build;
import android.support.annotation.IdRes;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.tbadk.pay.PayHelper;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.kascend.chushou.a;
import com.kascend.chushou.constants.ListItem;
import com.kascend.chushou.player.ui.food.k;
import com.kascend.chushou.widget.ItemTagView;
import tv.chushou.zues.widget.fresco.FrescoThumbnailView;
/* loaded from: classes6.dex */
public class f extends k {
    protected ImageView a;
    protected TextView b;
    protected TextView c;
    protected LinearLayout e;
    protected ImageView i;
    protected FrameLayout j;
    protected FrescoThumbnailView npn;
    protected FrescoThumbnailView nvR;
    protected FrescoThumbnailView nzD;
    protected ItemTagView nzE;
    protected FrescoThumbnailView nzF;

    @Override // com.kascend.chushou.player.ui.food.k
    int a() {
        return a.h.view_normal_style;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.kascend.chushou.player.ui.food.k
    @SuppressLint({"ClickableViewAccessibility"})
    public void f(FoodView foodView) {
        super.f(foodView);
        this.j = (FrameLayout) KG(a.f.fl_holder);
        this.a = (ImageView) KG(a.f.iv_ad_close_top);
        this.b = (TextView) KG(a.f.tv_ad_name);
        this.c = (TextView) KG(a.f.tv_ad_desc);
        this.npn = (FrescoThumbnailView) KG(a.f.iv_cover_ad_small);
        this.e = (LinearLayout) KG(a.f.ll_ad_small);
        this.a.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.ui.food.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.nzR.c();
            }
        });
        this.e.setOnTouchListener(new View.OnTouchListener() { // from class: com.kascend.chushou.player.ui.food.f.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getActionMasked() == 0) {
                    f.this.m = (int) motionEvent.getX();
                    f.this.n = (int) motionEvent.getY();
                    f.this.o = AdCard.INVALID_NUM;
                    f.this.p = AdCard.INVALID_NUM;
                    return false;
                } else if (motionEvent.getActionMasked() == 1) {
                    f.this.o = (int) motionEvent.getX();
                    f.this.p = (int) motionEvent.getY();
                    return false;
                } else {
                    return false;
                }
            }
        });
        this.nvR = (FrescoThumbnailView) KG(a.f.iv_cover_ad);
        this.nzD = (FrescoThumbnailView) KG(a.f.iv_cover_ad_wangmai);
        this.nzF = (FrescoThumbnailView) KG(a.f.iv_frame_border);
        this.nzE = (ItemTagView) KG(a.f.iv_icon);
        int dip2px = tv.chushou.zues.utils.a.dip2px(this.q, 2.0f);
        this.nzE.a(dip2px, dip2px, dip2px, dip2px);
        this.i = (ImageView) KG(a.f.iv_ad_close);
        this.i.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.ui.food.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.nzR.c();
            }
        });
        this.nvR.setOnTouchListener(new View.OnTouchListener() { // from class: com.kascend.chushou.player.ui.food.f.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getActionMasked() == 0) {
                    f.this.m = (int) motionEvent.getX();
                    f.this.n = (int) motionEvent.getY();
                    f.this.o = AdCard.INVALID_NUM;
                    f.this.p = AdCard.INVALID_NUM;
                    return false;
                } else if (motionEvent.getActionMasked() == 1) {
                    f.this.o = (int) motionEvent.getX();
                    f.this.p = (int) motionEvent.getY();
                    return false;
                } else {
                    return false;
                }
            }
        });
        this.nzD.setOnTouchListener(new View.OnTouchListener() { // from class: com.kascend.chushou.player.ui.food.f.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getActionMasked() == 0) {
                    f.this.m = (int) motionEvent.getX();
                    f.this.n = (int) motionEvent.getY();
                    f.this.o = AdCard.INVALID_NUM;
                    f.this.p = AdCard.INVALID_NUM;
                    return false;
                } else if (motionEvent.getActionMasked() == 1) {
                    f.this.o = (int) motionEvent.getX();
                    f.this.p = (int) motionEvent.getY();
                    return false;
                } else {
                    return false;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.kascend.chushou.player.ui.food.k
    public void a(ListItem listItem, k.a aVar) {
        a(listItem, this.j);
        if ("32".equals(listItem.mDisplayStyle)) {
            Point gE = tv.chushou.zues.utils.a.gE(this.nzR.getContext());
            int i = gE.x;
            ViewGroup.LayoutParams layoutParams = this.nzR.getLayoutParams();
            layoutParams.height = i / 5;
            layoutParams.width = i;
            this.nzR.setLayoutParams(layoutParams);
            if (this.nzF != null) {
                this.nzF.setVisibility(8);
            }
            if (b()) {
                this.e.setVisibility(8);
                this.nvR.setVisibility(8);
                this.j.setVisibility(0);
                return;
            }
            this.j.setVisibility(8);
            this.nvR.setVisibility(0);
            this.e.setVisibility(0);
            this.e.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.ui.food.f.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.nzR.b(f.this.m, f.this.n, f.this.o, f.this.p);
                }
            });
            com.kascend.chushou.a.a.dMi().b(listItem, this.npn, gE.x / 5, ((gE.x / 5) * 360) / 144, ((gE.x / 5) * 144) / 144);
            return;
        }
        Point gE2 = tv.chushou.zues.utils.a.gE(this.nzR.getContext());
        int min = Math.min(gE2.x, gE2.y);
        int i2 = min / 5;
        if (com.kascend.chushou.a.a.dMi().a(listItem, this.nzR, min, (min * 144) / 720, (min * 77) / 720) == 0) {
            ViewGroup.LayoutParams layoutParams2 = this.nzR.getLayoutParams();
            layoutParams2.width = min;
            layoutParams2.height = i2;
            this.nzR.setLayoutParams(layoutParams2);
        }
        if (b()) {
            this.j.setVisibility(0);
            this.nvR.setVisibility(8);
            this.nzD.setVisibility(8);
            this.e.setVisibility(8);
            c();
            if (this.nzF != null) {
                this.nzF.setVisibility(8);
                return;
            }
            return;
        }
        this.j.setVisibility(8);
        this.nvR.setVisibility(0);
        this.e.setVisibility(8);
        this.nvR.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.ui.food.f.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.nzR.b(f.this.m, f.this.n, f.this.o, f.this.p);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.kascend.chushou.player.ui.food.k
    public void a(ListItem listItem, boolean z) {
        a(listItem, z, false);
    }

    @Override // com.kascend.chushou.player.ui.food.k
    public void a(ListItem listItem, boolean z, boolean z2) {
        if (b()) {
            if (dOi() != null) {
                dOi().loadUrl(listItem.mCover);
                a(listItem, a.f.fl_holder);
            }
        } else if (z2) {
            this.nvR.zR(tv.chushou.widget.a.c.dZV());
            return;
        } else {
            this.nvR.setBlur(false);
            if (!PayHelper.STATUS_SUCC.equals(listItem.mType) || listItem.mAdExtraInfo == null || com.kascend.chushou.a.a.y != tv.chushou.zues.utils.h.parseInt(listItem.mAdExtraInfo.mMarketId) || tv.chushou.zues.utils.h.isEmpty(listItem.mAdExtraInfo.marketPositionCode)) {
                ((ViewGroup) KG(a.f.rl_wangmai)).setVisibility(8);
                this.nvR.setAnim(true);
                this.nvR.i(listItem.mCover, tv.chushou.widget.a.c.dZV(), 0, 0);
                this.nzD.setVisibility(8);
                if (this.nzF != null) {
                    if (tv.chushou.zues.utils.h.isEmpty(listItem.borderImage)) {
                        this.nzF.setVisibility(8);
                    } else {
                        this.nzF.setVisibility(0);
                        this.nzF.i(listItem.borderImage, a.c.transparent, -1, -1);
                    }
                }
                if (this.e.getVisibility() == 0) {
                    this.b.setText(listItem.mName);
                    this.c.setText(listItem.mDesc);
                    this.npn.i(listItem.mCover, tv.chushou.widget.a.c.dZV(), 0, 0);
                }
            }
            a(listItem, a.f.iv_cover_ad);
        }
        if (z) {
            this.a.setVisibility(listItem.mShowClose ? 0 : 8);
            this.i.setVisibility(8);
            return;
        }
        this.i.setVisibility(listItem.mShowClose ? 0 : 8);
        this.a.setVisibility(8);
    }

    private void a(ListItem listItem, @IdRes int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nzE.getLayoutParams();
        if (listItem.mAdExtraInfo != null) {
            int dip2px = tv.chushou.zues.utils.a.dip2px(this.q, 2.0f);
            this.nzE.a(dip2px, dip2px, dip2px, dip2px);
            switch (listItem.mAdExtraInfo.mDisplayTagLocation) {
                case 1:
                    if (Build.VERSION.SDK_INT >= 17) {
                        layoutParams.removeRule(7);
                        layoutParams.removeRule(10);
                        layoutParams.removeRule(8);
                        layoutParams.removeRule(9);
                    }
                    layoutParams.addRule(9);
                    layoutParams.addRule(10);
                    layoutParams.setMargins(tv.chushou.zues.utils.a.dip2px(this.q, 8.0f), tv.chushou.zues.utils.a.dip2px(this.q, 8.0f), 0, 0);
                    break;
                case 2:
                    if (Build.VERSION.SDK_INT >= 17) {
                        layoutParams.removeRule(7);
                        layoutParams.removeRule(10);
                        layoutParams.removeRule(8);
                        layoutParams.removeRule(9);
                    }
                    layoutParams.addRule(7, i);
                    layoutParams.addRule(10);
                    layoutParams.setMargins(0, tv.chushou.zues.utils.a.dip2px(this.q, 8.0f), tv.chushou.zues.utils.a.dip2px(this.q, 30.0f), 0);
                    break;
                case 3:
                    if (Build.VERSION.SDK_INT >= 17) {
                        layoutParams.removeRule(7);
                        layoutParams.removeRule(10);
                        layoutParams.removeRule(8);
                        layoutParams.removeRule(9);
                    }
                    layoutParams.addRule(7, i);
                    layoutParams.addRule(8, i);
                    layoutParams.setMargins(0, 0, tv.chushou.zues.utils.a.dip2px(this.q, 30.0f), 0);
                    break;
                case 4:
                    if (Build.VERSION.SDK_INT >= 17) {
                        layoutParams.removeRule(7);
                        layoutParams.removeRule(10);
                        layoutParams.removeRule(8);
                        layoutParams.removeRule(9);
                    }
                    layoutParams.addRule(9);
                    layoutParams.addRule(8, i);
                    layoutParams.setMargins(tv.chushou.zues.utils.a.dip2px(this.q, 8.0f), 0, 0, tv.chushou.zues.utils.a.dip2px(this.q, 15.0f));
                    break;
            }
        } else {
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(7);
                layoutParams.removeRule(10);
                layoutParams.removeRule(8);
                layoutParams.removeRule(9);
            }
            layoutParams.addRule(9);
            layoutParams.addRule(10);
            layoutParams.setMargins(tv.chushou.zues.utils.a.dip2px(this.q, 8.0f), tv.chushou.zues.utils.a.dip2px(this.q, 8.0f), 0, 0);
            int dip2px2 = tv.chushou.zues.utils.a.dip2px(this.q, 2.0f);
            this.nzE.a(dip2px2, dip2px2, dip2px2, dip2px2);
        }
        this.nzE.setLayoutParams(layoutParams);
        this.nzE.a(listItem);
    }
}
