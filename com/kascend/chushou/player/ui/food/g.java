package com.kascend.chushou.player.ui.food;

import android.annotation.SuppressLint;
import android.os.Build;
import android.support.annotation.IdRes;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.live.tbadk.pay.PayHelper;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.kascend.chushou.a;
import com.kascend.chushou.constants.ListItem;
import com.kascend.chushou.player.ui.food.k;
import com.kascend.chushou.widget.ItemTagView;
import tv.chushou.zues.widget.fresco.FrescoThumbnailView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class g extends k {
    private final float a;
    private ImageView b;
    private ImageView g;
    private FrescoThumbnailView mpp;
    private FrescoThumbnailView mzK;
    private FrescoThumbnailView mzL;
    private ItemTagView mzM;
    private FrameLayout mzN;

    public g(float f) {
        this.a = f;
    }

    @Override // com.kascend.chushou.player.ui.food.k
    int a() {
        return a.h.view_ratio_holder_style;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.kascend.chushou.player.ui.food.k
    @SuppressLint({"ClickableViewAccessibility"})
    public void f(FoodView foodView) {
        super.f(foodView);
        this.mzN = (FrameLayout) Is(a.f.fl_holder);
        this.b = (ImageView) Is(a.f.iv_ad_close_top);
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.ui.food.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.mzU.c();
            }
        });
        this.mzK = (FrescoThumbnailView) Is(a.f.iv_cover_ad);
        this.mzL = (FrescoThumbnailView) Is(a.f.iv_cover_ad_wangmai);
        this.mpp = (FrescoThumbnailView) Is(a.f.iv_frame_border);
        this.mzM = (ItemTagView) Is(a.f.iv_icon);
        this.g = (ImageView) Is(a.f.iv_ad_close);
        this.g.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.ui.food.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.mzU.c();
            }
        });
        this.mzK.setOnTouchListener(new View.OnTouchListener() { // from class: com.kascend.chushou.player.ui.food.g.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getActionMasked() == 0) {
                    g.this.m = (int) motionEvent.getX();
                    g.this.n = (int) motionEvent.getY();
                    g.this.o = AdCard.INVALID_NUM;
                    g.this.p = AdCard.INVALID_NUM;
                    return false;
                } else if (motionEvent.getActionMasked() == 1) {
                    g.this.o = (int) motionEvent.getX();
                    g.this.p = (int) motionEvent.getY();
                    return false;
                } else {
                    return false;
                }
            }
        });
        this.mzL.setOnTouchListener(new View.OnTouchListener() { // from class: com.kascend.chushou.player.ui.food.g.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getActionMasked() == 0) {
                    g.this.m = (int) motionEvent.getX();
                    g.this.n = (int) motionEvent.getY();
                    g.this.o = AdCard.INVALID_NUM;
                    g.this.p = AdCard.INVALID_NUM;
                    return false;
                } else if (motionEvent.getActionMasked() == 1) {
                    g.this.o = (int) motionEvent.getX();
                    g.this.p = (int) motionEvent.getY();
                    return false;
                } else {
                    return false;
                }
            }
        });
        this.mzK.setAspectRatio(this.a);
        this.mzL.setAspectRatio(this.a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.kascend.chushou.player.ui.food.k
    public void a(ListItem listItem, k.a aVar) {
        a(listItem, this.mzN);
        if (b()) {
            this.mzN.setVisibility(0);
            this.mzK.setVisibility(8);
            this.mzL.setVisibility(8);
            if (this.mpp != null) {
                this.mpp.setVisibility(8);
            }
        } else {
            this.mzN.setVisibility(8);
            this.mzK.setVisibility(0);
        }
        if (b()) {
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.kascend.chushou.player.ui.food.k
    public void a(ListItem listItem, boolean z) {
        if (b()) {
            if (dyA() != null) {
                dyA().loadUrl(listItem.mCover);
                a(listItem, a.f.fl_holder);
            }
        } else {
            this.mzK.setBlur(false);
            if (!PayHelper.STATUS_SUCC.equals(listItem.mType) || listItem.mAdExtraInfo == null || com.kascend.chushou.a.a.y != tv.chushou.zues.utils.h.parseInt(listItem.mAdExtraInfo.mMarketId) || tv.chushou.zues.utils.h.isEmpty(listItem.mAdExtraInfo.marketPositionCode)) {
                ((ViewGroup) Is(a.f.rl_wangmai)).setVisibility(8);
                this.mzK.setAnim(true);
                this.mzK.i(listItem.mCover, tv.chushou.widget.a.c.dJK(), 0, 0);
                this.mzL.setVisibility(8);
                a(listItem, a.f.iv_cover_ad);
                if (this.mpp != null) {
                    if (tv.chushou.zues.utils.h.isEmpty(listItem.borderImage)) {
                        this.mpp.setVisibility(8);
                    } else {
                        this.mpp.setVisibility(0);
                        this.mpp.i(listItem.borderImage, a.c.transparent, -1, -1);
                    }
                }
            }
        }
        if (z) {
            this.b.setVisibility(listItem.mShowClose ? 0 : 8);
            this.g.setVisibility(8);
            return;
        }
        this.g.setVisibility(listItem.mShowClose ? 0 : 8);
        this.b.setVisibility(8);
    }

    private void a(ListItem listItem, @IdRes int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mzM.getLayoutParams();
        if (listItem.mAdExtraInfo != null) {
            int dip2px = tv.chushou.zues.utils.a.dip2px(this.q, 2.0f);
            this.mzM.a(dip2px, dip2px, dip2px, dip2px);
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
            this.mzM.a(dip2px2, dip2px2, dip2px2, dip2px2);
        }
        this.mzM.setLayoutParams(layoutParams);
        this.mzM.a(listItem);
    }
}
