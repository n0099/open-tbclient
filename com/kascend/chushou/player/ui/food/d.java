package com.kascend.chushou.player.ui.food;

import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import com.kascend.chushou.constants.ListItem;
import com.kascend.chushou.player.ui.food.k;
/* loaded from: classes4.dex */
public class d extends f {
    @Override // com.kascend.chushou.player.ui.food.f, com.kascend.chushou.player.ui.food.k
    void a(ListItem listItem, k.a aVar) {
        if (aVar != null) {
            a(listItem, this.j);
            if (aVar.f) {
                if (this.naB != null) {
                    this.naB.setVisibility(8);
                }
                if (b()) {
                    this.j.setVisibility(0);
                    this.e.setVisibility(8);
                    this.mWR.setVisibility(8);
                } else {
                    this.j.setVisibility(8);
                    this.e.setVisibility(0);
                    this.mWR.setVisibility(0);
                }
                Point he = tv.chushou.zues.utils.a.he(this.q);
                int i = he.x;
                ViewGroup.LayoutParams layoutParams = this.naN.getLayoutParams();
                layoutParams.height = i / 5;
                layoutParams.width = i;
                this.naN.setLayoutParams(layoutParams);
                com.kascend.chushou.a.a.dAE().b(listItem, this.mQa, he.x / 5, ((he.x / 5) * 360) / 144, ((he.x / 5) * 144) / 144);
                if (aVar.a) {
                    if (b()) {
                        c();
                    } else {
                        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.ui.food.d.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                d.this.naN.b(d.this.m, d.this.n, d.this.o, d.this.p);
                            }
                        });
                    }
                } else if (b()) {
                    c();
                }
            } else {
                if (b()) {
                    this.j.setVisibility(0);
                    this.mWR.setVisibility(8);
                    if (this.naB != null) {
                        this.naB.setVisibility(8);
                    }
                } else {
                    this.j.setVisibility(8);
                    this.mWR.setVisibility(0);
                }
                this.e.setVisibility(8);
                if (aVar.b) {
                    Point he2 = tv.chushou.zues.utils.a.he(this.q);
                    if (com.kascend.chushou.a.a.dAE().a(listItem, this.naN, he2.x, (he2.x * aVar.c) / 720, (he2.x * aVar.d) / 720) == 0) {
                        int i2 = he2.x;
                        ViewGroup.LayoutParams layoutParams2 = this.naN.getLayoutParams();
                        layoutParams2.width = i2;
                        layoutParams2.height = (int) (i2 / 2.5d);
                        this.naN.setLayoutParams(layoutParams2);
                    }
                }
                if (aVar.a) {
                    if (b()) {
                        c();
                    } else {
                        this.mWR.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.ui.food.d.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                d.this.naN.b(d.this.m, d.this.n, d.this.o, d.this.p);
                            }
                        });
                    }
                }
            }
            this.naN.setVisibility(0);
        }
    }
}
