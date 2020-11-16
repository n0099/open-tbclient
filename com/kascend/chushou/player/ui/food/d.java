package com.kascend.chushou.player.ui.food;

import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.kascend.chushou.constants.ListItem;
import com.kascend.chushou.player.ui.food.k;
/* loaded from: classes6.dex */
public class d extends f {
    @Override // com.kascend.chushou.player.ui.food.f, com.kascend.chushou.player.ui.food.k
    void a(ListItem listItem, k.a aVar) {
        if (aVar != null) {
            a(listItem, this.j);
            if (aVar.f) {
                if (this.pvt != null) {
                    this.pvt.setVisibility(8);
                }
                if (b()) {
                    this.j.setVisibility(0);
                    this.e.setVisibility(8);
                    this.prH.setVisibility(8);
                } else {
                    this.j.setVisibility(8);
                    this.e.setVisibility(0);
                    this.prH.setVisibility(0);
                }
                Point hB = tv.chushou.zues.utils.a.hB(this.q);
                int i = hB.x;
                ViewGroup.LayoutParams layoutParams = this.pvF.getLayoutParams();
                layoutParams.height = i / 5;
                layoutParams.width = i;
                this.pvF.setLayoutParams(layoutParams);
                com.kascend.chushou.a.a.etR().b(listItem, this.pkZ, hB.x / 5, ((hB.x / 5) * EncoderTextureDrawer.X264_WIDTH) / 144, ((hB.x / 5) * 144) / 144);
                if (aVar.f4162a) {
                    if (b()) {
                        c();
                    } else {
                        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.ui.food.d.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                d.this.pvF.b(d.this.m, d.this.n, d.this.o, d.this.p);
                            }
                        });
                    }
                } else if (b()) {
                    c();
                }
            } else {
                if (b()) {
                    this.j.setVisibility(0);
                    this.prH.setVisibility(8);
                    if (this.pvt != null) {
                        this.pvt.setVisibility(8);
                    }
                } else {
                    this.j.setVisibility(8);
                    this.prH.setVisibility(0);
                }
                this.e.setVisibility(8);
                if (aVar.b) {
                    Point hB2 = tv.chushou.zues.utils.a.hB(this.q);
                    if (com.kascend.chushou.a.a.etR().a(listItem, this.pvF, hB2.x, (hB2.x * aVar.c) / 720, (hB2.x * aVar.d) / 720) == 0) {
                        int i2 = hB2.x;
                        ViewGroup.LayoutParams layoutParams2 = this.pvF.getLayoutParams();
                        layoutParams2.width = i2;
                        layoutParams2.height = (int) (i2 / 2.5d);
                        this.pvF.setLayoutParams(layoutParams2);
                    }
                }
                if (aVar.f4162a) {
                    if (b()) {
                        c();
                    } else {
                        this.prH.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.ui.food.d.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                d.this.pvF.b(d.this.m, d.this.n, d.this.o, d.this.p);
                            }
                        });
                    }
                }
            }
            this.pvF.setVisibility(0);
        }
    }
}
