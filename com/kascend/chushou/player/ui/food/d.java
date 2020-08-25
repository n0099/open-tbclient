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
                if (this.nTv != null) {
                    this.nTv.setVisibility(8);
                }
                if (b()) {
                    this.j.setVisibility(0);
                    this.e.setVisibility(8);
                    this.nPH.setVisibility(8);
                } else {
                    this.j.setVisibility(8);
                    this.e.setVisibility(0);
                    this.nPH.setVisibility(0);
                }
                Point gW = tv.chushou.zues.utils.a.gW(this.q);
                int i = gW.x;
                ViewGroup.LayoutParams layoutParams = this.nTH.getLayoutParams();
                layoutParams.height = i / 5;
                layoutParams.width = i;
                this.nTH.setLayoutParams(layoutParams);
                com.kascend.chushou.a.a.dYk().b(listItem, this.nJd, gW.x / 5, ((gW.x / 5) * EncoderTextureDrawer.X264_WIDTH) / 144, ((gW.x / 5) * 144) / 144);
                if (aVar.a) {
                    if (b()) {
                        c();
                    } else {
                        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.ui.food.d.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                d.this.nTH.b(d.this.m, d.this.n, d.this.o, d.this.p);
                            }
                        });
                    }
                } else if (b()) {
                    c();
                }
            } else {
                if (b()) {
                    this.j.setVisibility(0);
                    this.nPH.setVisibility(8);
                    if (this.nTv != null) {
                        this.nTv.setVisibility(8);
                    }
                } else {
                    this.j.setVisibility(8);
                    this.nPH.setVisibility(0);
                }
                this.e.setVisibility(8);
                if (aVar.b) {
                    Point gW2 = tv.chushou.zues.utils.a.gW(this.q);
                    if (com.kascend.chushou.a.a.dYk().a(listItem, this.nTH, gW2.x, (gW2.x * aVar.c) / 720, (gW2.x * aVar.d) / 720) == 0) {
                        int i2 = gW2.x;
                        ViewGroup.LayoutParams layoutParams2 = this.nTH.getLayoutParams();
                        layoutParams2.width = i2;
                        layoutParams2.height = (int) (i2 / 2.5d);
                        this.nTH.setLayoutParams(layoutParams2);
                    }
                }
                if (aVar.a) {
                    if (b()) {
                        c();
                    } else {
                        this.nPH.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.ui.food.d.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                d.this.nTH.b(d.this.m, d.this.n, d.this.o, d.this.p);
                            }
                        });
                    }
                }
            }
            this.nTH.setVisibility(0);
        }
    }
}
