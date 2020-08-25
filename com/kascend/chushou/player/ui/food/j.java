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
    private FrameLayout nPF;
    private FrescoThumbnailView nTn;
    private ItemTagView nTr;

    @Override // com.kascend.chushou.player.ui.food.k
    int a() {
        return a.h.view_small_ad;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.kascend.chushou.player.ui.food.k
    @SuppressLint({"ClickableViewAccessibility"})
    public void f(FoodView foodView) {
        super.f(foodView);
        this.nPF = (FrameLayout) Nk(a.f.fl_holder);
        this.nTr = (ItemTagView) Nk(a.f.iv_icon);
        this.c = (ImageView) Nk(a.f.iv_ad_close);
        this.nTn = (FrescoThumbnailView) Nk(a.f.iv_cover_ad);
        this.c.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.ui.food.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.nTH.c();
            }
        });
        this.nTn.setOnTouchListener(new View.OnTouchListener() { // from class: com.kascend.chushou.player.ui.food.j.2
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
        int a;
        a(listItem, (ViewGroup) this.nPF);
        if (b()) {
            this.nPF.setVisibility(0);
            this.nTn.setVisibility(8);
            a = a(listItem, (View) this.nPF);
            c();
        } else {
            this.nPF.setVisibility(8);
            this.nTn.setVisibility(0);
            a = a(listItem, this.nTn);
            this.nTn.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.ui.food.j.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    j.this.nTH.b(j.this.m, j.this.n, j.this.o, j.this.p);
                }
            });
        }
        ViewGroup.LayoutParams layoutParams = this.nTH.getLayoutParams();
        layoutParams.width = a + tv.chushou.zues.utils.a.dip2px(this.q, 20.0f);
        layoutParams.height = tv.chushou.zues.utils.a.dip2px(this.q, 44.0f);
        this.nTH.setLayoutParams(layoutParams);
        this.nTH.setVisibility(0);
    }

    private int a(ListItem listItem, View view) {
        int b = com.kascend.chushou.a.a.dYk().b(listItem, view, tv.chushou.zues.utils.a.dip2px(this.q, 44.0f), tv.chushou.zues.utils.a.dip2px(this.q, 110.0f), tv.chushou.zues.utils.a.dip2px(this.q, 44.0f));
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
            if (eal() != null) {
                eal().loadUrl(listItem.mCover);
            }
        } else {
            this.nTn.setAnim(true);
            this.nTn.i(listItem.mCover, tv.chushou.widget.a.c.elZ(), 0, 0);
        }
        this.nTr.a(listItem);
        this.c.setVisibility(listItem.mShowClose ? 0 : 4);
    }
}
