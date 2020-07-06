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
                if (this.nqV != null) {
                    this.nqV.setVisibility(8);
                }
                if (b()) {
                    this.j.setVisibility(0);
                    this.e.setVisibility(8);
                    this.nne.setVisibility(8);
                } else {
                    this.j.setVisibility(8);
                    this.e.setVisibility(0);
                    this.nne.setVisibility(0);
                }
                Point gw = tv.chushou.zues.utils.a.gw(this.q);
                int i = gw.x;
                ViewGroup.LayoutParams layoutParams = this.nrh.getLayoutParams();
                layoutParams.height = i / 5;
                layoutParams.width = i;
                this.nrh.setLayoutParams(layoutParams);
                com.kascend.chushou.a.a.dIN().b(listItem, this.ngB, gw.x / 5, ((gw.x / 5) * 360) / 144, ((gw.x / 5) * 144) / 144);
                if (aVar.a) {
                    if (b()) {
                        c();
                    } else {
                        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.ui.food.d.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                d.this.nrh.b(d.this.m, d.this.n, d.this.o, d.this.p);
                            }
                        });
                    }
                } else if (b()) {
                    c();
                }
            } else {
                if (b()) {
                    this.j.setVisibility(0);
                    this.nne.setVisibility(8);
                    if (this.nqV != null) {
                        this.nqV.setVisibility(8);
                    }
                } else {
                    this.j.setVisibility(8);
                    this.nne.setVisibility(0);
                }
                this.e.setVisibility(8);
                if (aVar.b) {
                    Point gw2 = tv.chushou.zues.utils.a.gw(this.q);
                    if (com.kascend.chushou.a.a.dIN().a(listItem, this.nrh, gw2.x, (gw2.x * aVar.c) / 720, (gw2.x * aVar.d) / 720) == 0) {
                        int i2 = gw2.x;
                        ViewGroup.LayoutParams layoutParams2 = this.nrh.getLayoutParams();
                        layoutParams2.width = i2;
                        layoutParams2.height = (int) (i2 / 2.5d);
                        this.nrh.setLayoutParams(layoutParams2);
                    }
                }
                if (aVar.a) {
                    if (b()) {
                        c();
                    } else {
                        this.nne.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.ui.food.d.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                d.this.nrh.b(d.this.m, d.this.n, d.this.o, d.this.p);
                            }
                        });
                    }
                }
            }
            this.nrh.setVisibility(0);
        }
    }
}
