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
    private int e;
    private int f;
    private FrameLayout prF;
    private FrescoThumbnailView pvl;
    private ItemTagView pvp;

    @Override // com.kascend.chushou.player.ui.food.k
    int a() {
        return a.h.view_room_ad_style;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.kascend.chushou.player.ui.food.k
    @SuppressLint({"ClickableViewAccessibility"})
    public void f(FoodView foodView) {
        super.f(foodView);
        this.prF = (FrameLayout) Rk(a.f.fl_holder);
        this.pvl = (FrescoThumbnailView) Rk(a.f.iv_ad);
        this.pvp = (ItemTagView) Rk(a.f.iv_icon);
        this.c = (ImageView) Rk(a.f.iv_close);
        this.c.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.ui.food.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.pvF.c();
            }
        });
        this.pvl.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.ui.food.i.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.pvF.b(i.this.m, i.this.n, i.this.o, i.this.p);
            }
        });
        this.pvl.setOnTouchListener(new View.OnTouchListener() { // from class: com.kascend.chushou.player.ui.food.i.3
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
        a(listItem, this.prF);
        Point hB = tv.chushou.zues.utils.a.hB(this.q);
        this.e = (int) (hB.x * 0.8d);
        this.f = (hB.x * 1066) / 720;
        if (!aVar.g) {
            this.e = (((int) (hB.y * 0.625d)) * 4) / 3;
            this.f = (hB.x * 600) / PlatformPlugin.DEFAULT_SYSTEM_UI;
            i = (hB.x * 450) / PlatformPlugin.DEFAULT_SYSTEM_UI;
        } else {
            this.e = (int) (hB.x * 0.83d);
            this.f = (hB.x * 600) / 720;
            i = (hB.x * 450) / 720;
        }
        if (b()) {
            this.prF.setVisibility(0);
            this.pvl.setVisibility(8);
            a(listItem, aVar, hB, i, this.prF);
            c();
            return;
        }
        this.prF.setVisibility(8);
        this.pvl.setVisibility(0);
        a(listItem, aVar, hB, i, this.pvl);
    }

    private void a(ListItem listItem, k.a aVar, Point point, int i, View view) {
        int i2;
        if (com.kascend.chushou.a.a.etR().a(listItem, view, this.e, this.f, i) == 0) {
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
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.pvp.getLayoutParams();
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
            this.pvp.setLayoutParams(layoutParams);
        }
        this.pvp.a(listItem);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.kascend.chushou.player.ui.food.k
    public void a(ListItem listItem, boolean z) {
        if (b()) {
            if (evS() != null) {
                evS().loadUrl(listItem.mCover);
                a(listItem, a.f.fl_holder);
            }
        } else {
            a(listItem, a.f.iv_ad);
            this.pvl.setAnim(true);
            this.pvl.i(listItem.mCover, tv.chushou.widget.a.c.eHF(), this.e, this.f);
        }
        this.pvp.a(listItem);
    }
}
