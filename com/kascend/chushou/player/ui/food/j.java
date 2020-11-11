package com.kascend.chushou.player.ui.food;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.kascend.chushou.a;
import com.kascend.chushou.constants.ListItem;
import com.kascend.chushou.player.ui.food.k;
import com.kascend.chushou.widget.ItemTagView;
import tv.chushou.zues.widget.fresco.FrescoThumbnailView;
/* loaded from: classes6.dex */
public class j extends k {
    private ImageView c;
    private FrameLayout pqc;
    private FrescoThumbnailView ptI;
    private ItemTagView ptM;

    @Override // com.kascend.chushou.player.ui.food.k
    int a() {
        return a.h.view_small_ad;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.kascend.chushou.player.ui.food.k
    @SuppressLint({"ClickableViewAccessibility"})
    public void f(FoodView foodView) {
        super.f(foodView);
        this.pqc = (FrameLayout) QH(a.f.fl_holder);
        this.ptM = (ItemTagView) QH(a.f.iv_icon);
        this.c = (ImageView) QH(a.f.iv_ad_close);
        this.ptI = (FrescoThumbnailView) QH(a.f.iv_cover_ad);
        this.c.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.ui.food.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.puc.c();
            }
        });
        this.ptI.setOnTouchListener(new View.OnTouchListener() { // from class: com.kascend.chushou.player.ui.food.j.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getActionMasked() == 0) {
                    j.this.m = (int) motionEvent.getX();
                    j.this.n = (int) motionEvent.getY();
                    j.this.o = AdCard.INVALID_NUM;
                    j.this.p = AdCard.INVALID_NUM;
                    return false;
                } else if (motionEvent.getActionMasked() == 1) {
                    j.this.o = (int) motionEvent.getX();
                    j.this.p = (int) motionEvent.getY();
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
        int a2;
        a(listItem, (ViewGroup) this.pqc);
        if (b()) {
            this.pqc.setVisibility(0);
            this.ptI.setVisibility(8);
            a2 = a(listItem, (View) this.pqc);
            c();
        } else {
            this.pqc.setVisibility(8);
            this.ptI.setVisibility(0);
            a2 = a(listItem, this.ptI);
            this.ptI.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.ui.food.j.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    j.this.puc.b(j.this.m, j.this.n, j.this.o, j.this.p);
                }
            });
        }
        ViewGroup.LayoutParams layoutParams = this.puc.getLayoutParams();
        layoutParams.width = a2 + tv.chushou.zues.utils.a.dip2px(this.q, 20.0f);
        layoutParams.height = tv.chushou.zues.utils.a.dip2px(this.q, 44.0f);
        this.puc.setLayoutParams(layoutParams);
        this.puc.setVisibility(0);
    }

    private int a(ListItem listItem, View view) {
        int b = com.kascend.chushou.a.a.etR().b(listItem, view, tv.chushou.zues.utils.a.dip2px(this.q, 44.0f), tv.chushou.zues.utils.a.dip2px(this.q, 110.0f), tv.chushou.zues.utils.a.dip2px(this.q, 44.0f));
        if (b == 0) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.width = tv.chushou.zues.utils.a.dip2px(this.q, 44.0f);
            layoutParams.height = tv.chushou.zues.utils.a.dip2px(this.q, 44.0f);
            view.setLayoutParams(layoutParams);
            return tv.chushou.zues.utils.a.dip2px(this.q, 44.0f);
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.kascend.chushou.player.ui.food.k
    public void a(ListItem listItem, boolean z) {
        if (b()) {
            if (evS() != null) {
                evS().loadUrl(listItem.mCover);
            }
        } else {
            this.ptI.setAnim(true);
            this.ptI.i(listItem.mCover, tv.chushou.widget.a.c.eHE(), 0, 0);
        }
        this.ptM.a(listItem);
        this.c.setVisibility(listItem.mShowClose ? 0 : 4);
    }
}
