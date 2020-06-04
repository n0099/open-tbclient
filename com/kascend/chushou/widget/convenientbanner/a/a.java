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
/* loaded from: classes5.dex */
public class a<T> extends RecyclerView.Adapter<b<T>> {
    protected List<T> aAp;
    private boolean nbH;
    private final int nbO;
    private com.kascend.chushou.widget.convenientbanner.c.a<T> nbP;
    private ConvenientBanner nbQ;

    public a(com.kascend.chushou.widget.convenientbanner.c.a<T> aVar, List<T> list, boolean z, ConvenientBanner convenientBanner) {
        this.nbP = aVar;
        this.nbO = aVar.getLayoutId();
        this.aAp = list;
        this.nbH = z;
        this.nbQ = convenientBanner;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: E */
    public b<T> onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(this.nbO, viewGroup, false);
        if (this.nbQ != null) {
            inflate.setTag(this.nbQ);
        }
        return this.nbP.du(inflate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull b<T> bVar, int i, @NonNull List<Object> list) {
        if (list != null && list.size() > 0 && "wangmai".equals(String.valueOf(list.get(0)))) {
            bVar.i(this.aAp.get(i % this.aAp.size()), 0);
            return;
        }
        onBindViewHolder(bVar, i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(b<T> bVar, int i) {
        bVar.bv(this.aAp.get(i % this.aAp.size()));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.aAp == null || this.aAp.size() == 0) {
            return 0;
        }
        return this.nbH ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : this.aAp.size();
    }

    public int brX() {
        return this.aAp.size();
    }
}
