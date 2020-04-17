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
                if (this.mzI != null) {
                    this.mzI.setVisibility(8);
                }
                if (b()) {
                    this.j.setVisibility(0);
                    this.e.setVisibility(8);
                    this.mvU.setVisibility(8);
                } else {
                    this.j.setVisibility(8);
                    this.e.setVisibility(0);
                    this.mvU.setVisibility(0);
                }
                Point gh = tv.chushou.zues.utils.a.gh(this.q);
                int i = gh.x;
                ViewGroup.LayoutParams layoutParams = this.mzU.getLayoutParams();
                layoutParams.height = i / 5;
                layoutParams.width = i;
                this.mzU.setLayoutParams(layoutParams);
                com.kascend.chushou.a.a.dwE().b(listItem, this.mpp, gh.x / 5, ((gh.x / 5) * 360) / 144, ((gh.x / 5) * 144) / 144);
                if (aVar.a) {
                    if (b()) {
                        c();
                    } else {
                        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.ui.food.d.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                d.this.mzU.b(d.this.m, d.this.n, d.this.o, d.this.p);
                            }
                        });
                    }
                } else if (b()) {
                    c();
                }
            } else {
                if (b()) {
                    this.j.setVisibility(0);
                    this.mvU.setVisibility(8);
                    if (this.mzI != null) {
                        this.mzI.setVisibility(8);
                    }
                } else {
                    this.j.setVisibility(8);
                    this.mvU.setVisibility(0);
                }
                this.e.setVisibility(8);
                if (aVar.b) {
                    Point gh2 = tv.chushou.zues.utils.a.gh(this.q);
                    if (com.kascend.chushou.a.a.dwE().a(listItem, this.mzU, gh2.x, (gh2.x * aVar.c) / 720, (gh2.x * aVar.d) / 720) == 0) {
                        int i2 = gh2.x;
                        ViewGroup.LayoutParams layoutParams2 = this.mzU.getLayoutParams();
                        layoutParams2.width = i2;
                        layoutParams2.height = (int) (i2 / 2.5d);
                        this.mzU.setLayoutParams(layoutParams2);
                    }
                }
                if (aVar.a) {
                    if (b()) {
                        c();
                    } else {
                        this.mvU.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.ui.food.d.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                d.this.mzU.b(d.this.m, d.this.n, d.this.o, d.this.p);
                            }
                        });
                    }
                }
            }
            this.mzU.setVisibility(0);
        }
    }
}
