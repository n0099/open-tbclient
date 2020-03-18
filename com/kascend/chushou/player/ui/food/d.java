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
                if (this.ndh != null) {
                    this.ndh.setVisibility(8);
                }
                if (b()) {
                    this.j.setVisibility(0);
                    this.e.setVisibility(8);
                    this.mZw.setVisibility(8);
                } else {
                    this.j.setVisibility(8);
                    this.e.setVisibility(0);
                    this.mZw.setVisibility(0);
                }
                Point hc = tv.chushou.zues.utils.a.hc(this.q);
                int i = hc.x;
                ViewGroup.LayoutParams layoutParams = this.ndt.getLayoutParams();
                layoutParams.height = i / 5;
                layoutParams.width = i;
                this.ndt.setLayoutParams(layoutParams);
                com.kascend.chushou.a.a.dCm().b(listItem, this.mSF, hc.x / 5, ((hc.x / 5) * 360) / 144, ((hc.x / 5) * 144) / 144);
                if (aVar.a) {
                    if (b()) {
                        c();
                    } else {
                        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.ui.food.d.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                d.this.ndt.b(d.this.m, d.this.n, d.this.o, d.this.p);
                            }
                        });
                    }
                } else if (b()) {
                    c();
                }
            } else {
                if (b()) {
                    this.j.setVisibility(0);
                    this.mZw.setVisibility(8);
                    if (this.ndh != null) {
                        this.ndh.setVisibility(8);
                    }
                } else {
                    this.j.setVisibility(8);
                    this.mZw.setVisibility(0);
                }
                this.e.setVisibility(8);
                if (aVar.b) {
                    Point hc2 = tv.chushou.zues.utils.a.hc(this.q);
                    if (com.kascend.chushou.a.a.dCm().a(listItem, this.ndt, hc2.x, (hc2.x * aVar.c) / 720, (hc2.x * aVar.d) / 720) == 0) {
                        int i2 = hc2.x;
                        ViewGroup.LayoutParams layoutParams2 = this.ndt.getLayoutParams();
                        layoutParams2.width = i2;
                        layoutParams2.height = (int) (i2 / 2.5d);
                        this.ndt.setLayoutParams(layoutParams2);
                    }
                }
                if (aVar.a) {
                    if (b()) {
                        c();
                    } else {
                        this.mZw.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.ui.food.d.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                d.this.ndt.b(d.this.m, d.this.n, d.this.o, d.this.p);
                            }
                        });
                    }
                }
            }
            this.ndt.setVisibility(0);
        }
    }
}
