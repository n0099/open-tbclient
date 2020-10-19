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
/* loaded from: classes6.dex */
public class e extends k {
    private ImageView c;
    private int e;
    private int f;
    private FrameLayout opl;
    private FrescoThumbnailView osS;
    private ItemTagView osW;

    @Override // com.kascend.chushou.player.ui.food.k
    int a() {
        return a.h.view_home_ad_style;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.kascend.chushou.player.ui.food.k
    @SuppressLint({"ClickableViewAccessibility"})
    public void f(FoodView foodView) {
        super.f(foodView);
        this.opl = (FrameLayout) Ov(a.f.fl_holder);
        this.osS = (FrescoThumbnailView) Ov(a.f.iv_ad);
        this.osW = (ItemTagView) Ov(a.f.iv_icon);
        this.c = (ImageView) Ov(a.f.iv_close);
        this.c.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.ui.food.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.otm.c();
            }
        });
        this.osS.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.ui.food.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.otm.b(e.this.m, e.this.n, e.this.o, e.this.p);
            }
        });
        this.osS.setOnTouchListener(new View.OnTouchListener() { // from class: com.kascend.chushou.player.ui.food.e.3
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
        a(listItem, this.opl);
        Point hj = tv.chushou.zues.utils.a.hj(this.q);
        this.e = (int) (hj.x * 0.8d);
        this.f = (hj.x * 1066) / 720;
        int i = (hj.x * 800) / 720;
        if (b()) {
            this.opl.setVisibility(0);
            this.osS.setVisibility(8);
            a(listItem, aVar, hj, i, this.opl);
            c();
            return;
        }
        this.opl.setVisibility(8);
        this.osS.setVisibility(0);
        a(listItem, aVar, hj, i, this.osS);
    }

    private void a(ListItem listItem, k.a aVar, Point point, int i, View view) {
        if (com.kascend.chushou.a.a.egc().a(listItem, view, this.e, this.f, i) == 0) {
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
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.osW.getLayoutParams();
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
            this.osW.setLayoutParams(layoutParams);
        }
        this.osW.a(listItem);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.kascend.chushou.player.ui.food.k
    public void a(ListItem listItem, boolean z) {
        if (b()) {
            if (eid() != null) {
                eid().loadUrl(listItem.mCover);
                a(listItem, a.f.fl_holder);
            }
        } else {
            a(listItem, a.f.iv_ad);
            this.osS.setAnim(true);
            this.osS.i(listItem.mCover, tv.chushou.widget.a.c.etR(), this.e, this.f);
        }
        this.osW.a(listItem);
    }
}
