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
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.kascend.chushou.a;
import com.kascend.chushou.constants.ListItem;
import com.kascend.chushou.player.ui.food.k;
import com.kascend.chushou.widget.ItemTagView;
import tv.chushou.zues.widget.fresco.FrescoThumbnailView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class h extends k {
    private ImageView a;
    private ImageView d;
    private FrameLayout e;
    private FrescoThumbnailView naI;
    private ItemTagView naJ;

    @Override // com.kascend.chushou.player.ui.food.k
    int a() {
        return a.h.view_resize_holder_style;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.kascend.chushou.player.ui.food.k
    @SuppressLint({"ClickableViewAccessibility"})
    public void f(FoodView foodView) {
        super.f(foodView);
        this.e = (FrameLayout) MP(a.f.fl_holder);
        this.a = (ImageView) MP(a.f.iv_ad_close_top);
        this.a.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.ui.food.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.naN.c();
            }
        });
        this.naI = (FrescoThumbnailView) MP(a.f.iv_cover_ad);
        this.naJ = (ItemTagView) MP(a.f.iv_icon);
        this.d = (ImageView) MP(a.f.iv_ad_close);
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.ui.food.h.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.naN.c();
            }
        });
        this.naI.setOnTouchListener(new View.OnTouchListener() { // from class: com.kascend.chushou.player.ui.food.h.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getActionMasked() == 0) {
                    h.this.m = (int) motionEvent.getX();
                    h.this.n = (int) motionEvent.getY();
                    h.this.o = AdCard.INVALID_NUM;
                    h.this.p = AdCard.INVALID_NUM;
                    return false;
                } else if (motionEvent.getActionMasked() == 1) {
                    h.this.o = (int) motionEvent.getX();
                    h.this.p = (int) motionEvent.getY();
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
        if (aVar != null) {
            a(listItem, this.e);
            if (b()) {
                this.e.setVisibility(0);
                this.naI.setVisibility(8);
            } else {
                this.e.setVisibility(8);
                this.naI.setVisibility(0);
            }
            int i = tv.chushou.zues.utils.a.he(this.q).x - aVar.e;
            if (com.kascend.chushou.a.a.dAE().a(listItem, this.naN, i, (aVar.c * i) / 720, (aVar.d * i) / 720) == 0) {
                ViewGroup.LayoutParams layoutParams = this.naN.getLayoutParams();
                layoutParams.width = i;
                layoutParams.height = (int) (i / 2.5d);
                this.naN.setLayoutParams(layoutParams);
            }
            if (b()) {
                c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.kascend.chushou.player.ui.food.k
    public void a(ListItem listItem, boolean z) {
        if (b()) {
            if (dCP() != null) {
                dCP().loadUrl(listItem.mCover);
                a(listItem, a.f.fl_holder);
            }
        } else {
            this.naI.setAnim(true);
            this.naI.i(listItem.mCover, tv.chushou.widget.a.c.dOT(), 0, 0);
            a(listItem, a.f.iv_cover_ad);
        }
        if (z) {
            this.a.setVisibility(listItem.mShowClose ? 0 : 8);
            this.d.setVisibility(8);
            return;
        }
        this.d.setVisibility(listItem.mShowClose ? 0 : 8);
        this.a.setVisibility(8);
    }

    private void a(ListItem listItem, @IdRes int i) {
        if (listItem.mAdExtraInfo != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.naJ.getLayoutParams();
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
                    layoutParams.setMargins(tv.chushou.zues.utils.a.dip2px(this.q, 10.0f), 0, 0, 0);
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
                    layoutParams.setMargins(0, 0, tv.chushou.zues.utils.a.dip2px(this.q, 30.0f), 0);
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
                    layoutParams.setMargins(tv.chushou.zues.utils.a.dip2px(this.q, 10.0f), 0, 0, tv.chushou.zues.utils.a.dip2px(this.q, 15.0f));
                    break;
            }
            this.naJ.setLayoutParams(layoutParams);
        }
        this.naJ.a(listItem);
    }
}
