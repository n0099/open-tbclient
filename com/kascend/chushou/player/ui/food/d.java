package com.kascend.chushou.player.ui.food;

import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import com.kascend.chushou.constants.ListItem;
import com.kascend.chushou.player.ui.food.k;
/* loaded from: classes6.dex */
public class d extends f {
    @Override // com.kascend.chushou.player.ui.food.f, com.kascend.chushou.player.ui.food.k
    void a(ListItem listItem, k.a aVar) {
        if (aVar != null) {
            a(listItem, this.j);
            if (aVar.f) {
                if (this.nzF != null) {
                    this.nzF.setVisibility(8);
                }
                if (b()) {
                    this.j.setVisibility(0);
                    this.e.setVisibility(8);
                    this.nvR.setVisibility(8);
                } else {
                    this.j.setVisibility(8);
                    this.e.setVisibility(0);
                    this.nvR.setVisibility(0);
                }
                Point gE = tv.chushou.zues.utils.a.gE(this.q);
                int i = gE.x;
                ViewGroup.LayoutParams layoutParams = this.nzR.getLayoutParams();
                layoutParams.height = i / 5;
                layoutParams.width = i;
                this.nzR.setLayoutParams(layoutParams);
                com.kascend.chushou.a.a.dMi().b(listItem, this.npn, gE.x / 5, ((gE.x / 5) * 360) / 144, ((gE.x / 5) * 144) / 144);
                if (aVar.a) {
                    if (b()) {
                        c();
                    } else {
                        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.ui.food.d.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                d.this.nzR.b(d.this.m, d.this.n, d.this.o, d.this.p);
                            }
                        });
                    }
                } else if (b()) {
                    c();
                }
            } else {
                if (b()) {
                    this.j.setVisibility(0);
                    this.nvR.setVisibility(8);
                    if (this.nzF != null) {
                        this.nzF.setVisibility(8);
                    }
                } else {
                    this.j.setVisibility(8);
                    this.nvR.setVisibility(0);
                }
                this.e.setVisibility(8);
                if (aVar.b) {
                    Point gE2 = tv.chushou.zues.utils.a.gE(this.q);
                    if (com.kascend.chushou.a.a.dMi().a(listItem, this.nzR, gE2.x, (gE2.x * aVar.c) / 720, (gE2.x * aVar.d) / 720) == 0) {
                        int i2 = gE2.x;
                        ViewGroup.LayoutParams layoutParams2 = this.nzR.getLayoutParams();
                        layoutParams2.width = i2;
                        layoutParams2.height = (int) (i2 / 2.5d);
                        this.nzR.setLayoutParams(layoutParams2);
                    }
                }
                if (aVar.a) {
                    if (b()) {
                        c();
                    } else {
                        this.nvR.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.ui.food.d.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                d.this.nzR.b(d.this.m, d.this.n, d.this.o, d.this.p);
                            }
                        });
                    }
                }
            }
            this.nzR.setVisibility(0);
        }
    }
}
