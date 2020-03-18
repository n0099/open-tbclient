package com.kascend.chushou.widget.convenientbanner.d;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class a implements c {
    private int[] njE;
    private c njO;
    private ArrayList<ImageView> nke;

    public a(ArrayList<ImageView> arrayList, int[] iArr) {
        this.nke = arrayList;
        this.njE = iArr;
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (this.njO != null) {
            this.njO.onScrollStateChanged(recyclerView, i);
        }
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        if (this.njO != null) {
            this.njO.onScrolled(recyclerView, i, i2);
        }
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onPageSelected(int i) {
        for (int i2 = 0; i2 < this.nke.size(); i2++) {
            this.nke.get(i).setImageResource(this.njE[1]);
            if (i != i2) {
                this.nke.get(i2).setImageResource(this.njE[0]);
            }
        }
        if (this.njO != null) {
            this.njO.onPageSelected(i);
        }
    }

    public void a(c cVar) {
        this.njO = cVar;
    }
}
