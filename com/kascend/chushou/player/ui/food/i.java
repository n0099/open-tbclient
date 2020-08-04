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
import io.flutter.plugin.platform.PlatformPlugin;
import tv.chushou.zues.widget.fresco.FrescoThumbnailView;
/* loaded from: classes6.dex */
public class i extends k {
    private ImageView c;
    private FrameLayout d;
    private int e;
    private int f;
    private ItemTagView nzD;
    private FrescoThumbnailView nzz;

    @Override // com.kascend.chushou.player.ui.food.k
    int a() {
        return a.h.view_room_ad_style;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.kascend.chushou.player.ui.food.k
    @SuppressLint({"ClickableViewAccessibility"})
    public void f(FoodView foodView) {
        super.f(foodView);
        this.d = (FrameLayout) KG(a.f.fl_holder);
        this.nzz = (FrescoThumbnailView) KG(a.f.iv_ad);
        this.nzD = (ItemTagView) KG(a.f.iv_icon);
        this.c = (ImageView) KG(a.f.iv_close);
        this.c.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.ui.food.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.nzT.c();
            }
        });
        this.nzz.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.ui.food.i.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.nzT.b(i.this.m, i.this.n, i.this.o, i.this.p);
            }
        });
        this.nzz.setOnTouchListener(new View.OnTouchListener() { // from class: com.kascend.chushou.player.ui.food.i.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getActionMasked() == 0) {
                    i.this.m = (int) motionEvent.getX();
                    i.this.n = (int) motionEvent.getY();
                    return false;
                } else if (motionEvent.getActionMasked() == 1) {
                    i.this.o = (int) motionEvent.getX();
                    i.this.p = (int) motionEvent.getY();
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
        int i;
        a(listItem, this.d);
        Point gE = tv.chushou.zues.utils.a.gE(this.q);
        this.e = (int) (gE.x * 0.8d);
        this.f = (gE.x * 1066) / 720;
        if (!aVar.g) {
            this.e = (((int) (gE.y * 0.625d)) * 4) / 3;
            this.f = (gE.x * 600) / PlatformPlugin.DEFAULT_SYSTEM_UI;
            i = (gE.x * 450) / PlatformPlugin.DEFAULT_SYSTEM_UI;
        } else {
            this.e = (int) (gE.x * 0.83d);
            this.f = (gE.x * 600) / 720;
            i = (gE.x * 450) / 720;
        }
        if (b()) {
            this.d.setVisibility(0);
            this.nzz.setVisibility(8);
            a(listItem, aVar, gE, i, this.d);
            c();
            return;
        }
        this.d.setVisibility(8);
        this.nzz.setVisibility(0);
        a(listItem, aVar, gE, i, this.nzz);
    }

    private void a(ListItem listItem, k.a aVar, Point point, int i, View view) {
        int i2;
        if (com.kascend.chushou.a.a.dMj().a(listItem, view, this.e, this.f, i) == 0) {
            this.e = (int) (point.x * 0.8d);
            if (!aVar.g) {
                int i3 = (int) (point.y * 0.625d);
                this.e = (i3 * 4) / 3;
                i2 = i3;
            } else {
                this.e = (int) (point.x * 0.833d);
                i2 = (this.e * 3) / 4;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            layoutParams.width = this.e;
            layoutParams.height = i2;
            view.setLayoutParams(layoutParams);
        }
    }

    private void a(ListItem listItem, @IdRes int i) {
        if (listItem.mAdExtraInfo != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nzD.getLayoutParams();
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
            this.nzD.setLayoutParams(layoutParams);
        }
        this.nzD.a(listItem);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.kascend.chushou.player.ui.food.k
    public void a(ListItem listItem, boolean z) {
        if (b()) {
            if (dOj() != null) {
                dOj().loadUrl(listItem.mCover);
                a(listItem, a.f.fl_holder);
            }
        } else {
            a(listItem, a.f.iv_ad);
            this.nzz.setAnim(true);
            this.nzz.i(listItem.mCover, tv.chushou.widget.a.c.dZW(), this.e, this.f);
        }
        this.nzD.a(listItem);
    }
}
