package com.kascend.chushou.widget.convenientbanner.d;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class a implements c {
    private ArrayList<ImageView> oaO;
    private int[] oao;
    private c oay;

    public a(ArrayList<ImageView> arrayList, int[] iArr) {
        this.oaO = arrayList;
        this.oao = iArr;
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (this.oay != null) {
            this.oay.onScrollStateChanged(recyclerView, i);
        }
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        if (this.oay != null) {
            this.oay.onScrolled(recyclerView, i, i2);
        }
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onPageSelected(int i) {
        for (int i2 = 0; i2 < this.oaO.size(); i2++) {
            this.oaO.get(i).setImageResource(this.oao[1]);
            if (i != i2) {
                this.oaO.get(i2).setImageResource(this.oao[0]);
            }
        }
        if (this.oay != null) {
            this.oay.onPageSelected(i);
        }
    }

    public void a(c cVar) {
        this.oay = cVar;
    }
}
