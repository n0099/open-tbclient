package com.kascend.chushou.player.ui.food;

import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import com.kascend.chushou.constants.ListItem;
import com.kascend.chushou.player.ui.food.k;
/* loaded from: classes5.dex */
public class d extends f {
    @Override // com.kascend.chushou.player.ui.food.f, com.kascend.chushou.player.ui.food.k
    void a(ListItem listItem, k.a aVar) {
        if (aVar != null) {
            a(listItem, this.j);
            if (aVar.f) {
                if (this.mVb != null) {
                    this.mVb.setVisibility(8);
                }
                if (b()) {
                    this.j.setVisibility(0);
                    this.e.setVisibility(8);
                    this.mRe.setVisibility(8);
                } else {
                    this.j.setVisibility(8);
                    this.e.setVisibility(0);
                    this.mRe.setVisibility(0);
                }
                Point gv = tv.chushou.zues.utils.a.gv(this.q);
                int i = gv.x;
                ViewGroup.LayoutParams layoutParams = this.mVn.getLayoutParams();
                layoutParams.height = i / 5;
                layoutParams.width = i;
                this.mVn.setLayoutParams(layoutParams);
                com.kascend.chushou.a.a.dEh().b(listItem, this.mKA, gv.x / 5, ((gv.x / 5) * 360) / 144, ((gv.x / 5) * 144) / 144);
                if (aVar.a) {
                    if (b()) {
                        c();
                    } else {
                        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.ui.food.d.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                d.this.mVn.b(d.this.m, d.this.n, d.this.o, d.this.p);
                            }
                        });
                    }
                } else if (b()) {
                    c();
                }
            } else {
                if (b()) {
                    this.j.setVisibility(0);
                    this.mRe.setVisibility(8);
                    if (this.mVb != null) {
                        this.mVb.setVisibility(8);
                    }
                } else {
                    this.j.setVisibility(8);
                    this.mRe.setVisibility(0);
                }
                this.e.setVisibility(8);
                if (aVar.b) {
                    Point gv2 = tv.chushou.zues.utils.a.gv(this.q);
                    if (com.kascend.chushou.a.a.dEh().a(listItem, this.mVn, gv2.x, (gv2.x * aVar.c) / 720, (gv2.x * aVar.d) / 720) == 0) {
                        int i2 = gv2.x;
                        ViewGroup.LayoutParams layoutParams2 = this.mVn.getLayoutParams();
                        layoutParams2.width = i2;
                        layoutParams2.height = (int) (i2 / 2.5d);
                        this.mVn.setLayoutParams(layoutParams2);
                    }
                }
                if (aVar.a) {
                    if (b()) {
                        c();
                    } else {
                        this.mRe.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.ui.food.d.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                d.this.mVn.b(d.this.m, d.this.n, d.this.o, d.this.p);
                            }
                        });
                    }
                }
            }
            this.mVn.setVisibility(0);
        }
    }
}
