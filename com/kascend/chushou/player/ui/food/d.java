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
                if (this.mzN != null) {
                    this.mzN.setVisibility(8);
                }
                if (b()) {
                    this.j.setVisibility(0);
                    this.e.setVisibility(8);
                    this.mvZ.setVisibility(8);
                } else {
                    this.j.setVisibility(8);
                    this.e.setVisibility(0);
                    this.mvZ.setVisibility(0);
                }
                Point fU = tv.chushou.zues.utils.a.fU(this.q);
                int i = fU.x;
                ViewGroup.LayoutParams layoutParams = this.mzZ.getLayoutParams();
                layoutParams.height = i / 5;
                layoutParams.width = i;
                this.mzZ.setLayoutParams(layoutParams);
                com.kascend.chushou.a.a.dwB().b(listItem, this.mpu, fU.x / 5, ((fU.x / 5) * 360) / 144, ((fU.x / 5) * 144) / 144);
                if (aVar.a) {
                    if (b()) {
                        c();
                    } else {
                        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.ui.food.d.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                d.this.mzZ.b(d.this.m, d.this.n, d.this.o, d.this.p);
                            }
                        });
                    }
                } else if (b()) {
                    c();
                }
            } else {
                if (b()) {
                    this.j.setVisibility(0);
                    this.mvZ.setVisibility(8);
                    if (this.mzN != null) {
                        this.mzN.setVisibility(8);
                    }
                } else {
                    this.j.setVisibility(8);
                    this.mvZ.setVisibility(0);
                }
                this.e.setVisibility(8);
                if (aVar.b) {
                    Point fU2 = tv.chushou.zues.utils.a.fU(this.q);
                    if (com.kascend.chushou.a.a.dwB().a(listItem, this.mzZ, fU2.x, (fU2.x * aVar.c) / 720, (fU2.x * aVar.d) / 720) == 0) {
                        int i2 = fU2.x;
                        ViewGroup.LayoutParams layoutParams2 = this.mzZ.getLayoutParams();
                        layoutParams2.width = i2;
                        layoutParams2.height = (int) (i2 / 2.5d);
                        this.mzZ.setLayoutParams(layoutParams2);
                    }
                }
                if (aVar.a) {
                    if (b()) {
                        c();
                    } else {
                        this.mvZ.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.ui.food.d.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                d.this.mzZ.b(d.this.m, d.this.n, d.this.o, d.this.p);
                            }
                        });
                    }
                }
            }
            this.mzZ.setVisibility(0);
        }
    }
}
