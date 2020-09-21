package com.kascend.chushou.widget.convenientbanner.d;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class a implements c {
    private ArrayList<ImageView> okC;
    private int[] okc;
    private c okm;

    public a(ArrayList<ImageView> arrayList, int[] iArr) {
        this.okC = arrayList;
        this.okc = iArr;
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (this.okm != null) {
            this.okm.onScrollStateChanged(recyclerView, i);
        }
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        if (this.okm != null) {
            this.okm.onScrolled(recyclerView, i, i2);
        }
    }

    @Override // com.kascend.chushou.widget.convenientbanner.d.c
    public void onPageSelected(int i) {
        for (int i2 = 0; i2 < this.okC.size(); i2++) {
            this.okC.get(i).setImageResource(this.okc[1]);
            if (i != i2) {
                this.okC.get(i2).setImageResource(this.okc[0]);
            }
        }
        if (this.okm != null) {
            this.okm.onPageSelected(i);
        }
    }

    public void a(c cVar) {
        this.okm = cVar;
    }
}
