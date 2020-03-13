package com.kascend.chushou.player.ui.food;

import android.annotation.SuppressLint;
import android.graphics.Point;
import android.os.Build;
import android.support.annotation.IdRes;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.kascend.chushou.a;
import com.kascend.chushou.constants.ListItem;
import com.kascend.chushou.player.ui.food.k;
import com.kascend.chushou.widget.ItemTagView;
import tv.chushou.zues.widget.fresco.FrescoThumbnailView;
/* loaded from: classes5.dex */
public class e extends k {
    private ImageView c;
    private FrameLayout d;
    private int e;
    private int f;
    private FrescoThumbnailView nbo;
    private ItemTagView nbs;

    @Override // com.kascend.chushou.player.ui.food.k
    int a() {
        return a.h.view_home_ad_style;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.kascend.chushou.player.ui.food.k
    @SuppressLint({"ClickableViewAccessibility"})
    public void f(FoodView foodView) {
        super.f(foodView);
        this.d = (FrameLayout) MS(a.f.fl_holder);
        this.nbo = (FrescoThumbnailView) MS(a.f.iv_ad);
        this.nbs = (ItemTagView) MS(a.f.iv_icon);
        this.c = (ImageView) MS(a.f.iv_close);
        this.c.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.ui.food.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.nbI.c();
            }
        });
        this.nbo.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.ui.food.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.nbI.b(e.this.m, e.this.n, e.this.o, e.this.p);
            }
        });
        this.nbo.setOnTouchListener(new View.OnTouchListener() { // from class: com.kascend.chushou.player.ui.food.e.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getActionMasked() == 0) {
                    e.this.m = (int) motionEvent.getX();
                    e.this.n = (int) motionEvent.getY();
                    return false;
                } else if (motionEvent.getActionMasked() == 1) {
                    e.this.o = (int) motionEvent.getX();
                    e.this.p = (int) motionEvent.getY();
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
        a(listItem, this.d);
        Point hd = tv.chushou.zues.utils.a.hd(this.q);
        this.e = (int) (hd.x * 0.8d);
        this.f = (hd.x * 1066) / 720;
        int i = (hd.x * 800) / 720;
        if (b()) {
            this.d.setVisibility(0);
            this.nbo.setVisibility(8);
            a(listItem, aVar, hd, i, this.d);
            c();
            return;
        }
        this.d.setVisibility(8);
        this.nbo.setVisibility(0);
        a(listItem, aVar, hd, i, this.nbo);
    }

    private void a(ListItem listItem, k.a aVar, Point point, int i, View view) {
        if (com.kascend.chushou.a.a.dBP().a(listItem, view, this.e, this.f, i) == 0) {
            this.e = (int) (point.x * 0.8d);
            int i2 = (this.e * 4) / 3;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            layoutParams.width = this.e;
            layoutParams.height = i2;
            view.setLayoutParams(layoutParams);
        }
    }

    private void a(ListItem listItem, @IdRes int i) {
        if (listItem.mAdExtraInfo != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nbs.getLayoutParams();
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
                    layoutParams.setMargins(0, 0, tv.chushou.zues.utils.a.dip2px(this.q, 10.0f), 0);
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
                    layoutParams.setMargins(0, 0, tv.chushou.zues.utils.a.dip2px(this.q, 10.0f), 0);
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
            this.nbs.setLayoutParams(layoutParams);
        }
        this.nbs.a(listItem);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.kascend.chushou.player.ui.food.k
    public void a(ListItem listItem, boolean z) {
        if (b()) {
            if (dEa() != null) {
                dEa().loadUrl(listItem.mCover);
                a(listItem, a.f.fl_holder);
            }
        } else {
            a(listItem, a.f.iv_ad);
            this.nbo.setAnim(true);
            this.nbo.i(listItem.mCover, tv.chushou.widget.a.c.dQl(), this.e, this.f);
        }
        this.nbs.a(listItem);
    }
}
