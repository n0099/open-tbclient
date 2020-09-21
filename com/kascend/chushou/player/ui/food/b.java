package com.kascend.chushou.player.ui.food;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.kascend.chushou.a;
import com.kascend.chushou.constants.ListItem;
import com.kascend.chushou.player.ui.food.k;
import tv.chushou.zues.widget.fresco.FrescoThumbnailView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class b extends k {
    private ImageView b;
    private FrescoThumbnailView odz;

    @Override // com.kascend.chushou.player.ui.food.k
    int a() {
        return a.h.view_gift_small_style;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.kascend.chushou.player.ui.food.k
    @SuppressLint({"ClickableViewAccessibility"})
    public void f(FoodView foodView) {
        super.f(foodView);
        this.odz = (FrescoThumbnailView) NP(a.f.iv_cover_ad);
        this.b = (ImageView) NP(a.f.iv_ad_close);
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.ui.food.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.odT.c();
            }
        });
        this.odz.setOnTouchListener(new View.OnTouchListener() { // from class: com.kascend.chushou.player.ui.food.b.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getActionMasked() == 0) {
                    b.this.m = (int) motionEvent.getX();
                    b.this.n = (int) motionEvent.getY();
                    b.this.o = AdCard.INVALID_NUM;
                    b.this.p = AdCard.INVALID_NUM;
                    return false;
                } else if (motionEvent.getActionMasked() == 1) {
                    b.this.o = (int) motionEvent.getX();
                    b.this.p = (int) motionEvent.getY();
                    return false;
                } else {
                    return false;
                }
            }
        });
        this.odz.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.ui.food.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.odT.b(b.this.m, b.this.n, b.this.o, b.this.p);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.kascend.chushou.player.ui.food.k
    public void a(ListItem listItem, k.a aVar) {
        if (aVar != null) {
            int i = aVar.h;
            ViewGroup.LayoutParams layoutParams = this.odz.getLayoutParams();
            layoutParams.height = i;
            this.odz.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.kascend.chushou.player.ui.food.k
    public void a(ListItem listItem, boolean z) {
        this.odz.setAnim(true);
        this.odz.a(listItem.mCover, tv.chushou.widget.a.c.eqg(), 0, 0, 1);
        this.b.setVisibility(listItem.mShowClose ? 0 : 8);
    }
}
