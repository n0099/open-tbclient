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
                if (this.mTQ != null) {
                    this.mTQ.setVisibility(8);
                }
                if (b()) {
                    this.j.setVisibility(0);
                    this.e.setVisibility(8);
                    this.mPT.setVisibility(8);
                } else {
                    this.j.setVisibility(8);
                    this.e.setVisibility(0);
                    this.mPT.setVisibility(0);
                }
                Point gv = tv.chushou.zues.utils.a.gv(this.q);
                int i = gv.x;
                ViewGroup.LayoutParams layoutParams = this.mUc.getLayoutParams();
                layoutParams.height = i / 5;
                layoutParams.width = i;
                this.mUc.setLayoutParams(layoutParams);
                com.kascend.chushou.a.a.dDT().b(listItem, this.mJq, gv.x / 5, ((gv.x / 5) * 360) / 144, ((gv.x / 5) * 144) / 144);
                if (aVar.a) {
                    if (b()) {
                        c();
                    } else {
                        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.ui.food.d.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                d.this.mUc.b(d.this.m, d.this.n, d.this.o, d.this.p);
                            }
                        });
                    }
                } else if (b()) {
                    c();
                }
            } else {
                if (b()) {
                    this.j.setVisibility(0);
                    this.mPT.setVisibility(8);
                    if (this.mTQ != null) {
                        this.mTQ.setVisibility(8);
                    }
                } else {
                    this.j.setVisibility(8);
                    this.mPT.setVisibility(0);
                }
                this.e.setVisibility(8);
                if (aVar.b) {
                    Point gv2 = tv.chushou.zues.utils.a.gv(this.q);
                    if (com.kascend.chushou.a.a.dDT().a(listItem, this.mUc, gv2.x, (gv2.x * aVar.c) / 720, (gv2.x * aVar.d) / 720) == 0) {
                        int i2 = gv2.x;
                        ViewGroup.LayoutParams layoutParams2 = this.mUc.getLayoutParams();
                        layoutParams2.width = i2;
                        layoutParams2.height = (int) (i2 / 2.5d);
                        this.mUc.setLayoutParams(layoutParams2);
                    }
                }
                if (aVar.a) {
                    if (b()) {
                        c();
                    } else {
                        this.mPT.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.ui.food.d.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                d.this.mUc.b(d.this.m, d.this.n, d.this.o, d.this.p);
                            }
                        });
                    }
                }
            }
            this.mUc.setVisibility(0);
        }
    }
}
