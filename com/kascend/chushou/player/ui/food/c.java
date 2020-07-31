package com.kascend.chushou.player.ui.food;

import android.view.View;
import com.kascend.chushou.constants.ListItem;
import com.kascend.chushou.player.ui.food.k;
/* loaded from: classes6.dex */
public class c extends f {
    @Override // com.kascend.chushou.player.ui.food.f, com.kascend.chushou.player.ui.food.k
    void a(ListItem listItem, k.a aVar) {
        a(listItem, this.j);
        this.e.setVisibility(8);
        if (b()) {
            this.nvR.setVisibility(8);
            this.j.setVisibility(0);
            c();
            return;
        }
        this.nvR.setVisibility(0);
        this.j.setVisibility(8);
        this.nvR.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.ui.food.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.nzR.b(c.this.m, c.this.n, c.this.o, c.this.p);
            }
        });
    }
}
