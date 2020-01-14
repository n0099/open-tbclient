package com.kascend.chushou.widget.convenientbanner.a;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.kascend.chushou.widget.convenientbanner.ConvenientBanner;
import com.kascend.chushou.widget.convenientbanner.c.b;
import java.util.List;
/* loaded from: classes4.dex */
public class a<T> extends RecyclerView.Adapter<b<T>> {
    protected List<T> aaB;
    private boolean nhh;
    private final int nho;
    private com.kascend.chushou.widget.convenientbanner.c.a<T> nhp;
    private ConvenientBanner nhq;

    public a(com.kascend.chushou.widget.convenientbanner.c.a<T> aVar, List<T> list, boolean z, ConvenientBanner convenientBanner) {
        this.nhp = aVar;
        this.nho = aVar.getLayoutId();
        this.aaB = list;
        this.nhh = z;
        this.nhq = convenientBanner;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: E */
    public b<T> onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(this.nho, viewGroup, false);
        if (this.nhq != null) {
            inflate.setTag(this.nhq);
        }
        return this.nhp.dA(inflate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull b<T> bVar, int i, @NonNull List<Object> list) {
        if (list != null && list.size() > 0 && "wangmai".equals(String.valueOf(list.get(0)))) {
            bVar.i(this.aaB.get(i % this.aaB.size()), 0);
            return;
        }
        onBindViewHolder(bVar, i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(b<T> bVar, int i) {
        bVar.bF(this.aaB.get(i % this.aaB.size()));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.aaB == null || this.aaB.size() == 0) {
            return 0;
        }
        if (this.nhh) {
            return Integer.MAX_VALUE;
        }
        return this.aaB.size();
    }

    public int bbl() {
        return this.aaB.size();
    }
}
