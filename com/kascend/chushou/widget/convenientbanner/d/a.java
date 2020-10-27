package com.kascend.chushou.widget.convenientbanner.d;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class a implements c {
    private int[] pqQ;
    private c pra;
    private ArrayList<ImageView> prq;

    public a(ArrayList<ImageView> arrayList, int[] iArr) {
        this.prq = arrayList;
        this.pqQ = iArr;
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (this.pra != null) {
            this.pra.onScrollStateChanged(recyclerView, i);
        }
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        if (this.pra != null) {
            this.pra.onScrolled(recyclerView, i, i2);
        }
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onPageSelected(int i) {
        for (int i2 = 0; i2 < this.prq.size(); i2++) {
            this.prq.get(i).setImageResource(this.pqQ[1]);
            if (i != i2) {
                this.prq.get(i2).setImageResource(this.pqQ[0]);
            }
        }
        if (this.pra != null) {
            this.pra.onPageSelected(i);
        }
    }

    public void a(c cVar) {
        this.pra = cVar;
    }
}
