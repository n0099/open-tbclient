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
    protected List<T> aKx;
    private boolean okj;
    private final int okq;
    private com.kascend.chushou.widget.convenientbanner.c.a<T> okr;
    private ConvenientBanner oks;

    public a(com.kascend.chushou.widget.convenientbanner.c.a<T> aVar, List<T> list, boolean z, ConvenientBanner convenientBanner) {
        this.okr = aVar;
        this.okq = aVar.getLayoutId();
        this.aKx = list;
        this.okj = z;
        this.oks = convenientBanner;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: N */
    public b<T> onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(this.okq, viewGroup, false);
        if (this.oks != null) {
            inflate.setTag(this.oks);
        }
        return this.okr.dM(inflate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull b<T> bVar, int i, @NonNull List<Object> list) {
        if (list != null && list.size() > 0 && "wangmai".equals(String.valueOf(list.get(0)))) {
            bVar.i(this.aKx.get(i % this.aKx.size()), 0);
            return;
        }
        onBindViewHolder(bVar, i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(b<T> bVar, int i) {
        bVar.bA(this.aKx.get(i % this.aKx.size()));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.aKx == null || this.aKx.size() == 0) {
            return 0;
        }
        return this.okj ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : this.aKx.size();
    }

    public int bIt() {
        return this.aKx.size();
    }
}
