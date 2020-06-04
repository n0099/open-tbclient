package com.kascend.chushou.widget.convenientbanner.d;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class a implements c {
    private int[] nbA;
    private c nbK;
    private ArrayList<ImageView> nca;

    public a(ArrayList<ImageView> arrayList, int[] iArr) {
        this.nca = arrayList;
        this.nbA = iArr;
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (this.nbK != null) {
            this.nbK.onScrollStateChanged(recyclerView, i);
        }
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        if (this.nbK != null) {
            this.nbK.onScrolled(recyclerView, i, i2);
        }
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onPageSelected(int i) {
        for (int i2 = 0; i2 < this.nca.size(); i2++) {
            this.nca.get(i).setImageResource(this.nbA[1]);
            if (i != i2) {
                this.nca.get(i2).setImageResource(this.nbA[0]);
            }
        }
        if (this.nbK != null) {
            this.nbK.onPageSelected(i);
        }
    }

    public void a(c cVar) {
        this.nbK = cVar;
    }
}
