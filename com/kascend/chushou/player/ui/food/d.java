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
                if (this.nbj != null) {
                    this.nbj.setVisibility(8);
                }
                if (b()) {
                    this.j.setVisibility(0);
                    this.e.setVisibility(8);
                    this.mXz.setVisibility(8);
                } else {
                    this.j.setVisibility(8);
                    this.e.setVisibility(0);
                    this.mXz.setVisibility(0);
                }
                Point hd = tv.chushou.zues.utils.a.hd(this.q);
                int i = hd.x;
                ViewGroup.LayoutParams layoutParams = this.nbv.getLayoutParams();
                layoutParams.height = i / 5;
                layoutParams.width = i;
                this.nbv.setLayoutParams(layoutParams);
                com.kascend.chushou.a.a.dBM().b(listItem, this.mQI, hd.x / 5, ((hd.x / 5) * 360) / 144, ((hd.x / 5) * 144) / 144);
                if (aVar.a) {
                    if (b()) {
                        c();
                    } else {
                        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.ui.food.d.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                d.this.nbv.b(d.this.m, d.this.n, d.this.o, d.this.p);
                            }
                        });
                    }
                } else if (b()) {
                    c();
                }
            } else {
                if (b()) {
                    this.j.setVisibility(0);
                    this.mXz.setVisibility(8);
                    if (this.nbj != null) {
                        this.nbj.setVisibility(8);
                    }
                } else {
                    this.j.setVisibility(8);
                    this.mXz.setVisibility(0);
                }
                this.e.setVisibility(8);
                if (aVar.b) {
                    Point hd2 = tv.chushou.zues.utils.a.hd(this.q);
                    if (com.kascend.chushou.a.a.dBM().a(listItem, this.nbv, hd2.x, (hd2.x * aVar.c) / 720, (hd2.x * aVar.d) / 720) == 0) {
                        int i2 = hd2.x;
                        ViewGroup.LayoutParams layoutParams2 = this.nbv.getLayoutParams();
                        layoutParams2.width = i2;
                        layoutParams2.height = (int) (i2 / 2.5d);
                        this.nbv.setLayoutParams(layoutParams2);
                    }
                }
                if (aVar.a) {
                    if (b()) {
                        c();
                    } else {
                        this.mXz.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.ui.food.d.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                d.this.nbv.b(d.this.m, d.this.n, d.this.o, d.this.p);
                            }
                        });
                    }
                }
            }
            this.nbv.setVisibility(0);
        }
    }
}
