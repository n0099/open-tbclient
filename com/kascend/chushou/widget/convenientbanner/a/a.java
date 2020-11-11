package com.kascend.chushou.widget.convenientbanner.a;

import android.support.annotation.NonNull;
import android.support.v7.widget.ActivityChooserView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.kascend.chushou.widget.convenientbanner.ConvenientBanner;
import com.kascend.chushou.widget.convenientbanner.c.b;
import java.util.List;
/* loaded from: classes6.dex */
public class a<T> extends RecyclerView.Adapter<b<T>> {
    protected List<T> bSh;
    private com.kascend.chushou.widget.convenientbanner.c.a<T> pAA;
    private ConvenientBanner pAB;
    private boolean pAs;
    private final int pAz;

    public a(com.kascend.chushou.widget.convenientbanner.c.a<T> aVar, List<T> list, boolean z, ConvenientBanner convenientBanner) {
        this.pAA = aVar;
        this.pAz = aVar.getLayoutId();
        this.bSh = list;
        this.pAs = z;
        this.pAB = convenientBanner;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: Q */
    public b<T> onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(this.pAz, viewGroup, false);
        if (this.pAB != null) {
            inflate.setTag(this.pAB);
        }
        return this.pAA.eg(inflate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull b<T> bVar, int i, @NonNull List<Object> list) {
        if (list != null && list.size() > 0 && "wangmai".equals(String.valueOf(list.get(0)))) {
            bVar.i(this.bSh.get(i % this.bSh.size()), 0);
            return;
        }
        onBindViewHolder(bVar, i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(b<T> bVar, int i) {
        bVar.bH(this.bSh.get(i % this.bSh.size()));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.bSh == null || this.bSh.size() == 0) {
            return 0;
        }
        return this.pAs ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : this.bSh.size();
    }

    public int bQf() {
        return this.bSh.size();
    }
}
