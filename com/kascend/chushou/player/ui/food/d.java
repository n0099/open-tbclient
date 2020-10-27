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
                if (this.pks != null) {
                    this.pks.setVisibility(8);
                }
                if (b()) {
                    this.j.setVisibility(0);
                    this.e.setVisibility(8);
                    this.pgD.setVisibility(8);
                } else {
                    this.j.setVisibility(8);
                    this.e.setVisibility(0);
                    this.pgD.setVisibility(0);
                }
                Point hD = tv.chushou.zues.utils.a.hD(this.q);
                int i = hD.x;
                ViewGroup.LayoutParams layoutParams = this.pkE.getLayoutParams();
                layoutParams.height = i / 5;
                layoutParams.width = i;
                this.pkE.setLayoutParams(layoutParams);
                com.kascend.chushou.a.a.eqc().b(listItem, this.oZX, hD.x / 5, ((hD.x / 5) * EncoderTextureDrawer.X264_WIDTH) / 144, ((hD.x / 5) * 144) / 144);
                if (aVar.f4160a) {
                    if (b()) {
                        c();
                    } else {
                        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.ui.food.d.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                d.this.pkE.b(d.this.m, d.this.n, d.this.o, d.this.p);
                            }
                        });
                    }
                } else if (b()) {
                    c();
                }
            } else {
                if (b()) {
                    this.j.setVisibility(0);
                    this.pgD.setVisibility(8);
                    if (this.pks != null) {
                        this.pks.setVisibility(8);
                    }
                } else {
                    this.j.setVisibility(8);
                    this.pgD.setVisibility(0);
                }
                this.e.setVisibility(8);
                if (aVar.b) {
                    Point hD2 = tv.chushou.zues.utils.a.hD(this.q);
                    if (com.kascend.chushou.a.a.eqc().a(listItem, this.pkE, hD2.x, (hD2.x * aVar.c) / 720, (hD2.x * aVar.d) / 720) == 0) {
                        int i2 = hD2.x;
                        ViewGroup.LayoutParams layoutParams2 = this.pkE.getLayoutParams();
                        layoutParams2.width = i2;
                        layoutParams2.height = (int) (i2 / 2.5d);
                        this.pkE.setLayoutParams(layoutParams2);
                    }
                }
                if (aVar.f4160a) {
                    if (b()) {
                        c();
                    } else {
                        this.pgD.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.ui.food.d.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                d.this.pkE.b(d.this.m, d.this.n, d.this.o, d.this.p);
                            }
                        });
                    }
                }
            }
            this.pkE.setVisibility(0);
        }
    }
}
